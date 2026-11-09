//import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Main {
    public static void main(String[] args) {
        // Print LWJGL version to confirm bindings work
        System.out.println("LWJGL loaded successfully.");

        // Set an error callback (optional but helpful)
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Create a window (tiny one)
        long window = glfwCreateWindow(400, 300, "LWJGL Test", NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Make OpenGL context current (required even if we draw nothing)
        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        System.out.println("GLFW + OpenGL initialized correctly!");

        // Loop until the window is closed
        while (!glfwWindowShouldClose(window)) {
            glfwPollEvents();
            glfwSwapBuffers(window);
        }

        // Cleanup
        glfwDestroyWindow(window);
        glfwTerminate();
        System.out.println("Success! LWJGL is configured correctly.");
    }
}