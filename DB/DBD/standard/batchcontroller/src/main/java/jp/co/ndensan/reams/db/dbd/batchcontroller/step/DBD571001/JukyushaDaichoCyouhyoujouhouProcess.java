/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD571001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100026.JukyushaDaichoReport;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.homon.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KyoshitsuShubetsu;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.ShinseiRiyuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.Datakubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd571001.IdoChushutsuDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.IdoChushutsuDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.IdoChushutsuDaichoNewEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.FutanGendogakuNinteiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.HomonKaigoGenmenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.HyojunFutanGengakuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ItakuKeikakuTodokedejohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.KyufugakuGengakujohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.RiyoshaFutanGenmenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.RoreiFukushiNenkinjohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.SeikatsuHogojohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.SentoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShafuHojinKeigenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShiharaHohoHenkojohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShikakujohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShisetsuNyutaishojohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.TokubetsuChiikiKasanGenmenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.TokureiShisetuNyutaishojohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.TyohyoShutuRyokuYoJukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.YokaigoNinteiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100026.JukyushaDaichoReportSource;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushadaicho.IJukyushaDaichoMainMapper;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.core.kyusochisha.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.SeikatsuHogoFujoShuruiCodeType;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * バッチ設計_DBD571001_受給者台帳のprocess処理クラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
public class JukyushaDaichoCyouhyoujouhouProcess extends BatchProcessBase<IdoChushutsuDaichoNewEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushadaicho."
            + "IJukyushaDaichoMainMapper.get個人情報と要介護認定情報");
    private IJukyushaDaichoMainMapper mapper;
    private IdoChushutsuDaichoProcessParameter processParamter;
    private List<PersonalData> personalDataList;
    private List<HihokenshaNo> 被保険者番号リスト;
    private List<ShikibetsuCode> 識別コードリスト;
    private ShikibetsuCode 識別コードKEY;
    private HihokenshaNo 被保険者番号KEY;
    private HihokenshaNo 被保険者番号;
    private DonyuKeitaiCode 導入形態コード;
    private RString 保険者番号の取得;
    private RString 保険者名称の取得;
    private boolean is広域;
    private boolean is単一;
    private final RString 要介護状態区分コード = new RString("要介護状態区分コード:");
    private final RString 要介護認定一次判定結果コード = new RString("要介護認定一次判定結果コード:");
    private int 明細;
    private List<FutanGendogakuNinteiJohoEntity> 負担限度額認定情報EntityList;
    private List<YokaigoNinteiJohoEntity> 要介護認定情報List;
    private List<ShafuHojinKeigenJohoEntity> 社福法人軽減情報EntityList;
    private List<RiyoshaFutanGenmenJohoEntity> 利用者負担減免情報EntityList;
    private List<HomonKaigoGenmenJohoEntity> 訪問介護等減額情報EntityList;
    private List<HyojunFutanGengakuJohoEntity> 標準負担減額情報EntityList;
    private List<TokubetsuChiikiKasanGenmenJohoEntity> 特別地域加算減免情報EntityList;
    private List<ShisetsuNyutaishojohoEntity> 施設入退所情報EntityList;
    private List<ItakuKeikakuTodokedejohoEntity> 居宅計画届出情報EntityList;
    private List<TokureiShisetuNyutaishojohoEntity> 特例施設入退所情報EntityList;
    private List<ShiharaHohoHenkojohoEntity> 支払方法変更情報EntityList;
    private List<KyufugakuGengakujohoEntity> 給付額減額情報EntityList;
    private List<ShikakujohoEntity> 資格情報EntityList;
    private List<RoreiFukushiNenkinjohoEntity> 老齢福祉年金情報EntityList;
    private List<SeikatsuHogojohoEntity> 生活保護情報EntityList;
    private TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳Entity;
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(JukyushaDaichoReportSource.ReportSourceFields.hokenshaNo.name())));
    private static final RString 改行 = new RString("\r\n");
    private static final RString なし = new RString("なし");
    private static final RString 有り = new RString("有り");
    private static final RString 区分_0 = new RString("0");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString 区分_3 = new RString("3");
    private static final RString 区分_4 = new RString("4");
    private static final RString 区分_99A = new RString("99A");
    private static final RString 区分_02A = new RString("02A");
    private static final RString 区分_06A = new RString("06A");
    private static final RString 区分_09A = new RString("09A");
    private static final RString 区分_09B = new RString("09B");

    @Override
    protected void initialize() {
        mapper = getMapper(IJukyushaDaichoMainMapper.class);
        personalDataList = new ArrayList<>();
        被保険者番号リスト = new ArrayList();
        識別コードリスト = new ArrayList();
        被保険者番号KEY = HihokenshaNo.EMPTY;
        識別コードKEY = ShikibetsuCode.EMPTY;
        保険者番号の取得 = RString.EMPTY;
        保険者名称の取得 = RString.EMPTY;
        明細 = 0;
        帳票出力用受給者台帳Entity = new TyohyoShutuRyokuYoJukyushaDaichoEntity();
        負担限度額認定情報EntityList = new ArrayList();
        要介護認定情報List = new ArrayList();
        社福法人軽減情報EntityList = new ArrayList();
        利用者負担減免情報EntityList = new ArrayList();
        訪問介護等減額情報EntityList = new ArrayList();
        標準負担減額情報EntityList = new ArrayList();
        特別地域加算減免情報EntityList = new ArrayList();
        施設入退所情報EntityList = new ArrayList();
        居宅計画届出情報EntityList = new ArrayList();
        特例施設入退所情報EntityList = new ArrayList();
        支払方法変更情報EntityList = new ArrayList();
        給付額減額情報EntityList = new ArrayList();
        資格情報EntityList = new ArrayList();
        老齢福祉年金情報EntityList = new ArrayList();
        生活保護情報EntityList = new ArrayList();
    }
    @BatchWriter
    private BatchReportWriter<JukyushaDaichoReportSource> batchReportWrite;
    private ReportSourceWriter<JukyushaDaichoReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        List<IdoChushutsuDaichoEntity> entityList = mapper.get新たな抽出対象リスト();
        for (IdoChushutsuDaichoEntity entity : entityList) {
            if (entity != null) {
                if (!entity.get被保険者番号().isEmpty() && !被保険者番号KEY.equals(entity.get被保険者番号())) {
                    被保険者番号KEY = entity.get被保険者番号();
                    被保険者番号リスト.add(entity.get被保険者番号());
                }
                if (!entity.get識別コード().isEmpty() && !識別コードKEY.equals(entity.get識別コード())) {
                    識別コードKEY = entity.get識別コード();
                    識別コードリスト.add(entity.get識別コード());
                }

            }
        }
        ShichosonSecurityJohoFinder finder = ShichosonSecurityJohoFinder.createInstance();
        ShichosonSecurityJoho 市町村セキュリティ情報 = finder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null) {
            導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        }
        if (導入形態コード.equals(DonyuKeitaiCode.事務広域)
                || 導入形態コード.equals(DonyuKeitaiCode.事務構成市町村)) {
            is広域 = true;
        }
        if (導入形態コード.equals(DonyuKeitaiCode.事務単一)) {
            is単一 = true;
        }
        保険者番号の取得 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        保険者名称の取得 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toIdoChushutsuDaichoNewMybatisParameter(被保険者番号リスト, 識別コードリスト, is広域, is単一));
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBD.DBD100026.getReportId().getColumnValue()).addBreak(
                new BreakerCatalog<JukyushaDaichoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(IdoChushutsuDaichoNewEntity t) {
        if (被保険者番号 == HihokenshaNo.EMPTY || 被保険者番号 == null) {
            被保険者番号 = t.get要介護認定情報().get受給者台帳_被保険者番号();
        } else if (!被保険者番号.equals(t.get要介護認定情報().get受給者台帳_被保険者番号())) {
            JukyushaDaichoReport report = JukyushaDaichoReport.createReport(帳票出力用受給者台帳Entity);
            report.writeBy(reportSourceWriter);
            被保険者番号 = t.get要介護認定情報().get受給者台帳_被保険者番号();
            帳票出力用受給者台帳Entity = new TyohyoShutuRyokuYoJukyushaDaichoEntity();
            負担限度額認定情報EntityList = new ArrayList();
            要介護認定情報List = new ArrayList();
            社福法人軽減情報EntityList = new ArrayList();
            利用者負担減免情報EntityList = new ArrayList();
            訪問介護等減額情報EntityList = new ArrayList();
            標準負担減額情報EntityList = new ArrayList();
            特別地域加算減免情報EntityList = new ArrayList();
            施設入退所情報EntityList = new ArrayList();
            居宅計画届出情報EntityList = new ArrayList();
            特例施設入退所情報EntityList = new ArrayList();
            支払方法変更情報EntityList = new ArrayList();
            給付額減額情報EntityList = new ArrayList();
            資格情報EntityList = new ArrayList();
            老齢福祉年金情報EntityList = new ArrayList();
            生活保護情報EntityList = new ArrayList();
        }
        set帳票出力用受給者台帳Entity(t);
        帳票出力用受給者台帳Entity.set要介護認定情報EntityList(要介護認定情報List);
        帳票出力用受給者台帳Entity.set負担限度額認定情報EntityList(負担限度額認定情報EntityList);
        帳票出力用受給者台帳Entity.set社福法人軽減情報EntityList(社福法人軽減情報EntityList);
        帳票出力用受給者台帳Entity.set利用者負担減免情報EntityList(利用者負担減免情報EntityList);
        帳票出力用受給者台帳Entity.set訪問介護等減額情報EntityList(訪問介護等減額情報EntityList);
        帳票出力用受給者台帳Entity.set標準負担減額情報EntityList(標準負担減額情報EntityList);
        帳票出力用受給者台帳Entity.set特別地域加算減免情報EntityList(特別地域加算減免情報EntityList);
        帳票出力用受給者台帳Entity.set施設入退所情報EntityList(施設入退所情報EntityList);
        帳票出力用受給者台帳Entity.set居宅計画届出情報EntityList(居宅計画届出情報EntityList);
        帳票出力用受給者台帳Entity.set特例施設入退所情報EntityList(特例施設入退所情報EntityList);
        帳票出力用受給者台帳Entity.set支払方法変更情報EntityList(支払方法変更情報EntityList);
        帳票出力用受給者台帳Entity.set給付額減額情報EntityList(給付額減額情報EntityList);
        帳票出力用受給者台帳Entity.set資格情報EntityList(資格情報EntityList);
        帳票出力用受給者台帳Entity.set老齢福祉年金情報EntityList(老齢福祉年金情報EntityList);
        帳票出力用受給者台帳Entity.set生活保護情報EntityList(生活保護情報EntityList);
        ExpandedInformation expandedInformations
                = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), t.get要介護認定情報().get受給者台帳_被保険者番号().getColumnValue());
        PersonalData personalData = PersonalData.of(t.get要介護認定情報().getPsm_識別コード(), expandedInformations);
        personalDataList.add(personalData);
    }

    @Override
    protected void afterExecute() {
        AccessLogger.log(AccessLogType.照会, personalDataList);
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString ページ数 = new RString(reportSourceWriter.pageCount().value());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBD.DBD100026.getReportId().getColumnValue(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD100026.getReportName(),
                ページ数,
                なし,
                RString.EMPTY,
                contribute(processParamter));
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
        if (processParamter.get出力オプション区分().equals(区分_0)) {
            mapper.updDbt7022ShoriDateKanri(update処理日付管理マスタ(processParamter));
        }
    }

    private ShoriDateKanriEntity update処理日付管理マスタ(IdoChushutsuDaichoProcessParameter parameter) {
        ShoriDateKanriEntity dbT7022entity = new ShoriDateKanriEntity();
        dbT7022entity.setSubGyomuCode(SubGyomuCode.DBD介護受給);
        dbT7022entity.setShoriName(ShoriName.受給者台帳.get名称());
        dbT7022entity.setShichosonCode(new LasdecCode(parameter.get市町村コード().toString()));
        dbT7022entity.setNendoNaiRenban(new RString("0001"));
        dbT7022entity.setTaishoKaishiTimestamp(new YMDHMS(parameter.get今回抽出開始年月日(), parameter.get今回抽出開始時分秒()));
        dbT7022entity.setTaishoShuryoTimestamp(new YMDHMS(parameter.get今回抽出終了年月日(), parameter.get今回抽出終了時分秒()));
        dbT7022entity.setLastUpdateTimestamp(RDate.getNowDateTime());
        dbT7022entity.setLastUpdateReamsLoginId(ControlDataHolder.getUserId());
        return dbT7022entity;

    }

    private List<RString> contribute(IdoChushutsuDaichoProcessParameter parameter) {
        List<RString> 出力条件 = new ArrayList<>();
        if (processParamter.get抽出条件設定区分().equals(区分_0)) {
            set今回抽出あり(出力条件, parameter);
        } else if (processParamter.get抽出条件設定区分().equals(区分_1)) {
            set今回抽出なし(出力条件, parameter);
        }
        if (parameter.get異動抽出対象リスト().isEmpty()) {
            出力条件.add(new RString("【異動抽出対象】　").concat(なし));
        } else {
            RString 異動抽出対象 = set異動抽出対象(parameter);
            if (異動抽出対象 != null) {
                出力条件.add(異動抽出対象);
            }
        }
        if (parameter.get出力オプション区分() != null && !parameter.get出力オプション区分().isEmpty()) {
            if (parameter.get出力オプション区分().equals(区分_0)) {
                出力条件.add(new RString("【出力オプション区分】　").concat(new RString("全てのページを印刷する")));
            } else if (parameter.get出力オプション区分().equals(区分_1)) {
                出力条件.add(new RString("【出力オプション区分】　").concat(new RString("被保険者毎に最新1ページ分のみ印刷する")));
            }
        }
        return 出力条件;

    }

    private void set今回抽出あり(List<RString> 出力条件, IdoChushutsuDaichoProcessParameter parameter) {
        if (parameter.get今回抽出開始年月日() != null) {
            出力条件.add(new RString("【今回抽出開始年月日】　").concat(parameter.get今回抽出開始年月日().wareki().toDateString()));
        }
        if (parameter.get今回抽出開始時分秒() != null) {
            出力条件.add(new RString("【今回抽出開始時分秒】　").concat(parameter.get今回抽出開始時分秒().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        }
        if (parameter.get今回抽出終了年月日() != null) {
            出力条件.add(new RString("【今回抽出終了年月日】　").concat(parameter.get今回抽出終了年月日().wareki().toDateString()));
        }
        if (parameter.get今回抽出終了時分秒() != null) {
            出力条件.add(new RString("【今回抽出終了時分秒】　").concat(parameter.get今回抽出終了時分秒().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        }
    }

    private void set今回抽出なし(List<RString> 出力条件, IdoChushutsuDaichoProcessParameter parameter) {
        if (parameter.get今回抽出開始年月日() != null) {
            出力条件.add(new RString("【今回抽出開始年月日】　").concat(なし));
        }
        if (parameter.get今回抽出開始時分秒() != null) {
            出力条件.add(new RString("【今回抽出開始時分秒】　").concat(なし));
        }
        if (parameter.get今回抽出終了年月日() != null) {
            出力条件.add(new RString("【今回抽出終了年月日】　").concat(なし));
        }
        if (parameter.get今回抽出終了時分秒() != null) {
            出力条件.add(new RString("【今回抽出終了時分秒】　").concat(なし));
        }
    }

    private RString set異動抽出対象(IdoChushutsuDaichoProcessParameter parameter) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(new RString("【異動抽出対象】　"));
        for (RString 異動抽出対象 : parameter.get異動抽出対象リスト()) {
            if (異動抽出対象.equals(new RString("要介護認定"))) {
                builder.append(new RString("要介護認定"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("利用者負担額減免"))) {
                builder.append(new RString("利用者負担額減免"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("施設入退所"))) {
                builder.append(new RString("施設入退所"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("資格"))) {
                builder.append(new RString("資格"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("訪問介護（特別対策減免）"))) {
                builder.append(new RString("訪問介護（特別対策減免）"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("居宅サービス計画"))) {
                builder.append(new RString("居宅サービス計画"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("老齢福祉年金"))) {
                builder.append(new RString("老齢福祉年金"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("負担限度額(特定入所者)"))) {
                builder.append(new RString("負担限度額(特定入所者)"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("社会福祉法人軽減"))) {
                builder.append(new RString("社会福祉法人軽減"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("給付制限"))) {
                builder.append(new RString("給付制限"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("生活保護"))) {
                builder.append(new RString("生活保護"));
                builder.append(改行);
            }
        }
        return builder.toRString();
    }

    private void set要介護認定情報List(IdoChushutsuDaichoNewEntity t) {
        YokaigoNinteiJohoEntity 要介護認定情報 = new YokaigoNinteiJohoEntity();
        SentoEntity 先頭Entity = new SentoEntity();
        set先頭Entity(先頭Entity, t);
        if (t.get要介護認定情報() != null) {
            要介護認定情報.set先頭Entity(先頭Entity);
            要介護認定情報.set認定区分(RString.EMPTY);
            要介護認定情報.set明細番号(new RString(String.valueOf(明細++)));
            要介護認定情報.set認定日(t.get要介護認定情報().get受給者台帳_認定年月日());
            要介護認定情報.set申請事由(JukyuShinseiJiyu.toValue(t.get要介護認定情報().get受給者台帳_受給申請事由().getColumnValue()).get名称());
            要介護認定情報.set異動事由(Datakubun.toValue(t.get要介護認定情報().get受給者台帳_データ区分()).get名称());
            set要介護度(要介護認定情報, t);
            要介護認定情報.set認定開始日(t.get要介護認定情報().get受給者台帳_認定有効期間開始年月日());
            要介護認定情報.set認定終了日(t.get要介護認定情報().get受給者台帳_認定有効期間終了年月日());
            要介護認定情報.set訪問限度額(t.get要介護認定情報().get受給者台帳_支給限度単位数());
            要介護認定情報.set訪問開始日(t.get要介護認定情報().get受給者台帳_支給限度有効開始年月日());
            要介護認定情報.set訪問終了日(t.get要介護認定情報().get受給者台帳_支給限度有効終了年月日());
            要介護認定情報.set短期限度額(t.get要介護認定情報().get受給者台帳_短期入所支給限度日数());
            要介護認定情報.set短期開始日(t.get要介護認定情報().get受給者台帳_短期入所支給限度開始年月日());
            要介護認定情報.set短期終了日(t.get要介護認定情報().get受給者台帳_短期入所支給限度終了年月日());
            if (導入形態コード.equals(DonyuKeitaiCode.事務構成市町村)
                    || 導入形態コード.equals(DonyuKeitaiCode.事務広域)) {
                set広域(要介護認定情報, t);
            }
            if (導入形態コード.equals(DonyuKeitaiCode.事務単一)) {
                set単一(要介護認定情報, t);
            }
            要介護認定情報.set調査予定日(t.get要介護認定情報().getT4123_認定調査予定年月日());
            要介護認定情報.set医師予定日(t.get要介護認定情報().getT4123_主治医意見書作成登録予定日());
            要介護認定情報.set旧措置(KyusochishaKubun.toValue(t.get要介護認定情報().is受給者台帳_旧措置者フラグ()).get名称());
            要介護認定情報.set喪失日(t.get要介護認定情報().get受給者台帳_喪失年月日());
            要介護認定情報.set資格取得前申請(t.get要介護認定情報().is受給者台帳_資格取得前申請フラグ() ? new RString("取得前申請") : RString.EMPTY);
            要介護認定情報.set延期通知書発行日(t.get要介護認定情報().getT4101_延期通知発行年月日());
            要介護認定情報.set延期通知書発行回数(DecimalFormatter.toコンマ区切りRString(t.get要介護認定情報().getT4101_延期通知発行回数(), 0));
            要介護認定情報.set資格証明書発行日１(t.get要介護認定情報().get受給者台帳_受給資格証明書発行年月日１());
            要介護認定情報.set資格証明書発行日２(t.get要介護認定情報().get受給者台帳_受給資格証明書発行年月日２());
            要介護認定情報.set申請代行事業者((t.get要介護認定情報().get受給者台帳_届出者申請者関係コード() == null
                    || t.get要介護認定情報().get受給者台帳_届出者申請者関係コード().isEmpty())
                    ? (t.get要介護認定情報().getX4120_事業者名称() != null
                    ? t.get要介護認定情報().getX4120_事業者名称() : RString.EMPTY) : (t.get要介護認定情報().getX4120_申請届出者氏名() != null
                    ? t.get要介護認定情報().getX4120_申請届出者氏名() : RString.EMPTY));
//        要介護認定情報
            要介護認定情報.set代行者コード((t.get要介護認定情報().get受給者台帳_届出者本人との関係() == null
                    || t.get要介護認定情報().get受給者台帳_届出者本人との関係().isEmpty())
                    ? (t.get要介護認定情報().getX4120_申請届出代行区分コード() != null
                    ? ShinseiTodokedeDaikoKubunCode.toValue(t.get要介護認定情報().getX4120_申請届出代行区分コード()).get名称() : RString.EMPTY)
                    : (t.get要介護認定情報().get受給者台帳_届出者本人との関係() != null
                    ? t.get要介護認定情報().get受給者台帳_届出者本人との関係() : RString.EMPTY));
            要介護認定情報.set指定医区分(t.get要介護認定情報().isT4101_指定医フラグ() ? new RString("指定医") : RString.EMPTY);
            要介護認定情報.set調査委託先名(t.get要介護認定情報().getT4910_事業者名称());
            要介護認定情報.set調査員名(t.get要介護認定情報().getT4913_調査員氏名());
            要介護認定情報.set主治医医療機関名(t.get要介護認定情報().getT4911_医療機関名称());
            要介護認定情報.set主治医名(t.get要介護認定情報().getT4912_主治医氏名());
            要介護認定情報.set申請区分_申請時(t.get要介護認定情報().getT4101_認定申請区分_申請時_コード() != null
                    ? NinteiShinseiShinseijiKubunCode.toValue(t.get要介護認定情報().getT4101_認定申請区分_申請時_コード()).get名称() : RString.EMPTY);
            要介護認定情報.set申請区分_法令(t.get要介護認定情報().getT4101_認定申請区分_法令_コード() != null
                    ? NinteiShinseiHoreiCode.toValue(t.get要介護認定情報().getT4101_認定申請区分_法令_コード()).get名称() : RString.EMPTY);

            要介護認定情報List.add(要介護認定情報);
        }
    }

    private void set要介護度(YokaigoNinteiJohoEntity 要介護認定情報, IdoChushutsuDaichoNewEntity t) {
        if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_99A)) {
            要介護認定情報.set要介護度(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード() != null
                    ? 要介護状態区分コード.concat(YokaigoJotaiKubun99
                            .toValue(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_02A)) {
            要介護認定情報.set要介護度(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード() != null
                    ? 要介護状態区分コード.concat(YokaigoJotaiKubun02
                            .toValue(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_06A)) {
            要介護認定情報.set要介護度(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード() != null
                    ? 要介護状態区分コード.concat(YokaigoJotaiKubun06
                            .toValue(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_09A)
                || t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_09B)) {
            要介護認定情報.set要介護度(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード() != null
                    ? 要介護状態区分コード.concat(YokaigoJotaiKubun09
                            .toValue(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード()).get名称()) : RString.EMPTY);
        }
    }

    private void set広域(YokaigoNinteiJohoEntity 要介護認定情報, IdoChushutsuDaichoNewEntity t) {
        要介護認定情報.set認定申請日(t.get要介護認定情報().getT4003_認定申請日());
        要介護認定情報.set調査依頼日(t.get要介護認定情報().getT4003_調査委託年月日());
        要介護認定情報.set調査実施日(t.get要介護認定情報().getT4003_調査終了年月日());
        要介護認定情報.set医師依頼日(t.get要介護認定情報().getT4003_意見書依頼年月日());
        要介護認定情報.set医師取寄日(t.get要介護認定情報().getT4003_意見書取寄せ年月日());
        要介護認定情報.set資料作成日(t.get要介護認定情報().getT4003_審査会資料作成年月日());
        要介護認定情報.set審査予定日(t.get要介護認定情報().getT4003_審査会予定年月日());
        要介護認定情報.set二次判定日(t.get要介護認定情報().getT4003_二次判定日());
        if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_99A)) {
            要介護認定情報.set一次要介護度(t.get要介護認定情報().getT4003_一次判定結果() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode99
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果()).get名称()) : RString.EMPTY);
            要介護認定情報.set一次要介護度_重(t.get要介護認定情報().getT4003_一次判定結果重み() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode99
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果重み()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_02A)) {
            要介護認定情報.set一次要介護度(t.get要介護認定情報().getT4003_一次判定結果() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode02
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果()).get名称()) : RString.EMPTY);
            要介護認定情報.set一次要介護度_重(t.get要介護認定情報().getT4003_一次判定結果重み() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode02
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果重み()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_06A)) {
            要介護認定情報.set一次要介護度(t.get要介護認定情報().getT4003_一次判定結果() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode06
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果()).get名称()) : RString.EMPTY);
            要介護認定情報.set一次要介護度_重(t.get要介護認定情報().getT4003_一次判定結果重み() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode06
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果重み()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_09A)
                || t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_09B)) {
            要介護認定情報.set一次要介護度(t.get要介護認定情報().getT4003_一次判定結果() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode09
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果()).get名称()) : RString.EMPTY);
            要介護認定情報.set一次要介護度_重(t.get要介護認定情報().getT4003_一次判定結果重み() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode09
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果重み()).get名称()) : RString.EMPTY);
        }
        要介護認定情報.set一次判定日(t.get要介護認定情報().getT4003_一次判定日());
        要介護認定情報.set特定疾病(t.get要介護認定情報().getT4003_特定疾病コード() != null
                ? TokuteiShippei.toValue(t.get要介護認定情報().getT4003_特定疾病コード()).get名称() : RString.EMPTY);
        要介護認定情報.set調査委託先コード(t.get要介護認定情報().getT4003_調査委託先コード());
        要介護認定情報.set調査員コード(t.get要介護認定情報().getT4003_調査員コード());
        要介護認定情報.set主治医医療機関コード(t.get要介護認定情報().getT4003_医療機関コード());
        要介護認定情報.set主治医コード(t.get要介護認定情報().getT4003_主治医コード());
        要介護認定情報.set認定審査会意見(t.get要介護認定情報().getT4003_審査会意見());
    }

    private void set単一(YokaigoNinteiJohoEntity 要介護認定情報, IdoChushutsuDaichoNewEntity t) {
        要介護認定情報.set認定申請日(t.get要介護認定情報().getT4101_認定申請年月日());
        要介護認定情報.set調査依頼日(t.get要介護認定情報().getX4102_認定調査依頼年月日());
        要介護認定情報.set調査実施日(t.get要介護認定情報().getX4102_認定調査実施年月日());
        要介護認定情報.set医師依頼日(t.get要介護認定情報().getX4102_主治医意見書作成依頼年月日());
        要介護認定情報.set医師取寄日(t.get要介護認定情報().getX4102_主治医意見書受領年月日());
        要介護認定情報.set資料作成日(t.get要介護認定情報().getX4102_介護認定審査会資料作成年月日());
        要介護認定情報.set審査予定日(t.get要介護認定情報().getT4123_認定審査会予定年月日());
        要介護認定情報.set二次判定日(t.get要介護認定情報().getX4102_二次判定年月日());
        if (t.get要介護認定情報().getX4102_要介護認定一次判定結果コード() != null) {
            set一次要介護度(要介護認定情報, t);
        }
        if (t.get要介護認定情報().getX4102_要介護認定一次判定結果コード認知症加算() != null) {
            set一次要介護度_重(要介護認定情報, t);
        }
        要介護認定情報.set一次判定日(t.get要介護認定情報().getX4102_要介護認定一次判定年月日() != null
                ? t.get要介護認定情報().getX4102_要介護認定一次判定年月日() : FlexibleDate.EMPTY);
        要介護認定情報.set特定疾病(t.get要介護認定情報().getT4101_２号特定疾病コード() != null
                ? TokuteiShippei.toValue(t.get要介護認定情報().getT4101_２号特定疾病コード()).get名称() : RString.EMPTY);
        要介護認定情報.set調査委託先コード(t.get要介護認定情報().getT4101_認定調査委託先コード() != null
                ? t.get要介護認定情報().getT4101_認定調査委託先コード() : RString.EMPTY);
        要介護認定情報.set調査員コード(t.get要介護認定情報().getT4101_認定調査員コード());
        要介護認定情報.set主治医医療機関コード(t.get要介護認定情報().getT4101_主治医医療機関コード());
        要介護認定情報.set主治医コード(t.get要介護認定情報().getT4101_主治医コード());
        要介護認定情報.set認定審査会意見(t.get要介護認定情報().getX4102_介護認定審査会意見());
    }

    private void set一次要介護度(YokaigoNinteiJohoEntity 要介護認定情報, IdoChushutsuDaichoNewEntity t) {
        if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_99A)) {
            要介護認定情報.set一次要介護度(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode99.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_02A)) {
            要介護認定情報.set一次要介護度(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode02.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_06A)) {
            要介護認定情報.set一次要介護度(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode06.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_09A)
                || t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_09B)) {
            要介護認定情報.set一次要介護度(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode09.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード()).get名称()));
        }
    }

    private void set一次要介護度_重(YokaigoNinteiJohoEntity 要介護認定情報, IdoChushutsuDaichoNewEntity t) {
        if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_99A)) {
            要介護認定情報.set一次要介護度_重(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode99.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード認知症加算()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_02A)) {
            要介護認定情報.set一次要介護度_重(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode02.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード認知症加算()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_06A)) {
            要介護認定情報.set一次要介護度_重(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode06.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード認知症加算()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_09A)
                || t.get要介護認定情報().getT4101_厚労省IF識別コード().equals(区分_09B)) {
            要介護認定情報.set一次要介護度_重(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode09.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード認知症加算()).get名称()));
        }
    }

    private void set負担限度額認定情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get負担限度額認定情報List() != null) {
            FutanGendogakuNinteiJohoEntity 負担限度額認定情報 = new FutanGendogakuNinteiJohoEntity();
            負担限度額認定情報.set負担限度額認定区分(RString.EMPTY);
            負担限度額認定情報.set申請年月日(t.get負担限度額認定情報List().get負担限度額_申請年月日());
            負担限度額認定情報.set申請理由(ShinseiRiyuKubun.toValue(t.get負担限度額認定情報List().get負担限度額_申請理由区分()).get名称());
            負担限度額認定情報.set決定年月日(t.get負担限度額認定情報List().get負担限度額_決定年月日());
            負担限度額認定情報.set適用年月日(t.get負担限度額認定情報List().get負担限度額_適用開始年月日());
            負担限度額認定情報.set有効期限(t.get負担限度額認定情報List().get負担限度額_適用終了年月日());
            負担限度額認定情報.set負担段階(RiyoshaFutanDankai.toValue(t.get負担限度額認定情報List().get負担限度額_利用者負担段階()).get名称());
            負担限度額認定情報.set旧措置(KyuSochishaKubun.toValue(t.get負担限度額認定情報List().get負担限度額_旧措置者区分()).get名称());
            負担限度額認定情報.set居室種別(KyoshitsuShubetsu.toValue(t.get負担限度額認定情報List().get負担限度額_居室種別()).get名称());
            負担限度額認定情報.set食費(t.get負担限度額認定情報List().get負担限度額_食費負担限度額());
            負担限度額認定情報.setユ個(t.get負担限度額認定情報List().get負担限度額_ユニット型個室());
            負担限度額認定情報.setユ準(t.get負担限度額認定情報List().get負担限度額_ユニット型準個室());
            負担限度額認定情報.set従特養(t.get負担限度額認定情報List().get負担限度額_従来型個室特養等());
            負担限度額認定情報.set従老健(t.get負担限度額認定情報List().get負担限度額_従来型個室老健療養等());
            負担限度額認定情報.set多床(t.get負担限度額認定情報List().get負担限度額_多床室());
            負担限度額認定情報.set境界層(t.get負担限度額認定情報List().is負担限度額_境界層該当者区分() ? new RString("境界層該当者") : RString.EMPTY);
            負担限度額認定情報.set激変緩和(t.get負担限度額認定情報List().is負担限度額_激変緩和措置対象者区分() ? new RString("激変緩和対象者") : RString.EMPTY);
            負担限度額認定情報EntityList.add(負担限度額認定情報);
        }
    }

    private void set社福法人軽減情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get社福法人軽減List() != null) {
            ShafuHojinKeigenJohoEntity 社福法人軽減情報 = new ShafuHojinKeigenJohoEntity();
            社福法人軽減情報.set社福軽減区分(RString.EMPTY);
//        社福法人軽減情報.set明細番号(RString.EMPTY);
            社福法人軽減情報.set減免申請日(t.get社福法人軽減List().get社福法人軽減_申請年月日());
            社福法人軽減情報.set減免決定日(t.get社福法人軽減List().get社福法人軽減_決定年月日());
            社福法人軽減情報.set減免開始日(t.get社福法人軽減List().get社福法人軽減_適用開始年月日());
            社福法人軽減情報.set減免終了日(t.get社福法人軽減List().get社福法人軽減_適用終了年月日());
            社福法人軽減情報.set確認番号(t.get社福法人軽減List().get社福法人軽減_確認番号());
            社福法人軽減情報.set軽減率(new RString(String.valueOf(t.get社福法人軽減List().get社福法人軽減_軽減率_分子().divide(t.get社福法人軽減List().get社福法人軽減_軽減率_分母()))));
            社福法人軽減情報.set居宅限定(t.get社福法人軽減List().is社福法人軽減_居宅サービス限定() ? 有り : RString.EMPTY);
            社福法人軽減情報.set居_食限定(t.get社福法人軽減List().is社福法人軽減_居住費食費のみ() ? 有り : RString.EMPTY);
            社福法人軽減情報.set旧措限定(t.get社福法人軽減List().is社福法人軽減_旧措置者ユニット型個室のみ() ? 有り : RString.EMPTY);
            社福法人軽減情報EntityList.add(社福法人軽減情報);
        }

    }

    private void set利用者負担減免情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get利用者負担減免List() != null) {
            RiyoshaFutanGenmenJohoEntity 利用者負担減免情報 = new RiyoshaFutanGenmenJohoEntity();
            利用者負担減免情報.set利用者負担減免区分(RString.EMPTY);
//        利用者負担減免情報.set明細番号(RString.EMPTY);
            利用者負担減免情報.set減免申請日(t.get利用者負担減免List().get利用者負担減免_申請年月日());
            利用者負担減免情報.set減免決定日(t.get利用者負担減免List().get利用者負担減免_決定年月日());
            利用者負担減免情報.set減免開始日(t.get利用者負担減免List().get利用者負担減免_適用開始年月日());
            利用者負担減免情報.set減免終了日(t.get利用者負担減免List().get利用者負担減免_適用終了年月日());
            利用者負担減免情報.set給付率(new RString(String.valueOf(t.get利用者負担減免List().get利用者負担減免_給付率().value())));
            利用者負担減免情報EntityList.add(利用者負担減免情報);
        }
    }

    private void set訪問介護等減額情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get訪問介護等減額情報List() != null) {
            HomonKaigoGenmenJohoEntity 訪問介護等減額情報 = new HomonKaigoGenmenJohoEntity();
            訪問介護等減額情報.set訪問介護利用者負担減額区分(RString.EMPTY);
//        訪問介護等減額情報.set明細番号(RString.EMPTY);
            訪問介護等減額情報.set減免申請日(t.get訪問介護等減額情報List().get訪問介護等減額_申請年月日());
            訪問介護等減額情報.set減免決定日(t.get訪問介護等減額情報List().get訪問介護等減額_決定年月日());
            訪問介護等減額情報.set減免開始日(t.get訪問介護等減額情報List().get訪問介護等減額_適用開始年月日());
            訪問介護等減額情報.set減免終了日(t.get訪問介護等減額情報List().get訪問介護等減額_適用終了年月日());
            訪問介護等減額情報.set給付率(new RString(String.valueOf(t.get訪問介護等減額情報List().get訪問介護等減額_給付率().value())));
            訪問介護等減額情報.set法別(HobetsuKubun.toValue(t.get訪問介護等減額情報List().get訪問介護等減額_法別区分()));
            訪問介護等減額情報.set受給者番号(t.get訪問介護等減額情報List().get訪問介護等減額_公費受給者番号());
            訪問介護等減額情報EntityList.add(訪問介護等減額情報);
        }
    }

    private void set標準負担減額情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get標準負担減額List() != null) {
            HyojunFutanGengakuJohoEntity 標準負担減額情報 = new HyojunFutanGengakuJohoEntity();
            標準負担減額情報.set標準負担減額区分(RString.EMPTY);
//        標準負担減額情報.set明細番号(RString.EMPTY);
            標準負担減額情報.set減免申請日(t.get標準負担減額List().get標準負担減額_申請年月日());
            標準負担減額情報.set減免決定日(t.get標準負担減額List().get標準負担減額_決定年月日());
            標準負担減額情報.set減免開始日(t.get標準負担減額List().get標準負担減額_適用開始年月日());
            標準負担減額情報.set減免終了日(t.get標準負担減額List().get標準負担減額_適用終了年月日());
            標準負担減額情報.set負担額(new RString(String.valueOf(t.get標準負担減額List().get標準負担減額_減額後金額())));
            標準負担減額情報EntityList.add(標準負担減額情報);
        }
    }

    private void set特別地域加算減免情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get特別地域加算List() != null) {
            TokubetsuChiikiKasanGenmenJohoEntity 特別地域加算減免情報 = new TokubetsuChiikiKasanGenmenJohoEntity();
            特別地域加算減免情報.set特別地域加算減免区分(RString.EMPTY);
//        特別地域加算減免情報.set明細番号(RString.EMPTY);
            特別地域加算減免情報.set申請年月日(t.get特別地域加算List().get特別地域加算_申請年月日());
            特別地域加算減免情報.set決定年月日(t.get特別地域加算List().get特別地域加算_決定年月日());
            特別地域加算減免情報.set適用年月日(t.get特別地域加算List().get特別地域加算_適用開始年月日());
            特別地域加算減免情報.set有効期限(t.get特別地域加算List().get特別地域加算_適用終了年月日());
            特別地域加算減免情報.set減額率(new RString(String.valueOf(t.get特別地域加算List().get特別地域加算_減額率())));
            特別地域加算減免情報.set確認番号(t.get特別地域加算List().get特別地域加算_確認番号());
            特別地域加算減免情報EntityList.add(特別地域加算減免情報);
        }
    }

    private void set施設入退所情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get施設入退所List() != null) {
            ShisetsuNyutaishojohoEntity 施設入退所情報 = new ShisetsuNyutaishojohoEntity();
            施設入退所情報.set施設入退所区分(RString.EMPTY);
//        施設入退所情報.set明細番号(RString.EMPTY);
            施設入退所情報.set施設入所日(t.get施設入退所List().get施設入退所_入所年月日());
            施設入退所情報.set施設退所日(t.get施設入退所List().get施設入退所_退所年月日());
            施設入退所情報.set施設コード(t.get施設入退所List().get施設入退所_入所施設コード());
            施設入退所情報.set入所施設名称(t.get施設入退所List().get施設入退所_事業者名称());
            施設入退所情報.set電話番号(t.get施設入退所List().get施設入退所_電話番号());
            施設入退所情報EntityList.add(施設入退所情報);
        }
    }

    private void set居宅計画届出情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get居宅計画届出List() != null) {
            ItakuKeikakuTodokedejohoEntity 居宅計画届出情報 = new ItakuKeikakuTodokedejohoEntity();
            居宅計画届出情報.set居宅計画区分(RString.EMPTY);
//        居宅計画届出情報.set明細番号(RString.EMPTY);
            居宅計画届出情報.set対象年月(t.get居宅計画届出List().get居宅計画届出_対象年月());
            if (t.get居宅計画届出List().get居宅計画届出_届出区分().equals(区分_1)) {
                居宅計画届出情報.set区分(new RString("新規"));
            } else if (t.get居宅計画届出List().get居宅計画届出_届出区分().equals(区分_2)) {
                居宅計画届出情報.set区分(new RString("変更"));
            } else if (t.get居宅計画届出List().get居宅計画届出_届出区分().equals(区分_3)) {
                居宅計画届出情報.set区分(new RString("暫定"));
            }
            居宅計画届出情報.set作成(t.get居宅計画届出List().get居宅計画届出_作成区分コード().equals(区分_3) ? new RString("自己作成") : RString.EMPTY);
            居宅計画届出情報.set計画届出日(t.get居宅計画届出List().get居宅計画届出_届出年月日());
            居宅計画届出情報.set変更日(t.get居宅計画届出List().get居宅計画届出_計画変更年月日());
            居宅計画届出情報.set適用開始日(t.get居宅計画届出List().get居宅計画届出_適用開始年月日());
            居宅計画届出情報.set適用終了日(t.get居宅計画届出List().get居宅計画届出_適用終了年月日());
            居宅計画届出情報.set事業所番号(t.get居宅計画届出List().get居宅計画届出_計画事業者番号());
            居宅計画届出情報.set事業所名称(t.get居宅計画届出List().get居宅計画届出_事業者名称());
            居宅計画届出情報.set電話番号(t.get居宅計画届出List().get居宅計画届出_電話番号());
            居宅計画届出情報EntityList.add(居宅計画届出情報);
        }
    }

    private void set特例施設入退所情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get特例施設入退所List() != null) {
            TokureiShisetuNyutaishojohoEntity 特例施設入退所情報 = new TokureiShisetuNyutaishojohoEntity();
            特例施設入退所情報.set特例施設入退所区分(RString.EMPTY);
//        特例施設入退所情報.set明細番号(RString.EMPTY);
            特例施設入退所情報.set入所日(t.get特例施設入退所List().get特例施設入退所_有効開始年月日());
            特例施設入退所情報.set退所日(t.get特例施設入退所List().get特例施設入退所_有効終了年月日());
            特例施設入退所情報.set事業所番号(t.get特例施設入退所List().get特例施設入退所_事業者番号());
            特例施設入退所情報.set事業所(t.get特例施設入退所List().get特例施設入退所_事業者名称());
            特例施設入退所情報.set電話番号(t.get特例施設入退所List().get特例施設入退所_電話番号());
            特例施設入退所情報EntityList.add(特例施設入退所情報);
        }

    }

    private void set支払方法変更情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get支払方法変更List() != null) {
            ShiharaHohoHenkojohoEntity 支払方法変更情報 = new ShiharaHohoHenkojohoEntity();
            支払方法変更情報.set支払方法変更区分(RString.EMPTY);
//        支払方法変更情報.set明細番号(RString.EMPTY);
            支払方法変更情報.set給付制限(t.get支払方法変更List().get支払方法変更_登録区分().equals(ShiharaiHenkoTorokuKubun._１号給付額減額登録.getコード())
                    ? ShiharaiHenkoTorokuKubun._空 : ShiharaiHenkoTorokuKubun.toValue(t.get支払方法変更List().get支払方法変更_登録区分()));
            支払方法変更情報.set開始日(t.get支払方法変更List().get支払方法変更_適用開始年月日());
            支払方法変更情報.set終了日(t.get支払方法変更List().get支払方法変更_適用終了年月日());
            支払方法変更情報.set終了事由(ShiharaiHenkoShuryoKubun.toValue(t.get支払方法変更List().get支払方法変更_終了区分()));
            支払方法変更情報.set差止状況(t.get支払方法変更List().get支払方法変更_管理区分().equals(区分_2) ? new RString("差止") : RString.EMPTY);
            支払方法変更情報.set提供年月(t.get支払方法変更List().get支払方法変更_差止サービス提供年月());
            支払方法変更情報.set整理番号(t.get支払方法変更List().get支払方法変更_差止償還整理番号());
            支払方法変更情報.set控除(t.get支払方法変更List().get支払方法変更_差止解除年月日().isEmpty() ? RString.EMPTY : new RString("控除"));
            支払方法変更情報EntityList.add(支払方法変更情報);
        }
    }

    private void set給付額減額情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get給付額減額情報List() != null) {
            KyufugakuGengakujohoEntity 給付額減額情報 = new KyufugakuGengakujohoEntity();
            給付額減額情報.set給付額減額区分(RString.EMPTY);
//        給付額減額情報.set明細番号(RString.EMPTY);
            給付額減額情報.set給付制限(t.get給付額減額情報List().get給付額減額情報_登録区分().equals(ShiharaiHenkoTorokuKubun._１号給付額減額登録.getコード())
                    ? ShiharaiHenkoTorokuKubun._１号給付額減額登録 : ShiharaiHenkoTorokuKubun._空);
            給付額減額情報.set開始日(t.get給付額減額情報List().get給付額減額情報_適用開始年月日());
            給付額減額情報.set終了日(t.get給付額減額情報List().get給付額減額情報_適用終了年月日());
            給付額減額情報.set給付率(new RString(t.get給付額減額情報List().get給付額減額情報_給付率().toString()));
            給付額減額情報.set徴収権消滅期間(new RString(t.get給付額減額情報List().get給付額減額情報_徴収権消滅期間().toString()));
            給付額減額情報.set納付済期間(new RString(t.get給付額減額情報List().get給付額減額情報_納付済期間().toString()));
            給付額減額情報.set減額期間(new RString(t.get給付額減額情報List().get給付額減額情報_納付済減額期間().toString()));
            給付額減額情報EntityList.add(給付額減額情報);
        }
    }

    private void set資格情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get資格情報List() != null) {
            ShikakujohoEntity 資格情報 = new ShikakujohoEntity();
            資格情報.set資格区分(RString.EMPTY);
//        資格情報.set明細番号(RString.EMPTY);
            資格情報.set資格取得日(t.get資格情報List().get資格情報_資格取得年月日());
            資格情報.set取得届出日(t.get資格情報List().get資格情報_資格取得届出年月日());
            if (t.get資格情報List().get資格情報_資格取得事由コード() != null && !t.get資格情報List().get資格情報_資格取得事由コード().isEmpty()) {
                資格情報.set取得事由(ShikakuShutokuJiyu.toValue(t.get資格情報List().get資格情報_資格取得事由コード()));
            }
            資格情報.set資格喪失日(t.get資格情報List().get資格情報_資格喪失年月日());
            資格情報.set喪失届出日(t.get資格情報List().get資格情報_資格喪失届出年月日());
            if (t.get資格情報List().get資格情報_資格喪失事由コード() != null && !t.get資格情報List().get資格情報_資格喪失事由コード().isEmpty()) {
                資格情報.set喪失事由(ShikakuSoshitsuJiyu.toValue(t.get資格情報List().get資格情報_資格喪失事由コード()));
            }
            資格情報.set変更年月日(t.get資格情報List().get資格情報_資格変更年月日());
            資格情報.set変更届出日(t.get資格情報List().get資格情報_資格変更届出年月日());
            if (t.get資格情報List().get資格情報_資格変更事由コード() != null && !t.get資格情報List().get資格情報_資格変更事由コード().isEmpty()) {
                資格情報.set変更事由(ShikakuHenkoJiyu.toValue(t.get資格情報List().get資格情報_資格変更事由コード()));
            }
            資格情報.set適用開始日(t.get資格情報List().get資格情報_適用年月日());
            資格情報.set適用届出日(t.get資格情報List().get資格情報_適用届出年月日());
            if (t.get資格情報List().get資格情報_住所地特例適用事由コード() != null && !t.get資格情報List().get資格情報_住所地特例適用事由コード().isEmpty()) {
                資格情報.set適用事由(ShikakuJutokuTekiyoJiyu.toValue(t.get資格情報List().get資格情報_住所地特例適用事由コード()));
            }

            資格情報.set解除開始日(t.get資格情報List().get資格情報_解除年月日());
            資格情報.set解除届出日(t.get資格情報List().get資格情報_解除届出年月日());
            if (t.get資格情報List().get資格情報_住所地特例解除事由コード() != null && !t.get資格情報List().get資格情報_住所地特例解除事由コード().isEmpty()) {
                資格情報.set解除事由(ShikakuJutokuKaijoJiyu.toValue(t.get資格情報List().get資格情報_住所地特例解除事由コード()));
            }
            資格情報EntityList.add(資格情報);
        }

    }

    private void set老齢福祉年金情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get老齢福祉年金List() != null) {
            RoreiFukushiNenkinjohoEntity 老齢福祉年金情報 = new RoreiFukushiNenkinjohoEntity();
            老齢福祉年金情報.set老齢福祉年金区分(RString.EMPTY);
//        老齢福祉年金情報.set明細番号(RString.EMPTY);
            老齢福祉年金情報.set老福開始日(t.get老齢福祉年金List().get老齢福祉年金_受給開始年月日());
            老齢福祉年金情報.set老福終了日(t.get老齢福祉年金List().get老齢福祉年金_受給廃止年月日());
            老齢福祉年金情報EntityList.add(老齢福祉年金情報);
        }
    }

    private void set生活保護情報EntityList(IdoChushutsuDaichoNewEntity t) {
        if (t.get生活保護情報List() != null) {
            SeikatsuHogojohoEntity 生活保護情報 = new SeikatsuHogojohoEntity();
            生活保護情報.set生活保護区分(RString.EMPTY);
//        生活保護情報.set明細番号(RString.EMPTY);
            生活保護情報.set生保開始日(t.get生活保護情報List().get生活保護情報_受給開始日());
            生活保護情報.set生保終了日(t.get生活保護情報List().get生活保護情報_受給廃止日());
            生活保護情報.set生保種別(t.get生活保護情報List().get生活保護情報_扶助種類コード() != null
                    ? SeikatsuHogoFujoShuruiCodeType.toValue(t.get生活保護情報List().get生活保護情報_扶助種類コード()).toRString() : RString.EMPTY);
            生活保護情報EntityList.add(生活保護情報);
        }
    }

    private void set帳票出力用受給者台帳Entity(IdoChushutsuDaichoNewEntity t) {
        set要介護認定情報List(t);
        set負担限度額認定情報EntityList(t);
        set社福法人軽減情報EntityList(t);
        set利用者負担減免情報EntityList(t);
        set訪問介護等減額情報EntityList(t);
        set標準負担減額情報EntityList(t);
        set特別地域加算減免情報EntityList(t);
        set施設入退所情報EntityList(t);
        set居宅計画届出情報EntityList(t);
        set特例施設入退所情報EntityList(t);
        set支払方法変更情報EntityList(t);
        set給付額減額情報EntityList(t);
        set資格情報EntityList(t);
        set老齢福祉年金情報EntityList(t);
        set生活保護情報EntityList(t);
    }

    private RString get通知文情報通知文(ReportId reportId, int パターン番号, int 項目番号) {
        Map<Integer, RString> 通知文情報 = ReportUtil.get通知文(SubGyomuCode.DBD介護受給,
                reportId, KamokuCode.EMPTY, パターン番号);
        return null != 通知文情報 ? 通知文情報.get(項目番号) : RString.EMPTY;
    }

    private void set先頭Entity(SentoEntity 先頭Entity, IdoChushutsuDaichoNewEntity t) {
        先頭Entity.set保険者番号(保険者番号の取得);
        先頭Entity.set保険者名称(保険者名称の取得);
        if (導入形態コード.equals(DonyuKeitaiCode.事務構成市町村)
                || 導入形態コード.equals(DonyuKeitaiCode.事務広域)) {
            先頭Entity.set証記載保険者コード(new RString(t.get要介護認定情報().get受給者台帳_市町村コード().code市町村()));
            先頭Entity.set証記載保険者名(t.get要介護認定情報().getT7051_市町村名称());
        }
        if (導入形態コード.equals(DonyuKeitaiCode.事務単一)) {
            先頭Entity.set証記載保険者コード(保険者番号の取得);
            先頭Entity.set証記載保険者名(保険者名称の取得);
        }
        先頭Entity.set被保険者番号(t.get要介護認定情報().get受給者台帳_被保険者番号().value());
        先頭Entity.set被保険者名(t.get要介護認定情報().getPsm_名称());
        先頭Entity.set被保険者名カナ(t.get要介護認定情報().getPsm_カナ名称());
        先頭Entity.set性別(Seibetsu.toValue(t.get要介護認定情報().getPsm_性別コード()).get名称());
        先頭Entity.set生年月日(t.get要介護認定情報().getPsm_生年月日());
        先頭Entity.set住所コード(t.get要介護認定情報().getPsm_全国住所コード());
        先頭Entity.set住所(t.get要介護認定情報().getPsm_住所());
        先頭Entity.set世帯コード(t.get要介護認定情報().getPsm_世帯コード());
        先頭Entity.set住民コード(t.get要介護認定情報().getPsm_識別コード().getColumnValue());
        if (t.get要介護認定情報().get受給者台帳_データ区分().substring(0, 1).equals(区分_1)) {
            先頭Entity.set現状態(new RString("職権取消者"));
        } else if (t.get要介護認定情報().get受給者台帳_データ区分().substring(0, 1).equals(区分_2)
                || t.get要介護認定情報().get受給者台帳_データ区分().substring(0, 1).equals(new RString("9"))) {
            先頭Entity.set現状態(new RString("受給資格者"));
        } else if (t.get要介護認定情報().get受給者台帳_データ区分().substring(0, 1).equals(区分_3)) {
            先頭Entity.set現状態(new RString("認定取消者"));
        } else if (t.get要介護認定情報().get受給者台帳_データ区分().substring(0, 1).equals(区分_4)) {
            先頭Entity.set現状態(new RString("申請取消者"));
        }
        先頭Entity.set行政区コード(t.get要介護認定情報().getPsm_行政区コード());
        先頭Entity.set行政区名称(t.get要介護認定情報().getPsm_行政区名称());
        先頭Entity.set連絡先区分1(new RString("連絡先1"));
        先頭Entity.set連絡先1(t.get要介護認定情報().getPsm_連絡先1());
        先頭Entity.set連絡先区分2(new RString("連絡先2"));
        先頭Entity.set連絡先2(t.get要介護認定情報().getPsm_連絡先2());
        先頭Entity.set老健市町村コード(t.get要介護認定情報().getT7005_老人保健市町村コード());
        先頭Entity.set老健市町村名称(t.get要介護認定情報().getT7051_市町村名称());
        先頭Entity.set老健受給者番号(t.get要介護認定情報().getT7005_老人保健受給者番号());
        先頭Entity.set地区タイトル1(t.get要介護認定情報().getPsm_地区名1());
        先頭Entity.set地区タイトル2(t.get要介護認定情報().getPsm_地区名2());
        先頭Entity.set地区タイトル3(t.get要介護認定情報().getPsm_地区名3());
        先頭Entity.set地区コード1(t.get要介護認定情報().getPsm_地区コード1());
        先頭Entity.set地区コード2(t.get要介護認定情報().getPsm_地区コード2());
        先頭Entity.set地区コード3(t.get要介護認定情報().getPsm_地区コード3());
        if (t.get要介護認定情報().getX1008_医療保険種別コード() != null) {
            先頭Entity.set医療種別(CodeMaster.getCodeMeisho(CodeShubetsu.EMPTY, new Code(t.get要介護認定情報().getX1008_医療保険種別コード()), FlexibleDate.getNowDate()));
        }
        先頭Entity.set医療保険者番号(t.get要介護認定情報().getX1008_医療保険者番号());
        先頭Entity.set医療保険者名称(t.get要介護認定情報().getX1008_医療保険者名称());
        先頭Entity.set記号番号(t.get要介護認定情報().getX1008_医療保険記号番号());
        先頭Entity.set直近管理票(t.get要介護認定情報().getX3015_サービス提供年月());
        先頭Entity.set直近実績(t.get要介護認定情報().getX3017_サービス提供年月());
        先頭Entity.set直近高額(t.get要介護認定情報().getX3056_サービス提供年月());
        先頭Entity.set直近償還(t.get要介護認定情報().getX3034_サービス提供年月());
        先頭Entity.set直近所得段階(t.get要介護認定情報().getX2002_調定年度().concat(t.get要介護認定情報().getX2002_保険料段階()));
        先頭Entity.set調査先住所(t.get要介護認定情報().getT4101_訪問調査先郵便番号());
        先頭Entity.set調査先名称(t.get要介護認定情報().getT4101_訪問調査先名称());
        先頭Entity.set調査先電話番号(t.get要介護認定情報().getT4101_訪問調査先電話番号());
        先頭Entity.set備考(get通知文情報通知文(ReportIdDBD.DBD100026.getReportId(), 1, 1));
    }
}
