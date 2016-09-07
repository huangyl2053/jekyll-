/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120190;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInPageBreak;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsaketteihokenshain.SaishinsaKetteiTsuchishoJyohoTorikomiIchiranhyo;
import jp.co.ndensan.reams.db.dbc.business.report.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInItem;
import jp.co.ndensan.reams.db.dbc.business.report.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaMeisaiPsmEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.saishinsaketteihokenshain.SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshain.SaishinsaKetteiTsuchishoJyohoTorikomiHenshu;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票用Entityリスト作成と作成したdataを帳票に出力する。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaWriteReportProcess extends BatchKeyBreakBase<SaishinsaKetteiHokenshaInMeisaiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsaketteihokenshain.ISaishinsaKetteiHokenshaInMapper.selectAllMeisai");
    private SaishinsaKetteiTsuchishoJyohoTorikomiHenshu manager;
    private List<SaishinsaMeisaiPsmEntity> 明細情報List;
    private SaishinsaKetteiHokenshaInGokeiEntity 集計情報Entity;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * 処理年月
     */
    public static final RString PARAMETER_IN_SHORIYM;

    /**
     * 出力順ID
     */
    public static final RString PARAMETER_IN_SHUTSURYOKUJUNID;

    static {
        PARAMETER_IN_SHORIYM = new RString("shoriYM");
        PARAMETER_IN_SHUTSURYOKUJUNID = new RString("shutsuryokujunID");
    }
    @BatchWriter
    private BatchReportWriter<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> batchReportWriter;
    private ReportSourceWriter<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> reportSourceWriter;

    InputParameter<FlexibleYearMonth> shoriYM;
    InputParameter<Long> shutsuryokujunID;

    @Override
    protected void beforeExecute() {
        manager = SaishinsaKetteiTsuchishoJyohoTorikomiHenshu.createInstance();
        明細情報List = new ArrayList<>();
        集計情報Entity = new SaishinsaKetteiHokenshaInGokeiEntity();
    }

    @Override
    protected void createWriter() {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200048.getReportId(), shutsuryokujunID.getValue());
        List<RString> 改頁項目リスト = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目ID());
                }
            }
        }
        PageBreaker<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> breaker = new SaishinsaKetteiHokenshaInPageBreak(改頁項目リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200048.getReportId().value(), SubGyomuCode.DBC介護給付).
                addBreak(breaker).create();
        this.reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void keyBreakProcess(SaishinsaKetteiHokenshaInMeisaiEntity entity) {

    }

    @Override
    protected void usualProcess(SaishinsaKetteiHokenshaInMeisaiEntity entity) {
    }

    @Override
    protected void afterExecute() {

        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200048.getReportId(), shutsuryokujunID.getValue());
        List<RString> 改頁項目リスト = new ArrayList<>();
        int i = 0;
        RString 並び順の１件目 = RString.EMPTY;
        RString 並び順の２件目 = RString.EMPTY;
        RString 並び順の３件目 = RString.EMPTY;
        RString 並び順の４件目 = RString.EMPTY;
        RString 並び順の５件目 = RString.EMPTY;
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目名());
                }
                if (i == INDEX_0) {
                    並び順の１件目 = item.get項目名();
                } else if (i == INDEX_1) {
                    並び順の２件目 = item.get項目名();
                } else if (i == INDEX_2) {
                    並び順の３件目 = item.get項目名();
                } else if (i == INDEX_3) {
                    並び順の４件目 = item.get項目名();
                } else if (i == INDEX_4) {
                    並び順の５件目 = item.get項目名();
                }
                i = i + 1;
            }
        }
        集計情報Entity = manager.getSaishinsaKetteiTsuchishoSyukeiJyoho();
        明細情報List = manager.getSaishinsaKetteiTsuchishoMeisaiJyoho();
        SaishinsaKetteiTsuchishoJyohoTorikomiIchiranhyo business = new SaishinsaKetteiTsuchishoJyohoTorikomiIchiranhyo();
        List<SaishinsaKetteiHokenshaInItem> targets = business.createSaishinsaKetteiTsuchishoJyohoTorikomiIchiranData(明細情報List,
                集計情報Entity,
                shoriYM.getValue(),
                並び順の１件目,
                並び順の２件目,
                並び順の３件目,
                並び順の４件目,
                並び順の５件目,
                改頁項目リスト);
        SaishinsaKetteiHokenshaInReport report
                = SaishinsaKetteiHokenshaInReport.createFrom(targets);
        report.writeBy(reportSourceWriter);
    }
}
