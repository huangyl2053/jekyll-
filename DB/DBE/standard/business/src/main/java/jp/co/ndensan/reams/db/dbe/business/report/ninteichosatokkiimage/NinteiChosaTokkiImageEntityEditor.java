/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinteichosaRelate;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokkiimage.NinteiChosaTokkiImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
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

/**
 * NinteiChosaTokkiImageEntityの編集クラスです。
 *
 * @author N3212 竹内 和紀
 */
public final class NinteiChosaTokkiImageEntityEditor {

    private static final RString マスキングあり = new RString("1");
    private static final int 連番23 = 23;
    private static final int 連番24 = 24;
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
    private static final int 最大共有ファイル下二桁 = 9;
    private static final RString C0007_FILENAME_BAK = new RString("C0007_BAK.png");
    private static final RString C0007_FILENAME = new RString("C0007.png");

    private NinteiChosaTokkiImageEntityEditor() {
    }

    /**
     * NinteiChosaTokkiImageEntityを編集します。
     *
     * @param yokaigoNinteiJohoTeikyoEntity YokaigoNinteiJohoTeikyoEntity
     * @param 特記事項List NinteichosaRelateのリスト
     * @param 特記事項マスキング区分 特記事項マスキング区分
     * @return NinteiChosaTokkiImageEntity
     */
    public static NinteiChosaTokkiImageEntity edit(YokaigoNinteiJohoTeikyoEntity yokaigoNinteiJohoTeikyoEntity,
            List<NinteichosaRelate> 特記事項List,
            RString 特記事項マスキング区分) {
        特記事項List = edit特記事項リスト(特記事項List);
        NinteiChosaTokkiImageEntity ninteiChosaTokkiImageEntity = new NinteiChosaTokkiImageEntity();
        setBodyItem(ninteiChosaTokkiImageEntity, yokaigoNinteiJohoTeikyoEntity, 特記事項List);
        ninteiChosaTokkiImageEntity.set特記事項リスト番号(set特記事項リスト1(特記事項List, yokaigoNinteiJohoTeikyoEntity));
        ninteiChosaTokkiImageEntity.set特記事項リスト連番(set特記事項リスト2(特記事項List));
        ninteiChosaTokkiImageEntity.set特記事項リスト名称(set特記事項リスト3(特記事項List, yokaigoNinteiJohoTeikyoEntity));
        set特記事項リスト4(ninteiChosaTokkiImageEntity, 特記事項List, yokaigoNinteiJohoTeikyoEntity, 特記事項マスキング区分);
        return ninteiChosaTokkiImageEntity;
    }

