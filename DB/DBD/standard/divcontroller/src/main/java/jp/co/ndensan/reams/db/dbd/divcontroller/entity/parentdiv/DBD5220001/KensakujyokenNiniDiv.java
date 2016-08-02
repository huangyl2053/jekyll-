package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakujyokenNini のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakujyokenNiniDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtMikomiDate")
    private TextBoxDateRange txtMikomiDate;
    @JsonProperty("ddlEnkiRiyu")
    private DropDownList ddlEnkiRiyu;
    @JsonProperty("spSpace1")
    private Space spSpace1;
    @JsonProperty("spSpace2")
    private Space spSpace2;
    @JsonProperty("cblNinteiChosa")
    private CheckBoxList cblNinteiChosa;
    @JsonProperty("cblIkenshoJyuryo")
    private CheckBoxList cblIkenshoJyuryo;
    @JsonProperty("cblIchijiHantei")
    private CheckBoxList cblIchijiHantei;
    @JsonProperty("cblShinsakaiWaritsuke")
    private CheckBoxList cblShinsakaiWaritsuke;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtMikomiDate
     * @return txtMikomiDate
     */
    @JsonProperty("txtMikomiDate")
    public TextBoxDateRange getTxtMikomiDate() {
        return txtMikomiDate;
    }

    /*
     * settxtMikomiDate
     * @param txtMikomiDate txtMikomiDate
     */
    @JsonProperty("txtMikomiDate")
    public void setTxtMikomiDate(TextBoxDateRange txtMikomiDate) {
        this.txtMikomiDate = txtMikomiDate;
    }

    /*
     * getddlEnkiRiyu
     * @return ddlEnkiRiyu
     */
    @JsonProperty("ddlEnkiRiyu")
    public DropDownList getDdlEnkiRiyu() {
        return ddlEnkiRiyu;
    }

    /*
     * setddlEnkiRiyu
     * @param ddlEnkiRiyu ddlEnkiRiyu
     */
    @JsonProperty("ddlEnkiRiyu")
    public void setDdlEnkiRiyu(DropDownList ddlEnkiRiyu) {
        this.ddlEnkiRiyu = ddlEnkiRiyu;
    }

    /*
     * getspSpace1
     * @return spSpace1
     */
    @JsonProperty("spSpace1")
    public Space getSpSpace1() {
        return spSpace1;
    }

    /*
     * setspSpace1
     * @param spSpace1 spSpace1
     */
    @JsonProperty("spSpace1")
    public void setSpSpace1(Space spSpace1) {
        this.spSpace1 = spSpace1;
    }

    /*
     * getspSpace2
     * @return spSpace2
     */
    @JsonProperty("spSpace2")
    public Space getSpSpace2() {
        return spSpace2;
    }

    /*
     * setspSpace2
     * @param spSpace2 spSpace2
     */
    @JsonProperty("spSpace2")
    public void setSpSpace2(Space spSpace2) {
        this.spSpace2 = spSpace2;
    }

    /*
     * getcblNinteiChosa
     * @return cblNinteiChosa
     */
    @JsonProperty("cblNinteiChosa")
    public CheckBoxList getCblNinteiChosa() {
        return cblNinteiChosa;
    }

    /*
     * setcblNinteiChosa
     * @param cblNinteiChosa cblNinteiChosa
     */
    @JsonProperty("cblNinteiChosa")
    public void setCblNinteiChosa(CheckBoxList cblNinteiChosa) {
        this.cblNinteiChosa = cblNinteiChosa;
    }

    /*
     * getcblIkenshoJyuryo
     * @return cblIkenshoJyuryo
     */
    @JsonProperty("cblIkenshoJyuryo")
    public CheckBoxList getCblIkenshoJyuryo() {
        return cblIkenshoJyuryo;
    }

    /*
     * setcblIkenshoJyuryo
     * @param cblIkenshoJyuryo cblIkenshoJyuryo
     */
    @JsonProperty("cblIkenshoJyuryo")
    public void setCblIkenshoJyuryo(CheckBoxList cblIkenshoJyuryo) {
        this.cblIkenshoJyuryo = cblIkenshoJyuryo;
    }

    /*
     * getcblIchijiHantei
     * @return cblIchijiHantei
     */
    @JsonProperty("cblIchijiHantei")
    public CheckBoxList getCblIchijiHantei() {
        return cblIchijiHantei;
    }

    /*
     * setcblIchijiHantei
     * @param cblIchijiHantei cblIchijiHantei
     */
    @JsonProperty("cblIchijiHantei")
    public void setCblIchijiHantei(CheckBoxList cblIchijiHantei) {
        this.cblIchijiHantei = cblIchijiHantei;
    }

    /*
     * getcblShinsakaiWaritsuke
     * @return cblShinsakaiWaritsuke
     */
    @JsonProperty("cblShinsakaiWaritsuke")
    public CheckBoxList getCblShinsakaiWaritsuke() {
        return cblShinsakaiWaritsuke;
    }

    /*
     * setcblShinsakaiWaritsuke
     * @param cblShinsakaiWaritsuke cblShinsakaiWaritsuke
     */
    @JsonProperty("cblShinsakaiWaritsuke")
    public void setCblShinsakaiWaritsuke(CheckBoxList cblShinsakaiWaritsuke) {
        this.cblShinsakaiWaritsuke = cblShinsakaiWaritsuke;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}
