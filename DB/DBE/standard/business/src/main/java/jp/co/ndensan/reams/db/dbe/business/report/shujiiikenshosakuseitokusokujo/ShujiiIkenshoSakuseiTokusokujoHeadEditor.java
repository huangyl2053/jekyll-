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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 主治医意見書提出督促状のEditorです。
 *
 */
public class ShujiiIkenshoSakuseiTokusokujoHeadEditor implements IShujiiIkenshoSakuseiTokusokujoEditor {

    private final ShujiiIkenshoSakuseiTokusokujoItem headitem;

    private static final RString 改行 = new RString("\\n");

    /**
     * インスタンスを生成します。
     *
     * @param headitem {@link ShujiiIkenshoSakuseiTokusokujoItem}
     */
    protected ShujiiIkenshoSakuseiTokusokujoHeadEditor(ShujiiIkenshoSakuseiTokusokujoItem headitem) {
        this.headitem = headitem;
    }

    @Override
    public ShujiiIkenshoSakuseiTokusokujoReportSource edit(ShujiiIkenshoSakuseiTokusokujoReportSource source) {
        return editSource(source);
    }

    private ShujiiIkenshoSakuseiTokusokujoReportSource editSource(ShujiiIkenshoSakuseiTokusokujoReportSource source) {
        source.bunshoNo = headitem.getBunshoNo();
        source.denshiKoin = headitem.getDenshikoin();
        source.hakkoYMD1 = headitem.getHakkoYMD().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        source.ninshoshaYakushokuMei = headitem.getShomeiHakkoYMD();
        source.ninshoshaShimeiKakenai = headitem.getShuchoMei();
        source.koinShoryaku = headitem.getKoinShoryaku();
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
        source.shinseiYMD = headitem.getShinseiYMD().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        source.yubinNo = headitem.getYubinNo();
        source.jusho = headitem.getJusho();
        source.birthYMD = headitem.getBirthYMD().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString().substring(2);

        RStringBuilder builder = new RStringBuilder();
        builder.append(headitem.getTsuchibun2());
        builder.append(改行);
        builder.append(headitem.getTsuchibun3());
        builder.append(改行);
        builder.append(headitem.getTsuchibun4());
        builder.append(改行);
        builder.append(headitem.getTsuchibun5());
        builder.append(改行);
        builder.append(headitem.getTsuchibun6());
        builder.append(改行);
        builder.append(headitem.getTsuchibun7());
        builder.append(改行);
        builder.append(headitem.getTsuchibun8());
        builder.append(改行);
        builder.append(headitem.getTsuchibun9());
        builder.append(改行);
        builder.append(headitem.getTsuchibun10());
        builder.append(改行);
        builder.append(headitem.getTsuchibun11());
        builder.append(改行);
        builder.append(headitem.getTsuchibun12());
        builder.append(改行);
        builder.append(headitem.getTsuchibun13());
        builder.append(改行);
        builder.append(headitem.getTsuchibun14());
        builder.append(改行);
        builder.append(headitem.getTsuchibun15());
        builder.append(改行);
        builder.append(headitem.getTsuchibun16());
        builder.append(改行);
        builder.append(headitem.getTsuchibun17());
        builder.append(改行);
        builder.append(headitem.getTsuchibun18());
        builder.append(改行);
        builder.append(headitem.getTsuchibun19());
        source.tsuchibun2 = builder.toRString();
        source.remban = headitem.getRemban();
        source.seibetsuMan = headitem.getSeyibenMan();
        source.seibetsuWoman = headitem.getSeyibenWoman();
        source.remban = headitem.getRemban();
        source.seibetsuMan = headitem.getSeyibenMan();
        source.seibetsuWoman = headitem.getSeyibenWoman();
        source.birthGengoMeiji = headitem.getBirthYMDseyiji();
        source.birthGengoTaisho = headitem.getBirthYMDdayiseyi();
        source.birthGengoShowa = headitem.getBirthYMDsyowa();
        return source;
    }
}
