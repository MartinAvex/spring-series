# spring-series
spring知识梳理

# lesson-002
需求：实现一个线程级别的bean作用域，同一个线程中同名的bean是同一个实例，不同的线程中的bean是不同的实例。
需求分析：要求bean在线程中是共享的，所以我们可以通过ThreadLocal来实现，ThreadLocal可以实现线程中数据的共享。
