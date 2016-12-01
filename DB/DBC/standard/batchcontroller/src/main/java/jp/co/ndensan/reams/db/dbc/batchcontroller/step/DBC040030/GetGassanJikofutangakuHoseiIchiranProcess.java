/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200031.GassanJikofutangakuHoseiIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200031.GassanJikofutangakuHoseiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200031.GassanJikofutangakuHoseiIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200031.GassanJikofutangakuHoseiOutPutOrder;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040030.KogakugassanJikofutangakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040030.KogakugassanJikofutangakuInfoHoseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.FutangakuTashoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200031.GassanJikofutangakuHoseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200031.GassanJikofutangakuHoseiIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算自己負担額情報補正（一括）のprocessクラスです。
 *
 * @reamsid_L DBC-2320-030 chenyadong
 */
public class GetGassanJikofutangakuHoseiIchiranProcess extends BatchKeyBreakBase<FutangakuTashoshaEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030."
            + "IKogakugassanJikofutangakuInfoHoseiMapper.get負担額補正対象者データ");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private IOutputOrder 並び順;
    private List<RString> 改頁項目リスト;
    private RString 出力順1 = RString.EMPTY;
    private RString 出力順2 = RString.EMPTY;
    private RString 出力順3 = RString.EMPTY;
    private RString 出力順4 = RString.EMPTY;
    private RString 出力順5 = RString.EMPTY;
    private RString 改頁1 = RString.EMPTY;
    private RString 改頁2 = RString.EMPTY;
    private RString 改頁3 = RString.EMPTY;
    private RString 改頁4 = RString.EMPTY;
    private RString 改頁5 = RString.EMPTY;
    private static final ReportId 出力順帳票分類ID = new ReportId("DBC200031_GassanJikofutangakuHoseiIchiran");
    private KogakugassanJikofutangakuInfoHoseiProcessParameter processParameter;
    private static final RString ORDER_BY = new RString("order by");
    private RString 市町村コード;
    private RString 市町村名称;

    private BatchReportWriter<GassanJikofutangakuHoseiIchiranSource> batchReportWriter;
    private ReportSourceWriter<GassanJikofutangakuHoseiIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        市町村コード = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        市町村名称 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        改頁項目リスト = new ArrayList<>();
        並び順 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBC介護給付, 出力順帳票分類ID, Long.parseLong(processParameter.get改頁出力順ID().toString()));
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目ID());
                }
            }
        }
        set出力順();
    }

    @Override
    protected IBatchReader createReader() {
        KogakugassanJikofutangakuMybatisParameter parameter = new KogakugassanJikofutangakuMybatisParameter();
        if (並び順 != null) {
            parameter.set改頁出力順(MyBatisOrderByClauseCreator.create(
                    GassanJikofutangakuHoseiOutPutOrder.class, 並び順).replace(ORDER_BY, RString.EMPTY));
        } else {
            parameter.set改頁出力順(null);
        }
        return new BatchDbReader(READ_DATA_ID, parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<GassanJikofutangakuHoseiIchiranSource> breaker = new GassanJikofutangakuHoseiIchiranPageBreak(改頁項目リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200031.getReportId().value()).
                addBreak(breaker).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(FutangakuTashoshaEntity entity) {
    }

    @Override
    protected void usualProcess(FutangakuTashoshaEntity entity) {
        if (isSameAsBefore(entity)) {
            return;
        }
        GassanJikofutangakuHoseiIchiranParameter param = new GassanJikofutangakuHoseiIchiranParameter();
        param.set作成日時(processParameter.getHandleTimestamp());
        param.set出力順1(出力順1);
        param.set出力順2(出力順2);
        param.set出力順3(出力順3);
        param.set出力順4(出力順4);
        param.set出力順5(出力順5);
        param.set改頁1(改頁1);
        param.set改頁2(改頁2);
        param.set改頁3(改頁3);
        param.set改頁4(改頁4);
        param.set改頁5(改頁5);
        param.set市町村コード(市町村コード);
        param.set市町村名称(市町村名称);
        GassanJikofutangakuHoseiIchiranEntity tmpEntity = new GassanJikofutangakuHoseiIchiranEntity();
        tmpEntity.set被保険者番号(entity.getHihokenshaNo());
        tmpEntity.set被保険者氏名(entity.getHihokenshaShimei().value());
        tmpEntity.set生年月日(entity.getUmareYMD());
        tmpEntity.set性別(entity.getSeibetsuCode().getColumnValue());
        tmpEntity.set申請書整理番号(entity.getShikyuShinseishoSeiriNo());
        tmpEntity.set申請対象年度(entity.getTaishoNendo());
        tmpEntity.set介護加入期間開始(entity.getHihokenshaKaishiYMD());
        tmpEntity.set介護加入期間終了(entity.getHihokenshaShuryoYMD());
        tmpEntity.set補正前_自己負担額(entity.getGokei_JikoFutanGaku());
        tmpEntity.set補正前_70_74自己負担額(entity.getGokei_70_74JikoFutanGaku());
        tmpEntity.set補正前_高額支給額(entity.getGokei_Under70KogakuShikyuGaku());
        tmpEntity.set補正後_自己負担額(entity.getSumi_Gokei_JikoFutanGaku());
        tmpEntity.set補正後_70_74自己負担額(entity.getSumi_Gokei_70_74JikoFutanGaku());
        tmpEntity.set補正後_高額支給額(entity.getSumi_Gokei_Under70KogakuShikyuGaku());
        tmpEntity.set負担額補正有無(entity.getJikoFutanGakuHoseiJissi());
        tmpEntity.set支給額補正有無(entity.getKogakuShikyuGakuGakuHoseiJissi());
        tmpEntity.set警告(entity.getIchiranKakuninKubun());
        tmpEntity.set警告2(entity.getIchiranKakuninKubun2());
        tmpEntity.set宛名ﾃﾞｰﾀ種別(entity.getJuminShubetsuCode());
        tmpEntity.set市町村コード(entity.getShichosonCode());
        tmpEntity.set氏名５０音カナ(entity.getHihokenshaShimeiKana());
        tmpEntity.set申請年月日(entity.getShinseiYMD());
        tmpEntity.set町域コード(entity.getChoikiCode());
        tmpEntity.set行政区コード(entity.getGyoseikuCode());
        tmpEntity.set証記載保険者番号(entity.getHokenshaNo());
        tmpEntity.set郵便番号(entity.getYubinNo());
        param.set高額合算自己負担額補正一覧表(tmpEntity);
        GassanJikofutangakuHoseiIchiranReport report = new GassanJikofutangakuHoseiIchiranReport(param);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        batchReportWriter.close();
        eucFileOutputJohoFactory();
    }

    private void set出力順() {
        if (並び順 != null) {
            int i = INT_0;
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (i == INT_0) {
                    出力順1 = item.get項目名();
                } else if (i == INT_1) {
                    出力順2 = item.get項目名();
                } else if (i == INT_2) {
                    出力順3 = item.get項目名();
                } else if (i == INT_3) {
                    出力順4 = item.get項目名();
                } else if (i == INT_4) {
                    出力順5 = item.get項目名();
                }
                i = i + 1;
            }
            int j = INT_0;
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (j == INT_0 && item.is改頁項目()) {
                    改頁1 = item.get項目名();
                    j = j + 1;
                } else if (j == INT_1 && item.is改頁項目()) {
                    改頁2 = item.get項目名();
                    j = j + 1;
                } else if (j == INT_2 && item.is改頁項目()) {
                    改頁3 = item.get項目名();
                    j = j + 1;
                } else if (j == INT_3 && item.is改頁項目()) {
                    改頁4 = item.get項目名();
                    j = j + 1;
                } else if (j == INT_4 && item.is改頁項目()) {
                    改頁5 = item.get項目名();
                }

            }
        }
    }

    private boolean isSameAsBefore(FutangakuTashoshaEntity current) {
        FutangakuTashoshaEntity before = getBefore();
        return before != null && before.getHihokenshaNo().equals(current.getHihokenshaNo())
                && before.getTaishoNendo().equals(current.getTaishoNendo())
                && before.getHokenshaNo().equals(current.getHokenshaNo())
                && before.getShikyuShinseishoSeiriNo().equals(current.getShikyuShinseishoSeiriNo())
                && before.getRirekiNo2() == current.getRirekiNo2();
    }

    private void eucFileOutputJohoFactory() {
        List<RString> 出力条件 = new ArrayList<>();
        if (processParameter.getKakunin_UketoriYM() != null && !processParameter.getKakunin_UketoriYM().isEmpty()) {
            出力条件.add(new RString("抽出条件")
                    .concat(RString.FULL_SPACE)
                    .concat(processParameter.getKakunin_UketoriYM().wareki()
                            .eraType(EraType.KANJI_RYAKU)
                            .firstYear(FirstYear.ICHI_NEN)
                            .separator(Separator.PERIOD)
                            .fillType(FillType.BLANK).toDateString()));
        }
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBC.DBC200031.getReportId().getColumnValue(),
                市町村コード,
                市町村名称,
                new RString(JobContextHolder.getJobId()),
                ReportIdDBC.DBC200031.getReportName(),
                new RString(reportSourceWriter.pageCount().value()),
                new RString("なし"),
                RString.EMPTY,
                出力条件);
        OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem).print();
    }
}
