/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0020061;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061.YoshikiIchiBesshiDiv;
import jp.co.ndensan.reams.db.dbu.service.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
//import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;

/**
 * 事業報告（月報）補正発行_様式１(別紙)のクラス
 */
public final class YoshikiIchiBesshiHandler {

    private final YoshikiIchiBesshiDiv div;
    private static final int 横番号_1 = 1;
    private static final int 横番号_2 = 2;
    private static final int 横番号_3 = 3;
    private static final int 横番号_4 = 4;

    private YoshikiIchiBesshiHandler(YoshikiIchiBesshiDiv div) {
        this.div = div;
    }

    /**
     * ofメソッド
     *
     * @param div YoshikiIchiBesshiDiv
     * @return YoshikiIchiBesshiHandler
     */
    public static YoshikiIchiBesshiHandler of(YoshikiIchiBesshiDiv div) {
        return new YoshikiIchiBesshiHandler(div);
    }

    /**
     * メソッド
     */
    public void disableMainPanel() {
        div.setDisabled(true);
    }

    /**
     * 世帯数整合性チェック
     *
     * @param div YoshikiIchiBesshiDiv
     */
    public void 世帯数整合性チェック(YoshikiIchiBesshiDiv div) {
        Decimal 前月末現在 = div.getYoshikiIchiBesshiIchi().getTxtZengetsumatsugenzai().getValue();
        Decimal 月中増 = div.getYoshikiIchiBesshiIchi().getTxtTogetsuChuzo().getValue();
        Decimal 月中減 = div.getYoshikiIchiBesshiIchi().getTxtTogetsuChugen().getValue();
        Decimal 当月末現在 = div.getYoshikiIchiBesshiIchi().getTxtTogetsumatsugenzai().getValue();
        if (!前月末現在.add(月中増).subtract(月中減).equals(当月末現在)) {
            throw new ApplicationException(UrWarningMessages.相違.getMessage().
                    replace("当月末現在の世帯数", "前月末世帯数から増減した世帯数の計算結果"));
        }
    }

    /**
     * initializeKihoneria初期化
     *
     * @param 更新前データ JigyoHokokuTokeiData
     */
    public void initializeKihoneria(JigyoHokokuTokeiData 更新前データ) {
        RStringBuilder 報告年月 = new RStringBuilder();
        報告年月.append(更新前データ.get報告年().toDateString());
        報告年月.append(更新前データ.get報告月());
        div.getYoshikiIchiBesshiHeader().getTxtHokokuNengetsu().setValue(new RDate(報告年月.toString()));
        RStringBuilder 集計年月 = new RStringBuilder();
        集計年月.append(更新前データ.get集計対象年().toDateString());
        集計年月.append(更新前データ.get集計対象月());
        div.getYoshikiIchiBesshiHeader().getTxtShukeiNengetsu().setValue(new RDate(集計年月.toString()));
        div.getYoshikiIchiBesshiHeader().getTxtYosikiHosei().setValue(new RString("0010"));
        div.getYoshikiIchiBesshiHeader().getTxtHokensyaName().setValue(new RString("張三"));
    }

    /**
     * 更新前データリスト取得
     *
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>
     */
    public List<JigyoHokokuTokeiData> get更新前データリスト() {
        JigyoHokokuGeppoDetalSearchParameter par = JigyoHokokuGeppoDetalSearchParameter
                .createParameterForJigyoHokokuGeppoDetal(
                        new FlexibleYear("2015"),
                        new RString("06"),
                        new FlexibleYear("2015"),
                        new RString("06"),
                        new RString("3"),
                        new LasdecCode("209008"),
                        new Code("03"),
                        new Code("0100"));
        List<JigyoHokokuTokeiData> 更新前データリスト = JigyoHokokuGeppoHoseiHako
                .createInstance().getJigyoHokokuGeppoDetal(par);
        return 更新前データリスト;
    }

