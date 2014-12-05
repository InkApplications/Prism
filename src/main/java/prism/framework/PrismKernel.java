/*
 * Copyright (c) 2014 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package prism.framework;

import android.app.Activity;

/**
 * The core loader for the framework.
 *
 * This class is intended to provide the API for executing lifecycle actions to
 * all of the listeners in the framework.
 *
 * Currently this is only bootstrapping Injections.
 *
 * @author Maxwell Vandervelde (Max@MaxVandervelde.com)
 */
@SuppressWarnings("unused")
final public class PrismKernel
{
    /** Service used when injecting dependencies into objects. */
    final private DependencyInjector dependencyInjector;

    /** Service used when injecting the content view for an activity. */
    final private ActivityLayoutInjector layoutInjector;

    /**
     * Whether or not to set the content view to activities during injections
     * based on the Layout attribute.
     *
     * @see #injectContentView
     */
    private boolean injectContentView = true;

    /**
     * Create an application with the specified object graphs.
     */
    public PrismKernel(GraphContext graph)
    {
        this.dependencyInjector = new DependencyInjector(graph);
        this.layoutInjector = new ActivityLayoutInjector();
    }

    /**
     * Start the framework and injections for an Activity.
     */
    public void bootstrap(Activity activity)
    {
        if (this.injectContentView) {
            this.layoutInjector.injectContentView(activity);
        }
        this.dependencyInjector.inject(activity);
    }

    /**
     * Start the framework and injections for a Fragment.
     */
    public void bootstrap(android.app.Fragment fragment)
    {
        this.dependencyInjector.inject(fragment);
    }

    /**
     * Start the framework and injections for a Support Fragment.
     */
    public void bootstrap(android.support.v4.app.Fragment fragment)
    {
        this.dependencyInjector.inject(fragment);
    }

    /**
     * Start the framework and injections for an arbitrary Object.
     */
    public void bootstrap(Object object)
    {
        this.dependencyInjector.inject(object);
    }

    /**
     * Start the framework and injections for an arbitrary Object, with an
     * Activity as a context.
     */
    public void bootstrap(Object object, Activity activity)
    {
        this.dependencyInjector.inject(object, activity);
    }

    /**
     * Changes Whether or not the framework will set thecontent view on
     * activities during their bootstrap phase.
     */
    public void shouldInjectContentView(boolean runInjections)
    {
        this.injectContentView = runInjections;
    }
}
