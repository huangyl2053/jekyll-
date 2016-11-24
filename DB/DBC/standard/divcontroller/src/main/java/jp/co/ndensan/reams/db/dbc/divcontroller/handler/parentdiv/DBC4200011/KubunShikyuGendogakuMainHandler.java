/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4200011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseKubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.kubunshikyugendogaku.KubunShikyuGendogakuData;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku.KubunShikyuGendogakuYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku.ShikyuGendogakuTableKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011.KubunShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011.dgShikyuGendogaku_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.UwanoseKubunShikyuGendoGakuManager;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KubunShikyuGendoGakuManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 区分支給限度額登録のHandlerクラスです。
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class KubunShikyuGendogakuMainHandler {

    private final KubunShikyuGendogakuMainDiv div;
    private static final RString RS_1 = new RString("1");
    private static final RString 共通ボタン = new RString("btnUpdate");
    private static final int INDEX_1 = 1;

    /**
     * コンストラクタです。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     */
    public KubunShikyuGendogakuMainHandler(KubunShikyuGendogakuMainDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ShokanShikyuGendogakuMainHandler
     */
    public static KubunShikyuGendogakuMainHandler of(KubunShikyuGendogakuMainDiv div) {
        return new KubunShikyuGendogakuMainHandler(div);
    }

    /**
     * 初期化のメソッドです。
     *
     * @param 居宅List List<KubunShikyuGendoGaku>
     * @param 上乗せ居宅List List<UwanoseKubunShikyuGendoGaku>
     */
    public void initializeDisplay(List<KubunShikyuGendoGaku> 居宅List,
            List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅List) {
        List<KubunShikyuGendogakuData> entityList = new ArrayList<>();
        if (居宅List != null
                && !居宅List.isEmpty()) {
            居宅List横並びに(居宅List, entityList);
        }
        if (上乗せ居宅List != null
                && !上乗せ居宅List.isEmpty()) {
            上乗せ居宅List横並びに(上乗せ居宅List, entityList);
        }
        if (!entityList.isEmpty()) {
            状態１(entityList);
        }
        状態１画面制御();
    }

    private void 居宅List横並びに(List<KubunShikyuGendoGaku> 居宅List, List<KubunShikyuGendogakuData> entityList) {
        Boolean 最新フラグ = true;
        FlexibleYearMonth tekiyoKaishiYM = null;
        KubunShikyuGendogakuData entity = new KubunShikyuGendogakuData();

        for (KubunShikyuGendoGaku 居宅データ : 居宅List) {
            if (最新フラグ) {
                tekiyoKaishiYM = 居宅データ.get適用開始年月();
                entity.setTekiyoKaishiYM(居宅データ.get適用開始年月());
                entity.setTekiyoShuryoYM(居宅データ.get適用終了年月());
                entity.setTableKubun(ShikyuGendogakuTableKubun.標準.get名称());
                並びに(居宅データ, null, entity);
                entity.setHdnSaishinFlag(RS_1);
                最新フラグ = false;
                continue;
            }
            if (居宅データ.get適用開始年月().compareTo(tekiyoKaishiYM) == 0) {
                並びに(居宅データ, null, entity);
            } else {
                entityList.add(entity);
                entity = new KubunShikyuGendogakuData();

                tekiyoKaishiYM = 居宅データ.get適用開始年月();
                entity.setTekiyoKaishiYM(居宅データ.get適用開始年月());
                entity.setTekiyoShuryoYM(居宅データ.get適用終了年月());
                entity.setTableKubun(ShikyuGendogakuTableKubun.標準.get名称());
                並びに(居宅データ, null, entity);
            }
        }
        entityList.add(entity);
    }

    private void 上乗せ居宅List横並びに(List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅List,
            List<KubunShikyuGendogakuData> entityList) {
        Boolean 最新フラグ = true;
        FlexibleYearMonth tekiyoKaishiYM = null;
        KubunShikyuGendogakuData entity = new KubunShikyuGendogakuData();

        for (UwanoseKubunShikyuGendoGaku 上乗せ居宅データ : 上乗せ居宅List) {
            if (最新フラグ) {
                tekiyoKaishiYM = 上乗せ居宅データ.get適用開始年月();
                entity.setTekiyoKaishiYM(上乗せ居宅データ.get適用開始年月());
                entity.setTekiyoShuryoYM(上乗せ居宅データ.get適用終了年月());
                entity.setTableKubun(ShikyuGendogakuTableKubun.上乗せ後.get名称());
                並びに(null, 上乗せ居宅データ, entity);
                entity.setHdnSaishinFlag(RS_1);
                最新フラグ = false;
                continue;
            }
            if (上乗せ居宅データ.get適用開始年月().compareTo(tekiyoKaishiYM) == 0) {
                並びに(null, 上乗せ居宅データ, entity);
            } else {
                entityList.add(entity);
                entity = new KubunShikyuGendogakuData();

                tekiyoKaishiYM = 上乗せ居宅データ.get適用開始年月();
                entity.setTekiyoKaishiYM(上乗せ居宅データ.get適用開始年月());
                entity.setTekiyoShuryoYM(上乗せ居宅データ.get適用終了年月());
                entity.setTableKubun(ShikyuGendogakuTableKubun.上乗せ後.get名称());
                並びに(null, 上乗せ居宅データ, entity);
            }
        }
        entityList.add(entity);
    }

    private void 並びに(KubunShikyuGendoGaku 居宅データ, UwanoseKubunShikyuGendoGaku 上乗せ居宅データ, KubunShikyuGendogakuData entity) {
        if (居宅データ != null) {
            RString 要介護状態区分 = 居宅データ.get要介護状態区分();
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護1.getコード().equals(要介護状態区分)) {
                entity.setYokaigo1ShikyuGendogaku(居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護2.getコード().equals(要介護状態区分)) {
                entity.setYokaigo2ShikyuGendogaku(居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護3.getコード().equals(要介護状態区分)) {
                entity.setYokaigo3ShikyuGendogaku(居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護4.getコード().equals(要介護状態区分)) {
                entity.setYokaigo4ShikyuGendogaku(居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護5.getコード().equals(要介護状態区分)) {
                entity.setYokaigo5ShikyuGendogaku(居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.経過介護.getコード().equals(要介護状態区分)) {
                entity.setKeikaKaigoShikyuGendogaku(居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード().equals(要介護状態区分)) {
                entity.setYoshien1ShikyuGendogaku(居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード().equals(要介護状態区分)) {
                entity.setYoshien2ShikyuGendogaku(居宅データ.get支給限度単位数());
            }
        }
        if (上乗せ居宅データ != null) {
            RString 要介護状態区分 = 上乗せ居宅データ.get要介護状態区分();
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護1.getコード().equals(要介護状態区分)) {
                entity.setYokaigo1ShikyuGendogaku(上乗せ居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護2.getコード().equals(要介護状態区分)) {
                entity.setYokaigo2ShikyuGendogaku(上乗せ居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護3.getコード().equals(要介護状態区分)) {
                entity.setYokaigo3ShikyuGendogaku(上乗せ居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護4.getコード().equals(要介護状態区分)) {
                entity.setYokaigo4ShikyuGendogaku(上乗せ居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要介護5.getコード().equals(要介護状態区分)) {
                entity.setYokaigo5ShikyuGendogaku(上乗せ居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.経過介護.getコード().equals(要介護状態区分)) {
                entity.setKeikaKaigoShikyuGendogaku(上乗せ居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード().equals(要介護状態区分)) {
                entity.setYoshien1ShikyuGendogaku(上乗せ居宅データ.get支給限度単位数());
            }
            if (KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード().equals(要介護状態区分)) {
                entity.setYoshien2ShikyuGendogaku(上乗せ居宅データ.get支給限度単位数());
            }
        }
    }

    /**
     * 「状態定義｣状態1．より、画面を表示する。
     *
     * @param resultList List<KubunShikyuGendogakuData>
     */
    public void 状態１(List<KubunShikyuGendogakuData> resultList) {
        List<dgShikyuGendogaku_Row> rowList = new ArrayList();
        for (KubunShikyuGendogakuData result : resultList) {
            dgShikyuGendogaku_Row row = new dgShikyuGendogaku_Row();
            if (RS_1.equals(result.getHdnSaishinFlag())) {
                row.setModifyButtonState(DataGridButtonState.Enabled);
                row.setDeleteButtonState(DataGridButtonState.Enabled);
            } else {
                row.setDeleteButtonState(DataGridButtonState.Disabled);
                row.setModifyButtonState(DataGridButtonState.Disabled);
            }
            row.getTekiyoKaishiYM().setValue(flexibleDateToRDate(result.getTekiyoKaishiYM()));
            row.getTekiyoShuryoYm().setValue(flexibleDateToRDate(result.getTekiyoShuryoYM()));
            row.setTableKubun(result.getTableKubun());
            row.getYokaigo1ShikyuGendogaku().setValue(result.getYokaigo1ShikyuGendogaku());
            row.getYokaigo2ShikyuGendogaku().setValue(result.getYokaigo2ShikyuGendogaku());
            row.getYokaigo3ShikyuGendogaku().setValue(result.getYokaigo3ShikyuGendogaku());
            row.getYokaigo4ShikyuGendogaku().setValue(result.getYokaigo4ShikyuGendogaku());
            row.getYokaigo5ShikyuGendogaku().setValue(result.getYokaigo5ShikyuGendogaku());
            row.getKeikaKaigoShikyuGendogaku().setValue(result.getKeikaKaigoShikyuGendogaku());
            row.getYoshien1ShikyuGendogaku().setValue(result.getYoshien1ShikyuGendogaku());
            row.getYoshien2ShikyuGendogaku().setValue(result.getYoshien2ShikyuGendogaku());
            row.setHdnSaishinFlag(result.getHdnSaishinFlag());
            rowList.add(row);
        }
        div.getKubunShikyuGendogakuIchiran().getDgShikyuGendogaku().setDataSource(rowList);

    }

    /**
     * 「状態定義｣状態1．より、画面を表示する。
     *
     */
    public void 状態１画面制御() {
        div.getKubunShikyuGendogakuIchiran().setDisabled(false);
        div.getKubunShikyuGendogakuIchiran().getBtnAddShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(共通ボタン, true);
        clear詳細エリア();
    }

    private void clear詳細エリア() {
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().clearFromValue();
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().clearToValue();
        div.getKubunShikyuGendogakuShosai().getRadTableKubun().setSelectedValue(ShikyuGendogakuTableKubun.標準.get名称());
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().clearValue();
    }

    private void setValue() {
        dgShikyuGendogaku_Row row = div.getDgShikyuGendogaku().getClickedItem();
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromValue(row.getTekiyoKaishiYM().getValue());
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToValue(row.getTekiyoShuryoYm().getValue());
        div.getKubunShikyuGendogakuShosai().getRadTableKubun().setSelectedValue(row.getTableKubun());
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setValue(row.getYokaigo1ShikyuGendogaku().getValue());
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setValue(row.getYokaigo2ShikyuGendogaku().getValue());
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setValue(row.getYokaigo3ShikyuGendogaku().getValue());
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setValue(row.getYokaigo4ShikyuGendogaku().getValue());
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setValue(row.getYokaigo5ShikyuGendogaku().getValue());
        div.getKubunShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().setValue(row.getKeikaKaigoShikyuGendogaku().getValue());
        div.getKubunShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setValue(row.getYoshien1ShikyuGendogaku().getValue());
        div.getKubunShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setValue(row.getYoshien2ShikyuGendogaku().getValue());
    }

    /**
     * 「状態定義」状態3．より、画面を表示する
     *
     */
    public void 状態３() {
        clear詳細エリア();
        setValue();
        div.getKubunShikyuGendogakuIchiran().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        div.getKubunShikyuGendogakuShosai().getRadTableKubun().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setDisabled(false);
        div.getBtnCancel().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(共通ボタン, true);
    }

    /**
     * 「状態定義」状態４．より、画面を表示する
     *
     */
    public void 状態４() {
        clear詳細エリア();
        setValue();
        div.getKubunShikyuGendogakuIchiran().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        div.getKubunShikyuGendogakuShosai().getRadTableKubun().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setDisabled(true);
        div.getBtnCancel().setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(共通ボタン, true);
    }

    /**
     * 「状態定義」状態５．より、画面を表示する
     *
     */
    public void 状態５() {
        clear詳細エリア();
        div.getKubunShikyuGendogakuIchiran().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        div.getKubunShikyuGendogakuShosai().getRadTableKubun().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setDisabled(false);
        div.getBtnCancel().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(共通ボタン, true);
    }

    private void getInsertData(List<KubunShikyuGendoGaku> 居宅InsertList,
            List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅InsertList) {
        RString テーブル区分 = div.getKubunShikyuGendogakuShosai().getRadTableKubun().getSelectedValue();
        FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(
                div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange()
                .getFromValue().getYearMonth().toString());
        RString 要介護状態区分 = null;
        Decimal 支給限度単位数 = null;

        if (div.getKubunShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要介護1.getコード();
            支給限度単位数 = div.getKubunShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().getValue();
            setInsertList(居宅InsertList, 上乗せ居宅InsertList, テーブル区分, 要介護状態区分, 適用開始年月, 支給限度単位数);
        }
        if (div.getKubunShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要介護2.getコード();
            支給限度単位数 = div.getKubunShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().getValue();
            setInsertList(居宅InsertList, 上乗せ居宅InsertList, テーブル区分, 要介護状態区分, 適用開始年月, 支給限度単位数);
        }
        if (div.getKubunShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要介護3.getコード();
            支給限度単位数 = div.getKubunShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().getValue();
            setInsertList(居宅InsertList, 上乗せ居宅InsertList, テーブル区分, 要介護状態区分, 適用開始年月, 支給限度単位数);
        }
        if (div.getKubunShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要介護4.getコード();
            支給限度単位数 = div.getKubunShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().getValue();
            setInsertList(居宅InsertList, 上乗せ居宅InsertList, テーブル区分, 要介護状態区分, 適用開始年月, 支給限度単位数);
        }
        if (div.getKubunShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要介護5.getコード();
            支給限度単位数 = div.getKubunShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().getValue();
            setInsertList(居宅InsertList, 上乗せ居宅InsertList, テーブル区分, 要介護状態区分, 適用開始年月, 支給限度単位数);
        }
        if (div.getKubunShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.経過介護.getコード();
            支給限度単位数 = div.getKubunShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().getValue();
            setInsertList(居宅InsertList, 上乗せ居宅InsertList, テーブル区分, 要介護状態区分, 適用開始年月, 支給限度単位数);
        }
        if (div.getKubunShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード();
            支給限度単位数 = div.getKubunShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue();
            setInsertList(居宅InsertList, 上乗せ居宅InsertList, テーブル区分, 要介護状態区分, 適用開始年月, 支給限度単位数);
        }
        if (div.getKubunShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード();
            支給限度単位数 = div.getKubunShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue();
            setInsertList(居宅InsertList, 上乗せ居宅InsertList, テーブル区分, 要介護状態区分, 適用開始年月, 支給限度単位数);
        }
    }

    private void setInsertList(List<KubunShikyuGendoGaku> 居宅InsertList,
            List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅InsertList,
            RString テーブル区分,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            Decimal 支給限度単位数) {
        int 履歴番号 = INDEX_1;
        if (ShikyuGendogakuTableKubun.標準.get名称().equals(テーブル区分)) {
            KubunShikyuGendoGaku 居宅データ = new KubunShikyuGendoGaku(要介護状態区分, 適用開始年月, 履歴番号);
            居宅データ = 居宅データ.createBuilderForEdit()
                    .set要介護状態区分(要介護状態区分)
                    .set適用開始年月(適用開始年月)
                    .set履歴番号(履歴番号)
                    .set適用終了年月(FlexibleYearMonth.EMPTY)
                    .set支給限度単位数(支給限度単位数)
                    .build();
            居宅InsertList.add(居宅データ);
        } else {
            UwanoseKubunShikyuGendoGaku 上乗せ居宅データ = new UwanoseKubunShikyuGendoGaku(要介護状態区分, 適用開始年月, 履歴番号);
            上乗せ居宅データ = 上乗せ居宅データ.createBuilderForEdit()
                    .set要介護状態区分(要介護状態区分)
                    .set適用開始年月(適用開始年月)
                    .set履歴番号(履歴番号)
                    .set適用終了年月(FlexibleYearMonth.EMPTY)
                    .set支給限度単位数(支給限度単位数)
                    .build();
            上乗せ居宅InsertList.add(上乗せ居宅データ);
        }
    }

    /**
     * 「追加する」ボタン押下による入力の場合、詳細エリアの入力内容をINSERTする
     *
     * @param 居宅HoldList List<KubunShikyuGendoGaku>
     * @param 上乗せ居宅HoldList List<UwanoseKubunShikyuGendoGaku>
     */
    public void insertAndUpdate(List<KubunShikyuGendoGaku> 居宅HoldList,
            List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅HoldList) {
        RString テーブル区分 = div.getKubunShikyuGendogakuShosai().getRadTableKubun().getSelectedValue();
        FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(
                div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange()
                .getFromValue().getYearMonth().toString());

        List<KubunShikyuGendoGaku> add居宅List = new ArrayList();
        List<KubunShikyuGendoGaku> update居宅List = new ArrayList();
        List<UwanoseKubunShikyuGendoGaku> add上乗せ居宅List = new ArrayList();
        List<UwanoseKubunShikyuGendoGaku> update上乗せ居宅List = new ArrayList();

        getInsertData(add居宅List, add上乗せ居宅List);

        List<dgShikyuGendogaku_Row> rowList = div.getKubunShikyuGendogakuIchiran()
                .getDgShikyuGendogaku().getDataSource();
        for (dgShikyuGendogaku_Row row : rowList) {
            if (ShikyuGendogakuTableKubun.標準.get名称().equals(テーブル区分)) {
                if (RS_1.equals(row.getHdnSaishinFlag())
                        && テーブル区分.equals(row.getTableKubun())) {
                    setUpdateList(適用開始年月.minusMonth(INDEX_1), update居宅List,
                            update上乗せ居宅List, row, 居宅HoldList, 上乗せ居宅HoldList);
                }
            } else {
                if (RS_1.equals(row.getHdnSaishinFlag())
                        && row.getTekiyoShuryoYm().getValue() == null
                        && テーブル区分.equals(row.getTableKubun())) {
                    setUpdateList(適用開始年月.minusMonth(INDEX_1), update居宅List,
                            update上乗せ居宅List, row, 居宅HoldList, 上乗せ居宅HoldList);
                }
            }
        }
        KubunShikyuGendoGakuManager 居宅manager = new KubunShikyuGendoGakuManager();
        UwanoseKubunShikyuGendoGakuManager 上乗せ居宅manager
                = new UwanoseKubunShikyuGendoGakuManager();
        居宅manager.insertAndUpdate居宅(add居宅List, update居宅List);
        上乗せ居宅manager.insertAndUpdate上乗せ居宅(add上乗せ居宅List, update上乗せ居宅List);
    }

    /**
     * 「修正」ボタン押下による入力の場合、詳細エリアの入力内容でUPDATEする
     *
     * @param 居宅HoldList List<KubunShikyuGendoGaku>
     * @param 上乗せ居宅HoldList List<UwanoseKubunShikyuGendoGaku>
     */
    public void update(List<KubunShikyuGendoGaku> 居宅HoldList,
            List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅HoldList) {
        RString テーブル区分 = div.getKubunShikyuGendogakuShosai().getRadTableKubun().getSelectedValue();
        FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(
                div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange()
                .getFromValue().getYearMonth().toString());
        RString 要介護状態区分 = null;
        Decimal 支給限度単位数 = null;

        KubunShikyuGendoGakuManager 居宅manager = new KubunShikyuGendoGakuManager();
        UwanoseKubunShikyuGendoGakuManager 上乗せ居宅manager
                = new UwanoseKubunShikyuGendoGakuManager();

        List<KubunShikyuGendoGaku> update居宅List = new ArrayList();
        List<UwanoseKubunShikyuGendoGaku> update上乗せ居宅List = new ArrayList();
        List<KubunShikyuGendoGaku> insert居宅List = new ArrayList();
        List<UwanoseKubunShikyuGendoGaku> insert上乗せ居宅List = new ArrayList();

        getInsertData(insert居宅List, insert上乗せ居宅List);

        if (!insert居宅List.isEmpty()) {
            for (KubunShikyuGendoGaku insert居宅 : insert居宅List) {
                要介護状態区分 = insert居宅.get要介護状態区分();
                支給限度単位数 = insert居宅.get支給限度単位数();
                valueChange(テーブル区分, 要介護状態区分, 適用開始年月, 支給限度単位数, update居宅List,
                        update上乗せ居宅List, 居宅HoldList, 上乗せ居宅HoldList, insert居宅, null);
            }
        }
        if (!insert上乗せ居宅List.isEmpty()) {
            for (UwanoseKubunShikyuGendoGaku insert上乗せ : insert上乗せ居宅List) {
                要介護状態区分 = insert上乗せ.get要介護状態区分();
                支給限度単位数 = insert上乗せ.get支給限度単位数();
                valueChange(テーブル区分, 要介護状態区分, 適用開始年月, 支給限度単位数, update居宅List,
                        update上乗せ居宅List, 居宅HoldList, 上乗せ居宅HoldList, null, insert上乗せ);
            }
        }

        居宅manager.save居宅サービス区分List(update居宅List);
        上乗せ居宅manager.save上乗せ居宅サービス区分List(update上乗せ居宅List);
    }

    /**
     * 「削除」ボタン押下による入力の場合、選択行のデータを物理削除する
     *
     * @param 居宅HolderList List<KubunShikyuGendoGaku>
     * @param 上乗せ居宅HolderList List<UwanoseKubunShikyuGendoGaku>
     */
    public void deleteAndUpdate(List<KubunShikyuGendoGaku> 居宅HolderList,
            List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅HolderList) {
        RString テーブル区分 = div.getKubunShikyuGendogakuShosai().getRadTableKubun().getSelectedValue();
        FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(
                div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange()
                .getFromValue().getYearMonth().toString());
        RString 要介護状態区分 = null;

        KubunShikyuGendoGakuManager 居宅manager = new KubunShikyuGendoGakuManager();
        UwanoseKubunShikyuGendoGakuManager 上乗せ居宅manager
                = new UwanoseKubunShikyuGendoGakuManager();

        List<KubunShikyuGendoGaku> update居宅List = new ArrayList();
        List<UwanoseKubunShikyuGendoGaku> update上乗せ居宅List = new ArrayList();
        List<KubunShikyuGendoGaku> delete居宅List = new ArrayList();
        List<UwanoseKubunShikyuGendoGaku> delete上乗せ居宅List = new ArrayList();
        List<KubunShikyuGendoGaku> insert居宅List = new ArrayList();
        List<UwanoseKubunShikyuGendoGaku> insert上乗せ居宅List = new ArrayList();

        getInsertData(insert居宅List, insert上乗せ居宅List);

        if (!insert居宅List.isEmpty()) {
            for (KubunShikyuGendoGaku insert居宅 : insert居宅List) {
                要介護状態区分 = insert居宅.get要介護状態区分();
                setDeleteList(テーブル区分, 要介護状態区分, 適用開始年月, delete居宅List,
                        delete上乗せ居宅List, 居宅HolderList, 上乗せ居宅HolderList);
            }
        }
        if (!insert上乗せ居宅List.isEmpty()) {
            for (UwanoseKubunShikyuGendoGaku insert上乗せ : insert上乗せ居宅List) {
                要介護状態区分 = insert上乗せ.get要介護状態区分();
                setDeleteList(テーブル区分, 要介護状態区分, 適用開始年月, delete居宅List,
                        delete上乗せ居宅List, 居宅HolderList, 上乗せ居宅HolderList);
            }
        }

        List<dgShikyuGendogaku_Row> rowList = div.getKubunShikyuGendogakuIchiran()
                .getDgShikyuGendogaku().getDataSource();
        for (dgShikyuGendogaku_Row row : rowList) {
            if (row.getTekiyoShuryoYm().getValue() != null
                    && テーブル区分.equals(row.getTableKubun())
                    && !RS_1.equals(row.getHdnSaishinFlag())
                    && 適用開始年月.minusMonth(INDEX_1).toDateString().equals(
                            row.getTekiyoShuryoYm().getValue().getYearMonth().toDateString())) {
                setUpdateList(FlexibleYearMonth.EMPTY, update居宅List, update上乗せ居宅List,
                        row, 居宅HolderList, 上乗せ居宅HolderList);
            }
        }
        居宅manager.deleteAndUpdate居宅(delete居宅List, update居宅List);
        上乗せ居宅manager.deleteAndUpdate上乗せ居宅(delete上乗せ居宅List, update上乗せ居宅List);
    }

    private void setDeleteList(RString テーブル区分, RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            List<KubunShikyuGendoGaku> delete居宅List,
            List<UwanoseKubunShikyuGendoGaku> delete上乗せ居宅List,
            List<KubunShikyuGendoGaku> 居宅HolderList,
            List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅HolderList) {
        int 履歴番号 = INDEX_1;

        if (ShikyuGendogakuTableKubun.標準.get名称().equals(
                テーブル区分)) {
            for (KubunShikyuGendoGaku 居宅Holder : 居宅HolderList) {
                if (要介護状態区分.equals(居宅Holder.get要介護状態区分())
                        && 適用開始年月.equals(居宅Holder.get適用開始年月())
                        && 履歴番号 == 居宅Holder.get履歴番号()) {
                    delete居宅List.add(居宅Holder);
                }
            }
        } else {
            for (UwanoseKubunShikyuGendoGaku 上乗せ居宅Holder : 上乗せ居宅HolderList) {
                if (要介護状態区分.equals(上乗せ居宅Holder.get要介護状態区分())
                        && 適用開始年月.equals(上乗せ居宅Holder.get適用開始年月())
                        && 履歴番号 == 上乗せ居宅Holder.get履歴番号()) {
                    delete上乗せ居宅List.add(上乗せ居宅Holder);
                }
            }
        }
    }

    private void valueChange(RString テーブル区分, RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            Decimal 支給限度単位数,
            List<KubunShikyuGendoGaku> update居宅List,
            List<UwanoseKubunShikyuGendoGaku> update上乗せ居宅List,
            List<KubunShikyuGendoGaku> 居宅HolderList,
            List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅HolderList,
            KubunShikyuGendoGaku insert居宅,
            UwanoseKubunShikyuGendoGaku insert上乗せ) {
        boolean flag = true;
        if (ShikyuGendogakuTableKubun.標準.get名称().equals(
                テーブル区分)) {
            for (KubunShikyuGendoGaku 居宅Holder : 居宅HolderList) {
                if (要介護状態区分.equals(居宅Holder.get要介護状態区分())
                        && 適用開始年月.equals(居宅Holder.get適用開始年月())) {
                    居宅Holder = 居宅Holder.createBuilderForEdit()
                            .set支給限度単位数(支給限度単位数)
                            .build();
                    update居宅List.add(居宅Holder);
                    flag = false;
                }
            }
            if (flag) {
                update居宅List.add(insert居宅);
            }
        } else {
            for (UwanoseKubunShikyuGendoGaku 上乗せ居宅Holder : 上乗せ居宅HolderList) {
                if (要介護状態区分.equals(上乗せ居宅Holder.get要介護状態区分())
                        && 適用開始年月.equals(上乗せ居宅Holder.get適用開始年月())) {
                    上乗せ居宅Holder = 上乗せ居宅Holder.createBuilderForEdit()
                            .set支給限度単位数(支給限度単位数)
                            .build();
                    update上乗せ居宅List.add(上乗せ居宅Holder);
                    flag = false;
                }
            }
            if (flag) {
                update上乗せ居宅List.add(insert上乗せ);
            }
        }
    }

    private void setUpdateList(FlexibleYearMonth 適用終了年月,
            List<KubunShikyuGendoGaku> update居宅List,
            List<UwanoseKubunShikyuGendoGaku> update上乗せList,
            dgShikyuGendogaku_Row row,
            List<KubunShikyuGendoGaku> 居宅HolderList,
            List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅HolderList) {
        FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(
                row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString());
        RString 要介護状態区分 = null;
        RString テーブル区分 = row.getTableKubun();
        if (row.getYokaigo1ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要介護1.getコード();
            setUpdateList2(要介護状態区分, テーブル区分, 適用開始年月, 適用終了年月, update居宅List,
                    update上乗せList, 居宅HolderList, 上乗せ居宅HolderList);
        }
        if (row.getYokaigo2ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要介護2.getコード();
            setUpdateList2(要介護状態区分, テーブル区分, 適用開始年月, 適用終了年月, update居宅List,
                    update上乗せList, 居宅HolderList, 上乗せ居宅HolderList);
        }
        if (row.getYokaigo3ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要介護3.getコード();
            setUpdateList2(要介護状態区分, テーブル区分, 適用開始年月, 適用終了年月, update居宅List,
                    update上乗せList, 居宅HolderList, 上乗せ居宅HolderList);
        }
        if (row.getYokaigo4ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要介護4.getコード();
            setUpdateList2(要介護状態区分, テーブル区分, 適用開始年月, 適用終了年月, update居宅List,
                    update上乗せList, 居宅HolderList, 上乗せ居宅HolderList);
        }
        if (row.getYokaigo5ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要介護5.getコード();
            setUpdateList2(要介護状態区分, テーブル区分, 適用開始年月, 適用終了年月, update居宅List,
                    update上乗せList, 居宅HolderList, 上乗せ居宅HolderList);
        }
        if (row.getKeikaKaigoShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.経過介護.getコード();
            setUpdateList2(要介護状態区分, テーブル区分, 適用開始年月, 適用終了年月, update居宅List,
                    update上乗せList, 居宅HolderList, 上乗せ居宅HolderList);
        }
        if (row.getYoshien1ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード();
            setUpdateList2(要介護状態区分, テーブル区分, 適用開始年月, 適用終了年月, update居宅List,
                    update上乗せList, 居宅HolderList, 上乗せ居宅HolderList);
        }
        if (row.getYoshien2ShikyuGendogaku().getValue() != null) {
            要介護状態区分 = KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード();
            setUpdateList2(要介護状態区分, テーブル区分, 適用開始年月, 適用終了年月, update居宅List,
                    update上乗せList, 居宅HolderList, 上乗せ居宅HolderList);
        }
    }

    private void setUpdateList2(RString 要介護状態区分,
            RString テーブル区分, FlexibleYearMonth 適用開始年月,
            FlexibleYearMonth 適用終了年月,
            List<KubunShikyuGendoGaku> update居宅List,
            List<UwanoseKubunShikyuGendoGaku> update上乗せList,
            List<KubunShikyuGendoGaku> 居宅HolderList,
            List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅HolderList) {

        if (ShikyuGendogakuTableKubun.標準.get名称().equals(テーブル区分)) {
            for (KubunShikyuGendoGaku 居宅Holder : 居宅HolderList) {
                if (要介護状態区分.equals(居宅Holder.get要介護状態区分())
                        && 適用開始年月.equals(居宅Holder.get適用開始年月())) {
                    居宅Holder = 居宅Holder.createBuilderForEdit()
                            .set適用終了年月(適用終了年月)
                            .build();
                    update居宅List.add(居宅Holder);
                }
            }
        } else {
            for (UwanoseKubunShikyuGendoGaku 上乗せ居宅Holder : 上乗せ居宅HolderList) {
                if (要介護状態区分.equals(上乗せ居宅Holder.get要介護状態区分())
                        && 適用開始年月.equals(上乗せ居宅Holder.get適用開始年月())) {
                    上乗せ居宅Holder = 上乗せ居宅Holder.createBuilderForEdit()
                            .set適用終了年月(適用終了年月)
                            .build();
                    update上乗せList.add(上乗せ居宅Holder);
                }
            }
        }
    }

    private RDate flexibleDateToRDate(FlexibleYearMonth fd) {
        if (fd == null || RString.EMPTY.equals(new RString(fd.toString()))) {
            return null;
        }
        return new RDate(fd.getYearValue(), fd.getMonthValue());
    }
}
