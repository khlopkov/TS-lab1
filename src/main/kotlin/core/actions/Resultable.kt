package kotlin.core.actions

interface Resultable<TResult> {
  fun result(): TResult
}

abstract class Result<TResult> {
  abstract fun should(predicate: TResult -> bool) 
}