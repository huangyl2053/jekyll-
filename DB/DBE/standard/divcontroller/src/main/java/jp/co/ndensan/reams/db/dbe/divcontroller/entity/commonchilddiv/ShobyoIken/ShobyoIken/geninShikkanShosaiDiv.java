package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * geninShikkanShosai のクラスファイル
 *
 */
public class geninShikkanShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdCodeInputGeninShikkan")
    private CodeInputDiv ccdCodeInputGeninShikkan;
    @JsonProperty("radIsShutaruGeninShikkan")
    private RadioButton radIsShutaruGeninShikkan;
    @JsonProperty("btnNo")
    private Button btnNo;
    @JsonProperty("btnOK")
    private Button btnOK;
    @JsonProperty("ShikkanCode")
    private RString ShikkanCode;
    @JsonProperty("Meisho")
    private RString Meisho;
    @JsonProperty("IsShutaru")
    private RString IsShutaru;
    @JsonProperty("Jotai")
    private RString Jotai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdCodeInputGeninShikkan
     * @return ccdCodeInputGeninShikkan
     */
    @JsonProperty("ccdCodeInputGeninShikkan")
    public ICodeInputDiv getCcdCodeInputGeninShikkan() {
        return ccdCodeInputGeninShikkan;
    }

    /*
     * getradIsShutaruGeninShikkan
     * @return radIsShutaruGeninShikkan
     */
    @JsonProperty("radIsShutaruGeninShikkan")
    public RadioButton getRadIsShutaruGeninShikkan() {
        return radIsShutaruGeninShikkan;
    }

    /*
     * setradIsShutaruGeninShikkan
     * @param radIsShutaruGeninShikkan radIsShutaruGeninShikkan
     */
    @JsonProperty("radIsShutaruGeninShikkan")
    public void setRadIsShutaruGeninShikkan(RadioButton radIsShutaruGeninShikkan) {
        this.radIsShutaruGeninShikkan = radIsShutaruGeninShikkan;
    }

    /*
     * getbtnNo
     * @return btnNo
     */
    @JsonProperty("btnNo")
    public Button getBtnNo() {
        return btnNo;
    }

    /*
     * setbtnNo
     * @param btnNo btnNo
     */
    @JsonProperty("btnNo")
    public void setBtnNo(Button btnNo) {
        this.btnNo = btnNo;
    }

    /*
     * getbtnOK
     * @return btnOK
     */
    @JsonProperty("btnOK")
    public Button getBtnOK() {
        return btnOK;
    }

    /*
     * setbtnOK
     * @param btnOK btnOK
     */
    @JsonProperty("btnOK")
    public void setBtnOK(Button btnOK) {
        this.btnOK = btnOK;
    }

    /*
     * getShikkanCode
     * @return ShikkanCode
     */
    @JsonProperty("ShikkanCode")
    public RString getShikkanCode() {
        return ShikkanCode;
    }

    /*
     * setShikkanCode
     * @param ShikkanCode ShikkanCode
     */
    @JsonProperty("ShikkanCode")
    public void setShikkanCode(RString ShikkanCode) {
        this.ShikkanCode = ShikkanCode;
    }

    /*
     * getMeisho
     * @return Meisho
     */
    @JsonProperty("Meisho")
    public RString getMeisho() {
        return Meisho;
    }

    /*
     * setMeisho
     * @param Meisho Meisho
     */
    @JsonProperty("Meisho")
    public void setMeisho(RString Meisho) {
        this.Meisho = Meisho;
    }

    /*
     * getIsShutaru
     * @return IsShutaru
     */
    @JsonProperty("IsShutaru")
    public RString getIsShutaru() {
        return IsShutaru;
    }

    /*
     * setIsShutaru
     * @param IsShutaru IsShutaru
     */
    @JsonProperty("IsShutaru")
    public void setIsShutaru(RString IsShutaru) {
        this.IsShutaru = IsShutaru;
    }

    /*
     * getJotai
     * @return Jotai
     */
    @JsonProperty("Jotai")
    public RString getJotai() {
        return Jotai;
    }

    /*
     * setJotai
     * @param Jotai Jotai
     */
    @JsonProperty("Jotai")
    public void setJotai(RString Jotai) {
        this.Jotai = Jotai;
    }

    // </editor-fold>
}
