/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC010010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.dbc100029.JyuryoItakuKeiyakuKakuninShoReport;
import jp.co.ndensan.reams.db.dbc.business.report.dbc100030.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoReport;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200013.JuryoIninShoninKakuninshoIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc010010.JuryoininKeiyakuShoninKakuninshoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010010.BusinessEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010010.JuryoininKeiyakuShoninKakuninshoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200013.JuryoIninShoninKakuninshoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100029.JyuryoItakuKeiyakuKakuninShoSource;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100030.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200013.JuryoIninShoninKakuninshoIchiranSource;
import jp.co.ndensan.reams.db.dbc.service.core.juryoininkeiyakushoninkakuninsho.JuryoininKeiyakuShoninKakuninshoService;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険受領委任契約承認（不承認）確認書のProcessです。
 *
 * @reamsid_L DBC-1910-030 yuanzhenxia
 */
public class JuryoininKeiyakuShoninKakuninshoProcess extends BatchKeyBreakBase<JuryoininKeiyakuShoninKakuninshoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc010010.IJuryoininKeiyakuShoninKakuninshoMapper.get受領委任データ");
    private JuryoininKeiyakuShoninKakuninshoProcessParameter proParameter;
    private static final ReportId 利用者向け帳票ID = ReportIdDBC.DBC100029.getReportId();
    private static final ReportId 事業者用帳票ID = ReportIdDBC.DBC100030.getReportId();
    private static final ReportId 一覧表帳票ID = ReportIdDBC.DBC200013.getReportId();
    private static final RString 対象データは存在しません = new RString("＊＊　対象データは存在しません　＊＊");
    private static final RString CODE = new RString("003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 帳票名 = new RString("受領委任契約承認（不承認）確認書");
    private static final RString なし = new RString("なし");
    private static final RString 契約申請日 = new RString("【契約申請日】：");
    private static final RString 契約決定日 = new RString("【契約決定日】：");
    private static final RString 発行済 = new RString("【発行済␣␣】：");
    private static final RString 発行済を出力する = new RString("発行済を出力する");
    private static final RString 発行済を出力しない = new RString("発行済を出力しない");
    private static final RString TWO = new RString("2");
    private static final RString 帳票制御汎用キー_帳票タイトル = new RString("帳票タイトル");
    private IOutputOrder 出力順;
    private static final RString ORDERBY = new RString("order by");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString STRING = new RString("　～　");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private JuryoininKeiyakuShoninKakuninshoProcessCore breakProcessCore;
    private BatchReportWriter<JyuryoItakuKeiyakuKakuninShoSource> 利用者向けReportWriter;
    private ReportSourceWriter<JyuryoItakuKeiyakuKakuninShoSource> 利用者向けSourceWriter;
    private BatchReportWriter<JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource> 事業者用ReportWriter;
    private ReportSourceWriter<JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource> 事業者用SourceWriter;
    private BatchReportWriter<JuryoIninShoninKakuninshoIchiranSource> 一覧表ReportWriter;
    private ReportSourceWriter<JuryoIninShoninKakuninshoIchiranSource> 一覧表SourceWriter;
    private boolean flag;
    private int count;
    private NinshoshaSource 利用者向け認証者情報;
    private NinshoshaSource 事業者用認証者情報;
    private RString 利用者向け帳票タイトル;
    private RString 事業者帳票タイトル;
    @BatchWriter
    private BatchPermanentTableWriter 償還受領委任契約者;

    @Override
    protected void initialize() {
        flag = true;
        count = 1;
        if (!RString.isNullOrEmpty(proParameter.get改頁出力順()) && !ZERO.equals(proParameter.get改頁出力順())) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBC介護給付,
                    利用者向け帳票ID, UrControlDataFactory.createInstance().getLoginInfo().getUserId(),
                    Long.valueOf(proParameter.get改頁出力順().toString()));
            if (出力順 != null) {
                proParameter.set改頁出力順(MyBatisOrderByClauseCreator.create(
                        JuryoininKeiyakuShoninKakuninshoOutputOrder.class, 出力順).replace(ORDERBY, RString.EMPTY));
            }
        } else {
            proParameter.set改頁出力順(null);
        }
        償還受領委任契約者 = new BatchPermanentTableWriter(DbT3078ShokanJuryoininKeiyakushaEntity.class);
        breakProcessCore = new JuryoininKeiyakuShoninKakuninshoProcessCore(出力順);
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        利用者向け帳票タイトル = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル, 利用者向け帳票ID);
        事業者帳票タイトル = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル, 事業者用帳票ID);
        proParameter.set利用者向けタイトル(利用者向け帳票タイトル);
        proParameter.set事業者用タイトル(事業者帳票タイトル);
        proParameter.set利用者向け通知文1(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 利用者向け帳票ID,
                KamokuCode.EMPTY, INT_1, INT_1, FlexibleDate.getNowDate()));
        proParameter.set利用者向け通知文2(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 利用者向け帳票ID,
                KamokuCode.EMPTY, INT_1, INT_2, FlexibleDate.getNowDate()));
        proParameter.set事業者用通知文1(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 事業者用帳票ID,
                KamokuCode.EMPTY, INT_1, INT_1, FlexibleDate.getNowDate()));
        proParameter.set事業者用通知文2(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 事業者用帳票ID,
                KamokuCode.EMPTY, INT_1, INT_2, FlexibleDate.getNowDate()));

    }

    @Override
    protected void keyBreakProcess(JuryoininKeiyakuShoninKakuninshoEntity t) {
    }

    @Override
    protected void usualProcess(JuryoininKeiyakuShoninKakuninshoEntity entity) {
        flag = false;
        entity.setページ(count);
        JuryoininKeiyakuShoninKakuninshoService service = new JuryoininKeiyakuShoninKakuninshoService();
        DbT3078ShokanJuryoininKeiyakushaEntity 償還受領委任契約者Entity = entity.get償還受領委任契約者();
        BusinessEntity businessEntity = service.setJuryoininShouninkakuninshoChouhyouSakusei(entity);
        JyuryoItakuKeiyakuKakuninShoReport 利用者向けReport = new JyuryoItakuKeiyakuKakuninShoReport(
                breakProcessCore.edit利用者向けEntity(businessEntity, 利用者向け認証者情報, proParameter));
        利用者向けReport.writeBy(利用者向けSourceWriter);

        JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoReport 事業者Report = new JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoReport(
                breakProcessCore.edit事業者用Entity(businessEntity, 事業者用認証者情報, proParameter));
        事業者Report.writeBy(事業者用SourceWriter);

        JuryoIninShoninKakuninshoIchiranReport 一覧表Report = new JuryoIninShoninKakuninshoIchiranReport(
                breakProcessCore.edit一覧表Entity(businessEntity.get一覧表Entity(), proParameter));
        一覧表Report.writeBy(一覧表SourceWriter);

        償還受領委任契約者Entity.setShoninKekkaTsuchiSakuseiYMD(proParameter.get通知日());
        if (ONE.equals(償還受領委任契約者Entity.getShoninKekkaTsuchiSaiHakkoKubun())) {
            償還受領委任契約者Entity.setShoninKekkaTsuchiSaiHakkoKubun(RString.EMPTY);
        }
        償還受領委任契約者.update(償還受領委任契約者Entity);
        count++;
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE), 被保険者番号,
                entity.get償還受領委任契約者().getHihokenshaNo().value());
        AccessLogger.log(AccessLogType.照会, PersonalData.of(entity.get識別コード(), expandedInfo));
    }

    @Override
    protected void afterExecute() {
        if (flag) {
            JuryoIninShoninKakuninshoIchiranEntity entity = new JuryoIninShoninKakuninshoIchiranEntity();
            entity.set被保険者氏名2(対象データは存在しません);
            JuryoIninShoninKakuninshoIchiranReport 一覧表Report = new JuryoIninShoninKakuninshoIchiranReport(
                    breakProcessCore.edit一覧表Entity(entity, proParameter));
            一覧表Report.writeBy(一覧表SourceWriter);
        }
        利用者向けReportWriter.close();
        事業者用ReportWriter.close();
        一覧表ReportWriter.close();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                利用者向け帳票ID.value(),
                proParameter.get市町村コード().value(),
                proParameter.get市町村名称(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                new RString(String.valueOf(利用者向けSourceWriter.pageCount().value())),
                なし,
                RString.EMPTY,
                getOutputJokenhyoParam());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, proParameter.toJuryoininKeiyakuShoninKakuninshoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        if (!breakProcessCore.is改頁()) {
            利用者向けReportWriter = BatchReportFactory.createBatchReportWriter(利用者向け帳票ID.value()).create();
        } else {
            利用者向けReportWriter = BatchReportFactory.createBatchReportWriter(利用者向け帳票ID.value()).addBreak(
                    new JyuryoItakuKeiyakuKakuninShoPageBreak(breakProcessCore.改頁項())).create();
        }
        利用者向けSourceWriter = new ReportSourceWriter<>(利用者向けReportWriter);

        if (!breakProcessCore.is改頁()) {
            事業者用ReportWriter = BatchReportFactory.createBatchReportWriter(事業者用帳票ID.value()).create();
        } else {
            事業者用ReportWriter = BatchReportFactory.createBatchReportWriter(事業者用帳票ID.value()).addBreak(
                    new JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoPageBreak(breakProcessCore.改頁項())).create();
        }
        事業者用SourceWriter = new ReportSourceWriter<>(事業者用ReportWriter);
        if (!breakProcessCore.is改頁()) {
            一覧表ReportWriter = BatchReportFactory.createBatchReportWriter(一覧表帳票ID.value()).create();
        } else {
            一覧表ReportWriter = BatchReportFactory.createBatchReportWriter(一覧表帳票ID.value()).addBreak(
                    new JuryoIninShoninKakuninshoIchiranPageBreak(breakProcessCore.改頁項())).create();
        }
        一覧表SourceWriter = new ReportSourceWriter<>(一覧表ReportWriter);
        利用者向け認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 利用者向け帳票ID,
                new FlexibleDate(proParameter.get処理日時().getDate().toString()), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, 利用者向けSourceWriter);
        事業者用認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 事業者用帳票ID,
                new FlexibleDate(proParameter.get処理日時().getDate().toString()), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, 事業者用SourceWriter);
    }

    /**
     * 出力条件表を編集します。
     *
     * @return 出力条件表
     */
    public List<RString> getOutputJokenhyoParam() {
        List<RString> outputJokenhyoList = new ArrayList<>();
        RString tmp = RString.EMPTY;
        tmp = tmp.concat(契約申請日);
        if (proParameter.get契約申請日開始() != null && proParameter.get契約申請日終了() != null) {
            tmp = tmp.concat(proParameter.get契約申請日開始().toString()).concat(STRING)
                    .concat(proParameter.get契約申請日終了().toString());
        } else if (proParameter.get契約申請日開始() != null) {
            tmp = tmp.concat(proParameter.get契約申請日開始().toString()).concat(STRING);
        } else if (proParameter.get契約申請日終了() != null) {
            tmp = tmp.concat(STRING).concat(proParameter.get契約申請日終了().toString());
        }
        outputJokenhyoList.add(tmp);
        tmp = RString.EMPTY;
        tmp = tmp.concat(契約決定日);
        if (proParameter.get契約決定日開始() != null && proParameter.get契約決定日終了() != null) {
            tmp = tmp.concat(proParameter.get契約決定日開始().toString()).concat(STRING)
                    .concat(proParameter.get契約決定日終了().toString());
        } else if (proParameter.get契約決定日開始() != null) {
            tmp = tmp.concat(proParameter.get契約決定日開始().toString()).concat(STRING);
        } else if (proParameter.get契約決定日終了() != null) {
            tmp = tmp.concat(STRING).concat(proParameter.get契約決定日終了().toString());
        }
        outputJokenhyoList.add(tmp);
        tmp = RString.EMPTY;
        tmp = tmp.concat(発行済);
        if (proParameter.get発行済() != null) {
            if (ONE.equals(proParameter.get発行済())) {
                tmp = tmp.concat(発行済を出力する);
            } else if (TWO.equals(proParameter.get発行済())) {
                tmp = tmp.concat(発行済を出力しない);
            }
        }
        outputJokenhyoList.add(tmp);
        return outputJokenhyoList;
    }

    private RString get帳票制御汎用(ChohyoSeigyoHanyoManager 帳票制御汎用Manager, RString 項目名, ReportId 帳票ID) {
        RString 設定値 = RString.EMPTY;
        ChohyoSeigyoHanyo chohyoSeigyoHanyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票ID,
                FlexibleYear.MIN, 項目名);
        if (chohyoSeigyoHanyo != null) {
            設定値 = chohyoSeigyoHanyo.get設定値();
        }
        return 設定値;
    }
}
