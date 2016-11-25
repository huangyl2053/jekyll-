/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4220011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseShokanShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.shokanshuruishikyugendogaku.ShokanShuruiShikyuGendoGakuData;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku.ShikyuGendogakuTableKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.ShokanShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.dgShikyuGendogaku_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.ShokanShuruiShikyuGendoGakuManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.UwanoseShokanShuruiShikyuGendoGakuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 償還支給限度額登録のHandlerクラスです。
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public class ShokanShikyuGendogakuMainHandler {

    private final ShokanShikyuGendogakuMainDiv div;
    private static final int INDEX_1 = 1;
    private static final RString RS_1 = new RString("1");
    private static final RString 共通ボタン = new RString("btnUpdate");

    /**
     * コンストラクタです。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     */
    public ShokanShikyuGendogakuMainHandler(ShokanShikyuGendogakuMainDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ShokanShikyuGendogakuMainHandler
     */
    public static ShokanShikyuGendogakuMainHandler of(ShokanShikyuGendogakuMainDiv div) {
        return new ShokanShikyuGendogakuMainHandler(div);
    }

    /**
     * 初期化のメソッドです。
     *
     * @param 償還list List<ShokanShuruiShikyuGendoGaku>
     * @param 上乗せ償還list List<UwanoseShokanShuruiShikyuGendoGaku>
     */
    public void initializeDisplay(List<ShokanShuruiShikyuGendoGaku> 償還list,
            List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還list) {
        List<ShokanShuruiShikyuGendoGakuData> entityList = new ArrayList<>();
        if (償還list != null
                && !償還list.isEmpty()) {
            step1(償還list, entityList);
        }
        if (上乗せ償還list != null
                && !上乗せ償還list.isEmpty()) {
            step2(上乗せ償還list, entityList);
        }
        if (!entityList.isEmpty()) {
            List<dgShikyuGendogaku_Row> rowList = new ArrayList<>();

            for (ShokanShuruiShikyuGendoGakuData result : entityList) {
                dgShikyuGendogaku_Row row = new dgShikyuGendogaku_Row();

                if (result.get最新フラグ() == INDEX_1) {
                    row.setDeleteButtonState(DataGridButtonState.Enabled);
                    row.setModifyButtonState(DataGridButtonState.Enabled);
                } else {
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
                    row.setModifyButtonState(DataGridButtonState.Disabled);
                }
                row.getTekiyoKaishiYM().setValue(flexibleDateToRDate(result.getTekiyoKaishiYM()));
                row.getTekiyoShuryoYM().setValue(flexibleDateToRDate(result.getTekiyoShuryoYM()));
                row.setTableKubun(result.get区分());
                row.getKyotakukaigoFukushiyoguGendogaku().setValue(result.get居宅介護_福祉用具());
                row.getKyotakukaigoJutakuKaishuGendogaku().setValue(result.get居宅介護_住宅改修());
                row.getKyotakushienFukushiyoguGendogaku().setValue(result.get居宅支援_福祉用具());
                row.getKyotakushienJutakuKaishuGendogaku().setValue(result.get居宅支援_住宅改修());
                row.setHdnSaishinFlag(new RString(result.get最新フラグ()));
                rowList.add(row);
            }
            div.getShokanShikyuGendogakuIchiran().getDgShikyuGendogaku().setDataSource(rowList);
        }
        状態１画面制御();
    }

    private void step1(List<ShokanShuruiShikyuGendoGaku> 償還list,
            List<ShokanShuruiShikyuGendoGakuData> entityList) {
        Boolean 最新フラグ = true;
        FlexibleYearMonth tekiyoKaishiYM = null;
        ShokanShuruiShikyuGendoGakuData entity = new ShokanShuruiShikyuGendoGakuData();

        for (ShokanShuruiShikyuGendoGaku 償還データ : 償還list) {

            if (最新フラグ) {
                tekiyoKaishiYM = 償還データ.get適用開始年月();
                entity.setTekiyoKaishiYM(償還データ.get適用開始年月());
                entity.setTekiyoShuryoYM(償還データ.get適用終了年月());
                entity.set区分(ShikyuGendogakuTableKubun.標準.get名称());
                並びに(entity, 償還データ, null);
                entity.set最新フラグ(INDEX_1);
                最新フラグ = false;
                continue;
            }
            if (償還データ.get適用開始年月().equals(tekiyoKaishiYM)) {
                並びに(entity, 償還データ, null);
            } else {
                entityList.add(entity);
                entity = new ShokanShuruiShikyuGendoGakuData();

                tekiyoKaishiYM = 償還データ.get適用開始年月();
                entity.setTekiyoKaishiYM(償還データ.get適用開始年月());
                entity.setTekiyoShuryoYM(償還データ.get適用終了年月());
                entity.set区分(ShikyuGendogakuTableKubun.標準.get名称());
                並びに(entity, 償還データ, null);
            }
        }
        entityList.add(entity);
    }

    private void step2(List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還list,
            List<ShokanShuruiShikyuGendoGakuData> entityList) {

        Boolean 最新フラグ = true;
        FlexibleYearMonth tekiyoKaishiYM = null;
        ShokanShuruiShikyuGendoGakuData entity = new ShokanShuruiShikyuGendoGakuData();

        for (UwanoseShokanShuruiShikyuGendoGaku 上乗せ償還データ : 上乗せ償還list) {
            if (最新フラグ) {
                tekiyoKaishiYM = 上乗せ償還データ.get適用開始年月();
                entity.setTekiyoKaishiYM(上乗せ償還データ.get適用開始年月());
                entity.setTekiyoShuryoYM(上乗せ償還データ.get適用終了年月());
                entity.set区分(ShikyuGendogakuTableKubun.上乗せ後.get名称());
                並びに(entity, null, 上乗せ償還データ);
                entity.set最新フラグ(INDEX_1);
                最新フラグ = false;
                continue;
            }
            if (上乗せ償還データ.get適用開始年月().equals(tekiyoKaishiYM)) {
                並びに(entity, null, 上乗せ償還データ);
            } else {
                entityList.add(entity);
                entity = new ShokanShuruiShikyuGendoGakuData();

                tekiyoKaishiYM = 上乗せ償還データ.get適用開始年月();
                entity.setTekiyoKaishiYM(上乗せ償還データ.get適用開始年月());
                entity.setTekiyoShuryoYM(上乗せ償還データ.get適用終了年月());
                entity.set区分(ShikyuGendogakuTableKubun.上乗せ後.get名称());
                並びに(entity, null, 上乗せ償還データ);
            }
        }
        entityList.add(entity);
    }

    private void 並びに(ShokanShuruiShikyuGendoGakuData entity,
            ShokanShuruiShikyuGendoGaku 償還データ, UwanoseShokanShuruiShikyuGendoGaku 上乗せ償還データ) {
        if (償還データ != null) {
            RString サービス種類コード = 償還データ.getサービス種類コード().getColumnValue();
            if (ServiceCategoryShurui.用具販売.getコード().equals(サービス種類コード)) {
                entity.set居宅介護_福祉用具(償還データ.get支給限度単位数());
            } else if (ServiceCategoryShurui.住宅改修.getコード().equals(サービス種類コード)) {
                entity.set居宅介護_住宅改修(償還データ.get支給限度単位数());
            } else if (ServiceCategoryShurui.予用販売.getコード().equals(サービス種類コード)) {
                entity.set居宅支援_福祉用具(償還データ.get支給限度単位数());
            } else if (ServiceCategoryShurui.予住改修.getコード().equals(サービス種類コード)) {
                entity.set居宅支援_住宅改修(償還データ.get支給限度単位数());
            }
        }
        if (上乗せ償還データ != null) {
            RString サービス種類コード = 上乗せ償還データ.getサービス種類コード().getColumnValue();
            if (ServiceCategoryShurui.用具販売.getコード().equals(サービス種類コード)) {
                entity.set居宅介護_福祉用具(上乗せ償還データ.get支給限度単位数());
            } else if (ServiceCategoryShurui.住宅改修.getコード().equals(サービス種類コード)) {
                entity.set居宅介護_住宅改修(上乗せ償還データ.get支給限度単位数());
            } else if (ServiceCategoryShurui.予用販売.getコード().equals(サービス種類コード)) {
                entity.set居宅支援_福祉用具(上乗せ償還データ.get支給限度単位数());
            } else if (ServiceCategoryShurui.予住改修.getコード().equals(サービス種類コード)) {
                entity.set居宅支援_住宅改修(上乗せ償還データ.get支給限度単位数());
            }
        }
    }

    /**
     * 「状態定義｣状態1．より、画面を表示する。
     *
     */
    public void 状態１画面制御() {
        div.getShokanShikyuGendogakuIchiran().setDisabled(false);
        div.getShokanShikyuGendogakuIchiran().getBtnAddShikyuGendogaku().setDisabled(false);
        div.getShokanShikyuGendogakuShosai().setDisabled(true);
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(true);
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(共通ボタン, true);
        clear詳細エリア();
    }

    private void clear詳細エリア() {
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().clearFromValue();
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().clearToValue();
        div.getShokanShikyuGendogakuShosai().getRadTableKubun().setSelectedValue(
                ShikyuGendogakuTableKubun.標準.get名称());
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoFukushiYogu().clearValue();
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoJutakuKaishu().clearValue();
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienFukushiYogu().clearValue();
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienJutakuKaishu().clearValue();
    }

    private void setValue() {
        dgShikyuGendogaku_Row row = div.getDgShikyuGendogaku().getClickedItem();
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromValue(
                row.getTekiyoKaishiYM().getValue());
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToValue(
                row.getTekiyoShuryoYM().getValue());
        div.getShokanShikyuGendogakuShosai().getRadTableKubun().setSelectedValue(
                row.getTableKubun());
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoFukushiYogu().setValue(
                row.getKyotakukaigoFukushiyoguGendogaku().getValue());
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoJutakuKaishu().setValue(
                row.getKyotakukaigoJutakuKaishuGendogaku().getValue());
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienFukushiYogu().setValue(
                row.getKyotakushienFukushiyoguGendogaku().getValue());
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienJutakuKaishu().setValue(
                row.getKyotakushienJutakuKaishuGendogaku().getValue());
    }

    /**
     * 「状態定義」状態3．より、画面を表示する
     *
     */
    public void 状態３() {
        clear詳細エリア();
        setValue();
        div.getShokanShikyuGendogakuIchiran().setDisabled(true);
        div.getShokanShikyuGendogakuShosai().setDisabled(false);
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(true);
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        div.getShokanShikyuGendogakuShosai().getRadTableKubun().setDisabled(true);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoFukushiYogu().setDisabled(false);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoJutakuKaishu().setDisabled(false);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienFukushiYogu().setDisabled(false);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienJutakuKaishu().setDisabled(false);
        div.getBtnCancel().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(共通ボタン, true);
    }

    /**
     * 「状態定義」状態4．より、画面を表示する
     *
     */
    public void 状態４() {
        clear詳細エリア();
        setValue();
        div.getShokanShikyuGendogakuIchiran().setDisabled(true);
        div.getShokanShikyuGendogakuShosai().setDisabled(true);
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(true);
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        div.getShokanShikyuGendogakuShosai().getRadTableKubun().setDisabled(true);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoFukushiYogu().setDisabled(true);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoJutakuKaishu().setDisabled(true);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienFukushiYogu().setDisabled(true);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienJutakuKaishu().setDisabled(true);
        div.getBtnCancel().setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(共通ボタン, true);
    }

    /**
     * 「状態定義」状態5．より、画面を表示する
     *
     */
    public void 状態５() {
        clear詳細エリア();
        div.getShokanShikyuGendogakuIchiran().setDisabled(true);
        div.getShokanShikyuGendogakuShosai().setDisabled(false);
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(false);
        div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        div.getShokanShikyuGendogakuShosai().getRadTableKubun().setDisabled(false);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoFukushiYogu().setDisabled(false);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoJutakuKaishu().setDisabled(false);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienFukushiYogu().setDisabled(false);
        div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienJutakuKaishu().setDisabled(false);
        div.getBtnCancel().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(共通ボタン, true);
    }

    /**
     * 「追加する」ボタン押下による入力の場合、詳細エリアの入力内容をINSERTする
     *
     * @param 償還HolderList List<ShokanShuruiShikyuGendoGaku>
     * @param 上乗せ償還HolderList List<UwanoseShokanShuruiShikyuGendoGaku>
     */
    public void insertAndUpdate(List<ShokanShuruiShikyuGendoGaku> 償還HolderList,
            List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還HolderList) {
        ServiceShuruiCode サービス種類コード = null;
        FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(
                div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue()
                .getYearMonth().toString());
        int 履歴番号 = INDEX_1;
        Decimal 支給限度単位数 = null;
        RString テーブル区分 = div.getShokanShikyuGendogakuShosai().getRadTableKubun()
                .getSelectedValue();

        List<ShokanShuruiShikyuGendoGaku> add償還List = new ArrayList();
        List<ShokanShuruiShikyuGendoGaku> update償還List = new ArrayList();
        List<UwanoseShokanShuruiShikyuGendoGaku> add上乗せList = new ArrayList();
        List<UwanoseShokanShuruiShikyuGendoGaku> update上乗せList = new ArrayList();

        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoFukushiYogu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.用具販売.getコード());
            支給限度単位数 = div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoFukushiYogu().getValue();
            setAddList(サービス種類コード, 適用開始年月, 履歴番号, 支給限度単位数, add償還List, add上乗せList, テーブル区分);
        }
        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoJutakuKaishu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.住宅改修.getコード());
            支給限度単位数 = div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoJutakuKaishu().getValue();
            setAddList(サービス種類コード, 適用開始年月, 履歴番号, 支給限度単位数, add償還List, add上乗せList, テーブル区分);
        }
        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienFukushiYogu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.予用販売.getコード());
            支給限度単位数 = div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienFukushiYogu().getValue();
            setAddList(サービス種類コード, 適用開始年月, 履歴番号, 支給限度単位数, add償還List, add上乗せList, テーブル区分);
        }
        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienJutakuKaishu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.予住改修.getコード());
            支給限度単位数 = div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienJutakuKaishu().getValue();
            setAddList(サービス種類コード, 適用開始年月, 履歴番号, 支給限度単位数, add償還List, add上乗せList, テーブル区分);
        }

        List<dgShikyuGendogaku_Row> rowList = div.getShokanShikyuGendogakuIchiran().
                getDgShikyuGendogaku().getDataSource();
        for (dgShikyuGendogaku_Row row : rowList) {
            if (ShikyuGendogakuTableKubun.標準.get名称().equals(
                    テーブル区分)) {
                if (RS_1.equals(row.getHdnSaishinFlag())
                        && テーブル区分.equals(row.getTableKubun())) {
                    setUpdateList(適用開始年月.minusMonth(INDEX_1), update償還List,
                            update上乗せList, row, 償還HolderList, 上乗せ償還HolderList);
                }
            } else {
                if (RS_1.equals(row.getHdnSaishinFlag())
                        && row.getTekiyoShuryoYM().getValue() == null
                        && テーブル区分.equals(row.getTableKubun())) {
                    setUpdateList(適用開始年月.minusMonth(INDEX_1), update償還List,
                            update上乗せList, row, 償還HolderList, 上乗せ償還HolderList);
                }
            }
        }
        ShokanShuruiShikyuGendoGakuManager 償還manager = new ShokanShuruiShikyuGendoGakuManager();
        UwanoseShokanShuruiShikyuGendoGakuManager 上乗せ償還manager
                = new UwanoseShokanShuruiShikyuGendoGakuManager();
        償還manager.insertAndUpdate償還(add償還List, update償還List);
        上乗せ償還manager.insertAndUpdate上乗せ(add上乗せList, update上乗せList);
    }

    /**
     * 「修正」ボタン押下による入力の場合、詳細エリアの入力内容でUPDATEする
     *
     * @param 償還HolderList List<ShokanShuruiShikyuGendoGaku>
     * @param 上乗せ償還HolderList List<UwanoseShokanShuruiShikyuGendoGaku>
     */
    public void update(List<ShokanShuruiShikyuGendoGaku> 償還HolderList,
            List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還HolderList) {
        ServiceShuruiCode サービス種類コード = null;
        FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(
                div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().
                getYearMonth().toString());
        FlexibleYearMonth 適用終了年月 = FlexibleYearMonth.EMPTY;
        if (div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().getToValue() != null) {
            適用終了年月 = new FlexibleYearMonth(
                    div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().getToValue().
                    getYearMonth().toString());
        }
        Decimal 支給限度単位数 = null;
        RString テーブル区分 = div.getShokanShikyuGendogakuShosai().getRadTableKubun().getSelectedValue();

        ShokanShuruiShikyuGendoGakuManager 償還manager = new ShokanShuruiShikyuGendoGakuManager();
        UwanoseShokanShuruiShikyuGendoGakuManager 上乗せ償還manager
                = new UwanoseShokanShuruiShikyuGendoGakuManager();

        List<ShokanShuruiShikyuGendoGaku> update償還List = new ArrayList();
        List<UwanoseShokanShuruiShikyuGendoGaku> update上乗せList = new ArrayList();
        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoFukushiYogu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.用具販売.getコード());
            支給限度単位数 = div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoFukushiYogu().getValue();
            valueChange(テーブル区分, サービス種類コード, 適用開始年月, 適用終了年月, 支給限度単位数, update償還List,
                    update上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }

        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoJutakuKaishu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.住宅改修.getコード());
            支給限度単位数 = div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoJutakuKaishu().getValue();
            valueChange(テーブル区分, サービス種類コード, 適用開始年月, 適用終了年月, 支給限度単位数, update償還List,
                    update上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }

        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienFukushiYogu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.予用販売.getコード());
            支給限度単位数 = div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienFukushiYogu().getValue();
            valueChange(テーブル区分, サービス種類コード, 適用開始年月, 適用終了年月, 支給限度単位数, update償還List,
                    update上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }

        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienJutakuKaishu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.予住改修.getコード());
            支給限度単位数 = div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienJutakuKaishu().getValue();
            valueChange(テーブル区分, サービス種類コード, 適用開始年月, 適用終了年月, 支給限度単位数, update償還List,
                    update上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }
        償還manager.save償還List(update償還List);
        上乗せ償還manager.save上乗せList(update上乗せList);
    }

    private void valueChange(RString テーブル区分, ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用開始年月,
            FlexibleYearMonth 適用終了年月,
            Decimal 支給限度単位数,
            List<ShokanShuruiShikyuGendoGaku> update償還List,
            List<UwanoseShokanShuruiShikyuGendoGaku> update上乗せList,
            List<ShokanShuruiShikyuGendoGaku> 償還HolderList,
            List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還HolderList) {
        boolean flag = true;
        if (ShikyuGendogakuTableKubun.標準.get名称().equals(
                テーブル区分)) {
            for (ShokanShuruiShikyuGendoGaku 償還Holder : 償還HolderList) {
                if (サービス種類コード.equals(償還Holder.getサービス種類コード())
                        && 適用開始年月.equals(償還Holder.get適用開始年月())) {
                    償還Holder = 償還Holder.createBuilderForEdit()
                            .set支給限度単位数(支給限度単位数)
                            .build();
                    update償還List.add(償還Holder);
                    flag = false;
                }
            }
            if (flag) {
                int 履歴番号 = INDEX_1;
                ShokanShuruiShikyuGendoGaku add償還 = new ShokanShuruiShikyuGendoGaku(
                        サービス種類コード, 適用開始年月, 履歴番号);
                add償還 = add償還.createBuilderForEdit()
                        .setサービス種類コード(サービス種類コード)
                        .set適用開始年月(適用開始年月)
                        .set履歴番号(履歴番号)
                        .set適用終了年月(適用終了年月)
                        .set支給限度単位数(支給限度単位数)
                        .build();
                update償還List.add(add償還);
            }
        } else {
            for (UwanoseShokanShuruiShikyuGendoGaku 上乗せ償還Holder : 上乗せ償還HolderList) {
                if (サービス種類コード.equals(上乗せ償還Holder.getサービス種類コード())
                        && 適用開始年月.equals(上乗せ償還Holder.get適用開始年月())) {
                    上乗せ償還Holder = 上乗せ償還Holder.createBuilderForEdit()
                            .set支給限度単位数(支給限度単位数)
                            .build();
                    update上乗せList.add(上乗せ償還Holder);
                    flag = false;
                }
            }
            if (flag) {
                int 履歴番号 = INDEX_1;
                UwanoseShokanShuruiShikyuGendoGaku 上乗せ = new UwanoseShokanShuruiShikyuGendoGaku(
                        サービス種類コード, 適用開始年月, 履歴番号);
                上乗せ = 上乗せ.createBuilderForEdit()
                        .setサービス種類コード(サービス種類コード)
                        .set適用開始年月(適用開始年月)
                        .set履歴番号(履歴番号)
                        .set適用終了年月(適用終了年月)
                        .set支給限度単位数(支給限度単位数)
                        .build();
                update上乗せList.add(上乗せ);
            }
        }
    }

    /**
     * 「削除」ボタン押下による入力の場合、選択行のデータを物理削除する
     *
     * @param 償還HolderList List<ShokanShuruiShikyuGendoGaku>
     * @param 上乗せ償還HolderList List<UwanoseShokanShuruiShikyuGendoGaku>
     */
    public void deleteAndUpdate(List<ShokanShuruiShikyuGendoGaku> 償還HolderList,
            List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還HolderList) {
        ServiceShuruiCode サービス種類コード = null;
        FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(
                div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange()
                .getFromValue().getYearMonth().toString());

        RString テーブル区分 = div.getShokanShikyuGendogakuShosai().getRadTableKubun().getSelectedValue();
        ShokanShuruiShikyuGendoGakuManager 償還manager = new ShokanShuruiShikyuGendoGakuManager();
        UwanoseShokanShuruiShikyuGendoGakuManager 上乗せ償還manager
                = new UwanoseShokanShuruiShikyuGendoGakuManager();
        List<ShokanShuruiShikyuGendoGaku> delete償還List = new ArrayList();
        List<ShokanShuruiShikyuGendoGaku> update償還List = new ArrayList();
        List<UwanoseShokanShuruiShikyuGendoGaku> delete上乗せList = new ArrayList();
        List<UwanoseShokanShuruiShikyuGendoGaku> update上乗せList = new ArrayList();

        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoFukushiYogu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.用具販売.getコード());
            setDeleteList(テーブル区分, サービス種類コード, 適用開始年月, delete償還List,
                    delete上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }

        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuKaigoJutakuKaishu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.住宅改修.getコード());
            setDeleteList(テーブル区分, サービス種類コード, 適用開始年月, delete償還List,
                    delete上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }

        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienFukushiYogu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.予用販売.getコード());
            setDeleteList(テーブル区分, サービス種類コード, 適用開始年月, delete償還List,
                    delete上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }

        if (div.getShokanShikyuGendogakuShosai().getTxtKyotakuShienJutakuKaishu().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.予住改修.getコード());
            setDeleteList(テーブル区分, サービス種類コード, 適用開始年月, delete償還List,
                    delete上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }
        List<dgShikyuGendogaku_Row> rowList = div.getShokanShikyuGendogakuIchiran()
                .getDgShikyuGendogaku().getDataSource();
        for (dgShikyuGendogaku_Row row : rowList) {
            if (row.getTekiyoShuryoYM().getValue() != null
                    && テーブル区分.equals(row.getTableKubun())
                    && !RS_1.equals(row.getHdnSaishinFlag())
                    && 適用開始年月.minusMonth(INDEX_1).toDateString().equals(
                            row.getTekiyoShuryoYM().getValue().getYearMonth().toDateString())) {
                setUpdateList(FlexibleYearMonth.EMPTY, update償還List, update上乗せList, row,
                        償還HolderList, 上乗せ償還HolderList);
            }
        }
        償還manager.deleteAndUpdate償還(delete償還List, update償還List);
        上乗せ償還manager.deleteAndUpdate上乗せ(delete上乗せList, update上乗せList);
    }

    private void setDeleteList(RString テーブル区分, ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用開始年月,
            List<ShokanShuruiShikyuGendoGaku> delete償還List,
            List<UwanoseShokanShuruiShikyuGendoGaku> delete上乗せList,
            List<ShokanShuruiShikyuGendoGaku> 償還HolderList,
            List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還HolderList) {
        int 履歴番号 = INDEX_1;

        if (ShikyuGendogakuTableKubun.標準.get名称().equals(
                テーブル区分)) {
            for (ShokanShuruiShikyuGendoGaku 償還Holder : 償還HolderList) {
                if (サービス種類コード.equals(償還Holder.getサービス種類コード())
                        && 適用開始年月.equals(償還Holder.get適用開始年月())
                        && 履歴番号 == 償還Holder.get履歴番号()) {
                    delete償還List.add(償還Holder);
                }
            }
        } else {
            for (UwanoseShokanShuruiShikyuGendoGaku 上乗せ償還Holder : 上乗せ償還HolderList) {
                if (サービス種類コード.equals(上乗せ償還Holder.getサービス種類コード())
                        && 適用開始年月.equals(上乗せ償還Holder.get適用開始年月())
                        && 履歴番号 == 上乗せ償還Holder.get履歴番号()) {
                    delete上乗せList.add(上乗せ償還Holder);
                }
            }
        }
    }

    private void setAddList(ServiceShuruiCode サービス種類コード, FlexibleYearMonth 適用開始年月,
            int 履歴番号, Decimal 支給限度単位数, List<ShokanShuruiShikyuGendoGaku> add償還List,
            List<UwanoseShokanShuruiShikyuGendoGaku> add上乗せList, RString テーブル区分) {
        if (ShikyuGendogakuTableKubun.標準.get名称().equals(
                テーブル区分)) {
            ShokanShuruiShikyuGendoGaku add償還 = new ShokanShuruiShikyuGendoGaku(
                    サービス種類コード, 適用開始年月, 履歴番号);
            add償還 = add償還.createBuilderForEdit()
                    .setサービス種類コード(サービス種類コード)
                    .set適用開始年月(適用開始年月)
                    .set履歴番号(履歴番号)
                    .set適用終了年月(FlexibleYearMonth.EMPTY)
                    .set支給限度単位数(支給限度単位数)
                    .build();
            add償還List.add(add償還);
        } else {
            UwanoseShokanShuruiShikyuGendoGaku add上乗せ = new UwanoseShokanShuruiShikyuGendoGaku(
                    サービス種類コード, 適用開始年月, 履歴番号);
            add上乗せ = add上乗せ.createBuilderForEdit()
                    .setサービス種類コード(サービス種類コード)
                    .set適用開始年月(適用開始年月)
                    .set履歴番号(履歴番号)
                    .set適用終了年月(FlexibleYearMonth.EMPTY)
                    .set支給限度単位数(支給限度単位数)
                    .build();
            add上乗せList.add(add上乗せ);
        }
    }

    private void setUpdateList(FlexibleYearMonth 適用終了年月,
            List<ShokanShuruiShikyuGendoGaku> update償還List,
            List<UwanoseShokanShuruiShikyuGendoGaku> update上乗せList,
            dgShikyuGendogaku_Row row,
            List<ShokanShuruiShikyuGendoGaku> 償還HolderList,
            List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還HolderList) {
        FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(
                row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString());
        ServiceShuruiCode サービス種類コード = null;
        RString テーブル区分 = row.getTableKubun();
        if (row.getKyotakukaigoFukushiyoguGendogaku().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.用具販売.getコード());
            setUpdateList2(サービス種類コード, テーブル区分, 適用開始年月, 適用終了年月, update償還List,
                    update上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }
        if (row.getKyotakukaigoJutakuKaishuGendogaku().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.住宅改修.getコード());
            setUpdateList2(サービス種類コード, テーブル区分, 適用開始年月, 適用終了年月, update償還List,
                    update上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }
        if (row.getKyotakushienFukushiyoguGendogaku().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.予用販売.getコード());
            setUpdateList2(サービス種類コード, テーブル区分, 適用開始年月, 適用終了年月, update償還List,
                    update上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }
        if (row.getKyotakushienJutakuKaishuGendogaku().getValue() != null) {
            サービス種類コード = new ServiceShuruiCode(ServiceCategoryShurui.予住改修.getコード());
            setUpdateList2(サービス種類コード, テーブル区分, 適用開始年月, 適用終了年月, update償還List,
                    update上乗せList, 償還HolderList, 上乗せ償還HolderList);
        }
    }

    private void setUpdateList2(ServiceShuruiCode サービス種類コード,
            RString テーブル区分, FlexibleYearMonth 適用開始年月,
            FlexibleYearMonth 適用終了年月,
            List<ShokanShuruiShikyuGendoGaku> update償還List,
            List<UwanoseShokanShuruiShikyuGendoGaku> update上乗せList,
            List<ShokanShuruiShikyuGendoGaku> 償還HolderList,
            List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還HolderList) {

        if (ShikyuGendogakuTableKubun.標準.get名称().equals(テーブル区分)) {
            for (ShokanShuruiShikyuGendoGaku 償還Holder : 償還HolderList) {
                if (サービス種類コード.equals(償還Holder.getサービス種類コード())
                        && 適用開始年月.equals(償還Holder.get適用開始年月())) {
                    償還Holder = 償還Holder.createBuilderForEdit()
                            .set適用終了年月(適用終了年月)
                            .build();
                    update償還List.add(償還Holder);
                }
            }
        } else {
            for (UwanoseShokanShuruiShikyuGendoGaku 上乗せ償還Holder : 上乗せ償還HolderList) {
                if (サービス種類コード.equals(上乗せ償還Holder.getサービス種類コード())
                        && 適用開始年月.equals(上乗せ償還Holder.get適用開始年月())) {
                    上乗せ償還Holder = 上乗せ償還Holder.createBuilderForEdit()
                            .set適用終了年月(適用終了年月)
                            .build();
                    update上乗せList.add(上乗せ償還Holder);
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
