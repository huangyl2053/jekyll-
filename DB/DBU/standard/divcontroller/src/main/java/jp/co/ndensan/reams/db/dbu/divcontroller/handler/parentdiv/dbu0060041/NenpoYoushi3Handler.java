/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0060041;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiDataBuilder;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiDataIdentifier;
import jp.co.ndensan.reams.db.dbu.definition.core.nenpoyoushi3.NenpoYoushi3DetalParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.nenpoyoushi3.NenpoYoushi3ViewStateKeys;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060041.NenpoYoushi3Div;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 事業報告（年報）補正、発行_様式３画面のハンドラクラスです。
 */
public class NenpoYoushi3Handler {

    private static final Decimal 横番号_1 = new Decimal("1");
    private static final Decimal 横番号_2 = new Decimal("2");
    private static final Decimal 横番号_3 = new Decimal("3");
    private static final Decimal 横番号_4 = new Decimal("4");
    private static final Decimal 横番号_5 = new Decimal("5");
    private static final Decimal 横番号_6 = new Decimal("6");
    private static final Decimal 縦番号_1 = new Decimal("1");
    private static final Decimal 縦番号_2 = new Decimal("2");
    private static final Decimal 縦番号_3 = new Decimal("3");
    private static final Decimal 縦番号_4 = new Decimal("4");
    private static final Decimal 縦番号_5 = new Decimal("5");
    private static final Decimal 縦番号_6 = new Decimal("6");
    private static final Decimal 縦番号_7 = new Decimal("7");
    private static final RString フラグ_削除 = new RString("削除");
    private static final RString 保険料収納状況 = new RString("3.保険料収納状況");
    private static final RString 保険給付支払状況 = new RString("4.保険給付支払状況");
    private final NenpoYoushi3Div div;

