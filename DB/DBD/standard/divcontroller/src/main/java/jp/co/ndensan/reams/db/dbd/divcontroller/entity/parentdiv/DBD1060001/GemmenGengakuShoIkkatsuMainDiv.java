package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1060001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * GemmenGengakuShoIkkatsuMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class GemmenGengakuShoIkkatsuMainDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SakuseiTaisho")
    private SakuseiTaishoDiv SakuseiTaisho;
    @JsonProperty("FutanGendogaku")
    private FutanGendogakuDiv FutanGendogaku;
    @JsonProperty("ShafukuKeigen")
    private ShafukuKeigenDiv ShafukuKeigen;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSakuseiTaisho
     * @return SakuseiTaisho
     */
    @JsonProperty("SakuseiTaisho")
    public SakuseiTaishoDiv getSakuseiTaisho() {
        return SakuseiTaisho;
    }

    /*
     * setSakuseiTaisho
     * @param SakuseiTaisho SakuseiTaisho
     */
    @JsonProperty("SakuseiTaisho")
    public void setSakuseiTaisho(SakuseiTaishoDiv SakuseiTaisho) {
        this.SakuseiTaisho = SakuseiTaisho;
    }

    /*
     * getFutanGendogaku
     * @return FutanGendogaku
     */
    @JsonProperty("FutanGendogaku")
    public FutanGendogakuDiv getFutanGendogaku() {
        return FutanGendogaku;
    }

    /*
     * setFutanGendogaku
     * @param FutanGendogaku FutanGendogaku
     */
    @JsonProperty("FutanGendogaku")
    public void setFutanGendogaku(FutanGendogakuDiv FutanGendogaku) {
        this.FutanGendogaku = FutanGendogaku;
    }

    /*
     * getShafukuKeigen
     * @return ShafukuKeigen
     */
    @JsonProperty("ShafukuKeigen")
    public ShafukuKeigenDiv getShafukuKeigen() {
        return ShafukuKeigen;
    }

    /*
     * setShafukuKeigen
     * @param ShafukuKeigen ShafukuKeigen
     */
    @JsonProperty("ShafukuKeigen")
    public void setShafukuKeigen(ShafukuKeigenDiv ShafukuKeigen) {
        this.ShafukuKeigen = ShafukuKeigen;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlGemmenGengakuShurui() {
        return this.getSakuseiTaisho().getDdlGemmenGengakuShurui();
    }

    @JsonIgnore
    public void  setDdlGemmenGengakuShurui(DropDownList ddlGemmenGengakuShurui) {
        this.getSakuseiTaisho().setDdlGemmenGengakuShurui(ddlGemmenGengakuShurui);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendogakuNinteishoKofuYmd() {
        return this.getFutanGendogaku().getFutanGendogakuNinteisho().getTxtFutanGendogakuNinteishoKofuYmd();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteishoKofuYmd(TextBoxFlexibleDate txtFutanGendogakuNinteishoKofuYmd) {
        this.getFutanGendogaku().getFutanGendogakuNinteisho().setTxtFutanGendogakuNinteishoKofuYmd(txtFutanGendogakuNinteishoKofuYmd);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdFutanGendogakuNinteishoBunshoNo() {
        return this.getFutanGendogaku().getFutanGendogakuNinteisho().getCcdFutanGendogakuNinteishoBunshoNo();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendogakuKetteiTsuchishoHakkoYmd() {
        return this.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().getTxtFutanGendogakuKetteiTsuchishoHakkoYmd();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuKetteiTsuchishoHakkoYmd(TextBoxFlexibleDate txtFutanGendogakuKetteiTsuchishoHakkoYmd) {
        this.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().setTxtFutanGendogakuKetteiTsuchishoHakkoYmd(txtFutanGendogakuKetteiTsuchishoHakkoYmd);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdFutanGendogakuKetteiTsuchishoBunshoNo() {
        return this.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().getCcdFutanGendogakuKetteiTsuchishoBunshoNo();
    }

    @JsonIgnore
    public DropDownList getDdlFutanGenogakuAtenaSealSaiyusenJusho() {
        return this.getFutanGendogaku().getFutanGendogakuAtenaSeal().getDdlFutanGenogakuAtenaSealSaiyusenJusho();
    }

    @JsonIgnore
    public void  setDdlFutanGenogakuAtenaSealSaiyusenJusho(DropDownList ddlFutanGenogakuAtenaSealSaiyusenJusho) {
        this.getFutanGendogaku().getFutanGendogakuAtenaSeal().setDdlFutanGenogakuAtenaSealSaiyusenJusho(ddlFutanGenogakuAtenaSealSaiyusenJusho);
    }

    @JsonIgnore
    public DropDownList getDdlFutanGendogakuAtenaSealKeisho() {
        return this.getFutanGendogaku().getFutanGendogakuAtenaSeal().getDdlFutanGendogakuAtenaSealKeisho();
    }

    @JsonIgnore
    public void  setDdlFutanGendogakuAtenaSealKeisho(DropDownList ddlFutanGendogakuAtenaSealKeisho) {
        this.getFutanGendogaku().getFutanGendogakuAtenaSeal().setDdlFutanGendogakuAtenaSealKeisho(ddlFutanGendogakuAtenaSealKeisho);
    }

    @JsonIgnore
    public RadioButton getDdlFutanGendogakuAtenaSealHihoNoHyoji() {
        return this.getFutanGendogaku().getFutanGendogakuAtenaSeal().getDdlFutanGendogakuAtenaSealHihoNoHyoji();
    }

    @JsonIgnore
    public void  setDdlFutanGendogakuAtenaSealHihoNoHyoji(RadioButton ddlFutanGendogakuAtenaSealHihoNoHyoji) {
        this.getFutanGendogaku().getFutanGendogakuAtenaSeal().setDdlFutanGendogakuAtenaSealHihoNoHyoji(ddlFutanGendogakuAtenaSealHihoNoHyoji);
    }

    @JsonIgnore
    public Button getBtnAtena() {
        return this.getFutanGendogaku().getFutanGendogakuAtenaSeal().getBtnAtena();
    }

    @JsonIgnore
    public void  setBtnAtena(Button btnAtena) {
        this.getFutanGendogaku().getFutanGendogakuAtenaSeal().setBtnAtena(btnAtena);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendogakuAtenaSealJushoHenshuHoho() {
        return this.getFutanGendogaku().getFutanGendogakuAtenaSeal().getTxtFutanGendogakuAtenaSealJushoHenshuHoho();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuAtenaSealJushoHenshuHoho(TextBox txtFutanGendogakuAtenaSealJushoHenshuHoho) {
        this.getFutanGendogaku().getFutanGendogakuAtenaSeal().setTxtFutanGendogakuAtenaSealJushoHenshuHoho(txtFutanGendogakuAtenaSealJushoHenshuHoho);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuKeigenKakuninShoKofuYmd() {
        return this.getShafukuKeigen().getShafukuKeigenKakuninSho().getTxtShafukuKeigenKakuninShoKofuYmd();
    }

    @JsonIgnore
    public void  setTxtShafukuKeigenKakuninShoKofuYmd(TextBoxFlexibleDate txtShafukuKeigenKakuninShoKofuYmd) {
        this.getShafukuKeigen().getShafukuKeigenKakuninSho().setTxtShafukuKeigenKakuninShoKofuYmd(txtShafukuKeigenKakuninShoKofuYmd);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdShafukuKeigenKakuninShoBunshoNo() {
        return this.getShafukuKeigen().getShafukuKeigenKakuninSho().getCcdShafukuKeigenKakuninShoBunshoNo();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuKeigenKetteiTsuchishoHakkoYmd() {
        return this.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().getTxtShafukuKeigenKetteiTsuchishoHakkoYmd();
    }

    @JsonIgnore
    public void  setTxtShafukuKeigenKetteiTsuchishoHakkoYmd(TextBoxFlexibleDate txtShafukuKeigenKetteiTsuchishoHakkoYmd) {
        this.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().setTxtShafukuKeigenKetteiTsuchishoHakkoYmd(txtShafukuKeigenKetteiTsuchishoHakkoYmd);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdShafukuKeigenKetteiTsuchishoBunshoNo() {
        return this.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().getCcdShafukuKeigenKetteiTsuchishoBunshoNo();
    }

    // </editor-fold>
}