    private static void setBodyItem(NinteiChosaTokkiImageEntity ninteiChosaTokkiImageEntity,
            YokaigoNinteiJohoTeikyoEntity entity,
            List<NinteichosaRelate> 特記事項リスト) {
        ninteiChosaTokkiImageEntity.set保険者番号(entity.get保険者番号());
        ninteiChosaTokkiImageEntity.set被保険者番号(entity.get被保険者番号());
        ninteiChosaTokkiImageEntity.set被保険者氏名(entity.get被保険者氏名());
        ninteiChosaTokkiImageEntity.setTemp_保険者番号(entity.get保険者番号());
        ninteiChosaTokkiImageEntity.setTemp_被保険者番号(entity.get被保険者番号());
        ninteiChosaTokkiImageEntity.setTemp_申請書管理番号(entity.get申請書管理番号());
        ninteiChosaTokkiImageEntity.set申請日_元号(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiChosaTokkiImageEntity.set申請日_年(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiChosaTokkiImageEntity.set申請日_月(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiChosaTokkiImageEntity.set申請日_日(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiChosaTokkiImageEntity.set作成日_元号(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiChosaTokkiImageEntity.set作成日_年(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiChosaTokkiImageEntity.set作成日_月(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiChosaTokkiImageEntity.set作成日_日(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiChosaTokkiImageEntity.set調査日_元号(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiChosaTokkiImageEntity.set調査日_年(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiChosaTokkiImageEntity.set調査日_月(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiChosaTokkiImageEntity.set調査日_日(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiChosaTokkiImageEntity.set審査日_元号(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiChosaTokkiImageEntity.set審査日_年(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiChosaTokkiImageEntity.set審査日_月(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiChosaTokkiImageEntity.set審査日_日(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiChosaTokkiImageEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        int page = (特記事項リスト.size() + 連番23) / 連番24;
        ninteiChosaTokkiImageEntity.set総ページ数(new RString(page));
    }

    private static List<RString> set特記事項リスト1(List<NinteichosaRelate> 特記事項区分, YokaigoNinteiJohoTeikyoEntity entity) {
        List<RString> 特記事項リスト1 = new ArrayList<>();
        for (int i = 0; i < 特記事項区分.size(); i++) {
            特記事項リスト1.add(get特記事項番号(特記事項区分, i, entity));
        }
        return 特記事項リスト1;
    }

    private static List<RString> set特記事項リスト2(List<NinteichosaRelate> 特記事項区分) {
        List<RString> 特記事項リスト2 = new ArrayList<>();
        for (int i = 0; i < 特記事項区分.size(); i++) {
            特記事項リスト2.add(get特記事項連番(特記事項区分, i));
        }
        return 特記事項リスト2;
    }

    private static List<RString> set特記事項リスト3(List<NinteichosaRelate> 特記事項区分, YokaigoNinteiJohoTeikyoEntity entity) {
        List<RString> 特記事項リスト3 = new ArrayList<>();
        for (int i = 0; i < 特記事項区分.size(); i++) {
            特記事項リスト3.add(get特記事項名称(特記事項区分, i, entity));
        }
        return 特記事項リスト3;
    }

    private static void set特記事項リスト4(NinteiChosaTokkiImageEntity ninteiChosaTokkiImageEntity,
            List<NinteichosaRelate> 特記事項区分, YokaigoNinteiJohoTeikyoEntity entity, RString 特記事項マスキング区分) {
        List<RString> 特記事項リスト4 = new ArrayList<>();
        RString 共有ファイル名 = entity.get保険者番号().concat(entity.get被保険者番号());
        RString path = copySharedFiles(特記事項区分.get(0).getイメージID(), 共有ファイル名);
        set概況特記事項(ninteiChosaTokkiImageEntity, path, 特記事項マスキング区分);
        for (int i = 0; i < 特記事項区分.size(); i++) {
            RString fileName = get共有ファイル(get特記事項番号(特記事項区分, i), entity.get厚労省IF識別コード());
            int remban = Integer.parseInt(get特記事項連番(特記事項区分, i).toString());
            RString imageFileName = convertImageFileName(fileName, remban);
            RString currentFilefullPath = getFilePath(path, imageFileName);
            if (!RString.isNullOrEmpty(currentFilefullPath)) {
                boolean hasMask = !getFilePath(path, imageFileName.replace(拡張子_PNG.toString(), "_BAK.png")).isEmpty();
                if (マスキングあり.equals(特記事項マスキング区分) && hasMask) {
                    特記事項リスト4.add(currentFilefullPath);
                } else if (マスキングあり.equals(特記事項マスキング区分) && !hasMask) {
                    特記事項リスト4.add(RString.EMPTY);
                } else if (!マスキングあり.equals(特記事項マスキング区分) && hasMask) {
                    特記事項リスト4.add(currentFilefullPath.replace(拡張子_PNG.toString(), "_BAK.png"));
                } else if (!マスキングあり.equals(特記事項マスキング区分) && !hasMask) {
                    特記事項リスト4.add(currentFilefullPath);
                }
            }
//            RString fileFullPath = RString.EMPTY;
//            for (int currentNumber = 0; currentNumber <= 最大共有ファイル下二桁; currentNumber++) {
//                RString currentFileName = fileName.concat(new RString(String.format("%02d", currentNumber))).concat(拡張子_PNG);
//                RString currentFilefullPath = getFilePath(path, currentFileName);
//                if (!RString.isNullOrEmpty(currentFilefullPath)) {
//                    boolean hasMask = !getFilePath(path, currentFileName.replace(拡張子_PNG.toString(), "_BAK.png")).isEmpty();
//                    if (マスキングあり.equals(特記事項マスキング区分) && hasMask) {
//                        特記事項リスト4.add(currentFilefullPath);
//                    } else if (マスキングあり.equals(特記事項マスキング区分) && !hasMask) {
//                        特記事項リスト4.add(RString.EMPTY);
//                    } else if (!マスキングあり.equals(特記事項マスキング区分) && hasMask) {
//                        特記事項リスト4.add(currentFilefullPath.replace(拡張子_PNG.toString(), "_BAK.png"));
//                    } else if (!マスキングあり.equals(特記事項マスキング区分) && !hasMask) {
//                        特記事項リスト4.add(currentFilefullPath);
//                    }
//                }
//            }
//            if (!RString.isNullOrEmpty(fileFullPath)) {
//                if (!マスキングあり.equals(特記事項マスキング区分)) {
//                    特記事項リスト4.add(fileFullPath);
//                } else {
//                    特記事項リスト4.add(fileFullPath.replace(拡張子_PNG.toString(), "_BAK.png"));
//                }
//            }
        }
        ninteiChosaTokkiImageEntity.set特記事項リストイメージ(特記事項リスト4);
    }

    private static RString convertImageFileName(RString baseFileName, int remban) {
        int imageFileNameRemban = remban - 1;
        RStringBuilder imageFileName = new RStringBuilder(baseFileName);
        imageFileName.append(new RString(imageFileNameRemban).padZeroToLeft(2));
        imageFileName.append(拡張子_PNG);
        return imageFileName.toRString();
    }

    private static RString get特記事項番号(List<NinteichosaRelate> 特記事項区分, int 連番, YokaigoNinteiJohoTeikyoEntity entity) {
        RString 特記事項番号 = RString.EMPTY;
        if (連番 < 特記事項区分.size()) {
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード())) {
                NinteichosaKomoku09B 認定調査項目 = NinteichosaKomoku09B.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号());
                特記事項番号 = (!認定調査項目.equals(NinteichosaKomoku09B.その他特記事項)) ? 認定調査項目.get特記事項番号() : RString.EMPTY;
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(entity.get厚労省IF識別コード())) {
                NinteichosaKomoku09A 認定調査項目 = NinteichosaKomoku09A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号());
                特記事項番号 = (!認定調査項目.equals(NinteichosaKomoku09A.その他特記事項)) ? 認定調査項目.get特記事項番号() : RString.EMPTY;
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.get厚労省IF識別コード())) {
                NinteichosaKomoku06A 認定調査項目 = NinteichosaKomoku06A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号());
                特記事項番号 = (!認定調査項目.equals(NinteichosaKomoku06A.その他特記事項)) ? 認定調査項目.get特記事項番号() : RString.EMPTY;
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.get厚労省IF識別コード())) {
                NinteichosaKomoku02A 認定調査項目 = NinteichosaKomoku02A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号());
                特記事項番号 = (!認定調査項目.equals(NinteichosaKomoku02A.その他特記事項)) ? 認定調査項目.get特記事項番号() : RString.EMPTY;
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.get厚労省IF識別コード())) {
                NinteichosaKomoku99A 認定調査項目 = NinteichosaKomoku99A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号());
                特記事項番号 = (!認定調査項目.equals(NinteichosaKomoku99A.その他特記事項)) ? 認定調査項目.get特記事項番号() : RString.EMPTY;
            }
        }
        return 特記事項番号;
    }

    private static RString get特記事項番号(List<NinteichosaRelate> 特記事項, int 連番) {
        if (連番 < 特記事項.size()) {
            if (RString.isNullOrEmpty(特記事項.get(連番).get特記事項番号())) {
                return RString.EMPTY;
            }
            return 特記事項.get(連番).get特記事項番号();
        }
        return RString.EMPTY;
    }

    private static RString get特記事項連番(List<NinteichosaRelate> 特記事項, int 連番) {
        if (連番 < 特記事項.size()) {
            if (RString.isNullOrEmpty(特記事項.get(連番).get特記事項連番())) {
                return RString.EMPTY;
            }
            return 特記事項.get(連番).get特記事項連番();
        }
        return RString.EMPTY;
    }

    private static RString get特記事項名称(List<NinteichosaRelate> 特記事項区分, int 連番, YokaigoNinteiJohoTeikyoEntity entity) {
        RString 名称 = RString.EMPTY;
        if (連番 < 特記事項区分.size()) {
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード())) {
                名称 = NinteichosaKomoku09B.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get帳票印字用名称();
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(entity.get厚労省IF識別コード())) {
                名称 = NinteichosaKomoku09A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get帳票印字用名称();
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.get厚労省IF識別コード())) {
                名称 = NinteichosaKomoku06A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get帳票印字用名称();
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.get厚労省IF識別コード())) {
                名称 = NinteichosaKomoku02A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get帳票印字用名称();
            }
            if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                    && KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.get厚労省IF識別コード())) {
                名称 = NinteichosaKomoku99A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get帳票印字用名称();
            }
        }
        return 名称;
    }

