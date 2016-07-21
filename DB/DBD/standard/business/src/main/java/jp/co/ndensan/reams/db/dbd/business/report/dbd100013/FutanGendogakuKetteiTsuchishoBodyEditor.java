/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100013;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100013.FutanGendogakuKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 負担限度額決定通知書ボディEditorです。
 *
 * @reamsid_L DBD-3540-050 wangchao
 */
public class FutanGendogakuKetteiTsuchishoBodyEditor implements IFutanGendogakuKetteiTsuchishoEditor {

    private final RString 折り返す符号 = new RString("\r\n");
    private final RString 金額単位 = new RString("円");
    private final RString 決定区分_承認 = new RString("○");
    private final RString ハイフン = new RString("-");
    private final RString 通知文 = new RString("tsuchibun");
    private final RString 通知文Large = new RString("tsuchibunLarge");
    private final RString 通知文混在 = new RString("tsuchibunMix");
    private final RString 通知文混在２ = new RString("tsuchibunMixtwo");
    private final RString 負担名_居住費負担限度額多床室 = new RString("居住費負担限度額多床室");
    private final RString 負担名_食費負担限度額 = new RString("食費負担限度額");
    private final RString 負担名_居住費負担限度額ユニット型個室 = new RString("居住費負担限度額ユニット型個室");
    private final RString 負担名_居住費負担限度額ユニット型準個室 = new RString("居住費負担限度額ユニット型準個室");
    private final RString 負担名_居住費負担限度額従来型個室 = new RString("居住費負担限度額従来型個室");
    private final RString 負担名_居住費負担限度額従来型個室_特養等 = new RString("居住費負担限度額従来型個室（特養等）");
    private final RString 負担名_居住費負担限度額従来型個室_老健_療養等 = new RString("居住費負担限度額従来型個室（老健・療養等）");
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
    private final FutanGendogakuKetteiTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 負担限度額決定通知書
     */
    public FutanGendogakuKetteiTsuchishoBodyEditor(FutanGendogakuKetteiTsuchishoItem item) {
        this.item = item;
    }

    /**
     * 負担限度額決定通知書ボディEditorです。
     *
     * @param source 負担限度額決定通知書Source
     * @return 負担限度額決定通知書Source
     */
    @Override
    public FutanGendogakuKetteiTsuchishoReportSource edit(FutanGendogakuKetteiTsuchishoReportSource source) {
        return bodyEdit(source);
    }

    private FutanGendogakuKetteiTsuchishoReportSource bodyEdit(FutanGendogakuKetteiTsuchishoReportSource source) {
        source.bunshoNo = item.get文書番号();

        setTitle(source, item);

        EditedKojin 編集後個人 = getEditedKojin(item.getIKojin(), item.get帳票制御共通());
        source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        source.hihokenshaNo1 = item.get負担限度額認定().get被保険者番号().getColumnValue().substring(INDEX_0, INDEX_1);
        source.hihokenshaNo2 = item.get負担限度額認定().get被保険者番号().getColumnValue().substring(INDEX_1, INDEX_2);
        source.hihokenshaNo3 = item.get負担限度額認定().get被保険者番号().getColumnValue().substring(INDEX_2, INDEX_3);
        source.hihokenshaNo4 = item.get負担限度額認定().get被保険者番号().getColumnValue().substring(INDEX_3, INDEX_4);
        source.hihokenshaNo5 = item.get負担限度額認定().get被保険者番号().getColumnValue().substring(INDEX_4, INDEX_5);
        source.hihokenshaNo6 = item.get負担限度額認定().get被保険者番号().getColumnValue().substring(INDEX_5, INDEX_6);
        source.hihokenshaNo7 = item.get負担限度額認定().get被保険者番号().getColumnValue().substring(INDEX_6, INDEX_7);
        source.hihokenshaNo8 = item.get負担限度額認定().get被保険者番号().getColumnValue().substring(INDEX_7, INDEX_8);
        source.hihokenshaNo9 = item.get負担限度額認定().get被保険者番号().getColumnValue().substring(INDEX_8, INDEX_9);
        source.hihokenshaNo10 = item.get負担限度額認定().get被保険者番号().getColumnValue().substring(INDEX_9, INDEX_10);
        source.ketteiYMD = item.get負担限度額認定().get決定年月日().wareki().toDateString();
        source.ninteiKekka1 = RString.EMPTY;
        source.ninteiKekka2 = RString.EMPTY;

        if (KetteiKubun.承認する.getコード().equals(item.get負担限度額認定().get決定区分())) {
            source.tekiyoYMD = item.get負担限度額認定().get適用開始年月日().wareki().toDateString();
            source.ninteiKekka3 = new RString("（承認内容）");
            source.shoninSuru = 決定区分_承認;
            source.yukoYMD = item.get負担限度額認定().get適用終了年月日().wareki().toDateString();

            source.futanName1 = 負担名_食費負担限度額;
            source.futanName2 = 負担名_居住費負担限度額ユニット型個室;
            source.futanName3 = 負担名_居住費負担限度額ユニット型準個室;
            if (KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())
                    || KyuSochishaKubun.旧措置者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
                source.futanName4 = 負担名_居住費負担限度額従来型個室;
                source.futanName5 = 負担名_居住費負担限度額多床室;
                source.futanName6 = RString.EMPTY;
            } else {
                source.futanName4 = 負担名_居住費負担限度額従来型個室_特養等;
                source.futanName5 = 負担名_居住費負担限度額従来型個室_老健_療養等;
                source.futanName6 = 負担名_居住費負担限度額多床室;
            }

            setFutanGaku(source, item);

            source.futanEn1 = 金額単位;
            source.futanEn2 = 金額単位;
            source.futanEn3 = 金額単位;
            source.futanEn4 = 金額単位;
            source.futanEn5 = 金額単位;
            source.futanEn6 = 金額単位;

            source.shoninsinai = RString.EMPTY;
            source.riyu1 = RString.EMPTY;
            source.riyu2 = RString.EMPTY;
            source.riyu3 = RString.EMPTY;
            source.riyu4 = RString.EMPTY;
            source.riyu5 = RString.EMPTY;
        } else {
            承認しない(source, item);
        }

