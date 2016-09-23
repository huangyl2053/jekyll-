/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020060;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakujigyoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.jigyokogakushikyufushikyukettetsuchiich.JigyoKogakuShikyuFushikyuKetteTsuchiPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.jigyokogakushikyufushikyukettetsuchiich.JigyoKogakuShikyuFushikyuKetteTsuchiReport;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku.KubunShikyuGendogakuYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoReportParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.JigyoKogakuShikyuFushikyuKetteTsuchiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakushikyufushikyukettetsuchiichiran.JigyoKogakuShikyuFushikyuKetteTsuchiSource;
import jp.co.ndensan.reams.db.dbd.definition.core.shokanbaraikyufu.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 高額総合事業サービス費支給（不支給）決定通知書作成の帳票発行_一覧Process
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class JigyoKogakuShikyuFushikyuKetteTsuchiSakuseiProcess extends BatchKeyBreakBase<KetteiTsuchishoInfoTempResultEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakusogojigyoservice.IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper.get事業高額決定通知書出力データ");

    private static final ReportId 帳票分類ID = new ReportId("DBC100061_JigyoKogakuKetteiTsuchisho");
    private static final RString 帳票タイトル = new RString("事業高額支給不支給決定通知一覧表");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 自動償還フラグ_TRUE = new RString("※");
    private static final RString 自動償還フラグ_FALSE = new RString(" ");
    private static final RString 被保険者氏名_出力ない = new RString("該当データがありません");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;

    private KogakuKaigoServiceProcessParameter parameter;
    private JigyoKogakuKetteiTsuchishoReportParameter mybatisParameter;

    private IOutputOrder 出力順;
    private List<RString> 改頁リスト;
    private List<RString> pageBreakKeys;
    private List<RString> 並び順;
    private ChohyoSeigyoKyotsu 帳票制御共通情報;
    private Association 導入団体情報;
    private boolean dataFlag;
    private RDateTime システム日時;
    private RString 住所;
    private RString 出力順情報;
    private int 連番;

    @BatchWriter
    BatchReportWriter<JigyoKogakuShikyuFushikyuKetteTsuchiSource> batchReportWriter;
    ReportSourceWriter<JigyoKogakuShikyuFushikyuKetteTsuchiSource> reportSourceWriter;

    @Override
    protected void initialize() {

        dataFlag = true;
        連番 = INT_1;
        並び順 = new ArrayList<>();
        改頁リスト = new ArrayList<>();
        pageBreakKeys = new ArrayList<>();
        mybatisParameter = new JigyoKogakuKetteiTsuchishoReportParameter();
        システム日時 = RDateTime.now();
        導入団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        get出力順();
        帳票制御共通情報 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票分類ID);
    }

    @Override
    protected IBatchReader createReader() {
        mybatisParameter.set出力順(出力順情報);
        return new BatchDbReader(MAPPERPATH, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<JigyoKogakuShikyuFushikyuKetteTsuchiSource> breaker
                = new JigyoKogakuShikyuFushikyuKetteTsuchiPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200078.getReportId().getColumnValue())
                .addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

    }

    @Override
    protected void keyBreakProcess(KetteiTsuchishoInfoTempResultEntity entity) {
    }

    @Override
    protected void usualProcess(KetteiTsuchishoInfoTempResultEntity entity) {

        dataFlag = false;
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.get宛名());
        住所 = JushoHenshu.editJusho(帳票制御共通情報, 宛名情報, 導入団体情報);
        JigyoKogakuShikyuFushikyuKetteTsuchiEntity reportEntity = getFushikyuReportEntity(entity);
        JigyoKogakuShikyuFushikyuKetteTsuchiReport report = new JigyoKogakuShikyuFushikyuKetteTsuchiReport(reportEntity, 連番);
        report.writeBy(reportSourceWriter);
        連番 = 連番 + INT_1;
    }

    @Override
    protected void afterExecute() {
        if (dataFlag) {
            JigyoKogakuShikyuFushikyuKetteTsuchiEntity afterEntity = new JigyoKogakuShikyuFushikyuKetteTsuchiEntity();
            afterEntity.setテスト出力フラグ(parameter.getテスト出力フラグ());
            set出力順と改頁(afterEntity);
            afterEntity.set被保険者氏名(被保険者氏名_出力ない);
            JigyoKogakuShikyuFushikyuKetteTsuchiReport report = new JigyoKogakuShikyuFushikyuKetteTsuchiReport(afterEntity, 連番);
            report.writeBy(reportSourceWriter);
        }
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

    private JigyoKogakuShikyuFushikyuKetteTsuchiEntity getFushikyuReportEntity(KetteiTsuchishoInfoTempResultEntity entity) {
        JigyoKogakuShikyuFushikyuKetteTsuchiEntity returnEntity = new JigyoKogakuShikyuFushikyuKetteTsuchiEntity();
        set出力順と改頁(returnEntity);
        returnEntity.set決定通知No(entity.get決定通知No());
        if (null != entity.get被保険者番号()) {
            returnEntity.set被保険者番号(entity.get被保険者番号().getColumnValue());
        }
        if (entity.get宛名() != null && entity.get宛名().getKanjiShimei() != null) {
            returnEntity.set被保険者氏名(RString.EMPTY);
        }
        returnEntity.set住所(住所);
        // 郵便番号的来源不明
        returnEntity.set郵便番号(RString.EMPTY);
        if (null != entity.getサービス提供年月()) {
            returnEntity.set提供年月(entity.getサービス提供年月().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        // 区分支給限度額要介護状態区分はですか
        if (null != entity.get要介護認定状態区分コード() && !entity.get要介護認定状態区分コード().isEmpty()) {
            KubunShikyuGendogakuYokaigoJotaiKubun 要介護度 = KubunShikyuGendogakuYokaigoJotaiKubun.
                    toValue(entity.get要介護認定状態区分コード().getColumnValue());
            returnEntity.set要介護度(要介護度.get名称());
        }

        returnEntity.set認定開始日(formatDate(entity.get認定有効期間開始年月日()));
        returnEntity.set認定終了日(formatDate(entity.get認定有効期間終了年月日()));
        returnEntity.set受付年月日(formatDate(entity.get受付年月日()));
        returnEntity.set決定年月日(formatDate(entity.get決定年月日()));
        returnEntity.set本人支払額(doカンマ編集(entity.get本人支払額()));
        returnEntity.set支給額(doカンマ編集(entity.get支払金額()));
        ShikyuFushikyuKubun 支給不支給区分 = ShikyuFushikyuKubun.toValue(entity.get支給結果());
        returnEntity.set支給_不支給_決定区分(支給不支給区分.get名称());
        returnEntity.set資格喪失日(formatDate(entity.get資格喪失年月日()));
        RString 喪失事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(),
                new Code(entity.get資格喪失事由コード()), FlexibleDate.getNowDate());
        returnEntity.set喪失事由(喪失事由);
        if (entity.is自動償還対象フラグ()) {
            returnEntity.set自動償還(自動償還フラグ_TRUE);
        } else {
            returnEntity.set自動償還(自動償還フラグ_FALSE);
        }
        // ?TODO QA
        returnEntity.set支給総件数(RString.EMPTY);
        return returnEntity;
    }

    private void set出力順と改頁(JigyoKogakuShikyuFushikyuKetteTsuchiEntity returnEntity) {

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
}
