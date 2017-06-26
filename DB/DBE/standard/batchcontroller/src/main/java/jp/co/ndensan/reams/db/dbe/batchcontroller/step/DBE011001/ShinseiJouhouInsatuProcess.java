/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE011001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinseimonitor.ShinseiMonitorReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinseijouhouinnsatu.ShinseiJouhouInsatuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseimonitor.ShinseiMonitorEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinseimonitor.ShinseiMonitorReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 申請情報印刷のデータを作成します。
 *
 * @reamsid_L DBE-1390-020 suguangjun
 */
public class ShinseiJouhouInsatuProcess extends BatchProcessBase<ShinseiMonitorEntity> {

    private static final ReportId REPORT_ID = ReportIdDBE.DBE011002.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseijouhouinnsatu."
            + "IShinseiJouhouInsatuRelateMapper.selectShinseiJouhou");
    private ShinseiJouhouInsatuProcessParameter processParameter;
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(ShinseiMonitorReportSource.ReportSourceFields.shichosonName.name())));
    private static final RString MIDDLELINE = RString.EMPTY;
    private static final RString 作成条件_処理日 = new RString("1");
    private static final RString 作成条件文言_処理日 = new RString("作成条件 : 処理日の範囲を指定");
    private static final RString 作成条件文言_申請日 = new RString("作成条件 : 申請日の範囲を指定");
    private static final RString 日付範囲タイトル = new RString("日付範囲 : ");
    private static final RString 指定なし文言 = new RString("指定なし");
    private static final RString 範囲文言 = new RString(" ～ ");
    private static final RString 無し = new RString("無し");
    private static final RString 全市町村 = new RString("全市町村");
    private static final RString 保険者タイトル = new RString("保険者：");
    @BatchWriter
    private BatchReportWriter<ShinseiMonitorReportSource> batchWrite;
    private ReportSourceWriter<ShinseiMonitorReportSource> reportSourceWriter;
    private int index_tmp = 0;
    private RString 導入団体コード;
    private RString 市町村名;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        processParameter.setPsmShikibetsuTaisho(new RString(uaFt200Psm.getParameterMap().
                get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toShinseiJouhouInsatuMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                .addBreak(new BreakerCatalog<ShinseiMonitorReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void afterExecute() {
        if (index_tmp == 0) {
            ShinseiMonitorEntity entity = new ShinseiMonitorEntity();
            entity.set氏名(new RString("該当データがありません"));
            ShinseiMonitorReport report = new ShinseiMonitorReport(entity, -1);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    @Override
    protected void process(ShinseiMonitorEntity entity) {
        ShinseiMonitorReport report = new ShinseiMonitorReport(entity, index_tmp);
        report.writeBy(reportSourceWriter);
        index_tmp++;
    }

    private void バッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 帳票名 = ReportIdDBE.DBE011002.getReportName();
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        RString csv出力有無 = 無し;
        RString csvファイル名 = MIDDLELINE;
        List<RString> 出力条件 = new ArrayList<>();
        if (processParameter.getShichosonCode().equals(LasdecCode.EMPTY)) {
            出力条件.add(get保険者(全市町村));
        } else {
            出力条件.add(get保険者(processParameter.getShichosonName()));
        }
        if (processParameter.getSakuseijyouken().equals(作成条件_処理日)) {
            出力条件.add(作成条件文言_処理日);
            出力条件.add(get日付範囲(processParameter.getShorikaFrom(), processParameter.getShorikaTo()));
        } else {
            出力条件.add(作成条件文言_申請日);
            出力条件.add(get日付範囲(processParameter.getShinnseikaFrom(), processParameter.getShinnseikaTo()));
        }
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE011002.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private RString get日付範囲(FlexibleDate from, FlexibleDate to) {
        if ((from == null || from.isEmpty())
                && (to == null || to.isEmpty())) {
            return 日付範囲タイトル.concat(指定なし文言);
        }
        return 日付範囲タイトル
                .concat(dateFormat(from))
                .concat(範囲文言)
                .concat(dateFormat(to));
    }

    private RString get日付範囲(RDateTime from, RDateTime to) {
        return get日付範囲(convertToFlexbleDate(from), convertToFlexbleDate(to));
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

    private FlexibleDate convertToFlexbleDate(RDateTime オリジナル) {
        if (オリジナル == null || オリジナル.getDate() == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(
                オリジナル.getDate().getYearValue(),
                オリジナル.getDate().getMonthValue(),
                オリジナル.getDate().getDayValue());
    }

    private RString get保険者(RString 保険者) {
        return 保険者タイトル.concat(保険者);
    }
}
