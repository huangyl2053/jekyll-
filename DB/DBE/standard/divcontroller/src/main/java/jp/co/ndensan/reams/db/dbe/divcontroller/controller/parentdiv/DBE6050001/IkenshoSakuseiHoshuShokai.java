/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6050001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601004.DBE601004_IkenshosakuseiHoshuParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshohoshushokai.IkenshoHoshuShokaiMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6050001.DBE6050001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6050001.IkenshoSakuseiHoshuShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6050001.IkenshoSakuseiHoshuShokaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6050001.IkenshoSakuseiHoshuShokaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshohoshushokai.IkenshoHoshuShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import static jp.co.ndensan.reams.uz.uza.definition.enumeratedtype.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 意見書作成報酬照会の処理詳細です。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public class IkenshoSakuseiHoshuShokai {

    private static final RString CSVを出力する = new RString("1");
    private static final RString 一覧表を発行する = new RString("2");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData&lt;IkenshoSakuseiHoshuShokaiDiv&gt;
     */
    public ResponseData<IkenshoSakuseiHoshuShokaiDiv> onLoad(IkenshoSakuseiHoshuShokaiDiv div) {
        div.getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
        getHandler(div).clear作成依頼日();
        getHandler(div).set初期最大取得件数();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData&lt;IkenshoSakuseiHoshuShokaiDiv&gt;
     */
    public ResponseData<IkenshoSakuseiHoshuShokaiDiv> onClick_BtnKensakuClear(IkenshoSakuseiHoshuShokaiDiv div) {
        div.getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
        getHandler(div).clear作成依頼日();
        getHandler(div).set初期最大取得件数();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData&lt;IkenshoSakuseiHoshuShokaiDiv&gt;
     */
    public ResponseData<IkenshoSakuseiHoshuShokaiDiv> onClick_BtnKensaku(IkenshoSakuseiHoshuShokaiDiv div) {
        // メッセージ処理
        RString fromCode = ResponseHolder.getMessageCode();
        if (fromCode.equals(IkenshoSakuseiHoshuShokaiMessages.データなし.getCode())) {
            return ResponseData.of(div).respond();
        }
        
        // 作成依頼開始＞作成依頼終了の場合、エラーとする
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate開始日終了日();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        FlexibleDate 作成依頼日開始 = FlexibleDate.EMPTY;
        FlexibleDate 作成依頼日終了 = FlexibleDate.EMPTY;
        if (div.getTxtSakuseiIraibi().getFromValue() != null) {
            作成依頼日開始 = new FlexibleDate(div.getTxtSakuseiIraibi().getFromValue().toDateString());
        }
        if (div.getTxtSakuseiIraibi().getToValue() != null) {
            作成依頼日終了 = new FlexibleDate(div.getTxtSakuseiIraibi().getToValue().toDateString());
        }
        
        // 検索条件に満たす最大件数を取得
        
        Decimal 最大表示件数 = div.getTxtMaxKensu().getValue();
        IkenshoHoshuShokaiMapperParameter paramter = IkenshoHoshuShokaiMapperParameter.createParameterForGetCount(
                作成依頼日開始, 
                作成依頼日終了, 
                div.getCcdHokensya().getSelectedItem().get市町村コード().value());
        IkenshoHoshuShokaiFinder finder = IkenshoHoshuShokaiFinder.createInstance();
        int 総件数 = finder.getCount(paramter);
        
        // 総件数が 0 件の場合はメッセージを表示
        if (総件数 == 0) {
            return ResponseData.of(div).addMessage(IkenshoSakuseiHoshuShokaiMessages.データなし.getMessage()).respond();
        }
        
        // データを取得
        
        paramter = IkenshoHoshuShokaiMapperParameter.createSelectBy情報(
                作成依頼日開始, 
                作成依頼日終了, 
                div.getCcdHokensya().getSelectedItem().get市町村コード().value(),
                最大表示件数);
        getHandler(div).set一覧結果(IkenshoHoshuShokaiFinder.createInstance().select合計額リスト(paramter).records(), 総件数);
        
        if (div.getDgIkenshoSakuseiHoshu().getDataSource().isEmpty()) {
            return ResponseData.of(div).setState(DBE6050001StateName.検索結果表示結果無し);
        }
        return ResponseData.of(div).setState(DBE6050001StateName.検索結果表示);
    }

    /**
     * 「条件に戻る」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData&lt;IkenshoSakuseiHoshuShokaiDiv&gt;
     */
    public ResponseData<IkenshoSakuseiHoshuShokaiDiv> onClick_BtnModoru(IkenshoSakuseiHoshuShokaiDiv div) {
        return ResponseData.of(div).setState(DBE6050001StateName.検索条件入力);
    }

    /**
     * データの必須選択チェックを実施します。
     *
     * @param div 画面情報
     * @return ResponseData&lt;IkenshoSakuseiHoshuShokaiDiv&gt;
     */
    public ResponseData<IkenshoSakuseiHoshuShokaiDiv> onClick_BatchButton(IkenshoSakuseiHoshuShokaiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForCheckedDataCount();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「CSVを出力する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData&lt;IkenHoshuIchiranBatchParameter&gt;
     */
    public ResponseData<DBE601004_IkenshosakuseiHoshuParameter> onClick_BtnShutsutyoku(IkenshoSakuseiHoshuShokaiDiv div) {
        DBE601004_IkenshosakuseiHoshuParameter parameter = getHandler(div).createBatchParam(CSVを出力する);
        return ResponseData.of(parameter).respond();
    }

    /**
     * 「一覧表を発行する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData&lt;IkenHoshuIchiranBatchParameter&gt;
     */
    public ResponseData<DBE601004_IkenshosakuseiHoshuParameter> onClick_BtnPulish(IkenshoSakuseiHoshuShokaiDiv div) {
        DBE601004_IkenshosakuseiHoshuParameter parameter = getHandler(div).createBatchParam(一覧表を発行する);
        return ResponseData.of(parameter).respond();
    }

    /**
     * 一覧グリッドのソートイベント処理メソッドです。
     *
     * @param div 画面情報
     * @return ResponseData&lt;IkenshoSakuseiHoshuShokaiDiv&gt;
     */
    public ResponseData<IkenshoSakuseiHoshuShokaiDiv> onSort_dgIkenshoSakuseiHoshu(IkenshoSakuseiHoshuShokaiDiv div) {
        getHandler(div).resetシーケンス番号();
        return ResponseData.of(div).respond();
    }

    private IkenshoSakuseiHoshuShokaiHandler getHandler(IkenshoSakuseiHoshuShokaiDiv div) {
        return new IkenshoSakuseiHoshuShokaiHandler(div);
    }

    private IkenshoSakuseiHoshuShokaiValidationHandler getValidationHandler(IkenshoSakuseiHoshuShokaiDiv div) {
        return new IkenshoSakuseiHoshuShokaiValidationHandler(div);
    }

    private static enum IkenshoSakuseiHoshuShokaiMessages implements IMessageGettable {

        データなし(1, "該当データが存在しません。");

        private final RString code;
        private final RString message;

        private IkenshoSakuseiHoshuShokaiMessages(int no, String message) {
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
