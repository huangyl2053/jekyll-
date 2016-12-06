package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KaigoNinteiShinseiKihonJohoInput;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputHandler;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 * 介護認定申請基本情報の入力用クラス。
 *
 * @reamsid_L DBZ-1300-070 wangxiaodong
 */
public class KaigoNinteiShinseiKihonJohoInput {

    private static final RString サービス削除の旨 = new RString("1010");
    private static final RString 認定申請理由 = new RString("1001");

    /**
     * 画面項目の初期化を行します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoNinteiShinseiKihonJohoInputDiv>
     */
    public ResponseData<KaigoNinteiShinseiKihonJohoInputDiv> onLoad(KaigoNinteiShinseiKihonJohoInputDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ用引数を設定します。
     *
     * @param div 介護認定申請基本情報の入力用DIV
     * @return ResponseData
     */
    public ResponseData onBeforeOpenDialog_btnServiceSakujoTeikeibun(KaigoNinteiShinseiKihonJohoInputDiv div) {
        ResponseData<KaigoNinteiShinseiKihonJohoInputDiv> response = new ResponseData<>();
        div.setHdnSubGyomuCode(ControlDataHolder.getGyomuCD().value());
        div.setHdnServiceSakujoTeikeibunKey(サービス削除の旨);
        response.data = div;
        return response;
    }

    /**
     * ダイアログ上で選択したサービス削除の旨定型文情報を取得します。
     *
     * @param div 介護認定申請基本情報の入力用DIV
     * @return ResponseData
     */
    public ResponseData onOkClose_btnServiceSakujoTeikeibun(KaigoNinteiShinseiKihonJohoInputDiv div) {
        ResponseData<KaigoNinteiShinseiKihonJohoInputDiv> response = new ResponseData<>();

        RStringBuilder serviceSakujo = new RStringBuilder(div.getTxtServiceSakujo().getValue() == null
                ? RString.EMPTY : div.getTxtServiceSakujo().getValue());
        serviceSakujo.append(div.getHdnServiceSakujoTeikeibun());
        div.getTxtServiceSakujo().setValue(serviceSakujo.toRString());

        response.data = div;
        return response;
    }

    /**
     * ダイアログ用引数を設定します。
     *
     * @param div 介護認定申請基本情報の入力用DIV
     * @return ResponseData
     */
    public ResponseData onBeforeOpenDialog_btnNinteiShinseiRiyuTeikeibun(KaigoNinteiShinseiKihonJohoInputDiv div) {
        ResponseData<KaigoNinteiShinseiKihonJohoInputDiv> response = new ResponseData<>();
        div.setHdnSubGyomuCode(ControlDataHolder.getGyomuCD().value());
        div.setHdnNinteiRiyuTeikeibunKey(認定申請理由);
        response.data = div;
        return response;
    }

    /**
     * ダイアログ上で選択した認定申請理由定型文情報を取得します。
     *
     * @param div 介護認定申請基本情報の入力用DIV
     * @return ResponseData
     */
    public ResponseData onOkClose_btnNinteiShinseiRiyuTeikeibun(KaigoNinteiShinseiKihonJohoInputDiv div) {
        ResponseData<KaigoNinteiShinseiKihonJohoInputDiv> response = new ResponseData<>();

        RStringBuilder ninteidShinseiRiyu = new RStringBuilder(div.getTxtNinteiShinseRiyu().getValue() == null
                ? RString.EMPTY : div.getTxtNinteiShinseRiyu().getValue());
        ninteidShinseiRiyu.append(div.getHdnNinteiRiyuTeikeibun());
        div.getTxtNinteiShinseRiyu().setValue(ninteidShinseiRiyu.toRString());

        response.data = div;
        return response;
    }

    private KaigoNinteiShinseiKihonJohoInputHandler getHandler(KaigoNinteiShinseiKihonJohoInputDiv div) {
        return new KaigoNinteiShinseiKihonJohoInputHandler(div);
    }
}
