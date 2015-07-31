package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020006;
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
 * tabSetting のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabSettingDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celR1C1")
    private celR1C1AttabSetting celR1C1;
    @JsonProperty("celR1C2")
    private celR1C2AttabSetting celR1C2;
    @JsonProperty("celR2C1")
    private celR2C1AttabSetting celR2C1;
    @JsonProperty("celR2C2")
    private celR2C2AttabSetting celR2C2;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxDate getTxtSetteiYMD() {
        return this.celR1C1.getTxtSetteiYMD();
    }

    @JsonIgnore
    public TextBox getTxtJikanWaku() {
        return this.celR1C2.getTxtJikanWaku();
    }

    @JsonIgnore
    public TextBoxTime getTxtKaishiJikan() {
        return this.celR1C2.getTxtKaishiJikan();
    }

    @JsonIgnore
    public TextBoxTime getTxtShuryoJikan() {
        return this.celR1C2.getTxtShuryoJikan();
    }

    @JsonIgnore
    public RadioButton getRadYoyaku() {
        return this.celR2C1.getRadYoyaku();
    }

    @JsonIgnore
    public TextBox getTxtBiko() {
        return this.celR2C2.getTxtBiko();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celR1C1")
    private celR1C1AttabSetting getCelR1C1() {
        return celR1C1;
    }

    @JsonProperty("celR1C1")
    private void setCelR1C1(celR1C1AttabSetting celR1C1) {
        this.celR1C1=celR1C1;
    }

    @JsonProperty("celR1C2")
    private celR1C2AttabSetting getCelR1C2() {
        return celR1C2;
    }

    @JsonProperty("celR1C2")
    private void setCelR1C2(celR1C2AttabSetting celR1C2) {
        this.celR1C2=celR1C2;
    }

    @JsonProperty("celR2C1")
    private celR2C1AttabSetting getCelR2C1() {
        return celR2C1;
    }

    @JsonProperty("celR2C1")
    private void setCelR2C1(celR2C1AttabSetting celR2C1) {
        this.celR2C1=celR2C1;
    }

    @JsonProperty("celR2C2")
    private celR2C2AttabSetting getCelR2C2() {
        return celR2C2;
    }

    @JsonProperty("celR2C2")
    private void setCelR2C2(celR2C2AttabSetting celR2C2) {
        this.celR2C2=celR2C2;
    }

    // </editor-fold>
}
/**
 * celR1C1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celR1C1AttabSetting extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    @JsonProperty("txtSetteiYMD")
    private TextBoxDate txtSetteiYMD;

    @JsonProperty("txtSetteiYMD")
    public TextBoxDate getTxtSetteiYMD() {
        return txtSetteiYMD;
    }

    @JsonProperty("txtSetteiYMD")
    public void setTxtSetteiYMD(TextBoxDate txtSetteiYMD) {
        this.txtSetteiYMD=txtSetteiYMD;
    }

    // </editor-fold>
}
/**
 * celR1C2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celR1C2AttabSetting extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    @JsonProperty("txtJikanWaku")
    private TextBox txtJikanWaku;
    @JsonProperty("txtKaishiJikan")
    private TextBoxTime txtKaishiJikan;
    @JsonProperty("txtShuryoJikan")
    private TextBoxTime txtShuryoJikan;

    @JsonProperty("txtJikanWaku")
    public TextBox getTxtJikanWaku() {
        return txtJikanWaku;
    }

    @JsonProperty("txtJikanWaku")
    public void setTxtJikanWaku(TextBox txtJikanWaku) {
        this.txtJikanWaku=txtJikanWaku;
    }

    @JsonProperty("txtKaishiJikan")
    public TextBoxTime getTxtKaishiJikan() {
        return txtKaishiJikan;
    }

    @JsonProperty("txtKaishiJikan")
    public void setTxtKaishiJikan(TextBoxTime txtKaishiJikan) {
        this.txtKaishiJikan=txtKaishiJikan;
    }

    @JsonProperty("txtShuryoJikan")
    public TextBoxTime getTxtShuryoJikan() {
        return txtShuryoJikan;
    }

    @JsonProperty("txtShuryoJikan")
    public void setTxtShuryoJikan(TextBoxTime txtShuryoJikan) {
        this.txtShuryoJikan=txtShuryoJikan;
    }

    // </editor-fold>
}
/**
 * celR2C1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celR2C1AttabSetting extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    @JsonProperty("radYoyaku")
    private RadioButton radYoyaku;

    @JsonProperty("radYoyaku")
    public RadioButton getRadYoyaku() {
        return radYoyaku;
    }

    @JsonProperty("radYoyaku")
    public void setRadYoyaku(RadioButton radYoyaku) {
        this.radYoyaku=radYoyaku;
    }

    // </editor-fold>
}
/**
 * celR2C2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celR2C2AttabSetting extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    @JsonProperty("txtBiko")
    private TextBox txtBiko;

    @JsonProperty("txtBiko")
    public TextBox getTxtBiko() {
        return txtBiko;
    }

    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBox txtBiko) {
        this.txtBiko=txtBiko;
    }

    // </editor-fold>
}
