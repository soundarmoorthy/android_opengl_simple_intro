package com.example.soundararajan.testopengl;

import java.nio.ByteBuffer;
        import java.nio.ByteOrder;
        import java.nio.FloatBuffer;

        import javax.microedition.khronos.opengles.GL10;

public class Line {
    private FloatBuffer vertexFloatBuffer; // Buffer for vertex-array

    private float[] vertices = { // Vertices for top and bottom
            -1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f
    };

    public Line() {

        ByteBuffer vertexByteBuffer = ByteBuffer.allocateDirect(vertices.length * 4);
        vertexByteBuffer.order(ByteOrder.nativeOrder());
        vertexFloatBuffer = vertexByteBuffer.asFloatBuffer();
        vertexFloatBuffer.put(vertices);
        vertexFloatBuffer.position(0);
    }

    public void draw(GL10 gl) {

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);

        // Point to our vertex buffer
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexFloatBuffer);

        // Draw the vertices as triangle strip
        gl.glDrawArrays(GL10.GL_LINES, 0, vertices.length / 2);

        //Disable the client state before leaving
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }
}

