/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.kaigoserviceshurui;

import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigoserviceshurui.KaigoServiceShuruiEntity;

/**
 * 介護サービス種類のマッパーインタフェースです。
 */
public interface IKaigoServiceShuruiMapper {

    /**
     * 介護サービス種類情報をキー検索で１件取得します。
     *
     * @param 介護サービス種類検索条件 介護サービス種類検索条件
     * @return KaigoServiceShuruiEntity
     */
    KaigoServiceShuruiEntity getKaigoServiceEntity(KaigoServiceShuruiMapperParameter 介護サービス種類検索条件);

}
