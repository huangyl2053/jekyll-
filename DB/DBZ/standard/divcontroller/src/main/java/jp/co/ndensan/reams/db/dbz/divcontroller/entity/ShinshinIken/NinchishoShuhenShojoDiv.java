package jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinshinIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinchishoShuhenShojo のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinchishoShuhenShojoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkNinchishoShuhenShojoUmu")
    private CheckBoxList chkNinchishoShuhenShojoUmu;
    @JsonProperty("chkNinchishoShuhenShojo")
    private CheckBoxList chkNinchishoShuhenShojo;
    @JsonProperty("chkNinchishoShuhenShojoSonota")
    private CheckBoxList chkNinchishoShuhenShojoSonota;
    @JsonProperty("txtSonotaKinyu")
    private TextBox txtSonotaKinyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkNinchishoShuhenShojoUmu")
    public CheckBoxList getChkNinchishoShuhenShojoUmu() {
        return chkNinchishoShuhenShojoUmu;
    }

    @JsonProperty("chkNinchishoShuhenShojoUmu")
    public void setChkNinchishoShuhenShojoUmu(CheckBoxList chkNinchishoShuhenShojoUmu) {
        this.chkNinchishoShuhenShojoUmu=chkNinchishoShuhenShojoUmu;
    }

    @JsonProperty("chkNinchishoShuhenShojo")
    public CheckBoxList getChkNinchishoShuhenShojo() {
        return chkNinchishoShuhenShojo;
    }

    @JsonProperty("chkNinchishoShuhenShojo")
    public void setChkNinchishoShuhenShojo(CheckBoxList chkNinchishoShuhenShojo) {
        this.chkNinchishoShuhenShojo=chkNinchishoShuhenShojo;
    }

    @JsonProperty("chkNinchishoShuhenShojoSonota")
    public CheckBoxList getChkNinchishoShuhenShojoSonota() {
        return chkNinchishoShuhenShojoSonota;
    }

    @JsonProperty("chkNinchishoShuhenShojoSonota")
    public void setChkNinchishoShuhenShojoSonota(CheckBoxList chkNinchishoShuhenShojoSonota) {
        this.chkNinchishoShuhenShojoSonota=chkNinchishoShuhenShojoSonota;
    }

    @JsonProperty("txtSonotaKinyu")
    public TextBox getTxtSonotaKinyu() {
        return txtSonotaKinyu;
    }

    @JsonProperty("txtSonotaKinyu")
    public void setTxtSonotaKinyu(TextBox txtSonotaKinyu) {
        this.txtSonotaKinyu=txtSonotaKinyu;
    }

    // </editor-fold>
}
