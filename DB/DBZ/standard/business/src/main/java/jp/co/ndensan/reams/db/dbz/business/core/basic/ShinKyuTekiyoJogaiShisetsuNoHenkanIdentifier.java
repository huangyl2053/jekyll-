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
 * 新旧適用除外施設番号変換テーブルの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier implements Serializable {

    private final LasdecCode 市町村コード;
    private final RString 旧適用除外施設番号;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 旧適用除外施設番号 旧適用除外施設番号
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier(LasdecCode 市町村コード,
            RString 旧適用除外施設番号) {
        this.市町村コード = 市町村コード;
        this.旧適用除外施設番号 = 旧適用除外施設番号;
    }
}
