/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020;

import jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist.ShoriKekkaKakuninListReport;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan.JigyoHokokuGeppoShoriKekkaKakuninListProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogaku.ShoriKekkaKakuninListRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.shorikekkakakuninlist.ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.api.BatchInfo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特定入所者管理情報処理結果確認リストのバッチ処理クラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class TokuteiNyushoshaJohoKekkaKakuninProcess extends BatchProcessBase<ShoriKekkaKakuninListRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence."
            + "db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper.getTokuteiNyushoshaGengakuNinteiSyoriKakuninRisuto");
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");

    private JigyoHokokuGeppoShoriKekkaKakuninListProcessParameter processParameter;
    private RString 保険者番号;
    private RString 保険者名;

    @BatchWriter
    private BatchReportWriter<ShoriKekkaKakuninListReportSource> batchWrite;
    private ReportSourceWriter<ShoriKekkaKakuninListReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        保険者番号 = 地方公共団体.get地方公共団体コード().value();
        if (過去集計分旧市町村区分.equals(processParameter.get過去集計分旧市町村区分())) {
            保険者名 = 固定文字列_旧.concat(地方公共団体.get市町村名());
        } else {
            保険者名 = 地方公共団体.get市町村名();
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBU200002.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(ShoriKekkaKakuninListRelateEntity entity) {
        ShoriKekkaKakuninListEntity reportData = new ShoriKekkaKakuninListEntity();
        reportData.set作成日時(processParameter.get処理日時().getRDateTime());
        reportData.set保険者名(保険者名);
        reportData.set保険者番号(保険者番号);
        reportData.setプログラムID(processParameter.getバッチID());
        reportData.set処理名称(BatchInfo.getBatchName(SubGyomuCode.DBU介護統計報告, processParameter.getバッチID()));
        reportData.set項目コード1(entity.getKomokuNo1());
        reportData.set項目コード2(entity.getKomokuNo2());
        reportData.set項目コード3(entity.getKomokuNo3());
        reportData.set項目コード4(entity.getKomokuNo4());
        reportData.set項目値1(entity.getKomoku1());
        reportData.set項目値2(entity.getKomoku2());
        reportData.set項目値3(entity.getKomoku3());
        reportData.set項目値4(entity.getKomoku4());
        reportData.set内容1(entity.getNaiYou1());
        reportData.set内容2(entity.getNaiYou2());
        ShoriKekkaKakuninListReport report = new ShoriKekkaKakuninListReport(reportData);
        report.writeBy(reportSourceWriter);
    }

}
