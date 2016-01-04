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
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoKekkaTaishouIchiranHeadItem {

    private final RString shichosonName;
    private final RString chushutsuKikanFrom;
    private final RString chushutsuKikanTo;
    private final RString printTimeStamp;
    private final Integer gokei;

    /**
     * インスタンスを生成します。
     *
     * @param shichosonName 広域連合
     * @param chushutsuKikanFrom 抽出期間From
     * @param chushutsuKikanTo 抽出期間To
     * @param printTimeStamp 作成年月日
     * @param gokei 合計
     */
    public KaigoKekkaTaishouIchiranHeadItem(
            RString shichosonName,
            RString chushutsuKikanFrom,
            RString chushutsuKikanTo,
            RString printTimeStamp,
            Integer gokei) {

        this.shichosonName = shichosonName;
        this.chushutsuKikanFrom = chushutsuKikanFrom;
        this.chushutsuKikanTo = chushutsuKikanTo;
        this.printTimeStamp = printTimeStamp;
        this.gokei = gokei;
    }

    public static KaigoKekkaTaishouIchiranHeadItem creataKaigoKekkaTaishouIchiranHeadItem(
            RString shichosonName,
            RString chushutsuKikanFrom,
            RString chushutsuKikanTo,
            RString printTimeStamp,
            Integer gokei) {

        return new KaigoKekkaTaishouIchiranHeadItem(shichosonName, chushutsuKikanFrom, chushutsuKikanTo, printTimeStamp, gokei);

    }
}