    /**
     * 画面初期化処理します。
     *
     * @param 更新前データリスト List<JigyoHokokuTokeiData>
     */
    public void 更新前データリスト初期化(List<JigyoHokokuTokeiData> 更新前データリスト) {

        for (JigyoHokokuTokeiData 更新前データ : 更新前データリスト) {
            Decimal 集計結果値 = 更新前データ.get集計結果値();
            if (更新前データ.get縦番号().intValue() == 1) {
                switch (更新前データ.get横番号().intValue()) {
                    case 横番号_1:
                        div.getYoshikiIchiBesshiIchi().getTxtZengetsumatsugenzai().setValue(集計結果値);
                        break;
                    case 横番号_2:
                        div.getYoshikiIchiBesshiIchi().getTxtTogetsuChuzo().setValue(集計結果値);
                        break;
                    case 横番号_3:
                        div.getYoshikiIchiBesshiIchi().getTxtTogetsuChugen().setValue(集計結果値);
                        break;
                    case 横番号_4:
                        div.getYoshikiIchiBesshiIchi().getTxtTogetsumatsugenzai().setValue(集計結果値);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * set第1号被保険者のいる世帯数
     *
     * @param 第1号被保険者のいる世帯数 List<Decimal>
     */
    public void set第1号被保険者のいる世帯数(List<Decimal> 第1号被保険者のいる世帯数) {
        第1号被保険者のいる世帯数.add(div.getYoshikiIchiBesshiIchi().getTxtZengetsumatsugenzai().getValue());
        第1号被保険者のいる世帯数.add(div.getYoshikiIchiBesshiIchi().getTxtTogetsuChuzo().getValue());
        第1号被保険者のいる世帯数.add(div.getYoshikiIchiBesshiIchi().getTxtTogetsuChugen().getValue());
        第1号被保険者のいる世帯数.add(div.getYoshikiIchiBesshiIchi().getTxtTogetsumatsugenzai().getValue());
    }

    /**
     *
     * @param 更新前データ
     * @param 集計番号
     * @param 横番号
     * @param 縦番号
     * @param 集計結果値
     * @return JigyoHokokuTokeiData
     */
    private JigyoHokokuTokeiData get画面データ(
            JigyoHokokuTokeiData 更新前データ,
            Code 集計番号,
            Decimal 横番号,
            Decimal 縦番号,
            Decimal 集計結果値) {
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
        画面データ = 画面データ.createBuilderForEdit().set集計結果値(集計結果値).build();
        return 画面データ;
    }

    /**
     * get修正データリスト
     *
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> get修正データリスト() {

        List<JigyoHokokuTokeiData> 更新前データリスト = get更新前データリスト();
        JigyoHokokuTokeiData 更新前データ = 更新前データリスト.get(0);
        List<JigyoHokokuTokeiData> 画面データリスト = new ArrayList<>();
        // 修正データを格納するリストを初期化する
        List<Decimal> 第1号被保険者のいる世帯数リスト = new ArrayList<>();
        set第1号被保険者のいる世帯数(第1号被保険者のいる世帯数リスト);

        set画面データリスト(
                画面データリスト, 更新前データ, new Code(new RString("0100")), 第1号被保険者のいる世帯数リスト, new Decimal(1));
        List<JigyoHokokuTokeiData> 修正データリスト = new ArrayList<>();
        for (JigyoHokokuTokeiData entity1 : 更新前データリスト) {
            for (JigyoHokokuTokeiData entity2 : 画面データリスト) {
                if (entity1.get横番号().equals(entity2.get横番号()) && !entity1.get集計結果値().equals(entity2.get集計結果値())) {
                    entity1 = entity1.createBuilderForEdit().set集計結果値(entity2.get集計結果値()).build();
                    修正データリスト.add(entity1);
                }
            }
        }
        return 修正データリスト;
    }

    /**
     * 画面データリスト取得
     *
     * @param 画面データリスト List
     * @param 更新前データ DbT7021JigyoHokokuTokeiDataEntity
     * @param 集計番号 Code
     * @param 集計結果値リスト List<Decimal>
     * @param 縦番号 Decimal
     */
    public void set画面データリスト(
            List 画面データリスト,
            JigyoHokokuTokeiData 更新前データ,
            Code 集計番号,
            List<Decimal> 集計結果値リスト,
            Decimal 縦番号) {
        for (int i = 0; i < 集計結果値リスト.size(); i++) {
            画面データリスト.add(get画面データ(更新前データ, 集計番号, new Decimal(i + 1), 縦番号, 集計結果値リスト.get(i)));
        }
    }
}
