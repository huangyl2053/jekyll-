/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteitsuchishojuryouininshamuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijiari.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ua.uax.service.core.maskedkoza.MaskedKozaCreator;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還払い支給（不支給）決定通知書（受領委任者向け）のビジネスです。
 *
 * @reamsid_L DBC-1000-040 zuotao
 */
public class ShokanBaraiShikyuKetteiTsuchishoJuryoIninshaMuke {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final int 文字数_38 = 38;
    private static final int 文字数_76 = 76;
    private static final RString カンマ = new RString(",");
    private static final RString 記号_星 = new RString("**************");
    private static final RString 帳票制御汎用キー_持ち物内容文言１ = new RString("持ち物内容文言１");
    private static final RString 帳票制御汎用キー_持ち物内容文言２ = new RString("持ち物内容文言２");
    private static final RString 帳票制御汎用キー_持ち物内容文言３ = new RString("持ち物内容文言３");
    private static final RString KARA = new RString("～");
    private static final RString 帳票制御汎用キー_取り消し線 = new RString("取り消し線");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり１ = new RString("帳票タイトル_抹消線あり１");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり２ = new RString("帳票タイトル_抹消線あり２");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり３ = new RString("帳票タイトル_抹消線あり３");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり４ = new RString("帳票タイトル_抹消線あり４");
    private static final RString 帳票制御汎用キー_帳票タイトル = new RString("帳票タイトル");
    private static final RString 取り消し線を編集しない = new RString("0");
    private static final RString 取り消し線を編集する = new RString("1");
    private static final RString 種別タイトル_口座種別 = new RString("口座種別");
    private static final RString 種別タイトル_店番 = new RString("店番");
    private static final RString 番号タイトル_口座番号 = new RString("口座番号");
    private static final RString 増減の理由タイトル_不支給の理由 = new RString("不支給の理由");
    private static final RString 増減の理由タイトル_増減の理由 = new RString("増減の理由");
    private static final RString 金融機関コード_郵便局 = new RString("9900");
    private static final RString フォント小 = new RString("1");
    private static final RString フォント大 = new RString("2");
    private static final RString フォント混在_上大下小 = new RString("3");
    private static final RString フォント混在_上小下大 = new RString("4");
    private static final RString 更新しない = new RString("1");
    private static final int RSTRING_12 = 12;
    private static final RString 午前 = new RString("午前");
    private static final RString 午後 = new RString("午後");
    private static final KinyuKikanCode ゆうちょ銀行 = new KinyuKikanCode("9900");
    private static final RString 帳票制御汎用キー_ゆうちょ銀行店名表示 = new RString("ゆうちょ銀行店名表示");
    private static final RString 帳票制御汎用キー_口座名義人カナ優先区分 = new RString("口座名義人カナ優先区分");
    private static final RString 印字する = new RString("1");
    private static final RString カナ氏名 = new RString("2");

    /**
     * 帳票データを作成します。
     *
     * @param shiharaiList 償還払支給（不支給）決定通知書情報Entityリスト
     * @param batchPram バッチパラメータ
     * @param reportSourceWriter IReportWriter
     * @param 種類Map 種類Map
     * @param 帳票制御共通情報 帳票制御共通情報
     * @return 償還払支給（不支給）決定通知書（受領委任払い・被保険者用）のITEM
     */
    public List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> getShokanBaraiShikyuKetteiTsuchishoJuryoIninshaMukeData(
            List<ShokanKetteiTsuchiShoShiharai> shiharaiList, ShokanKetteiTsuchiShoSealerBatchParameter batchPram,
            ReportSourceWriter reportSourceWriter, Map<RString, RString> 種類Map, ChohyoSeigyoKyotsu 帳票制御共通情報) {

        return 帳票データ作成(shiharaiList, batchPram, reportSourceWriter, 種類Map, 帳票制御共通情報);
    }

