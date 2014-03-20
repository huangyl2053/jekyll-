/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受領委任事業者のデータアクセスクラスのインタフェースです。
 *
 * @author N3317 塚田 萌
 */
public interface IJuryoininJigyoshaDac extends
        IDeletable<DbT3077JuryoininKeiyakuJigyoshaEntity>,
        IInsertable<DbT3077JuryoininKeiyakuJigyoshaEntity> {

    /**
     * 契約番号に対応する１つの受領委任事業者エンティティを取得します。
     *
     * @param 契約番号 契約番号
     * @return 受領委任事業者エンティティ
     */
    @Transaction
    DbT3077JuryoininKeiyakuJigyoshaEntity select(KeiyakuNo 契約番号);

    /**
     * 検索条件に該当する受領委任事業者エンティティを複数取得します。
     *
     * @param criteria 検索条件
     * @return 受領委任事業者エンティティリスト
     */
    //TODO n3317 塚田萌　本実装の時に対応する。期限　本実装完了まで
    @Transaction
    List<DbT3077JuryoininKeiyakuJigyoshaEntity> select(ITrueFalseCriteria criteria);
}
