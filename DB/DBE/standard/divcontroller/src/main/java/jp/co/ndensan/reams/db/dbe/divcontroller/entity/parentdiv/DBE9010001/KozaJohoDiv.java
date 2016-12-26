package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KozaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KozaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlYokinShubetsu")
    private DropDownList ddlYokinShubetsu;
    @JsonProperty("txtGinkoKozaNo")
    private TextBoxCode txtGinkoKozaNo;
    @JsonProperty("txtKozaMeiginin")
    private TextBoxKana txtKozaMeiginin;
    @JsonProperty("txtKanjiMeiginin")
    private TextBox txtKanjiMeiginin;
    @JsonProperty("ccdKozaJohoMeisaiKinyuKikanInput")
    private KinyuKikanInputDiv ccdKozaJohoMeisaiKinyuKikanInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlYokinShubetsu
     * @return ddlYokinShubetsu
     */
    @JsonProperty("ddlYokinShubetsu")
    public DropDownList getDdlYokinShubetsu() {
        return ddlYokinShubetsu;
    }

    /*
     * setddlYokinShubetsu
     * @param ddlYokinShubetsu ddlYokinShubetsu
     */
    @JsonProperty("ddlYokinShubetsu")
    public void setDdlYokinShubetsu(DropDownList ddlYokinShubetsu) {
        this.ddlYokinShubetsu = ddlYokinShubetsu;
    }

    /*
     * gettxtGinkoKozaNo
     * @return txtGinkoKozaNo
     */
    @JsonProperty("txtGinkoKozaNo")
    public TextBoxCode getTxtGinkoKozaNo() {
        return txtGinkoKozaNo;
    }

    /*
     * settxtGinkoKozaNo
     * @param txtGinkoKozaNo txtGinkoKozaNo
     */
    @JsonProperty("txtGinkoKozaNo")
    public void setTxtGinkoKozaNo(TextBoxCode txtGinkoKozaNo) {
        this.txtGinkoKozaNo = txtGinkoKozaNo;
    }

    /*
     * gettxtKozaMeiginin
     * @return txtKozaMeiginin
     */
    @JsonProperty("txtKozaMeiginin")
    public TextBoxKana getTxtKozaMeiginin() {
        return txtKozaMeiginin;
    }

    /*
     * settxtKozaMeiginin
     * @param txtKozaMeiginin txtKozaMeiginin
     */
    @JsonProperty("txtKozaMeiginin")
    public void setTxtKozaMeiginin(TextBoxKana txtKozaMeiginin) {
        this.txtKozaMeiginin = txtKozaMeiginin;
    }

    /*
     * gettxtKanjiMeiginin
     * @return txtKanjiMeiginin
     */
    @JsonProperty("txtKanjiMeiginin")
    public TextBox getTxtKanjiMeiginin() {
        return txtKanjiMeiginin;
    }

    /*
     * settxtKanjiMeiginin
     * @param txtKanjiMeiginin txtKanjiMeiginin
     */
    @JsonProperty("txtKanjiMeiginin")
    public void setTxtKanjiMeiginin(TextBox txtKanjiMeiginin) {
        this.txtKanjiMeiginin = txtKanjiMeiginin;
    }

    /*
     * getccdKozaJohoMeisaiKinyuKikanInput
     * @return ccdKozaJohoMeisaiKinyuKikanInput
     */
    @JsonProperty("ccdKozaJohoMeisaiKinyuKikanInput")
    public IKinyuKikanInputDiv getCcdKozaJohoMeisaiKinyuKikanInput() {
        return ccdKozaJohoMeisaiKinyuKikanInput;
    }

    // </editor-fold>
}
