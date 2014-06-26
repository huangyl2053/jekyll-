package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.InjiNaiyoSetteiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaShokaiGrandson のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaShokaiGrandsonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBox txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("txtKoseiM")
    private TextBox txtKoseiM;
    @JsonProperty("txtKoseiYMD")
    private TextBox txtKoseiYMD;
    @JsonProperty("InjiNaiyoSettei")
    private InjiNaiyoSetteiDiv InjiNaiyoSettei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo")
    public TextBox getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.txtChoteiNendo=txtChoteiNendo;
    }

    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo=txtFukaNendo;
    }

    @JsonProperty("txtKoseiM")
    public TextBox getTxtKoseiM() {
        return txtKoseiM;
    }

    @JsonProperty("txtKoseiM")
    public void setTxtKoseiM(TextBox txtKoseiM) {
        this.txtKoseiM=txtKoseiM;
    }

    @JsonProperty("txtKoseiYMD")
    public TextBox getTxtKoseiYMD() {
        return txtKoseiYMD;
    }

    @JsonProperty("txtKoseiYMD")
    public void setTxtKoseiYMD(TextBox txtKoseiYMD) {
        this.txtKoseiYMD=txtKoseiYMD;
    }

    @JsonProperty("InjiNaiyoSettei")
    public InjiNaiyoSetteiDiv getInjiNaiyoSettei() {
        return InjiNaiyoSettei;
    }

    @JsonProperty("InjiNaiyoSettei")
    public void setInjiNaiyoSettei(InjiNaiyoSetteiDiv InjiNaiyoSettei) {
        this.InjiNaiyoSettei=InjiNaiyoSettei;
    }

}
