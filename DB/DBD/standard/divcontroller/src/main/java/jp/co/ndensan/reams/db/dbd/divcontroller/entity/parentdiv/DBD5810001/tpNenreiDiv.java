package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5810001;
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
 * tpNenrei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tpNenreiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tcRdoNenrei")
    private tcRdoNenreiAttpNenrei tcRdoNenrei;
    @JsonProperty("tcNenrei")
    private tcNenreiAttpNenrei tcNenrei;
    @JsonProperty("tcNenrei3")
    private tcNenrei3AttpNenrei tcNenrei3;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public RadioButton getRdoNenrei() {
        return this.tcRdoNenrei.getRdoNenrei();
    }

    @JsonIgnore
    public TextBoxNumRange getTxtNenrei() {
        return this.tcNenrei.getTxtNenrei();
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreikijyun() {
        return this.tcNenrei.getTxtNenreikijyun();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSeinen() {
        return this.tcNenrei.getTxtSeinen();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettcRdoNenrei
     * @return tcRdoNenrei
     */
    @JsonProperty("tcRdoNenrei")
    private tcRdoNenreiAttpNenrei getTcRdoNenrei() {
        return tcRdoNenrei;
    }

    /*
     * settcRdoNenrei
     * @param tcRdoNenrei tcRdoNenrei
     */
    @JsonProperty("tcRdoNenrei")
    private void setTcRdoNenrei(tcRdoNenreiAttpNenrei tcRdoNenrei) {
        this.tcRdoNenrei = tcRdoNenrei;
    }

    /*
     * gettcNenrei
     * @return tcNenrei
     */
    @JsonProperty("tcNenrei")
    private tcNenreiAttpNenrei getTcNenrei() {
        return tcNenrei;
    }

    /*
     * settcNenrei
     * @param tcNenrei tcNenrei
     */
    @JsonProperty("tcNenrei")
    private void setTcNenrei(tcNenreiAttpNenrei tcNenrei) {
        this.tcNenrei = tcNenrei;
    }

    /*
     * gettcNenrei3
     * @return tcNenrei3
     */
    @JsonProperty("tcNenrei3")
    private tcNenrei3AttpNenrei getTcNenrei3() {
        return tcNenrei3;
    }

    /*
     * settcNenrei3
     * @param tcNenrei3 tcNenrei3
     */
    @JsonProperty("tcNenrei3")
    private void setTcNenrei3(tcNenrei3AttpNenrei tcNenrei3) {
        this.tcNenrei3 = tcNenrei3;
    }

    // </editor-fold>
}
/**
 * tcRdoNenrei のクラスファイル 
 * 
 * @author 自動生成
 */
class tcRdoNenreiAttpNenrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("rdoNenrei")
    private RadioButton rdoNenrei;

    /*
     * getrdoNenrei
     * @return rdoNenrei
     */
    @JsonProperty("rdoNenrei")
    public RadioButton getRdoNenrei() {
        return rdoNenrei;
    }

    /*
     * setrdoNenrei
     * @param rdoNenrei rdoNenrei
     */
    @JsonProperty("rdoNenrei")
    public void setRdoNenrei(RadioButton rdoNenrei) {
        this.rdoNenrei = rdoNenrei;
    }

    // </editor-fold>
}
/**
 * tcNenrei のクラスファイル 
 * 
 * @author 自動生成
 */
class tcNenreiAttpNenrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtNenrei")
    private TextBoxNumRange txtNenrei;
    @JsonProperty("txtNenreikijyun")
    private TextBoxDate txtNenreikijyun;
    @JsonProperty("txtSeinen")
    private TextBoxDateRange txtSeinen;

    /*
     * gettxtNenrei
     * @return txtNenrei
     */
    @JsonProperty("txtNenrei")
    public TextBoxNumRange getTxtNenrei() {
        return txtNenrei;
    }

    /*
     * settxtNenrei
     * @param txtNenrei txtNenrei
     */
    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBoxNumRange txtNenrei) {
        this.txtNenrei = txtNenrei;
    }

    /*
     * gettxtNenreikijyun
     * @return txtNenreikijyun
     */
    @JsonProperty("txtNenreikijyun")
    public TextBoxDate getTxtNenreikijyun() {
        return txtNenreikijyun;
    }

    /*
     * settxtNenreikijyun
     * @param txtNenreikijyun txtNenreikijyun
     */
    @JsonProperty("txtNenreikijyun")
    public void setTxtNenreikijyun(TextBoxDate txtNenreikijyun) {
        this.txtNenreikijyun = txtNenreikijyun;
    }

    /*
     * gettxtSeinen
     * @return txtSeinen
     */
    @JsonProperty("txtSeinen")
    public TextBoxDateRange getTxtSeinen() {
        return txtSeinen;
    }

    /*
     * settxtSeinen
     * @param txtSeinen txtSeinen
     */
    @JsonProperty("txtSeinen")
    public void setTxtSeinen(TextBoxDateRange txtSeinen) {
        this.txtSeinen = txtSeinen;
    }

    // </editor-fold>
}
/**
 * tcNenrei3 のクラスファイル 
 * 
 * @author 自動生成
 */
class tcNenrei3AttpNenrei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    // </editor-fold>
}
