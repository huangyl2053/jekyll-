/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 処理確認リストのボディのITEMです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriKekkaKakuninListBodyItem {

    private final List<RString> listUpper_1;
    private final List<RString> listUpper_2;
    private final List<RString> listUpper_3;
    private final List<RString> listUpper_4;
    private final List<RString> listUpper_5;
    private final List<RString> listUpper_6;
    private final List<RString> listUpper_7;
    private final List<RString> listLower_1;
    private final List<RString> listLower_2;

    /**
     * インスタンスを生成します。
     *
     * @param listUpper_1 プログラムID
     * @param listUpper_2 項目値1
     * @param listUpper_3 項目値2
     * @param listUpper_4 項目値3
     * @param listUpper_5 項目値4
     * @param listUpper_7 項目値5
     * @param listUpper_6 内容1
     * @param listLower_1 処理名称
     * @param listLower_2 内容2
     */
    public ShoriKekkaKakuninListBodyItem(
            List<RString> listUpper_1,
            List<RString> listUpper_2,
            List<RString> listUpper_3,
            List<RString> listUpper_4,
            List<RString> listUpper_5,
            List<RString> listUpper_6,
            List<RString> listUpper_7,
            List<RString> listLower_1,
            List<RString> listLower_2) {

        this.listUpper_1 = listUpper_1;
        this.listUpper_2 = listUpper_2;
        this.listUpper_3 = listUpper_3;
        this.listUpper_4 = listUpper_4;
        this.listUpper_5 = listUpper_5;
        this.listUpper_6 = listUpper_6;
        this.listUpper_7 = listUpper_7;
        this.listLower_1 = listLower_1;
        this.listLower_2 = listLower_2;
    }

}
