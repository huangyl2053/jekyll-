/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4210011;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ServiceShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku.KubunShikyuGendogakuYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.ShuruiShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.dgShikyuGendogaku_Row;
import jp.co.ndensan.reams.db.dbc.service.core.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * DBC4210011_種類支給限度額登録のHandlerです。
 *
 * @reamsid_L DBC-3440-010 lihang
 */
public class ShuruiShikyuGendogakuMainHandler {

    private final ShuruiShikyuGendogakuMainDiv div;
    private static final RString 種類支給限度額登録完了 = new RString("種類支給限度額の登録が完了しました。");
    private static final RString 更新 = new RString("btnUpdate");
    private static final RString 一 = new RString("1");
    private static final int ゼロ = 0;

    /**
     * コンストラクタです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     */
    public ShuruiShikyuGendogakuMainHandler(ShuruiShikyuGendogakuMainDiv div) {
        this.div = div;
    }

    /**
     * initializeのメッソドです。
     *
     * @throws ApplicationException
     * @return List<ServiceShuruiShikyuGendoGaku>
     */
    public List<ServiceShuruiShikyuGendoGaku> initialize() {
        Map<Object, List> map = ShuruiShikyuGendogakuMainFinder.createInstance().get種類支給限度額();

        div.getShuruiShikyuGendogakuIchiran().setDisabled(false);
        if (map.get(ShuruiShikyuGendogakuMainResult.class) != null
                && !map.get(ShuruiShikyuGendogakuMainResult.class).isEmpty()) {
            set初期化状態(map.get(ShuruiShikyuGendogakuMainResult.class));
        }
        return map.get(ServiceShuruiShikyuGendoGaku.class);
    }

    /**
     * btnContinueのメッソドです。
     *
     * @throws ApplicationException
     * @return List<ServiceShuruiShikyuGendoGaku>
     */
    public List<ServiceShuruiShikyuGendoGaku> btnContinue() {
        Map<Object, List> map = ShuruiShikyuGendogakuMainFinder.createInstance().get種類支給限度額();
        set初期化状態(map.get(ShuruiShikyuGendogakuMainResult.class));
        return map.get(ServiceShuruiShikyuGendoGaku.class);
    }

