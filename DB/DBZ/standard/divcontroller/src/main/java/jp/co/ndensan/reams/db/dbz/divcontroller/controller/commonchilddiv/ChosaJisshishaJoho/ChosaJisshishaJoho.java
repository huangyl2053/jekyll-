/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ChosaJisshishaJoho;

import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv.TaishoMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJohoHandler;
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
     * 入力された所属機関コードより、所属機関名称を取得します。
     *
     * @param div 調査実施者情報入力共有子Div
     * @return 調査委託先投票区名称
     */
    public ResponseData<ChosaJisshishaJohoDiv> onBlur_txtShozokuKikanCode(ChosaJisshishaJohoDiv div) {
        getHandler(div).onBlurTxtShozokuKikanCode();
        return ResponseData.of(div).respond();
    }

    /**
     * 共有子Div上で入力された記入者コードから記入者名称を取得します。
     *
     * @param div 調査実施者情報共有子Div
     * @return 記入者名称
     */
    public ResponseData<ChosaJisshishaJohoDiv> onBlur_txtKinyushaCode(ChosaJisshishaJohoDiv div) {
        getHandler(div).onBlurTxtKinyushaCode();
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先ガイドボタンを押下した際に動作するメソッドです。
     *
     * @param div 調査実施者情報共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaJisshishaJohoDiv> onClick_btnChosaItakusakiGuide(ChosaJisshishaJohoDiv div) {
        KijuntsukiShichosonjohoiDataPassModel modle = new KijuntsukiShichosonjohoiDataPassModel();
        modle.set市町村コード(div.getHdnShichosonCode());
        modle.set委託先コード(div.getTxtShozokuKikanCode().getValue());
        modle.set委託先名(div.getTxtShozokuKikanName().getValue());
        modle.set対象モード(new RString(TaishoMode.Itakusaki.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(modle));
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先/調査員ガイドDivに選択ボタンを押下した際に動作するメソッドです。（委託先対象モード）
     *
     * @param div 調査実施者情報共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaJisshishaJohoDiv> onOKClose_btnChosaItakusakiGuide(ChosaJisshishaJohoDiv div) {
        KijuntsukiShichosonjohoiDataPassModel modle = DataPassingConverter.deserialize(div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        div.getTxtShozokuKikanCode().setValue(modle.get委託先コード());
        div.getTxtShozokuKikanName().setValue(modle.get委託先名());
        return ResponseData.of(div).respond();
    }

    /**
     * 調査員ガイドボタンを押下した際に動作するメソッドです。
     *
     * @param div 調査実施者情報共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaJisshishaJohoDiv> onClick_btnChosainGuide(ChosaJisshishaJohoDiv div) {
        KijuntsukiShichosonjohoiDataPassModel modle = new KijuntsukiShichosonjohoiDataPassModel();
        modle.set市町村コード(div.getHdnShichosonCode());
        modle.set委託先コード(div.getTxtShozokuKikanCode().getValue());
        modle.set委託先名(div.getTxtShozokuKikanName().getValue());
        modle.set調査員コード(div.getTxtKinyushaCode().getValue());
        modle.set調査員名(div.getTxtKinyushaName().getValue());
        modle.set対象モード(new RString(TaishoMode.Chosain.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(modle));
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先/調査員ガイドDivに選択ボタンを押下した際に動作するメソッドです。（調査員対象モード）
     *
     * @param div 調査実施者情報共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaJisshishaJohoDiv> onOKClose_btnChosainGuide(ChosaJisshishaJohoDiv div) {
        KijuntsukiShichosonjohoiDataPassModel modle = DataPassingConverter.deserialize(div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        div.getTxtShozokuKikanCode().setValue(modle.get委託先コード());
        div.getTxtShozokuKikanName().setValue(modle.get委託先名());
        div.getTxtKinyushaCode().setValue(modle.get調査員コード());
        div.getTxtKinyushaName().setValue(modle.get調査員名());
        return ResponseData.of(div).respond();
    }

    /**
     * 実施場所ddlの値が変更された（onChange）時のイベント
     *
     * @param div 調査実施者情報共有子Div
     * @return イベント処理後の共有子Div
     */
    public ResponseData<ChosaJisshishaJohoDiv> onChange_ddlChosaJisshiBasho(ChosaJisshishaJohoDiv div) {
        getHandler(div).onChange_ddlChosaJisshiBasho();
        return ResponseData.of(div).respond();
    }

    private ChosaJisshishaJohoHandler getHandler(ChosaJisshishaJohoDiv div) {
        return new ChosaJisshishaJohoHandler(div);
    }
}
