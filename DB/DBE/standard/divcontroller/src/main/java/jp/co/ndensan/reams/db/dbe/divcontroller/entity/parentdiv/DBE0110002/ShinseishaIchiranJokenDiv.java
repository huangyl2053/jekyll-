package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseishaIchiranJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaIchiranJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShinseishaIchiran")
    private CheckBoxList chkShinseishaIchiran;
    @JsonProperty("lblShinseishaSakuseiJoken")
    private Label lblShinseishaSakuseiJoken;
    @JsonProperty("radShinseishaJoken")
    private RadioButton radShinseishaJoken;
    @JsonProperty("txtShinseishaShoriYMD")
    private TextBoxDateRange txtShinseishaShoriYMD;
    @JsonProperty("txtShinseishaShinseiYMD")
    private TextBoxDateRange txtShinseishaShinseiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkShinseishaIchiran
     * @return chkShinseishaIchiran
     */
    @JsonProperty("chkShinseishaIchiran")
    public CheckBoxList getChkShinseishaIchiran() {
        return chkShinseishaIchiran;
    }

    /*
     * setchkShinseishaIchiran
     * @param chkShinseishaIchiran chkShinseishaIchiran
     */
    @JsonProperty("chkShinseishaIchiran")
    public void setChkShinseishaIchiran(CheckBoxList chkShinseishaIchiran) {
        this.chkShinseishaIchiran = chkShinseishaIchiran;
    }

    /*
     * getlblShinseishaSakuseiJoken
     * @return lblShinseishaSakuseiJoken
     */
    @JsonProperty("lblShinseishaSakuseiJoken")
    public Label getLblShinseishaSakuseiJoken() {
        return lblShinseishaSakuseiJoken;
    }

    /*
     * setlblShinseishaSakuseiJoken
     * @param lblShinseishaSakuseiJoken lblShinseishaSakuseiJoken
     */
    @JsonProperty("lblShinseishaSakuseiJoken")
    public void setLblShinseishaSakuseiJoken(Label lblShinseishaSakuseiJoken) {
        this.lblShinseishaSakuseiJoken = lblShinseishaSakuseiJoken;
    }

    /*
     * getradShinseishaJoken
     * @return radShinseishaJoken
     */
    @JsonProperty("radShinseishaJoken")
    public RadioButton getRadShinseishaJoken() {
        return radShinseishaJoken;
    }

    /*
     * setradShinseishaJoken
     * @param radShinseishaJoken radShinseishaJoken
     */
    @JsonProperty("radShinseishaJoken")
    public void setRadShinseishaJoken(RadioButton radShinseishaJoken) {
        this.radShinseishaJoken = radShinseishaJoken;
    }

    /*
     * gettxtShinseishaShoriYMD
     * @return txtShinseishaShoriYMD
     */
    @JsonProperty("txtShinseishaShoriYMD")
    public TextBoxDateRange getTxtShinseishaShoriYMD() {
        return txtShinseishaShoriYMD;
    }

    /*
     * settxtShinseishaShoriYMD
     * @param txtShinseishaShoriYMD txtShinseishaShoriYMD
     */
    @JsonProperty("txtShinseishaShoriYMD")
    public void setTxtShinseishaShoriYMD(TextBoxDateRange txtShinseishaShoriYMD) {
        this.txtShinseishaShoriYMD = txtShinseishaShoriYMD;
    }

    /*
     * gettxtShinseishaShinseiYMD
     * @return txtShinseishaShinseiYMD
     */
    @JsonProperty("txtShinseishaShinseiYMD")
    public TextBoxDateRange getTxtShinseishaShinseiYMD() {
        return txtShinseishaShinseiYMD;
    }

    /*
     * settxtShinseishaShinseiYMD
     * @param txtShinseishaShinseiYMD txtShinseishaShinseiYMD
     */
    @JsonProperty("txtShinseishaShinseiYMD")
    public void setTxtShinseishaShinseiYMD(TextBoxDateRange txtShinseishaShinseiYMD) {
        this.txtShinseishaShinseiYMD = txtShinseishaShinseiYMD;
    }

    // </editor-fold>
}