    private static void set概況特記事項(NinteiChosaTokkiImageEntity ninteiChosaTokkiImageEntity,
            RString path, RString 特記事項マスキング区分) {
        Boolean hasImage = !getFilePath(path, C0007_FILENAME).isEmpty();
        Boolean hasImageMask = !getFilePath(path, C0007_FILENAME_BAK).isEmpty();
        ninteiChosaTokkiImageEntity.set概況特記事項テキスト(RString.EMPTY);
        if (!hasImage) {
            ninteiChosaTokkiImageEntity.set概況特記事項イメージ(RString.EMPTY);
            return;
        }
        if (マスキングあり.equals(特記事項マスキング区分)) {
            if (hasImageMask) {
                ninteiChosaTokkiImageEntity.set概況特記事項イメージ(getFilePath(path, C0007_FILENAME));
            } else {
                ninteiChosaTokkiImageEntity.set概況特記事項イメージ(RString.EMPTY);
            }
        } else {
            if (hasImageMask) {
                ninteiChosaTokkiImageEntity.set概況特記事項イメージ(getFilePath(path, C0007_FILENAME_BAK));
            } else {
                ninteiChosaTokkiImageEntity.set概況特記事項イメージ(getFilePath(path, C0007_FILENAME));
            }
        }
//
//        RString fileName = マスキングあり.equals(特記事項マスキング区分) ? C0007_FILENAME_BAK : C0007_FILENAME;
//        RString 概況特記イメージPath = getFilePath(path, fileName);
//        if (RString.isNullOrEmpty(概況特記イメージPath)) {
//            ninteiChosaTokkiImageEntity.set概況特記事項イメージ(RString.EMPTY);
//            ninteiChosaTokkiImageEntity.set概況特記事項テキスト(entity.get概況調査特記事項());
//        } else {
//            ninteiChosaTokkiImageEntity.set概況特記事項イメージ(概況特記イメージPath);
//            ninteiChosaTokkiImageEntity.set概況特記事項テキスト(RString.EMPTY);
//        }
    }

