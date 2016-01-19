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

    private final RString no;
    private final RString tyousayinnNo;
    private final RString tyousayinnName;
    private final RString hihokennsyaNo;
    private final RString hihokennsyaName;
    private final RString rennrakusaki1;
    private final RString rennrakusaki2;
    private final RString ninteiChosaYoteiKaishiTime;
    private final RString ninteiChosaYoteiShuryoTime;
    private final RString yoyakuJokyo;

    /**
     * インスタンスを生成します。
     *
     * @param no No
     * @param tyousayinnNo 調査員コード
     * @param tyousayinnName 調査員名
     * @param hihokennsyaNo 被保険者番号
     * @param hihokennsyaName 被保険者氏名
     * @param rennrakusaki1 連絡先１
     * @param rennrakusaki2 連絡先２
     * @param ninteiChosaYoteiKaishiTime 認定調査予定開始時間
     * @param ninteiChosaYoteiShuryoTime 認定調査予定終了時間
     * @param yoyakuJokyo 予約状況
     */
    public ChosaSchedulehyoJikankanriBodyItem(
            RString no,
            RString tyousayinnNo,
            RString tyousayinnName,
            RString hihokennsyaNo,
            RString hihokennsyaName,
            RString rennrakusaki1,
            RString rennrakusaki2,
            RString ninteiChosaYoteiKaishiTime,
            RString ninteiChosaYoteiShuryoTime,
            RString yoyakuJokyo) {

        this.no = no;
        this.tyousayinnNo = tyousayinnNo;
        this.tyousayinnName = tyousayinnName;
        this.hihokennsyaNo = hihokennsyaNo;
        this.hihokennsyaName = hihokennsyaName;
        this.rennrakusaki1 = rennrakusaki1;
        this.rennrakusaki2 = rennrakusaki2;
        this.ninteiChosaYoteiKaishiTime = ninteiChosaYoteiKaishiTime;
        this.ninteiChosaYoteiShuryoTime = ninteiChosaYoteiShuryoTime;
        this.yoyakuJokyo = yoyakuJokyo;
    }
}
