/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.SonoTashiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * SonoTashiryoEntityの編集クラスです。
 *
 * @author N3212 竹内 和紀
 */
public final class SonoTashiryoEntityEditor {

    private SonoTashiryoEntityEditor() {
    }

    /**
     * SonoTashiryoEntityを編集します。
     *
     * @param yokaigoNinteiJohoTeikyoEntity YokaigoNinteiJohoTeikyoEntity
     * @param イメージファイルパス イメージファイルパス
     * @return SonoTashiryoEntity
     */
    public static SonoTashiryoEntity edit(YokaigoNinteiJohoTeikyoEntity yokaigoNinteiJohoTeikyoEntity, RString イメージファイルパス) {
        SonoTashiryoEntity sonoTashiryo = new SonoTashiryoEntity();
        sonoTashiryo.set保険者番号(yokaigoNinteiJohoTeikyoEntity.get保険者番号());
        sonoTashiryo.set被保険者番号(yokaigoNinteiJohoTeikyoEntity.get被保険者番号());
        sonoTashiryo.set被保険者氏名(yokaigoNinteiJohoTeikyoEntity.get被保険者氏名());
        sonoTashiryo.setTemp_保険者番号(yokaigoNinteiJohoTeikyoEntity.get保険者番号());
        sonoTashiryo.setTemp_被保険者番号(yokaigoNinteiJohoTeikyoEntity.get被保険者番号());
        sonoTashiryo.setTemp_申請書管理番号(yokaigoNinteiJohoTeikyoEntity.get申請書管理番号());
        sonoTashiryo.set申請日_元号(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get認定申請年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        sonoTashiryo.set申請日_年(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get認定申請年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        sonoTashiryo.set申請日_月(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get認定申請年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        sonoTashiryo.set申請日_日(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get認定申請年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        sonoTashiryo.set作成日_元号(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        sonoTashiryo.set作成日_年(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        sonoTashiryo.set作成日_月(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        sonoTashiryo.set作成日_日(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        sonoTashiryo.set調査日_元号(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get実施年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        sonoTashiryo.set調査日_年(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get実施年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        sonoTashiryo.set調査日_月(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get実施年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        sonoTashiryo.set調査日_日(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get実施年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        sonoTashiryo.set審査日_元号(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get審査会開催日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        sonoTashiryo.set審査日_年(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get審査会開催日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        sonoTashiryo.set審査日_月(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get審査会開催日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        sonoTashiryo.set審査日_日(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY : yokaigoNinteiJohoTeikyoEntity
                .get審査会開催日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        sonoTashiryo.setその他資料イメージ(イメージファイルパス);
        return sonoTashiryo;
    }
}
