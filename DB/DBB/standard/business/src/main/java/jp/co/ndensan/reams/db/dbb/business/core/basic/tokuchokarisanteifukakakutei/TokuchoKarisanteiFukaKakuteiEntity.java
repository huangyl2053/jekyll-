/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifukakakutei;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 特徴仮算定賦課確定の戻るEntity。
 */
public class TokuchoKarisanteiFukaKakuteiEntity {

    private DbT7022ShoriDateKanriEntity DateKanriEntity;

    /**
     * コンストラクタです。
     */
    public TokuchoKarisanteiFukaKakuteiEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param DateKanriEntity DbT7022ShoriDateKanriEntity
     */
    public TokuchoKarisanteiFukaKakuteiEntity(DbT7022ShoriDateKanriEntity DateKanriEntity) {
        this.DateKanriEntity = DateKanriEntity;
    }

    /**
     * 基準日時を取得します。
     *
     * @return 基準日時
     */
    public FlexibleDate getKijunYMD() {
        return DateKanriEntity.getKijunYMD();
    }
}
