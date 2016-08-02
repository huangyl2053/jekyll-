/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 処理確認リストのヘッダのITEMです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriKekkaKakuninListHeadItem {

    private final RString printTimeStamp;
    private final RString shichosonCode;
    private final RString shichosonName;
    private final RString keyKomoku1;
    private final RString keyKomoku2;
    private final RString keyKomoku3;
    private final RString keyKomoku4;
    private final RString keyKomoku5;

    /**
     * インスタンスを生成します。
     *
     * @param printTimeStamp printTimeStamp
     * @param shichosonCode shichosonCode
     * @param shichosonName shichosonName
     * @param keyKomoku1 keyKomoku1
     * @param keyKomoku2 keyKomoku2
     * @param keyKomoku3 keyKomoku3
     * @param keyKomoku4 keyKomoku4
     * @param keyKomoku5 keyKomoku5
     */
    public ShoriKekkaKakuninListHeadItem(
            RString printTimeStamp,
            RString shichosonCode,
            RString shichosonName,
            RString keyKomoku1,
            RString keyKomoku2,
            RString keyKomoku3,
            RString keyKomoku4,
            RString keyKomoku5) {

        this.printTimeStamp = printTimeStamp;
        this.shichosonCode = shichosonCode;
        this.shichosonName = shichosonName;
        this.keyKomoku1 = keyKomoku1;
        this.keyKomoku2 = keyKomoku2;
        this.keyKomoku3 = keyKomoku3;
        this.keyKomoku4 = keyKomoku4;
        this.keyKomoku5 = keyKomoku5;

    }

}
