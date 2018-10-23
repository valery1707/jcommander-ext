package name.valery1707;

import com.github.marschall.memoryfilesystem.MemoryFileSystemBuilder;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.EnumSet;
import java.util.Set;

import static java.nio.file.Files.*;
import static java.nio.file.attribute.PosixFilePermission.*;
import static java.nio.file.attribute.PosixFilePermissions.asFileAttribute;

public class AccessTest {
	public static void main(String[] args) throws IOException {
		try (FileSystem fileSystem = MemoryFileSystemBuilder.newLinux().build()) {
			Path root = createDirectories(fileSystem.getPath(".")).toAbsolutePath();
			Set<PosixFilePermission> permissions;

			permissions = EnumSet.noneOf(PosixFilePermission.class);
			Path none = createFile(root.resolve("permissions.none"), asFileAttribute(permissions));
			System.out.println("exists(none) = " + exists(none));
			System.out.println("isDirectory(none) = " + isDirectory(none));
			System.out.println("isRegularFile(none) = " + isRegularFile(none));
			System.out.println("isSymbolicLink(none) = " + isSymbolicLink(none));

			permissions = EnumSet.noneOf(PosixFilePermission.class);
			permissions.add(OWNER_READ);
			Path read = createFile(root.resolve("permissions.read"), asFileAttribute(permissions));
			System.out.println("exists(read) = " + exists(read));
			System.out.println("isDirectory(read) = " + isDirectory(read));
			System.out.println("isRegularFile(read) = " + isRegularFile(read));
			System.out.println("isSymbolicLink(read) = " + isSymbolicLink(read));

			permissions = EnumSet.noneOf(PosixFilePermission.class);
			permissions.add(OWNER_WRITE);
			Path write = createFile(root.resolve("permissions.write"), asFileAttribute(permissions));
			System.out.println("exists(write) = " + exists(write));
			System.out.println("isDirectory(write) = " + isDirectory(write));
			System.out.println("isRegularFile(write) = " + isRegularFile(write));
			System.out.println("isSymbolicLink(write) = " + isSymbolicLink(write));

			permissions = EnumSet.noneOf(PosixFilePermission.class);
			permissions.add(OWNER_EXECUTE);
			Path exec = createFile(root.resolve("permissions.exec"), asFileAttribute(permissions));
			System.out.println("exists(exec) = " + exists(exec));
			System.out.println("isDirectory(exec) = " + isDirectory(exec));
			System.out.println("isRegularFile(exec) = " + isRegularFile(exec));
			System.out.println("isSymbolicLink(exec) = " + isSymbolicLink(exec));
		}
	}
}
