/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 主治医意見書提出督促状のEditorです。
 *
 */
public class ShujiiIkenshoSakuseiTokusokujoHeadEditor implements IShujiiIkenshoSakuseiTokusokujoEditor {

    private final ShujiiIkenshoSakuseiTokusokujoItem headitem;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param headitem {@link ShujiiIkenshoSakuseiTokusokujoItem}
     * @param index int
     */
    protected ShujiiIkenshoSakuseiTokusokujoHeadEditor(ShujiiIkenshoSakuseiTokusokujoItem headitem, int index) {
        this.headitem = headitem;
        this.index = index;
    }

    @Override
    public ShujiiIkenshoSakuseiTokusokujoReportSource edit(ShujiiIkenshoSakuseiTokusokujoReportSource source) {
        return editSource(source);
    }

    private ShujiiIkenshoSakuseiTokusokujoReportSource editSource(ShujiiIkenshoSakuseiTokusokujoReportSource source) {
        source.bunshoNo = headitem.getBunshoNo();
        source.denshiKoin = headitem.getDenshikoin();
        if (headitem.getHakkoYMD1() != null) {
            source.hakkoYMD1 = new RDate(headitem.getHakkoYMD1().toString()).wareki()
                    .eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
        source.koinMojiretsu = headitem.getKoinMojiretsu();
        source.koinShoryaku = headitem.getKoinShoryaku();
        source.ninshoshaShimeiKakeru = headitem.getNinshoshaShimeiKakeru();
        source.ninshoshaShimeiKakenai = headitem.getNinshoshaShimeiKakenai();
        source.ninshoshaYakushokuMei = headitem.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei1 = headitem.getNinshoshaYakushokuMei1();
        source.ninshoshaYakushokuMei2 = headitem.getNinshoshaYakushokuMei2();
        source.atenaRenban = headitem.getAtenaRenban();
        source.customerBarCode = headitem.getCustomerBarCode();
        source.yubinNo1 = headitem.getYubinNo1();
        source.jushoText = headitem.getJushoText();
        source.kikanNameText = headitem.getKikanNameText();
        source.shimeiText = headitem.getShimeiText();
        source.meishoFuyo = headitem.getMeishoFuyo();
        source.sonota = headitem.getSonota();
        source.tsuchibun1 = headitem.getTsuchibun1();
        source.hihokenshaNo1 = headitem.getHihokenshaNo1();
        source.hihokenshaNo2 = headitem.getHihokenshaNo2();
        source.hihokenshaNo3 = headitem.getHihokenshaNo3();
        source.hihokenshaNo4 = headitem.getHihokenshaNo4();
        source.hihokenshaNo5 = headitem.getHihokenshaNo5();
        source.hihokenshaNo6 = headitem.getHihokenshaNo6();
        source.hihokenshaNo7 = headitem.getHihokenshaNo7();
        source.hihokenshaNo8 = headitem.getHihokenshaNo8();
        source.hihokenshaNo9 = headitem.getHihokenshaNo9();
        source.hihokenshaNo10 = headitem.getHihokenshaNo10();
        source.hokenshaNo1 = headitem.getHokenshaNo1();
        source.hokenshaNo2 = headitem.getHokenshaNo2();
        source.hokenshaNo3 = headitem.getHokenshaNo3();
        source.hokenshaNo4 = headitem.getHokenshaNo4();
        source.hokenshaNo5 = headitem.getHokenshaNo5();
        source.hokenshaNo6 = headitem.getHokenshaNo6();
        source.shinseiKubun = headitem.getShinseiKubun();
        source.hihokenshaNameKana = headitem.getHihokenshaNameKana();
        source.hihokenshaName = headitem.getHihokennsyaName();
        if (headitem.getShinseiYMD() != null) {
            source.shinseiYMD = headitem.getShinseiYMD().wareki()
                    .eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }

        source.yubinNo = headitem.getYubinNo();
        source.jusho = headitem.getJusho();
        if (headitem.getBirthYMD() != null) {
            source.birthYMD = headitem.getBirthYMD().wareki()
                    .eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString().substring(2);
        }
        source.tsuchibun2 = headitem.getTsuchibun2();
        source.remban = headitem.getRemban();
        source.seibetsuMan = headitem.getSeyibenMan();
        source.seibetsuWoman = headitem.getSeyibenWoman();
        source.birthGengoMeiji = headitem.getBirthGengoMeiji();
        source.birthGengoTaisho = headitem.getBirthGengoTaisho();
        source.birthGengoShowa = headitem.getBirthGengoShowa();
        return source;
    }
}