    private List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> 帳票データ作成(List<ShokanKetteiTsuchiShoShiharai> shiharaiList,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, ReportSourceWriter reportSourceWriter, Map<RString, RString> 種類Map,
            ChohyoSeigyoKyotsu 帳票制御共通情報) {

        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(
                SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(), batchPram.getHakkoYMD(),
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);

        List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> 帳票ソースデータ = new ArrayList<>();
        for (ShokanKetteiTsuchiShoShiharai shiharai : shiharaiList) {
            ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item = new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem();
            RString kyufuShu = 種類Map.get(getJufukuKey(shiharai)) == null ? RString.EMPTY : 種類Map.get(getJufukuKey(shiharai));

            item.setBunshoNo(batchPram.get文書番号());
            if (kyufuShu.length() <= 文字数_38) {
                item.setKyufuShu1(kyufuShu);
            } else if (kyufuShu.length() <= 文字数_76) {
                item.setKyufuShu1(kyufuShu.substring(ZERO, 文字数_38));
                item.setKyufuShu2(kyufuShu.substring(文字数_38));
            } else {
                item.setKyufuShu2(kyufuShu.substring(文字数_38, 文字数_76));
                item.setKyufuShu3(kyufuShu.substring(文字数_76));
            }

            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(shiharai.get市町村コード(), FlexibleDate.getNowDate());
            EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(shiharai.get宛先情報(), 地方公共団体, 帳票制御共通情報);
            SofubutsuAtesakiSource 送付物宛先ソースデータ = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();

            item = create帳票ソースデータ(item, ninshoshaSource, shiharai, batchPram, 送付物宛先ソースデータ);
            boolean 金融機関未登録フラグ = false;
            if (ShiharaiHohoKubun.口座払.getコード().equals(shiharai.get支払方法区分コード())
                    && (null == shiharai.get金融機関コード() || shiharai.get金融機関コード().isEmpty())) {
                金融機関未登録フラグ = true;
            }
            if (!RString.isNullOrEmpty(shiharai.get支給不支給決定区分())
                    && ShikyuFushikyuKubun.支給.getコード().equals(shiharai.get支給不支給決定区分())
                    && ShikakuKubun._２号.getコード().equals(shiharai.get被保険者区分コード())) {
                金融機関未登録フラグ = false;
            }
            if (!金融機関未登録フラグ) {
                帳票ソースデータ.add(item);
            }
        }
        return 帳票ソースデータ;
    }

    private RString getJufukuKey(ShokanKetteiTsuchiShoShiharai shiharai) {
        RStringBuilder key = new RStringBuilder();
        key.append(shiharai.get被保険者番号().value());
        key.append(shiharai.get提供年月().wareki().toDateString());
        key.append(shiharai.get整理番号().padLeft(new RString(ZERO), TEN));
        return key.toRString();
    }

