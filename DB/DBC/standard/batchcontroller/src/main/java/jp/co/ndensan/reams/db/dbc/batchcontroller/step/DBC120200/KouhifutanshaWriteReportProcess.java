/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120200;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KohiFutanShaMeiSai;
import jp.co.ndensan.reams.db.dbc.business.core.KohiFutanShaShuKei;
import jp.co.ndensan.reams.db.dbc.business.core.SaishinsaKohifutanshaBunSourceData;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsaketteitsuchishojohoichiranhyo.SaishinsaKetteiTsuchishoJohoIchiranhyo;
import jp.co.ndensan.reams.db.dbc.business.report.saishinsa.SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa.SaishisaKohifutanshaInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.saishinsa.SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsa.SaishinsaKetteiTsuchishoJohoHenshu;
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

/**
 * 帳票発行処理。
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
public class KouhifutanshaWriteReportProcess extends BatchKeyBreakBase<SaishisaKohifutanshaInEntity> {

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
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.saishinsakohifutansha."
            + "IKagoKetteiKohishaMapper.select一時テーブル");

//    private static final RString KAI_PAGE_HIHOKENSHA = new RString("listLower_2");
    @BatchWriter
    private BatchReportWriter<SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource> batchReportWriter;
    private ReportSourceWriter<SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource> reportSourceWriter;

    List<SaishisaKohifutanshaInEntity> entityList;

    InputParameter<FlexibleYearMonth> shoriYM;
    InputParameter<Long> shutsuryokujunID;

    /**
     * コンストラクタです
     *
     * @param shoriYM 処理年月
     * @param shutsuryokujunID 出力順ID
     */
    public KouhifutanshaWriteReportProcess(
            InputParameter<FlexibleYearMonth> shoriYM, InputParameter<Long> shutsuryokujunID) {
        this.shoriYM = shoriYM;
        this.shutsuryokujunID = shutsuryokujunID;
    }

    /**
     * コンストラクタです
     */
    public KouhifutanshaWriteReportProcess() {
    }

    @Override
    protected void initialize() {
        super.initialize();
        entityList = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200049.getReportId().value(), SubGyomuCode.DBC介護給付).create();
        this.reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(SaishisaKohifutanshaInEntity t) {
    }

    @Override
    protected void usualProcess(SaishisaKohifutanshaInEntity t) {
        entityList.add(t);
    }

    @Override
    protected void afterExecute() {
        SaishinsaKetteiTsuchishoJohoHenshu saishinsaFutanshaSvr = new SaishinsaKetteiTsuchishoJohoHenshu();
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200049.getReportId(), shutsuryokujunID.getValue());
        List<RString> 改頁項目リスト = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目名());
                }
            }
        }
        RString 改頁 = (並び順 == null ? RString.EMPTY : 並び順.getFormated改頁項目());
        KohiFutanShaShuKei 集計情報Entity = saishinsaFutanshaSvr.getSaishinsaKetteiTsuchishoShukeiJohoData();

        List<KohiFutanShaMeiSai> 明細情報Entityリスト
                = saishinsaFutanshaSvr.getSaishinsaKetteiTsuchishoMeisaiJohoData();

        SaishinsaKetteiTsuchishoJohoIchiranhyo saishinsaKetteiSvr = new SaishinsaKetteiTsuchishoJohoIchiranhyo();
        List<SaishinsaKohifutanshaBunSourceData> 帳票用ソースデータリスト
                = saishinsaKetteiSvr.createSaishinsaKetteiTsuchishoJohoIchiranData(
                        明細情報Entityリスト, 集計情報Entity, shoriYM.getValue(), 改頁項目リスト, 改頁);

        SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunReport report
                = new SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunReport(帳票用ソースデータリスト);
        report.writeBy(reportSourceWriter);
    }

}
