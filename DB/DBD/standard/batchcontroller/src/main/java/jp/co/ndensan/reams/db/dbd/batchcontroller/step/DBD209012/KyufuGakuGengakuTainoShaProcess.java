/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200008.KyufuGengakuHaakuIchiranReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbdbt32004.KyufuGakuGengakuTainoShaProcessProperty;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.shiharaihohohenko.kyufugengakukanrilist.TaishoKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32004.KyufuGakuGengakuTainoShaProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.KyufuGengakuHaakuIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.KyufuGengakuHaakuListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200008.KyufuGengakuHaakuIchiranReportSource;
import jp.co.ndensan.reams.db.dbd.service.core.dbd209011.KyufuGengakuHaakuListSakuseiService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 給付額減額滞納者把握情報取得_process処理クラスです。
 *
 * @reamsid_L DBD-3800-050 x_xuliang
 */
public class KyufuGakuGengakuTainoShaProcess extends BatchProcessBase<KyufuGengakuHaakuListSakuseiEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugengakulist."
            + "IKyufuGengakuHaakuListSakuseiMapper.get給付額減額滞納者把握情報");
    private KyufuGakuGengakuTainoShaProcessParameter processParameter;
    private IOutputOrder outputOrder;
    private Association association;
    private RString 出力順;
    HokenshaNo 保険者番号;
    RString 保険者名称;

    @BatchWriter
    private BatchReportWriter<KyufuGengakuHaakuIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<KyufuGengakuHaakuIchiranReportSource> reportSourceWriter;

    private static final RString 基準日 = new RString("【基準日】");
    private static final RString 対象区分 = new RString("【対象】");
    private static final RString 通知書未発行者 = new RString("　　　　 ・通知書未発行者");
    private static final RString 減額適用中者 = new RString("　　　　 ・減額適用中者（");
    private static final RString 時点で減額適用中の被保険者 = new RString("時点で減額適用中の被保険者）");
    private static final RString 減額終了日抽出 = new RString("　　　　 ・減額終了日抽出　開始：");
    private static final RString 終了 = new RString("　～　終了：");
    private static final RString 保険料完納者出力 = new RString("【保険料完納者も出力】  ");
    private static final RString 帳票作成日時 = new RString("【作成日時】 ");
    private static final RString TRUE = new RString("true");
    private static final RString FALSE = new RString("false");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString 秒 = new RString("秒");
    private HihokenshaNo 当該被保険者番号;
    private KyufuGengakuHaakuListSakuseiService service;
    private Map<FlexibleYear, Decimal> 調定額Map;
    private Map<FlexibleYear, Decimal> 収入額Map;
    private Map<FlexibleYear, Decimal> 未納額Map;
    private Map<FlexibleYear, Decimal> 徴収権消滅期間Map;
    private Map<FlexibleYear, Decimal> 納付済み期間Map;
    private List<DbT4025ShiharaiHohoHenkoGengakuEntity> 支払方法変更減額List;
    private List<KyufuGengakuHaakuListSakuseiEntity> 把握情報List;
    private Map<FlexibleYear, List<KyufuGengakuHaakuListSakuseiEntity>> 把握情報Map;

    @Override
    protected void initialize() {

        association = AssociationFinderFactory.createInstance().getAssociation();
        if (association != null) {
            if (association.get地方公共団体コード() != null) {
                保険者番号 = new HokenshaNo(association.get地方公共団体コード().getColumnValue());
            }
            保険者名称 = association.get市町村名();
        }
        service = KyufuGengakuHaakuListSakuseiService.createInstance();
        調定額Map = new HashMap<>();
        収入額Map = new HashMap<>();
        未納額Map = new HashMap<>();
        徴収権消滅期間Map = new HashMap<>();
        納付済み期間Map = new HashMap<>();

        支払方法変更減額List = new ArrayList<>();
        把握情報List = new ArrayList<>();
        把握情報Map = new HashMap<>();

    }

    @Override
    protected void createWriter() {
        List pageBreakKeys = new ArrayList<>();
        service.set改頁Key(outputOrder, pageBreakKeys);
        if (!pageBreakKeys.isEmpty()) {
            batchReportWrite = BatchReportFactory.
                    createBatchReportWriter(processParameter.get帳票ID().value(), SubGyomuCode.DBD介護受給)
                    .addBreak(new BreakerCatalog<KyufuGengakuHaakuIchiranReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWrite = BatchReportFactory.
                    createBatchReportWriter(processParameter.get帳票ID().value(), SubGyomuCode.DBD介護受給).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    private RString get出力順() {
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBD介護受給, processParameter.get帳票ID(), processParameter.get改頁出力順ID());
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator
                    .create(KyufuGakuGengakuTainoShaProcessProperty.DBD200009_KyufuGengakuKanriIchiran.class, outputOrder);
        }
        if (出力順 != null && !出力順.isEmpty()) {
            出力順 = (new RString("order by \"tmp_hihokenshaNo\",")).concat(出力順.replace("order by", ""));
        } else {
            出力順 = new RString("order by \"tmp_hihokenshaNo\"");
        }
        return 出力順;
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        key.set基準日(processParameter.get基準日());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return new BatchDbReader(MAPPERPATH, processParameter.toTaishoShaKanriJohoMybatisParameter(get出力順(), uaFt200Psm));
    }

    @Override
    protected void process(KyufuGengakuHaakuListSakuseiEntity haakuEntity) {
        edit給付額減額滞納者把握情報(haakuEntity);
    }

    private void edit給付額減額滞納者把握情報(KyufuGengakuHaakuListSakuseiEntity entity) {

        if (!entity.get対象者TmpTblEntity().getHihokenshaNo2().equals(当該被保険者番号)) {

            if (当該被保険者番号 != null) {
                KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity = service.edit給付額減額把握リストEntity(
                        把握情報Map, 調定額Map, 収入額Map, 未納額Map, 徴収権消滅期間Map, 納付済み期間Map, 把握情報List, 支払方法変更減額List);
                KyufuGengakuHaakuIchiranReport report = new KyufuGengakuHaakuIchiranReport(RDateTime.now(),
                        保険者番号, 保険者名称, 給付額減額把握リストEntity, outputOrder);
                report.writeBy(reportSourceWriter);

            }
            当該被保険者番号 = entity.get対象者TmpTblEntity().getHihokenshaNo2();
            支払方法変更減額List = new ArrayList<>();
            把握情報List = new ArrayList<>();
            把握情報Map = new HashMap<>();

            調定額Map = new HashMap<>();
            収入額Map = new HashMap<>();
            未納額Map = new HashMap<>();
            徴収権消滅期間Map = new HashMap<>();
            納付済み期間Map = new HashMap<>();
        }

        if (entity.get支払方法変更減額Entity() != null) {
            支払方法変更減額List.add(entity.get支払方法変更減額Entity());
        }

        service.減額対象最新情報の設定(entity, 調定額Map, 収入額Map, 未納額Map);

        FlexibleYear 賦課年度 = entity.get収納滞納状況TmpTblEntity().getTmp_fukaNendo();
        把握情報List = 把握情報Map.get(賦課年度);
        if (把握情報List == null) {
            把握情報List = new ArrayList<>();
        }
        把握情報List.add(entity);
        把握情報Map.put(賦課年度, 把握情報List);
    }

    @Override
    protected void afterExecute() {
        if (当該被保険者番号 != null) {
            KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity = service.edit給付額減額把握リストEntity(
                    把握情報Map, 調定額Map, 収入額Map, 未納額Map, 徴収権消滅期間Map, 納付済み期間Map, 把握情報List, 支払方法変更減額List);
            KyufuGengakuHaakuIchiranReport report = new KyufuGengakuHaakuIchiranReport(RDateTime.now(),
                    保険者番号, 保険者名称, 給付額減額把握リストEntity, outputOrder);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RString 帳票ID = new RString("DBD200009_KyufuGengakuKanriIchiran");
        RString 導入団体コード = association.getLasdecCode_().getColumnValue();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 帳票名 = ReportIdDBD.DBD200009.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(batchReportWrite.getPageCount()));
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = RString.EMPTY;

        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(基準日.concat(processParameter.get基準日().toString()));
        出力条件.add(対象区分.concat(processParameter.get対象区分().get名称()));
        if (TaishoKubun.全登録者以外.getコード().equals(processParameter.get対象区分().getコード())) {
            if (processParameter.is通知書未発行者抽出()) {
                出力条件.add(通知書未発行者);
            }
            if (processParameter.is減額適用中者抽出()) {
                出力条件.add(減額適用中者.concat(processParameter.get減額適用中者抽出基準日().toString())
                        .concat(時点で減額適用中の被保険者));
            }
            if (processParameter.is減額終了日抽出()) {
                出力条件.add(減額終了日抽出.concat(processParameter.get減額終了日範囲From().toString())
                        .concat(終了)
                        .concat(processParameter.get減額終了日範囲To().toString()));
            }
        }
        if (processParameter.is保険料完納者出力()) {
            出力条件.add(保険料完納者出力.concat(TRUE));
        } else {
            出力条件.add(保険料完納者出力.concat(FALSE));
        }
        出力条件.add(帳票作成日時.concat(processParameter.get帳票作成日時().getDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString())
                .concat(RString.HALF_SPACE).concat(new RString(processParameter.get帳票作成日時().getHour())).concat(時)
                .concat(new RString(processParameter.get帳票作成日時().getMinute())).concat(分)
                .concat(new RString(processParameter.get帳票作成日時().getSecond())).concat(秒));
        出力条件.add(出力順);

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
