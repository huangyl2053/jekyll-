/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.kyokaisoggaitoshareportprocess;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListBodyItem;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListHeadItem;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReport;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlistchohyodatasakusei.KyokaisoKanriMasterListChohyoDataSakusei;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kyokaisogaitosha.KyokaisoGaitoshaProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoKanriMasterListChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaListEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.IAssociation;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * バッチ設計_DBUMN52001_境界層管理マスタリストのバッチ処理クラスです。
 *
 * @reamsid_L DBU-1050-020 wanghui
 *
 */
public class KyokaisogGaitoshaReportPageBreakProcess extends BatchProcessBase<KyokaisogGaitoshaRelateEntity> {

    private static final RString 取得モード_1 = new RString("1");
    private static final RString 取得モード_2 = new RString("2");
    private static final RString 取得モード_3 = new RString("3");
    private static final RString 境界層該当申請日名称 = new RString("1");
    private static final RString 境界層該当開始日名称 = new RString("2");
    private static final RString 境界層該当終了日名称 = new RString("3");
    private static final RString 登録されて = new RString("1");
    private static final RString 出力条件_基準日 = new RString("【抽出条件】 基準日で抽出");
    private static final RString 出力条件_範囲 = new RString("【抽出条件】 範囲で抽出");
    private static final RString 出力条件_指定無し = new RString("【抽出条件】 指定無し");
    private static final RString 境界層該当申請日 = new RString("境界層該当申請日");
    private static final RString 境界層該当開始日 = new RString("境界層該当開始日");
    private static final RString 境界層該当終了日 = new RString("境界層該当終了日");
    private static final RString 時点での境界層登録者 = new RString("時点での境界層登録者");
    private static final RString 標準負担額 = new RString("標準負担額の減額情報が登録されている情報");
    private static final RString 給付額減額記載解除 = new RString("給付額減額記載解除情報が登録されている情報");
    private static final RString 特定介護サービス居住費 = new RString("特定介護サービス居住費等負担額の減額情報が登録されている情報");
    private static final RString 特定介護サービス食費負 = new RString("特定介護サービス食費負担額の減額情報が登録されている情報");
    private static final RString 高額介護サービス費世帯 = new RString("高額介護サービス費世帯上限額の減額情報が登録されている情報");
    private static final RString 保険料額 = new RString("保険料額の低減適用情報が登録されている情報");
    private static final RString 出力条件_が = new RString("が");
    private static final RString 出力条件_ = new RString("～");
    private static final RString なし = new RString("なし");
    private static final RString 境界層該当内容 = new RString("【境界層該当内容】");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kyokaisogaitosha.IKkyokaisoGaitoshaMapper.getKyokaisoKanriMasterList");
    private KyokaisoKanriMasterListHeadItem headItem;
    private List<KyokaisoKanriMasterListBodyItem> bodyItemList;
    List<KyokaisogGaitoshaRelateEntity> daichoJohoList = new ArrayList<>();
    private KyokaisogGaitoshaListEntity kyokaisokanrimasterList;
    private KyokaisoGaitoshaProcessParameter parameter;
    @BatchWriter
    private BatchReportWriter<KyokaisoKanriMasterListReportSource> batchReportWriter;
    private ReportSourceWriter<KyokaisoKanriMasterListReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        kyokaisokanrimasterList = new KyokaisogGaitoshaListEntity();
        bodyItemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        KyokaisoGaitoshaMybatisParameter mybatisParameter = parameter.toKyokaisoGaitoshaMybatisParameter();
        KyokaisoGaitoshaMybatisParameter piarameter = KyokaisoGaitoshaMybatisParameter.createParam(
                mybatisParameter.getMode(),
                mybatisParameter.getRange(),
                mybatisParameter.getDate_FROM(),
                mybatisParameter.getDate_TO(),
                mybatisParameter.getIskyuufugakuFlag(),
                mybatisParameter.getIshyojunFutanFlag(),
                mybatisParameter.getIskyojuhinadoFutangFlag(),
                mybatisParameter.getIsshokuhiKeiFlag(),
                mybatisParameter.getIskogakuFlag(),
                mybatisParameter.getIshokenFlag(),
                mybatisParameter.getOrder_ID(),
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, piarameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBA200005.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(KyokaisogGaitoshaRelateEntity entity) {
//         TODO  QA377 AccessLogの実装方式
//       PersonalData personalData = toPersonalData(KyokaisogGaitoshaRelateEntity);
//        AccessLogger.log(AccessLogType.照会, KyokaisogGaitoshaRelateEntity);
//        KyokaisoKanriMasterListChohyoDataSakusei chohyoDataSakusei = new KyokaisoKanriMasterListChohyoDataSakusei();
//        chohyoDataSakusei.getcreateNenreiToutatsuYoteishaCheckListChohyo(kyokaisokanrimasterList);
        daichoJohoList.add(entity);

    }

    private void paramte() {
        IAssociation association = AssociationFinderFactory.createInstance().getAssociation();
        kyokaisokanrimasterList.set市町村コード(association.get地方公共団体コード().getColumnValue());
        kyokaisokanrimasterList.set市町村名(association.get市町村名());
        // TODO QA #73393 出力順ID実装方式 回復待ち
        kyokaisokanrimasterList.set並び順(parameter.toKyokaisoGaitoshaMybatisParameter().getOrder_ID());
        kyokaisokanrimasterList.set改頁(parameter.toKyokaisoGaitoshaMybatisParameter().getOrder_ID());

    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder nituliki = new RStringBuilder();
        if ((取得モード_1).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getMode())) {
            nituliki.append((出力条件_基準日));
            if (parameter.toKyokaisoGaitoshaMybatisParameter().getDate_FROM() != null) {
                nituliki.append(parameter.toKyokaisoGaitoshaMybatisParameter().getDate_FROM()
                        .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            } else {
                nituliki.append(RString.EMPTY);
            }
            nituliki.append(時点での境界層登録者);
            出力条件.add(nituliki.toRString());
        }
        if ((取得モード_2).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getMode())) {
            nituliki = new RStringBuilder();
            nituliki.append((出力条件_範囲));
            if ((境界層該当申請日名称).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getRange())) {
                nituliki.append(境界層該当申請日);
            }
            if ((境界層該当開始日名称).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getRange())) {
                nituliki.append(境界層該当開始日);
            }
            if ((境界層該当終了日名称).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getRange())) {
                nituliki.append(境界層該当終了日);
            }
            nituliki.append((出力条件_が));
            if (parameter.toKyokaisoGaitoshaMybatisParameter().getDate_FROM() != null) {
                nituliki.append(parameter.toKyokaisoGaitoshaMybatisParameter().getDate_FROM()
                        .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            } else {
                nituliki.append(RString.EMPTY);
            }
            nituliki.append((出力条件_));
            if (parameter.toKyokaisoGaitoshaMybatisParameter().getDate_TO() != null) {
                nituliki.append(parameter.toKyokaisoGaitoshaMybatisParameter().getDate_TO()
                        .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
                出力条件.add(nituliki.toRString());
            } else {
                nituliki.append(RString.EMPTY);
                出力条件.add(nituliki.toRString());
            }

        }
        if ((取得モード_3).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getMode())) {
            nituliki = new RStringBuilder();
            nituliki.append((出力条件_指定無し));
            出力条件.add(nituliki.toRString());
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIshokenFlag())) {
            出力条件.add((給付額減額記載解除));
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIshyojunFutanFlag())) {
            出力条件.add((標準負担額));
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIskogakuFlag())) {
            出力条件.add((特定介護サービス居住費));
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIskyojuhinadoFutangFlag())) {
            出力条件.add((特定介護サービス食費負));
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIskyuufugakuFlag())) {
            出力条件.add((高額介護サービス費世帯));
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIsshokuhiKeiFlag())) {
            出力条件.add((保険料額));
        }
        出力条件.set(1, 境界層該当内容.concat(出力条件.get(1)));
        return 出力条件;
    }

    private void outputJokenhyoFactory(int pageCnt) {
        ReportOutputJokenhyoItem item
                = new ReportOutputJokenhyoItem(ReportIdDBU.DBA200005.getReportId().value(),
                        kyokaisokanrimasterList.get市町村コード(), kyokaisokanrimasterList.get市町村名(),
                        new RString(String.valueOf(JobContextHolder.getJobId())),
                        ReportIdDBU.DBA200005.getReportName(),
                        //new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                        new RString(String.valueOf(pageCnt)),
                        なし,
                        RString.EMPTY,
                        contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private KyokaisoKanriMasterListBodyItem setBodyItem(KyokaisoKanriMasterListChohyoDataSakuseiEntity entity) {
        return new KyokaisoKanriMasterListBodyItem(entity.get被保険者番号(),
                entity.getカナ氏名(),
                entity.get性別(),
                entity.get種別(),
                entity.get状態(),
                entity.get生年月日(),
                entity.get該当開始日(),
                entity.get給付額減額解除(),
                entity.get居住費軽減後居室種類(),
                entity.get識別コード(),
                entity.get氏名(),
                entity.get世帯コード(),
                entity.get該当申請日(),
                entity.get該当終了日(),
                entity.get標準負担減額後負担額(),
                entity.get居住費軽減後負担額(),
                entity.get食費軽減後負担額(),
                entity.get高額ｻｰﾋﾞｽ費減額後上限額(),
                entity.get保険料納付減額後保険料段階());
    }

    @Override
    protected void afterExecute() {
        paramte();
        kyokaisokanrimasterList.setKyokaisokanrimasterList(daichoJohoList);
        KyokaisoKanriMasterListChohyoDataSakusei 帳票データリスト = new KyokaisoKanriMasterListChohyoDataSakusei();
        List<KyokaisoKanriMasterListChohyoDataSakuseiEntity> 帳票データ = 帳票データリスト.getcreateNenreiToutatsuYoteishaCheckListChohyo(kyokaisokanrimasterList);
        for (KyokaisoKanriMasterListChohyoDataSakuseiEntity dataSakuseiEntity : 帳票データ) {
            if (dataSakuseiEntity.get被保険者番号() != null) {
                bodyItemList.add(setBodyItem(dataSakuseiEntity));
            }

            headItem = new KyokaisoKanriMasterListHeadItem(
                    dataSakuseiEntity.get印刷日時(),
                    dataSakuseiEntity.get市町村コード(),
                    dataSakuseiEntity.get市町村名(),
                    dataSakuseiEntity.get並び順1(),
                    dataSakuseiEntity.get並び順2(),
                    dataSakuseiEntity.get並び順3(),
                    dataSakuseiEntity.get並び順4(),
                    dataSakuseiEntity.get並び順5(),
                    dataSakuseiEntity.get改頁1(),
                    dataSakuseiEntity.get改頁2(),
                    dataSakuseiEntity.get改頁3(),
                    dataSakuseiEntity.get改頁4(),
                    dataSakuseiEntity.get改頁5());
        }
        if (!bodyItemList.isEmpty() || headItem != null) {
            KyokaisoKanriMasterListReport report = KyokaisoKanriMasterListReport.createFrom(headItem, bodyItemList);
            report.writeBy(reportSourceWriter);
            outputJokenhyoFactory(帳票データ.size());
        }
    }
}
