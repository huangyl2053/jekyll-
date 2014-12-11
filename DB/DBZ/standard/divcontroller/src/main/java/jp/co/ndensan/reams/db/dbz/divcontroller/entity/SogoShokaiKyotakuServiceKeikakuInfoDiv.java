package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ISogoShokaiKyotakuServiceKeikakuInfoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiKyotakuServiceKeikakuInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKyotakuServiceKeikakuInfoDiv extends Panel implements ISogoShokaiKyotakuServiceKeikakuInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKeikakuTodokedeYMD")
    private TextBoxDate txtKeikakuTodokedeYMD;
    @JsonProperty("txtKeikakuHenkoYMD")
    private TextBoxDate txtKeikakuHenkoYMD;
    @JsonProperty("txtKeikakuJigyoshaShurui")
    private TextBox txtKeikakuJigyoshaShurui;
    @JsonProperty("txtKeikakuJigyoshaNo")
    private TextBoxCode txtKeikakuJigyoshaNo;
    @JsonProperty("txtKeikakuJigyoshaName")
    private TextBox txtKeikakuJigyoshaName;
    @JsonProperty("txtKeikakuServiceShurui")
    private TextBox txtKeikakuServiceShurui;
    @JsonProperty("txtKeikakuSakuseiKubun")
    private TextBox txtKeikakuSakuseiKubun;
    @JsonProperty("txtKeikakuYM")
    private TextBoxDate txtKeikakuYM;
    @JsonProperty("txtKeikakuKikan")
    private TextBoxDateRange txtKeikakuKikan;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKeikakuTodokedeYMD")
    public TextBoxDate getTxtKeikakuTodokedeYMD() {
        return txtKeikakuTodokedeYMD;
    }

    @JsonProperty("txtKeikakuTodokedeYMD")
    public void setTxtKeikakuTodokedeYMD(TextBoxDate txtKeikakuTodokedeYMD) {
        this.txtKeikakuTodokedeYMD=txtKeikakuTodokedeYMD;
    }

    @JsonProperty("txtKeikakuHenkoYMD")
    public TextBoxDate getTxtKeikakuHenkoYMD() {
        return txtKeikakuHenkoYMD;
    }

    @JsonProperty("txtKeikakuHenkoYMD")
    public void setTxtKeikakuHenkoYMD(TextBoxDate txtKeikakuHenkoYMD) {
        this.txtKeikakuHenkoYMD=txtKeikakuHenkoYMD;
    }

    @JsonProperty("txtKeikakuJigyoshaShurui")
    public TextBox getTxtKeikakuJigyoshaShurui() {
        return txtKeikakuJigyoshaShurui;
    }

    @JsonProperty("txtKeikakuJigyoshaShurui")
    public void setTxtKeikakuJigyoshaShurui(TextBox txtKeikakuJigyoshaShurui) {
        this.txtKeikakuJigyoshaShurui=txtKeikakuJigyoshaShurui;
    }

    @JsonProperty("txtKeikakuJigyoshaNo")
    public TextBoxCode getTxtKeikakuJigyoshaNo() {
        return txtKeikakuJigyoshaNo;
    }

    @JsonProperty("txtKeikakuJigyoshaNo")
    public void setTxtKeikakuJigyoshaNo(TextBoxCode txtKeikakuJigyoshaNo) {
        this.txtKeikakuJigyoshaNo=txtKeikakuJigyoshaNo;
    }

    @JsonProperty("txtKeikakuJigyoshaName")
    public TextBox getTxtKeikakuJigyoshaName() {
        return txtKeikakuJigyoshaName;
    }

    @JsonProperty("txtKeikakuJigyoshaName")
    public void setTxtKeikakuJigyoshaName(TextBox txtKeikakuJigyoshaName) {
        this.txtKeikakuJigyoshaName=txtKeikakuJigyoshaName;
    }

    @JsonProperty("txtKeikakuServiceShurui")
    public TextBox getTxtKeikakuServiceShurui() {
        return txtKeikakuServiceShurui;
    }

    @JsonProperty("txtKeikakuServiceShurui")
    public void setTxtKeikakuServiceShurui(TextBox txtKeikakuServiceShurui) {
        this.txtKeikakuServiceShurui=txtKeikakuServiceShurui;
    }

    @JsonProperty("txtKeikakuSakuseiKubun")
    public TextBox getTxtKeikakuSakuseiKubun() {
        return txtKeikakuSakuseiKubun;
    }

    @JsonProperty("txtKeikakuSakuseiKubun")
    public void setTxtKeikakuSakuseiKubun(TextBox txtKeikakuSakuseiKubun) {
        this.txtKeikakuSakuseiKubun=txtKeikakuSakuseiKubun;
    }

    @JsonProperty("txtKeikakuYM")
    public TextBoxDate getTxtKeikakuYM() {
        return txtKeikakuYM;
    }

    @JsonProperty("txtKeikakuYM")
    public void setTxtKeikakuYM(TextBoxDate txtKeikakuYM) {
        this.txtKeikakuYM=txtKeikakuYM;
    }

    @JsonProperty("txtKeikakuKikan")
    public TextBoxDateRange getTxtKeikakuKikan() {
        return txtKeikakuKikan;
    }

    @JsonProperty("txtKeikakuKikan")
    public void setTxtKeikakuKikan(TextBoxDateRange txtKeikakuKikan) {
        this.txtKeikakuKikan=txtKeikakuKikan;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
