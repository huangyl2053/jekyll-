/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100009;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100009.RiysFutgGengMenjKettTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担額減額･免除認定決定通知書ボディEditorです。
 *
 * @reamsid_L DBD-3540-070 wangchao
 */
public class RiysFutgGengMenjKettTsuchishoBodyEditor implements IRiysFutgGengMenjKettTsuchishoEditor {

    private final RString 折り返す符号 = new RString("\r\n");
    private final RString マル = new RString("○");
    private final RString 通知文 = new RString("tsuchibun");
    private final RString 通知文Large = new RString("tsuchibunLarge");
    private final RString 通知文混在 = new RString("tsuchibunMix");
    private final RString 通知文混在２ = new RString("tsuchibunMixtwo");

    private final RiysFutgGengMenjKettTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 利用者負担額減額･免除認定決定通知書
     */
    public RiysFutgGengMenjKettTsuchishoBodyEditor(RiysFutgGengMenjKettTsuchishoItem item) {
        this.item = item;
    }

    /**
     * 利用者負担額減額･免除認定決定通知書ボディEditorです。
     *
     * @param source 利用者負担額減額･免除認定決定通知書Source
     * @return 利用者負担額減額･免除認定決定通知書Source
     */
    @Override
    public RiysFutgGengMenjKettTsuchishoReportSource edit(RiysFutgGengMenjKettTsuchishoReportSource source) {
        return bodyEdit(source);
    }

    private RiysFutgGengMenjKettTsuchishoReportSource bodyEdit(RiysFutgGengMenjKettTsuchishoReportSource source) {
        source.bunshoNo = item.get文書番号();

        setTitle(source, item);
        set通知書定型文(source, 1, item, 通知文);

        EditedKojin 編集後個人 = getEditedKojin(item.getIKojin(), item.get帳票制御共通());
        source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        source.hihokenshaNo1 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(0, 1);
        source.hihokenshaNo2 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(1, 2);
        source.hihokenshaNo3 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(2, 3);
        source.hihokenshaNo4 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(3, 4);
        source.hihokenshaNo5 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(4, 5);
        source.hihokenshaNo6 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(5, 6);
        source.hihokenshaNo7 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(6, 7);
        source.hihokenshaNo8 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(7, 8);
        source.hihokenshaNo9 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(8, 9);
        source.hihokenshaNo10 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(9, 10);
        source.ketteiYMD = item.get利用者負担額減額情報().get決定年月日().wareki().toDateString();

        if (KetteiKubun.承認する.getコード().equals(item.get利用者負担額減額情報().get決定区分())) {
            source.tekiyoYMD = item.get利用者負担額減額情報().get適用開始年月日().wareki().toDateString();
            source.ninteiKekka1 = new RString("（承認内容）");
            source.shoninSuru = マル;
            source.yukoYMD = item.get利用者負担額減額情報().get適用終了年月日().wareki().toDateString();
            source.ninteiKekka3
                    = new RString("□□□給付率".concat(item.get利用者負担額減額情報().get給付率().getColumnValue().toString().concat("□/□100")));
            source.shoninShinai = RString.EMPTY;
            source.riyu1 = RString.EMPTY;
            source.riyu2 = RString.EMPTY;
            source.riyu3 = RString.EMPTY;
            source.riyu4 = RString.EMPTY;
            source.riyu5 = RString.EMPTY;
        } else {
            source.tekiyoYMD = RString.EMPTY;
            source.ninteiKekka1 = RString.EMPTY;
            source.shoninSuru = RString.EMPTY;
            source.yukoYMD = RString.EMPTY;
            source.ninteiKekka3 = RString.EMPTY;
            source.shoninShinai = マル;
            source.riyu1 = item.get利用者負担額減額情報().get非承認理由();
            // source.riyu2 = RString.EMPTY;
            // source.riyu3 = RString.EMPTY;
            // source.riyu4 = RString.EMPTY;
            // source.riyu5 = RString.EMPTY;
        }

        source.ninteiKekka2 = RString.EMPTY;
        source.ninteiKekka4 = RString.EMPTY;
        source.ninteiKekka5 = RString.EMPTY;
        source.ninteiKekka6 = RString.EMPTY;
        source.ninteiKekka7 = RString.EMPTY;
        source.ninteiKekka8 = RString.EMPTY;
        source.ninteiKekka9 = RString.EMPTY;

        if (TeikeibunMojiSize.フォント小.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
            set通知書定型文(source, 2, item, 通知文);
        }

        if (TeikeibunMojiSize.フォント大.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
            set通知書定型文(source, 2, item, 通知文Large);

        }
        if (TeikeibunMojiSize.フォント上小下大.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
            set通知書定型文(source, 2, item, 通知文混在);
            set通知書定型文(source, 3, item, 通知文混在);
        }
        if (TeikeibunMojiSize.フォント上大下小.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
            set通知書定型文(source, 2, item, 通知文混在２);
            set通知書定型文(source, 3, item, 通知文混在２);
        }
        setCompNinshosha(source, item);
        setCompSofubutsuAtesaki(source, item);

        source.shikibetsuCode = item.getIKojin().get識別コード().getColumnValue();
        source.hihokenshaNo = item.get利用者負担額減額情報().get被保険者番号().getColumnValue();
        return source;
    }

