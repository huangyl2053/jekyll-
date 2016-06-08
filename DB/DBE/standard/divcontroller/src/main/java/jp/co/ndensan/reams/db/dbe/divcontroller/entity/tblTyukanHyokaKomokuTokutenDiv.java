package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblTyukanHyokaKomokuTokuten のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTyukanHyokaKomokuTokutenDiv extends TablePanel {
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
    @JsonProperty("celDai6gunHeader")
    private celDai6gunHeaderAttblTyukanHyokaKomokuTokuten celDai6gunHeader;
    @JsonProperty("celDai7gunHeader")
    private celDai7gunHeaderAttblTyukanHyokaKomokuTokuten celDai7gunHeader;
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
    @JsonProperty("celDai6gun")
    private celDai6gunAttblTyukanHyokaKomokuTokuten celDai6gun;
    @JsonProperty("celDai7gun")
    private celDai7gunAttblTyukanHyokaKomokuTokuten celDai7gun;

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
    public Label getLblDai6gun() {
        return this.celDai6gunHeader.getLblDai6gun();
    }

    @JsonIgnore
    public Label getLblDai7gun() {
        return this.celDai7gunHeader.getLblDai7gun();
    }

    @JsonIgnore
    public TextBox getTxtDai1gun() {
        return this.celDai1gun.getTxtDai1gun();
    }

    @JsonIgnore
    public TextBox getTxtDai2gun() {
        return this.celDai2gun.getTxtDai2gun();
    }

    @JsonIgnore
    public TextBox getTxtDai3gun() {
        return this.celDai3gun.getTxtDai3gun();
    }

    @JsonIgnore
    public TextBox getTxtDai4gun() {
        return this.celDai4gun.getTxtDai4gun();
    }

    @JsonIgnore
    public TextBox getTxtDai5gun() {
        return this.celDai5gun.getTxtDai5gun();
    }

    @JsonIgnore
    public TextBox getTxtDai6gun() {
        return this.celDai6gun.getTxtDai6gun();
    }

    @JsonIgnore
    public TextBox getTxtDai7gun() {
        return this.celDai7gun.getTxtDai7gun();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celDai1gunHeader")
    private celDai1gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai1gunHeader() {
        return celDai1gunHeader;
    }

    @JsonProperty("celDai1gunHeader")
    private void setCelDai1gunHeader(celDai1gunHeaderAttblTyukanHyokaKomokuTokuten celDai1gunHeader) {
        this.celDai1gunHeader=celDai1gunHeader;
    }

    @JsonProperty("celDai2gunHeader")
    private celDai2gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai2gunHeader() {
        return celDai2gunHeader;
    }

    @JsonProperty("celDai2gunHeader")
    private void setCelDai2gunHeader(celDai2gunHeaderAttblTyukanHyokaKomokuTokuten celDai2gunHeader) {
        this.celDai2gunHeader=celDai2gunHeader;
    }

    @JsonProperty("celDai3gunHeader")
    private celDai3gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai3gunHeader() {
        return celDai3gunHeader;
    }

    @JsonProperty("celDai3gunHeader")
    private void setCelDai3gunHeader(celDai3gunHeaderAttblTyukanHyokaKomokuTokuten celDai3gunHeader) {
        this.celDai3gunHeader=celDai3gunHeader;
    }

    @JsonProperty("celDai4gunHeader")
    private celDai4gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai4gunHeader() {
        return celDai4gunHeader;
    }

    @JsonProperty("celDai4gunHeader")
    private void setCelDai4gunHeader(celDai4gunHeaderAttblTyukanHyokaKomokuTokuten celDai4gunHeader) {
        this.celDai4gunHeader=celDai4gunHeader;
    }

    @JsonProperty("celDai5gunHeader")
    private celDai5gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai5gunHeader() {
        return celDai5gunHeader;
    }

    @JsonProperty("celDai5gunHeader")
    private void setCelDai5gunHeader(celDai5gunHeaderAttblTyukanHyokaKomokuTokuten celDai5gunHeader) {
        this.celDai5gunHeader=celDai5gunHeader;
    }

    @JsonProperty("celDai6gunHeader")
    private celDai6gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai6gunHeader() {
        return celDai6gunHeader;
    }

    @JsonProperty("celDai6gunHeader")
    private void setCelDai6gunHeader(celDai6gunHeaderAttblTyukanHyokaKomokuTokuten celDai6gunHeader) {
        this.celDai6gunHeader=celDai6gunHeader;
    }

    @JsonProperty("celDai7gunHeader")
    private celDai7gunHeaderAttblTyukanHyokaKomokuTokuten getCelDai7gunHeader() {
        return celDai7gunHeader;
    }

    @JsonProperty("celDai7gunHeader")
    private void setCelDai7gunHeader(celDai7gunHeaderAttblTyukanHyokaKomokuTokuten celDai7gunHeader) {
        this.celDai7gunHeader=celDai7gunHeader;
    }

    @JsonProperty("celDai1gun")
    private celDai1gunAttblTyukanHyokaKomokuTokuten getCelDai1gun() {
        return celDai1gun;
    }

    @JsonProperty("celDai1gun")
    private void setCelDai1gun(celDai1gunAttblTyukanHyokaKomokuTokuten celDai1gun) {
        this.celDai1gun=celDai1gun;
    }

    @JsonProperty("celDai2gun")
    private celDai2gunAttblTyukanHyokaKomokuTokuten getCelDai2gun() {
        return celDai2gun;
    }

    @JsonProperty("celDai2gun")
    private void setCelDai2gun(celDai2gunAttblTyukanHyokaKomokuTokuten celDai2gun) {
        this.celDai2gun=celDai2gun;
    }

    @JsonProperty("celDai3gun")
    private celDai3gunAttblTyukanHyokaKomokuTokuten getCelDai3gun() {
        return celDai3gun;
    }

    @JsonProperty("celDai3gun")
    private void setCelDai3gun(celDai3gunAttblTyukanHyokaKomokuTokuten celDai3gun) {
        this.celDai3gun=celDai3gun;
    }

    @JsonProperty("celDai4gun")
    private celDai4gunAttblTyukanHyokaKomokuTokuten getCelDai4gun() {
        return celDai4gun;
    }

    @JsonProperty("celDai4gun")
    private void setCelDai4gun(celDai4gunAttblTyukanHyokaKomokuTokuten celDai4gun) {
        this.celDai4gun=celDai4gun;
    }

    @JsonProperty("celDai5gun")
    private celDai5gunAttblTyukanHyokaKomokuTokuten getCelDai5gun() {
        return celDai5gun;
    }

    @JsonProperty("celDai5gun")
    private void setCelDai5gun(celDai5gunAttblTyukanHyokaKomokuTokuten celDai5gun) {
        this.celDai5gun=celDai5gun;
    }

    @JsonProperty("celDai6gun")
    private celDai6gunAttblTyukanHyokaKomokuTokuten getCelDai6gun() {
        return celDai6gun;
    }

    @JsonProperty("celDai6gun")
    private void setCelDai6gun(celDai6gunAttblTyukanHyokaKomokuTokuten celDai6gun) {
        this.celDai6gun=celDai6gun;
    }

    @JsonProperty("celDai7gun")
    private celDai7gunAttblTyukanHyokaKomokuTokuten getCelDai7gun() {
        return celDai7gun;
    }

    @JsonProperty("celDai7gun")
    private void setCelDai7gun(celDai7gunAttblTyukanHyokaKomokuTokuten celDai7gun) {
        this.celDai7gun=celDai7gun;
    }

}
/**
 * celDai1gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai1gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("lblDai1gun")
    private Label lblDai1gun;

    @JsonProperty("lblDai1gun")
    public Label getLblDai1gun() {
        return lblDai1gun;
    }

    @JsonProperty("lblDai1gun")
    public void setLblDai1gun(Label lblDai1gun) {
        this.lblDai1gun=lblDai1gun;
    }

}
/**
 * celDai2gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai2gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("lblDai2gun")
    private Label lblDai2gun;

    @JsonProperty("lblDai2gun")
    public Label getLblDai2gun() {
        return lblDai2gun;
    }

    @JsonProperty("lblDai2gun")
    public void setLblDai2gun(Label lblDai2gun) {
        this.lblDai2gun=lblDai2gun;
    }

}
/**
 * celDai3gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai3gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("lblDai3gun")
    private Label lblDai3gun;

    @JsonProperty("lblDai3gun")
    public Label getLblDai3gun() {
        return lblDai3gun;
    }

    @JsonProperty("lblDai3gun")
    public void setLblDai3gun(Label lblDai3gun) {
        this.lblDai3gun=lblDai3gun;
    }

}
/**
 * celDai4gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai4gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("lblDai4gun")
    private Label lblDai4gun;

    @JsonProperty("lblDai4gun")
    public Label getLblDai4gun() {
        return lblDai4gun;
    }

    @JsonProperty("lblDai4gun")
    public void setLblDai4gun(Label lblDai4gun) {
        this.lblDai4gun=lblDai4gun;
    }

}
/**
 * celDai5gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai5gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("lblDai5gun")
    private Label lblDai5gun;

    @JsonProperty("lblDai5gun")
    public Label getLblDai5gun() {
        return lblDai5gun;
    }

    @JsonProperty("lblDai5gun")
    public void setLblDai5gun(Label lblDai5gun) {
        this.lblDai5gun=lblDai5gun;
    }

}
/**
 * celDai6gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai6gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("lblDai6gun")
    private Label lblDai6gun;

    @JsonProperty("lblDai6gun")
    public Label getLblDai6gun() {
        return lblDai6gun;
    }

    @JsonProperty("lblDai6gun")
    public void setLblDai6gun(Label lblDai6gun) {
        this.lblDai6gun=lblDai6gun;
    }

}
/**
 * celDai7gunHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai7gunHeaderAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("lblDai7gun")
    private Label lblDai7gun;

    @JsonProperty("lblDai7gun")
    public Label getLblDai7gun() {
        return lblDai7gun;
    }

    @JsonProperty("lblDai7gun")
    public void setLblDai7gun(Label lblDai7gun) {
        this.lblDai7gun=lblDai7gun;
    }

}
/**
 * celDai1gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai1gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("txtDai1gun")
    private TextBox txtDai1gun;

    @JsonProperty("txtDai1gun")
    public TextBox getTxtDai1gun() {
        return txtDai1gun;
    }

    @JsonProperty("txtDai1gun")
    public void setTxtDai1gun(TextBox txtDai1gun) {
        this.txtDai1gun=txtDai1gun;
    }

}
/**
 * celDai2gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai2gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("txtDai2gun")
    private TextBox txtDai2gun;

    @JsonProperty("txtDai2gun")
    public TextBox getTxtDai2gun() {
        return txtDai2gun;
    }

    @JsonProperty("txtDai2gun")
    public void setTxtDai2gun(TextBox txtDai2gun) {
        this.txtDai2gun=txtDai2gun;
    }

}
/**
 * celDai3gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai3gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("txtDai3gun")
    private TextBox txtDai3gun;

    @JsonProperty("txtDai3gun")
    public TextBox getTxtDai3gun() {
        return txtDai3gun;
    }

    @JsonProperty("txtDai3gun")
    public void setTxtDai3gun(TextBox txtDai3gun) {
        this.txtDai3gun=txtDai3gun;
    }

}
/**
 * celDai4gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai4gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("txtDai4gun")
    private TextBox txtDai4gun;

    @JsonProperty("txtDai4gun")
    public TextBox getTxtDai4gun() {
        return txtDai4gun;
    }

    @JsonProperty("txtDai4gun")
    public void setTxtDai4gun(TextBox txtDai4gun) {
        this.txtDai4gun=txtDai4gun;
    }

}
/**
 * celDai5gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai5gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("txtDai5gun")
    private TextBox txtDai5gun;

    @JsonProperty("txtDai5gun")
    public TextBox getTxtDai5gun() {
        return txtDai5gun;
    }

    @JsonProperty("txtDai5gun")
    public void setTxtDai5gun(TextBox txtDai5gun) {
        this.txtDai5gun=txtDai5gun;
    }

}
/**
 * celDai6gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai6gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("txtDai6gun")
    private TextBox txtDai6gun;

    @JsonProperty("txtDai6gun")
    public TextBox getTxtDai6gun() {
        return txtDai6gun;
    }

    @JsonProperty("txtDai6gun")
    public void setTxtDai6gun(TextBox txtDai6gun) {
        this.txtDai6gun=txtDai6gun;
    }

}
/**
 * celDai7gun のクラスファイル 
 * 
 * @author 自動生成
 */
class celDai7gunAttblTyukanHyokaKomokuTokuten extends TableCell {
    @JsonProperty("txtDai7gun")
    private TextBox txtDai7gun;

    @JsonProperty("txtDai7gun")
    public TextBox getTxtDai7gun() {
        return txtDai7gun;
    }

    @JsonProperty("txtDai7gun")
    public void setTxtDai7gun(TextBox txtDai7gun) {
        this.txtDai7gun=txtDai7gun;
    }

}
