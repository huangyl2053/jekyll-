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
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> new認定調査基本情報リスト = getHandler(div).onClick_btnConfirm(認定調査基本情報リスト);
        ViewStateHolder.put(ViewStateKeys.第六群認定調査基本情報リスト, new認定調査基本情報リスト);
        return ResponseData.of(div).dialogOKClose();
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
     * 点滴の管理の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnTenteki(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.点滴の管理.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 中心静脈栄養の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnSeimyaku(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.中心静脈栄養.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 透析の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnTouseki(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.透析.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * ストーマ（人工肛門）の処置の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnSutoma(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.ストーマの処置.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 酸素療法の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnSansou(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.酸素療法.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * レスピレーター（人工呼吸器）の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnResupireta(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.レスピレーター.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 気管切開の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnKikan(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.気管切開.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 疼痛の看護の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnToutsu(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.疼痛の看護.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 経管栄養の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnKeikan(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.経管栄養.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * モニター測定（血圧、心拍、酸素飽和度等）の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnMonita(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.モニター測定.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * じょくそうの処置の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnJyokuso(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.じょくそうの処置.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * カテーテル（コンドームカテーテル、留置カテーテル、ウロストーマ等）の処置の特記事項をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onBeforeOpenDialog_btnKateru(KihonChosaInput6Div div) {
        div.getTokubetsuIryo().setTokkijikoNo(NinteiChosaTokkiJikou.カテーテル.get認定調査票_特記情報_認定調査特記事項番号());
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