    private ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem create帳票ソースデータ(ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item,
            NinshoshaSource ninshoshaSource, ShokanKetteiTsuchiShoShiharai shiharai,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, SofubutsuAtesakiSource atesaki) {

        RString hihokenshaNo = shiharai.get被保険者番号().value().padLeft(RString.HALF_SPACE, TEN);
        item.setHihokenshaName(shiharai.get被保険者氏名());
        item.setHihokenshaNo1(hihokenshaNo.substring(ZERO, ONE));
        item.setHihokenshaNo2(hihokenshaNo.substring(ONE, TWO));
        item.setHihokenshaNo3(hihokenshaNo.substring(TWO, THREE));
        item.setHihokenshaNo4(hihokenshaNo.substring(THREE, FOUR));
        item.setHihokenshaNo5(hihokenshaNo.substring(FOUR, FIVE));
        item.setHihokenshaNo6(hihokenshaNo.substring(FIVE, SIX));
        item.setHihokenshaNo7(hihokenshaNo.substring(SIX, SEVEN));
        item.setHihokenshaNo8(hihokenshaNo.substring(SEVEN, EIGHT));
        item.setHihokenshaNo9(hihokenshaNo.substring(EIGHT, NINE));
        item.setHihokenshaNo10(hihokenshaNo.substring(NINE));
        item.setUketsukeYMD(shiharai.get受付年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        item.setKetteiYMD(shiharai.get決定年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        item.setHonninShiharaiGaku(shiharai.get本人支払額() == null
                ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(shiharai.get本人支払額(), ZERO));
        item.setTaishoYM(shiharai.get提供年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        if (!RString.isNullOrEmpty(shiharai.get支給不支給決定区分())) {
            item.setKekka(ShikyuFushikyuKubun.toValue(shiharai.get支給不支給決定区分()).get名称());
        }
        item.setShikyuGaku(shiharai.get支給額() == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(shiharai.get支給額(), ZERO));
        RString 増減の理由 = shiharai.get増減理由等();
        if (RString.isNullOrEmpty(増減の理由) || 増減の理由.length() <= 文字数_38) {
            item.setRiyu1(増減の理由);
        } else if (増減の理由.length() <= 文字数_76) {
            item.setRiyu1(増減の理由.substring(ZERO, 文字数_38));
            item.setRiyu2(増減の理由.substring(文字数_38));
        } else {
            item.setRiyu1(増減の理由.substring(ZERO, 文字数_38));
            item.setRiyu2(増減の理由.substring(文字数_38, 文字数_76));
            item.setRiyu3(RString.EMPTY);
        }
        if (ShiharaiHohoKubun.窓口払.getコード().equals(shiharai.get支払方法区分コード())) {
            item.setTorikeshi1(RString.EMPTY);
            item.setTorikeshi2(記号_星);

        } else if (ShiharaiHohoKubun.口座払.getコード().equals(shiharai.get支払方法区分コード())) {
            item.setTorikeshi1(記号_星);
            item.setTorikeshi2(RString.EMPTY);
        }
        if (ShikyuFushikyuKubun.不支給.getコード().equals(shiharai.get支給不支給決定区分())) {
            item.setTorikeshi1(記号_星);
            item.setTorikeshi2(記号_星);
        }
        item.setTorikeshiMochimono1(RString.EMPTY);
        item.setTorikeshiMochimono2(RString.EMPTY);
        item.setTorikeshiShiharaibasho(RString.EMPTY);
        item.setTorikeshiShiharaikikan(RString.EMPTY);
        setItem(item, ninshoshaSource, shiharai, batchPram, atesaki);

        return item;
    }

    private void setItem(ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item,
            NinshoshaSource ninshoshaSource, ShokanKetteiTsuchiShoShiharai shiharai,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, SofubutsuAtesakiSource atesaki) {
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        if (ShiharaiHohoKubun.窓口払.getコード().equals(shiharai.get支払方法区分コード())
                && ShikyuFushikyuKubun.支給.getコード().equals(shiharai.get支給不支給決定区分())) {
            item.setMochimono1(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_持ち物内容文言１));
            item.setMochimono2(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_持ち物内容文言２));
            item.setMochimono3(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_持ち物内容文言３));
            if (更新しない.equals(batchPram.get窓口払い一括更新区分())) {
                item.setShiharaiBasho(shiharai.get支払場所());
                item.setShiharaiStartYMD(setFlexibleDateYMD(shiharai.get支払期間開始年月日()));
                item.setShiharaiEndYMD(setFlexibleDateYMD(shiharai.get支払期間終了年月日()));
                item.setShiharaiStartHMS(setDataTimeFomart(shiharai.get支払窓口開始時間()));
                item.setShiharaiEndHMS(setDataTimeFomart(shiharai.get支払窓口終了期間()));
            } else {
                item.setShiharaiBasho(batchPram.getShiharaiBasho());
                item.setShiharaiStartYMD(setDateYMD(batchPram.get支払期間From()));
                item.setShiharaiEndYMD(setDateYMD(batchPram.get支払期間To()));
                item.setShiharaiStartHMS(setDataTimeFomart2(batchPram.get開始時間()));
                item.setShiharaiEndHMS(setDataTimeFomart2(batchPram.get終了時間()));
            }
            if (!RString.isNullOrEmpty(item.getShiharaiStartHMS()) && !RString.isNullOrEmpty(item.getShiharaiEndHMS())) {
                item.setKaraFugo(KARA);
            }
        }

        if (ShiharaiHohoKubun.口座払.getコード().equals(shiharai.get支払方法区分コード())
                && ShikyuFushikyuKubun.支給.getコード().equals(shiharai.get支給不支給決定区分())
                && shiharai.get口座() != null
                && shiharai.get口座().getUaT0310KozaEntity().getKozaId() != 0L) {
            IKoza 口座情報 = do口座マスク編集(shiharai.get口座());

            item.setBankName(口座情報.get金融機関().get金融機関名称());
            item.setKouzaShu(口座情報.get店番());
            if (!ゆうちょ銀行.equals(口座情報.get金融機関コード())) {
                item.setBranchBankName(口座情報.get支店().get支店名称());
                item.setKouzaShu(口座情報.get預金種別名称());
            } else if (印字する.equals(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_ゆうちょ銀行店名表示))) {
                item.setBranchBankName(口座情報.get支店().get支店名称());
            }

            item.setKouzaNo(口座情報.get口座番号());

            if (カナ氏名.equals(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_口座名義人カナ優先区分))) {
                item.setKouzaMeigi(口座情報.get口座名義人().value());
            } else {
                item.setKouzaMeigi(口座情報.get口座名義人漢字().value());
            }
            item.setSihaYoYmd(batchPram.getHurikomiYMD() == null
                    ? RString.EMPTY : batchPram.getHurikomiYMD().wareki().eraType(
                            EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                    Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        item.setSeirino(shiharai.get整理番号());
        item.setTsuchino(shiharai.get決定通知No());
        RString タイトル = RString.EMPTY;
        RString タイトル2_1 = RString.EMPTY;
        RString タイトル2_2_1 = RString.EMPTY;
        RString タイトル2_2_2 = RString.EMPTY;
        RString タイトル2_3_1 = RString.EMPTY;
        RString タイトル2_3_2 = RString.EMPTY;
        RString タイトル2_4 = RString.EMPTY;
        RString 取り消し線 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_取り消し線);
        if (取り消し線を編集しない.equals(取り消し線)) {
            タイトル = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル);
        } else if (取り消し線を編集する.equals(取り消し線)) {
            タイトル2_1 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり１);
            タイトル2_4 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり４);
            if (ShikyuFushikyuKubun.支給.getコード().equals(shiharai.get支給不支給決定区分())) {
                タイトル2_2_1 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり２);
                タイトル2_3_2 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり３);
            } else {
                タイトル2_2_2 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり２);
                タイトル2_3_1 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり３);
            }
        }
        item.setTitle(タイトル);
        item.setTitle2_1(タイトル2_1);
        item.setTitle2_2_1(タイトル2_2_1);
        item.setTitle2_2_2(タイトル2_2_2);
        item.setTitle2_3_1(タイトル2_3_1);
        item.setTitle2_3_2(タイトル2_3_2);
        item.setTitle2_4(タイトル2_4);
        item.setTsuchibun1(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                KamokuCode.EMPTY, ONE, ONE, batchPram.getHakkoYMD()));
        item = set通知文(item, batchPram);
        item.setRemban(RString.EMPTY);
        item = set認証者And宛先(item, ninshoshaSource, atesaki);
        item.setBangoTitle(番号タイトル_口座番号);
        RString 種別タイトル = get種別タイトル(shiharai);
        RString 増減の理由タイトル;
        if (ShikyuFushikyuKubun.不支給.getコード().equals(shiharai.get支給不支給決定区分())) {
            増減の理由タイトル = 増減の理由タイトル_不支給の理由;
        } else {
            増減の理由タイトル = 増減の理由タイトル_増減の理由;
        }
        item.setRiyuTitle(増減の理由タイトル);
        item.setShumokuTitle(種別タイトル);
        item.setBangoTitle(番号タイトル_口座番号);

    }

    private IKoza do口座マスク編集(TokuteiKozaRelateEntity koza) {
        MaskedKozaCreator maskedKozaCreator = MaskedKozaCreator.createInstance(SubGyomuCode.DBC介護給付);
        return maskedKozaCreator.createマスク編集済口座(new Koza(koza));
    }

    private RString get帳票制御汎用(ChohyoSeigyoHanyoManager 帳票制御汎用Manager, RString 項目名) {
        RString 設定値 = RString.EMPTY;
        ChohyoSeigyoHanyo chohyoSeigyoHanyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                FlexibleYear.MIN, 項目名);
        if (chohyoSeigyoHanyo != null) {
            設定値 = chohyoSeigyoHanyo.get設定値();
        }
        return 設定値;
    }

    private RString get種別タイトル(ShokanKetteiTsuchiShoShiharai business) {
        if (ShikyuFushikyuKubun.不支給.getコード().equals(business.get支給不支給決定区分())) {
            return 種別タイトル_口座種別;
        }
        RString 種別タイトル = RString.EMPTY;
        if (ShiharaiHohoKubun.窓口払.getコード().equals(business.get支払方法区分コード())) {
            種別タイトル = 種別タイトル_口座種別;
        } else if (ShiharaiHohoKubun.口座払.getコード().equals(business.get支払方法区分コード())
                && null != business.get金融機関コード()) {
            if (金融機関コード_郵便局.equals(business.get金融機関コード().value())) {
                種別タイトル = 種別タイトル_店番;
            } else {
                種別タイトル = 種別タイトル_口座種別;
            }
        }
        return 種別タイトル;
    }

    private ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem set認証者And宛先(ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item,
            NinshoshaSource ninshoshaSource, SofubutsuAtesakiSource atesaki) {

        item.setHakkoYMD(ninshoshaSource.hakkoYMD);
        item.setDenshiKoin(ninshoshaSource.denshiKoin);
        item.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
        item.setNinshoshaYakushokuMei1(ninshoshaSource.ninshoshaYakushokuMei1);
        item.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
        item.setNinshoshaYakushokuMei2(ninshoshaSource.ninshoshaYakushokuMei2);
        item.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
        item.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
        item.setKoinShoryaku(ninshoshaSource.koinShoryaku);
        item.setYubinNo(atesaki.yubinNo);
        item.setGyoseiku2(atesaki.gyoseiku);
        item.setJusho4(atesaki.jusho1);
        item.setJushoText(atesaki.jushoText);
        item.setJusho5(atesaki.jusho2);
        item.setJusho6(atesaki.jusho3);
        item.setKatagakiText(atesaki.katagakiText);
        item.setKatagaki3(atesaki.katagaki1);
        item.setKatagaki4(atesaki.katagaki2);
        item.setKatagakiSmall2(atesaki.katagakiSmall2);
        item.setKatagakiSmall1(atesaki.katagakiSmall1);
        item.setShimeiSmall2(atesaki.shimeiSmall2);
        item.setShimeiText(atesaki.shimeiText);
        item.setMeishoFuyo2(atesaki.meishoFuyo2);
        item.setShimeiSmall1(atesaki.shimeiSmall1);
        item.setDainoKubunMei(atesaki.dainoKubunMei);
        item.setShimei5(atesaki.shimei1);
        item.setShimei6(atesaki.shimei2);
        item.setMeishoFuyo1(atesaki.meishoFuyo1);
        item.setSamabunShimeiText(atesaki.samabunShimeiText);
        item.setSamaBun2(atesaki.samaBun2);
        item.setKakkoLeft2(atesaki.kakkoLeft2);
        item.setSamabunShimei2(atesaki.samabunShimei2);
        item.setSamabunShimeiSmall2(atesaki.samabunShimeiSmall2);
        item.setKakkoRight2(atesaki.kakkoRight2);
        item.setKakkoLeft1(atesaki.kakkoLeft1);
        item.setSamabunShimei1(atesaki.samabunShimei1);
        item.setSamaBun1(atesaki.samaBun1);
        item.setKakkoRight1(atesaki.kakkoRight1);
        item.setSamabunShimeiSmall1(atesaki.samabunShimeiSmall1);
        item.setCustomerBarCode(atesaki.customerBarCode);
        return item;
    }

    private ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem set通知文(
            ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item, ShokanKetteiTsuchiShoSealerBatchParameter batchPram) {
        RString 定型文文字サイズ = ReportUtil.get定型文文字サイズ(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId());
        if (フォント小.equals(定型文文字サイズ)) {
            item.setTsuchibun２(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, ONE, TWO, batchPram.getHakkoYMD()));
        } else if (フォント大.equals(定型文文字サイズ)) {
            item.setTsuchibunLarge(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, TWO, TWO, batchPram.getHakkoYMD()));
        } else if (フォント混在_上小下大.equals(定型文文字サイズ)) {
            item.setTsuchibunMix1(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, THREE, TWO, batchPram.getHakkoYMD()));
            item.setTsuchibunMix2(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, THREE, THREE, batchPram.getHakkoYMD()));
        } else if (フォント混在_上大下小.equals(定型文文字サイズ)) {
            item.setTsuchibunMixtwo1(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, FOUR, TWO, batchPram.getHakkoYMD()));
            item.setTsuchibunMixtwo2(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, FOUR, THREE, batchPram.getHakkoYMD()));
        }
        item.set定型文文字サイズ(定型文文字サイズ);
        return item;
    }

    private RString setDataTimeFomart(RString time) {
        if (RString.isNullOrEmpty(time)) {
            return RString.EMPTY;
        }
        RTime 支払窓口終了期間 = new RTime(time);
        return setDataTimeFomart2(支払窓口終了期間);
    }

    private RString setDataTimeFomart2(RTime 支払窓口終了期間) {
        if (null == 支払窓口終了期間) {
            return RString.EMPTY;
        }
        RStringBuilder 支払窓口終了期間Builder = new RStringBuilder();
        int hour = 支払窓口終了期間.getHour();
        if (hour < RSTRING_12) {
            支払窓口終了期間Builder.append(午前);
        } else {
            hour = hour - RSTRING_12;
            支払窓口終了期間Builder.append(午後);
        }
        支払窓口終了期間Builder.append(String.format("%02d", hour));
        支払窓口終了期間Builder.append(new RString("時"));
        if (0 < 支払窓口終了期間.getMinute()) {
            支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getMinute()));
            支払窓口終了期間Builder.append(new RString("分"));
        }
        return 支払窓口終了期間Builder.toRString();
    }

    private RString setFlexibleDateYMD(FlexibleDate 年月日) {
        if (null == 年月日 || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        RString str年月日 = 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 曜日 = new RString(年月日.getDayOfWeek().getInFullParentheses());
        return str年月日.concat(曜日);
    }

    private RString setDateYMD(RDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        RString str年月日 = 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 曜日 = new RString(年月日.getDayOfWeek().getInFullParentheses());
        return str年月日.concat(曜日);
    }
}
