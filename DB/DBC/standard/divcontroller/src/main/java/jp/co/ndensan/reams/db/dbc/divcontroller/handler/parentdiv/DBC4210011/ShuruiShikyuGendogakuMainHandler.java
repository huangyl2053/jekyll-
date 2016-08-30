/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4210011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku.KubunShikyuGendogakuYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainListParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.ShuruiShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.dgShikyuGendogaku_Row;
import jp.co.ndensan.reams.db.dbc.service.core.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
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
    private static final LockingKey 前排他ロックキー = new LockingKey("DBCShikyuGendoGakuTableDbT7111");
    private static final RString 種類支給限度額登録完了 = new RString("種類支給限度額の登録が完了しました。");

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
     */
    public void initialize() {

        List<ShuruiShikyuGendogakuMainResult> list = ShuruiShikyuGendogakuMainFinder.createInstance().get種類支給限度額();
        if (!get前排他(前排他ロックキー)) {
            div.getShuruiShikyuGendogakuIchiran().setDisabled(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        } else {
            set初期化状態(list);
        }
    }

    /**
     * btnContinueのメッソドです。
     *
     * @throws ApplicationException
     */
    public void btnContinue() {
        List<ShuruiShikyuGendogakuMainResult> list = ShuruiShikyuGendogakuMainFinder.createInstance().get種類支給限度額();
        set初期化状態(list);
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
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnUpdate"), true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
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
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnUpdate"), true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
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
        if (yoshien1ShikyuGendogaku.equals(Decimal.ZERO)) {
            div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().clearValue();
        } else {
            div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().setValue(yoshien1ShikyuGendogaku);
        }
        div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setDisabled(true);
        Decimal yoshien2ShikyuGendogaku = div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku()
                .getClickedItem().getYoshien2ShikyuGendogaku().getValue();
        if (yoshien2ShikyuGendogaku.equals(Decimal.ZERO)) {
            div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().clearValue();
        } else {
            div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().setValue(yoshien2ShikyuGendogaku);
        }
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo1ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo2ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo3ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo4ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().setValue(
                div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getClickedItem().getYokaigo5ShikyuGendogaku().getValue());
        div.getShuruiShikyuGendogakuShosai().getBtnCancel().setDisabled(true);
        div.getCcdKanryoMessage().setVisible(true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnUpdate"), true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
    }

    /**
     * 「入力を破棄する」ボタンのメソッドです。
     */
    public void btnCancel() {
        div.getShuruiShikyuGendogakuShosai().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().setDisabled(true);
        div.getShuruiShikyuGendogakuShosai().setDdlServiceShurui(null);
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
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), true);
    }

    /**
     * 「追加する」ボタン押下による入力の場合のinsert追加メソッドです。
     */
    public void 追加する() {
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
        insert追加修正(new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui()
                .getSelectedKey()), FlexibleYearMonth.EMPTY);

    }

    /**
     * 「修正」ボタン押下による入力の場合のメソッドです。
     */
    public void update修正() {
        if (div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().getValue() != null) {
            update修正する(KubunShikyuGendogakuYokaigoJotaiKubun.経過介護.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtKeikaKaigoShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue() != null) {
            update修正する(KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYoshien1ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue() != null) {
            update修正する(KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYoshien2ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().getValue() != null) {
            update修正する(KubunShikyuGendogakuYokaigoJotaiKubun.要介護1.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo1ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().getValue() != null) {
            update修正する(KubunShikyuGendogakuYokaigoJotaiKubun.要介護2.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo2ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().getValue() != null) {
            update修正する(KubunShikyuGendogakuYokaigoJotaiKubun.要介護3.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo3ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().getValue() != null) {
            update修正する(KubunShikyuGendogakuYokaigoJotaiKubun.要介護4.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo4ShikyuGendogaku().getValue());
        }
        if (div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().getValue() != null) {
            update修正する(KubunShikyuGendogakuYokaigoJotaiKubun.要介護5.getコード(),
                    div.getShuruiShikyuGendogakuShosai().getTxtYokaigo5ShikyuGendogaku().getValue());
        }
    }

    /**
     * 「削除」ボタン押下による入力の場合のメソッドです。
     */
    public void update削除() {
        List<dgShikyuGendogaku_Row> bowList = div.getShuruiShikyuGendogakuIchiran().getDgShikyuGendogaku().getSelectedItems();
        for (dgShikyuGendogaku_Row row : bowList) {
            ShuruiShikyuGendogakuMainListParameter parameter1 = new ShuruiShikyuGendogakuMainListParameter(
                    new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                    new ServiceShuruiCode(row.getServiceShuruiCode()),
                    KubunShikyuGendogakuYokaigoJotaiKubun.経過介護.getコード(), 1);
            ShuruiShikyuGendogakuMainListParameter parameter2 = new ShuruiShikyuGendogakuMainListParameter(
                    new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                    new ServiceShuruiCode(row.getServiceShuruiCode()),
                    KubunShikyuGendogakuYokaigoJotaiKubun.要支援1.getコード(), 1);
            ShuruiShikyuGendogakuMainListParameter parameter3 = new ShuruiShikyuGendogakuMainListParameter(
                    new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                    new ServiceShuruiCode(row.getServiceShuruiCode()),
                    KubunShikyuGendogakuYokaigoJotaiKubun.要支援2.getコード(), 1);
            ShuruiShikyuGendogakuMainListParameter parameter4 = new ShuruiShikyuGendogakuMainListParameter(
                    new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                    new ServiceShuruiCode(row.getServiceShuruiCode()),
                    KubunShikyuGendogakuYokaigoJotaiKubun.要介護1.getコード(), 1);
            ShuruiShikyuGendogakuMainListParameter parameter5 = new ShuruiShikyuGendogakuMainListParameter(
                    new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                    new ServiceShuruiCode(row.getServiceShuruiCode()),
                    KubunShikyuGendogakuYokaigoJotaiKubun.要介護2.getコード(), 1);
            ShuruiShikyuGendogakuMainListParameter parameter6 = new ShuruiShikyuGendogakuMainListParameter(
                    new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                    new ServiceShuruiCode(row.getServiceShuruiCode()),
                    KubunShikyuGendogakuYokaigoJotaiKubun.要介護3.getコード(), 1);
            ShuruiShikyuGendogakuMainListParameter parameter7 = new ShuruiShikyuGendogakuMainListParameter(
                    new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                    new ServiceShuruiCode(row.getServiceShuruiCode()),
                    KubunShikyuGendogakuYokaigoJotaiKubun.要介護4.getコード(), 1);
            ShuruiShikyuGendogakuMainListParameter parameter8 = new ShuruiShikyuGendogakuMainListParameter(
                    new FlexibleYearMonth(row.getTekiyoKaishiYM().getValue().getYearMonth().toDateString()),
                    new ServiceShuruiCode(row.getServiceShuruiCode()),
                    KubunShikyuGendogakuYokaigoJotaiKubun.要介護5.getコード(), 1);
            ShuruiShikyuGendogakuMainFinder.createInstance().deleteEntity(parameter1);
            ShuruiShikyuGendogakuMainFinder.createInstance().deleteEntity(parameter2);
            ShuruiShikyuGendogakuMainFinder.createInstance().deleteEntity(parameter3);
            ShuruiShikyuGendogakuMainFinder.createInstance().deleteEntity(parameter4);
            ShuruiShikyuGendogakuMainFinder.createInstance().deleteEntity(parameter5);
            ShuruiShikyuGendogakuMainFinder.createInstance().deleteEntity(parameter6);
            ShuruiShikyuGendogakuMainFinder.createInstance().deleteEntity(parameter7);
            ShuruiShikyuGendogakuMainFinder.createInstance().deleteEntity(parameter8);
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
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnUpdate"), false);
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
        if ((new RString("1")).equals(result.get(0).getDbT7130entity().getShien1InKahiKubun())) {
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
        if ((new RString("1")).equals(result.get(0).getDbT7130entity().getShien2InKahiKubun())) {
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
            row.setServiceShurui(ServiceCategoryShurui.toValue(entity.getEntity().getサービス種類コード().getColumnValue()).get名称());
            row.getTekiyoKaishiYM().setValue(new RDate(entity.getEntity().get適用開始年月().toString()));
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
            if (row.getTekiyoShuryoYM().toString().isEmpty()) {
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
        div.getShuruiShikyuGendogakuShosai().setDdlServiceShurui(null);
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
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), true);
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

    private void insert追加修正(ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用終了年月) {
        List<ShuruiShikyuGendogakuMainResult> list
                = ShuruiShikyuGendogakuMainFinder.createInstance().selectByPama(サービス種類コード, 適用終了年月);
        for (ShuruiShikyuGendogakuMainResult entity : list) {
            entity.getDbT7111entity().setTekiyoShuryoYM(new FlexibleYearMonth(
                    div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue().minusMonth(1).getYearMonth().toDateString()));
            ShuruiShikyuGendogakuMainFinder.createInstance().insert追加(
                    entity.getDbT7111entity().getServiceShuruiCode(),
                    entity.getDbT7111entity().getYoKaigoJotaiKubun(),
                    entity.getDbT7111entity().getTekiyoKaishiYM(),
                    entity.getDbT7111entity().getRirekiNo(),
                    entity.getDbT7111entity().getTekiyoShuryoYM(),
                    entity.getDbT7111entity().getShikyuGendoTaniSu());
        }
    }

    private void update修正する(RString 要介護状態区分, Decimal 支給限度単位数) {
        ShuruiShikyuGendogakuMainResult result
                = ShuruiShikyuGendogakuMainFinder.createInstance().selectByKey(
                        new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()),
                        要介護状態区分,
                        new FlexibleYearMonth(div.getShuruiShikyuGendogakuShosai()
                                .getTxtTekiyoKikanRange().getFromValue().getYearMonth().toDateString()));
        if (result != null && result.getDbT7111entity() != null) {
            result.getDbT7111entity().setShikyuGendoTaniSu(支給限度単位数);
            ShuruiShikyuGendogakuMainFinder.createInstance().saveEntity(result.getDbT7111entity());
        } else {
            ShuruiShikyuGendogakuMainFinder.createInstance().saveEntitys(
                    new ServiceShuruiCode(div.getShuruiShikyuGendogakuShosai().getDdlServiceShurui().getSelectedKey()),
                    要介護状態区分,
                    new FlexibleYearMonth(div.getShuruiShikyuGendogakuShosai().getTxtTekiyoKikanRange()
                            .getFromValue().getYearMonth().toDateString()),
                    支給限度単位数);
        }
    }

    private boolean get前排他(LockingKey 前排他ロックキー) {
        return RealInitialLocker.tryGetLock(前排他ロックキー);
    }
}
