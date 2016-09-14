/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050;

import jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist.ShoriKekkaKakuninListReport;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippanshokanketteiym.JigyoHokokuGeppoIppanShokanProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym.JigyouHoukokuTokeiThuRelateEntity;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 処理確認リスト帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 *
 */
public class JigyoHokokuGeppoIppanShokanDBU200002Process extends BatchProcessBase<JigyouHoukokuTokeiThuRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti."
            + "IJigyoHokokuGeppoIppanShokanMapper.getJigyouHoukokuTokeiTyouhyou");
    private JigyoHokokuGeppoIppanShokanProcessParamter processParameter;
    private static final ReportId REPORT_DBU200002 = ReportIdDBU.DBU200002.getReportId();
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");
    private RString 保険者番号;
    private RString 保険者名;

    @BatchWriter
    private BatchReportWriter<ShoriKekkaKakuninListReportSource> batchWrite;
    private ReportSourceWriter<ShoriKekkaKakuninListReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
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
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toDataMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU200002.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyouHoukokuTokeiThuRelateEntity entity) {
        ShoriKekkaKakuninListEntity eucEntity = new ShoriKekkaKakuninListEntity();
        eucEntity.set作成日時(processParameter.get処理日時());
        eucEntity.set保険者番号(保険者番号);
        eucEntity.set保険者名(保険者名);
        eucEntity.set項目コード1(entity.getKomokuNo1());
        eucEntity.set項目コード2(entity.getKomokuNo2());
        eucEntity.set項目コード3(RString.EMPTY);
        eucEntity.set項目コード4(RString.EMPTY);
        eucEntity.setプログラムID(processParameter.getバッチID());
        eucEntity.set項目値1(entity.getKomoku1());
        eucEntity.set項目値2(entity.getKomoku2());
        eucEntity.set項目値3(RString.EMPTY);
        eucEntity.set項目値4(RString.EMPTY);
        eucEntity.set内容1(entity.getNaiYou1());
        eucEntity.set処理名称(BatchInfo.getBatchName(SubGyomuCode.DBU介護統計報告, processParameter.getバッチID()));
        eucEntity.set内容2(entity.getNaiYou2());
        ShoriKekkaKakuninListReport report = new ShoriKekkaKakuninListReport(eucEntity);
        report.writeBy(reportSourceWriter);
    }
}
