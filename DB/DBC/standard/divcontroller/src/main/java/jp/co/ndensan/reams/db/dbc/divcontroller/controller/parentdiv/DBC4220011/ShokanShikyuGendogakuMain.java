/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4220011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseShokanShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.shokanshuruishikyugendogaku.ShokanShuruiShikyuGendoGakuData;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku.ShikyuGendogakuTableKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.DBC4220011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.ShokanShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.dgShikyuGendogaku_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4220011.ShokanShikyuGendogakuMainHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.ShokanShuruiShikyuGendoGakuManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.UwanoseShokanShuruiShikyuGendoGakuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 償還支給限度額登録のクラスです。
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public class ShokanShikyuGendogakuMain {

    private static final RString 排他キー = new RString("DBCShikyuGendoGakuTableDbT7112");
    private static final RString 完了メッセージメイン = new RString("償還支給限度額の登録が完了しました。");
    private static final RString 省略_空 = new RString("");
    private static final int INDEX_0 = 0;
    private static final RString INDEX_1 = new RString("1");

    /**
     * 画面初期化のonLoadメソッドです。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onLoad(ShokanShikyuGendogakuMainDiv div) {
        ShokanShuruiShikyuGendoGakuManager 償還manager = new ShokanShuruiShikyuGendoGakuManager();
        List<ShokanShuruiShikyuGendoGaku> 償還list = 償還manager.get償還払い給付種類支給限度額データ();
        UwanoseShokanShuruiShikyuGendoGakuManager 上乗せ償還manager = new UwanoseShokanShuruiShikyuGendoGakuManager();
        List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還list = 上乗せ償還manager.get上乗せ償還払い給付種類支給限度額データ();
        ShokanShikyuGendogakuMainHandler handler = getHandler(div);
        List<ShokanShuruiShikyuGendoGakuData> entityList = handler.initializeDisplay(償還list, 上乗せ償還list);

        div.getShokanShikyuGendogakuIchiran().setDisabled(true);

        LockingKey key = new LockingKey(排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }

        if (entityList != null) {
            handler.状態１(entityList);
        }
        return ResponseData.of(div).setState(DBC4220011StateName.標準);
    }

    /**
     * 「追加する」ボタン押下の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onClick_btnAdd(ShokanShikyuGendogakuMainDiv div) {
        ShokanShikyuGendogakuMainHandler handler = getHandler(div);
        handler.状態５();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧の「修正」が選択状態の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onClick_btnModify(ShokanShikyuGendogakuMainDiv div) {
        ShokanShikyuGendogakuMainHandler handler = getHandler(div);
        handler.状態３();
        return ResponseData.of(div).setState(DBC4220011StateName.標準);
    }

    /**
     * 一覧の「削除」が選択状態の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onClick_btnDelete(ShokanShikyuGendogakuMainDiv div) {
        ShokanShikyuGendogakuMainHandler handler = getHandler(div);
        handler.状態４();
        return ResponseData.of(div).respond();
    }

    /**
     * 「入力を破棄する」ボタンクリック時の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onClick_btnCancel(ShokanShikyuGendogakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            ShokanShikyuGendogakuMainHandler handler = getHandler(div);
            handler.状態１画面制御();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンクリック時の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onClick_btnUpdate(ShokanShikyuGendogakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).respond();
        }
        ShokanShikyuGendogakuMainHandler handler = getHandler(div);
        // 「追加する」ボタン押下による入力の場合
        if (!(div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().isFromDisabled()
                || div.getBtnCancel().isDisabled())) {
            RString 入力テーブル区分 = div.getShokanShikyuGendogakuShosai().getRadTableKubun().getSelectedValue();
            RDate 入力適用期間From = div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().getFromValue();
            List<dgShikyuGendogaku_Row> rowList = div.getShokanShikyuGendogakuIchiran().getDgShikyuGendogaku().getDataSource();
            for (dgShikyuGendogaku_Row row : rowList) {
                if (入力テーブル区分.equalsIgnoreCase(row.getTableKubun())
                        && INDEX_1.equalsIgnoreCase(row.getHdnSaishinFlag())
                        && 入力適用期間From.compareTo(row.getTekiyoKaishiYM().getValue()) <= INDEX_0) {
                    throw new ApplicationException(
                            DbcErrorMessages.適用期間_重複_開始年月不正.getMessage());
                }
                if (ShikyuGendogakuTableKubun.上乗せ後.get名称().equalsIgnoreCase(入力テーブル区分)
                        && ShikyuGendogakuTableKubun.標準.get名称().equalsIgnoreCase(row.getTableKubun())
                        && INDEX_1.equalsIgnoreCase(row.getHdnSaishinFlag())
                        && 入力適用期間From.compareTo(row.getTekiyoKaishiYM().getValue()) < INDEX_0) {
                    throw new ApplicationException(
                            DbcErrorMessages.適用期間_標準額と不一致.getMessage());
                }
            }
            handler.insertAndUpdate();
        }
        // 「修正」ボタン押下による入力の場合
        if (div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().isFromDisabled()
                && !div.getBtnCancel().isDisabled()) {
            handler.update();
        }
        // 「削除」ボタン押下による入力の場合
        if (div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().isFromDisabled()
                && div.getBtnCancel().isDisabled()) {
            handler.deleteAndUpdate();
        }
        div.getCcdKanryoMessage().setMessage(完了メッセージメイン, 省略_空, 省略_空, true);
        LockingKey key = new LockingKey(排他キー);
        RealInitialLocker.release(key);
        return ResponseData.of(div).setState(DBC4220011StateName.保存完了);
    }

    /**
     * 支給限度額テーブル区分onChangeの事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onChange_Kubun(ShokanShikyuGendogakuMainDiv div) {
        if (ShikyuGendogakuTableKubun.標準.get名称().equals(
                div.getShokanShikyuGendogakuShosai().getRadTableKubun().getSelectedValue())) {
            div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().clearToValue();
            div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        }
        if (ShikyuGendogakuTableKubun.上乗せ後.get名称().equals(
                div.getShokanShikyuGendogakuShosai().getRadTableKubun().getSelectedValue())) {
            div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    private ShokanShikyuGendogakuMainHandler getHandler(ShokanShikyuGendogakuMainDiv div) {
        return ShokanShikyuGendogakuMainHandler.of(div);
    }
}
