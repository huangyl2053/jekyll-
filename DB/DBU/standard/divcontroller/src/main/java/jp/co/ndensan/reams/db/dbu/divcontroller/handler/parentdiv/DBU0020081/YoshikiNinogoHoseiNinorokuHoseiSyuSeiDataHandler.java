/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020081;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081.YoshikiNinogoHoseiNinorokuHoseiDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 修正データ取得ハンドラークラスです。
 *
 * @reamsid_L DBU-1100-070 yebangqiang
 */
public final class YoshikiNinogoHoseiNinorokuHoseiSyuSeiDataHandler {

    private final YoshikiNinogoHoseiNinorokuHoseiDiv div;
    private static final RString 集計番号_0105 = new RString("0105");
    private static final RString 集計番号_0205 = new RString("0205");
    private static final RString 集計番号_0106 = new RString("0106");
    private static final RString 集計番号_0206 = new RString("0206");
    private static final int 縦番号_1 = 1;
    private static final int 縦番号_2 = 2;
    private static final int 縦番号_3 = 3;
    private static final int 縦番号_4 = 4;
    private static final int 縦番号_5 = 5;
    private static final int 縦番号_6 = 6;
    private static final int 縦番号_7 = 7;
    private static final int 縦番号_8 = 8;
    private static final int 縦番号_9 = 9;
    private static final int 縦番号_10 = 10;
    private static final int 縦番号_11 = 11;
    private static final int 縦番号_12 = 12;
    private static final int 縦番号_13 = 13;
    private static final int 縦番号_14 = 14;
    private static final int 縦番号_15 = 15;
    private static final int 縦番号_16 = 16;
    private static final int 縦番号_17 = 17;
    private static final int 横番号_2 = 2;
    private static final int 横番号_3 = 3;
    private static final int 横番号_12 = 12;
    private static final int 横行データ件数_7 = 7;
    private static final int 横行データ件数_10 = 10;
    private static final int 横行データ件数_11 = 11;

    private YoshikiNinogoHoseiNinorokuHoseiSyuSeiDataHandler(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        this.div = div;
    }

    /**
     * ハンドラー生成するメソッドです。
     *
     * @param div 画面DIV
     * @return 修正データ取得ハンドラークラス
     */
    public static YoshikiNinogoHoseiNinorokuHoseiSyuSeiDataHandler of(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return new YoshikiNinogoHoseiNinorokuHoseiSyuSeiDataHandler(div);
    }

