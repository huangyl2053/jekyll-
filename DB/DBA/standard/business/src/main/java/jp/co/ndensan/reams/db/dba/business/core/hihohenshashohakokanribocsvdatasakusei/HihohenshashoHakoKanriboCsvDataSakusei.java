/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakokanribocsvdatasakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakkoKanriboChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakoKanriboCsvDataSakuseiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 被保険者証発行管理簿_CSVデータ作成のクラスです。
 *
 * @reamsid_L DBA-0600-040 zhangguopeng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihohenshashoHakoKanriboCsvDataSakusei {

    /**
     * 証発行管理CSVデータリスト作成します。
     *
     * @param entityList 証発行管理リストEntity
     * @param koumukumeyifukaflg 項目名付加フラグ
     * @param hizikehensyuuflg 日付'/'編集フラグ
     * @return List<HihohenshashoHakoKanriboCsvDataSakuseiEntity>
     * 証発行管理リストCSV用データリスト
     */
    public List<HihohenshashoHakoKanriboCsvDataSakuseiEntity> getShohakkoKanriCSVDataList(
            List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> entityList,
            boolean koumukumeyifukaflg,
            boolean hizikehensyuuflg) {
        List<HihohenshashoHakoKanriboCsvDataSakuseiEntity> csvDataList = new ArrayList<>();
        if (!entityList.isEmpty() && !(entityList.get(0).get被保険者番号() == null
                || entityList.get(0).get被保険者番号().isEmpty())) {
            for (int i = 0; i < entityList.size(); i++) {
                HihohenshashoHakoKanriboCsvDataSakuseiEntity csvEntity = new HihohenshashoHakoKanriboCsvDataSakuseiEntity();
                csvEntity.setHihokenshaNo(entityList.get(i).get被保険者番号());
                csvEntity.setShikibetsuCode(entityList.get(i).get識別コード());
                csvEntity.setShichosonCode(entityList.get(i).get市町村コード());
                csvEntity.setYubinNo(entityList.get(i).get郵便番号());
                csvEntity.setJusho(entityList.get(i).get住所());
                csvEntity.setMeisho(entityList.get(i).get氏名());
                csvEntity.setKofuJiyuCode(entityList.get(i).get交付事由コード());
                csvEntity.setKofuJiyuRyakusho(entityList.get(i).get交付事由略称());
                csvEntity.setKofuJiyu(entityList.get(i).get交付事由名称());
                csvEntity.setKaishuJiyuCode(entityList.get(i).get回収事由コード());
                csvEntity.setKaishuJiyu(entityList.get(i).get回収事由名称());

                if (hizikehensyuuflg) {
                    csvEntity.setKofuYMD(RString.isNullOrEmpty(entityList.get(i).get交付年月日()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get交付年月日().toString()).seireki().separator(
                                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
                    csvEntity.setKaishuYMD(RString.isNullOrEmpty(entityList.get(i).get回収年月日()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get回収年月日().toString()).seireki().separator(
                                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
                    csvEntity.setYukoKigenYMD(RString.isNullOrEmpty(entityList.get(i).get有効期限()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get有効期限().toString()).seireki().separator(
                                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
                } else {
                    csvEntity.setKofuYMD(RString.isNullOrEmpty(entityList.get(i).get交付年月日()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get交付年月日().toString()).seireki().separator(
                                    Separator.NONE).fillType(FillType.ZERO).toDateString());
                    csvEntity.setKaishuYMD(RString.isNullOrEmpty(entityList.get(i).get回収年月日()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get回収年月日().toString()).seireki().separator(
                                    Separator.NONE).fillType(FillType.ZERO).toDateString());
                    csvEntity.setYukoKigenYMD(RString.isNullOrEmpty(entityList.get(i).get交付年月日()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get有効期限().toString()).seireki().separator(
                                    Separator.NONE).fillType(FillType.ZERO).toDateString());
                }
                csvEntity.setShoYoshikiKubunCode(entityList.get(i).get様式());
                csvDataList.add(csvEntity);
            }
        }
        return csvDataList;
    }

    /**
     * 証発行管理CSVデータリスト作成(連番有)します。
     *
     * @param entityList 証発行管理リストEntity
     * @param koumukumeyifukaflg 項目名付加フラグ
     * @param hizikehensyuuflg 日付'/'編集フラグ
     * @return List<HihohenshashoHakoKanriboCsvDataSakuseiEntity>
     */
    public List<HihohenshashoHakoKanriboCsvDataSakuseiEntity> getShohakkoKanriCSVDataListAddRenban(
            List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> entityList,
            boolean koumukumeyifukaflg,
            boolean hizikehensyuuflg) {
        List<HihohenshashoHakoKanriboCsvDataSakuseiEntity> csvDataList = new ArrayList<>();
        int renban = 1;
        if (!entityList.isEmpty() && !(entityList.get(0).get被保険者番号() == null
                || entityList.get(0).get被保険者番号().isEmpty())) {
            for (int i = 0; i < entityList.size(); i++) {
                HihohenshashoHakoKanriboCsvDataSakuseiEntity csvEntity = new HihohenshashoHakoKanriboCsvDataSakuseiEntity();
                csvEntity.setHihokenshaNo(entityList.get(i).get被保険者番号());
                csvEntity.setShikibetsuCode(entityList.get(i).get識別コード());
                csvEntity.setShichosonCode(entityList.get(i).get市町村コード());
                csvEntity.setYubinNo(entityList.get(i).get郵便番号());
                csvEntity.setJusho(entityList.get(i).get住所());
                csvEntity.setMeisho(entityList.get(i).get氏名());
                csvEntity.setKofuJiyuCode(entityList.get(i).get交付事由コード());
                csvEntity.setKofuJiyuRyakusho(entityList.get(i).get交付事由略称());
                csvEntity.setKofuJiyu(entityList.get(i).get交付事由名称());
                csvEntity.setKaishuJiyuCode(entityList.get(i).get回収事由コード());
                csvEntity.setKaishuJiyu(entityList.get(i).get回収事由名称());

                if (hizikehensyuuflg) {
                    csvEntity.setKofuYMD(RString.isNullOrEmpty(entityList.get(i).get交付年月日()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get交付年月日().toString()).seireki().separator(
                                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
                    csvEntity.setKaishuYMD(RString.isNullOrEmpty(entityList.get(i).get回収年月日()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get回収年月日().toString()).seireki().separator(
                                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
                    csvEntity.setYukoKigenYMD(RString.isNullOrEmpty(entityList.get(i).get有効期限()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get有効期限().toString()).seireki().separator(
                                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
                } else {
                    csvEntity.setKofuYMD(RString.isNullOrEmpty(entityList.get(i).get交付年月日()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get交付年月日().toString()).seireki().separator(
                                    Separator.NONE).fillType(FillType.ZERO).toDateString());
                    csvEntity.setKaishuYMD(RString.isNullOrEmpty(entityList.get(i).get回収年月日()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get回収年月日().toString()).seireki().separator(
                                    Separator.NONE).fillType(FillType.ZERO).toDateString());
                    csvEntity.setYukoKigenYMD(RString.isNullOrEmpty(entityList.get(i).get交付年月日()) ? RString.EMPTY : new RDate(
                            entityList.get(i).get有効期限().toString()).seireki().separator(
                                    Separator.NONE).fillType(FillType.ZERO).toDateString());
                }
                csvEntity.setShoYoshikiKubunCode(entityList.get(i).get様式());
                csvEntity.setRenban(renban);
                renban++;
                csvDataList.add(csvEntity);
            }
        }
        return csvDataList;
    }
}
