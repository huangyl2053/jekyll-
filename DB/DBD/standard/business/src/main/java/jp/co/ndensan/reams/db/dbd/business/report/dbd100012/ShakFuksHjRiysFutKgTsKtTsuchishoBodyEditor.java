/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100012;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100012.ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 社会福祉法人等利用者負担軽減対象決定通知書ボディEditorです。
 *
 * @reamsid_L DBD-3540-110 wangchao
 */
public class ShakFuksHjRiysFutKgTsKtTsuchishoBodyEditor implements IShakFuksHjRiysFutKgTsKtTsuchishoEditor {

    private final RString 折り返す符号 = new RString("\r\n");
    private final RString 決定区分_承認 = new RString("○");
    private final RString 通知文 = new RString("tsuchibun");
    private final RString 通知文Large = new RString("tsuchibunLarge");
    private final RString 通知文混在 = new RString("tsuchibunMix");
    private final RString 通知文混在２ = new RString("tsuchibunMixtwo");
    private final static int INDEX_0 = 0;
    private final static int INDEX_1 = 1;
    private final static int INDEX_2 = 2;
    private final static int INDEX_3 = 3;
    private final static int INDEX_4 = 4;
    private final static int INDEX_5 = 5;
    private final static int INDEX_6 = 6;
    private final static int INDEX_7 = 7;
    private final static int INDEX_8 = 8;
    private final static int INDEX_9 = 9;
    private final static int INDEX_10 = 10;
    private final static int INDEX_11 = 11;
    private final static int INDEX_14 = 14;
    private final static int INDEX_15 = 15;
    private final ShakFuksHjRiysFutKgTsKtTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 社会福祉法人等利用者負担軽減対象決定通知書
     */
    public ShakFuksHjRiysFutKgTsKtTsuchishoBodyEditor(ShakFuksHjRiysFutKgTsKtTsuchishoItem item) {
        this.item = item;
    }

    /**
     * 社会福祉法人等利用者負担軽減対象決定通知書ボディEditorです。
     *
     * @param source 社会福祉法人等利用者負担軽減対象決定通知書Source
     * @return 社会福祉法人等利用者負担軽減対象決定通知書Source
     */
    @Override
    public ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource edit(ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource source) {
        return bodyEdit(source);
    }

    private ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource bodyEdit(ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource source) {

        source.bunshoNo = item.get文書番号();
        source.title1 = new RString("社会福祉法人等利用者負担軽減対象決定通知書");
        source.title2 = new RString("（社会福祉法人等による利用者負担の減免措置）");
        set通知書定型文(source, 1, item, 通知文);

        EditedKojin 編集後個人 = getEditedKojin(item.getIKojin(), item.get帳票制御共通());
        source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        source.hihokenshaNo1 = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue().substring(INDEX_0, INDEX_1);
        source.hihokenshaNo2 = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue().substring(INDEX_1, INDEX_2);
        source.hihokenshaNo3 = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue().substring(INDEX_2, INDEX_3);
        source.hihokenshaNo4 = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue().substring(INDEX_3, INDEX_4);
        source.hihokenshaNo5 = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue().substring(INDEX_4, INDEX_5);
        source.hihokenshaNo6 = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue().substring(INDEX_5, INDEX_6);
        source.hihokenshaNo7 = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue().substring(INDEX_6, INDEX_7);
        source.hihokenshaNo8 = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue().substring(INDEX_7, INDEX_8);
        source.hihokenshaNo9 = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue().substring(INDEX_8, INDEX_9);
        source.hihokenshaNo10 = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue().substring(INDEX_9, INDEX_10);
        source.ketteiYMD = item.get社会福祉法人等利用者負担軽減().get決定年月日().wareki().toDateString();

        source.ninteiKekka4 = RString.EMPTY;
        source.ninteiKekka5 = RString.EMPTY;
        source.ninteiKekka6 = RString.EMPTY;
        source.ninteiKekka7 = RString.EMPTY;

        if (KetteiKubun.承認する.getコード().equals(item.get社会福祉法人等利用者負担軽減().get決定区分())) {
            source.ninteiKekka1 = new RString("（承認内容）");
            source.tekiyoYMD = item.get社会福祉法人等利用者負担軽減().get適用開始年月日().wareki().toDateString();
            source.shoninSuru = 決定区分_承認;
            source.ninteiKekka2 = new RString(item.get社会福祉法人等利用者負担軽減().get軽減率_分子().toString().concat("/0").concat(
                    item.get社会福祉法人等利用者負担軽減().get軽減率_分母().toString()));
            source.yukoYMD = item.get社会福祉法人等利用者負担軽減().get適用終了年月日().wareki().toDateString();
            source.ninteiKekka3 = new RString("居住費．食費のみ");
            source.kakuninNoTitle = new RString("確　認　番　号");
            source.kakuninNo1 = item.get社会福祉法人等利用者負担軽減().get確認番号().substring(INDEX_0, INDEX_1);
            source.kakuninNo2 = item.get社会福祉法人等利用者負担軽減().get確認番号().substring(INDEX_1, INDEX_2);
            source.kakuninNo3 = item.get社会福祉法人等利用者負担軽減().get確認番号().substring(INDEX_2, INDEX_3);
            source.kakuninNo4 = item.get社会福祉法人等利用者負担軽減().get確認番号().substring(INDEX_3, INDEX_4);
            source.kakuninNo5 = item.get社会福祉法人等利用者負担軽減().get確認番号().substring(INDEX_4, INDEX_5);
            source.kakuninNo6 = item.get社会福祉法人等利用者負担軽減().get確認番号().substring(INDEX_5, INDEX_6);
            source.kakuninNo7 = item.get社会福祉法人等利用者負担軽減().get確認番号().substring(INDEX_6, INDEX_7);
            source.kakuninNo8 = item.get社会福祉法人等利用者負担軽減().get確認番号().substring(INDEX_7, INDEX_8);
            source.kakuninNo9 = item.get社会福祉法人等利用者負担軽減().get確認番号().substring(INDEX_8, INDEX_9);
            source.kakuninNo10 = item.get社会福祉法人等利用者負担軽減().get確認番号().substring(INDEX_9, INDEX_10);

            source.shoninNg = RString.EMPTY;
            source.riyu1 = RString.EMPTY;
            source.riyu2 = RString.EMPTY;
            source.riyu3 = RString.EMPTY;
            source.riyu4 = RString.EMPTY;
            source.riyu5 = RString.EMPTY;
        } else {
            source.ninteiKekka1 = RString.EMPTY;
            source.tekiyoYMD = RString.EMPTY;
            source.shoninSuru = RString.EMPTY;
            source.ninteiKekka2 = RString.EMPTY;
            source.yukoYMD = RString.EMPTY;
            source.ninteiKekka3 = RString.EMPTY;
            source.kakuninNoTitle = RString.EMPTY;

            source.kakuninNo1 = RString.EMPTY;
            source.kakuninNo2 = RString.EMPTY;
            source.kakuninNo3 = RString.EMPTY;
            source.kakuninNo4 = RString.EMPTY;
            source.kakuninNo5 = RString.EMPTY;
            source.kakuninNo6 = RString.EMPTY;
            source.kakuninNo7 = RString.EMPTY;
            source.kakuninNo8 = RString.EMPTY;
            source.kakuninNo9 = RString.EMPTY;
            source.kakuninNo10 = RString.EMPTY;

            source.shoninNg = 決定区分_承認;
            source.riyu1 = item.get社会福祉法人等利用者負担軽減().get非承認理由();
            // source.riyu2 = RString.EMPTY;
            // source.riyu3 = RString.EMPTY;
            // source.riyu4 = RString.EMPTY;
            // source.riyu5 = RString.EMPTY;

            if (TeikeibunMojiSize.フォント小.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
                set通知書定型文(source, INDEX_2, item, 通知文);
            }

            if (TeikeibunMojiSize.フォント大.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
                set通知書定型文(source, INDEX_2, item, 通知文Large);

            }
            if (TeikeibunMojiSize.フォント上小下大.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
                set通知書定型文(source, INDEX_2, item, 通知文混在);
                set通知書定型文(source, INDEX_3, item, 通知文混在);
            }
            if (TeikeibunMojiSize.フォント上大下小.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
                set通知書定型文(source, INDEX_2, item, 通知文混在２);
                set通知書定型文(source, INDEX_3, item, 通知文混在２);
            }
            setCompNinshosha(source, item);
            setCompSofubutsuAtesaki(source, item);

            source.shikibetsuCode = item.getIKojin().get識別コード().getColumnValue();
            source.hihokenshaNo = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue();
        }
        return source;
    }

