/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.RoreiFukushiNenkinShokai;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dba.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiHandler;
import jp.co.ndensan.reams.db.dba.service.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 老齢福祉年金受給情報共有子Divです。
 *
 */
public class RoreiFukushiNenkinShokai {

    private static final RString 追加 = new RString("追加");
    private static final RString 更新 = new RString("更新");
    private static final RString 削除 = new RString("削除");

    private final RoreiFukushiNenkinJukyushaManager service;

    /**
     * コンストラクタです。
     *
     */
    public RoreiFukushiNenkinShokai() {
        service = RoreiFukushiNenkinJukyushaManager.createInstance();
    }

    /**
     * 老齢福祉年金情報共通子DIVを初期化します。
     *
     * @param div 老齢福祉年金Div
     * @return ResponseData<RoreiFukushiNenkinShokaiDiv> 老齢福祉年金情報Div
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onLoad(RoreiFukushiNenkinShokaiDiv div) {
        div.setHihokenshaNo(new RString("12"));
        div.setShikibetsuCode(new RString("123456789000001"));
        RoreiFukushiNenkinJohoMapperParameter param = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(
                new ShikibetsuCode(div.getShikibetsuCode()), FlexibleDate.EMPTY, HihokenshaNo.EMPTY, FlexibleDate.EMPTY);
        List<RoreiFukushiNenkinJukyusha> 一覧情報 = service.getRoreiFukushiNenkinJoho(param);
        getHandler(div).set老齢福祉年金情報一覧表示グリッド(一覧情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 老齢福祉年金情報の「情報を追加する」ボタン処理です。
     *
     * @param div 老齢福祉年金Div
     * @return ResponseData<RoreiFukushiNenkinShokaiDiv> 老齢福祉年金情報Div
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onClick_btnAdd(RoreiFukushiNenkinShokaiDiv div) {
        div.setModel(追加);
        getHandler(div).set老齢福祉年金追加ボタン画面表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 老齢福祉年金情報の「修正」ボタン処理です。
     *
     * @param div 老齢福祉年金情報Div
     * @return ResponseData<RoreiFukushiNenkinShokaiDiv> 老齢福祉年金情報Div
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onChange_btnUpdate(RoreiFukushiNenkinShokaiDiv div) {
        div.setModel(更新);
        getHandler(div).set老齢福祉年金修正ボタン画面表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 老齢福祉年金情報の「削除」ボタン処理です。
     *
     * @param div 老齢福祉年金情報Div
     * @return ResponseData<RoreiFukushiNenkinShokaiDiv> 老齢福祉年金情報Div
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onClick_btnDelete(RoreiFukushiNenkinShokaiDiv div) {
        div.setModel(削除);
        getHandler(div).set老齢福祉年金削除ボタン画面表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 老齢福祉年金情報の「入力を取消」ボタンです。
     *
     * @param div 老齢福祉年金情報Div
     * @return ResponseData<RoreiFukushiNenkinShokaiDiv> 老齢福祉年金情報Div
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onClick_btnCancel(RoreiFukushiNenkinShokaiDiv div) {
        getHandler(div).set老齢福祉年金取消ボタン画面表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 老齢福祉年金情報の「保存する」ボタン処理です。
     *
     * @param div 老齢福祉年金情報Div
     * @return ResponseData<RoreiFukushiNenkinShokaiDiv> 老齢福祉年金情報Div
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onClick_btnSave(RoreiFukushiNenkinShokaiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (追加.equals(div.getModel())) {
                get老齢福祉年金追加チェック(div);
            }
            getHandler(div).set老齢福祉年金入力チェック();
            onClick_はい(div);
        }

        return ResponseData.of(div).respond();
    }

    private RoreiFukushiNenkinShokaiHandler getHandler(RoreiFukushiNenkinShokaiDiv div) {
        return new RoreiFukushiNenkinShokaiHandler(div);
    }

    private ResponseData<RoreiFukushiNenkinShokaiDiv> onClick_はい(RoreiFukushiNenkinShokaiDiv div) {
        if (追加.equals(div.getModel())) {
            RoreiFukushiNenkinJukyusha busiRoreiFukushiNenkin = new RoreiFukushiNenkinJukyusha(
                    new ShikibetsuCode(div.getShikibetsuCode()),
                    new FlexibleDate(div.getTxtStartDate().getValue().toDateString()));
            busiRoreiFukushiNenkin = getHandler(div).set年金保存ボタン押下の追加(busiRoreiFukushiNenkin);
            if (service.save老齢福祉年金受給者(busiRoreiFukushiNenkin)) {
                return onLoad(div);
            }
        }
        if (更新.equals(div.getModel())) {
            RoreiFukushiNenkinJukyusha busiRoreiFukushiNenkin = getHandler(div).set老齢福祉年金保存ボタン押下の更新処理();
            if (service.save老齢福祉年金受給者(busiRoreiFukushiNenkin)) {
                return onLoad(div);
            }
        }
        if (削除.equals(div.getModel())) {
            RoreiFukushiNenkinJukyusha busiRoreiFukushiNenkin = getHandler(div).set老齢福祉年金保存ボタン押下の削除処理();
            if (service.save老齢福祉年金受給者(busiRoreiFukushiNenkin)) {
                return onLoad(div);
            }
        }
        return onLoad(div);
    }

    private void get老齢福祉年金追加チェック(RoreiFukushiNenkinShokaiDiv div) {
        RoreiFukushiNenkinJohoMapperParameter addCheck = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(
                new ShikibetsuCode(div.getShikibetsuCode()),
                new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toDateString()),
                HihokenshaNo.EMPTY,
                FlexibleDate.EMPTY);
        if (service.checkSameJukyuKaishibi(addCheck) > 0) {
            throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace("受給開始年月日"));
        }
    }
}
