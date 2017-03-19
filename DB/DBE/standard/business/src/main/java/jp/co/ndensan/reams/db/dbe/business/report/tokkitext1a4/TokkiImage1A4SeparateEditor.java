/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinteichosaRelate;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiTextEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
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
 * 特記事項(短冊)用のTokkiText1A4Entity編集クラスです。
 *
 * @author N3212 竹内 和紀
 */
public final class TokkiImage1A4SeparateEditor {

    private static final RString マスキングあり = new RString("1");
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

    private TokkiImage1A4SeparateEditor() {
    }

    /**
     * TokkiText1A4Entityを編集します。
     *
     * @param yokaigoNinteiJohoTeikyoEntity YokaigoNinteiJohoTeikyoEntity
     * @param 特記事項List NinteichosaRelateのリスト
     * @param 特記事項マスキング区分 特記事項マスキング区分
     * @param イメージID RDateTime
     * @return TokkiText1A4Entity
     */
    public static TokkiText1A4Entity edit(YokaigoNinteiJohoTeikyoEntity yokaigoNinteiJohoTeikyoEntity,
            List<NinteichosaRelate> 特記事項List,
            RString 特記事項マスキング区分,
            RDateTime イメージID) {
        特記事項List = edit特記事項リスト(特記事項List);
        TokkiText1A4Entity ninteiEntity = new TokkiText1A4Entity();
        if (!マスキングあり.equals(特記事項マスキング区分)) {
            ninteiEntity.set保険者番号(yokaigoNinteiJohoTeikyoEntity.get保険者番号());
            ninteiEntity.set被保険者番号(yokaigoNinteiJohoTeikyoEntity.get被保険者番号());
            ninteiEntity.set被保険者氏名(yokaigoNinteiJohoTeikyoEntity.get被保険者氏名());
        }
        ninteiEntity.set概況調査特記事項(yokaigoNinteiJohoTeikyoEntity.get概況調査特記事項());
        ninteiEntity.set厚労省IF識別コード(yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード());
        ninteiEntity.set申請日_元号(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get認定申請年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiEntity.set申請日_年(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get認定申請年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiEntity.set申請日_月(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get認定申請年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiEntity.set申請日_日(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get認定申請年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiEntity.set作成日_元号(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiEntity.set作成日_年(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiEntity.set作成日_月(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiEntity.set作成日_日(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiEntity.set調査日_元号(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get実施年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiEntity.set調査日_年(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get実施年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiEntity.set調査日_月(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get実施年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiEntity.set調査日_日(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get実施年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiEntity.set審査日_元号(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get審査会開催日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiEntity.set審査日_年(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get審査会開催日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiEntity.set審査日_月(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get審査会開催日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiEntity.set審査日_日(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get審査会開催日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiEntity.set厚労省IF識別コード(yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード());
        setBodyItem_Sub(yokaigoNinteiJohoTeikyoEntity, 特記事項List, ninteiEntity, 特記事項マスキング区分, イメージID);
        return ninteiEntity;
    }

    private static TokkiText1A4Entity setBodyItem_Sub(YokaigoNinteiJohoTeikyoEntity yokaigoNinteiJohoTeikyoEntity,
            List<NinteichosaRelate> entity, TokkiText1A4Entity ninteiEntity, RString 特記事項マスキング区分, RDateTime イメージID) {
        List<TokkiTextEntity> 特記事項List = new ArrayList<>();
        List<TokkiTextEntity> 特記事項番号リスト = new ArrayList<>();
        List<TokkiTextEntity> イメージリスト = new ArrayList<>();
        List<TokkiTextEntity> 全イメージリスト = new ArrayList<>();
        RString 共有ファイル名 = yokaigoNinteiJohoTeikyoEntity.get保険者番号().concat(yokaigoNinteiJohoTeikyoEntity.get被保険者番号());
        RString path = copySharedFiles(イメージID, 共有ファイル名);
        ninteiEntity.set概況調査特記事項イメージ(getImageFile_C0007(path, 特記事項マスキング区分));
        for (int i = 0; i < entity.size(); i++) {
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(entity.get(i).get特記事項区分())) {
                TokkiTextEntity tokki = new TokkiTextEntity();
                tokki.set特記事項(entity.get(i).get特記事項());
                tokki.set特記事項番号(get特記事項番号(entity, i, ninteiEntity));
                tokki.set特記事項名称(get特記事項名称(entity, i, ninteiEntity));
                tokki.set特記事項連番(entity.get(i).get特記事項連番());
                RString fileName = get共有ファイル(entity.get(i).get特記事項番号(), ninteiEntity);
//                RString fileFullPath = RString.EMPTY;
//                for (int currentNumber = 0; currentNumber <= 最大共有ファイル下二桁; currentNumber++) {
                RString currentFileName
                        = fileName.concat(new RString(String.format("%02d", Integer.parseInt(entity.get(i).get特記事項連番().toString()) - 1))).concat(拡張子_PNG);
                RString currentFilefullPath = getFilePath(path, currentFileName);
                if (!RString.isNullOrEmpty(currentFilefullPath)) {
                    boolean hasMask = !getFilePath(path, currentFileName.replace(拡張子_PNG.toString(), "_BAK.png")).isEmpty();
                    if (マスキングあり.equals(特記事項マスキング区分) && hasMask) {
                        tokki.set特記事項イメージ(currentFilefullPath);
                    } else if (マスキングあり.equals(特記事項マスキング区分) && !hasMask) {
                        tokki.set特記事項イメージ(RString.EMPTY);
                        continue;
                    } else if (!マスキングあり.equals(特記事項マスキング区分) && hasMask) {
                        tokki.set特記事項イメージ(currentFilefullPath.replace(拡張子_PNG.toString(), "_BAK.png"));
                    } else if (!マスキングあり.equals(特記事項マスキング区分) && !hasMask) {
                        tokki.set特記事項イメージ(currentFilefullPath);
                    }
//                        fileFullPath = currentFilefullPath;
//                        break;
                } else {
                    tokki.set特記事項イメージ(RString.EMPTY);
                    continue;
                }
//                }
//                if (!RString.isNullOrEmpty(fileFullPath)) {
//                    tokki.set特記事項イメージ(fileFullPath);
//                } else {
//                    tokki.set特記事項イメージ(RString.EMPTY);
//                }
                イメージリスト.add(tokki);
            }
        }
        ninteiEntity.set特記事項リスト(特記事項List);
        ninteiEntity.set特記事項番号リスト(特記事項番号リスト);
        ninteiEntity.set特記事項イメージリスト(イメージリスト);
        ninteiEntity.set特記事項全イメージリスト(全イメージリスト);
        return ninteiEntity;
    }

    private static RString get特記事項番号(List<NinteichosaRelate> 特記事項区分, int 連番, TokkiText1A4Entity ninteiEntity) {
        RString 特記事項番号 = RString.EMPTY;
        if (連番 < 特記事項区分.size()) {
            try {
                if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                    NinteichosaKomoku09B 認定調査項目 = NinteichosaKomoku09B.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号());
                    特記事項番号 = (!認定調査項目.equals(NinteichosaKomoku09B.その他特記事項)) ? 認定調査項目.get特記事項番号() : RString.EMPTY;
                }
                if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                    NinteichosaKomoku09A 認定調査項目 = NinteichosaKomoku09A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号());
                    特記事項番号 = (!認定調査項目.equals(NinteichosaKomoku09A.その他特記事項)) ? 認定調査項目.get特記事項番号() : RString.EMPTY;
                }
                if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                    NinteichosaKomoku06A 認定調査項目 = NinteichosaKomoku06A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号());
                    特記事項番号 = (!認定調査項目.equals(NinteichosaKomoku06A.その他特記事項)) ? 認定調査項目.get特記事項番号() : RString.EMPTY;
                }
                if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                    NinteichosaKomoku02A 認定調査項目 = NinteichosaKomoku02A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号());
                    特記事項番号 = (!認定調査項目.equals(NinteichosaKomoku02A.その他特記事項)) ? 認定調査項目.get特記事項番号() : RString.EMPTY;
                }
                if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                    NinteichosaKomoku99A 認定調査項目 = NinteichosaKomoku99A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号());
                    特記事項番号 = (!認定調査項目.equals(NinteichosaKomoku99A.その他特記事項)) ? 認定調査項目.get特記事項番号() : RString.EMPTY;
                }
            } catch (IllegalArgumentException ex) {
                特記事項番号 = RString.EMPTY;
            }
        }
        return 特記事項番号;
    }

    private static RString get特記事項名称(List<NinteichosaRelate> 特記事項区分, int 連番, TokkiText1A4Entity ninteiEntity) {
        RString 名称 = RString.EMPTY;
        if (連番 < 特記事項区分.size()) {
            try {
                if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                    名称 = NinteichosaKomoku09B.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get帳票印字用名称();
                }
                if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                    名称 = NinteichosaKomoku09A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get帳票印字用名称();
                }
                if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                    名称 = NinteichosaKomoku06A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get帳票印字用名称();
                }
                if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                    名称 = NinteichosaKomoku02A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get帳票印字用名称();
                }
                if (!RString.isNullOrEmpty(特記事項区分.get(連番).get特記事項番号())
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(ninteiEntity.get厚労省IF識別コード())) {
                    名称 = NinteichosaKomoku99A.getAllBy調査特記事項番(特記事項区分.get(連番).get特記事項番号()).get帳票印字用名称();
                }
            } catch (IllegalArgumentException ex) {
                名称 = RString.EMPTY;
            }
        }
        return 名称;
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

    private static RString getImageFile_C0007(RString path, RString 特記事項マスキング区分) {
        Boolean hasImage = !getFilePath(path, C0007_FILENAME).isEmpty();
        Boolean hasImageMask = !getFilePath(path, C0007_FILENAME_BAK).isEmpty();
        if (!hasImage) {
            return RString.EMPTY;
        }
        if (マスキングあり.equals(特記事項マスキング区分)) {
            if (hasImageMask) {
                return getFilePath(path, C0007_FILENAME);
            } else {
                return RString.EMPTY;
            }
        } else {
            if (hasImageMask) {
                return getFilePath(path, C0007_FILENAME_BAK);
            } else {
                return getFilePath(path, C0007_FILENAME);
            }
        }
//        RString fileName = マスキングあり.equals(特記事項マスキング区分) ? C0007_FILENAME_BAK : C0007_FILENAME;
//        RString fileFullPath = getFilePath(path, fileName);
//        if (!RString.isNullOrEmpty(fileFullPath)) {
//            return fileFullPath;
//        }
//        return RString.EMPTY;
    }

    private static RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, ファイル名);
        }
        return RString.EMPTY;
    }

    private static RString get共有ファイル(RString 特記事項番号, TokkiText1A4Entity ninteiEntity) {
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

    private static RString get特記事項4(RString 特記事項番号, TokkiText1A4Entity ninteiEntity) {
        RString imageName = get特記事項401(特記事項番号, ninteiEntity);
        RStringBuilder builder = new RStringBuilder();
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

    private static RString get特記事項401(RString 特記事項番号, TokkiText1A4Entity ninteiEntity) {
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

    private static RString get特記事項5(RString 特記事項番号, TokkiText1A4Entity ninteiEntity) {
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

    private static RString get特記事項6(RString 特記事項番号, TokkiText1A4Entity ninteiEntity) {
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