    private static RDateTime getイメージID(List<NinteichosaRelate> 特記事項, int 連番) {
        if (連番 < 特記事項.size()) {
            if (特記事項.get(連番).getイメージID() == null) {
                return RDateTime.MIN;
            }
            return 特記事項.get(連番).getイメージID();
        }
        return RDateTime.MIN;
    }

    private static RString copySharedFiles(RDateTime イメージID, RString 共有ファイル名) {
        if (イメージID != null) {
            RString 出力イメージフォルダパス = Directory.createTmpDirectory();
            ReadOnlySharedFileEntryDescriptor descriptor
                    = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(共有ファイル名), イメージID);
            try {
                return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(出力イメージフォルダパス)).getCanonicalPath());
            } catch (Exception e) {
                return RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }

    private static RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, ファイル名);
        }
        return RString.EMPTY;
    }

    private static RString get共有ファイル(RString 特記事項番号, RString 厚労省IF識別コード) {
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
        builder.append(get特記事項4(特記事項番号, 厚労省IF識別コード));
        builder.append(get特記事項5(特記事項番号, 厚労省IF識別コード));
        builder.append(get特記事項6(特記事項番号, 厚労省IF識別コード));
        return builder.toRString();
    }

    private static RString get特記事項2(RString 特記事項番号) {
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

    private static RString get特記事項3(RString 特記事項番号) {
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

    private static RString get特記事項4(RString 特記事項番号, RString 厚労省IF識別コード) {
        RString imageName = get特記事項401(特記事項番号, 厚労省IF識別コード);
        RStringBuilder builder = new RStringBuilder();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
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
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
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

    private static RString get特記事項401(RString 特記事項番号, RString 厚労省IF識別コード) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
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

    private static RString get特記事項5(RString 特記事項番号, RString 厚労省IF識別コード) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
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
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
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

    private static RString get特記事項6(RString 特記事項番号, RString 厚労省IF識別コード) {
        RString imageName = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        builder.append(get特記事項601(特記事項番号));
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
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
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
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

    private static RString get特記事項601(RString 特記事項番号) {
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

    private static List<NinteichosaRelate> edit特記事項リスト(List<NinteichosaRelate> 特記事項List) {
        List<NinteichosaRelate> その他特記事項リスト = new ArrayList<>();
        for (NinteichosaRelate 特記事項 : 特記事項List) {
            if (特記事項.get特記事項番号().equals(NinteichosaKomoku09B.その他特記事項.get調査特記事項番序())) {
                その他特記事項リスト.add(特記事項);
            }
        }
        for (NinteichosaRelate その他特記事項 : その他特記事項リスト) {
            特記事項List.remove(その他特記事項);
            特記事項List.add(その他特記事項);
        }
        return 特記事項List;
    }
}
