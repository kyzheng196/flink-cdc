/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.cdc.common.sink;

import org.apache.flink.api.connector.sink2.Sink;
import org.apache.flink.cdc.common.annotation.PublicEvolving;
import org.apache.flink.cdc.common.event.Event;

/**
 * {@code FlinkSinkProvider} is used to provide a Flink {@link Sink} for writing events to external
 * systems.
 */
@PublicEvolving
public interface FlinkSinkProvider extends EventSinkProvider {

    /** Get the {@link Sink} for writing events to external systems. */
    Sink<Event> getSink();

    /** Create a {@link FlinkSinkProvider} from a {@link Sink}. */
    static FlinkSinkProvider of(Sink<Event> sink) {
        return () -> sink;
    }
}
