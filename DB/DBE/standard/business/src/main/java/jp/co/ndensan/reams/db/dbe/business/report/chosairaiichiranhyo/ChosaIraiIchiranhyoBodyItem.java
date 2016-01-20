/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 認定調査依頼一覧表ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiIchiranhyoBodyItem {

    private final RString no;
    private final RString tyousayinnmeyi;
    private final RString hihokennsyabanngou;
    private final RString sinnseyibi;
    private final RString sinnseyikubunn;
    private final RString hihokennsyameyi;
    private final RString hihokennsyameyikaya;
    private final RString seyibetu;
    private final RString birthYMD;
    private final RString jyuusyo;
    private final RString telNo;
    private final RString teyisyukigenn;

    /**
     * インスタンスを生成します。
     *
     * @param no No.
     * @param tyousayinnmeyi 調査員名
     * @param hihokennsyabanngou 被保険者番号
     * @param sinnseyibi 申請日
     * @param sinnseyikubunn 申請区分
     * @param hihokennsyameyi 被保険者名
     * @param hihokennsyameyikaya 被保険者名(カナ)
     * @param seyibetu 性別
     * @param birthYMD 生年月日
     * @param jyuusyo 住所
     * @param telNo 電話番号
     * @param teyisyukigenn 提出期限
     */
    public ChosaIraiIchiranhyoBodyItem(
            RString no,
            RString tyousayinnmeyi,
            RString hihokennsyabanngou,
            RString sinnseyibi,
            RString sinnseyikubunn,
            RString hihokennsyameyi,
            RString hihokennsyameyikaya,
            RString seyibetu,
            RString birthYMD,
            RString jyuusyo,
            RString telNo,
            RString teyisyukigenn) {
        this.no = no;
        this.tyousayinnmeyi = tyousayinnmeyi;
        this.hihokennsyabanngou = hihokennsyabanngou;
        this.sinnseyibi = sinnseyibi;
        this.sinnseyikubunn = sinnseyikubunn;
        this.hihokennsyameyi = hihokennsyameyi;
        this.hihokennsyameyikaya = hihokennsyameyikaya;
        this.seyibetu = seyibetu;
        this.birthYMD = birthYMD;
        this.jyuusyo = jyuusyo;
        this.telNo = telNo;
        this.teyisyukigenn = teyisyukigenn;
    }

}
