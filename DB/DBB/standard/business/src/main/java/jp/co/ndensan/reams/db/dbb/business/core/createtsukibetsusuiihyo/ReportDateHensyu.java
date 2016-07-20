/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.createtsukibetsusuiihyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.GemmenJyoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.KoumokuGoukey;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tsukibetsusuiihyo.TsukibetsuSuiihyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票用データEntity編集クラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public class ReportDateHensyu {

    private static final Decimal ZERO = new Decimal(0);
    private static final RString 合計 = new RString("合計");
    private static final RString 不明 = new RString("不明");
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private static final int INT_15 = 15;
    private static final int INT_16 = 16;
    private static final int INT_17 = 17;
    private static final int INT_18 = 18;
    private static final RString 第一段階 = new RString("010");
    private static final RString 第二段階 = new RString("020");
    private static final RString 第三段階 = new RString("030");
    private static final RString 第四段階 = new RString("040");
    private static final RString 第五段階 = new RString("050");
    private static final RString 第六段階 = new RString("060");
    private static final RString 第七段階 = new RString("070");
    private static final RString 第八段階 = new RString("080");
    private static final RString 第九段階 = new RString("090");
    private static final RString 第十段階 = new RString("010");
    private static final RString 第十一段階 = new RString("110");
    private static final RString 第十二段階 = new RString("120");
    private static final RString 第十三段階 = new RString("130");
    private static final RString 第十四段階 = new RString("140");
    private static final RString 第十五段階 = new RString("150");
    private static final RString 第十六段階 = new RString("160");
    private static final RString 第十七段階 = new RString("170");
    private static final RString 第十八段階 = new RString("180");
    private static final RString 第十九段階 = new RString("190");
    private int i;

    /**
     * コンストラクタ。
     */
    public ReportDateHensyu() {
    }

    /**
     * 月別推移表（帳票）のEntityの編集です。
     *
     * @param koumokuGoukeyList List<KoumokuGoukey>
     * @param 元号 元号
     * @param 年度 年度
     * @param 徴収方法 徴収方法
     * @param 保険者名 保険者名
     * @param 保険者番号 保険者番号
     * @param 表記List List<RString>
     * @return 月別推移表（帳票）のEntity
     */
    public TsukibetsuSuiihyoEntity getTsukibetsuSuiihyoEntity(List<KoumokuGoukey> koumokuGoukeyList,
            RString 元号, RString 年度, RString 徴収方法, RString 保険者名, RString 保険者番号, List<RString> 表記List) {
        TsukibetsuSuiihyoEntity entity = new TsukibetsuSuiihyoEntity();
        entity.set発行日時(RDate.getNowDateTime());
        entity.set元号(元号);
        entity.set年度(年度);
        entity.set保険者名(保険者名);
        entity.set保険者番号(保険者番号);
        entity.set徴収方法Title(徴収方法);
        if (koumokuGoukeyList == null || koumokuGoukeyList.isEmpty()) {
            entity.set人数_1段階_4月(new RString("該当者無し"));
            return entity;
        }
        int listLength = koumokuGoukeyList.size();
        i = 0;
        if (listLength > i && 第一段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_1段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_1段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_1段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_1段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_1段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_1段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_1段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_1段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_1段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_1段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_1段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_1段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_1段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_1段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_1段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_1段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_1段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_1段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_1段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_1段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_1段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_1段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_1段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_1段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_1段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_1段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_1段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_1段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_1段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_1段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_1段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_1段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_1段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_1段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第二段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_2段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_2段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_2段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_2段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_2段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_2段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_2段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_2段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_2段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_2段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_2段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_2段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_2段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_2段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_2段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_2段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_2段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_2段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_2段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_2段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_2段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_2段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_2段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_2段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_2段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_2段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_2段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_2段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_2段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_2段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_2段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_2段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_2段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_2段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第三段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_3段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_3段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_3段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_3段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_3段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_3段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_3段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_3段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_3段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_3段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_3段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_3段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_3段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_3段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_3段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_3段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_3段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_3段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_3段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_3段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_3段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_3段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_3段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_3段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_3段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_3段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_3段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_3段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_3段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_3段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_3段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_3段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_3段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_3段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        entity = set4段階_6段階(entity, koumokuGoukeyList);
        entity = set7段階_9段階(entity, koumokuGoukeyList);
        entity = set10段階_12段階(entity, koumokuGoukeyList);
        entity = set13段階_15段階(entity, koumokuGoukeyList);
        entity = set16段階_18段階(entity, koumokuGoukeyList);
        entity = set19段階_合計(entity, koumokuGoukeyList);
        return set段階_Title(entity, 表記List);
    }

    private TsukibetsuSuiihyoEntity set4段階_6段階(TsukibetsuSuiihyoEntity entity, List<KoumokuGoukey> koumokuGoukeyList) {
        int listLength = koumokuGoukeyList.size();
        if (listLength > i && 第四段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_4段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_4段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_4段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_4段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_4段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_4段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_4段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_4段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_4段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_4段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_4段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_4段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_4段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_4段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_4段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_4段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_4段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_4段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_4段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_4段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_4段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_4段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_4段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_4段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_4段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_4段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_4段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_4段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_4段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_4段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_4段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_4段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_4段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_4段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第五段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_5段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_5段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_5段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_5段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_5段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_5段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_5段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_5段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_5段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_5段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_5段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_5段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_5段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_5段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_5段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_5段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_5段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_5段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_5段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_5段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_5段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_5段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_5段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_5段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_5段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_5段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_5段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_5段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_5段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_5段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_5段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_5段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_5段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_5段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第六段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_6段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_6段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_6段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_6段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_6段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_6段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_6段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_6段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_6段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_6段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_6段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_6段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_6段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_6段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_6段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_6段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_6段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_6段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_6段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_6段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_6段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_6段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_6段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_6段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_6段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_6段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_6段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_6段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_6段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_6段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_6段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_6段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_6段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_6段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity set7段階_9段階(TsukibetsuSuiihyoEntity entity, List<KoumokuGoukey> koumokuGoukeyList) {
        int listLength = koumokuGoukeyList.size();
        if (listLength > i && 第七段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_7段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_7段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_7段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_7段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_7段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_7段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_7段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_7段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_7段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_7段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_7段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_7段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_7段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_7段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_7段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_7段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_7段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_7段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_7段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_7段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_7段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_7段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_7段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_7段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_7段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_7段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_7段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_7段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_7段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_7段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_7段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_7段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_7段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_7段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第八段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_8段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_8段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_8段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_8段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_8段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_8段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_8段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_8段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_8段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_8段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_8段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_8段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_8段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_8段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_8段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_8段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_8段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_8段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_8段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_8段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_8段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_8段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_8段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_8段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_8段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_8段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_8段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_8段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_8段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_8段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_8段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_8段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_8段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_8段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第九段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_9段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_9段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_9段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_9段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_9段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_9段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_9段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_9段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_9段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_9段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_9段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_9段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_9段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_9段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_9段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_9段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_9段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_9段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_9段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_9段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_9段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_9段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_9段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_9段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_9段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_9段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_9段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_9段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_9段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_9段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_9段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_9段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_9段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_9段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity set10段階_12段階(TsukibetsuSuiihyoEntity entity, List<KoumokuGoukey> koumokuGoukeyList) {
        int listLength = koumokuGoukeyList.size();
        if (listLength > i && 第十段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_10段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_10段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_10段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_10段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_10段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_10段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_10段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_10段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_10段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_10段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_10段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_10段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_10段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_10段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_10段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_10段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_10段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_10段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_10段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_10段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_10段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_10段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_10段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_10段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_10段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_10段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_10段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_10段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_10段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_10段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_10段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_10段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_10段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_10段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第十一段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_11段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_11段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_11段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_11段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_11段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_11段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_11段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_11段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_11段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_11段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_11段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_11段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_11段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_11段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_11段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_11段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_11段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_11段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_11段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_11段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_11段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_11段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_11段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_11段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_11段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_11段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_11段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_11段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_11段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_11段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_11段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_11段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_11段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_11段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第十二段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_12段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_12段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_12段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_12段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_12段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_12段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_12段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_12段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_12段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_12段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_12段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_12段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_12段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_12段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_12段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_12段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_12段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_12段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_12段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_12段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_12段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_12段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_12段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_12段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_12段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_12段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_12段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_12段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_12段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_12段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_12段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_12段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_12段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_12段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity set13段階_15段階(TsukibetsuSuiihyoEntity entity, List<KoumokuGoukey> koumokuGoukeyList) {
        int listLength = koumokuGoukeyList.size();
        if (listLength > i && 第十三段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_13段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_13段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_13段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_13段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_13段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_13段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_13段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_13段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_13段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_13段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_13段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_13段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_13段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_13段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_13段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_13段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_13段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_13段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_13段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_13段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_13段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_13段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_13段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_13段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_13段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_13段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_13段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_13段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_13段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_13段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_13段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_13段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_13段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_13段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第十四段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_14段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_14段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_14段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_14段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_14段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_14段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_14段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_14段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_14段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_14段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_14段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_14段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_14段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_14段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_14段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_14段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_14段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_14段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_14段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_14段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_14段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_14段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_14段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_14段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_14段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_14段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_14段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_14段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_14段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_14段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_14段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_14段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_14段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_14段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第十五段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_15段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_15段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_15段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_15段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_15段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_15段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_15段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_15段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_15段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_15段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_15段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_15段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_15段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_15段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_15段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_15段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_15段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_15段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_15段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_15段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_15段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_15段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_15段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_15段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_15段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_15段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_15段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_15段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_15段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_15段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_15段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_15段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_15段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_15段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity set16段階_18段階(TsukibetsuSuiihyoEntity entity, List<KoumokuGoukey> koumokuGoukeyList) {
        int listLength = koumokuGoukeyList.size();
        if (listLength > i && 第十六段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_16段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_16段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_16段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_16段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_16段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_16段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_16段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_16段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_16段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_16段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_16段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_16段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_16段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_16段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_16段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_16段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_16段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_16段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_16段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_16段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_16段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_16段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_16段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_16段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_16段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_16段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_16段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_16段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_16段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_16段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_16段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_16段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_16段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_16段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第十七段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_17段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_17段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_17段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_17段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_17段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_17段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_17段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_17段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_17段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_17段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_17段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_17段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_17段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_17段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_17段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_17段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_17段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_17段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_17段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_17段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_17段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_17段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_17段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_17段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_17段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_17段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_17段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_17段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_17段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_17段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_17段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_17段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_17段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_17段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        if (listLength > i && 第十八段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_18段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_18段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_18段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_18段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_18段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_18段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_18段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_18段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_18段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_18段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_18段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_18段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_18段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_18段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_18段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_18段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_18段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_18段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_18段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_18段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_18段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_18段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_18段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_18段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_18段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_18段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_18段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_18段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_18段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_18段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_18段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_18段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_18段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_18段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity set19段階_合計(TsukibetsuSuiihyoEntity entity, List<KoumokuGoukey> koumokuGoukeyList) {
        int listLength = koumokuGoukeyList.size();
        if (listLength > i && 第十九段階.equals(koumokuGoukeyList.get(i).getHokenryoDankai())) {
            entity.set人数_19段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set人数_19段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuNinsuuGoukeyi()));
            entity.set人数_19段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuNinsuuGoukeyi()));
            entity.set人数_19段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_19段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_19段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_19段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_19段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_19段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_19段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_19段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuNinsuuGoukeyi()));
            entity.set人数_19段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuNinsuuGoukeyi()));
            entity.set人数_19段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuNinsuuGoukeyi()));
            entity.set人数_19段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の人数合計()));
            entity.set人数_19段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の人数合計()));
            entity.set人数_19段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の人数合計()));
            entity.set人数_19段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の人数合計()));
            entity.set金額_19段階_Title(koumokuGoukeyList.get(i).getHokenryoDankai());
            entity.set金額_19段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getYoGetuKinkakuGoukeyi()));
            entity.set金額_19段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getGoGetuKinkakuGoukeyi()));
            entity.set金額_19段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_19段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_19段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_19段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_19段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_19段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_19段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_19段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getItiGetuKinkakuGoukeyi()));
            entity.set金額_19段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getNiGetuKinkakuGoukeyi()));
            entity.set金額_19段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).getSanGetuKinkakuGoukeyi()));
            entity.set金額_19段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get現年随時の金額合計()));
            entity.set金額_19段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get過年度の金額合計()));
            entity.set金額_19段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get該当段階の金額合計()));
            entity.set金額_19段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(i).get歳出還付の金額合計()));
            i = i + 1;
        }
        for (KoumokuGoukey koumokuGoukey : koumokuGoukeyList) {
            if (不明.equals(koumokuGoukey.getHokenryoDankai())) {
                entity.set人数_20段階_Title(koumokuGoukey.getHokenryoDankai());
                entity.set人数_20段階_4月(getNinsuuOrKinkaku(koumokuGoukey.getYoGetuNinsuuGoukeyi()));
                entity.set人数_20段階_5月(getNinsuuOrKinkaku(koumokuGoukey.getGoGetuNinsuuGoukeyi()));
                entity.set人数_20段階_6月(getNinsuuOrKinkaku(koumokuGoukey.getRokuGetuNinsuuGoukeyi()));
                entity.set人数_20段階_7月(getNinsuuOrKinkaku(koumokuGoukey.getNanaGetuNinsuuGoukeyi()));
                entity.set人数_20段階_8月(getNinsuuOrKinkaku(koumokuGoukey.getHatiGetuNinsuuGoukeyi()));
                entity.set人数_20段階_9月(getNinsuuOrKinkaku(koumokuGoukey.getKyuGetuNinsuuGoukeyi()));
                entity.set人数_20段階_10月(getNinsuuOrKinkaku(koumokuGoukey.getJyuGetuNinsuuGoukeyi()));
                entity.set人数_20段階_11月(getNinsuuOrKinkaku(koumokuGoukey.getJyuitiGetuNinsuuGoukeyi()));
                entity.set人数_20段階_12月(getNinsuuOrKinkaku(koumokuGoukey.getJyuniGetuNinsuuGoukeyi()));
                entity.set人数_20段階_1月(getNinsuuOrKinkaku(koumokuGoukey.getItiGetuNinsuuGoukeyi()));
                entity.set人数_20段階_2月(getNinsuuOrKinkaku(koumokuGoukey.getNiGetuNinsuuGoukeyi()));
                entity.set人数_20段階_3月(getNinsuuOrKinkaku(koumokuGoukey.getSanGetuNinsuuGoukeyi()));
                entity.set人数_20段階_現年随時(getNinsuuOrKinkaku(koumokuGoukey.get現年随時の人数合計()));
                entity.set人数_20段階_過年度(getNinsuuOrKinkaku(koumokuGoukey.get過年度の人数合計()));
                entity.set人数_20段階_合計(getNinsuuOrKinkaku(koumokuGoukey.get該当段階の人数合計()));
                entity.set人数_20段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukey.get歳出還付の人数合計()));
                entity.set金額_20段階_Title(koumokuGoukey.getHokenryoDankai());
                entity.set金額_20段階_4月(getNinsuuOrKinkaku(koumokuGoukey.getYoGetuKinkakuGoukeyi()));
                entity.set金額_20段階_5月(getNinsuuOrKinkaku(koumokuGoukey.getGoGetuKinkakuGoukeyi()));
                entity.set金額_20段階_6月(getNinsuuOrKinkaku(koumokuGoukey.getRokuGetuKinkakuGoukeyi()));
                entity.set金額_20段階_7月(getNinsuuOrKinkaku(koumokuGoukey.getNanaGetuKinkakuGoukeyi()));
                entity.set金額_20段階_8月(getNinsuuOrKinkaku(koumokuGoukey.getHatiGetuKinkakuGoukeyi()));
                entity.set金額_20段階_9月(getNinsuuOrKinkaku(koumokuGoukey.getKyuGetuKinkakuGoukeyi()));
                entity.set金額_20段階_10月(getNinsuuOrKinkaku(koumokuGoukey.getJyuGetuKinkakuGoukeyi()));
                entity.set金額_20段階_11月(getNinsuuOrKinkaku(koumokuGoukey.getJyuitiGetuKinkakuGoukeyi()));
                entity.set金額_20段階_12月(getNinsuuOrKinkaku(koumokuGoukey.getJyuniGetuKinkakuGoukeyi()));
                entity.set金額_20段階_1月(getNinsuuOrKinkaku(koumokuGoukey.getItiGetuKinkakuGoukeyi()));
                entity.set金額_20段階_2月(getNinsuuOrKinkaku(koumokuGoukey.getNiGetuKinkakuGoukeyi()));
                entity.set金額_20段階_3月(getNinsuuOrKinkaku(koumokuGoukey.getSanGetuKinkakuGoukeyi()));
                entity.set金額_20段階_現年随時(getNinsuuOrKinkaku(koumokuGoukey.get現年随時の金額合計()));
                entity.set金額_20段階_過年度(getNinsuuOrKinkaku(koumokuGoukey.get過年度の金額合計()));
                entity.set金額_20段階_合計(getNinsuuOrKinkaku(koumokuGoukey.get該当段階の金額合計()));
                entity.set金額_20段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukey.get歳出還付の金額合計()));
            }
            if (合計.equals(koumokuGoukey.getHokenryoDankai())) {
                entity.set人数_合計_Title(koumokuGoukey.getHokenryoDankai());
                entity.set人数_合計_4月(getNinsuuOrKinkaku(koumokuGoukey.getYoGetuNinsuuGoukeyi()));
                entity.set人数_合計_5月(getNinsuuOrKinkaku(koumokuGoukey.getGoGetuNinsuuGoukeyi()));
                entity.set人数_合計_6月(getNinsuuOrKinkaku(koumokuGoukey.getRokuGetuNinsuuGoukeyi()));
                entity.set人数_合計_7月(getNinsuuOrKinkaku(koumokuGoukey.getNanaGetuNinsuuGoukeyi()));
                entity.set人数_合計_8月(getNinsuuOrKinkaku(koumokuGoukey.getHatiGetuNinsuuGoukeyi()));
                entity.set人数_合計_9月(getNinsuuOrKinkaku(koumokuGoukey.getKyuGetuNinsuuGoukeyi()));
                entity.set人数_合計_10月(getNinsuuOrKinkaku(koumokuGoukey.getJyuGetuNinsuuGoukeyi()));
                entity.set人数_合計_11月(getNinsuuOrKinkaku(koumokuGoukey.getJyuitiGetuNinsuuGoukeyi()));
                entity.set人数_合計_12月(getNinsuuOrKinkaku(koumokuGoukey.getJyuniGetuNinsuuGoukeyi()));
                entity.set人数_合計_1月(getNinsuuOrKinkaku(koumokuGoukey.getItiGetuNinsuuGoukeyi()));
                entity.set人数_合計_2月(getNinsuuOrKinkaku(koumokuGoukey.getNiGetuNinsuuGoukeyi()));
                entity.set人数_合計_3月(getNinsuuOrKinkaku(koumokuGoukey.getSanGetuNinsuuGoukeyi()));
                entity.set人数_合計_現年随時(getNinsuuOrKinkaku(koumokuGoukey.get現年随時の人数合計()));
                entity.set人数_合計_過年度(getNinsuuOrKinkaku(koumokuGoukey.get過年度の人数合計()));
                entity.set人数_合計_合計(getNinsuuOrKinkaku(koumokuGoukey.get該当段階の人数合計()));
                entity.set人数_合計_歳出還付(getNinsuuOrKinkaku(koumokuGoukey.get歳出還付の人数合計()));
                entity.set金額_合計_Title(koumokuGoukey.getHokenryoDankai());
                entity.set金額_合計_4月(getNinsuuOrKinkaku(koumokuGoukey.getYoGetuKinkakuGoukeyi()));
                entity.set金額_合計_5月(getNinsuuOrKinkaku(koumokuGoukey.getGoGetuKinkakuGoukeyi()));
                entity.set金額_合計_6月(getNinsuuOrKinkaku(koumokuGoukey.getRokuGetuKinkakuGoukeyi()));
                entity.set金額_合計_7月(getNinsuuOrKinkaku(koumokuGoukey.getNanaGetuKinkakuGoukeyi()));
                entity.set金額_合計_8月(getNinsuuOrKinkaku(koumokuGoukey.getHatiGetuKinkakuGoukeyi()));
                entity.set金額_合計_9月(getNinsuuOrKinkaku(koumokuGoukey.getKyuGetuKinkakuGoukeyi()));
                entity.set金額_合計_10月(getNinsuuOrKinkaku(koumokuGoukey.getJyuGetuKinkakuGoukeyi()));
                entity.set金額_合計_11月(getNinsuuOrKinkaku(koumokuGoukey.getJyuitiGetuKinkakuGoukeyi()));
                entity.set金額_合計_12月(getNinsuuOrKinkaku(koumokuGoukey.getJyuniGetuKinkakuGoukeyi()));
                entity.set金額_合計_1月(getNinsuuOrKinkaku(koumokuGoukey.getItiGetuKinkakuGoukeyi()));
                entity.set金額_合計_2月(getNinsuuOrKinkaku(koumokuGoukey.getNiGetuKinkakuGoukeyi()));
                entity.set金額_合計_3月(getNinsuuOrKinkaku(koumokuGoukey.getSanGetuKinkakuGoukeyi()));
                entity.set金額_合計_現年随時(getNinsuuOrKinkaku(koumokuGoukey.get現年随時の金額合計()));
                entity.set金額_合計_過年度(getNinsuuOrKinkaku(koumokuGoukey.get過年度の金額合計()));
                entity.set金額_合計_合計(getNinsuuOrKinkaku(koumokuGoukey.get該当段階の金額合計()));
                entity.set金額_合計_歳出還付(getNinsuuOrKinkaku(koumokuGoukey.get歳出還付の金額合計()));
            }
        }
        return entity;
    }

    private RString getNinsuuOrKinkaku(Decimal temp) {
        if (temp == null || temp.compareTo(ZERO) == 0) {
            return RString.EMPTY;
        }
        return new RString(temp.toString());
    }

    /**
     * 月別推移表（帳票）のEntityの編集です。
     *
     * @param gemmenJyohoList List<GemmenJyoho>
     * @param 元号 元号
     * @param 年度 年度
     * @param 徴収方法 徴収方法
     * @param 保険者名 保険者名
     * @param 保険者番号 保険者番号
     * @param 表記List List<RString>
     * @return 月別推移表（帳票）のEntity
     */
    public TsukibetsuSuiihyoEntity getGemmen_TsukibetsuSuiihyoEntity(List<GemmenJyoho> gemmenJyohoList,
            RString 元号, RString 年度, RString 徴収方法, RString 保険者名, RString 保険者番号, List<RString> 表記List) {
        TsukibetsuSuiihyoEntity entity = new TsukibetsuSuiihyoEntity();
        entity.set発行日時(RDate.getNowDateTime());
        entity.set元号(元号);
        entity.set年度(年度);
        entity.set保険者名(保険者名);
        entity.set保険者番号(保険者番号);
        entity.set徴収方法Title(徴収方法);
        if (gemmenJyohoList == null || gemmenJyohoList.isEmpty()) {
            entity.set人数_1段階_4月(new RString("該当者無し"));
            return entity;
        }
        int listLength = gemmenJyohoList.size();
        i = 0;
        if (listLength > i && 第一段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_1段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_1段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_1段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_1段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_1段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_1段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        if (listLength > i && 第二段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_2段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_2段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_2段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_2段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_2段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_2段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        if (listLength > i && 第三段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_3段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_3段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_3段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_3段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_3段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_3段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        if (listLength > i && 第四段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_4段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_4段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_4段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_4段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_4段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_4段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        if (listLength > i && 第五段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_5段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_5段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_5段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_5段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_5段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_5段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        if (listLength > i && 第六段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_6段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_6段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_6段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_6段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_6段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_6段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        entity = setGemmen_8段階_12段階(entity, gemmenJyohoList);
        entity = setGemmen_13段階_15段階(entity, gemmenJyohoList);
        entity = setGemmen_16段階_合計(entity, gemmenJyohoList);
        return set段階_Title(entity, 表記List);
    }

    private TsukibetsuSuiihyoEntity setGemmen_8段階_12段階(TsukibetsuSuiihyoEntity entity, List<GemmenJyoho> gemmenJyohoList) {
        int listLength = gemmenJyohoList.size();
        if (listLength > i && 第七段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_7段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_7段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_7段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_7段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_7段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_7段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        if (listLength > i && 第八段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_8段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_8段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_8段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_8段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_8段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_8段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        if (listLength > i && 第九段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_9段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_9段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_9段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_9段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_9段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_9段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        if (listLength > i && 第十段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_10段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_10段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_10段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_10段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_10段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_10段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        if (listLength > i && 第十一段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_11段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_11段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_11段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_11段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_11段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_11段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        if (listLength > i && 第十二段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_12段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_12段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_12段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_12段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_12段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_12段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
            i = i + 1;
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity setGemmen_13段階_15段階(TsukibetsuSuiihyoEntity entity, List<GemmenJyoho> gemmenJyohoList) {
        int listLength = gemmenJyohoList.size();
        if (listLength > i && 第十三段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_13段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_13段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_13段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_13段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_13段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_13段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength > i && 第十四段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_14段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_14段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_14段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_14段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_14段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_14段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength > i && 第十五段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_15段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_15段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_15段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_15段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_15段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_15段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity setGemmen_16段階_合計(TsukibetsuSuiihyoEntity entity, List<GemmenJyoho> gemmenJyohoList) {
        int listLength = gemmenJyohoList.size();
        if (listLength > i && 第十六段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_16段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_16段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_16段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_16段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_16段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_16段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength > i && 第十七段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_17段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_17段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_17段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_17段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_17段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_17段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength > i && 第十八段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_18段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_18段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_18段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_18段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_18段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_18段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength > i && 第十九段階.equals(gemmenJyohoList.get(i).getHokenryoDankai())) {
            entity.set人数_19段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set人数_19段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_19段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_19段階_Title(gemmenJyohoList.get(i).getHokenryoDankai());
            entity.set金額_19段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_19段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(i).getHoDankaiKanendoGemenGakuGoukei()));
        }
        for (GemmenJyoho gemmenJyoho : gemmenJyohoList) {
            if (不明.equals(gemmenJyoho.getHokenryoDankai())) {
                entity.set人数_20段階_Title(gemmenJyoho.getHokenryoDankai());
                entity.set人数_20段階_過年度(getNinsuuOrKinkaku(gemmenJyoho.getHokenryoDankaiKanendoNinsu()));
                entity.set人数_20段階_合計(getNinsuuOrKinkaku(gemmenJyoho.getHoDankaiKanendoGemmenGaku()));
                entity.set金額_20段階_Title(gemmenJyoho.getHokenryoDankai());
                entity.set金額_20段階_過年度(getNinsuuOrKinkaku(gemmenJyoho.getHoDankaiKanendoNinsuGoukeyi()));
                entity.set金額_20段階_合計(getNinsuuOrKinkaku(gemmenJyoho.getHoDankaiKanendoGemenGakuGoukei()));
            }
            if (合計.equals(gemmenJyoho.getHokenryoDankai())) {
                entity.set人数_合計_Title(gemmenJyoho.getHokenryoDankai());
                entity.set人数_合計_過年度(getNinsuuOrKinkaku(gemmenJyoho.getHokenryoDankaiKanendoNinsu()));
                entity.set人数_合計_合計(getNinsuuOrKinkaku(gemmenJyoho.getHoDankaiKanendoGemmenGaku()));
                entity.set金額_合計_Title(gemmenJyoho.getHokenryoDankai());
                entity.set金額_合計_過年度(getNinsuuOrKinkaku(gemmenJyoho.getHoDankaiKanendoNinsuGoukeyi()));
                entity.set金額_合計_合計(getNinsuuOrKinkaku(gemmenJyoho.getHoDankaiKanendoGemenGakuGoukei()));
            }
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity set段階_Title(TsukibetsuSuiihyoEntity entity, List<RString> 表記List) {
        if (0 < 表記List.size()) {
            entity.set人数_1段階_Title(表記List.get(0));
            entity.set金額_1段階_Title(表記List.get(0));
        }
        if (1 < 表記List.size()) {
            entity.set人数_2段階_Title(表記List.get(1));
            entity.set金額_2段階_Title(表記List.get(1));
        }
        if (2 < 表記List.size()) {
            entity.set人数_3段階_Title(表記List.get(2));
            entity.set金額_3段階_Title(表記List.get(2));
        }
        if (INT_3 < 表記List.size()) {
            entity.set人数_4段階_Title(表記List.get(INT_3));
            entity.set金額_4段階_Title(表記List.get(INT_3));
        }
        if (INT_4 < 表記List.size()) {
            entity.set人数_5段階_Title(表記List.get(INT_4));
            entity.set金額_5段階_Title(表記List.get(INT_4));
        }
        if (INT_5 < 表記List.size()) {
            entity.set人数_6段階_Title(表記List.get(INT_5));
            entity.set金額_6段階_Title(表記List.get(INT_5));
        }
        if (INT_6 < 表記List.size()) {
            entity.set人数_7段階_Title(表記List.get(INT_6));
            entity.set金額_7段階_Title(表記List.get(INT_6));
        }
        if (INT_7 < 表記List.size()) {
            entity.set人数_8段階_Title(表記List.get(INT_7));
            entity.set金額_8段階_Title(表記List.get(INT_7));
        }
        if (INT_8 < 表記List.size()) {
            entity.set人数_9段階_Title(表記List.get(INT_8));
            entity.set金額_9段階_Title(表記List.get(INT_8));
        }
        if (INT_9 < 表記List.size()) {
            entity.set人数_10段階_Title(表記List.get(INT_9));
            entity.set金額_10段階_Title(表記List.get(INT_9));
        }
        if (INT_10 < 表記List.size()) {
            entity.set人数_11段階_Title(表記List.get(INT_10));
            entity.set金額_11段階_Title(表記List.get(INT_10));
        }
        if (INT_11 < 表記List.size()) {
            entity.set人数_12段階_Title(表記List.get(INT_11));
            entity.set金額_12段階_Title(表記List.get(INT_11));
        }
        if (INT_12 < 表記List.size()) {
            entity.set人数_13段階_Title(表記List.get(INT_12));
            entity.set金額_13段階_Title(表記List.get(INT_12));
        }
        if (INT_13 < 表記List.size()) {
            entity.set人数_14段階_Title(表記List.get(INT_13));
            entity.set金額_14段階_Title(表記List.get(INT_13));
        }
        if (INT_14 < 表記List.size()) {
            entity.set人数_15段階_Title(表記List.get(INT_14));
            entity.set金額_15段階_Title(表記List.get(INT_14));
        }
        return set段階_Title1(entity, 表記List);
    }

    private TsukibetsuSuiihyoEntity set段階_Title1(TsukibetsuSuiihyoEntity entity, List<RString> 表記List) {
        if (INT_15 < 表記List.size()) {
            entity.set人数_16段階_Title(表記List.get(INT_15));
            entity.set金額_16段階_Title(表記List.get(INT_15));
        }
        if (INT_16 < 表記List.size()) {
            entity.set人数_17段階_Title(表記List.get(INT_16));
            entity.set金額_17段階_Title(表記List.get(INT_16));
        }
        if (INT_17 < 表記List.size()) {
            entity.set人数_18段階_Title(表記List.get(INT_17));
            entity.set金額_18段階_Title(表記List.get(INT_17));
        }
        if (INT_18 < 表記List.size()) {
            entity.set人数_19段階_Title(表記List.get(INT_18));
            entity.set金額_19段階_Title(表記List.get(INT_17));
        }
        return entity;
    }
}
