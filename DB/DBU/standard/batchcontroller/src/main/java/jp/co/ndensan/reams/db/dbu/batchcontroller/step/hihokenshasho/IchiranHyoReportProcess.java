/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoReport;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hihokenshasho.IkkatsuHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.IkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshashohakkoichiranhyo.IchiranyoShohakkoshaEntity;
import jp.co.ndensan.reams.db.dbu.service.core.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoFinder;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
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
 * 帳票「被保険者証発行一覧表」の出力処理クラスです。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 *
 */
public class IchiranHyoReportProcess extends BatchProcessBase<IkkatsuHakkoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho.IIkkatsuHakkoMapper.getHihokenshaIchiran");
    private static final ReportId 帳票ID = ReportIdDBA.DBA200003.getReportId();
    private List<IkkatsuHakkoRelateEntity> 帳票用Entityリスト;
    private IkkatsuHakkoProcessParameter processPrm;
    private List<HihokenshashoHakkoIchiranHyoItem> itemList;
    @BatchWriter
    private BatchReportWriter<HihokenshashoHakkoIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<HihokenshashoHakkoIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        帳票用Entityリスト = new ArrayList<>();
        itemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toIkkatsuHakkoMybatisParameter());

    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(IkkatsuHakkoRelateEntity entity) {
        帳票用Entityリスト.add(entity);
    }

    @Override
    protected void afterExecute() {
        List<IchiranyoShohakkoshaEntity> ichiranyoShohakkoshaEntityList = new HihokenshashoHakkoIchiranHyoFinder().
                createHihokenshashoHakkoIchiranHyo(processPrm.getKofuYMD(), 帳票用Entityリスト, get出力順());
        for (IchiranyoShohakkoshaEntity entity : ichiranyoShohakkoshaEntityList) {
            itemList.add(setItem(entity));
        }
        if (itemList != null && !itemList.isEmpty()) {
            HihokenshashoHakkoIchiranHyoReport report = HihokenshashoHakkoIchiranHyoReport.createReport(itemList);
            report.writeBy(reportSourceWriter);
        }
    }

    private HihokenshashoHakkoIchiranHyoItem setItem(IchiranyoShohakkoshaEntity entity) {
        return new HihokenshashoHakkoIchiranHyoItem(entity.get作成日付(),
                entity.get保険者名(),
                entity.get保険者番号(),
                entity.getソート順１(),
                entity.getソート順２(),
                entity.getソート順３(),
                entity.getソート順４(),
                entity.getソート順５(),
                entity.get改頁１(),
                entity.get改頁２(),
                entity.get改頁３(),
                entity.get改頁４(),
                entity.get改頁５(),
                entity.get交付事由_非交付理由タイトル(),
                entity.get帳票連番(),
                entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty() ? entity.get被保険者番号().value() : RString.EMPTY,
                entity.get氏名(),
                entity.get生年月日_年齢(),
                entity.get送付先住所(),
                entity.get要介護(),
                entity.get認定開始日_認定終了日(),
                entity.get施設名(),
                entity.get計画事業所名(),
                entity.get交付_非交付事由());
    }

    private IOutputOrder get出力順() {
        IOutputOrder shutsuryokujunId = null;
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        RString reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        if (!RString.isNullOrEmpty(processPrm.getShutsuryokujunId())) {
            shutsuryokujunId = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBA介護資格,
                    帳票ID,
                    reamsLoginID,
                    Long.valueOf(processPrm.getShutsuryokujunId().toString()));
        }
        return shutsuryokujunId;
    }

}
