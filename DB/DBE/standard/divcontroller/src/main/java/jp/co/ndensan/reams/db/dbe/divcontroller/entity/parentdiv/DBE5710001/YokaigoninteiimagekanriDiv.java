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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-06_05-07-20">
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
    @JsonProperty("hdnHihokenshaNo")
    private RString hdnHihokenshaNo;
    @JsonProperty("hdnShokisaiHokenshaNo")
    private RString hdnShokisaiHokenshaNo;
    @JsonProperty("hdnImageLocalCopyPath")
    private RString hdnImageLocalCopyPath;
    @JsonProperty("hdnTokkiShuseiOperation")
    private RString hdnTokkiShuseiOperation;

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
     * gethdnHihokenshaNo
     * @return hdnHihokenshaNo
     */
    @JsonProperty("hdnHihokenshaNo")
    public RString getHdnHihokenshaNo() {
        return hdnHihokenshaNo;
    }

    /*
     * sethdnHihokenshaNo
     * @param hdnHihokenshaNo hdnHihokenshaNo
     */
    @JsonProperty("hdnHihokenshaNo")
    public void setHdnHihokenshaNo(RString hdnHihokenshaNo) {
        this.hdnHihokenshaNo = hdnHihokenshaNo;
    }

    /*
     * gethdnShokisaiHokenshaNo
     * @return hdnShokisaiHokenshaNo
     */
    @JsonProperty("hdnShokisaiHokenshaNo")
    public RString getHdnShokisaiHokenshaNo() {
        return hdnShokisaiHokenshaNo;
    }

    /*
     * sethdnShokisaiHokenshaNo
     * @param hdnShokisaiHokenshaNo hdnShokisaiHokenshaNo
     */
    @JsonProperty("hdnShokisaiHokenshaNo")
    public void setHdnShokisaiHokenshaNo(RString hdnShokisaiHokenshaNo) {
        this.hdnShokisaiHokenshaNo = hdnShokisaiHokenshaNo;
    }

    /*
     * gethdnImageLocalCopyPath
     * @return hdnImageLocalCopyPath
     */
    @JsonProperty("hdnImageLocalCopyPath")
    public RString getHdnImageLocalCopyPath() {
        return hdnImageLocalCopyPath;
    }

    /*
     * sethdnImageLocalCopyPath
     * @param hdnImageLocalCopyPath hdnImageLocalCopyPath
     */
    @JsonProperty("hdnImageLocalCopyPath")
    public void setHdnImageLocalCopyPath(RString hdnImageLocalCopyPath) {
        this.hdnImageLocalCopyPath = hdnImageLocalCopyPath;
    }

    /*
     * gethdnTokkiShuseiOperation
     * @return hdnTokkiShuseiOperation
     */
    @JsonProperty("hdnTokkiShuseiOperation")
    public RString getHdnTokkiShuseiOperation() {
        return hdnTokkiShuseiOperation;
    }

    /*
     * sethdnTokkiShuseiOperation
     * @param hdnTokkiShuseiOperation hdnTokkiShuseiOperation
     */
    @JsonProperty("hdnTokkiShuseiOperation")
    public void setHdnTokkiShuseiOperation(RString hdnTokkiShuseiOperation) {
        this.hdnTokkiShuseiOperation = hdnTokkiShuseiOperation;
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
    public ButtonDialog getBtnGaikyoChosa() {
        return this.getImagePanel().getBtnGaikyoChosa();
    }

    @JsonIgnore
    public void  setBtnGaikyoChosa(ButtonDialog btnGaikyoChosa) {
        this.getImagePanel().setBtnGaikyoChosa(btnGaikyoChosa);
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
    public ButtonDialog getBtnTokkiRembanShusei() {
        return this.getImagePanel().getBtnTokkiRembanShusei();
    }

    @JsonIgnore
    public void  setBtnTokkiRembanShusei(ButtonDialog btnTokkiRembanShusei) {
        this.getImagePanel().setBtnTokkiRembanShusei(btnTokkiRembanShusei);
    }

    @JsonIgnore
    public ButtonDialog getBtnGaikyoTokki() {
        return this.getImagePanel().getBtnGaikyoTokki();
    }

    @JsonIgnore
    public void  setBtnGaikyoTokki(ButtonDialog btnGaikyoTokki) {
        this.getImagePanel().setBtnGaikyoTokki(btnGaikyoTokki);
    }

    @JsonIgnore
    public ButtonDialog getBtnIkenshoTeikei() {
        return this.getImagePanel().getBtnIkenshoTeikei();
    }

    @JsonIgnore
    public void  setBtnIkenshoTeikei(ButtonDialog btnIkenshoTeikei) {
        this.getImagePanel().setBtnIkenshoTeikei(btnIkenshoTeikei);
    }

    @JsonIgnore
    public ButtonDialog getBtnIkenshoTeikeigai() {
        return this.getImagePanel().getBtnIkenshoTeikeigai();
    }

    @JsonIgnore
    public void  setBtnIkenshoTeikeigai(ButtonDialog btnIkenshoTeikeigai) {
        this.getImagePanel().setBtnIkenshoTeikeigai(btnIkenshoTeikeigai);
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
