@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION")

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

typealias FormSubmitHandler<FormData, P, ErrorType> = (values: FormData, dispatch: Dispatch<Any>, props: P) -> dynamic

typealias GetFormState = (state: Any) -> FormStateMap

external interface SubmitHandler<FormData, P, ErrorType> {
    @nativeInvoke
    operator fun invoke(submit: FormSubmitHandler<FormData, P, ErrorType>, props: InjectedFormProps<FormData, P, ErrorType> = definedExternally, valid: Boolean = definedExternally, asyncValidate: Any = definedExternally, fields: Array<String> = definedExternally): Any
    @nativeInvoke
    operator fun invoke(event: SyntheticEvent<Any>)
}

external interface ValidateCallback<FormData, P, ErrorType> {
    var values: FormData
    var nextProps: P /* P & InjectedFormProps<FormData, P, ErrorType> */
    var props: P /* P & InjectedFormProps<FormData, P, ErrorType> */
    var initialRender: Boolean
    var lastFieldValidatorKeys: Array<String>
    var fieldValidatorKeys: Array<String>
    var structure: Any
}

external interface AsyncValidateCallback<FormData, ErrorType> {
    var asyncErrors: Any?
        get() = definedExternally
        set(value) = definedExternally
    var initialized: Boolean
    var trigger: String /* "blur" | "submit" */
    var blurredField: String?
        get() = definedExternally
        set(value) = definedExternally
    var pristine: Boolean
    var syncValidationPasses: Boolean
}

external interface InjectedArrayProps {
    fun insert(field: String, index: Number, value: Any)
    fun move(field: String, from: Number, to: Number)
    fun pop(field: String)
    fun push(field: String, value: Any)
    fun remove(field: String, index: Number)
    fun removeAll(field: String)
    fun shift(field: String)
    fun splice(field: String, index: Number, removeNum: Number, value: Any)
    fun swap(field: String, indexA: Number, indexB: Number)
    fun unshift(field: String, value: Any)
}

external interface RegisteredField {
    var count: Number
    var name: String
    var type: String /* "Field" | "FieldArray" */
}

external interface `T$0` {
    @nativeGetter
    operator fun get(name: String): RegisteredField?
    @nativeSetter
    operator fun set(name: String, value: RegisteredField)
}

external interface InjectedFormProps<FormData, P, ErrorType> {
    var anyTouched: Boolean
    var array: InjectedArrayProps
    fun asyncValidate()
    var asyncValidating: dynamic /* String | Boolean */
        get() = definedExternally
        set(value) = definedExternally
    fun autofill(field: String, value: Any)
    fun blur(field: String, value: Any)
    fun change(field: String, value: Any)
    fun clearAsyncError(field: String)
    fun destroy()
    var dirty: Boolean
    var error: ErrorType
    var form: String
    var handleSubmit: SubmitHandler<FormData, P, ErrorType>
    fun initialize(data: Partial<FormData>)
    var initialized: Boolean
    var initialValues: Any
    var invalid: Boolean
    var pristine: Boolean
    fun reset()
    var submitFailed: Boolean
    var submitSucceeded: Boolean
    var submitting: Boolean
    fun touch(vararg field: String)
    fun untouch(vararg field: String)
    var valid: Boolean
    var warning: Any
    var registeredFields: `T$0`
}

external interface ConfigProps<FormData, P, ErrorType> {
    var form: String
    var asyncBlurFields: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var asyncChangeFields: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    val asyncValidate: ((values: FormData, dispatch: Dispatch<Any>, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */, blurredField: String) -> Promise<Any>)?
        get() = definedExternally
    var destroyOnUnmount: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var enableReinitialize: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var forceUnregisterOnUnmount: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var getFormState: GetFormState?
        get() = definedExternally
        set(value) = definedExternally
    var immutableProps: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var initialValues: Any?
        get() = definedExternally
        set(value) = definedExternally
    var keepDirtyOnReinitialize: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var updateUnregisteredFields: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    val onChange: ((values: Partial<FormData>, dispatch: Dispatch<Any>, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */, previousValues: Partial<FormData>) -> Unit)?
        get() = definedExternally
    var onSubmit: dynamic /* FormSubmitHandler<FormData, P /* P & InjectedFormProps<FormData, P, ErrorType> */, ErrorType> | SubmitHandler<FormData, P /* P & InjectedFormProps<FormData, P, ErrorType> */, ErrorType> */
        get() = definedExternally
        set(value) = definedExternally
    val onSubmitFail: ((errors: FormErrors<FormData, ErrorType>?, dispatch: Dispatch<Any>, submitError: Any, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */) -> Unit)?
        get() = definedExternally
    val onSubmitSuccess: ((result: Any, dispatch: Dispatch<Any>, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */) -> Unit)?
        get() = definedExternally
    var propNamespace: String?
        get() = definedExternally
        set(value) = definedExternally
    var pure: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    val shouldValidate: ((params: ValidateCallback<FormData, P, ErrorType>) -> Boolean)?
        get() = definedExternally
    val shouldError: ((params: ValidateCallback<FormData, P, ErrorType>) -> Boolean)?
        get() = definedExternally
    val shouldWarn: ((params: ValidateCallback<FormData, P, ErrorType>) -> Boolean)?
        get() = definedExternally
    val shouldAsyncValidate: ((params: AsyncValidateCallback<FormData, ErrorType>) -> Boolean)?
        get() = definedExternally
    var submitAsSideEffect: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var touchOnBlur: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var touchOnChange: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var persistentSubmitErrors: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    val validate: ((values: FormData, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */) -> FormErrors<FormData, ErrorType>)?
        get() = definedExternally
    val warn: ((values: FormData, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */) -> FormWarnings<FormData>)?
        get() = definedExternally
}

