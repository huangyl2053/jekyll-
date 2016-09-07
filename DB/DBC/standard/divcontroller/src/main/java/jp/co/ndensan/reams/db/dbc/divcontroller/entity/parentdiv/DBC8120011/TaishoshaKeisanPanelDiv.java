package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TaishoshaKeisanPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoshaKeisanPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTaishoshaKeisan")
    private RadioButton radTaishoshaKeisan;
    @JsonProperty("txtZenkaiUketoriYM")
    private TextBoxDate txtZenkaiUketoriYM;
    @JsonProperty("txtZenkaiShoriYMD")
    private TextBox txtZenkaiShoriYMD;
    @JsonProperty("txtUketoriYM")
    private TextBoxDate txtUketoriYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTaishoshaKeisan
     * @return radTaishoshaKeisan
     */
    @JsonProperty("radTaishoshaKeisan")
    public RadioButton getRadTaishoshaKeisan() {
        return radTaishoshaKeisan;
    }

    /*
     * setradTaishoshaKeisan
     * @param radTaishoshaKeisan radTaishoshaKeisan
     */
    @JsonProperty("radTaishoshaKeisan")
    public void setRadTaishoshaKeisan(RadioButton radTaishoshaKeisan) {
        this.radTaishoshaKeisan = radTaishoshaKeisan;
    }

    /*
     * gettxtZenkaiUketoriYM
     * @return txtZenkaiUketoriYM
     */
    @JsonProperty("txtZenkaiUketoriYM")
    public TextBoxDate getTxtZenkaiUketoriYM() {
        return txtZenkaiUketoriYM;
    }

    /*
     * settxtZenkaiUketoriYM
     * @param txtZenkaiUketoriYM txtZenkaiUketoriYM
     */
    @JsonProperty("txtZenkaiUketoriYM")
    public void setTxtZenkaiUketoriYM(TextBoxDate txtZenkaiUketoriYM) {
        this.txtZenkaiUketoriYM = txtZenkaiUketoriYM;
    }

    /*
     * gettxtZenkaiShoriYMD
     * @return txtZenkaiShoriYMD
     */
    @JsonProperty("txtZenkaiShoriYMD")
    public TextBox getTxtZenkaiShoriYMD() {
        return txtZenkaiShoriYMD;
    }

    /*
     * settxtZenkaiShoriYMD
     * @param txtZenkaiShoriYMD txtZenkaiShoriYMD
     */
    @JsonProperty("txtZenkaiShoriYMD")
    public void setTxtZenkaiShoriYMD(TextBox txtZenkaiShoriYMD) {
        this.txtZenkaiShoriYMD = txtZenkaiShoriYMD;
    }

    /*
     * gettxtUketoriYM
     * @return txtUketoriYM
     */
    @JsonProperty("txtUketoriYM")
    public TextBoxDate getTxtUketoriYM() {
        return txtUketoriYM;
    }

    /*
     * settxtUketoriYM
     * @param txtUketoriYM txtUketoriYM
     */
    @JsonProperty("txtUketoriYM")
    public void setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.txtUketoriYM = txtUketoriYM;
    }

    // </editor-fold>
}
