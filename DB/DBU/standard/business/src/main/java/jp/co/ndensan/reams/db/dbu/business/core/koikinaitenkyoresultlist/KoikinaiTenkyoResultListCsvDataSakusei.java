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
 * @author GC xuhao
 */
public class KoikinaiTenkyoResultListCsvDataSakusei {
    
    /**
     * 広域内転居結果一覧表バッチから取った入力パラメータにより、CSVデータを作成する
     * @param 広域内転居結果リスト
     * @return List<KoikinaiTenkyoCSVDataEntity>
     */
    public List<KoikinaiTenkyoCSVDataEntity> getKoikinaiTenkyoResultListCsvData(
            List<KoikinaiTenkyoEntity> 広域内転居結果リスト) {
        if (null == 広域内転居結果リスト || 0 == 広域内転居結果リスト.size()) {
            return null;
        }
        List<KoikinaiTenkyoCSVDataEntity> KoikinaiTenkyoCSVDataEntityList = new ArrayList<>();
        for (int i = 0; i < 広域内転居結果リスト.size(); i++) {
            KoikinaiTenkyoCSVDataEntity entity = new KoikinaiTenkyoCSVDataEntity();
            entity.set被保険者番号(広域内転居結果リスト.get(i).get被保険者番号().value());
            entity.set氏名カナ(new RString(広域内転居結果リスト.get(i).get氏名カナ().toString()));
            entity.set氏名(new RString(広域内転居結果リスト.get(i).get氏名().toString()));
            entity.set旧住民コード(new RString(広域内転居結果リスト.get(i).get旧住民コード().toString()));
            entity.set前住所(広域内転居結果リスト.get(i).get前住所());
            entity.set転出予定日(広域内転居結果リスト.get(i).get転出予定日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.set転出確定日(広域内転居結果リスト.get(i).get転出確定日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.set転出確定通知日(広域内転居結果リスト.get(i).get転出確定通知日().wareki().eraType(
                    EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).
                    fillType(FillType.BLANK).toDateString());
            entity.set処理日(広域内転居結果リスト.get(i).get処理日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.set新住民コード(new RString(広域内転居結果リスト.get(i).get新住民コード().toString()));
            entity.set現住所(広域内転居結果リスト.get(i).get現住所());
            entity.set登録異動日(広域内転居結果リスト.get(i).get登録異動日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.set登録届出日(広域内転居結果リスト.get(i).get登録届出日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            entity.set異動情報(広域内転居結果リスト.get(i).get異動情報());
            KoikinaiTenkyoCSVDataEntityList.add(entity);
        }
        return KoikinaiTenkyoCSVDataEntityList;
    }
}
