package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0140011;
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
 * SouShinFileInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SouShinFileInfoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTorikomi")
    private celTorikomiAtSouShinFileInfo celTorikomi;
    @JsonProperty("celKensu")
    private celKensuAtSouShinFileInfo celKensu;
    @JsonProperty("celSakuseiDate")
    private celSakuseiDateAtSouShinFileInfo celSakuseiDate;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Button getBtnTorikomi() {
        return this.celTorikomi.getBtnTorikomi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKensu() {
        return this.celKensu.getTxtKensu();
    }

    @JsonIgnore
    public Label getLblTani() {
        return this.celKensu.getLblTani();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD() {
        return this.celSakuseiDate.getTxtSakuseiYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime() {
        return this.celSakuseiDate.getTxtSakuseiTime();
    }

    @JsonIgnore
    public Label getLblKuran() {
        return this.celSakuseiDate.getLblKuran();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelTorikomi
     * @return celTorikomi
     */
    @JsonProperty("celTorikomi")
    private celTorikomiAtSouShinFileInfo getCelTorikomi() {
        return celTorikomi;
    }

    /*
     * setcelTorikomi
     * @param celTorikomi celTorikomi
     */
    @JsonProperty("celTorikomi")
    private void setCelTorikomi(celTorikomiAtSouShinFileInfo celTorikomi) {
        this.celTorikomi = celTorikomi;
    }

    /*
     * getcelKensu
     * @return celKensu
     */
    @JsonProperty("celKensu")
    private celKensuAtSouShinFileInfo getCelKensu() {
        return celKensu;
    }

    /*
     * setcelKensu
     * @param celKensu celKensu
     */
    @JsonProperty("celKensu")
    private void setCelKensu(celKensuAtSouShinFileInfo celKensu) {
        this.celKensu = celKensu;
    }

    /*
     * getcelSakuseiDate
     * @return celSakuseiDate
     */
    @JsonProperty("celSakuseiDate")
    private celSakuseiDateAtSouShinFileInfo getCelSakuseiDate() {
        return celSakuseiDate;
    }

    /*
     * setcelSakuseiDate
     * @param celSakuseiDate celSakuseiDate
     */
    @JsonProperty("celSakuseiDate")
    private void setCelSakuseiDate(celSakuseiDateAtSouShinFileInfo celSakuseiDate) {
        this.celSakuseiDate = celSakuseiDate;
    }

    // </editor-fold>
}
/**
 * celTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
class celTorikomiAtSouShinFileInfo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("btnTorikomi")
    private Button btnTorikomi;

    /*
     * getbtnTorikomi
     * @return btnTorikomi
     */
    @JsonProperty("btnTorikomi")
    public Button getBtnTorikomi() {
        return btnTorikomi;
    }

    /*
     * setbtnTorikomi
     * @param btnTorikomi btnTorikomi
     */
    @JsonProperty("btnTorikomi")
    public void setBtnTorikomi(Button btnTorikomi) {
        this.btnTorikomi = btnTorikomi;
    }

    // </editor-fold>
}
/**
 * celKensu のクラスファイル 
 * 
 * @author 自動生成
 */
class celKensuAtSouShinFileInfo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtKensu")
    private TextBoxNum txtKensu;
    @JsonProperty("lblTani")
    private Label lblTani;

    /*
     * gettxtKensu
     * @return txtKensu
     */
    @JsonProperty("txtKensu")
    public TextBoxNum getTxtKensu() {
        return txtKensu;
    }

    /*
     * settxtKensu
     * @param txtKensu txtKensu
     */
    @JsonProperty("txtKensu")
    public void setTxtKensu(TextBoxNum txtKensu) {
        this.txtKensu = txtKensu;
    }

    /*
     * getlblTani
     * @return lblTani
     */
    @JsonProperty("lblTani")
    public Label getLblTani() {
        return lblTani;
    }

    /*
     * setlblTani
     * @param lblTani lblTani
     */
    @JsonProperty("lblTani")
    public void setLblTani(Label lblTani) {
        this.lblTani = lblTani;
    }

    // </editor-fold>
}
/**
 * celSakuseiDate のクラスファイル 
 * 
 * @author 自動生成
 */
class celSakuseiDateAtSouShinFileInfo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtSakuseiYMD")
    private TextBoxDate txtSakuseiYMD;
    @JsonProperty("txtSakuseiTime")
    private TextBoxTime txtSakuseiTime;
    @JsonProperty("lblKuran")
    private Label lblKuran;

    /*
     * gettxtSakuseiYMD
     * @return txtSakuseiYMD
     */
    @JsonProperty("txtSakuseiYMD")
    public TextBoxDate getTxtSakuseiYMD() {
        return txtSakuseiYMD;
    }

    /*
     * settxtSakuseiYMD
     * @param txtSakuseiYMD txtSakuseiYMD
     */
    @JsonProperty("txtSakuseiYMD")
    public void setTxtSakuseiYMD(TextBoxDate txtSakuseiYMD) {
        this.txtSakuseiYMD = txtSakuseiYMD;
    }

    /*
     * gettxtSakuseiTime
     * @return txtSakuseiTime
     */
    @JsonProperty("txtSakuseiTime")
    public TextBoxTime getTxtSakuseiTime() {
        return txtSakuseiTime;
    }

    /*
     * settxtSakuseiTime
     * @param txtSakuseiTime txtSakuseiTime
     */
    @JsonProperty("txtSakuseiTime")
    public void setTxtSakuseiTime(TextBoxTime txtSakuseiTime) {
        this.txtSakuseiTime = txtSakuseiTime;
    }

    /*
     * getlblKuran
     * @return lblKuran
     */
    @JsonProperty("lblKuran")
    public Label getLblKuran() {
        return lblKuran;
    }

    /*
     * setlblKuran
     * @param lblKuran lblKuran
     */
    @JsonProperty("lblKuran")
    public void setLblKuran(Label lblKuran) {
        this.lblKuran = lblKuran;
    }

    // </editor-fold>
}
