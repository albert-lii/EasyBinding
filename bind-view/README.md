# bind-view
DataBinding与ListView、GridView、RecyclerView的结合使用，使用更简单，代码更简洁。主要是针对它们的适配器做修改

## 主要类
- abslistview  
    - [EasyViewHolder（abslistview的viewholder基类][EasyViewHolder]  
    - [SimpleESBaseAdpter（针对于单种item的abslistview的适配器）][SimpleESBaseAdpter]
- recyclerview  
    - [EasyRecyclerAdapter（recyclerview的viewholder基类）][SimpleESBaseAdpter]  
    - [EasyRecyclerViewHolder（recyclerview的适配器基类）][EasyRecyclerViewHolder]  
    - [SimpleESRecyclerAdapter（针对于单种item的recyclerview的适配器）][SimpleESRecyclerAdapter]

## 使用方法
### 1、abslistview 
   - 单种item，直接使用SimpleESBaseAdpter代替BaseAdapter
   - 多种item，仍然使用BaseAdapter，使用EasyViewHolder作为ViewHolder
### 2、recyclerview 
   - 单种item，直接使用SimpleESRecyclerAdapter代替RecyclerView.Adapter 
   - 多种item，使用EasyRecyclerAdapter代替RecyclerView.Adapter，使用EasyRecyclerViewHolder作为ViewHolder
 
[EasyViewHolder]:https://github.com/albert-lii/EasyBinding/blob/master/easy-view/src/main/java/com/ly/easy/abslistview/EasyViewHolder.java
[SimpleESBaseAdpter]:https://github.com/albert-lii/EasyBinding/blob/master/easy-view/src/main/java/com/ly/easy/abslistview/SimpleESBaseAdpter.java
[EasyRecyclerAdapter]:https://github.com/albert-lii/EasyBinding/blob/master/easy-view/src/main/java/com/ly/easy/recyclerview/EasyRecyclerAdapter.java
[EasyRecyclerViewHolder]:https://github.com/albert-lii/EasyBinding/blob/master/easy-view/src/main/java/com/ly/easy/recyclerview/EasyRecyclerViewHolder.java
[SimpleESRecyclerAdapter]:https://github.com/albert-lii/EasyBinding/blob/master/easy-view/src/main/java/com/ly/easy/recyclerview/SimpleESRecyclerAdapter.java


