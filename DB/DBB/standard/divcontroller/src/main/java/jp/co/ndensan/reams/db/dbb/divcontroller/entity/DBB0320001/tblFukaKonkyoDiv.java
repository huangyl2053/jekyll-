package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukakonkyoNengakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.KikanDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.tblFukakonkyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.tblKikan1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.tblKikan2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku.IKiwarigakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku.KiwarigakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblFukaKonkyo のクラスファイル
 *
 * @author 自動生成
 */
public class tblFukaKonkyoDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("celFukaKonkyo")
    private celFukaKonkyoAttblFukaKonkyo celFukaKonkyo;
    @JsonProperty("celKiwari")
    private celKiwariAttblFukaKonkyo celKiwari;
    @JsonProperty("celKikan")
    private celKikanAttblFukaKonkyo celKikan;
    @JsonProperty("celChoteiJiyu")
    private celChoteiJiyuAttblFukaKonkyo celChoteiJiyu;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public tblFukakonkyoMeisaiDiv getTblFukakonkyoMeisai() {
        return this.celFukaKonkyo.getTblFukakonkyoMeisai();
    }

    @JsonIgnore
    public Label getLblDamy() {
        return this.celFukaKonkyo.getLblDamy();
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiKeisanjoHokenryoGaku() {
        return this.celFukaKonkyo.getTxtZanteiKeisanjoHokenryoGaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiGemmenGaku() {
        return this.celFukaKonkyo.getTxtZanteiGemmenGaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiHokenryoGaku() {
        return this.celFukaKonkyo.getTxtZanteiHokenryoGaku();
    }

    @JsonIgnore
    public IKiwarigakuDiv getCcdKiwarigaku() {
        return this.celKiwari.getCcdKiwarigaku();
    }

    @JsonIgnore
    public KikanDiv getKikan() {
        return this.celKikan.getKikan();
    }

    @JsonIgnore
    public FukakonkyoNengakuDiv getFukakonkyoNengaku() {
        return this.celKikan.getFukakonkyoNengaku();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu1() {
        return this.celChoteiJiyu.getTxtFukashokaiChoteiJiyu1();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu2() {
        return this.celChoteiJiyu.getTxtFukashokaiChoteiJiyu2();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu3() {
        return this.celChoteiJiyu.getTxtFukashokaiChoteiJiyu3();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu4() {
        return this.celChoteiJiyu.getTxtFukashokaiChoteiJiyu4();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celFukaKonkyo")
    private celFukaKonkyoAttblFukaKonkyo getCelFukaKonkyo() {
        return celFukaKonkyo;
    }

    @JsonProperty("celFukaKonkyo")
    private void setCelFukaKonkyo(celFukaKonkyoAttblFukaKonkyo celFukaKonkyo) {
        this.celFukaKonkyo = celFukaKonkyo;
    }

    @JsonProperty("celKiwari")
    private celKiwariAttblFukaKonkyo getCelKiwari() {
        return celKiwari;
    }

    @JsonProperty("celKiwari")
    private void setCelKiwari(celKiwariAttblFukaKonkyo celKiwari) {
        this.celKiwari = celKiwari;
    }

    @JsonProperty("celKikan")
    private celKikanAttblFukaKonkyo getCelKikan() {
        return celKikan;
    }

    @JsonProperty("celKikan")
    private void setCelKikan(celKikanAttblFukaKonkyo celKikan) {
        this.celKikan = celKikan;
    }

    @JsonProperty("celChoteiJiyu")
    private celChoteiJiyuAttblFukaKonkyo getCelChoteiJiyu() {
        return celChoteiJiyu;
    }

    @JsonProperty("celChoteiJiyu")
    private void setCelChoteiJiyu(celChoteiJiyuAttblFukaKonkyo celChoteiJiyu) {
        this.celChoteiJiyu = celChoteiJiyu;
    }

}

/**
 * celFukaKonkyo のクラスファイル
 *
 * @author 自動生成
 */
class celFukaKonkyoAttblFukaKonkyo extends TableCell {

    @JsonProperty("tblFukakonkyoMeisai")
    private tblFukakonkyoMeisaiDiv tblFukakonkyoMeisai;
    @JsonProperty("lblDamy")
    private Label lblDamy;
    @JsonProperty("txtZanteiKeisanjoHokenryoGaku")
    private TextBoxNum txtZanteiKeisanjoHokenryoGaku;
    @JsonProperty("txtZanteiGemmenGaku")
    private TextBoxNum txtZanteiGemmenGaku;
    @JsonProperty("txtZanteiHokenryoGaku")
    private TextBoxNum txtZanteiHokenryoGaku;

    @JsonProperty("tblFukakonkyoMeisai")
    public tblFukakonkyoMeisaiDiv getTblFukakonkyoMeisai() {
        return tblFukakonkyoMeisai;
    }

    @JsonProperty("tblFukakonkyoMeisai")
    public void setTblFukakonkyoMeisai(tblFukakonkyoMeisaiDiv tblFukakonkyoMeisai) {
        this.tblFukakonkyoMeisai = tblFukakonkyoMeisai;
    }

    @JsonProperty("lblDamy")
    public Label getLblDamy() {
        return lblDamy;
    }

    @JsonProperty("lblDamy")
    public void setLblDamy(Label lblDamy) {
        this.lblDamy = lblDamy;
    }

    @JsonProperty("txtZanteiKeisanjoHokenryoGaku")
    public TextBoxNum getTxtZanteiKeisanjoHokenryoGaku() {
        return txtZanteiKeisanjoHokenryoGaku;
    }

    @JsonProperty("txtZanteiKeisanjoHokenryoGaku")
    public void setTxtZanteiKeisanjoHokenryoGaku(TextBoxNum txtZanteiKeisanjoHokenryoGaku) {
        this.txtZanteiKeisanjoHokenryoGaku = txtZanteiKeisanjoHokenryoGaku;
    }

    @JsonProperty("txtZanteiGemmenGaku")
    public TextBoxNum getTxtZanteiGemmenGaku() {
        return txtZanteiGemmenGaku;
    }

    @JsonProperty("txtZanteiGemmenGaku")
    public void setTxtZanteiGemmenGaku(TextBoxNum txtZanteiGemmenGaku) {
        this.txtZanteiGemmenGaku = txtZanteiGemmenGaku;
    }

    @JsonProperty("txtZanteiHokenryoGaku")
    public TextBoxNum getTxtZanteiHokenryoGaku() {
        return txtZanteiHokenryoGaku;
    }

    @JsonProperty("txtZanteiHokenryoGaku")
    public void setTxtZanteiHokenryoGaku(TextBoxNum txtZanteiHokenryoGaku) {
        this.txtZanteiHokenryoGaku = txtZanteiHokenryoGaku;
    }

}

/**
 * celKiwari のクラスファイル
 *
 * @author 自動生成
 */
class celKiwariAttblFukaKonkyo extends TableCell {

    @JsonProperty("ccdKiwarigaku")
    private KiwarigakuDiv ccdKiwarigaku;

    @JsonProperty("ccdKiwarigaku")
    public IKiwarigakuDiv getCcdKiwarigaku() {
        return ccdKiwarigaku;
    }

}

/**
 * celKikan のクラスファイル
 *
 * @author 自動生成
 */
class celKikanAttblFukaKonkyo extends TableCell {

    @JsonProperty("Kikan")
    private KikanDiv Kikan;
    @JsonProperty("FukakonkyoNengaku")
    private FukakonkyoNengakuDiv FukakonkyoNengaku;

    @JsonProperty("Kikan")
    public KikanDiv getKikan() {
        return Kikan;
    }

    @JsonProperty("Kikan")
    public void setKikan(KikanDiv Kikan) {
        this.Kikan = Kikan;
    }

    @JsonProperty("FukakonkyoNengaku")
    public FukakonkyoNengakuDiv getFukakonkyoNengaku() {
        return FukakonkyoNengaku;
    }

    @JsonProperty("FukakonkyoNengaku")
    public void setFukakonkyoNengaku(FukakonkyoNengakuDiv FukakonkyoNengaku) {
        this.FukakonkyoNengaku = FukakonkyoNengaku;
    }

}

/**
 * celChoteiJiyu のクラスファイル
 *
 * @author 自動生成
 */
class celChoteiJiyuAttblFukaKonkyo extends TableCell {

    @JsonProperty("txtFukashokaiChoteiJiyu1")
    private TextBox txtFukashokaiChoteiJiyu1;
    @JsonProperty("txtFukashokaiChoteiJiyu2")
    private TextBox txtFukashokaiChoteiJiyu2;
    @JsonProperty("txtFukashokaiChoteiJiyu3")
    private TextBox txtFukashokaiChoteiJiyu3;
    @JsonProperty("txtFukashokaiChoteiJiyu4")
    private TextBox txtFukashokaiChoteiJiyu4;

    @JsonProperty("txtFukashokaiChoteiJiyu1")
    public TextBox getTxtFukashokaiChoteiJiyu1() {
        return txtFukashokaiChoteiJiyu1;
    }

    @JsonProperty("txtFukashokaiChoteiJiyu1")
    public void setTxtFukashokaiChoteiJiyu1(TextBox txtFukashokaiChoteiJiyu1) {
        this.txtFukashokaiChoteiJiyu1 = txtFukashokaiChoteiJiyu1;
    }

    @JsonProperty("txtFukashokaiChoteiJiyu2")
    public TextBox getTxtFukashokaiChoteiJiyu2() {
        return txtFukashokaiChoteiJiyu2;
    }

    @JsonProperty("txtFukashokaiChoteiJiyu2")
    public void setTxtFukashokaiChoteiJiyu2(TextBox txtFukashokaiChoteiJiyu2) {
        this.txtFukashokaiChoteiJiyu2 = txtFukashokaiChoteiJiyu2;
    }

    @JsonProperty("txtFukashokaiChoteiJiyu3")
    public TextBox getTxtFukashokaiChoteiJiyu3() {
        return txtFukashokaiChoteiJiyu3;
    }

    @JsonProperty("txtFukashokaiChoteiJiyu3")
    public void setTxtFukashokaiChoteiJiyu3(TextBox txtFukashokaiChoteiJiyu3) {
        this.txtFukashokaiChoteiJiyu3 = txtFukashokaiChoteiJiyu3;
    }

    @JsonProperty("txtFukashokaiChoteiJiyu4")
    public TextBox getTxtFukashokaiChoteiJiyu4() {
        return txtFukashokaiChoteiJiyu4;
    }

    @JsonProperty("txtFukashokaiChoteiJiyu4")
    public void setTxtFukashokaiChoteiJiyu4(TextBox txtFukashokaiChoteiJiyu4) {
        this.txtFukashokaiChoteiJiyu4 = txtFukashokaiChoteiJiyu4;
    }

}
