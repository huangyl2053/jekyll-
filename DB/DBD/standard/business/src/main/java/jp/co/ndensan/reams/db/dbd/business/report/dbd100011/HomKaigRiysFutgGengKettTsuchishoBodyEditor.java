/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100011;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100011.HomKaigRiysFutgGengKettTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 訪問介護等利用者負担額減額決定通知書ボディEditorです。
 *
 * @reamsid_L DBD-3540-090 wangchao
 */
public class HomKaigRiysFutgGengKettTsuchishoBodyEditor implements IHomKaigRiysFutgGengKettTsuchishoEditor {

    private final RString 折り返す符号 = new RString("\n");
    private final RString 決定区分_承認 = new RString("○");
    private final int INDEX_0 = 0;
    private final int INDEX_1 = 1;
    private final int INDEX_2 = 2;
    private final int INDEX_3 = 3;
    private final int INDEX_4 = 4;
    private final int INDEX_5 = 5;
    private final int INDEX_6 = 6;
    private final int INDEX_7 = 7;
    private final int INDEX_8 = 8;
    private final int INDEX_9 = 9;
    private final int INDEX_10 = 10;
    private final int INDEX_11 = 11;
    private final int INDEX_12 = 12;
    private final int INDEX_13 = 13;
    private final int INDEX_14 = 14;
    private final int INDEX_15 = 15;
    private final int INDEX_16 = 16;
    private final int INDEX_17 = 17;
    private final int INDEX_18 = 18;
    private final int INDEX_19 = 19;
    private final int INDEX_20 = 20;
    private final int INDEX_21 = 21;
    private final HomKaigRiysFutgGengKettTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 訪問介護等利用者負担額減額決定通知書
     */
    public HomKaigRiysFutgGengKettTsuchishoBodyEditor(HomKaigRiysFutgGengKettTsuchishoItem item) {
        this.item = item;
    }

    /**
     * 訪問介護等利用者負担額減額決定通知書ボディEditorです。
     *
     * @param source 訪問介護等利用者負担額減額決定通知書Source
     * @return 訪問介護等利用者負担額減額決定通知書Source
     */
    @Override
    public HomKaigRiysFutgGengKettTsuchishoReportSource edit(HomKaigRiysFutgGengKettTsuchishoReportSource source) {
        return bodyEdit(source);
    }

