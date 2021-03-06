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

external interface _BaseFieldArrayProps<P, FieldValue> {
    var name: String
    var component: Any
    var validate: dynamic /* Validator | Array<Validator> */
        get() = definedExternally
        set(value) = definedExternally
    var warn: dynamic /* Validator | Array<Validator> */
        get() = definedExternally
        set(value) = definedExternally
    var withRef: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var rerenderOnEveryChange: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$2`<P> {
    var props: P
}

external interface GenericFieldArray<FieldValue, P> : Component<dynamic /* P | `T$2`<P> */> {
    var name: String
    var valid: Boolean
    fun getRenderedComponent(): Component<WrappedFieldArrayProps<FieldValue> /* WrappedFieldArrayProps<FieldValue> & P */>
}

external open class FieldArray<P, FieldValue> : Component<dynamic /* P | `T$2`<P> */>, GenericFieldArray<FieldValue, P> {
    override var name: String
    override var valid: Boolean
    override fun getRenderedComponent(): Component<WrappedFieldArrayProps<FieldValue> /* WrappedFieldArrayProps<FieldValue> & P */>
}

external interface WrappedFieldArrayProps<FieldValue> {
    var fields: FieldArrayFieldsProps<FieldValue>
    var meta: FieldArrayMetaProps
}

typealias FieldIterate<FieldValue, R> = (name: String, index: Number, fields: FieldArrayFieldsProps<FieldValue>) -> R

external interface FieldArrayFieldsProps<FieldValue> {
    fun forEach(callback: FieldIterate<FieldValue>)
    fun get(index: Number): FieldValue
    fun getAll(): Array<FieldValue>
    fun removeAll()
    fun insert(index: Number, value: FieldValue)
    var name: String
    var length: Number
    fun <R> map(callback: FieldIterate<FieldValue, R>): Array<R>
    fun pop(): FieldValue
    fun push(value: FieldValue)
    fun remove(index: Number)
    fun shift(): FieldValue
    fun swap(indexA: Number, indexB: Number)
    fun move(from: Number, to: Number)
    fun unshift(value: FieldValue)
}

external interface FieldArrayMetaProps {
    var dirty: Boolean
    var error: Any?
        get() = definedExternally
        set(value) = definedExternally
    var form: String
    var invalid: Boolean
    var pristine: Boolean
    var submitFailed: Boolean
    var submitting: Boolean
    var valid: Boolean
    var warning: Any?
        get() = definedExternally
        set(value) = definedExternally
}