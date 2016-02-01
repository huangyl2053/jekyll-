/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.business.core.koikinaitenkyoresultlist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoCSVDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 広域内転居結果一覧表CSVデータ作成
 * @author 徐浩
 */
public class KoikinaiTenkyoResultListCsvDataSakusei {
    
    /**
     * 広域内転居結果一覧表バッチから取った入力パラメータにより、CSVデータを作成する
     * @param 広域内転居結果リスト
     * @return List<KoikinaiTenkyoCSVDataEntity>
     */
    public List<KoikinaiTenkyoCSVDataEntity> getKoikinaiTenkyoResultListCsvData(
            List<KoikinaiTenkyoEntity> 広域内転居結果リスト) {
        List<KoikinaiTenkyoCSVDataEntity> koikinaiTenkyoCSVDataEntityList = new ArrayList<>();
        if (広域内転居結果リスト == null || 広域内転居結果リスト.isEmpty()) {
            return koikinaiTenkyoCSVDataEntityList;
        }
        for (KoikinaiTenkyoEntity koikinaiTenkyoEntity : 広域内転居結果リスト) {
            KoikinaiTenkyoCSVDataEntity entity = new KoikinaiTenkyoCSVDataEntity();
            entity.set被保険者番号(koikinaiTenkyoEntity.get被保険者番号().value());
            entity.set氏名カナ(new RString(koikinaiTenkyoEntity.get氏名カナ().toString()));
            entity.set氏名(new RString(koikinaiTenkyoEntity.get氏名().toString()));
            entity.set旧住民コード(new RString(koikinaiTenkyoEntity.get旧住民コード().toString()));
            entity.set前住所(koikinaiTenkyoEntity.get前住所());
            entity.set転出予定日(koikinaiTenkyoEntity.get転出予定日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.set転出確定日(koikinaiTenkyoEntity.get転出確定日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.set転出確定通知日(koikinaiTenkyoEntity.get転出確定通知日().wareki().eraType(
                    EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).
                    fillType(FillType.BLANK).toDateString());
            entity.set処理日(koikinaiTenkyoEntity.get処理日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.set新住民コード(new RString(koikinaiTenkyoEntity.get新住民コード().toString()));
            entity.set現住所(koikinaiTenkyoEntity.get現住所());
            entity.set登録異動日(koikinaiTenkyoEntity.get登録異動日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.set登録届出日(koikinaiTenkyoEntity.get登録届出日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.set異動情報(koikinaiTenkyoEntity.get異動情報());
            koikinaiTenkyoCSVDataEntityList.add(entity);
        }
        return koikinaiTenkyoCSVDataEntityList;
    }
}
