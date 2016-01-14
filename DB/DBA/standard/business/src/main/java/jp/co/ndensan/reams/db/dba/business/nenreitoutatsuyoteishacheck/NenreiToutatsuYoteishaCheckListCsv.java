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

    private static final RString 性別コード1 = new RString("1");
    private static final RString 性別コード2 = new RString("2");
    private static final RString 性別_男 = new RString("男");
    private static final RString 性別_女 = new RString("女");
    private static final RString 住登内日本人 = new RString("1");
    private static final RString 住登内外国人 = new RString("2");
    private static final RString 住登外日本人 = new RString("3");
    private static final RString 住登外外国人 = new RString("4");
    private static final RString 住民種別_日本人のみ = new RString("2");
    private static final RString 住民種別_外国人のみ = new RString("3");

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
                if (性別コード1.equals(entity.getSeibetsuCode())) {
                    csvDataEntity.setSeibetsu(性別_男);
                } else if (性別コード2.equals(entity.getSeibetsuCode())) {
                    csvDataEntity.setSeibetsu(性別_女);
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
                if (住登内日本人.equals(entity.getJuminShubetsuCode()) || 住登外日本人.equals(
                        entity.getJuminShubetsuCode())) {
                    csvDataEntity.setJuminShubetsu(住民種別_日本人のみ);
                } else if (住登内外国人.equals(entity.getJuminShubetsuCode()) || 住登外外国人.equals(
                        entity.getJuminShubetsuCode())) {
                    csvDataEntity.setJuminShubetsu(住民種別_外国人のみ);
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
                csvDataEntity.setHihokenshaNo(new RString(entity.getHihokenshaNo().value().toString()));
                csvDataEntity.setShikibetsuCode(new RString(entity.getShikibetsuCode().value().toString()));
                csvDataEntity.setKanaMeisho(entity.getKanaMeisho());
                csvDataEntity.setMeisho(entity.getMeisho());
                if (性別コード1.equals(entity.getSeibetsuCode())) {
                    csvDataEntity.setSeibetsu(性別_男);
                } else if (性別コード2.equals(entity.getSeibetsuCode())) {
                    csvDataEntity.setSeibetsu(性別_女);
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
                if (住登内日本人.equals(entity.getJuminShubetsuCode()) || 住登外日本人.equals(
                        entity.getJuminShubetsuCode())) {
                    csvDataEntity.setJuminShubetsu(住民種別_日本人のみ);
                } else if (住登内外国人.equals(entity.getJuminShubetsuCode()) || 住登外外国人.equals(
                        entity.getJuminShubetsuCode())) {
                    csvDataEntity.setJuminShubetsu(住民種別_外国人のみ);
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
