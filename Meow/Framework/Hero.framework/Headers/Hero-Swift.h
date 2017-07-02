// Generated by Apple Swift version 3.1 (swiftlang-802.0.53 clang-802.0.42)
#pragma clang diagnostic push

#if defined(__has_include) && __has_include(<swift/objc-prologue.h>)
# include <swift/objc-prologue.h>
#endif

#pragma clang diagnostic ignored "-Wauto-import"
#include <objc/NSObject.h>
#include <stdint.h>
#include <stddef.h>
#include <stdbool.h>

#if !defined(SWIFT_TYPEDEFS)
# define SWIFT_TYPEDEFS 1
# if defined(__has_include) && __has_include(<uchar.h>)
#  include <uchar.h>
# elif !defined(__cplusplus) || __cplusplus < 201103L
typedef uint_least16_t char16_t;
typedef uint_least32_t char32_t;
# endif
typedef float swift_float2  __attribute__((__ext_vector_type__(2)));
typedef float swift_float3  __attribute__((__ext_vector_type__(3)));
typedef float swift_float4  __attribute__((__ext_vector_type__(4)));
typedef double swift_double2  __attribute__((__ext_vector_type__(2)));
typedef double swift_double3  __attribute__((__ext_vector_type__(3)));
typedef double swift_double4  __attribute__((__ext_vector_type__(4)));
typedef int swift_int2  __attribute__((__ext_vector_type__(2)));
typedef int swift_int3  __attribute__((__ext_vector_type__(3)));
typedef int swift_int4  __attribute__((__ext_vector_type__(4)));
typedef unsigned int swift_uint2  __attribute__((__ext_vector_type__(2)));
typedef unsigned int swift_uint3  __attribute__((__ext_vector_type__(3)));
typedef unsigned int swift_uint4  __attribute__((__ext_vector_type__(4)));
#endif

#if !defined(SWIFT_PASTE)
# define SWIFT_PASTE_HELPER(x, y) x##y
# define SWIFT_PASTE(x, y) SWIFT_PASTE_HELPER(x, y)
#endif
#if !defined(SWIFT_METATYPE)
# define SWIFT_METATYPE(X) Class
#endif
#if !defined(SWIFT_CLASS_PROPERTY)
# if __has_feature(objc_class_property)
#  define SWIFT_CLASS_PROPERTY(...) __VA_ARGS__
# else
#  define SWIFT_CLASS_PROPERTY(...)
# endif
#endif

#if defined(__has_attribute) && __has_attribute(objc_runtime_name)
# define SWIFT_RUNTIME_NAME(X) __attribute__((objc_runtime_name(X)))
#else
# define SWIFT_RUNTIME_NAME(X)
#endif
#if defined(__has_attribute) && __has_attribute(swift_name)
# define SWIFT_COMPILE_NAME(X) __attribute__((swift_name(X)))
#else
# define SWIFT_COMPILE_NAME(X)
#endif
#if defined(__has_attribute) && __has_attribute(objc_method_family)
# define SWIFT_METHOD_FAMILY(X) __attribute__((objc_method_family(X)))
#else
# define SWIFT_METHOD_FAMILY(X)
#endif
#if defined(__has_attribute) && __has_attribute(noescape)
# define SWIFT_NOESCAPE __attribute__((noescape))
#else
# define SWIFT_NOESCAPE
#endif
#if defined(__has_attribute) && __has_attribute(warn_unused_result)
# define SWIFT_WARN_UNUSED_RESULT __attribute__((warn_unused_result))
#else
# define SWIFT_WARN_UNUSED_RESULT
#endif
#if !defined(SWIFT_CLASS_EXTRA)
# define SWIFT_CLASS_EXTRA
#endif
#if !defined(SWIFT_PROTOCOL_EXTRA)
# define SWIFT_PROTOCOL_EXTRA
#endif
#if !defined(SWIFT_ENUM_EXTRA)
# define SWIFT_ENUM_EXTRA
#endif
#if !defined(SWIFT_CLASS)
# if defined(__has_attribute) && __has_attribute(objc_subclassing_restricted)
#  define SWIFT_CLASS(SWIFT_NAME) SWIFT_RUNTIME_NAME(SWIFT_NAME) __attribute__((objc_subclassing_restricted)) SWIFT_CLASS_EXTRA
#  define SWIFT_CLASS_NAMED(SWIFT_NAME) __attribute__((objc_subclassing_restricted)) SWIFT_COMPILE_NAME(SWIFT_NAME) SWIFT_CLASS_EXTRA
# else
#  define SWIFT_CLASS(SWIFT_NAME) SWIFT_RUNTIME_NAME(SWIFT_NAME) SWIFT_CLASS_EXTRA
#  define SWIFT_CLASS_NAMED(SWIFT_NAME) SWIFT_COMPILE_NAME(SWIFT_NAME) SWIFT_CLASS_EXTRA
# endif
#endif