    private HomKaigRiysFutgGengKettTsuchishoReportSource bodyEdit(HomKaigRiysFutgGengKettTsuchishoReportSource source) {

        source.bunshoNo = item.get文書番号();
        source.title1 = new RString("訪問介護等利用者負担額減額　決定通知書");
        source.title2 = RString.EMPTY;
        set通知文(source);

        EditedKojin 編集後個人 = getEditedKojin(item.getIKojin(), item.get帳票制御共通(), item.get地方公共団体());
        source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        source.hihokenshaNo1 = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue().substring(INDEX_0, INDEX_1);
        source.hihokenshaNo2 = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue().substring(INDEX_1, INDEX_2);
        source.hihokenshaNo3 = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue().substring(INDEX_2, INDEX_3);
        source.hihokenshaNo4 = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue().substring(INDEX_3, INDEX_4);
        source.hihokenshaNo5 = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue().substring(INDEX_4, INDEX_5);
        source.hihokenshaNo6 = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue().substring(INDEX_5, INDEX_6);
        source.hihokenshaNo7 = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue().substring(INDEX_6, INDEX_7);
        source.hihokenshaNo8 = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue().substring(INDEX_7, INDEX_8);
        source.hihokenshaNo9 = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue().substring(INDEX_8, INDEX_9);
        source.hihokenshaNo10 = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue().substring(INDEX_9, INDEX_10);
        source.ketteiYMD = item.get訪問介護利用者負担額減額().get決定年月日().wareki().toDateString();

        source.ninteiKekka3 = RString.EMPTY;
        source.ninteiKekka4 = RString.EMPTY;
        source.ninteiKekka5 = RString.EMPTY;
        source.ninteiKekka6 = RString.EMPTY;
        source.ninteiKekka7 = RString.EMPTY;
        if (KetteiKubun.承認する.getコード().equals(item.get訪問介護利用者負担額減額().get決定区分())) {
            source.tekiyoYMD = item.get訪問介護利用者負担額減額().get適用開始年月日().wareki().toDateString();
            source.ninteiKekka1 = new RString("（承認内容）");
            source.shoninSuru = 決定区分_承認;
            source.ninteiKekka2 = new RString(
                    "　　　給付率".concat(item.get訪問介護利用者負担額減額().get給付率().getColumnValue().toString().concat("　/　100")));
            source.yukoYMD = item.get訪問介護利用者負担額減額().get適用終了年月日().wareki().toDateString();

            source.futanshaNo1 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_0, INDEX_1);
            source.futanshaNo2 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_1, INDEX_2);
            source.futanshaNo3 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_2, INDEX_3);
            source.futanshaNo4 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_3, INDEX_4);
            source.futanshaNo5 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_4, INDEX_5);
            source.futanshaNo6 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_5, INDEX_6);
            source.futanshaNo7 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_6, INDEX_7);
            source.futanshaNo8 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_7, INDEX_8);

            source.jukyushaNo1 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_0, INDEX_1);
            source.jukyushaNo2 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_1, INDEX_2);
            source.jukyushaNo3 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_2, INDEX_3);
            source.jukyushaNo4 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_3, INDEX_4);
            source.jukyushaNo5 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_4, INDEX_5);
            source.jukyushaNo6 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_5, INDEX_6);
            source.jukyushaNo7 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_6, INDEX_7);

            source.shoninNg = RString.EMPTY;
            source.riyu1 = RString.EMPTY;
            source.riyu2 = RString.EMPTY;
            source.riyu3 = RString.EMPTY;
            source.riyu4 = RString.EMPTY;
            source.riyu5 = RString.EMPTY;
        } else {
            source.tekiyoYMD = RString.EMPTY;
            source.ninteiKekka1 = RString.EMPTY;
            source.shoninSuru = RString.EMPTY;
            source.ninteiKekka2 = RString.EMPTY;
            source.yukoYMD = RString.EMPTY;
            source.futanshaNo4 = RString.EMPTY;
            source.futanshaNo1 = RString.EMPTY;
            source.futanshaNo2 = RString.EMPTY;
            source.futanshaNo3 = RString.EMPTY;
            source.futanshaNo5 = RString.EMPTY;
            source.futanshaNo6 = RString.EMPTY;
            source.futanshaNo7 = RString.EMPTY;
            source.futanshaNo8 = RString.EMPTY;
            source.jukyushaNo1 = RString.EMPTY;
            source.jukyushaNo2 = RString.EMPTY;
            source.jukyushaNo3 = RString.EMPTY;
            source.jukyushaNo4 = RString.EMPTY;
            source.jukyushaNo5 = RString.EMPTY;
            source.jukyushaNo6 = RString.EMPTY;
            source.jukyushaNo7 = RString.EMPTY;
            source.shoninNg = 決定区分_承認;
            List<RString> 非承認理由 = item.get訪問介護利用者負担額減額().get非承認理由().split(折り返す符号.toString());
            source.riyu1 = get非承認理由List(INDEX_0, 非承認理由);
            source.riyu2 = get非承認理由List(INDEX_1, 非承認理由);
            source.riyu3 = get非承認理由List(INDEX_2, 非承認理由);
            source.riyu4 = get非承認理由List(INDEX_3, 非承認理由);
            source.riyu5 = get非承認理由List(INDEX_4, 非承認理由);
        }
        if (TeikeibunMojiSize.フォント小.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
            set連絡先他(source);
        }

        if (TeikeibunMojiSize.フォント大.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
            set連絡先他Large(source);

        }
        if (TeikeibunMojiSize.フォント上小下大.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
            set連絡先他上段Small(source);
            set連絡先他下段Large(source);
        }
        if (TeikeibunMojiSize.フォント上大下小.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
            set連絡先他上段Large(source);
            set連絡先他下段Small(source);
        }
        setCompNinshosha(source, item);
        setCompSofubutsuAtesaki(source, item);

        source.shikibetsuCode = item.getIKojin().get識別コード().getColumnValue();
        source.hihokenshaNo = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue();
        return source;
    }

    private RString get非承認理由List(int i, List<RString> 非承認理由) {
        if (非承認理由.size() >= i + 1) {
            return 非承認理由.get(i);
        } else {
            return RString.EMPTY;
        }
    }

    private void set通知文(HomKaigRiysFutgGengKettTsuchishoReportSource source) {
        List<RString> 通知書定型文List = item.get通知書定型文List().get(1).split(折り返す符号.toString());
        source.tsuchibun1 = getLenStr(INDEX_0, 通知書定型文List);
        source.tsuchibun2 = getLenStr(INDEX_1, 通知書定型文List);
    }

    private void set連絡先他(HomKaigRiysFutgGengKettTsuchishoReportSource source) {
        List<RString> 通知書定型文List = item.get通知書定型文List().get(2).split(折り返す符号.toString());
        source.tsuchibun3 = getLenStr(INDEX_0, 通知書定型文List);
        source.tsuchibun4 = getLenStr(INDEX_1, 通知書定型文List);
        source.tsuchibun5 = getLenStr(INDEX_2, 通知書定型文List);
        source.tsuchibun6 = getLenStr(INDEX_3, 通知書定型文List);
        source.tsuchibun7 = getLenStr(INDEX_4, 通知書定型文List);
        source.tsuchibun8 = getLenStr(INDEX_5, 通知書定型文List);
        source.tsuchibun9 = getLenStr(INDEX_6, 通知書定型文List);
        source.tsuchibun10 = getLenStr(INDEX_7, 通知書定型文List);
        source.tsuchibun11 = getLenStr(INDEX_8, 通知書定型文List);
        source.tsuchibun12 = getLenStr(INDEX_9, 通知書定型文List);
        source.tsuchibun13 = getLenStr(INDEX_10, 通知書定型文List);
        source.tsuchibun14 = getLenStr(INDEX_11, 通知書定型文List);
        source.tsuchibun15 = getLenStr(INDEX_12, 通知書定型文List);
        source.tsuchibun16 = getLenStr(INDEX_13, 通知書定型文List);
        source.tsuchibun17 = getLenStr(INDEX_14, 通知書定型文List);
        source.tsuchibun18 = getLenStr(INDEX_15, 通知書定型文List);
        source.tsuchibun19 = getLenStr(INDEX_16, 通知書定型文List);
        source.tsuchibun20 = getLenStr(INDEX_17, 通知書定型文List);
        source.tsuchibun21 = getLenStr(INDEX_18, 通知書定型文List);
        source.tsuchibun22 = getLenStr(INDEX_19, 通知書定型文List);
        source.tsuchibun23 = getLenStr(INDEX_20, 通知書定型文List);
        source.tsuchibun24 = getLenStr(INDEX_21, 通知書定型文List);
    }

    private void set連絡先他Large(HomKaigRiysFutgGengKettTsuchishoReportSource source) {
        List<RString> 通知書定型文List = item.get通知書定型文List().get(2).split(折り返す符号.toString());
        source.tsuchibunLarge3 = getLenStr(INDEX_0, 通知書定型文List);
        source.tsuchibunLarge4 = getLenStr(INDEX_1, 通知書定型文List);
        source.tsuchibunLarge5 = getLenStr(INDEX_2, 通知書定型文List);
        source.tsuchibunLarge6 = getLenStr(INDEX_3, 通知書定型文List);
        source.tsuchibunLarge7 = getLenStr(INDEX_4, 通知書定型文List);
        source.tsuchibunLarge8 = getLenStr(INDEX_5, 通知書定型文List);
        source.tsuchibunLarge9 = getLenStr(INDEX_6, 通知書定型文List);
        source.tsuchibunLarge10 = getLenStr(INDEX_7, 通知書定型文List);
        source.tsuchibunLarge11 = getLenStr(INDEX_8, 通知書定型文List);
        source.tsuchibunLarge12 = getLenStr(INDEX_9, 通知書定型文List);
        source.tsuchibunLarge13 = getLenStr(INDEX_10, 通知書定型文List);
        source.tsuchibunLarge14 = getLenStr(INDEX_11, 通知書定型文List);
        source.tsuchibunLarge15 = getLenStr(INDEX_12, 通知書定型文List);
        source.tsuchibunLarge16 = getLenStr(INDEX_13, 通知書定型文List);
        source.tsuchibunLarge17 = getLenStr(INDEX_14, 通知書定型文List);
        source.tsuchibunLarge18 = getLenStr(INDEX_15, 通知書定型文List);
        source.tsuchibunLarge19 = getLenStr(INDEX_16, 通知書定型文List);
        source.tsuchibunLarge20 = getLenStr(INDEX_17, 通知書定型文List);
    }

    private void set連絡先他上段Small(HomKaigRiysFutgGengKettTsuchishoReportSource source) {
        List<RString> 通知書定型文List = item.get通知書定型文List().get(2).split(折り返す符号.toString());
        source.tsuchibunMix3 = getLenStr(INDEX_0, 通知書定型文List);
        source.tsuchibunMix4 = getLenStr(INDEX_1, 通知書定型文List);
        source.tsuchibunMix5 = getLenStr(INDEX_2, 通知書定型文List);
        source.tsuchibunMix6 = getLenStr(INDEX_3, 通知書定型文List);
        source.tsuchibunMix7 = getLenStr(INDEX_4, 通知書定型文List);
        source.tsuchibunMix8 = getLenStr(INDEX_5, 通知書定型文List);
        source.tsuchibunMix9 = getLenStr(INDEX_6, 通知書定型文List);
        source.tsuchibunMix10 = getLenStr(INDEX_7, 通知書定型文List);
        source.tsuchibunMix11 = getLenStr(INDEX_8, 通知書定型文List);
        source.tsuchibunMix12 = getLenStr(INDEX_9, 通知書定型文List);
        source.tsuchibunMix13 = getLenStr(INDEX_10, 通知書定型文List);
        source.tsuchibunMix14 = getLenStr(INDEX_11, 通知書定型文List);
        source.tsuchibunMix15 = getLenStr(INDEX_12, 通知書定型文List);

    }

    private void set連絡先他下段Large(HomKaigRiysFutgGengKettTsuchishoReportSource source) {
        List<RString> 通知書定型文List = item.get通知書定型文List().get(INDEX_3).split(折り返す符号.toString());
        source.tsuchibunMix16 = getLenStr(INDEX_0, 通知書定型文List);
        source.tsuchibunMix17 = getLenStr(INDEX_1, 通知書定型文List);
        source.tsuchibunMix18 = getLenStr(INDEX_2, 通知書定型文List);
        source.tsuchibunMix19 = getLenStr(INDEX_3, 通知書定型文List);
        source.tsuchibunMix20 = getLenStr(INDEX_4, 通知書定型文List);
        source.tsuchibunMix21 = getLenStr(INDEX_5, 通知書定型文List);
        source.tsuchibunMix22 = getLenStr(INDEX_6, 通知書定型文List);
    }

    private void set連絡先他上段Large(HomKaigRiysFutgGengKettTsuchishoReportSource source) {
        List<RString> 通知書定型文List = item.get通知書定型文List().get(2).split(折り返す符号.toString());
        source.tsuchibunMixtwo3 = getLenStr(INDEX_0, 通知書定型文List);
        source.tsuchibunMixtwo4 = getLenStr(INDEX_1, 通知書定型文List);
        source.tsuchibunMixtwo5 = getLenStr(INDEX_2, 通知書定型文List);
        source.tsuchibunMixtwo6 = getLenStr(INDEX_3, 通知書定型文List);
        source.tsuchibunMixtwo7 = getLenStr(INDEX_4, 通知書定型文List);
        source.tsuchibunMixtwo8 = getLenStr(INDEX_5, 通知書定型文List);
        source.tsuchibunMixtwo9 = getLenStr(INDEX_6, 通知書定型文List);

    }

    private void set連絡先他下段Small(HomKaigRiysFutgGengKettTsuchishoReportSource source) {
        List<RString> 通知書定型文List = item.get通知書定型文List().get(INDEX_3).split(折り返す符号.toString());
        source.tsuchibunMixtwo10 = getLenStr(INDEX_0, 通知書定型文List);
        source.tsuchibunMixtwo11 = getLenStr(INDEX_1, 通知書定型文List);
        source.tsuchibunMixtwo12 = getLenStr(INDEX_2, 通知書定型文List);
        source.tsuchibunMixtwo13 = getLenStr(INDEX_3, 通知書定型文List);
        source.tsuchibunMixtwo14 = getLenStr(INDEX_4, 通知書定型文List);
        source.tsuchibunMixtwo15 = getLenStr(INDEX_5, 通知書定型文List);
        source.tsuchibunMixtwo16 = getLenStr(INDEX_6, 通知書定型文List);
        source.tsuchibunMixtwo17 = getLenStr(INDEX_7, 通知書定型文List);
        source.tsuchibunMixtwo18 = getLenStr(INDEX_8, 通知書定型文List);
        source.tsuchibunMixtwo19 = getLenStr(INDEX_9, 通知書定型文List);
        source.tsuchibunMixtwo20 = getLenStr(INDEX_10, 通知書定型文List);
        source.tsuchibunMixtwo21 = getLenStr(INDEX_11, 通知書定型文List);
        source.tsuchibunMixtwo22 = getLenStr(INDEX_12, 通知書定型文List);
    }

    private RString getLenStr(int i, List<RString> 通知書定型文List) {
        if (通知書定型文List.size() >= i + 1) {
            return 通知書定型文List.get(i);
        } else {
            return RString.EMPTY;
        }
    }

    private void setCompNinshosha(HomKaigRiysFutgGengKettTsuchishoReportSource source, HomKaigRiysFutgGengKettTsuchishoItem item) {
        source.denshiKoin = item.getNinshoshaSource().denshiKoin;
        source.hakkoYMD = item.getNinshoshaSource().hakkoYMD;
        source.ninshoshaYakushokuMei1 = item.getNinshoshaSource().ninshoshaYakushokuMei1;
        source.koinMojiretsu = item.getNinshoshaSource().koinMojiretsu;
        source.ninshoshaYakushokuMei2 = item.getNinshoshaSource().ninshoshaYakushokuMei2;
        source.ninshoshaShimeiKakenai = item.getNinshoshaSource().ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = item.getNinshoshaSource().ninshoshaShimeiKakeru;
        source.koinShoryaku = item.getNinshoshaSource().koinShoryaku;
    }

    private void setCompSofubutsuAtesaki(HomKaigRiysFutgGengKettTsuchishoReportSource source, HomKaigRiysFutgGengKettTsuchishoItem item) {
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = JushoHenshu.create編集後宛先(
                    item.getIAtesaki(), item.get地方公共団体(), item.get帳票制御共通()).getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        }
        source.yubinNo = sofubutsuAtesakiSource.yubinNo;
        source.gyoseiku1 = sofubutsuAtesakiSource.gyoseiku;
        // source.jusho4 = sofubutsuAtesakiSource.j;
        source.jushoText = sofubutsuAtesakiSource.jushoText;
        // source.jusho5 = RString.EMPTY;
        // source.jusho6 = RString.EMPTY;
        source.katagakiText = sofubutsuAtesakiSource.katagakiText;
        // source.katagaki3 = RString.EMPTY;
        source.katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
        // source.katagaki4 = RString.EMPTY;
        source.katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
        // source.shimei3 = RString.EMPTY;
        source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        source.shimeiText = sofubutsuAtesakiSource.shimeiText;
        source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
        source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        // source.shimei4 = RString.EMPTY;
        source.meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
        source.samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
        source.samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
        source.samaBun2 = sofubutsuAtesakiSource.samaBun2;
        source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        source.samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
        source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        source.samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
        source.samaBun1 = sofubutsuAtesakiSource.samaBun1;
        source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        source.samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
        source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
    }

    private static EditedKojin getEditedKojin(IKojin kojin, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体) {
        return new EditedKojin(kojin, 帳票制御共通, 地方公共団体);
    }
}
