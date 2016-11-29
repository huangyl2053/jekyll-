/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.util.report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNoHatsubanHoho;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibun;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 帳票共通クラスです。
 *
 * @reamsid_L DBE-0050-040 sunhaidi
 */
public final class ReportUtil {

    private ReportUtil() {
    }

    private static final RString 首長名印字位置 = new RString("1");
    private static final RString 汎用キー_文書番号 = new RString("文書番号");
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static RStringBuilder orderByClause;
    private static RString space;
    private static RString comma;
    private static int commaCount;

    /**
     * 雛形部品_認証者を取得します。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票分類ID
     * @param kaisiYMD 開始年月日
     * @param denshikoinshubetsuCode 認証者電子公印種別コード
     * @param kenmeiFuyoKubunType 県郡名付与区分
     * @param reportSourceWriter ReportSourceWriter
     * @return 認証者情報
     */
    public static NinshoshaSource get認証者情報(
            SubGyomuCode subGyomuCode,
            ReportId reportId,
            FlexibleDate kaisiYMD,
            RString denshikoinshubetsuCode,
            KenmeiFuyoKubunType kenmeiFuyoKubunType,
            ReportSourceWriter reportSourceWriter) {
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        ChohyoSeigyoKyotsu chohyoSeigyoKyotsu = chohyoSeigyoKyotsuManager.get帳票制御共通(subGyomuCode, reportId);
        INinshoshaManager ninshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha ninshosha = ninshoshaManager.get帳票認証者(GyomuCode.DB介護保険, denshikoinshubetsuCode, kaisiYMD);
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        boolean is公印に掛ける = false;
        boolean is公印を省略 = false;
        if (chohyoSeigyoKyotsu != null) {
            is公印に掛ける = 首長名印字位置.equals(chohyoSeigyoKyotsu.get首長名印字位置());
            is公印を省略 = !chohyoSeigyoKyotsu.is電子公印印字有無();
        }
        return NinshoshaSourceBuilderFactory.createInstance(ninshosha, 導入団体クラス,
                reportSourceWriter.getImageFolderPath(),
                new RDate(kaisiYMD.toString()),
                is公印に掛ける,
                is公印を省略,
                kenmeiFuyoKubunType).buildSource();
    }