    /**
     * コンストラクタです。
     *
     * @param div NenpoYoushi3Div
     */
    public NenpoYoushi3Handler(NenpoYoushi3Div div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param 事業報告集計一覧データリスト 事業報告集計一覧データリスト
     * @param 補正フラグ 補正フラグ
     * @param 報告年度 報告年度
     * @param 集計年度 集計年度
     * @param 保険者コード 保険者コード
     * @param 保険者名称 保険者名称
     */
    public void initialize(List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト, RString 補正フラグ,
            FlexibleDate 報告年度, FlexibleDate 集計年度, RString 保険者コード, RString 保険者名称) {
        div.getHihokenshabango().getTxthokokuYM().setValue(報告年度);
        div.getHihokenshabango().getTxthokokuYM().setDisabled(true);
        div.getHihokenshabango().getTxtShukeiY().setValue(集計年度);
        div.getHihokenshabango().getTxtShukeiY().setDisabled(true);
        div.getHihokenshabango().getTxtHihokenshabango().setValue(保険者コード);
        div.getHihokenshabango().getTxtHihokenshabango().setDisabled(true);
        div.getHihokenshabango().getTxthihokenshamei().setValue(保険者名称);
        div.getHihokenshabango().getTxthihokenshamei().setDisabled(true);
        for (JigyoHokokuTokeiData data : 事業報告集計一覧データリスト) {
            set収納状況詳細データ(data);
        }
        set活性();
        if (補正フラグ.equals(フラグ_削除)) {
            set非活性();
        }
    }

    /**
     * 保険給付支払状況詳細データを設定します。
     *
     * @param 事業報告集計一覧データリスト 事業報告集計一覧データリスト
     */
    public void set保険給付支払状況詳細データ(List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト) {
        for (JigyoHokokuTokeiData data : 事業報告集計一覧データリスト) {
            set支払状況詳細データ(data);
        }
    }

    /**
     * 画面の修正データを取得します。
     *
     * @return List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト
     */
    public List<JigyoHokokuTokeiData> get修正データ() {
        List<JigyoHokokuTokeiData> list = new ArrayList<>();
        RString title = div.getShokuhikyojunofutannintei().getTabShokuhikyojunofutannintei().getSelectedItem().getTitle();
        if (title.equals(保険料収納状況)) {
            list = get保険料収納状況修正データ();
        }
        if (title.equals(保険給付支払状況)) {
            list = get保険給付支払状況修正データ();
        }
        return list;
    }

    private List<JigyoHokokuTokeiData> get保険料収納状況修正データ() {
        List<JigyoHokokuTokeiData> list = new ArrayList<>();
        Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 保険料収納状況データ = ViewStateHolder.
                get(NenpoYoushi3ViewStateKeys.保険料収納状況データ, Models.class);
        List<NenpoYoushi3DetalParameter> 保険料収納状況画面データ = get保険料収納状況画面データ();
        for (NenpoYoushi3DetalParameter parameter : 保険料収納状況画面データ) {
            for (JigyoHokokuTokeiData data : 保険料収納状況データ) {
                JigyoHokokuTokeiDataBuilder builder = data.createBuilderForEdit();
                if (parameter.get縦番号().compareTo(data.get縦番号()) == 0
                        && parameter.get横番号().compareTo(data.get横番号()) == 0
                        && parameter.get集計結果値().compareTo(data.get集計結果値()) != 0) {
                    builder.set集計結果値(parameter.get集計結果値());
                    data = builder.build();
                    list.add(data);
                }
            }
        }
        return list;
    }

    private List<JigyoHokokuTokeiData> get保険給付支払状況修正データ() {
        List<JigyoHokokuTokeiData> list = new ArrayList<>();
        Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 保険給付支払状況データ = ViewStateHolder.
                get(NenpoYoushi3ViewStateKeys.保険給付支払状況データ, Models.class);
        List<NenpoYoushi3DetalParameter> 保険給付支払状況画面データ = get保険給付支払状況画面データ();
        for (NenpoYoushi3DetalParameter parameter : 保険給付支払状況画面データ) {
            for (JigyoHokokuTokeiData data : 保険給付支払状況データ) {
                JigyoHokokuTokeiDataBuilder builder = data.createBuilderForEdit();
                if (parameter.get縦番号().compareTo(data.get縦番号()) == 0
                        && parameter.get横番号().compareTo(data.get横番号()) == 0
                        && parameter.get集計結果値().compareTo(data.get集計結果値()) != 0) {
                    builder.set集計結果値(parameter.get集計結果値());
                    data = builder.build();
                    list.add(data);
                }
            }
        }
        return list;
    }

    private void set非活性() {
        div.getShokuhikyojunofutannintei().getTxtchotei1().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShuno1().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtKampu1().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku1().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtchotei2().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShuno2().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtKampu2().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtfuno2().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtmino2().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku2().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtchotei3().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShuno3().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtKampu3().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtfuno3().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtmino3().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku3().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtchotei4().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShuno4().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtKampu4().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtfuno4().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtmino4().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku4().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtchotei5().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShuno5().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtKampu5().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku5().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtchotei6().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShuno6().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtxtKampu6().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtfuno5().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtmino6().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku6().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtchotei7().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShuno7().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtKampu7().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtfuno6().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtmino7().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku7().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi1().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu1().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtChoshu1().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtReinyu1().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku1().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi2().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu2().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtChoshu2().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtReinyu2().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku2().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi3().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu3().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtChoshu3().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtReinyu3().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku3().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi4().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu4().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtChoshu4().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtReinyu4().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku4().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi5().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu5().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtChoshu5().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtReinyu5().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku5().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi6().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu6().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtChoshu6().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtReinyu6().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku6().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi7().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu7().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtChoshu7().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtReinyu7().setDisabled(true);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku7().setDisabled(true);
    }

    private void set活性() {
        div.getShokuhikyojunofutannintei().getTxtchotei1().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShuno1().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtKampu1().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku1().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtchotei2().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShuno2().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtKampu2().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtfuno2().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtmino2().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku2().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtchotei3().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShuno3().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtKampu3().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtfuno3().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtmino3().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku3().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtchotei4().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShuno4().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtKampu4().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtfuno4().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtmino4().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku4().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtchotei5().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShuno5().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtKampu5().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku5().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtchotei6().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShuno6().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtxtKampu6().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtfuno5().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtmino6().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku6().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtchotei7().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShuno7().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtKampu7().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtfuno6().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtmino7().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtgemmengaku7().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi1().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu1().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtChoshu1().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtReinyu1().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku1().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi2().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu2().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtChoshu2().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtReinyu2().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku2().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi3().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu3().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtChoshu3().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtReinyu3().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku3().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi4().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu4().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtChoshu4().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtReinyu4().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku4().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi5().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu5().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtChoshu5().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtReinyu5().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku5().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi6().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu6().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtChoshu6().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtReinyu6().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku6().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaigi7().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtShiharaizu7().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtChoshu7().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtReinyu7().setDisabled(false);
        div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku7().setDisabled(false);
    }

    private void set収納状況詳細データ(JigyoHokokuTokeiData data) {
        if (縦番号_1.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtchotei1().setValue(data.get集計結果値());
        }
        if (縦番号_1.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShuno1().setValue(data.get集計結果値());
        }
        if (縦番号_1.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtKampu1().setValue(data.get集計結果値());
        }
        if (縦番号_1.equals(data.get縦番号()) && 横番号_6.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtgemmengaku1().setValue(data.get集計結果値());
        }
        if (縦番号_2.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtchotei2().setValue(data.get集計結果値());
        }
        if (縦番号_2.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShuno2().setValue(data.get集計結果値());
        }
        if (縦番号_2.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtKampu2().setValue(data.get集計結果値());
        }
        if (縦番号_2.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtfuno2().setValue(data.get集計結果値());
        }
        if (縦番号_2.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtmino2().setValue(data.get集計結果値());
        }
        if (縦番号_2.equals(data.get縦番号()) && 横番号_6.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtgemmengaku2().setValue(data.get集計結果値());
        }
        if (縦番号_3.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtchotei3().setValue(data.get集計結果値());
        }
        if (縦番号_3.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShuno3().setValue(data.get集計結果値());
        }
        if (縦番号_3.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtKampu3().setValue(data.get集計結果値());
        }
        if (縦番号_3.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtfuno3().setValue(data.get集計結果値());
        }
        if (縦番号_3.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtmino3().setValue(data.get集計結果値());
        }
        if (縦番号_3.equals(data.get縦番号()) && 横番号_6.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtgemmengaku3().setValue(data.get集計結果値());
        }
        if (縦番号_4.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtchotei4().setValue(data.get集計結果値());
        }
        if (縦番号_4.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShuno4().setValue(data.get集計結果値());
        }
        if (縦番号_4.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtKampu4().setValue(data.get集計結果値());
        }
        if (縦番号_4.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtfuno4().setValue(data.get集計結果値());
        }
        if (縦番号_4.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtmino4().setValue(data.get集計結果値());
        }
        if (縦番号_4.equals(data.get縦番号()) && 横番号_6.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtgemmengaku4().setValue(data.get集計結果値());
        }
        if (縦番号_5.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtchotei5().setValue(data.get集計結果値());
        }
        if (縦番号_5.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShuno5().setValue(data.get集計結果値());
        }
        if (縦番号_5.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtKampu5().setValue(data.get集計結果値());
        }
        if (縦番号_5.equals(data.get縦番号()) && 横番号_6.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtgemmengaku5().setValue(data.get集計結果値());
        }
        if (縦番号_6.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtchotei6().setValue(data.get集計結果値());
        }
        if (縦番号_6.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShuno6().setValue(data.get集計結果値());
        }
        if (縦番号_6.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtxtKampu6().setValue(data.get集計結果値());
        }
        if (縦番号_6.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtfuno5().setValue(data.get集計結果値());
        }
        if (縦番号_6.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtmino6().setValue(data.get集計結果値());
        }
        if (縦番号_6.equals(data.get縦番号()) && 横番号_6.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtgemmengaku6().setValue(data.get集計結果値());
        }
        if (縦番号_7.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtchotei7().setValue(data.get集計結果値());
        }
        if (縦番号_7.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShuno7().setValue(data.get集計結果値());
        }
        if (縦番号_7.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtKampu7().setValue(data.get集計結果値());
        }
        if (縦番号_7.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtfuno6().setValue(data.get集計結果値());
        }
        if (縦番号_7.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtmino7().setValue(data.get集計結果値());
        }
        if (縦番号_7.equals(data.get縦番号()) && 横番号_6.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtgemmengaku7().setValue(data.get集計結果値());
        }
    }

    private void set支払状況詳細データ(JigyoHokokuTokeiData data) {
        if (縦番号_1.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaigi1().setValue(data.get集計結果値());
        }
        if (縦番号_1.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaizu1().setValue(data.get集計結果値());
        }
        if (縦番号_1.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtChoshu1().setValue(data.get集計結果値());
        }
        if (縦番号_1.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtReinyu1().setValue(data.get集計結果値());
        }
        if (縦番号_1.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku1().setValue(data.get集計結果値());
        }
        if (縦番号_2.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaigi2().setValue(data.get集計結果値());
        }
        if (縦番号_2.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaizu2().setValue(data.get集計結果値());
        }
        if (縦番号_2.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtChoshu2().setValue(data.get集計結果値());
        }
        if (縦番号_2.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtReinyu2().setValue(data.get集計結果値());
        }
        if (縦番号_2.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku2().setValue(data.get集計結果値());
        }
        if (縦番号_3.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaigi3().setValue(data.get集計結果値());
        }
        if (縦番号_3.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaizu3().setValue(data.get集計結果値());
        }
        if (縦番号_3.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtChoshu3().setValue(data.get集計結果値());
        }
        if (縦番号_3.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtReinyu3().setValue(data.get集計結果値());
        }
        if (縦番号_3.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku3().setValue(data.get集計結果値());
        }
        if (縦番号_4.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaigi4().setValue(data.get集計結果値());
        }
        if (縦番号_4.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaizu4().setValue(data.get集計結果値());
        }
        if (縦番号_4.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtChoshu4().setValue(data.get集計結果値());
        }
        if (縦番号_4.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtReinyu4().setValue(data.get集計結果値());
        }
        if (縦番号_4.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku4().setValue(data.get集計結果値());
        }
        if (縦番号_5.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaigi5().setValue(data.get集計結果値());
        }
        if (縦番号_5.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaizu5().setValue(data.get集計結果値());
        }
        if (縦番号_5.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtChoshu5().setValue(data.get集計結果値());
        }
        if (縦番号_5.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtReinyu5().setValue(data.get集計結果値());
        }
        if (縦番号_5.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku5().setValue(data.get集計結果値());
        }
        if (縦番号_6.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaigi6().setValue(data.get集計結果値());
        }
        if (縦番号_6.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaizu6().setValue(data.get集計結果値());
        }
        if (縦番号_6.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtChoshu6().setValue(data.get集計結果値());
        }
        if (縦番号_6.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtReinyu6().setValue(data.get集計結果値());
        }
        if (縦番号_6.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku6().setValue(data.get集計結果値());
        }
        if (縦番号_7.equals(data.get縦番号()) && 横番号_1.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaigi7().setValue(data.get集計結果値());
        }
        if (縦番号_7.equals(data.get縦番号()) && 横番号_2.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtShiharaizu7().setValue(data.get集計結果値());
        }
        if (縦番号_7.equals(data.get縦番号()) && 横番号_3.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtChoshu7().setValue(data.get集計結果値());
        }
        if (縦番号_7.equals(data.get縦番号()) && 横番号_4.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtReinyu7().setValue(data.get集計結果値());
        }
        if (縦番号_7.equals(data.get縦番号()) && 横番号_5.equals(data.get横番号())) {
            div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku7().setValue(data.get集計結果値());
        }
    }

    private List<NenpoYoushi3DetalParameter> get保険料収納状況画面データ() {
        List<NenpoYoushi3DetalParameter> list = new ArrayList<>();
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_1, 横番号_1, div.getShokuhikyojunofutannintei().getTxtchotei1().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_1, 横番号_2, div.getShokuhikyojunofutannintei().getTxtShuno1().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_1, 横番号_3, div.getShokuhikyojunofutannintei().getTxtKampu1().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_1, 横番号_6,
                div.getShokuhikyojunofutannintei().getTxtgemmengaku1().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_2, 横番号_1, div.getShokuhikyojunofutannintei().getTxtchotei2().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_2, 横番号_2, div.getShokuhikyojunofutannintei().getTxtShuno2().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_2, 横番号_3, div.getShokuhikyojunofutannintei().getTxtKampu2().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_2, 横番号_4, div.getShokuhikyojunofutannintei().getTxtfuno2().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_2, 横番号_5, div.getShokuhikyojunofutannintei().getTxtmino2().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_2, 横番号_6,
                div.getShokuhikyojunofutannintei().getTxtgemmengaku2().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_3, 横番号_1, div.getShokuhikyojunofutannintei().getTxtchotei3().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_3, 横番号_2, div.getShokuhikyojunofutannintei().getTxtShuno3().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_3, 横番号_3, div.getShokuhikyojunofutannintei().getTxtKampu3().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_3, 横番号_4, div.getShokuhikyojunofutannintei().getTxtfuno3().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_3, 横番号_5, div.getShokuhikyojunofutannintei().getTxtmino3().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_3, 横番号_6,
                div.getShokuhikyojunofutannintei().getTxtgemmengaku3().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_4, 横番号_1, div.getShokuhikyojunofutannintei().getTxtchotei4().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_4, 横番号_2, div.getShokuhikyojunofutannintei().getTxtShuno4().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_4, 横番号_3, div.getShokuhikyojunofutannintei().getTxtKampu4().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_4, 横番号_4, div.getShokuhikyojunofutannintei().getTxtfuno4().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_4, 横番号_5, div.getShokuhikyojunofutannintei().getTxtmino4().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_4, 横番号_6,
                div.getShokuhikyojunofutannintei().getTxtgemmengaku4().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_5, 横番号_1, div.getShokuhikyojunofutannintei().getTxtchotei5().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_5, 横番号_2, div.getShokuhikyojunofutannintei().getTxtShuno5().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_5, 横番号_3, div.getShokuhikyojunofutannintei().getTxtKampu5().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_5, 横番号_6,
                div.getShokuhikyojunofutannintei().getTxtgemmengaku5().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_6, 横番号_1, div.getShokuhikyojunofutannintei().getTxtchotei6().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_6, 横番号_2, div.getShokuhikyojunofutannintei().getTxtShuno6().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_6, 横番号_3, div.getShokuhikyojunofutannintei().getTxtxtKampu6().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_6, 横番号_4, div.getShokuhikyojunofutannintei().getTxtfuno5().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_6, 横番号_5, div.getShokuhikyojunofutannintei().getTxtmino6().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_6, 横番号_6,
                div.getShokuhikyojunofutannintei().getTxtgemmengaku6().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_7, 横番号_1, div.getShokuhikyojunofutannintei().getTxtchotei7().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_7, 横番号_2, div.getShokuhikyojunofutannintei().getTxtShuno7().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_7, 横番号_3, div.getShokuhikyojunofutannintei().getTxtKampu7().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_7, 横番号_4, div.getShokuhikyojunofutannintei().getTxtfuno6().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_7, 横番号_5, div.getShokuhikyojunofutannintei().getTxtmino7().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_7, 横番号_6,
                div.getShokuhikyojunofutannintei().getTxtgemmengaku7().getValue()));
        return list;
    }

    private List<NenpoYoushi3DetalParameter> get保険給付支払状況画面データ() {
        List<NenpoYoushi3DetalParameter> list = new ArrayList<>();
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_1, 横番号_1,
                div.getShokuhikyojunofutannintei().getTxtShiharaigi1().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_1, 横番号_2,
                div.getShokuhikyojunofutannintei().getTxtShiharaizu1().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_1, 横番号_3, div.getShokuhikyojunofutannintei().getTxtChoshu1().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_1, 横番号_4, div.getShokuhikyojunofutannintei().getTxtReinyu1().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_1, 横番号_5,
                div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku1().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_2, 横番号_1,
                div.getShokuhikyojunofutannintei().getTxtShiharaigi2().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_2, 横番号_2,
                div.getShokuhikyojunofutannintei().getTxtShiharaizu2().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_2, 横番号_3, div.getShokuhikyojunofutannintei().getTxtChoshu2().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_2, 横番号_4, div.getShokuhikyojunofutannintei().getTxtReinyu2().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_2, 横番号_5,
                div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku2().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_3, 横番号_1,
                div.getShokuhikyojunofutannintei().getTxtShiharaigi3().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_3, 横番号_2,
                div.getShokuhikyojunofutannintei().getTxtShiharaizu3().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_3, 横番号_3, div.getShokuhikyojunofutannintei().getTxtChoshu3().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_3, 横番号_4, div.getShokuhikyojunofutannintei().getTxtReinyu3().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_3, 横番号_5,
                div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku3().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_4, 横番号_1,
                div.getShokuhikyojunofutannintei().getTxtShiharaigi4().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_4, 横番号_2,
                div.getShokuhikyojunofutannintei().getTxtShiharaizu4().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_4, 横番号_3, div.getShokuhikyojunofutannintei().getTxtChoshu4().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_4, 横番号_4, div.getShokuhikyojunofutannintei().getTxtReinyu4().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_4, 横番号_5,
                div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku4().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_5, 横番号_1,
                div.getShokuhikyojunofutannintei().getTxtShiharaigi5().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_5, 横番号_2,
                div.getShokuhikyojunofutannintei().getTxtShiharaizu5().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_5, 横番号_3, div.getShokuhikyojunofutannintei().getTxtChoshu5().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_5, 横番号_4, div.getShokuhikyojunofutannintei().getTxtReinyu5().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_5, 横番号_5,
                div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku5().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_6, 横番号_1,
                div.getShokuhikyojunofutannintei().getTxtShiharaigi6().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_6, 横番号_2,
                div.getShokuhikyojunofutannintei().getTxtShiharaizu6().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_6, 横番号_3, div.getShokuhikyojunofutannintei().getTxtChoshu6().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_6, 横番号_4, div.getShokuhikyojunofutannintei().getTxtReinyu6().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_6, 横番号_5,
                div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku6().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_7, 横番号_1,
                div.getShokuhikyojunofutannintei().getTxtShiharaigi7().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_7, 横番号_2,
                div.getShokuhikyojunofutannintei().getTxtShiharaizu7().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_7, 横番号_3, div.getShokuhikyojunofutannintei().getTxtChoshu7().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_7, 横番号_4, div.getShokuhikyojunofutannintei().getTxtReinyu7().getValue()));
        list.add(NenpoYoushi3DetalParameter.creatDetalParameter(縦番号_7, 横番号_5,
                div.getShokuhikyojunofutannintei().getTxtlmishiharaigaku7().getValue()));
        return list;
    }
}
