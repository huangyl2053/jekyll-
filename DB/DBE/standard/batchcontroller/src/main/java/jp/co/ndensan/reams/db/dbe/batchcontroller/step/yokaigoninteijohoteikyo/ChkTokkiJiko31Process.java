/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.yokaigoninteijohoteikyo;

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
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;

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
    private static final RString FILENAME_BAK = new RString("C4101_BAK.png");
    private static final RString FILENAME = new RString("C4101.png");
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString フラグ = new RString("1");
    private static final RString 認定調査票チェックフラグ = new RString("【認定調査票チェックフラグ】");
    private static final RString 特記事項チェックフラグ = new RString("【特記事項チェックフラグ】");
    private static final RString 主治医意見書チェックフラグ = new RString("【主治医意見書チェックフラグ】");
    private static final RString その他資料チェックフラグ = new RString("【その他資料チェックフラグ】");
    private static final RString 一次判定結果チェックフラグ = new RString("【一次判定結果チェックフラグ】");
    private static final RString 総合事業開始区分 = new RString("【総合事業開始区分】");
    private static final RString 全イメージ = new RString("2");
    private static final RString 短冊 = new RString("3");
    private static final RString すべて = new RString("1");
    private static final RString 一つずつ = new RString("3");
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
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517131.getReportId().value()).create();
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
        ninteiEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        setBodyItem01(特記事項リスト, ninteiEntity);
        return ninteiEntity;
    }

    private TokkiText1A4Entity setBodyItem01(List<NinteichosaRelateEntity> entity, TokkiText1A4Entity ninteiEntity) {
        List<TokkiTextEntity> 特記事項List = new ArrayList<>();
        List<TokkiTextEntity> 特記事項番号リスト = new ArrayList<>();
        List<TokkiTextEntity> イメージリスト = new ArrayList<>();
        for (int i = 0; i < entity.size(); i++) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.get(i).get特記事項区分())
                    && すべて.equals(DbBusinessConfig.get(ConfigNameDBE.特記事項編集, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                TokkiTextEntity tokki = new TokkiTextEntity();
                tokki.set特記事項(entity.get(i).get特記事項());
                tokki.set特記事項番号(entity.get(i).get特記事項番号());
                tokki.set特記事項名称(get特記事項名称(entity, i, ninteiEntity));
                tokki.set特記事項連番(entity.get(i).get特記事項連番());
                特記事項List.add(tokki);
            }
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.get(i).get特記事項区分())
                    && 一つずつ.equals(DbBusinessConfig.get(ConfigNameDBE.特記事項編集, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                TokkiTextEntity tokki = new TokkiTextEntity();
                tokki.set特記事項(entity.get(i).get特記事項());
                tokki.set特記事項番号(entity.get(i).get特記事項番号());
                tokki.set特記事項名称(get特記事項名称(entity, i, ninteiEntity));
                tokki.set特記事項連番(entity.get(i).get特記事項連番());
                特記事項番号リスト.add(tokki);
            }
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(entity.get(i).get特記事項区分())
                    && 全イメージ.equals(DbBusinessConfig.get(ConfigNameDBE.特記事項イメージ, RDate.getNowDate(),
                                    SubGyomuCode.DBE認定支援))) {
                RDateTime イメージID = mapper.getイメージ(processPrm.toYokaigoBatchMybitisParamter());
                ninteiEntity.set特記事項イメージ(共有ファイルを引き出す(イメージID));
            }
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(entity.get(i).get特記事項区分())
                    && 短冊.equals(DbBusinessConfig.get(ConfigNameDBE.特記事項イメージ, RDate.getNowDate(),
                                    SubGyomuCode.DBE認定支援))) {
                TokkiTextEntity tokki = new TokkiTextEntity();
                tokki.set特記事項(entity.get(i).get特記事項());
                tokki.set特記事項番号(entity.get(i).get特記事項番号());
                tokki.set特記事項名称(get特記事項名称(entity, i, ninteiEntity));
                tokki.set特記事項連番(entity.get(i).get特記事項連番());
                tokki.set特記事項イメージ(get共有ファイルを引き出す(entity.get(i).getイメージID(),
                        entity.get(i).get特記事項番号(), entity.get(i).get特記事項連番(), ninteiEntity));
                イメージリスト.add(tokki);
            }
        }
        ninteiEntity.set特記事項リスト(特記事項List);
        ninteiEntity.set特記事項番号リスト(特記事項番号リスト);
        ninteiEntity.set特記事項イメージリスト(イメージリスト);
        return ninteiEntity;
    }

    private RString get共有ファイルを引き出す(RDateTime イメージID, RString 特記事項番号, RString 特記事項連番, TokkiText1A4Entity ninteiEntity) {
        RString imagePath = RString.EMPTY;
        RString fileName = get共有ファイル(特記事項番号, 特記事項連番, ninteiEntity);
        if (イメージID != null && !RString.isNullOrEmpty(fileName)) {
            if (フラグ.equals(processPrm.getRadTokkiJikoMasking())) {
                imagePath = getFilePath(イメージID, fileName);
            } else {
                imagePath = getFilePathBak(イメージID, fileName.replace(".png", "_BAK.png"));
            }
        }
        return imagePath;
    }

    private RString get共有ファイル(RString 特記事項番号, RString 特記事項連番, TokkiText1A4Entity ninteiEntity) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (特記事項番号_101.equals(特記事項番号)) {
            builder.append(new RString("C3001-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_102.equals(特記事項番号)) {
            builder.append(new RString("C3006-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_103.equals(特記事項番号)) {
            builder.append(new RString("C3010-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_104.equals(特記事項番号)) {
            builder.append(new RString("C3011-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_105.equals(特記事項番号)) {
            builder.append(new RString("C3012-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_106.equals(特記事項番号)) {
            builder.append(new RString("C3013-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_107.equals(特記事項番号)) {
            builder.append(new RString("C3014-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_108.equals(特記事項番号)) {
            builder.append(new RString("C3015-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_109.equals(特記事項番号)) {
            builder.append(new RString("C3016-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_110.equals(特記事項番号)) {
            builder.append(new RString("C3017-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_111.equals(特記事項番号)) {
            builder.append(new RString("C3018-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_112.equals(特記事項番号)) {
            builder.append(new RString("C3019-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_113.equals(特記事項番号)) {
            builder.append(new RString("C3020-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        builder.append(get特記事項2(特記事項番号, 特記事項連番));
        builder.append(get特記事項3(特記事項番号, 特記事項連番));
        builder.append(get特記事項4(特記事項番号, 特記事項連番, ninteiEntity));
        builder.append(get特記事項5(特記事項番号, 特記事項連番, ninteiEntity));
        builder.append(get特記事項6(特記事項番号, 特記事項連番, ninteiEntity));
        return imageName;
    }

    private RString get特記事項2(RString 特記事項番号, RString 特記事項連番) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (特記事項番号_201.equals(特記事項番号)) {
            builder.append(new RString("C3021-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_202.equals(特記事項番号)) {
            builder.append(new RString("C3022-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_203.equals(特記事項番号)) {
            builder.append(new RString("C3023-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_204.equals(特記事項番号)) {
            builder.append(new RString("C3024-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_205.equals(特記事項番号)) {
            builder.append(new RString("C3025-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_206.equals(特記事項番号)) {
            builder.append(new RString("C3026-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_207.equals(特記事項番号)) {
            builder.append(new RString("C3027-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_208.equals(特記事項番号)) {
            builder.append(new RString("C3028-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_209.equals(特記事項番号)) {
            builder.append(new RString("C3029-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_210.equals(特記事項番号)) {
            builder.append(new RString("C3030-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_211.equals(特記事項番号)) {
            builder.append(new RString("C3031-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_212.equals(特記事項番号)) {
            builder.append(new RString("C3032-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_301.equals(特記事項番号)) {
            builder.append(new RString("C3033-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_302.equals(特記事項番号)) {
            builder.append(new RString("C3034-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_303.equals(特記事項番号)) {
            builder.append(new RString("C3035-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        return imageName;
    }

    private RString get特記事項3(RString 特記事項番号, RString 特記事項連番) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (特記事項番号_304.equals(特記事項番号)) {
            builder.append(new RString("C3036-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_305.equals(特記事項番号)) {
            builder.append(new RString("C3037-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_306.equals(特記事項番号)) {
            builder.append(new RString("C3038-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_307.equals(特記事項番号)) {
            builder.append(new RString("C3039-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_308.equals(特記事項番号)) {
            builder.append(new RString("C3040-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_309.equals(特記事項番号)) {
            builder.append(new RString("C3041-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_408.equals(特記事項番号)) {
            builder.append(new RString("C3049-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_409.equals(特記事項番号)) {
            builder.append(new RString("C3050-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_410.equals(特記事項番号)) {
            builder.append(new RString("C3051-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_411.equals(特記事項番号)) {
            builder.append(new RString("C3052-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_412.equals(特記事項番号)) {
            builder.append(new RString("C3053-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_413.equals(特記事項番号)) {
            builder.append(new RString("C3054-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_414.equals(特記事項番号)) {
            builder.append(new RString("C3055-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_415.equals(特記事項番号)) {
            builder.append(new RString("C3056-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_701.equals(特記事項番号)) {
            builder.append(new RString("C3075-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_702.equals(特記事項番号)) {
            builder.append(new RString("C3076-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        return imageName;
    }

    private RString get特記事項401(RString 特記事項番号, RString 特記事項連番, TokkiText1A4Entity ninteiEntity) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_401.equals(特記事項番号)) {
                builder.append(new RString("C3042-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_402.equals(特記事項番号)) {
                builder.append(new RString("C3043-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_403.equals(特記事項番号)) {
                builder.append(new RString("C3044-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_404.equals(特記事項番号)) {
                builder.append(new RString("C3045-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_405.equals(特記事項番号)) {
                builder.append(new RString("C3046-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_406.equals(特記事項番号)) {
                builder.append(new RString("C3047-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_407.equals(特記事項番号)) {
                builder.append(new RString("C3048-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
        }
        return imageName;
    }

    private RString get特記事項4(RString 特記事項番号, RString 特記事項連番, TokkiText1A4Entity ninteiEntity) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        builder.append(get特記事項401(特記事項番号, 特記事項連番, ninteiEntity));
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_4011.equals(特記事項番号)) {
                builder.append(new RString("C3042-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_4012.equals(特記事項番号)) {
                builder.append(new RString("C3043-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_402.equals(特記事項番号)) {
                builder.append(new RString("C3044-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_403.equals(特記事項番号)) {
                builder.append(new RString("C3045-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_404.equals(特記事項番号)) {
                builder.append(new RString("C3046-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_406.equals(特記事項番号)) {
                builder.append(new RString("C3047-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_407.equals(特記事項番号)) {
                builder.append(new RString("C3048-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_4011.equals(特記事項番号)) {
                builder.append(new RString("C3042-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_4012.equals(特記事項番号)) {
                builder.append(new RString("C3043-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_402.equals(特記事項番号)) {
                builder.append(new RString("C3044-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_403.equals(特記事項番号)) {
                builder.append(new RString("C3045-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_404.equals(特記事項番号)) {
                builder.append(new RString("C3046-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_405.equals(特記事項番号)) {
                builder.append(new RString("C3047-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_406.equals(特記事項番号)) {
                builder.append(new RString("C3048-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
        }
        return imageName;
    }

    private RString get特記事項5(RString 特記事項番号, RString 特記事項連番, TokkiText1A4Entity ninteiEntity) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_501.equals(特記事項番号)) {
                builder.append(new RString("C3057-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_502.equals(特記事項番号)) {
                builder.append(new RString("C3058-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_503.equals(特記事項番号)) {
                builder.append(new RString("C3059-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_504.equals(特記事項番号)) {
                builder.append(new RString("C3060-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_505.equals(特記事項番号)) {
                builder.append(new RString("C3061-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_506.equals(特記事項番号)) {
                builder.append(new RString("C3062-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_5011.equals(特記事項番号)) {
                builder.append(new RString("C3057-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_5012.equals(特記事項番号)) {
                builder.append(new RString("C3058-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_5013.equals(特記事項番号)) {
                builder.append(new RString("C3059-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_5014.equals(特記事項番号)) {
                builder.append(new RString("C3060-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_5021.equals(特記事項番号)) {
                builder.append(new RString("C3061-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_5022.equals(特記事項番号)) {
                builder.append(new RString("C3062-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
        }
        return imageName;
    }

    private RString get特記事項601(RString 特記事項番号, RString 特記事項連番) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (特記事項番号_601.equals(特記事項番号)) {
            builder.append(new RString("C3063-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_602.equals(特記事項番号)) {
            builder.append(new RString("C3064-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_603.equals(特記事項番号)) {
            builder.append(new RString("C3065-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_604.equals(特記事項番号)) {
            builder.append(new RString("C3066-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_611.equals(特記事項番号)) {
            builder.append(new RString("C3073-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        if (特記事項番号_612.equals(特記事項番号)) {
            builder.append(new RString("C3074-"));
            builder.append(特記事項連番);
            imageName = builder.toRString();
        }
        return imageName;
    }

    private RString get特記事項6(RString 特記事項番号, RString 特記事項連番, TokkiText1A4Entity ninteiEntity) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        builder.append(get特記事項601(特記事項番号, 特記事項連番));
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(ninteiEntity.get厚労省IF識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_605.equals(特記事項番号)) {
                builder.append(new RString("C3067-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_606.equals(特記事項番号)) {
                builder.append(new RString("C3068-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_607.equals(特記事項番号)) {
                builder.append(new RString("C3069-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_608.equals(特記事項番号)) {
                builder.append(new RString("C3070-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_609.equals(特記事項番号)) {
                builder.append(new RString("C3071-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_610.equals(特記事項番号)) {
                builder.append(new RString("C3072-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
            if (特記事項番号_6051.equals(特記事項番号)) {
                builder.append(new RString("C3067-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_6052.equals(特記事項番号)) {
                builder.append(new RString("C3068-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_6053.equals(特記事項番号)) {
                builder.append(new RString("C3069-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_6054.equals(特記事項番号)) {
                builder.append(new RString("C3070-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_6055.equals(特記事項番号)) {
                builder.append(new RString("C3071-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
            if (特記事項番号_6056.equals(特記事項番号)) {
                builder.append(new RString("C3072-"));
                builder.append(特記事項連番);
                imageName = builder.toRString();
            }
        }
        return imageName;
    }

    private RString 共有ファイルを引き出す(RDateTime イメージID) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            if (フラグ.equals(processPrm.getRadTokkiJikoMasking())) {
                imagePath = getFilePath(イメージID, FILENAME);
            } else {
                imagePath = getFilePathBak(イメージID, FILENAME_BAK);
            }
        }
        return imagePath;
    }

    private RString getFilePathBak(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        } catch (Exception e) {
            return RString.EMPTY;
        }
        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        ReadOnlySharedFileEntryDescriptor descriptor_BAK
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName.replace(".png", "_BAK.png")), sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        } catch (Exception e) {
            try {
                SharedFile.copyToLocal(descriptor_BAK, new FilesystemPath(imagePath));
                return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName.replace(".png", "_BAK.png"));
            } catch (Exception ex) {
                return RString.EMPTY;
            }
        }
        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
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
