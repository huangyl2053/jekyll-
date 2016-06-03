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
 * 連動保留特定住所マスタの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class RendoHoryuTokuteiJushoIdentifier implements Serializable {

    private static final long serialVersionUID = 600028593312220576L;
    private final RString 管理番号;
    private final LasdecCode 市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 管理番号 管理番号
     * @param 市町村コード 市町村コード
     */
    public RendoHoryuTokuteiJushoIdentifier(RString 管理番号,
            LasdecCode 市町村コード) {
        this.管理番号 = 管理番号;
        this.市町村コード = 市町村コード;
    }
}
