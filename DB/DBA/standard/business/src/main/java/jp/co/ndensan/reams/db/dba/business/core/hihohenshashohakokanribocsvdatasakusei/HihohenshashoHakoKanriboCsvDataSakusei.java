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
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihohenshashoHakoKanriboCsvDataSakusei {

    /**
     * 証発行管理CSVデータリスト作成します。
     *
     * // TODO 張国朋 QA 499 回復から提供されたら対応可能。2016/01/20 まで
     *
     * @param entityList 証発行管理リストEntity
     * @param koumukumeyifukaflg 項目名付加フラグ
     * @param hizikehensyuuflg 日付'/'編集フラグ
     * @return　List<HihohenshashoHakoKanriboCsvDataSakuseiEntity>
     * 証発行管理リストCSV用データリスト
     */
    public List<HihohenshashoHakoKanriboCsvDataSakuseiEntity> getShohakkoKanriCSVDataList(
            List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> entityList,
            boolean koumukumeyifukaflg,
            boolean hizikehensyuuflg) {
        List<HihohenshashoHakoKanriboCsvDataSakuseiEntity> csvDataList = new ArrayList<>();
        if (!entityList.isEmpty()) {
            for (int i = 0; i < entityList.size(); i++) {
                HihohenshashoHakoKanriboCsvDataSakuseiEntity csvEntity = new HihohenshashoHakoKanriboCsvDataSakuseiEntity();
                csvEntity.setHihokenshaNo(entityList.get(0).get被保険者番号());
                csvEntity.setShikibetsuCode(entityList.get(0).get識別コード());
                csvEntity.setShichosonCode(entityList.get(0).get市町村コード());
                csvEntity.setYubinNo(entityList.get(0).get郵便番号());
                csvEntity.setJusho(entityList.get(0).get住所());
                csvEntity.setMeisho(entityList.get(0).get氏名());
                csvEntity.setKofuJiyuCode(entityList.get(0).get回収事由コード());
                csvEntity.setKofuJiyuRyakusho(entityList.get(0).get交付事由略称());
                // TODO 張国朋 QA 499 回復から提供されたら対応可能。2016/01/20 まで
                csvEntity.setKofuJiyu(entityList.get(0).get交付事由名称());
                csvEntity.setKaishuJiyuCode(entityList.get(0).get回収事由コード());
                // TODO 張国朋 QA 499 回復から提供されたら対応可能。2016/01/20 まで
                csvEntity.setKaishuJiyu(entityList.get(0).get回収事由名称());

                if (hizikehensyuuflg) {
                    csvEntity.setKofuYMD(new RDate(
                            entityList.get(0).get交付年月日().toString()).toFlexibleDate().seireki()
                            .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                    csvEntity.setKaishuYMD(new RDate(
                            entityList.get(0).get回収年月日().toString()).toFlexibleDate().seireki()
                            .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                    csvEntity.setYukoKigenYMD(new RDate(
                            entityList.get(0).get有効期限().toString()).toFlexibleDate().seireki()
                            .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                } else {
                    csvEntity.setKofuYMD(new RString(entityList.get(0).get交付年月日().toString()));
                    csvEntity.setKaishuYMD(new RString(entityList.get(0).get回収年月日().toString()));
                    csvEntity.setYukoKigenYMD(new RString(entityList.get(0).get有効期限().toString()));
                }
                csvEntity.setShoYoshikiKubunCode(entityList.get(0).get様式());
                csvDataList.add(csvEntity);
            }
        }
        return csvDataList;

    }

    /**
     * 証発行管理CSVデータリスト作成(連番有)します。
     *
     * // TODO 張国朋 QA 499 回復から提供されたら対応可能。2016/01/20 まで
     *
     * @param entityList 証発行管理リストEntity
     * @param koumukumeyifukaflg 項目名付加フラグ
     * @param hizikehensyuuflg 日付'/'編集フラグ
     * @return　List<HihohenshashoHakoKanriboCsvDataSakuseiEntity>
     */
    public List<HihohenshashoHakoKanriboCsvDataSakuseiEntity> getShohakkoKanriCSVDataListAddRenban(
            List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> entityList,
            boolean koumukumeyifukaflg,
            boolean hizikehensyuuflg) {
        List<HihohenshashoHakoKanriboCsvDataSakuseiEntity> csvDataList = new ArrayList<>();
        int renban = 1;
        if (!entityList.isEmpty()) {
            for (int i = 0; i < entityList.size(); i++) {
                HihohenshashoHakoKanriboCsvDataSakuseiEntity csvEntity = new HihohenshashoHakoKanriboCsvDataSakuseiEntity();
                csvEntity.setHihokenshaNo(entityList.get(0).get被保険者番号());
                csvEntity.setShikibetsuCode(entityList.get(0).get識別コード());
                csvEntity.setShichosonCode(entityList.get(0).get市町村コード());
                csvEntity.setYubinNo(entityList.get(0).get郵便番号());
                csvEntity.setJusho(entityList.get(0).get住所());
                csvEntity.setMeisho(entityList.get(0).get氏名());
                csvEntity.setKofuJiyuCode(entityList.get(0).get回収事由コード());
                csvEntity.setKofuJiyuRyakusho(entityList.get(0).get交付事由略称());
                // TODO 張国朋 QA 499 回復から提供されたら対応可能。2016/01/20 まで
                csvEntity.setKofuJiyu(entityList.get(0).get交付事由名称());
                csvEntity.setKaishuJiyuCode(entityList.get(0).get回収事由コード());
                // TODO 張国朋 QA 499 回復から提供されたら対応可能。2016/01/20 まで
                csvEntity.setKaishuJiyu(entityList.get(0).get回収事由名称());

                if (hizikehensyuuflg) {
                    csvEntity.setKofuYMD(new RDate(
                            entityList.get(0).get交付年月日().toString()).toFlexibleDate().seireki()
                            .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                    csvEntity.setKaishuYMD(new RDate(
                            entityList.get(0).get回収年月日().toString()).toFlexibleDate().seireki()
                            .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                    csvEntity.setYukoKigenYMD(new RDate(
                            entityList.get(0).get有効期限().toString()).toFlexibleDate().seireki()
                            .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                } else {
                    csvEntity.setKofuYMD(new RString(entityList.get(0).get交付年月日().toString()));
                    csvEntity.setKaishuYMD(new RString(entityList.get(0).get回収年月日().toString()));
                    csvEntity.setYukoKigenYMD(new RString(entityList.get(0).get有効期限().toString()));
                }
                csvEntity.setShoYoshikiKubunCode(entityList.get(0).get様式());
                csvEntity.setRenban(renban);
                renban++;
                csvDataList.add(csvEntity);
            }
        }
        return csvDataList;

    }
}
