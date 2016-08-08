package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchiGojiHanteiKekkaJoho;
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
 * tblTyukanHyokaKomokuTokuten のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTyukanHyokaKomokuTokutenDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celDai1gunHeader")
    private celDai1gunHeaderAttblTyukanHyokaKomokuTokuten celDai1gunHeader;
    @JsonProperty("celDai2gunHeader")
    private celDai2gunHeaderAttblTyukanHyokaKomokuTokuten celDai2gunHeader;
    @JsonProperty("celDai3gunHeader")
    private celDai3gunHeaderAttblTyukanHyokaKomokuTokuten celDai3gunHeader;
    @JsonProperty("celDai4gunHeader")
    private celDai4gunHeaderAttblTyukanHyokaKomokuTokuten celDai4gunHeader;
    @JsonProperty("celDai5gunHeader")
    private celDai5gunHeaderAttblTyukanHyokaKomokuTokuten celDai5gunHeader;
    @JsonProperty("celDai1gun")
    private celDai1gunAttblTyukanHyokaKomokuTokuten celDai1gun;
    @JsonProperty("celDai2gun")
    private celDai2gunAttblTyukanHyokaKomokuTokuten celDai2gun;
    @JsonProperty("celDai3gun")
    private celDai3gunAttblTyukanHyokaKomokuTokuten celDai3gun;
    @JsonProperty("celDai4gun")
    private celDai4gunAttblTyukanHyokaKomokuTokuten celDai4gun;
    @JsonProperty("celDai5gun")
    private celDai5gunAttblTyukanHyokaKomokuTokuten celDai5gun;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDai1gun() {
        return this.celDai1gunHeader.getLblDai1gun();
    }

    @JsonIgnore
    public Label getLblDai2gun() {
        return this.celDai2gunHeader.getLblDai2gun();
    }

    @JsonIgnore
    public Label getLblDai3gun() {
        return this.celDai3gunHeader.getLblDai3gun();
    }

    @JsonIgnore
    public Label getLblDai4gun() {
        return this.celDai4gunHeader.getLblDai4gun();
    }

    @JsonIgnore
    public Label getLblDai5gun() {
        return this.celDai5gunHeader.getLblDai5gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai1gun() {
        return this.celDai1gun.getTxtDai1gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai2gun() {
        return this.celDai2gun.getTxtDai2gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai3gun() {
        return this.celDai3gun.getTxtDai3gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai4gun() {
        return this.celDai4gun.getTxtDai4gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai5gun() {
        return this.celDai5gun.getTxtDai5gun();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelDai1gunHeader
     * @return celDai1gunHeader
     */
    @JsonProperty("celDai1gunHeader")
    private celDai1gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai1gunHeader() {
        return celDai1gunHeader;
    }

    /*
     * setcelDai1gunHeader
     * @param celDai1gunHeader celDai1gunHeader
     */
    @JsonProperty("celDai1gunHeader")
    private void setCelDai1gunHeader(celDai1gunHeaderAttblTyukanHyokaKomokuTokuten celDai1gunHeader) {
        this.celDai1gunHeader = celDai1gunHeader;
    }

    /*
     * getcelDai2gunHeader
     * @return celDai2gunHeader
     */
    @JsonProperty("celDai2gunHeader")
    private celDai2gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai2gunHeader() {
        return celDai2gunHeader;
    }

    /*
     * setcelDai2gunHeader
     * @param celDai2gunHeader celDai2gunHeader
     */
    @JsonProperty("celDai2gunHeader")
    private void setCelDai2gunHeader(celDai2gunHeaderAttblTyukanHyokaKomokuTokuten celDai2gunHeader) {
        this.celDai2gunHeader = celDai2gunHeader;
    }

    /*
     * getcelDai3gunHeader
     * @return celDai3gunHeader
     */
    @JsonProperty("celDai3gunHeader")
    private celDai3gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai3gunHeader() {
        return celDai3gunHeader;
    }

    /*
     * setcelDai3gunHeader
     * @param celDai3gunHeader celDai3gunHeader
     */
    @JsonProperty("celDai3gunHeader")
    private void setCelDai3gunHeader(celDai3gunHeaderAttblTyukanHyokaKomokuTokuten celDai3gunHeader) {
        this.celDai3gunHeader = celDai3gunHeader;
    }

    /*
     * getcelDai4gunHeader
     * @return celDai4gunHeader
     */
    @JsonProperty("celDai4gunHeader")
    private celDai4gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai4gunHeader() {
        return celDai4gunHeader;
    }

    /*
     * setcelDai4gunHeader
     * @param celDai4gunHeader celDai4gunHeader
     */
    @JsonProperty("celDai4gunHeader")
    private void setCelDai4gunHeader(celDai4gunHeaderAttblTyukanHyokaKomokuTokuten celDai4gunHeader) {
        this.celDai4gunHeader = celDai4gunHeader;
    }

    /*
     * getcelDai5gunHeader
     * @return celDai5gunHeader
     */
    @JsonProperty("celDai5gunHeader")
    private celDai5gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai5gunHeader() {
        return celDai5gunHeader;
    }

    /*
     * setcelDai5gunHeader
     * @param celDai5gunHeader celDai5gunHeader
     */
    @JsonProperty("celDai5gunHeader")
    private void setCelDai5gunHeader(celDai5gunHeaderAttblTyukanHyokaKomokuTokuten celDai5gunHeader) {
        this.celDai5gunHeader = celDai5gunHeader;
    }

    /*
     * getcelDai1gun
     * @return celDai1gun
     */
    @JsonProperty("celDai1gun")
    private celDai1gunAttblTyukanHyokaKomokuTokuten getCelDai1gun() {
        return celDai1gun;
    }

    /*
     * setcelDai1gun
     * @param celDai1gun celDai1gun
     */
    @JsonProperty("celDai1gun")
    private void setCelDai1gun(celDai1gunAttblTyukanHyokaKomokuTokuten celDai1gun) {
        this.celDai1gun = celDai1gun;
    }

    /*
     * getcelDai2gun
     * @return celDai2gun
     */
    @JsonProperty("celDai2gun")
    private celDai2gunAttblTyukanHyokaKomokuTokuten getCelDai2gun() {
        return celDai2gun;
    }

    /*
     * setcelDai2gun
     * @param celDai2gun celDai2gun
     */
    @JsonProperty("celDai2gun")
    private void setCelDai2gun(celDai2gunAttblTyukanHyokaKomokuTokuten celDai2gun) {
        this.celDai2gun = celDai2gun;
    }

    /*
     * getcelDai3gun
     * @return celDai3gun
     */
    @JsonProperty("celDai3gun")
    private celDai3gunAttblTyukanHyokaKomokuTokuten getCelDai3gun() {
        return celDai3gun;
    }

    /*
     * setcelDai3gun
     * @param celDai3gun celDai3gun
     */
    @JsonProperty("celDai3gun")
    private void setCelDai3gun(celDai3gunAttblTyukanHyokaKomokuTokuten celDai3gun) {
        this.celDai3gun = celDai3gun;
    }

    /*
     * getcelDai4gun
     * @return celDai4gun
     */
    @JsonProperty("celDai4gun")
    private celDai4gunAttblTyukanHyokaKomokuTokuten getCelDai4gun() {
        return celDai4gun;
    }

    /*
     * setcelDai4gun
     * @param celDai4gun celDai4gun
     */
    @JsonProperty("celDai4gun")
    private void setCelDai4gun(celDai4gunAttblTyukanHyokaKomokuTokuten celDai4gun) {
        this.celDai4gun = celDai4gun;
    }

    /*
     * getcelDai5gun
     * @return celDai5gun
     */
    @JsonProperty("celDai5gun")
    private celDai5gunAttblTyukanHyokaKomokuTokuten getCelDai5gun() {
        return celDai5gun;
    }

    /*
     * setcelDai5gun
     * @param celDai5gun celDai5gun
     */
    @JsonProperty("celDai5gun")
    private void setCelDai5gun(celDai5gunAttblTyukanHyokaKomokuTokuten celDai5gun) {
        this.celDai5gun = celDai5gun;
    }

    // </editor-fold>
}
/**
 * celDai1gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai1gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblDai1gun")
    private Label lblDai1gun;

    /*
     * getlblDai1gun
     * @return lblDai1gun
     */
    @JsonProperty("lblDai1gun")
    public Label getLblDai1gun() {
        return lblDai1gun;
    }

    /*
     * setlblDai1gun
     * @param lblDai1gun lblDai1gun
     */
    @JsonProperty("lblDai1gun")
    public void setLblDai1gun(Label lblDai1gun) {
        this.lblDai1gun = lblDai1gun;
    }

    // </editor-fold>
}
/**
 * celDai2gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai2gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblDai2gun")
    private Label lblDai2gun;

    /*
     * getlblDai2gun
     * @return lblDai2gun
     */
    @JsonProperty("lblDai2gun")
    public Label getLblDai2gun() {
        return lblDai2gun;
    }

    /*
     * setlblDai2gun
     * @param lblDai2gun lblDai2gun
     */
    @JsonProperty("lblDai2gun")
    public void setLblDai2gun(Label lblDai2gun) {
        this.lblDai2gun = lblDai2gun;
    }

    // </editor-fold>
}
/**
 * celDai3gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai3gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblDai3gun")
    private Label lblDai3gun;

    /*
     * getlblDai3gun
     * @return lblDai3gun
     */
    @JsonProperty("lblDai3gun")
    public Label getLblDai3gun() {
        return lblDai3gun;
    }

    /*
     * setlblDai3gun
     * @param lblDai3gun lblDai3gun
     */
    @JsonProperty("lblDai3gun")
    public void setLblDai3gun(Label lblDai3gun) {
        this.lblDai3gun = lblDai3gun;
    }

    // </editor-fold>
}
/**
 * celDai4gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai4gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblDai4gun")
    private Label lblDai4gun;

    /*
     * getlblDai4gun
     * @return lblDai4gun
     */
    @JsonProperty("lblDai4gun")
    public Label getLblDai4gun() {
        return lblDai4gun;
    }

    /*
     * setlblDai4gun
     * @param lblDai4gun lblDai4gun
     */
    @JsonProperty("lblDai4gun")
    public void setLblDai4gun(Label lblDai4gun) {
        this.lblDai4gun = lblDai4gun;
    }

    // </editor-fold>
}
/**
 * celDai5gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai5gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblDai5gun")
    private Label lblDai5gun;

    /*
     * getlblDai5gun
     * @return lblDai5gun
     */
    @JsonProperty("lblDai5gun")
    public Label getLblDai5gun() {
        return lblDai5gun;
    }

    /*
     * setlblDai5gun
     * @param lblDai5gun lblDai5gun
     */
    @JsonProperty("lblDai5gun")
    public void setLblDai5gun(Label lblDai5gun) {
        this.lblDai5gun = lblDai5gun;
    }

    // </editor-fold>
}
/**
 * celDai1gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai1gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtDai1gun")
    private TextBoxNum txtDai1gun;

    /*
     * gettxtDai1gun
     * @return txtDai1gun
     */
    @JsonProperty("txtDai1gun")
    public TextBoxNum getTxtDai1gun() {
        return txtDai1gun;
    }

    /*
     * settxtDai1gun
     * @param txtDai1gun txtDai1gun
     */
    @JsonProperty("txtDai1gun")
    public void setTxtDai1gun(TextBoxNum txtDai1gun) {
        this.txtDai1gun = txtDai1gun;
    }

    // </editor-fold>
}
/**
 * celDai2gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai2gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtDai2gun")
    private TextBoxNum txtDai2gun;

    /*
     * gettxtDai2gun
     * @return txtDai2gun
     */
    @JsonProperty("txtDai2gun")
    public TextBoxNum getTxtDai2gun() {
        return txtDai2gun;
    }

    /*
     * settxtDai2gun
     * @param txtDai2gun txtDai2gun
     */
    @JsonProperty("txtDai2gun")
    public void setTxtDai2gun(TextBoxNum txtDai2gun) {
        this.txtDai2gun = txtDai2gun;
    }

    // </editor-fold>
}
/**
 * celDai3gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai3gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtDai3gun")
    private TextBoxNum txtDai3gun;

    /*
     * gettxtDai3gun
     * @return txtDai3gun
     */
    @JsonProperty("txtDai3gun")
    public TextBoxNum getTxtDai3gun() {
        return txtDai3gun;
    }

    /*
     * settxtDai3gun
     * @param txtDai3gun txtDai3gun
     */
    @JsonProperty("txtDai3gun")
    public void setTxtDai3gun(TextBoxNum txtDai3gun) {
        this.txtDai3gun = txtDai3gun;
    }

    // </editor-fold>
}
/**
 * celDai4gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai4gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtDai4gun")
    private TextBoxNum txtDai4gun;

    /*
     * gettxtDai4gun
     * @return txtDai4gun
     */
    @JsonProperty("txtDai4gun")
    public TextBoxNum getTxtDai4gun() {
        return txtDai4gun;
    }

    /*
     * settxtDai4gun
     * @param txtDai4gun txtDai4gun
     */
    @JsonProperty("txtDai4gun")
    public void setTxtDai4gun(TextBoxNum txtDai4gun) {
        this.txtDai4gun = txtDai4gun;
    }

    // </editor-fold>
}
/**
 * celDai5gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai5gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtDai5gun")
    private TextBoxNum txtDai5gun;

    /*
     * gettxtDai5gun
     * @return txtDai5gun
     */
    @JsonProperty("txtDai5gun")
    public TextBoxNum getTxtDai5gun() {
        return txtDai5gun;
    }

    /*
     * settxtDai5gun
     * @param txtDai5gun txtDai5gun
     */
    @JsonProperty("txtDai5gun")
    public void setTxtDai5gun(TextBoxNum txtDai5gun) {
        this.txtDai5gun = txtDai5gun;
    }

    // </editor-fold>
}
