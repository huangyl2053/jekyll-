package jp.co.ndensan.reams.db.dbu.divcontroller.entity;
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
 * tblShisetsuNyutaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblShisetsuNyutaishoDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celShisetsuShuruiTitle")
    private celShisetsuShuruiTitleAttblShisetsuNyutaisho celShisetsuShuruiTitle;
    @JsonProperty("celNyushoShisetsuTitle")
    private celNyushoShisetsuTitleAttblShisetsuNyutaisho celNyushoShisetsuTitle;
    @JsonProperty("celShisetsuNyushoDateTitle")
    private celShisetsuNyushoDateTitleAttblShisetsuNyutaisho celShisetsuNyushoDateTitle;
    @JsonProperty("celShisetsuTaishoDateTitle")
    private celShisetsuTaishoDateTitleAttblShisetsuNyutaisho celShisetsuTaishoDateTitle;
    @JsonProperty("celShisetsuShurui1")
    private celShisetsuShurui1AttblShisetsuNyutaisho celShisetsuShurui1;
    @JsonProperty("celNyushoShisetsu1")
    private celNyushoShisetsu1AttblShisetsuNyutaisho celNyushoShisetsu1;
    @JsonProperty("celShisetsuNyushoDate1")
    private celShisetsuNyushoDate1AttblShisetsuNyutaisho celShisetsuNyushoDate1;
    @JsonProperty("celShisetsuTaishoDate1")
    private celShisetsuTaishoDate1AttblShisetsuNyutaisho celShisetsuTaishoDate1;
    @JsonProperty("celShisetsuShurui2")
    private celShisetsuShurui2AttblShisetsuNyutaisho celShisetsuShurui2;
    @JsonProperty("celNyushoShisetsu2")
    private celNyushoShisetsu2AttblShisetsuNyutaisho celNyushoShisetsu2;
    @JsonProperty("celShisetsuNyushoDate2")
    private celShisetsuNyushoDate2AttblShisetsuNyutaisho celShisetsuNyushoDate2;
    @JsonProperty("celShisetsuTaishoDate2")
    private celShisetsuTaishoDate2AttblShisetsuNyutaisho celShisetsuTaishoDate2;
    @JsonProperty("celShisetsuShurui3")
    private celShisetsuShurui3AttblShisetsuNyutaisho celShisetsuShurui3;
    @JsonProperty("celNyushoShisetsu3")
    private celNyushoShisetsu3AttblShisetsuNyutaisho celNyushoShisetsu3;
    @JsonProperty("celShisetsuNyushoDate3")
    private celShisetsuNyushoDate3AttblShisetsuNyutaisho celShisetsuNyushoDate3;
    @JsonProperty("celShisetsuTaishoDate3")
    private celShisetsuTaishoDate3AttblShisetsuNyutaisho celShisetsuTaishoDate3;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblShisetsuShurui() {
        return this.celShisetsuShuruiTitle.getLblShisetsuShurui();
    }

    @JsonIgnore
    public Label getLblNyushoShisetsu() {
        return this.celNyushoShisetsuTitle.getLblNyushoShisetsu();
    }

    @JsonIgnore
    public Label getLblShisetsuNyushoDate() {
        return this.celShisetsuNyushoDateTitle.getLblShisetsuNyushoDate();
    }

    @JsonIgnore
    public Label getLblShisetsuTaishoDate() {
        return this.celShisetsuTaishoDateTitle.getLblShisetsuTaishoDate();
    }

    @JsonIgnore
    public TextBox getTxtShisetsuShurui1() {
        return this.celShisetsuShurui1.getTxtShisetsuShurui1();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu1() {
        return this.celNyushoShisetsu1.getTxtNyushoShisetsu1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate1() {
        return this.celShisetsuNyushoDate1.getTxtShisetsuNyushoDate1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate1() {
        return this.celShisetsuTaishoDate1.getTxtShisetsuTaishoDate1();
    }

    @JsonIgnore
    public TextBox getTxtShisetsuShurui2() {
        return this.celShisetsuShurui2.getTxtShisetsuShurui2();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu2() {
        return this.celNyushoShisetsu2.getTxtNyushoShisetsu2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate2() {
        return this.celShisetsuNyushoDate2.getTxtShisetsuNyushoDate2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate2() {
        return this.celShisetsuTaishoDate2.getTxtShisetsuTaishoDate2();
    }

    @JsonIgnore
    public TextBox getTxtShisetsuShurui3() {
        return this.celShisetsuShurui3.getTxtShisetsuShurui3();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu3() {
        return this.celNyushoShisetsu3.getTxtNyushoShisetsu3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate3() {
        return this.celShisetsuNyushoDate3.getTxtShisetsuNyushoDate3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate3() {
        return this.celShisetsuTaishoDate3.getTxtShisetsuTaishoDate3();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celShisetsuShuruiTitle")
    private celShisetsuShuruiTitleAttblShisetsuNyutaisho getCelShisetsuShuruiTitle() {
        return celShisetsuShuruiTitle;
    }

    @JsonProperty("celShisetsuShuruiTitle")
    private void setCelShisetsuShuruiTitle(celShisetsuShuruiTitleAttblShisetsuNyutaisho celShisetsuShuruiTitle) {
        this.celShisetsuShuruiTitle=celShisetsuShuruiTitle;
    }

    @JsonProperty("celNyushoShisetsuTitle")
    private celNyushoShisetsuTitleAttblShisetsuNyutaisho getCelNyushoShisetsuTitle() {
        return celNyushoShisetsuTitle;
    }

    @JsonProperty("celNyushoShisetsuTitle")
    private void setCelNyushoShisetsuTitle(celNyushoShisetsuTitleAttblShisetsuNyutaisho celNyushoShisetsuTitle) {
        this.celNyushoShisetsuTitle=celNyushoShisetsuTitle;
    }

    @JsonProperty("celShisetsuNyushoDateTitle")
    private celShisetsuNyushoDateTitleAttblShisetsuNyutaisho getCelShisetsuNyushoDateTitle() {
        return celShisetsuNyushoDateTitle;
    }

    @JsonProperty("celShisetsuNyushoDateTitle")
    private void setCelShisetsuNyushoDateTitle(celShisetsuNyushoDateTitleAttblShisetsuNyutaisho celShisetsuNyushoDateTitle) {
        this.celShisetsuNyushoDateTitle=celShisetsuNyushoDateTitle;
    }

    @JsonProperty("celShisetsuTaishoDateTitle")
    private celShisetsuTaishoDateTitleAttblShisetsuNyutaisho getCelShisetsuTaishoDateTitle() {
        return celShisetsuTaishoDateTitle;
    }

    @JsonProperty("celShisetsuTaishoDateTitle")
    private void setCelShisetsuTaishoDateTitle(celShisetsuTaishoDateTitleAttblShisetsuNyutaisho celShisetsuTaishoDateTitle) {
        this.celShisetsuTaishoDateTitle=celShisetsuTaishoDateTitle;
    }

    @JsonProperty("celShisetsuShurui1")
    private celShisetsuShurui1AttblShisetsuNyutaisho getCelShisetsuShurui1() {
        return celShisetsuShurui1;
    }

    @JsonProperty("celShisetsuShurui1")
    private void setCelShisetsuShurui1(celShisetsuShurui1AttblShisetsuNyutaisho celShisetsuShurui1) {
        this.celShisetsuShurui1=celShisetsuShurui1;
    }

    @JsonProperty("celNyushoShisetsu1")
    private celNyushoShisetsu1AttblShisetsuNyutaisho getCelNyushoShisetsu1() {
        return celNyushoShisetsu1;
    }

    @JsonProperty("celNyushoShisetsu1")
    private void setCelNyushoShisetsu1(celNyushoShisetsu1AttblShisetsuNyutaisho celNyushoShisetsu1) {
        this.celNyushoShisetsu1=celNyushoShisetsu1;
    }

    @JsonProperty("celShisetsuNyushoDate1")
    private celShisetsuNyushoDate1AttblShisetsuNyutaisho getCelShisetsuNyushoDate1() {
        return celShisetsuNyushoDate1;
    }

    @JsonProperty("celShisetsuNyushoDate1")
    private void setCelShisetsuNyushoDate1(celShisetsuNyushoDate1AttblShisetsuNyutaisho celShisetsuNyushoDate1) {
        this.celShisetsuNyushoDate1=celShisetsuNyushoDate1;
    }

    @JsonProperty("celShisetsuTaishoDate1")
    private celShisetsuTaishoDate1AttblShisetsuNyutaisho getCelShisetsuTaishoDate1() {
        return celShisetsuTaishoDate1;
    }

    @JsonProperty("celShisetsuTaishoDate1")
    private void setCelShisetsuTaishoDate1(celShisetsuTaishoDate1AttblShisetsuNyutaisho celShisetsuTaishoDate1) {
        this.celShisetsuTaishoDate1=celShisetsuTaishoDate1;
    }

    @JsonProperty("celShisetsuShurui2")
    private celShisetsuShurui2AttblShisetsuNyutaisho getCelShisetsuShurui2() {
        return celShisetsuShurui2;
    }

    @JsonProperty("celShisetsuShurui2")
    private void setCelShisetsuShurui2(celShisetsuShurui2AttblShisetsuNyutaisho celShisetsuShurui2) {
        this.celShisetsuShurui2=celShisetsuShurui2;
    }

    @JsonProperty("celNyushoShisetsu2")
    private celNyushoShisetsu2AttblShisetsuNyutaisho getCelNyushoShisetsu2() {
        return celNyushoShisetsu2;
    }

    @JsonProperty("celNyushoShisetsu2")
    private void setCelNyushoShisetsu2(celNyushoShisetsu2AttblShisetsuNyutaisho celNyushoShisetsu2) {
        this.celNyushoShisetsu2=celNyushoShisetsu2;
    }

    @JsonProperty("celShisetsuNyushoDate2")
    private celShisetsuNyushoDate2AttblShisetsuNyutaisho getCelShisetsuNyushoDate2() {
        return celShisetsuNyushoDate2;
    }

    @JsonProperty("celShisetsuNyushoDate2")
    private void setCelShisetsuNyushoDate2(celShisetsuNyushoDate2AttblShisetsuNyutaisho celShisetsuNyushoDate2) {
        this.celShisetsuNyushoDate2=celShisetsuNyushoDate2;
    }

    @JsonProperty("celShisetsuTaishoDate2")
    private celShisetsuTaishoDate2AttblShisetsuNyutaisho getCelShisetsuTaishoDate2() {
        return celShisetsuTaishoDate2;
    }

    @JsonProperty("celShisetsuTaishoDate2")
    private void setCelShisetsuTaishoDate2(celShisetsuTaishoDate2AttblShisetsuNyutaisho celShisetsuTaishoDate2) {
        this.celShisetsuTaishoDate2=celShisetsuTaishoDate2;
    }

    @JsonProperty("celShisetsuShurui3")
    private celShisetsuShurui3AttblShisetsuNyutaisho getCelShisetsuShurui3() {
        return celShisetsuShurui3;
    }

    @JsonProperty("celShisetsuShurui3")
    private void setCelShisetsuShurui3(celShisetsuShurui3AttblShisetsuNyutaisho celShisetsuShurui3) {
        this.celShisetsuShurui3=celShisetsuShurui3;
    }

    @JsonProperty("celNyushoShisetsu3")
    private celNyushoShisetsu3AttblShisetsuNyutaisho getCelNyushoShisetsu3() {
        return celNyushoShisetsu3;
    }

    @JsonProperty("celNyushoShisetsu3")
    private void setCelNyushoShisetsu3(celNyushoShisetsu3AttblShisetsuNyutaisho celNyushoShisetsu3) {
        this.celNyushoShisetsu3=celNyushoShisetsu3;
    }

    @JsonProperty("celShisetsuNyushoDate3")
    private celShisetsuNyushoDate3AttblShisetsuNyutaisho getCelShisetsuNyushoDate3() {
        return celShisetsuNyushoDate3;
    }

    @JsonProperty("celShisetsuNyushoDate3")
    private void setCelShisetsuNyushoDate3(celShisetsuNyushoDate3AttblShisetsuNyutaisho celShisetsuNyushoDate3) {
        this.celShisetsuNyushoDate3=celShisetsuNyushoDate3;
    }

    @JsonProperty("celShisetsuTaishoDate3")
    private celShisetsuTaishoDate3AttblShisetsuNyutaisho getCelShisetsuTaishoDate3() {
        return celShisetsuTaishoDate3;
    }

    @JsonProperty("celShisetsuTaishoDate3")
    private void setCelShisetsuTaishoDate3(celShisetsuTaishoDate3AttblShisetsuNyutaisho celShisetsuTaishoDate3) {
        this.celShisetsuTaishoDate3=celShisetsuTaishoDate3;
    }

}
/**
 * celShisetsuShuruiTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuShuruiTitleAttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("lblShisetsuShurui")
    private Label lblShisetsuShurui;

    @JsonProperty("lblShisetsuShurui")
    public Label getLblShisetsuShurui() {
        return lblShisetsuShurui;
    }

    @JsonProperty("lblShisetsuShurui")
    public void setLblShisetsuShurui(Label lblShisetsuShurui) {
        this.lblShisetsuShurui=lblShisetsuShurui;
    }

}
/**
 * celNyushoShisetsuTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celNyushoShisetsuTitleAttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("lblNyushoShisetsu")
    private Label lblNyushoShisetsu;

    @JsonProperty("lblNyushoShisetsu")
    public Label getLblNyushoShisetsu() {
        return lblNyushoShisetsu;
    }

    @JsonProperty("lblNyushoShisetsu")
    public void setLblNyushoShisetsu(Label lblNyushoShisetsu) {
        this.lblNyushoShisetsu=lblNyushoShisetsu;
    }

}
/**
 * celShisetsuNyushoDateTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuNyushoDateTitleAttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("lblShisetsuNyushoDate")
    private Label lblShisetsuNyushoDate;

    @JsonProperty("lblShisetsuNyushoDate")
    public Label getLblShisetsuNyushoDate() {
        return lblShisetsuNyushoDate;
    }

    @JsonProperty("lblShisetsuNyushoDate")
    public void setLblShisetsuNyushoDate(Label lblShisetsuNyushoDate) {
        this.lblShisetsuNyushoDate=lblShisetsuNyushoDate;
    }

}
/**
 * celShisetsuTaishoDateTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuTaishoDateTitleAttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("lblShisetsuTaishoDate")
    private Label lblShisetsuTaishoDate;

    @JsonProperty("lblShisetsuTaishoDate")
    public Label getLblShisetsuTaishoDate() {
        return lblShisetsuTaishoDate;
    }

    @JsonProperty("lblShisetsuTaishoDate")
    public void setLblShisetsuTaishoDate(Label lblShisetsuTaishoDate) {
        this.lblShisetsuTaishoDate=lblShisetsuTaishoDate;
    }

}
/**
 * celShisetsuShurui1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuShurui1AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtShisetsuShurui1")
    private TextBox txtShisetsuShurui1;

    @JsonProperty("txtShisetsuShurui1")
    public TextBox getTxtShisetsuShurui1() {
        return txtShisetsuShurui1;
    }

    @JsonProperty("txtShisetsuShurui1")
    public void setTxtShisetsuShurui1(TextBox txtShisetsuShurui1) {
        this.txtShisetsuShurui1=txtShisetsuShurui1;
    }

}
/**
 * celNyushoShisetsu1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNyushoShisetsu1AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtNyushoShisetsu1")
    private TextBox txtNyushoShisetsu1;

    @JsonProperty("txtNyushoShisetsu1")
    public TextBox getTxtNyushoShisetsu1() {
        return txtNyushoShisetsu1;
    }

    @JsonProperty("txtNyushoShisetsu1")
    public void setTxtNyushoShisetsu1(TextBox txtNyushoShisetsu1) {
        this.txtNyushoShisetsu1=txtNyushoShisetsu1;
    }

}
/**
 * celShisetsuNyushoDate1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuNyushoDate1AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtShisetsuNyushoDate1")
    private TextBoxFlexibleDate txtShisetsuNyushoDate1;

    @JsonProperty("txtShisetsuNyushoDate1")
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate1() {
        return txtShisetsuNyushoDate1;
    }

    @JsonProperty("txtShisetsuNyushoDate1")
    public void setTxtShisetsuNyushoDate1(TextBoxFlexibleDate txtShisetsuNyushoDate1) {
        this.txtShisetsuNyushoDate1=txtShisetsuNyushoDate1;
    }

}
/**
 * celShisetsuTaishoDate1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuTaishoDate1AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtShisetsuTaishoDate1")
    private TextBoxFlexibleDate txtShisetsuTaishoDate1;

    @JsonProperty("txtShisetsuTaishoDate1")
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate1() {
        return txtShisetsuTaishoDate1;
    }

    @JsonProperty("txtShisetsuTaishoDate1")
    public void setTxtShisetsuTaishoDate1(TextBoxFlexibleDate txtShisetsuTaishoDate1) {
        this.txtShisetsuTaishoDate1=txtShisetsuTaishoDate1;
    }

}
/**
 * celShisetsuShurui2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuShurui2AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtShisetsuShurui2")
    private TextBox txtShisetsuShurui2;

    @JsonProperty("txtShisetsuShurui2")
    public TextBox getTxtShisetsuShurui2() {
        return txtShisetsuShurui2;
    }

    @JsonProperty("txtShisetsuShurui2")
    public void setTxtShisetsuShurui2(TextBox txtShisetsuShurui2) {
        this.txtShisetsuShurui2=txtShisetsuShurui2;
    }

}
/**
 * celNyushoShisetsu2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNyushoShisetsu2AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtNyushoShisetsu2")
    private TextBox txtNyushoShisetsu2;

    @JsonProperty("txtNyushoShisetsu2")
    public TextBox getTxtNyushoShisetsu2() {
        return txtNyushoShisetsu2;
    }

    @JsonProperty("txtNyushoShisetsu2")
    public void setTxtNyushoShisetsu2(TextBox txtNyushoShisetsu2) {
        this.txtNyushoShisetsu2=txtNyushoShisetsu2;
    }

}
/**
 * celShisetsuNyushoDate2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuNyushoDate2AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtShisetsuNyushoDate2")
    private TextBoxFlexibleDate txtShisetsuNyushoDate2;

    @JsonProperty("txtShisetsuNyushoDate2")
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate2() {
        return txtShisetsuNyushoDate2;
    }

    @JsonProperty("txtShisetsuNyushoDate2")
    public void setTxtShisetsuNyushoDate2(TextBoxFlexibleDate txtShisetsuNyushoDate2) {
        this.txtShisetsuNyushoDate2=txtShisetsuNyushoDate2;
    }

}
/**
 * celShisetsuTaishoDate2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuTaishoDate2AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtShisetsuTaishoDate2")
    private TextBoxFlexibleDate txtShisetsuTaishoDate2;

    @JsonProperty("txtShisetsuTaishoDate2")
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate2() {
        return txtShisetsuTaishoDate2;
    }

    @JsonProperty("txtShisetsuTaishoDate2")
    public void setTxtShisetsuTaishoDate2(TextBoxFlexibleDate txtShisetsuTaishoDate2) {
        this.txtShisetsuTaishoDate2=txtShisetsuTaishoDate2;
    }

}
/**
 * celShisetsuShurui3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuShurui3AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtShisetsuShurui3")
    private TextBox txtShisetsuShurui3;

    @JsonProperty("txtShisetsuShurui3")
    public TextBox getTxtShisetsuShurui3() {
        return txtShisetsuShurui3;
    }

    @JsonProperty("txtShisetsuShurui3")
    public void setTxtShisetsuShurui3(TextBox txtShisetsuShurui3) {
        this.txtShisetsuShurui3=txtShisetsuShurui3;
    }

}
/**
 * celNyushoShisetsu3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNyushoShisetsu3AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtNyushoShisetsu3")
    private TextBox txtNyushoShisetsu3;

    @JsonProperty("txtNyushoShisetsu3")
    public TextBox getTxtNyushoShisetsu3() {
        return txtNyushoShisetsu3;
    }

    @JsonProperty("txtNyushoShisetsu3")
    public void setTxtNyushoShisetsu3(TextBox txtNyushoShisetsu3) {
        this.txtNyushoShisetsu3=txtNyushoShisetsu3;
    }

}
/**
 * celShisetsuNyushoDate3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuNyushoDate3AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtShisetsuNyushoDate3")
    private TextBoxFlexibleDate txtShisetsuNyushoDate3;

    @JsonProperty("txtShisetsuNyushoDate3")
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate3() {
        return txtShisetsuNyushoDate3;
    }

    @JsonProperty("txtShisetsuNyushoDate3")
    public void setTxtShisetsuNyushoDate3(TextBoxFlexibleDate txtShisetsuNyushoDate3) {
        this.txtShisetsuNyushoDate3=txtShisetsuNyushoDate3;
    }

}
/**
 * celShisetsuTaishoDate3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuTaishoDate3AttblShisetsuNyutaisho extends TableCell {
    @JsonProperty("txtShisetsuTaishoDate3")
    private TextBoxFlexibleDate txtShisetsuTaishoDate3;

    @JsonProperty("txtShisetsuTaishoDate3")
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate3() {
        return txtShisetsuTaishoDate3;
    }

    @JsonProperty("txtShisetsuTaishoDate3")
    public void setTxtShisetsuTaishoDate3(TextBoxFlexibleDate txtShisetsuTaishoDate3) {
        this.txtShisetsuTaishoDate3=txtShisetsuTaishoDate3;
    }

}
