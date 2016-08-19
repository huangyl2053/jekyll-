/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.koga;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.koga.KogakuShikyuShinseishoIkkatsuHakkoMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;

/**
 * 高額サービス費給付お知らせ通知書作成のハンドラクラスです。
 *
 * @reamsid_L DBC-4770-010 zhengshenlei
 */
public interface IKogakuShikyuShinseishoIkkatsuHakkoMapper {

    /**
     * サービス提供年月の取得のメソッドます
     *
     * @param param KogakuShikyuShinseishoIkkatsuHakkoMapperParameter
     * @return List<DbT3056KogakuShikyuShinseiEntity>
     */
    public List<DbT3056KogakuShikyuShinseiEntity> getServiceTeikyoByDbT3056(KogakuShikyuShinseishoIkkatsuHakkoMapperParameter param);

    /**
     * サービス提供年月の取得のメソッドます
     *
     * @param param KogakuShikyuShinseishoIkkatsuHakkoMapperParameter
     * @return List<DbT3110JigyoKogakuShikyuShinseiEntity>
     */
    public List<DbT3110JigyoKogakuShikyuShinseiEntity> getServiceTeikyoByDbT3110(KogakuShikyuShinseishoIkkatsuHakkoMapperParameter param);
}
