/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ChosaJisshishaJoho;

import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv.TaishoMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共有子Div「調査実施者情報」のDivControllerです。
 *
 * @author n3423
 */
public class ChosaJisshishaJoho {

    /**
     * 調査員ガイドボタンを押下した際に動作するメソッドです。
     *
     * @param div 調査実施者情報共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaJisshishaJohoDiv> onClick_btnChosainGuide(ChosaJisshishaJohoDiv div) {
        KijuntsukiShichosonjohoiDataPassModel model = new KijuntsukiShichosonjohoiDataPassModel();
        model.set市町村コード(div.getHdnShichosonCode());
        model.set委託先コード(div.getTxtShozokuKikanCode().getValue());
        model.set委託先名(div.getTxtShozokuKikanName().getValue());
        model.set調査員コード(div.getTxtKinyushaCode().getValue());
        model.set調査員名(div.getTxtKinyushaName().getValue());
        model.set対象モード(new RString(TaishoMode.Chosain.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先/調査員ガイドDivに選択ボタンを押下した際に動作するメソッドです。（調査員対象モード）
     *
     * @param div 調査実施者情報共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaJisshishaJohoDiv> onOKClose_btnChosainGuide(ChosaJisshishaJohoDiv div) {
        KijuntsukiShichosonjohoiDataPassModel model = DataPassingConverter.deserialize(div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        div.getTxtShozokuKikanCode().setValue(model.get委託先コード());
        div.getTxtShozokuKikanName().setValue(model.get委託先名());
        div.getTxtKinyushaCode().setValue(model.get調査員コード());
        div.getTxtKinyushaName().setValue(model.get調査員名());
        return ResponseData.of(div).respond();
    }
}