#if !defined(SWIFT_PROTOCOL)
# define SWIFT_PROTOCOL(SWIFT_NAME) SWIFT_RUNTIME_NAME(SWIFT_NAME) SWIFT_PROTOCOL_EXTRA
# define SWIFT_PROTOCOL_NAMED(SWIFT_NAME) SWIFT_COMPILE_NAME(SWIFT_NAME) SWIFT_PROTOCOL_EXTRA
#endif

#if !defined(SWIFT_EXTENSION)
# define SWIFT_EXTENSION(M) SWIFT_PASTE(M##_Swift_, __LINE__)
#endif

#if !defined(OBJC_DESIGNATED_INITIALIZER)
# if defined(__has_attribute) && __has_attribute(objc_designated_initializer)
#  define OBJC_DESIGNATED_INITIALIZER __attribute__((objc_designated_initializer))
# else
#  define OBJC_DESIGNATED_INITIALIZER
# endif
#endif
#if !defined(SWIFT_ENUM)
# define SWIFT_ENUM(_type, _name) enum _name : _type _name; enum SWIFT_ENUM_EXTRA _name : _type
# if defined(__has_feature) && __has_feature(generalized_swift_name)
#  define SWIFT_ENUM_NAMED(_type, _name, SWIFT_NAME) enum _name : _type _name SWIFT_COMPILE_NAME(SWIFT_NAME); enum SWIFT_COMPILE_NAME(SWIFT_NAME) SWIFT_ENUM_EXTRA _name : _type
# else
#  define SWIFT_ENUM_NAMED(_type, _name, SWIFT_NAME) SWIFT_ENUM(_type, _name)
# endif
#endif
#if !defined(SWIFT_UNAVAILABLE)
# define SWIFT_UNAVAILABLE __attribute__((unavailable))
#endif
#if !defined(SWIFT_UNAVAILABLE_MSG)
# define SWIFT_UNAVAILABLE_MSG(msg) __attribute__((unavailable(msg)))
#endif
#if !defined(SWIFT_AVAILABILITY)
# define SWIFT_AVAILABILITY(plat, ...) __attribute__((availability(plat, __VA_ARGS__)))
#endif
#if !defined(SWIFT_DEPRECATED)
# define SWIFT_DEPRECATED __attribute__((deprecated))
#endif
#if !defined(SWIFT_DEPRECATED_MSG)
# define SWIFT_DEPRECATED_MSG(...) __attribute__((deprecated(__VA_ARGS__)))
#endif
#if defined(__has_feature) && __has_feature(modules)
@import QuartzCore;
@import ObjectiveC;
@import Foundation;
@import UIKit;
#endif

#pragma clang diagnostic ignored "-Wproperty-attribute-mismatch"
#pragma clang diagnostic ignored "-Wduplicate-method-arg"

@interface CALayer (SWIFT_EXTENSION(Hero))
@end


@interface CAMediaTimingFunction (SWIFT_EXTENSION(Hero))
@end

@class UIView;

