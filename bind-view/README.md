# bind-view
DataBinding与ListView、GridView、RecyclerView的结合使用，使用更简单，代码更简洁。主要是针对它们的适配器做修改

## 主要类
- abslistview  
    - [BindViewHolder（abslistview的viewholder基类][BindViewHolder]  
    - [SimpleBindBaseAdpter（针对于单种item的abslistview的适配器）][SimpleBindBaseAdpter]
- recyclerview  
    - [BindRecyclerAdapter（recyclerview的viewholder基类）][SimpleBindBaseAdpter]  
    - [BindRecyclerViewHolder（recyclerview的适配器基类）][BindRecyclerViewHolder]  
    - [SimpleBindRecyclerAdapter（针对于单种item的recyclerview的适配器）][SimpleBindRecyclerAdapter]

## 使用方法
### 1、abslistview 
   - 单种item，直接使用SimpleBindBaseAdpter代替BaseAdapter
   - 多种item，仍然使用BaseAdapter，使用BindViewHolder作为ViewHolder
### 2、recyclerview 
   - 单种item，直接使用SimpleESRecyclerAdapter代替RecyclerView.Adapter  
   - 多种item，使用BindRecyclerAdapter代替RecyclerView.Adapter，使用BindRecyclerViewHolder作为ViewHolder
 
[BindViewHolder]:https://github.com/albert-lii/BindBinding/blob/master/bind-view/src/main/java/com/ly/easy/abslistview/BindViewHolder.java
[SimpleBindBaseAdpter]:https://github.com/albert-lii/BindBinding/blob/master/bind-view/src/main/java/com/ly/easy/abslistview/SimpleESBaseAdpter.java
[BindRecyclerAdapter]:https://github.com/albert-lii/BindBinding/blob/master/bind-view/src/main/java/com/ly/easy/recyclerview/BindRecyclerAdapter.java
[BindRecyclerViewHolder]:https://github.com/albert-lii/BindBinding/blob/master/bind-view/src/main/java/com/ly/easy/recyclerview/BindRecyclerViewHolder.java
[SimpleBindRecyclerAdapter]:https://github.com/albert-lii/BindBinding/blob/master/bind-view/src/main/java/com/ly/easy/recyclerview/SimpleESRecyclerAdapter.java


