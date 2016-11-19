/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBBRP43002_5_介護保険料額変更通知書発行一覧表 KaigoHokenryogakuProperty
 *
 * @reamsid_L DBB-0780-120 zhouchuanlin
 */
public class KaigoHokenryogakuProperty extends ReportPropertyBase<KaigoHokenryogakuSource> {

    private final List<RString> pageBreakKeys;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final RString FORMAT = new RString("\"");

    /**
     * コンストラクタです。
     *
     * @param outputOrder IOutputOrder
     */
    public KaigoHokenryogakuProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200030.getReportId());

        pageBreakKeys = new ArrayList<>();

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;

        if (outputOrder == null) {
            return;
        }
        List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
        if (iSetSortItemList == null) {
            return;
        }

        if (INDEX_0 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_0).is改頁項目()) {
            改頁１ = to帳票物理名(iSetSortItemList.get(0).get項目ID());
        }
        if (INDEX_1 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_1).is改頁項目()) {
            改頁２ = to帳票物理名(iSetSortItemList.get(INDEX_1).get項目ID());
        }
        if (INDEX_2 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_2).is改頁項目()) {
            改頁３ = to帳票物理名(iSetSortItemList.get(INDEX_2).get項目ID());
        }
        if (INDEX_3 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_3).is改頁項目()) {
            改頁４ = to帳票物理名(iSetSortItemList.get(INDEX_3).get項目ID());
        }
        if (INDEX_4 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_4).is改頁項目()) {
            改頁５ = to帳票物理名(iSetSortItemList.get(INDEX_4).get項目ID());
        }

        if (!改頁１.isEmpty()) {
            pageBreakKeys.add(改頁１);
        }
        if (!改頁２.isEmpty()) {
            pageBreakKeys.add(改頁２);
        }
        if (!改頁３.isEmpty()) {
            pageBreakKeys.add(改頁３);
        }
        if (!改頁４.isEmpty()) {
            pageBreakKeys.add(改頁４);
        }
        if (!改頁５.isEmpty()) {
            pageBreakKeys.add(改頁５);
        }
    }

    @Override
    public Breakers<KaigoHokenryogakuSource> defineBreakers(
            Breakers<KaigoHokenryogakuSource> breakers,
            BreakerCatalog<KaigoHokenryogakuSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            pageBreakKeys) {
            @Override
            public ReportLineRecord<KaigoHokenryogakuSource> occuredBreak(
                    ReportLineRecord<KaigoHokenryogakuSource> currentRecord,
                    ReportLineRecord<KaigoHokenryogakuSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    private RString to帳票物理名(RString 項目ID) {

        RString 帳票物理名 = RString.EMPTY;

        if (KaigoHokenryogakuProperty.OutputOrderEnum.郵便番号.equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.listUpper_2.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.町域コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.choikiCode.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.番地コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.banchiCode.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.gyoseikuCode.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.地区１.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.chikuCode1.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.地区２.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.chikuCode2.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.地区３.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.chikuCode3.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.世帯コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.listLower_2.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.識別コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.shikibetsuCode.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.氏名５０音カナ.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.kanaMeisho.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.生年月日.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.listUpper_5.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.性別.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.listUpper_6.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.hokenshaNo.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.hihokenshaNo.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.年金コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.nenkinCode.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.納組コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.nokumiCode.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.生活保護.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.seihoFlag1.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.生活保護種別.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.seihoFlag.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.八月特徴開始者.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.tokuchoKaishi8.name());
        } else if (KaigoHokenryogakuProperty.OutputOrderEnum.十月特徴開始者.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHokenryogakuSource.ReportSourceFields.tokuchoKaishi10.name());
        }
        return 帳票物理名;
    }

    /**
     * 帳票設計_DBBRP43002_5_介護保険料額変更通知書発行一覧表 出力順設定可能項目です。
     */
    public enum OutputOrderEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("郵便番号"), FORMAT.concat(new RString("Atesaki_yubinNo")).concat(FORMAT)),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("町域コード"), FORMAT.concat(new RString("Atesaki_choikiCode")).concat(FORMAT)),
        /**
         * 番地コード
         */
        番地コード(new RString("0003"), new RString("番地コード"), new RString("\"Atesaki_banchiCode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("行政区コード"), FORMAT.concat(new RString("Atesaki_gyoseikuCode")).concat(FORMAT)),
        /**
         * 地区１
         */
        地区１(new RString("0005"), new RString("地区１"), FORMAT.concat(new RString("Atesaki_chikuCode1")).concat(FORMAT)),
        /**
         * 地区２
         */
        地区２(new RString("0006"), new RString("地区２"), FORMAT.concat(new RString("Atesaki_chikuCode2")).concat(FORMAT)),
        /**
         * 地区３
         */
        地区３(new RString("0007"), new RString("地区３"), FORMAT.concat(new RString("Atesaki_chikuCode3")).concat(FORMAT)),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("世帯コード"), FORMAT.concat(new RString("ShikibetsuTaisho_setaiCode")).concat(FORMAT)),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("識別コード"), FORMAT.concat(new RString("ShikibetsuTaisho_shikibetsuCode")).concat(FORMAT)),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), FORMAT.concat(new RString("ShikibetsuTaisho_kanaMeisho")).concat(FORMAT)),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString("生年月日"), FORMAT.concat(new RString("ShikibetsuTaisho_seinengappiYMD")).concat(FORMAT)),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString("性別"), FORMAT.concat(new RString("ShikibetsuTaisho_seibetsuCode")).concat(FORMAT)),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), FORMAT
                .concat(new RString("dbT2015KeisangoJoho_fukaShichosonCode")).concat(FORMAT)),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), FORMAT
                .concat(new RString("dbT2015KeisangoJoho_hihokenshaNo")).concat(FORMAT)),
        /**
         * 年金コード
         */
        年金コード(new RString("0206"), new RString("年金コード"), FORMAT
                .concat(new RString("dbT2015KeisangoJoho_honNenkinCode")).concat(FORMAT)),
        /**
         * 納組コード
         */
        納組コード(new RString("0208"), new RString("納組コード"), FORMAT.concat(new RString("CaT0714nokumiCode")).concat(FORMAT)),
        /**
         * 生活保護
         */
        生活保護(new RString("0133"), new RString("生活保護"), FORMAT.concat(new RString("生活保護区分")).concat(FORMAT)),
        /**
         * 生活保護種別
         */
        生活保護種別(new RString("0116"), new RString("生活保護種別"), FORMAT.concat(new RString("dbT2015KeisangoJoho_seihofujoShurui")).concat(FORMAT)),
        /**
         * 現金口座区分
         */
        現金口座区分(new RString("0210"), new RString("現金口座区分"), FORMAT.concat(new RString("dbT2015KeisangoJoho_kozaKubun")).concat(FORMAT)),
        /**
         * 8月特徴開始者
         */
        八月特徴開始者(new RString("0220"), new RString("8月特徴開始者"), FORMAT
                .concat(new RString("特徴8月開始者区分")).concat(FORMAT)),
        /**
         * 10月特徴開始者
         */
        十月特徴開始者(new RString("0219"), new RString("10月特徴開始者"), FORMAT
                .concat(new RString("特徴10月開始者区分")).concat(FORMAT));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private OutputOrderEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }
    }
}
