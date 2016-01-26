/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0060021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.core.zigyouhoukokunenpou.ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiDataIdentifier;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.TempJigyoHokokuNenpoDetalParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060021.NenpoYoushiki1HoseiDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 老人保健受給者台帳管理ハンドラクラスです。
 */
public class NenpoYoushiki1HoseiHandler {

    private static final RString 処理種別_削除 = new RString("削除");

    private static final Decimal NUM_2 = new Decimal("2");
    private static final Decimal NUM_3 = new Decimal("3");
    private static final Decimal NUM_4 = new Decimal("4");
    private static final Decimal NUM_5 = new Decimal("5");
    private static final Decimal NUM_6 = new Decimal("6");
    private static final Decimal NUM_7 = new Decimal("7");
    private static final Decimal NUM_8 = new Decimal("8");
    private static final Decimal NUM_9 = new Decimal("9");
    private static final Decimal NUM_11 = new Decimal("11");
    private static final Decimal NUM_12 = new Decimal("12");
    private static final Decimal NUM_13 = new Decimal("13");
    private static final Decimal NUM_14 = new Decimal("14");
    private static final Decimal NUM_15 = new Decimal("15");
    private static final Decimal NUM_16 = new Decimal("16");
    private static final Decimal NUM_17 = new Decimal("17");
    private static final Decimal NUM_18 = new Decimal("18");
    private static final Decimal NUM_19 = new Decimal("19");
    private static final Decimal NUM_20 = new Decimal("20");
    private static final Decimal NUM_21 = new Decimal("21");
    private static final Decimal NUM_22 = new Decimal("22");
    private static final Decimal NUM_23 = new Decimal("23");

