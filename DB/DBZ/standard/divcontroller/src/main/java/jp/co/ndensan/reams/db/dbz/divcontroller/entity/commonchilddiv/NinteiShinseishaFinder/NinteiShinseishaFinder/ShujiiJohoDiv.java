package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShujiiJoho のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class ShujiiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShujiiIryokikan")
    private TextBoxDomainCode txtShujiiIryokikan;
    @JsonProperty("btnShujiiIryokikanGuide")
    private ButtonDialog btnShujiiIryokikanGuide;
    @JsonProperty("txtShujiiIryokikanName")
    private TextBox txtShujiiIryokikanName;
    @JsonProperty("txtShujiiShimei")
    private TextBoxDomainCode txtShujiiShimei;
    @JsonProperty("btnShujiiGuide")
    private ButtonDialog btnShujiiGuide;
    @JsonProperty("txtShujiiName")
    private TextBox txtShujiiName;
    @JsonProperty("ddlShujiIkubun")
    private DropDownList ddlShujiIkubun;
    @JsonProperty("txtIkenshoKinyuDateRange")
    private TextBoxDateRange txtIkenshoKinyuDateRange;
    @JsonProperty("ddlShujiJohoNetakirido")
    private DropDownList ddlShujiJohoNetakirido;
    @JsonProperty("ddlShujiJohoNinchido")
    private DropDownList ddlShujiJohoNinchido;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShujiiIryokikan
     * @return txtShujiiIryokikan
     */
    @JsonProperty("txtShujiiIryokikan")
    public TextBoxDomainCode getTxtShujiiIryokikan() {
        return txtShujiiIryokikan;
    }

    /*
     * settxtShujiiIryokikan
     * @param txtShujiiIryokikan txtShujiiIryokikan
     */
    @JsonProperty("txtShujiiIryokikan")
    public void setTxtShujiiIryokikan(TextBoxDomainCode txtShujiiIryokikan) {
        this.txtShujiiIryokikan = txtShujiiIryokikan;
    }

    /*
     * getbtnShujiiIryokikanGuide
     * @return btnShujiiIryokikanGuide
     */
    @JsonProperty("btnShujiiIryokikanGuide")
    public ButtonDialog getBtnShujiiIryokikanGuide() {
        return btnShujiiIryokikanGuide;
    }

    /*
     * setbtnShujiiIryokikanGuide
     * @param btnShujiiIryokikanGuide btnShujiiIryokikanGuide
     */
    @JsonProperty("btnShujiiIryokikanGuide")
    public void setBtnShujiiIryokikanGuide(ButtonDialog btnShujiiIryokikanGuide) {
        this.btnShujiiIryokikanGuide = btnShujiiIryokikanGuide;
    }

    /*
     * gettxtShujiiIryokikanName
     * @return txtShujiiIryokikanName
     */
    @JsonProperty("txtShujiiIryokikanName")
    public TextBox getTxtShujiiIryokikanName() {
        return txtShujiiIryokikanName;
    }

    /*
     * settxtShujiiIryokikanName
     * @param txtShujiiIryokikanName txtShujiiIryokikanName
     */
    @JsonProperty("txtShujiiIryokikanName")
    public void setTxtShujiiIryokikanName(TextBox txtShujiiIryokikanName) {
        this.txtShujiiIryokikanName = txtShujiiIryokikanName;
    }

    /*
     * gettxtShujiiShimei
     * @return txtShujiiShimei
     */
    @JsonProperty("txtShujiiShimei")
    public TextBoxDomainCode getTxtShujiiShimei() {
        return txtShujiiShimei;
    }

    /*
     * settxtShujiiShimei
     * @param txtShujiiShimei txtShujiiShimei
     */
    @JsonProperty("txtShujiiShimei")
    public void setTxtShujiiShimei(TextBoxDomainCode txtShujiiShimei) {
        this.txtShujiiShimei = txtShujiiShimei;
    }

    /*
     * getbtnShujiiGuide
     * @return btnShujiiGuide
     */
    @JsonProperty("btnShujiiGuide")
    public ButtonDialog getBtnShujiiGuide() {
        return btnShujiiGuide;
    }

    /*
     * setbtnShujiiGuide
     * @param btnShujiiGuide btnShujiiGuide
     */
    @JsonProperty("btnShujiiGuide")
    public void setBtnShujiiGuide(ButtonDialog btnShujiiGuide) {
        this.btnShujiiGuide = btnShujiiGuide;
    }

    /*
     * gettxtShujiiName
     * @return txtShujiiName
     */
    @JsonProperty("txtShujiiName")
    public TextBox getTxtShujiiName() {
        return txtShujiiName;
    }

    /*
     * settxtShujiiName
     * @param txtShujiiName txtShujiiName
     */
    @JsonProperty("txtShujiiName")
    public void setTxtShujiiName(TextBox txtShujiiName) {
        this.txtShujiiName = txtShujiiName;
    }

    /*
     * getddlShujiIkubun
     * @return ddlShujiIkubun
     */
    @JsonProperty("ddlShujiIkubun")
    public DropDownList getDdlShujiIkubun() {
        return ddlShujiIkubun;
    }

    /*
     * setddlShujiIkubun
     * @param ddlShujiIkubun ddlShujiIkubun
     */
    @JsonProperty("ddlShujiIkubun")
    public void setDdlShujiIkubun(DropDownList ddlShujiIkubun) {
        this.ddlShujiIkubun = ddlShujiIkubun;
    }

    /*
     * gettxtIkenshoKinyuDateRange
     * @return txtIkenshoKinyuDateRange
     */
    @JsonProperty("txtIkenshoKinyuDateRange")
    public TextBoxDateRange getTxtIkenshoKinyuDateRange() {
        return txtIkenshoKinyuDateRange;
    }

    /*
     * settxtIkenshoKinyuDateRange
     * @param txtIkenshoKinyuDateRange txtIkenshoKinyuDateRange
     */
    @JsonProperty("txtIkenshoKinyuDateRange")
    public void setTxtIkenshoKinyuDateRange(TextBoxDateRange txtIkenshoKinyuDateRange) {
        this.txtIkenshoKinyuDateRange = txtIkenshoKinyuDateRange;
    }

    /*
     * getddlShujiJohoNetakirido
     * @return ddlShujiJohoNetakirido
     */
    @JsonProperty("ddlShujiJohoNetakirido")
    public DropDownList getDdlShujiJohoNetakirido() {
        return ddlShujiJohoNetakirido;
    }

    /*
     * setddlShujiJohoNetakirido
     * @param ddlShujiJohoNetakirido ddlShujiJohoNetakirido
     */
    @JsonProperty("ddlShujiJohoNetakirido")
    public void setDdlShujiJohoNetakirido(DropDownList ddlShujiJohoNetakirido) {
        this.ddlShujiJohoNetakirido = ddlShujiJohoNetakirido;
    }

    /*
     * getddlShujiJohoNinchido
     * @return ddlShujiJohoNinchido
     */
    @JsonProperty("ddlShujiJohoNinchido")
    public DropDownList getDdlShujiJohoNinchido() {
        return ddlShujiJohoNinchido;
    }

    /*
     * setddlShujiJohoNinchido
     * @param ddlShujiJohoNinchido ddlShujiJohoNinchido
     */
    @JsonProperty("ddlShujiJohoNinchido")
    public void setDdlShujiJohoNinchido(DropDownList ddlShujiJohoNinchido) {
        this.ddlShujiJohoNinchido = ddlShujiJohoNinchido;
    }

    // </editor-fold>
}
