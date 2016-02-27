/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.dbe521002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 要介護認定業務進捗状況一覧表リスト一覧表情報です。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NiteiGyomuShinchokuJokyoIchiranhyoBodyItem {
    
    
    private final RString listIchiranhyo1_2;
    private final RString listIchiranhyo1_3;
    private final RString listIchiranhyo1_4;
    private final RString listIchiranhyo1_5;
    private final RString listIchiranhyo1_6;
    private final RString listIchiranhyo1_7;
    private final RString listIchiranhyo1_8;
    private final RString listIchiranhyo1_9;
    private final RString listIchiranhyo1_10;
    private final RString listHihokenshaName_1;
    private final RString listIchiranhyo2_1;
    private final RString listIchiranhyo2_2;
    private final RString listIchiranhyo2_3;
    private final RString listChosaItakusakiName_1;
    private final RString listIryokikanName_1;
    private final RString listShinsaYoteiYMD_1;
    private final RString listHihokenshaJusho_1;
    private final RString listChosainName_1;
    private final RString listIshiName_1;
    
    /**
     * インスタンスを生成します。
     * @param listIchiranhyo1_2 調査依頼
     * @param listIchiranhyo1_3 意見書依頼
     * @param listIchiranhyo1_4 調査結果
     * @param listIchiranhyo1_5 意見書受領
     * @param listIchiranhyo1_6 一次判定
     * @param listIchiranhyo1_7 審査受付
     * @param listIchiranhyo1_8 審査結果
     * @param listIchiranhyo1_9 市町村名
     * @param listIchiranhyo1_10 認定申請日
     * @param listHihokenshaName_1 氏名
     * @param listIchiranhyo2_1 生年月日
     * @param listIchiranhyo2_2 性別
     * @param listIchiranhyo2_3 被保険者番号
     * @param listChosaItakusakiName_1 調査委託先名
     * @param listIryokikanName_1 医療機関名
     * @param listShinsaYoteiYMD_1 審査予定日
     * @param listHihokenshaJusho_1 住所
     * @param listChosainName_1 調査員名
     * @param listIshiName_1 医師名
     */
    public NiteiGyomuShinchokuJokyoIchiranhyoBodyItem(RString listIchiranhyo1_2,
            RString listIchiranhyo1_3,
            RString listIchiranhyo1_4,
            RString listIchiranhyo1_5,
            RString listIchiranhyo1_6,
            RString listIchiranhyo1_7,
            RString listIchiranhyo1_8,
            RString listIchiranhyo1_9,
            RString listIchiranhyo1_10,
            RString listHihokenshaName_1,
            RString listIchiranhyo2_1,
            RString listIchiranhyo2_2,
            RString listIchiranhyo2_3,
            RString listChosaItakusakiName_1,
            RString listIryokikanName_1,
            RString listShinsaYoteiYMD_1,
            RString listHihokenshaJusho_1,
            RString listChosainName_1,
            RString listIshiName_1) {
        this.listIchiranhyo1_2 = listIchiranhyo1_2;
        this.listIchiranhyo1_3 = listIchiranhyo1_3;
        this.listIchiranhyo1_4 = listIchiranhyo1_4;
        this.listIchiranhyo1_5 = listIchiranhyo1_5;
        this.listIchiranhyo1_6 = listIchiranhyo1_6;
        this.listIchiranhyo1_7 = listIchiranhyo1_7;
        this.listIchiranhyo1_8 = listIchiranhyo1_8;
        this.listIchiranhyo1_9 = listIchiranhyo1_9;
        this.listIchiranhyo1_10 = listIchiranhyo1_10;
        this.listHihokenshaName_1 = listHihokenshaName_1;
        this.listIchiranhyo2_1 = listIchiranhyo2_1;
        this.listIchiranhyo2_2 = listIchiranhyo2_2;
        this.listIchiranhyo2_3 = listIchiranhyo2_3;
        this.listChosaItakusakiName_1 = listChosaItakusakiName_1;
        this.listIryokikanName_1 = listIryokikanName_1;
        this.listShinsaYoteiYMD_1 = listShinsaYoteiYMD_1;
        this.listHihokenshaJusho_1 = listHihokenshaJusho_1;
        this.listChosainName_1 = listChosainName_1;
        this.listIshiName_1 = listIshiName_1;
    }
}
