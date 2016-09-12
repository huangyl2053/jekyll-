package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Yokaigoninteiimagekanri のクラスファイル 
 * 
 * @author 自動生成
 */
public class YokaigoninteiimagekanriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ImagePanel")
    private ImagePanelDiv ImagePanel;
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    private NinteiShinseishaKihonInfoDiv ccdNinteiShinseishaKihonInfo;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnNinteichosaRirekiNo")
    private RString hdnNinteichosaRirekiNo;
    @JsonProperty("hdnGaikyoChosaTextImageKubun")
    private RString hdnGaikyoChosaTextImageKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getImagePanel
     * @return ImagePanel
     */
    @JsonProperty("ImagePanel")
    public ImagePanelDiv getImagePanel() {
        return ImagePanel;
    }

    /*
     * setImagePanel
     * @param ImagePanel ImagePanel
     */
    @JsonProperty("ImagePanel")
    public void setImagePanel(ImagePanelDiv ImagePanel) {
        this.ImagePanel = ImagePanel;
    }

    /*
     * getccdNinteiShinseishaKihonInfo
     * @return ccdNinteiShinseishaKihonInfo
     */
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return ccdNinteiShinseishaKihonInfo;
    }

    /*
     * gethdnShinseishoKanriNo
     * @return hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    /*
     * sethdnShinseishoKanriNo
     * @param hdnShinseishoKanriNo hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo = hdnShinseishoKanriNo;
    }

    /*
     * gethdnNinteichosaRirekiNo
     * @return hdnNinteichosaRirekiNo
     */
    @JsonProperty("hdnNinteichosaRirekiNo")
    public RString getHdnNinteichosaRirekiNo() {
        return hdnNinteichosaRirekiNo;
    }

    /*
     * sethdnNinteichosaRirekiNo
     * @param hdnNinteichosaRirekiNo hdnNinteichosaRirekiNo
     */
    @JsonProperty("hdnNinteichosaRirekiNo")
    public void setHdnNinteichosaRirekiNo(RString hdnNinteichosaRirekiNo) {
        this.hdnNinteichosaRirekiNo = hdnNinteichosaRirekiNo;
    }

    /*
     * gethdnGaikyoChosaTextImageKubun
     * @return hdnGaikyoChosaTextImageKubun
     */
    @JsonProperty("hdnGaikyoChosaTextImageKubun")
    public RString getHdnGaikyoChosaTextImageKubun() {
        return hdnGaikyoChosaTextImageKubun;
    }

    /*
     * sethdnGaikyoChosaTextImageKubun
     * @param hdnGaikyoChosaTextImageKubun hdnGaikyoChosaTextImageKubun
     */
    @JsonProperty("hdnGaikyoChosaTextImageKubun")
    public void setHdnGaikyoChosaTextImageKubun(RString hdnGaikyoChosaTextImageKubun) {
        this.hdnGaikyoChosaTextImageKubun = hdnGaikyoChosaTextImageKubun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getImagePanel().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getImagePanel().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public ButtonDialog getBtnGaikyoTokuki() {
        return this.getImagePanel().getBtnGaikyoTokuki();
    }

    @JsonIgnore
    public void  setBtnGaikyoTokuki(ButtonDialog btnGaikyoTokuki) {
        this.getImagePanel().setBtnGaikyoTokuki(btnGaikyoTokuki);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosahyoTokuki() {
        return this.getImagePanel().getBtnChosahyoTokuki();
    }

    @JsonIgnore
    public void  setBtnChosahyoTokuki(ButtonDialog btnChosahyoTokuki) {
        this.getImagePanel().setBtnChosahyoTokuki(btnChosahyoTokuki);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosahyoGaikyo() {
        return this.getImagePanel().getBtnChosahyoGaikyo();
    }

    @JsonIgnore
    public void  setBtnChosahyoGaikyo(ButtonDialog btnChosahyoGaikyo) {
        this.getImagePanel().setBtnChosahyoGaikyo(btnChosahyoGaikyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnIkensho() {
        return this.getImagePanel().getBtnIkensho();
    }

    @JsonIgnore
    public void  setBtnIkensho(ButtonDialog btnIkensho) {
        this.getImagePanel().setBtnIkensho(btnIkensho);
    }

    @JsonIgnore
    public ButtonDialog getBtnSonota() {
        return this.getImagePanel().getBtnSonota();
    }

    @JsonIgnore
    public void  setBtnSonota(ButtonDialog btnSonota) {
        this.getImagePanel().setBtnSonota(btnSonota);
    }

    @JsonIgnore
    public TextBoxDate getTxtJuryoYMD() {
        return this.getImagePanel().getTxtJuryoYMD();
    }

    @JsonIgnore
    public void  setTxtJuryoYMD(TextBoxDate txtJuryoYMD) {
        this.getImagePanel().setTxtJuryoYMD(txtJuryoYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtJishiYMD() {
        return this.getImagePanel().getTxtJishiYMD();
    }

    @JsonIgnore
    public void  setTxtJishiYMD(TextBoxDate txtJishiYMD) {
        this.getImagePanel().setTxtJishiYMD(txtJishiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtReadYMD() {
        return this.getImagePanel().getTxtReadYMD();
    }

    @JsonIgnore
    public void  setTxtReadYMD(TextBoxDate txtReadYMD) {
        this.getImagePanel().setTxtReadYMD(txtReadYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinyuYMD() {
        return this.getImagePanel().getTxtKinyuYMD();
    }

    @JsonIgnore
    public void  setTxtKinyuYMD(TextBoxDate txtKinyuYMD) {
        this.getImagePanel().setTxtKinyuYMD(txtKinyuYMD);
    }

    @JsonIgnore
    public RadioButton getRadSonota() {
        return this.getImagePanel().getRadSonota();
    }

    @JsonIgnore
    public void  setRadSonota(RadioButton radSonota) {
        this.getImagePanel().setRadSonota(radSonota);
    }

    // </editor-fold>
}
