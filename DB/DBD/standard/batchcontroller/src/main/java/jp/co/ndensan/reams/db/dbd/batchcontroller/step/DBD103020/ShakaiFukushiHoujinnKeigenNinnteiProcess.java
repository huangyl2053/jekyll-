/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD103020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoOrderKey;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100019.ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902.ShakaiFukushiHoujinnKeigenNinnteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.ShakaiFukushiHoujinnKeigenNinnteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.temptable.ShafukuKeigenKetteiTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100019.ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.hakkorireki.GyomuKoyuJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 社会福祉法人等軽減の認定証発行_process処理クラスです.
 *
 * @reamsid_L DBD-3981-050 x_xuliang
 */
public class ShakaiFukushiHoujinnKeigenNinnteiProcess extends BatchProcessBase<ShakaiFukushiHoujinnKeigenNinnteiEntity> {

    private static final ReportIdDBD 帳票ID = ReportIdDBD.DBD100018;
    private RString reamsLoginID;
    private boolean isInsert = false;
    private IOutputOrder outputOrder;
    private ShakaiFukushiHoujinnKeigenNinnteiProcessParameter processParamter;
    private RString 出力順;
    private Association 地方公共団体;
    private final RString 単票発行区分 = new RString("【単票発行区分】");
    private final RString 年度 = new RString("【年度】");
    private final RString 決定日期間 = new RString("【決定日期間】");
    private final RString カラ = new RString("～");
    private final RString より大きい = new RString("＞");
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
    private List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用;
    @BatchWriter
    private BatchReportWriter<ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource> batchReportWrite;
    private ReportSourceWriter<ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource> reportSourceWriter;
    private NinshoshaSource ninshoshaSource;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei."
                    + "IShakaiFukushiHoujinnKeigenNinnteiMapper.get社会福祉法人等軽減の認定証発行情報");

    @Override
    protected void beforeExecute() {
        reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給, 帳票ID.getReportId(), reamsLoginID,
                processParamter.get改頁出力順ID());
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(ShakfukusRiysFutKeigTaisKakuninshoOrderKey.class, outputOrder);
        } else {
            出力順 = RString.EMPTY;
        }
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        帳票制御共通 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御共通(帳票ID.getReportId());
        帳票制御汎用 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御汎用(帳票ID.getReportId());
        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100018.getReportId(),
                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter);
    }

    @Override
    protected IBatchReader createReader() {

        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShakaiFukushiHoujinnKeigenNinnteiMybatisParameter(出力順,
                帳票ID.getReportId(), GyomuKoyuJoho.被保番号.getコード(), GyomuKoyuJoho.減免適用開始日.getコード()));
    }
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempWriter;

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(帳票ID.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
        tempWriter = new BatchEntityCreatedTempTableWriter(ShafukuKeigenKetteiTempTableEntity.TABLE_NAME,
                ShafukuKeigenKetteiTempTableEntity.class);
    }

    @Override
    protected void process(ShakaiFukushiHoujinnKeigenNinnteiEntity entity) {
        isInsert = true;
        IKojin iKojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
        RDate 認定証の交付日 = null;
        if (null != processParamter.get認定証の交付日()) {
            認定証の交付日 = new RDate(processParamter.get認定証の交付日().getYearValue(),
                    processParamter.get認定証の交付日().getMonthValue(),
                    processParamter.get認定証の交付日().getDayValue());
        }
        ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減 = new ShakaifukuRiyoshaFutanKeigen(entity.get社会福祉法人等利用者負担軽減());
        ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport report = ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport.createReport(社会福祉法人等利用者負担軽減, iKojin,
                new ChohyoSeigyoKyotsu(帳票制御共通), 帳票制御汎用, 地方公共団体, 認定証の交付日, ninshoshaSource);
        report.writeBy(reportSourceWriter);
        tempWriter.insert(getTempEntity(entity));
    }

    @Override
    protected void afterExecute() {
        if (isInsert) {
            バッチ出力条件リストの出力();
        }
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
        if (processParamter.get年度開始日() != null && processParamter.get年度終了日() != null) {
            出力条件.add(年度.concat(processParamter.get年度開始日().toString())
                    .concat(カラ)
                    .concat(processParamter.get年度終了日().toString()));
        }
        if (processParamter.get決定日FROM() != null && processParamter.get決定日TO() != null) {
            出力条件.add(決定日期間.concat(processParamter.get決定日FROM().toString())
                    .concat(カラ)
                    .concat(processParamter.get決定日TO().toString()));
        }

        RString 設定項目 = RString.EMPTY;
        if (outputOrder != null) {
            for (ISetSortItem item : outputOrder.get設定項目リスト()) {
                設定項目.concat(より大きい).concat(item.get項目名());
            }
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

    private ShafukuKeigenKetteiTempTableEntity getTempEntity(ShakaiFukushiHoujinnKeigenNinnteiEntity entity) {
        ShafukuKeigenKetteiTempTableEntity tempEntity = new ShafukuKeigenKetteiTempTableEntity();
        tempEntity.setHihokenshaNo(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getHihokenshaNo());
        tempEntity.setKeigenritsu_Bumbo(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKeigenritsu_Bumbo());
        tempEntity.setKeigenritsu_Bunshi(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKeigenritsu_Bunshi());
        tempEntity.setKetteiKubun(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKetteiKubun());
        tempEntity.setKetteiYMD(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKetteiYMD());
        tempEntity.setKyojuhiShokuhiNomi(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKyojuhiShokuhiNomi());
        tempEntity.setKeigenritsu(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getGemmenKubun());
        tempEntity.setKyotakuServiceGentei(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKyotakuServiceGentei());
        tempEntity.setShikibetsuCode(entity.getPsmEntity().getShikibetsuCode());
        tempEntity.setShinseiYMD(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getShinseiYMD());
        tempEntity.setTekiyoYMD(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getTekiyoKaishiYMD());
        tempEntity.setTsuchiHakkoZumi(false);
        tempEntity.setNinteishoHakkoZumi(true);
        tempEntity.setYukoKigenYMD(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getTekiyoShuryoYMD());
        tempEntity.setKyusochishaUnitTypeKoshitsuNomi(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().
                getKyusochishaUnitTypeKoshitsuNomi());
        tempEntity.setKakuninNo(entity.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKakuninNo());
        return tempEntity;
    }
}