/// Base class for managing a Hero transition
SWIFT_CLASS("_TtC4Hero18HeroBaseController")
@interface HeroBaseController : NSObject
/// whether or not we are handling transition interactively
@property (nonatomic, readonly) BOOL interactive;
/// progress of the current transition. 0 if no transition is happening
@property (nonatomic, readonly) double progress;
/// whether or not we are doing a transition
@property (nonatomic, readonly) BOOL transitioning;
/// container we created to hold all animating views, will be a subview of the
/// transitionContainer when transitioning
@property (nonatomic, readonly, strong) UIView * _Null_unspecified container;
/// max duration needed by the default animator and plugins
@property (nonatomic, readonly) NSTimeInterval totalDuration;
- (nonnull instancetype)init SWIFT_UNAVAILABLE;
@end

@class UIViewController;

/// <h3>The singleton class/object for controlling interactive transitions.</h3>
/// \code
///   Hero.shared
///
/// \endcode<h4>Use the following methods for controlling the interactive transition:</h4>
/// \code
///   func update(progress:Double)
///   func end()
///   func cancel()
///   func apply(modifiers:[HeroModifier], to view:UIView)
///
/// \endcode
SWIFT_CLASS("_TtC4Hero4Hero")
@interface Hero : HeroBaseController
/// Shared singleton object for controlling the transition
SWIFT_CLASS_PROPERTY(@property (nonatomic, class, readonly, strong) Hero * _Nonnull shared;)
+ (Hero * _Nonnull)shared SWIFT_WARN_UNUSED_RESULT;
/// destination view controller
@property (nonatomic, readonly, strong) UIViewController * _Nullable toViewController;
/// source view controller
@property (nonatomic, readonly, strong) UIViewController * _Nullable fromViewController;
/// whether or not we are presenting the destination view controller
@property (nonatomic, readonly) BOOL presenting;
/// progress of the current transition. 0 if no transition is happening
@property (nonatomic) double progress;
@end


@interface Hero (SWIFT_EXTENSION(Hero))
@end


@interface Hero (SWIFT_EXTENSION(Hero))
@end

@protocol UIViewControllerContextTransitioning;

@interface Hero (SWIFT_EXTENSION(Hero)) <UIViewControllerAnimatedTransitioning>
- (void)animateTransition:(id <UIViewControllerContextTransitioning> _Nonnull)context;
- (NSTimeInterval)transitionDuration:(id <UIViewControllerContextTransitioning> _Nullable)transitionContext SWIFT_WARN_UNUSED_RESULT;
@end

@class UINavigationController;
@protocol UIViewControllerInteractiveTransitioning;

@interface Hero (SWIFT_EXTENSION(Hero)) <UINavigationControllerDelegate>
- (id <UIViewControllerAnimatedTransitioning> _Nullable)navigationController:(UINavigationController * _Nonnull)navigationController animationControllerForOperation:(UINavigationControllerOperation)operation fromViewController:(UIViewController * _Nonnull)fromVC toViewController:(UIViewController * _Nonnull)toVC SWIFT_WARN_UNUSED_RESULT;
- (id <UIViewControllerInteractiveTransitioning> _Nullable)navigationController:(UINavigationController * _Nonnull)navigationController interactionControllerForAnimationController:(id <UIViewControllerAnimatedTransitioning> _Nonnull)animationController SWIFT_WARN_UNUSED_RESULT;
@end

@class UITabBarController;

@interface Hero (SWIFT_EXTENSION(Hero)) <UITabBarControllerDelegate>
- (id <UIViewControllerInteractiveTransitioning> _Nullable)tabBarController:(UITabBarController * _Nonnull)tabBarController interactionControllerForAnimationController:(id <UIViewControllerAnimatedTransitioning> _Nonnull)animationController SWIFT_WARN_UNUSED_RESULT;
- (id <UIViewControllerAnimatedTransitioning> _Nullable)tabBarController:(UITabBarController * _Nonnull)tabBarController animationControllerForTransitionFromViewController:(UIViewController * _Nonnull)fromVC toViewController:(UIViewController * _Nonnull)toVC SWIFT_WARN_UNUSED_RESULT;
@end


@interface Hero (SWIFT_EXTENSION(Hero))
@end

