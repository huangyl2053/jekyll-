/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaicihiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 「本算定賦課計算」property
 *
 * @reamsid_L DBB-0730-030 lijunjun
 */
public class HonsanteiKekkaIcihiranProperty extends ReportPropertyBase<HonsanteiKekkaIcihiranReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString(
            HonsanteiKekkaIcihiranReportSource.ReportSourceFields.listUpper_1.name())));

    /**
     * コンストラクタです。
     */
    public HonsanteiKekkaIcihiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200009.getReportId());
    }

    @Override
    public Breakers<HonsanteiKekkaIcihiranReportSource> defineBreakers(
            Breakers<HonsanteiKekkaIcihiranReportSource> breakers,
            BreakerCatalog<HonsanteiKekkaIcihiranReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(







            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<HonsanteiKekkaIcihiranReportSource> occuredBreak(
                    ReportLineRecord<HonsanteiKekkaIcihiranReportSource> currentRecord,
                    ReportLineRecord<HonsanteiKekkaIcihiranReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    /**
     * 帳票分類ID「DBB200009_HonsanteiKekkaIcihiran」（本算定賦課計算）出力順設定可能項目です。
     */
    public enum DBB200009ShutsuryokujunEnum implements IReportItems {

        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString(""), new RString("setaiCode")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), new RString("shikibetsuCode")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), new RString("shimei50onKana")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("hihokenshaNo"));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB200009ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
