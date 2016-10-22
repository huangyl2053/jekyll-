/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kogakujigyoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoSealer2Report;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijinashi.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteitsuchihakko.KogakuShikyuFushikyuKetteiTsuchiHakkoPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteitsuchihakko.KogakuShikyuFushikyuKetteiTsuchiHakkoReport;
import jp.co.ndensan.reams.db.dbc.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.KogakuKetteiTsuchiShoSealerReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoReportParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijinashi.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuServiceReportEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuShikyuFushikyuKetteiTsuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoSealer2Source;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer.KogakuKetteiTsuchiShoSealerSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakushikyufushikyuketteitsuchihakkoichiran.KogakuShikyuFushikyuKetteiTsuchiHakkoSource;
import jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho.ServicehiShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ua.uax.service.core.maskedkoza.MaskedKozaCreator;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額サービス費支給（不支給）決定通知書作成の帳票発行Process
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class KogakuKaigoServicehiDoChohyoHakkoProcess extends BatchKeyBreakBase<KogakuServiceReportEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservice.IKogakuKaigoServicehiShikyuKetteiTsuchishoMapper.get高額サービス帳票出力データ");
    private static final ReportId 帳票分類ID = new ReportId("DBC100007_KogakuKetteiTsuchiSho");
    private static final RString 帳票タイトル_0 = new RString("介護保険高額介護サービス費支給（不支給）決定通知一覧表");
    private static final RString 帳票タイトル = new RString("高額介護サービス費支給（不支給）決定通知一覧表");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 自動償還フラグ_TRUE = new RString("※");
    private static final RString 被保険者氏名_出力ない = new RString("該当データがありません");
    private static final RString フラグ_TRUE = new RString("true");
    private static final RString アスタリスク = new RString("*");
    private static final RString 取り消し線_項目名 = new RString("取り消し線");
    private static final RString 帳票タイトル_項目名 = new RString("帳票タイトル");
    private static final RString 調整用_項目名 = new RString("帳票タイトル_調整用");
    private static final RString 取り消し線無し = new RString("0");
    private static final RString 高額介護 = new RString("高額介護（予防）サービス費");
    private static final RString 支給区分_1 = new RString("1");
    private static final RString 支給区分_支給 = new RString("支給");
    private static final RString 支給区分_不支給 = new RString("不支給");
    private static final RString 決定通知書_NAME = new RString("決定通知書");
    private static final RString 決定通知書_調整用_NAME = new RString("決定通知書　調整用");
    private static final RString 口座表示区分_0 = new RString("0");
    private static final RString 定型文文字サイズ_1 = new RString("1");
    private static final RString 定型文文字サイズ_2 = new RString("2");
    private static final RString 定型文文字サイズ_3 = new RString("3");
    private static final RString 定型文文字サイズ_4 = new RString("4");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;

    private KogakuKaigoServiceProcessParameter parameter;
    private JigyoKogakuKetteiTsuchishoReportParameter mybatisParameter;
    ServicehiShikyuKetteiTsuchisho service;

    private Decimal 本人支給額合計;
    private Decimal 支給額給額合計;
    private RString 出力順情報;
    private List<RString> 改頁リスト;
    private List<RString> pageBreakKeys;
    private List<RString> 並び順;
    private List<RString> 通知書定型文;
    private List<RString> タイトルlist;
    private List<RString> インフォ;
    private ChohyoSeigyoKyotsu 帳票制御共通情報;
    private Association 導入団体情報;
    private boolean dataFlag;
    private RDateTime システム日時;
    private int 連番;
    private RString 設定値1;
    private RString 設定値2;
    private RString 設定値3;
    private NinshoshaSource ninshoshaSource1;
    private NinshoshaSource ninshoshaSource2;
    private NinshoshaSource ninshoshaSource3;
    private NinshoshaSource ninshoshaSource4;
    private RString 帳票ID;
    private KogakuShikyuFushikyuKetteiTsuchiHakkoEntity lastReportEntity;

    BatchReportWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> batchReportWriter1;
    ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> reportSourceWriter1;
    BatchReportWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource> batchReportWriter2;
    ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource> reportSourceWriter2;
    BatchReportWriter<KogakuKetteiTsuchiShoSealerSource> batchReportWriter3;
    ReportSourceWriter<KogakuKetteiTsuchiShoSealerSource> reportSourceWriter3;
    BatchReportWriter<KogakuKetteiTsuchiShoSealer2Source> batchReportWriter4;
    ReportSourceWriter<KogakuKetteiTsuchiShoSealer2Source> reportSourceWriter4;
    BatchReportWriter<KogakuShikyuFushikyuKetteiTsuchiHakkoSource> batchReportWriter5;
    ReportSourceWriter<KogakuShikyuFushikyuKetteiTsuchiHakkoSource> reportSourceWriter5;

    @Override
    protected void initialize() {

        dataFlag = true;
        連番 = INT_0;
        本人支給額合計 = Decimal.ZERO;
        支給額給額合計 = Decimal.ZERO;
        並び順 = new ArrayList<>();
        改頁リスト = new ArrayList<>();
        pageBreakKeys = new ArrayList<>();
        システム日時 = RDateTime.now();
        service = ServicehiShikyuKetteiTsuchisho.createInstance();
        タイトルlist = service.getタイトル(帳票分類ID);
        設定値1 = service.get設定値(帳票分類ID, 取り消し線_項目名);
        設定値2 = service.get設定値(帳票分類ID, 帳票タイトル_項目名);
        設定値3 = service.get設定値(帳票分類ID, 調整用_項目名);
        インフォ = getインフォ();
        get出力順();
        導入団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        帳票制御共通情報 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票分類ID);
        帳票ID = DbBusinessConfig.get(ConfigNameDBC.高額決定通知書_帳票ID, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (ReportIdDBC.DBC100010.getReportId().getColumnValue().equals(帳票ID)) {
            通知書定型文 = get通知書定型文2();
        } else {
            通知書定型文 = get通知書定型文();
        }
    }

    @Override
    protected BatchDbReader createReader() {
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護給付_高額 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護給付_高額);
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder()
                .set業務コード(GyomuCode.DB介護保険)
                .setサブ業務コード(SubGyomuCode.DBC介護給付)
                .set科目コード(介護給付_高額.getコード())
                .set基準日(FlexibleDate.getNowDate()).build();
        List<KamokuCode> kamokuList = new ShunoKamokuAuthority().
                get参照権限科目コード(UrControlDataFactory.createInstance().getLoginInfo().getUserId());
        mybatisParameter = new JigyoKogakuKetteiTsuchishoReportParameter(出力順情報,
                DbBusinessConfig.get(ConfigNameDBC.高額決定通知書_支払方法抽出区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付),
                searchKey, kamokuList);
        return new BatchDbReader(MAPPERPATH, mybatisParameter);
    }

    @Override
    protected void createWriter() {

        if (ReportIdDBC.DBC100007_支給.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter1 = BatchReportFactory.createBatchReportWriter(帳票ID).create();
            reportSourceWriter1 = new ReportSourceWriter<>(batchReportWriter1);
            ninshoshaSource1 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleDate.getNowDate(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter1);
        } else if (ReportIdDBC.DBC100008.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter2 = BatchReportFactory.createBatchReportWriter(帳票ID).create();
            reportSourceWriter2 = new ReportSourceWriter<>(batchReportWriter2);
            ninshoshaSource2 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleDate.getNowDate(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter2);
        } else if (ReportIdDBC.DBC100009.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter3 = BatchReportFactory.createBatchReportWriter(帳票ID).create();
            reportSourceWriter3 = new ReportSourceWriter<>(batchReportWriter3);
            ninshoshaSource3 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleDate.getNowDate(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter3);
        } else if (ReportIdDBC.DBC100010.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter4 = BatchReportFactory.createBatchReportWriter(帳票ID).create();
            reportSourceWriter4 = new ReportSourceWriter<>(batchReportWriter4);
            ninshoshaSource4 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleDate.getNowDate(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter4);
        }
        PageBreaker<KogakuShikyuFushikyuKetteiTsuchiHakkoSource> breaker
                = new KogakuShikyuFushikyuKetteiTsuchiHakkoPageBreak(pageBreakKeys);
        batchReportWriter5 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200020.getReportId().getColumnValue())
                .addBreak(breaker).create();
        reportSourceWriter5 = new ReportSourceWriter<>(batchReportWriter5);
    }

    @Override
    protected void keyBreakProcess(KogakuServiceReportEntity entity) {
    }

    @Override
    protected void usualProcess(KogakuServiceReportEntity entity) {

        dataFlag = false;
        連番 = 連番 + INT_1;
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.get宛名());
        IKoza 口座情報 = null;
        if (entity.get口座() != null && entity.get口座().getUaT0310KozaEntity().getKozaId() != 0L) {
            口座情報 = do口座マスク編集(entity.get口座());
        }
        RString 金融機関コード = 口座情報 == null || 口座情報.get金融機関コード() == null ? RString.EMPTY
                : 口座情報.get金融機関コード().getColumnValue();
        KetteiTsuchishoInfoTempEntity 一時Entity = entity.get一時Entity();
        if (ReportIdDBC.DBC100007_支給.getReportId().getColumnValue().equals(帳票ID)) {
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity reportEntity1 = getReportEntity(一時Entity, 宛名情報, 口座情報);
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaReport report1
                    = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaReport(reportEntity1, 連番, getタイトル(一時Entity), 通知書定型文,
                            ninshoshaSource1, 帳票制御共通情報, 金融機関コード);
            report1.writeBy(reportSourceWriter1);
        } else if (ReportIdDBC.DBC100008.getReportId().getColumnValue().equals(帳票ID)) {
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity reportEntity2 = getReportEntity(一時Entity, 宛名情報, 口座情報);
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiReport report2
                    = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiReport(reportEntity2, 連番, getタイトル(一時Entity), 通知書定型文,
                            ninshoshaSource2, 帳票制御共通情報, 金融機関コード);
            report2.writeBy(reportSourceWriter2);
        } else if (ReportIdDBC.DBC100009.getReportId().getColumnValue().equals(帳票ID)) {
            KogakuKetteiTsuchiShoEntity reportEntity3 = getShoSealerReportEntity(一時Entity, 宛名情報, 口座情報);
            KogakuKetteiTsuchiShoSealerReport report3 = new KogakuKetteiTsuchiShoSealerReport(reportEntity3, parameter.get文書番号(),
                    通知書定型文, インフォ, ninshoshaSource3, タイトルlist, 連番);
            report3.writeBy(reportSourceWriter3);
        } else if (ReportIdDBC.DBC100010.getReportId().getColumnValue().equals(帳票ID)) {
            KogakuKetteiTsuchiShoEntity reportEntity4 = getShoSealer2ReportEntity(一時Entity, 宛名情報, 口座情報);
            KogakuKetteiTsuchiShoSealer2Report report4
                    = new KogakuKetteiTsuchiShoSealer2Report(getタイトル(一時Entity), reportEntity4, ninshoshaSource4, parameter.get文書番号(), 連番);
            report4.writeBy(reportSourceWriter4);
        }
        RString 住所 = JushoHenshu.editJusho(帳票制御共通情報, 宛名情報, 導入団体情報);
        KogakuShikyuFushikyuKetteiTsuchiHakkoEntity fushikyuReportEntity = getFushikyuReportEntity(entity, 宛名情報, 住所);
        lastReportEntity = fushikyuReportEntity;
        KogakuShikyuFushikyuKetteiTsuchiHakkoReport report = new KogakuShikyuFushikyuKetteiTsuchiHakkoReport(fushikyuReportEntity, 連番, false);
        report.writeBy(reportSourceWriter5);
        本人支給額合計 = 本人支給額合計.add(entity.get一時Entity().getRiyoshaFutanGaku() == null ? Decimal.ZERO
                : entity.get一時Entity().getRiyoshaFutanGaku());
        支給額給額合計 = 支給額給額合計.add(entity.get一時Entity().getKogakuShikyuGaku() == null ? Decimal.ZERO
                : entity.get一時Entity().getKogakuShikyuGaku());

    }

    @Override
    protected void afterExecute() {
        if (dataFlag) {
            KogakuShikyuFushikyuKetteiTsuchiHakkoEntity afterEntity = new KogakuShikyuFushikyuKetteiTsuchiHakkoEntity();
            set出力順と改頁(afterEntity);
            afterEntity.setテスト印刷(帳票タイトル_0);
            afterEntity.set被保険者氏名(被保険者氏名_出力ない);
            KogakuShikyuFushikyuKetteiTsuchiHakkoReport report = new KogakuShikyuFushikyuKetteiTsuchiHakkoReport(afterEntity, 連番, false);
            report.writeBy(reportSourceWriter5);
        } else {
            lastReportEntity.set支給総件数(new RString(連番));
            lastReportEntity.set本人支給額合計(doカンマ編集(本人支給額合計));
            lastReportEntity.set支給額給額合計(doカンマ編集(支給額給額合計));
            KogakuShikyuFushikyuKetteiTsuchiHakkoReport report = new KogakuShikyuFushikyuKetteiTsuchiHakkoReport(lastReportEntity, 連番, true);
            report.writeBy(reportSourceWriter5);
        }
        if (ReportIdDBC.DBC100007_支給.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter1.close();
        } else if (ReportIdDBC.DBC100008.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter2.close();
        } else if (ReportIdDBC.DBC100009.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter3.close();
        } else if (ReportIdDBC.DBC100010.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter4.close();
        }
        batchReportWriter5.close();
    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder 出力順 = finder.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, parameter.get出力順ID());
        if (出力順 != null) {
            出力順情報 = MyBatisOrderByClauseCreator.create(JigyoKogakuKetteiTsuchishoOutputOrder.class, 出力順);
            for (ISetSortItem item : 出力順.get設定項目リスト()) {
                並び順.add(item.get項目名());
                if (item.is改頁項目()) {
                    pageBreakKeys.add(item.get項目ID());
                    改頁リスト.add(item.get項目名());
                }
            }
        } else {
            出力順情報 = RString.EMPTY;
        }
    }

    private IKoza do口座マスク編集(TokuteiKozaRelateEntity koza) {
        if (帳票制御共通情報.is口座マスク有無()) {
            if (口座表示区分_0.equals(koza.getUaT0310KozaEntity().getKozaHyojiKubun())) {
                MaskedKozaCreator maskedKozaCreator = MaskedKozaCreator.createInstance(SubGyomuCode.DBC介護給付);
                return maskedKozaCreator.createマスク編集済口座(new Koza(koza));
            }
        }
        return null;
    }

    private List<RString> get通知書定型文() {
        RString 通知書0 = RString.EMPTY;
        RString 通知書1 = RString.EMPTY;
        RString 通知書2 = RString.EMPTY;
        RString 通知書3 = RString.EMPTY;
        Map<Integer, RString> map = new HashMap<>();
        if (定型文文字サイズ_1.equals(帳票制御共通情報.get定型文文字サイズ())) {
            map = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, INT_1);
        } else if (定型文文字サイズ_2.equals(帳票制御共通情報.get定型文文字サイズ())) {
            map = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, INT_2);
        } else if (定型文文字サイズ_3.equals(帳票制御共通情報.get定型文文字サイズ())) {
            map = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, INT_3);
        } else if (定型文文字サイズ_4.equals(帳票制御共通情報.get定型文文字サイズ())) {
            map = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, INT_4);
        }
        if (!map.isEmpty()) {
            通知書0 = map.get(INT_0);
            通知書1 = map.get(INT_1);
            通知書2 = map.get(INT_2);
            通知書3 = map.get(INT_3);
        }
        List<RString> list = new ArrayList<>();
        list.add(通知書0);
        list.add(通知書1);
        list.add(通知書2);
        list.add(通知書3);
        return list;
    }

    private List<RString> get通知書定型文2() {
        RString 通知書0 = RString.EMPTY;
        RString 通知書1 = RString.EMPTY;
        RString 通知書2 = RString.EMPTY;
        RString 通知書3 = RString.EMPTY;
        Map<Integer, RString> map = new HashMap<>();
        if (定型文文字サイズ_1.equals(帳票制御共通情報.get定型文文字サイズ())) {
            map = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, INT_5);
        }
        if (!map.isEmpty()) {
            通知書0 = map.get(INT_0);
            通知書1 = map.get(INT_1);
            通知書2 = map.get(INT_2);
            通知書3 = map.get(INT_3);
        }
        List<RString> list = new ArrayList<>();
        list.add(通知書0);
        list.add(通知書1);
        list.add(通知書2);
        list.add(通知書3);
        return list;
    }

    private KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity getReportEntity(KetteiTsuchishoInfoTempEntity entity,
            IShikibetsuTaisho 宛名情報, IKoza 口座情報) {
        KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity reportEntity = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity();
        if (フラグ_TRUE.equals(parameter.getテスト出力フラグ())) {
            reportEntity.setテスト出力フラグ(true);
        } else {
            reportEntity.setテスト出力フラグ(false);
        }
        reportEntity.set文書番号(parameter.get文書番号());
        reportEntity.set被保険者氏名(宛名情報.get名称().getName().value());
        reportEntity.set被保険者番号(entity.getHihokenshaNo());
        reportEntity.set決定年月日(toRDate(entity.getKetteiYMD()));
        reportEntity.set支払予定日(parameter.get振込予定日());
        reportEntity.set受付年月日(toRDate(entity.getUketsukeYMD()));
        reportEntity.set本人支払額(entity.getRiyoshaFutanGaku());
        reportEntity.set対象年月(entity.getServiceTeikyoYM());
        reportEntity.set給付の種類(entity.getServiceShuruiName());
        reportEntity.set支給_不支給決定区分(entity.getKetteiShikyuKubunCode());
        reportEntity.set支給金額(entity.getKogakuShikyuGaku());
        reportEntity.set不支給理由(entity.getFushikyuRiyu());
        reportEntity.set支払方法区分(entity.getShiharaiHohoKubunCode());
        reportEntity.set持ちもの(通知書定型文.get(INT_0));
        reportEntity.set支払場所(entity.getShiharaiBasho());
        reportEntity.set決定通知書番号(entity.getTsuchishoNo());
        reportEntity.set支払期間開始年月日(toRDate(entity.getShiharaiKaishiYMD()));
        reportEntity.set支払期間終了年月日(toRDate(entity.getShiharaiShuryoYMD()));
        reportEntity.set支払窓口開始時間(entity.getShiharaiKaishiTime());
        reportEntity.set支払窓口終了時間(entity.getShiharaiShuryoTime());
        if (口座情報 != null) {
            set口座情報_3(reportEntity, 口座情報);
        }
        return reportEntity;
    }

    private KogakuKetteiTsuchiShoEntity getShoSealer2ReportEntity(KetteiTsuchishoInfoTempEntity entity,
            IShikibetsuTaisho 宛名情報, IKoza 口座情報) {
        KogakuKetteiTsuchiShoEntity reportEntity = new KogakuKetteiTsuchiShoEntity();
        reportEntity.set識別コード(entity.getShikibetsuCode());
        if (フラグ_TRUE.equals(parameter.getテスト出力フラグ())) {
            reportEntity.setテスト出力フラグ(true);
        } else {
            reportEntity.setテスト出力フラグ(false);
        }
        reportEntity.set被保険者氏名(宛名情報.get名称().getName().value());
        reportEntity.set被保険者番号(entity.getHihokenshaNo());
        if (entity.getShoKisaiHokenshaNo() != null) {
            reportEntity.set証記載保険者番号(new ShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo().getColumnValue()));
        }
        reportEntity.set受付年月日(entity.getUketsukeYMD());
        reportEntity.set決定年月日(entity.getKetteiYMD());
        reportEntity.set本人支払額(entity.getRiyoshaFutanGaku());
        reportEntity.set対象年月(entity.getServiceTeikyoYM());
        reportEntity.set給付の種類(entity.getServiceShuruiName());
        reportEntity.set支給不支給決定区分(entity.getKetteiShikyuKubunCode());
        reportEntity.set支給金額(entity.getKogakuShikyuGaku());
        reportEntity.set不支給理由(entity.getFushikyuRiyu());
        reportEntity.set支払方法区分(entity.getShiharaiHohoKubunCode());
        reportEntity.set持ちもの(通知書定型文.get(INT_0));
        reportEntity.set支払場所(entity.getShiharaiBasho());
        reportEntity.set支払期間開始年月日(entity.getShiharaiKaishiYMD());
        reportEntity.set支払期間終了年月日(entity.getShiharaiShuryoYMD());
        reportEntity.set支払窓口開始時間(entity.getShiharaiKaishiTime());
        reportEntity.set支払窓口終了時間(entity.getShiharaiShuryoTime());
        if (口座情報 != null) {
            set口座情報_2(reportEntity, 口座情報);
        }
        reportEntity.set決定通知書番号(entity.getTsuchishoNo());
        reportEntity.set自動償還対象フラグ(entity.isJidoShokanTaishoFlag());
        return reportEntity;
    }

    private KogakuKetteiTsuchiShoEntity getShoSealerReportEntity(KetteiTsuchishoInfoTempEntity entity,
            IShikibetsuTaisho 宛名情報, IKoza 口座情報) {
        KogakuKetteiTsuchiShoEntity reportEntity = new KogakuKetteiTsuchiShoEntity();
        reportEntity.set識別コード(entity.getShikibetsuCode());
        if (フラグ_TRUE.equals(parameter.getテスト出力フラグ())) {
            reportEntity.setテスト出力フラグ(true);
        } else {
            reportEntity.setテスト出力フラグ(false);
        }
        reportEntity.set被保険者氏名(宛名情報.get名称().getName().value());
        reportEntity.set被保険者番号(entity.getHihokenshaNo());
        reportEntity.set決定年月日(entity.getKetteiYMD());
        reportEntity.set支払金額合計(entity.getKogakuShikyuGaku());
        if (parameter.get振込予定日() != null) {
            reportEntity.set支払予定日(new FlexibleDate(parameter.get振込予定日().toDateString()));
        }
        reportEntity.set対象年月1(entity.getServiceTeikyoYM());
        reportEntity.set支給金額1(entity.getKogakuShikyuGaku());
        reportEntity.set支給不支給決定区分(entity.getKetteiShikyuKubunCode());
        reportEntity.set支払方法区分(entity.getShiharaiHohoKubunCode());
        if (口座情報 != null) {
            set口座情報_1(reportEntity, 口座情報);
        }
        return reportEntity;
    }

    private void set口座情報_3(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity reportEntity, IKoza 口座情報) {
        reportEntity.setゆうちょ銀行フラグ(口座情報.isゆうちょ銀行());
        if (フラグ_TRUE.equals(parameter.get利用者向け決定通知書フラグ())) {
            if (!口座情報.isゆうちょ銀行()) {
                reportEntity.set金融機関上段(口座情報.get金融機関().get金融機関名称());
                reportEntity.set金融機関下段(口座情報.get支店().get支店名称());
                reportEntity.set口座種別(口座情報.get預金種別名称());
                reportEntity.set口座番号(口座情報.get口座番号());
            } else {
                reportEntity.set金融機関上段(口座情報.get金融機関().get金融機関名称());
                reportEntity.set金融機関下段(口座情報.get支店().get支店名称());
                reportEntity.set通帳記号(口座情報.get通帳記号());
                reportEntity.set通帳番号(口座情報.get通帳番号());
            }
            reportEntity.set口座名義人(口座情報.get口座名義人漢字() == null ? RString.EMPTY : 口座情報.get口座名義人漢字().value());
        } else if (フラグ_TRUE.equals(parameter.get受領委任者向け決定通知書フラグ())) {
            if (!口座情報.isゆうちょ銀行()) {
                reportEntity.set金融機関上段(アスタリスク);
                reportEntity.set金融機関下段(アスタリスク);
                reportEntity.set口座種別(アスタリスク);
                reportEntity.set口座番号(アスタリスク);
            } else {
                reportEntity.set金融機関上段(アスタリスク);
                reportEntity.set金融機関下段(アスタリスク);
                reportEntity.set通帳記号(アスタリスク);
                reportEntity.set通帳番号(アスタリスク);
            }
            reportEntity.set口座名義人(アスタリスク);
        }
    }

    private void set口座情報_1(KogakuKetteiTsuchiShoEntity reportEntity, IKoza 口座情報) {
        reportEntity.setゆうちょ銀行フラグ(口座情報.isゆうちょ銀行());
        reportEntity.set金融機関コード(口座情報.get金融機関コード() == null ? RString.EMPTY
                : 口座情報.get金融機関コード().getColumnValue());
        if (フラグ_TRUE.equals(parameter.get利用者向け決定通知書フラグ())) {
            if (!口座情報.isゆうちょ銀行()) {
                reportEntity.set金融機関上段(口座情報.get金融機関().get金融機関名称());
                reportEntity.set金融機関下段(口座情報.get支店().get支店名称());
                reportEntity.set口座種別(口座情報.get預金種別名称());
                reportEntity.set口座番号(口座情報.get口座番号());
            } else {
                reportEntity.set金融機関上段(口座情報.get金融機関().get金融機関名称());
                reportEntity.set金融機関下段(口座情報.get支店().get支店名称());
                reportEntity.set通帳記号(口座情報.get通帳記号());
                reportEntity.set通帳番号(口座情報.get通帳番号());
            }
            reportEntity.set口座名義人(口座情報.get口座名義人漢字() == null ? RString.EMPTY : 口座情報.get口座名義人漢字().value());
        } else if (フラグ_TRUE.equals(parameter.get受領委任者向け決定通知書フラグ())) {
            if (!口座情報.isゆうちょ銀行()) {
                reportEntity.set金融機関上段(アスタリスク);
                reportEntity.set金融機関下段(アスタリスク);
                reportEntity.set口座種別(アスタリスク);
                reportEntity.set口座番号(アスタリスク);
            } else {
                reportEntity.set金融機関上段(アスタリスク);
                reportEntity.set金融機関下段(アスタリスク);
                reportEntity.set通帳記号(アスタリスク);
                reportEntity.set通帳番号(アスタリスク);
            }
            reportEntity.set口座名義人(アスタリスク);
        }
    }

    private void set口座情報_2(KogakuKetteiTsuchiShoEntity reportEntity, IKoza 口座情報) {
        reportEntity.setゆうちょ銀行フラグ(口座情報.isゆうちょ銀行());
        reportEntity.set金融機関コード(口座情報.get金融機関コード() == null ? RString.EMPTY
                : 口座情報.get金融機関コード().getColumnValue());
        if (!口座情報.isゆうちょ銀行()) {
            reportEntity.set金融機関上段(口座情報.get金融機関().get金融機関名称());
            reportEntity.set金融機関下段(口座情報.get支店().get支店名称());
            reportEntity.set口座種別(口座情報.get預金種別名称());
            reportEntity.set口座番号(口座情報.get口座番号());
        } else {
            reportEntity.set金融機関上段(口座情報.get金融機関().get金融機関名称());
            reportEntity.set金融機関下段(口座情報.get支店().get支店名称());
            reportEntity.set通帳記号(口座情報.get通帳記号());
            reportEntity.set通帳番号(口座情報.get通帳番号());
        }
        reportEntity.set口座名義人(口座情報.get口座名義人漢字() == null ? RString.EMPTY : 口座情報.get口座名義人漢字().value());
    }

    private KogakuShikyuFushikyuKetteiTsuchiHakkoEntity getFushikyuReportEntity(KogakuServiceReportEntity entity,
            IShikibetsuTaisho 宛名情報, RString 住所) {
        KogakuShikyuFushikyuKetteiTsuchiHakkoEntity returnEntity = new KogakuShikyuFushikyuKetteiTsuchiHakkoEntity();
        set出力順と改頁(returnEntity);
        returnEntity.setテスト印刷(帳票タイトル);
        KetteiTsuchishoInfoTempEntity 一時Entity = entity.get一時Entity();
        returnEntity.set決定通知No(一時Entity.getTsuchishoNo() == null ? RString.EMPTY : 一時Entity.getTsuchishoNo());
        if (null != 一時Entity.getHihokenshaNo()) {
            returnEntity.set被保険者番号(一時Entity.getHihokenshaNo().getColumnValue());
        }
        returnEntity.set被保険者氏名(宛名情報.get名称().getName().getColumnValue());
        returnEntity.set住所(住所);
        returnEntity.set郵便番号(宛名情報.get住所().get郵便番号().getEditedYubinNo());
        if (null != 一時Entity.getServiceTeikyoYM()) {
            returnEntity.set提供年月(一時Entity.getServiceTeikyoYM().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (null != 一時Entity.getServiceTeikyoYM() && null != 一時Entity.getYokaigoJotaiKubunCode()
                && !一時Entity.getYokaigoJotaiKubunCode().isEmpty()) {
            IYokaigoJotaiKubun 要介護度 = YokaigoJotaiKubunSupport.toValue(一時Entity.getServiceTeikyoYM(),
                    一時Entity.getYokaigoJotaiKubunCode().getColumnValue());
            returnEntity.set要介護度(要介護度.getName());
        }

        returnEntity.set認定開始日(formatDate(一時Entity.getNinteiYukoKikanKaishiYMD()));
        returnEntity.set認定終了日(formatDate(一時Entity.getNinteiYukoKikanShuryoYMD()));
        returnEntity.set受付年月日(formatDate(一時Entity.getUketsukeYMD()));
        returnEntity.set決定年月日(formatDate(一時Entity.getKetteiYMD()));
        returnEntity.set本人支払額(doカンマ編集(一時Entity.getRiyoshaFutanGaku()));
        returnEntity.set支給額(doカンマ編集(一時Entity.getKogakuShikyuGaku()));
        if (null != 一時Entity.getKetteiShikyuKubunCode() && !一時Entity.getKetteiShikyuKubunCode().isEmpty()) {
            ShikyuKubun 支給不支給決定区分 = ShikyuKubun.toValue(一時Entity.getKetteiShikyuKubunCode());
            returnEntity.set支給_不支給_決定区分(支給不支給決定区分.get名称());
        }
        returnEntity.set資格喪失日(formatDate(一時Entity.getShikakuSoshitsuYMD()));
        if (一時Entity.getShikakuSoshitsuJiyuCode() != null && !一時Entity.getShikakuSoshitsuJiyuCode().isEmpty()) {
            RString 喪失事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(),
                    new Code(一時Entity.getShikakuSoshitsuJiyuCode()), FlexibleDate.getNowDate());
            returnEntity.set喪失事由(喪失事由);
        }
        if (一時Entity.isJidoShokanTaishoFlag()) {
            returnEntity.set自動償還(自動償還フラグ_TRUE);
        } else {
            returnEntity.set自動償還(RString.HALF_SPACE);
        }
        returnEntity.set町域コード(entity.get町域コード() == null ? RString.EMPTY : entity.get町域コード().getColumnValue());
        returnEntity.set行政区コード(entity.get行政区コード() == null ? RString.EMPTY : entity.get行政区コード().getColumnValue());
        returnEntity.set氏名５０音カナ(entity.getカナ名称() == null ? RString.EMPTY : entity.getカナ名称().getColumnValue());
        returnEntity.set証記載保険者番号(一時Entity.getShoKisaiHokenshaNo() == null ? RString.EMPTY
                : 一時Entity.getShoKisaiHokenshaNo().getColumnValue());
        returnEntity.set資格状態区分(一時Entity.getShikakuJyotaiKubun() == null ? RString.EMPTY : 一時Entity.getShikakuJyotaiKubun());
        return returnEntity;
    }

    private void set出力順と改頁(KogakuShikyuFushikyuKetteiTsuchiHakkoEntity returnEntity) {

        returnEntity.setテスト印刷(parameter.getテスト出力フラグ());
        if (導入団体情報.getLasdecCode_() != null) {
            returnEntity.set市町村コード(導入団体情報.getLasdecCode_().getColumnValue());
        }
        returnEntity.set市町村名称(導入団体情報.get市町村名());
        int count = INT_0;
        for (RString item : 改頁リスト) {
            if (count == INT_0) {
                returnEntity.set改頁1(item);
            } else if (count == INT_1) {
                returnEntity.set改頁2(item);
            } else if (count == INT_2) {
                returnEntity.set改頁3(item);
            } else if (count == INT_3) {
                returnEntity.set改頁4(item);
            } else if (count == INT_4) {
                returnEntity.set改頁5(item);
            }
            count = count + INT_1;
        }
        count = INT_0;
        for (RString item : 並び順) {
            if (count == INT_0) {
                returnEntity.set並び順1(item);
            } else if (count == INT_1) {
                returnEntity.set並び順2(item);
            } else if (count == INT_2) {
                returnEntity.set並び順3(item);
            } else if (count == INT_3) {
                returnEntity.set並び順4(item);
            } else if (count == INT_4) {
                returnEntity.set並び順5(item);
            }
            count = count + INT_1;
        }
        RString 作成日 = システム日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = システム日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        returnEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI));
    }

    private RString formatDate(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString doカンマ編集(Decimal data) {
        if (null == data) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(data, 0);
    }

    private List<RString> getインフォ() {
        List<RString> list = new ArrayList<>();
        RString インフォ1 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, INT_1, INT_2, FlexibleDate.getNowDate());
        list.add(インフォ1);
        return list;
    }

    private RDate toRDate(FlexibleDate date) {
        if (date == null) {
            return null;
        }
        return new RDate(date.toString());
    }

    private List<RString> getタイトル(KetteiTsuchishoInfoTempEntity entity) {
        List<RString> list = new ArrayList<>();
        if (entity.getKogakuShikyuGaku() == null) {
            list.add(RString.EMPTY);
            set6_ListEmpty(list);
            set6_ListEmpty(list);
        } else if (取り消し線無し.equals(設定値1)) {
            if (Decimal.ZERO.compareTo(entity.getKogakuShikyuGaku()) <= 0) {
                list.add(設定値2);
            } else {
                list.add(設定値3);
            }
            set6_ListEmpty(list);
            set6_ListEmpty(list);
        } else if (Decimal.ZERO.compareTo(entity.getKogakuShikyuGaku()) <= 0) {
            list.add(RString.EMPTY);
            list.add(高額介護);
            if (支給区分_1.equals(entity.getKetteiShikyuKubunCode())) {
                list.add(支給区分_支給);
                list.add(RString.EMPTY);
                list.add(RString.EMPTY);
                list.add(支給区分_不支給);
            } else {
                list.add(RString.EMPTY);
                list.add(支給区分_支給);
                list.add(支給区分_不支給);
                list.add(RString.EMPTY);
            }
            list.add(決定通知書_NAME);
            set6_ListEmpty(list);
        } else {
            list.add(RString.EMPTY);
            set6_ListEmpty(list);
            list.add(高額介護);
            if (支給区分_1.equals(entity.getKetteiShikyuKubunCode())) {
                list.add(支給区分_支給);
                list.add(RString.EMPTY);
                list.add(RString.EMPTY);
                list.add(支給区分_不支給);
            } else {
                list.add(RString.EMPTY);
                list.add(支給区分_支給);
                list.add(支給区分_不支給);
                list.add(RString.EMPTY);
            }
            list.add(決定通知書_調整用_NAME);
        }
        return list;
    }

    private void set6_ListEmpty(List<RString> list) {
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
    }
}