external interface ConfigPropsPartial<FormData, P, ErrorType> {
    var form: String?
        get() = definedExternally
        set(value) = definedExternally
    var asyncBlurFields: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var asyncChangeFields: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var asyncValidate: ((values: FormData, dispatch: Dispatch<Any>, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */, blurredField: String) -> Promise<Any>)?
        get() = definedExternally
        set(value) = definedExternally
    var destroyOnUnmount: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var enableReinitialize: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var forceUnregisterOnUnmount: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var getFormState: GetFormState?
        get() = definedExternally
        set(value) = definedExternally
    var immutableProps: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var initialValues: Any?
        get() = definedExternally
        set(value) = definedExternally
    var keepDirtyOnReinitialize: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var updateUnregisteredFields: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var onChange: ((values: Partial<FormData>, dispatch: Dispatch<Any>, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */, previousValues: Partial<FormData>) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onSubmit: dynamic /* FormSubmitHandler<FormData, P /* P & InjectedFormProps<FormData, P, ErrorType> */, ErrorType> | SubmitHandler<FormData, P /* P & InjectedFormProps<FormData, P, ErrorType> */, ErrorType> */
        get() = definedExternally
        set(value) = definedExternally
    var onSubmitFail: ((errors: FormErrors<FormData, ErrorType>?, dispatch: Dispatch<Any>, submitError: Any, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onSubmitSuccess: ((result: Any, dispatch: Dispatch<Any>, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var propNamespace: String?
        get() = definedExternally
        set(value) = definedExternally
    var pure: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var shouldValidate: ((params: ValidateCallback<FormData, P, ErrorType>) -> Boolean)?
        get() = definedExternally
        set(value) = definedExternally
    var shouldError: ((params: ValidateCallback<FormData, P, ErrorType>) -> Boolean)?
        get() = definedExternally
        set(value) = definedExternally
    var shouldWarn: ((params: ValidateCallback<FormData, P, ErrorType>) -> Boolean)?
        get() = definedExternally
        set(value) = definedExternally
    var shouldAsyncValidate: ((params: AsyncValidateCallback<FormData, ErrorType>) -> Boolean)?
        get() = definedExternally
        set(value) = definedExternally
    var submitAsSideEffect: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var touchOnBlur: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var touchOnChange: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var persistentSubmitErrors: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var validate: ((values: FormData, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */) -> FormErrors<FormData, ErrorType>)?
        get() = definedExternally
        set(value) = definedExternally
    var warn: ((values: FormData, props: P /* P & InjectedFormProps<FormData, P, ErrorType> */) -> FormWarnings<FormData>)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface FormInstance<FormData, P, ErrorType> : Component<P> {
    var dirty: Boolean
    var invalid: Boolean
    var pristine: Boolean
    var registeredFields: Array<RegisteredFieldState>
    fun reset()
    fun resetSection(vararg sections: String)
    fun submit(): Promise<Any>
    var valid: Boolean
    var values: Any
    var wrappedInstance: Any
}

external interface DecoratedComponentClass<FormData, P, ErrorType>

typealias FormDecorator<FormData, P, Config, ErrorType> = (component: ComponentType<P /* P & InjectedFormProps<FormData, P, ErrorType> */>) -> DecoratedComponentClass<FormData, P /* P & Config */, ErrorType>

external fun <FormData, P, ErrorType> reduxForm(config: ConfigProps<FormData, P, ErrorType>): FormDecorator<FormData, P, ConfigPropsPartial<FormData, P, ErrorType>, ErrorType>

external fun <FormData, P, ErrorType> reduxForm(config: ConfigPropsPartial<FormData, P, ErrorType>): FormDecorator<FormData, P, ConfigProps<FormData, P, ErrorType>, ErrorType>