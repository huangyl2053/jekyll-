/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1200902;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100019.ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd1200902.ShakaiFukushiHoujinnKeigenNinnteiListPropery;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902.ShakaiFukushiHoujinnKeigenNinnteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.ShakaiFukushiHoujinnKeigenNinnteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100019.ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
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
 * 社会福祉法人等軽減の認定証発行_process処理クラスです.
 *
 * @reamsid_L DBD-3981-050 x_xuliang
 */
public class ShakaiFukushiHoujinnKeigenNinnteiProcess extends BatchProcessBase<ShakaiFukushiHoujinnKeigenNinnteiEntity> {

    private static final ReportIdDBD 帳票ID = ReportIdDBD.DBD100018;
    private RString reamsLoginID;
    private IOutputOrder outputOrder;
    private static final int THREE_3 = 3;
    private static final int FOUR_4 = 4;
    private ShakaiFukushiHoujinnKeigenNinnteiProcessParameter processParamter;
    private RString 出力順;
    private Association 地方公共団体;
    private final RString 単票発行区分 = new RString("【単票発行区分】");
    private final RString 年度 = new RString("【年度】");
    private final RString 決定日期間 = new RString("【決定日期間】");
    private final RString カラ = new RString("～");
    private final RString より大きい = new RString("＞");
    private ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport report;
    private ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減;
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
    private List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用;
    @BatchWriter
    private BatchReportWriter<ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource> batchReportWrite;
    private ReportSourceWriter<ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource> reportSourceWriter;
    private NinshoshaSource ninshoshaSource;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei."
                    + "IShakaiFukushiHoujinnKeigenNinnteiMapper.get負担限度額認定の認定証発行情報");

    @Override
    protected void beforeExecute() {
        reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給, 帳票ID.getReportId(), reamsLoginID,
                processParamter.get改頁出力順ID());
        出力順 = MyBatisOrderByClauseCreator.create(ShakaiFukushiHoujinnKeigenNinnteiListPropery.class, outputOrder);
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        帳票制御共通 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御共通(帳票ID.getReportId());
        帳票制御汎用 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御汎用(帳票ID.getReportId());
        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100020.getReportId(),
                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter);
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
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShakaiFukushiHoujinnKeigenNinnteiMybatisParameter(psmShikibetsuTaisho,
                psmAtesaki, 出力順, 帳票ID.getReportId().getColumnValue()));
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(帳票ID.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(ShakaiFukushiHoujinnKeigenNinnteiEntity t) {
        IKojin iKojin = ShikibetsuTaishoFactory.createKojin(t.getPsmEntity());
        RDate 認定証の交付日 = null;
        if (null != processParamter.get認定証の交付日()) {
            認定証の交付日 = new RDate(processParamter.get認定証の交付日().getYearValue(),
                    processParamter.get認定証の交付日().getMonthValue(),
                    processParamter.get認定証の交付日().getDayValue());
        }
        GemmenGengakuShinsei 減免減額申請情報 = new GemmenGengakuShinsei(t.get減免減額申請Entity());
        社会福祉法人等利用者負担軽減.createBuilderForEdit()
                .setGemmenGengakuShinsei(減免減額申請情報)
                .set居住費_食費のみ(t.get社会福祉法人等利用者負担軽減Entity().getKyojuhiShokuhiNomi())
                .set居宅サービス限定(t.get社会福祉法人等利用者負担軽減Entity().getKyotakuServiceGentei())
                .set旧措置者ユニット型個室のみ(t.get社会福祉法人等利用者負担軽減Entity().getKyusochishaUnitTypeKoshitsuNomi())
                .set決定区分(t.get社会福祉法人等利用者負担軽減Entity().getKetteiKubun())
                .set決定年月日(t.get社会福祉法人等利用者負担軽減Entity().getKetteiYMD())
                .set減免区分(t.get社会福祉法人等利用者負担軽減Entity().getGemmenKubun())
                .set生保扶助見直し特例有無(t.get社会福祉法人等利用者負担軽減Entity().getSeihoFujoMinaoshiTokureiUmu())
                .set生活保護受給有無(t.get社会福祉法人等利用者負担軽減Entity().getSeihoJukyuUmu())
                .set申請事由(t.get社会福祉法人等利用者負担軽減Entity().getShinseiJiyu())
                .set申請年月日(t.get社会福祉法人等利用者負担軽減Entity().getShinseiYMD())
                .set確認番号(t.get社会福祉法人等利用者負担軽減Entity().getKakuninNo())
                .set老齢福祉年金受給有無(t.get社会福祉法人等利用者負担軽減Entity().getRoreiFukushiNenkinJukyuUmu())
                .set軽減率_分子(t.get社会福祉法人等利用者負担軽減Entity().getKeigenritsu_Bunshi())
                .set軽減率_分母(t.get社会福祉法人等利用者負担軽減Entity().getKeigenritsu_Bumbo())
                .set適用終了年月日(t.get社会福祉法人等利用者負担軽減Entity().getTekiyoShuryoYMD())
                .set適用開始年月日(t.get社会福祉法人等利用者負担軽減Entity().getTekiyoKaishiYMD())
                .set非承認理由(t.get社会福祉法人等利用者負担軽減Entity().getHiShoninRiyu())
                .build();
        ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport.createReport(社会福祉法人等利用者負担軽減, iKojin,
                new ChohyoSeigyoKyotsu(帳票制御共通), 帳票制御汎用, 地方公共団体, 認定証の交付日, ninshoshaSource);
        report.writeBy(reportSourceWriter);
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
        出力条件.add(年度.concat(processParamter.get年度開始日().toString())
                .concat(カラ)
                .concat(processParamter.get年度終了日().toString()));
        出力条件.add(決定日期間.concat(processParamter.get決定日FROM().toString())
                .concat(カラ)
                .concat(processParamter.get決定日TO().toString()));
        出力条件.add(new RString("【出力順】").concat(outputOrder.get設定項目リスト().get(0).get項目名())
                .concat(より大きい)
                .concat(outputOrder.get設定項目リスト().get(1).get項目名())
                .concat(より大きい)
                .concat(outputOrder.get設定項目リスト().get(2).get項目名())
                .concat(より大きい)
                .concat(outputOrder.get設定項目リスト().get(THREE_3).get項目名())
                .concat(より大きい)
                .concat(outputOrder.get設定項目リスト().get(FOUR_4).get項目名()));
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

}
