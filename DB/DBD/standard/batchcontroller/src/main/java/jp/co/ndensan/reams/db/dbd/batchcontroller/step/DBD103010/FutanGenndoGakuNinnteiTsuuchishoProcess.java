/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD103010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100013.FutanGendogakuKetteiTsuchishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100013.HakkoRirekiKoyuJohoDBD100013;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100020.FutanGendogakuNinteishoOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.ShakaiFukushiHoujinnKeigenParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902.FutanGenndoGakuNinnteiTsuuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.FutanGenndoGakuNinnteiTsuuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.temptable.FutanGenndoGakuNinnteiTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100013.FutanGendogakuKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei.IFutanGenndoGakuNinnteiListMapper;
import jp.co.ndensan.reams.db.dbd.service.report.dbd1200902.FutanGenndoGakuNinnteiTsuuchishoService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.hakkorireki.GyomuKoyuJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
 * 負担限度額認定の通知書発行_process処理クラスです.
 *
 * @reamsid_L DBD-3981-050 x_lilh
 */
public class FutanGenndoGakuNinnteiTsuuchishoProcess extends BatchProcessBase<FutanGenndoGakuNinnteiTsuuchishoEntity> {

    private static final ReportId 帳票ID = new ReportId("DBD100013_FutanGendogakuKetteiTsuchisho");
    private static final ReportId 帳票分類ID = new ReportId("DBD100013_FutanGendogakuKetteiTsuchisho");
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
    private static FutanGenndoGakuNinnteiTsuuchishoProcessParameter processParamter;
    private static Association association;
    private static CountedItem countedItem;
    private static RString reamsLoginID;
    private static IOutputOrder order;
    private static int count;
    private IFutanGenndoGakuNinnteiListMapper mapper;
    private static List<RString> 通知書定型文;
    private static final int ONE_1 = 1;
    private static final int TWO_2 = 2;
    private static final int THREE_3 = 3;
    private static final int FOUR_4 = 4;
    private static DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
    private static List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用;
    private static final RString GENERICKEY = new RString("負担限度額決定通知書");
    @BatchWriter
    private BatchReportWriter<FutanGendogakuKetteiTsuchishoReportSource> batchReportWrite;
    private ReportSourceWriter<FutanGendogakuKetteiTsuchishoReportSource> reportSourceWriter;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei."
                    + "IFutanGenndoGakuNinnteiTsuuchishoMapper.get負担限度額認定の通知書発行情報");

    @Override
    protected void initialize() {
        mapper = getMapper(IFutanGenndoGakuNinnteiListMapper.class);
        reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        association = AssociationFinderFactory.createInstance().getAssociation();
        帳票制御共通 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御共通(帳票ID);
        帳票制御汎用 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御汎用(帳票ID);
        通知書定型文 = new ArrayList();
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

        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toFutanGenndoGakuNinnteiTsuuchishoMybatisParameter(
                psmShikibetsuTaisho, psmAtesaki, get出力順(),
                HakkoRirekiKoyuJohoDBD100013.被保番号.get名称(), HakkoRirekiKoyuJohoDBD100013.減免適用開始日.get名称(), 帳票ID,
                GyomuKoyuJoho.被保番号.getコード(),
                GyomuKoyuJoho.減免適用開始日.getコード()));

    }
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
        tmpTableWriter = new BatchEntityCreatedTempTableWriter(FutanGenndoGakuNinnteiTempTableEntity.TABLE_NAME,
                FutanGenndoGakuNinnteiTempTableEntity.class);
    }

    @Override
    protected void beforeExecute() {
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
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = manager.get通知書定型文項目(SubGyomuCode.DBD介護受給, 帳票ID,
                KamokuCode.EMPTY, パターン番号);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBD介護受給, 帳票ID);
        List<TsuchishoTeikeibunEntity> 通知書定型文List = tsuchishoTeikeibunInfo.get通知書定型文List();
        for (TsuchishoTeikeibunEntity entity : 通知書定型文List) {
            int 項目番号 = entity.getTsuchishoTeikeibunEntity().getSentenceNo();
            RString 文章 = textHenkanRule.editText(entity.getTsuchishoTeikeibunEntity().getSentence());
            通知書定型文.add(項目番号, textHenkanRule.editText(文章));
        }
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        RString psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
        FutanGenndoGakuNinnteiTsuuchishoService service = new FutanGenndoGakuNinnteiTsuuchishoService();
        count = service.get利用者負担割合(processParamter.toFutanGenndoGakuNinnteiTsuuchishoMybatisParameter(
                psmShikibetsuTaisho, psmAtesaki, get出力順(),
                HakkoRirekiKoyuJohoDBD100013.被保番号.get名称(), HakkoRirekiKoyuJohoDBD100013.減免適用開始日.get名称(), 帳票ID,
                GyomuKoyuJoho.被保番号.getコード(),
                GyomuKoyuJoho.減免適用開始日.getコード()));
    }

    @Override
    protected void process(FutanGenndoGakuNinnteiTsuuchishoEntity fatan) {
        ShakaiFukushiHoujinnKeigenParameter parameter = new ShakaiFukushiHoujinnKeigenParameter(fatan.get介護保険負担限度額認定().
                get介護保険負担限度額認定Entity().getHihokenshaNo(), fatan.getShikibetsuCode());
        FutanGenndoGakuNinnteiTempTableEntity entity = mapper.get負担限度額認定の認定証発行一時テーブル(parameter);
        if (entity == null) {
            tmpTableWriter.insert(create処理(fatan));
        } else {
            tmpTableWriter.update(insert(entity, fatan));
        }
        UaFt250FindAtesakiEntity uaFt250Entity = fatan.getAtesakiEntity();
        UaFt200FindShikibetsuTaishoEntity uaFt200Entity = fatan.getPsmEntity();
        FutanGendogakuNinteiEntity 負担限度額認定 = fatan.get介護保険負担限度額認定();
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票分類ID,
                processParamter.get通知書の交付日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        FutanGendogakuKetteiTsuchishoReport find = FutanGendogakuKetteiTsuchishoReport.createReport(new FutanGendogakuNintei(負担限度額認定),
                ShikibetsuTaishoFactory.createKojin(uaFt200Entity), AtesakiFactory.createInstance(uaFt250Entity),
                new ChohyoSeigyoKyotsu(帳票制御共通), 帳票制御汎用, association, set文書番号(), 通知書定型文, ninshoshaSource);
        find.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        order = finder.get出力順(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100020.getReportId(), reamsLoginID, processParamter.get改頁出力順ID());
        RString 出力順 = RString.EMPTY;
        if (order != null) {
            出力順 = MyBatisOrderByClauseCreator.create(FutanGendogakuNinteishoOrderKey.class, order);
        }
        return 出力順;
    }

    private RString set文書番号() {
        RString 文書番号;
        if (processParamter.get通知書の文書番号().isEmpty()) {
            IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
            BunshoNo bunshoNo = finder.get文書番号管理(帳票ID, processParamter.get通知書の交付日());
            countedItem = Saiban.get(SubGyomuCode.DBD介護受給, GENERICKEY, new FlexibleYear(RDateTime.now().getDate().getYear().toDateString()), count);
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
        builder.append(旧措置者区分);
        builder.append(processParamter.get旧措置者区分().get名称());
        出力条件.add(builder.toRString());
        builder.append(年度);
        if (null != processParamter.get年度開始日()) {
            builder.append(new RString(processParamter.get年度開始日().toString()));
        }
        builder.append(カラ);
        if (null != processParamter.get年度終了日()) {
            builder.append(new RString(processParamter.get年度終了日().toString()));
        }
        出力条件.add(builder.toRString());

        builder.append(抽出期間種類);
        builder.append(processParamter.get対象区分().get名称());
        出力条件.add(builder.toRString());

        builder.append(対象期間範囲);
        if (null != processParamter.get対象日FROM()) {
            builder.append(new RString(processParamter.get対象日FROM().toString()));
        }
        builder.append(カラ);
        if (null != processParamter.get対象日TO()) {
            builder.append(new RString(processParamter.get対象日TO().toString()));
        }
        出力条件.add(builder.toRString());
        builder.append(発行日);

        builder.append(new RString(processParamter.get通知書の交付日().toString()));

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

    private FutanGenndoGakuNinnteiTempTableEntity create処理(FutanGenndoGakuNinnteiTsuuchishoEntity futan) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(futan.getPsmEntity());
        FutanGenndoGakuNinnteiTempTableEntity data = new FutanGenndoGakuNinnteiTempTableEntity();
        data.setHihokenshaNo(futan.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getHihokenshaNo());
        data.setNinteishoHakkoZumi(false);
        data.setTsuchiHakkoZumi(true);
        data.setShikibetsuCode(kojin.get識別コード());
        data.setShinseiYMD(futan.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getShinseiYMD());
        data.setKetteiYMD(futan.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getKetteiYMD());
        data.setTekiyoYMD(futan.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getTekiyoKaishiYMD());
        data.setKetteiKubun(futan.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getKetteiKubun());
        data.setRiyoshaFutanDankai(futan.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getRiyoshaFutanDankai());
        return data;
    }

    private FutanGenndoGakuNinnteiTempTableEntity insert(FutanGenndoGakuNinnteiTempTableEntity tempEntity,
            FutanGenndoGakuNinnteiTsuuchishoEntity fatan) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(fatan.getPsmEntity());
        tempEntity.setShikibetsuCode(kojin.get識別コード());
        tempEntity.setTsuchiHakkoZumi(true);
        tempEntity.setHihokenshaNo(fatan.get介護保険負担限度額認定().get介護保険負担限度額認定Entity().getHihokenshaNo());
        return tempEntity;
    }
}
