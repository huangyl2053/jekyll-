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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項(１つずつ)用のTokkiText1A4Entity編集クラスです。
 *
 * @author N3212 竹内 和紀
 */
public final class TokkiText1A4SeparateEditor {

    private static final RString マスキングあり = new RString("1");

    private TokkiText1A4SeparateEditor() {
    }

    /**
     * TokkiText1A4Entityを編集します。
     *
     * @param yokaigoNinteiJohoTeikyoEntity YokaigoNinteiJohoTeikyoEntity
     * @param 特記事項List NinteichosaRelateのリスト
     * @param 特記事項マスキング区分 特記事項マスキング区分
     * @return TokkiText1A4Entity
     */
    public static TokkiText1A4Entity edit(YokaigoNinteiJohoTeikyoEntity yokaigoNinteiJohoTeikyoEntity,
            List<NinteichosaRelate> 特記事項List,
            RString 特記事項マスキング区分) {
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
        setBodyItem01(特記事項List, ninteiEntity);
        return ninteiEntity;
    }

    private static TokkiText1A4Entity setBodyItem01(List<NinteichosaRelate> entity, TokkiText1A4Entity ninteiEntity) {
        List<TokkiTextEntity> 特記事項List = new ArrayList<>();
        List<TokkiTextEntity> 特記事項番号リスト = new ArrayList<>();
        List<TokkiTextEntity> イメージリスト = new ArrayList<>();
        for (int i = 0; i < entity.size(); i++) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.get(i).get特記事項区分())) {
                TokkiTextEntity tokki = new TokkiTextEntity();
                tokki.set特記事項(entity.get(i).get特記事項());
                tokki.set特記事項番号(get特記事項番号(entity, i, ninteiEntity));
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

    private static RString get特記事項番号(List<NinteichosaRelate> 特記事項区分, int 連番, TokkiText1A4Entity ninteiEntity) {
        RString 特記事項番号 = RString.EMPTY;
        if (連番 < 特記事項区分.size()) {
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
        }
        return 特記事項番号;
    }

    private static RString get特記事項名称(List<NinteichosaRelate> 特記事項区分, int 連番, TokkiText1A4Entity ninteiEntity) {
        RString 名称 = RString.EMPTY;
        if (連番 < 特記事項区分.size()) {
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
        }
        return 名称;
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
