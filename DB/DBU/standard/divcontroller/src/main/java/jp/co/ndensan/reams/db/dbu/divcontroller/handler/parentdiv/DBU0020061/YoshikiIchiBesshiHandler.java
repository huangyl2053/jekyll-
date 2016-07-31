/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020061;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061.YoshikiIchiBesshiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 事業報告（月報）補正発行_様式１(別紙)のクラス
 *
 * @reamsid_L DBU-1100-020 lijunjun
 */
public final class YoshikiIchiBesshiHandler {

    private final YoshikiIchiBesshiDiv div;
    private static final RString 削除 = new RString("削除");
    private static final RString 更新 = new RString("更新");
    private static final int DATA_1 = 1;
    private static final int DATA_2 = 2;
    private static final int DATA_3 = 3;
    private static final int DATA_4 = 4;
    private static final Decimal DATA_ONE = new Decimal(1);
    private static final Decimal DATA_TWO = new Decimal(2);
    private static final Decimal DATA_THREE = new Decimal(3);
    private static final Decimal DATA_FOUR = new Decimal(4);
    private static final Code DATA = new Code(new RString("0100"));

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
     * setViewState
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @param 状態 RString
     */
    public void setViewState(JigyoHokokuGeppoParameter 引き継ぎデータ, RString 状態) {
        if (状態.equals(削除)) {
            div.setDisabled(true);
        }
        initializeKihoneria(引き継ぎデータ);
    }

    /**
     * show削除正常終了
     */
    public void show削除正常終了() {
        div.getKanryoMessage().getCcdKanryoMessage().setSuccessMessage(new RString(
                UrInformationMessages.正常終了.getMessage().replace(削除.toString()).evaluate()));
    }

    /**
     * show更新正常終了
     */
    public void show更新正常終了() {
        div.getKanryoMessage().getCcdKanryoMessage().setSuccessMessage(new RString(
                UrInformationMessages.正常終了.getMessage().replace(更新.toString()).evaluate()));
    }

