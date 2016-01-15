package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryoHokenRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * plIryoHokenRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class plIryoHokenRirekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIryohokenTsuika")
    private Button btnIryohokenTsuika;
    @JsonProperty("dgIryohokenIchiran")
    private DataGrid<dgIryohokenIchiran_Row> dgIryohokenIchiran;
    @JsonProperty("pnlIryohokenJoho")
    private pnlIryohokenJohoDiv pnlIryohokenJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIryohokenTsuika
     * @return btnIryohokenTsuika
     */
    @JsonProperty("btnIryohokenTsuika")
    public Button getBtnIryohokenTsuika() {
        return btnIryohokenTsuika;
    }

    /*
     * setbtnIryohokenTsuika
     * @param btnIryohokenTsuika btnIryohokenTsuika
     */
    @JsonProperty("btnIryohokenTsuika")
    public void setBtnIryohokenTsuika(Button btnIryohokenTsuika) {
        this.btnIryohokenTsuika = btnIryohokenTsuika;
    }

    /*
     * getdgIryohokenIchiran
     * @return dgIryohokenIchiran
     */
    @JsonProperty("dgIryohokenIchiran")
    public DataGrid<dgIryohokenIchiran_Row> getDgIryohokenIchiran() {
        return dgIryohokenIchiran;
    }

    /*
     * setdgIryohokenIchiran
     * @param dgIryohokenIchiran dgIryohokenIchiran
     */
    @JsonProperty("dgIryohokenIchiran")
    public void setDgIryohokenIchiran(DataGrid<dgIryohokenIchiran_Row> dgIryohokenIchiran) {
        this.dgIryohokenIchiran = dgIryohokenIchiran;
    }

    /*
     * getpnlIryohokenJoho
     * @return pnlIryohokenJoho
     */
    @JsonProperty("pnlIryohokenJoho")
    public pnlIryohokenJohoDiv getPnlIryohokenJoho() {
        return pnlIryohokenJoho;
    }

    /*
     * setpnlIryohokenJoho
     * @param pnlIryohokenJoho pnlIryohokenJoho
     */
    @JsonProperty("pnlIryohokenJoho")
    public void setPnlIryohokenJoho(pnlIryohokenJohoDiv pnlIryohokenJoho) {
        this.pnlIryohokenJoho = pnlIryohokenJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTbdKanyubi() {
        return this.getPnlIryohokenJoho().getTbdKanyubi();
    }

    @JsonIgnore
    public void  setTbdKanyubi(TextBoxDate tbdKanyubi) {
        this.getPnlIryohokenJoho().setTbdKanyubi(tbdKanyubi);
    }

    @JsonIgnore
    public TextBoxDate getTbdDattabi() {
        return this.getPnlIryohokenJoho().getTbdDattabi();
    }

    @JsonIgnore
    public void  setTbdDattabi(TextBoxDate tbdDattabi) {
        this.getPnlIryohokenJoho().setTbdDattabi(tbdDattabi);
    }

    @JsonIgnore
    public DropDownList getDdlSyubetsu() {
        return this.getPnlIryohokenJoho().getDdlSyubetsu();
    }

    @JsonIgnore
    public void  setDdlSyubetsu(DropDownList ddlSyubetsu) {
        this.getPnlIryohokenJoho().setDdlSyubetsu(ddlSyubetsu);
    }

    @JsonIgnore
    public TextBox getTxtHokensyaKodo() {
        return this.getPnlIryohokenJoho().getTxtHokensyaKodo();
    }

    @JsonIgnore
    public void  setTxtHokensyaKodo(TextBox txtHokensyaKodo) {
        this.getPnlIryohokenJoho().setTxtHokensyaKodo(txtHokensyaKodo);
    }

    @JsonIgnore
    public TextBox getTxtHokensyaMeisho() {
        return this.getPnlIryohokenJoho().getTxtHokensyaMeisho();
    }

    @JsonIgnore
    public void  setTxtHokensyaMeisho(TextBox txtHokensyaMeisho) {
        this.getPnlIryohokenJoho().setTxtHokensyaMeisho(txtHokensyaMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKigoBango() {
        return this.getPnlIryohokenJoho().getTxtKigoBango();
    }

    @JsonIgnore
    public void  setTxtKigoBango(TextBox txtKigoBango) {
        this.getPnlIryohokenJoho().setTxtKigoBango(txtKigoBango);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getPnlIryohokenJoho().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getPnlIryohokenJoho().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPnlIryohokenJoho().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPnlIryohokenJoho().setBtnCancel(btnCancel);
    }

    // </editor-fold>
}
