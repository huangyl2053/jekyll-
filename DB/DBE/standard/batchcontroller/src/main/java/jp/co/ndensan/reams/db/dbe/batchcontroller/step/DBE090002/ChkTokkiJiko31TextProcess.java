/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4.TokkiText1A4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiTextEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteichosaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoninteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext1a4.TokkiText1ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo.IYokaigoNinteiJohoTeikyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimpleLayoutBreaker;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 特記事項の作成クラスです。
 *
 * @author n3331
 */
public class ChkTokkiJiko31TextProcess extends BatchProcessBase<YokaigoninteiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo."
            + "IYokaigoNinteiJohoTeikyoMapper.get要介護認定申請者");
    private YokaigoBatchProcessParamter processPrm;
    TokkiText1A4Entity bodyItem;
    IYokaigoNinteiJohoTeikyoMapper mapper;
    @BatchWriter
    private BatchReportWriter<TokkiText1ReportSource> batchWrite;
    private ReportSourceWriter<TokkiText1ReportSource> reportSourceWriter;
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString 認定調査票チェックフラグ = new RString("【認定調査票チェックフラグ】");
    private static final RString 特記事項チェックフラグ = new RString("【特記事項チェックフラグ】");
    private static final RString 主治医意見書チェックフラグ = new RString("【主治医意見書チェックフラグ】");
    private static final RString その他資料チェックフラグ = new RString("【その他資料チェックフラグ】");
    private static final RString 一次判定結果チェックフラグ = new RString("【一次判定結果チェックフラグ】");
    private static final RString 総合事業開始区分 = new RString("【総合事業開始区分】");
    private static final RString すべて = new RString("1");
    private static final RString 一つずつ = new RString("3");
    private static final RString マスキングあり = new RString("1");
    List<NinteichosaRelateEntity> 特記事項リスト;

    @Override
    protected void initialize() {
        特記事項リスト = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IYokaigoNinteiJohoTeikyoMapper.class);
        特記事項リスト = mapper.get特記事項リスト(processPrm.toYokaigoBatchMybitisParamter());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toYokaigoBatchMybitisParamter());
    }

    @Override
    protected void createWriter() {
        RString reportId;
        if (すべて.equals(DbBusinessConfig.get(ConfigNameDBE.情報提供資料の特記事項編集パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            reportId = ReportIdDBE.DBE517131.getReportId().value();
        } else {
            reportId = ReportIdDBE.DBE517132.getReportId().value();
        }
        batchWrite = BatchReportFactory.createBatchReportWriter(reportId).addBreak(new BreakerCatalog<TokkiText1ReportSource>().new SimpleLayoutBreaker(

            TokkiText1ReportSource.LAYOUTBREAKITEM) {
            @Override
            public ReportLineRecord<TokkiText1ReportSource> occuredBreak(
                    ReportLineRecord<TokkiText1ReportSource> currentRecord, ReportLineRecord<TokkiText1ReportSource> nextRecord, ReportDynamicChart dynamicChart) {
                int layout = currentRecord.getSource().layoutBreakItem;
                currentRecord.setFormGroupIndex(layout);
                if (nextRecord != null && nextRecord.getSource() != null) {
                    layout = nextRecord.getSource().layoutBreakItem;
                    nextRecord.setFormGroupIndex(layout);
                }
                return currentRecord;
            }
        }).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(YokaigoninteiEntity entity) {
        TokkiText1A4Report report = new TokkiText1A4Report(setBodyItem(entity));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        set出力条件表();
    }

    private RString get特記事項名称(List<NinteichosaRelateEntity> 特記事項区分, int 連番, TokkiText1A4Entity ninteiEntity) {
        RString 名称 = RString.EMPTY;
        if (連番 < 特記事項区分.size()) {
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                名称 = NinteichosaKomoku09B.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get名称();
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                名称 = NinteichosaKomoku09A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get名称();
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                名称 = NinteichosaKomoku06A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get名称();
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                名称 = NinteichosaKomoku02A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get名称();
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                名称 = NinteichosaKomoku99A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get名称();
            }
        }
        return 名称;
    }

    private TokkiText1A4Entity setBodyItem(YokaigoninteiEntity entity) {
        TokkiText1A4Entity ninteiEntity = new TokkiText1A4Entity();
        if (!processPrm.getRadTokkiJikoMasking().equals(マスキングあり)) {
            ninteiEntity.set保険者番号(entity.get保険者番号());
            ninteiEntity.set被保険者番号(entity.get被保険者番号());
            ninteiEntity.set被保険者氏名(entity.get被保険者氏名());
        }
        ninteiEntity.set概況調査特記事項(entity.get概況調査特記事項());
        ninteiEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        ninteiEntity.set申請日_元号(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiEntity.set申請日_年(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiEntity.set申請日_月(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiEntity.set申請日_日(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiEntity.set作成日_元号(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiEntity.set作成日_年(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiEntity.set作成日_月(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiEntity.set作成日_日(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiEntity.set調査日_元号(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiEntity.set調査日_年(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiEntity.set調査日_月(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiEntity.set調査日_日(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiEntity.set審査日_元号(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiEntity.set審査日_年(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiEntity.set審査日_月(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiEntity.set審査日_日(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        setBodyItem01(特記事項リスト, ninteiEntity);
        return ninteiEntity;
    }

    private TokkiText1A4Entity setBodyItem01(List<NinteichosaRelateEntity> entity, TokkiText1A4Entity ninteiEntity) {
        List<TokkiTextEntity> 特記事項List = new ArrayList<>();
        List<TokkiTextEntity> 特記事項番号リスト = new ArrayList<>();
        List<TokkiTextEntity> イメージリスト = new ArrayList<>();
        for (int i = 0; i < entity.size(); i++) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.get(i).get特記事項区分())
                    && すべて.equals(DbBusinessConfig.get(ConfigNameDBE.情報提供資料の特記事項編集パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                TokkiTextEntity tokki = new TokkiTextEntity();
                tokki.set特記事項(entity.get(i).get特記事項());
                tokki.set特記事項番号(entity.get(i).get特記事項番号());
                tokki.set特記事項名称(get特記事項名称(entity, i, ninteiEntity));
                tokki.set特記事項連番(entity.get(i).get特記事項連番());
                特記事項List.add(tokki);
            }
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.get(i).get特記事項区分())
                    && 一つずつ.equals(DbBusinessConfig.get(ConfigNameDBE.情報提供資料の特記事項編集パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                TokkiTextEntity tokki = new TokkiTextEntity();
                tokki.set特記事項(entity.get(i).get特記事項());
                tokki.set特記事項番号(entity.get(i).get特記事項番号());
                tokki.set特記事項名称(get特記事項名称(entity, i, ninteiEntity));
                tokki.set特記事項連番(entity.get(i).get特記事項連番());
                特記事項番号リスト.add(tokki);
            }
        }
        ninteiEntity.set特記事項リスト(特記事項List);
        ninteiEntity.set特記事項番号リスト(特記事項番号リスト);
        ninteiEntity.set特記事項イメージリスト(イメージリスト);
        return ninteiEntity;
    }

    private void set出力条件表() {
        List<RString> 出力条件 = new ArrayList();
        RStringBuilder builder = new RStringBuilder();
        builder.append(認定調査票チェックフラグ);
        builder.append(processPrm.getChkNinteiChosahyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(特記事項チェックフラグ);
        builder.append(processPrm.getChkTokkiJiko());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(主治医意見書チェックフラグ);
        builder.append(processPrm.getChkShujiiIkensho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(その他資料チェックフラグ);
        builder.append(processPrm.getChkSonotaShiryo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(一次判定結果チェックフラグ);
        builder.append(processPrm.getChkIchijiHanteiKekka());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(総合事業開始区分);
        builder.append(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        出力条件.add(builder.toRString());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        ReportIdDBE.DBE517131.getReportId().value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString(JobContextHolder.getJobId()),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517131.getReportId().value()),
                        new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                        CSV出力有無,
                        CSVファイル名,
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }
}
