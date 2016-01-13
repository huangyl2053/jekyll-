/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.nenreitoutatsuyoteishacheck;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListEntity;
import jp.co.ndensan.reams.db.dba.entity.db.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListEucCsvEntity;
import jp.co.ndensan.reams.db.dba.entity.db.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListJyohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 年齢到達予定者チェックリスト_CSVデータ作成します。
 */
public class NenreiToutatsuYoteishaCheckListCsv {

    /**
     * 年齢到達予定者チェックリスト_CSVデータ作成、連番なし。
     *
     * @param nenCheckListJyohoEntity 年齢到達予定者チェックリスト情報Entity
     * @return 年齢到達予定者チェックリスト_CSVデータ
     */
    public List<NenreiToutatsuYoteishaCheckListEucCsvEntity> createNenreiToutatsuYoteishaCheckListCSV(
            NenreiToutatsuYoteishaCheckListJyohoEntity nenCheckListJyohoEntity) {
        List<NenreiToutatsuYoteishaCheckListEucCsvEntity> csvDataList = new ArrayList<>();
        List<NenreiToutatsuYoteishaCheckListEntity> checkListEntity = nenCheckListJyohoEntity
                .get年齢到達予定者チェックリスト();

        if (!checkListEntity.isEmpty()) {
            for (NenreiToutatsuYoteishaCheckListEntity entity : checkListEntity) {
                NenreiToutatsuYoteishaCheckListEucCsvEntity csvDataEntity
                        = new NenreiToutatsuYoteishaCheckListEucCsvEntity();
                csvDataEntity.setHihokenshaNo(new RString(entity.getHihokenshaNo().value().toString()));
                csvDataEntity.setShikibetsuCode(new RString(entity.getShikibetsuCode().value().toString()));
                csvDataEntity.setKanaMeisho(entity.getKanaMeisho());
                csvDataEntity.setMeisho(entity.getMeisho());
                if (new RString("1").equals(entity.getSeibetsuCode())) {
                    csvDataEntity.setSeibetsu(new RString("男"));
                } else if (new RString("2").equals(entity.getSeibetsuCode())) {
                    csvDataEntity.setSeibetsu(new RString("女"));
                }
                if (nenCheckListJyohoEntity.is日付編集フラグ()) {
                    if (entity.getSeinengappiYMD() != null) {
                        csvDataEntity.setSeinengappiYMD(new RString(entity.getSeinengappiYMD().seireki().
                                separator(Separator.SLASH).fillType(FillType.ZERO).toDateString().toString()));
                    }
                    if (entity.getNenreiyotainichi() != null) {
                        csvDataEntity.setNenreiyotainichi(new RString(entity.getNenreiyotainichi().seireki().separator(
                                Separator.SLASH).fillType(FillType.ZERO).toDateString().toString()));
                    }
                } else {
                    if (entity.getSeinengappiYMD() != null) {
                        csvDataEntity.setSeinengappiYMD(new RString(entity.getSeinengappiYMD().toString()));
                    }
                    if (entity.getNenreiyotainichi() != null) {
                        csvDataEntity.setNenreiyotainichi(new RString(entity.getNenreiyotainichi().toString()));
                    }
                }
                csvDataEntity.setShigekubun(entity.getShigekubun());
                csvDataEntity.setJutosyakubun(entity.getJutosyakubun());
                csvDataEntity.setJushoCode(entity.getZenkokuJushoCode());
                csvDataEntity.setJusho(entity.getJusho());
                csvDataEntity.setGyoseikuCode(entity.getGyoseikuCode());
                csvDataEntity.setGyoseikuName(entity.getGyoseikuName());
                if (new RString("1").equals(entity.getJuminShubetsuCode()) || new RString("3").equals(
                        entity.getJuminShubetsuCode())) {
                    csvDataEntity.setJuminShubetsu(new RString("日本人"));
                } else if (new RString("2").equals(entity.getJuminShubetsuCode()) || new RString("4").equals(
                        entity.getJuminShubetsuCode())) {
                    csvDataEntity.setJuminShubetsu(new RString("外国人"));
                }
                csvDataEntity.setSeikatsu(entity.getSeikatsu());
                csvDataEntity.setJyotei(entity.getJyotei());
                csvDataList.add(csvDataEntity);
            }
        }
        return csvDataList;
    }

