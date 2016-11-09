/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.jigyohokokunenpoyoshiki1to2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpokyuyoshiki1.JigyohokokuNenpoKyuyoshiki1Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1of1.JigyohokokuToukeiData;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.JigyoHokokuReportDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.KonkyoListCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.TempIchijiTableEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki28.JigyohokokuNenpoYoshiki28Entity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業状況報告年報　様式１・２のBusinessクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
public class JigyoHokokuNenpoYoshiki1To2Business {

    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final int INDEX_12 = 12;
    private static final int INDEX_13 = 13;
    private static final int INDEX_14 = 14;
    private static final int INDEX_15 = 15;
    private static final int INDEX_16 = 16;
    private static final int INDEX_17 = 17;
    private static final int INDEX_18 = 18;
    private static final int INDEX_19 = 19;
    private static final int INDEX_20 = 20;
    private static final int INDEX_21 = 21;
    private static final int INDEX_22 = 22;
    private static final int INDEX_23 = 23;
    private static final int INDEX_24 = 24;
    private static final int INDEX_25 = 25;
    private static final int INDEX_26 = 26;
    private static final int INDEX_27 = 27;
    private static final int INDEX_28 = 28;
    private static final int INDEX_29 = 29;
    private static final RString データ区分_21 = new RString("21");
    private static final RString 集計区分_加算 = new RString("加算");
    private static final RString 表番号_01 = new RString("01");
    private static final RString 集計番号_0400 = new RString("0400");
    private static final RString 集計単位_1 = new RString("1");
    private static final RString 横番号_1 = new RString("1");
    private static final RString 所得段階_1 = new RString("所得段階第01段階");
    private static final RString 所得段階_2 = new RString("所得段階第02段階");
    private static final RString 所得段階_3 = new RString("所得段階第03段階");
    private static final RString 所得段階_4 = new RString("所得段階第04段階");
    private static final RString 所得段階_5 = new RString("所得段階第05段階");
    private static final RString 所得段階_6 = new RString("所得段階第06段階（市町村所得段階第06段階）");
    private static final RString 所得段階_7 = new RString("所得段階第06段階（市町村所得段階第07段階）");
    private static final RString 所得段階_8 = new RString("所得段階第06段階（市町村所得段階第08段階）");
    private static final RString 所得段階_9 = new RString("所得段階第06段階（市町村所得段階不明）");
    private static final RString 所得段階_10 = new RString("所得段階第07段階（市町村所得段階第07段階）");
    private static final RString 所得段階_11 = new RString("所得段階第07段階（市町村所得段階第08段階）");
    private static final RString 所得段階_12 = new RString("所得段階第07段階（市町村所得段階第09段階）");
    private static final RString 所得段階_13 = new RString("所得段階第07段階（市町村所得段階不明）");
    private static final RString 所得段階_14 = new RString("所得段階第08段階（市町村所得段階第08段階）");
    private static final RString 所得段階_15 = new RString("所得段階第08段階（市町村所得段階第09段階）");
    private static final RString 所得段階_16 = new RString("所得段階第08段階（市町村所得段階第10段階）");
    private static final RString 所得段階_17 = new RString("所得段階第08段階（市町村所得段階不明）");
    private static final RString 所得段階_18 = new RString("所得段階第09段階（市町村所得段階第09段階）");
    private static final RString 所得段階_19 = new RString("所得段階第09段階（市町村所得段階第10段階）");
    private static final RString 所得段階_20 = new RString("所得段階第09段階（市町村所得段階第11段階）");
    private static final RString 所得段階_21 = new RString("所得段階第09段階（市町村所得段階第12段階）");
    private static final RString 所得段階_22 = new RString("所得段階第09段階（市町村所得段階第13段階）");
    private static final RString 所得段階_23 = new RString("所得段階第09段階（市町村所得段階第14段階）");
    private static final RString 所得段階_24 = new RString("所得段階第09段階（市町村所得段階第15段階）");
    private static final RString 所得段階_25 = new RString("所得段階第09段階（市町村所得段階第16段階）");
    private static final RString 所得段階_26 = new RString("所得段階第09段階（市町村所得段階不明）");
    private static final RString 所得段階_27 = new RString("所得段階不明");

