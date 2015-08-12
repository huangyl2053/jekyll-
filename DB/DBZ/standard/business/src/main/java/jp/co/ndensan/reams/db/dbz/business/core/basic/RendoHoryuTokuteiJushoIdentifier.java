/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連動保留特定住所マスタの識別子です。
 */
@Value
public class RendoHoryuTokuteiJushoIdentifier implements Serializable {

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
