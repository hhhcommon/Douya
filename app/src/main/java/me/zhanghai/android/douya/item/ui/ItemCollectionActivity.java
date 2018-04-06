/*
 * Copyright (c) 2016 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.douya.item.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.zhanghai.android.douya.R;
import me.zhanghai.android.douya.network.api.info.frodo.CollectableItem;
import me.zhanghai.android.douya.util.FragmentUtils;

public class ItemCollectionActivity extends AppCompatActivity {

    private static final String KEY_PREFIX = ItemCollectionActivity.class.getName() + '.';

    private static final String EXTRA_COLLECTABLE_ITEM = KEY_PREFIX + "collectable_item";

    public static Intent makeIntent(CollectableItem collectableItem, Context context) {
        return new Intent(context, ItemCollectionActivity.class)
                .putExtra(EXTRA_COLLECTABLE_ITEM, collectableItem);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        CollectableItem collection = intent.getParcelableExtra(EXTRA_COLLECTABLE_ITEM);

        switch (collection.getType()) {
            case APP:
                break;
            case BOOK:
                break;
            case EVENT:
                break;
            case GAME:
                break;
            case MOVIE:
            case TV:
                setTheme(R.style.Theme_Douya_Movie_DialogWhenLarge);
                break;
            case MUSIC:
                break;
        }

        super.onCreate(savedInstanceState);

        // Calls ensureSubDecor().
        findViewById(android.R.id.content);

        if (savedInstanceState == null) {
            FragmentUtils.add(ItemCollectionFragment.newInstance(collection), this,
                    android.R.id.content);
        }
    }
}
