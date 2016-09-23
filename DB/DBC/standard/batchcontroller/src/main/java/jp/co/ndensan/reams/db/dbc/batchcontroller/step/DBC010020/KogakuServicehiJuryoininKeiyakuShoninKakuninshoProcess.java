/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC010020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.dbc100031.KogakuServiceHiJyuryoItakuKeiyakuKakuninShoReport;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200013.JuryoIninShoninKakuninshoIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehijuryoininkeiyakushoninkakuninsho.KogakuServicehiJuryoininProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010020.KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010020.ServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200013.JuryoIninShoninKakuninshoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100031.KogakuServiceHiJyuryoItakuKeiyakuKakuninShoSource;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200013.JuryoIninShoninKakuninshoIchiranSource;
import jp.co.ndensan.reams.db.dbc.service.core.kogakuservicehijuryoininkeiyakushoninkakuninsho.KogakuServicehiJuryoininKeiyakuShoninService;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
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
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成のバッチプロセスクラスです。
 *
 * @reamsid_L DBC-1970-030 zhouchuanlin
 */
public class KogakuServicehiJuryoininKeiyakuShoninKakuninshoProcess extends BatchKeyBreakBase<KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity> {

    private static final RString ORDER_BY = new RString("order by");
    private static final RString 首長名印字位置_1 = new RString("1");
    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc010020."
            + "IKogakuServicehiJuryoininKeiyakuShoninKakuninshoMapper.get高額受領委任契約事業者情報データ");
    private static final RString 文字列_003 = new RString("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 対象データは存在しません = new RString("＊＊　対象データは存在しません　＊＊");
    private static final RString なし = new RString("なし");
    private static final RString 契約申請日 = new RString("【契約申請日】：");
    private static final RString 契約決定日 = new RString("【契約決定日】：");
    private static final RString 波線 = new RString("～");
    private static final RString 発行済 = new RString("【発行済  】：");
    private static final RString 発行済_1 = new RString("1");
    private static final RString 発行済_2 = new RString("2");
    private static final RString 発行済を出力する = new RString("発行済を出力する");
    private static final RString 発行済を出力しない = new RString("発行済を出力しない");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final int パターン番号_1 = 1;
    private static final int 項目番号_1 = 1;
    private static final int 項目番号_2 = 2;
    private KogakuServicehiJuryoininProcessParameter processParameter;
    private KogakuServiceHiJyuryoItakuKeiyakuKakuninShoProcessCore breakProcessCore;
    private IOutputOrder 出力順;
    private Association 導入団体クラス;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private int ページ = 0;
    private RString 通知文1 = RString.EMPTY;
    private RString 通知文2 = RString.EMPTY;
    private NinshoshaSource 確認書認証者情報;
    private boolean is公印に掛ける;
    private boolean is公印を省略;
    private Ninshosha 認証者;
    private BatchReportWriter<KogakuServiceHiJyuryoItakuKeiyakuKakuninShoSource> 確認書ReportWriter;
    private ReportSourceWriter<KogakuServiceHiJyuryoItakuKeiyakuKakuninShoSource> 確認書SourceWriter;
    private BatchReportWriter<JuryoIninShoninKakuninshoIchiranSource> 一覧表ReportWriter;
    private ReportSourceWriter<JuryoIninShoninKakuninshoIchiranSource> 一覧表SourceWriter;
    @BatchWriter
    private BatchPermanentTableWriter 高額受領委任契約事業者;

    @Override
    protected void initialize() {
        導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        if (!RString.isNullOrEmpty(processParameter.get改頁出力順ID()) && !ZERO.equals(processParameter.get改頁出力順ID())) {
            出力順 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100031.getReportId(), Long.valueOf(processParameter.get改頁出力順ID().toString()));
            if (出力順 != null) {
                processParameter.set出力順(MyBatisOrderByClauseCreator.create(KogakuServicehiJuryoininKeiyakuShoninKakuninshoOutputOrder.class,
                        出力順).replace(ORDER_BY, RString.EMPTY));
            }
        } else {
            processParameter.set出力順(null);
        }
        breakProcessCore = new KogakuServiceHiJyuryoItakuKeiyakuKakuninShoProcessCore(出力順);
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100031.getReportId());
        if (首長名印字位置_1.equals(帳票制御共通.get首長名印字位置())) {
            is公印に掛ける = true;
        }
        if (!帳票制御共通.is電子公印印字有無()) {
            is公印を省略 = true;
        }
        認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), processParameter.get通知日());
        通知文1 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100031.getReportId(),
                KamokuCode.EMPTY, パターン番号_1, 項目番号_1, FlexibleDate.getNowDate());
        通知文2 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100031.getReportId(),
                KamokuCode.EMPTY, パターン番号_1, 項目番号_2, FlexibleDate.getNowDate());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, processParameter.toKogakuServicehiJuryoininKeiyakuShoninKakuninshoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        高額受領委任契約事業者 = new BatchPermanentTableWriter(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity.class);
        if (!breakProcessCore.is改頁()) {
            一覧表ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200013.getReportId().value()).create();
        } else {
            一覧表ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200013.getReportId().value()).addBreak(
                    new KogakuServicehiJuryoininKeiyakuShoninKakuninshoPageBreak(breakProcessCore.改頁項())).create();
        }
        一覧表SourceWriter = new ReportSourceWriter<>(一覧表ReportWriter);
        確認書ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100031.getReportId().value()).create();
        確認書SourceWriter = new ReportSourceWriter<>(確認書ReportWriter);
        確認書認証者情報 = NinshoshaSourceBuilderFactory.createInstance(認証者, 導入団体クラス, 確認書ReportWriter.getImageFolderPath(),
                new RDate(processParameter.get通知日().toString()), is公印に掛ける, is公印を省略, KenmeiFuyoKubunType.付与なし).buildSource();
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void keyBreakProcess(KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity entity) {
    }

    @Override
    protected void usualProcess(KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity entity) {
        ページ++;
        KogakuServicehiJuryoininKeiyakuShoninService service = new KogakuServicehiJuryoininKeiyakuShoninService();
        DbT3076KogakuJuryoininKeiyakuJigyoshaEntity 高額介護事業者Entity = entity.get高額介護事業者();
        ServiceEntity serviceEntity = service.setKogakuServicehiJuryoininKeiyakuShoninKakuninshoService(entity, ページ);
        JuryoIninShoninKakuninshoIchiranReport 一覧表Report = new JuryoIninShoninKakuninshoIchiranReport(
                breakProcessCore.edit一覧表Entity(serviceEntity.get一覧表Entity(), processParameter, 導入団体クラス));
        一覧表Report.writeBy(一覧表SourceWriter);
        KogakuServiceHiJyuryoItakuKeiyakuKakuninShoReport 確認書Report = new KogakuServiceHiJyuryoItakuKeiyakuKakuninShoReport(
                breakProcessCore.edit確認書Entity(serviceEntity.get介護保険高額Entity(), processParameter, 確認書認証者情報, 通知文1, 通知文2));
        確認書Report.writeBy(確認書SourceWriter);
        高額介護事業者Entity.setShoninKekkaTsuchiSakuseiYMD(processParameter.get通知日());
        if (ONE.equals(高額介護事業者Entity.getShoninKekkaTsuchiSaiHakkoKubun())) {
            高額介護事業者Entity.setShoninKekkaTsuchiSaiHakkoKubun(RString.EMPTY);
        }
        高額受領委任契約事業者.update(高額介護事業者Entity);
        ExpandedInformation expandedInfo = new ExpandedInformation(
                new Code(文字列_003), 被保険者番号, entity.get高額介護事業者().getHihokenshaNo().value());
        AccessLogger.log(AccessLogType.照会, PersonalData.of(entity.get識別コード(), expandedInfo));
    }

    @Override
    protected void afterExecute() {
        if (ページ == 0) {
            JuryoIninShoninKakuninshoIchiranEntity entity = new JuryoIninShoninKakuninshoIchiranEntity();
            entity.set被保険者氏名2(対象データは存在しません);
            JuryoIninShoninKakuninshoIchiranReport 一覧表Report = new JuryoIninShoninKakuninshoIchiranReport(
                    breakProcessCore.edit一覧表Entity(entity, processParameter, 導入団体クラス));
            一覧表Report.writeBy(一覧表SourceWriter);
        }
        確認書ReportWriter.close();
        一覧表ReportWriter.close();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBC.DBC100031.getReportId().value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBC.DBC100031.getReportName(),
                new RString(String.valueOf(ページ)),
                なし,
                RString.EMPTY,
                setOutConditionList());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private RString toRstring(FlexibleDate targetValue) {
        if (targetValue == null) {
            return RString.EMPTY;
        }
        return new RString(targetValue.toString());
    }

    private List<RString> setOutConditionList() {
        List<RString> outConditionList = new ArrayList<>();
        FlexibleDate 契約申請開始 = processParameter.get契約申請開始();
        FlexibleDate 契約申請終了 = processParameter.get契約申請終了();
        FlexibleDate 契約決定開始 = processParameter.get契約決定開始();
        FlexibleDate 契約決定終了 = processParameter.get契約決定終了();
        if (null == 契約申請開始 && null == 契約申請終了) {
            outConditionList.add(契約申請日);
        } else {
            outConditionList.add(契約申請日.concat(toRstring(契約申請開始)).concat(波線).concat(toRstring(契約申請終了)));
        }
        if (null == 契約決定開始 && null == 契約決定終了) {
            outConditionList.add(契約決定日);
        } else {
            outConditionList.add(契約申請日.concat(toRstring(契約決定開始)).concat(波線).concat(toRstring(契約決定終了)));
        }
        if (発行済_1.equals(processParameter.get発行済())) {
            outConditionList.add(発行済.concat(発行済を出力する));
        } else if (発行済_2.equals(processParameter.get発行済())) {
            outConditionList.add(発行済.concat(発行済を出力しない));
        }
        return outConditionList;
    }
}
