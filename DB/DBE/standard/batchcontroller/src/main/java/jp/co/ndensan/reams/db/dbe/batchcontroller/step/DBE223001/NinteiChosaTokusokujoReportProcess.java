/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE223001;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokujyo.NinteiChosaTokusokujoOutputJokenhyoEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokujyo.NinteiChosaTokusokujoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosatokusokujyo.NinteiChosaTokusokujoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo.AtenaKikan;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo.NinteiChosaTokusokujoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosatokusokujyo.NinteiChosaTokusokujoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosatokusokujyo.INinteichosaTokusokujyoRelateMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;

/**
 * 要介護認定調査督促状の作成クラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
public class NinteiChosaTokusokujoReportProcess extends BatchProcessBase<NinteiChosaTokusokujoRelateEntity> {

    private NinteiChosaTokusokujoProcessParameter paramter;
    private static final ReportId REPORT_DBE223001 = ReportIdDBE.DBE223001_NinteiChosaTokusokujo.getReportId();
    @BatchWriter
    private BatchReportWriter<NinteiChosaTokusokujoReportSource> batchWrite;
    private ReportSourceWriter<NinteiChosaTokusokujoReportSource> reportSourceWriter;

    @BatchWriter
    private BatchPermanentTableWriter<DbT5201NinteichosaIraiJohoEntity> dbT5201TableWriter;

    INinteichosaTokusokujyoRelateMapper mapper;

    private final int パターン番号_1 = 1;
    RString 文書番号;
    NinshoshaSource ninshoshaSource;
    Map<Integer, RString> 通知文;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosatokusokujyo."
                    + "INinteichosaTokusokujyoRelateMapper.select要介護認定調査督促状ByKey");

    @Override
    protected void beforeExecute() {
        mapper = getMapper(INinteichosaTokusokujyoRelateMapper.class);
        getKyotsuData();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toNinteiChosaTokusokujoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBE223001.value(), SubGyomuCode.DBE認定支援).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
        dbT5201TableWriter = new BatchPermanentTableWriter<>(DbT5201NinteichosaIraiJohoEntity.class);
    }

    @Override
    protected void process(NinteiChosaTokusokujoRelateEntity entity) {
        NinteiChosaTokusokujoReport report = new NinteiChosaTokusokujoReport(
                entity.get認定申請情報(), ninshoshaSource, entity.get宛名機関(),
                文書番号, 通知文, createCustomerBarCode(entity.get宛名機関()));
        report.writeBy(reportSourceWriter);

        DbT5201NinteichosaIraiJohoEntity dbT5201Entity = entity.get認定調査依頼情報();
        dbT5201Entity.setNinteichosaTokusokuYMD(paramter.getTemp_督促日());
        dbT5201Entity.setNinteichosaTokusokuMemo(paramter.getTemp_督促メモ());
        dbT5201Entity.setNinteichosaTokusokuHoho(paramter.getTemp_督促方法());
        dbT5201Entity.setNinteichosaIraiKaisu(dbT5201Entity.getNinteichosaIraiKaisu() + 1);
        dbT5201TableWriter.update(dbT5201Entity);
    }

    @Override
    protected void afterExecute() {
        NinteiChosaTokusokujoOutputJokenhyoEditor outputJokenhyoEditor = new NinteiChosaTokusokujoOutputJokenhyoEditor(paramter);
        List<RString> 条件リスト = outputJokenhyoEditor.edit();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ = new ReportOutputJokenhyoItem(
                REPORT_DBE223001.value(),
                association.get地方公共団体コード().value(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                ReportInfo.getReportName(SubGyomuCode.DBE認定支援, REPORT_DBE223001.value()),
                new RString(batchWrite.getPageCount()),
                new RString("なし"),
                RString.EMPTY,
                条件リスト);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }

    private void getKyotsuData() {
        文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, REPORT_DBE223001, paramter.getTemp_基準日());
        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, REPORT_DBE223001, paramter.getTemp_基準日(),
                NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, REPORT_DBE223001, KamokuCode.EMPTY, パターン番号_1);
    }

    private RString createCustomerBarCode(AtenaKikan atenaKikan) {
        RString 宛名郵便番号 = RString.EMPTY;
        if (atenaKikan.get宛名郵便番号() != null) {
            宛名郵便番号 = atenaKikan.get宛名郵便番号().getColumnValue();
        }
        RString 住所 = RString.EMPTY;
        if (atenaKikan.get宛名住所() != null) {
            住所 = atenaKikan.get宛名住所();
        }
        return ReportUtil.getCustomerBarCode(宛名郵便番号, 住所);
    }
}
