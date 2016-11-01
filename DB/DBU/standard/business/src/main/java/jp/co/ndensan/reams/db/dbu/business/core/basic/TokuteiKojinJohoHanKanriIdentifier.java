/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報版管理の識別子です。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TokuteiKojinJohoHanKanriIdentifier implements Serializable {

    private final RString 特定個人情報名コード;
    private final RString データセット番号;
    private final RString 版番号;

    /**
     * コンストラクタです。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param データセット番号 データセット番号
     * @param 版番号 版番号
     */
    public TokuteiKojinJohoHanKanriIdentifier(RString 特定個人情報名コード,
            RString データセット番号,
            RString 版番号) {
        this.特定個人情報名コード = 特定個人情報名コード;
        this.データセット番号 = データセット番号;
        this.版番号 = 版番号;
    }
}
