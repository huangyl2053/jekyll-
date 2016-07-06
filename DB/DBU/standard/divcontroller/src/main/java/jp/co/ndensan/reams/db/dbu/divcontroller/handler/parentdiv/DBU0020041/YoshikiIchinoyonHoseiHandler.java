/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020041;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041.YoshikiIchinoyonHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * Mainハンドラークラスです。
 *
 * @reamsid_L DBU-1100-040 yebangqiang
 */
public final class YoshikiIchinoyonHoseiHandler {

    private static final RString 様式種類_008 = new RString("008");
    private static final RString 様式種類_108 = new RString("108");
    private static final RString 様式種類_009 = new RString("009");
    private static final RString 様式種類_109 = new RString("109");
    private static final RString 集計番号_1030 = new RString("1030");
    private static final RString 集計番号_1040 = new RString("1040");
    private final YoshikiIchinoyonHoseiDiv div;
    private static final int 横番号_1 = 1;
    private static final int 横番号_2 = 2;
    private static final int 横番号_3 = 3;
    private static final int 横番号_4 = 4;
    private static final int 横番号_5 = 5;
    private static final int 横番号_6 = 6;
    private static final int 横番号_7 = 7;
    private static final int 横番号_8 = 8;
    private static final int 横番号_9 = 9;
    private static final int 横番号_10 = 10;
    private static final int 横番号_11 = 11;
    private static final int 横番号_12 = 12;
    private static final int 縦番号_1 = 1;
    private static final int 縦番号_2 = 2;
    private static final int 縦番号_3 = 3;
    private static final int 縦番号_4 = 4;
    private static final int 縦番号_5 = 5;
    private static final int 縦番号_6 = 6;
    private static final int 縦番号_7 = 7;

    private YoshikiIchinoyonHoseiHandler(YoshikiIchinoyonHoseiDiv div) {
        this.div = div;
    }

    /**
     * ハンドラー生成するメソッドです。
     *
     * @param div 画面DIV
     * @return Mainハンドラークラス
     */
    public static YoshikiIchinoyonHoseiHandler of(YoshikiIchinoyonHoseiDiv div) {
        return new YoshikiIchinoyonHoseiHandler(div);
    }

    /**
     * 削除状態、パネルを非活性するメソッドです。
     */
    public void disableMainPanel() {
        div.setDisabled(true);
    }

    /**
     * 基本エリアの初期化するメソッドです。
     *
     * @param 引き継ぎデータ 引き継ぎデータ
     */
    public void initializeKihoneria(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        div.getYoshikiIchinoyonHoseiHeader().getTxtHokokuNengetsu().setValue(new RDate(
                引き継ぎデータ.get報告年月().toString()));
        div.getYoshikiIchinoyonHoseiHeader().getTxtShukeiNengetsu().setValue(new RDate(
                引き継ぎデータ.get集計年月().toString()));
        div.getYoshikiIchinoyonHoseiHeader().getTxtHokenshaNo().setValue(引き継ぎデータ.get保険者コード());
        div.getYoshikiIchinoyonHoseiHeader().getTxtHokenshaName().setValue(引き継ぎデータ.get市町村名称());
    }

