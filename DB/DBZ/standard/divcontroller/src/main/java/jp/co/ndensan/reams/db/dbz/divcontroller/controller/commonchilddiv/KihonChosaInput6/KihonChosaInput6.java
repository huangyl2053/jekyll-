/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KihonChosaInput6;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput6.KihonChosaInput6.KihonChosaInput6Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput6.KihonChosaInput6.KihonChosaInputHandler6;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 認定基本調査入力の特別な医療のDivControllerです。
 *
 * @reamsid_L DBE-3000-095 wangjie2
 */
public class KihonChosaInput6 {

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput6Div
     * @return ResponseData<KihonChosaInput6Div>
     */
    public ResponseData<KihonChosaInput6Div> onLoad(KihonChosaInput6Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getTokubetsuIryo().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getTokubetsuIryo().getRecordNumber();
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class);
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onClick_btnConfirm(KihonChosaInput6Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class);
            ArrayList<KihonChosaInput> new認定調査基本情報リスト = getHandler(div).onClick_btnConfirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKeys.第六群認定調査基本情報リスト, new認定調査基本情報リスト);
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を戻るを押下する。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onClick_btnBack(KihonChosaInput6Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

    private KihonChosaInputHandler6 getHandler(KihonChosaInput6Div div) {
        return new KihonChosaInputHandler6(div);
    }

    /**
     * 処置内容（複数回答可）の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnShochiNaiyo(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.点滴の管理.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 特別な対応（複数回答可）の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnTokiTaiou(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.中心静脈栄養.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    private void setDailogDataPassing(KihonChosaInput6Div div) {
        RString rirekiNo = new RString(ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class));
        div.getTokubetsuIryo().setRecordNumber(rirekiNo);
        ArrayList list = new ArrayList();
        list.add(div.getTokubetsuIryo().getTokkijikoNo());
        div.getTokubetsuIryo().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(list));
    }
}
