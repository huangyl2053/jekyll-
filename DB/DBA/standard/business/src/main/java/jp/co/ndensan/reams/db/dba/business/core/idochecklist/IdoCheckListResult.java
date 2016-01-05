/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.idochecklist;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 異動チェックリスト情報Businessクラスです。
 */
public class IdoCheckListResult {

    private final DbT7022ShoriDateKanriEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity DbT7022ShoriDateKanriEntity
     */
    public IdoCheckListResult(DbT7022ShoriDateKanriEntity entity) {
        this.entity = entity;
    }

    public FlexibleDate get対象開始年月日() {
        return entity.getTaishoKaishiYMD();
    }

    public FlexibleDate get対象終了年月日() {
        return entity.getTaishoShuryoYMD();
    }
}
