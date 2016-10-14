/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD103010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100020.FutanGendogakuNinteishoOrderKey;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200019.FutangakuNinteiHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902.FutanGenndoGakuNinnteiListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.FutanGenndoGakuNinnteiListEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangakuninteihakkoichiran.FutangakuNinteiHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200019.FutangakuNinteiHakkoIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
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
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 負担額認定証・決定通知書発行一覧表発行_process処理クラスです.
 *
 * @reamsid_L DBD-3981-050 x_miaocl
 */
public class FutanGenndoGakuNinnteiListProcess extends BatchProcessBase<FutanGenndoGakuNinnteiListEntity> {

    private FutanGenndoGakuNinnteiListProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei."
                    + "IFutanGenndoGakuNinnteiListMapper.get負担額認定証_決定通知書発行一覧表発行情報");
    private static final ReportId ID = new ReportId("DBD200019_FutangakuNinteiHakkoIchiran");
    private static final RString なし = new RString("なし");
    private static final RString 単票発行区分 = new RString("単票発行区分");
    private static final RString 旧措置者区分 = new RString("旧措置者区分");
    private static final RString 抽出期間種類 = new RString("抽出期間種類】");
    private static final RString 対象期間範囲 = new RString("対象期間範囲");
    private static final RString 年度 = new RString("年度");
    private static final RString 発行日 = new RString("発行日");
    private static final RString SHUTSURYOKUJUN = new RString("出力順");
    private static final RString カラ = new RString("～");
    private static final RString より = new RString("＞");

    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_2 = 2;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;

    private int i = 0;
    private static Association association;
    private static IKojin kojin;
    @BatchWriter
    private BatchReportWriter<FutangakuNinteiHakkoIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<FutangakuNinteiHakkoIchiranReportSource> reportSourceWriter;
    private IOutputOrder order;

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
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toFutanGenndoGakuNinnteiListMybatisParameter(psmShikibetsuTaisho, get出力順()));
    }

    @Override
    protected void createWriter() {
        List<RString> pageBreakKeys = new ArrayList<>();
        set改頁Key(order, pageBreakKeys);
        if (!pageBreakKeys.isEmpty()) {
            batchReportWrite = BatchReportFactory.createBatchReportWriter(ID.value()).addBreak(
                    new BreakerCatalog<FutangakuNinteiHakkoIchiranReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWrite = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        }

        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(FutanGenndoGakuNinnteiListEntity entity) {
        FutangakuNinteiHakkoIchiranReport find = FutangakuNinteiHakkoIchiranReport.createReport(
                create(entity), association, order, kojin, i++);
        find.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        order = finder.get出力順(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100020.getReportId(),
                parameter.get改頁出力順ID());
        RString 出力順 = RString.EMPTY;
        if (order != null) {
            出力順 = MyBatisOrderByClauseCreator.create(FutanGendogakuNinteishoOrderKey.class, order);
        }
        return 出力順;
    }

    private FutangakuNinteiHakkoIchiranEntity create(FutanGenndoGakuNinnteiListEntity futan) {
        FutangakuNinteiHakkoIchiranEntity data = new FutangakuNinteiHakkoIchiranEntity();
        data.set被保険者番号(futan.getHihokenshaNo());
        kojin = ShikibetsuTaishoFactory.createKojin(futan.getPsmEntity());
        data.set申請日(futan.getShinseiYMD());
        data.set決定日(futan.getKetteiYMD());
        data.set適用日(futan.getTekiyoYMD());
        data.set有効期限(futan.getTekiyoYMD());
        if (futan.getKetteiKubun() != null) {
            data.set決定(KetteiKubun.toValue(futan.getKetteiKubun()));
        }
        if (futan.getRiyoshaFutanDankai() != null) {
            data.set負担段階(RiyoshaFutanDankai.toValue(futan.getRiyoshaFutanDankai()).get名称());
        }
        data.set認定証発行フラグ(futan.isNinteishoHakkoZumi());
        data.set通知書発行済み(futan.isTsuchiHakkoZumi());
        data.set認定証発行フラグ(parameter.is認定証発行フラグ());
        data.set通知書発行フラグ(parameter.is通知書発行フラグ());
        data.set入所施設CD(futan.getNyushoShisetsuCode());
        data.set喪失年月日(futan.getShikakuSoshitsuYMD());
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
        builder.append(parameter.get単票発行区分().get名称());
        出力条件.add(builder.toRString());
        builder.append(旧措置者区分);
        builder.append(parameter.get旧措置者区分().get名称());
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

        builder.append(抽出期間種類);
        builder.append(parameter.get対象区分().get名称());
        出力条件.add(builder.toRString());

        builder.append(対象期間範囲);
        if (null != parameter.get対象日FROM()) {
            builder.append(new RString(parameter.get対象日FROM().toString()));
        }
        builder.append(カラ);
        if (null != parameter.get対象日TO()) {
            builder.append(new RString(parameter.get対象日TO().toString()));
        }
        出力条件.add(builder.toRString());

        builder.append(発行日);
        if (parameter.is認定証発行フラグ()) {
            builder.append(new RString(parameter.get認定証の交付日().toString()));
        } else if (!parameter.is認定証発行フラグ() || parameter.is通知書発行フラグ()) {
            builder.append(new RString(parameter.get通知書の交付日().toString()));
        }
        出力条件.add(builder.toRString());

        RString 設定項目 = RString.EMPTY;
        if (order != null) {
            for (ISetSortItem item : order.get設定項目リスト()) {
                設定項目.concat(より).concat(item.get項目名());
            }
        }
        if (!設定項目.isEmpty()) {
            設定項目 = 設定項目.substringEmptyOnError(1, 設定項目.length() - 1);
        }
        出力条件.add(SHUTSURYOKUJUN.concat(設定項目));
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

    private void set改頁Key(IOutputOrder outputOrder, List<RString> pageBreakKeys) {
        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;
        if (outputOrder != null) {
            List<ISetSortItem> list = outputOrder.get設定項目リスト();
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list.size() > NO_0 && list.get(NO_0).is改頁項目()) {
                改頁１ = to帳票物理名(list.get(NO_0).get項目ID());
            }
            if (list.size() > NO_1 && list.get(NO_1).is改頁項目()) {
                改頁２ = to帳票物理名(list.get(NO_1).get項目ID());
            }
            if (list.size() > NO_2 && list.get(NO_2).is改頁項目()) {
                改頁３ = to帳票物理名(list.get(NO_2).get項目ID());
            }
            if (list.size() > NO_3 && list.get(NO_3).is改頁項目()) {
                改頁４ = to帳票物理名(list.get(NO_3).get項目ID());
            }
            if (list.size() > NO_4 && list.get(NO_4).is改頁項目()) {
                改頁５ = to帳票物理名(list.get(NO_4).get項目ID());
            }

            if (!改頁１.isEmpty()) {
                pageBreakKeys.add(改頁１);
            }
            if (!改頁２.isEmpty()) {
                pageBreakKeys.add(改頁２);
            }
            if (!改頁３.isEmpty()) {
                pageBreakKeys.add(改頁３);
            }
            if (!改頁４.isEmpty()) {
                pageBreakKeys.add(改頁４);
            }
            if (!改頁５.isEmpty()) {
                pageBreakKeys.add(改頁５);
            }
        }
    }

    private RString to帳票物理名(RString 項目ID) {
        RString 帳票物理名 = RString.EMPTY;
        if (FutanGendogakuNinteishoOrderKey.郵便番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("yubinNo");
        } else if (FutanGendogakuNinteishoOrderKey.町域コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("choikiCode");
        } else if (FutanGendogakuNinteishoOrderKey.番地コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("banchi");
        } else if (FutanGendogakuNinteishoOrderKey.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("gyoseikuCode");
        } else if (FutanGendogakuNinteishoOrderKey.地区１.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("chikuCode1");
        } else if (FutanGendogakuNinteishoOrderKey.地区２.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("chikuCode2");
        } else if (FutanGendogakuNinteishoOrderKey.世帯コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("setaiCode");
        } else if (FutanGendogakuNinteishoOrderKey.識別コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shikibetsuCode");
        } else if (FutanGendogakuNinteishoOrderKey.氏名５０音カナ.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("kanaShimei");
        } else if (FutanGendogakuNinteishoOrderKey.生年月日.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("seinengappiYMD");
        } else if (FutanGendogakuNinteishoOrderKey.性別.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("seibetsuCode");
        } else if (FutanGendogakuNinteishoOrderKey.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shichosonCode");
        } else if (FutanGendogakuNinteishoOrderKey.証記載保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shoKisaiHokenshaNo");
        } else if (FutanGendogakuNinteishoOrderKey.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("list_3");
        } else if (FutanGendogakuNinteishoOrderKey.入所施設コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("list_13");
        }
        return 帳票物理名;
    }
}
