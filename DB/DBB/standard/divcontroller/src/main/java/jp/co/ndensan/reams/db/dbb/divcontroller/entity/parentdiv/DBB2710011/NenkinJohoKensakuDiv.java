package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NenkinJohoKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NenkinJohoKensakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKisoNenkinNo")
    private TextBox txtKisoNenkinNo;
    @JsonProperty("txtNenkinCode")
    private TextBox txtNenkinCode;
    @JsonProperty("txtNenkinMeiSho")
    private TextBox txtNenkinMeiSho;
    @JsonProperty("btnNenkinInfoKensaku")
    private Button btnNenkinInfoKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKisoNenkinNo
     * @return txtKisoNenkinNo
     */
    @JsonProperty("txtKisoNenkinNo")
    public TextBox getTxtKisoNenkinNo() {
        return txtKisoNenkinNo;
    }

    /*
     * settxtKisoNenkinNo
     * @param txtKisoNenkinNo txtKisoNenkinNo
     */
    @JsonProperty("txtKisoNenkinNo")
    public void setTxtKisoNenkinNo(TextBox txtKisoNenkinNo) {
        this.txtKisoNenkinNo = txtKisoNenkinNo;
    }

    /*
     * gettxtNenkinCode
     * @return txtNenkinCode
     */
    @JsonProperty("txtNenkinCode")
    public TextBox getTxtNenkinCode() {
        return txtNenkinCode;
    }

    /*
     * settxtNenkinCode
     * @param txtNenkinCode txtNenkinCode
     */
    @JsonProperty("txtNenkinCode")
    public void setTxtNenkinCode(TextBox txtNenkinCode) {
        this.txtNenkinCode = txtNenkinCode;
    }

    /*
     * gettxtNenkinMeiSho
     * @return txtNenkinMeiSho
     */
    @JsonProperty("txtNenkinMeiSho")
    public TextBox getTxtNenkinMeiSho() {
        return txtNenkinMeiSho;
    }

    /*
     * settxtNenkinMeiSho
     * @param txtNenkinMeiSho txtNenkinMeiSho
     */
    @JsonProperty("txtNenkinMeiSho")
    public void setTxtNenkinMeiSho(TextBox txtNenkinMeiSho) {
        this.txtNenkinMeiSho = txtNenkinMeiSho;
    }

    /*
     * getbtnNenkinInfoKensaku
     * @return btnNenkinInfoKensaku
     */
    @JsonProperty("btnNenkinInfoKensaku")
    public Button getBtnNenkinInfoKensaku() {
        return btnNenkinInfoKensaku;
    }

    /*
     * setbtnNenkinInfoKensaku
     * @param btnNenkinInfoKensaku btnNenkinInfoKensaku
     */
    @JsonProperty("btnNenkinInfoKensaku")
    public void setBtnNenkinInfoKensaku(Button btnNenkinInfoKensaku) {
        this.btnNenkinInfoKensaku = btnNenkinInfoKensaku;
    }

    // </editor-fold>
}
