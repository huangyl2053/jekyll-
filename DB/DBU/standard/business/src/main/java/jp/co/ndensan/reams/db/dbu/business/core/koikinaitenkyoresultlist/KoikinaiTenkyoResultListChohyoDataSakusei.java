/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.koikinaitenkyoresultlist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoEntity;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoListEntity;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoResultEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 広域内転居結果一覧表帳票データ作成
 *
 * @author quxiaodong
 */
public class KoikinaiTenkyoResultListChohyoDataSakusei {

    /**
     * 広域内転居結果一覧表帳票データ作成
     *
     * @param entity
     * @return List<KoikinaiTenkyoResultEntity> 広域内転居結果一覧表帳票ソースリスト
     */
    public List<KoikinaiTenkyoResultEntity> getKoikinaiTenkyoResultListChohyoData(KoikinaiTenkyoListEntity entity) {

        List<KoikinaiTenkyoResultEntity> lists = new ArrayList<>();
        if (entity.getEntity() == null || entity.getEntity().isEmpty()) {
            KoikinaiTenkyoResultEntity koikiEntity = new KoikinaiTenkyoResultEntity();
            koikiEntity.set印刷日時(RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(RDate.getNowTime().
                            toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
            koikiEntity.setページ数(new RString(Integer.valueOf(1).toString()));
            koikiEntity.set市町村コード(entity.get市町村コード().value());
            koikiEntity.set市町村名(entity.get市町村名());

            lists.add(koikiEntity);
            return lists;

        } else {
            for (KoikinaiTenkyoEntity kokiten : entity.getEntity()) {

                KoikinaiTenkyoResultEntity koikiEntity = new KoikinaiTenkyoResultEntity();
//                koikiEntity.set印刷日時(RDate.getNowDate().wareki().eraType(EraType.KANJI).
//                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
                koikiEntity.set印刷日時(RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(RDate.getNowTime().
                                toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
                //TODO ページ数具体怎么获取不明确
                koikiEntity.set市町村コード(new RString(entity.get市町村コード().toString()));
                koikiEntity.set市町村名(entity.get市町村名());
                koikiEntity.set被保険者番号(kokiten.get被保険者番号().value());
                koikiEntity.set氏名カナ(kokiten.get氏名カナ().value());
                koikiEntity.set旧住民コード(kokiten.get旧住民コード().value());
                koikiEntity.set前住所(kokiten.get前住所());
                koikiEntity.set転出予定日(kokiten.get転出予定日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set転出確定日(kokiten.get転出確定日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set転出確定通知日(kokiten.get転出確定通知日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set処理日(kokiten.get処理日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set氏名(new RString(kokiten.get氏名().toString()));
                koikiEntity.set新住民コード(new RString(kokiten.get新住民コード().toString()));
                koikiEntity.set現住所(kokiten.get現住所());
                koikiEntity.set登録異動日(kokiten.get登録異動日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set登録届出日(kokiten.get登録届出日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set異動情報(kokiten.get異動情報());
                lists.add(koikiEntity);
            }

            return lists;
        }
    }

}