    /**
     * 「追加する」ボタンのメソッドです。
     */
    public void btnAddShikyuGendogaku() {
        div.getShuruiShikyuGendogakuIchiran().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getBtnCancel().setDisabled(false);
        div.getCcdKanryoMessage().setVisible(false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(更新, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(更新, false);
    }

    /**
     * 支給限度額一覧の「修正」ボタンのメソッドです。
     */
    public void modify() {
        div.getShuruiShikyuGendogakuIchiran().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().setSelectedKey(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getServiceShuruiCode());
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem()
                .getTekiyoKaishiYM().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem()
                .getTekiyoShuryoYM().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getKeikaKaigoShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYoshien1ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYoshien2ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo1ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo2ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo3ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo4ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setDisabled(false);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo5ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getBtnCancel().setDisabled(false);
        div.getCcdKanryoMessage().setVisible(false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(更新, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(更新, false);
    }

    /**
     * 支給限度額一覧の「削除」ボタンのメソッドです。
     */
    public void delete() {
        div.getShuruiShikyuGendogakuIchiran().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().setVisible(true);
        div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().setSelectedKey(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getServiceShuruiCode());
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getTekiyoKaishiYM().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getTekiyoShuryoYM().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getKeikaKaigoShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setDisabled(true);
        Decimal yoshien1ShikyuGendogaku = div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku()
                .getClickedItem().getYoshien1ShikyuGendogaku().getValue();
        if (yoshien1ShikyuGendogaku != null) {
            div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setValue(yoshien1ShikyuGendogaku);
        }
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setDisabled(true);
        Decimal yoshien2ShikyuGendogaku = div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku()
                .getClickedItem().getYoshien2ShikyuGendogaku().getValue();
        if (yoshien2ShikyuGendogaku != null) {
            div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setValue(yoshien2ShikyuGendogaku);
        }
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo1ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo2ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo3ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo4ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo5ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getBtnCancel().setDisabled(true);
        div.getCcdKanryoMessage().setVisible(true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(更新, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(更新, false);
    }

    /**
     * 「入力を破棄する」ボタンのメソッドです。
     */
    public void btnCancel() {
        div.getShuruiShikyuGendogakuShosai().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().setSelectedIndex(ゼロ);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().clearFromValue();
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().clearToValue();
        div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuIchiran().setVisible(true);
        div.getShuruiShikyuGendogakuIchiran().setDisabled(false);
        div.getCcdKanryoMessage().setVisible(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(更新, true);
    }

    /**
     * 「追加する」ボタン押下による入力の場合のinsert追加メソッドです。
     *
     * @param shikyuGendoGakuList List<ServiceShuruiShikyuGendoGaku>
     * shikyuGendoGakuList
     */
    public void 追加する(List<ServiceShuruiShikyuGendoGaku> shikyuGendoGakuList) {
        if (div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().getValue() != null) {
            insert追加(KubunShikyuGendogakuYokaigoJotaiKubun.経過介護.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue() != null) {
            insert追加(KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue() != null) {
            insert追加(KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().getValue() != null) {
            insert追加(KubunShikyuGendogakuYokaigoJotaiKubun.要介護1.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().getValue() != null) {
            insert追加(KubunShikyuGendogakuYokaigoJotaiKubun.要介護2.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().getValue() != null) {
            insert追加(KubunShikyuGendogakuYokaigoJotaiKubun.要介護3.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().getValue() != null) {
            insert追加(KubunShikyuGendogakuYokaigoJotaiKubun.要介護4.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().getValue() != null) {
            insert追加(KubunShikyuGendogakuYokaigoJotaiKubun.要介護5.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().getValue());
        }
        insert追加修正(shikyuGendoGakuList, new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui()
                .getSelectedKey()));

    }

    /**
     * 「修正」ボタン押下による入力の場合のメソッドです。
     *
     * @param shikyuGendoGakuList List<ServiceShuruiShikyuGendoGaku>
     */
    public void update修正(List<ServiceShuruiShikyuGendoGaku> shikyuGendoGakuList) {
        if (div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().getValue() != null) {
            update修正する(shikyuGendoGakuList, KubunShikyuGendogakuYokaigoJotaiKubun.経過介護.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue() != null) {
            update修正する(shikyuGendoGakuList, KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue());
        } else {
            dgShikyuGendogaku_Row row = div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem();
            deleteEntity(shikyuGendoGakuList,
                    new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                    new ServiceShuruiCode(row.getServiceShuruiCode()),
                    KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード(), 1);
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue() != null) {
            update修正する(shikyuGendoGakuList, KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue());
        } else {
            dgShikyuGendogaku_Row row = div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem();
            deleteEntity(shikyuGendoGakuList,
                    new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                    new ServiceShuruiCode(row.getServiceShuruiCode()),
                    KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード(), 1);
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().getValue() != null) {
            update修正する(shikyuGendoGakuList, KubunShikyuGendogakuYokaigoJotaiKubun.要介護1.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().getValue() != null) {
            update修正する(shikyuGendoGakuList, KubunShikyuGendogakuYokaigoJotaiKubun.要介護2.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().getValue() != null) {
            update修正する(shikyuGendoGakuList, KubunShikyuGendogakuYokaigoJotaiKubun.要介護3.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().getValue() != null) {
            update修正する(shikyuGendoGakuList, KubunShikyuGendogakuYokaigoJotaiKubun.要介護4.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().getValue() != null) {
            update修正する(shikyuGendoGakuList, KubunShikyuGendogakuYokaigoJotaiKubun.要介護5.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().getValue());
        }
    }

    /**
     * 「削除」ボタン押下による入力の場合のメソッドです。
     *
     * @param shikyuGendoGakuList List<ServiceShuruiShikyuGendoGaku>
     */
    public void update削除(List<ServiceShuruiShikyuGendoGaku> shikyuGendoGakuList) {
        dgShikyuGendogaku_Row row = div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem();
        deleteEntity(shikyuGendoGakuList,
                new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                new ServiceShuruiCode(row.getServiceShuruiCode()),
                KubunShikyuGendogakuYokaigoJotaiKubun.経過介護.getコード(), 1);
        deleteEntity(shikyuGendoGakuList,
                new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                new ServiceShuruiCode(row.getServiceShuruiCode()),
                KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード(), 1);
        deleteEntity(shikyuGendoGakuList,
                new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                new ServiceShuruiCode(row.getServiceShuruiCode()),
                KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード(), 1);
        deleteEntity(shikyuGendoGakuList,
                new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                new ServiceShuruiCode(row.getServiceShuruiCode()),
                KubunShikyuGendogakuYokaigoJotaiKubun.要介護1.getコード(), 1);
        deleteEntity(shikyuGendoGakuList,
                new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                new ServiceShuruiCode(row.getServiceShuruiCode()),
                KubunShikyuGendogakuYokaigoJotaiKubun.要介護2.getコード(), 1);
        deleteEntity(shikyuGendoGakuList,
                new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                new ServiceShuruiCode(row.getServiceShuruiCode()),
                KubunShikyuGendogakuYokaigoJotaiKubun.要介護3.getコード(), 1);
        deleteEntity(shikyuGendoGakuList,
                new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                new ServiceShuruiCode(row.getServiceShuruiCode()),
                KubunShikyuGendogakuYokaigoJotaiKubun.要介護4.getコード(), 1);
        deleteEntity(shikyuGendoGakuList,
                new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                new ServiceShuruiCode(row.getServiceShuruiCode()),
                KubunShikyuGendogakuYokaigoJotaiKubun.要介護5.getコード(), 1);
        delete修正(shikyuGendoGakuList, new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui()
                .getSelectedKey()));
    }

    private void deleteEntity(List<ServiceShuruiShikyuGendoGaku> shikyuGendoGakuList,
            FlexibleYearMonth 適用開始年月, ServiceShuruiCode サービス種類コード, RString 要介護状態区分, int 履歴番号) {
        for (ServiceShuruiShikyuGendoGaku gendoGaku : shikyuGendoGakuList) {
            ServiceShuruiCode サービス種類コード2 = gendoGaku.getサービス種類コード();
            RString 要介護状態区分2 = gendoGaku.get要介護状態区分();
            FlexibleYearMonth 適用開始年月2 = gendoGaku.get適用開始年月();
            int 履歴番号2 = gendoGaku.get履歴番号();
            if (サービス種類コード2.equals(サービス種類コード)
                    && 要介護状態区分2.equals(要介護状態区分)
                    && 適用開始年月2.equals(適用開始年月)
                    && 履歴番号2 == 履歴番号) {
                ShuruiShikyuGendogakuMainFinder.createInstance().deleteEntity(gendoGaku.toEntity());
            }
        }
    }

    /**
     * 「保存する」ボタンのメソッドです。
     */
    public void btnSave() {
        div.getShuruiShikyuGendogakuIchiran().setVisible(false);
        div.getShuruiShikyuGendogakuShosai().setVisible(false);
        div.getCcdKanryoMessage().setVisible(true);
        div.getCcdKanryoMessage().setSuccessMessage(種類支給限度額登録完了);
        div.getCcdKanryoMessage().setReadOnly(true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(更新, false);
    }

    /**
     * 要支援1入力チェック警告のメソッドです。
     *
     * @return Boolean
     */
    public boolean is要支援1入力チェック警告() {
        FlexibleYearMonth 適用期間From = new FlexibleYearMonth(
                div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString());
        List<ShuruiShikyuGendogakuMainResult> result = ShuruiShikyuGendogakuMainFinder.createInstance().select介護サービス種類データ(
                new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()), 適用期間From);
        if (一.equals(result.get(0).getDbT7130entity().getShien1InKahiKubun())) {
            return (!result.isEmpty() && result.get(0).getDbT7130entity() != null
                    && (div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue() != null
                    || (div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue().compareTo(Decimal.ZERO) == 0)));
        } else {
            return false;
        }
    }

    /**
     * 要支援2入力チェック警告のメソッドです。
     *
     * @return Boolean
     */
    public boolean is要支援2入力チェック警告() {
        FlexibleYearMonth 適用期間From = new FlexibleYearMonth(
                div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString());
        List<ShuruiShikyuGendogakuMainResult> result = ShuruiShikyuGendogakuMainFinder.createInstance().select介護サービス種類データ(
                new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()), 適用期間From);
        if (一.equals(result.get(0).getDbT7130entity().getShien2InKahiKubun())) {
            return (!result.isEmpty() && result.get(0).getDbT7130entity() != null
                    && (div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue() != null
                    || (div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue().compareTo(Decimal.ZERO) == 0)));
        } else {
            return false;
        }
    }

    private void set初期化状態(List<ShuruiShikyuGendogakuMainResult> list) {
        List<dgShikyuGendogaku_Row> rowList = new ArrayList<>();
        for (ShuruiShikyuGendogakuMainResult entity : list) {
            dgShikyuGendogaku_Row row = new dgShikyuGendogaku_Row();
            row.setServiceShuruiCode(entity.getEntity().getサービス種類コード().value());
            row.setServiceShurui(ServiceCategoryShurui.toValue(entity.getEntity().getサービス種類コード().getColumnValue()).get略称());
            if (entity.getEntity().get適用開始年月() != null && !entity.getEntity().get適用開始年月().isEmpty()) {
                row.getTekiyoKaishiYM().setValue(new RDate(entity.getEntity().get適用開始年月().toString()));
            }
            if (entity.getEntity().get適用終了年月() != null && !entity.getEntity().get適用終了年月().isEmpty()) {
                row.getTekiyoShuryoYM().setValue(new RDate(entity.getEntity().get適用終了年月().toString()));
            }
            row.getKeikaKaigoShikyuGendogaku().setValue(entity.getEntity().get経過介護支給限度額());
            row.getYoshien1ShikyuGendogaku().setValue(entity.getEntity().get要支援１支給限度額());
            row.getYoshien2ShikyuGendogaku().setValue(entity.getEntity().get要支援2支給限度額());
            row.getYokaigo1ShikyuGendogaku().setValue(entity.getEntity().get要介護１支給限度額());
            row.getYokaigo2ShikyuGendogaku().setValue(entity.getEntity().get要介護２支給限度額());
            row.getYokaigo3ShikyuGendogaku().setValue(entity.getEntity().get要介護３支給限度額());
            row.getYokaigo4ShikyuGendogaku().setValue(entity.getEntity().get要介護４支給限度額());
            row.getYokaigo5ShikyuGendogaku().setValue(entity.getEntity().get要介護５支給限度額());
            rowList.add(row);
        }
        div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().setDataSource(rowList);
        for (dgShikyuGendogaku_Row row : div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getDataSource()) {
            if (row.getTekiyoShuryoYM().getValue() != null) {
                row.setDeleteButtonState(DataGridButtonState.Disabled);
            } else {
                row.setDeleteButtonState(DataGridButtonState.Enabled);
            }
        }
        div.getShuruiShikyuGendogakuIchiran().setVisible(true);
        div.getShuruiShikyuGendogakuIchiran().setDisabled(false);
        div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().setVisible(true);
        div.getShuruiShikyuGendogakuShosai().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().setVisible(true);
        div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().setSelectedIndex(ゼロ);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setFromDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().clearFromValue();
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().clearToValue();
        div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().clearValue();
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().clearValue();
        div.getCcdKanryoMessage().setVisible(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(更新, true);
    }

    private int insert追加(RString 要介護状態区分, Decimal 支給限度単位数) {
        return ShuruiShikyuGendogakuMainFinder.createInstance().insert追加(
                new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()),
                要介護状態区分,
                new FlexibleYearMonth(div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString()),
                1,
                FlexibleYearMonth.EMPTY,
                支給限度単位数);
    }

    private void insert追加修正(List<ServiceShuruiShikyuGendoGaku> shikyuGendoGakuList, ServiceShuruiCode サービス種類コード) {
        for (ServiceShuruiShikyuGendoGaku gendoGaku : shikyuGendoGakuList) {
            ServiceShuruiCode サービス種類コード2 = gendoGaku.getサービス種類コード();
            if (サービス種類コード2 != null && サービス種類コード2.equals(サービス種類コード)
                    && (gendoGaku.get適用終了年月() == null || gendoGaku.get適用終了年月().isEmpty())) {
                gendoGaku = gendoGaku.createBuilderForEdit().set適用終了年月(new FlexibleYearMonth(div.getShuruiShikyuGendogakuShosai()
                        .getTxtTekiyoKikanRange().getFromValue().minusMonth(1).getYearMonth().toDateString())).build();
                ShuruiShikyuGendogakuMainFinder.createInstance().saveEntity(gendoGaku.toEntity());
            }
        }
    }

    private void delete修正(List<ServiceShuruiShikyuGendoGaku> shikyuGendoGakuList, ServiceShuruiCode サービス種類コード) {
        for (ServiceShuruiShikyuGendoGaku gendoGaku : shikyuGendoGakuList) {
            ServiceShuruiCode サービス種類コード2 = gendoGaku.getサービス種類コード();
            if (サービス種類コード2 != null && サービス種類コード2.equals(サービス種類コード)
                    && gendoGaku.get適用終了年月() != null && gendoGaku.get適用終了年月().equals(
                            new FlexibleYearMonth(div.getShuruiShikyuGendogakuShosai()
                                    .getTxtTekiyoKikanRange().getFromValue().minusMonth(1).getYearMonth().toDateString()))) {
                gendoGaku = gendoGaku.createBuilderForEdit().set適用終了年月(FlexibleYearMonth.EMPTY).build();
                ShuruiShikyuGendogakuMainFinder.createInstance().saveEntity(gendoGaku.toEntity());
            }
        }
    }

    private void update修正する(List<ServiceShuruiShikyuGendoGaku> shikyuGendoGakuList, RString 要介護状態区分, Decimal 支給限度単位数) {

        int i = 0;
        for (ServiceShuruiShikyuGendoGaku gendoGaku : shikyuGendoGakuList) {
            ServiceShuruiCode サービス種類コード = gendoGaku.getサービス種類コード();
            RString 要介護状態区分2 = gendoGaku.get要介護状態区分();
            FlexibleYearMonth 適用開始年月 = gendoGaku.get適用開始年月();
            if (サービス種類コード.equals(new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()))
                    && 要介護状態区分2.equals(要介護状態区分)
                    && 適用開始年月.equals(new FlexibleYearMonth(div.getShuruiShikyuGendogakuShosai()
                                    .getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString()))) {
                gendoGaku = gendoGaku.createBuilderForEdit().set支給限度単位数(支給限度単位数).build();
                ShuruiShikyuGendogakuMainFinder.createInstance().saveEntity(gendoGaku.toEntity());
                i++;
            }
        }
        if (i == 0) {
            ShuruiShikyuGendogakuMainFinder.createInstance().saveNewEntity(
                    new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()),
                    要介護状態区分, new FlexibleYearMonth(
                            div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString()),
                    支給限度単位数);
        }
    }
}
