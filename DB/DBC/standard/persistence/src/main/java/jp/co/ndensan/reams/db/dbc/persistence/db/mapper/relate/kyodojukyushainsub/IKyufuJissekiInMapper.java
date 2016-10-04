/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyodojukyushainsub;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.KyoudouShoriRelateEntity;

/**
 * バッチ設計書_DBCMNF2002-5Cx_共同処理用受給者情報更新結果情報取込共通処理（CSVファイル取込）Mapperクラスです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
public interface IKyufuJissekiInMapper {

    /**
     * 三つ一時TBLを結合結果の取得処理です。
     *
     * @return List<KyoudouShoriRelateEntity>
     */
    List<KyoudouShoriRelateEntity> get三つ一時TBLを結合結果();
}