@class UIColor;

@interface Hero (SWIFT_EXTENSION(Hero))
/// Turn off built-in animation for next transition
- (void)disableDefaultAnimationForNextTransition;
/// Set the container color for next transition
/// \param color container color
///
- (void)setContainerColorForNextTransition:(UIColor * _Nullable)color;
@end


@interface Hero (SWIFT_EXTENSION(Hero)) <UIViewControllerInteractiveTransitioning>
@property (nonatomic, readonly) BOOL wantsInteractiveStart;
- (void)startInteractiveTransition:(id <UIViewControllerContextTransitioning> _Nonnull)transitionContext;
@end


@interface Hero (SWIFT_EXTENSION(Hero)) <UIViewControllerTransitioningDelegate>
- (id <UIViewControllerAnimatedTransitioning> _Nullable)animationControllerForPresentedController:(UIViewController * _Nonnull)presented presentingController:(UIViewController * _Nonnull)presenting sourceController:(UIViewController * _Nonnull)source SWIFT_WARN_UNUSED_RESULT;
- (id <UIViewControllerAnimatedTransitioning> _Nullable)animationControllerForDismissedController:(UIViewController * _Nonnull)dismissed SWIFT_WARN_UNUSED_RESULT;
- (id <UIViewControllerInteractiveTransitioning> _Nullable)interactionControllerForDismissal:(id <UIViewControllerAnimatedTransitioning> _Nonnull)animator SWIFT_WARN_UNUSED_RESULT;
- (id <UIViewControllerInteractiveTransitioning> _Nullable)interactionControllerForPresentation:(id <UIViewControllerAnimatedTransitioning> _Nonnull)animator SWIFT_WARN_UNUSED_RESULT;
@end



@interface HeroBaseController (SWIFT_EXTENSION(Hero))
@end


@interface HeroBaseController (SWIFT_EXTENSION(Hero))
@end


@interface HeroBaseController (SWIFT_EXTENSION(Hero))
@end


@interface HeroBaseController (SWIFT_EXTENSION(Hero))
/// Update the progress for the interactive transition.
/// <ul>
///   <li>
///     Parameters:
///   </li>
///   <li>
///     progress: the current progress, must be between 0…1
///   </li>
/// </ul>
- (void)updateWithProgress:(double)progress;
/// Finish the interactive transition.
/// Will stop the interactive transition and animate from the
/// current state to the <em>end</em> state
- (void)endWithAnimate:(BOOL)animate;
/// Cancel the interactive transition.
/// Will stop the interactive transition and animate from the
/// current state to the <em>begining</em> state
- (void)cancelWithAnimate:(BOOL)animate;
@end


@interface HeroBaseController (SWIFT_EXTENSION(Hero))
@end


