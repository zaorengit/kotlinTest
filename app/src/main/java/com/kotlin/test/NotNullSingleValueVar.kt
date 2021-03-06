package com.kotlin.test

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Administrator on 2017/6/27.
 */
 public  class  NotNullSingleValueVar<T>() :ReadWriteProperty<Any?,T>{
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>)
            : T {
        return value ?: throw IllegalStateException("$value " + "not initialized")
    }
        override fun setValue(thisRef: Any?, property: KProperty<*>,
                              value: T) {
            this.value = if (this.value == null) value
            else throw IllegalStateException("$value already initialized")
        }


}