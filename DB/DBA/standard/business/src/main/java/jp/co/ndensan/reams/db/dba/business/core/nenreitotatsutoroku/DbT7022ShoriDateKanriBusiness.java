/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.nenreitotatsutoroku;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 前回開始終了日取得Businessクラスです。
 *
 * @reamsid_L DBA-0570-010 xuyannan
 */
public class DbT7022ShoriDateKanriBusiness {

    private final DbT7022ShoriDateKanriEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity DbT7022ShoriDateKanriEntity
     */
    public DbT7022ShoriDateKanriBusiness(DbT7022ShoriDateKanriEntity entity) {
        this.entity = entity;
    }

    /**
     * 対象開始年月日のgetメソッドです。
     *
     * @return 対象開始年月日
     */
    public FlexibleDate getTaishoKaishiYMD() {
        return entity.getTaishoKaishiYMD();
    }

    /**
     * 対象終了年月日のgetメソッドです。
     *
     * @return 対象終了年月日
     */
    public FlexibleDate getTaishoShuryoYMD() {
        return entity.getTaishoShuryoYMD();
    }
}
