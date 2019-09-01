package com.example.tavorcohen.recycleviewexample

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RelativeLayout
import android.widget.ScrollView
import com.example.infrastructure.view.widgets.CategoryView




class MensorySecondSolutionActivity : AppCompatActivity() {

    lateinit var mScrollView : ScrollView
    lateinit var mContainer : RelativeLayout
    var listCategoryView = ArrayList<CategoryView>()


    var params1 = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )

    var params2 = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )

    var params3 = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )

    var params4 = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )

    var params5 = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensory_second_solution)

        initView()
        //initList()
        addCustomViews()
    }

    private fun addCustomViews(){


//        var margin= LayoutUtils.convertDpToPixel(this, 6)
//        params1.setMargins(margin, margin, margin, margin)
//        params2.setMargins(margin, margin, margin, margin)
//        params3.setMargins(margin, margin, margin, margin)
//        mContainer.addView(listCategoryView.get(0))
//
//
//        for (item in 0 until  (listCategoryView.size-1)) {
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//                listCategoryView.get(item).id = View.generateViewId()
//            }
//
//        }
//        for (item in 1 until  (listCategoryView.size)) {
//            var k=item-1
//           if(item % 2 ==1 && (item % 3!= 0) && (item % 5 !=0)){
//                params1.addRule(RelativeLayout.BELOW, listCategoryView.get(k).id)
//                mContainer.addView(listCategoryView.get(item),params1)
//            }
//
//            if(item % 2 == 0 && (item % 4 !=0) && (item % 2 !=1) && (item % 3!= 0) && (item % 5 !=0) ){
//                params2.addRule(RelativeLayout.BELOW, listCategoryView.get(k-1).id)
//                  params2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, listCategoryView.get(k).id)
//                  mContainer.addView(listCategoryView.get(item),params2)
//            }
//            if(item % 3== 0 ){
//                params3.addRule(RelativeLayout.BELOW, listCategoryView.get(k).id)
//                mContainer.addView(listCategoryView.get(item),params3)
//
//              params1 = RelativeLayout.LayoutParams(
//                    RelativeLayout.LayoutParams.WRAP_CONTENT,
//                    RelativeLayout.LayoutParams.WRAP_CONTENT
//                )
//
//               params2 = RelativeLayout.LayoutParams(
//                    RelativeLayout.LayoutParams.WRAP_CONTENT,
//                    RelativeLayout.LayoutParams.WRAP_CONTENT
//                )
//
//                params3 = RelativeLayout.LayoutParams(
//                    RelativeLayout.LayoutParams.WRAP_CONTENT,
//                    RelativeLayout.LayoutParams.WRAP_CONTENT
//                )
//
//                params1.setMargins(margin, margin, margin, margin)
//                params2.setMargins(margin, margin, margin, margin)
//                params3.setMargins(margin, margin, margin, margin)
//            }
//
//            if(item % 4 ==0 && (item % 8 !=0) ){
//                params4.addRule(RelativeLayout.BELOW, listCategoryView.get(k).id)
//                mContainer.addView(listCategoryView.get(item),params4)
//            }
//
//            if(item % 5 ==0){
//                var j =k
//                params5.addRule(RelativeLayout.BELOW, listCategoryView.get(k-1).id)
//                params5.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, listCategoryView.get(j).id)
//                mContainer.addView(listCategoryView.get(item),params5)
//
//                params4 = RelativeLayout.LayoutParams(
//                    RelativeLayout.LayoutParams.WRAP_CONTENT,
//                    RelativeLayout.LayoutParams.WRAP_CONTENT
//                )
//
//                params5 = RelativeLayout.LayoutParams(
//                    RelativeLayout.LayoutParams.WRAP_CONTENT,
//                    RelativeLayout.LayoutParams.WRAP_CONTENT
//                )
//
//                params4.setMargins(margin, margin, margin, margin)
//                params5.setMargins(margin, margin, margin, margin)
//            }
//
//        }
//


    }

    private fun initView(){
        mScrollView = findViewById(R.id.scrollViewCategory)
        mContainer = findViewById(R.id.categoryLayout)
    }
