package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaJokyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoNinteiShinsakai のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoNinteiShinsakaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiShiryoSakuseiDate")
    private TextBoxDate txtShinsakaiShiryoSakuseiDate;
    @JsonProperty("txtShinsakaiKaisaiYoteiDate")
    private TextBoxDate txtShinsakaiKaisaiYoteiDate;
    @JsonProperty("txtNijiHanteiDate")
    private TextBoxDate txtNijiHanteiDate;
    @JsonProperty("ddlNijiHanteiKekka")
    private DropDownList ddlNijiHanteiKekka;
    @JsonProperty("txtNijiHanteiYukoKikan")
    private TextBox txtNijiHanteiYukoKikan;
    @JsonProperty("txtNinteiYukoKikanFrom")
    private TextBoxFlexibleDate txtNinteiYukoKikanFrom;
    @JsonProperty("txtNinteiYukoKikanTo")
    private TextBoxFlexibleDate txtNinteiYukoKikanTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiShiryoSakuseiDate
     * @return txtShinsakaiShiryoSakuseiDate
     */
    @JsonProperty("txtShinsakaiShiryoSakuseiDate")
    public TextBoxDate getTxtShinsakaiShiryoSakuseiDate() {
        return txtShinsakaiShiryoSakuseiDate;
    }

    /*
     * settxtShinsakaiShiryoSakuseiDate
     * @param txtShinsakaiShiryoSakuseiDate txtShinsakaiShiryoSakuseiDate
     */
    @JsonProperty("txtShinsakaiShiryoSakuseiDate")
    public void setTxtShinsakaiShiryoSakuseiDate(TextBoxDate txtShinsakaiShiryoSakuseiDate) {
        this.txtShinsakaiShiryoSakuseiDate = txtShinsakaiShiryoSakuseiDate;
    }

    /*
     * gettxtShinsakaiKaisaiYoteiDate
     * @return txtShinsakaiKaisaiYoteiDate
     */
    @JsonProperty("txtShinsakaiKaisaiYoteiDate")
    public TextBoxDate getTxtShinsakaiKaisaiYoteiDate() {
        return txtShinsakaiKaisaiYoteiDate;
    }

    /*
     * settxtShinsakaiKaisaiYoteiDate
     * @param txtShinsakaiKaisaiYoteiDate txtShinsakaiKaisaiYoteiDate
     */
    @JsonProperty("txtShinsakaiKaisaiYoteiDate")
    public void setTxtShinsakaiKaisaiYoteiDate(TextBoxDate txtShinsakaiKaisaiYoteiDate) {
        this.txtShinsakaiKaisaiYoteiDate = txtShinsakaiKaisaiYoteiDate;
    }

    /*
     * gettxtNijiHanteiDate
     * @return txtNijiHanteiDate
     */
    @JsonProperty("txtNijiHanteiDate")
    public TextBoxDate getTxtNijiHanteiDate() {
        return txtNijiHanteiDate;
    }

    /*
     * settxtNijiHanteiDate
     * @param txtNijiHanteiDate txtNijiHanteiDate
     */
    @JsonProperty("txtNijiHanteiDate")
    public void setTxtNijiHanteiDate(TextBoxDate txtNijiHanteiDate) {
        this.txtNijiHanteiDate = txtNijiHanteiDate;
    }

    /*
     * getddlNijiHanteiKekka
     * @return ddlNijiHanteiKekka
     */
    @JsonProperty("ddlNijiHanteiKekka")
    public DropDownList getDdlNijiHanteiKekka() {
        return ddlNijiHanteiKekka;
    }

    /*
     * setddlNijiHanteiKekka
     * @param ddlNijiHanteiKekka ddlNijiHanteiKekka
     */
    @JsonProperty("ddlNijiHanteiKekka")
    public void setDdlNijiHanteiKekka(DropDownList ddlNijiHanteiKekka) {
        this.ddlNijiHanteiKekka = ddlNijiHanteiKekka;
    }

    /*
     * gettxtNijiHanteiYukoKikan
     * @return txtNijiHanteiYukoKikan
     */
    @JsonProperty("txtNijiHanteiYukoKikan")
    public TextBox getTxtNijiHanteiYukoKikan() {
        return txtNijiHanteiYukoKikan;
    }

    /*
     * settxtNijiHanteiYukoKikan
     * @param txtNijiHanteiYukoKikan txtNijiHanteiYukoKikan
     */
    @JsonProperty("txtNijiHanteiYukoKikan")
    public void setTxtNijiHanteiYukoKikan(TextBox txtNijiHanteiYukoKikan) {
        this.txtNijiHanteiYukoKikan = txtNijiHanteiYukoKikan;
    }

    /*
     * gettxtNinteiYukoKikanFrom
     * @return txtNinteiYukoKikanFrom
     */
    @JsonProperty("txtNinteiYukoKikanFrom")
    public TextBoxFlexibleDate getTxtNinteiYukoKikanFrom() {
        return txtNinteiYukoKikanFrom;
    }

    /*
     * settxtNinteiYukoKikanFrom
     * @param txtNinteiYukoKikanFrom txtNinteiYukoKikanFrom
     */
    @JsonProperty("txtNinteiYukoKikanFrom")
    public void setTxtNinteiYukoKikanFrom(TextBoxFlexibleDate txtNinteiYukoKikanFrom) {
        this.txtNinteiYukoKikanFrom = txtNinteiYukoKikanFrom;
    }

    /*
     * gettxtNinteiYukoKikanTo
     * @return txtNinteiYukoKikanTo
     */
    @JsonProperty("txtNinteiYukoKikanTo")
    public TextBoxFlexibleDate getTxtNinteiYukoKikanTo() {
        return txtNinteiYukoKikanTo;
    }

    /*
     * settxtNinteiYukoKikanTo
     * @param txtNinteiYukoKikanTo txtNinteiYukoKikanTo
     */
    @JsonProperty("txtNinteiYukoKikanTo")
    public void setTxtNinteiYukoKikanTo(TextBoxFlexibleDate txtNinteiYukoKikanTo) {
        this.txtNinteiYukoKikanTo = txtNinteiYukoKikanTo;
    }

    // </editor-fold>
}