    private RiysFutgGengMenjKettTsuchishoReportSource setTitle(RiysFutgGengMenjKettTsuchishoReportSource source,
            RiysFutgGengMenjKettTsuchishoItem item) {
        if (item.get利用者負担額減額情報().is旧措置者有無()) {
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100009.帳票タイトル_上段_旧措置者用.name()).equals(entity.getKomokuName())) {
                    source.title1 = entity.getKomokuValue();
                    break;
                }
            }
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100009.帳票タイトル__旧措置者用.name()).equals(entity.getKomokuName())) {
                    source.title2 = entity.getKomokuValue();
                    break;
                }
            }

        } else {
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100009.帳票タイトル_上段.name()).equals(entity.getKomokuName())) {
                    source.title1 = entity.getKomokuValue();
                    break;
                }
            }
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100009.帳票タイトル_下段.name()).equals(entity.getKomokuName())) {
                    source.title2 = entity.getKomokuValue();
                    break;
                }
            }

        }
        return source;
    }

    private RiysFutgGengMenjKettTsuchishoReportSource set通知書定型文(RiysFutgGengMenjKettTsuchishoReportSource source,
            int index, RiysFutgGengMenjKettTsuchishoItem item, RString taisyou) {
        List<RString> 通知書定型文List = item.get通知書定型文List().get(index).split(折り返す符号.toString());
        Class reportSource = source.getClass();
        for (int i = 0; i <= 通知書定型文List.size(); i++) {
            try {
                if (index == 1) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + 1))).set(source, 通知書定型文List.get(i));
                    if (i == 1) {
                        break;
                    }
                } else if (index == 2 && (通知文).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + 2))).set(source, 通知書定型文List.get(i + 2));
                } else if ((通知文Large).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + 3))).set(source, 通知書定型文List.get(i + 2));
                } else if (index == 2 && (通知文混在).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + 3))).set(source, 通知書定型文List.get(i + 2));
                    if (i == 12) {
                        break;
                    }
                } else if (index == 3 && (通知文混在).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + 16))).set(source, 通知書定型文List.get(i + 15));
                } else if (index == 2 && (通知文混在２).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + 3))).set(source, 通知書定型文List.get(i + 2));
                    if (i == 6) {
                        break;
                    }
                } else if (index == 3 && (通知文混在２).equals(taisyou)) {
                    reportSource.getDeclaredField(taisyou.toString().concat(String.valueOf(i + 10))).set(source, 通知書定型文List.get(i + 9));
                }
            } catch (IllegalAccessException | NoSuchFieldException ex) {
                break;
            }
        }
        return source;
    }

    private RiysFutgGengMenjKettTsuchishoReportSource setCompNinshosha(RiysFutgGengMenjKettTsuchishoReportSource source,
            RiysFutgGengMenjKettTsuchishoItem item) {
        source.denshiKoin = getCompNinshosha(item).denshiKoin;
        source.hakkoYMD = getCompNinshosha(item).hakkoYMD;
        source.ninshoshaYakushokuMei1 = getCompNinshosha(item).ninshoshaYakushokuMei1;
        source.koinMojiretsu = getCompNinshosha(item).koinMojiretsu;
        source.ninshoshaYakushokuMei2 = getCompNinshosha(item).ninshoshaYakushokuMei2;
        source.ninshoshaShimeiKakenai = getCompNinshosha(item).ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = getCompNinshosha(item).ninshoshaShimeiKakeru;
        source.koinShoryaku = getCompNinshosha(item).koinShoryaku;
        return source;
    }

    private RiysFutgGengMenjKettTsuchishoReportSource setCompSofubutsuAtesaki(
            RiysFutgGengMenjKettTsuchishoReportSource source, RiysFutgGengMenjKettTsuchishoItem item) {
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = item.get編集後宛先().getSofubutsuAtesakiSource().get送付物宛先ソース();
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
        return source;
    }

    private static EditedKojin getEditedKojin(IKojin kojin, ChohyoSeigyoKyotsu 帳票制御共通) {
        return new EditedKojin(kojin, 帳票制御共通);
    }

    private static NinshoshaSource getCompNinshosha(RiysFutgGengMenjKettTsuchishoItem item) {
        return NinshoshaSourceBuilderFactory.createInstance(
                item.get認証者(), item.get地方公共団体(), item.getイメージファイルパス(), item.get発行日()).buildSource();
    }
}
