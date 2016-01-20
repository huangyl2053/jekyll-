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
    private final RString no;
    private final RString ninyutyousayinnNo;
    private final RString ninyutyousayinnName;
    private final RString ninnteyityousayoteyibi;
    private final RString jyoukyou;
    private final RString hihokennsyaNo;
    private final RString hihokennsyaName;
    private final RString hihokennsyaAdd;
    private final RString tyousajisibasyou;
    private final RString tatiayisya;
    private final RString rennrakusaki1;
    private final RString rennrakusaki2;

    /**
     * インスタンスを生成します。
     *
     * @param ninnteyityousakaisiTime 認定調査予定開始時間
     * @param ninnteyityousasyuroTime 認定調査予定終了時間
     * @param no No
     * @param ninyutyousayinnNo 認定調査員番号
     * @param ninyutyousayinnName 認定調査員名
     * @param ninnteyityousayoteyibi 認定調査予定日
     * @param jyoukyou 状況
     * @param hihokennsyaNo 被保険者番号
     * @param hihokennsyaName 被保険者氏名
     * @param hihokennsyaAdd 被保険者住所
     * @param tyousajisibasyou 調査実施場所
     * @param tatiayisya 立会者
     * @param rennrakusaki1 連絡先１
     * @param rennrakusaki2 連絡先２
     */
    public ChosaSchedulehyoTyousayinBodyItem(
            RString ninnteyityousakaisiTime,
            RString ninnteyityousasyuroTime,
            RString no,
            RString ninyutyousayinnNo,
            RString ninyutyousayinnName,
            RString ninnteyityousayoteyibi,
            RString jyoukyou,
            RString hihokennsyaNo,
            RString hihokennsyaName,
            RString hihokennsyaAdd,
            RString tyousajisibasyou,
            RString tatiayisya,
            RString rennrakusaki1,
            RString rennrakusaki2) {
        this.ninnteyityousakaisiTime = ninnteyityousakaisiTime;
        this.ninnteyityousasyuroTime = ninnteyityousasyuroTime;
        this.no = no;
        this.ninyutyousayinnNo = ninyutyousayinnNo;
        this.ninyutyousayinnName = ninyutyousayinnName;
        this.ninnteyityousayoteyibi = ninnteyityousayoteyibi;
        this.jyoukyou = jyoukyou;
        this.hihokennsyaNo = hihokennsyaNo;
        this.hihokennsyaName = hihokennsyaName;
        this.hihokennsyaAdd = hihokennsyaAdd;
        this.tyousajisibasyou = tyousajisibasyou;
        this.tatiayisya = tatiayisya;
        this.rennrakusaki1 = rennrakusaki1;
        this.rennrakusaki2 = rennrakusaki2;
    }
}
