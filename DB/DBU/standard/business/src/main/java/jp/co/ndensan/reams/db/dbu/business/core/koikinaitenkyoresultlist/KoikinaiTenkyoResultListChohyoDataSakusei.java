/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.koikinaitenkyoresultlist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoListEntity;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoResultEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 広域内転居結果一覧表帳票データ作成
 *
 * @author quxiaodong
 */
public class KoikinaiTenkyoResultListChohyoDataSakusei {

    /**
     *
     * @param entity
     * @return KoikinaiTenkyoResultEntity 広域内転居結果一覧表帳票ソースリスト
     */
    public List<KoikinaiTenkyoResultEntity> getKoikinaiTenkyoResultListChohyoData(KoikinaiTenkyoListEntity entity) {

        if (entity.getEntity() == null || 0 == entity.getEntity().size()) {
            KoikinaiTenkyoResultEntity koikiEntity = new KoikinaiTenkyoResultEntity();
            koikiEntity.set市町村コード(new RString(entity.get市町村コード().toString()));
            koikiEntity.set市町村名(entity.get市町村名());
            koikiEntity.set印刷日時(new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toString()));
            return null;

        } else {
            List<KoikinaiTenkyoResultEntity> lists = new ArrayList<>();
            for (int i = 0; i < entity.getEntity().size(); i++) {
                KoikinaiTenkyoResultEntity koikiEntity = new KoikinaiTenkyoResultEntity();
                koikiEntity.set市町村コード(new RString(entity.get市町村コード().toString()));
                koikiEntity.set市町村名(entity.get市町村名());
                koikiEntity.set印刷日時(new RString(FlexibleDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toString()));
                koikiEntity.set被保険者番号(new RString((entity.getEntity().get(i).get被保険者番号().toString())));
                koikiEntity.set氏名カナ(new RString(entity.getEntity().get(i).get氏名カナ().toString()));
                koikiEntity.set旧住民コード(new RString(entity.getEntity().get(i).get旧住民コード().toString()));
                koikiEntity.set前住所(entity.getEntity().get(i).get前住所());
                koikiEntity.set転出予定日(entity.getEntity().get(i).get転出予定日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set転出確定日(entity.getEntity().get(i).get転出確定日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set転出確定通知日(entity.getEntity().get(i).get転出確定通知日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set処理日(entity.getEntity().get(i).get処理日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set氏名(new RString(entity.getEntity().get(i).get氏名().toString()));
                koikiEntity.set新住民コード(new RString(entity.getEntity().get(i).get新住民コード().toString()));
                koikiEntity.set現住所(entity.getEntity().get(i).get現住所());
                koikiEntity.set登録異動日(entity.getEntity().get(i).get登録異動日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set登録届出日(entity.getEntity().get(i).get登録届出日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                koikiEntity.set異動情報(entity.getEntity().get(i).get異動情報());
                lists.add(koikiEntity);
            }

            return lists;
        }
    }

}
