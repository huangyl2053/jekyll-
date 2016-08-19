/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoReport;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshasho.IchiranHyoReportBreakItem;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshasho.IchiranHyoReportShutsuryoItem;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hihokenshasho.IkkatsuHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hihokenshasho.IkkatsuHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.IkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshashohakkoichiranhyo.IchiranyoShohakkoshaEntity;
import jp.co.ndensan.reams.db.dbu.service.core.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.mybatisorderbycreator.BreakPageCreator;
import jp.co.ndensan.reams.db.dbz.business.core.mybatisorderbycreator.MyBatisOrderByCreator;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票「被保険者証発行一覧表」の出力処理クラスです。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 *
 */
public class IchiranHyoReportProcess extends BatchKeyBreakBase<IkkatsuHakkoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho.IIkkatsuHakkoMapper.getHihokenshaIchiran");
    private static final ReportId 帳票ID = ReportIdDBA.DBA200003.getReportId();
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private List<IkkatsuHakkoRelateEntity> 帳票用Entityリスト;
    private IkkatsuHakkoProcessParameter processPrm;
    private IkkatsuHakkoMybatisParameter mybatisPrm;
    private List<HihokenshashoHakkoIchiranHyoItem> itemList;
    private static List<RString> pageBreakKeys;
    @BatchWriter
    private BatchReportWriter<HihokenshashoHakkoIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<HihokenshashoHakkoIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        帳票用Entityリスト = new ArrayList<>();
        itemList = new ArrayList<>();
        getSQLOrderBy();
        getPageBreakKeys();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisPrm);

    }

    @Override
    protected void createWriter() {
        if (pageBreakKeys != null && !pageBreakKeys.isEmpty()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).
                    addBreak(new BreakerCatalog<HihokenshaDaichoHakkoIchiranhyoReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(IkkatsuHakkoRelateEntity entity) {
        AccessLogger.log(AccessLogType.照会, PersonalData.of(entity.getShikibetsuCode()));
        帳票用Entityリスト.add(entity);
    }

    @Override
    protected void afterExecute() {
        Map<Integer, RString> 改頁Map = ReportUtil.get改頁項目(SubGyomuCode.DBA介護資格,
                processPrm.getShutsuryokujunId(),
                帳票ID);
        Map<Integer, ISetSortItem> 出力順Map = ReportUtil.get出力順項目(SubGyomuCode.DBA介護資格,
                processPrm.getShutsuryokujunId(),
                帳票ID);
        List<IchiranyoShohakkoshaEntity> ichiranyoShohakkoshaEntityList = new HihokenshashoHakkoIchiranHyoFinder().
                createHihokenshashoHakkoIchiranHyo(processPrm.getKofuYMD(), 帳票用Entityリスト, 出力順Map, 改頁Map);
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

    private void getSQLOrderBy() {
        IOutputOrder shutsuryokujunId = ReportUtil.get出力順ID(SubGyomuCode.DBA介護資格,
                processPrm.getShutsuryokujunId(),
                帳票ID);
        RString orderBy = MyBatisOrderByCreator.createWithOutOrderBy(IchiranHyoReportShutsuryoItem.class, shutsuryokujunId);
        mybatisPrm = IkkatsuHakkoMybatisParameter.
                createSelectByKeyParam(processPrm.getShutsuryokuJokenCode(),
                        getKonkaiYMDHMS(processPrm.getKonkaiFromYMD(), processPrm.getKonkaiFromHMS()),
                        processPrm.getKonkaiToYMD(),
                        getKonkaiYMDHMS(processPrm.getKonkaiToYMD(), processPrm.getKonkaiToHMS()),
                        processPrm.getKonkaiKijunYMD(),
                        getKonkaiYMDHMS(processPrm.getKonkaiKijunYMD(), processPrm.getKonkaiKijunHMS()),
                        processPrm.getKofuYMD(),
                        processPrm.getShinseishoKanriNo(),
                        processPrm.getSeinengappiToYMD(),
                        processPrm.getSeinengappiFromYMD(),
                        processPrm.getHihokenshaNo(),
                        processPrm.getShikibetsuCode(),
                        processPrm.getPsmShikibetsuTaisho(),
                        processPrm.getPsmAtesaki(),
                        processPrm.getNenreiTotatsuYMD(),
                        orderBy);
    }

    private RDateTime getKonkaiYMDHMS(FlexibleDate konkaiYMD, RTime konkaiHMS) {
        RDateTime konkaiYMDHMS = RDateTime.of(konkaiYMD.getYearValue(),
                konkaiYMD.getMonthValue(),
                konkaiYMD.getDayValue(),
                konkaiHMS.getHour(),
                konkaiHMS.getMinute(),
                konkaiHMS.getSecond(),
                konkaiHMS.getMillisOfSecond());
        return konkaiYMDHMS;
    }

    private void getPageBreakKeys() {
        Map<Integer, RString> 改頁Map = ReportUtil.get改頁項目(SubGyomuCode.DBA介護資格,
                processPrm.getShutsuryokujunId(),
                帳票ID);
        List<RString> pageBreakKeyList = new ArrayList<>();
        if (!RString.isNullOrEmpty(改頁Map.get(0))) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(IchiranHyoReportBreakItem.class, 改頁Map.get(0)));
        }
        if (!RString.isNullOrEmpty(改頁Map.get(1))) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(IchiranHyoReportBreakItem.class, 改頁Map.get(1)));
        }
        if (!RString.isNullOrEmpty(改頁Map.get(2))) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(IchiranHyoReportBreakItem.class, 改頁Map.get(2)));
        }
        if (!RString.isNullOrEmpty(改頁Map.get(INT3))) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(IchiranHyoReportBreakItem.class, 改頁Map.get(INT3)));
        }
        if (!RString.isNullOrEmpty(改頁Map.get(INT4))) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(IchiranHyoReportBreakItem.class, 改頁Map.get(INT4)));
        }
        pageBreakKeys = Collections.unmodifiableList(pageBreakKeyList);

    }

    @Override
    protected void keyBreakProcess(IkkatsuHakkoRelateEntity current) {
        if (hasBrek(getBefore(), current)) {
            HihokenshashoHakkoIchiranHyoReport report = HihokenshashoHakkoIchiranHyoReport.createReport(itemList);
            report.writeBy(reportSourceWriter);
            itemList = new ArrayList<>();
        }
    }

    private boolean hasBrek(IkkatsuHakkoRelateEntity before, IkkatsuHakkoRelateEntity current) {
        return !before.getHihokenshaNo().equals(current.getHihokenshaNo());
    }

}
