/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC010030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.kaigojuryoininkeiyakujigyoshaichirahyo.JuryoIninJigyoshaIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kaigojuryoininkeiyakujigyoshaichirahyo.JuryoIninJigyoshaIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.kaigojuryoininkeiyakujigyoshaichirahyo.KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigojuryoininkeiyaku.KaigoJuryoininKeiyakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.juryoininjigyoshaichiran.JuryoIninJigyoshaIchiranGetIdProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigojuryoininkeiyakujigyoshaichirahyo.KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.juryoininjigyoshaichiran.JuryoIninJigyoshaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 受領委任契約事業者一覧表作成を実行する.
 *
 * @reamsid_L DBC-2110-030 liuxiaoyu
 *
 */
public class JuryoIninJigyoshaIchiranProcess extends BatchKeyBreakBase<KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity> {

    private JuryoIninJigyoshaIchiranGetIdProcessParameter parameter;
    private KaigoJuryoininKeiyakuMybatisParameter 一覧表の取得Parameter;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigojuryoininkeiyaku."
                    + "IKaigoJuryoininKeiyakuMapper.select受領委任契約事業者");
    private static final ReportId 帳票ID = ReportIdDBC.DBC200012.getReportId();
    private static final RString 最小番号 = new RString("0000000000");
    private static final RString 最大番号 = new RString("9999999999");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSVファイル名_なし = new RString("なし");
    private static final AtenaMeisho 事業者名称 = new AtenaMeisho("＊＊　対象データは存在しません　＊＊");
    private static final RString 契約事業者番号 = new RString("【契約事業者番号   】:");
    private static final RString 契約開始日 = new RString("【契約開始日     】：");
    private static final RString 契約種別 = new RString("【契約種別      】:");
    private static final RString 契約期間終了事業者 = new RString("【契約期間終了事業者】：");
    private static final RString FUGOU = new RString("～");
    private static final RString 契約_0 = new RString("0");
    private static final RString 契約_1 = new RString("1");
    private static final RString 契約_2 = new RString("2");
    private static final RString 全て = new RString("全て");
    private static final RString 住宅改修 = new RString("住宅改修");
    private static final RString 福祉用具 = new RString("福祉用具");
    private static final RString SONNZAI = new RString("住宅改修/福祉用具");
    private static final RString 事業者を含む = new RString("契約期間終了事業者を含む");
    private static final RString 事業者を含まない = new RString("契約期間終了事業者を含まない");
    private static final RString 事業者のみ = new RString("契約期間終了事業者のみ");
    private static final RString 事業者_0 = new RString("0");
    private static final RString 事業者_1 = new RString("1");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final RString KEY_並び順の1件目 = new RString("KEY_並び順の1件目");
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");

    private RString 並び順;
    private boolean データFlag = false;
    private List<RString> 改頁項目;
    private Association 地方公共団体;
    private List<RString> pageBreakKeys;
    private Map<RString, RString> 出力順Map;
    private IOutputOrder 出力順クラス;

    @BatchWriter
    private BatchReportWriter<JuryoIninJigyoshaIchiranSource> batchReportWriter_一覧表;
    private ReportSourceWriter<JuryoIninJigyoshaIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        pageBreakKeys = new ArrayList<>();
        出力順Map = new HashMap<>();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (parameter.get帳票出力順ID() != null && parameter.get帳票出力順ID() != 0) {
            出力順クラス = finder.get出力順(SubGyomuCode.DBC介護給付, 帳票ID, parameter.get帳票出力順ID());
            並び順 = MyBatisOrderByClauseCreator.create(KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder.class, 出力順クラス);
        }
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        一覧表の取得Parameter = new KaigoJuryoininKeiyakuMybatisParameter();
        if (RString.isNullOrEmpty(parameter.get契約事業者番号FROM())) {
            一覧表の取得Parameter.set契約事業者番号FROM(最小番号);
        } else {
            一覧表の取得Parameter.set契約事業者番号FROM(parameter.get契約事業者番号FROM());
        }
        if (RString.isNullOrEmpty(parameter.get契約事業者番号TO())) {
            一覧表の取得Parameter.set契約事業者番号TO(最大番号);
        } else {
            一覧表の取得Parameter.set契約事業者番号TO(parameter.get契約事業者番号TO());
        }
        if (parameter.get契約日FROM().isEmpty()) {
            一覧表の取得Parameter.set契約日FROM(FlexibleDate.MIN);
        } else {
            一覧表の取得Parameter.set契約日FROM(parameter.get契約日FROM());
        }
        if (parameter.get契約日TO().isEmpty()) {
            一覧表の取得Parameter.set契約日TO(FlexibleDate.MAX);
        } else {
            一覧表の取得Parameter.set契約日TO(parameter.get契約日TO());
        }

        一覧表の取得Parameter.set並び順(並び順);
        一覧表の取得Parameter.set契約種別(parameter.get契約種別());
        一覧表の取得Parameter.set契約期間終了事業者(parameter.get契約期間終了事業者());

        int i = 0;
        改頁項目 = new ArrayList();
        if (出力順クラス != null) {
            for (ISetSortItem item : 出力順クラス.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目.add(item.get項目名());
                    pageBreakKeys.add(item.get項目ID());
                }
                if (i == INDEX_0) {
                    出力順Map.put(KEY_並び順の1件目, item.get項目名());
                } else if (i == INDEX_1) {
                    出力順Map.put(KEY_並び順の２件目, item.get項目名());
                } else if (i == INDEX_2) {
                    出力順Map.put(KEY_並び順の３件目, item.get項目名());
                } else if (i == INDEX_3) {
                    出力順Map.put(KEY_並び順の４件目, item.get項目名());
                } else if (i == INDEX_4) {
                    出力順Map.put(KEY_並び順の５件目, item.get項目名());
                }
                i = i + 1;
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, 一覧表の取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<JuryoIninJigyoshaIchiranSource> breaker
                = new JuryoIninJigyoshaIchiranPageBreak(pageBreakKeys);
        batchReportWriter_一覧表 = BatchReportFactory.createBatchReportWriter(
                帳票ID.value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter_一覧表);
    }

    @Override
    protected void usualProcess(KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity entity) {
        データFlag = true;
        JuryoIninJigyoshaIchiranReport report = new JuryoIninJigyoshaIchiranReport(
                entity,
                parameter.get市町村コード(),
                地方公共団体.get市町村名(),
                parameter.get処理日時(),
                出力順Map,
                改頁項目
        );
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void keyBreakProcess(KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity entity) {
    }

    @Override
    protected void afterExecute() {
        if (!データFlag) {
            KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity entity = new KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity();
            entity.set事業者名称(事業者名称);
            JuryoIninJigyoshaIchiranReport report = new JuryoIninJigyoshaIchiranReport(
                    entity,
                    parameter.get市町村コード(),
                    地方公共団体.get市町村名(),
                    parameter.get処理日時(),
                    出力順Map,
                    改頁項目);
            report.writeBy(reportSourceWriter);
        }
        List<RString> 出力条件 = get出力条件();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                parameter.get市町村コード().value(),
                地方公共団体.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBC.DBC200012.getReportName(),
                new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                CSV出力有無_なし,
                CSVファイル名_なし,
                出力条件);
        OutputJokenhyoFactory.createInstance(item).print();

    }

    private List<RString> get出力条件() {
        List<RString> 出力条件 = new ArrayList();
        RStringBuilder builder = new RStringBuilder();
        builder.append(契約事業者番号.concat(RString.HALF_SPACE)
                .concat(parameter.get契約事業者番号FROM()).concat(FUGOU).concat(parameter.get契約事業者番号TO()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(契約開始日.concat(RString.HALF_SPACE)
                .concat(parameter.get契約日FROM().toString().concat(FUGOU.toString()).concat(parameter.get契約日TO().toString())));
        出力条件.add(builder.toRString());
        builder = get契約種別();
        出力条件.add(builder.toRString());
        builder = get契約期間終了事業者();
        出力条件.add(builder.toRString());
        return 出力条件;
    }

    private RStringBuilder get契約種別() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(契約種別);
        if (parameter.get契約種別() == null || parameter.get契約種別().isEmpty()) {
            return builder;
        }
        if (契約_0.equals(parameter.get契約種別())) {
            builder.append(全て);
            return builder;
        } else if (契約_1.equals(parameter.get契約種別())) {
            builder.append(住宅改修);
            return builder;
        } else if (契約_2.equals(parameter.get契約種別())) {
            builder.append(福祉用具);
            return builder;
        } else {
            builder.append(SONNZAI);
            return builder;
        }
    }

    private RStringBuilder get契約期間終了事業者() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(契約期間終了事業者);
        if (parameter.get契約種別() == null || parameter.get契約種別().isEmpty()) {
            return builder;
        }
        if (事業者_0.equals(parameter.get契約期間終了事業者())) {
            builder.append(事業者を含む);
            return builder;
        } else if (事業者_1.equals(parameter.get契約期間終了事業者())) {
            builder.append(事業者を含まない);
            return builder;
        } else {
            builder.append(事業者のみ);
            return builder;
        }
    }
}
