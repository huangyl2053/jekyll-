/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KihonChosaInput1;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1.KihonChosaInput1Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1.KihonChosaInputHandler1;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 認定基本調査入力の第一群身体機能のDivControllerです。
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class KihonChosaInput1 {

    private static final int 整数1 = 1;
    private static final int 整数2 = 2;
    private static final int 整数3 = 3;
    private static final int 整数4 = 4;
    private static final int 整数5 = 5;
    private static final int 整数6 = 6;
    private static final int 整数7 = 7;
    private static final int 整数8 = 8;
    private static final int 整数9 = 9;
    private static final int 整数11 = 11;

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput1Div
     * @return ResponseData<KihonChosaInput1Div>
     */
    public ResponseData<KihonChosaInput1Div> onLoad(KihonChosaInput1Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getDaiichigunShintaiKino().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getDaiichigunShintaiKino().getRecordNumber();
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onClick_btnConfirm(KihonChosaInput1Div div) {
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> new認定調査基本情報リスト = getHandler(div).onClick_btnConfirm(認定調査基本情報リスト);
        ViewStateHolder.put(ViewStateKeys.第一群認定調査基本情報リスト, new認定調査基本情報リスト);
        必須入力チェック(new認定調査基本情報リスト);
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 認定基本調査入力を戻るを押下する。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onClick_btnBack(KihonChosaInput1Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 認定基本調査入力を麻痺等の有無ないを押下する。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onClick_chkMahiChange(KihonChosaInput1Div div) {
        getHandler(div).麻痺等の有無ないChange();
        return ResponseData.of(div).focusId(div.getChkMahi().getSelectControlID()).respond();
    }

    /**
     * 認定基本調査入力を拘縮の有無ないを押下する。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onClick_chkKoshukuChange(KihonChosaInput1Div div) {
        getHandler(div).拘縮の有無ないChange();
        return ResponseData.of(div).focusId(div.getChkKoshuku().getSelectControlID()).respond();
    }

    private KihonChosaInputHandler1 getHandler(KihonChosaInput1Div div) {
        return new KihonChosaInputHandler1(div);
    }

    private void 必須入力チェック(ArrayList<KihonChosaInput> new認定調査基本情報リスト) {
        int size = 0;
        int 連番;
        for (KihonChosaInput joho : new認定調査基本情報リスト) {
            連番 = joho.get調査連番();
            if (連番 != 整数1 && 連番 != 整数2 && 連番 != 整数3 && 連番 != 整数4 && 連番 != 整数5
                    && 連番 != 整数6 && 連番 != 整数7 && 連番 != 整数8 && 連番 != 整数9) {
                size++;
            }
        }
        if (size == 整数11) {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("1"));
        } else {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("0"));
        }
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnMahi(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.麻痺等の有無.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnKoshuku(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.拘縮の有無.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnNeKaeri(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.寝返り.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnOkiAgari(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.起き上がり.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnZai(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.座位保持.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnRyoAshi(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.両足での立位保持.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnBuko(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.歩行.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnTachiAgari(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.立ち上がり.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnKataAshi(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.片足での立位.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnSenshin(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.洗身.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnTumeKiri(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.つめ切り.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnShiryoku(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.視力.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    /**
     * をクリックした際に、特記事項番号の設定をおこないます。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onBeforeOpenDialog_btnChoryoku(KihonChosaInput1Div div) {
        div.getDaiichigunShintaiKino().setTokkijikoNo(NinteiChosaTokkiJikou.聴力.get認定調査票_特記情報_認定調査特記事項番号());
        setDailogDataPassing(div);
        return ResponseData.of(div).respond();
    }

    private void setDailogDataPassing(KihonChosaInput1Div div) {
        RString rirekiNo = new RString(ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class));
        div.getDaiichigunShintaiKino().setRecordNumber(rirekiNo);
        ArrayList list = new ArrayList();
        list.add(div.getDaiichigunShintaiKino().getTokkijikoNo());
        div.getDaiichigunShintaiKino().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(list));
    }

}
