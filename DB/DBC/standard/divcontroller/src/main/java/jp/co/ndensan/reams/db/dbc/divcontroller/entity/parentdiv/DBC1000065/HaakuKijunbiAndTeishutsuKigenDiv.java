package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000065;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * HaakuKijunbiAndTeishutsuKigen のクラスファイル
 *
 * @reamsid_L DBC-4640-010 qinzhen
 */
public class HaakuKijunbiAndTeishutsuKigenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("blank3")
    private Space blank3;
    @JsonProperty("txtSetaiinHaakuKijunYMD")
    private TextBoxFlexibleDate txtSetaiinHaakuKijunYMD;
    @JsonProperty("txtTeishutsuKigen")
    private TextBox txtTeishutsuKigen;
    @JsonProperty("radChushutsuTaisho")
    private RadioButton radChushutsuTaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getblank3
     * @return blank3
     */
    @JsonProperty("blank3")
    public Space getBlank3() {
        return blank3;
    }

    /*
     * setblank3
     * @param blank3 blank3
     */
    @JsonProperty("blank3")
    public void setBlank3(Space blank3) {
        this.blank3 = blank3;
    }

    /*
     * gettxtSetaiinHaakuKijunYMD
     * @return txtSetaiinHaakuKijunYMD
     */
    @JsonProperty("txtSetaiinHaakuKijunYMD")
    public TextBoxFlexibleDate getTxtSetaiinHaakuKijunYMD() {
        return txtSetaiinHaakuKijunYMD;
    }

    /*
     * settxtSetaiinHaakuKijunYMD
     * @param txtSetaiinHaakuKijunYMD txtSetaiinHaakuKijunYMD
     */
    @JsonProperty("txtSetaiinHaakuKijunYMD")
    public void setTxtSetaiinHaakuKijunYMD(TextBoxFlexibleDate txtSetaiinHaakuKijunYMD) {
        this.txtSetaiinHaakuKijunYMD = txtSetaiinHaakuKijunYMD;
    }

    /*
     * gettxtTeishutsuKigen
     * @return txtTeishutsuKigen
     */
    @JsonProperty("txtTeishutsuKigen")
    public TextBox getTxtTeishutsuKigen() {
        return txtTeishutsuKigen;
    }

    /*
     * settxtTeishutsuKigen
     * @param txtTeishutsuKigen txtTeishutsuKigen
     */
    @JsonProperty("txtTeishutsuKigen")
    public void setTxtTeishutsuKigen(TextBox txtTeishutsuKigen) {
        this.txtTeishutsuKigen = txtTeishutsuKigen;
    }

    /*
     * getradChushutsuTaisho
     * @return radChushutsuTaisho
     */
    @JsonProperty("radChushutsuTaisho")
    public RadioButton getRadChushutsuTaisho() {
        return radChushutsuTaisho;
    }

    /*
     * setradChushutsuTaisho
     * @param radChushutsuTaisho radChushutsuTaisho
     */
    @JsonProperty("radChushutsuTaisho")
    public void setRadChushutsuTaisho(RadioButton radChushutsuTaisho) {
        this.radChushutsuTaisho = radChushutsuTaisho;
    }

    // </editor-fold>
}