    /**
     * 年齢到達予定者チェックリスト_CSVデータ作成、連番あり。
     *
     * @param nenCheckListJyohoEntity 年齢到達予定者チェックリスト情報Entity
     * @return 年齢到達予定者チェックリスト_CSVデータ
     */
    public List<NenreiToutatsuYoteishaCheckListEucCsvEntity> createNenreiToutatsuYoteishaCheckListRenbanCSV(
            NenreiToutatsuYoteishaCheckListJyohoEntity nenCheckListJyohoEntity) {
        List<NenreiToutatsuYoteishaCheckListEucCsvEntity> csvDataList = new ArrayList<>();
        List<NenreiToutatsuYoteishaCheckListEntity> checkListEntity
                = nenCheckListJyohoEntity.get年齢到達予定者チェックリスト();
        int renban = 1;
        if (!checkListEntity.isEmpty()) {
            for (NenreiToutatsuYoteishaCheckListEntity entity : checkListEntity) {
                NenreiToutatsuYoteishaCheckListEucCsvEntity csvDataEntity
                        = new NenreiToutatsuYoteishaCheckListEucCsvEntity();
                csvDataEntity.setRenban(new RString(String.valueOf(renban)));
                csvDataEntity.setHihokenshaNo(new RString(entity.getHihokenshaNo().toString()));
                csvDataEntity.setShikibetsuCode(new RString(entity.getShikibetsuCode().toString()));
                csvDataEntity.setKanaMeisho(entity.getKanaMeisho());
                csvDataEntity.setMeisho(entity.getMeisho());
                if (new RString("1").equals(entity.getSeibetsuCode())) {
                    csvDataEntity.setSeibetsu(new RString("男"));
                } else if (new RString("2").equals(entity.getSeibetsuCode())) {
                    csvDataEntity.setSeibetsu(new RString("女"));
                }
                if (nenCheckListJyohoEntity.is日付編集フラグ()) {
                    if (entity.getSeinengappiYMD() != null) {
                        csvDataEntity.setSeinengappiYMD(new RString(entity.getSeinengappiYMD().seireki().
                                separator(Separator.SLASH).fillType(FillType.ZERO).toDateString().toString()));
                    }
                    if (entity.getNenreiyotainichi() != null) {
                        csvDataEntity.setNenreiyotainichi(new RString(entity.getNenreiyotainichi().seireki().separator(
                                Separator.SLASH).fillType(FillType.ZERO).toDateString().toString()));
                    }
                } else {
                    if (entity.getSeinengappiYMD() != null) {
                        csvDataEntity.setSeinengappiYMD(new RString(entity.getSeinengappiYMD().toString()));
                    }
                    if (entity.getNenreiyotainichi() != null) {
                        csvDataEntity.setNenreiyotainichi(new RString(entity.getNenreiyotainichi().toString()));
                    }
                }
                csvDataEntity.setShigekubun(entity.getShigekubun());
                csvDataEntity.setJutosyakubun(entity.getJutosyakubun());
                csvDataEntity.setJushoCode(entity.getZenkokuJushoCode());
                csvDataEntity.setJusho(entity.getJusho());
                csvDataEntity.setGyoseikuCode(entity.getGyoseikuCode());
                csvDataEntity.setGyoseikuName(entity.getGyoseikuName());
                if (new RString("1").equals(entity.getJuminShubetsuCode()) || new RString("3").equals(
                        entity.getJuminShubetsuCode())) {
                    csvDataEntity.setJuminShubetsu(new RString("日本人"));
                } else if (new RString("2").equals(entity.getJuminShubetsuCode()) || new RString("4").equals(
                        entity.getJuminShubetsuCode())) {
                    csvDataEntity.setJuminShubetsu(new RString("外国人"));
                }
                csvDataEntity.setSeikatsu(entity.getSeikatsu());
                csvDataEntity.setJyotei(entity.getJyotei());
                csvDataList.add(csvDataEntity);
                renban++;
            }
        }
        return csvDataList;
    }
}
