package name.valery1707.jcommander.validators.nio;

import com.github.marschall.memoryfilesystem.MemoryFileSystemBuilder;
import org.junit.rules.ExternalResource;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import static java.nio.file.Files.*;
import static java.nio.file.attribute.PosixFilePermission.*;
import static java.nio.file.attribute.PosixFilePermissions.asFileAttribute;

@SuppressWarnings("WeakerAccess")
public class VirtualFolder extends ExternalResource {
	private final AtomicLong temp = new AtomicLong();
	private final AtomicLong name = new AtomicLong();
	private final FileSystem fileSystem;

	public VirtualFolder() {
		try {
			fileSystem = MemoryFileSystemBuilder
				.newLinux()
//				.setUmask()
				.build();
		} catch (IOException e) {
			throw new IllegalStateException("Fail to build virtual FS", e);
		}
	}

	@Override
	protected void after() {
		try {
			fileSystem.close();
		} catch (IOException e) {
			throw new IllegalStateException("Fail to close virtual FS", e);
		}
		super.after();
	}

	public FileBuilder create() {
		return new FileBuilder(false, FileType.FILE, false, false, false);
	}

	private String temp() {
		return Long.toString(temp.incrementAndGet());
	}

	private String name() {
		return Long.toString(name.incrementAndGet());
	}

	public enum FileType {
		FILE, DIRECTORY, LINK;
	}

	@SuppressWarnings("WeakerAccess")
	public final class FileBuilder {
		private final boolean exists;
		private final FileType type;
		private final boolean readable;
		private final boolean writable;
		private final boolean executable;

		FileBuilder(boolean exists, FileType type, boolean readable, boolean writable, boolean executable) {
			this.exists = exists;
			this.type = type;
			this.readable = readable;
			this.writable = writable;
			this.executable = executable;
		}

		public FileBuilder exists(boolean exists) {
			return new FileBuilder(exists, type, readable, writable, executable);
		}

		public FileBuilder exists() {
			return exists(true);
		}

		public FileBuilder notExists() {
			return exists(false);
		}

		public FileBuilder type(FileType type) {
			return new FileBuilder(exists, type, readable, writable, executable);
		}

		public FileBuilder file() {
			return type(FileType.FILE);
		}

		public FileBuilder dir() {
			return type(FileType.DIRECTORY);
		}

		public FileBuilder link() {
			return type(FileType.LINK);
		}

		public FileBuilder readable(boolean readable) {
			return new FileBuilder(exists, type, readable, writable, executable);
		}

		public FileBuilder readable() {
			return readable(true);
		}

		public FileBuilder writable(boolean writable) {
			return new FileBuilder(exists, type, readable, writable, executable);
		}

		public FileBuilder writable() {
			return writable(true);
		}

		public FileBuilder executable(boolean executable) {
			return new FileBuilder(exists, type, readable, writable, executable);
		}

		public FileBuilder executable() {
			return executable(true);
		}

		public Path build() throws IOException {
			Path root = createDirectories(
				fileSystem.getPath(
					"tmp",
					temp()
				)
			)
				.toAbsolutePath();
			Path path = root.resolve(name());
			if (exists) {
				Set<PosixFilePermission> permissions = EnumSet.noneOf(PosixFilePermission.class);
				if (readable) {
					permissions.add(OWNER_READ);
				}
				if (writable) {
					permissions.add(OWNER_WRITE);
				}
				if (executable) {
					permissions.add(OWNER_EXECUTE);
				}
				switch (type) {
					case FILE:
						permissions.add(OWNER_READ);
						return createFile(path, asFileAttribute(permissions));
					case DIRECTORY:
						permissions.add(OWNER_READ);
						return createDirectory(path, asFileAttribute(permissions));
					case LINK:
						permissions.add(OWNER_READ);
						return createSymbolicLink(
							path,
							createFile(root.resolve(name())),
							asFileAttribute(permissions)
						);
					default:
						throw new IllegalArgumentException("Unknown type: " + type);
				}
			}
			return path;
		}
	}
}