    /**
     * 画面から修正データリストをDBに更新する。
     *
     * @param 修正データリスト List<JigyoHokokuNenpoUpdateParameter>
     * @return boolean
     */
    public boolean update(List<JigyoHokokuTokeiData> 修正データリスト) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
        return 修正データリスト.size() == finder.updateJigyoHokokuGeppoData(修正データリスト);
    }

    /**
     * is世帯数整合性チェックNG
     *
     * @return boolean
     */
    public boolean is世帯数整合性チェックNG() {
        Decimal 前月末現在 = div.getYoshikiIchiBesshiIchi().getTxtZengetsumatsugenzai().getValue();
        Decimal 月中増 = div.getYoshikiIchiBesshiIchi().getTxtTogetsuChuzo().getValue();
        Decimal 月中減 = div.getYoshikiIchiBesshiIchi().getTxtTogetsuChugen().getValue();
        Decimal 当月末現在 = div.getYoshikiIchiBesshiIchi().getTxtTogetsumatsugenzai().getValue();
        前月末現在 = null == 前月末現在 ? Decimal.ZERO : 前月末現在;
        月中増 = null == 月中増 ? Decimal.ZERO : 月中増;
        月中減 = null == 月中減 ? Decimal.ZERO : 月中減;
        当月末現在 = null == 当月末現在 ? Decimal.ZERO : 当月末現在;
        return !当月末現在.equals(前月末現在.add(月中増).subtract(月中減));
    }

    /**
     * initializeKihoneria
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     */
    public void initializeKihoneria(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        FlexibleDate 報告年月 = new FlexibleDate(引き継ぎデータ.get報告年月());
        FlexibleDate 集計年月 = new FlexibleDate(引き継ぎデータ.get集計年月());
        RString 保険者コード = 引き継ぎデータ.get保険者コード();
        RString 保険者名 = 引き継ぎデータ.get市町村名称();
        div.getYoshikiIchiBesshiHeader().getTxtHokokuNengetsu().setValue(new RDate(報告年月.toString()));
        div.getYoshikiIchiBesshiHeader().getTxtShukeiNengetsu().setValue(new RDate(集計年月.toString()));
        div.getYoshikiIchiBesshiHeader().getTxtYosikiHosei().setValue(保険者コード);
        div.getYoshikiIchiBesshiHeader().getTxtHokensyaName().setValue(保険者名);
    }

    /**
     * 更新前データリスト取得
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> get更新前データリスト(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        JigyoHokokuGeppoDetalSearchParameter par = JigyoHokokuGeppoDetalSearchParameter
                .createParameterForJigyoHokokuGeppoDetal(
                        new FlexibleYear(引き継ぎデータ.get行報告年()),
                        引き継ぎデータ.get行報告月(),
                        new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                        引き継ぎデータ.get行集計対象月(),
                        引き継ぎデータ.get行統計対象区分(),
                        new LasdecCode(引き継ぎデータ.get行市町村コード()),
                        new Code(引き継ぎデータ.get行表番号()),
                        DATA);
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
            if (更新前データ.get縦番号().intValue() == 1 && 更新前データ.get集計番号().equals(DATA)) {
                switch (更新前データ.get横番号().intValue()) {
                    case DATA_1:
                        div.getYoshikiIchiBesshiIchi().getTxtZengetsumatsugenzai().setValue(集計結果値);
                        break;
                    case DATA_2:
                        div.getYoshikiIchiBesshiIchi().getTxtTogetsuChuzo().setValue(集計結果値);
                        break;
                    case DATA_3:
                        div.getYoshikiIchiBesshiIchi().getTxtTogetsuChugen().setValue(集計結果値);
                        break;
                    case DATA_4:
                        div.getYoshikiIchiBesshiIchi().getTxtTogetsumatsugenzai().setValue(集計結果値);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * 修正データ
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> get修正データ(List<JigyoHokokuTokeiData> 引き継ぎデータ) {
        List<JigyoHokokuTokeiData> 修正データリスト = new ArrayList<>();
        for (JigyoHokokuTokeiData entity : 引き継ぎデータ) {
            if (isdata_ONE(entity)) {
                entity = entity.createBuilderForEdit().set集計結果値(
                        div.getYoshikiIchiBesshiIchi().getTxtZengetsumatsugenzai().getValue()).build();
                修正データリスト.add(entity);
            }
            if (isdata_TWO(entity)) {
                entity = entity.createBuilderForEdit().set集計結果値(
                        div.getYoshikiIchiBesshiIchi().getTxtTogetsuChuzo().getValue()).build();
                修正データリスト.add(entity);
            }
            if (isdata_THREE(entity)) {
                entity = entity.createBuilderForEdit().set集計結果値(
                        div.getYoshikiIchiBesshiIchi().getTxtTogetsuChugen().getValue()).build();
                修正データリスト.add(entity);
            }
            if (isdata_FOUR(entity)) {
                entity = entity.createBuilderForEdit().set集計結果値(
                        div.getYoshikiIchiBesshiIchi().getTxtTogetsumatsugenzai().getValue()).build();
                修正データリスト.add(entity);
            }
        }
        return 修正データリスト;
    }

    private boolean isdata_FOUR(JigyoHokokuTokeiData entity) {
        return entity.get横番号().equals(DATA_FOUR) && entity.get縦番号().equals(DATA_ONE)
                && entity.get集計番号().equals(DATA)
                && !entity.get集計結果値().equals(div.getYoshikiIchiBesshiIchi().getTxtTogetsumatsugenzai().getValue());
    }

    private boolean isdata_THREE(JigyoHokokuTokeiData entity) {
        return entity.get横番号().equals(DATA_THREE) && entity.get縦番号().equals(DATA_ONE)
                && entity.get集計番号().equals(DATA)
                && !entity.get集計結果値().equals(div.getYoshikiIchiBesshiIchi()
                        .getTxtTogetsuChugen().getValue());
    }

    private boolean isdata_TWO(JigyoHokokuTokeiData entity) {
        return entity.get横番号().equals(DATA_TWO) && entity.get縦番号().equals(DATA_ONE)
                && entity.get集計番号().equals(DATA)
                && !entity.get集計結果値().equals(div.getYoshikiIchiBesshiIchi().getTxtTogetsuChuzo().getValue());
    }

    private boolean isdata_ONE(JigyoHokokuTokeiData entity) {
        return entity.get横番号().equals(DATA_ONE) && entity.get縦番号().equals(DATA_ONE)
                && entity.get集計番号().equals(DATA)
                && !entity.get集計結果値().equals(div.getYoshikiIchiBesshiIchi()
                        .getTxtZengetsumatsugenzai().getValue());
    }
}
