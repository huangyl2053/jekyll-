/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6040001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahoshuichiran.ShinsaHoshuIchiran;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601006.DBE601006_ShinsakaiiinHoshuParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsahoshuichiran.ShinsaHoshuIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6040001.DBE6040001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6040001.ShinsakauIinHoshuShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6040001.ShinsakauIinHoshuShokaiHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsahoshushokai.ShinsakauIinHoshuShokaiFindler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import static jp.co.ndensan.reams.uz.uza.definition.enumeratedtype.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 審査会委員報酬照会の画面処理クラスです。
 *
 * @reamsid_L DBE-1920-010 zhaoyao
 */
public class ShinsakauIinHoshuShokai {

    private static final RString CSVを出力する = new RString("1");
    private static final RString 一覧表を発行する = new RString("2");

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData&lt;ShinsakauIinHoshuShokaiDiv&gt;
     */
    public ResponseData<ShinsakauIinHoshuShokaiDiv> onLoad(ShinsakauIinHoshuShokaiDiv div) {
        div.getShinsakaiKaisaibi().getTxtShinsakaiKaisaiYM().clearValue();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件に戻る」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData&lt;ShinsakauIinHoshuShokaiDiv&gt;
     */
    public ResponseData<ShinsakauIinHoshuShokaiDiv> onClick_btnBackToKensaku(ShinsakauIinHoshuShokaiDiv div) {
        return ResponseData.of(div).setState(DBE6040001StateName.検索条件入力);
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData&lt;ShinsakauIinHoshuShokaiDiv&gt;
     */
    public ResponseData<ShinsakauIinHoshuShokaiDiv> onClick_BtnKensaku(ShinsakauIinHoshuShokaiDiv div) {
        // メッセージ処理
        RString fromCode = ResponseHolder.getMessageCode();
        if (fromCode.equals(ShinsakauIinHoshuShokaiMessages.データなし.getCode())) {
            return ResponseData.of(div).respond();
        }
        
        ShinsaHoshuIchiranMybitisParamter paramter = ShinsaHoshuIchiranMybitisParamter.createParamter(
                new RString(div.getShinsakaiKaisaibi().getTxtShinsakaiKaisaiYM().getValue().getYearMonth().toString()));

        List<ShinsaHoshuIchiran> ihinsaHoshuIchiranList = ShinsakauIinHoshuShokaiFindler.createInstance().get審査会委員報酬照会(paramter).records();
        if (ihinsaHoshuIchiranList.isEmpty()) {
            return ResponseData.of(div).addMessage(ShinsakauIinHoshuShokaiMessages.データなし.getMessage()).respond();
        }
        
        getHandler(div).onClick_BtnKensaku(ihinsaHoshuIchiranList);

        if (div.getDgShinsakaiIinHoshu().getDataSource().isEmpty()) {
            return ResponseData.of(div).setState(DBE6040001StateName.一覧表示結果無し);
        }
        return ResponseData.of(div).setState(DBE6040001StateName.一覧表示);
    }

    /**
     * 「CSVを出力する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseDatalt;ShinsaHoshuIchiranBatchParameter&gt;
     */
    public ResponseData<DBE601006_ShinsakaiiinHoshuParameter> onClick_BtnShutsutyoku(ShinsakauIinHoshuShokaiDiv div) {
        DBE601006_ShinsakaiiinHoshuParameter paramter = getHandler(div).createBatchParam(CSVを出力する);
        return ResponseData.of(paramter).respond();
    }

    /**
     * 「集計表を発行する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseDatalt;ShinsaHoshuIchiranBatchParameter&gt;
     */
    public ResponseData<DBE601006_ShinsakaiiinHoshuParameter> onClick_BtnPulish(ShinsakauIinHoshuShokaiDiv div) {
        DBE601006_ShinsakaiiinHoshuParameter paramter = getHandler(div).createBatchParam(一覧表を発行する);
        return ResponseData.of(paramter).respond();
    }

    /**
     * 一覧グリッドのソートイベント処理メソッドです。
     *
     * @param div 画面情報
     * @return ResponseData&lt;ShinsakauIinHoshuShokaiDiv&gt;
     */
    public ResponseData<ShinsakauIinHoshuShokaiDiv> onSort_dgShinsakaiIinHoshu(ShinsakauIinHoshuShokaiDiv div) {
        getHandler(div).resetシーケンス番号();
        return ResponseData.of(div).respond();
    }

    /**
     * ShinsakauIinHoshuShokaiHandlerの取得する。
     *
     * @param div
     * @return ShinsakauIinHoshuShokaiHandler
     */
    private ShinsakauIinHoshuShokaiHandler getHandler(ShinsakauIinHoshuShokaiDiv div) {
        return new ShinsakauIinHoshuShokaiHandler(div);
    }

    private static enum ShinsakauIinHoshuShokaiMessages implements IMessageGettable {

        データなし(1, "該当データが存在しません。");

        private final RString code;
        private final RString message;

        private ShinsakauIinHoshuShokaiMessages(int no, String message) {
            this.code = new RString(toCode("I", no));
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new InformationMessage(this.code.toString(), this.message.toString());
        }

        public RString getCode() {
            return this.code;
        }

    }
}
