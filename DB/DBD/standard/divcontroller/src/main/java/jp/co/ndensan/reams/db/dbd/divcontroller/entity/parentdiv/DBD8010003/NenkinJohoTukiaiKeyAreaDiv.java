package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NenkinJohoTukiaiKeyArea のクラスファイル 
 * 
 * @author 自動生成
 */
public class NenkinJohoTukiaiKeyAreaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbNameKana")
    private TextBox tbNameKana;
    @JsonProperty("ddlSex")
    private DropDownList ddlSex;
    @JsonProperty("tbBirthday")
    private TextBoxDate tbBirthday;
    @JsonProperty("tbNameKanji")
    private TextBox tbNameKanji;
    @JsonProperty("tbAddressKana")
    private TextBox tbAddressKana;
    @JsonProperty("tbAddressKanji")
    private TextBox tbAddressKanji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbNameKana
     * @return tbNameKana
     */
    @JsonProperty("tbNameKana")
    public TextBox getTbNameKana() {
        return tbNameKana;
    }

    /*
     * settbNameKana
     * @param tbNameKana tbNameKana
     */
    @JsonProperty("tbNameKana")
    public void setTbNameKana(TextBox tbNameKana) {
        this.tbNameKana = tbNameKana;
    }

    /*
     * getddlSex
     * @return ddlSex
     */
    @JsonProperty("ddlSex")
    public DropDownList getDdlSex() {
        return ddlSex;
    }

    /*
     * setddlSex
     * @param ddlSex ddlSex
     */
    @JsonProperty("ddlSex")
    public void setDdlSex(DropDownList ddlSex) {
        this.ddlSex = ddlSex;
    }

    /*
     * gettbBirthday
     * @return tbBirthday
     */
    @JsonProperty("tbBirthday")
    public TextBoxDate getTbBirthday() {
        return tbBirthday;
    }

    /*
     * settbBirthday
     * @param tbBirthday tbBirthday
     */
    @JsonProperty("tbBirthday")
    public void setTbBirthday(TextBoxDate tbBirthday) {
        this.tbBirthday = tbBirthday;
    }

    /*
     * gettbNameKanji
     * @return tbNameKanji
     */
    @JsonProperty("tbNameKanji")
    public TextBox getTbNameKanji() {
        return tbNameKanji;
    }

    /*
     * settbNameKanji
     * @param tbNameKanji tbNameKanji
     */
    @JsonProperty("tbNameKanji")
    public void setTbNameKanji(TextBox tbNameKanji) {
        this.tbNameKanji = tbNameKanji;
    }

    /*
     * gettbAddressKana
     * @return tbAddressKana
     */
    @JsonProperty("tbAddressKana")
    public TextBox getTbAddressKana() {
        return tbAddressKana;
    }

    /*
     * settbAddressKana
     * @param tbAddressKana tbAddressKana
     */
    @JsonProperty("tbAddressKana")
    public void setTbAddressKana(TextBox tbAddressKana) {
        this.tbAddressKana = tbAddressKana;
    }

    /*
     * gettbAddressKanji
     * @return tbAddressKanji
     */
    @JsonProperty("tbAddressKanji")
    public TextBox getTbAddressKanji() {
        return tbAddressKanji;
    }

    /*
     * settbAddressKanji
     * @param tbAddressKanji tbAddressKanji
     */
    @JsonProperty("tbAddressKanji")
    public void setTbAddressKanji(TextBox tbAddressKanji) {
        this.tbAddressKanji = tbAddressKanji;
    }

    // </editor-fold>
}
