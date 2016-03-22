/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 年齢到達予定者一覧表ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreitotatsuYoteishaIchiranhyoBodyItem {

    private final RString listUpper_1;
    private final RString listUpper_2;
    private final RString listUpper_3;
    private final RString listUpper_4;
    private final RString listUpper_5;
    private final RString listUpper_6;
    private final RString listUpper_7;
    private final RString listUpper_8;
    private final RString listLower_1;
    private final RString listLower_2;
    private final RString listLower_3;
    private final RString listLower_4;
    private final RString listLower_5;
    private final RString listLower_6;
    private final RString listLower_7;
    private final RString listLower_8;

    /**
     * インスタンスを生成します。
     *
     * @param listUpper_1 被保険者番号
     * @param listUpper_2 カナ氏名
     * @param listUpper_3 性別
     * @param listUpper_4 生年月日
     * @param listUpper_5 資格区分
     * @param listUpper_6 住所コード
     * @param listUpper_7 住所
     * @param listUpper_8 生活
     * @param listLower_1 識別コード
     * @param listLower_2 氏名
     * @param listLower_3 年齢到達日
     * @param listLower_4 住特者区分
     * @param listLower_5 行政区コード
     * @param listLower_6 行政区
     * @param listLower_7 住民種別
     * @param listLower_8 状態
     */
    public NenreitotatsuYoteishaIchiranhyoBodyItem(
            RString listUpper_1,
            RString listUpper_2,
            RString listUpper_3,
            RString listUpper_4,
            RString listUpper_5,
            RString listUpper_6,
            RString listUpper_7,
            RString listUpper_8,
            RString listLower_1,
            RString listLower_2,
            RString listLower_3,
            RString listLower_4,
            RString listLower_5,
            RString listLower_6,
            RString listLower_7,
            RString listLower_8
    ) {
        this.listUpper_1 = listUpper_1;
        this.listUpper_2 = listUpper_2;
        this.listUpper_3 = listUpper_3;
        this.listUpper_4 = listUpper_4;
        this.listUpper_5 = listUpper_5;
        this.listUpper_6 = listUpper_6;
        this.listUpper_7 = listUpper_7;
        this.listUpper_8 = listUpper_8;
        this.listLower_1 = listLower_1;
        this.listLower_2 = listLower_2;
        this.listLower_3 = listLower_3;
        this.listLower_4 = listLower_4;
        this.listLower_5 = listLower_5;
        this.listLower_6 = listLower_6;
        this.listLower_7 = listLower_7;
        this.listLower_8 = listLower_8;

    }
}
