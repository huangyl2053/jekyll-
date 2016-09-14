/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbt21004;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsuhihokenshasuichiran.HokenshaDankaibetsuHihokenshasuGroup;
import jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsuhihokenshasuichiran.HyojunDankaibetsuHihokenshasuGroup;
import jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsuhihokenshasuichiran.ShotokuDankaiBetsuHihokenshasuIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt21004.DankaibetuHihokensyasuIchiranhyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt21004.DankaibetuHihokensyasuIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibehihokensixya.DankaibeHihokensixyaForReport;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokudankaibetsuhihokenshasuichiran.ShotokuDankaiBetsuHihokenshasuIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 「帳票の出力」処理クラスです。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
public class ReportProcess extends BatchKeyBreakBase<DankaibeHihokensixyaForReport> {

    private DankaibetuHihokensyasuIchiranhyoProcessParameter processParameter;
    private static final RString 保険者設定段階 = new RString("1");
    private static final RString 標準段階 = new RString("2");
    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
                    + ".dankaibetsuhihokenshasuichiranhyosakusei.IDankaibetsuHihokenshasuIchiranhyoSakuseiMapper.select帳票出力対象データ");
    @BatchWriter
    private BatchReportWriter<ShotokuDankaiBetsuHihokenshasuIchiranSource> batchReportWriter;
    private ReportSourceWriter<ShotokuDankaiBetsuHihokenshasuIchiranSource> reportSourceWriter;
    private static final RString 市町村コード = new RString("1");
    List<RString> 改頁項目リスト;

    @Override
    protected void initialize() {
        super.initialize();
        改頁項目リスト = new ArrayList<>();
        改頁項目リスト.add(new RString(ShotokuDankaiBetsuHihokenshasuIchiranSource.DBB300004_ShotokuDankaiBetsuHihokenshasuIchiran.hokenshaNo.name()));
    }

    @Override
    protected void createWriter() {
        PageBreaker<ShotokuDankaiBetsuHihokenshasuIchiranSource> breaker = new ShotokuDankaiBetsuHihokenshasuIchiranSourcePageBreak(改頁項目リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB300004.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(DankaibeHihokensixyaForReport entity) {
        HokenshaDankaibetsuHihokenshasuGroup hokenshaDankaibetsu = new HokenshaDankaibetsuHihokenshasuGroup();
        HyojunDankaibetsuHihokenshasuGroup hyojunDankaibetsu = new HyojunDankaibetsuHihokenshasuGroup();
        if (保険者設定段階.equals(entity.getFlag())) {
            if (null != entity.getShichosonCode()) {
                hokenshaDankaibetsu.set市町村コード(new LasdecCode(entity.getShichosonCode().toString()));
                Association 市町村 = AssociationFinderFactory.createInstance().getAssociation(entity.getShichosonCode());
                hokenshaDankaibetsu.set市町村名称(市町村.get市町村名());
            }
            hokenshaDankaibetsu.set保険者設定段階(entity.get保険者設定段階());
            hokenshaDankaibetsu.set保険者設定人数(entity.get保険者設定());
        } else if (標準段階.equals(entity.getFlag())) {
            if (null != entity.getShichosonCode()) {
                hyojunDankaibetsu.set市町村コード(new LasdecCode(entity.getShichosonCode().toString()));
                Association 市町村 = AssociationFinderFactory.createInstance().getAssociation(entity.getShichosonCode());
                hyojunDankaibetsu.set市町村名称(市町村.get市町村名());
            }
            hyojunDankaibetsu.set保険者設定段階(entity.get保険者設定段階());
            hyojunDankaibetsu.set保険者設定人数(entity.get保険者設定());
        }
        HokenryoDankaiSettings hokenryoDankaiSettings = new HokenryoDankaiSettings();
        HokenryoDankaiList hokenryoDankaiList = hokenryoDankaiSettings.get保険料段階ListIn(processParameter.get調定年度());
        ShotokuDankaiBetsuHihokenshasuIchiranReport report
                = new ShotokuDankaiBetsuHihokenshasuIchiranReport(
                        hokenshaDankaibetsu,
                        hyojunDankaibetsu,
                        processParameter.getバッチ起動時処理日時(),
                        new RDate(processParameter.get資格基準日().toString()),
                        new RDate(processParameter.get調定基準日().toString()),
                        processParameter.get調定年度(),
                        hokenryoDankaiList);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, toMyBatisParameter());
    }

    private DankaibetuHihokensyasuIchiranhyoMyBatisParameter toMyBatisParameter() {
        DankaibetuHihokensyasuIchiranhyoMyBatisParameter parameter = new DankaibetuHihokensyasuIchiranhyoMyBatisParameter();
        parameter.set市町村コード(false);
        if (市町村コード.equals(processParameter.get市町村コード複数())) {
            parameter.set市町村コード(true);
            parameter.set市町村コード複数(processParameter.get市町村コード複数());
        }
        return parameter;
    }

    @Override
    protected void keyBreakProcess(DankaibeHihokensixyaForReport t) {
    }

}
