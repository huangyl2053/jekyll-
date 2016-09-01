package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5830001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tp1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tp1Div extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tc1")
    private tc1Attp1 tc1;
    @JsonProperty("tc2")
    private tc2Attp1 tc2;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public RadioButton getRdoKijyun() {
        return this.tc1.getRdoKijyun();
    }

    @JsonIgnore
    public TextBoxDate getTxtKijyunD() {
        return this.tc2.getTxtKijyunD();
    }

    @JsonIgnore
    public TextBoxDate getTxtKijyunYM() {
        return this.tc2.getTxtKijyunYM();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettc1
     * @return tc1
     */
    @JsonProperty("tc1")
    private tc1Attp1 getTc1() {
        return tc1;
    }

    /*
     * settc1
     * @param tc1 tc1
     */
    @JsonProperty("tc1")
    private void setTc1(tc1Attp1 tc1) {
        this.tc1 = tc1;
    }

    /*
     * gettc2
     * @return tc2
     */
    @JsonProperty("tc2")
    private tc2Attp1 getTc2() {
        return tc2;
    }

    /*
     * settc2
     * @param tc2 tc2
     */
    @JsonProperty("tc2")
    private void setTc2(tc2Attp1 tc2) {
        this.tc2 = tc2;
    }

    // </editor-fold>
}
/**
 * tc1 のクラスファイル 
 * 
 * @author 自動生成
 */
class tc1Attp1 extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("rdoKijyun")
    private RadioButton rdoKijyun;

    /*
     * getrdoKijyun
     * @return rdoKijyun
     */
    @JsonProperty("rdoKijyun")
    public RadioButton getRdoKijyun() {
        return rdoKijyun;
    }

    /*
     * setrdoKijyun
     * @param rdoKijyun rdoKijyun
     */
    @JsonProperty("rdoKijyun")
    public void setRdoKijyun(RadioButton rdoKijyun) {
        this.rdoKijyun = rdoKijyun;
    }

    // </editor-fold>
}
/**
 * tc2 のクラスファイル 
 * 
 * @author 自動生成
 */
class tc2Attp1 extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtKijyunD")
    private TextBoxDate txtKijyunD;
    @JsonProperty("txtKijyunYM")
    private TextBoxDate txtKijyunYM;

    /*
     * gettxtKijyunD
     * @return txtKijyunD
     */
    @JsonProperty("txtKijyunD")
    public TextBoxDate getTxtKijyunD() {
        return txtKijyunD;
    }

    /*
     * settxtKijyunD
     * @param txtKijyunD txtKijyunD
     */
    @JsonProperty("txtKijyunD")
    public void setTxtKijyunD(TextBoxDate txtKijyunD) {
        this.txtKijyunD = txtKijyunD;
    }

    /*
     * gettxtKijyunYM
     * @return txtKijyunYM
     */
    @JsonProperty("txtKijyunYM")
    public TextBoxDate getTxtKijyunYM() {
        return txtKijyunYM;
    }

    /*
     * settxtKijyunYM
     * @param txtKijyunYM txtKijyunYM
     */
    @JsonProperty("txtKijyunYM")
    public void setTxtKijyunYM(TextBoxDate txtKijyunYM) {
        this.txtKijyunYM = txtKijyunYM;
    }

    // </editor-fold>
}