    /**
     * 更新前データリストの取得するメッソドです。
     *
     * @param 引き継ぎデータ 引き継ぎデータ
     * @param 様式種類 様式種類
     * @return 更新前データリスト
     */
    public List<JigyoHokokuTokeiData> get更新前データリスト(JigyoHokokuGeppoParameter 引き継ぎデータ, RString 様式種類) {
        JigyoHokokuGeppoDetalSearchParameter param = null;
        if (様式種類_008.equals(様式種類) || 様式種類_108.equals(様式種類)) {
            param = JigyoHokokuGeppoDetalSearchParameter.
                    createParameterForJigyoHokokuGeppoDetal(
                            new FlexibleYear(引き継ぎデータ.get行報告年()),
                            引き継ぎデータ.get行報告月(),
                            new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                            引き継ぎデータ.get行集計対象月(),
                            引き継ぎデータ.get行統計対象区分(),
                            new LasdecCode(引き継ぎデータ.get行市町村コード()),
                            new Code(引き継ぎデータ.get行表番号()),
                            new Code(集計番号_1040));
        } else if (様式種類_009.equals(様式種類) || 様式種類_109.equals(様式種類)) {
            param = JigyoHokokuGeppoDetalSearchParameter.
                    createParameterForJigyoHokokuGeppoDetal(
                            new FlexibleYear(引き継ぎデータ.get行報告年()),
                            引き継ぎデータ.get行報告月(),
                            new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                            引き継ぎデータ.get行集計対象月(),
                            引き継ぎデータ.get行統計対象区分(),
                            new LasdecCode(引き継ぎデータ.get行市町村コード()),
                            new Code(引き継ぎデータ.get行表番号()),
                            new Code(集計番号_1030));
        }
        return JigyoHokokuGeppoHoseiHako.createInstance().getJigyoHokokuGeppoDetal(param);
    }

    /**
     * 修正データの取得するメッソドです。
     *
     * @param 引き継ぎデータ List<JigyoHokokuTokeiData>
     * @param 様式種類 様式種類
     * @return 修正データリスト 修正データリスト
     */
    public List<JigyoHokokuTokeiData> get修正データ(List<JigyoHokokuTokeiData> 引き継ぎデータ, RString 様式種類) {
        List<JigyoHokokuTokeiData> 更新前データリスト = 引き継ぎデータ;

        JigyoHokokuTokeiData 更新前データ = 更新前データリスト.get(0);
        List<JigyoHokokuTokeiData> 画面データリスト = new ArrayList<>();
        if (様式種類_008.equals(様式種類) || 様式種類_108.equals(様式種類)) {
            List<Decimal> 申請件数リスト = new ArrayList<>();
            set申請件数リスト(申請件数リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1040), 申請件数リスト, new Decimal(縦番号_1));
            List<Decimal> 利用者負担第三段階認定件数リスト = new ArrayList<>();
            set利用者負担第三段階認定件数リスト(利用者負担第三段階認定件数リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1040), 利用者負担第三段階認定件数リスト,
                    new Decimal(縦番号_2));

