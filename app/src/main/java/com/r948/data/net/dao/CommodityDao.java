package com.r948.data.net.dao;


import com.r948.data.model.Commodity;

public interface CommodityDao {
    /**
     * 根据商品ID查询这个商品的所有信息
     * @param commodityId
     * @return 一个商品
     * @sql select * from commodity where commodity_id =: commodityId;
     */
    Commodity[] findCommodityById(int commodityId);
    /**
     * 根据店铺的id查询店铺的商品，返回值有多条
     * 业务场景：管理店铺信息
     * @param shopId
     * @return 多条商品
     * @sql select * from commodity where shop_id =: shopId;
     */
    Commodity [] findCommodityByShopId(int shopId);
    /**
     * 删除商品
     * 业务场景：店铺信息管理
     * @param commodityId
     * @return 受影响的行数
     * @sql delete from Commodity where commodity_id =: commodityId;
     */
    int deleteCommodityById(int commodityId);
    /**
     * 更新该商品的信息
     * 应用场景：商品信息管理
     * @param commodity
     * @param commodityId
     * @return 受影响的行数
     * @sql update commodity set
     * comm_name =: commodity.commName,shop_id =: commodity.shopId,
     * sort =:commodity.sort,price =: commodity.price,
     * comm_score =: commodity.commScore,sales_volume =: salesVolume,picture =: commodity.picture
     * where commodity_id =:commodity.commodityId;
     */
    int updateCommodity(Commodity commodity,int commodityId);
    /**
     *
     * 添加一个新商品
     * 应用场景：添加新商品
     * @param commodity
     * @return 受影响的行数
     * @sql insert into commodity (shop_id,comm_name,sort,price,comm_score,sales_volume,picture)
     * values(commodity.shopId,commodity.commName,commodity.sort,commodity.price,commodity.comm_score,commodity.sales_volume,commodity.picture);
     */
    int addCommodity(Commodity commodity);
}
