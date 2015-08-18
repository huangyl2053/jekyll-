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
 * 新旧調査委託先調査員番号変換テーブルの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinKyuChosaItakusakiChosainNoHenkanIdentifier implements Serializable {

    private final LasdecCode 市町村コード;
    private final RString 旧調査委託先番号;
    private final RString 旧調査員番号;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 旧調査委託先番号 旧調査委託先番号
     * @param 旧調査員番号 旧調査員番号
     */
    public ShinKyuChosaItakusakiChosainNoHenkanIdentifier(LasdecCode 市町村コード,
            RString 旧調査委託先番号,
            RString 旧調査員番号) {
        this.市町村コード = 市町村コード;
        this.旧調査委託先番号 = 旧調査委託先番号;
        this.旧調査員番号 = 旧調査員番号;
    }
}
