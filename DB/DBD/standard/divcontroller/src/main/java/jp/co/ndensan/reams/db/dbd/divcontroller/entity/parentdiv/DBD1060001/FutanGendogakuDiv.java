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
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FutanGendogaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanGendogakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("FutanGendogakuChushutsuJoken")
    private FutanGendogakuChushutsuJokenDiv FutanGendogakuChushutsuJoken;
    @JsonProperty("FutanGendogakuNinteisho")
    private FutanGendogakuNinteishoDiv FutanGendogakuNinteisho;
    @JsonProperty("FutanGendogakuKetteiTsuchisho")
    private FutanGendogakuKetteiTsuchishoDiv FutanGendogakuKetteiTsuchisho;
    @JsonProperty("FutanGendogakuAtenaSeal")
    private FutanGendogakuAtenaSealDiv FutanGendogakuAtenaSeal;
    @JsonProperty("ccdFutanGendogakuShutsuryokuJun")
    private ChohyoShutsuryokujunDiv ccdFutanGendogakuShutsuryokuJun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getFutanGendogakuChushutsuJoken
     * @return FutanGendogakuChushutsuJoken
     */
    @JsonProperty("FutanGendogakuChushutsuJoken")
    public FutanGendogakuChushutsuJokenDiv getFutanGendogakuChushutsuJoken() {
        return FutanGendogakuChushutsuJoken;
    }

    /*
     * setFutanGendogakuChushutsuJoken
     * @param FutanGendogakuChushutsuJoken FutanGendogakuChushutsuJoken
     */
    @JsonProperty("FutanGendogakuChushutsuJoken")
    public void setFutanGendogakuChushutsuJoken(FutanGendogakuChushutsuJokenDiv FutanGendogakuChushutsuJoken) {
        this.FutanGendogakuChushutsuJoken = FutanGendogakuChushutsuJoken;
    }

    /*
     * getFutanGendogakuNinteisho
     * @return FutanGendogakuNinteisho
     */
    @JsonProperty("FutanGendogakuNinteisho")
    public FutanGendogakuNinteishoDiv getFutanGendogakuNinteisho() {
        return FutanGendogakuNinteisho;
    }

    /*
     * setFutanGendogakuNinteisho
     * @param FutanGendogakuNinteisho FutanGendogakuNinteisho
     */
    @JsonProperty("FutanGendogakuNinteisho")
    public void setFutanGendogakuNinteisho(FutanGendogakuNinteishoDiv FutanGendogakuNinteisho) {
        this.FutanGendogakuNinteisho = FutanGendogakuNinteisho;
    }

    /*
     * getFutanGendogakuKetteiTsuchisho
     * @return FutanGendogakuKetteiTsuchisho
     */
    @JsonProperty("FutanGendogakuKetteiTsuchisho")
    public FutanGendogakuKetteiTsuchishoDiv getFutanGendogakuKetteiTsuchisho() {
        return FutanGendogakuKetteiTsuchisho;
    }

    /*
     * setFutanGendogakuKetteiTsuchisho
     * @param FutanGendogakuKetteiTsuchisho FutanGendogakuKetteiTsuchisho
     */
    @JsonProperty("FutanGendogakuKetteiTsuchisho")
    public void setFutanGendogakuKetteiTsuchisho(FutanGendogakuKetteiTsuchishoDiv FutanGendogakuKetteiTsuchisho) {
        this.FutanGendogakuKetteiTsuchisho = FutanGendogakuKetteiTsuchisho;
    }

    /*
     * getFutanGendogakuAtenaSeal
     * @return FutanGendogakuAtenaSeal
     */
    @JsonProperty("FutanGendogakuAtenaSeal")
    public FutanGendogakuAtenaSealDiv getFutanGendogakuAtenaSeal() {
        return FutanGendogakuAtenaSeal;
    }

    /*
     * setFutanGendogakuAtenaSeal
     * @param FutanGendogakuAtenaSeal FutanGendogakuAtenaSeal
     */
    @JsonProperty("FutanGendogakuAtenaSeal")
    public void setFutanGendogakuAtenaSeal(FutanGendogakuAtenaSealDiv FutanGendogakuAtenaSeal) {
        this.FutanGendogakuAtenaSeal = FutanGendogakuAtenaSeal;
    }

    /*
     * getccdFutanGendogakuShutsuryokuJun
     * @return ccdFutanGendogakuShutsuryokuJun
     */
    @JsonProperty("ccdFutanGendogakuShutsuryokuJun")
    public IChohyoShutsuryokujunDiv getCcdFutanGendogakuShutsuryokuJun() {
        return ccdFutanGendogakuShutsuryokuJun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendogakuNinteishoKofuYmd() {
        return this.getFutanGendogakuNinteisho().getTxtFutanGendogakuNinteishoKofuYmd();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteishoKofuYmd(TextBoxFlexibleDate txtFutanGendogakuNinteishoKofuYmd) {
        this.getFutanGendogakuNinteisho().setTxtFutanGendogakuNinteishoKofuYmd(txtFutanGendogakuNinteishoKofuYmd);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdFutanGendogakuNinteishoBunshoNo() {
        return this.getFutanGendogakuNinteisho().getCcdFutanGendogakuNinteishoBunshoNo();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendogakuKetteiTsuchishoHakkoYmd() {
        return this.getFutanGendogakuKetteiTsuchisho().getTxtFutanGendogakuKetteiTsuchishoHakkoYmd();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuKetteiTsuchishoHakkoYmd(TextBoxFlexibleDate txtFutanGendogakuKetteiTsuchishoHakkoYmd) {
        this.getFutanGendogakuKetteiTsuchisho().setTxtFutanGendogakuKetteiTsuchishoHakkoYmd(txtFutanGendogakuKetteiTsuchishoHakkoYmd);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdFutanGendogakuKetteiTsuchishoBunshoNo() {
        return this.getFutanGendogakuKetteiTsuchisho().getCcdFutanGendogakuKetteiTsuchishoBunshoNo();
    }

    @JsonIgnore
    public DropDownList getDdlFutanGenogakuAtenaSealSaiyusenJusho() {
        return this.getFutanGendogakuAtenaSeal().getDdlFutanGenogakuAtenaSealSaiyusenJusho();
    }

    @JsonIgnore
    public void  setDdlFutanGenogakuAtenaSealSaiyusenJusho(DropDownList ddlFutanGenogakuAtenaSealSaiyusenJusho) {
        this.getFutanGendogakuAtenaSeal().setDdlFutanGenogakuAtenaSealSaiyusenJusho(ddlFutanGenogakuAtenaSealSaiyusenJusho);
    }

    @JsonIgnore
    public DropDownList getDdlFutanGendogakuAtenaSealKeisho() {
        return this.getFutanGendogakuAtenaSeal().getDdlFutanGendogakuAtenaSealKeisho();
    }

    @JsonIgnore
    public void  setDdlFutanGendogakuAtenaSealKeisho(DropDownList ddlFutanGendogakuAtenaSealKeisho) {
        this.getFutanGendogakuAtenaSeal().setDdlFutanGendogakuAtenaSealKeisho(ddlFutanGendogakuAtenaSealKeisho);
    }

    @JsonIgnore
    public RadioButton getDdlFutanGendogakuAtenaSealHihoNoHyoji() {
        return this.getFutanGendogakuAtenaSeal().getDdlFutanGendogakuAtenaSealHihoNoHyoji();
    }

    @JsonIgnore
    public void  setDdlFutanGendogakuAtenaSealHihoNoHyoji(RadioButton ddlFutanGendogakuAtenaSealHihoNoHyoji) {
        this.getFutanGendogakuAtenaSeal().setDdlFutanGendogakuAtenaSealHihoNoHyoji(ddlFutanGendogakuAtenaSealHihoNoHyoji);
    }

    @JsonIgnore
    public Button getBtnAtena() {
        return this.getFutanGendogakuAtenaSeal().getBtnAtena();
    }

    @JsonIgnore
    public void  setBtnAtena(Button btnAtena) {
        this.getFutanGendogakuAtenaSeal().setBtnAtena(btnAtena);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendogakuAtenaSealJushoHenshuHoho() {
        return this.getFutanGendogakuAtenaSeal().getTxtFutanGendogakuAtenaSealJushoHenshuHoho();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuAtenaSealJushoHenshuHoho(TextBox txtFutanGendogakuAtenaSealJushoHenshuHoho) {
        this.getFutanGendogakuAtenaSeal().setTxtFutanGendogakuAtenaSealJushoHenshuHoho(txtFutanGendogakuAtenaSealJushoHenshuHoho);
    }

    // </editor-fold>
}
