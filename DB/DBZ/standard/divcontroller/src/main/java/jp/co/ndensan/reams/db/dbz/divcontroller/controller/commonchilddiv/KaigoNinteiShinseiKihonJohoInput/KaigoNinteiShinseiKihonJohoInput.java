package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KaigoNinteiShinseiKihonJohoInput;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 * 介護認定申請基本情報の入力用クラス。
 */
public class KaigoNinteiShinseiKihonJohoInput {

    private static final RString サービス削除の旨 = new RString("1010");
    private static final RString 認定申請理由 = new RString("1001");

    /**
     * ダイアログ用引数を設定します。
     *
     * @param div 介護認定申請基本情報の入力用DIV
     * @return ResponseData
     */
    public ResponseData onBeforeOpenDialog_btnServiceSakujoTeikeibun(KaigoNinteiShinseiKihonJohoInputDiv div) {
        ResponseData<KaigoNinteiShinseiKihonJohoInputDiv> response = new ResponseData<>();
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
        RStringBuilder serviceSakujo;
        if (div.getTxtServiceSakujo().getValue() == null) {
            serviceSakujo = new RStringBuilder(RString.EMPTY);
        } else {
            serviceSakujo = new RStringBuilder(div.getTxtServiceSakujo().getValue());
        }
//      TODO QA852 データパッシング：サブ業務コード・グループコード 王暁冬 2015/03/08
        serviceSakujo.append(serviceSakujo);
        div.setHdnServiceSakujoTeikeibun(serviceSakujo.toRString());

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
        RStringBuilder ninteiShinseiRiyu;
        if (div.getTxtServiceSakujo().getValue() == null) {
            ninteiShinseiRiyu = new RStringBuilder(RString.EMPTY);
        } else {
            ninteiShinseiRiyu = new RStringBuilder(div.getTxtServiceSakujo().getValue());
        }
//      TODO QA852 データパッシング：サブ業務コード・グループコード 王暁冬 2015/03/08
        ninteiShinseiRiyu.append(ninteiShinseiRiyu);
        div.setHdnNinteiRiyuTeikeibun(ninteiShinseiRiyu.toRString());

        response.data = div;
        return response;
    }
}
