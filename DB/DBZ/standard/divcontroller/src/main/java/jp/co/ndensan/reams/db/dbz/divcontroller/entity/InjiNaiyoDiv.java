package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * InjiNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class InjiNaiyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlBusho")
    private DropDownList ddlBusho;
    @JsonProperty("dllBushomeiKuhakuUMu")
    private DropDownList dllBushomeiKuhakuUMu;
    @JsonProperty("txtName")
    private TextBox txtName;
    @JsonProperty("txtTelNo")
    private TextBox txtTelNo;
    @JsonProperty("txtNaisenNo")
    private TextBox txtNaisenNo;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("ddlKenmeiFuyo")
    private DropDownList ddlKenmeiFuyo;
    @JsonProperty("ddlShichoshonMei")
    private DropDownList ddlShichoshonMei;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxMultiLine txtJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlBusho")
    public DropDownList getDdlBusho() {
        return ddlBusho;
    }

    @JsonProperty("ddlBusho")
    public void setDdlBusho(DropDownList ddlBusho) {
        this.ddlBusho=ddlBusho;
    }

    @JsonProperty("dllBushomeiKuhakuUMu")
    public DropDownList getDllBushomeiKuhakuUMu() {
        return dllBushomeiKuhakuUMu;
    }

    @JsonProperty("dllBushomeiKuhakuUMu")
    public void setDllBushomeiKuhakuUMu(DropDownList dllBushomeiKuhakuUMu) {
        this.dllBushomeiKuhakuUMu=dllBushomeiKuhakuUMu;
    }

    @JsonProperty("txtName")
    public TextBox getTxtName() {
        return txtName;
    }

    @JsonProperty("txtName")
    public void setTxtName(TextBox txtName) {
        this.txtName=txtName;
    }

    @JsonProperty("txtTelNo")
    public TextBox getTxtTelNo() {
        return txtTelNo;
    }

    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBox txtTelNo) {
        this.txtTelNo=txtTelNo;
    }

    @JsonProperty("txtNaisenNo")
    public TextBox getTxtNaisenNo() {
        return txtNaisenNo;
    }

    @JsonProperty("txtNaisenNo")
    public void setTxtNaisenNo(TextBox txtNaisenNo) {
        this.txtNaisenNo=txtNaisenNo;
    }

    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1=lin1;
    }

    @JsonProperty("ddlKenmeiFuyo")
    public DropDownList getDdlKenmeiFuyo() {
        return ddlKenmeiFuyo;
    }

    @JsonProperty("ddlKenmeiFuyo")
    public void setDdlKenmeiFuyo(DropDownList ddlKenmeiFuyo) {
        this.ddlKenmeiFuyo=ddlKenmeiFuyo;
    }

    @JsonProperty("ddlShichoshonMei")
    public DropDownList getDdlShichoshonMei() {
        return ddlShichoshonMei;
    }

    @JsonProperty("ddlShichoshonMei")
    public void setDdlShichoshonMei(DropDownList ddlShichoshonMei) {
        this.ddlShichoshonMei=ddlShichoshonMei;
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

}
