/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KihonChosaInput4;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4.KihonChosaInput4Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4.KihonChosaInputHandler4;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 認定基本調査入力の第四群精神・行動障害のDivControllerです。
 *
 * @reamsid_L DBE-3000-093 wangjie2
 */
public class KihonChosaInput4 {

    private static final int 整数15 = 15;

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput4Div
     * @return ResponseData<KihonChosaInput4Div>
     */
    public ResponseData<KihonChosaInput4Div> onLoad(KihonChosaInput4Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getKoudoShogai().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getKoudoShogai().getRecordNumber();
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class);
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onClick_btnConfirm(KihonChosaInput4Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class);
            ArrayList<KihonChosaInput> new認定調査基本情報リスト = getHandler(div).onClick_btnConfirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKeys.第四群認定調査基本情報リスト, new認定調査基本情報リスト);
            必須入力チェック(new認定調査基本情報リスト);
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を戻るを押下する。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onClick_btnBack(KihonChosaInput4Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

    private KihonChosaInputHandler4 getHandler(KihonChosaInput4Div div) {
        return new KihonChosaInputHandler4(div);
    }

    private void 必須入力チェック(ArrayList<KihonChosaInput> new認定調査基本情報リスト) {
        if (new認定調査基本情報リスト != null && new認定調査基本情報リスト.size() == 整数15) {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("1"));
        } else {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("0"));
        }
    }

    /**
     * 「物を盗られた」等と被害的になるの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnHiryaku(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.被虐的.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 作話の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnTukuriHanashi(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.作話.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 泣いたり、笑ったりして感情が不安定になるの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnKanjyo(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.感情が不安定.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 昼夜の逆転があるの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnChuyaku(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.昼夜逆転.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * しつこく同じ話をするの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnOnajiHanashi(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.同じ話をする.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 大声をだすの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnBigVoice(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.大声をだす.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護に抵抗するの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnTeikou(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.介護に抵抗.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「家に帰る」等と言い落ち着きがないの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnOchituki(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.落ち着きなし.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 一人で外に出たがり目が離せないの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnOutLonly(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.一人で出たがる.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 色々なものを集めたり、無断で持ってくるの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnShushu(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.収集癖.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 物や衣類を壊すの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnKowasu(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.物や衣類を壊す.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * ひどい物忘れの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnMonoWasure(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.ひどい物忘れ.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 独り言・独り笑いの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnHitoriWarai(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.独り言_独り笑い.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 自分勝手に行動するの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnKateKodo(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.自分勝手に行動する.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 話がまとまらない・会話にならないの特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onBeforeOpenDialog_btnMatomeNai(KihonChosaInput4Div div) {
        div.getKoudoShogai().setTokkijikoNo(NinteiChosaTokkiJikou.話がまとまらない.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    private void setDailogDataPassing(KihonChosaInput4Div div) {
        RString rirekiNo = new RString(ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class));
        div.getKoudoShogai().setRecordNumber(rirekiNo);
        ArrayList list = new ArrayList();
        list.add(div.getKoudoShogai().getTokkijikoNo());
        div.getKoudoShogai().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(list));
    }
}
