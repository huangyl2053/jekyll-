/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD571001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.dbd571001.JukyushaDaichoCyouhyoujouhou;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100026.JukyushaDaichoReport;
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
import jp.co.ndensan.reams.db.dbd.service.report.dbd571001.OutputJokenHyo;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

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
    private static final RString 区分_0 = new RString("0");
    private int 明細;

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
    }

    @BatchWriter
    private BatchReportWriter<JukyushaDaichoReportSource> batchReportWrite;
    private ReportSourceWriter<JukyushaDaichoReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        List<IdoChushutsuDaichoEntity> entityList = mapper.get新たな抽出対象リスト();
        if (!entityList.isEmpty()) {
            for (IdoChushutsuDaichoEntity entity : entityList) {
                if (entity != null) {
                    if (!被保険者番号KEY.equals(entity.get被保険者番号())) {
                        被保険者番号KEY = entity.get被保険者番号();
                        if (entity.get被保険者番号() == null) {
                            被保険者番号リスト.add(HihokenshaNo.EMPTY);
                        } else {
                            被保険者番号リスト.add(entity.get被保険者番号());
                        }
                    }
                    if (!識別コードKEY.equals(entity.get識別コード())) {
                        識別コードKEY = entity.get識別コード();
                        if (entity.get識別コード() == null) {
                            識別コードリスト.add(ShikibetsuCode.EMPTY);
                        } else {
                            識別コードリスト.add(entity.get識別コード());
                        }
                    }

                }
            }
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
        batchReportWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBD.DBD100026.getReportId().getColumnValue(), SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(IdoChushutsuDaichoNewEntity t) {
        明細 = 明細 + 1;
        if (被保険者番号 == HihokenshaNo.EMPTY || 被保険者番号 == null) {
            被保険者番号 = t.get要介護認定情報().get受給者台帳_被保険者番号();
        } else if (!被保険者番号.equals(t.get要介護認定情報().get受給者台帳_被保険者番号())) {
            JukyushaDaichoReport report = new JukyushaDaichoReport(帳票出力用受給者台帳Entity, processParamter.get出力オプション区分());
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
        if (明細 == 1) {
            JukyushaDaichoReport report = new JukyushaDaichoReport(帳票出力用受給者台帳Entity, processParamter.get出力オプション区分());
            report.writeBy(reportSourceWriter);
        }
        AccessLogger.log(AccessLogType.照会, personalDataList);
        RString ページ数 = new RString(reportSourceWriter.pageCount().value());
        OutputJokenHyo outputJokenhyo = new OutputJokenHyo();
        outputJokenhyo.outputJokenhyoFactory(processParamter, ページ数);
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
        if (parameter.get今回抽出開始年月日() != null && parameter.get今回抽出開始時分秒() != null) {
            dbT7022entity.setTaishoKaishiTimestamp(new YMDHMS(parameter.get今回抽出開始年月日(), parameter.get今回抽出開始時分秒()));
        }
        if (parameter.get今回抽出終了年月日() != null && parameter.get今回抽出終了時分秒() != null) {
            dbT7022entity.setTaishoShuryoTimestamp(new YMDHMS(parameter.get今回抽出終了年月日(), parameter.get今回抽出終了時分秒()));
        }
        dbT7022entity.setLastUpdateTimestamp(RDate.getNowDateTime());
        dbT7022entity.setLastUpdateReamsLoginId(ControlDataHolder.getUserId());
        return dbT7022entity;
    }

    private void set帳票出力用受給者台帳Entity(IdoChushutsuDaichoNewEntity t) {
        JukyushaDaichoCyouhyoujouhou 帳票出力用受給者台帳 = new JukyushaDaichoCyouhyoujouhou();
        RString 通知文情報通知文 = get通知文情報通知文(ReportIdDBD.DBD100026.getReportId(), 1, 1);
        要介護認定情報List = 帳票出力用受給者台帳.set要介護認定情報List(t, 導入形態コード, 保険者番号の取得, 保険者名称の取得,
                通知文情報通知文, 要介護認定情報List);
        負担限度額認定情報EntityList = 帳票出力用受給者台帳.set負担限度額認定情報EntityList(t, 負担限度額認定情報EntityList);
        社福法人軽減情報EntityList = 帳票出力用受給者台帳.set社福法人軽減情報EntityList(t, 社福法人軽減情報EntityList);
        利用者負担減免情報EntityList = 帳票出力用受給者台帳.set利用者負担減免情報EntityList(t, 利用者負担減免情報EntityList);
        訪問介護等減額情報EntityList = 帳票出力用受給者台帳.set訪問介護等減額情報EntityList(t, 訪問介護等減額情報EntityList);
        標準負担減額情報EntityList = 帳票出力用受給者台帳.set標準負担減額情報EntityList(t, 標準負担減額情報EntityList);
        特別地域加算減免情報EntityList = 帳票出力用受給者台帳.set特別地域加算減免情報EntityList(t, 特別地域加算減免情報EntityList);
        施設入退所情報EntityList = 帳票出力用受給者台帳.set施設入退所情報EntityList(t, 施設入退所情報EntityList);
        居宅計画届出情報EntityList = 帳票出力用受給者台帳.set居宅計画届出情報EntityList(t, 居宅計画届出情報EntityList);
        特例施設入退所情報EntityList = 帳票出力用受給者台帳.set特例施設入退所情報EntityList(t, 特例施設入退所情報EntityList);
        支払方法変更情報EntityList = 帳票出力用受給者台帳.set支払方法変更情報EntityList(t, 支払方法変更情報EntityList);
        給付額減額情報EntityList = 帳票出力用受給者台帳.set給付額減額情報EntityList(t, 給付額減額情報EntityList);
        資格情報EntityList = 帳票出力用受給者台帳.set資格情報EntityList(t, 資格情報EntityList);
        老齢福祉年金情報EntityList = 老齢福祉年金情報EntityList = 帳票出力用受給者台帳.set老齢福祉年金情報EntityList(t, 老齢福祉年金情報EntityList);
        生活保護情報EntityList = 帳票出力用受給者台帳.set生活保護情報EntityList(t, 生活保護情報EntityList);
    }

    private RString get通知文情報通知文(ReportId reportId, int パターン番号, int 項目番号) {
        Map<Integer, RString> 通知文情報 = ReportUtil.get通知文(SubGyomuCode.DBD介護受給,
                reportId, KamokuCode.EMPTY, パターン番号);
        return null != 通知文情報 ? 通知文情報.get(項目番号) : RString.EMPTY;
    }
}
