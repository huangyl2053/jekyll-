/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 介護導入形態の識別子です。
 */
@Value
public class KaigoDonyuKeitaiIdentifier implements Serializable {

    private final RString 業務分類;
    private final Code 導入形態コード;

    /**
     * コンストラクタです。
     *
     * @param 業務分類 業務分類
     * @param 導入形態コード 導入形態コード
     */
    public KaigoDonyuKeitaiIdentifier(RString 業務分類,
            Code 導入形態コード) {
        this.業務分類 = 業務分類;
        this.導入形態コード = 導入形態コード;
    }
}
