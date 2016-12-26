/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KihonChosaInput7;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput7.KihonChosaInput7.KihonChosaInput7Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput7.KihonChosaInput7.KihonChosaInputHandler7;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 認定基本調査入力の自立度のDivControllerです。
 *
 * @reamsid_L DBE-3000-096 wangjie2
 */
public class KihonChosaInput7 {

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput7Div
     * @return ResponseData<KihonChosaInput7Div>
     */
    public ResponseData<KihonChosaInput7Div> onLoad(KihonChosaInput7Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getJiritsudo().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getJiritsudo().getRecordNumber();
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class);
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput7Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput7Div> onClick_btnConfirm(KihonChosaInput7Div div) {
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> new認定調査基本情報リスト = getHandler(div).onClick_btnConfirm(認定調査基本情報リスト);
        ViewStateHolder.put(ViewStateKeys.第七群認定調査基本情報リスト, new認定調査基本情報リスト);
        必須入力チェック(new認定調査基本情報リスト);
        return ResponseData.of(div).dialogOKClose();
    }

    private KihonChosaInputHandler7 getHandler(KihonChosaInput7Div div) {
        return new KihonChosaInputHandler7(div);
    }

    /**
     * 認定基本調査入力を戻るを押下する。
     *
     * @param div {@link KihonChosaInput7Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput7Div> onClick_btnBack(KihonChosaInput7Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

    private void 必須入力チェック(ArrayList<KihonChosaInput> new認定調査基本情報リスト) {
        boolean 障害高齢者の日常生活自立度_選択 = false;
        boolean 認知症高齢者の日常生活自立度_選択 = false;
        for (KihonChosaInput joho : new認定調査基本情報リスト) {
            if (!joho.get認知症高齢者自立度().isEmpty()) {
                障害高齢者の日常生活自立度_選択 = true;
            }
            if (!joho.get障害高齢者自立度().isEmpty()) {
                認知症高齢者の日常生活自立度_選択 = true;
            }
        }
        if (障害高齢者の日常生活自立度_選択 && 認知症高齢者の日常生活自立度_選択) {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("1"));
        } else {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("0"));
        }
    }

    /**
     * 障害高齢者の日常生活自立度（寝たきり度）の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput7Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput7Div> onBeforeOpenDialog_btnShogaiKoreisha(KihonChosaInput7Div div) {
        div.getJiritsudo().setTokkijikoNo(NinteiChosaTokkiJikou.障害高齢者自立度.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 認知症高齢者の日常生活自立度の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput7Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput7Div> onBeforeOpenDialog_btnNinchishaJiritsudo(KihonChosaInput7Div div) {
        div.getJiritsudo().setTokkijikoNo(NinteiChosaTokkiJikou.認知症高齢者自立度.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    private void setDailogDataPassing(KihonChosaInput7Div div) {
        RString rirekiNo = new RString(ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class));
        div.getJiritsudo().setRecordNumber(rirekiNo);
        ArrayList list = new ArrayList();
        list.add(div.getJiritsudo().getTokkijikoNo());
        div.getJiritsudo().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(list));
    }
}
