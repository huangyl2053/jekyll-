package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002.FukakonkyoNengakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002.tblFukakonkyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002.tblKikanDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku.KiwarigakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

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

    @JsonProperty("cellFukaShokai11")
    private cellFukaShokai11AttblFukaKonkyo cellFukaShokai11;
    @JsonProperty("cellFukaShokai12")
    private cellFukaShokai12AttblFukaKonkyo cellFukaShokai12;
    @JsonProperty("cellFukaShokai13")
    private cellFukaShokai13AttblFukaKonkyo cellFukaShokai13;
    @JsonProperty("cellFukaShokai14")
    private cellFukaShokai14AttblFukaKonkyo cellFukaShokai14;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public tblFukakonkyoMeisaiDiv getTblFukakonkyoMeisai() {
        return this.cellFukaShokai11.getTblFukakonkyoMeisai();
    }

    @JsonIgnore
    public KiwarigakuDiv getFukaShokaiKiwarigaku() {
        return this.cellFukaShokai12.getFukaShokaiKiwarigaku();
    }

    @JsonIgnore
    public tblKikanDiv getTblKikan() {
        return this.cellFukaShokai13.getTblKikan();
    }

    @JsonIgnore
    public FukakonkyoNengakuDiv getFukakonkyoNengaku() {
        return this.cellFukaShokai13.getFukakonkyoNengaku();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu1() {
        return this.cellFukaShokai14.getTxtFukashokaiChoteiJiyu1();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu2() {
        return this.cellFukaShokai14.getTxtFukashokaiChoteiJiyu2();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu3() {
        return this.cellFukaShokai14.getTxtFukashokaiChoteiJiyu3();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu4() {
        return this.cellFukaShokai14.getTxtFukashokaiChoteiJiyu4();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("cellFukaShokai11")
    private cellFukaShokai11AttblFukaKonkyo getCellFukaShokai11() {
        return cellFukaShokai11;
    }

    @JsonProperty("cellFukaShokai11")
    private void setCellFukaShokai11(cellFukaShokai11AttblFukaKonkyo cellFukaShokai11) {
        this.cellFukaShokai11 = cellFukaShokai11;
    }

    @JsonProperty("cellFukaShokai12")
    private cellFukaShokai12AttblFukaKonkyo getCellFukaShokai12() {
        return cellFukaShokai12;
    }

    @JsonProperty("cellFukaShokai12")
    private void setCellFukaShokai12(cellFukaShokai12AttblFukaKonkyo cellFukaShokai12) {
        this.cellFukaShokai12 = cellFukaShokai12;
    }

    @JsonProperty("cellFukaShokai13")
    private cellFukaShokai13AttblFukaKonkyo getCellFukaShokai13() {
        return cellFukaShokai13;
    }

    @JsonProperty("cellFukaShokai13")
    private void setCellFukaShokai13(cellFukaShokai13AttblFukaKonkyo cellFukaShokai13) {
        this.cellFukaShokai13 = cellFukaShokai13;
    }

    @JsonProperty("cellFukaShokai14")
    private cellFukaShokai14AttblFukaKonkyo getCellFukaShokai14() {
        return cellFukaShokai14;
    }

    @JsonProperty("cellFukaShokai14")
    private void setCellFukaShokai14(cellFukaShokai14AttblFukaKonkyo cellFukaShokai14) {
        this.cellFukaShokai14 = cellFukaShokai14;
    }

}

/**
 * cellFukaShokai11 のクラスファイル
 *
 * @author 自動生成
 */
class cellFukaShokai11AttblFukaKonkyo extends TableCell {

    @JsonProperty("tblFukakonkyoMeisai")
    private tblFukakonkyoMeisaiDiv tblFukakonkyoMeisai;

    @JsonProperty("tblFukakonkyoMeisai")
    public tblFukakonkyoMeisaiDiv getTblFukakonkyoMeisai() {
        return tblFukakonkyoMeisai;
    }

    @JsonProperty("tblFukakonkyoMeisai")
    public void setTblFukakonkyoMeisai(tblFukakonkyoMeisaiDiv tblFukakonkyoMeisai) {
        this.tblFukakonkyoMeisai = tblFukakonkyoMeisai;
    }

}

/**
 * cellFukaShokai12 のクラスファイル
 *
 * @author 自動生成
 */
class cellFukaShokai12AttblFukaKonkyo extends TableCell {

    @JsonProperty("FukaShokaiKiwarigaku")
    private KiwarigakuDiv FukaShokaiKiwarigaku;

    @JsonProperty("FukaShokaiKiwarigaku")
    public KiwarigakuDiv getFukaShokaiKiwarigaku() {
        return FukaShokaiKiwarigaku;
    }

}

/**
 * cellFukaShokai13 のクラスファイル
 *
 * @author 自動生成
 */
class cellFukaShokai13AttblFukaKonkyo extends TableCell {

    @JsonProperty("tblKikan")
    private tblKikanDiv tblKikan;
    @JsonProperty("FukakonkyoNengaku")
    private FukakonkyoNengakuDiv FukakonkyoNengaku;

    @JsonProperty("tblKikan")
    public tblKikanDiv getTblKikan() {
        return tblKikan;
    }

    @JsonProperty("tblKikan")
    public void setTblKikan(tblKikanDiv tblKikan) {
        this.tblKikan = tblKikan;
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
 * cellFukaShokai14 のクラスファイル
 *
 * @author 自動生成
 */
class cellFukaShokai14AttblFukaKonkyo extends TableCell {

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