    /**
     * 文書番号を取得します。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票分類ID
     * @param kaisiYMD 開始年月日
     * @return 文書番号
     */
    public static RString get文書番号(
            SubGyomuCode subGyomuCode,
            ReportId reportId,
            FlexibleDate kaisiYMD) {
        IBunshoNoFinder bushoFineder = BunshoNoFinderFactory.createInstance();
        BunshoNo bushoNo = bushoFineder.get文書番号管理(reportId, kaisiYMD);
        RString 文書番号 = RString.EMPTY;
        if (bushoNo != null) {
            RString 文書番号発番方法 = bushoNo.get文書番号発番方法();
            if (BunshoNoHatsubanHoho.固定.getCode().equals(文書番号発番方法)) {
                文書番号 = bushoNo.edit文書番号();
            } else if (BunshoNoHatsubanHoho.手入力.getCode().equals(文書番号発番方法)) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("文書番号情報の取得"));
            } else if (BunshoNoHatsubanHoho.自動採番.getCode().equals(文書番号発番方法)) {
                CountedItem 採番 = Saiban.get(subGyomuCode, 汎用キー_文書番号, new FlexibleYear(RDate.getNowDate().getYear().toDateString()));
                文書番号 = bushoNo.edit文書番号(採番.nextString());
            }
        }
        return 文書番号;
    }

    /**
     * 通知文を取得します。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票ID
     * @param kamokuCode 科目コード
     * @param patternNo パターン番号
     * @return 通知文
     */
    public static Map<Integer, RString> get通知文(
            SubGyomuCode subGyomuCode,
            ReportId reportId,
            KamokuCode kamokuCode,
            int patternNo) {
        TsuchishoTeikeibunManager tsuchishoTeikeibunManager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo info = tsuchishoTeikeibunManager.get通知書定型文項目(subGyomuCode, reportId, kamokuCode, patternNo);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(subGyomuCode, reportId);
        List<TsuchishoTeikeibunEntity> tsuchishoTeikeibunList = info.get通知書定型文List();
        Map<Integer, RString> 通知文 = new HashMap<>();
        for (TsuchishoTeikeibunEntity tsuchishoTeikeibun : tsuchishoTeikeibunList) {
            int sentenceNo = tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentenceNo();
            通知文.put(sentenceNo, textHenkanRule.editText(tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentence()));
        }
        return 通知文;
    }

    /**
     * 基準日により、通知文を取得します。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票ID
     * @param kamokuCode 科目コード
     * @param patternNo パターン番号
     * @param sentenceNo 項目番号
     * @param kijunDate 基準年月日
     * @return 通知文
     */
    public static RString get通知文(
            SubGyomuCode subGyomuCode,
            ReportId reportId,
            KamokuCode kamokuCode,
            int patternNo,
            int sentenceNo,
            FlexibleDate kijunDate) {
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(subGyomuCode, reportId);
        return get通知文(subGyomuCode, reportId, kamokuCode, patternNo, sentenceNo, kijunDate, textHenkanRule);
    }

    /**
     * 基準日により、通知文を取得します。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票ID
     * @param kamokuCode 科目コード
     * @param patternNo パターン番号
     * @param sentenceNo 項目番号
     * @param kijunDate 基準年月日
     * @param henkanRule ルール
     * @return 通知文
     */
    public static RString get通知文(
            SubGyomuCode subGyomuCode,
            ReportId reportId,
            KamokuCode kamokuCode,
            int patternNo,
            int sentenceNo,
            FlexibleDate kijunDate,
            ITextHenkanRule henkanRule) {
        TsuchishoTeikeibunManager tsuchishoTeikeibunManager = TsuchishoTeikeibunManager.createInstance();
        List<TsuchishoTeikeibun> tsuchishoTeikeibunList = tsuchishoTeikeibunManager.get通知書定型文(subGyomuCode, reportId,
                kamokuCode, patternNo, kijunDate);
        TsuchishoTeikeibun info = null;
        for (TsuchishoTeikeibun tsuchishoTeikeibun : tsuchishoTeikeibunList) {
            if (tsuchishoTeikeibun.get項目番号() == sentenceNo) {
                info = tsuchishoTeikeibun;
            }
        }
        if (info == null) {
            return henkanRule.editText(RString.EMPTY);
        }
        return henkanRule.editText(info.get文章());
    }

    /**
     * カスタマーバーコードを取得します。
     *
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @return カスタマーバーコード
     */
    public static RString getCustomerBarCode(
            RString yubinNo,
            RString jusho) {
        CustomerBarCode barcode = new CustomerBarCode();
        CustomerBarCodeResult result = barcode.convertCustomerBarCode(yubinNo, jusho);
        return result.getCustomerBarCode();
    }

    /**
     * 定型文文字サイズを取得します。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportBunruiId 帳票分類ID
     * @return 定型文文字サイズ
     */
    public static RString get定型文文字サイズ(
            SubGyomuCode subGyomuCode,
            ReportId reportBunruiId) {

        ChohyoSeigyoKyotsuManager manager = new ChohyoSeigyoKyotsuManager();
        ChohyoSeigyoKyotsu kyotsu = manager.get帳票制御共通(subGyomuCode, reportBunruiId);
        if (kyotsu != null) {
            return kyotsu.get定型文文字サイズ();
        }
        return RString.EMPTY;
    }

    /**
     * 出力順・改頁リスト及び、出力順・改頁項目管理Enumクラスを引数で指定することで、出力順・改頁のEntityを生成します。
     *
     * @param <T> IReportItemsを実装したEnumクラス
     * @param clazz 出力順・改頁項目管理Enumクラス
     * @param サブ業務コード サブ業務コード
     * @param 帳票ID 帳票ID
     * @param 出力順ID 出力順ID
     * @return ShutsuryokujunRelateEntity
     */
    public static <T extends Enum<T> & IReportItems> ShutsuryokujunRelateEntity get出力順情報(
            Class<T> clazz,
            SubGyomuCode サブ業務コード,
            ReportId 帳票ID,
            long 出力順ID) {
        ShutsuryokujunRelateEntity entity = new ShutsuryokujunRelateEntity();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = finder.get出力順(サブ業務コード, 帳票ID, 出力順ID);
        ReportItemsMap reportItems = new ReportItemsMap(Arrays.<IReportItems>asList(clazz.getEnumConstants()));
        if (outputOrder == null) {
            entity.setPageBreakKeys(new ArrayList<RString>());
            entity.set出力順OrderBy(RString.EMPTY);
            return entity;
        }
        orderByClause = new RStringBuilder("order by");
        space = RString.HALF_SPACE;
        comma = new RString(",");
        commaCount = 0;
        int shutsuryokujunCount = 0;
        int kaiPeijiCount = 0;
        List<RString> 出力順List = new ArrayList<>();
        List<RString> 改頁List = new ArrayList<>();
        List<RString> pagebreakList = new ArrayList<>();
        for (int i = 0; i < INT5; i++) {
            出力順List.add(RString.EMPTY);
            改頁List.add(RString.EMPTY);
        }
        if (outputOrder.get設定項目リスト().isEmpty()) {
            entity.setPageBreakKeys(new ArrayList<RString>());
            entity.set出力順OrderBy(RString.EMPTY);
            return entity;
        }
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            getOrderByClause(reportItems, setSortItem);
            if (INT5 > shutsuryokujunCount) {
                出力順List.set(commaCount, setSortItem.get項目名());
                shutsuryokujunCount++;
            }
            if (setSortItem.is改頁項目() && INT5 > kaiPeijiCount) {
                pagebreakList.add(reportItems.getフォームフィールド名(setSortItem.get項目ID()));
                改頁List.set(commaCount, setSortItem.get項目名());
                kaiPeijiCount++;
            }
            commaCount++;
        }
        entity.set出力順1(出力順List.get(0));
        entity.set出力順2(出力順List.get(1));
        entity.set出力順3(出力順List.get(2));
        entity.set出力順4(出力順List.get(INT3));
        entity.set出力順5(出力順List.get(INT4));
        entity.set改頁項目1(改頁List.get(0));
        entity.set改頁項目2(改頁List.get(1));
        entity.set改頁項目3(改頁List.get(2));
        entity.set改頁項目4(改頁List.get(INT3));
        entity.set改頁項目5(改頁List.get(INT4));
        entity.set出力順OrderBy(orderByClause.toRString());
        entity.set出力順項目(出力順List);
        entity.setPageBreakKeys(pagebreakList);
        entity.set改頁項目(改頁List);
        return entity;
    }

    private static void getOrderByClause(ReportItemsMap reportItems, ISetSortItem setSortItem) {
        if (commaCount < INT5) {
            if (commaCount != 0) {
                orderByClause = orderByClause.append(space).append(comma).append(space)
                        .append(reportItems.getMyBatis項目名(setSortItem.get項目ID())).append(space).append(setSortItem.get昇降順().getOrder());

            } else {
                orderByClause = orderByClause.append(space)
                        .append(reportItems.getMyBatis項目名(setSortItem.get項目ID())).append(space).append(setSortItem.get昇降順().getOrder());
            }
        }
    }

    private static class ReportItemsMap {

        private Map<RString, IReportItems> map;

        public ReportItemsMap(List<IReportItems> items) {
            this.map = new HashMap<>();
            for (IReportItems item : items) {
                this.map.put(item.get項目ID(), item);
            }
            this.map = Collections.unmodifiableMap(map);
        }

        RString getMyBatis項目名(RString 項目ID) throws IllegalArgumentException {
            if (this.map.containsKey(項目ID)) {
                return this.map.get(項目ID).getMyBatis項目名();
            } else {
                throw new IllegalArgumentException(UrErrorMessages.データが存在しない.toString());
            }
        }

        RString getフォームフィールド名(RString 項目ID) throws IllegalArgumentException {
            if (this.map.containsKey(項目ID)) {
                return this.map.get(項目ID).getフォームフィールド名();
            } else {
                throw new IllegalArgumentException(UrErrorMessages.データが存在しない.toString());
            }
        }
    }

    /**
     * 0から、出力順項目を取得します。
     *
     * @param shutsuryokujunId 出力順ID
     * @param reportId 帳票ID
     * @param subGyomuCode サブ業務コード
     * @return List<ISetSortItem>
     */
    public static Map<Integer, ISetSortItem> get出力順項目(
            SubGyomuCode subGyomuCode,
            Long shutsuryokujunId,
            ReportId reportId) {
        List<ISetSortItem> 設定項目リスト = new ArrayList<>();
        IOutputOrder iOutputOrder = ReportUtil.get出力順ID(subGyomuCode, shutsuryokujunId, reportId);
        if (iOutputOrder != null) {
            設定項目リスト = iOutputOrder.get設定項目リスト();
        }
        Map<Integer, ISetSortItem> 出力順Map = new HashMap();
        int i = 0;
        for (ISetSortItem sortItem : 設定項目リスト) {
            出力順Map.put(i, sortItem);
            i++;
        }
        return 出力順Map;
    }

    /**
     * 0から、改頁項目を取得します。
     *
     * @param shutsuryokujunId 出力順ID
     * @param reportId 帳票ID
     * @param subGyomuCode サブ業務コード
     * @return List<ISetSortItem>
     */
    public static Map<Integer, RString> get改頁項目(
            SubGyomuCode subGyomuCode,
            Long shutsuryokujunId,
            ReportId reportId) {
        List<ISetSortItem> 設定項目リスト = new ArrayList<>();
        IOutputOrder iOutputOrder = ReportUtil.get出力順ID(subGyomuCode, shutsuryokujunId, reportId);
        if (iOutputOrder != null) {
            設定項目リスト = iOutputOrder.get設定項目リスト();
        }
        Map<Integer, RString> 改頁Map = new HashMap();
        int i = 0;
        for (ISetSortItem sortItem : 設定項目リスト) {
            if (sortItem.is改頁項目()) {
                改頁Map.put(i, sortItem.get項目名());
                i++;
            }
        }
        return 改頁Map;
    }

    /**
     * 出力順IDを取得します。
     *
     * @param shutsuryokujunId 出力順ID
     * @param reportId 帳票ID
     * @param subGyomuCode サブ業務コード
     * @return List<ISetSortItem>
     */
    public static IOutputOrder get出力順ID(
            SubGyomuCode subGyomuCode,
            Long shutsuryokujunId,
            ReportId reportId) {
        if (shutsuryokujunId != null) {
            IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            RString reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
            return chohyoShutsuryokujunFinder.get出力順(subGyomuCode,
                    reportId,
                    reamsLoginID,
                    Long.valueOf(shutsuryokujunId.toString()));
        }
        return null;
    }
}
