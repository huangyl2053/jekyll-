package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001;
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
 * ShinsaTaishoshaShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsaTaishoshaShosaiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblNenrei")
    private tblNenreiAtShinsaTaishoshaShosai tblNenrei;
    @JsonProperty("tblSex")
    private tblSexAtShinsaTaishoshaShosai tblSex;
    @JsonProperty("tblHihokenshaKubun")
    private tblHihokenshaKubunAtShinsaTaishoshaShosai tblHihokenshaKubun;
    @JsonProperty("tblShinseiKubun")
    private tblShinseiKubunAtShinsaTaishoshaShosai tblShinseiKubun;
    @JsonProperty("tblGaikyo")
    private tblGaikyoAtShinsaTaishoshaShosai tblGaikyo;
    @JsonProperty("tblNetakiri")
    private tblNetakiriAtShinsaTaishoshaShosai tblNetakiri;
    @JsonProperty("tblNinchi")
    private tblNinchiAtShinsaTaishoshaShosai tblNinchi;
    @JsonProperty("tblZenIchiji")
    private tblZenIchijiAtShinsaTaishoshaShosai tblZenIchiji;
    @JsonProperty("tblZenNiji")
    private tblZenNijiAtShinsaTaishoshaShosai tblZenNiji;
    @JsonProperty("tblIchijiHantei")
    private tblIchijiHanteiAtShinsaTaishoshaShosai tblIchijiHantei;
    @JsonProperty("tblKijunJikan")
    private tblKijunJikanAtShinsaTaishoshaShosai tblKijunJikan;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtNenrei() {
        return this.tblNenrei.getTxtNenrei();
    }

    @JsonIgnore
    public TextBox getTxtSeibetsu() {
        return this.tblSex.getTxtSeibetsu();
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaKubun() {
        return this.tblHihokenshaKubun.getTxtHihokenshaKubun();
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubun() {
        return this.tblShinseiKubun.getTxtShinseiKubun();
    }

    @JsonIgnore
    public Button getBtnGaikyo() {
        return this.tblGaikyo.getBtnGaikyo();
    }

    @JsonIgnore
    public Button getBtnNetakiri() {
        return this.tblNetakiri.getBtnNetakiri();
    }

    @JsonIgnore
    public Button getBtnNinchi() {
        return this.tblNinchi.getBtnNinchi();
    }

    @JsonIgnore
    public TextBox getTxtZenIchiji() {
        return this.tblZenIchiji.getTxtZenIchiji();
    }

    @JsonIgnore
    public TextBox getTxtZenNiji() {
        return this.tblZenNiji.getTxtZenNiji();
    }

    @JsonIgnore
    public ButtonDialog getBtnIchijiHanteiKakunin() {
        return this.tblIchijiHantei.getBtnIchijiHanteiKakunin();
    }

    @JsonIgnore
    public TextBox getTxtKijunJikan() {
        return this.tblKijunJikan.getTxtKijunJikan();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblNenrei")
    private tblNenreiAtShinsaTaishoshaShosai getTblNenrei() {
        return tblNenrei;
    }

    @JsonProperty("tblNenrei")
    private void setTblNenrei(tblNenreiAtShinsaTaishoshaShosai tblNenrei) {
        this.tblNenrei=tblNenrei;
    }

    @JsonProperty("tblSex")
    private tblSexAtShinsaTaishoshaShosai getTblSex() {
        return tblSex;
    }

    @JsonProperty("tblSex")
    private void setTblSex(tblSexAtShinsaTaishoshaShosai tblSex) {
        this.tblSex=tblSex;
    }

    @JsonProperty("tblHihokenshaKubun")
    private tblHihokenshaKubunAtShinsaTaishoshaShosai getTblHihokenshaKubun() {
        return tblHihokenshaKubun;
    }

    @JsonProperty("tblHihokenshaKubun")
    private void setTblHihokenshaKubun(tblHihokenshaKubunAtShinsaTaishoshaShosai tblHihokenshaKubun) {
        this.tblHihokenshaKubun=tblHihokenshaKubun;
    }

    @JsonProperty("tblShinseiKubun")
    private tblShinseiKubunAtShinsaTaishoshaShosai getTblShinseiKubun() {
        return tblShinseiKubun;
    }

    @JsonProperty("tblShinseiKubun")
    private void setTblShinseiKubun(tblShinseiKubunAtShinsaTaishoshaShosai tblShinseiKubun) {
        this.tblShinseiKubun=tblShinseiKubun;
    }

    @JsonProperty("tblGaikyo")
    private tblGaikyoAtShinsaTaishoshaShosai getTblGaikyo() {
        return tblGaikyo;
    }

    @JsonProperty("tblGaikyo")
    private void setTblGaikyo(tblGaikyoAtShinsaTaishoshaShosai tblGaikyo) {
        this.tblGaikyo=tblGaikyo;
    }

    @JsonProperty("tblNetakiri")
    private tblNetakiriAtShinsaTaishoshaShosai getTblNetakiri() {
        return tblNetakiri;
    }

    @JsonProperty("tblNetakiri")
    private void setTblNetakiri(tblNetakiriAtShinsaTaishoshaShosai tblNetakiri) {
        this.tblNetakiri=tblNetakiri;
    }

    @JsonProperty("tblNinchi")
    private tblNinchiAtShinsaTaishoshaShosai getTblNinchi() {
        return tblNinchi;
    }

    @JsonProperty("tblNinchi")
    private void setTblNinchi(tblNinchiAtShinsaTaishoshaShosai tblNinchi) {
        this.tblNinchi=tblNinchi;
    }

    @JsonProperty("tblZenIchiji")
    private tblZenIchijiAtShinsaTaishoshaShosai getTblZenIchiji() {
        return tblZenIchiji;
    }

    @JsonProperty("tblZenIchiji")
    private void setTblZenIchiji(tblZenIchijiAtShinsaTaishoshaShosai tblZenIchiji) {
        this.tblZenIchiji=tblZenIchiji;
    }

    @JsonProperty("tblZenNiji")
    private tblZenNijiAtShinsaTaishoshaShosai getTblZenNiji() {
        return tblZenNiji;
    }

    @JsonProperty("tblZenNiji")
    private void setTblZenNiji(tblZenNijiAtShinsaTaishoshaShosai tblZenNiji) {
        this.tblZenNiji=tblZenNiji;
    }

    @JsonProperty("tblIchijiHantei")
    private tblIchijiHanteiAtShinsaTaishoshaShosai getTblIchijiHantei() {
        return tblIchijiHantei;
    }

    @JsonProperty("tblIchijiHantei")
    private void setTblIchijiHantei(tblIchijiHanteiAtShinsaTaishoshaShosai tblIchijiHantei) {
        this.tblIchijiHantei=tblIchijiHantei;
    }

    @JsonProperty("tblKijunJikan")
    private tblKijunJikanAtShinsaTaishoshaShosai getTblKijunJikan() {
        return tblKijunJikan;
    }

    @JsonProperty("tblKijunJikan")
    private void setTblKijunJikan(tblKijunJikanAtShinsaTaishoshaShosai tblKijunJikan) {
        this.tblKijunJikan=tblKijunJikan;
    }

}
/**
 * tblNenrei のクラスファイル 
 * 
 * @author 自動生成
 */
class tblNenreiAtShinsaTaishoshaShosai extends TableCell {
    @JsonProperty("txtNenrei")
    private TextBox txtNenrei;

    @JsonProperty("txtNenrei")
    public TextBox getTxtNenrei() {
        return txtNenrei;
    }

    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBox txtNenrei) {
        this.txtNenrei=txtNenrei;
    }

}
/**
 * tblSex のクラスファイル 
 * 
 * @author 自動生成
 */
class tblSexAtShinsaTaishoshaShosai extends TableCell {
    @JsonProperty("txtSeibetsu")
    private TextBox txtSeibetsu;

    @JsonProperty("txtSeibetsu")
    public TextBox getTxtSeibetsu() {
        return txtSeibetsu;
    }

    @JsonProperty("txtSeibetsu")
    public void setTxtSeibetsu(TextBox txtSeibetsu) {
        this.txtSeibetsu=txtSeibetsu;
    }

}
/**
 * tblHihokenshaKubun のクラスファイル 
 * 
 * @author 自動生成
 */
class tblHihokenshaKubunAtShinsaTaishoshaShosai extends TableCell {
    @JsonProperty("txtHihokenshaKubun")
    private TextBox txtHihokenshaKubun;

    @JsonProperty("txtHihokenshaKubun")
    public TextBox getTxtHihokenshaKubun() {
        return txtHihokenshaKubun;
    }

    @JsonProperty("txtHihokenshaKubun")
    public void setTxtHihokenshaKubun(TextBox txtHihokenshaKubun) {
        this.txtHihokenshaKubun=txtHihokenshaKubun;
    }

}
/**
 * tblShinseiKubun のクラスファイル 
 * 
 * @author 自動生成
 */
class tblShinseiKubunAtShinsaTaishoshaShosai extends TableCell {
    @JsonProperty("txtShinseiKubun")
    private TextBox txtShinseiKubun;

    @JsonProperty("txtShinseiKubun")
    public TextBox getTxtShinseiKubun() {
        return txtShinseiKubun;
    }

    @JsonProperty("txtShinseiKubun")
    public void setTxtShinseiKubun(TextBox txtShinseiKubun) {
        this.txtShinseiKubun=txtShinseiKubun;
    }

}
/**
 * tblGaikyo のクラスファイル 
 * 
 * @author 自動生成
 */
class tblGaikyoAtShinsaTaishoshaShosai extends TableCell {
    @JsonProperty("btnGaikyo")
    private Button btnGaikyo;

    @JsonProperty("btnGaikyo")
    public Button getBtnGaikyo() {
        return btnGaikyo;
    }

    @JsonProperty("btnGaikyo")
    public void setBtnGaikyo(Button btnGaikyo) {
        this.btnGaikyo=btnGaikyo;
    }

}
/**
 * tblNetakiri のクラスファイル 
 * 
 * @author 自動生成
 */
class tblNetakiriAtShinsaTaishoshaShosai extends TableCell {
    @JsonProperty("btnNetakiri")
    private Button btnNetakiri;

    @JsonProperty("btnNetakiri")
    public Button getBtnNetakiri() {
        return btnNetakiri;
    }

    @JsonProperty("btnNetakiri")
    public void setBtnNetakiri(Button btnNetakiri) {
        this.btnNetakiri=btnNetakiri;
    }

}
/**
 * tblNinchi のクラスファイル 
 * 
 * @author 自動生成
 */
class tblNinchiAtShinsaTaishoshaShosai extends TableCell {
    @JsonProperty("btnNinchi")
    private Button btnNinchi;

    @JsonProperty("btnNinchi")
    public Button getBtnNinchi() {
        return btnNinchi;
    }

    @JsonProperty("btnNinchi")
    public void setBtnNinchi(Button btnNinchi) {
        this.btnNinchi=btnNinchi;
    }

}
/**
 * tblZenIchiji のクラスファイル 
 * 
 * @author 自動生成
 */
class tblZenIchijiAtShinsaTaishoshaShosai extends TableCell {
    @JsonProperty("txtZenIchiji")
    private TextBox txtZenIchiji;

    @JsonProperty("txtZenIchiji")
    public TextBox getTxtZenIchiji() {
        return txtZenIchiji;
    }

    @JsonProperty("txtZenIchiji")
    public void setTxtZenIchiji(TextBox txtZenIchiji) {
        this.txtZenIchiji=txtZenIchiji;
    }

}
/**
 * tblZenNiji のクラスファイル 
 * 
 * @author 自動生成
 */
class tblZenNijiAtShinsaTaishoshaShosai extends TableCell {
    @JsonProperty("txtZenNiji")
    private TextBox txtZenNiji;

    @JsonProperty("txtZenNiji")
    public TextBox getTxtZenNiji() {
        return txtZenNiji;
    }

    @JsonProperty("txtZenNiji")
    public void setTxtZenNiji(TextBox txtZenNiji) {
        this.txtZenNiji=txtZenNiji;
    }

}
/**
 * tblIchijiHantei のクラスファイル 
 * 
 * @author 自動生成
 */
class tblIchijiHanteiAtShinsaTaishoshaShosai extends TableCell {
    @JsonProperty("btnIchijiHanteiKakunin")
    private ButtonDialog btnIchijiHanteiKakunin;

    @JsonProperty("btnIchijiHanteiKakunin")
    public ButtonDialog getBtnIchijiHanteiKakunin() {
        return btnIchijiHanteiKakunin;
    }

    @JsonProperty("btnIchijiHanteiKakunin")
    public void setBtnIchijiHanteiKakunin(ButtonDialog btnIchijiHanteiKakunin) {
        this.btnIchijiHanteiKakunin=btnIchijiHanteiKakunin;
    }

}
/**
 * tblKijunJikan のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKijunJikanAtShinsaTaishoshaShosai extends TableCell {
    @JsonProperty("txtKijunJikan")
    private TextBox txtKijunJikan;

    @JsonProperty("txtKijunJikan")
    public TextBox getTxtKijunJikan() {
        return txtKijunJikan;
    }

    @JsonProperty("txtKijunJikan")
    public void setTxtKijunJikan(TextBox txtKijunJikan) {
        this.txtKijunJikan=txtKijunJikan;
    }

}
