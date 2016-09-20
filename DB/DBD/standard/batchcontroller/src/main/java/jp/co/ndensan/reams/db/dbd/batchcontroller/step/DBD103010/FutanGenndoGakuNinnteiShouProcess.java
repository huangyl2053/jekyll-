/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD103010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100020.FutanGendogakuNinteishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200019.FutangakuNinteiHakkoIchiranOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902.FutanGenndoGakuNinnteiShouProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.FutanGenndoGakuNinnteiShouEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.temptable.FutanGenndoGakuNinnteiTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100020.FutanGendogakuNinteishoReportSource;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.hakkorireki.GyomuKoyuJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
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
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 負担限度額認定の認定証発行_process処理クラスです.
 *
 * @reamsid_L DBD-3981-050 x_xuliang
 */
public class FutanGenndoGakuNinnteiShouProcess extends BatchProcessBase<FutanGenndoGakuNinnteiShouEntity> {

    private static final ReportIdDBD 帳票ID = ReportIdDBD.DBD100020;
    private static final ReportIdDBD 帳票分類ID = ReportIdDBD.DBD100020;
    private static DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
    private static List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用;
    private RString 出力順;
    private Association 地方公共団体;
    private final RString 単票発行区分 = new RString("【単票発行区分】");
    private final RString 旧措置者区分 = new RString("【旧措置者区分】");
    private final RString 年度 = new RString("【年度】");
    private final RString 抽出期間種類 = new RString("【抽出期間種類】");
    private final RString 対象期間範囲 = new RString("【対象期間範囲】");
    private final RString 交付日 = new RString("【交付日】");
    private final RString カラ = new RString("～");
    private final RString より大きい = new RString("＞");
    private FutanGenndoGakuNinnteiShouProcessParameter processParamter;
    private IOutputOrder outputOrder;
    private FutanGendogakuNintei 負担限度額認定;

    @BatchWriter
    private BatchReportWriter<FutanGendogakuNinteishoReportSource> batchReportWrite;
    private ReportSourceWriter<FutanGendogakuNinteishoReportSource> reportSourceWriter;
    private NinshoshaSource ninshoshaSource;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei."
                    + "IFutanGenndoGakuNinnteiShouMapper.get負担限度額認定の認定証発行情報");

    @Override
    protected void initialize() {
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給, 帳票ID.getReportId(),
                UrControlDataFactory.createInstance().getLoginInfo().getUserId(), processParamter.get改頁出力順ID());
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(FutangakuNinteiHakkoIchiranOrderKey.class, outputOrder);
        } else {
            出力順 = RString.EMPTY;
        }
        帳票制御共通 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御共通(帳票分類ID.getReportId());
        帳票制御汎用 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御汎用(帳票分類ID.getReportId());
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        RString psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toFutanGenndoGakuNinnteiShouMybatisParameter(
                psmShikibetsuTaisho,
                psmAtesaki,
                出力順,
                帳票ID.getReportId().getColumnValue(),
                GyomuKoyuJoho.被保番号.getコード(),
                GyomuKoyuJoho.減免適用開始日.getコード()));
    }
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempWriter;

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(帳票ID.getReportId().value(),
                SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
        tempWriter = new BatchEntityCreatedTempTableWriter(FutanGenndoGakuNinnteiTempTableEntity.TABLE_NAME,
                FutanGenndoGakuNinnteiTempTableEntity.class);
        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100020.getReportId(), FlexibleDate.getNowDate(),
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter);
    }

    @Override
    protected void process(FutanGenndoGakuNinnteiShouEntity entity) {
        IKojin iKojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
        負担限度額認定 = new FutanGendogakuNintei(entity.get介護保険負担限度額認定());
        RDate 認定証の交付日 = null;
        if (processParamter.get認定証の交付日() != null) {
            認定証の交付日 = new RDate(processParamter.get認定証の交付日().getYearValue(),
                    processParamter.get認定証の交付日().getMonthValue(),
                    processParamter.get認定証の交付日().getDayValue());
        }
        FutanGendogakuNinteishoReport report = FutanGendogakuNinteishoReport.createReport(
                負担限度額認定,
                iKojin,
                new ChohyoSeigyoKyotsu(帳票制御共通),
                帳票制御汎用,
                地方公共団体,
                認定証の交付日,
                ninshoshaSource);
        report.writeBy(reportSourceWriter);
        tempWriter.insert(creatTempEntity(entity));
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().getColumnValue();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 出力ページ数 = new RString(String.valueOf(batchReportWrite.getPageCount()));
        RString csv出力有無 = new RString("なし");
        RString csvファイル名 = new RString("なし");

        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(単票発行区分.concat(processParamter.get単票発行区分().get名称()));
        出力条件.add(旧措置者区分.concat(processParamter.get旧措置者区分().get名称()));
        出力条件.add(年度.concat(processParamter.get年度開始日().toString())
                .concat(カラ)
                .concat(processParamter.get年度終了日().toString()));
        出力条件.add(抽出期間種類.concat(processParamter.get対象区分().get名称()));
        出力条件.add(対象期間範囲.concat(processParamter.get対象日FROM().toString())
                .concat(カラ)
                .concat(processParamter.get対象日TO().toString()));
        出力条件.add(交付日.concat(processParamter.get認定証の交付日().toString()));
        RString 設定項目 = RString.EMPTY;
        if (outputOrder != null) {
            for (ISetSortItem item : outputOrder.get設定項目リスト()) {
                設定項目.concat(より大きい).concat(item.get項目名());
            }
        }
        if (!設定項目.isEmpty()) {
            設定項目 = 設定項目.substringEmptyOnError(1, 設定項目.length() - 1);
        }
        出力条件.add(new RString("【出力順】").concat(設定項目));

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.getReportId().value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                帳票ID.getReportName(),
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private FutanGenndoGakuNinnteiTempTableEntity creatTempEntity(FutanGenndoGakuNinnteiShouEntity entity) {
        IKojin iKojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
        FutanGenndoGakuNinnteiTempTableEntity tempEntity = new FutanGenndoGakuNinnteiTempTableEntity();
        tempEntity.setHihokenshaNo(entity.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getHihokenshaNo());
        tempEntity.setKetteiKubun(entity.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getKetteiKubun());
        tempEntity.setKetteiYMD(entity.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getKetteiYMD());
        tempEntity.setNinteishoHakkoZumi(true);
        tempEntity.setRiyoshaFutanDankai(entity.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getRiyoshaFutanDankai());
        tempEntity.setShikibetsuCode(iKojin.get識別コード());
        tempEntity.setShinseiYMD(entity.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getShinseiYMD());
        tempEntity.setTekiyoYMD(entity.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getTekiyoKaishiYMD());
        tempEntity.setTsuchiHakkoZumi(false);
        tempEntity.setYukoKigenYMD(entity.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getTekiyoShuryoYMD());
        return tempEntity;
    }
}
