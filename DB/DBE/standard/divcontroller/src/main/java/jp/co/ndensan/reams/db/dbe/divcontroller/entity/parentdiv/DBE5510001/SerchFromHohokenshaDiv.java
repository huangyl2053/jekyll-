package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SerchFromHohokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SerchFromHohokenshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-20_05-03-35">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("btnHihokenshaKensaku")
    private Button btnHihokenshaKensaku;
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("txtShimei")
    private TextBoxAtenaMeisho txtShimei;
    @JsonProperty("chkKensakuOption")
    private CheckBoxList chkKensakuOption;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * getbtnHihokenshaKensaku
     * @return btnHihokenshaKensaku
     */
    @JsonProperty("btnHihokenshaKensaku")
    public Button getBtnHihokenshaKensaku() {
        return btnHihokenshaKensaku;
    }

    /*
     * setbtnHihokenshaKensaku
     * @param btnHihokenshaKensaku btnHihokenshaKensaku
     */
    @JsonProperty("btnHihokenshaKensaku")
    public void setBtnHihokenshaKensaku(Button btnHihokenshaKensaku) {
        this.btnHihokenshaKensaku = btnHihokenshaKensaku;
    }

    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBoxAtenaMeisho getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBoxAtenaMeisho txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * getchkKensakuOption
     * @return chkKensakuOption
     */
    @JsonProperty("chkKensakuOption")
    public CheckBoxList getChkKensakuOption() {
        return chkKensakuOption;
    }

    /*
     * setchkKensakuOption
     * @param chkKensakuOption chkKensakuOption
     */
    @JsonProperty("chkKensakuOption")
    public void setChkKensakuOption(CheckBoxList chkKensakuOption) {
        this.chkKensakuOption = chkKensakuOption;
    }

    // </editor-fold>
}
