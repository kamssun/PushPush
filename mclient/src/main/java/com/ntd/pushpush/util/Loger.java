package com.ntd.pushpush.util;



import android.util.Log;



public  class Loger {
	private String tag = "0000";
	public static int logLevel = Log.VERBOSE;
	public static boolean isDebug = true;
	
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	private String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        
        if (sts == null) {
            return null;
        }
        
        
        for (StackTraceElement st:sts) {
        	/*
        	 * 过滤掉堆栈方法
        	 */
            if (st.isNativeMethod()) {
                continue;
            }
            /*
             * 过滤掉线程方法
             */
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            /*
             * 过滤掉该类方法
             */
            if (st.getClassName().equals(this.getClass().getName())) {
                continue;
            }

            return "["+Thread.currentThread().getId()+": "+st.getFileName()+":"+st.getLineNumber()+"]";
        }
        
        return null;
	}

	public void info(Object str) {
	    if (logLevel <= Log.INFO) {	        
	        String name = getFunctionName();
	        String ls=(name==null?str.toString():(name+" - "+str));
	        Log.i(tag, ls);
	    }
	}
	
	public void i(Object str) {
		if (isDebug) {
			info(str);
		}
	}
	
	public void verbose(Object str) {
        if (logLevel <= Log.VERBOSE) {
            String name = getFunctionName();
            String ls=(name==null?str.toString():(name+" - "+str));
            Log.v(tag, ls);    
        }
	}
	
	public void v(Object str) {
		if (isDebug) {
			verbose(str);
		}
    }
	
	public void warn(Object str) {
	    if (logLevel <= Log.WARN) {
            String name = getFunctionName();
            String ls=(name==null?str.toString():(name+" - "+str));
            Log.w(tag, ls);
	    }
	}
	
	public void w(Object str) {
		if (isDebug) {
			warn(str);
		}
    }
	
	public void error(Object str) {
        if (logLevel <= Log.ERROR) {            
            String name = getFunctionName();
            String ls=(name==null?str.toString():(name+" - "+str));
            Log.e(tag, ls);
        }
	}
	
	public void error(Exception ex) {
	    if (logLevel <= Log.ERROR) {
	        StringBuffer sb = new StringBuffer();
	        String name = getFunctionName();
	        StackTraceElement[] sts = ex.getStackTrace();

	        if (name != null) {
                sb.append(name+" - "+ex+"\r\n");
            } else {
                sb.append(ex+"\r\n");
            }
	        
	        if (sts != null && sts.length > 0) {
	            for (StackTraceElement st:sts) {
	                if (st != null) {
	                    sb.append("[ "+st.getFileName()+":"+st.getLineNumber()+" ]\r\n");
	                }
	            }
	        }
	        
	        Log.e(tag, sb.toString());
	    }
	}
	
    public void e(Object str) {
    	if (isDebug) {
    		error(str);
    	}
    }

    public void e(Exception ex) {
    	if (isDebug) {
    		error(ex);
    	}
    }
	
	public void debug(Object str) {
        if (logLevel <= Log.DEBUG) {
            String name = getFunctionName();
            String ls = (name == null?str.toString():(name+" - "+str));
            Log.d(tag, ls);
        }
	}
	
	public void d(Object str) {
		if (isDebug) {
			debug(str);
		}
    }
}