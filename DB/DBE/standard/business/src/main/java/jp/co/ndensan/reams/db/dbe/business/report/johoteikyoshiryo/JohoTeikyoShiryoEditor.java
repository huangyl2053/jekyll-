/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo;

import jp.co.ndensan.reams.db.dbe.entity.report.johoteikyoshiryo.JohoTeikyoShiryoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 要介護認定結果情報提供票（主治医）のEditorです。
 */
public class JohoTeikyoShiryoEditor implements IJohoTeikyoShiryoEditor {

    private final JohoTeikyoShiryoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected JohoTeikyoShiryoEditor(JohoTeikyoShiryoItem item) {
        this.item = item;
    }

    @Override
    public JohoTeikyoShiryoReportSource edit(JohoTeikyoShiryoReportSource source) {
        return editSource(source);
    }

    private JohoTeikyoShiryoReportSource editSource(JohoTeikyoShiryoReportSource source) {

        source.hakkoYMD = item.getHakkoYMD().wareki()
                .eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
        source.hokenshaName1 = item.getHokenshaName1();
        source.hokenshaName2 = item.getHokenshaName2();
        source.title = BusinessConfig.get(ConfigNameDBE.要支援認定結果, SubGyomuCode.DBE認定支援);
        source.tsuchibun1 = item.getTsuchibun1();
        source.hihokenshaName = item.getHihokenshaName();
        source.Jusho = item.getJusho();
        source.infoNijiDate = item.getInfoNijiDate().wareki()
                .eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
        source.ninteiKekka = item.getNinteiKekka();
        source.yokaigoNiteiKaishoYMD = item.getYokaigoNiteiKaishoYMD().wareki()
                .eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
        source.yokaigoNinteiShuryoYMD = item.getYokaigoNinteiShuryoYMD().wareki()
                .eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
        source.shinsakaiIken = item.getShinsakaiIken();
        source.tsuchibun2 = item.getTsuchibun2();
        source.tsuchibun3 = item.getTsuchibun3();
        source.tsuchibun4 = item.getTsuchibun4();
        source.tsuchibun5 = item.getTsuchibun5();
        source.tsuchibun6 = item.getTsuchibun6();
        source.tsuchibun7 = item.getTsuchibun7();
        source.tsuchibun8 = item.getTsuchibun8();
        source.tsuchibun9 = item.getTsuchibun9();
        source.tsuchibun10 = item.getTsuchibun10();
        return source;
    }
}