    private List<JigyohokokuToukeiData> dataList;
    private JigyohokokuNenpoKyuyoshiki1Entity 所得段階data;
    private List<JigyohokokuNenpoYoshiki28Entity> 市町村特別給付List;
    private List<JigyoHokokuReportDataRelateEntity> entityList;

    /**
     * 事業状況報告年報・（様式１・２　被保険者数）のデータを設定します
     *
     * @param entity 事業報告統計データ
     */
    public void setToukeiDataList(JigyoHokokuReportDataRelateEntity entity) {
        JigyohokokuToukeiData data = new JigyohokokuToukeiData();
        data.set横番号(entity.getYokoNo().intValue());
        data.set縦番号(entity.getTateNo().intValue());
        data.set表番号(entity.getHyoNo().value());
        data.set集計結果値(new RString(entity.getSukeiKekkaAtai().toString()));
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        dataList.add(data);
    }

    /**
     * 事業状況報告年報・（様式１・２　被保険者数）のデータを取得します
     *
     * @return 事業状況報告年報・（様式１・２　被保険者数）のデータ
     */
    public List<JigyohokokuToukeiData> getToukeiDataList() {
        return this.dataList;
    }

    /**
     * 事業状況報告年報・（様式１・２　市町村特別給付）のデータを設定します
     *
     * @param entity 事業報告統計データ
     */
    public void setShichosonDataList(JigyoHokokuReportDataRelateEntity entity) {
        if (entityList == null) {
            entityList = new ArrayList<>();
        }
        entityList.add(entity);
    }

    /**
     * 事業状況報告年報・（様式１・２　市町村特別給付）のデータを取得します
     *
     * @return 事業状況報告年報・（様式１・２　市町村特別給付）のデータ
     */
    public List<JigyohokokuNenpoYoshiki28Entity> getShichosonDataList() {
        市町村特別給付List = new ArrayList<>();
        Collections.sort(entityList, new TateComparator());
        Decimal tateNo = null;
        JigyohokokuNenpoYoshiki28Entity retEntity = null;
        for (JigyoHokokuReportDataRelateEntity entity : entityList) {
            if (tateNo == null) {
                tateNo = entity.getTateNo();
                retEntity = new JigyohokokuNenpoYoshiki28Entity();
                retEntity.set集計番号(entity.getSyukeiNo().value());
            }
            if (tateNo.intValue() == entity.getTateNo().intValue()) {
                set集計結果値(retEntity, entity.getYokoNo(), entity.getSukeiKekkaAtai(), entity.getShukeiKomokuMeisho());
            } else {
                市町村特別給付List.add(retEntity);
                retEntity = new JigyohokokuNenpoYoshiki28Entity();
                tateNo = entity.getTateNo();
                retEntity.set集計番号(entity.getSyukeiNo().value());
                set集計結果値(retEntity, entity.getYokoNo(), entity.getSukeiKekkaAtai(), entity.getShukeiKomokuMeisho());
            }
        }
        return this.市町村特別給付List;
    }

