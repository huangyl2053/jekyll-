package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RenrakusakiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class RenrakusakiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtRenrakusakiJusho")
    private TextBoxMultiLine txtRenrakusakiJusho;
    @JsonProperty("txtRenrakusakiMei1")
    private TextBox txtRenrakusakiMei1;
    @JsonProperty("txtRenrakusakiMei2")
    private TextBox txtRenrakusakiMei2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtRenrakusakiJusho
     * @return txtRenrakusakiJusho
     */
    @JsonProperty("txtRenrakusakiJusho")
    public TextBoxMultiLine getTxtRenrakusakiJusho() {
        return txtRenrakusakiJusho;
    }

    /*
     * settxtRenrakusakiJusho
     * @param txtRenrakusakiJusho txtRenrakusakiJusho
     */
    @JsonProperty("txtRenrakusakiJusho")
    public void setTxtRenrakusakiJusho(TextBoxMultiLine txtRenrakusakiJusho) {
        this.txtRenrakusakiJusho = txtRenrakusakiJusho;
    }

    /*
     * gettxtRenrakusakiMei1
     * @return txtRenrakusakiMei1
     */
    @JsonProperty("txtRenrakusakiMei1")
    public TextBox getTxtRenrakusakiMei1() {
        return txtRenrakusakiMei1;
    }

    /*
     * settxtRenrakusakiMei1
     * @param txtRenrakusakiMei1 txtRenrakusakiMei1
     */
    @JsonProperty("txtRenrakusakiMei1")
    public void setTxtRenrakusakiMei1(TextBox txtRenrakusakiMei1) {
        this.txtRenrakusakiMei1 = txtRenrakusakiMei1;
    }

    /*
     * gettxtRenrakusakiMei2
     * @return txtRenrakusakiMei2
     */
    @JsonProperty("txtRenrakusakiMei2")
    public TextBox getTxtRenrakusakiMei2() {
        return txtRenrakusakiMei2;
    }

    /*
     * settxtRenrakusakiMei2
     * @param txtRenrakusakiMei2 txtRenrakusakiMei2
     */
    @JsonProperty("txtRenrakusakiMei2")
    public void setTxtRenrakusakiMei2(TextBox txtRenrakusakiMei2) {
        this.txtRenrakusakiMei2 = txtRenrakusakiMei2;
    }

    // </editor-fold>
}
