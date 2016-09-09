package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HenkoInput のクラスファイル
 *
 * @reamsid_L DBA-1300-050 chengsanyuan
 */
public class HenkoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHenkoDate")
    private TextBoxFlexibleDate txtHenkoDate;
    @JsonProperty("txtHenkoTodokedeDate")
    private TextBoxFlexibleDate txtHenkoTodokedeDate;
    @JsonProperty("ddlHenkoJiyu")
    private DropDownList ddlHenkoJiyu;
    @JsonProperty("HenkoHokenshaJoho")
    private HenkoHokenshaJohoDiv HenkoHokenshaJoho;
    @JsonProperty("btnHenkoKakutei")
    private Button btnHenkoKakutei;
    @JsonProperty("btnHenkoTorikeshi")
    private Button btnHenkoTorikeshi;
    @JsonProperty("henkojiShichosonCode")
    private RString henkojiShichosonCode;
    @JsonProperty("henkojiHihokenshaNo")
    private RString henkojiHihokenshaNo;
    @JsonProperty("henkojiShikibetsuCode")
    private RString henkojiShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHenkoDate
     * @return txtHenkoDate
     */
    @JsonProperty("txtHenkoDate")
    public TextBoxFlexibleDate getTxtHenkoDate() {
        return txtHenkoDate;
    }

    /*
     * settxtHenkoDate
     * @param txtHenkoDate txtHenkoDate
     */
    @JsonProperty("txtHenkoDate")
    public void setTxtHenkoDate(TextBoxFlexibleDate txtHenkoDate) {
        this.txtHenkoDate = txtHenkoDate;
    }

    /*
     * gettxtHenkoTodokedeDate
     * @return txtHenkoTodokedeDate
     */
    @JsonProperty("txtHenkoTodokedeDate")
    public TextBoxFlexibleDate getTxtHenkoTodokedeDate() {
        return txtHenkoTodokedeDate;
    }

    /*
     * settxtHenkoTodokedeDate
     * @param txtHenkoTodokedeDate txtHenkoTodokedeDate
     */
    @JsonProperty("txtHenkoTodokedeDate")
    public void setTxtHenkoTodokedeDate(TextBoxFlexibleDate txtHenkoTodokedeDate) {
        this.txtHenkoTodokedeDate = txtHenkoTodokedeDate;
    }

    /*
     * getddlHenkoJiyu
     * @return ddlHenkoJiyu
     */
    @JsonProperty("ddlHenkoJiyu")
    public DropDownList getDdlHenkoJiyu() {
        return ddlHenkoJiyu;
    }

    /*
     * setddlHenkoJiyu
     * @param ddlHenkoJiyu ddlHenkoJiyu
     */
    @JsonProperty("ddlHenkoJiyu")
    public void setDdlHenkoJiyu(DropDownList ddlHenkoJiyu) {
        this.ddlHenkoJiyu = ddlHenkoJiyu;
    }

    /*
     * getHenkoHokenshaJoho
     * @return HenkoHokenshaJoho
     */
    @JsonProperty("HenkoHokenshaJoho")
    public HenkoHokenshaJohoDiv getHenkoHokenshaJoho() {
        return HenkoHokenshaJoho;
    }

    /*
     * setHenkoHokenshaJoho
     * @param HenkoHokenshaJoho HenkoHokenshaJoho
     */
    @JsonProperty("HenkoHokenshaJoho")
    public void setHenkoHokenshaJoho(HenkoHokenshaJohoDiv HenkoHokenshaJoho) {
        this.HenkoHokenshaJoho = HenkoHokenshaJoho;
    }

    /*
     * getbtnHenkoKakutei
     * @return btnHenkoKakutei
     */
    @JsonProperty("btnHenkoKakutei")
    public Button getBtnHenkoKakutei() {
        return btnHenkoKakutei;
    }

    /*
     * setbtnHenkoKakutei
     * @param btnHenkoKakutei btnHenkoKakutei
     */
    @JsonProperty("btnHenkoKakutei")
    public void setBtnHenkoKakutei(Button btnHenkoKakutei) {
        this.btnHenkoKakutei = btnHenkoKakutei;
    }

    /*
     * getbtnHenkoTorikeshi
     * @return btnHenkoTorikeshi
     */
    @JsonProperty("btnHenkoTorikeshi")
    public Button getBtnHenkoTorikeshi() {
        return btnHenkoTorikeshi;
    }

    /*
     * setbtnHenkoTorikeshi
     * @param btnHenkoTorikeshi btnHenkoTorikeshi
     */
    @JsonProperty("btnHenkoTorikeshi")
    public void setBtnHenkoTorikeshi(Button btnHenkoTorikeshi) {
        this.btnHenkoTorikeshi = btnHenkoTorikeshi;
    }

    /*
     * gethenkojiShichosonCode
     * @return henkojiShichosonCode
     */
    @JsonProperty("henkojiShichosonCode")
    public RString getHenkojiShichosonCode() {
        return henkojiShichosonCode;
    }

    /*
     * sethenkojiShichosonCode
     * @param henkojiShichosonCode henkojiShichosonCode
     */
    @JsonProperty("henkojiShichosonCode")
    public void setHenkojiShichosonCode(RString henkojiShichosonCode) {
        this.henkojiShichosonCode = henkojiShichosonCode;
    }

    /*
     * gethenkojiHihokenshaNo
     * @return henkojiHihokenshaNo
     */
    @JsonProperty("henkojiHihokenshaNo")
    public RString getHenkojiHihokenshaNo() {
        return henkojiHihokenshaNo;
    }

    /*
     * sethenkojiHihokenshaNo
     * @param henkojiHihokenshaNo henkojiHihokenshaNo
     */
    @JsonProperty("henkojiHihokenshaNo")
    public void setHenkojiHihokenshaNo(RString henkojiHihokenshaNo) {
        this.henkojiHihokenshaNo = henkojiHihokenshaNo;
    }

    /*
     * gethenkojiShikibetsuCode
     * @return henkojiShikibetsuCode
     */
    @JsonProperty("henkojiShikibetsuCode")
    public RString getHenkojiShikibetsuCode() {
        return henkojiShikibetsuCode;
    }

    /*
     * sethenkojiShikibetsuCode
     * @param henkojiShikibetsuCode henkojiShikibetsuCode
     */
    @JsonProperty("henkojiShikibetsuCode")
    public void setHenkojiShikibetsuCode(RString henkojiShikibetsuCode) {
        this.henkojiShikibetsuCode = henkojiShikibetsuCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlHenkoSochimotoHokensha() {
        return this.getHenkoHokenshaJoho().getDdlHenkoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoSochimotoHokensha(DropDownList ddlHenkoSochimotoHokensha) {
        this.getHenkoHokenshaJoho().setDdlHenkoSochimotoHokensha(ddlHenkoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoKyuHokensha() {
        return this.getHenkoHokenshaJoho().getDdlHenkoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoKyuHokensha(DropDownList ddlHenkoKyuHokensha) {
        this.getHenkoHokenshaJoho().setDdlHenkoKyuHokensha(ddlHenkoKyuHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlJuminJoho() {
        return this.getHenkoHokenshaJoho().getDdlJuminJoho();
    }

    @JsonIgnore
    public void  setDdlJuminJoho(DropDownList ddlJuminJoho) {
        this.getHenkoHokenshaJoho().setDdlJuminJoho(ddlJuminJoho);
    }

    // </editor-fold>
}
