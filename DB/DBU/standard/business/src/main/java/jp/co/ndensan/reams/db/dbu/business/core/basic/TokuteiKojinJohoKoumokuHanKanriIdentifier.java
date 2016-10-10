/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報項目版管理の識別子です。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TokuteiKojinJohoKoumokuHanKanriIdentifier implements Serializable {

    private final RString 特定個人情報項目コード;
    private final RString 特定個人情報名コード;
    private final RString コード連番;
    private final RString バージョン情報;

    /**
     * コンストラクタです。
     *
     * @param 特定個人情報項目コード 特定個人情報項目コード
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param コード連番 コード連番
     * @param バージョン情報 バージョン情報
     */
    public TokuteiKojinJohoKoumokuHanKanriIdentifier(RString 特定個人情報項目コード,
            RString 特定個人情報名コード,
            RString コード連番,
            RString バージョン情報) {
        this.特定個人情報項目コード = 特定個人情報項目コード;
        this.特定個人情報名コード = 特定個人情報名コード;
        this.コード連番 = コード連番;
        this.バージョン情報 = バージョン情報;
    }
}