SWIFT_CLASS("_TtC4Hero10HeroPlugin")
@interface HeroPlugin : NSObject
/// Determines whether or not to receive <code>seekTo</code> callback on every frame.
/// Default is false.
/// When <em>requirePerFrameCallback</em> is <em>false</em>, the plugin needs to start its own animations inside <code>animate</code> & <code>resume</code>
/// The <code>seekTo</code> method is only being called during an interactive transition.
/// When <em>requirePerFrameCallback</em> is <em>true</em>, the plugin will receive <code>seekTo</code> callback on every animation frame. Hence it is possible for the plugin to do per-frame animations without implementing <code>animate</code> & <code>resume</code>
@property (nonatomic) BOOL requirePerFrameCallback;
- (nonnull instancetype)init OBJC_DESIGNATED_INITIALIZER;
/// Called before any animation.
/// Override this method when you want to preprocess modifiers for views
/// To check a view’s modifiers:
/// \code
/// context[view]
/// context[view, "modifierName"]
///
/// \endcodeTo set a view’s modifiers:
/// \code
/// context[view] = [("modifier1", ["parameter1"]), ("modifier2", [])]
/// context[view, "modifier1"] = ["parameter1", "parameter2"]
///
/// \endcode\param context object holding all parsed and changed modifiers,
///
/// \param fromViews A flattened list of all views from source ViewController
///
/// \param toViews A flattened list of all views from destination ViewController
///
- (void)processFromViews:(NSArray<UIView *> * _Nonnull)fromViews toViews:(NSArray<UIView *> * _Nonnull)toViews;
/// \param context object holding all parsed and changed modifiers,
///
/// \param view the view to check whether or not the plugin can handle the animation
///
/// \param appearing true if the view is appearing(i.e. a view in destination ViewController)
/// If return true, Hero won’t animate and won’t let any other plugins animate this view.
/// The view will also be hidden automatically during the animation.
///
///
/// returns:
/// return true if the plugin can handle animating the view.
- (BOOL)canAnimateWithView:(UIView * _Nonnull)view appearing:(BOOL)appearing SWIFT_WARN_UNUSED_RESULT;
/// Perform the animation.
/// Note: views in <code>fromViews</code> & <code>toViews</code> are hidden already. Unhide then if you need to take snapshots.
/// \param context object holding all parsed and changed modifiers,
///
/// \param fromViews A flattened list of all views from source ViewController (filtered by <code>canAnimate</code>)
///
/// \param toViews A flattened list of all views from destination ViewController (filtered by <code>canAnimate</code>)
///
///
/// returns:
/// The duration needed to complete the animation
- (NSTimeInterval)animateFromViews:(NSArray<UIView *> * _Nonnull)fromViews toViews:(NSArray<UIView *> * _Nonnull)toViews SWIFT_WARN_UNUSED_RESULT;
/// Called when all animations are completed.
/// Should perform cleanup and release any reference
- (void)clean;
/// For supporting interactive animation only.
/// This method is called when an interactive animation is in place
/// The plugin should pause the animation, and seek to the given progress
/// \param timePassed time of the animation to seek to.
///
- (void)seekToTimePassed:(NSTimeInterval)timePassed;
/// For supporting interactive animation only.
/// This method is called when an interactive animation is ended
/// The plugin should resume the animation.
/// <ul>
///   <li>
///     Parameters:
///   </li>
///   <li>
///     timePassed: will be the same value since last <code>seekTo</code>
///   </li>
///   <li>
///     reverse: a boolean value indicating whether or not the animation should reverse
///   </li>
/// </ul>
- (NSTimeInterval)resumeWithTimePassed:(NSTimeInterval)timePassed reverse:(BOOL)reverse SWIFT_WARN_UNUSED_RESULT;
@end


SWIFT_CLASS("_TtC4Hero15HeroDebugPlugin")
@interface HeroDebugPlugin : HeroPlugin
SWIFT_CLASS_PROPERTY(@property (nonatomic, class) BOOL showOnTop;)
+ (BOOL)showOnTop SWIFT_WARN_UNUSED_RESULT;
+ (void)setShowOnTop:(BOOL)value;
- (NSTimeInterval)animateFromViews:(NSArray<UIView *> * _Nonnull)fromViews toViews:(NSArray<UIView *> * _Nonnull)toViews SWIFT_WARN_UNUSED_RESULT;
- (NSTimeInterval)resumeWithTimePassed:(NSTimeInterval)timePassed reverse:(BOOL)reverse SWIFT_WARN_UNUSED_RESULT;
- (void)clean;
- (nonnull instancetype)init OBJC_DESIGNATED_INITIALIZER;
@end


@interface HeroDebugPlugin (SWIFT_EXTENSION(Hero))
- (void)onDone;
- (void)onProcessSliderChangedWithProgress:(float)progress;
@end


SWIFT_CLASS("_TtC4Hero25HeroIndependentController")
@interface HeroIndependentController : HeroBaseController
- (nonnull instancetype)init OBJC_DESIGNATED_INITIALIZER;
- (void)transitionWithRootView:(UIView * _Nonnull)rootView fromViews:(NSArray<UIView *> * _Nonnull)fromViews toViews:(NSArray<UIView *> * _Nonnull)toViews completion:(void (^ _Nullable)(BOOL))completion;
@end



