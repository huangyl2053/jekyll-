/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表ヘッダEditorです。
 */
class TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranHeaderEditor implements ITokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranEditor {

    private final TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranItem item;

    protected TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranHeaderEditor(TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranItem item) {
        this.item = item;

    }

    @Override
    public TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource edit(TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource source) {
        return editHeader(source);
    }

    private TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource editHeader(TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource source) {

        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(0, 2);
        RString min = new RString(time.toString()).substring(3, 5);
        RString sec = new RString(time.toString()).substring(6, 8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        
        source.printTimeStamp = new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString().toString()  + RString.HALF_SPACE + timeFormat)
                .concat(RString.FULL_SPACE).concat(new RString("作成"));
        source.nendo = item.getNendo();
        source.hokenshaNo = item.getHokenshaNo();
        source.hokenshaName = item.getHokenshaName();
        source.shutsuryokujun1 = item.getShutsuryokujun1();
        source.shutsuryokujun2 = item.getShutsuryokujun2();
        source.shutsuryokujun3 = item.getShutsuryokujun3();
        source.shutsuryokujun4 = item.getShutsuryokujun4();
        source.shutsuryokujun5 = item.getShutsuryokujun5();
        source.kaipage1 = item.getKaipage1();
        source.kaipage2 = item.getKaipage2();
        source.kaipage3 = item.getKaipage3();
        source.kaipage4 = item.getKaipage4();
        source.kaipage5 = item.getKaipage5();
        return source;
    }

}
