package mod.modid.api.addons;

import mod.modid.api.IAPI;

/**
 * Implement this on a class with the @ChiselsAndBitsAddon annotation, you can
 * do anything you want to get your support ready inside the callback, such as
 * store the object for later use, or replace a null implementation with a mod
 * implementation.
 *
 * Implementing object must be public, and have a public default constructor and
 * have the @ChiselsAndBitsAddon annotation, failure to do these steps will
 * result in an error.
 */
public interface IChiselsAndBitsAddon
{
	/**
	 * Called during init-phase for mod.
	 *
	 * @param api The api of mod.
	 */
	void commonSetup(final IAPI api);
}
