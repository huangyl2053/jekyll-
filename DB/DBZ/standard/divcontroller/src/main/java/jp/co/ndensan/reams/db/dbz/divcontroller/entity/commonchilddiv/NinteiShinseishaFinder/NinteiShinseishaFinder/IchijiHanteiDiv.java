package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHantei のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class IchijiHanteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIchijiHanteiDateFrom")
    private TextBoxFlexibleDate txtIchijiHanteiDateFrom;
    @JsonProperty("lblIchijiHanteiDate")
    private Label lblIchijiHanteiDate;
    @JsonProperty("txtIchijiHanteiDateTo")
    private TextBoxFlexibleDate txtIchijiHanteiDateTo;
    @JsonProperty("ddlIchijiHanteiKekka")
    private DropDownList ddlIchijiHanteiKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIchijiHanteiDateFrom
     * @return txtIchijiHanteiDateFrom
     */
    @JsonProperty("txtIchijiHanteiDateFrom")
    public TextBoxFlexibleDate getTxtIchijiHanteiDateFrom() {
        return txtIchijiHanteiDateFrom;
    }

    /*
     * settxtIchijiHanteiDateFrom
     * @param txtIchijiHanteiDateFrom txtIchijiHanteiDateFrom
     */
    @JsonProperty("txtIchijiHanteiDateFrom")
    public void setTxtIchijiHanteiDateFrom(TextBoxFlexibleDate txtIchijiHanteiDateFrom) {
        this.txtIchijiHanteiDateFrom = txtIchijiHanteiDateFrom;
    }

    /*
     * getlblIchijiHanteiDate
     * @return lblIchijiHanteiDate
     */
    @JsonProperty("lblIchijiHanteiDate")
    public Label getLblIchijiHanteiDate() {
        return lblIchijiHanteiDate;
    }

    /*
     * setlblIchijiHanteiDate
     * @param lblIchijiHanteiDate lblIchijiHanteiDate
     */
    @JsonProperty("lblIchijiHanteiDate")
    public void setLblIchijiHanteiDate(Label lblIchijiHanteiDate) {
        this.lblIchijiHanteiDate = lblIchijiHanteiDate;
    }

    /*
     * gettxtIchijiHanteiDateTo
     * @return txtIchijiHanteiDateTo
     */
    @JsonProperty("txtIchijiHanteiDateTo")
    public TextBoxFlexibleDate getTxtIchijiHanteiDateTo() {
        return txtIchijiHanteiDateTo;
    }

    /*
     * settxtIchijiHanteiDateTo
     * @param txtIchijiHanteiDateTo txtIchijiHanteiDateTo
     */
    @JsonProperty("txtIchijiHanteiDateTo")
    public void setTxtIchijiHanteiDateTo(TextBoxFlexibleDate txtIchijiHanteiDateTo) {
        this.txtIchijiHanteiDateTo = txtIchijiHanteiDateTo;
    }

    /*
     * getddlIchijiHanteiKekka
     * @return ddlIchijiHanteiKekka
     */
    @JsonProperty("ddlIchijiHanteiKekka")
    public DropDownList getDdlIchijiHanteiKekka() {
        return ddlIchijiHanteiKekka;
    }

    /*
     * setddlIchijiHanteiKekka
     * @param ddlIchijiHanteiKekka ddlIchijiHanteiKekka
     */
    @JsonProperty("ddlIchijiHanteiKekka")
    public void setDdlIchijiHanteiKekka(DropDownList ddlIchijiHanteiKekka) {
        this.ddlIchijiHanteiKekka = ddlIchijiHanteiKekka;
    }

    // </editor-fold>
}
