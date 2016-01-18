/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.kyokaisoggaitoshareportprocess;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kyokaisogaitosha.KyokaisoGaitoshaProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoKanriMasterListChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaListEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaRelateEntity;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.IAssociation;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * バッチ設計_DBUMN52001_境界層管理マスタリストのバッチ処理クラスです。
 *
 */
public class KyokaisogGaitoshaReportPageBreakProcess extends BatchProcessBase<KyokaisogGaitoshaRelateEntity> {

    private static final ReportId ID = new ReportId("DBA200005_KyokaisoKanriMasterList");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.basic.mapper.kyokaisogaitosha.IKyokaisoGaitoshaMapper.getKyokaisoKanriMasterList");
    private List<ReportOutputJokenhyoItem> lists;
    List<KyokaisogGaitoshaRelateEntity> daichoJohoList = new ArrayList<>();
    private KyokaisogGaitoshaListEntity kyokaisokanrimasterList;
    private KyokaisoGaitoshaProcessParameter parameter;
    private KyokaisoKanriMasterListChohyoDataSakuseiEntity dataSakuseiEntity;
    ReportOutputJokenhyoItem hyoItem;
//TODO 客户没有提供
//    @BatchWriter
//    private BatchReportWriter<CKyokaisoKanriMasterReportSource> batchReportWriter;
//    private ReportSourceWriter<CKyokaisoKanriMasterReportSource> reportSourceWriter;

    @Override
    protected void initialize() {

        lists = new ArrayList<>();
        kyokaisokanrimasterList = new KyokaisogGaitoshaListEntity();

    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        KyokaisoGaitoshaMybatisParameter mybatisParameter = parameter.toKyokaisoGaitoshaMybatisParameter();
        KyokaisoGaitoshaMybatisParameter piarameter = new KyokaisoGaitoshaMybatisParameter(
                mybatisParameter.getRange(), mybatisParameter.getMode(), mybatisParameter.getDate_FROM(),
                mybatisParameter.getDate_TO(), mybatisParameter.getIshokenFlag(),
                mybatisParameter.getIshyojunFutanFlag(),
                mybatisParameter.getIskogakuFlag(),
                mybatisParameter.getIskyojuhinadoFutangFlag(), mybatisParameter.getIskyuufugakuFlag(),
                mybatisParameter.getOrder_ID(), mybatisParameter.getIsshokuhiKeiFlag(),
                mybatisParameter.isDateFlag(),
                mybatisParameter.isDate_TOFlag(), mybatisParameter.isIsmodekjunhe(),
                mybatisParameter.isIsmoderange(), mybatisParameter.isIsmodenayi(),
                mybatisParameter.isRangeApplication(), mybatisParameter.isRangeStart(),
                mybatisParameter.isRangeEnd(), new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, piarameter);
    }

    @Override
    protected void createWriter() {
        //TODO 发行账票 客户方3月25号纳品。没有提供
//        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
//        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(KyokaisogGaitoshaRelateEntity entity) {
        //TODO  发行账票 客户方3月25号纳品。没有提供
        // TODO  QA377 AccessLogの実装方式
//        PersonalData personalData = toPersonalData(KyokaisogGaitoshaRelateEntity);
//        AccessLogger.log(AccessLogType.照会, KyokaisogGaitoshaRelateEntity);
        //OutputJokenhyoFactory();
//        KyokaisoKanriMasterListChohyoDataSakusei chohyoDataSakusei = new KyokaisoKanriMasterListChohyoDataSakusei();
//         chohyoDataSakusei.getcreateNenreiToutatsuYoteishaCheckListChohyo(kyokaisokanrimasterList);
        daichoJohoList.add(entity);
    }

    private void paramte(KyokaisogGaitoshaListEntity entity) {
        IAssociation association = AssociationFinderFactory.createInstance().getAssociation();
        kyokaisokanrimasterList.set市町村コード(association.get地方公共団体コード().getColumnValue());
        kyokaisokanrimasterList.set市町村名(association.get市町村名());
        //TODO QA#73393 改頁 ,並び順取得。
        entity.set並び順(parameter.toKyokaisoGaitoshaMybatisParameter().getOrder_ID());
        entity.set改頁(parameter.toKyokaisoGaitoshaMybatisParameter().getOrder_ID());
        entity.setKyokaisokanrimasterList(daichoJohoList);

    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder nituliki = new RStringBuilder();
        if (new RString("1").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getMode())) {
            nituliki.append(new RString("【抽出条件】 範囲で抽出　"));
            nituliki.append(parameter.toKyokaisoGaitoshaMybatisParameter().getDate_FROM()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            nituliki.append("時点での境界層登録者");
            出力条件.add(nituliki.toRString());
        }

        if (new RString("2").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getMode())) {
            nituliki.append(new RString("【抽出条件】 範囲で抽出　"));
            if (new RString("1").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getRange())) {
                nituliki.append("境界層該当申請日");
            }
            if (new RString("2").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getRange())) {
                nituliki.append("境界層該当開始日");
            }
            if (new RString("3").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getRange())) {
                nituliki.append("境界層該当終了日");
            }
            nituliki.append(new RString("が"));
            nituliki.append(parameter.toKyokaisoGaitoshaMybatisParameter().getDate_FROM()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            nituliki.append(new RString("～"));
            nituliki.append(parameter.toKyokaisoGaitoshaMybatisParameter().getDate_TO()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            出力条件.add(nituliki.toRString());
        }
        if (new RString("3").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getMode())) {
            nituliki.append(new RString("指定無し"));
            出力条件.add(nituliki.toRString());
        }
        if (new RString("1").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIshokenFlag())) {
            出力条件.add(new RString("給付額減額記載解除情報が登録されている情報"));
        }
        if (new RString("1").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIshyojunFutanFlag())) {
            出力条件.add(new RString("標準負担額の減額情報が登録されている情報"));
        }
        if (new RString("1").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIskogakuFlag())) {
            出力条件.add(new RString("特定介護サービス居住費等負担額の減額情報が登録されている情報"));
        }
        if (new RString("1").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIskyojuhinadoFutangFlag())) {
            出力条件.add(new RString("特定介護サービス食費負担額の減額情報が登録されている情報"));
        }
        if (new RString("1").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIskyuufugakuFlag())) {
            出力条件.add(new RString("高額介護サービス費世帯上限額の減額情報が登録されている情報"));
        }
        if (new RString("1").equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIsshokuhiKeiFlag())) {
            出力条件.add(new RString("保険料額の低減適用情報が登録されている情報"));
        }
        return 出力条件;
    }

    private void outputJokenhyoFactory() {
        hyoItem = new ReportOutputJokenhyoItem(new RString("DBA200005_KyokaisoKanriMasterList"),
                new RString("境界層管理マスタリスト"), kyokaisokanrimasterList.get市町村コード(), kyokaisokanrimasterList.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                dataSakuseiEntity.getページ数(), new RString("なし"), new RString("Empty"), contribute());
    }

    @Override
    protected void afterExecute() {
    }
}
