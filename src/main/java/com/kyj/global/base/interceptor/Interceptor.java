package com.kyj.global.base.interceptor;

import com.kyj.global.base.rq.Rq;

public interface Interceptor {
  boolean run(Rq rq);
}
