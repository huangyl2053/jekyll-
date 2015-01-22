package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IOutputOrderAndNewpageDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * OutputOrderAndNewpage のクラスファイル 
 * 
 * @author 自動生成
 */
public class OutputOrderAndNewpageDiv extends Panel implements IOutputOrderAndNewpageDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnChangeOrder")
    private Button btnChangeOrder;
    @JsonProperty("txtNewPageItem")
    private TextBox txtNewPageItem;
    @JsonProperty("txt1")
    private TextBox txt1;
    @JsonProperty("txt2")
    private TextBox txt2;
    @JsonProperty("txt3")
    private TextBox txt3;
    @JsonProperty("txt4")
    private TextBox txt4;
    @JsonProperty("txt5")
    private TextBox txt5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnChangeOrder")
    public Button getBtnChangeOrder() {
        return btnChangeOrder;
    }

    @JsonProperty("btnChangeOrder")
    public void setBtnChangeOrder(Button btnChangeOrder) {
        this.btnChangeOrder=btnChangeOrder;
    }

    @JsonProperty("txtNewPageItem")
    public TextBox getTxtNewPageItem() {
        return txtNewPageItem;
    }

    @JsonProperty("txtNewPageItem")
    public void setTxtNewPageItem(TextBox txtNewPageItem) {
        this.txtNewPageItem=txtNewPageItem;
    }

    @JsonProperty("txt1")
    public TextBox getTxt1() {
        return txt1;
    }

    @JsonProperty("txt1")
    public void setTxt1(TextBox txt1) {
        this.txt1=txt1;
    }

    @JsonProperty("txt2")
    public TextBox getTxt2() {
        return txt2;
    }

    @JsonProperty("txt2")
    public void setTxt2(TextBox txt2) {
        this.txt2=txt2;
    }

    @JsonProperty("txt3")
    public TextBox getTxt3() {
        return txt3;
    }

    @JsonProperty("txt3")
    public void setTxt3(TextBox txt3) {
        this.txt3=txt3;
    }

    @JsonProperty("txt4")
    public TextBox getTxt4() {
        return txt4;
    }

    @JsonProperty("txt4")
    public void setTxt4(TextBox txt4) {
        this.txt4=txt4;
    }

    @JsonProperty("txt5")
    public TextBox getTxt5() {
        return txt5;
    }

    @JsonProperty("txt5")
    public void setTxt5(TextBox txt5) {
        this.txt5=txt5;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
