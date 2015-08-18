/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域番号発番テーブルの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KoikiNoHatsubanIdentifier implements Serializable {

    private final LasdecCode 市町村コード;
    private final RString コード区分;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param コード区分 コード区分
     */
    public KoikiNoHatsubanIdentifier(LasdecCode 市町村コード,
            RString コード区分) {
        this.市町村コード = 市町村コード;
        this.コード区分 = コード区分;
    }
}
