/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KihonChosaInput2;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput2.KihonChosaInput2.KihonChosaInput2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput2.KihonChosaInput2.KihonChosaInputHandler2;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 認定基本調査入力の第二群生活機能のDivControllerです。
 *
 * @reamsid_L DBE-3000-091 wangjie2
 */
public class KihonChosaInput2 {

    private static final int 整数12 = 12;

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput2Div
     * @return ResponseData<KihonChosaInput2Div>
     */
    public ResponseData<KihonChosaInput2Div> onLoad(KihonChosaInput2Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getSeikatsuKinou().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getSeikatsuKinou().getRecordNumber();
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class);
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onClick_btnConfirm(KihonChosaInput2Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class);
            ArrayList<KihonChosaInput> new認定調査基本情報リスト = getHandler(div).onClick_btnConfirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKeys.第二群認定調査基本情報リスト, new認定調査基本情報リスト);
            必須入力チェック(new認定調査基本情報リスト);
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onClick_btnBack(KihonChosaInput2Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

    private KihonChosaInputHandler2 getHandler(KihonChosaInput2Div div) {
        return new KihonChosaInputHandler2(div);
    }

    private void 必須入力チェック(ArrayList<KihonChosaInput> new認定調査基本情報リスト) {
        if (new認定調査基本情報リスト != null && new認定調査基本情報リスト.size() == 整数12) {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("1"));
        } else {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("0"));
        }
    }

    /**
     * 移乗の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnIjyo(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.移乗.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 移動の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnIdou(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.移動.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * えん下の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnEnka(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.えん下.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 食事摂取の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnShokuji(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.食事摂取.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 排尿の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnHainyo(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.排尿.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 排便の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnHaiben(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.排便.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 口腔清潔の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnKokou(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.口腔清潔.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 洗顔の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnSengan(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.洗顔.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 整髪の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnSeihatsu(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.整髪.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 上衣の着脱の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnUwagi(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.上衣の着脱.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * ズボン等の着脱の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnZubon(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.ズボン等の着脱.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 外出頻度の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onBeforeOpenDialog_btnHindo(KihonChosaInput2Div div) {
        div.getSeikatsuKinou().setTokkijikoNo(NinteiChosaTokkiJikou.外出頻度.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    private void setDailogDataPassing(KihonChosaInput2Div div) {
        RString rirekiNo = new RString(ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class));
        div.getSeikatsuKinou().setRecordNumber(rirekiNo);
        ArrayList list = new ArrayList();
        list.add(div.getSeikatsuKinou().getTokkijikoNo());
        div.getSeikatsuKinou().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(list));
    }
}