@interface HeroPlugin (SWIFT_EXTENSION(Hero))
SWIFT_CLASS_PROPERTY(@property (nonatomic, class) BOOL isEnabled;)
+ (BOOL)isEnabled SWIFT_WARN_UNUSED_RESULT;
+ (void)setIsEnabled:(BOOL)newValue;
+ (void)enable;
+ (void)disable;
@end


SWIFT_PROTOCOL("_TtP4Hero26HeroViewControllerDelegate_")
@protocol HeroViewControllerDelegate
@optional
- (void)heroWillStartAnimatingFromViewController:(UIViewController * _Nonnull)viewController;
- (void)heroDidEndAnimatingFromViewController:(UIViewController * _Nonnull)viewController;
- (void)heroDidCancelAnimatingFromViewController:(UIViewController * _Nonnull)viewController;
- (void)heroWillStartTransition;
- (void)heroDidEndTransition;
- (void)heroDidCancelTransition;
- (void)heroWillStartAnimatingToViewController:(UIViewController * _Nonnull)viewController;
- (void)heroDidEndAnimatingToViewController:(UIViewController * _Nonnull)viewController;
- (void)heroDidCancelAnimatingToViewController:(UIViewController * _Nonnull)viewController;
@end


@interface NSObject (SWIFT_EXTENSION(Hero))
@end


@interface UIColor (SWIFT_EXTENSION(Hero))
@end


@interface UIImage (SWIFT_EXTENSION(Hero))
@end


@interface UINavigationController (SWIFT_EXTENSION(Hero))
@property (nonatomic, copy) NSString * _Nullable heroNavigationAnimationTypeString;
@end


@interface UITabBarController (SWIFT_EXTENSION(Hero))
@property (nonatomic, copy) NSString * _Nullable heroTabBarAnimationTypeString;
@end


@interface UIView (SWIFT_EXTENSION(Hero))
@end


@interface UIView (SWIFT_EXTENSION(Hero))
/// <em>heroID</em> is the identifier for the view. When doing a transition between two view controllers,
/// Hero will search through all the subviews for both view controllers and matches views with the same <em>heroID</em>.
/// Whenever a pair is discovered,
/// Hero will automatically transit the views from source state to the destination state.
@property (nonatomic, copy) NSString * _Nullable heroID;
/// <em>heroModifierString</em> provides another way to set <em>heroModifiers</em>. It can be assigned through storyboard.
@property (nonatomic, copy) NSString * _Nullable heroModifierString;
@end


@interface UIViewController (SWIFT_EXTENSION(Hero))
- (IBAction)ht_dismiss:(UIView * _Nonnull)sender;
- (void)heroReplaceViewControllerWith:(UIViewController * _Nonnull)next;
/// Dismiss the current view controller with animation. Will perform a navigationController.popViewController
/// if the current view controller is contained inside a navigationController
- (IBAction)hero_dismissViewController;
/// Unwind to the root view controller using Hero
- (IBAction)hero_unwindToRootViewController;
/// Unwind to a specific view controller using Hero
- (void)hero_unwindToViewController:(UIViewController * _Nonnull)toViewController;
/// Unwind to a view controller that responds to the given selector using Hero
- (void)hero_unwindToViewControllerWithSelector:(SEL _Nonnull)withSelector;
/// Unwind to a view controller with given class using Hero
- (void)hero_unwindToViewControllerWithClass:(Class _Nonnull)withClass;
/// Unwind to a view controller that the matchBlock returns true on.
- (void)hero_unwindToViewControllerWithMatchBlock:(SWIFT_NOESCAPE BOOL (^ _Nonnull)(UIViewController * _Nonnull))withMatchBlock;
/// Replace the current view controller with another VC on the navigation/modal stack.
- (void)hero_replaceViewControllerWith:(UIViewController * _Nonnull)next;
@end


@interface UIViewController (SWIFT_EXTENSION(Hero))
@property (nonatomic, copy) NSString * _Nullable heroModalAnimationTypeString;
@property (nonatomic) BOOL isHeroEnabled;
@end

#pragma clang diagnostic pop