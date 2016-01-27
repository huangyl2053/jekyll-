package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
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
 * tblTextTokkiJiko のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTextTokkiJikoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTextTokkiJikoTitle")
    private celTextTokkiJikoTitleAttblTextTokkiJiko celTextTokkiJikoTitle;
    @JsonProperty("celTextTokkiJikoGun")
    private celTextTokkiJikoGunAttblTextTokkiJiko celTextTokkiJikoGun;
    @JsonProperty("celTextTokkiJikoHyphen")
    private celTextTokkiJikoHyphenAttblTextTokkiJiko celTextTokkiJikoHyphen;
    @JsonProperty("celTokkiJikoNoText")
    private celTokkiJikoNoTextAttblTextTokkiJiko celTokkiJikoNoText;
    @JsonProperty("celTextTokkiJikoNaiyo")
    private celTextTokkiJikoNaiyoAttblTextTokkiJiko celTextTokkiJikoNaiyo;
    @JsonProperty("celTokkijikoInput")
    private celTokkijikoInputAttblTextTokkiJiko celTokkijikoInput;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblTextTokkiJikoTitle() {
        return this.celTextTokkiJikoTitle.getLblTextTokkiJikoTitle();
    }

    @JsonIgnore
    public Label getLblTextTokkiJikoGun() {
        return this.celTextTokkiJikoGun.getLblTextTokkiJikoGun();
    }

    @JsonIgnore
    public Label getLblTextTokkiJikoHyphen() {
        return this.celTextTokkiJikoHyphen.getLblTextTokkiJikoHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokkiJikoNoText() {
        return this.celTokkiJikoNoText.getTxtTokkiJikoNoText();
    }

    @JsonIgnore
    public Label getLblTextTokkiJikoNaiyo() {
        return this.celTextTokkiJikoNaiyo.getLblTextTokkiJikoNaiyo();
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikeiBunGuide() {
        return this.celTextTokkiJikoNaiyo.getBtnTeikeiBunGuide();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokkijikoInput() {
        return this.celTokkijikoInput.getTxtTokkijikoInput();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelTextTokkiJikoTitle
     * @return celTextTokkiJikoTitle
     */
    @JsonProperty("celTextTokkiJikoTitle")
    private celTextTokkiJikoTitleAttblTextTokkiJiko getCelTextTokkiJikoTitle() {
        return celTextTokkiJikoTitle;
    }

    /*
     * setcelTextTokkiJikoTitle
     * @param celTextTokkiJikoTitle celTextTokkiJikoTitle
     */
    @JsonProperty("celTextTokkiJikoTitle")
    private void setCelTextTokkiJikoTitle(celTextTokkiJikoTitleAttblTextTokkiJiko celTextTokkiJikoTitle) {
        this.celTextTokkiJikoTitle = celTextTokkiJikoTitle;
    }

    /*
     * getcelTextTokkiJikoGun
     * @return celTextTokkiJikoGun
     */
    @JsonProperty("celTextTokkiJikoGun")
    private celTextTokkiJikoGunAttblTextTokkiJiko getCelTextTokkiJikoGun() {
        return celTextTokkiJikoGun;
    }

    /*
     * setcelTextTokkiJikoGun
     * @param celTextTokkiJikoGun celTextTokkiJikoGun
     */
    @JsonProperty("celTextTokkiJikoGun")
    private void setCelTextTokkiJikoGun(celTextTokkiJikoGunAttblTextTokkiJiko celTextTokkiJikoGun) {
        this.celTextTokkiJikoGun = celTextTokkiJikoGun;
    }

    /*
     * getcelTextTokkiJikoHyphen
     * @return celTextTokkiJikoHyphen
     */
    @JsonProperty("celTextTokkiJikoHyphen")
    private celTextTokkiJikoHyphenAttblTextTokkiJiko getCelTextTokkiJikoHyphen() {
        return celTextTokkiJikoHyphen;
    }

    /*
     * setcelTextTokkiJikoHyphen
     * @param celTextTokkiJikoHyphen celTextTokkiJikoHyphen
     */
    @JsonProperty("celTextTokkiJikoHyphen")
    private void setCelTextTokkiJikoHyphen(celTextTokkiJikoHyphenAttblTextTokkiJiko celTextTokkiJikoHyphen) {
        this.celTextTokkiJikoHyphen = celTextTokkiJikoHyphen;
    }

    /*
     * getcelTokkiJikoNoText
     * @return celTokkiJikoNoText
     */
    @JsonProperty("celTokkiJikoNoText")
    private celTokkiJikoNoTextAttblTextTokkiJiko getCelTokkiJikoNoText() {
        return celTokkiJikoNoText;
    }

    /*
     * setcelTokkiJikoNoText
     * @param celTokkiJikoNoText celTokkiJikoNoText
     */
    @JsonProperty("celTokkiJikoNoText")
    private void setCelTokkiJikoNoText(celTokkiJikoNoTextAttblTextTokkiJiko celTokkiJikoNoText) {
        this.celTokkiJikoNoText = celTokkiJikoNoText;
    }

    /*
     * getcelTextTokkiJikoNaiyo
     * @return celTextTokkiJikoNaiyo
     */
    @JsonProperty("celTextTokkiJikoNaiyo")
    private celTextTokkiJikoNaiyoAttblTextTokkiJiko getCelTextTokkiJikoNaiyo() {
        return celTextTokkiJikoNaiyo;
    }

    /*
     * setcelTextTokkiJikoNaiyo
     * @param celTextTokkiJikoNaiyo celTextTokkiJikoNaiyo
     */
    @JsonProperty("celTextTokkiJikoNaiyo")
    private void setCelTextTokkiJikoNaiyo(celTextTokkiJikoNaiyoAttblTextTokkiJiko celTextTokkiJikoNaiyo) {
        this.celTextTokkiJikoNaiyo = celTextTokkiJikoNaiyo;
    }

    /*
     * getcelTokkijikoInput
     * @return celTokkijikoInput
     */
    @JsonProperty("celTokkijikoInput")
    private celTokkijikoInputAttblTextTokkiJiko getCelTokkijikoInput() {
        return celTokkijikoInput;
    }

    /*
     * setcelTokkijikoInput
     * @param celTokkijikoInput celTokkijikoInput
     */
    @JsonProperty("celTokkijikoInput")
    private void setCelTokkijikoInput(celTokkijikoInputAttblTextTokkiJiko celTokkijikoInput) {
        this.celTokkijikoInput = celTokkijikoInput;
    }

    // </editor-fold>
}
/**
 * celTextTokkiJikoTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celTextTokkiJikoTitleAttblTextTokkiJiko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblTextTokkiJikoTitle")
    private Label lblTextTokkiJikoTitle;

    /*
     * getlblTextTokkiJikoTitle
     * @return lblTextTokkiJikoTitle
     */
    @JsonProperty("lblTextTokkiJikoTitle")
    public Label getLblTextTokkiJikoTitle() {
        return lblTextTokkiJikoTitle;
    }

    /*
     * setlblTextTokkiJikoTitle
     * @param lblTextTokkiJikoTitle lblTextTokkiJikoTitle
     */
    @JsonProperty("lblTextTokkiJikoTitle")
    public void setLblTextTokkiJikoTitle(Label lblTextTokkiJikoTitle) {
        this.lblTextTokkiJikoTitle = lblTextTokkiJikoTitle;
    }

    // </editor-fold>
}
/**
 * celTextTokkiJikoGun のクラスファイル 
 * 
 * @author 自動生成
 */
class celTextTokkiJikoGunAttblTextTokkiJiko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblTextTokkiJikoGun")
    private Label lblTextTokkiJikoGun;

    /*
     * getlblTextTokkiJikoGun
     * @return lblTextTokkiJikoGun
     */
    @JsonProperty("lblTextTokkiJikoGun")
    public Label getLblTextTokkiJikoGun() {
        return lblTextTokkiJikoGun;
    }

    /*
     * setlblTextTokkiJikoGun
     * @param lblTextTokkiJikoGun lblTextTokkiJikoGun
     */
    @JsonProperty("lblTextTokkiJikoGun")
    public void setLblTextTokkiJikoGun(Label lblTextTokkiJikoGun) {
        this.lblTextTokkiJikoGun = lblTextTokkiJikoGun;
    }

    // </editor-fold>
}
/**
 * celTextTokkiJikoHyphen のクラスファイル 
 * 
 * @author 自動生成
 */
class celTextTokkiJikoHyphenAttblTextTokkiJiko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblTextTokkiJikoHyphen")
    private Label lblTextTokkiJikoHyphen;

    /*
     * getlblTextTokkiJikoHyphen
     * @return lblTextTokkiJikoHyphen
     */
    @JsonProperty("lblTextTokkiJikoHyphen")
    public Label getLblTextTokkiJikoHyphen() {
        return lblTextTokkiJikoHyphen;
    }

    /*
     * setlblTextTokkiJikoHyphen
     * @param lblTextTokkiJikoHyphen lblTextTokkiJikoHyphen
     */
    @JsonProperty("lblTextTokkiJikoHyphen")
    public void setLblTextTokkiJikoHyphen(Label lblTextTokkiJikoHyphen) {
        this.lblTextTokkiJikoHyphen = lblTextTokkiJikoHyphen;
    }

    // </editor-fold>
}
/**
 * celTokkiJikoNoText のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokkiJikoNoTextAttblTextTokkiJiko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtTokkiJikoNoText")
    private TextBoxNum txtTokkiJikoNoText;

    /*
     * gettxtTokkiJikoNoText
     * @return txtTokkiJikoNoText
     */
    @JsonProperty("txtTokkiJikoNoText")
    public TextBoxNum getTxtTokkiJikoNoText() {
        return txtTokkiJikoNoText;
    }

    /*
     * settxtTokkiJikoNoText
     * @param txtTokkiJikoNoText txtTokkiJikoNoText
     */
    @JsonProperty("txtTokkiJikoNoText")
    public void setTxtTokkiJikoNoText(TextBoxNum txtTokkiJikoNoText) {
        this.txtTokkiJikoNoText = txtTokkiJikoNoText;
    }

    // </editor-fold>
}
/**
 * celTextTokkiJikoNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
class celTextTokkiJikoNaiyoAttblTextTokkiJiko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblTextTokkiJikoNaiyo")
    private Label lblTextTokkiJikoNaiyo;
    @JsonProperty("btnTeikeiBunGuide")
    private ButtonDialog btnTeikeiBunGuide;

    /*
     * getlblTextTokkiJikoNaiyo
     * @return lblTextTokkiJikoNaiyo
     */
    @JsonProperty("lblTextTokkiJikoNaiyo")
    public Label getLblTextTokkiJikoNaiyo() {
        return lblTextTokkiJikoNaiyo;
    }

    /*
     * setlblTextTokkiJikoNaiyo
     * @param lblTextTokkiJikoNaiyo lblTextTokkiJikoNaiyo
     */
    @JsonProperty("lblTextTokkiJikoNaiyo")
    public void setLblTextTokkiJikoNaiyo(Label lblTextTokkiJikoNaiyo) {
        this.lblTextTokkiJikoNaiyo = lblTextTokkiJikoNaiyo;
    }

    /*
     * getbtnTeikeiBunGuide
     * @return btnTeikeiBunGuide
     */
    @JsonProperty("btnTeikeiBunGuide")
    public ButtonDialog getBtnTeikeiBunGuide() {
        return btnTeikeiBunGuide;
    }

    /*
     * setbtnTeikeiBunGuide
     * @param btnTeikeiBunGuide btnTeikeiBunGuide
     */
    @JsonProperty("btnTeikeiBunGuide")
    public void setBtnTeikeiBunGuide(ButtonDialog btnTeikeiBunGuide) {
        this.btnTeikeiBunGuide = btnTeikeiBunGuide;
    }

    // </editor-fold>
}
/**
 * celTokkijikoInput のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokkijikoInputAttblTextTokkiJiko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtTokkijikoInput")
    private TextBoxMultiLine txtTokkijikoInput;

    /*
     * gettxtTokkijikoInput
     * @return txtTokkijikoInput
     */
    @JsonProperty("txtTokkijikoInput")
    public TextBoxMultiLine getTxtTokkijikoInput() {
        return txtTokkijikoInput;
    }

    /*
     * settxtTokkijikoInput
     * @param txtTokkijikoInput txtTokkijikoInput
     */
    @JsonProperty("txtTokkijikoInput")
    public void setTxtTokkijikoInput(TextBoxMultiLine txtTokkijikoInput) {
        this.txtTokkijikoInput = txtTokkijikoInput;
    }

    // </editor-fold>
}
