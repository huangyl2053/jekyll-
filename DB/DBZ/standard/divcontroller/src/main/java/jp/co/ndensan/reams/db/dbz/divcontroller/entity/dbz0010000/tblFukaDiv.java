package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000;
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
 * tblFuka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblFukaDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celFuka11")
    private celFuka11AttblFuka celFuka11;
    @JsonProperty("celFuka12")
    private celFuka12AttblFuka celFuka12;
    @JsonProperty("celFuka21")
    private celFuka21AttblFuka celFuka21;
    @JsonProperty("celFuka22")
    private celFuka22AttblFuka celFuka22;
    @JsonProperty("celFuka31")
    private celFuka31AttblFuka celFuka31;
    @JsonProperty("celFuka32")
    private celFuka32AttblFuka celFuka32;
    @JsonProperty("celFuka41")
    private celFuka41AttblFuka celFuka41;
    @JsonProperty("celFuka42")
    private celFuka42AttblFuka celFuka42;
    @JsonProperty("celFuka51")
    private celFuka51AttblFuka celFuka51;
    @JsonProperty("celFuka52")
    private celFuka52AttblFuka celFuka52;
    @JsonProperty("celFuka61")
    private celFuka61AttblFuka celFuka61;
    @JsonProperty("celFuka62")
    private celFuka62AttblFuka celFuka62;
    @JsonProperty("celFuka71")
    private celFuka71AttblFuka celFuka71;
    @JsonProperty("celFuka72")
    private celFuka72AttblFuka celFuka72;
    @JsonProperty("celFuka81")
    private celFuka81AttblFuka celFuka81;
    @JsonProperty("celFuka82")
    private celFuka82AttblFuka celFuka82;
    @JsonProperty("celFuka91")
    private celFuka91AttblFuka celFuka91;
    @JsonProperty("celFuka92")
    private celFuka92AttblFuka celFuka92;
    @JsonProperty("celFuka101")
    private celFuka101AttblFuka celFuka101;
    @JsonProperty("celFuka102")
    private celFuka102AttblFuka celFuka102;
    @JsonProperty("celFuka111")
    private celFuka111AttblFuka celFuka111;
    @JsonProperty("celFuka112")
    private celFuka112AttblFuka celFuka112;
    @JsonProperty("celFuka121")
    private celFuka121AttblFuka celFuka121;
    @JsonProperty("celFuka122")
    private celFuka122AttblFuka celFuka122;
    @JsonProperty("celFuka131")
    private celFuka131AttblFuka celFuka131;
    @JsonProperty("celFuka132")
    private celFuka132AttblFuka celFuka132;
    @JsonProperty("celFuka141")
    private celFuka141AttblFuka celFuka141;
    @JsonProperty("celFuka142")
    private celFuka142AttblFuka celFuka142;
    @JsonProperty("celFuka151")
    private celFuka151AttblFuka celFuka151;
    @JsonProperty("celFuka152")
    private celFuka152AttblFuka celFuka152;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblFukaKijun() {
        return this.celFuka12.getLblFukaKijun();
    }

    @JsonIgnore
    public Label getLblFukaKijunYMD() {
        return this.celFuka21.getLblFukaKijunYMD();
    }

    @JsonIgnore
    public TextBoxDate getTxtFukaKijunYMD() {
        return this.celFuka22.getTxtFukaKijunYMD();
    }

    @JsonIgnore
    public Label getLblZennendo() {
        return this.celFuka32.getLblZennendo();
    }

    @JsonIgnore
    public Label getLblShotokuDankai() {
        return this.celFuka41.getLblShotokuDankai();
    }

    @JsonIgnore
    public TextBox getTxtShotokuDankai() {
        return this.celFuka42.getTxtShotokuDankai();
    }

    @JsonIgnore
    public Label getLblHokenryoRitsu() {
        return this.celFuka51.getLblHokenryoRitsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoRitsu() {
        return this.celFuka52.getTxtHokenryoRitsu();
    }

    @JsonIgnore
    public Label getLblNenHokenryo() {
        return this.celFuka61.getLblNenHokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtNenHokenryo() {
        return this.celFuka62.getTxtNenHokenryo();
    }

    @JsonIgnore
    public Label getLblTokubetsuSaishugaku() {
        return this.celFuka71.getLblTokubetsuSaishugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetsuSaishugaku() {
        return this.celFuka72.getTxtTokubetsuSaishugaku();
    }

    @JsonIgnore
    public Label getLblFutsuSaishugaku() {
        return this.celFuka81.getLblFutsuSaishugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsuSaishugaku() {
        return this.celFuka82.getTxtFutsuSaishugaku();
    }

    @JsonIgnore
    public Label getLblGenmen() {
        return this.celFuka92.getLblGenmen();
    }

    @JsonIgnore
    public Label getLblGenmengaku() {
        return this.celFuka101.getLblGenmengaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGenmengaku() {
        return this.celFuka102.getTxtGenmengaku();
    }

    @JsonIgnore
    public Label getLblEtc() {
        return this.celFuka112.getLblEtc();
    }

    @JsonIgnore
    public Label getLblZanteiGokei() {
        return this.celFuka121.getLblZanteiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiGokei() {
        return this.celFuka122.getTxtZanteiGokei();
    }

    @JsonIgnore
    public Label getLblSudeniNofugaku() {
        return this.celFuka131.getLblSudeniNofugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtSudeniNofugaku() {
        return this.celFuka132.getTxtSudeniNofugaku();
    }

    @JsonIgnore
    public Label getLblKongoNofugaku() {
        return this.celFuka141.getLblKongoNofugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKongoNofugaku() {
        return this.celFuka142.getTxtKongoNofugaku();
    }

    @JsonIgnore
    public Label getLblNofuzumigaku() {
        return this.celFuka151.getLblNofuzumigaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtNofuzumigaku() {
        return this.celFuka152.getTxtNofuzumigaku();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celFuka11")
    private celFuka11AttblFuka getCelFuka11() {
        return celFuka11;
    }

    @JsonProperty("celFuka11")
    private void setCelFuka11(celFuka11AttblFuka celFuka11) {
        this.celFuka11=celFuka11;
    }

    @JsonProperty("celFuka12")
    private celFuka12AttblFuka getCelFuka12() {
        return celFuka12;
    }

    @JsonProperty("celFuka12")
    private void setCelFuka12(celFuka12AttblFuka celFuka12) {
        this.celFuka12=celFuka12;
    }

    @JsonProperty("celFuka21")
    private celFuka21AttblFuka getCelFuka21() {
        return celFuka21;
    }

    @JsonProperty("celFuka21")
    private void setCelFuka21(celFuka21AttblFuka celFuka21) {
        this.celFuka21=celFuka21;
    }

    @JsonProperty("celFuka22")
    private celFuka22AttblFuka getCelFuka22() {
        return celFuka22;
    }

    @JsonProperty("celFuka22")
    private void setCelFuka22(celFuka22AttblFuka celFuka22) {
        this.celFuka22=celFuka22;
    }

    @JsonProperty("celFuka31")
    private celFuka31AttblFuka getCelFuka31() {
        return celFuka31;
    }

    @JsonProperty("celFuka31")
    private void setCelFuka31(celFuka31AttblFuka celFuka31) {
        this.celFuka31=celFuka31;
    }

    @JsonProperty("celFuka32")
    private celFuka32AttblFuka getCelFuka32() {
        return celFuka32;
    }

    @JsonProperty("celFuka32")
    private void setCelFuka32(celFuka32AttblFuka celFuka32) {
        this.celFuka32=celFuka32;
    }

    @JsonProperty("celFuka41")
    private celFuka41AttblFuka getCelFuka41() {
        return celFuka41;
    }

    @JsonProperty("celFuka41")
    private void setCelFuka41(celFuka41AttblFuka celFuka41) {
        this.celFuka41=celFuka41;
    }

    @JsonProperty("celFuka42")
    private celFuka42AttblFuka getCelFuka42() {
        return celFuka42;
    }

    @JsonProperty("celFuka42")
    private void setCelFuka42(celFuka42AttblFuka celFuka42) {
        this.celFuka42=celFuka42;
    }

    @JsonProperty("celFuka51")
    private celFuka51AttblFuka getCelFuka51() {
        return celFuka51;
    }

    @JsonProperty("celFuka51")
    private void setCelFuka51(celFuka51AttblFuka celFuka51) {
        this.celFuka51=celFuka51;
    }

    @JsonProperty("celFuka52")
    private celFuka52AttblFuka getCelFuka52() {
        return celFuka52;
    }

    @JsonProperty("celFuka52")
    private void setCelFuka52(celFuka52AttblFuka celFuka52) {
        this.celFuka52=celFuka52;
    }

    @JsonProperty("celFuka61")
    private celFuka61AttblFuka getCelFuka61() {
        return celFuka61;
    }

    @JsonProperty("celFuka61")
    private void setCelFuka61(celFuka61AttblFuka celFuka61) {
        this.celFuka61=celFuka61;
    }

    @JsonProperty("celFuka62")
    private celFuka62AttblFuka getCelFuka62() {
        return celFuka62;
    }

    @JsonProperty("celFuka62")
    private void setCelFuka62(celFuka62AttblFuka celFuka62) {
        this.celFuka62=celFuka62;
    }

    @JsonProperty("celFuka71")
    private celFuka71AttblFuka getCelFuka71() {
        return celFuka71;
    }

    @JsonProperty("celFuka71")
    private void setCelFuka71(celFuka71AttblFuka celFuka71) {
        this.celFuka71=celFuka71;
    }

    @JsonProperty("celFuka72")
    private celFuka72AttblFuka getCelFuka72() {
        return celFuka72;
    }

    @JsonProperty("celFuka72")
    private void setCelFuka72(celFuka72AttblFuka celFuka72) {
        this.celFuka72=celFuka72;
    }

    @JsonProperty("celFuka81")
    private celFuka81AttblFuka getCelFuka81() {
        return celFuka81;
    }

    @JsonProperty("celFuka81")
    private void setCelFuka81(celFuka81AttblFuka celFuka81) {
        this.celFuka81=celFuka81;
    }

    @JsonProperty("celFuka82")
    private celFuka82AttblFuka getCelFuka82() {
        return celFuka82;
    }

    @JsonProperty("celFuka82")
    private void setCelFuka82(celFuka82AttblFuka celFuka82) {
        this.celFuka82=celFuka82;
    }

    @JsonProperty("celFuka91")
    private celFuka91AttblFuka getCelFuka91() {
        return celFuka91;
    }

    @JsonProperty("celFuka91")
    private void setCelFuka91(celFuka91AttblFuka celFuka91) {
        this.celFuka91=celFuka91;
    }

    @JsonProperty("celFuka92")
    private celFuka92AttblFuka getCelFuka92() {
        return celFuka92;
    }

    @JsonProperty("celFuka92")
    private void setCelFuka92(celFuka92AttblFuka celFuka92) {
        this.celFuka92=celFuka92;
    }

    @JsonProperty("celFuka101")
    private celFuka101AttblFuka getCelFuka101() {
        return celFuka101;
    }

    @JsonProperty("celFuka101")
    private void setCelFuka101(celFuka101AttblFuka celFuka101) {
        this.celFuka101=celFuka101;
    }

    @JsonProperty("celFuka102")
    private celFuka102AttblFuka getCelFuka102() {
        return celFuka102;
    }

    @JsonProperty("celFuka102")
    private void setCelFuka102(celFuka102AttblFuka celFuka102) {
        this.celFuka102=celFuka102;
    }

    @JsonProperty("celFuka111")
    private celFuka111AttblFuka getCelFuka111() {
        return celFuka111;
    }

    @JsonProperty("celFuka111")
    private void setCelFuka111(celFuka111AttblFuka celFuka111) {
        this.celFuka111=celFuka111;
    }

    @JsonProperty("celFuka112")
    private celFuka112AttblFuka getCelFuka112() {
        return celFuka112;
    }

    @JsonProperty("celFuka112")
    private void setCelFuka112(celFuka112AttblFuka celFuka112) {
        this.celFuka112=celFuka112;
    }

    @JsonProperty("celFuka121")
    private celFuka121AttblFuka getCelFuka121() {
        return celFuka121;
    }

    @JsonProperty("celFuka121")
    private void setCelFuka121(celFuka121AttblFuka celFuka121) {
        this.celFuka121=celFuka121;
    }

    @JsonProperty("celFuka122")
    private celFuka122AttblFuka getCelFuka122() {
        return celFuka122;
    }

    @JsonProperty("celFuka122")
    private void setCelFuka122(celFuka122AttblFuka celFuka122) {
        this.celFuka122=celFuka122;
    }

    @JsonProperty("celFuka131")
    private celFuka131AttblFuka getCelFuka131() {
        return celFuka131;
    }

    @JsonProperty("celFuka131")
    private void setCelFuka131(celFuka131AttblFuka celFuka131) {
        this.celFuka131=celFuka131;
    }

    @JsonProperty("celFuka132")
    private celFuka132AttblFuka getCelFuka132() {
        return celFuka132;
    }

    @JsonProperty("celFuka132")
    private void setCelFuka132(celFuka132AttblFuka celFuka132) {
        this.celFuka132=celFuka132;
    }

    @JsonProperty("celFuka141")
    private celFuka141AttblFuka getCelFuka141() {
        return celFuka141;
    }

    @JsonProperty("celFuka141")
    private void setCelFuka141(celFuka141AttblFuka celFuka141) {
        this.celFuka141=celFuka141;
    }

    @JsonProperty("celFuka142")
    private celFuka142AttblFuka getCelFuka142() {
        return celFuka142;
    }

    @JsonProperty("celFuka142")
    private void setCelFuka142(celFuka142AttblFuka celFuka142) {
        this.celFuka142=celFuka142;
    }

    @JsonProperty("celFuka151")
    private celFuka151AttblFuka getCelFuka151() {
        return celFuka151;
    }

    @JsonProperty("celFuka151")
    private void setCelFuka151(celFuka151AttblFuka celFuka151) {
        this.celFuka151=celFuka151;
    }

    @JsonProperty("celFuka152")
    private celFuka152AttblFuka getCelFuka152() {
        return celFuka152;
    }

    @JsonProperty("celFuka152")
    private void setCelFuka152(celFuka152AttblFuka celFuka152) {
        this.celFuka152=celFuka152;
    }

}
/**
 * celFuka11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka11AttblFuka extends TableCell {

}
/**
 * celFuka12 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka12AttblFuka extends TableCell {
    @JsonProperty("lblFukaKijun")
    private Label lblFukaKijun;

    @JsonProperty("lblFukaKijun")
    public Label getLblFukaKijun() {
        return lblFukaKijun;
    }

    @JsonProperty("lblFukaKijun")
    public void setLblFukaKijun(Label lblFukaKijun) {
        this.lblFukaKijun=lblFukaKijun;
    }

}
/**
 * celFuka21 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka21AttblFuka extends TableCell {
    @JsonProperty("lblFukaKijunYMD")
    private Label lblFukaKijunYMD;

    @JsonProperty("lblFukaKijunYMD")
    public Label getLblFukaKijunYMD() {
        return lblFukaKijunYMD;
    }

    @JsonProperty("lblFukaKijunYMD")
    public void setLblFukaKijunYMD(Label lblFukaKijunYMD) {
        this.lblFukaKijunYMD=lblFukaKijunYMD;
    }

}
/**
 * celFuka22 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka22AttblFuka extends TableCell {
    @JsonProperty("txtFukaKijunYMD")
    private TextBoxDate txtFukaKijunYMD;

    @JsonProperty("txtFukaKijunYMD")
    public TextBoxDate getTxtFukaKijunYMD() {
        return txtFukaKijunYMD;
    }

    @JsonProperty("txtFukaKijunYMD")
    public void setTxtFukaKijunYMD(TextBoxDate txtFukaKijunYMD) {
        this.txtFukaKijunYMD=txtFukaKijunYMD;
    }

}
/**
 * celFuka31 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka31AttblFuka extends TableCell {

}
/**
 * celFuka32 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka32AttblFuka extends TableCell {
    @JsonProperty("lblZennendo")
    private Label lblZennendo;

    @JsonProperty("lblZennendo")
    public Label getLblZennendo() {
        return lblZennendo;
    }

    @JsonProperty("lblZennendo")
    public void setLblZennendo(Label lblZennendo) {
        this.lblZennendo=lblZennendo;
    }

}
/**
 * celFuka41 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka41AttblFuka extends TableCell {
    @JsonProperty("lblShotokuDankai")
    private Label lblShotokuDankai;

    @JsonProperty("lblShotokuDankai")
    public Label getLblShotokuDankai() {
        return lblShotokuDankai;
    }

    @JsonProperty("lblShotokuDankai")
    public void setLblShotokuDankai(Label lblShotokuDankai) {
        this.lblShotokuDankai=lblShotokuDankai;
    }

}
/**
 * celFuka42 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka42AttblFuka extends TableCell {
    @JsonProperty("txtShotokuDankai")
    private TextBox txtShotokuDankai;

    @JsonProperty("txtShotokuDankai")
    public TextBox getTxtShotokuDankai() {
        return txtShotokuDankai;
    }

    @JsonProperty("txtShotokuDankai")
    public void setTxtShotokuDankai(TextBox txtShotokuDankai) {
        this.txtShotokuDankai=txtShotokuDankai;
    }

}
/**
 * celFuka51 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka51AttblFuka extends TableCell {
    @JsonProperty("lblHokenryoRitsu")
    private Label lblHokenryoRitsu;

    @JsonProperty("lblHokenryoRitsu")
    public Label getLblHokenryoRitsu() {
        return lblHokenryoRitsu;
    }

    @JsonProperty("lblHokenryoRitsu")
    public void setLblHokenryoRitsu(Label lblHokenryoRitsu) {
        this.lblHokenryoRitsu=lblHokenryoRitsu;
    }

}
/**
 * celFuka52 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka52AttblFuka extends TableCell {
    @JsonProperty("txtHokenryoRitsu")
    private TextBoxNum txtHokenryoRitsu;

    @JsonProperty("txtHokenryoRitsu")
    public TextBoxNum getTxtHokenryoRitsu() {
        return txtHokenryoRitsu;
    }

    @JsonProperty("txtHokenryoRitsu")
    public void setTxtHokenryoRitsu(TextBoxNum txtHokenryoRitsu) {
        this.txtHokenryoRitsu=txtHokenryoRitsu;
    }

}
/**
 * celFuka61 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka61AttblFuka extends TableCell {
    @JsonProperty("lblNenHokenryo")
    private Label lblNenHokenryo;

    @JsonProperty("lblNenHokenryo")
    public Label getLblNenHokenryo() {
        return lblNenHokenryo;
    }

    @JsonProperty("lblNenHokenryo")
    public void setLblNenHokenryo(Label lblNenHokenryo) {
        this.lblNenHokenryo=lblNenHokenryo;
    }

}
/**
 * celFuka62 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka62AttblFuka extends TableCell {
    @JsonProperty("txtNenHokenryo")
    private TextBoxNum txtNenHokenryo;

    @JsonProperty("txtNenHokenryo")
    public TextBoxNum getTxtNenHokenryo() {
        return txtNenHokenryo;
    }

    @JsonProperty("txtNenHokenryo")
    public void setTxtNenHokenryo(TextBoxNum txtNenHokenryo) {
        this.txtNenHokenryo=txtNenHokenryo;
    }

}
/**
 * celFuka71 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka71AttblFuka extends TableCell {
    @JsonProperty("lblTokubetsuSaishugaku")
    private Label lblTokubetsuSaishugaku;

    @JsonProperty("lblTokubetsuSaishugaku")
    public Label getLblTokubetsuSaishugaku() {
        return lblTokubetsuSaishugaku;
    }

    @JsonProperty("lblTokubetsuSaishugaku")
    public void setLblTokubetsuSaishugaku(Label lblTokubetsuSaishugaku) {
        this.lblTokubetsuSaishugaku=lblTokubetsuSaishugaku;
    }

}
/**
 * celFuka72 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka72AttblFuka extends TableCell {
    @JsonProperty("txtTokubetsuSaishugaku")
    private TextBoxNum txtTokubetsuSaishugaku;

    @JsonProperty("txtTokubetsuSaishugaku")
    public TextBoxNum getTxtTokubetsuSaishugaku() {
        return txtTokubetsuSaishugaku;
    }

    @JsonProperty("txtTokubetsuSaishugaku")
    public void setTxtTokubetsuSaishugaku(TextBoxNum txtTokubetsuSaishugaku) {
        this.txtTokubetsuSaishugaku=txtTokubetsuSaishugaku;
    }

}
/**
 * celFuka81 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka81AttblFuka extends TableCell {
    @JsonProperty("lblFutsuSaishugaku")
    private Label lblFutsuSaishugaku;

    @JsonProperty("lblFutsuSaishugaku")
    public Label getLblFutsuSaishugaku() {
        return lblFutsuSaishugaku;
    }

    @JsonProperty("lblFutsuSaishugaku")
    public void setLblFutsuSaishugaku(Label lblFutsuSaishugaku) {
        this.lblFutsuSaishugaku=lblFutsuSaishugaku;
    }

}
/**
 * celFuka82 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka82AttblFuka extends TableCell {
    @JsonProperty("txtFutsuSaishugaku")
    private TextBoxNum txtFutsuSaishugaku;

    @JsonProperty("txtFutsuSaishugaku")
    public TextBoxNum getTxtFutsuSaishugaku() {
        return txtFutsuSaishugaku;
    }

    @JsonProperty("txtFutsuSaishugaku")
    public void setTxtFutsuSaishugaku(TextBoxNum txtFutsuSaishugaku) {
        this.txtFutsuSaishugaku=txtFutsuSaishugaku;
    }

}
/**
 * celFuka91 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka91AttblFuka extends TableCell {

}
/**
 * celFuka92 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka92AttblFuka extends TableCell {
    @JsonProperty("lblGenmen")
    private Label lblGenmen;

    @JsonProperty("lblGenmen")
    public Label getLblGenmen() {
        return lblGenmen;
    }

    @JsonProperty("lblGenmen")
    public void setLblGenmen(Label lblGenmen) {
        this.lblGenmen=lblGenmen;
    }

}
/**
 * celFuka101 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka101AttblFuka extends TableCell {
    @JsonProperty("lblGenmengaku")
    private Label lblGenmengaku;

    @JsonProperty("lblGenmengaku")
    public Label getLblGenmengaku() {
        return lblGenmengaku;
    }

    @JsonProperty("lblGenmengaku")
    public void setLblGenmengaku(Label lblGenmengaku) {
        this.lblGenmengaku=lblGenmengaku;
    }

}
/**
 * celFuka102 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka102AttblFuka extends TableCell {
    @JsonProperty("txtGenmengaku")
    private TextBoxNum txtGenmengaku;

    @JsonProperty("txtGenmengaku")
    public TextBoxNum getTxtGenmengaku() {
        return txtGenmengaku;
    }

    @JsonProperty("txtGenmengaku")
    public void setTxtGenmengaku(TextBoxNum txtGenmengaku) {
        this.txtGenmengaku=txtGenmengaku;
    }

}
/**
 * celFuka111 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka111AttblFuka extends TableCell {

}
/**
 * celFuka112 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka112AttblFuka extends TableCell {
    @JsonProperty("lblEtc")
    private Label lblEtc;

    @JsonProperty("lblEtc")
    public Label getLblEtc() {
        return lblEtc;
    }

    @JsonProperty("lblEtc")
    public void setLblEtc(Label lblEtc) {
        this.lblEtc=lblEtc;
    }

}
/**
 * celFuka121 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka121AttblFuka extends TableCell {
    @JsonProperty("lblZanteiGokei")
    private Label lblZanteiGokei;

    @JsonProperty("lblZanteiGokei")
    public Label getLblZanteiGokei() {
        return lblZanteiGokei;
    }

    @JsonProperty("lblZanteiGokei")
    public void setLblZanteiGokei(Label lblZanteiGokei) {
        this.lblZanteiGokei=lblZanteiGokei;
    }

}
/**
 * celFuka122 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka122AttblFuka extends TableCell {
    @JsonProperty("txtZanteiGokei")
    private TextBoxNum txtZanteiGokei;

    @JsonProperty("txtZanteiGokei")
    public TextBoxNum getTxtZanteiGokei() {
        return txtZanteiGokei;
    }

    @JsonProperty("txtZanteiGokei")
    public void setTxtZanteiGokei(TextBoxNum txtZanteiGokei) {
        this.txtZanteiGokei=txtZanteiGokei;
    }

}
/**
 * celFuka131 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka131AttblFuka extends TableCell {
    @JsonProperty("lblSudeniNofugaku")
    private Label lblSudeniNofugaku;

    @JsonProperty("lblSudeniNofugaku")
    public Label getLblSudeniNofugaku() {
        return lblSudeniNofugaku;
    }

    @JsonProperty("lblSudeniNofugaku")
    public void setLblSudeniNofugaku(Label lblSudeniNofugaku) {
        this.lblSudeniNofugaku=lblSudeniNofugaku;
    }

}
/**
 * celFuka132 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka132AttblFuka extends TableCell {
    @JsonProperty("txtSudeniNofugaku")
    private TextBoxNum txtSudeniNofugaku;

    @JsonProperty("txtSudeniNofugaku")
    public TextBoxNum getTxtSudeniNofugaku() {
        return txtSudeniNofugaku;
    }

    @JsonProperty("txtSudeniNofugaku")
    public void setTxtSudeniNofugaku(TextBoxNum txtSudeniNofugaku) {
        this.txtSudeniNofugaku=txtSudeniNofugaku;
    }

}
/**
 * celFuka141 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka141AttblFuka extends TableCell {
    @JsonProperty("lblKongoNofugaku")
    private Label lblKongoNofugaku;

    @JsonProperty("lblKongoNofugaku")
    public Label getLblKongoNofugaku() {
        return lblKongoNofugaku;
    }

    @JsonProperty("lblKongoNofugaku")
    public void setLblKongoNofugaku(Label lblKongoNofugaku) {
        this.lblKongoNofugaku=lblKongoNofugaku;
    }

}
/**
 * celFuka142 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka142AttblFuka extends TableCell {
    @JsonProperty("txtKongoNofugaku")
    private TextBoxNum txtKongoNofugaku;

    @JsonProperty("txtKongoNofugaku")
    public TextBoxNum getTxtKongoNofugaku() {
        return txtKongoNofugaku;
    }

    @JsonProperty("txtKongoNofugaku")
    public void setTxtKongoNofugaku(TextBoxNum txtKongoNofugaku) {
        this.txtKongoNofugaku=txtKongoNofugaku;
    }

}
/**
 * celFuka151 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka151AttblFuka extends TableCell {
    @JsonProperty("lblNofuzumigaku")
    private Label lblNofuzumigaku;

    @JsonProperty("lblNofuzumigaku")
    public Label getLblNofuzumigaku() {
        return lblNofuzumigaku;
    }

    @JsonProperty("lblNofuzumigaku")
    public void setLblNofuzumigaku(Label lblNofuzumigaku) {
        this.lblNofuzumigaku=lblNofuzumigaku;
    }

}
/**
 * celFuka152 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuka152AttblFuka extends TableCell {
    @JsonProperty("txtNofuzumigaku")
    private TextBoxNum txtNofuzumigaku;

    @JsonProperty("txtNofuzumigaku")
    public TextBoxNum getTxtNofuzumigaku() {
        return txtNofuzumigaku;
    }

    @JsonProperty("txtNofuzumigaku")
    public void setTxtNofuzumigaku(TextBoxNum txtNofuzumigaku) {
        this.txtNofuzumigaku=txtNofuzumigaku;
    }

}
