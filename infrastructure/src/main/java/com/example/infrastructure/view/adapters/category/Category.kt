package com.example.infrastructure.view.adapters.category

import com.example.infrastructure.view.widgets.CategoryView

class Category(
    var id: String?,
    var title: String? = null,
    var description: String? = null,
    var imageUrl: String? = null,
    var numberSupplier : String? = null,
    var isNew : Boolean =false,
    var color: Int,
    var listener : CategoryView.OnClickCategoryView,
    var height : Int
)