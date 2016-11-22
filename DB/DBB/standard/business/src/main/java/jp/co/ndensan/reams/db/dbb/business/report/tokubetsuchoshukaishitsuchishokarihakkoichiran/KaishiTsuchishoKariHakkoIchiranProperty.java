/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表KaishiTsuchishoKariHakkoIchiranPropertyクラスです。
 *
 * @reamsid_L DBB-0790-060 surun
 */
public class KaishiTsuchishoKariHakkoIchiranProperty extends
        ReportPropertyBase<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> {

    private static final RString FORMAT = new RString("\"");

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.listLower_1.name())
    ));

    /**
     * コンストラクタです。
     */
    public KaishiTsuchishoKariHakkoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200001.getReportId());
    }

    @Override
    public Breakers<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> defineBreakers(
            Breakers<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> breakers,
            BreakerCatalog<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(
            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> occuredBreak(
                    ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> currentRecord,
                    ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    /**
     * 特別徴収開始通知書（仮算定）発行一覧表 出力順設定可能項目です。
     */
    public enum BreakerFieldsEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("郵便番号"), FORMAT.concat(new RString("atesaki_yubinNo")).concat(FORMAT)),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("町域コード"), FORMAT.concat(new RString("atesaki_choikiCode")).concat(FORMAT)),
        /**
         * 番地コード
         */
        番地コード(new RString("0003"), new RString("番地コード"), new RString("\"番地コード\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("行政区コード"), FORMAT.concat(new RString("atesaki_gyoseikuCode")).concat(FORMAT)),
        /**
         * 地区１
         */
        地区１(new RString("0005"), new RString("地区１"), FORMAT.concat(new RString("atesaki_chikuCode1")).concat(FORMAT)),
        /**
         * 地区２
         */
        地区２(new RString("0006"), new RString("地区２"), FORMAT.concat(new RString("atesaki_chikuCode2")).concat(FORMAT)),
        /**
         * 地区３
         */
        地区３(new RString("0007"), new RString("地区３"), FORMAT.concat(new RString("atesaki_chikuCode3")).concat(FORMAT)),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("世帯コード"), FORMAT.concat(new RString("atena_setaiCode")).concat(FORMAT)),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("識別コード"), FORMAT.concat(new RString("atena_shikibetsuCode")).concat(FORMAT)),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), FORMAT.concat(new RString("atena_kanaMeisho")).concat(FORMAT)),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString("生年月日"), FORMAT.concat(new RString("atena_seinengappiYMD")).concat(FORMAT)),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString("性別"), FORMAT.concat(new RString("atena_seibetsuCode")).concat(FORMAT)),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), FORMAT.concat(new RString("dbT2015KeisangoJoho_fukaShichosonCode")).concat(FORMAT)),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), FORMAT
                .concat(new RString("dbT2015KeisangoJoho_hihokenshaNo")).concat(FORMAT)),
        /**
         * 年金コード
         */
        年金コード(new RString("0206"), new RString("年金コード"), FORMAT
                .concat(new RString("nenkinTokuchoKaifuJoho_nenkinCode")).concat(FORMAT)),
        /**
         * 生活保護種別
         */
        生活保護種別(new RString("0116"), new RString("生活保護種別"), FORMAT
                .concat(new RString("dbT2015KeisangoJoho_seihofujoShurui")).concat(FORMAT)),
        /**
         * 納組コード
         */
        納組コード(new RString("0208"), new RString("納組コード"), FORMAT.concat(new RString("caT0714SeikyuHoho_nokumiCode")).concat(FORMAT)),
        /**
         * 調定事由
         */
        調定事由(new RString("0212"), new RString("調定事由"), FORMAT.concat(new RString("dbT2015KeisangoJoho_choteiJiyu1")).concat(FORMAT));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private BreakerFieldsEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
