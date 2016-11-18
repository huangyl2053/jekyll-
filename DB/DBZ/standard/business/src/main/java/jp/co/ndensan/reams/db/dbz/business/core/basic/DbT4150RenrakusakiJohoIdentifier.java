/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 介護連絡先情報(DbT4150Renrakusaki)の識別しです。
 * 
 * @author n3213
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class DbT4150RenrakusakiJohoIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 連番 連番
     */
    public DbT4150RenrakusakiJohoIdentifier(ShinseishoKanriNo 申請書管理番号,
            int 連番) {
        this.申請書管理番号 = 申請書管理番号;
        this.連番 = 連番;

    }
}
