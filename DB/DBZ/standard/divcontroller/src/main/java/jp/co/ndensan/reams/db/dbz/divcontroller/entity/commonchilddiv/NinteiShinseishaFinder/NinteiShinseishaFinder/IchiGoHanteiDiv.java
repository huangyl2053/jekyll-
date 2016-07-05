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
 * IchiGoHantei のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class IchiGoHanteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIchiGoHanteiDateFrom")
    private TextBoxFlexibleDate txtIchiGoHanteiDateFrom;
    @JsonProperty("lblIchiGoHanteiDate")
    private Label lblIchiGoHanteiDate;
    @JsonProperty("txtIchiGoHanteiDateTo")
    private TextBoxFlexibleDate txtIchiGoHanteiDateTo;
    @JsonProperty("ddlIchiGohanteiKekka")
    private DropDownList ddlIchiGohanteiKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIchiGoHanteiDateFrom
     * @return txtIchiGoHanteiDateFrom
     */
    @JsonProperty("txtIchiGoHanteiDateFrom")
    public TextBoxFlexibleDate getTxtIchiGoHanteiDateFrom() {
        return txtIchiGoHanteiDateFrom;
    }

    /*
     * settxtIchiGoHanteiDateFrom
     * @param txtIchiGoHanteiDateFrom txtIchiGoHanteiDateFrom
     */
    @JsonProperty("txtIchiGoHanteiDateFrom")
    public void setTxtIchiGoHanteiDateFrom(TextBoxFlexibleDate txtIchiGoHanteiDateFrom) {
        this.txtIchiGoHanteiDateFrom = txtIchiGoHanteiDateFrom;
    }

    /*
     * getlblIchiGoHanteiDate
     * @return lblIchiGoHanteiDate
     */
    @JsonProperty("lblIchiGoHanteiDate")
    public Label getLblIchiGoHanteiDate() {
        return lblIchiGoHanteiDate;
    }

    /*
     * setlblIchiGoHanteiDate
     * @param lblIchiGoHanteiDate lblIchiGoHanteiDate
     */
    @JsonProperty("lblIchiGoHanteiDate")
    public void setLblIchiGoHanteiDate(Label lblIchiGoHanteiDate) {
        this.lblIchiGoHanteiDate = lblIchiGoHanteiDate;
    }

    /*
     * gettxtIchiGoHanteiDateTo
     * @return txtIchiGoHanteiDateTo
     */
    @JsonProperty("txtIchiGoHanteiDateTo")
    public TextBoxFlexibleDate getTxtIchiGoHanteiDateTo() {
        return txtIchiGoHanteiDateTo;
    }

    /*
     * settxtIchiGoHanteiDateTo
     * @param txtIchiGoHanteiDateTo txtIchiGoHanteiDateTo
     */
    @JsonProperty("txtIchiGoHanteiDateTo")
    public void setTxtIchiGoHanteiDateTo(TextBoxFlexibleDate txtIchiGoHanteiDateTo) {
        this.txtIchiGoHanteiDateTo = txtIchiGoHanteiDateTo;
    }

    /*
     * getddlIchiGohanteiKekka
     * @return ddlIchiGohanteiKekka
     */
    @JsonProperty("ddlIchiGohanteiKekka")
    public DropDownList getDdlIchiGohanteiKekka() {
        return ddlIchiGohanteiKekka;
    }

    /*
     * setddlIchiGohanteiKekka
     * @param ddlIchiGohanteiKekka ddlIchiGohanteiKekka
     */
    @JsonProperty("ddlIchiGohanteiKekka")
    public void setDdlIchiGohanteiKekka(DropDownList ddlIchiGohanteiKekka) {
        this.ddlIchiGohanteiKekka = ddlIchiGohanteiKekka;
    }

    // </editor-fold>
}
