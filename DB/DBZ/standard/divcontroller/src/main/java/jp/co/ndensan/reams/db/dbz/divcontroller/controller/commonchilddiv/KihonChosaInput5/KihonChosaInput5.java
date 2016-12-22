/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KihonChosaInput5;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput5.KihonChosaInput5.KihonChosaInput5Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput5.KihonChosaInput5.KihonChosaInputHandler5;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 認定基本調査入力の第五群社会生活への適用のDivControllerです。
 *
 * @reamsid_L DBE-3000-094 wangjie2
 */
public class KihonChosaInput5 {

    private static final int 整数6 = 6;

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput5Div
     * @return ResponseData<KihonChosaInput5Div>
     */
    public ResponseData<KihonChosaInput5Div> onLoad(KihonChosaInput5Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getShakaiSekatsu().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getShakaiSekatsu().getRecordNumber();
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class);
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput5Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput5Div> onClick_btnConfirm(KihonChosaInput5Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class);
            ArrayList<KihonChosaInput> new認定調査基本情報リスト = getHandler(div).onClick_btnConfirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKeys.第五群認定調査基本情報リスト, new認定調査基本情報リスト);
            必須入力チェック(new認定調査基本情報リスト);
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を戻るを押下する。
     *
     * @param div {@link KihonChosaInput5Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput5Div> onClick_btnBack(KihonChosaInput5Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

    private KihonChosaInputHandler5 getHandler(KihonChosaInput5Div div) {
        return new KihonChosaInputHandler5(div);
    }

    private void 必須入力チェック(ArrayList<KihonChosaInput> new認定調査基本情報リスト) {
        if (new認定調査基本情報リスト != null && new認定調査基本情報リスト.size() == 整数6) {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("1"));
        } else {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("0"));
        }
    }

    /**
     * 薬の内服の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput5Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput5Div> onBeforeOpenDialog_btnKusuri(KihonChosaInput5Div div) {
        div.getShakaiSekatsu().setTokkijikoNo(NinteiChosaTokkiJikou.薬の内服.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 金銭の管理の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput5Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput5Div> onBeforeOpenDialog_btnKingakuKanri(KihonChosaInput5Div div) {
        div.getShakaiSekatsu().setTokkijikoNo(NinteiChosaTokkiJikou.金銭の管理.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 日常の意思決定の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput5Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput5Div> onBeforeOpenDialog_btnIshiKetei(KihonChosaInput5Div div) {
        div.getShakaiSekatsu().setTokkijikoNo(NinteiChosaTokkiJikou.日常の意思決定.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 集団への不適応の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput5Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput5Div> onBeforeOpenDialog_btnShudan(KihonChosaInput5Div div) {
        div.getShakaiSekatsu().setTokkijikoNo(NinteiChosaTokkiJikou.集団への不適応.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 買い物の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput5Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput5Div> onBeforeOpenDialog_btnKaiMono(KihonChosaInput5Div div) {
        div.getShakaiSekatsu().setTokkijikoNo(NinteiChosaTokkiJikou.買い物.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 簡単な調理の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput5Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput5Div> onBeforeOpenDialog_btnKantanChori(KihonChosaInput5Div div) {
        div.getShakaiSekatsu().setTokkijikoNo(NinteiChosaTokkiJikou.簡単な調理.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    private void setDailogDataPassing(KihonChosaInput5Div div) {
        RString rirekiNo = new RString(ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class));
        div.getShakaiSekatsu().setRecordNumber(rirekiNo);
        ArrayList list = new ArrayList();
        list.add(div.getShakaiSekatsu().getTokkijikoNo());
        div.getShakaiSekatsu().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(list));
    }
}
