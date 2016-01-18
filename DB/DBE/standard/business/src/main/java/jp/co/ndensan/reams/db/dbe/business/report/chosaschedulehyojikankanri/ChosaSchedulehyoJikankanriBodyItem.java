/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 認定調査スケジュール表(時間管理)ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoJikankanriBodyItem {

    private final RString listChosaSukejuru2_1;
    private final RString listChosaSukejuru2_2;
    private final RString listChosaSukejuru2_3;
    private final RString listChosaSukejuru2_4;
    private final RString listChosaSukejuru3_1;
    private final RString listChosaSukejuru3_2;
    private final RString listChosaSukejuru3_3;
    private final RString ninteiChosaYoteiKaishiTime;
    private final RString ninteiChosaYoteiShuryoTime;
    private final RString yoyakuJokyo;

    /**
     * インスタンスを生成します。
     *
     * @param listChosaSukejuru2_1 No
     * @param listChosaSukejuru2_2 調査員コード
     * @param listChosaSukejuru2_3 調査員名
     * @param listChosaSukejuru2_4 被保険者番号
     * @param listChosaSukejuru3_1 被保険者氏名
     * @param listChosaSukejuru3_2 連絡先１
     * @param listChosaSukejuru3_3 連絡先２
     * @param ninteiChosaYoteiKaishiTime 認定調査予定開始時間
     * @param ninteiChosaYoteiShuryoTime 認定調査予定終了時間
     * @param yoyakuJokyo 予約状況
     */
    public ChosaSchedulehyoJikankanriBodyItem(
            RString listChosaSukejuru2_1,
            RString listChosaSukejuru2_2,
            RString listChosaSukejuru2_3,
            RString listChosaSukejuru2_4,
            RString listChosaSukejuru3_1,
            RString listChosaSukejuru3_2,
            RString listChosaSukejuru3_3,
            RString ninteiChosaYoteiKaishiTime,
            RString ninteiChosaYoteiShuryoTime,
            RString yoyakuJokyo) {

        this.listChosaSukejuru2_1 = listChosaSukejuru2_1;
        this.listChosaSukejuru2_2 = listChosaSukejuru2_2;
        this.listChosaSukejuru2_3 = listChosaSukejuru2_3;
        this.listChosaSukejuru2_4 = listChosaSukejuru2_4;
        this.listChosaSukejuru3_1 = listChosaSukejuru3_1;
        this.listChosaSukejuru3_2 = listChosaSukejuru3_2;
        this.listChosaSukejuru3_3 = listChosaSukejuru3_3;
        this.ninteiChosaYoteiKaishiTime = ninteiChosaYoteiKaishiTime;
        this.ninteiChosaYoteiShuryoTime = ninteiChosaYoteiShuryoTime;
        this.yoyakuJokyo = yoyakuJokyo;
    }
}
