package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6060001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaIraibi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaIraibiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChosaIraibi")
    private TextBoxDateRange txtChosaIraibi;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("ccdHokensya")
    private HokenshaListDiv ccdHokensya;
    @JsonProperty("btnKensakuClear")
    private Button btnKensakuClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChosaIraibi
     * @return txtChosaIraibi
     */
    @JsonProperty("txtChosaIraibi")
    public TextBoxDateRange getTxtChosaIraibi() {
        return txtChosaIraibi;
    }

    /*
     * settxtChosaIraibi
     * @param txtChosaIraibi txtChosaIraibi
     */
    @JsonProperty("txtChosaIraibi")
    public void setTxtChosaIraibi(TextBoxDateRange txtChosaIraibi) {
        this.txtChosaIraibi = txtChosaIraibi;
    }

    /*
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    /*
     * getccdHokensya
     * @return ccdHokensya
     */
    @JsonProperty("ccdHokensya")
    public IHokenshaListDiv getCcdHokensya() {
        return ccdHokensya;
    }

    /*
     * getbtnKensakuClear
     * @return btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public Button getBtnKensakuClear() {
        return btnKensakuClear;
    }

    /*
     * setbtnKensakuClear
     * @param btnKensakuClear btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public void setBtnKensakuClear(Button btnKensakuClear) {
        this.btnKensakuClear = btnKensakuClear;
    }

    // </editor-fold>
}
