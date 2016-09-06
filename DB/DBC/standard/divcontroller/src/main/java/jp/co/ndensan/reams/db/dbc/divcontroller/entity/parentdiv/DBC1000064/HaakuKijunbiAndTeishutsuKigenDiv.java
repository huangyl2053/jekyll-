package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000064;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HaakuKijunbiAndTeishutsuKigen のクラスファイル 
 * 
 * @author 自動生成
 */
public class HaakuKijunbiAndTeishutsuKigenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
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

    // </editor-fold>
}
