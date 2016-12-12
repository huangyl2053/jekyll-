package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2270001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiKensakuJyoken のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiKensakuJyokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKyufuJissekiSearchClear")
    private Button btnKyufuJissekiSearchClear;
    @JsonProperty("txtMaxCount")
    private TextBoxNum txtMaxCount;
    @JsonProperty("ccdHokensha")
    private HokenshaListDiv ccdHokensha;
    @JsonProperty("ccdChosaltakusakiAndChosainInput")
    private ChosaItakusakiAndChosainInputDiv ccdChosaltakusakiAndChosainInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKyufuJissekiSearchClear
     * @return btnKyufuJissekiSearchClear
     */
    @JsonProperty("btnKyufuJissekiSearchClear")
    public Button getBtnKyufuJissekiSearchClear() {
        return btnKyufuJissekiSearchClear;
    }

    /*
     * setbtnKyufuJissekiSearchClear
     * @param btnKyufuJissekiSearchClear btnKyufuJissekiSearchClear
     */
    @JsonProperty("btnKyufuJissekiSearchClear")
    public void setBtnKyufuJissekiSearchClear(Button btnKyufuJissekiSearchClear) {
        this.btnKyufuJissekiSearchClear = btnKyufuJissekiSearchClear;
    }

    /*
     * gettxtMaxCount
     * @return txtMaxCount
     */
    @JsonProperty("txtMaxCount")
    public TextBoxNum getTxtMaxCount() {
        return txtMaxCount;
    }

    /*
     * settxtMaxCount
     * @param txtMaxCount txtMaxCount
     */
    @JsonProperty("txtMaxCount")
    public void setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.txtMaxCount = txtMaxCount;
    }

    /*
     * getccdHokensha
     * @return ccdHokensha
     */
    @JsonProperty("ccdHokensha")
    public IHokenshaListDiv getCcdHokensha() {
        return ccdHokensha;
    }

    /*
     * getccdChosaltakusakiAndChosainInput
     * @return ccdChosaltakusakiAndChosainInput
     */
    @JsonProperty("ccdChosaltakusakiAndChosainInput")
    public IChosaItakusakiAndChosainInputDiv getCcdChosaltakusakiAndChosainInput() {
        return ccdChosaltakusakiAndChosainInput;
    }

    // </editor-fold>
}
