/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1200902;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd1200902.FutanGenndoGakuNinnteiListProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200018.ShakaiFukushiHojinKeigenHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902.ShakaiFukushiHoujinnKeigenListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.ShakaiFukushiHoujinnKeigenListEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shakaifukushihojinkeigenhakkoichiran.ShakaiFukushiHojinKeigenHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200018.ShakaiFukushiHojinKeigenHakkoIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 社会福祉法人軽減確認証・決定通知書発行一覧表発行_process処理クラスです.
 *
 * @reamsid_L DBD-3981-050 x_lilh
 */
public class ShakaiFukushiHoujinnKeigenListProcess extends BatchProcessBase<ShakaiFukushiHoujinnKeigenListEntity> {

    private static final ReportId REPORT_DBD100020 = ReportIdDBD.DBD100020.getReportId();
    private ShakaiFukushiHoujinnKeigenListProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei."
                    + "IShakaiFukushiHoujinnKeigenListMapper.get社会福祉法人軽減確認証_決定通知書発行一覧表発行情報");
    private List<ShakaiFukushiHojinKeigenHakkoIchiranEntity> shakaiFukushiHoujinnKeigenList;
    private static final ReportId ID = new ReportId("DBD200018_ShakaiFukushiHojinKeigenHakkoIchiran");
    private static final RString なし = new RString("なし");
    private static final RString 単票発行区分 = new RString("【単票発行区分】");
    private static final RString 決定日期間 = new RString("【決定日期間】");
    private static final RString 年度 = new RString("【年度】");
    private static final RString 交付日 = new RString("【交付日】");
    private static final RString 出力順 = new RString("【出力順】");
    private static final RString カラ = new RString("～");
    private static final RString より = new RString("＞");
    private static IOutputOrder order;
    private static IKojin kojin;
    private static Association association;
    private int i = 0;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;
    @BatchWriter
    private BatchReportWriter<ShakaiFukushiHojinKeigenHakkoIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<ShakaiFukushiHojinKeigenHakkoIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());

        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toShakaiFukushiHoujinnKeigenListMybatisParameter(psmShikibetsuTaisho, get出力順()));
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(ShakaiFukushiHoujinnKeigenListEntity t) {
        shakaiFukushiHoujinnKeigenList.add(create(t));
        for (ShakaiFukushiHojinKeigenHakkoIchiranEntity shakai : shakaiFukushiHoujinnKeigenList) {
            ShakaiFukushiHojinKeigenHakkoIchiranReport find = ShakaiFukushiHojinKeigenHakkoIchiranReport.createReport(
                    shakai, association, order, kojin, i++);
            find.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        order = finder.get出力順(SubGyomuCode.DBD介護受給, REPORT_DBD100020, parameter.get改頁出力順ID());

        RString 出力順 = RString.EMPTY;
        if (order != null) {
            出力順 = MyBatisOrderByClauseCreator.create(FutanGenndoGakuNinnteiListProperty.DBD100020_ResultListEnum.class, order);
        }
        return 出力順;
    }

    private ShakaiFukushiHojinKeigenHakkoIchiranEntity create(ShakaiFukushiHoujinnKeigenListEntity shakai) {
        ShakaiFukushiHojinKeigenHakkoIchiranEntity data = new ShakaiFukushiHojinKeigenHakkoIchiranEntity();
        //TODO
        //data.set確認番号();
        data.set被保険者番号(shakai.getHihokenshaNo());
        kojin = ShikibetsuTaishoFactory.createKojin(shakai.getPsmEntity());
        data.set申請日(shakai.getShinseiYMD());
        data.set決定日(shakai.getKetteiYMD());
        data.set適用日(shakai.getTekiyoYMD());
        data.set有効期限(shakai.getYukoKigenYMD());
        data.set決定(shakai.getKetteiKubun());
        data.set軽減(shakai.getKeigenritsu());
        data.set軽減率_分子(shakai.getKeigenritsu_Bunshi());
        data.set軽減率_分母(shakai.getKeigenritsu_Bumbo());
        data.set居宅サービス限定(shakai.isKyotakuServiceGentei());
        data.set居住費食費のみ(shakai.isKyojuhiShokuhiNomi());
        data.set旧措置者ユニット型個室のみ(shakai.isKyusochishaUnitTypeKoshitsuNomi());
        data.set認定証発行済み(shakai.isNinteishoHakkoZumi());
        data.set通知書発行済み(shakai.isTsuchiHakkoZumi());
        data.set認定証発行フラグ(parameter.is認定証発行フラグ());
        data.set通知書発行フラグ(parameter.is通知書発行フラグ());
        data.set喪失年月日(shakai.getShikakuSoshitsuYMD());
        return data;
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = association.getLasdecCode_().getColumnValue();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 帳票名 = ReportIdDBD.DBD200019.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(batchReportWrite.getPageCount()));
        RString csv出力有無 = なし;
        RString csvファイル名 = なし;
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(単票発行区分);
        builder.append(parameter.get単票発行区分());
        出力条件.add(builder.toRString());

        builder.append(年度);
        if (null != parameter.get年度開始日()) {
            builder.append(new RString(parameter.get年度開始日().toString()));
        }
        builder.append(カラ);
        if (null != parameter.get年度終了日()) {
            builder.append(new RString(parameter.get年度終了日().toString()));
        }
        出力条件.add(builder.toRString());

        builder.append(決定日期間);
        if (null != parameter.get決定日FROM()) {
            builder.append(new RString(parameter.get決定日FROM().toString()));
        }
        builder.append(カラ);
        if (null != parameter.get決定日TO()) {
            builder.append(new RString(parameter.get決定日TO().toString()));
        }
        出力条件.add(builder.toRString());

        builder.append(交付日);
        if (parameter.is認定証発行フラグ()) {
            builder.append(new RString(parameter.get認定証の交付日().toString()));
        } else {
            builder.append(new RString(parameter.get通知書の発行日().toString()));
        }
        出力条件.add(builder.toRString());
        builder.append(出力順);
        builder.append(order.get設定項目リスト().get(0).get項目名());
        builder.append(より);
        builder.append(order.get設定項目リスト().get(1).get項目名());
        builder.append(より);
        builder.append(order.get設定項目リスト().get(2).get項目名());
        builder.append(より);
        builder.append(order.get設定項目リスト().get(NO_3).get項目名());
        builder.append(より);
        builder.append(order.get設定項目リスト().get(NO_4).get項目名());
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ID.value(),
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
