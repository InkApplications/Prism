/*
 * Copyright (c) 2014 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package prism.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines which module a target class should be a part of when running
 * module injections.
 *
 * @deprecated as of 2.1 specify the module scope in the `@Injected` annotation
 *             instead of using this flag.
 * @author Maxwell Vandervelde (Max@MaxVandervelde.com)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Deprecated
public @interface ModuleScope
{
    /**
     * The Module class to include in the injection scope.
     */
    Class value();
}
