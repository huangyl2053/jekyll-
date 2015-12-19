/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBE5210001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 介護認定審査会開催結果登録するクラスです
 *
 */
public class ShinsakaiKaisaiKekka {

    private final ShinsakaiKaisaiYoteiJohoManager service;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKaisaiKekka() {
        service = ShinsakaiKaisaiYoteiJohoManager.createInstance();
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     *
     * @param div
     * @return
     */
    public ResponseData<ShinsakaiKaisaiKekkaDiv> onLoad(ShinsakaiKaisaiKekkaDiv div) {
        ResponseData<ShinsakaiKaisaiKekkaDiv> responseData = new ResponseData<>();
        getHandler(div).onLoad();
        List<ShinsakaiKaisaiYoteiJoho> list = service.get審査会委員一覧検索(null);
        getHandler(div).initialize(list);
        responseData.data = div;
        return responseData;
    }

    /**
     * 審査会委員一覧Gridの「削除」ボタンを押下 ＤＢ介護認定審査会割当委員情報」より物理削除する
     *
     * @param div
     * @return responseData
     */
    public ResponseData onClick_ShowDeleteButton(ShinsakaiKaisaiKekkaDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
//            boolean gera = new RString(DbzQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode());
//            ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes;
        }
        ResponseData<ShinsakaiKaisaiKekkaDiv> responseData = new ResponseData<>();
        //ShinsakaiOnseiJoho shinsakaiOnseiJoho = service.delete介護認定審査会割当委員情報(null);
        responseData.data = div;
        return responseData;
    }

    /**
     * 介護認定審査会音声情報更新処理。
     *
     * @param div ShinsakaiKaisaiKekkaDiv
     * @return ResponseData<ShinsakaiKaisaiKekkaDiv>
     */
    public ResponseData onClick_btnAddlin(ShinsakaiKaisaiKekkaDiv div) {
        ResponseData<ShinsakaiKaisaiKekkaDiv> responseData = new ResponseData<>();
        // ShinsakaiOnseiJoho shinsakaiOnseiJoho = service.inster介護認定審査会音声情報(null);
//        getHandler(div).onClick_btnAddlin();
        responseData.data = div;
        return responseData;
    }

    /**
     * 保存」ボタンを押下 介護認定審査会結果情報更新処理。
     *
     * @param div ShinsakaiKaisaiKekkaDiv
     * @return ResponseData<ShinsakaiKaisaiKekkaDiv>
     */
    public ResponseData onClick_btnUpdate(ShinsakaiKaisaiKekkaDiv div) {
        ResponseData<ShinsakaiKaisaiKekkaDiv> responseData = new ResponseData<>();
        List<dgShinsakaiIinIchiran_Row> row = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        boolean is全員遅刻 = true;
        boolean is全員早退 = true;
        for (dgShinsakaiIinIchiran_Row shinsakaiIinIchiran_Row : row) {
            dgShinsakaiIinIchiran_Row ShinsakaiIinIchiran_Row = new dgShinsakaiIinIchiran_Row();
            if (div.getTxtYoteiStartTime().getValue().isAfter(div.getTxtKaisaiEndTime().getValue())) {
                throw new ApplicationException(UrErrorMessages.期間が不正_追加メッセージあり２
                        .getMessage().replace(div.getTxtYoteiStartTime().getValue().toString(),
                                div.getTxtKaisaiEndTime().getValue().toString()));
            }
            if (div.getTxtKaisaiStartTime().getValue().isAfter(RTime.parse(shinsakaiIinIchiran_Row.getShussekiTime().toString()))
                    || div.getTxtKaisaiEndTime().getValue().isBefore(RTime.parse(shinsakaiIinIchiran_Row.getShussekiTime().toString()))) {
                throw new ApplicationException(UrErrorMessages.入力値が不正
                        .getMessage().replace("出席時間"));
            }
            if (div.getTxtKaisaiStartTime().getValue().isAfter(RTime.parse(shinsakaiIinIchiran_Row.getShussekiTime().toString()))
                    || div.getTxtKaisaiEndTime().getValue().isBefore(RTime.parse(shinsakaiIinIchiran_Row.getShussekiTime().toString()))) {
                throw new ApplicationException(UrErrorMessages.入力値が不正
                        .getMessage().replace("退席時"));
            }
            if (ShinsakaiIinIchiran_Row.getGichoKubun().getSelectedKey().equals(new RString("1"))
                    && ShinsakaiIinIchiran_Row.getShukketsuKubun().getSelectedKey().equals(new RString("false"))) {
                throw new ApplicationException(DbeErrorMessages.欠席の設定不可.getMessage()
                        .replace("議長"));
            }
            if (ShinsakaiIinIchiran_Row.getChikokuUmu().getSelectedKey().equals(new RString("false"))) {
                is全員遅刻 = false;
            }
            if (ShinsakaiIinIchiran_Row.getSotaiUmu().getSelectedKey().equals(new RString("false"))) {
                is全員早退 = false;
            }
        }
        if (is全員遅刻) {
            throw new ApplicationException(DbeWarningMessages.保存確認
                    .getMessage().replace("全員が遅刻"));
        }
        if (is全員早退) {
            throw new ApplicationException(DbeWarningMessages.保存確認
                    .getMessage().replace("全員が早退"));
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (div.getTxtKaisaiBi().getValue() == null) {
            boolean saiYoteiJoho = service.update介護認定審査会開催結果情報更新(null);
            getHandler(div).onClick_介護認定審査会開催結果情報();
//            ShinsakaiKaisaiYoteiJoho saiYoteiJoho = service.update介護認定審査会開催予定情報更新(null);
//            ShinsakaiKaisaiYoteiJoho saiYoteiJoho = service.update介護認定審査会割当委員情報更新(null);
            getHandler(div).onClick_介護認定審査会割当委員情報();
        }
        // ShinsakaiKaisaiYoteiJoho saiYoteiJoho = service.update介護認定審査会開催結果情報更新(null);
        getHandler(div).onClick_介護認定審査会開催結果情報();
        //ShinsakaiKaisaiYoteiJoho saiYoteiJoho = service.update介護認定審査会割当委員情報更新(null);
        getHandler(div).onClick_介護認定審査会割当委員情報();
        //RealInitialLocker.lock(new Loc kingKey(div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().get));
        //RealInitialLocker.release(new LockingKey(""));
        responseData.data = div;
        return responseData;
    }

    private ShinsakaiKaisaiKekkaHandler getHandler(ShinsakaiKaisaiKekkaDiv div) {
        return new ShinsakaiKaisaiKekkaHandler(div);
    }

}
