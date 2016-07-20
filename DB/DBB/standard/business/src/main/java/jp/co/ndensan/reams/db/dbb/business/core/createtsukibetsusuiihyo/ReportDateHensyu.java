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
        if (listLength > 0) {
            entity.set人数_1段階_Title(koumokuGoukeyList.get(0).getHokenryoDankai());
            entity.set人数_1段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getYoGetuNinsuuGoukeyi()));
            entity.set人数_1段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getGoGetuNinsuuGoukeyi()));
            entity.set人数_1段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_1段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_1段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_1段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_1段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_1段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_1段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_1段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getItiGetuNinsuuGoukeyi()));
            entity.set人数_1段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getNiGetuNinsuuGoukeyi()));
            entity.set人数_1段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getSanGetuNinsuuGoukeyi()));
            entity.set人数_1段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).get現年随時の人数合計()));
            entity.set人数_1段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).get過年度の人数合計()));
            entity.set人数_1段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).get該当段階の人数合計()));
            entity.set人数_1段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).get歳出還付の人数合計()));
            entity.set金額_1段階_Title(koumokuGoukeyList.get(0).getHokenryoDankai());
            entity.set金額_1段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getYoGetuKinkakuGoukeyi()));
            entity.set金額_1段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getGoGetuKinkakuGoukeyi()));
            entity.set金額_1段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_1段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_1段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_1段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_1段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_1段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_1段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_1段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getItiGetuKinkakuGoukeyi()));
            entity.set金額_1段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getNiGetuKinkakuGoukeyi()));
            entity.set金額_1段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).getSanGetuKinkakuGoukeyi()));
            entity.set金額_1段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).get現年随時の金額合計()));
            entity.set金額_1段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).get過年度の金額合計()));
            entity.set金額_1段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).get該当段階の金額合計()));
            entity.set金額_1段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(0).get歳出還付の金額合計()));
        }
        if (listLength - 1 > 1 && !不明.equals(koumokuGoukeyList.get(1).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(1).getHokenryoDankai())) {
            entity.set人数_2段階_Title(koumokuGoukeyList.get(1).getHokenryoDankai());
            entity.set人数_2段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getYoGetuNinsuuGoukeyi()));
            entity.set人数_2段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getGoGetuNinsuuGoukeyi()));
            entity.set人数_2段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_2段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_2段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_2段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_2段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_2段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_2段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_2段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getItiGetuNinsuuGoukeyi()));
            entity.set人数_2段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getNiGetuNinsuuGoukeyi()));
            entity.set人数_2段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getSanGetuNinsuuGoukeyi()));
            entity.set人数_2段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).get現年随時の人数合計()));
            entity.set人数_2段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).get過年度の人数合計()));
            entity.set人数_2段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).get該当段階の人数合計()));
            entity.set人数_2段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).get歳出還付の人数合計()));
            entity.set金額_2段階_Title(koumokuGoukeyList.get(1).getHokenryoDankai());
            entity.set金額_2段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getYoGetuKinkakuGoukeyi()));
            entity.set金額_2段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getGoGetuKinkakuGoukeyi()));
            entity.set金額_2段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_2段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_2段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_2段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_2段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_2段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_2段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_2段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getItiGetuKinkakuGoukeyi()));
            entity.set金額_2段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getNiGetuKinkakuGoukeyi()));
            entity.set金額_2段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).getSanGetuKinkakuGoukeyi()));
            entity.set金額_2段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).get現年随時の金額合計()));
            entity.set金額_2段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).get過年度の金額合計()));
            entity.set金額_2段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).get該当段階の金額合計()));
            entity.set金額_2段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(1).get歳出還付の金額合計()));
        }
        if (listLength - 1 > 2 && !不明.equals(koumokuGoukeyList.get(2).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(2).getHokenryoDankai())) {
            entity.set人数_3段階_Title(koumokuGoukeyList.get(2).getHokenryoDankai());
            entity.set人数_3段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getYoGetuNinsuuGoukeyi()));
            entity.set人数_3段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getGoGetuNinsuuGoukeyi()));
            entity.set人数_3段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_3段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_3段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_3段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_3段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_3段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_3段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_3段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getItiGetuNinsuuGoukeyi()));
            entity.set人数_3段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getNiGetuNinsuuGoukeyi()));
            entity.set人数_3段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getSanGetuNinsuuGoukeyi()));
            entity.set人数_3段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).get現年随時の人数合計()));
            entity.set人数_3段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).get過年度の人数合計()));
            entity.set人数_3段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).get該当段階の人数合計()));
            entity.set人数_3段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).get歳出還付の人数合計()));
            entity.set金額_3段階_Title(koumokuGoukeyList.get(2).getHokenryoDankai());
            entity.set金額_3段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getYoGetuKinkakuGoukeyi()));
            entity.set金額_3段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getGoGetuKinkakuGoukeyi()));
            entity.set金額_3段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_3段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_3段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_3段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_3段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_3段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_3段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_3段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getItiGetuKinkakuGoukeyi()));
            entity.set金額_3段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getNiGetuKinkakuGoukeyi()));
            entity.set金額_3段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).getSanGetuKinkakuGoukeyi()));
            entity.set金額_3段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).get現年随時の金額合計()));
            entity.set金額_3段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).get過年度の金額合計()));
            entity.set金額_3段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).get該当段階の金額合計()));
            entity.set金額_3段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(2).get歳出還付の金額合計()));
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
        if (listLength - 1 > INT_3 && !不明.equals(koumokuGoukeyList.get(INT_3).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_3).getHokenryoDankai())) {
            entity.set人数_4段階_Title(koumokuGoukeyList.get(INT_3).getHokenryoDankai());
            entity.set人数_4段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getYoGetuNinsuuGoukeyi()));
            entity.set人数_4段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getGoGetuNinsuuGoukeyi()));
            entity.set人数_4段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_4段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_4段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_4段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_4段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_4段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_4段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_4段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getItiGetuNinsuuGoukeyi()));
            entity.set人数_4段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getNiGetuNinsuuGoukeyi()));
            entity.set人数_4段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getSanGetuNinsuuGoukeyi()));
            entity.set人数_4段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).get現年随時の人数合計()));
            entity.set人数_4段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).get過年度の人数合計()));
            entity.set人数_4段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).get該当段階の人数合計()));
            entity.set人数_4段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).get歳出還付の人数合計()));
            entity.set金額_4段階_Title(koumokuGoukeyList.get(INT_3).getHokenryoDankai());
            entity.set金額_4段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getYoGetuKinkakuGoukeyi()));
            entity.set金額_4段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getGoGetuKinkakuGoukeyi()));
            entity.set金額_4段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_4段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_4段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_4段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_4段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_4段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_4段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_4段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getItiGetuKinkakuGoukeyi()));
            entity.set金額_4段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getNiGetuKinkakuGoukeyi()));
            entity.set金額_4段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).getSanGetuKinkakuGoukeyi()));
            entity.set金額_4段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).get現年随時の金額合計()));
            entity.set金額_4段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).get過年度の金額合計()));
            entity.set金額_4段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).get該当段階の金額合計()));
            entity.set金額_4段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_3).get歳出還付の金額合計()));
        }
        if (listLength - 1 > INT_4 && !不明.equals(koumokuGoukeyList.get(INT_4).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_4).getHokenryoDankai())) {
            entity.set人数_5段階_Title(koumokuGoukeyList.get(INT_4).getHokenryoDankai());
            entity.set人数_5段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getYoGetuNinsuuGoukeyi()));
            entity.set人数_5段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getGoGetuNinsuuGoukeyi()));
            entity.set人数_5段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_5段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_5段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_5段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_5段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_5段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_5段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_5段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getItiGetuNinsuuGoukeyi()));
            entity.set人数_5段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getNiGetuNinsuuGoukeyi()));
            entity.set人数_5段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getSanGetuNinsuuGoukeyi()));
            entity.set人数_5段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).get現年随時の人数合計()));
            entity.set人数_5段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).get過年度の人数合計()));
            entity.set人数_5段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).get該当段階の人数合計()));
            entity.set人数_5段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).get歳出還付の人数合計()));
            entity.set金額_5段階_Title(koumokuGoukeyList.get(INT_4).getHokenryoDankai());
            entity.set金額_5段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getYoGetuKinkakuGoukeyi()));
            entity.set金額_5段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getGoGetuKinkakuGoukeyi()));
            entity.set金額_5段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_5段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_5段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_5段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_5段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_5段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_5段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_5段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getItiGetuKinkakuGoukeyi()));
            entity.set金額_5段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getNiGetuKinkakuGoukeyi()));
            entity.set金額_5段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).getSanGetuKinkakuGoukeyi()));
            entity.set金額_5段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).get現年随時の金額合計()));
            entity.set金額_5段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).get過年度の金額合計()));
            entity.set金額_5段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).get該当段階の金額合計()));
            entity.set金額_5段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_4).get歳出還付の金額合計()));
        }
        if (listLength - 1 > INT_5 && !不明.equals(koumokuGoukeyList.get(INT_5).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_5).getHokenryoDankai())) {
            entity.set人数_6段階_Title(koumokuGoukeyList.get(INT_5).getHokenryoDankai());
            entity.set人数_6段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getYoGetuNinsuuGoukeyi()));
            entity.set人数_6段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getGoGetuNinsuuGoukeyi()));
            entity.set人数_6段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_6段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_6段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_6段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_6段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_6段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_6段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_6段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getItiGetuNinsuuGoukeyi()));
            entity.set人数_6段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getNiGetuNinsuuGoukeyi()));
            entity.set人数_6段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getSanGetuNinsuuGoukeyi()));
            entity.set人数_6段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).get現年随時の人数合計()));
            entity.set人数_6段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).get過年度の人数合計()));
            entity.set人数_6段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).get該当段階の人数合計()));
            entity.set人数_6段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).get歳出還付の人数合計()));
            entity.set金額_6段階_Title(koumokuGoukeyList.get(INT_5).getHokenryoDankai());
            entity.set金額_6段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getYoGetuKinkakuGoukeyi()));
            entity.set金額_6段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getGoGetuKinkakuGoukeyi()));
            entity.set金額_6段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_6段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_6段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_6段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_6段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_6段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_6段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_6段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getItiGetuKinkakuGoukeyi()));
            entity.set金額_6段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getNiGetuKinkakuGoukeyi()));
            entity.set金額_6段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).getSanGetuKinkakuGoukeyi()));
            entity.set金額_6段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).get現年随時の金額合計()));
            entity.set金額_6段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).get過年度の金額合計()));
            entity.set金額_6段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).get該当段階の金額合計()));
            entity.set金額_6段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_5).get歳出還付の金額合計()));
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity set7段階_9段階(TsukibetsuSuiihyoEntity entity, List<KoumokuGoukey> koumokuGoukeyList) {
        int listLength = koumokuGoukeyList.size();
        if (listLength - 1 > INT_6 && !不明.equals(koumokuGoukeyList.get(INT_6).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_6).getHokenryoDankai())) {
            entity.set人数_7段階_Title(koumokuGoukeyList.get(INT_6).getHokenryoDankai());
            entity.set人数_7段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getYoGetuNinsuuGoukeyi()));
            entity.set人数_7段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getGoGetuNinsuuGoukeyi()));
            entity.set人数_7段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_7段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_7段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_7段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_7段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_7段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_7段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_7段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getItiGetuNinsuuGoukeyi()));
            entity.set人数_7段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getNiGetuNinsuuGoukeyi()));
            entity.set人数_7段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getSanGetuNinsuuGoukeyi()));
            entity.set人数_7段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).get現年随時の人数合計()));
            entity.set人数_7段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).get過年度の人数合計()));
            entity.set人数_7段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).get該当段階の人数合計()));
            entity.set人数_7段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).get歳出還付の人数合計()));
            entity.set金額_7段階_Title(koumokuGoukeyList.get(INT_6).getHokenryoDankai());
            entity.set金額_7段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getYoGetuKinkakuGoukeyi()));
            entity.set金額_7段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getGoGetuKinkakuGoukeyi()));
            entity.set金額_7段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_7段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_7段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_7段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_7段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_7段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_7段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_7段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getItiGetuKinkakuGoukeyi()));
            entity.set金額_7段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getNiGetuKinkakuGoukeyi()));
            entity.set金額_7段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).getSanGetuKinkakuGoukeyi()));
            entity.set金額_7段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).get現年随時の金額合計()));
            entity.set金額_7段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).get過年度の金額合計()));
            entity.set金額_7段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).get該当段階の金額合計()));
            entity.set金額_7段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_6).get歳出還付の金額合計()));
        }
        if (listLength - 1 > INT_7 && !不明.equals(koumokuGoukeyList.get(INT_7).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_7).getHokenryoDankai())) {
            entity.set人数_8段階_Title(koumokuGoukeyList.get(INT_7).getHokenryoDankai());
            entity.set人数_8段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getYoGetuNinsuuGoukeyi()));
            entity.set人数_8段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getGoGetuNinsuuGoukeyi()));
            entity.set人数_8段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_8段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_8段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_8段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_8段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_8段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_8段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_8段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getItiGetuNinsuuGoukeyi()));
            entity.set人数_8段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getNiGetuNinsuuGoukeyi()));
            entity.set人数_8段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getSanGetuNinsuuGoukeyi()));
            entity.set人数_8段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).get現年随時の人数合計()));
            entity.set人数_8段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).get過年度の人数合計()));
            entity.set人数_8段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).get該当段階の人数合計()));
            entity.set人数_8段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).get歳出還付の人数合計()));
            entity.set金額_8段階_Title(koumokuGoukeyList.get(INT_7).getHokenryoDankai());
            entity.set金額_8段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getYoGetuKinkakuGoukeyi()));
            entity.set金額_8段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getGoGetuKinkakuGoukeyi()));
            entity.set金額_8段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_8段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_8段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_8段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_8段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_8段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_8段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_8段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getItiGetuKinkakuGoukeyi()));
            entity.set金額_8段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getNiGetuKinkakuGoukeyi()));
            entity.set金額_8段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).getSanGetuKinkakuGoukeyi()));
            entity.set金額_8段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).get現年随時の金額合計()));
            entity.set金額_8段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).get過年度の金額合計()));
            entity.set金額_8段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).get該当段階の金額合計()));
            entity.set金額_8段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_7).get歳出還付の金額合計()));
        }
        if (listLength - 1 > INT_8 && !不明.equals(koumokuGoukeyList.get(INT_8).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_8).getHokenryoDankai())) {
            entity.set人数_9段階_Title(koumokuGoukeyList.get(INT_8).getHokenryoDankai());
            entity.set人数_9段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getYoGetuNinsuuGoukeyi()));
            entity.set人数_9段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getGoGetuNinsuuGoukeyi()));
            entity.set人数_9段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_9段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_9段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_9段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_9段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_9段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_9段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_9段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getItiGetuNinsuuGoukeyi()));
            entity.set人数_9段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getNiGetuNinsuuGoukeyi()));
            entity.set人数_9段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getSanGetuNinsuuGoukeyi()));
            entity.set人数_9段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).get現年随時の人数合計()));
            entity.set人数_9段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).get過年度の人数合計()));
            entity.set人数_9段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).get該当段階の人数合計()));
            entity.set人数_9段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).get歳出還付の人数合計()));
            entity.set金額_9段階_Title(koumokuGoukeyList.get(INT_8).getHokenryoDankai());
            entity.set金額_9段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getYoGetuKinkakuGoukeyi()));
            entity.set金額_9段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getGoGetuKinkakuGoukeyi()));
            entity.set金額_9段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_9段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_9段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_9段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_9段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_9段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_9段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_9段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getItiGetuKinkakuGoukeyi()));
            entity.set金額_9段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getNiGetuKinkakuGoukeyi()));
            entity.set金額_9段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).getSanGetuKinkakuGoukeyi()));
            entity.set金額_9段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).get現年随時の金額合計()));
            entity.set金額_9段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).get過年度の金額合計()));
            entity.set金額_9段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).get該当段階の金額合計()));
            entity.set金額_9段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_8).get歳出還付の金額合計()));
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity set10段階_12段階(TsukibetsuSuiihyoEntity entity, List<KoumokuGoukey> koumokuGoukeyList) {
        int listLength = koumokuGoukeyList.size();
        if (listLength - 1 > INT_9 && !不明.equals(koumokuGoukeyList.get(INT_9).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_9).getHokenryoDankai())) {
            entity.set人数_10段階_Title(koumokuGoukeyList.get(INT_9).getHokenryoDankai());
            entity.set人数_10段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getYoGetuNinsuuGoukeyi()));
            entity.set人数_10段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getGoGetuNinsuuGoukeyi()));
            entity.set人数_10段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_10段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_10段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_10段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_10段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_10段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_10段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_10段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getItiGetuNinsuuGoukeyi()));
            entity.set人数_10段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getNiGetuNinsuuGoukeyi()));
            entity.set人数_10段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getSanGetuNinsuuGoukeyi()));
            entity.set人数_10段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).get現年随時の人数合計()));
            entity.set人数_10段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).get過年度の人数合計()));
            entity.set人数_10段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).get該当段階の人数合計()));
            entity.set人数_10段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).get歳出還付の人数合計()));
            entity.set金額_10段階_Title(koumokuGoukeyList.get(INT_9).getHokenryoDankai());
            entity.set金額_10段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getYoGetuKinkakuGoukeyi()));
            entity.set金額_10段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getGoGetuKinkakuGoukeyi()));
            entity.set金額_10段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_10段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_10段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_10段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_10段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_10段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_10段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_10段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getItiGetuKinkakuGoukeyi()));
            entity.set金額_10段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getNiGetuKinkakuGoukeyi()));
            entity.set金額_10段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).getSanGetuKinkakuGoukeyi()));
            entity.set金額_10段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).get現年随時の金額合計()));
            entity.set金額_10段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).get過年度の金額合計()));
            entity.set金額_10段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).get該当段階の金額合計()));
            entity.set金額_10段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_9).get歳出還付の金額合計()));
        }
        if (listLength - 1 > INT_10 && !不明.equals(koumokuGoukeyList.get(INT_10).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_10).getHokenryoDankai())) {
            entity.set人数_11段階_Title(koumokuGoukeyList.get(INT_10).getHokenryoDankai());
            entity.set人数_11段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getYoGetuNinsuuGoukeyi()));
            entity.set人数_11段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getGoGetuNinsuuGoukeyi()));
            entity.set人数_11段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_11段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_11段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_11段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_11段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_11段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_11段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_11段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getItiGetuNinsuuGoukeyi()));
            entity.set人数_11段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getNiGetuNinsuuGoukeyi()));
            entity.set人数_11段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getSanGetuNinsuuGoukeyi()));
            entity.set人数_11段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).get現年随時の人数合計()));
            entity.set人数_11段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).get過年度の人数合計()));
            entity.set人数_11段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).get該当段階の人数合計()));
            entity.set人数_11段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).get歳出還付の人数合計()));
            entity.set金額_11段階_Title(koumokuGoukeyList.get(INT_10).getHokenryoDankai());
            entity.set金額_11段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getYoGetuKinkakuGoukeyi()));
            entity.set金額_11段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getGoGetuKinkakuGoukeyi()));
            entity.set金額_11段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_11段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_11段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_11段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_11段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_11段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_11段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_11段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getItiGetuKinkakuGoukeyi()));
            entity.set金額_11段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getNiGetuKinkakuGoukeyi()));
            entity.set金額_11段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).getSanGetuKinkakuGoukeyi()));
            entity.set金額_11段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).get現年随時の金額合計()));
            entity.set金額_11段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).get過年度の金額合計()));
            entity.set金額_11段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).get該当段階の金額合計()));
            entity.set金額_11段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_10).get歳出還付の金額合計()));
        }
        if (listLength - 1 > INT_11 && !不明.equals(koumokuGoukeyList.get(INT_11).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_11).getHokenryoDankai())) {
            entity.set人数_12段階_Title(koumokuGoukeyList.get(INT_11).getHokenryoDankai());
            entity.set人数_12段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getYoGetuNinsuuGoukeyi()));
            entity.set人数_12段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getGoGetuNinsuuGoukeyi()));
            entity.set人数_12段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_12段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_12段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_12段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_12段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_12段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_12段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_12段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getItiGetuNinsuuGoukeyi()));
            entity.set人数_12段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getNiGetuNinsuuGoukeyi()));
            entity.set人数_12段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getSanGetuNinsuuGoukeyi()));
            entity.set人数_12段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).get現年随時の人数合計()));
            entity.set人数_12段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).get過年度の人数合計()));
            entity.set人数_12段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).get該当段階の人数合計()));
            entity.set人数_12段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).get歳出還付の人数合計()));
            entity.set金額_12段階_Title(koumokuGoukeyList.get(INT_11).getHokenryoDankai());
            entity.set金額_12段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getYoGetuKinkakuGoukeyi()));
            entity.set金額_12段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getGoGetuKinkakuGoukeyi()));
            entity.set金額_12段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_12段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_12段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_12段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_12段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_12段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_12段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_12段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getItiGetuKinkakuGoukeyi()));
            entity.set金額_12段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getNiGetuKinkakuGoukeyi()));
            entity.set金額_12段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).getSanGetuKinkakuGoukeyi()));
            entity.set金額_12段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).get現年随時の金額合計()));
            entity.set金額_12段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).get過年度の金額合計()));
            entity.set金額_12段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).get該当段階の金額合計()));
            entity.set金額_12段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_11).get歳出還付の金額合計()));
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity set13段階_15段階(TsukibetsuSuiihyoEntity entity, List<KoumokuGoukey> koumokuGoukeyList) {
        int listLength = koumokuGoukeyList.size();
        if (listLength - 1 > INT_12 && !不明.equals(koumokuGoukeyList.get(INT_12).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_12).getHokenryoDankai())) {
            entity.set人数_13段階_Title(koumokuGoukeyList.get(INT_12).getHokenryoDankai());
            entity.set人数_13段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getYoGetuNinsuuGoukeyi()));
            entity.set人数_13段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getGoGetuNinsuuGoukeyi()));
            entity.set人数_13段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_13段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_13段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_13段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_13段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_13段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_13段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_13段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getItiGetuNinsuuGoukeyi()));
            entity.set人数_13段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getNiGetuNinsuuGoukeyi()));
            entity.set人数_13段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getSanGetuNinsuuGoukeyi()));
            entity.set人数_13段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).get現年随時の人数合計()));
            entity.set人数_13段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).get過年度の人数合計()));
            entity.set人数_13段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).get該当段階の人数合計()));
            entity.set人数_13段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).get歳出還付の人数合計()));
            entity.set金額_13段階_Title(koumokuGoukeyList.get(INT_12).getHokenryoDankai());
            entity.set金額_13段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getYoGetuKinkakuGoukeyi()));
            entity.set金額_13段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getGoGetuKinkakuGoukeyi()));
            entity.set金額_13段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_13段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_13段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_13段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_13段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_13段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_13段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_13段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getItiGetuKinkakuGoukeyi()));
            entity.set金額_13段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getNiGetuKinkakuGoukeyi()));
            entity.set金額_13段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).getSanGetuKinkakuGoukeyi()));
            entity.set金額_13段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).get現年随時の金額合計()));
            entity.set金額_13段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).get過年度の金額合計()));
            entity.set金額_13段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).get該当段階の金額合計()));
            entity.set金額_13段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_12).get歳出還付の金額合計()));
        }
        if (listLength - 1 > INT_13 && !不明.equals(koumokuGoukeyList.get(INT_13).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_13).getHokenryoDankai())) {
            entity.set人数_14段階_Title(koumokuGoukeyList.get(INT_13).getHokenryoDankai());
            entity.set人数_14段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getYoGetuNinsuuGoukeyi()));
            entity.set人数_14段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getGoGetuNinsuuGoukeyi()));
            entity.set人数_14段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_14段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_14段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_14段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_14段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_14段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_14段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_14段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getItiGetuNinsuuGoukeyi()));
            entity.set人数_14段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getNiGetuNinsuuGoukeyi()));
            entity.set人数_14段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getSanGetuNinsuuGoukeyi()));
            entity.set人数_14段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).get現年随時の人数合計()));
            entity.set人数_14段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).get過年度の人数合計()));
            entity.set人数_14段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).get該当段階の人数合計()));
            entity.set人数_14段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).get歳出還付の人数合計()));
            entity.set金額_14段階_Title(koumokuGoukeyList.get(INT_13).getHokenryoDankai());
            entity.set金額_14段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getYoGetuKinkakuGoukeyi()));
            entity.set金額_14段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getGoGetuKinkakuGoukeyi()));
            entity.set金額_14段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_14段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_14段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_14段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_14段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_14段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_14段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_14段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getItiGetuKinkakuGoukeyi()));
            entity.set金額_14段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getNiGetuKinkakuGoukeyi()));
            entity.set金額_14段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).getSanGetuKinkakuGoukeyi()));
            entity.set金額_14段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).get現年随時の金額合計()));
            entity.set金額_14段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).get過年度の金額合計()));
            entity.set金額_14段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).get該当段階の金額合計()));
            entity.set金額_14段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_13).get歳出還付の金額合計()));
        }
        if (listLength - 1 > INT_14 && !不明.equals(koumokuGoukeyList.get(INT_14).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_14).getHokenryoDankai())) {
            entity.set人数_15段階_Title(koumokuGoukeyList.get(INT_14).getHokenryoDankai());
            entity.set人数_15段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getYoGetuNinsuuGoukeyi()));
            entity.set人数_15段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getGoGetuNinsuuGoukeyi()));
            entity.set人数_15段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_15段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_15段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_15段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_15段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_15段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_15段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_15段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getItiGetuNinsuuGoukeyi()));
            entity.set人数_15段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getNiGetuNinsuuGoukeyi()));
            entity.set人数_15段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getSanGetuNinsuuGoukeyi()));
            entity.set人数_15段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).get現年随時の人数合計()));
            entity.set人数_15段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).get過年度の人数合計()));
            entity.set人数_15段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).get該当段階の人数合計()));
            entity.set人数_15段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).get歳出還付の人数合計()));
            entity.set金額_15段階_Title(koumokuGoukeyList.get(INT_14).getHokenryoDankai());
            entity.set金額_15段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getYoGetuKinkakuGoukeyi()));
            entity.set金額_15段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getGoGetuKinkakuGoukeyi()));
            entity.set金額_15段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_15段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_15段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_15段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_15段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_15段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_15段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_15段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getItiGetuKinkakuGoukeyi()));
            entity.set金額_15段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getNiGetuKinkakuGoukeyi()));
            entity.set金額_15段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).getSanGetuKinkakuGoukeyi()));
            entity.set金額_15段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).get現年随時の金額合計()));
            entity.set金額_15段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).get過年度の金額合計()));
            entity.set金額_15段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).get該当段階の金額合計()));
            entity.set金額_15段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_14).get歳出還付の金額合計()));
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity set16段階_18段階(TsukibetsuSuiihyoEntity entity, List<KoumokuGoukey> koumokuGoukeyList) {
        int listLength = koumokuGoukeyList.size();
        if (listLength - 1 > INT_15 && !不明.equals(koumokuGoukeyList.get(INT_15).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_15).getHokenryoDankai())) {
            entity.set人数_16段階_Title(koumokuGoukeyList.get(INT_15).getHokenryoDankai());
            entity.set人数_16段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getYoGetuNinsuuGoukeyi()));
            entity.set人数_16段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getGoGetuNinsuuGoukeyi()));
            entity.set人数_16段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_16段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_16段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_16段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_16段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_16段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_16段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_16段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getItiGetuNinsuuGoukeyi()));
            entity.set人数_16段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getNiGetuNinsuuGoukeyi()));
            entity.set人数_16段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getSanGetuNinsuuGoukeyi()));
            entity.set人数_16段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).get現年随時の人数合計()));
            entity.set人数_16段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).get過年度の人数合計()));
            entity.set人数_16段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).get該当段階の人数合計()));
            entity.set人数_16段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).get歳出還付の人数合計()));
            entity.set金額_16段階_Title(koumokuGoukeyList.get(INT_15).getHokenryoDankai());
            entity.set金額_16段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getYoGetuKinkakuGoukeyi()));
            entity.set金額_16段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getGoGetuKinkakuGoukeyi()));
            entity.set金額_16段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_16段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_16段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_16段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_16段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_16段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_16段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_16段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getItiGetuKinkakuGoukeyi()));
            entity.set金額_16段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getNiGetuKinkakuGoukeyi()));
            entity.set金額_16段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).getSanGetuKinkakuGoukeyi()));
            entity.set金額_16段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).get現年随時の金額合計()));
            entity.set金額_16段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).get過年度の金額合計()));
            entity.set金額_16段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).get該当段階の金額合計()));
            entity.set金額_16段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_15).get歳出還付の金額合計()));
        }
        if (listLength - 1 > INT_16 && !不明.equals(koumokuGoukeyList.get(INT_16).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_16).getHokenryoDankai())) {
            entity.set人数_17段階_Title(koumokuGoukeyList.get(INT_16).getHokenryoDankai());
            entity.set人数_17段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getYoGetuNinsuuGoukeyi()));
            entity.set人数_17段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getGoGetuNinsuuGoukeyi()));
            entity.set人数_17段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_17段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_17段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_17段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_17段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_17段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_17段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_17段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getItiGetuNinsuuGoukeyi()));
            entity.set人数_17段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getNiGetuNinsuuGoukeyi()));
            entity.set人数_17段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getSanGetuNinsuuGoukeyi()));
            entity.set人数_17段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).get現年随時の人数合計()));
            entity.set人数_17段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).get過年度の人数合計()));
            entity.set人数_17段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).get該当段階の人数合計()));
            entity.set人数_17段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).get歳出還付の人数合計()));
            entity.set金額_17段階_Title(koumokuGoukeyList.get(INT_16).getHokenryoDankai());
            entity.set金額_17段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getYoGetuKinkakuGoukeyi()));
            entity.set金額_17段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getGoGetuKinkakuGoukeyi()));
            entity.set金額_17段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_17段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_17段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_17段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_17段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_17段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_17段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_17段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getItiGetuKinkakuGoukeyi()));
            entity.set金額_17段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getNiGetuKinkakuGoukeyi()));
            entity.set金額_17段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).getSanGetuKinkakuGoukeyi()));
            entity.set金額_17段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).get現年随時の金額合計()));
            entity.set金額_17段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).get過年度の金額合計()));
            entity.set金額_17段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).get該当段階の金額合計()));
            entity.set金額_17段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_16).get歳出還付の金額合計()));
        }
        if (listLength - 1 > INT_17 && !不明.equals(koumokuGoukeyList.get(INT_17).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_17).getHokenryoDankai())) {
            entity.set人数_18段階_Title(koumokuGoukeyList.get(INT_17).getHokenryoDankai());
            entity.set人数_18段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getYoGetuNinsuuGoukeyi()));
            entity.set人数_18段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getGoGetuNinsuuGoukeyi()));
            entity.set人数_18段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_18段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_18段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_18段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_18段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_18段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_18段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_18段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getItiGetuNinsuuGoukeyi()));
            entity.set人数_18段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getNiGetuNinsuuGoukeyi()));
            entity.set人数_18段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getSanGetuNinsuuGoukeyi()));
            entity.set人数_18段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).get現年随時の人数合計()));
            entity.set人数_18段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).get過年度の人数合計()));
            entity.set人数_18段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).get該当段階の人数合計()));
            entity.set人数_18段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).get歳出還付の人数合計()));
            entity.set金額_18段階_Title(koumokuGoukeyList.get(INT_17).getHokenryoDankai());
            entity.set金額_18段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getYoGetuKinkakuGoukeyi()));
            entity.set金額_18段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getGoGetuKinkakuGoukeyi()));
            entity.set金額_18段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_18段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_18段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_18段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_18段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_18段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_18段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_18段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getItiGetuKinkakuGoukeyi()));
            entity.set金額_18段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getNiGetuKinkakuGoukeyi()));
            entity.set金額_18段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).getSanGetuKinkakuGoukeyi()));
            entity.set金額_18段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).get現年随時の金額合計()));
            entity.set金額_18段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).get過年度の金額合計()));
            entity.set金額_18段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).get該当段階の金額合計()));
            entity.set金額_18段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_17).get歳出還付の金額合計()));
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity set19段階_合計(TsukibetsuSuiihyoEntity entity, List<KoumokuGoukey> koumokuGoukeyList) {
        int listLength = koumokuGoukeyList.size();
        if (listLength - 1 > INT_18 && !不明.equals(koumokuGoukeyList.get(INT_18).getHokenryoDankai())
                && !合計.equals(koumokuGoukeyList.get(INT_18).getHokenryoDankai())) {
            entity.set人数_19段階_Title(koumokuGoukeyList.get(INT_18).getHokenryoDankai());
            entity.set人数_19段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getYoGetuNinsuuGoukeyi()));
            entity.set人数_19段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getGoGetuNinsuuGoukeyi()));
            entity.set人数_19段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getRokuGetuNinsuuGoukeyi()));
            entity.set人数_19段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getNanaGetuNinsuuGoukeyi()));
            entity.set人数_19段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getHatiGetuNinsuuGoukeyi()));
            entity.set人数_19段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getKyuGetuNinsuuGoukeyi()));
            entity.set人数_19段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getJyuGetuNinsuuGoukeyi()));
            entity.set人数_19段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getJyuitiGetuNinsuuGoukeyi()));
            entity.set人数_19段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getJyuniGetuNinsuuGoukeyi()));
            entity.set人数_19段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getItiGetuNinsuuGoukeyi()));
            entity.set人数_19段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getNiGetuNinsuuGoukeyi()));
            entity.set人数_19段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getSanGetuNinsuuGoukeyi()));
            entity.set人数_19段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).get現年随時の人数合計()));
            entity.set人数_19段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).get過年度の人数合計()));
            entity.set人数_19段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).get該当段階の人数合計()));
            entity.set人数_19段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).get歳出還付の人数合計()));
            entity.set金額_19段階_Title(koumokuGoukeyList.get(INT_18).getHokenryoDankai());
            entity.set金額_19段階_4月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getYoGetuKinkakuGoukeyi()));
            entity.set金額_19段階_5月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getGoGetuKinkakuGoukeyi()));
            entity.set金額_19段階_6月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getRokuGetuKinkakuGoukeyi()));
            entity.set金額_19段階_7月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getNanaGetuKinkakuGoukeyi()));
            entity.set金額_19段階_8月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getHatiGetuKinkakuGoukeyi()));
            entity.set金額_19段階_9月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getKyuGetuKinkakuGoukeyi()));
            entity.set金額_19段階_10月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getJyuGetuKinkakuGoukeyi()));
            entity.set金額_19段階_11月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getJyuitiGetuKinkakuGoukeyi()));
            entity.set金額_19段階_12月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getJyuniGetuKinkakuGoukeyi()));
            entity.set金額_19段階_1月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getItiGetuKinkakuGoukeyi()));
            entity.set金額_19段階_2月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getNiGetuKinkakuGoukeyi()));
            entity.set金額_19段階_3月(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).getSanGetuKinkakuGoukeyi()));
            entity.set金額_19段階_現年随時(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).get現年随時の金額合計()));
            entity.set金額_19段階_過年度(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).get過年度の金額合計()));
            entity.set金額_19段階_合計(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).get該当段階の金額合計()));
            entity.set金額_19段階_歳出還付(getNinsuuOrKinkaku(koumokuGoukeyList.get(INT_18).get歳出還付の金額合計()));
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
        if (listLength > 0) {
            entity.set人数_1段階_Title(gemmenJyohoList.get(0).getHokenryoDankai());
            entity.set人数_1段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(0).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_1段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(0).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_1段階_Title(gemmenJyohoList.get(0).getHokenryoDankai());
            entity.set金額_1段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(0).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_1段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(0).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > 1 && !不明.equals(gemmenJyohoList.get(1).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(1).getHokenryoDankai())) {
            entity.set人数_2段階_Title(gemmenJyohoList.get(1).getHokenryoDankai());
            entity.set人数_2段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(1).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_2段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(1).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_2段階_Title(gemmenJyohoList.get(1).getHokenryoDankai());
            entity.set金額_2段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(1).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_2段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(1).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > 2 && !不明.equals(gemmenJyohoList.get(2).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(2).getHokenryoDankai())) {
            entity.set人数_3段階_Title(gemmenJyohoList.get(2).getHokenryoDankai());
            entity.set人数_3段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(2).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_3段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(2).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_3段階_Title(gemmenJyohoList.get(2).getHokenryoDankai());
            entity.set金額_3段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(2).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_3段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(2).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_3 && !不明.equals(gemmenJyohoList.get(INT_3).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_3).getHokenryoDankai())) {
            entity.set人数_4段階_Title(gemmenJyohoList.get(INT_3).getHokenryoDankai());
            entity.set人数_4段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_3).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_4段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_3).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_4段階_Title(gemmenJyohoList.get(INT_3).getHokenryoDankai());
            entity.set金額_4段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_3).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_4段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_3).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_4 && !不明.equals(gemmenJyohoList.get(INT_4).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_4).getHokenryoDankai())) {
            entity.set人数_5段階_Title(gemmenJyohoList.get(INT_4).getHokenryoDankai());
            entity.set人数_5段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_4).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_5段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_4).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_5段階_Title(gemmenJyohoList.get(INT_4).getHokenryoDankai());
            entity.set金額_5段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_4).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_5段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_4).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_5 && !不明.equals(gemmenJyohoList.get(INT_5).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_5).getHokenryoDankai())) {
            entity.set人数_6段階_Title(gemmenJyohoList.get(INT_5).getHokenryoDankai());
            entity.set人数_6段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_5).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_6段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_5).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_6段階_Title(gemmenJyohoList.get(INT_5).getHokenryoDankai());
            entity.set金額_6段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_5).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_6段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_5).getHoDankaiKanendoGemenGakuGoukei()));
        }
        entity = setGemmen_8段階_12段階(entity, gemmenJyohoList);
        entity = setGemmen_13段階_15段階(entity, gemmenJyohoList);
        entity = setGemmen_16段階_合計(entity, gemmenJyohoList);
        return set段階_Title(entity, 表記List);
    }

    private TsukibetsuSuiihyoEntity setGemmen_8段階_12段階(TsukibetsuSuiihyoEntity entity, List<GemmenJyoho> gemmenJyohoList) {
        int listLength = gemmenJyohoList.size();
        if (listLength - 1 > INT_6 && !不明.equals(gemmenJyohoList.get(INT_6).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_6).getHokenryoDankai())) {
            entity.set人数_7段階_Title(gemmenJyohoList.get(INT_6).getHokenryoDankai());
            entity.set人数_7段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_6).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_7段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_6).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_7段階_Title(gemmenJyohoList.get(INT_6).getHokenryoDankai());
            entity.set金額_7段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_6).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_7段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_6).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_7 && !不明.equals(gemmenJyohoList.get(INT_7).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_7).getHokenryoDankai())) {
            entity.set人数_8段階_Title(gemmenJyohoList.get(INT_7).getHokenryoDankai());
            entity.set人数_8段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_7).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_8段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_7).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_8段階_Title(gemmenJyohoList.get(INT_7).getHokenryoDankai());
            entity.set金額_8段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_7).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_8段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_7).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_8 && !不明.equals(gemmenJyohoList.get(INT_8).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_8).getHokenryoDankai())) {
            entity.set人数_9段階_Title(gemmenJyohoList.get(INT_8).getHokenryoDankai());
            entity.set人数_9段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_8).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_9段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_8).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_9段階_Title(gemmenJyohoList.get(INT_8).getHokenryoDankai());
            entity.set金額_9段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_8).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_9段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_8).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_9 && !不明.equals(gemmenJyohoList.get(INT_9).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_9).getHokenryoDankai())) {
            entity.set人数_10段階_Title(gemmenJyohoList.get(INT_9).getHokenryoDankai());
            entity.set人数_10段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_9).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_10段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_9).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_10段階_Title(gemmenJyohoList.get(INT_9).getHokenryoDankai());
            entity.set金額_10段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_9).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_10段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_9).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_10 && !不明.equals(gemmenJyohoList.get(INT_10).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_10).getHokenryoDankai())) {
            entity.set人数_11段階_Title(gemmenJyohoList.get(INT_10).getHokenryoDankai());
            entity.set人数_11段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_10).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_11段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_10).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_11段階_Title(gemmenJyohoList.get(INT_10).getHokenryoDankai());
            entity.set金額_11段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_10).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_11段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_10).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_11 && !不明.equals(gemmenJyohoList.get(INT_11).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_11).getHokenryoDankai())) {
            entity.set人数_12段階_Title(gemmenJyohoList.get(INT_11).getHokenryoDankai());
            entity.set人数_12段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_11).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_12段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_11).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_12段階_Title(gemmenJyohoList.get(INT_11).getHokenryoDankai());
            entity.set金額_12段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_11).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_12段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_11).getHoDankaiKanendoGemenGakuGoukei()));
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity setGemmen_13段階_15段階(TsukibetsuSuiihyoEntity entity, List<GemmenJyoho> gemmenJyohoList) {
        int listLength = gemmenJyohoList.size();
        if (listLength - 1 > INT_12 && !不明.equals(gemmenJyohoList.get(INT_12).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_12).getHokenryoDankai())) {
            entity.set人数_13段階_Title(gemmenJyohoList.get(INT_12).getHokenryoDankai());
            entity.set人数_13段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_12).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_13段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_12).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_13段階_Title(gemmenJyohoList.get(INT_12).getHokenryoDankai());
            entity.set金額_13段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_12).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_13段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_12).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_13 && !不明.equals(gemmenJyohoList.get(INT_13).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_13).getHokenryoDankai())) {
            entity.set人数_14段階_Title(gemmenJyohoList.get(INT_13).getHokenryoDankai());
            entity.set人数_14段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_13).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_14段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_13).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_14段階_Title(gemmenJyohoList.get(INT_13).getHokenryoDankai());
            entity.set金額_14段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_13).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_14段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_13).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_14 && !不明.equals(gemmenJyohoList.get(INT_14).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_14).getHokenryoDankai())) {
            entity.set人数_15段階_Title(gemmenJyohoList.get(INT_14).getHokenryoDankai());
            entity.set人数_15段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_14).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_15段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_14).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_15段階_Title(gemmenJyohoList.get(INT_14).getHokenryoDankai());
            entity.set金額_15段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_14).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_15段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_14).getHoDankaiKanendoGemenGakuGoukei()));
        }
        return entity;
    }

    private TsukibetsuSuiihyoEntity setGemmen_16段階_合計(TsukibetsuSuiihyoEntity entity, List<GemmenJyoho> gemmenJyohoList) {
        int listLength = gemmenJyohoList.size();
        if (listLength - 1 > INT_15 && !不明.equals(gemmenJyohoList.get(INT_15).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_15).getHokenryoDankai())) {
            entity.set人数_16段階_Title(gemmenJyohoList.get(INT_15).getHokenryoDankai());
            entity.set人数_16段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_15).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_16段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_15).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_16段階_Title(gemmenJyohoList.get(INT_15).getHokenryoDankai());
            entity.set金額_16段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_15).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_16段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_15).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_16 && !不明.equals(gemmenJyohoList.get(INT_16).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_16).getHokenryoDankai())) {
            entity.set人数_17段階_Title(gemmenJyohoList.get(INT_16).getHokenryoDankai());
            entity.set人数_17段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_16).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_17段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_16).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_17段階_Title(gemmenJyohoList.get(INT_16).getHokenryoDankai());
            entity.set金額_17段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_16).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_17段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_16).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_17 && !不明.equals(gemmenJyohoList.get(INT_17).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_17).getHokenryoDankai())) {
            entity.set人数_18段階_Title(gemmenJyohoList.get(INT_17).getHokenryoDankai());
            entity.set人数_18段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_17).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_18段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_17).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_18段階_Title(gemmenJyohoList.get(INT_17).getHokenryoDankai());
            entity.set金額_18段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_17).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_18段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_17).getHoDankaiKanendoGemenGakuGoukei()));
        }
        if (listLength - 1 > INT_18 && !不明.equals(gemmenJyohoList.get(INT_18).getHokenryoDankai())
                && !合計.equals(gemmenJyohoList.get(INT_18).getHokenryoDankai())) {
            entity.set人数_19段階_Title(gemmenJyohoList.get(INT_18).getHokenryoDankai());
            entity.set人数_19段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_18).getHokenryoDankaiKanendoNinsu()));
            entity.set人数_19段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_18).getHoDankaiKanendoGemmenGaku()));
            entity.set金額_19段階_Title(gemmenJyohoList.get(INT_18).getHokenryoDankai());
            entity.set金額_19段階_過年度(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_18).getHoDankaiKanendoNinsuGoukeyi()));
            entity.set金額_19段階_合計(getNinsuuOrKinkaku(gemmenJyohoList.get(INT_18).getHoDankaiKanendoGemenGakuGoukei()));
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
