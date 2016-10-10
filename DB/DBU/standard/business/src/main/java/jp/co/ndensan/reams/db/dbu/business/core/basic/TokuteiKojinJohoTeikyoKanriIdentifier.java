/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報提供管理の識別子です。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TokuteiKojinJohoTeikyoKanriIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final RString データセットレコードキー;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param データセットレコードキー データセットレコードキー
     */
    public TokuteiKojinJohoTeikyoKanriIdentifier(HihokenshaNo 被保険者番号,
            RString データセットレコードキー) {
        this.被保険者番号 = 被保険者番号;
        this.データセットレコードキー = データセットレコードキー;
    }
}
