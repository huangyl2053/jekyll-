package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5090001;
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
 * Ninteishinseibi のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteishinseibiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TxtRdoShinseiNintei")
    private TxtRdoShinseiNinteiDiv TxtRdoShinseiNintei;
    @JsonProperty("txtShinseiNintei")
    private txtShinseiNinteiDiv txtShinseiNintei;
    @JsonProperty("rdoSyutsuryoku")
    private RadioButton rdoSyutsuryoku;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("btnKensakuClear")
    private Button btnKensakuClear;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTxtRdoShinseiNintei
     * @return TxtRdoShinseiNintei
     */
    @JsonProperty("TxtRdoShinseiNintei")
    public TxtRdoShinseiNinteiDiv getTxtRdoShinseiNintei() {
        return TxtRdoShinseiNintei;
    }

    /*
     * setTxtRdoShinseiNintei
     * @param TxtRdoShinseiNintei TxtRdoShinseiNintei
     */
    @JsonProperty("TxtRdoShinseiNintei")
    public void setTxtRdoShinseiNintei(TxtRdoShinseiNinteiDiv TxtRdoShinseiNintei) {
        this.TxtRdoShinseiNintei = TxtRdoShinseiNintei;
    }

    /*
     * gettxtShinseiNintei
     * @return txtShinseiNintei
     */
    @JsonProperty("txtShinseiNintei")
    public txtShinseiNinteiDiv getTxtShinseiNintei() {
        return txtShinseiNintei;
    }

    /*
     * settxtShinseiNintei
     * @param txtShinseiNintei txtShinseiNintei
     */
    @JsonProperty("txtShinseiNintei")
    public void setTxtShinseiNintei(txtShinseiNinteiDiv txtShinseiNintei) {
        this.txtShinseiNintei = txtShinseiNintei;
    }

    /*
     * getrdoSyutsuryoku
     * @return rdoSyutsuryoku
     */
    @JsonProperty("rdoSyutsuryoku")
    public RadioButton getRdoSyutsuryoku() {
        return rdoSyutsuryoku;
    }

    /*
     * setrdoSyutsuryoku
     * @param rdoSyutsuryoku rdoSyutsuryoku
     */
    @JsonProperty("rdoSyutsuryoku")
    public void setRdoSyutsuryoku(RadioButton rdoSyutsuryoku) {
        this.rdoSyutsuryoku = rdoSyutsuryoku;
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

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRdoShinseiNintei() {
        return this.getTxtRdoShinseiNintei().getRdoShinseiNintei();
    }

    @JsonIgnore
    public void  setRdoShinseiNintei(RadioButton rdoShinseiNintei) {
        this.getTxtRdoShinseiNintei().setRdoShinseiNintei(rdoShinseiNintei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseiYMD() {
        return this.getTxtShinseiNintei().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDateRange txtShinseiYMD) {
        this.getTxtShinseiNintei().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getNinteiYMD() {
        return this.getTxtShinseiNintei().getNinteiYMD();
    }

    @JsonIgnore
    public void  setNinteiYMD(TextBoxDateRange NinteiYMD) {
        this.getTxtShinseiNintei().setNinteiYMD(NinteiYMD);
    }

    // </editor-fold>
}