    private void set通知書定型文(ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource source, int index, ShakFuksHjRiysFutKgTsKtTsuchishoItem item,
            RString taisyou) {
        List<RString> 通知書定型文List = item.get通知書定型文List().get(index).split(折り返す符号.toString());
        Class reportSource = source.getClass();
        for (int i = 0; i <= 通知書定型文List.size(); i++) {
            try {
                if (index == INDEX_2) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + INDEX_1))).set(source, 通知書定型文List.get(i));
                    if (i == INDEX_1) {
                        break;
                    }
                } else if (index == INDEX_3 && (通知文).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + INDEX_2))).set(source, 通知書定型文List.get(i + INDEX_2));
                } else if ((通知文Large).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + INDEX_3))).set(source, 通知書定型文List.get(i + INDEX_2));
                } else if (index == INDEX_3 && (通知文混在).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + INDEX_3))).set(source, 通知書定型文List.get(i + INDEX_2));
                    if (i == INDEX_11) {
                        break;
                    }
                } else if (index == INDEX_4 && (通知文混在).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + INDEX_15))).set(source, 通知書定型文List.get(i + INDEX_14));
                } else if (index == INDEX_3 && (通知文混在２).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + INDEX_3))).set(source, 通知書定型文List.get(i + INDEX_2));
                    if (i == 6) {
                        break;
                    }
                } else if (index == INDEX_4 && (通知文混在２).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + INDEX_10))).set(source, 通知書定型文List.get(i + INDEX_9));
                }
            } catch (IllegalAccessException | NoSuchFieldException ex) {
                break;
            }
        }
    }

    private void setCompNinshosha(ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource source, ShakFuksHjRiysFutKgTsKtTsuchishoItem item) {
        source.denshiKoin = item.getNinshoshaSource().denshiKoin;
        source.hakkoYMD = item.getNinshoshaSource().hakkoYMD;
        source.ninshoshaYakushokuMei1 = item.getNinshoshaSource().ninshoshaYakushokuMei1;
        source.koinMojiretsu = item.getNinshoshaSource().koinMojiretsu;
        source.ninshoshaYakushokuMei2 = item.getNinshoshaSource().ninshoshaYakushokuMei2;
        source.ninshoshaShimeiKakenai = item.getNinshoshaSource().ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = item.getNinshoshaSource().ninshoshaShimeiKakeru;
        source.koinShoryaku = item.getNinshoshaSource().koinShoryaku;
    }

    private void setCompSofubutsuAtesaki(ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource source, ShakFuksHjRiysFutKgTsKtTsuchishoItem item) {
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

    private static EditedKojin getEditedKojin(IKojin kojin, ChohyoSeigyoKyotsu 帳票制御共通) {
        return new EditedKojin(kojin, 帳票制御共通);
    }
}