        if (TeikeibunMojiSize.フォント大.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
            set通知書定型文(source, INDEX_3, item, 通知文Large);

        }
        if (TeikeibunMojiSize.フォント上小下大.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
            set通知書定型文(source, INDEX_3, item, 通知文混在);
            set通知書定型文(source, INDEX_4, item, 通知文混在);
        }
        if (TeikeibunMojiSize.フォント上大下小.getコード().equals(item.get帳票制御共通().get定型文文字サイズ())) {
            set通知書定型文(source, INDEX_3, item, 通知文混在２);
            set通知書定型文(source, INDEX_4, item, 通知文混在２);
        }

        setCompNinshosha(source, item);
        setCompSofubutsuAtesaki(source, item);

        source.shikibetsuCode = new RString(item.getIKojin().get識別コード().toString());
        source.hihokenshaNo = new RString(item.get負担限度額認定().get被保険者番号().toString());
        return source;
    }

    private void setTitle(FutanGendogakuKetteiTsuchishoReportSource source, FutanGendogakuKetteiTsuchishoItem item) {
        if (KyuSochishaKubun.旧措置者.getコード().equals(item.get負担限度額認定().get旧措置者区分())
                || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100013.帳票タイトル_上段_旧措置者用.name()).equals(entity.getKomokuName())) {
                    source.title1 = entity.getKomokuValue();
                    break;
                }
            }
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100013.帳票タイトル_旧措置者用.name()).equals(entity.getKomokuName())) {
                    source.title2 = entity.getKomokuValue();
                    break;
                }
            }

            set通知書定型文(source, INDEX_2, item, 通知文);
        } else {
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100013.帳票タイトル_上段.name()).equals(entity.getKomokuName())) {
                    source.title1 = entity.getKomokuValue();
                    break;
                }
            }
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100013.帳票タイトル_下段.name()).equals(entity.getKomokuName())) {
                    source.title2 = entity.getKomokuValue();
                    break;
                }
            }
            set通知書定型文(source, INDEX_1, item, 通知文);
        }
    }

    private void set通知書定型文(FutanGendogakuKetteiTsuchishoReportSource source, int index, FutanGendogakuKetteiTsuchishoItem item,
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
                    if (i == INDEX_6) {
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

    private void setFutanGaku(FutanGendogakuKetteiTsuchishoReportSource source, FutanGendogakuKetteiTsuchishoItem item) {
        if ((item.get負担限度額認定().get食費負担限度額() != Decimal.ZERO) && (item.get負担限度額認定().get食費負担限度額() != null)) {
            source.futanGaku1 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().get食費負担限度額(), 0);
        } else if (item.get負担限度額認定().is境界層該当者区分()) {
            source.futanGaku1 = ハイフン;
        } else {
            source.futanGaku1 = RString.EMPTY;
        }

        if ((item.get負担限度額認定().getユニット型個室() != Decimal.ZERO) && (item.get負担限度額認定().getユニット型個室() != null)) {
            source.futanGaku2 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().getユニット型個室(), 0);
        } else if (item.get負担限度額認定().is境界層該当者区分()
                || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
            source.futanGaku2 = ハイフン;
        } else {
            source.futanGaku2 = RString.EMPTY;
        }

        if ((item.get負担限度額認定().getユニット型準個室() != Decimal.ZERO) && (item.get負担限度額認定().getユニット型準個室() != null)) {
            source.futanGaku3 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().getユニット型準個室(), 0);
        } else if (item.get負担限度額認定().is境界層該当者区分()
                || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
            source.futanGaku3 = ハイフン;
        } else {
            source.futanGaku3 = RString.EMPTY;
        }

        if ((item.get負担限度額認定().get従来型個室_特養等() != Decimal.ZERO) && (item.get負担限度額認定().get従来型個室_特養等() != null)) {
            source.futanGaku4 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().get従来型個室_特養等(), 0);
        } else if (item.get負担限度額認定().is境界層該当者区分()
                || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
            source.futanGaku4 = ハイフン;
        } else {
            source.futanGaku4 = RString.EMPTY;
        }

        if ((item.get負担限度額認定().get多床室() != Decimal.ZERO) && (item.get負担限度額認定().get多床室() != null)) {
            source.futanGaku5 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().get多床室(), 0);
        } else if ((item.get負担限度額認定().get従来型個室_老健_療養等() != Decimal.ZERO)
                && (item.get負担限度額認定().get従来型個室_老健_療養等() != null)) {
            source.futanGaku5 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().get従来型個室_老健_療養等(), 0);
        } else if (item.get負担限度額認定().is境界層該当者区分()
                || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
            source.futanGaku5 = ハイフン;
        } else {
            source.futanGaku5 = RString.EMPTY;
        }

        if (KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())
                || KyuSochishaKubun.旧措置者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
            source.futanGaku6 = RString.EMPTY;
        } else if ((item.get負担限度額認定().get多床室() != Decimal.ZERO) && (item.get負担限度額認定().get多床室() != null)) {
            source.futanGaku6 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().get多床室(), 0);
        } else if (item.get負担限度額認定().is境界層該当者区分()
                || !(KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())
                || KyuSochishaKubun.旧措置者.getコード().equals(item.get負担限度額認定().get旧措置者区分()))) {
            source.futanGaku6 = ハイフン;
        } else {
            source.futanGaku6 = RString.EMPTY;
        }
    }

    private void 承認しない(FutanGendogakuKetteiTsuchishoReportSource source, FutanGendogakuKetteiTsuchishoItem item) {
        source.tekiyoYMD = RString.EMPTY;
        source.ninteiKekka3 = RString.EMPTY;
        source.shoninSuru = RString.EMPTY;
        source.yukoYMD = RString.EMPTY;
        source.futanName1 = RString.EMPTY;
        source.futanGaku1 = RString.EMPTY;
        source.futanEn1 = RString.EMPTY;
        source.futanGaku2 = RString.EMPTY;
        source.futanEn2 = RString.EMPTY;
        source.futanName3 = RString.EMPTY;
        source.futanGaku3 = RString.EMPTY;
        source.futanEn3 = RString.EMPTY;
        source.futanName4 = RString.EMPTY;
        source.futanGaku3 = RString.EMPTY;
        source.futanEn4 = RString.EMPTY;
        source.futanName4 = RString.EMPTY;
        source.futanGaku5 = RString.EMPTY;
        source.futanEn5 = RString.EMPTY;
        source.futanName6 = RString.EMPTY;
        source.futanGaku6 = RString.EMPTY;
        source.futanEn6 = RString.EMPTY;
        source.shoninsinai = 決定区分_承認;
        List<RString> 非承認理由 = item.get負担限度額認定().get非承認理由().split(折り返す符号.toString());
        Class reportSource = FutanGendogakuKetteiTsuchishoReportSource.class;
        for (int i = 0; i <= 非承認理由.size(); i++) {
            try {
                reportSource.getDeclaredField("riyu".concat(String.valueOf(i + 1))).set(非承認理由.get(i), RString.class);
            } catch (IllegalAccessException | NoSuchFieldException ex) {
                break;
            }
        }
    }

    private void setCompNinshosha(FutanGendogakuKetteiTsuchishoReportSource source, FutanGendogakuKetteiTsuchishoItem item) {
        source.denshiKoin = item.getNinshoshaSource().denshiKoin;
        source.hakkoYMD = item.getNinshoshaSource().hakkoYMD;
        source.ninshoshaYakushokuMei1 = item.getNinshoshaSource().ninshoshaYakushokuMei1;
        source.koinMojiretsu = item.getNinshoshaSource().koinMojiretsu;
        source.ninshoshaYakushokuMei2 = item.getNinshoshaSource().ninshoshaYakushokuMei2;
        source.ninshoshaShimeiKakenai = item.getNinshoshaSource().ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = item.getNinshoshaSource().ninshoshaShimeiKakeru;
        source.koinShoryaku = item.getNinshoshaSource().koinShoryaku;
    }

    private void setCompSofubutsuAtesaki(FutanGendogakuKetteiTsuchishoReportSource source, FutanGendogakuKetteiTsuchishoItem item) {
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
