/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc170020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170020.TorikomiDataTempEntity;

/**
 * 介護サービス内容テーブルの登録処理のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3400-030 liuyl
 */
public interface IKaigoSabisuNaiyoMasterKoshinMapper {

    /**
     * 「介護サービス内容」テーブル　該当行を削除する。
     */
    void delete介護サービス内容();

    /**
     * 介護サービス内容を取得します。
     *
     * @return List<TorikomiDataTempEntity>
     */
    List<TorikomiDataTempEntity> select介護サービス内容();
}
