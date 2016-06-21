package com.entc489.marcomendiola.minefielddstr;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class TheThread extends Thread {
    TheCanvas theCanvas;
    SurfaceHolder surfaceHolder;
    boolean running = false;
    Canvas canvas;
    TheThread thread;

    public TheThread(SurfaceHolder surfaceHolder, TheCanvas theCanvas) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.theCanvas = theCanvas;
    }

    public void setRunning(boolean run) {
        running = run;
    }

    public TheThread getThread() {
        return thread;
    }

    @Override
    public void run() {
        while (running) {
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    if (canvas != null) {
//                        this.theCanvas.updateAll();
                        this.theCanvas.draw(canvas);
                    }

                }
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }



}
