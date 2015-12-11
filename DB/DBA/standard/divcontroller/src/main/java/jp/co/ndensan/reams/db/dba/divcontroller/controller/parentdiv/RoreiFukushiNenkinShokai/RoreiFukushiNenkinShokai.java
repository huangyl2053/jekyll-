/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.RoreiFukushiNenkinShokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dba.divcontroentity.DbT7006DivControEntity;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.datagridRireki_Row;
import jp.co.ndensan.reams.db.dba.service.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoManagers;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 老齢福祉年金受給情報共有子Divです。
 */
public class RoreiFukushiNenkinShokai {

    private final RoreiFukushiNenkinJohoManagers service;
    private Code モード;
    DbT7006DivControEntity dbT7006DivContro;
    Code addflag;
    Code updateflag;

    /**
     * コンストラクタです。
     *
     */
    public RoreiFukushiNenkinShokai() {
        service = RoreiFukushiNenkinJohoManagers.createInstance();
        dbT7006DivContro = new DbT7006DivControEntity();
    }

    /**
     * 共通子DIVを初期化します.
     *
     * @param div
     * @return
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onLoad(RoreiFukushiNenkinShokaiDiv div) {

        dbT7006DivContro.setShikibetsuCode(new ShikibetsuCode("000001234567890"));
        RoreiFukushiNenkinJohoMapperParameter param = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(dbT7006DivContro.getShikibetsuCode(),
                FlexibleDate.EMPTY,
                HihokenshaNo.EMPTY,
                FlexibleDate.EMPTY);
        getHandler(div).set老齢福祉年金情報一覧表示グリッド(service.getRoreiFukushiNenkinJoho(param));
        return ResponseData.of(div).respond();
    }

    /**
     * 老齢福祉年金情報の登録処理です.
     *
     * @param div
     * @return
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> btnAdd(RoreiFukushiNenkinShokaiDiv div) {

        addflag = new Code("1");
        getHandler(div).set老齢福祉年金情報画面表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 老齢福祉年金情報の修正処理です.
     *
     * @param div
     * @return
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> btnUpdate(RoreiFukushiNenkinShokaiDiv div) {
        updateflag = new Code("2");
        div.getPanelRireki().setDisplayNone(true);
        div.getPanelInput().setDisplayNone(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 老齢福祉年金情報の削除処理です.
     *
     * @param div
     * @return
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> btnDelete(RoreiFukushiNenkinShokaiDiv div) {

        div.getPanelRireki().setDisplayNone(true);
        div.getPanelInput().setDisplayNone(false);
        div.getPanelInput().getTxtStartDate().setDisabled(true);
        div.getPanelInput().getTxtEndDate().setDisabled(true);

        return ResponseData.of(div).respond();
    }

    /**
     * 老齢福祉年金情報の取消処理です.
     *
     * @param div
     * @return
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> btnCancel(RoreiFukushiNenkinShokaiDiv div) {

        div.getPanelInput().getTxtStartDate().setDisabled(false);
        div.getPanelInput().getTxtEndDate().setDisabled(false);

        div.getPanelRireki().setDisplayNone(false);
        div.getPanelInput().setDisplayNone(true);
        div.getPanelInput().getTxtStartDate().clearValue();
        div.getPanelInput().getTxtEndDate().clearValue();
        return ResponseData.of(div).respond();
    }

    /**
     * 老齢福祉年金情報の保存処理です.
     *
     * @param div
     * @return
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> btnSave(RoreiFukushiNenkinShokaiDiv div) {

        dbT7006DivContro.setHihokenshaNo(new HihokenshaNo("19"));
        dbT7006DivContro.setShikibetsuCode(new ShikibetsuCode("000001234567890"));

        if ("1".equals(モード)) {

            List<datagridRireki_Row> list = div.getDatagridRireki().getDataSource();
            List<RoreiFukushiNenkinJohoMapperParameter> checkKikanParam = new ArrayList();
            for (datagridRireki_Row row : list) {
                RoreiFukushiNenkinJohoMapperParameter pa = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(
                        ShikibetsuCode.EMPTY,
                        new FlexibleDate(row.getStartDate()),
                        HihokenshaNo.EMPTY,
                        new FlexibleDate(row.getStartDate()));
                checkKikanParam.add(pa);
            }
            if (service.checkKikanJuku(checkKikanParam) == false) {
                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(new ValidationMessageControlPair(
                        DbzErrorMessages.期間が不正_追加メッセージあり２));
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();

            }

            RoreiFukushiNenkinJohoMapperParameter checkParam = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(dbT7006DivContro.getShikibetsuCode(),
                    new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toDateString()),
                    HihokenshaNo.EMPTY,
                    FlexibleDate.EMPTY);
            if (service.checkSameJukyuKaishibi(checkParam) != null) {
                throw new ApplicationException(UrErrorMessages.既に登録済.getMessage());
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())) {

            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                if ("1".equals(モード)) {
                    RoreiFukushiNenkinJohoMapperParameter addParam = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(dbT7006DivContro.getShikibetsuCode(),
                            new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toDateString()),
                            dbT7006DivContro.getHihokenshaNo(),
                            new FlexibleDate(div.getPanelInput().getTxtEndDate().getValue().toDateString()));
                    if (1 == service.regRoreiFukushiNenkinJoho(addParam)) {
                        return onLoad(div);
                    }
                }
                if ("2".equals(モード)) {
                    RoreiFukushiNenkinJohoMapperParameter updateParam = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(dbT7006DivContro.getShikibetsuCode(),
                            new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toDateString()),
                            HihokenshaNo.EMPTY,
                            new FlexibleDate(div.getPanelInput().getTxtEndDate().getValue().toDateString()));
                    if (1 == service.updRoreiFukushiNenkinJoho(updateParam)) {
                        return onLoad(div);
                    }
                }
                RoreiFukushiNenkinJohoMapperParameter deleteParam = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(dbT7006DivContro.getShikibetsuCode(),
                        new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toDateString()),
                        HihokenshaNo.EMPTY,
                        FlexibleDate.EMPTY);
                if (1 == service.delRoreiFukushiNenkinJoho(deleteParam)) {
                    return onLoad(div);
                }

            }

            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private RoreiFukushiNenkinShokaiHandler getHandler(RoreiFukushiNenkinShokaiDiv div) {
        return new RoreiFukushiNenkinShokaiHandler(div);
    }
}
