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
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 特記事項の作成クラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
public class ChkTokkiJiko31Process extends BatchProcessBase<YokaigoninteiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo."
            + "IYokaigoNinteiJohoTeikyoMapper.get要介護認定申請者");
    private YokaigoBatchProcessParamter processPrm;
    TokkiText1A4Entity bodyItem;
    IYokaigoNinteiJohoTeikyoMapper mapper;
    @BatchWriter
    private BatchReportWriter<TokkiText1ReportSource> batchWrite;
    private ReportSourceWriter<TokkiText1ReportSource> reportSourceWriter;
    private static final RString FILENAME = new RString("C410");
    private static final RString BAK = new RString("_BAK");
    private static final RString C0007_FILENAME_BAK = new RString("C0007_BAK.png");
    private static final RString C0007_FILENAME = new RString("C0007.png");
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString フラグ = new RString("1");
    private static final int 最大ページ = 6;
    private static final RString 認定調査票チェックフラグ = new RString("【認定調査票】");
    private static final RString 特記事項チェックフラグ = new RString("【特記事項】");
    private static final RString 主治医意見書チェックフラグ = new RString("【主治医意見書】");
    private static final RString その他資料チェックフラグ = new RString("【その他資料】");
    private static final RString 一次判定結果チェックフラグ = new RString("【一次判定結果】");
    private static final RString 帳票発行有り = new RString("1");
    private static final RString 帳票発行無し = new RString("0");
    private static final RString 出力する = new RString("出力する");
    private static final RString 出力しない = new RString("出力しない");
    private static final RString 総合事業開始区分 = new RString("【総合事業開始区分】");
    private static final RString 総合事業開始区分_未実施 = new RString("1");
    private static final RString 総合事業開始区分_実施済 = new RString("2");
    private static final RString 総合事業未実施 = new RString("総合事業未実施");
    private static final RString 総合事業実施済 = new RString("総合事業実施済");
    private static final RString 全イメージ = new RString("2");
    private static final RString 短冊 = new RString("3");
    private static final RString 特記事項番号_101 = new RString("101");
    private static final RString 特記事項番号_102 = new RString("102");
    private static final RString 特記事項番号_103 = new RString("103");
    private static final RString 特記事項番号_104 = new RString("104");
    private static final RString 特記事項番号_105 = new RString("105");
    private static final RString 特記事項番号_106 = new RString("106");
    private static final RString 特記事項番号_107 = new RString("107");
    private static final RString 特記事項番号_108 = new RString("108");
    private static final RString 特記事項番号_109 = new RString("109");
    private static final RString 特記事項番号_110 = new RString("110");
    private static final RString 特記事項番号_111 = new RString("111");
    private static final RString 特記事項番号_112 = new RString("112");
    private static final RString 特記事項番号_113 = new RString("113");
    private static final RString 特記事項番号_201 = new RString("201");
    private static final RString 特記事項番号_202 = new RString("202");
    private static final RString 特記事項番号_203 = new RString("203");
    private static final RString 特記事項番号_204 = new RString("204");
    private static final RString 特記事項番号_205 = new RString("205");
    private static final RString 特記事項番号_206 = new RString("206");
    private static final RString 特記事項番号_207 = new RString("207");
    private static final RString 特記事項番号_208 = new RString("208");
    private static final RString 特記事項番号_209 = new RString("209");
    private static final RString 特記事項番号_210 = new RString("210");
    private static final RString 特記事項番号_211 = new RString("211");
    private static final RString 特記事項番号_212 = new RString("212");
    private static final RString 特記事項番号_301 = new RString("301");
    private static final RString 特記事項番号_302 = new RString("302");
    private static final RString 特記事項番号_303 = new RString("303");
    private static final RString 特記事項番号_304 = new RString("304");
    private static final RString 特記事項番号_305 = new RString("305");
    private static final RString 特記事項番号_306 = new RString("306");
    private static final RString 特記事項番号_307 = new RString("307");
    private static final RString 特記事項番号_308 = new RString("308");
    private static final RString 特記事項番号_309 = new RString("309");
    private static final RString 特記事項番号_401 = new RString("401");
    private static final RString 特記事項番号_402 = new RString("402");
    private static final RString 特記事項番号_403 = new RString("403");
    private static final RString 特記事項番号_404 = new RString("404");
    private static final RString 特記事項番号_405 = new RString("405");
    private static final RString 特記事項番号_406 = new RString("406");
    private static final RString 特記事項番号_407 = new RString("407");
    private static final RString 特記事項番号_408 = new RString("408");
    private static final RString 特記事項番号_409 = new RString("409");
    private static final RString 特記事項番号_410 = new RString("410");
    private static final RString 特記事項番号_411 = new RString("411");
    private static final RString 特記事項番号_412 = new RString("412");
    private static final RString 特記事項番号_413 = new RString("413");
    private static final RString 特記事項番号_414 = new RString("414");
    private static final RString 特記事項番号_415 = new RString("415");
    private static final RString 特記事項番号_4011 = new RString("4011");
    private static final RString 特記事項番号_4012 = new RString("4022");
    private static final RString 特記事項番号_501 = new RString("501");
    private static final RString 特記事項番号_502 = new RString("502");
    private static final RString 特記事項番号_503 = new RString("503");
    private static final RString 特記事項番号_504 = new RString("504");
    private static final RString 特記事項番号_505 = new RString("505");
    private static final RString 特記事項番号_506 = new RString("506");
    private static final RString 特記事項番号_5011 = new RString("5011");
    private static final RString 特記事項番号_5012 = new RString("5012");
    private static final RString 特記事項番号_5013 = new RString("5013");
    private static final RString 特記事項番号_5014 = new RString("5014");
    private static final RString 特記事項番号_5021 = new RString("5021");
    private static final RString 特記事項番号_5022 = new RString("5022");
    private static final RString 特記事項番号_601 = new RString("601");
    private static final RString 特記事項番号_602 = new RString("602");
    private static final RString 特記事項番号_603 = new RString("603");
    private static final RString 特記事項番号_604 = new RString("604");
    private static final RString 特記事項番号_605 = new RString("605");
    private static final RString 特記事項番号_606 = new RString("606");
    private static final RString 特記事項番号_607 = new RString("607");
    private static final RString 特記事項番号_608 = new RString("608");
    private static final RString 特記事項番号_609 = new RString("609");
    private static final RString 特記事項番号_610 = new RString("610");
    private static final RString 特記事項番号_611 = new RString("611");
    private static final RString 特記事項番号_612 = new RString("612");
    private static final RString 特記事項番号_6051 = new RString("6051");
    private static final RString 特記事項番号_6052 = new RString("6052");
    private static final RString 特記事項番号_6053 = new RString("6053");
    private static final RString 特記事項番号_6054 = new RString("6054");
    private static final RString 特記事項番号_6055 = new RString("6055");
    private static final RString 特記事項番号_6056 = new RString("6056");
    private static final RString 特記事項番号_701 = new RString("701");
    private static final RString 特記事項番号_702 = new RString("702");
    private static final RString 拡張子_PNG = new RString(".png");
    private static final RString マスキングあり = new RString("1");
    List<NinteichosaRelateEntity> 特記事項リスト;
    private static final int 最大共有ファイル下二桁 = 9;

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
        if (全イメージ.equals(DbBusinessConfig.get(ConfigNameDBE.情報提供資料の特記事項イメージパターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            reportId = ReportIdDBE.DBE517133.getReportId().value();
        } else {
            reportId = ReportIdDBE.DBE517134.getReportId().value();
        }
        batchWrite = BatchReportFactory.createBatchReportWriter(reportId)
                .addBreak(new BreakerCatalog<TokkiText1ReportSource>().new SimpleLayoutBreaker(TokkiText1ReportSource.LAYOUTBREAKITEM,
                        TokkiText1ReportSource.TOKKIIMG) {
                    @Override
                    public ReportLineRecord<TokkiText1ReportSource> occuredBreak(
                            ReportLineRecord<TokkiText1ReportSource> currentRecord,
                            ReportLineRecord<TokkiText1ReportSource> nextRecord, ReportDynamicChart dynamicChart) {
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
        ninteiEntity.set作成日_元号(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiEntity.set作成日_年(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiEntity.set作成日_月(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiEntity.set作成日_日(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
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
        ninteiEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        setBodyItem01(特記事項リスト, ninteiEntity);
        return ninteiEntity;
    }

    private TokkiText1A4Entity setBodyItem01(List<NinteichosaRelateEntity> entity, TokkiText1A4Entity ninteiEntity) {
        List<TokkiTextEntity> 特記事項List = new ArrayList<>();
        List<TokkiTextEntity> 特記事項番号リスト = new ArrayList<>();
        List<TokkiTextEntity> イメージリスト = new ArrayList<>();
        List<TokkiTextEntity> 全イメージリスト = new ArrayList<>();
        RString 共有ファイル名 = ninteiEntity.get保険者番号().concat(ninteiEntity.get被保険者番号());
        RDateTime イメージID = mapper.getイメージ(processPrm.toYokaigoBatchMybitisParamter());
        RString path = 共有ファイルを引き出す(イメージID, 共有ファイル名);
        ninteiEntity.set概況調査特記事項イメージ(getImageFile_C0007(path));
        if (全イメージ.equals(DbBusinessConfig.get(ConfigNameDBE.情報提供資料の特記事項イメージパターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            for (int i = 1; i <= 最大ページ; i++) {
                set特記事項全イメージパス(path, entity, i, 全イメージリスト);
            }
        } else if (短冊.equals(DbBusinessConfig.get(ConfigNameDBE.情報提供資料の特記事項イメージパターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            for (int i = 0; i < entity.size(); i++) {
                if (TokkijikoTextImageKubun.イメージ.getコード().equals(entity.get(i).get特記事項区分())) {
                    TokkiTextEntity tokki = new TokkiTextEntity();
                    tokki.set特記事項(entity.get(i).get特記事項());
                    tokki.set特記事項番号(entity.get(i).get特記事項番号());
                    tokki.set特記事項名称(get特記事項名称(entity, i, ninteiEntity));
                    tokki.set特記事項連番(entity.get(i).get特記事項連番());
                    RString fileName = get共有ファイル(entity.get(i).get特記事項番号(), ninteiEntity);
                    RString fileFullPath = RString.EMPTY;
                    for (int currentNumber = 0; currentNumber <= 最大共有ファイル下二桁; currentNumber++) {
                        RString currentFileName = fileName.concat(new RString(String.format("%02d", currentNumber))).concat(拡張子_PNG);
                        RString currentFilefullPath = getFilePath(path, currentFileName);
                        if (!RString.isNullOrEmpty(currentFilefullPath)) {
                            fileFullPath = currentFilefullPath;
                            break;
                        }
                    }
                    if (!RString.isNullOrEmpty(fileFullPath)) {
                        tokki.set特記事項イメージ(fileFullPath);
                    } else {
                        tokki.set特記事項イメージ(RString.EMPTY);
                    }
                    イメージリスト.add(tokki);
                }
            }
        }
        ninteiEntity.set特記事項リスト(特記事項List);
        ninteiEntity.set特記事項番号リスト(特記事項番号リスト);
        ninteiEntity.set特記事項イメージリスト(イメージリスト);
        ninteiEntity.set特記事項全イメージリスト(全イメージリスト);
        return ninteiEntity;
    }

    private void set特記事項全イメージパス(RString path, List<NinteichosaRelateEntity> entity, int i, List<TokkiTextEntity> 全イメージリスト) {
        if (!entity.isEmpty() && TokkijikoTextImageKubun.イメージ.getコード().equals(entity.get(0).get特記事項区分())) {
            TokkiTextEntity tokki = new TokkiTextEntity();
            RString fileName = getImageFile_C410X(path, i);
            if (!RString.isNullOrEmpty(fileName)) {
                tokki.set特記事項イメージ(fileName);
                全イメージリスト.add(tokki);
            }
        }
    }

    private RString get共有ファイル(RString 特記事項番号, TokkiText1A4Entity ninteiEntity) {
        RStringBuilder builder = new RStringBuilder();
        if (特記事項番号_101.equals(特記事項番号)) {
            builder.append(new RString("C3001-"));
        }
        if (特記事項番号_102.equals(特記事項番号)) {
            builder.append(new RString("C3006-"));
        }
        if (特記事項番号_103.equals(特記事項番号)) {
            builder.append(new RString("C3010-"));
        }
        if (特記事項番号_104.equals(特記事項番号)) {
            builder.append(new RString("C3011-"));
        }
        if (特記事項番号_105.equals(特記事項番号)) {
            builder.append(new RString("C3012-"));
        }
        if (特記事項番号_106.equals(特記事項番号)) {
            builder.append(new RString("C3013-"));
        }
        if (特記事項番号_107.equals(特記事項番号)) {
            builder.append(new RString("C3014-"));
        }
        if (特記事項番号_108.equals(特記事項番号)) {
            builder.append(new RString("C3015-"));
        }
        if (特記事項番号_109.equals(特記事項番号)) {
            builder.append(new RString("C3016-"));
        }
        if (特記事項番号_110.equals(特記事項番号)) {
            builder.append(new RString("C3017-"));
        }
        if (特記事項番号_111.equals(特記事項番号)) {
            builder.append(new RString("C3018-"));
        }
        if (特記事項番号_112.equals(特記事項番号)) {
            builder.append(new RString("C3019-"));
        }
        if (特記事項番号_113.equals(特記事項番号)) {
            builder.append(new RString("C3020-"));
        }
        builder.append(get特記事項2(特記事項番号));
        builder.append(get特記事項3(特記事項番号));
        builder.append(get特記事項4(特記事項番号, ninteiEntity));
        builder.append(get特記事項5(特記事項番号, ninteiEntity));
        builder.append(get特記事項6(特記事項番号, ninteiEntity));
        return builder.toRString();
    }

    private RString get特記事項2(RString 特記事項番号) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (特記事項番号_201.equals(特記事項番号)) {
            builder.append(new RString("C3021-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_202.equals(特記事項番号)) {
            builder.append(new RString("C3022-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_203.equals(特記事項番号)) {
            builder.append(new RString("C3023-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_204.equals(特記事項番号)) {
            builder.append(new RString("C3024-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_205.equals(特記事項番号)) {
            builder.append(new RString("C3025-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_206.equals(特記事項番号)) {
            builder.append(new RString("C3026-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_207.equals(特記事項番号)) {
            builder.append(new RString("C3027-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_208.equals(特記事項番号)) {
            builder.append(new RString("C3028-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_209.equals(特記事項番号)) {
            builder.append(new RString("C3029-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_210.equals(特記事項番号)) {
            builder.append(new RString("C3030-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_211.equals(特記事項番号)) {
            builder.append(new RString("C3031-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_212.equals(特記事項番号)) {
            builder.append(new RString("C3032-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_301.equals(特記事項番号)) {
            builder.append(new RString("C3033-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_302.equals(特記事項番号)) {
            builder.append(new RString("C3034-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_303.equals(特記事項番号)) {
            builder.append(new RString("C3035-"));
            imageName = builder.toRString();
        }
        return imageName;
    }

    private RString get特記事項3(RString 特記事項番号) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (特記事項番号_304.equals(特記事項番号)) {
            builder.append(new RString("C3036-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_305.equals(特記事項番号)) {
            builder.append(new RString("C3037-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_306.equals(特記事項番号)) {
            builder.append(new RString("C3038-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_307.equals(特記事項番号)) {
            builder.append(new RString("C3039-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_308.equals(特記事項番号)) {
            builder.append(new RString("C3040-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_309.equals(特記事項番号)) {
            builder.append(new RString("C3041-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_408.equals(特記事項番号)) {
            builder.append(new RString("C3049-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_409.equals(特記事項番号)) {
            builder.append(new RString("C3050-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_410.equals(特記事項番号)) {
            builder.append(new RString("C3051-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_411.equals(特記事項番号)) {
            builder.append(new RString("C3052-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_412.equals(特記事項番号)) {
            builder.append(new RString("C3053-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_413.equals(特記事項番号)) {
            builder.append(new RString("C3054-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_414.equals(特記事項番号)) {
            builder.append(new RString("C3055-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_415.equals(特記事項番号)) {
            builder.append(new RString("C3056-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_701.equals(特記事項番号)) {
            builder.append(new RString("C3075-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_702.equals(特記事項番号)) {
            builder.append(new RString("C3076-"));
            imageName = builder.toRString();
        }
        return imageName;
    }

    private RString get特記事項401(RString 特記事項番号, TokkiText1A4Entity ninteiEntity) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_401.equals(特記事項番号)) {
                builder.append(new RString("C3042-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_402.equals(特記事項番号)) {
                builder.append(new RString("C3043-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_403.equals(特記事項番号)) {
                builder.append(new RString("C3044-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_404.equals(特記事項番号)) {
                builder.append(new RString("C3045-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_405.equals(特記事項番号)) {
                builder.append(new RString("C3046-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_406.equals(特記事項番号)) {
                builder.append(new RString("C3047-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_407.equals(特記事項番号)) {
                builder.append(new RString("C3048-"));
                imageName = builder.toRString();
            }
        }
        return imageName;
    }

    private RString get特記事項4(RString 特記事項番号, TokkiText1A4Entity ninteiEntity) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        builder.append(get特記事項401(特記事項番号, ninteiEntity));
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_4011.equals(特記事項番号)) {
                builder.append(new RString("C3042-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_4012.equals(特記事項番号)) {
                builder.append(new RString("C3043-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_402.equals(特記事項番号)) {
                builder.append(new RString("C3044-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_403.equals(特記事項番号)) {
                builder.append(new RString("C3045-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_404.equals(特記事項番号)) {
                builder.append(new RString("C3046-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_406.equals(特記事項番号)) {
                builder.append(new RString("C3047-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_407.equals(特記事項番号)) {
                builder.append(new RString("C3048-"));
                imageName = builder.toRString();
            }
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_4011.equals(特記事項番号)) {
                builder.append(new RString("C3042-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_4012.equals(特記事項番号)) {
                builder.append(new RString("C3043-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_402.equals(特記事項番号)) {
                builder.append(new RString("C3044-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_403.equals(特記事項番号)) {
                builder.append(new RString("C3045-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_404.equals(特記事項番号)) {
                builder.append(new RString("C3046-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_405.equals(特記事項番号)) {
                builder.append(new RString("C3047-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_406.equals(特記事項番号)) {
                builder.append(new RString("C3048-"));
                imageName = builder.toRString();
            }
        }
        return imageName;
    }

    private RString get特記事項5(RString 特記事項番号, TokkiText1A4Entity ninteiEntity) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_501.equals(特記事項番号)) {
                builder.append(new RString("C3057-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_502.equals(特記事項番号)) {
                builder.append(new RString("C3058-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_503.equals(特記事項番号)) {
                builder.append(new RString("C3059-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_504.equals(特記事項番号)) {
                builder.append(new RString("C3060-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_505.equals(特記事項番号)) {
                builder.append(new RString("C3061-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_506.equals(特記事項番号)) {
                builder.append(new RString("C3062-"));
                imageName = builder.toRString();
            }
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_5011.equals(特記事項番号)) {
                builder.append(new RString("C3057-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_5012.equals(特記事項番号)) {
                builder.append(new RString("C3058-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_5013.equals(特記事項番号)) {
                builder.append(new RString("C3059-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_5014.equals(特記事項番号)) {
                builder.append(new RString("C3060-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_5021.equals(特記事項番号)) {
                builder.append(new RString("C3061-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_5022.equals(特記事項番号)) {
                builder.append(new RString("C3062-"));
                imageName = builder.toRString();
            }
        }
        return imageName;
    }

    private RString get特記事項601(RString 特記事項番号) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (特記事項番号_601.equals(特記事項番号)) {
            builder.append(new RString("C3063-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_602.equals(特記事項番号)) {
            builder.append(new RString("C3064-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_603.equals(特記事項番号)) {
            builder.append(new RString("C3065-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_604.equals(特記事項番号)) {
            builder.append(new RString("C3066-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_611.equals(特記事項番号)) {
            builder.append(new RString("C3073-"));
            imageName = builder.toRString();
        }
        if (特記事項番号_612.equals(特記事項番号)) {
            builder.append(new RString("C3074-"));
            imageName = builder.toRString();
        }
        return imageName;
    }

    private RString get特記事項6(RString 特記事項番号, TokkiText1A4Entity ninteiEntity) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        builder.append(get特記事項601(特記事項番号));
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_605.equals(特記事項番号)) {
                builder.append(new RString("C3067-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_606.equals(特記事項番号)) {
                builder.append(new RString("C3068-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_607.equals(特記事項番号)) {
                builder.append(new RString("C3069-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_608.equals(特記事項番号)) {
                builder.append(new RString("C3070-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_609.equals(特記事項番号)) {
                builder.append(new RString("C3071-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_610.equals(特記事項番号)) {
                builder.append(new RString("C3072-"));
                imageName = builder.toRString();
            }
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_6051.equals(特記事項番号)) {
                builder.append(new RString("C3067-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_6052.equals(特記事項番号)) {
                builder.append(new RString("C3068-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_6053.equals(特記事項番号)) {
                builder.append(new RString("C3069-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_6054.equals(特記事項番号)) {
                builder.append(new RString("C3070-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_6055.equals(特記事項番号)) {
                builder.append(new RString("C3071-"));
                imageName = builder.toRString();
            }
            if (特記事項番号_6056.equals(特記事項番号)) {
                builder.append(new RString("C3072-"));
                imageName = builder.toRString();
            }
        }
        return imageName;
    }

    private RString 共有ファイルを引き出す(RDateTime イメージID, RString 共有ファイル名) {
        if (イメージID != null) {
            ReadOnlySharedFileEntryDescriptor descriptor
                    = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(共有ファイル名), イメージID);
            try {
                return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(batchWrite.getImageFolderPath())).getCanonicalPath());
            } catch (Exception e) {
                return RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }

    private RString getImageFile_C0007(RString path) {
        RString fileName = フラグ.equals(processPrm.getRadTokkiJikoMasking()) ? C0007_FILENAME_BAK : C0007_FILENAME;
        RString fileFullPath = getFilePath(path, fileName);
        if (!RString.isNullOrEmpty(fileFullPath)) {
            return fileFullPath;
        }
        return RString.EMPTY;
    }

    private RString getImageFile_C410X(RString path, int i) {
        RStringBuilder imageFileName = new RStringBuilder();
        if (フラグ.equals(processPrm.getRadTokkiJikoMasking())) {
            imageFileName.append(FILENAME);
            imageFileName.append(i);
            imageFileName.append(拡張子_PNG);
        } else {
            imageFileName.append(FILENAME);
            imageFileName.append(i);
            imageFileName.append(BAK);
            imageFileName.append(拡張子_PNG);
        }
        RString fileFullPath = getFilePath(path, imageFileName.toRString());
        if (!RString.isNullOrEmpty(fileFullPath)) {
            return fileFullPath;
        }
        return RString.EMPTY;
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, ファイル名);
        }
        return RString.EMPTY;
    }

    private void set出力条件表() {
        List<RString> 出力条件 = new ArrayList();
        RStringBuilder builder = new RStringBuilder();
        builder.append(認定調査票チェックフラグ);
        builder.append(get帳票発行有無(processPrm.getChkNinteiChosahyo()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(特記事項チェックフラグ);
        builder.append(get帳票発行有無(processPrm.getChkTokkiJiko()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(主治医意見書チェックフラグ);
        builder.append(get帳票発行有無(processPrm.getChkShujiiIkensho()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(その他資料チェックフラグ);
        builder.append(get帳票発行有無(processPrm.getChkSonotaShiryo()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(一次判定結果チェックフラグ);
        builder.append(get帳票発行有無(processPrm.getChkIchijiHanteiKekka()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(総合事業開始区分);
        builder.append(get総合事業開始区分名称(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援)));
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

    private RString get帳票発行有無(RString 帳票発行フラグ) {
        if (帳票発行フラグ.equals(帳票発行有り)) {
            return 出力する;
        } else if (帳票発行フラグ.equals(帳票発行無し)) {
            return 出力しない;
        }
        return RString.EMPTY;
    }

    private RString get総合事業開始区分名称(RString 総合事業開始区分) {
        if (総合事業開始区分.equals(総合事業開始区分_未実施)) {
            return 総合事業未実施;
        } else if (総合事業開始区分.equals(総合事業開始区分_実施済)) {
            return 総合事業実施済;
        }
        return RString.EMPTY;
    }
}