//
//    private fun initList(){
//       var categoryView : CategoryView = CategoryView(this)
//
//        var width1 = LayoutUtils.convertDpToPixel(this, 465)
//        val height1 = LayoutUtils.convertDpToPixel(this, 170)
//        categoryView.setWidthAndHeight(width1 ,height1)
//        categoryView.setTitle("Handyman")
//        categoryView.setNumberSupplier("2000")
//        categoryView.setDescription("Hello wormg dfgg dfgg rwt")
//        categoryView.changeColorOfCard(Color.BLUE)
//
//        listCategoryView.add(categoryView)
//
//        var width2 = LayoutUtils.convertDpToPixel(this, 225)
//        val height2 = LayoutUtils.convertDpToPixel(this, 190)
//        var categoryView1 : CategoryView = CategoryView(this)
//        categoryView1.setWidthAndHeight(width2,height2)
//        categoryView1.setTitle("Handyman")
//        categoryView1.setNumberSupplier("2000")
//        categoryView1.setDescription("Hello wormg dfgg dfgg rwt")
//        categoryView1.changeColorOfCard(Color.GREEN)
//
//        listCategoryView.add(categoryView1)
//
//
//        var categoryView2 : CategoryView = CategoryView(this)
//        categoryView2.setWidthAndHeight(width2,height2)
//        categoryView2.setTitle("Handyman")
//        categoryView2.setNumberSupplier("2000")
//        categoryView2.setDescription("Hello wormg dfgg dfgg rwt")
//        categoryView2.changeColorOfCard(Color.MAGENTA)
//
//
//        listCategoryView.add(categoryView2)
//
//
//
//
//        var categoryView3 : CategoryView = CategoryView(this)
//
//        categoryView3.setWidthAndHeight(width1 ,height1)
//        categoryView3.setTitle("Handyman")
//        categoryView3.setNumberSupplier("2000")
//        categoryView3.setDescription("Hello wormg dfgg dfgg rwt")
//        categoryView3.changeColorOfCard(Color.RED)
//
//        listCategoryView.add(categoryView3)
////
//////
//        var categoryView4 : CategoryView = CategoryView(this)
//        categoryView4.setWidthAndHeight(width2,height2)
//        categoryView4.setTitle("Handyman")
//        categoryView4.setNumberSupplier("2000")
//        categoryView4.setDescription("Hello wormg dfgg dfgg rwt")
//        categoryView4.changeColorOfCard(Color.YELLOW)
//
//        listCategoryView.add(categoryView4)
////
////
////
//        var categoryView5 : CategoryView = CategoryView(this)
//        categoryView5.setWidthAndHeight(width2,height2)
//        categoryView5.setTitle("Handyman")
//        categoryView5.setNumberSupplier("2000")
//        categoryView5.setDescription("Hello wormg dfgg dfgg rwt")
//        categoryView5.changeColorOfCard(Color.DKGRAY)
//
//        listCategoryView.add(categoryView5)
//
//
//
//
//
//
//        var categoryView6 : CategoryView = CategoryView(this)
//
//        categoryView6.setWidthAndHeight(width1 ,height1)
//        categoryView6.setTitle("Handyman")
//        categoryView6.setNumberSupplier("2000")
//        categoryView6.setDescription("Hello wormg dfgg dfgg rwt")
//        categoryView6.changeColorOfCard(Color.BLACK)
//
//        listCategoryView.add(categoryView6)
//////
////////
//        var categoryView7 : CategoryView = CategoryView(this)
//        categoryView7.setWidthAndHeight(width2,height2)
//        categoryView7.setTitle("Handyman")
//        categoryView7.setNumberSupplier("2000")
//        categoryView7.setDescription("Hello wormg dfgg dfgg rwt")
//        categoryView7.changeColorOfCard(Color.CYAN)
//
//        listCategoryView.add(categoryView7)
//////
//////
//////
//        var categoryView8 : CategoryView = CategoryView(this)
//        categoryView8.setWidthAndHeight(width2,height2)
//        categoryView8.setTitle("Handyman")
//        categoryView8.setNumberSupplier("2000")
//        categoryView8.setDescription("Hello wormg dfgg dfgg rwt")
//        categoryView8.changeColorOfCard(Color.BLACK)
//
//        listCategoryView.add(categoryView8)
//    }
}
