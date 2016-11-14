/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanharaishikyufushikyuketeitsuchiichiranhyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.association.IAssociation;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 償還払支給（不支給）決定通知一覧表のビジネスです。
 *
 * @reamsid_L DBC-1000-080 lizhuoxuan
 */
public class ShokanharaiShikyuFushikyuKeteiTsuchiIchiranhyo {

    private static final int 数字_5 = 5;
    private static final int 数字_4 = 4;
    private static final int 数字_3 = 3;
    private static final int ZERO = 0;
    private static final int TEN = 10;
    private static final RString 差止中 = new RString("差止中");
    private static final RString 控除中 = new RString("控除中");
    private static final RString _２号 = new RString("２号");

    /**
     * 帳票データを作成します。
     *
     * @param businessList 償還払支給（不支給）決定通知一覧表Entityリスト
     * @param batchPram バッチパラメータ
     * @param 出力順 出力順
     * @param 改ページ 改ページ
     * @param 種類Map 種類Map
     * @param 帳票制御共通情報 帳票制御共通情報
     * @return List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem>
     */
    public List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem>
            getShokanharaiShikyuFushikyuKeteiTsuchiIchiranhyoData(List<ShokanKetteiTsuchiShoShiharai> businessList,
                    ShokanKetteiTsuchiShoSealerBatchParameter batchPram, List<RString> 出力順, List<RString> 改ページ, Map<RString, RString> 種類Map,
                    ChohyoSeigyoKyotsu 帳票制御共通情報) {
        List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> tsuchiIchiranItemsList = new ArrayList<>();
        if (businessList == null || businessList.isEmpty()) {
            ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem ichiranItem = new ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem();
            ichiranItem.setShutsuryokujun1(出力順.get(0));
            ichiranItem.setShutsuryokujun2(出力順.get(1));
            ichiranItem.setShutsuryokujun3(出力順.get(2));
            ichiranItem.setShutsuryokujun4(出力順.get(数字_3));
            ichiranItem.setShutsuryokujun5(出力順.get(数字_4));
            ichiranItem.setKaipage1(改ページ.get(0));
            ichiranItem.setKaipage2(改ページ.get(1));
            ichiranItem.setKaipage3(改ページ.get(2));
            ichiranItem.setKaipage4(改ページ.get(数字_3));
            ichiranItem.setKaipage5(改ページ.get(数字_4));
            IAssociation association = AssociationFinderFactory.createInstance().getAssociation();
            ichiranItem.setHokenshaNo(association.get地方公共団体コード().getColumnValue());
            ichiranItem.setHokenshaName(association.get市町村名());
            ichiranItem.setPrintTimeStamp(get作成日時分秒());
            ichiranItem.setHihokenshaName(new RString("該当データがありません"));
            tsuchiIchiranItemsList.add(ichiranItem);
            return tsuchiIchiranItemsList;
        }
        int renban = 0;
//        RString hihokenshaNo = RString.EMPTY;
        for (ShokanKetteiTsuchiShoShiharai shoShiharaiList : businessList) {
            ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem ichiranItem = new ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem();
            IAssociation association = AssociationFinderFactory.createInstance().getAssociation();
            ichiranItem.setHokenshaNo(association.get地方公共団体コード().getColumnValue());
            ichiranItem.setHokenshaName(association.get市町村名());
            ichiranItem.setShutsuryokujun1(出力順.get(0));
            ichiranItem.setShutsuryokujun2(出力順.get(1));
            ichiranItem.setShutsuryokujun3(出力順.get(2));
            ichiranItem.setShutsuryokujun4(出力順.get(数字_3));
            ichiranItem.setShutsuryokujun5(出力順.get(数字_4));
            ichiranItem.setKaipage1(改ページ.get(0));
            ichiranItem.setKaipage2(改ページ.get(1));
            ichiranItem.setKaipage3(改ページ.get(2));
            ichiranItem.setKaipage4(改ページ.get(数字_3));
            ichiranItem.setKaipage5(改ページ.get(数字_4));
//            if (!hihokenshaNo.equals(shoShiharaiList.get被保険者番号().value())) {
                ichiranItem.setRenban(new RString(String.valueOf(++renban)));
//            }
//            hihokenshaNo = shoShiharaiList.get被保険者番号().value();
            ichiranItem.setPrintTimeStamp(get作成日時分秒());
            ichiranItem.setSeiriNo(shoShiharaiList.get整理番号());
            ichiranItem.setKeteiTsuchiNo(shoShiharaiList.get決定通知No());
            ichiranItem.setHihokenshaNo(shoShiharaiList.get被保険者番号().value());
            ichiranItem.setHihokenshaName(shoShiharaiList.get被保険者氏名());

            RString 編集住所 = get編集住所(shoShiharaiList, 帳票制御共通情報);
            ichiranItem.setJusho(編集住所);

            ichiranItem.setYubinBango(getEditedYubinNo(shoShiharaiList.get郵便番号()));
            ichiranItem.setTeikyo(shoShiharaiList.get提供年月().wareki().
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).
                    fillType(FillType.BLANK).toDateString());
            if (shoShiharaiList.get要介護認定状態区分コード() != null
                    && !RString.isNullOrEmpty(shoShiharaiList.get要介護認定状態区分コード().getColumnValue())) {
                ichiranItem.setYoKaigodo(YokaigoJotaiKubun.toValue(shoShiharaiList.get要介護認定状態区分コード().getColumnValue()).get名称());
            }
            ichiranItem.setNinteiKaishibi(共通ポリシfomart(shoShiharaiList.get認定開始日()));
            ichiranItem.setNinteiShuryobi(共通ポリシfomart(shoShiharaiList.get認定終了日()));
            ichiranItem.setUketsukeYMD(共通ポリシfomart(shoShiharaiList.get受付年月日()));
            ichiranItem.setKeteiYMD(共通ポリシfomart(shoShiharaiList.get決定年月日()));
            ichiranItem.setHonjinShiharaigaku(shoShiharaiList.get本人支払額() == null
                    ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(shoShiharaiList.get本人支払額(), 0));
            ichiranItem.setShikyugaku(shoShiharaiList.get支給額() == null
                    ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(shoShiharaiList.get支給額(), 0));
            ichiranItem.setYoshikigotoKingaku(shoShiharaiList.get様式名称());
            ichiranItem.setKingaku(DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(shoShiharaiList.get金額()), 0));
            ichiranItem.setTuika(RString.EMPTY);
            ichiranItem.setShurui(種類Map.get(getJufukuKey(shoShiharaiList)));
            if (!RString.isNullOrEmpty(shoShiharaiList.get支給不支給決定区分())) {
                ichiranItem.setKeteiKubun(new RString(ShikyuFushikyuKubun.toValue(shoShiharaiList.get支給不支給決定区分()).get名称().toString()));
            }
            if (ShiharaiHohoKubun.口座払.getコード().equals(shoShiharaiList.get支払方法区分コード())
                    && (null == shoShiharaiList.get金融機関コード() || shoShiharaiList.get金融機関コード().isEmpty())) {
                ichiranItem.setKeteiKubun(new RString("金融機関未登録"));
            }
            if (!RString.isNullOrEmpty(shoShiharaiList.get支給不支給決定区分())
                    && ShikyuFushikyuKubun.支給.getコード().equals(shoShiharaiList.get支給不支給決定区分())
                    && ShikakuKubun._２号.getコード().equals(shoShiharaiList.get被保険者区分コード())) {
                ichiranItem.setKeteiKubun(new RString("支給　　　２号"));
            }
            if (!RString.isNullOrEmpty(shoShiharaiList.get支払方法区分コード())) {
                ichiranItem.setShiharaiHoho(new RString(ShiharaiHohoKubun.toValue(shoShiharaiList.get支払方法区分コード()).get名称().toString()));
            }
            if (shoShiharaiList.get町域コード() != null) {
                ichiranItem.setChoikiCode(shoShiharaiList.get町域コード().value());
            } else {
                ichiranItem.setChoikiCode(RString.EMPTY);
            }
            if (shoShiharaiList.get行政区コード() != null) {
                ichiranItem.setGyoseikuCode(shoShiharaiList.get行政区コード().value());
            } else {
                ichiranItem.setGyoseikuCode(RString.EMPTY);
            }
            if (shoShiharaiList.get氏名５０音カナ() != null) {
                ichiranItem.setKanaMeisho(shoShiharaiList.get氏名５０音カナ().value());
            } else {
                ichiranItem.setKanaMeisho(RString.EMPTY);
            }
            ichiranItem.setShoKisaiHokenshaNo(shoShiharaiList.get証記載保険者番号().value());
            ichiranItem.setKetteiTsuchiNo(shoShiharaiList.get決定通知No());
            ichiranItem.setShinseishaKubun(shoShiharaiList.get申請者区分());
            tsuchiIchiranItemsList.add(ichiranItem);
        }
        return tsuchiIchiranItemsList;
    }

    private RString get編集住所(ShokanKetteiTsuchiShoShiharai shiharai, ChohyoSeigyoKyotsu 帳票制御共通情報) {
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(shiharai.get市町村コード(), FlexibleDate.getNowDate());
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(shiharai.get宛先情報(), 地方公共団体, 帳票制御共通情報);
        return 編集後宛先.get編集後住所();
    }

    private RString getJufukuKey(ShokanKetteiTsuchiShoShiharai shiharai) {
        RStringBuilder key = new RStringBuilder();
        key.append(shiharai.get被保険者番号().value());
        key.append(shiharai.get提供年月().wareki().toDateString());
        key.append(shiharai.get整理番号().padLeft(new RString(ZERO), TEN));
        return key.toRString();
    }

    /**
     *
     * 作成日時分秒取得です。
     *
     */
    private static RString get作成日時分秒() {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%2d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%2d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%2d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        return systemDateTime.toRString();
    }

    private RString getEditedYubinNo(RString yubinNo) {
        if (RString.isNullOrEmpty(yubinNo)) {
            return RString.EMPTY;
        }
        if (yubinNo.length() < 数字_5) {
            return yubinNo;
        }
        return yubinNo.insert(yubinNo.length() - 数字_4, "-");
    }

    private RString 共通ポリシfomart(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }

        return (date.
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
    }

    /**
     * 帳票設計_DBC200024_償還払支給差止対象者一覧表データを作成します。
     *
     * @param businessList 償還払支給（不支給）決定通知一覧表Entityリスト
     * @param batchPram バッチパラメータ
     * @param 出力順 出力順
     * @param 改ページ 改ページ
     * @param 種類Map 種類Map
     * @param 帳票制御共通情報 帳票制御共通情報
     * @return List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem>
     */
    public List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem>
            shokanbaraiSashitomeTaishoshaIchiranReportData(
                    List<ShokanKetteiTsuchiShoShiharai> businessList,
                    ShokanKetteiTsuchiShoSealerBatchParameter batchPram,
                    List<RString> 出力順,
                    List<RString> 改ページ,
                    Map<RString, RString> 種類Map,
                    ChohyoSeigyoKyotsu 帳票制御共通情報) {
                List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> tsuchiIchiranItemsList = new ArrayList<>();
                if (businessList == null || businessList.isEmpty()) {
                    ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem ichiranItem = new ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem();
                    ichiranItem.setShutsuryokujun1(出力順.get(0));
                    ichiranItem.setShutsuryokujun2(出力順.get(1));
                    ichiranItem.setShutsuryokujun3(出力順.get(2));
                    ichiranItem.setShutsuryokujun4(出力順.get(数字_3));
                    ichiranItem.setShutsuryokujun5(出力順.get(数字_4));
                    ichiranItem.setKaipage1(改ページ.get(0));
                    ichiranItem.setKaipage2(改ページ.get(1));
                    ichiranItem.setKaipage3(改ページ.get(2));
                    ichiranItem.setKaipage4(改ページ.get(数字_3));
                    ichiranItem.setKaipage5(改ページ.get(数字_4));
                    IAssociation association = AssociationFinderFactory.createInstance().getAssociation();
                    ichiranItem.setHokenshaNo(association.get地方公共団体コード().getColumnValue());
                    ichiranItem.setHokenshaName(association.get市町村名());
                    ichiranItem.setPrintTimeStamp(get作成日時分秒());
                    ichiranItem.setHihokenshaName(new RString("該当データがありません"));
                    tsuchiIchiranItemsList.add(ichiranItem);
                    return tsuchiIchiranItemsList;
                }
                int renban = 0;
                RString hihokenshaNo = RString.EMPTY;
                for (ShokanKetteiTsuchiShoShiharai shoShiharaiList : businessList) {
                    ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem ichiranItem = new ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem();
                    IAssociation association = AssociationFinderFactory.createInstance().getAssociation();
                    ichiranItem.setHokenshaNo(association.get地方公共団体コード().getColumnValue());
                    ichiranItem.setHokenshaName(association.get市町村名());
                    ichiranItem.setShutsuryokujun1(出力順.get(0));
                    ichiranItem.setShutsuryokujun2(出力順.get(1));
                    ichiranItem.setShutsuryokujun3(出力順.get(2));
                    ichiranItem.setShutsuryokujun4(出力順.get(数字_3));
                    ichiranItem.setShutsuryokujun5(出力順.get(数字_4));
                    ichiranItem.setKaipage1(改ページ.get(0));
                    ichiranItem.setKaipage2(改ページ.get(1));
                    ichiranItem.setKaipage3(改ページ.get(2));
                    ichiranItem.setKaipage4(改ページ.get(数字_3));
                    ichiranItem.setKaipage5(改ページ.get(数字_4));
                    if (!hihokenshaNo.equals(shoShiharaiList.get被保険者番号().value())) {
                        ichiranItem.setRenban(new RString(String.valueOf(++renban)));
                    }
                    hihokenshaNo = shoShiharaiList.get被保険者番号().value();
                    ichiranItem.setPrintTimeStamp(get作成日時分秒());
                    ichiranItem.setSeiriNo(shoShiharaiList.get整理番号());
                    ichiranItem.setKeteiTsuchiNo(shoShiharaiList.get決定通知No());
                    ichiranItem.setHihokenshaNo(shoShiharaiList.get被保険者番号().value());
                    ichiranItem.setHihokenshaName(shoShiharaiList.get被保険者氏名());

                    RString 編集住所 = get編集住所(shoShiharaiList, 帳票制御共通情報);
                    ichiranItem.setJusho(編集住所);

                    ichiranItem.setYubinBango(getEditedYubinNo(shoShiharaiList.get郵便番号()));
                    ichiranItem.setTeikyo(shoShiharaiList.get提供年月().wareki().
                            firstYear(FirstYear.GAN_NEN).
                            separator(Separator.PERIOD).
                            fillType(FillType.BLANK).toDateString());
                    if (shoShiharaiList.get要介護認定状態区分コード() != null
                            && !RString.isNullOrEmpty(shoShiharaiList.get要介護認定状態区分コード().getColumnValue())) {
                        ichiranItem.setYoKaigodo(YokaigoJotaiKubun.toValue(shoShiharaiList.get要介護認定状態区分コード().getColumnValue()).get名称());
                    }
                    ichiranItem.setUketsukeYMD(共通ポリシfomart(shoShiharaiList.get受付年月日()));
                    ichiranItem.setKeteiYMD(共通ポリシfomart(shoShiharaiList.get決定年月日()));
                    ichiranItem.setHonjinShiharaigaku(shoShiharaiList.get本人支払額() == null
                            ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(shoShiharaiList.get本人支払額(), 0));
                    ichiranItem.setShikyugaku(shoShiharaiList.get支給額() == null
                            ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(shoShiharaiList.get支給額(), 0));
                    ichiranItem.setYoshikigotoKingaku(shoShiharaiList.get様式名称());
                    ichiranItem.setKingaku(DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(shoShiharaiList.get金額()), 0));
                    ichiranItem.setTuika(set対象理由(shoShiharaiList));
                    ichiranItem.setShurui(種類Map.get(getJufukuKey(shoShiharaiList)));
                    if (shoShiharaiList.get町域コード() != null) {
                        ichiranItem.setChoikiCode(shoShiharaiList.get町域コード().value());
                    } else {
                        ichiranItem.setChoikiCode(RString.EMPTY);
                    }
                    if (shoShiharaiList.get行政区コード() != null) {
                        ichiranItem.setGyoseikuCode(shoShiharaiList.get行政区コード().value());
                    } else {
                        ichiranItem.setGyoseikuCode(RString.EMPTY);
                    }
                    if (shoShiharaiList.get氏名５０音カナ() != null) {
                        ichiranItem.setKanaMeisho(shoShiharaiList.get氏名５０音カナ().value());
                    } else {
                        ichiranItem.setKanaMeisho(RString.EMPTY);
                    }
                    ichiranItem.setShoKisaiHokenshaNo(shoShiharaiList.get証記載保険者番号().value());
                    ichiranItem.setKetteiTsuchiNo(shoShiharaiList.get決定通知No());
                    ichiranItem.setShinseishaKubun(shoShiharaiList.get申請者区分());
                    tsuchiIchiranItemsList.add(ichiranItem);
                }
                return tsuchiIchiranItemsList;
            }

            private RString set対象理由(ShokanKetteiTsuchiShoShiharai entity) {
                if (!entity.get差止被保険者番号().isEmpty()) {
                    if (entity.get差止控除番号().isEmpty()) {
                        return 差止中;
                    } else {
                        if (Decimal.ZERO.compareTo(entity.get差額金額合計()) == 0) {
                            return 控除中;
                        }
                    }
                }
                if (ShikakuKubun._２号.getコード().equals(entity.get被保険者区分コード())) {
                    return _２号;
                }
                return RString.EMPTY;
            }
}