            List<Decimal> 第三段階認定件数当該月末現在リスト = new ArrayList<>();
            set第三段階認定件数当該月末現在リスト(第三段階認定件数当該月末現在リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1040), 第三段階認定件数当該月末現在リスト,
                    new Decimal(縦番号_3));

            List<Decimal> 利用者負担第二段階認定件数リスト = new ArrayList<>();
            set利用者負担第二段階認定件数リスト(利用者負担第二段階認定件数リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1040), 利用者負担第二段階認定件数リスト,
                    new Decimal(縦番号_4));

            List<Decimal> 第二段階認定件数当該月末現在リスト = new ArrayList<>();
            set第二段階認定件数当該月末現在リスト(第二段階認定件数当該月末現在リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1040), 第二段階認定件数当該月末現在リスト,
                    new Decimal(縦番号_5));
        } else if (様式種類_009.equals(様式種類) || 様式種類_109.equals(様式種類)) {
            List<Decimal> 第4段階申請件数リスト = new ArrayList<>();
            set第4段階申請件数リスト(第4段階申請件数リスト);
            set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_1030), 第4段階申請件数リスト,
                    new Decimal(縦番号_1));
            List<Decimal> 食费のみ減額認定件数リスト = new ArrayList<>();
            set食费のみ減額認定件数リスト(食费のみ減額認定件数リスト);
            set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_1030), 食费のみ減額認定件数リスト,
                    new Decimal(縦番号_2));
            List<Decimal> 食费のみ減額認定件数累積リスト = new ArrayList<>();
            set食费のみ減額認定件数累積リスト(食费のみ減額認定件数累積リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1030), 食费のみ減額認定件数累積リスト,
                    new Decimal(縦番号_3));
            List<Decimal> 居住費のみ減額認定件数リスト = new ArrayList<>();
            set居住費のみ減額認定件数リスト(居住費のみ減額認定件数リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1030), 居住費のみ減額認定件数リスト,
                    new Decimal(縦番号_4));
            List<Decimal> 居住費のみ減額認定件数累積リスト = new ArrayList<>();
            set居住費のみ減額認定件数累積リスト(居住費のみ減額認定件数累積リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1030), 居住費のみ減額認定件数累積リスト,
                    new Decimal(縦番号_5));
            List<Decimal> 食费及び居住費減額認定件数リスト = new ArrayList<>();
            set食费及び居住費減額認定件数リスト(食费及び居住費減額認定件数リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1030), 食费及び居住費減額認定件数リスト,
                    new Decimal(縦番号_6));
            List<Decimal> 食费及び居住費減額認定件数累積リスト = new ArrayList<>();
            set食费及び居住費減額認定件数累積リスト(食费及び居住費減額認定件数累積リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1030), 食费及び居住費減額認定件数累積リスト,
                    new Decimal(縦番号_7));
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
                        && (更新前.get集計結果値() == null || (!更新前.get集計結果値().equals(画面データ.get集計結果値())))) {
                    更新前 = 更新前.createBuilderForEdit().set集計結果値(画面データ.get集計結果値()).build();
                    修正データリスト.add(更新前);
                }
            }
        }
        return 修正データリスト;
    }

    private JigyoHokokuTokeiData get更新前空データ(
            List<JigyoHokokuTokeiData> 更新前縦番号横番号リスト,
            JigyoHokokuTokeiData 画面データ) {
        boolean 更新前含む = false;
        for (JigyoHokokuTokeiData 更新前 : 更新前縦番号横番号リスト) {
            if (更新前.get横番号().equals(画面データ.get横番号()) && 更新前.get縦番号().equals(画面データ.get縦番号())) {
                更新前含む = true;
                break;
            }
        }
        if (!更新前含む) {
            return 画面データ;
        }
        return null;
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

    private void set申請件数リスト(List<Decimal> 申請件数リスト) {
        申請件数リスト.add(div.getYoshikiIchinoyonHosei9().getTxtFukushiShisetsuShinseiSu().getValue());
        申請件数リスト.add(div.getYoshikiIchinoyonHosei9().getTxtHokenShisetsuShinseiSu().getValue());
        申請件数リスト.add(div.getYoshikiIchinoyonHosei9().getTxtIryoShisetsuShinseiSu().getValue());
        申請件数リスト.add(div.getYoshikiIchinoyonHosei9().getTxtSeiKatsuKaigoShinseiSu().getValue());
        申請件数リスト.add(div.getYoshikiIchinoyonHosei9().getTxtSonotaShinseiSu().getValue());
        申請件数リスト.add(div.getYoshikiIchinoyonHosei9().getTxtKeiShinseiSu().getValue());
    }

    private void set利用者負担第三段階認定件数リスト(List<Decimal> 利用者負担第三段階認定件数リスト) {
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtFukushiShisetsuDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtFukushiShisetsuDaisanDankaiKyojuhi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtHokenShisetsuDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtHokenShisetsuDaisanDankaiKyojuhi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtIryoShisetsuDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtIryoShisetsuDaisanDankaiKyojuhi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSeikatsuKaigoShisetsuDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSeikatsuKaigoShisetsuDaisanDankaiKyojuhi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSonotaShisetsuDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSonotaShisetsuDaisanDankaiKyojuhi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtKeiDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtKeiDaisanDankaiKyojuhi().getValue());
    }

    private void set第三段階認定件数当該月末現在リスト(List<Decimal> 認定件数当該月末現在リスト) {
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtFukushiShisetsuDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtFukushiShisetsuDaisanDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtHokenShisetsuDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtHokenShisetsuDaisanDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtIryoShisetsuDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtIryoShisetsuDaisanDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtSonotaShisetsuDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtSonotaShisetsuDaisanDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtKeiDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(div.getYoshikiIchinoyonHosei9().
                getTxtKeiDaisanDankaiToGetsumatsuKyojuhi().getValue());
    }

    private void set利用者負担第二段階認定件数リスト(List<Decimal> 利用者負担第二段階認定件数リスト) {
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtFukushiShisetsuDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtFukushiShisetsuDainiDankaiKyojuhi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtHokenShisetsuDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtHokenShisetsuDainiDankaiKyojuhi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtIryoShisetsuDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtIryoShisetsuDainiDankaiKyojuhi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSeikatsuKaigoShisetsuDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSeikatsuKaigoShisetsuDainiDankaiKyojuhi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSonotaShisetsuDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSonotaShisetsuDainiDankaiKyojuhi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtKeiDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtKeiDainiDankaiKyojuhi().getValue());
    }

    private void set第二段階認定件数当該月末現在リスト(List<Decimal> 認定件数当該月末現在リスト) {
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtFukushiShisetsuDainiDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtFukushiShisetsuDainiDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtHokenShisetsuDainiDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtHokenShisetsuDainiDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtIryoShisetsuDainiDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtIryoShisetsuDainiDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSonotaShisetsuDaiichiDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtSonotaShisetsuDainiDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtKeiDainiDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getYoshikiIchinoyonHosei9().getTxtKeiDainiDankaiToGetsumatsuKyojuhi().getValue());
    }

    private void set画面データリスト(
            List<JigyoHokokuTokeiData> 画面データリスト,
            JigyoHokokuTokeiData 更新前データ,
            Code 集計番号,
            List<Decimal> 件数リスト,
            Decimal 縦番号) {
        for (int i = 0; i < 件数リスト.size(); i++) {
            画面データリスト.add(get画面データ(更新前データ, 集計番号, new Decimal(i + 1), 縦番号, 件数リスト.get(i)));
        }
    }

    private void set第4段階申請件数リスト(List<Decimal> 申請件数リスト) {
        申請件数リスト.add(div.getYoshikiIchinoyonHosei10().getTxtDanichigouShinseiSu().getValue());
        申請件数リスト.add(div.getYoshikiIchinoyonHosei10().getTxtDannigouShinseiSu().getValue());
        申請件数リスト.add(div.getYoshikiIchinoyonHosei10().getTxtGokeiShinseiSu().getValue());
    }

    private void set食费のみ減額認定件数リスト(List<Decimal> 食费のみ減額認定件数リスト) {
        食费のみ減額認定件数リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouShokujihiGengakuNinteiSu().getValue());
        食费のみ減額認定件数リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDannigouShokujihiGengakuNinteiSu().getValue());
        食费のみ減額認定件数リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtGokeiShokujihiGengakuNinteiSu().getValue());
    }

    private void set食费のみ減額認定件数累積リスト(List<Decimal> 食费のみ減額認定件数累積リスト) {
        食费のみ減額認定件数累積リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouShokujiGengakuNinteiKei().getValue());
        食费のみ減額認定件数累積リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDannigouShokujiGengakuNinteiKei().getValue());
        食费のみ減額認定件数累積リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtGokeiShokujiGengakuNinteiKei().getValue());
    }

    private void set居住費のみ減額認定件数リスト(List<Decimal> 居住費のみ減額認定件数リスト) {
        居住費のみ減額認定件数リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouKyojuhiGengakuNinteiSu().getValue());
        居住費のみ減額認定件数リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDannigouKyojuhiGengakuNinteiSu().getValue());
        居住費のみ減額認定件数リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtGokeiKyojuhiGengakuNinteiSu().getValue());
    }

    private void set居住費のみ減額認定件数累積リスト(List<Decimal> 居住費のみ減額認定件数累積リスト) {
        居住費のみ減額認定件数累積リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouKyojuhiGengakuNinteiKei().getValue());
        居住費のみ減額認定件数累積リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDannigouKyojuhiGengakuNinteiKei().getValue());
        居住費のみ減額認定件数累積リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtGokeiKyojuhiGengakuNinteiKei().getValue());
    }

    private void set食费及び居住費減額認定件数リスト(List<Decimal> 食费及び居住費減額認定件数リスト) {
        食费及び居住費減額認定件数リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouSJGengakuNinteiSu().getValue());
        食费及び居住費減額認定件数リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDannigouSJGengakuNinteiSu().getValue());
        食费及び居住費減額認定件数リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtGokeiSJGengakuNinteiSu().getValue());
    }

    private void set食费及び居住費減額認定件数累積リスト(List<Decimal> 食费及び居住費減額認定件数累積リスト) {
        食费及び居住費減額認定件数累積リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouSJGengakuNinteiKei().getValue());
        食费及び居住費減額認定件数累積リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtDannigouSJGengakuNinteiKei().getValue());
        食费及び居住費減額認定件数累積リスト.add(
                div.getYoshikiIchinoyonHosei10().getTxtGokeiSJGengakuNinteiKei().getValue());
    }

    /**
     * 画面初期化メソッドです。
     *
     * @param 更新前データリスト 更新前データリスト
     * @param 様式種類 様式種類
     */
    public void initializeTabList(List<JigyoHokokuTokeiData> 更新前データリスト, RString 様式種類) {
        if (様式種類_008.equals(様式種類) || 様式種類_108.equals(様式種類)) {
            for (JigyoHokokuTokeiData 更新前データ : 更新前データリスト) {
                Decimal 集計結果値 = 更新前データ.get集計結果値();
                switch (更新前データ.get縦番号().intValue()) {
                    case 縦番号_1:
                        set様式種類008縦番号１の集計結果値(更新前データ, 集計結果値);
                        break;
                    case 縦番号_2:
                        set様式種類008縦番号２の集計結果値(更新前データ, 集計結果値);
                        break;
                    case 縦番号_3:
                        set様式種類008縦番号３の集計結果値(更新前データ, 集計結果値);
                        break;
                    case 縦番号_4:
                        set様式種類008縦番号４の集計結果値(更新前データ, 集計結果値);
                        break;
                    case 縦番号_5:
                        set様式種類008縦番号５の集計結果値(更新前データ, 集計結果値);
                        break;
                    default:
                        break;
                }
            }
        } else if (様式種類_009.equals(様式種類) || 様式種類_109.equals(様式種類)) {
            for (JigyoHokokuTokeiData 更新前データ : 更新前データリスト) {
                Decimal 集計結果値 = 更新前データ.get集計結果値();
                switch (更新前データ.get縦番号().intValue()) {
                    case 縦番号_1:
                        set様式種類009縦番号１の集計結果値(更新前データ, 集計結果値);
                        break;
                    case 縦番号_2:
                        set様式種類009縦番号２の集計結果値(更新前データ, 集計結果値);
                        break;
                    case 縦番号_3:
                        set様式種類009縦番号３の集計結果値(更新前データ, 集計結果値);
                        break;
                    case 縦番号_4:
                        set様式種類009縦番号４の集計結果値(更新前データ, 集計結果値);
                        break;
                    case 縦番号_5:
                        set様式種類009縦番号５の集計結果値(更新前データ, 集計結果値);
                        break;
                    case 縦番号_6:
                        set様式種類009縦番号６の集計結果値(更新前データ, 集計結果値);
                        break;
                    case 縦番号_7:
                        set様式種類009縦番号７の集計結果値(更新前データ, 集計結果値);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void set様式種類009縦番号７の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouSJGengakuNinteiKei().
                        setValue(集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei10().getTxtDannigouSJGengakuNinteiKei().
                        setValue(集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei10().getTxtGokeiSJGengakuNinteiKei().
                        setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set様式種類009縦番号６の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouSJGengakuNinteiSu().
                        setValue(集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei10().getTxtDannigouSJGengakuNinteiSu().
                        setValue(集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei10().getTxtGokeiSJGengakuNinteiSu().
                        setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set様式種類009縦番号５の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouKyojuhiGengakuNinteiKei().
                        setValue(集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei10().getTxtDannigouKyojuhiGengakuNinteiKei().
                        setValue(集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei10().getTxtGokeiKyojuhiGengakuNinteiKei().
                        setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set様式種類009縦番号４の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouKyojuhiGengakuNinteiSu().
                        setValue(集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei10().getTxtDannigouKyojuhiGengakuNinteiSu().
                        setValue(集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei10().getTxtGokeiKyojuhiGengakuNinteiSu().
                        setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set様式種類009縦番号３の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei10().
                        getTxtDanichigouShokujiGengakuNinteiKei().setValue(集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei10().getTxtDannigouShokujiGengakuNinteiKei().
                        setValue(集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei10().getTxtGokeiShokujiGengakuNinteiKei().
                        setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set様式種類009縦番号２の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei10().
                        getTxtDanichigouShokujihiGengakuNinteiSu().setValue(集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei10().
                        getTxtDannigouShokujihiGengakuNinteiSu().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei10().
                        getTxtGokeiShokujihiGengakuNinteiSu().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set様式種類009縦番号１の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouShinseiSu().setValue(
                        集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei10().getTxtDannigouShinseiSu().setValue(
                        集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei10().getTxtGokeiShinseiSu().setValue(
                        集計結果値);
                break;
            default:
                break;
        }
    }

    private void set様式種類008縦番号５の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei9().getTxtFukushiShisetsuDainiDankaiToGetsumatsuShokujihi().setValue(
                        集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei9().
                        getTxtFukushiShisetsuDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei9().
                        getTxtHokenShisetsuDainiDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getYoshikiIchinoyonHosei9().
                        getTxtHokenShisetsuDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getYoshikiIchinoyonHosei9().
                        getTxtIryoShisetsuDainiDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getYoshikiIchinoyonHosei9().
                        getTxtIryoShisetsuDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSonotaShisetsuDaiichiDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSonotaShisetsuDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getYoshikiIchinoyonHosei9().
                        getTxtKeiDainiDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getYoshikiIchinoyonHosei9().
                        getTxtKeiDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set様式種類008縦番号４の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei9().
                        getTxtFukushiShisetsuDainiDankaiShokujihi().setValue(集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei9().
                        getTxtFukushiShisetsuDainiDankaiKyojuhi().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei9().
                        getTxtHokenShisetsuDainiDankaiShokujihi().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getYoshikiIchinoyonHosei9().
                        getTxtHokenShisetsuDainiDankaiKyojuhi().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getYoshikiIchinoyonHosei9().
                        getTxtIryoShisetsuDainiDankaiShokujihi().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getYoshikiIchinoyonHosei9().
                        getTxtIryoShisetsuDainiDankaiKyojuhi().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSeikatsuKaigoShisetsuDainiDankaiShokujihi().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSeikatsuKaigoShisetsuDainiDankaiKyojuhi().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSonotaShisetsuDainiDankaiShokujihi().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSonotaShisetsuDainiDankaiKyojuhi().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getYoshikiIchinoyonHosei9().getTxtKeiDainiDankaiShokujihi().
                        setValue(集計結果値);
                break;
            case 横番号_12:
                div.getYoshikiIchinoyonHosei9().getTxtKeiDainiDankaiKyojuhi().
                        setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set様式種類008縦番号３の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei9().
                        getTxtFukushiShisetsuDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei9().
                        getTxtFukushiShisetsuDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei9().
                        getTxtHokenShisetsuDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getYoshikiIchinoyonHosei9().
                        getTxtHokenShisetsuDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getYoshikiIchinoyonHosei9().
                        getTxtIryoShisetsuDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getYoshikiIchinoyonHosei9().
                        getTxtIryoShisetsuDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSonotaShisetsuDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSonotaShisetsuDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getYoshikiIchinoyonHosei9().
                        getTxtKeiDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getYoshikiIchinoyonHosei9().
                        getTxtKeiDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set様式種類008縦番号２の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei9().
                        getTxtFukushiShisetsuDaisanDankaiShokujihi().setValue(集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei9().
                        getTxtFukushiShisetsuDaisanDankaiKyojuhi().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei9().
                        getTxtHokenShisetsuDaisanDankaiShokujihi().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getYoshikiIchinoyonHosei9().
                        getTxtHokenShisetsuDaisanDankaiKyojuhi().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getYoshikiIchinoyonHosei9().
                        getTxtIryoShisetsuDaisanDankaiShokujihi().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getYoshikiIchinoyonHosei9().
                        getTxtIryoShisetsuDaisanDankaiKyojuhi().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSeikatsuKaigoShisetsuDaisanDankaiShokujihi().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSeikatsuKaigoShisetsuDaisanDankaiKyojuhi().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSonotaShisetsuDaisanDankaiShokujihi().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getYoshikiIchinoyonHosei9().
                        getTxtSonotaShisetsuDaisanDankaiKyojuhi().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getYoshikiIchinoyonHosei9().
                        getTxtKeiDaisanDankaiShokujihi().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getYoshikiIchinoyonHosei9().
                        getTxtKeiDaisanDankaiKyojuhi().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set様式種類008縦番号１の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_1:
                div.getYoshikiIchinoyonHosei9().getTxtFukushiShisetsuShinseiSu().setValue(
                        集計結果値);
                break;
            case 横番号_2:
                div.getYoshikiIchinoyonHosei9().getTxtHokenShisetsuShinseiSu().setValue(
                        集計結果値);
                break;
            case 横番号_3:
                div.getYoshikiIchinoyonHosei9().getTxtIryoShisetsuShinseiSu().setValue(
                        集計結果値);
                break;
            case 横番号_4:
                div.getYoshikiIchinoyonHosei9().getTxtSeiKatsuKaigoShinseiSu().setValue(
                        集計結果値);
                break;
            case 横番号_5:
                div.getYoshikiIchinoyonHosei9().getTxtSonotaShinseiSu().setValue(
                        集計結果値);
                break;
            case 横番号_6:
                div.getYoshikiIchinoyonHosei9().getTxtKeiShinseiSu().setValue(
                        集計結果値);
                break;
            default:
                break;
        }
    }

    /**
     * 整合性チェックするメッソドです。
     *
     * @param handler ハンドラー
     * @param div 画面DIV
     * @return 整合性チェック結果(true:結果が不整合 ;false:結果が整合)
     */
    public boolean is整合性チェック_NG(YoshikiIchinoyonHoseiHandler handler, YoshikiIchinoyonHoseiDiv div) {
        return handler.is第4段階データ不整合(
                div.getYoshikiIchinoyonHosei10().getTxtDanichigouShinseiSu().getValue(),
                div.getYoshikiIchinoyonHosei10().getTxtDannigouShinseiSu().getValue(),
                div.getYoshikiIchinoyonHosei10().getTxtGokeiShinseiSu().getValue())
                || handler.is第4段階データ不整合(
                        div.getYoshikiIchinoyonHosei10().getTxtDanichigouShokujihiGengakuNinteiSu().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtDannigouShokujihiGengakuNinteiSu().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtGokeiShokujihiGengakuNinteiSu().getValue())
                || handler.is第4段階データ不整合(
                        div.getYoshikiIchinoyonHosei10().getTxtDanichigouShokujiGengakuNinteiKei().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtDannigouShokujiGengakuNinteiKei().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtGokeiShokujiGengakuNinteiKei().getValue())
                || handler.is第4段階データ不整合(
                        div.getYoshikiIchinoyonHosei10().getTxtDanichigouKyojuhiGengakuNinteiSu().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtDannigouKyojuhiGengakuNinteiSu().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtGokeiKyojuhiGengakuNinteiSu().getValue())
                || handler.is第4段階データ不整合(
                        div.getYoshikiIchinoyonHosei10().getTxtDanichigouKyojuhiGengakuNinteiKei().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtDannigouKyojuhiGengakuNinteiKei().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtGokeiKyojuhiGengakuNinteiKei().getValue())
                || handler.is第4段階データ不整合(
                        div.getYoshikiIchinoyonHosei10().getTxtDanichigouSJGengakuNinteiSu().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtDannigouSJGengakuNinteiSu().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtGokeiSJGengakuNinteiSu().getValue())
                || handler.is第4段階データ不整合(
                        div.getYoshikiIchinoyonHosei10().getTxtDanichigouSJGengakuNinteiKei().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtDannigouSJGengakuNinteiKei().getValue(),
                        div.getYoshikiIchinoyonHosei10().getTxtGokeiSJGengakuNinteiKei().getValue());
    }

    /**
     * 整合性チェックするメッソドです。
     *
     * @param div 画面DIV
     * @return 整合性チェック結果(true:結果が不整合 ;false:結果が整合)
     */
    public boolean is合計結果チェック_NG(YoshikiIchinoyonHoseiDiv div) {
        Decimal 申請件数_介護老人福祉施設 = div.getYoshikiIchinoyonHosei9().getTxtFukushiShisetsuShinseiSu().getValue()
                == null ? Decimal.ZERO : div.getYoshikiIchinoyonHosei9().getTxtFukushiShisetsuShinseiSu().getValue();
        Decimal 申請件数_介護老人保健施設 = div.getYoshikiIchinoyonHosei9().getTxtHokenShisetsuShinseiSu().getValue()
                == null ? Decimal.ZERO : div.getYoshikiIchinoyonHosei9().getTxtHokenShisetsuShinseiSu().getValue();
        Decimal 申請件数_介護療養型医療施設 = div.getYoshikiIchinoyonHosei9().getTxtIryoShisetsuShinseiSu().getValue()
                == null ? Decimal.ZERO : div.getYoshikiIchinoyonHosei9().getTxtIryoShisetsuShinseiSu().getValue();
        Decimal 申請件数_地域密着型 = div.getYoshikiIchinoyonHosei9().getTxtSeiKatsuKaigoShinseiSu().getValue() == null
                ? Decimal.ZERO : div.getYoshikiIchinoyonHosei9().getTxtSeiKatsuKaigoShinseiSu().getValue();
        Decimal 申請件数_その他 = div.getYoshikiIchinoyonHosei9().getTxtSonotaShinseiSu().getValue() == null
                ? Decimal.ZERO : div.getYoshikiIchinoyonHosei9().getTxtSonotaShinseiSu().getValue();
        Decimal 申請件数_計 = div.getYoshikiIchinoyonHosei9().getTxtKeiShinseiSu().getValue() == null
                ? Decimal.ZERO : div.getYoshikiIchinoyonHosei9().getTxtKeiShinseiSu().getValue();
        return !申請件数_介護老人福祉施設.add(申請件数_介護老人保健施設).add(申請件数_介護療養型医療施設).add(
                申請件数_地域密着型).add(申請件数_その他).equals(申請件数_計);
    }

    /**
     * 整合性判断するメソッドです。
     *
     * @param 第1号被保険者 第1号被保険者
     * @param 第2号被保険者 第2号被保険者
     * @param 合計 合計
     * @return 整合結果(true:結果が不整合 ;false:結果が整合)
     */
    private boolean is第4段階データ不整合(Decimal 第1号被保険者, Decimal 第2号被保険者, Decimal 合計) {
        Decimal 第1号被保険者値 = 第1号被保険者 == null ? Decimal.ZERO : 第1号被保険者;
        Decimal 第2号被保険者値 = 第2号被保険者 == null ? Decimal.ZERO : 第2号被保険者;
        Decimal 合計値 = 合計 == null ? Decimal.ZERO : 合計;
        return !第1号被保険者値.add(第2号被保険者値).equals(合計値);
    }

    /**
     * 引き継ぎデータより、データ削除する。
     *
     * @param 引き継ぎデータ List<JigyoHokokuTokeiData>
     */
    public void delete(List<JigyoHokokuTokeiData> 引き継ぎデータ) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
        finder.deleteJigyoHokokuGeppoData(引き継ぎデータ);
    }

}
