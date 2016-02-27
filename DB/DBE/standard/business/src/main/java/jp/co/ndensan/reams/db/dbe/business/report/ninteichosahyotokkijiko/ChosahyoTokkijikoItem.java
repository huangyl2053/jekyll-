/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定調査票（特記事項）のItemです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahyoTokkijikoItem {

    private final RString ninteichosaItakusakiCode;
    private final RString ninteiChosainNo;
    private final RString hokenshaNo;
    private final RString iraibiFrom;
    private final RString iraibiTo;
    private final RString ninteichosaIraisho;
    private final RString ninteichosahyo;

    /**
     *
     * @param ninteichosaItakusakiCode 認定調査委託先コード
     * @param ninteiChosainNo 認定調査員コード
     * @param hokenshaNo 保険者番号
     * @param iraibiFrom 依頼日From
     * @param iraibiTo 依頼日To
     * @param ninteichosaIraisho 認定調査依頼書
     * @param ninteichosahyo 認定調査票
     */
    public ChosahyoTokkijikoItem(
            RString ninteichosaItakusakiCode,
            RString ninteiChosainNo,
            RString hokenshaNo,
            RString iraibiFrom,
            RString iraibiTo,
            RString ninteichosaIraisho,
            RString ninteichosahyo) {
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
        this.ninteiChosainNo = ninteiChosainNo;
        this.hokenshaNo = hokenshaNo;
        this.iraibiFrom = iraibiFrom;
        this.iraibiTo = iraibiTo;
        this.ninteichosaIraisho = ninteichosaIraisho;
        this.ninteichosahyo = ninteichosahyo;
    }
}