    /**
     * 修正データの取得するメッソドです。
     *
     * @param 引き継ぎデータ 引き継ぎデータ
     * @param 様式種類 様式種類
     * @return 修正データリスト List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> get修正データ(List<JigyoHokokuTokeiData> 引き継ぎデータ, RString 様式種類) {
        List<JigyoHokokuTokeiData> 更新前データリスト = 引き継ぎデータ;

        JigyoHokokuTokeiData 更新前データ = 更新前データリスト.get(0);
        List<JigyoHokokuTokeiData> 画面データリスト = new ArrayList<>();
        if (Integer.parseInt(様式種類.toString()) % 2 > 0) {
            set件数タブ総数場合_画面データリスト(画面データリスト, 更新前データ);
            set給付費タブ総数場合_画面データリスト(画面データリスト, 更新前データ);
        } else {
            set件数タブ第２号被保険者分場合_画面データリスト(画面データリスト, 更新前データ);
            set給付費タブ第２号被保険者分場合_画面データリスト(画面データリスト, 更新前データ);
        }

        List<JigyoHokokuTokeiData> 修正データリスト = new ArrayList<>();

        for (int j = 0; j < 画面データリスト.size(); j++) {
            JigyoHokokuTokeiData 画面データ = 画面データリスト.get(j);
            JigyoHokokuTokeiData 更新前_isNull = get更新前空データ(更新前データリスト, 画面データ);
            if ((更新前_isNull != null) && (更新前_isNull.get集計結果値() != null)) {
                更新前_isNull = 更新前_isNull.addedModel();
                修正データリスト.add(更新前_isNull);
            }
        }
        for (int i = 0; i < 更新前データリスト.size(); i++) {
            for (int j = 0; j < 画面データリスト.size(); j++) {
                JigyoHokokuTokeiData 画面データ = 画面データリスト.get(j);
                JigyoHokokuTokeiData 更新前 = 更新前データリスト.get(i);
                if (更新前.get縦番号().equals(画面データ.get縦番号())
                        && 更新前.get横番号().equals(画面データ.get横番号())
                        && 更新前.get集計番号().equals(画面データ.get集計番号())
                        && ((更新前.get集計結果値() == null && 画面データ.get集計結果値() != null)
                        || (更新前.get集計結果値() != null && 画面データ.get集計結果値() == null)
                        || (更新前.get集計結果値() != null && 画面データ.get集計結果値() != null
                        && !更新前.get集計結果値().equals(画面データ.get集計結果値())))) {
                    更新前 = 更新前.createBuilderForEdit().set集計結果値(画面データ.get集計結果値()).build();
                    修正データリスト.add(更新前);
                }
            }
        }
        return 修正データリスト;
    }

    private void set給付費タブ第２号被保険者分場合_画面データリスト(List<JigyoHokokuTokeiData> 画面データリスト,
            JigyoHokokuTokeiData 更新前データ) {
        List<Decimal> 給付費_食費リスト = new ArrayList<>();
        set給付費_食費リスト(給付費_食費リスト);
        set画面データリスト(
                画面データリスト, 更新前データ, new Code(集計番号_0206), 給付費_食費リスト, new Decimal(縦番号_1));
        List<Decimal> 給付費_介護老人福祉施設リスト = new ArrayList<>();
        set給付費_介護老人福祉施設リスト(給付費_介護老人福祉施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206), 給付費_介護老人福祉施設リスト,
                new Decimal(縦番号_4));
        List<Decimal> 給付費_介護老人保健施設リスト = new ArrayList<>();
        set給付費_介護老人保健施設リスト(給付費_介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206), 給付費_介護老人保健施設リスト,
                new Decimal(縦番号_5));
        List<Decimal> 給付費_介護療養型医療施設リスト = new ArrayList<>();
        set給付費_介護療養型医療施設リスト(給付費_介護療養型医療施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206), 給付費_介護療養型医療施設リスト,
                new Decimal(縦番号_6));
        List<Decimal> 給付費_地域密着型介護老人福祉リスト = new ArrayList<>();
        set給付費_地域密着型介護老人福祉施設入所者生活介護リスト(給付費_地域密着型介護老人福祉リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206), 給付費_地域密着型介護老人福祉リスト,
                new Decimal(縦番号_16));
        画面データリスト.add(get画面データ(更新前データ, new Code(集計番号_0206), new Decimal(横番号_12),
                new Decimal(縦番号_16), div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuGokei().getValue()));
        List<Decimal> 給付費_短期入所生活介護リスト = new ArrayList<>();
        set給付費_短期入所生活介護リスト(給付費_短期入所生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206), 給付費_短期入所生活介護リスト,
                new Decimal(縦番号_7));
        List<Decimal> 給付費_短期入所療養介護老人保健施設リスト = new ArrayList<>();
        set給付費_短期入所療養介護介護老人保健施設リスト(給付費_短期入所療養介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206), 給付費_短期入所療養介護老人保健施設リスト,
                new Decimal(縦番号_8));
        List<Decimal> 給付費_短期入所療養介護療養型医療施設等リスト = new ArrayList<>();
        set給付費_短期入所療養介護介護療養型医療施設等リスト(給付費_短期入所療養介護療養型医療施設等リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206),
                給付費_短期入所療養介護療養型医療施設等リスト, new Decimal(縦番号_9));
        List<Decimal> 給付費_居住費滞在費リスト = new ArrayList<>();
        set給付費_居住費滞在費リスト(給付費_居住費滞在費リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206), 給付費_居住費滞在費リスト,
                new Decimal(縦番号_2));
        List<Decimal> 給付費_居住費介護老人福祉施設リスト = new ArrayList<>();
        set給付費_居住費_介護老人福祉施設リスト(給付費_居住費介護老人福祉施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206), 給付費_居住費介護老人福祉施設リスト,
                new Decimal(縦番号_10));
        List<Decimal> 給付費_居住費介護老人保健施設リスト = new ArrayList<>();
        set給付費_居住費_介護老人保健施設リスト(給付費_居住費介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206), 給付費_居住費介護老人保健施設リスト,
                new Decimal(縦番号_11));
        List<Decimal> 給付費_居住費介護療養型医療施設リスト = new ArrayList<>();
        set給付費_居住費_介護療養型医療施設リスト(給付費_居住費介護療養型医療施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206), 給付費_居住費介護療養型医療施設リスト,
                new Decimal(縦番号_12));
        List<Decimal> 給付費_居住費老人福祉施設入所者生活介護リスト = new ArrayList<>();
        set給付費_居住費_地域密着型介護老人福祉施設入所者生活介護リスト(給付費_居住費老人福祉施設入所者生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206),
                給付費_居住費老人福祉施設入所者生活介護リスト, new Decimal(縦番号_17));
        画面データリスト.add(get画面データ(更新前データ, new Code(集計番号_0206), new Decimal(横番号_12),
                new Decimal(縦番号_17), div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuGokei().getValue()));
        List<Decimal> 給付費_居住費短期入所生活介護リスト = new ArrayList<>();
        set給付費_居住費_短期入所生活介護リスト(給付費_居住費短期入所生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206),
                給付費_居住費短期入所生活介護リスト, new Decimal(縦番号_13));
        List<Decimal> 給付費_居住費短期入所療養介護老人保健施設リスト = new ArrayList<>();
        set給付費_居住費_短期入所療養介護介護老人保健施設リスト(給付費_居住費短期入所療養介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206),
                給付費_居住費短期入所療養介護老人保健施設リスト, new Decimal(縦番号_14));
        List<Decimal> 給付費_居住費短期入所療養介護療養型医療施設等リスト = new ArrayList<>();
        set給付費_居住費_短期入所療養介護介護療養型医療施設等リスト(給付費_居住費短期入所療養介護療養型医療施設等リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206),
                給付費_居住費短期入所療養介護療養型医療施設等リスト, new Decimal(縦番号_15));
        List<Decimal> 給付費_総計リスト = new ArrayList<>();
        set給付費_総計リスト(給付費_総計リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0206),
                給付費_総計リスト, new Decimal(縦番号_3));
    }

    private void set件数タブ第２号被保険者分場合_画面データリスト(List<JigyoHokokuTokeiData> 画面データリスト,
            JigyoHokokuTokeiData 更新前データ) {
        List<Decimal> 件数_食費リスト = new ArrayList<>();
        set件数_食費リスト(件数_食費リスト);
        set画面データリスト(
                画面データリスト, 更新前データ, new Code(集計番号_0205), 件数_食費リスト, new Decimal(縦番号_1));
        List<Decimal> 件数_介護老人福祉施設リスト = new ArrayList<>();
        set件数_介護老人福祉施設リスト(件数_介護老人福祉施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205), 件数_介護老人福祉施設リスト,
                new Decimal(縦番号_4));
        List<Decimal> 件数_介護老人保健施設リスト = new ArrayList<>();
        set件数_介護老人保健施設リスト(件数_介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205), 件数_介護老人保健施設リスト,
                new Decimal(縦番号_5));
        List<Decimal> 件数_介護療養型医療施設リスト = new ArrayList<>();
        set件数_介護療養型医療施設リスト(件数_介護療養型医療施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205), 件数_介護療養型医療施設リスト,
                new Decimal(縦番号_6));
        List<Decimal> 件数_地域密着型介護老人福祉リスト = new ArrayList<>();
        set件数_地域密着型介護老人福祉施設入所者生活介護リスト(件数_地域密着型介護老人福祉リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205), 件数_地域密着型介護老人福祉リスト,
                new Decimal(縦番号_16));
        画面データリスト.add(get画面データ(更新前データ, new Code(集計番号_0205), new Decimal(横番号_12),
                new Decimal(縦番号_16), div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuGokei().getValue()));
        List<Decimal> 件数_短期入所生活介護リスト = new ArrayList<>();
        set件数_短期入所生活介護リスト(件数_短期入所生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205), 件数_短期入所生活介護リスト,
                new Decimal(縦番号_7));
        List<Decimal> 件数_短期入所療養介護老人保健施設リスト = new ArrayList<>();
        set件数_短期入所療養介護介護老人保健施設リスト(件数_短期入所療養介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205), 件数_短期入所療養介護老人保健施設リスト,
                new Decimal(縦番号_8));
        List<Decimal> 件数_短期入所療養介護療養型医療施設等リスト = new ArrayList<>();
        set件数_短期入所療養介護介護療養型医療施設等リスト(件数_短期入所療養介護療養型医療施設等リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205),
                件数_短期入所療養介護療養型医療施設等リスト, new Decimal(縦番号_9));
        List<Decimal> 件数_居住費滞在費リスト = new ArrayList<>();
        set件数_居住費滞在費リスト(件数_居住費滞在費リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205), 件数_居住費滞在費リスト,
                new Decimal(縦番号_2));
        List<Decimal> 件数_居住費介護老人福祉施設リスト = new ArrayList<>();
        set件数_居住費_介護老人福祉施設リスト(件数_居住費介護老人福祉施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205), 件数_居住費介護老人福祉施設リスト,
                new Decimal(縦番号_10));
        List<Decimal> 件数_居住費介護老人保健施設リスト = new ArrayList<>();
        set件数_居住費_介護老人保健施設リスト(件数_居住費介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205), 件数_居住費介護老人保健施設リスト,
                new Decimal(縦番号_11));
        List<Decimal> 件数_居住費介護療養型医療施設リスト = new ArrayList<>();
        set件数_居住費_介護療養型医療施設リスト(件数_居住費介護療養型医療施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205), 件数_居住費介護療養型医療施設リスト,
                new Decimal(縦番号_12));
        List<Decimal> 件数_居住費老人福祉施設入所者生活介護リスト = new ArrayList<>();
        set件数_居住費_地域密着型介護老人福祉施設入所者生活介護リスト(件数_居住費老人福祉施設入所者生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205),
                件数_居住費老人福祉施設入所者生活介護リスト, new Decimal(縦番号_17));
        画面データリスト.add(get画面データ(更新前データ, new Code(集計番号_0205), new Decimal(横番号_12),
                new Decimal(縦番号_17), div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuGokei().getValue()));
        List<Decimal> 件数_居住費短期入所生活介護リスト = new ArrayList<>();
        set件数_居住費_短期入所生活介護リスト(件数_居住費短期入所生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205),
                件数_居住費短期入所生活介護リスト, new Decimal(縦番号_13));
        List<Decimal> 件数_居住費短期入所療養介護老人保健施設リスト = new ArrayList<>();
        set件数_居住費_短期入所療養介護介護老人保健施設リスト(件数_居住費短期入所療養介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205),
                件数_居住費短期入所療養介護老人保健施設リスト, new Decimal(縦番号_14));
        List<Decimal> 件数_居住費短期入所療養介護療養型医療施設等リスト = new ArrayList<>();
        set件数_居住費_短期入所療養介護介護療養型医療施設等リスト(件数_居住費短期入所療養介護療養型医療施設等リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205),
                件数_居住費短期入所療養介護療養型医療施設等リスト, new Decimal(縦番号_15));
        List<Decimal> 件数_総計リスト = new ArrayList<>();
        set件数_総計リスト(件数_総計リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0205),
                件数_総計リスト, new Decimal(縦番号_3));
    }

    private void set給付費タブ総数場合_画面データリスト(List<JigyoHokokuTokeiData> 画面データリスト,
            JigyoHokokuTokeiData 更新前データ) {
        List<Decimal> 給付費_食費リスト = new ArrayList<>();
        set給付費_食費リスト(給付費_食費リスト);
        set画面データリスト(
                画面データリスト, 更新前データ, new Code(集計番号_0106), 給付費_食費リスト, new Decimal(縦番号_1));
        List<Decimal> 給付費_介護老人福祉施設リスト = new ArrayList<>();
        set給付費_介護老人福祉施設リスト(給付費_介護老人福祉施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106), 給付費_介護老人福祉施設リスト,
                new Decimal(縦番号_4));
        List<Decimal> 給付費_介護老人保健施設リスト = new ArrayList<>();
        set給付費_介護老人保健施設リスト(給付費_介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106), 給付費_介護老人保健施設リスト,
                new Decimal(縦番号_5));
        List<Decimal> 給付費_介護療養型医療施設リスト = new ArrayList<>();
        set給付費_介護療養型医療施設リスト(給付費_介護療養型医療施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106), 給付費_介護療養型医療施設リスト,
                new Decimal(縦番号_6));
        List<Decimal> 給付費_地域密着型介護老人福祉リスト = new ArrayList<>();
        set給付費_地域密着型介護老人福祉施設入所者生活介護リスト(給付費_地域密着型介護老人福祉リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106), 給付費_地域密着型介護老人福祉リスト,
                new Decimal(縦番号_16));
        画面データリスト.add(get画面データ(更新前データ, new Code(集計番号_0106), new Decimal(横番号_12),
                new Decimal(縦番号_16), div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuGokei().getValue()));
        List<Decimal> 給付費_短期入所生活介護リスト = new ArrayList<>();
        set給付費_短期入所生活介護リスト(給付費_短期入所生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106), 給付費_短期入所生活介護リスト,
                new Decimal(縦番号_7));
        List<Decimal> 給付費_短期入所療養介護老人保健施設リスト = new ArrayList<>();
        set給付費_短期入所療養介護介護老人保健施設リスト(給付費_短期入所療養介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106), 給付費_短期入所療養介護老人保健施設リスト,
                new Decimal(縦番号_8));
        List<Decimal> 給付費_短期入所療養介護療養型医療施設等リスト = new ArrayList<>();
        set給付費_短期入所療養介護介護療養型医療施設等リスト(給付費_短期入所療養介護療養型医療施設等リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106),
                給付費_短期入所療養介護療養型医療施設等リスト, new Decimal(縦番号_9));
        List<Decimal> 給付費_居住費滞在費リスト = new ArrayList<>();
        set給付費_居住費滞在費リスト(給付費_居住費滞在費リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106), 給付費_居住費滞在費リスト,
                new Decimal(縦番号_2));
        List<Decimal> 給付費_居住費介護老人福祉施設リスト = new ArrayList<>();
        set給付費_居住費_介護老人福祉施設リスト(給付費_居住費介護老人福祉施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106), 給付費_居住費介護老人福祉施設リスト,
                new Decimal(縦番号_10));
        List<Decimal> 給付費_居住費介護老人保健施設リスト = new ArrayList<>();
        set給付費_居住費_介護老人保健施設リスト(給付費_居住費介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106), 給付費_居住費介護老人保健施設リスト,
                new Decimal(縦番号_11));
        List<Decimal> 給付費_居住費介護療養型医療施設リスト = new ArrayList<>();
        set給付費_居住費_介護療養型医療施設リスト(給付費_居住費介護療養型医療施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106), 給付費_居住費介護療養型医療施設リスト,
                new Decimal(縦番号_12));
        List<Decimal> 給付費_居住費老人福祉施設入所者生活介護リスト = new ArrayList<>();
        set給付費_居住費_地域密着型介護老人福祉施設入所者生活介護リスト(給付費_居住費老人福祉施設入所者生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106),
                給付費_居住費老人福祉施設入所者生活介護リスト, new Decimal(縦番号_17));
        画面データリスト.add(get画面データ(更新前データ, new Code(集計番号_0106), new Decimal(横番号_12),
                new Decimal(縦番号_17), div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuGokei().getValue()));
        List<Decimal> 給付費_居住費短期入所生活介護リスト = new ArrayList<>();
        set給付費_居住費_短期入所生活介護リスト(給付費_居住費短期入所生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106),
                給付費_居住費短期入所生活介護リスト, new Decimal(縦番号_13));
        List<Decimal> 給付費_居住費短期入所療養介護老人保健施設リスト = new ArrayList<>();
        set給付費_居住費_短期入所療養介護介護老人保健施設リスト(給付費_居住費短期入所療養介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106),
                給付費_居住費短期入所療養介護老人保健施設リスト, new Decimal(縦番号_14));
        List<Decimal> 給付費_居住費短期入所療養介護療養型医療施設等リスト = new ArrayList<>();
        set給付費_居住費_短期入所療養介護介護療養型医療施設等リスト(給付費_居住費短期入所療養介護療養型医療施設等リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106),
                給付費_居住費短期入所療養介護療養型医療施設等リスト, new Decimal(縦番号_15));
        List<Decimal> 給付費_総計リスト = new ArrayList<>();
        set給付費_総計リスト(給付費_総計リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0106),
                給付費_総計リスト, new Decimal(縦番号_3));
    }

    private void set件数タブ総数場合_画面データリスト(List<JigyoHokokuTokeiData> 画面データリスト,
            JigyoHokokuTokeiData 更新前データ) {
        List<Decimal> 件数_食費リスト = new ArrayList<>();
        set件数_食費リスト(件数_食費リスト);
        set画面データリスト(
                画面データリスト, 更新前データ, new Code(集計番号_0105), 件数_食費リスト, new Decimal(縦番号_1));
        List<Decimal> 件数_介護老人福祉施設リスト = new ArrayList<>();
        set件数_介護老人福祉施設リスト(件数_介護老人福祉施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105), 件数_介護老人福祉施設リスト,
                new Decimal(縦番号_4));
        List<Decimal> 件数_介護老人保健施設リスト = new ArrayList<>();
        set件数_介護老人保健施設リスト(件数_介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105), 件数_介護老人保健施設リスト,
                new Decimal(縦番号_5));
        List<Decimal> 件数_介護療養型医療施設リスト = new ArrayList<>();
        set件数_介護療養型医療施設リスト(件数_介護療養型医療施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105), 件数_介護療養型医療施設リスト,
                new Decimal(縦番号_6));
        List<Decimal> 件数_地域密着型介護老人福祉リスト = new ArrayList<>();
        set件数_地域密着型介護老人福祉施設入所者生活介護リスト(件数_地域密着型介護老人福祉リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105), 件数_地域密着型介護老人福祉リスト,
                new Decimal(縦番号_16));
        画面データリスト.add(get画面データ(更新前データ, new Code(集計番号_0105), new Decimal(横番号_12),
                new Decimal(縦番号_16), div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuGokei().getValue()));
        List<Decimal> 件数_短期入所生活介護リスト = new ArrayList<>();
        set件数_短期入所生活介護リスト(件数_短期入所生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105), 件数_短期入所生活介護リスト,
                new Decimal(縦番号_7));
        List<Decimal> 件数_短期入所療養介護老人保健施設リスト = new ArrayList<>();
        set件数_短期入所療養介護介護老人保健施設リスト(件数_短期入所療養介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105), 件数_短期入所療養介護老人保健施設リスト,
                new Decimal(縦番号_8));
        List<Decimal> 件数_短期入所療養介護療養型医療施設等リスト = new ArrayList<>();
        set件数_短期入所療養介護介護療養型医療施設等リスト(件数_短期入所療養介護療養型医療施設等リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105),
                件数_短期入所療養介護療養型医療施設等リスト, new Decimal(縦番号_9));
        List<Decimal> 件数_居住費滞在費リスト = new ArrayList<>();
        set件数_居住費滞在費リスト(件数_居住費滞在費リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105), 件数_居住費滞在費リスト,
                new Decimal(縦番号_2));
        List<Decimal> 件数_居住費介護老人福祉施設リスト = new ArrayList<>();
        set件数_居住費_介護老人福祉施設リスト(件数_居住費介護老人福祉施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105), 件数_居住費介護老人福祉施設リスト,
                new Decimal(縦番号_10));
        List<Decimal> 件数_居住費介護老人保健施設リスト = new ArrayList<>();
        set件数_居住費_介護老人保健施設リスト(件数_居住費介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105), 件数_居住費介護老人保健施設リスト,
                new Decimal(縦番号_11));
        List<Decimal> 件数_居住費介護療養型医療施設リスト = new ArrayList<>();
        set件数_居住費_介護療養型医療施設リスト(件数_居住費介護療養型医療施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105), 件数_居住費介護療養型医療施設リスト,
                new Decimal(縦番号_12));
        List<Decimal> 件数_居住費老人福祉施設入所者生活介護リスト = new ArrayList<>();
        set件数_居住費_地域密着型介護老人福祉施設入所者生活介護リスト(件数_居住費老人福祉施設入所者生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105),
                件数_居住費老人福祉施設入所者生活介護リスト, new Decimal(縦番号_17));
        画面データリスト.add(get画面データ(更新前データ, new Code(集計番号_0105), new Decimal(横番号_12),
                new Decimal(縦番号_17), div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuGokei().getValue()));
        List<Decimal> 件数_居住費短期入所生活介護リスト = new ArrayList<>();
        set件数_居住費_短期入所生活介護リスト(件数_居住費短期入所生活介護リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105),
                件数_居住費短期入所生活介護リスト, new Decimal(縦番号_13));
        List<Decimal> 件数_居住費短期入所療養介護老人保健施設リスト = new ArrayList<>();
        set件数_居住費_短期入所療養介護介護老人保健施設リスト(件数_居住費短期入所療養介護老人保健施設リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105),
                件数_居住費短期入所療養介護老人保健施設リスト, new Decimal(縦番号_14));
        List<Decimal> 件数_居住費短期入所療養介護療養型医療施設等リスト = new ArrayList<>();
        set件数_居住費_短期入所療養介護介護療養型医療施設等リスト(件数_居住費短期入所療養介護療養型医療施設等リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105),
                件数_居住費短期入所療養介護療養型医療施設等リスト, new Decimal(縦番号_15));
        List<Decimal> 件数_総計リスト = new ArrayList<>();
        set件数_総計リスト(件数_総計リスト);
        set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_0105),
                件数_総計リスト, new Decimal(縦番号_3));
    }

    private JigyoHokokuTokeiData get更新前空データ(
            List<JigyoHokokuTokeiData> 更新前縦番号横番号リスト,
            JigyoHokokuTokeiData 画面データ) {
        boolean 更新前含む = false;
        for (JigyoHokokuTokeiData 更新前 : 更新前縦番号横番号リスト) {
            if (更新前.get横番号().equals(画面データ.get横番号()) && 更新前.get縦番号().equals(画面データ.get縦番号())
                    && 更新前.get集計番号().equals(画面データ.get集計番号())) {
                更新前含む = true;
                break;
            }
        }
        if (!更新前含む) {
            return 画面データ;
        }
        return null;
    }

    private void set画面データリスト(
            List<JigyoHokokuTokeiData> 画面データリスト,
            JigyoHokokuTokeiData 更新前データ,
            Code 集計番号,
            List<Decimal> 件数リスト,
            Decimal 縦番号) {
        for (int i = 0; i < 件数リスト.size(); i++) {
            if (件数リスト.size() == 横行データ件数_7 || 件数リスト.size() == 横行データ件数_11) {
                画面データリスト.add(get画面データ(更新前データ, 集計番号, new Decimal(i + 横番号_2), 縦番号,
                        件数リスト.get(i)));
            } else if (件数リスト.size() == 横行データ件数_10) {
                画面データリスト.add(get画面データ(更新前データ, 集計番号, new Decimal(i + 横番号_3), 縦番号,
                        件数リスト.get(i)));
            }
        }
    }

    private JigyoHokokuTokeiData get画面データ(
            JigyoHokokuTokeiData 更新前データ,
            Code 集計番号,
            Decimal 横番号,
            Decimal 縦番号,
            Decimal 件数) {
        JigyoHokokuTokeiData 画面データ = new JigyoHokokuTokeiData(更新前データ.get報告年(),
                更新前データ.get報告月(),
                更新前データ.get集計対象年(),
                更新前データ.get集計対象月(),
                更新前データ.get統計対象区分(),
                更新前データ.get市町村コード(),
                更新前データ.get表番号(),
                集計番号,
                更新前データ.get集計単位(),
                縦番号,
                横番号);
        if (件数 != null) {
            画面データ = 画面データ.createBuilderForEdit().set集計結果値(件数).build();
        }
        return 画面データ;
    }

    private void set件数_食費リスト(List<Decimal> 件数_食費リスト) {
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshien1().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshien2().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshienKei().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiKaigoKeikateki().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo1().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo2().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo3().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo4().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo5().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigoKei().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiGokei().getValue());
    }

    private void set件数_介護老人福祉施設リスト(List<Decimal> 介護老人福祉施設リスト) {
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshien1().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshien2().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshienKei().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo1().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo2().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo3().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo4().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo5().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigoKei().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiGokei().getValue());
    }

    private void set件数_介護老人保健施設リスト(List<Decimal> 介護老人保健施設リスト) {
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshien1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshien2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshienKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo3().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo4().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo5().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigoKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiHokenGokei().getValue());
    }

    private void set件数_介護療養型医療施設リスト(List<Decimal> 介護療養型医療施設リスト) {
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshien1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshien2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshienKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo3().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo4().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo5().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigoKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoGokei().getValue());
    }

    private void set件数_地域密着型介護老人福祉施設入所者生活介護リスト(List<Decimal> 老人福祉施設入所者生活介護リスト) {
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoKeikateki().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo1().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo2().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo3().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo4().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo5().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private void set件数_短期入所生活介護リスト(List<Decimal> 短期入所生活介護リスト) {
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshien1().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshien2().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshienKei().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoKeikateki().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo1().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo2().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo3().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo4().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo5().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigoKei().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiGokei().getValue());
    }

    private void set件数_短期入所療養介護介護老人保健施設リスト(List<Decimal> 介護老人保健施設リスト) {
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshien1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshien2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshienKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoKeikateki().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo3().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo4().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo5().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigoKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenGokei().getValue());
    }

    private void set件数_短期入所療養介護介護療養型医療施設等リスト(List<Decimal> 介護療養型医療施設リスト) {
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshien1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshien2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshienKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoKeikateki().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo3().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo4().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo5().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigoKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoGokei().getValue());
    }

    private void set件数_居住費滞在費リスト(List<Decimal> 居住費滞在費リスト) {
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshien1().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshien2().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshienKei().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiKaigoKeikateki().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo1().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo2().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo3().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo4().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo5().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigoKei().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiGokei().getValue());
    }

    private void set件数_居住費_介護老人福祉施設リスト(List<Decimal> 介護老人福祉施設リスト) {
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshien1().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshien2().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshienKei().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo1().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo2().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo3().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo4().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo5().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigoKei().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiGokei().getValue());
    }

    private void set件数_居住費_介護老人保健施設リスト(List<Decimal> 介護老人保健施設リスト) {
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshien1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshien2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshienKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo3().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo4().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo5().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigoKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiHokenGokei().getValue());
    }

    private void set件数_居住費_介護療養型医療施設リスト(List<Decimal> 介護療養型医療施設リスト) {
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshien1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshien2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshienKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo3().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo4().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo5().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigoKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoGokei().getValue());
    }

    private void set件数_居住費_地域密着型介護老人福祉施設入所者生活介護リスト(
            List<Decimal> 老人福祉施設入所者生活介護リスト) {
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoKeikateki().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo1().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo2().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo3().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo4().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo5().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private void set件数_居住費_短期入所生活介護リスト(List<Decimal> 短期入所生活介護リスト) {
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshien1().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshien2().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshienKei().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoKeikateki().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo1().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo2().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo3().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo4().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo5().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigoKei().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiGokei().getValue());
    }

    private void set件数_居住費_短期入所療養介護介護老人保健施設リスト(List<Decimal> 介護老人保健施設リスト) {
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshien1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshien2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshienKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoKeikateki().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo3().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo4().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo5().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigoKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenGokei().getValue());
    }

    private void set件数_居住費_短期入所療養介護介護療養型医療施設等リスト(List<Decimal> 介護療養型医療施設等リスト) {
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshien1().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshien2().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshienKei().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoKeikateki().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo1().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo2().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo3().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo4().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo5().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigoKei().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoGokei().getValue());
    }

    private void set件数_総計リスト(List<Decimal> 総計リスト) {
        総計リスト.add(div.getPnl2().getPnl1().getTxt1SokeiYoboYoshien1().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt1SokeiYoboYoshien2().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt1SokeiYoboYoshienKei().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt1SokeiKaigoKeikateki().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo1().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo2().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo3().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo4().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo5().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigoKei().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt1SokeiGokei().getValue());
    }

    private void set給付費_食費リスト(List<Decimal> 件数_食費リスト) {
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshien1().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshien2().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshienKei().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiKaigoKeikateki().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo1().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo2().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo3().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo4().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo5().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigoKei().getValue());
        件数_食費リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiGokei().getValue());
    }

    private void set給付費_介護老人福祉施設リスト(List<Decimal> 介護老人福祉施設リスト) {
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshien1().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshien2().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshienKei().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo1().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo2().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo3().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo4().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo5().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigoKei().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiGokei().getValue());
    }

    private void set給付費_介護老人保健施設リスト(List<Decimal> 介護老人保健施設リスト) {
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshien1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshien2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshienKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo3().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo4().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo5().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigoKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiHokenGokei().getValue());
    }

    private void set給付費_介護療養型医療施設リスト(List<Decimal> 介護療養型医療施設リスト) {
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshien1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshien2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshienKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo3().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo4().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo5().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigoKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoGokei().getValue());
    }

    private void set給付費_地域密着型介護老人福祉施設入所者生活介護リスト(
            List<Decimal> 老人福祉施設入所者生活介護リスト) {
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoKeikateki().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo1().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo2().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo3().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo4().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo5().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private void set給付費_短期入所生活介護リスト(List<Decimal> 短期入所生活介護リスト) {
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshien1().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshien2().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshienKei().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoKeikateki().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo1().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo2().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo3().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo4().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo5().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigoKei().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiGokei().getValue());
    }

    private void set給付費_短期入所療養介護介護老人保健施設リスト(List<Decimal> 介護老人保健施設リスト) {
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshien1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshien2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshienKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoKeikateki().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo3().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo4().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo5().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigoKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenGokei().getValue());
    }

    private void set給付費_短期入所療養介護介護療養型医療施設等リスト(List<Decimal> 介護療養型医療施設リスト) {
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshien1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshien2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshienKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoKeikateki().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo3().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo4().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo5().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigoKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoGokei().getValue());
    }

    private void set給付費_居住費滞在費リスト(List<Decimal> 居住費滞在費リスト) {
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshien1().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshien2().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshienKei().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiKaigoKeikateki().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo1().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo2().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo3().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo4().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo5().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigoKei().getValue());
        居住費滞在費リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiGokei().getValue());
    }

    private void set給付費_居住費_介護老人福祉施設リスト(List<Decimal> 介護老人福祉施設リスト) {
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshien1().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshien2().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshienKei().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo1().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo2().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo3().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo4().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo5().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigoKei().getValue());
        介護老人福祉施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiGokei().getValue());
    }

    private void set給付費_居住費_介護老人保健施設リスト(List<Decimal> 介護老人保健施設リスト) {
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshien1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshien2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshienKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo3().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo4().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo5().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigoKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiHokenGokei().getValue());
    }

    private void set給付費_居住費_介護療養型医療施設リスト(List<Decimal> 介護療養型医療施設リスト) {
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshien1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshien2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshienKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo1().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo2().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo3().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo4().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo5().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigoKei().getValue());
        介護療養型医療施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoGokei().getValue());
    }

    private void set給付費_居住費_地域密着型介護老人福祉施設入所者生活介護リスト(
            List<Decimal> 老人福祉施設入所者生活介護リスト) {
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoKeikateki().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo1().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo2().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo3().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo4().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo5().getValue());
        老人福祉施設入所者生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private void set給付費_居住費_短期入所生活介護リスト(List<Decimal> 短期入所生活介護リスト) {
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshien1().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshien2().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshienKei().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoKeikateki().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo1().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo2().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo3().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo4().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo5().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigoKei().getValue());
        短期入所生活介護リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiGokei().getValue());
    }

    private void set給付費_居住費_短期入所療養介護介護老人保健施設リスト(List<Decimal> 介護老人保健施設リスト) {
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshien1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshien2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshienKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoKeikateki().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo1().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo2().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo3().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo4().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo5().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigoKei().getValue());
        介護老人保健施設リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenGokei().getValue());
    }

    private void set給付費_居住費_短期入所療養介護介護療養型医療施設等リスト(List<Decimal> 介護療養型医療施設等リスト) {
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshien1().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshien2().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshienKei().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoKeikateki().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo1().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo2().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo3().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo4().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo5().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigoKei().getValue());
        介護療養型医療施設等リスト.add(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoGokei().getValue());
    }

    private void set給付費_総計リスト(List<Decimal> 総計リスト) {
        総計リスト.add(div.getPnl2().getPnl1().getTxt2SokeiYoboYoshien1().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt2SokeiYoboYoshien2().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt2SokeiYoboYoshienKei().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt2SokeiKaigoKeikateki().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo1().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo2().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo3().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo4().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo5().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigoKei().getValue());
        総計リスト.add(div.getPnl2().getPnl1().getTxt2SokeiGokei().getValue());
    }

}
