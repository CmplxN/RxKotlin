# Coroutine Job Cancellation
- Coroutine must be cooperative to be cancelled
    - periodically invoke suspend fun and catch Exception
    - explicitly check status (isActive)
- Cancellation by Timeout
    - withTimeout (Exception)
    - withTimeoutOrNull (Null)