    private void set集計結果値(JigyohokokuNenpoYoshiki28Entity retEntity, Decimal 横番号,
            Decimal 集計結果値, RString 集計項目名称) {
        switch (横番号.intValue()) {
            case 1:
                retEntity.set経過的要介護(new RString(集計結果値.toString()));
                break;
            case 2:
                retEntity.set要介護１(new RString(集計結果値.toString()));
                break;
            case INDEX_3:
                retEntity.set要介護2(new RString(集計結果値.toString()));
                break;
            case INDEX_4:
                retEntity.set要介護3(new RString(集計結果値.toString()));
                break;
            case INDEX_5:
                retEntity.set要介護4(new RString(集計結果値.toString()));
                break;
            case INDEX_6:
                retEntity.set要介護5(new RString(集計結果値.toString()));
                break;
            case INDEX_7:
                retEntity.set要介護計(new RString(集計結果値.toString()));
                break;
            case INDEX_8:
                retEntity.set要支援１(new RString(集計結果値.toString()));
                break;
            case INDEX_9:
                retEntity.set要支援２(new RString(集計結果値.toString()));
                break;
            case INDEX_10:
                retEntity.set種類(集計項目名称);
                break;
            case INDEX_11:
                break;
            case INDEX_12:
                retEntity.set要支援計(new RString(集計結果値.toString()));
                break;
            case INDEX_13:
                retEntity.set合計(new RString(集計結果値.toString()));
                break;
            default:
                break;
        }
    }

    private static class TateComparator implements Comparator<JigyoHokokuReportDataRelateEntity>, Serializable {

        private static final long serialVersionUID = -4813557413163162530L;

        @Override
        public int compare(JigyoHokokuReportDataRelateEntity o1, JigyoHokokuReportDataRelateEntity o2) {
            return o1.getTateNo().compareTo(o2.getTateNo());
        }
    }

    /**
     * 事業状況報告年報・（様式１・２　所得段階）のデータを設定します
     *
     * @param entity 事業報告統計データ
     */
    public void setKyuyoshikiData(JigyoHokokuReportDataRelateEntity entity) {
        if (所得段階data == null) {
            所得段階data = new JigyohokokuNenpoKyuyoshiki1Entity();
        }
        if (entity.getYokoNo().intValue() == 1) {
            if (entity.getTateNo().intValue() < INDEX_15) {
                set縦番号14以下(entity.getTateNo(), entity.getSukeiKekkaAtai());
            } else {
                set縦番号14以上(entity.getTateNo(), entity.getSukeiKekkaAtai());
            }
        }
    }

    /**
     * 事業状況報告年報・（様式１・２　所得段階）のデータを取得します
     *
     * @return 事業状況報告年報・（様式１・２　所得段階）のデータ
     */
    public JigyohokokuNenpoKyuyoshiki1Entity getKyuyoshikiData() {
        return this.所得段階data;
    }

    private void set縦番号14以下(Decimal 縦番号, Decimal 被保険者数) {
        switch (縦番号.intValue()) {
            case 1:
                所得段階data.set第１段階_被保険者数(new RString(被保険者数.intValue()));
                break;
            case 2:
                所得段階data.set第２段階_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_3:
                所得段階data.set第３段階_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_4:
                所得段階data.set第４段階_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_5:
                所得段階data.set第５段階_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_6:
                所得段階data.set第６段階１_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_7:
                所得段階data.set第６段階２_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_8:
                所得段階data.set第６段階３_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_9:
                所得段階data.set第６段階４_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_10:
                所得段階data.set第７段階１_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_11:
                所得段階data.set第７段階２_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_12:
                所得段階data.set第７段階３_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_13:
                所得段階data.set第７段階４_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_14:
                所得段階data.set第８段階１_被保険者数(new RString(被保険者数.intValue()));
                break;
            default:
                break;
        }
    }

