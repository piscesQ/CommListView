/*
 *  Copyright 2011 Yuri Kanivets
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package net.hyww.widget.wheel.adapter;

import android.content.Context;

import java.util.ArrayList;

/**
 * The simple Array wheel adapter
 *
 * @param <T> the element type
 */
public class ArrayWheelAdapter<T> extends AbstractWheelTextAdapter {

    // items
    private ArrayList<T> items;

    /**
     * Constructor
     *
     * @param context the current context
     * @param items   the items
     */
    public ArrayWheelAdapter(Context context, ArrayList<T> items) {
        super(context);

        // setEmptyItemResource(TEXT_VIEW_ITEM_RESOURCE);
        this.items = items;
    }

    public ArrayWheelAdapter(Context context, T[] items) {
        super(context);

        // setEmptyItemResource(TEXT_VIEW_ITEM_RESOURCE);
        initArr(items);
    }

    @Override
    public CharSequence getItemText(int index) {
        if (index >= 0 && index < items.size()) {
            T item = items.get(index);
            if (item instanceof CharSequence) {
                return (CharSequence) item;
            }
            return item.toString();
        }
        return null;
    }

    private void initArr(T[] list) {
        items = new ArrayList<T>();
        int count = list.length;
        for (int i = 0; i < count; i++) {
            items.add(list[i]);
        }
    }

    @Override
    public int getItemsCount() {
        return items.size();
    }
}
