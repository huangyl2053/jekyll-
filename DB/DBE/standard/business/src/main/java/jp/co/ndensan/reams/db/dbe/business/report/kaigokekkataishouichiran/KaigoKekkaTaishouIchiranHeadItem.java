/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定結果通知書対象者一覧表ヘッダのITEMです。
 *
 * @reamsid_L DBE-0190-020 lizhuoxuan
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KaigoKekkaTaishouIchiranHeadItem {

    private final RString shichosonName;
    private final RString chushutsuHoho;
    private final RString chushutsuKikanFrom;
    private final RString chushutsuKikanTo;
    private final RString printTimeStamp;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param shichosonName 広域連合
     * @param chushutsuHoho 抽出方法
     * @param chushutsuKikanFrom 抽出期間From
     * @param chushutsuKikanTo 抽出期間To
     * @param printTimeStamp 作成年月日
     */
    private KaigoKekkaTaishouIchiranHeadItem(
            RString shichosonName,
            RString chushutsuHoho,
            RString chushutsuKikanFrom,
            RString chushutsuKikanTo,
            RString printTimeStamp,
            int index) {

        this.shichosonName = shichosonName;
        this.chushutsuHoho = chushutsuHoho;
        this.chushutsuKikanFrom = chushutsuKikanFrom;
        this.chushutsuKikanTo = chushutsuKikanTo;
        this.printTimeStamp = printTimeStamp;
        this.index = index;
    }

    /**
     * インスタンスを生成します。
     *
     * @param shichosonName 広域連合
     * @param chushutsuHoho 抽出方法
     * @param chushutsuKikanFrom 抽出期間From
     * @param chushutsuKikanTo 抽出期間To
     * @param printTimeStamp 作成年月日
     * @param index データ数カウント値
     * @return KaigoKekkaTaishouIchiranHeadItem
     */
    public static KaigoKekkaTaishouIchiranHeadItem creataKaigoKekkaTaishouIchiranHeadItem(
            RString shichosonName,
            RString chushutsuHoho,
            RString chushutsuKikanFrom,
            RString chushutsuKikanTo,
            RString printTimeStamp,
            int index) {

        return new KaigoKekkaTaishouIchiranHeadItem(shichosonName, chushutsuHoho, chushutsuKikanFrom, chushutsuKikanTo, printTimeStamp, index);

    }
}
