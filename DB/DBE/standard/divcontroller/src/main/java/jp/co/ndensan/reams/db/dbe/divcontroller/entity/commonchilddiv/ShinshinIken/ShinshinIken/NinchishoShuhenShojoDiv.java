package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShinshinIken.ShinshinIken;
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
 */
public class NinchishoShuhenShojoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radNinchishoShuhenShojoUmu")
    private RadioButton radNinchishoShuhenShojoUmu;
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
    /*
     * getradNinchishoShuhenShojoUmu
     * @return radNinchishoShuhenShojoUmu
     */
    @JsonProperty("radNinchishoShuhenShojoUmu")
    public RadioButton getRadNinchishoShuhenShojoUmu() {
        return radNinchishoShuhenShojoUmu;
    }

    /*
     * setradNinchishoShuhenShojoUmu
     * @param radNinchishoShuhenShojoUmu radNinchishoShuhenShojoUmu
     */
    @JsonProperty("radNinchishoShuhenShojoUmu")
    public void setRadNinchishoShuhenShojoUmu(RadioButton radNinchishoShuhenShojoUmu) {
        this.radNinchishoShuhenShojoUmu = radNinchishoShuhenShojoUmu;
    }

    /*
     * getchkNinchishoShuhenShojo
     * @return chkNinchishoShuhenShojo
     */
    @JsonProperty("chkNinchishoShuhenShojo")
    public CheckBoxList getChkNinchishoShuhenShojo() {
        return chkNinchishoShuhenShojo;
    }

    /*
     * setchkNinchishoShuhenShojo
     * @param chkNinchishoShuhenShojo chkNinchishoShuhenShojo
     */
    @JsonProperty("chkNinchishoShuhenShojo")
    public void setChkNinchishoShuhenShojo(CheckBoxList chkNinchishoShuhenShojo) {
        this.chkNinchishoShuhenShojo = chkNinchishoShuhenShojo;
    }

    /*
     * getchkNinchishoShuhenShojoSonota
     * @return chkNinchishoShuhenShojoSonota
     */
    @JsonProperty("chkNinchishoShuhenShojoSonota")
    public CheckBoxList getChkNinchishoShuhenShojoSonota() {
        return chkNinchishoShuhenShojoSonota;
    }

    /*
     * setchkNinchishoShuhenShojoSonota
     * @param chkNinchishoShuhenShojoSonota chkNinchishoShuhenShojoSonota
     */
    @JsonProperty("chkNinchishoShuhenShojoSonota")
    public void setChkNinchishoShuhenShojoSonota(CheckBoxList chkNinchishoShuhenShojoSonota) {
        this.chkNinchishoShuhenShojoSonota = chkNinchishoShuhenShojoSonota;
    }

    /*
     * gettxtSonotaKinyu
     * @return txtSonotaKinyu
     */
    @JsonProperty("txtSonotaKinyu")
    public TextBox getTxtSonotaKinyu() {
        return txtSonotaKinyu;
    }

    /*
     * settxtSonotaKinyu
     * @param txtSonotaKinyu txtSonotaKinyu
     */
    @JsonProperty("txtSonotaKinyu")
    public void setTxtSonotaKinyu(TextBox txtSonotaKinyu) {
        this.txtSonotaKinyu = txtSonotaKinyu;
    }

    // </editor-fold>
}
