package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoRenrakusakiInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SelectedContents のクラスファイル 
 * 
 * @author 自動生成
 */
public class SelectedContentsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtShimeiKana")
    private TextBox txtShimeiKana;
    @JsonProperty("txtTel")
    private TextBoxCode txtTel;
    @JsonProperty("txtKeitaiNo")
    private TextBoxCode txtKeitaiNo;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxMultiLine txtJusho;
    @JsonProperty("txtTsuzukigara")
    private TextBox txtTsuzukigara;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("renrakusakiKbnNo")
    private RString renrakusakiKbnNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

    @JsonProperty("txtShimeiKana")
    public TextBox getTxtShimeiKana() {
        return txtShimeiKana;
    }

    @JsonProperty("txtShimeiKana")
    public void setTxtShimeiKana(TextBox txtShimeiKana) {
        this.txtShimeiKana=txtShimeiKana;
    }

    @JsonProperty("txtTel")
    public TextBoxCode getTxtTel() {
        return txtTel;
    }

    @JsonProperty("txtTel")
    public void setTxtTel(TextBoxCode txtTel) {
        this.txtTel=txtTel;
    }

    @JsonProperty("txtKeitaiNo")
    public TextBoxCode getTxtKeitaiNo() {
        return txtKeitaiNo;
    }

    @JsonProperty("txtKeitaiNo")
    public void setTxtKeitaiNo(TextBoxCode txtKeitaiNo) {
        this.txtKeitaiNo=txtKeitaiNo;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("txtJusho")
    public TextBoxMultiLine getTxtJusho() {
        return txtJusho;
    }

    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxMultiLine txtJusho) {
        this.txtJusho=txtJusho;
    }

    @JsonProperty("txtTsuzukigara")
    public TextBox getTxtTsuzukigara() {
        return txtTsuzukigara;
    }

    @JsonProperty("txtTsuzukigara")
    public void setTxtTsuzukigara(TextBox txtTsuzukigara) {
        this.txtTsuzukigara=txtTsuzukigara;
    }

    @JsonProperty("btnUpdate")
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    @JsonProperty("btnUpdate")
    public void setBtnUpdate(Button btnUpdate) {
        this.btnUpdate=btnUpdate;
    }

    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn=btnReturn;
    }

    @JsonProperty("renrakusakiKbnNo")
    public RString getRenrakusakiKbnNo() {
        return renrakusakiKbnNo;
    }

    @JsonProperty("renrakusakiKbnNo")
    public void setRenrakusakiKbnNo(RString renrakusakiKbnNo) {
        this.renrakusakiKbnNo=renrakusakiKbnNo;
    }

}
