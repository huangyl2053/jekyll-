 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021.DBU0020021StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021.JigyoHokokuGeppoYoshikiIchiHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021.tplFirstHihokensyaUtiwakeDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021.tplFirstHihokensyasuDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 事業報告（月報）補正発行_様式１補正画面のHandlerです。
 *
 * @reamsid_L DBU-1100-060 zhangrui
 */
public class JigyoHokokuGeppoYoshikiIchiHoseiHandler {

    private static final Decimal 横番号_1 = new Decimal(1);
    private static final Decimal 横番号_2 = new Decimal(2);
    private static final Decimal 横番号_3 = new Decimal(3);
    private static final Decimal 横番号_4 = new Decimal(4);
    private static final Decimal 横番号_5 = new Decimal(5);
    private static final Decimal 横番号_6 = new Decimal(6);
    private static final Decimal 縦番号_1 = new Decimal(1);
    private static final Decimal 縦番号_2 = new Decimal(2);
    private static final Decimal 縦番号_3 = new Decimal(3);
    private static final Decimal 縦番号_4 = new Decimal(4);
    private static final Decimal 縦番号_5 = new Decimal(5);
    private static final Code 集計番号_0200 = new Code("0200");
    private static final Code 集計番号_0301 = new Code("0301");
    private static final Code 集計番号_0302 = new Code("0302");

    private static final RString KEY_第1号被保険者数情報 = new RString("第1号被保険者数情報");
    private static final RString KEY_第1号被保険者増減内訳情報_当月中増 = new RString("第1号被保険者増減内訳情報_当月中増");
    private static final RString KEY_第1号被保険者増減内訳情報_当月中滅 = new RString("第1号被保険者増減内訳情報_当月中滅");

    private final JigyoHokokuGeppoYoshikiIchiHoseiDiv parentDiv;

    /**
     * コンストラクタです。
     *
     * @param parentDiv 様式１補正情報Div
     */
    public JigyoHokokuGeppoYoshikiIchiHoseiHandler(JigyoHokokuGeppoYoshikiIchiHoseiDiv parentDiv) {
        this.parentDiv = parentDiv;
    }

    /**
     * 画面初期化処理します。
     *
     * @param 引き継ぎデータ HoseitaishoYoshikiIchiranParameter
     * @param viewState 表示状態
     */
    public void setViewState(JigyoHokokuGeppoParameter 引き継ぎデータ, RString viewState) {
        if (DBU0020021StateName.削除状態.getName().equals(viewState)) {
            this.parentDiv.getFirstHihokensyasu().setDisabled(true);
            this.parentDiv.getFirstHihokensyaUtiwake().setDisabled(true);
        }
        FlexibleDate 報告年月 = new FlexibleDate(引き継ぎデータ.get報告年月());
        FlexibleDate 集計年月 = new FlexibleDate(引き継ぎデータ.get集計年月());
        RString 保険者コード = 引き継ぎデータ.get保険者コード();
        RString 保険者名 = 引き継ぎデータ.get市町村名称();
        this.parentDiv.getYosikiHosei().getTxtHokokuNengetsu().setValue(new RDate(報告年月.toString()));
        this.parentDiv.getYosikiHosei().getTxtShukeiNengetsu().setValue(new RDate(集計年月.toString()));
        this.parentDiv.getYosikiHosei().getTxtHokensyaCode().setValue(保険者コード);
        this.parentDiv.getYosikiHosei().getTxtHokensyaName().setValue(保険者名);
    }