    private final NenpoYoushiki1HoseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 老人保健受給者台帳管理Div
     */
    public NenpoYoushiki1HoseiHandler(NenpoYoushiki1HoseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param 事業報告集計一覧データリスト 事業報告統計データを管理リスト
     * @param param 遷移画面と事業状況報告（年報）補正検索画面は渡す項目Entityクラスです。
     */
    public void initialize(List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト, ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity param) {
        div.getHihokenshabango().getTxthokokuYM().setValue(new FlexibleDate("201501"));
        div.getHihokenshabango().getTxtShukeiY().setValue(new FlexibleDate("201501"));
        div.getHihokenshabango().getTxtHihokenshabango().setValue(param.get保険者コード());
        div.getHihokenshabango().getTxthihokenshamei().setValue(param.get市町村名称());
        for (JigyoHokokuTokeiData data : 事業報告集計一覧データリスト) {
            set詳細データエリア(data);
        }
        set活性();
        if (処理種別_削除.equals(param.get補正フラグ())) {
            set非活性();
        }
    }

    /**
     * 画面修正データの取得します。
     *
     * @return List<JigyoHokokuTokeiData> 事業報告統計データを管理リスト
     */
    public List<JigyoHokokuTokeiData> 修正データの取得() {
        List<JigyoHokokuTokeiData> modifyData = new ArrayList();
        List<TempJigyoHokokuNenpoDetalParameter> tempModifyData = getTempModifyData();
        Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> jigyoHokokuTokeiData
                = ViewStateHolder.get(ViewStateKeys.開催場所情報一覧, Models.class);
        for (TempJigyoHokokuNenpoDetalParameter paramData : tempModifyData) {
            for (JigyoHokokuTokeiData viewData : jigyoHokokuTokeiData) {
                if (paramData.get縦番号().compareTo(viewData.get縦番号()) == 0
                        && paramData.get横番号().compareTo(viewData.get横番号()) == 0
                        && paramData.get集計結果値().compareTo(viewData.get集計結果値()) != 0) {
                    viewData.createBuilderForEdit().set集計結果値(paramData.get集計結果値());
                    modifyData.add(viewData);
                }
            }
        }
        return modifyData;
    }

    private void set非活性() {
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuVal().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonVal().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuni().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonValni().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasusan().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonsan().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokensu().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonsandankai().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuyon().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonyonkaidan().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuyondankai().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonyondankai().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka1().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka1().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka2().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka2().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka3().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka3().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka4().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka4().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka5().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka5().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka6().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka6().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka7().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka7().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka8().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka8().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka9().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka9().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka10().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka10().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka11().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka11().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka12().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka12().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka13().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka13().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka14().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka14().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka15().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka15().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka16().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka16().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuFumei().setDisabled(true);
        div.getYoshikiichihoseiMeisai().getTxtshichosonFumei().setDisabled(true);
    }

    private void set活性() {
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuVal().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonVal().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuni().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonValni().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasusan().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonsan().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokensu().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonsandankai().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuyon().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonyonkaidan().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuyondankai().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonyondankai().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka1().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka1().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka2().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka2().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka3().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka3().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka4().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka4().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka5().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka5().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka6().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka6().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka7().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka7().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka8().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka8().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka9().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka9().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka10().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka10().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka11().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka11().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka12().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka12().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka13().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka13().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka14().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka14().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka15().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka15().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka16().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonka16().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuFumei().setDisabled(false);
        div.getYoshikiichihoseiMeisai().getTxtshichosonFumei().setDisabled(false);
    }

    private void set詳細データエリア(JigyoHokokuTokeiData data) {
        if (Decimal.ONE.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuVal().setValue(data.get集計結果値());
        }
        if (Decimal.ONE.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonVal().setValue(data.get集計項目名称());
        }
        if (NUM_2.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuni().setValue(data.get集計結果値());
        }
        if (NUM_2.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonValni().setValue(data.get集計項目名称());
        }
        if (NUM_3.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasusan().setValue(data.get集計結果値());
        }
        if (NUM_3.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonsan().setValue(data.get集計項目名称());
        }
        if (NUM_4.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokensu().setValue(data.get集計結果値());
        }
        if (NUM_4.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonsandankai().setValue(data.get集計項目名称());
        }
        set詳細データエリア１(data);
    }

    private void set詳細データエリア１(JigyoHokokuTokeiData data) {
        if (NUM_5.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuyon().setValue(data.get集計結果値());
        }
        if (NUM_5.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonyonkaidan().setValue(data.get集計項目名称());
        }
        if (NUM_6.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuyondankai().setValue(data.get集計結果値());
        }
        if (NUM_6.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonyondankai().setValue(data.get集計項目名称());
        }
        if (NUM_7.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka1().setValue(data.get集計結果値());
        }
        if (NUM_7.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka1().setValue(data.get集計項目名称());
        }
        if (NUM_8.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka2().setValue(data.get集計結果値());
        }
        if (NUM_8.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka2().setValue(data.get集計項目名称());
        }
        set詳細データエリア２(data);
    }

    private void set詳細データエリア２(JigyoHokokuTokeiData data) {
        if (NUM_9.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka3().setValue(data.get集計結果値());
        }
        if (NUM_9.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka3().setValue(data.get集計項目名称());
        }
        if (Decimal.TEN.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka4().setValue(data.get集計結果値());
        }
        if (Decimal.TEN.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka4().setValue(data.get集計項目名称());
        }
        if (NUM_11.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka5().setValue(data.get集計結果値());
        }
        if (NUM_11.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka5().setValue(data.get集計項目名称());
        }
        if (NUM_12.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka6().setValue(data.get集計結果値());
        }
        if (NUM_12.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka6().setValue(data.get集計項目名称());
        }
        set詳細データエリア３(data);
    }

    private void set詳細データエリア３(JigyoHokokuTokeiData data) {
        if (NUM_13.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka7().setValue(data.get集計結果値());
        }
        if (NUM_13.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka7().setValue(data.get集計項目名称());
        }
        if (NUM_14.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka8().setValue(data.get集計結果値());
        }
        if (NUM_14.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka8().setValue(data.get集計項目名称());
        }
        set詳細データエリア４(data);
    }

    private void set詳細データエリア４(JigyoHokokuTokeiData data) {
        if (NUM_15.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka9().setValue(data.get集計結果値());
        }
        if (NUM_15.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka9().setValue(data.get集計項目名称());
        }
        if (NUM_16.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka10().setValue(data.get集計結果値());
        }
        if (NUM_16.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka10().setValue(data.get集計項目名称());
        }
        if (NUM_17.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka11().setValue(data.get集計結果値());
        }
        if (NUM_17.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka11().setValue(data.get集計項目名称());
        }
        if (NUM_18.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka12().setValue(data.get集計結果値());
        }
        if (NUM_18.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka12().setValue(data.get集計項目名称());
        }
        set詳細データエリア５(data);
    }

    private void set詳細データエリア５(JigyoHokokuTokeiData data) {
        if (NUM_19.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka13().setValue(data.get集計結果値());
        }
        if (NUM_19.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka13().setValue(data.get集計項目名称());
        }
        if (NUM_20.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka14().setValue(data.get集計結果値());
        }
        if (NUM_20.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka14().setValue(data.get集計項目名称());
        }
        if (NUM_21.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka15().setValue(data.get集計結果値());
        }
        if (NUM_21.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka15().setValue(data.get集計項目名称());
        }
        set詳細データエリア６(data);
    }

    private void set詳細データエリア６(JigyoHokokuTokeiData data) {
        if (NUM_22.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka16().setValue(data.get集計結果値());
        }
        if (NUM_22.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonka16().setValue(data.get集計項目名称());
        }
        if (NUM_23.compareTo(data.get縦番号()) == 0 && Decimal.ONE.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuFumei().setValue(data.get集計結果値());
        }
        if (NUM_23.compareTo(data.get縦番号()) == 0 && NUM_2.compareTo(data.get横番号()) == 0) {
            div.getYoshikiichihoseiMeisai().getTxtshichosonFumei().setValue(data.get集計項目名称());
        }
    }

    private List<TempJigyoHokokuNenpoDetalParameter> getTempModifyData() {
        List<TempJigyoHokokuNenpoDetalParameter> tempList = new ArrayList();
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(Decimal.ONE, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuVal().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_2, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuni().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_3, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasusan().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_4, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokensu().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_5, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuyon().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_6, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendomatsugenzaihihokenshasuyondankai().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_7, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka1().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_8, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka2().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_9, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka3().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(Decimal.TEN, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka4().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_11, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka5().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_12, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka6().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_13, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka7().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_14, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka8().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_15, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka9().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_16, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka10().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_17, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka11().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_18, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka12().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_19, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka13().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_20, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka14().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_21, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka15().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_22, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuka16().getValue()));
        tempList.add(TempJigyoHokokuNenpoDetalParameter.createParameterForTempParam(NUM_23, Decimal.ONE, div.getYoshikiichihoseiMeisai().getTxtnendohihokenshasuFumei().getValue()));

        return tempList;
    }
}
