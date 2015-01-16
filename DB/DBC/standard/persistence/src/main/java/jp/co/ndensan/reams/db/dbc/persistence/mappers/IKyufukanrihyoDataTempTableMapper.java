/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.mappers;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufukanrihyoDataTempTableEntity;

/**
 * 給付管理票取込一時データエンティティのマッパーインタフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IKyufukanrihyoDataTempTableMapper {

    /**
     * 一時データを取得します。
     *
     * @param param パラメーター
     * @return DbTKyufukanrihyoDataTempTableEntity
     */
    List<DbTKyufukanrihyoDataTempTableEntity> getTempData(Map<String, Object> param);
}
