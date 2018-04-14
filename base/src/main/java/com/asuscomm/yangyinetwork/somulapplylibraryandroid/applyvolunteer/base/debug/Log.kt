package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.debug

/**
 * Created by jaeyeong on 13/04/2018.
 */

private const val REAL_METHOD_IDX = 2


object Log {
    fun d(message: String) {
        android.util.Log.d(getFileName(), "${getPrefix()} $message")
    }

    private fun getFileName(): String {
        val stackTrace = Throwable().stackTrace
        val method = stackTrace[REAL_METHOD_IDX]

        val fileName = method.fileName

        return fileName.substring(0, fileName.lastIndexOf("."))
    }

    private fun getPrefix(): String {
        val sb = StringBuilder(1024)

        try {
            val stackTrace = Throwable().stackTrace
            val realMethod = stackTrace[REAL_METHOD_IDX]

            sb.append("[")
            sb.append(realMethod.fileName)
            sb.append(":")
            sb.append(realMethod.lineNumber)
            sb.append(":")
            sb.append(realMethod.methodName)
            sb.append("()] ")
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return sb.toString()
    }
}
