package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko;
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
 * tblShisetsuNyutaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblShisetsuNyutaishoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celNyushoShisetsuTitle")
    private celNyushoShisetsuTitleAttblShisetsuNyutaisho celNyushoShisetsuTitle;
    @JsonProperty("celShisetsuNyushoDateTitle")
    private celShisetsuNyushoDateTitleAttblShisetsuNyutaisho celShisetsuNyushoDateTitle;
    @JsonProperty("celShisetsuTaishoDateTitle")
    private celShisetsuTaishoDateTitleAttblShisetsuNyutaisho celShisetsuTaishoDateTitle;
    @JsonProperty("celNyushoShisetsu1")
    private celNyushoShisetsu1AttblShisetsuNyutaisho celNyushoShisetsu1;
    @JsonProperty("celShisetsuNyushoDate1")
    private celShisetsuNyushoDate1AttblShisetsuNyutaisho celShisetsuNyushoDate1;
    @JsonProperty("celShisetsuTaishoDate1")
    private celShisetsuTaishoDate1AttblShisetsuNyutaisho celShisetsuTaishoDate1;
    @JsonProperty("celNyushoShisetsu2")
    private celNyushoShisetsu2AttblShisetsuNyutaisho celNyushoShisetsu2;
    @JsonProperty("celShisetsuNyushoDate2")
    private celShisetsuNyushoDate2AttblShisetsuNyutaisho celShisetsuNyushoDate2;
    @JsonProperty("celShisetsuTaishoDate2")
    private celShisetsuTaishoDate2AttblShisetsuNyutaisho celShisetsuTaishoDate2;
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
    /*
     * getcelNyushoShisetsuTitle
     * @return celNyushoShisetsuTitle
     */
    @JsonProperty("celNyushoShisetsuTitle")
    private celNyushoShisetsuTitleAttblShisetsuNyutaisho getCelNyushoShisetsuTitle() {
        return celNyushoShisetsuTitle;
    }

    /*
     * setcelNyushoShisetsuTitle
     * @param celNyushoShisetsuTitle celNyushoShisetsuTitle
     */
    @JsonProperty("celNyushoShisetsuTitle")
    private void setCelNyushoShisetsuTitle(celNyushoShisetsuTitleAttblShisetsuNyutaisho celNyushoShisetsuTitle) {
        this.celNyushoShisetsuTitle = celNyushoShisetsuTitle;
    }

    /*
     * getcelShisetsuNyushoDateTitle
     * @return celShisetsuNyushoDateTitle
     */
    @JsonProperty("celShisetsuNyushoDateTitle")
    private celShisetsuNyushoDateTitleAttblShisetsuNyutaisho getCelShisetsuNyushoDateTitle() {
        return celShisetsuNyushoDateTitle;
    }

    /*
     * setcelShisetsuNyushoDateTitle
     * @param celShisetsuNyushoDateTitle celShisetsuNyushoDateTitle
     */
    @JsonProperty("celShisetsuNyushoDateTitle")
    private void setCelShisetsuNyushoDateTitle(celShisetsuNyushoDateTitleAttblShisetsuNyutaisho celShisetsuNyushoDateTitle) {
        this.celShisetsuNyushoDateTitle = celShisetsuNyushoDateTitle;
    }

    /*
     * getcelShisetsuTaishoDateTitle
     * @return celShisetsuTaishoDateTitle
     */
    @JsonProperty("celShisetsuTaishoDateTitle")
    private celShisetsuTaishoDateTitleAttblShisetsuNyutaisho getCelShisetsuTaishoDateTitle() {
        return celShisetsuTaishoDateTitle;
    }

    /*
     * setcelShisetsuTaishoDateTitle
     * @param celShisetsuTaishoDateTitle celShisetsuTaishoDateTitle
     */
    @JsonProperty("celShisetsuTaishoDateTitle")
    private void setCelShisetsuTaishoDateTitle(celShisetsuTaishoDateTitleAttblShisetsuNyutaisho celShisetsuTaishoDateTitle) {
        this.celShisetsuTaishoDateTitle = celShisetsuTaishoDateTitle;
    }

    /*
     * getcelNyushoShisetsu1
     * @return celNyushoShisetsu1
     */
    @JsonProperty("celNyushoShisetsu1")
    private celNyushoShisetsu1AttblShisetsuNyutaisho getCelNyushoShisetsu1() {
        return celNyushoShisetsu1;
    }

    /*
     * setcelNyushoShisetsu1
     * @param celNyushoShisetsu1 celNyushoShisetsu1
     */
    @JsonProperty("celNyushoShisetsu1")
    private void setCelNyushoShisetsu1(celNyushoShisetsu1AttblShisetsuNyutaisho celNyushoShisetsu1) {
        this.celNyushoShisetsu1 = celNyushoShisetsu1;
    }

    /*
     * getcelShisetsuNyushoDate1
     * @return celShisetsuNyushoDate1
     */
    @JsonProperty("celShisetsuNyushoDate1")
    private celShisetsuNyushoDate1AttblShisetsuNyutaisho getCelShisetsuNyushoDate1() {
        return celShisetsuNyushoDate1;
    }

    /*
     * setcelShisetsuNyushoDate1
     * @param celShisetsuNyushoDate1 celShisetsuNyushoDate1
     */
    @JsonProperty("celShisetsuNyushoDate1")
    private void setCelShisetsuNyushoDate1(celShisetsuNyushoDate1AttblShisetsuNyutaisho celShisetsuNyushoDate1) {
        this.celShisetsuNyushoDate1 = celShisetsuNyushoDate1;
    }

    /*
     * getcelShisetsuTaishoDate1
     * @return celShisetsuTaishoDate1
     */
    @JsonProperty("celShisetsuTaishoDate1")
    private celShisetsuTaishoDate1AttblShisetsuNyutaisho getCelShisetsuTaishoDate1() {
        return celShisetsuTaishoDate1;
    }

    /*
     * setcelShisetsuTaishoDate1
     * @param celShisetsuTaishoDate1 celShisetsuTaishoDate1
     */
    @JsonProperty("celShisetsuTaishoDate1")
    private void setCelShisetsuTaishoDate1(celShisetsuTaishoDate1AttblShisetsuNyutaisho celShisetsuTaishoDate1) {
        this.celShisetsuTaishoDate1 = celShisetsuTaishoDate1;
    }

    /*
     * getcelNyushoShisetsu2
     * @return celNyushoShisetsu2
     */
    @JsonProperty("celNyushoShisetsu2")
    private celNyushoShisetsu2AttblShisetsuNyutaisho getCelNyushoShisetsu2() {
        return celNyushoShisetsu2;
    }

    /*
     * setcelNyushoShisetsu2
     * @param celNyushoShisetsu2 celNyushoShisetsu2
     */
    @JsonProperty("celNyushoShisetsu2")
    private void setCelNyushoShisetsu2(celNyushoShisetsu2AttblShisetsuNyutaisho celNyushoShisetsu2) {
        this.celNyushoShisetsu2 = celNyushoShisetsu2;
    }

    /*
     * getcelShisetsuNyushoDate2
     * @return celShisetsuNyushoDate2
     */
    @JsonProperty("celShisetsuNyushoDate2")
    private celShisetsuNyushoDate2AttblShisetsuNyutaisho getCelShisetsuNyushoDate2() {
        return celShisetsuNyushoDate2;
    }

    /*
     * setcelShisetsuNyushoDate2
     * @param celShisetsuNyushoDate2 celShisetsuNyushoDate2
     */
    @JsonProperty("celShisetsuNyushoDate2")
    private void setCelShisetsuNyushoDate2(celShisetsuNyushoDate2AttblShisetsuNyutaisho celShisetsuNyushoDate2) {
        this.celShisetsuNyushoDate2 = celShisetsuNyushoDate2;
    }

    /*
     * getcelShisetsuTaishoDate2
     * @return celShisetsuTaishoDate2
     */
    @JsonProperty("celShisetsuTaishoDate2")
    private celShisetsuTaishoDate2AttblShisetsuNyutaisho getCelShisetsuTaishoDate2() {
        return celShisetsuTaishoDate2;
    }

    /*
     * setcelShisetsuTaishoDate2
     * @param celShisetsuTaishoDate2 celShisetsuTaishoDate2
     */
    @JsonProperty("celShisetsuTaishoDate2")
    private void setCelShisetsuTaishoDate2(celShisetsuTaishoDate2AttblShisetsuNyutaisho celShisetsuTaishoDate2) {
        this.celShisetsuTaishoDate2 = celShisetsuTaishoDate2;
    }

    /*
     * getcelNyushoShisetsu3
     * @return celNyushoShisetsu3
     */
    @JsonProperty("celNyushoShisetsu3")
    private celNyushoShisetsu3AttblShisetsuNyutaisho getCelNyushoShisetsu3() {
        return celNyushoShisetsu3;
    }

    /*
     * setcelNyushoShisetsu3
     * @param celNyushoShisetsu3 celNyushoShisetsu3
     */
    @JsonProperty("celNyushoShisetsu3")
    private void setCelNyushoShisetsu3(celNyushoShisetsu3AttblShisetsuNyutaisho celNyushoShisetsu3) {
        this.celNyushoShisetsu3 = celNyushoShisetsu3;
    }

    /*
     * getcelShisetsuNyushoDate3
     * @return celShisetsuNyushoDate3
     */
    @JsonProperty("celShisetsuNyushoDate3")
    private celShisetsuNyushoDate3AttblShisetsuNyutaisho getCelShisetsuNyushoDate3() {
        return celShisetsuNyushoDate3;
    }

    /*
     * setcelShisetsuNyushoDate3
     * @param celShisetsuNyushoDate3 celShisetsuNyushoDate3
     */
    @JsonProperty("celShisetsuNyushoDate3")
    private void setCelShisetsuNyushoDate3(celShisetsuNyushoDate3AttblShisetsuNyutaisho celShisetsuNyushoDate3) {
        this.celShisetsuNyushoDate3 = celShisetsuNyushoDate3;
    }

    /*
     * getcelShisetsuTaishoDate3
     * @return celShisetsuTaishoDate3
     */
    @JsonProperty("celShisetsuTaishoDate3")
    private celShisetsuTaishoDate3AttblShisetsuNyutaisho getCelShisetsuTaishoDate3() {
        return celShisetsuTaishoDate3;
    }

    /*
     * setcelShisetsuTaishoDate3
     * @param celShisetsuTaishoDate3 celShisetsuTaishoDate3
     */
    @JsonProperty("celShisetsuTaishoDate3")
    private void setCelShisetsuTaishoDate3(celShisetsuTaishoDate3AttblShisetsuNyutaisho celShisetsuTaishoDate3) {
        this.celShisetsuTaishoDate3 = celShisetsuTaishoDate3;
    }

    // </editor-fold>
}
/**
 * celNyushoShisetsuTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celNyushoShisetsuTitleAttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblNyushoShisetsu")
    private Label lblNyushoShisetsu;

    /*
     * getlblNyushoShisetsu
     * @return lblNyushoShisetsu
     */
    @JsonProperty("lblNyushoShisetsu")
    public Label getLblNyushoShisetsu() {
        return lblNyushoShisetsu;
    }

    /*
     * setlblNyushoShisetsu
     * @param lblNyushoShisetsu lblNyushoShisetsu
     */
    @JsonProperty("lblNyushoShisetsu")
    public void setLblNyushoShisetsu(Label lblNyushoShisetsu) {
        this.lblNyushoShisetsu = lblNyushoShisetsu;
    }

    // </editor-fold>
}
/**
 * celShisetsuNyushoDateTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuNyushoDateTitleAttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblShisetsuNyushoDate")
    private Label lblShisetsuNyushoDate;

    /*
     * getlblShisetsuNyushoDate
     * @return lblShisetsuNyushoDate
     */
    @JsonProperty("lblShisetsuNyushoDate")
    public Label getLblShisetsuNyushoDate() {
        return lblShisetsuNyushoDate;
    }

    /*
     * setlblShisetsuNyushoDate
     * @param lblShisetsuNyushoDate lblShisetsuNyushoDate
     */
    @JsonProperty("lblShisetsuNyushoDate")
    public void setLblShisetsuNyushoDate(Label lblShisetsuNyushoDate) {
        this.lblShisetsuNyushoDate = lblShisetsuNyushoDate;
    }

    // </editor-fold>
}
/**
 * celShisetsuTaishoDateTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuTaishoDateTitleAttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("lblShisetsuTaishoDate")
    private Label lblShisetsuTaishoDate;

    /*
     * getlblShisetsuTaishoDate
     * @return lblShisetsuTaishoDate
     */
    @JsonProperty("lblShisetsuTaishoDate")
    public Label getLblShisetsuTaishoDate() {
        return lblShisetsuTaishoDate;
    }

    /*
     * setlblShisetsuTaishoDate
     * @param lblShisetsuTaishoDate lblShisetsuTaishoDate
     */
    @JsonProperty("lblShisetsuTaishoDate")
    public void setLblShisetsuTaishoDate(Label lblShisetsuTaishoDate) {
        this.lblShisetsuTaishoDate = lblShisetsuTaishoDate;
    }

    // </editor-fold>
}
/**
 * celNyushoShisetsu1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNyushoShisetsu1AttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtNyushoShisetsu1")
    private TextBox txtNyushoShisetsu1;

    /*
     * gettxtNyushoShisetsu1
     * @return txtNyushoShisetsu1
     */
    @JsonProperty("txtNyushoShisetsu1")
    public TextBox getTxtNyushoShisetsu1() {
        return txtNyushoShisetsu1;
    }

    /*
     * settxtNyushoShisetsu1
     * @param txtNyushoShisetsu1 txtNyushoShisetsu1
     */
    @JsonProperty("txtNyushoShisetsu1")
    public void setTxtNyushoShisetsu1(TextBox txtNyushoShisetsu1) {
        this.txtNyushoShisetsu1 = txtNyushoShisetsu1;
    }

    // </editor-fold>
}
/**
 * celShisetsuNyushoDate1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuNyushoDate1AttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtShisetsuNyushoDate1")
    private TextBoxFlexibleDate txtShisetsuNyushoDate1;

    /*
     * gettxtShisetsuNyushoDate1
     * @return txtShisetsuNyushoDate1
     */
    @JsonProperty("txtShisetsuNyushoDate1")
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate1() {
        return txtShisetsuNyushoDate1;
    }

    /*
     * settxtShisetsuNyushoDate1
     * @param txtShisetsuNyushoDate1 txtShisetsuNyushoDate1
     */
    @JsonProperty("txtShisetsuNyushoDate1")
    public void setTxtShisetsuNyushoDate1(TextBoxFlexibleDate txtShisetsuNyushoDate1) {
        this.txtShisetsuNyushoDate1 = txtShisetsuNyushoDate1;
    }

    // </editor-fold>
}
/**
 * celShisetsuTaishoDate1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuTaishoDate1AttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtShisetsuTaishoDate1")
    private TextBoxFlexibleDate txtShisetsuTaishoDate1;

    /*
     * gettxtShisetsuTaishoDate1
     * @return txtShisetsuTaishoDate1
     */
    @JsonProperty("txtShisetsuTaishoDate1")
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate1() {
        return txtShisetsuTaishoDate1;
    }

    /*
     * settxtShisetsuTaishoDate1
     * @param txtShisetsuTaishoDate1 txtShisetsuTaishoDate1
     */
    @JsonProperty("txtShisetsuTaishoDate1")
    public void setTxtShisetsuTaishoDate1(TextBoxFlexibleDate txtShisetsuTaishoDate1) {
        this.txtShisetsuTaishoDate1 = txtShisetsuTaishoDate1;
    }

    // </editor-fold>
}
/**
 * celNyushoShisetsu2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNyushoShisetsu2AttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtNyushoShisetsu2")
    private TextBox txtNyushoShisetsu2;

    /*
     * gettxtNyushoShisetsu2
     * @return txtNyushoShisetsu2
     */
    @JsonProperty("txtNyushoShisetsu2")
    public TextBox getTxtNyushoShisetsu2() {
        return txtNyushoShisetsu2;
    }

    /*
     * settxtNyushoShisetsu2
     * @param txtNyushoShisetsu2 txtNyushoShisetsu2
     */
    @JsonProperty("txtNyushoShisetsu2")
    public void setTxtNyushoShisetsu2(TextBox txtNyushoShisetsu2) {
        this.txtNyushoShisetsu2 = txtNyushoShisetsu2;
    }

    // </editor-fold>
}
/**
 * celShisetsuNyushoDate2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuNyushoDate2AttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtShisetsuNyushoDate2")
    private TextBoxFlexibleDate txtShisetsuNyushoDate2;

    /*
     * gettxtShisetsuNyushoDate2
     * @return txtShisetsuNyushoDate2
     */
    @JsonProperty("txtShisetsuNyushoDate2")
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate2() {
        return txtShisetsuNyushoDate2;
    }

    /*
     * settxtShisetsuNyushoDate2
     * @param txtShisetsuNyushoDate2 txtShisetsuNyushoDate2
     */
    @JsonProperty("txtShisetsuNyushoDate2")
    public void setTxtShisetsuNyushoDate2(TextBoxFlexibleDate txtShisetsuNyushoDate2) {
        this.txtShisetsuNyushoDate2 = txtShisetsuNyushoDate2;
    }

    // </editor-fold>
}
/**
 * celShisetsuTaishoDate2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuTaishoDate2AttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtShisetsuTaishoDate2")
    private TextBoxFlexibleDate txtShisetsuTaishoDate2;

    /*
     * gettxtShisetsuTaishoDate2
     * @return txtShisetsuTaishoDate2
     */
    @JsonProperty("txtShisetsuTaishoDate2")
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate2() {
        return txtShisetsuTaishoDate2;
    }

    /*
     * settxtShisetsuTaishoDate2
     * @param txtShisetsuTaishoDate2 txtShisetsuTaishoDate2
     */
    @JsonProperty("txtShisetsuTaishoDate2")
    public void setTxtShisetsuTaishoDate2(TextBoxFlexibleDate txtShisetsuTaishoDate2) {
        this.txtShisetsuTaishoDate2 = txtShisetsuTaishoDate2;
    }

    // </editor-fold>
}
/**
 * celNyushoShisetsu3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNyushoShisetsu3AttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtNyushoShisetsu3")
    private TextBox txtNyushoShisetsu3;

    /*
     * gettxtNyushoShisetsu3
     * @return txtNyushoShisetsu3
     */
    @JsonProperty("txtNyushoShisetsu3")
    public TextBox getTxtNyushoShisetsu3() {
        return txtNyushoShisetsu3;
    }

    /*
     * settxtNyushoShisetsu3
     * @param txtNyushoShisetsu3 txtNyushoShisetsu3
     */
    @JsonProperty("txtNyushoShisetsu3")
    public void setTxtNyushoShisetsu3(TextBox txtNyushoShisetsu3) {
        this.txtNyushoShisetsu3 = txtNyushoShisetsu3;
    }

    // </editor-fold>
}
/**
 * celShisetsuNyushoDate3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuNyushoDate3AttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtShisetsuNyushoDate3")
    private TextBoxFlexibleDate txtShisetsuNyushoDate3;

    /*
     * gettxtShisetsuNyushoDate3
     * @return txtShisetsuNyushoDate3
     */
    @JsonProperty("txtShisetsuNyushoDate3")
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate3() {
        return txtShisetsuNyushoDate3;
    }

    /*
     * settxtShisetsuNyushoDate3
     * @param txtShisetsuNyushoDate3 txtShisetsuNyushoDate3
     */
    @JsonProperty("txtShisetsuNyushoDate3")
    public void setTxtShisetsuNyushoDate3(TextBoxFlexibleDate txtShisetsuNyushoDate3) {
        this.txtShisetsuNyushoDate3 = txtShisetsuNyushoDate3;
    }

    // </editor-fold>
}
/**
 * celShisetsuTaishoDate3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShisetsuTaishoDate3AttblShisetsuNyutaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtShisetsuTaishoDate3")
    private TextBoxFlexibleDate txtShisetsuTaishoDate3;

    /*
     * gettxtShisetsuTaishoDate3
     * @return txtShisetsuTaishoDate3
     */
    @JsonProperty("txtShisetsuTaishoDate3")
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate3() {
        return txtShisetsuTaishoDate3;
    }

    /*
     * settxtShisetsuTaishoDate3
     * @param txtShisetsuTaishoDate3 txtShisetsuTaishoDate3
     */
    @JsonProperty("txtShisetsuTaishoDate3")
    public void setTxtShisetsuTaishoDate3(TextBoxFlexibleDate txtShisetsuTaishoDate3) {
        this.txtShisetsuTaishoDate3 = txtShisetsuTaishoDate3;
    }

    // </editor-fold>
}
