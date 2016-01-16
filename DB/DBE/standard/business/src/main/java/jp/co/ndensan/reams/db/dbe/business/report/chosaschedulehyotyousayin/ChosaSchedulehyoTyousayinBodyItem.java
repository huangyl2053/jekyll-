/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 認定調査スケジュール表(調査員)ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoTyousayinBodyItem {

    private final RString ninnteyityousakaisiTime;
    private final RString ninnteyityousasyuroTime;
    private final RString listTel1_1;
    private final RString listChosaSukejuru_1;
    private final RString listChosaSukejuru_2;
    private final RString listChosaSukejuru_3;
    private final RString listChosaSukejuru_4;
    private final RString listChosaSukejuru_5;
    private final RString listChosaSukejuru_6;
    private final RString listChosaSukejuru_7;
    private final RString listChosaSukejuru_8;
    private final RString listChosaSukejuru_9;
    private final RString listChosaSukejuru_10;
    private final RString listChosaSukejuru_11;
    private final RString listTel2_1;

    /**
     * インスタンスを生成します。
     *
     * @param ninnteyityousakaisiTime 認定調査予定開始時間
     * @param ninnteyityousasyuroTime 認定調査予定終了時間
     * @param listTel1_1 連絡先１
     * @param listChosaSukejuru_1 No
     * @param listChosaSukejuru_2 認定調査員番号
     * @param listChosaSukejuru_3 認定調査員名
     * @param listChosaSukejuru_4 認定調査予定日
     * @param listChosaSukejuru_5 認定調査時間
     * @param listChosaSukejuru_6 状況
     * @param listChosaSukejuru_7 被保険者番号
     * @param listChosaSukejuru_8 被保険者氏名
     * @param listChosaSukejuru_9 被保険者住所
     * @param listChosaSukejuru_10 調査実施場所
     * @param listChosaSukejuru_11 立会者
     * @param listTel2_1 連絡先２
     */
    public ChosaSchedulehyoTyousayinBodyItem(
            RString ninnteyityousakaisiTime,
            RString ninnteyityousasyuroTime,
            RString listTel1_1,
            RString listChosaSukejuru_1,
            RString listChosaSukejuru_2,
            RString listChosaSukejuru_3,
            RString listChosaSukejuru_4,
            RString listChosaSukejuru_5,
            RString listChosaSukejuru_6,
            RString listChosaSukejuru_7,
            RString listChosaSukejuru_8,
            RString listChosaSukejuru_9,
            RString listChosaSukejuru_10,
            RString listChosaSukejuru_11,
            RString listTel2_1) {
        this.ninnteyityousakaisiTime = ninnteyityousakaisiTime;
        this.ninnteyityousasyuroTime = ninnteyityousasyuroTime;
        this.listTel1_1 = listTel1_1;
        this.listChosaSukejuru_1 = listChosaSukejuru_1;
        this.listChosaSukejuru_2 = listChosaSukejuru_2;
        this.listChosaSukejuru_3 = listChosaSukejuru_3;
        this.listChosaSukejuru_4 = listChosaSukejuru_4;
        this.listChosaSukejuru_5 = listChosaSukejuru_5;
        this.listChosaSukejuru_6 = listChosaSukejuru_6;
        this.listChosaSukejuru_7 = listChosaSukejuru_7;
        this.listChosaSukejuru_8 = listChosaSukejuru_8;
        this.listChosaSukejuru_9 = listChosaSukejuru_9;
        this.listChosaSukejuru_10 = listChosaSukejuru_10;
        this.listChosaSukejuru_11 = listChosaSukejuru_11;
        this.listTel2_1 = listTel2_1;
    }
}
