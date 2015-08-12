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
 * 新旧被保険者番号変換テーブルの識別子です。
 */
@Value
public class ShinKyuHihokenshaNoHenkanIdentifier implements Serializable {

    private final LasdecCode 市町村コード;
    private final RString 旧番号;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 旧番号 旧番号
     */
    public ShinKyuHihokenshaNoHenkanIdentifier(LasdecCode 市町村コード,
            RString 旧番号) {
        this.市町村コード = 市町村コード;
        this.旧番号 = 旧番号;
    }
}
