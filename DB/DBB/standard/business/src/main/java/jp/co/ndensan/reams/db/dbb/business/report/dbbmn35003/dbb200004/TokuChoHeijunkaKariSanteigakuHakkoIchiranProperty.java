package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
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
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表のプロパティです。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
public class TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty extends ReportPropertyBase<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> {

    private final List<RString> pageBreakKeys;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    /**
     * コンストラクタです。
     *
     * @param outputOrder outputOrder
     */
    public TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200004.getReportId());

        pageBreakKeys = new ArrayList<>();

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;

        Map<Integer, ISetSortItem> 改頁Map = ChohyoUtil.get改頁項目Map(outputOrder);
        if (改頁Map.get(INDEX_1) != null) {
            改頁１ = to帳票物理名(改頁Map.get(INDEX_1));
        }
        if (改頁Map.get(INDEX_2) != null) {
            改頁２ = to帳票物理名(改頁Map.get(INDEX_2));
        }
        if (改頁Map.get(INDEX_3) != null) {
            改頁３ = to帳票物理名(改頁Map.get(INDEX_3));
        }
        if (改頁Map.get(INDEX_4) != null) {
            改頁４ = to帳票物理名(改頁Map.get(INDEX_4));
        }
        if (改頁Map.get(INDEX_5) != null) {
            改頁５ = to帳票物理名(改頁Map.get(INDEX_5));
        }

        if (改頁１ != null && !改頁１.isEmpty()) {
            pageBreakKeys.add(改頁１);
        }
        if (改頁２ != null && !改頁２.isEmpty()) {
            pageBreakKeys.add(改頁２);
        }
        if (改頁３ != null && !改頁３.isEmpty()) {
            pageBreakKeys.add(改頁３);
        }
        if (改頁４ != null && !改頁４.isEmpty()) {
            pageBreakKeys.add(改頁４);
        }
        if (改頁５ != null && !改頁５.isEmpty()) {
            pageBreakKeys.add(改頁５);
        }
    }

    @Override
    public Breakers<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> defineBreakers(
            Breakers<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> breakers,
            BreakerCatalog<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            pageBreakKeys) {
            @Override
            public ReportLineRecord<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> occuredBreak(
                    ReportLineRecord<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> currentRecord,
                    ReportLineRecord<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    private RString to帳票物理名(ISetSortItem 項目) {

        RString 帳票物理名 = RString.EMPTY;

        if (DBB100012ShutsuryokujunEnum.郵便番号.get項目ID().equals(項目.get項目ID())) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_郵便;
        } else if (DBB100012ShutsuryokujunEnum.行政区コード.get項目ID().equals(項目.get項目ID())) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_行政区コード;
        } else if (DBB100012ShutsuryokujunEnum.世帯コード.get項目ID().equals(項目.get項目ID())) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_世帯コード;
        } else if (DBB100012ShutsuryokujunEnum.生年月日.get項目ID().equals(項目.get項目ID())) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_生年月日;
        } else if (DBB100012ShutsuryokujunEnum.性別.get項目ID().equals(項目.get項目ID())) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_性別;
        } else if (DBB100012ShutsuryokujunEnum.市町村コード.get項目ID().equals(項目.get項目ID())) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_市町村コード;
        }

        return 帳票物理名;
    }

    /**
     * 帳票分類ID「DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo」（仮算定額変更通知書(平準化)）出力順設定可能項目です。
     */
    public enum DBB100012ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString(""), new RString("\"atena_yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), new RString("\"atena_choikiCode\"")),
        /**
         * 番地コード
         */
        番地コード(new RString("0003"), new RString(""), new RString("\"atesaki_banchi\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), new RString("\"atena_gyoseikuCode\"")),
        /**
         * 地区１
         */
        地区１(new RString("0005"), new RString(""), new RString("\"atesaki_chiku1\"")),
        /**
         * 地区２
         */
        地区２(new RString("0006"), new RString(""), new RString("\"atesaki_chiku2\"")),
        /**
         * 地区３
         */
        地区３(new RString("0007"), new RString(""), new RString("\"atesaki_chiku3\"")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString(""), new RString("\"atena_setaiCode\"")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), new RString("\"atena_shikibetsuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"atena_kanaShimei\"")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString(""), new RString("\"atena_seinengappiYMD\"")),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString(""), new RString("\"atena_seibetsuCode\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), new RString("\"koseigo_fukaShichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("\"koseigo_hihokenshaNo\"")),
        /**
         * 年金コード
         */
        年金コード(new RString("0206"), new RString(""), new RString("\"nenkinTokuchoKaifuJoho_nenkinCode\"")),
        /**
         * 納組コード
         */
        納組コード(new RString("0208"), new RString(""), new RString("\"caT0714SeikyuHoho_nokumiCode\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB100012ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
