/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD103020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100012.ShakFuksHjRiysFutKgTsKtTsuchishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.ShakaiFukushiHoujinnKeigenParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902.ShakaiFukushiHoujinnKeigenTsuuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.ShakaiFukushiHoujinnKeigenTsuuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.temptable.ShafukuKeigenKetteiTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100012.ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei.IShakaiFukushiHoujinnKeigenListMapper;
import jp.co.ndensan.reams.db.dbd.service.report.dbd1200902.ShakaiFukushiHoujinnKeigenTsuuchishoService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.hakkorireki.GyomuKoyuJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNoHatsubanHoho;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 社会福祉法人等軽減の通知書発行_process処理クラスです.
 *
 * @reamsid_L DBD-3981-050 x_lilh
 */
public class ShakaiFukushiHoujinnKeigenTsuuchishoProcess extends BatchProcessBase<ShakaiFukushiHoujinnKeigenTsuuchishoEntity> {

    private static final ReportId 帳票ID = new ReportId("DBD100012_ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchisho");
    private static final ReportId 帳票分類ID = new ReportId("DBD100012_ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchisho");
    private static final RString なし = new RString("なし");
    private static final RString 単票発行区分 = new RString("【単票発行区分】");
    private static final RString 決定日期間 = new RString("【決定日期間】");
    private static final RString 年度 = new RString("【年度】");
    private static final RString 交付日 = new RString("【発行日】");
    private static final RString 出力順 = new RString("【出力順】");
    private static final RString カラ = new RString("～");
    private static final RString より = new RString("＞");
    private static ShakaiFukushiHoujinnKeigenTsuuchishoProcessParameter processParamter;
    private static Association association;
    private static CountedItem countedItem;
    private static RString reamsLoginID;
    private static IOutputOrder order;
    private static List<RString> 通知書定型文;
    private static int count;
    private static final int ONE_1 = 1;
    private static final int TWO_2 = 2;
    private static final int THREE_3 = 3;
    private static final int FOUR_4 = 4;
    private static DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
    private IShakaiFukushiHoujinnKeigenListMapper mapper;
    private static final RString GENERICKEY = new RString("社会福祉法人等利用者負担軽減決定通知書");
    @BatchWriter
    private BatchReportWriter<ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource> batchReportWrite;
    private ReportSourceWriter<ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource> reportSourceWriter;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei."
                    + "IShakaiFukushiHoujinnKeigenTsuuchishoMapper.get社会福祉法人等軽減の通知書発行情報");

    @Override
    protected void initialize() {
        mapper = getMapper(IShakaiFukushiHoujinnKeigenListMapper.class);
        reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        association = AssociationFinderFactory.createInstance().getAssociation();
        帳票制御共通 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御共通(帳票分類ID);
        int パターン番号 = 0;
        if (TeikeibunMojiSize.フォント小.getコード().equals(帳票制御共通.getTeikeibunMojiSize())) {
            パターン番号 = ONE_1;
        } else if (TeikeibunMojiSize.フォント大.getコード().equals(帳票制御共通.getTeikeibunMojiSize())) {
            パターン番号 = TWO_2;
        } else if (TeikeibunMojiSize.フォント上小下大.getコード().equals(帳票制御共通.getTeikeibunMojiSize())) {
            パターン番号 = THREE_3;
        } else if (TeikeibunMojiSize.フォント上大下小.getコード().equals(帳票制御共通.getTeikeibunMojiSize())) {
            パターン番号 = FOUR_4;
        }
        通知書定型文 = new ArrayList();
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = manager.get通知書定型文項目(SubGyomuCode.DBD介護受給, 帳票ID, KamokuCode.EMPTY, パターン番号);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBD介護受給, 帳票ID);
        List<TsuchishoTeikeibunEntity> 通知書定型文List = tsuchishoTeikeibunInfo.get通知書定型文List();
        for (TsuchishoTeikeibunEntity entity : 通知書定型文List) {
            int 項目番号 = entity.getTsuchishoTeikeibunEntity().getSentenceNo();
            RString 文章 = textHenkanRule.editText(entity.getTsuchishoTeikeibunEntity().getSentence());
            通知書定型文.add(項目番号, textHenkanRule.editText(文章));
        }
        ShakaiFukushiHoujinnKeigenTsuuchishoService shakai = new ShakaiFukushiHoujinnKeigenTsuuchishoService();
        count = shakai.get利用者負担割合(processParamter.toShakaiFukushiHoujinnKeigenTsuuchishoMybatisParameter(RString.EMPTY,
                RString.EMPTY, GyomuKoyuJoho.被保番号.getコード(), GyomuKoyuJoho.減免適用開始日.getコード(),
                帳票ID, get出力順()));
    }

    @Override
    protected IBatchReader createReader() {

        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShakaiFukushiHoujinnKeigenTsuuchishoMybatisParameter(RString.EMPTY,
                RString.EMPTY, GyomuKoyuJoho.被保番号.getコード(), GyomuKoyuJoho.減免適用開始日.getコード(), 帳票ID, get出力順()));
    }
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShafukuKeigenKetteiTempTableEntity.class)
                .tempTableName(ShafukuKeigenKetteiTempTableEntity.TABLE_NAME).build();

    }

    @Override
    protected void process(ShakaiFukushiHoujinnKeigenTsuuchishoEntity shaka) {
        ShakaiFukushiHoujinnKeigenParameter parameter = new ShakaiFukushiHoujinnKeigenParameter(shaka.get社会福祉法人等利用者負担軽減().
                get社会福祉法人等利用者負担軽減Entity().getHihokenshaNo(), shaka.getPsmEntity().getShikibetsuCode());
        ShafukuKeigenKetteiTempTableEntity shafukuEntity = mapper.get社会福祉法人等軽減の通知書発行の一時テーブルEntity(parameter);
        if (shafukuEntity == null) {
            tmpTableWriter.insert(create処理(shaka));
        } else {
            tmpTableWriter.update(insert(shafukuEntity, shaka));
        }
        UaFt250FindAtesakiEntity uaFt250Entity = shaka.getAtesakiEntity();
        UaFt200FindShikibetsuTaishoEntity uaFt200Entity = shaka.getPsmEntity();
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票分類ID,
                processParamter.get通知書の発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        ShafukuRiyoshaFutanKeigenEntity 社会福祉法人等利用者負担軽減 = shaka.get社会福祉法人等利用者負担軽減();
        ShakFuksHjRiysFutKgTsKtTsuchishoReport find = ShakFuksHjRiysFutKgTsKtTsuchishoReport.createReport(
                new ShakaifukuRiyoshaFutanKeigen(社会福祉法人等利用者負担軽減), ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                AtesakiFactory.createInstance(uaFt250Entity), new ChohyoSeigyoKyotsu(帳票制御共通),
                association, set文書番号(), 通知書定型文, ninshoshaSource);
        find.writeBy(reportSourceWriter);

    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();

    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        order = finder.get出力順(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100018.getReportId(), reamsLoginID, processParamter.get改頁出力順ID());
        RString 出力順 = RString.EMPTY;
        if (order != null) {
            出力順 = MyBatisOrderByClauseCreator.create(ShakfukusRiysFutKeigTaisKakuninshoOrderKey.class, order);
        }
        return 出力順;
    }

    private RString set文書番号() {
        RString 文書番号;
        if (processParamter.get通知書の文書番号().isEmpty()) {
            IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
            BunshoNo bunshoNo = finder.get文書番号管理(帳票ID, processParamter.get通知書の発行日());
            countedItem = Saiban.get(SubGyomuCode.DBD介護受給, GENERICKEY, new FlexibleYear(RDateTime.now().getDate().toDateString()), count);
            if (BunshoNoHatsubanHoho.自動採番.getCode().equals(bunshoNo.get文書番号発番方法())) {
                文書番号 = bunshoNo.edit文書番号(new RString(String.valueOf(countedItem.next())));
            } else {
                文書番号 = bunshoNo.edit文書番号();
            }
        } else {
            文書番号 = processParamter.get通知書の文書番号();
        }
        return 文書番号;
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
        builder.append(processParamter.get単票発行区分().get名称());
        出力条件.add(builder.toRString());

        builder.append(年度);
        RStringBuilder builder1 = new RStringBuilder();
        if (null != processParamter.get年度開始日()) {
            builder1.append(new RString(processParamter.get年度開始日().toString()));
        }
        builder1.append(カラ);
        if (null != processParamter.get年度終了日()) {
            builder1.append(new RString(processParamter.get年度終了日().toString()));
        }
        出力条件.add(builder1.toRString());
        RStringBuilder builder2 = new RStringBuilder();
        builder2.append(決定日期間);
        if (null != processParamter.get決定日FROM()) {
            builder2.append(new RString(processParamter.get決定日FROM().toString()));
        }
        builder2.append(カラ);
        if (null != processParamter.get決定日TO()) {
            builder2.append(new RString(processParamter.get決定日TO().toString()));
        }
        出力条件.add(builder2.toRString());
        RStringBuilder builder3 = new RStringBuilder();
        builder3.append(交付日);
        builder3.append(new RString(processParamter.get通知書の発行日().toString()));
        出力条件.add(builder.toRString());
        RStringBuilder builder4 = new RStringBuilder();
        builder4.append(出力順);
        if (order != null) {
            for (ISetSortItem item : order.get設定項目リスト()) {
                builder4.append(より).append(item.get項目名());
            }
        }
        出力条件.add(builder4.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
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

    private ShafukuKeigenKetteiTempTableEntity create処理(ShakaiFukushiHoujinnKeigenTsuuchishoEntity futan) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(futan.getPsmEntity());
        ShafukuKeigenKetteiTempTableEntity data = new ShafukuKeigenKetteiTempTableEntity();
        data.setHihokenshaNo(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getHihokenshaNo());
        data.setNinteishoHakkoZumi(false);
        data.setTsuchiHakkoZumi(true);
        data.setShikibetsuCode(kojin.get識別コード());
        data.setShinseiYMD(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getShinseiYMD());
        data.setKetteiYMD(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKetteiYMD());
        data.setTekiyoYMD(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getTekiyoKaishiYMD());
        data.setYukoKigenYMD(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getTekiyoKaishiYMD());
        data.setKetteiKubun(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKetteiKubun());
        data.setKeigenritsu_Bunshi(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKeigenritsu_Bunshi());
        data.setKeigenritsu_Bumbo(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKeigenritsu_Bumbo());
        data.setKeigenritsu(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getGemmenKubun());
        data.setKyotakuServiceGentei(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKyotakuServiceGentei());
        data.setKyojuhiShokuhiNomi(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKyojuhiShokuhiNomi());
        data.setKyusochishaUnitTypeKoshitsuNomi(futan.get社会福祉法人等利用者負担軽減().
                get社会福祉法人等利用者負担軽減Entity().getKyusochishaUnitTypeKoshitsuNomi());
        data.setKakuninNo(futan.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getKakuninNo());
        return data;
    }

    private ShafukuKeigenKetteiTempTableEntity insert(ShafukuKeigenKetteiTempTableEntity entity, ShakaiFukushiHoujinnKeigenTsuuchishoEntity shaka) {
        entity.setTsuchiHakkoZumi(true);
        entity.setHihokenshaNo(shaka.get社会福祉法人等利用者負担軽減().get社会福祉法人等利用者負担軽減Entity().getHihokenshaNo());
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(shaka.getPsmEntity());
        entity.setShikibetsuCode(kojin.get識別コード());
        return entity;
    }
}
