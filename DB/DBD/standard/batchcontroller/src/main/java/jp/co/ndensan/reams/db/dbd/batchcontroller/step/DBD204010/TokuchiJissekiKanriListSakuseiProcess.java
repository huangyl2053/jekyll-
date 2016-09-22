/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD204010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200012.TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200012.TokuchiJissekiKanriListSakuseiOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd204010.TokuchiJissekiKanriListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri.TokubetsuChiikiKasanKeigenJissekiKanri;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200012.TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票出力情報の取得
 *
 * @reamsid_L DBD-3880-030 jinge
 */
public class TokuchiJissekiKanriListSakuseiProcess extends BatchProcessBase<TokubetsuChiikiKasanKeigenJissekiKanri> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.tokubetsuchiikikasankeigenlist."
            + "ITokubetsuChiikiKasanKeigenListMapper.select特別地域加算軽減実績管理情報");

    TokuchiJissekiKanriListSakuseiProcessParameter parameter;
    private Association 地方公共団体;
    private static final ReportIdDBD 帳票 = ReportIdDBD.DBD200012;
    private static final RString なし = new RString("なし");
    private static final ReportId ID = new ReportId("DBD200012_TokubetsuChiikiKasanKeigenJissekiKanriIchiran");
    private static final RString 対象年月 = new RString("【対象年月】 ");
    private static final RString 年月範囲 = new RString("【年月範囲】 ");
    private static final RString カラ = new RString("～");
    private static final RString 事業者番号 = new RString("【事業者番号】 ");
    private static final RString 地区種類 = new RString("【地区種類】 ");
    private static final RString 地区範囲 = new RString("【地区範囲】 ");
    private static final RString 市町村コード = new RString("【市町村コード】 ");
    private static final RString 出力 = new RString("【出力順】 ");
    private static IOutputOrder outputOrder;
    private static final RString より = new RString("＞");
    private RString 出力順;

    @Override
    protected void initialize() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        出力順 = RString.EMPTY;
    }

    @BatchWriter
    private BatchReportWriter<TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.set基準日(RDate.getNowDate().toFlexibleDate());
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        RString reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給,
                parameter.get帳票ID(), reamsLoginID, parameter.get改頁出力順ID());
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(TokuchiJissekiKanriListSakuseiOrderKey.class, outputOrder);
        }
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toTokuchiJissekiKanriListSakuseiMybatisParameter(psmShikibetsuTaisho, 出力順));
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(TokubetsuChiikiKasanKeigenJissekiKanri t) {
        if (outputOrder != null) {
            TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport finder
                    = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport(t, 地方公共団体, outputOrder);
            finder.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RString 帳票ID = new RString("DBD200012_TokubetsuChiikiKasanKeigenJissekiKanriIchiran");
        RString 導入団体コード = 地方公共団体.getLasdecCode_().getColumnValue();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 帳票名 = 帳票.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(batchReportWrite.getPageCount()));
        RString csv出力有無 = なし;
        RString csvファイル名 = なし;
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(対象年月);
        if (parameter.get対象年月() != null) {
            builder.append(parameter.get対象年月());
        }

        出力条件.add(builder.toRString());
        builder.append(年月範囲);
        builder.append(new RString(parameter.get年月範囲の開始().toString()));
        builder.append(カラ);
        builder.append(new RString(parameter.get年月範囲の終了().toString()));
        出力条件.add(builder.toRString());

        if (parameter.get事業者番号() != null && !parameter.get事業者番号().isEmpty()) {
            builder.append(事業者番号);
            builder.append(new RString(parameter.get事業者番号().toString()));
        }

        出力条件.add(builder.toRString());
        if (parameter.get市町村コード() == null || parameter.get市町村コード().isEmpty()) {
            builder.append(地区種類);
            builder.append(parameter.get地区コード種類());
            出力条件.add(builder.toRString());
            builder.append(地区範囲);
            if (parameter.get開始地区コード() != null && !parameter.get開始地区コード().isEmpty()) {
                builder.append(parameter.get開始地区コード());
            }
            builder.append(カラ);
            if (parameter.get終了地区コード() != null && !parameter.get終了地区コード().isEmpty()) {
                builder.append(parameter.get終了地区コード());
            }
            出力条件.add(builder.toRString());
        } else if (parameter.get市町村コード() != null && !parameter.get市町村コード().isEmpty()) {
            builder.append(市町村コード);
            builder.append(new RString(parameter.get市町村コード().toString()));
            出力条件.add(builder.toRString());
        }
        builder.append(出力);
        if (outputOrder != null) {
            for (ISetSortItem item : outputOrder.get設定項目リスト()) {
                builder.append(より).append(item.get項目名());
            }
        }
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID,
                導入団体コード,
                市町村名,
                ジョブ番号,
                帳票名,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
