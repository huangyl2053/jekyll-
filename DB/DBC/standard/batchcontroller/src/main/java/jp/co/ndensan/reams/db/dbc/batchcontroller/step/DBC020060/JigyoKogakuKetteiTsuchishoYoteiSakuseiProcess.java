/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020060;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kogakujigyoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyijiari.JigyoKogakuKetteiTsuchishoYijiAriReport;
import jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyijinashi.JigyoKogakuKetteiTsuchishoYijiNashiReport;
import jp.co.ndensan.reams.db.dbc.business.report.jigyokogakushikyufushikyukettetsuchiich.JigyoKogakuShikyuFushikyuKetteTsuchiPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.jigyokogakushikyufushikyukettetsuchiich.JigyoKogakuShikyuFushikyuKetteTsuchiReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoReportParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.JigyoKogakuShikyuFushikyuKetteTsuchiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuServiceReportEntity;
import jp.co.ndensan.reams.db.dbc.entity.jigyokogakuketteitsuchishoyijiari.JigyoKogakuKetteiTsuchishoYijiAriSource;
import jp.co.ndensan.reams.db.dbc.entity.jigyokogakuketteitsuchishoyijinashi.JigyoKogakuKetteiTsuchishoYijiNashiSource;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakushikyufushikyukettetsuchiichiran.JigyoKogakuShikyuFushikyuKetteTsuchiSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho.ServicehiShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
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
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
 * 高額総合事業サービス費支給（不支給）決定通知書作成の帳票発行
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class JigyoKogakuKetteiTsuchishoYoteiSakuseiProcess extends BatchKeyBreakBase<KogakuServiceReportEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakusogojigyoservice.IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper.get事業高額決定通知書出力データ");

    private static final ReportId 帳票分類ID = new ReportId("DBC100061_JigyoKogakuKetteiTsuchisho");
    private static final RString 帳票タイトル = new RString("事業高額支給不支給決定通知一覧表");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 自動償還フラグ_TRUE = new RString("※");
    private static final RString 被保険者氏名_出力ない = new RString("該当データがありません");
    private static final RString フラグ_TRUE = new RString("true");
    private static final RString アスタリスク = new RString("*");
    private static final RString 取り消し線_項目名 = new RString("取り消し線");
    private static final RString 帳票タイトル_項目名 = new RString("帳票タイトル");
    private static final RString 調整用_項目名 = new RString("帳票タイトル_調整用");
    private static final RString 取り消し線無し = new RString("0");
    private static final RString 事業高額介護 = new RString("高額介護（予防）サービス費相当");
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

    private KogakuKaigoServiceProcessParameter parameter;
    private JigyoKogakuKetteiTsuchishoReportParameter mybatisParameter;
    ServicehiShikyuKetteiTsuchisho service;

    private IOutputOrder 出力順;
    private List<RString> 改頁リスト;
    private List<RString> pageBreakKeys;
    private List<RString> 並び順;
    private List<RString> 通知書定型文;
    private RString 出力順情報;
    private RString 設定値1;
    private RString 設定値2;
    private RString 設定値3;
    private Association 導入団体情報;
    private boolean dataFlag;
    private RDateTime システム日時;
    private Decimal 本人支給額合計;
    private Decimal 支給額給額合計;
    private int 連番;
    private ChohyoSeigyoKyotsu 帳票制御共通情報;
    private NinshoshaSource ninshoshaSource1;
    private NinshoshaSource ninshoshaSource2;
    private RString 帳票ID;
    private JigyoKogakuShikyuFushikyuKetteTsuchiEntity lastReportEntity;

    BatchReportWriter<JigyoKogakuKetteiTsuchishoYijiNashiSource> batchReportWriter1;
    ReportSourceWriter<JigyoKogakuKetteiTsuchishoYijiNashiSource> reportSourceWriter1;
    BatchReportWriter<JigyoKogakuKetteiTsuchishoYijiAriSource> batchReportWriter2;
    ReportSourceWriter<JigyoKogakuKetteiTsuchishoYijiAriSource> reportSourceWriter2;
    BatchReportWriter<JigyoKogakuShikyuFushikyuKetteTsuchiSource> batchReportWriter3;
    ReportSourceWriter<JigyoKogakuShikyuFushikyuKetteTsuchiSource> reportSourceWriter3;

    @Override
    protected void initialize() {

        連番 = INT_0;
        dataFlag = true;
        本人支給額合計 = Decimal.ZERO;
        支給額給額合計 = Decimal.ZERO;
        並び順 = new ArrayList<>();
        改頁リスト = new ArrayList<>();
        pageBreakKeys = new ArrayList<>();
        service = ServicehiShikyuKetteiTsuchisho.createInstance();
        設定値1 = service.get設定値(帳票分類ID, 取り消し線_項目名);
        設定値2 = service.get設定値(帳票分類ID, 帳票タイトル_項目名);
        設定値3 = service.get設定値(帳票分類ID, 調整用_項目名);
        get出力順();
        システム日時 = RDateTime.now();
        導入団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        帳票制御共通情報 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票分類ID);
        通知書定型文 = get通知書定型文();
        帳票ID = DbBusinessConfig.get(ConfigNameDBC.高額決定通知書_帳票ID,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
    }

    @Override
    protected IBatchReader createReader() {
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護給付_高額 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護給付_事業高額);
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder()
                .set業務コード(GyomuCode.DB介護保険)
                .setサブ業務コード(SubGyomuCode.DBC介護給付)
                .set科目コード(介護給付_高額.getコード())
                .set基準日(FlexibleDate.getNowDate()).build();
        List<KamokuCode> kamokuList = new ShunoKamokuAuthority().
                get更新権限科目コード(UrControlDataFactory.createInstance().getLoginInfo().getUserId());
        mybatisParameter = new JigyoKogakuKetteiTsuchishoReportParameter(出力順情報,
                DbBusinessConfig.get(ConfigNameDBC.高額決定通知書_支払方法抽出区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付),
                searchKey, kamokuList);
        return new BatchDbReader(MAPPERPATH, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        if (ReportIdDBC.DBC100061.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter1 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100061.getReportId().getColumnValue()).create();
            reportSourceWriter1 = new ReportSourceWriter<>(batchReportWriter1);
            ninshoshaSource1 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleDate.getNowDate(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter1);
        } else if (ReportIdDBC.DBC100062.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter2 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100062.getReportId().getColumnValue()).create();
            reportSourceWriter2 = new ReportSourceWriter<>(batchReportWriter2);
            ninshoshaSource2 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleDate.getNowDate(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter2);
        }
        PageBreaker<JigyoKogakuShikyuFushikyuKetteTsuchiSource> breaker
                = new JigyoKogakuShikyuFushikyuKetteTsuchiPageBreak(pageBreakKeys);
        batchReportWriter3 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200078.getReportId().getColumnValue())
                .addBreak(breaker).create();
        reportSourceWriter3 = new ReportSourceWriter<>(batchReportWriter3);
    }

    @Override
    protected void keyBreakProcess(KogakuServiceReportEntity entity) {
    }

    @Override
    protected void usualProcess(KogakuServiceReportEntity entity) {

        連番 = 連番 + INT_1;
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.get宛名());
        IKoza 口座情報 = do口座マスク編集(entity.get口座());
        RString 住所 = JushoHenshu.editJusho(帳票制御共通情報, 宛名情報, 導入団体情報);
        KogakuKetteiTsuchiShoEntity reportEntity = getReportEntity(entity.get一時Entity(), 宛名情報, 口座情報);
        if (ReportIdDBC.DBC100061.getReportId().getColumnValue().equals(帳票ID)) {
            JigyoKogakuKetteiTsuchishoYijiNashiReport report1 = new JigyoKogakuKetteiTsuchishoYijiNashiReport(getタイトル(entity.get一時Entity()),
                    reportEntity, ninshoshaSource1, parameter.get文書番号(), 通知書定型文, 帳票制御共通情報, 連番);
            report1.writeBy(reportSourceWriter1);
        } else if (ReportIdDBC.DBC100062.getReportId().getColumnValue().equals(帳票ID)) {
            JigyoKogakuKetteiTsuchishoYijiAriReport report2 = new JigyoKogakuKetteiTsuchishoYijiAriReport(getタイトル(entity.get一時Entity()),
                    reportEntity, ninshoshaSource2, parameter.get文書番号(), 通知書定型文, 帳票制御共通情報, 連番);
            report2.writeBy(reportSourceWriter2);
        }
        dataFlag = false;
        JigyoKogakuShikyuFushikyuKetteTsuchiEntity fushikyuReportEntity = getFushikyuReportEntity(entity, 宛名情報, 住所);
        lastReportEntity = fushikyuReportEntity;
        JigyoKogakuShikyuFushikyuKetteTsuchiReport report = new JigyoKogakuShikyuFushikyuKetteTsuchiReport(fushikyuReportEntity, 連番, false);
        report.writeBy(reportSourceWriter3);
        本人支給額合計 = 本人支給額合計.add(entity.get一時Entity().getRiyoshaFutanGaku());
        支給額給額合計 = 支給額給額合計.add(entity.get一時Entity().getKogakuShikyuGaku());

    }

    @Override
    protected void afterExecute() {
        if (dataFlag) {
            JigyoKogakuShikyuFushikyuKetteTsuchiEntity afterEntity = new JigyoKogakuShikyuFushikyuKetteTsuchiEntity();
            set出力順と改頁(afterEntity);
            afterEntity.set被保険者氏名(被保険者氏名_出力ない);
            JigyoKogakuShikyuFushikyuKetteTsuchiReport report = new JigyoKogakuShikyuFushikyuKetteTsuchiReport(afterEntity, 連番, false);
            report.writeBy(reportSourceWriter3);
        } else {
            lastReportEntity.set支給総件数(new RString(連番));
            lastReportEntity.set本人支給額合計(doカンマ編集(本人支給額合計));
            lastReportEntity.set支給額給額合計(doカンマ編集(支給額給額合計));
            JigyoKogakuShikyuFushikyuKetteTsuchiReport report = new JigyoKogakuShikyuFushikyuKetteTsuchiReport(lastReportEntity, 連番, true);
            report.writeBy(reportSourceWriter3);
        }
        if (ReportIdDBC.DBC100061.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter1.close();
        } else if (ReportIdDBC.DBC100062.getReportId().getColumnValue().equals(帳票ID)) {
            batchReportWriter2.close();
        }
        batchReportWriter3.close();
    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        出力順 = finder.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, parameter.get出力順ID());
        if (出力順 != null) {
            出力順情報 = MyBatisOrderByClauseCreator.create(JigyoKogakuKetteiTsuchishoOutputOrder.class, 出力順);
            for (ISetSortItem item : 出力順.get設定項目リスト()) {
                並び順.add(item.getDB項目名());
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

    private KogakuKetteiTsuchiShoEntity getReportEntity(KetteiTsuchishoInfoTempEntity entity,
            IShikibetsuTaisho 宛名情報, IKoza 口座情報) {

        KogakuKetteiTsuchiShoEntity reportEntity = new KogakuKetteiTsuchiShoEntity();
        reportEntity.set識別コード(entity.getShikibetsuCode());
        if (フラグ_TRUE.equals(parameter.getテスト出力フラグ())) {
            reportEntity.setテスト出力フラグ(true);
        } else {
            reportEntity.setテスト出力フラグ(false);
        }
        reportEntity.set被保険者氏名(宛名情報.get名称().getName().getColumnValue());
        reportEntity.set被保険者番号(entity.getHihokenshaNo());
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
        if (parameter.get振込予定日() != null) {
            reportEntity.set支払予定日(new FlexibleDate(parameter.get振込予定日().toDateString()));
        }
        reportEntity.set決定通知書番号(entity.getTsuchishoNo());
        if (口座情報 != null) {
            set口座情報(reportEntity, 口座情報);
        }
        return reportEntity;
    }

    private JigyoKogakuShikyuFushikyuKetteTsuchiEntity getFushikyuReportEntity(KogakuServiceReportEntity entity,
            IShikibetsuTaisho 宛名情報, RString 住所) {
        JigyoKogakuShikyuFushikyuKetteTsuchiEntity returnEntity = new JigyoKogakuShikyuFushikyuKetteTsuchiEntity();
        set出力順と改頁(returnEntity);
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
        ShikyuKubun 支給不支給区分 = ShikyuKubun.toValue(一時Entity.getKetteiShikyuKubunCode());
        returnEntity.set支給_不支給_決定区分(支給不支給区分.get名称());
        returnEntity.set資格喪失日(formatDate(一時Entity.getShikakuSoshitsuYMD()));
        RString 喪失事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(),
                new Code(一時Entity.getShikakuSoshitsuJiyuCode()), FlexibleDate.getNowDate());
        returnEntity.set喪失事由(喪失事由);
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

    private void set出力順と改頁(JigyoKogakuShikyuFushikyuKetteTsuchiEntity returnEntity) {

        returnEntity.setテスト出力フラグ(parameter.getテスト出力フラグ());
        returnEntity.set帳票タイトル(帳票タイトル);
        if (導入団体情報.getLasdecCode_() != null) {
            returnEntity.set市町村コード(導入団体情報.getLasdecCode_().getColumnValue());
        }
        returnEntity.set市町村名称(導入団体情報.get市町村名());
        int count = INT_0;
        for (RString item : 改頁リスト) {
            if (count == INT_0) {
                returnEntity.set改頁１(item);
            } else if (count == INT_1) {
                returnEntity.set改頁２(item);
            } else if (count == INT_2) {
                returnEntity.set改頁３(item);
            } else if (count == INT_3) {
                returnEntity.set改頁４(item);
            } else if (count == INT_4) {
                returnEntity.set改頁５(item);
            }
            count = count + INT_1;
        }
        count = INT_0;
        for (RString item : 並び順) {
            if (count == INT_0) {
                returnEntity.set並び順１(item);
            } else if (count == INT_1) {
                returnEntity.set並び順２(item);
            } else if (count == INT_2) {
                returnEntity.set並び順３(item);
            } else if (count == INT_3) {
                returnEntity.set並び順４(item);
            } else if (count == INT_4) {
                returnEntity.set並び順５(item);
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

    private void set口座情報(KogakuKetteiTsuchiShoEntity reportEntity, IKoza 口座情報) {

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
                reportEntity.set通帳番号(口座情報.getEdited通帳番号());
            }
            reportEntity.set口座名義人(口座情報.get口座名義人漢字().getColumnValue());
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

    private List<RString> getタイトル(KetteiTsuchishoInfoTempEntity entity) {
        List<RString> list = new ArrayList<>();
        if (取り消し線無し.equals(設定値1)) {
            if (Decimal.ZERO.compareTo(entity.getKogakuShikyuGaku()) <= 0) {
                list.add(設定値2);
            } else {
                list.add(設定値3);
            }
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
        } else if (Decimal.ZERO.compareTo(entity.getKogakuShikyuGaku()) <= 0) {
            list.add(RString.EMPTY);
            list.add(事業高額介護);
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
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
        } else {
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(事業高額介護);
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
}