    /**
     * 画面データ設定する。
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @return Map<RString, List<JigyoHokokuTokeiData>>
     */
    public Map<RString, List<JigyoHokokuTokeiData>> onLoad(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        List<JigyoHokokuTokeiData> 第1号被保険者数情報
                = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0200);
        List<JigyoHokokuTokeiData> 第1号被保険者増減内訳情報_当月中増
                = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0301);
        List<JigyoHokokuTokeiData> 第1号被保険者増減内訳情報_当月中滅
                = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0302);
        loadList(第1号被保険者数情報);
        loadList(第1号被保険者増減内訳情報_当月中増);
        loadList(第1号被保険者増減内訳情報_当月中滅);
        Map<RString, List<JigyoHokokuTokeiData>> resultMap = new HashMap<>();
        resultMap.put(KEY_第1号被保険者数情報, 第1号被保険者数情報);
        resultMap.put(KEY_第1号被保険者増減内訳情報_当月中増, 第1号被保険者増減内訳情報_当月中増);
        resultMap.put(KEY_第1号被保険者増減内訳情報_当月中滅, 第1号被保険者増減内訳情報_当月中滅);
        return resultMap;
    }

    private void loadList(List<JigyoHokokuTokeiData> datalist) {
        for (JigyoHokokuTokeiData entity : datalist) {
            if (集計番号_0200.equals(entity.get集計番号())) {
                load第1号被保険者数Div(entity);
            } else if (集計番号_0301.equals(entity.get集計番号())) {
                load第1号被保険者増減内訳Div_増(entity);
            } else if (集計番号_0302.equals(entity.get集計番号())) {
                load第1号被保険者増減内訳Div_減(entity);
            }
        }
    }

    private void load第1号被保険者数Div(JigyoHokokuTokeiData entity) {
        if (横番号_1.equals(entity.get横番号())) {
            load前月末現在(entity);
        } else if (横番号_4.equals(entity.get横番号())) {
            load当月末現在(entity);
        } else {
            load当月中増減(entity);
        }
    }

    private void load前月末現在(JigyoHokokuTokeiData entity) {
        if (!横番号_1.equals(entity.get横番号())) {
            return;
        }
        tplFirstHihokensyasuDiv 第1号被保険者数Div
                = this.parentDiv.getFirstHihokensyasu().getTplFirstHihokensyasu();
        if (縦番号_1.equals(entity.get縦番号())) {
            第1号被保険者数Div.getTxtZenGetsumatsugenzailrokugoijonanagomiman().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号())) {
            第1号被保険者数Div.getTxtZennGetsumatsugenzaiKoki().setValue(entity.get集計結果値());
        } else if (縦番号_3.equals(entity.get縦番号())) {
            第1号被保険者数Div.getTxtZenGetsumatsugenzaiGai().setValue(entity.get集計結果値());
        } else if (縦番号_4.equals(entity.get縦番号())) {
            第1号被保険者数Div.getTxtZenGetsumatsugenzaiJusho().setValue(entity.get集計結果値());
        } else if (縦番号_5.equals(entity.get縦番号())) {
            第1号被保険者数Div.getTxtZenGetsumatsugenzaiKei().setValue(entity.get集計結果値());
        }
    }

    private void load当月末現在(JigyoHokokuTokeiData entity) {
        if (!横番号_4.equals(entity.get横番号())) {
            return;
        }
        tplFirstHihokensyasuDiv 第1号被保険者数Div
                = this.parentDiv.getFirstHihokensyasu().getTplFirstHihokensyasu();
        if (縦番号_1.equals(entity.get縦番号())) {
            第1号被保険者数Div.getTxtToGetsumatsugenzailrokugoijonanagomiman().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号())) {
            第1号被保険者数Div.getTxtToGetsumatsugenzaiKoki().setValue(entity.get集計結果値());
        } else if (縦番号_3.equals(entity.get縦番号())) {
            第1号被保険者数Div.getTxtToGetsumatsugenzaiGai().setValue(entity.get集計結果値());
        } else if (縦番号_4.equals(entity.get縦番号())) {
            第1号被保険者数Div.getTxtToGetsumatsugenzaiJusho().setValue(entity.get集計結果値());
        } else if (縦番号_5.equals(entity.get縦番号())) {
            第1号被保険者数Div.getTxtToGetsumatsugenzaiKei().setValue(entity.get集計結果値());
        }
    }

    private void load当月中増減(JigyoHokokuTokeiData entity) {
        if (!縦番号_5.equals(entity.get縦番号())) {
            return;
        }
        tplFirstHihokensyasuDiv 第1号被保険者数Div
                = this.parentDiv.getFirstHihokensyasu().getTplFirstHihokensyasu();
        if (横番号_2.equals(entity.get横番号())) {
            第1号被保険者数Div.getTxtSanko1().setValue(entity.get集計結果値());
        } else if (横番号_3.equals(entity.get横番号())) {
            第1号被保険者数Div.getTxtSanko2().setValue(entity.get集計結果値());
        }
    }

    private void load第1号被保険者増減内訳Div_増(JigyoHokokuTokeiData entity) {
        if (縦番号_1.equals(entity.get縦番号())) {
            load当月中増_1(entity);
        } else {
            load当月中増_その他(entity);
        }
    }

    private void load当月中増_1(JigyoHokokuTokeiData entity) {
        tplFirstHihokensyaUtiwakeDiv 第1号被保険者増減内訳Div
                = this.parentDiv.getFirstHihokensyaUtiwake().getTplFirstHihokensyaUtiwake();
        if (縦番号_1.equals(entity.get縦番号()) && 横番号_1.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuZoTennyu().setValue(entity.get集計結果値());
        } else if (縦番号_1.equals(entity.get縦番号()) && 横番号_2.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuzoShokukenFukatsu().setValue(entity.get集計結果値());
        } else if (縦番号_1.equals(entity.get縦番号()) && 横番号_3.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuNenreiToutatsu().setValue(entity.get集計結果値());
        } else if (縦番号_1.equals(entity.get縦番号()) && 横番号_4.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuZoTekiyojogaihi().setValue(entity.get集計結果値());
        } else if (縦番号_1.equals(entity.get縦番号()) && 横番号_5.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuZoSonota().setValue(entity.get集計結果値());
        } else if (縦番号_1.equals(entity.get縦番号()) && 横番号_6.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuZoKei().setValue(entity.get集計結果値());
        }
    }

    private void load当月中増_その他(JigyoHokokuTokeiData entity) {
        tplFirstHihokensyaUtiwakeDiv 第1号被保険者増減内訳Div
                = this.parentDiv.getFirstHihokensyaUtiwake().getTplFirstHihokensyaUtiwake();
        if (縦番号_2.equals(entity.get縦番号()) && 横番号_1.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuJitokuTekiyo().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号()) && 横番号_2.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuzoJitokuReiTennyu().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号()) && 横番号_3.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuzoTatokureiKyoju().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号()) && 横番号_4.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuzoGaikokujinShisei().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号()) && 横番号_5.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuzoKika().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号()) && 横番号_6.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuzoIgai().setValue(entity.get集計結果値());
        }
    }

    private void load第1号被保険者増減内訳Div_減(JigyoHokokuTokeiData entity) {
        if (縦番号_1.equals(entity.get縦番号())) {
            load当月中減_2(entity);
        } else {
            load当月中減_その他(entity);
        }
    }

    private void load当月中減_2(JigyoHokokuTokeiData entity) {
        tplFirstHihokensyaUtiwakeDiv 第1号被保険者増減内訳Div
                = this.parentDiv.getFirstHihokensyaUtiwake().getTplFirstHihokensyaUtiwake();
        if (縦番号_1.equals(entity.get縦番号()) && 横番号_1.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenTenshuchu().setValue(entity.get集計結果値());
        } else if (縦番号_1.equals(entity.get縦番号()) && 横番号_2.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenShokkensoshitsu().setValue(entity.get集計結果値());
        } else if (縦番号_1.equals(entity.get縦番号()) && 横番号_3.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenShibo().setValue(entity.get集計結果値());
        } else if (縦番号_1.equals(entity.get縦番号()) && 横番号_4.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenTekiyojogai().setValue(entity.get集計結果値());
        } else if (縦番号_1.equals(entity.get縦番号()) && 横番号_5.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenSonota().setValue(entity.get集計結果値());
        } else if (縦番号_1.equals(entity.get縦番号()) && 横番号_6.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenKei().setValue(entity.get集計結果値());
        }
    }

    private void load当月中減_その他(JigyoHokokuTokeiData entity) {
        tplFirstHihokensyaUtiwakeDiv 第1号被保険者増減内訳Div
                = this.parentDiv.getFirstHihokensyaUtiwake().getTplFirstHihokensyaUtiwake();
        if (縦番号_2.equals(entity.get縦番号()) && 横番号_1.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenJitokuKaijyo().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号()) && 横番号_2.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenJitokuTennyu().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号()) && 横番号_3.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenTatokureiTekiyo().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号()) && 横番号_4.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenKokusekiSoshitsu().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号()) && 横番号_5.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenKika().setValue(entity.get集計結果値());
        } else if (縦番号_2.equals(entity.get縦番号()) && 横番号_6.equals(entity.get横番号())) {
            第1号被保険者増減内訳Div.getTxtToGetsuGenIgai().setValue(entity.get集計結果値());
        }
    }

    /**
     * 引き継ぎデータより、事業報告月報詳細データリストを取得する。
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoHoseiHakoResult
     * @param 集計番号 Code
     * @return List<JigyoHokokuNenpoResult>
     */
    private List<JigyoHokokuTokeiData> get事業報告月報詳細データリスト(
            JigyoHokokuGeppoParameter 引き継ぎデータ, Code 集計番号) {
        JigyoHokokuGeppoHoseiHako finder = new JigyoHokokuGeppoHoseiHako();
        JigyoHokokuGeppoDetalSearchParameter parameter
                = JigyoHokokuGeppoDetalSearchParameter.createParameterForJigyoHokokuGeppoDetal(
                        new FlexibleYear(引き継ぎデータ.get行報告年()),
                        引き継ぎデータ.get行報告月(),
                        new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                        引き継ぎデータ.get行集計対象月(),
                        引き継ぎデータ.get行統計対象区分(),
                        new LasdecCode(引き継ぎデータ.get行市町村コード()),
                        new Code(引き継ぎデータ.get行表番号()),
                        集計番号);
        return finder.getJigyoHokokuGeppoDetal(parameter);
    }

    /**
     * 画面から修正データリストをDBに更新する。
     *
     * @param 修正データリスト List<JigyoHokokuNenpoUpdateParameter>
     * @return boolean DB操作結果
     */
    public boolean update(List<JigyoHokokuTokeiData> 修正データリスト) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
        return 修正データリスト.size() == finder.updateJigyoHokokuGeppoData(修正データリスト);
    }

    /**
     * 引き継ぎデータより、データ削除する。
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     */
    public void delete(List<JigyoHokokuTokeiData> 引き継ぎデータ) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
        finder.deleteJigyoHokokuGeppoData(引き継ぎデータ);
    }

    /**
     * 修正データリストより、修正データがないかどうかを判断する。
     *
     * @param 修正データリスト List<JigyoHokokuNenpoUpdateParameter>
     * @return boolean 判断結果
     */
    public boolean is修正データ無し(List<JigyoHokokuTokeiData> 修正データリスト) {
        return (null == 修正データリスト || 修正データリスト.isEmpty());
    }

    /**
     * 画面項目「計」で入力された値の整合性をチェックする。
     *
     * @return boolean チェック結果
     */
    public boolean is整合性チェック_NG() {
        tplFirstHihokensyasuDiv 第1号被保険者数Div
                = this.parentDiv.getFirstHihokensyasu().getTplFirstHihokensyasu();
        Decimal 前月末現在 = 第1号被保険者数Div.getTxtZenGetsumatsugenzaiKei().getValue();
        Decimal 月中増 = 第1号被保険者数Div.getTxtSanko1().getValue();
        Decimal 月中減 = 第1号被保険者数Div.getTxtSanko2().getValue();
        Decimal 当月末現在 = 第1号被保険者数Div.getTxtToGetsumatsugenzaiKei().getValue();
        前月末現在 = null == 前月末現在 ? Decimal.ZERO : 前月末現在;
        月中増 = null == 月中増 ? Decimal.ZERO : 月中増;
        月中減 = null == 月中減 ? Decimal.ZERO : 月中減;
        当月末現在 = null == 当月末現在 ? Decimal.ZERO : 当月末現在;
        return !当月末現在.equals(前月末現在.add(月中増).subtract(月中減));
    }

    /**
     * 引き継ぎデータより、画面修正データを抽出する。
     *
     * @param 第1号被保険者数情報 List<JigyoHokokuTokeiData>
     * @param 第1号被保険者増減内訳情報_当月中増 List<JigyoHokokuTokeiData>
     * @param 第1号被保険者増減内訳情報_当月中滅 List<JigyoHokokuTokeiData>
     * @return List<JigyoHokokuNenpoUpdateParameter> 修正データリスト
     */
    public List<JigyoHokokuTokeiData> get修正データリスト(
            List<JigyoHokokuTokeiData> 第1号被保険者数情報, List<JigyoHokokuTokeiData> 第1号被保険者増減内訳情報_当月中増,
            List<JigyoHokokuTokeiData> 第1号被保険者増減内訳情報_当月中滅) {
        List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト = new ArrayList<>();
        事業報告月報詳細データリスト.addAll(第1号被保険者数情報);
        事業報告月報詳細データリスト.addAll(第1号被保険者増減内訳情報_当月中増);
        事業報告月報詳細データリスト.addAll(第1号被保険者増減内訳情報_当月中滅);
        List<JigyoHokokuTokeiData> 修正データリスト = new ArrayList<>();
        if (事業報告月報詳細データリスト.isEmpty()) {
            return 修正データリスト;
        }
        for (JigyoHokokuTokeiData entity : 事業報告月報詳細データリスト) {
            JigyoHokokuTokeiData 修正データ = create修正データ(entity);
            if (null != 修正データ) {
                修正データリスト.add(修正データ);
            }
        }
        return 修正データリスト;
    }

    private JigyoHokokuTokeiData create修正データ(JigyoHokokuTokeiData 事業報告月報詳細データ) {
        if (null == 事業報告月報詳細データ) {
            return null;
        }
        Decimal 集計結果値 = null;
        if (集計番号_0200.equals(事業報告月報詳細データ.get集計番号())) {
            集計結果値 = 第1号被保険者数Divの集計結果値取得(事業報告月報詳細データ);
        } else if (集計番号_0301.equals(事業報告月報詳細データ.get集計番号())) {
            集計結果値 = 第1号被保険者増減内訳Div_増の集計結果値取得(事業報告月報詳細データ);
        } else if (集計番号_0302.equals(事業報告月報詳細データ.get集計番号())) {
            集計結果値 = 第1号被保険者増減内訳Div_減の集計結果値取得(事業報告月報詳細データ);
        }
        if (null != 集計結果値 && !集計結果値.equals(事業報告月報詳細データ.get集計結果値())) {
            return 事業報告月報詳細データ.createBuilderForEdit().set集計結果値(集計結果値).build();
        }
        return null;
    }

    private Decimal 第1号被保険者数Divの集計結果値取得(JigyoHokokuTokeiData 事業報告月報詳細データ) {
        Decimal 集計結果値;
        if (横番号_1.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 前月末現在の集計結果値取得(事業報告月報詳細データ);
        } else if (横番号_4.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 当月末現在の集計結果値取得(事業報告月報詳細データ);
        } else {
            集計結果値 = 当月中増減の集計結果値取得(事業報告月報詳細データ);
        }
        return 集計結果値;
    }

    private Decimal 前月末現在の集計結果値取得(JigyoHokokuTokeiData 事業報告月報詳細データ) {
        Decimal 集計結果値 = null;
        tplFirstHihokensyasuDiv 第1号被保険者数Div
                = this.parentDiv.getFirstHihokensyasu().getTplFirstHihokensyasu();
        if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_1.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtZenGetsumatsugenzailrokugoijonanagomiman().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_1.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtZennGetsumatsugenzaiKoki().getValue();
        } else if (縦番号_3.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_1.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtZenGetsumatsugenzaiGai().getValue();
        } else if (縦番号_4.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_1.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtZenGetsumatsugenzaiJusho().getValue();
        } else if (縦番号_5.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_1.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtZenGetsumatsugenzaiKei().getValue();
        }
        return 集計結果値;
    }

    private Decimal 当月末現在の集計結果値取得(JigyoHokokuTokeiData 事業報告月報詳細データ) {
        Decimal 集計結果値 = null;
        tplFirstHihokensyasuDiv 第1号被保険者数Div
                = this.parentDiv.getFirstHihokensyasu().getTplFirstHihokensyasu();
        if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_4.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtToGetsumatsugenzailrokugoijonanagomiman().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_4.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtToGetsumatsugenzaiKoki().getValue();
        } else if (縦番号_3.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_4.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtToGetsumatsugenzaiGai().getValue();
        } else if (縦番号_4.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_4.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtToGetsumatsugenzaiJusho().getValue();
        } else if (縦番号_5.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_4.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtToGetsumatsugenzaiKei().getValue();
        }
        return 集計結果値;
    }

    private Decimal 当月中増減の集計結果値取得(JigyoHokokuTokeiData 事業報告月報詳細データ) {
        Decimal 集計結果値 = null;
        tplFirstHihokensyasuDiv 第1号被保険者数Div
                = this.parentDiv.getFirstHihokensyasu().getTplFirstHihokensyasu();
        if (縦番号_5.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_2.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtSanko1().getValue();
        } else if (縦番号_5.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_3.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者数Div.getTxtSanko2().getValue();
        }
        return 集計結果値;
    }

    private Decimal 第1号被保険者増減内訳Div_増の集計結果値取得(JigyoHokokuTokeiData 事業報告月報詳細データ) {
        Decimal 集計結果値;
        if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())) {
            集計結果値 = 当月中増_1の集計結果値取得(事業報告月報詳細データ);
        } else {
            集計結果値 = 当月中増_その他の集計結果値取得(事業報告月報詳細データ);
        }
        return 集計結果値;
    }

    private Decimal 当月中増_1の集計結果値取得(JigyoHokokuTokeiData 事業報告月報詳細データ) {
        Decimal 集計結果値 = null;
        tplFirstHihokensyaUtiwakeDiv 第1号被保険者増減内訳Div
                = this.parentDiv.getFirstHihokensyaUtiwake().getTplFirstHihokensyaUtiwake();
        if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_1.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuZoTennyu().getValue();
        } else if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_2.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuzoShokukenFukatsu().getValue();
        } else if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_3.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuNenreiToutatsu().getValue();
        } else if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_4.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuZoTekiyojogaihi().getValue();
        } else if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_5.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuZoSonota().getValue();
        } else if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_6.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuZoKei().getValue();
        }
        return 集計結果値;
    }

    private Decimal 当月中増_その他の集計結果値取得(JigyoHokokuTokeiData 事業報告月報詳細データ) {
        Decimal 集計結果値 = null;
        tplFirstHihokensyaUtiwakeDiv 第1号被保険者増減内訳Div
                = this.parentDiv.getFirstHihokensyaUtiwake().getTplFirstHihokensyaUtiwake();
        if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_1.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuJitokuTekiyo().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_2.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuzoJitokuReiTennyu().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_3.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuzoTatokureiKyoju().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_4.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuzoGaikokujinShisei().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_5.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuzoKika().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_6.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuzoIgai().getValue();
        }
        return 集計結果値;
    }

    private Decimal 第1号被保険者増減内訳Div_減の集計結果値取得(JigyoHokokuTokeiData 事業報告月報詳細データ) {
        Decimal 集計結果値;
        if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())) {
            集計結果値 = 当月中減_2の集計結果値取得(事業報告月報詳細データ);
        } else {
            集計結果値 = 当月中減_その他の集計結果値取得(事業報告月報詳細データ);
        }
        return 集計結果値;
    }

    private Decimal 当月中減_2の集計結果値取得(JigyoHokokuTokeiData 事業報告月報詳細データ) {
        Decimal 集計結果値 = null;
        tplFirstHihokensyaUtiwakeDiv 第1号被保険者増減内訳Div
                = this.parentDiv.getFirstHihokensyaUtiwake().getTplFirstHihokensyaUtiwake();
        if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_1.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenTenshuchu().getValue();
        } else if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_2.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenShokkensoshitsu().getValue();
        } else if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_3.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenShibo().getValue();
        } else if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_4.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenTekiyojogai().getValue();
        } else if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_5.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenSonota().getValue();
        } else if (縦番号_1.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_6.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenKei().getValue();
        }
        return 集計結果値;
    }

    private Decimal 当月中減_その他の集計結果値取得(JigyoHokokuTokeiData 事業報告月報詳細データ) {
        Decimal 集計結果値 = null;
        tplFirstHihokensyaUtiwakeDiv 第1号被保険者増減内訳Div
                = this.parentDiv.getFirstHihokensyaUtiwake().getTplFirstHihokensyaUtiwake();
        if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_1.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenJitokuKaijyo().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_2.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenJitokuTennyu().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_3.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenTatokureiTekiyo().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_4.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenKokusekiSoshitsu().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_5.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenKika().getValue();
        } else if (縦番号_2.equals(事業報告月報詳細データ.get縦番号())
                && 横番号_6.equals(事業報告月報詳細データ.get横番号())) {
            集計結果値 = 第1号被保険者増減内訳Div.getTxtToGetsuGenIgai().getValue();
        }
        return 集計結果値;
    }
}
