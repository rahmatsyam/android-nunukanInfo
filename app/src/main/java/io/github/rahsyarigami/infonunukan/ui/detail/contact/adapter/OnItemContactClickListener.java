package io.github.rahsyarigami.infonunukan.ui.detail.contact.adapter;

import io.github.rahsyarigami.infonunukan.data.model.ItemContact;

public interface OnItemContactClickListener {

    void onItemClick(ItemContact itemContact);

    void onItemCopy(ItemContact itemContact);
}