    private void set縦番号14以上(Decimal 縦番号, Decimal 被保険者数) {
        switch (縦番号.intValue()) {
            case INDEX_15:
                所得段階data.set第８段階２_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_16:
                所得段階data.set第８段階３_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_17:
                所得段階data.set第８段階４_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_18:
                所得段階data.set第９段階１_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_19:
                所得段階data.set第９段階２_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_20:
                所得段階data.set第９段階３_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_21:
                所得段階data.set第９段階４_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_22:
                所得段階data.set第９段階５_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_23:
                所得段階data.set第９段階６_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_24:
                所得段階data.set第９段階７_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_25:
                所得段階data.set第９段階８_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_26:
                所得段階data.set第９段階９_被保険者数(new RString(被保険者数.intValue()));
                break;
            case INDEX_27:
                所得段階data.set不明_被保険者週(new RString(被保険者数.intValue()));
                break;
            case INDEX_28:
                所得段階data.set標準月額保険料(new RString(被保険者数.intValue()));
                break;
            case INDEX_29:
                所得段階data.set合計(new RString(被保険者数.intValue()));
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param entity 一時テーブルデータ
     * @return 根拠リストCSVEntity
     */
    public KonkyoListCsvEntity toKonkyoListCsvEntity(TempIchijiTableEntity entity) {
        KonkyoListCsvEntity retEntity = new KonkyoListCsvEntity();
        retEntity.setデータ区分(データ区分_21);
        retEntity.set集計区分(集計区分_加算);
        retEntity.set表番号(表番号_01);
        retEntity.set集計番号(集計番号_0400);
        retEntity.set集計単位(集計単位_1);
        retEntity.set縦番号(set縦番号(entity.getShotokuDankaiIndex()));
        retEntity.set横番号(横番号_1);
        retEntity.set調定年度(new RString(entity.getChoteiNendo().getYearValue()));
        retEntity.set通知書番号(entity.getTsuchishoNo().value());
        retEntity.set被保険者番号(entity.getHihokenshaNo().value());
        retEntity.set課税区分(entity.getKazeiKubun());
        retEntity.set世帯課税区分(entity.getSetaikazeiKubun());
        retEntity.set合計所得金額(new RString(entity.getGokeiShotokuGaku().intValue()));
        retEntity.set所得段階(entity.getShotokuDankai());
        retEntity.set保険料算定段階1(entity.getHokenryoDankai1());
        retEntity.set保険料算定段階2(entity.getHokenryoDankai2());
        retEntity.set市町村コード(entity.getShichosonCode().value());
        retEntity.set旧市町村コード(entity.getKyuShichosonCode().value());
        return retEntity;
    }

    private RString set縦番号(int 所得段階index) {
        if (所得段階index < INDEX_14) {
            return set縦番号13以下(所得段階index);
        } else {
            return set縦番号13以上(所得段階index);
        }
    }

    private RString set縦番号13以下(int 所得段階index) {
        switch (所得段階index) {
            case 1:
                return 所得段階_1;
            case 2:
                return 所得段階_2;
            case INDEX_3:
                return 所得段階_3;
            case INDEX_4:
                return 所得段階_4;
            case INDEX_5:
                return 所得段階_5;
            case INDEX_6:
                return 所得段階_6;
            case INDEX_7:
                return 所得段階_7;
            case INDEX_8:
                return 所得段階_8;
            case INDEX_9:
                return 所得段階_9;
            case INDEX_10:
                return 所得段階_10;
            case INDEX_11:
                return 所得段階_11;
            case INDEX_12:
                return 所得段階_12;
            case INDEX_13:
                return 所得段階_13;
            default:
                return RString.EMPTY;
        }
    }

    private RString set縦番号13以上(int 所得段階index) {
        switch (所得段階index) {
            case INDEX_14:
                return 所得段階_14;
            case INDEX_15:
                return 所得段階_15;
            case INDEX_16:
                return 所得段階_16;
            case INDEX_17:
                return 所得段階_17;
            case INDEX_18:
                return 所得段階_18;
            case INDEX_19:
                return 所得段階_19;
            case INDEX_20:
                return 所得段階_20;
            case INDEX_21:
                return 所得段階_21;
            case INDEX_22:
                return 所得段階_22;
            case INDEX_23:
                return 所得段階_23;
            case INDEX_24:
                return 所得段階_24;
            case INDEX_25:
                return 所得段階_25;
            case INDEX_26:
                return 所得段階_26;
            case INDEX_27:
                return 所得段階_27;
            default:
                return RString.EMPTY;
        }
    }
}
