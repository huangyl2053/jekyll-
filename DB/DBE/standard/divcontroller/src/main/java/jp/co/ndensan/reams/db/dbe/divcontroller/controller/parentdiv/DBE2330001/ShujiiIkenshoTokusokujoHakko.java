/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2330001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.DBE233001_IkenshoTokusokujyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.shujiiikentokusokujohakko.ShujiiIkenTokusokujoHakkoTempData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2330001.ShujiiIkenshoTokusokujoHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2330001.ShujiiIkenTokusokujoHakkoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2330001.ShujiiIkenTokusokujoHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 主治医意見書督促状発行のコントローラです。
 *
 * @reamsid_L DBE-0060-010 zhangzhiming
 */
public class ShujiiIkenshoTokusokujoHakko {

    private static final RString RADIOBUTTONKEY1 = new RString("key1");

    /**
     * 初期化の設定します。
     *
     * @param div ShujiiIkenshoTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<ShujiiIkenshoTokusokujoHakkoDiv> onLoad(ShujiiIkenshoTokusokujoHakkoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 印刷書類区分の設定します。
     *
     * @param div ShujiiIkenshoTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<ShujiiIkenshoTokusokujoHakkoDiv> onChange_radChohyo(ShujiiIkenshoTokusokujoHakkoDiv div) {
        getHandler(div).onChange_radChohyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者onChangeの設定します。
     *
     * @param div ShujiiIkenshoTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<ShujiiIkenshoTokusokujoHakkoDiv> onChange_ccdHokenshaList(ShujiiIkenshoTokusokujoHakkoDiv div) {
        getHandler(div).changeHokensha();
        div.getCcdIryokikanShujii().initialize(div.getCcdHokenshaList().getSelectedItem().get市町村コード(),
                ShinseishoKanriNo.EMPTY, SubGyomuCode.DBE認定支援);
        return ResponseData.of(div).respond();
    }

    private ShujiiIkenTokusokujoHakkoHandler getHandler(ShujiiIkenshoTokusokujoHakkoDiv div) {
        return new ShujiiIkenTokusokujoHakkoHandler(div);
    }

    /**
     * 「発行する」ボタンをクリックの設定します。
     *
     * @param div ShujiiIkenshoTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<ShujiiIkenshoTokusokujoHakkoDiv> beforeHakkou(ShujiiIkenshoTokusokujoHakkoDiv div) {
        ValidationMessageControlPairs message
                = new ShujiiIkenTokusokujoHakkoValidationHandler(div).check_btnBatchRegisterHakko();

        if (message.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(message).respond();
        }

        RDate 開始日 = div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue() == null
                ? RDate.MIN : div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue();
        RDate 終了日 = div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue() == null
                ? RDate.MIN : div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue();
        if (終了日.isBefore(開始日)) {
            throw new ApplicationException(UrErrorMessages.終了日が開始日以前.getMessage());
        }
        if (RADIOBUTTONKEY1.equals(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey())
                && div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getChkInsatsuChohyo().getSelectedKeys().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace("主治医意見書督促状対象者一覧の印刷書類を"));
        }
        int 該当データ件数 = getHandler(div).該当データ件数取得(getHandler(div).getTempData());
        if (該当データ件数 > 0) {
            return ResponseData.of(div).respond();
        } else {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
    }

    /**
     * バッチパラメータの設定します。
     *
     * @param div ShujiiIkenshoTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<DBE233001_IkenshoTokusokujyoParameter> hakkou(ShujiiIkenshoTokusokujoHakkoDiv div) {
        DBE233001_IkenshoTokusokujyoParameter parameter = new DBE233001_IkenshoTokusokujyoParameter();
        ShujiiIkenTokusokujoHakkoTempData tempData = getHandler(div).getTempData();
        parameter.toDBE233001Parameter(tempData);
        return ResponseData.of(parameter).respond();
    }
}
