/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho;

import jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeisho.JukyuShikakuShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 受給資格証明書ボディEditorです。
 *
 * @reamsid_L DBU-0490-090 suguangjun
 */
public class JukyuShikakuShomeishoBodyEditor implements IJukyuShikakuShomeishoEditor {

    private static final int NOCOUNT_1 = 1;
    private static final int NOCOUNT_2 = 2;
    private static final int NOCOUNT_3 = 3;
    private static final int NOCOUNT_4 = 4;
    private static final int NOCOUNT_5 = 5;
    private static final int NOCOUNT_6 = 6;
    private static final int NOCOUNT_7 = 7;
    private static final int NOCOUNT_8 = 8;
    private static final int NOCOUNT_9 = 9;
    private static final int NOCOUNT_10 = 10;
    private static final RString SHINSEICHU_1 = new RString("男");
    private static final RString SHINSEICHU_2 = new RString("女");
    private static final RString HOUSI = new RString("*");
    private static final RString HOUSI_3 = new RString("***");
    private final JukyuShikakuShomeishoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 受給資格証明書情報
     */
    public JukyuShikakuShomeishoBodyEditor(JukyuShikakuShomeishoBodyItem item) {
        this.item = item;
    }

    /**
     * 受給資格証明書ボディEditorです。
     *
     * @param source 受給資格証明書Source
     * @return 受給資格証明書Source
     */
    @Override
    public JukyuShikakuShomeishoReportSource edit(JukyuShikakuShomeishoReportSource source) {
        return bodyEdit(source);
    }

    private JukyuShikakuShomeishoReportSource bodyEdit(JukyuShikakuShomeishoReportSource source) {
        if (item.getHihokenshaNo() != null) {
            for (int i = 1; i <= item.getHihokenshaNo().length(); i++) {
                if (i == NOCOUNT_1) {
                    source.hihokenshaNo1 = item.getHihokenshaNo().substring(0, NOCOUNT_1);
                }
                if (i == NOCOUNT_2) {
                    source.hihokenshaNo2 = item.getHihokenshaNo().substring(NOCOUNT_1, NOCOUNT_2);
                }
                if (i == NOCOUNT_3) {
                    source.hihokenshaNo3 = item.getHihokenshaNo().substring(NOCOUNT_2, NOCOUNT_3);
                }
                if (i == NOCOUNT_4) {
                    source.hihokenshaNo4 = item.getHihokenshaNo().substring(NOCOUNT_3, NOCOUNT_4);
                }
                if (i == NOCOUNT_5) {
                    source.hihokenshaNo5 = item.getHihokenshaNo().substring(NOCOUNT_4, NOCOUNT_5);
                }
                if (i == NOCOUNT_6) {
                    source.hihokenshaNo6 = item.getHihokenshaNo().substring(NOCOUNT_5, NOCOUNT_6);
                }
                if (i == NOCOUNT_7) {
                    source.hihokenshaNo7 = item.getHihokenshaNo().substring(NOCOUNT_6, NOCOUNT_7);
                }
                if (i == NOCOUNT_8) {
                    source.hihokenshaNo8 = item.getHihokenshaNo().substring(NOCOUNT_7, NOCOUNT_8);
                }
                if (i == NOCOUNT_9) {
                    source.hihokenshaNo9 = item.getHihokenshaNo().substring(NOCOUNT_8, NOCOUNT_9);
                }
                if (i == NOCOUNT_10) {
                    source.hihokenshaNo10 = item.getHihokenshaNo().substring(NOCOUNT_9, NOCOUNT_10);
                }
            }
        }
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.birthGengoMeiji = item.getBirthGengoMeiji();
        source.birthGengoTaisho = item.getBirthGengoTaisho();
        source.birthGengoShowa = item.getBirthGengoShowa();
        source.birthYMD = item.getBirthYMD();
        RString seibetsu = item.getSeibetsu();
        source.seibetsuMan = seibetsu.equals(SHINSEICHU_1) ? RString.EMPTY : HOUSI;
        source.seibetsuWoman = seibetsu.equals(SHINSEICHU_2) ? RString.EMPTY : HOUSI;
        source.hihokenshaJusho = item.getSusakiYoteiJusho();
        source.tenshutsusakiYoteiJusho = item.getTenshutsusakiYoteiJusho();
        source.idoYoteiYMD = item.getIdoYoteiYMD();
        bodyEdit2(source);
        return source;
    }

    private JukyuShikakuShomeishoReportSource bodyEdit2(JukyuShikakuShomeishoReportSource source) {
        if (item.getHokenshaNo() != null) {
            for (int i = 1; i <= item.getHokenshaNo().length(); i++) {
                if (i == 1) {
                    source.hokenshaNo1 = item.getHokenshaNo().substring(0, NOCOUNT_1);
                }
                if (i == NOCOUNT_2) {
                    source.hokenshaNo2 = item.getHokenshaNo().substring(NOCOUNT_1, NOCOUNT_2);
                }
                if (i == NOCOUNT_3) {
                    source.hokenshaNo3 = item.getHokenshaNo().substring(NOCOUNT_2, NOCOUNT_3);
                }
                if (i == NOCOUNT_4) {
                    source.hokenshaNo4 = item.getHokenshaNo().substring(NOCOUNT_3, NOCOUNT_4);
                }
                if (i == NOCOUNT_5) {
                    source.hokenshaNo5 = item.getHokenshaNo().substring(NOCOUNT_4, NOCOUNT_5);
                }
                if (i == NOCOUNT_6) {
                    source.hokenshaNo6 = item.getHokenshaNo().substring(NOCOUNT_5, NOCOUNT_6);
                }
            }
        }
        RString shinseichu = item.getShinseichu();
        source.ninteizumi = new RString("0").equals(shinseichu) ? HOUSI_3 : RString.EMPTY;
        source.shinseichu = new RString("1").equals(shinseichu) ? HOUSI_3 : RString.EMPTY;
        RString shinseiYMD = item.getShinseiYMD();
        if (!RString.isNullOrEmpty(shinseiYMD)) {
            source.shinseiYMD = new RDate(shinseiYMD.toString()).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.ninteiYMD = item.getNinteiYMD();
        source.yokaigoKubun = item.getYokaigoKubun();
        source.yukoKaishiYMD = item.getYukoKaishiYMD();
        source.yukoShuryoYMD = item.getYukoShuryoYMD();
        source.shinsakaiIken = item.getShinsakaiIken();
        source.biko = item.getBiko();
        source.remban = item.getRemban();
        source.denshiKoin = item.getDenshiKoin();
        source.hakkoYMD = item.getHakkoYMD();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.koinShoryaku = item.getKoinShoryaku();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        return source;
    }
}
