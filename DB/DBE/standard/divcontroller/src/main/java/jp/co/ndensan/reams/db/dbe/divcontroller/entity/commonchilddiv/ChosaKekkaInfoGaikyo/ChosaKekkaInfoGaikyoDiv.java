package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.RembanServiceJokyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ChosaKekkaInfoGaikyo のクラスファイル
 *
 * @author 自動生成
 */
public class ChosaKekkaInfoGaikyoDiv extends Panel implements IChosaKekkaInfoGaikyoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    private TextBoxDate txtNinteichosaJisshiYMD;
    @JsonProperty("txtChosaJisshiBashoMeisho")
    private TextBox txtChosaJisshiBashoMeisho;
    @JsonProperty("TokkiPanel")
    private TokkiPanelDiv TokkiPanel;
    @JsonProperty("ServiceJokyoPanel")
    private ServiceJokyoPanelDiv ServiceJokyoPanel;
    @JsonProperty("radServiceKubun")
    private RadioButton radServiceKubun;
    @JsonProperty("rdoJutakuKaishu")
    private RadioButton rdoJutakuKaishu;
    @JsonProperty("KubetsuKyufuPanel")
    private KubetsuKyufuPanelDiv KubetsuKyufuPanel;
    @JsonProperty("ZaitakuServicePanel")
    private ZaitakuServicePanelDiv ZaitakuServicePanel;
    @JsonProperty("RiyoShisetsuPanel")
    private RiyoShisetsuPanelDiv RiyoShisetsuPanel;
    @JsonProperty("txtRiyoShisetsuShimei")
    private TextBox txtRiyoShisetsuShimei;
    @JsonProperty("txtRiyoShisetsuJusho")
    private TextBox txtRiyoShisetsuJusho;
    @JsonProperty("txtTelNo")
    private TextBox txtTelNo;
    @JsonProperty("GaikyoTokkiTextPanel")
    private GaikyoTokkiTextPanelDiv GaikyoTokkiTextPanel;
    @JsonProperty("GaikyoTokkiImagePanel")
    private GaikyoTokkiImagePanelDiv GaikyoTokkiImagePanel;
    @JsonProperty("btnBack")
    private Button btnBack;
    @JsonProperty("shinseishoKanriNo")
    private RString shinseishoKanriNo;
    @JsonProperty("ninteichosaRirekiNo")
    private RString ninteichosaRirekiNo;
    @JsonProperty("gaikyoChosaTextImageKubun")
    private RString gaikyoChosaTextImageKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNinteichosaJisshiYMD
     * @return txtNinteichosaJisshiYMD
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    public TextBoxDate getTxtNinteichosaJisshiYMD() {
        return txtNinteichosaJisshiYMD;
    }

    /*
     * settxtNinteichosaJisshiYMD
     * @param txtNinteichosaJisshiYMD txtNinteichosaJisshiYMD
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    public void setTxtNinteichosaJisshiYMD(TextBoxDate txtNinteichosaJisshiYMD) {
        this.txtNinteichosaJisshiYMD = txtNinteichosaJisshiYMD;
    }

    /*
     * gettxtChosaJisshiBashoMeisho
     * @return txtChosaJisshiBashoMeisho
     */
    @JsonProperty("txtChosaJisshiBashoMeisho")
    public TextBox getTxtChosaJisshiBashoMeisho() {
        return txtChosaJisshiBashoMeisho;
    }

    /*
     * settxtChosaJisshiBashoMeisho
     * @param txtChosaJisshiBashoMeisho txtChosaJisshiBashoMeisho
     */
    @JsonProperty("txtChosaJisshiBashoMeisho")
    public void setTxtChosaJisshiBashoMeisho(TextBox txtChosaJisshiBashoMeisho) {
        this.txtChosaJisshiBashoMeisho = txtChosaJisshiBashoMeisho;
    }

    /*
     * getTokkiPanel
     * @return TokkiPanel
     */
    @JsonProperty("TokkiPanel")
    public TokkiPanelDiv getTokkiPanel() {
        return TokkiPanel;
    }

    /*
     * setTokkiPanel
     * @param TokkiPanel TokkiPanel
     */
    @JsonProperty("TokkiPanel")
    public void setTokkiPanel(TokkiPanelDiv TokkiPanel) {
        this.TokkiPanel = TokkiPanel;
    }

    /*
     * getServiceJokyoPanel
     * @return ServiceJokyoPanel
     */
    @JsonProperty("ServiceJokyoPanel")
    public ServiceJokyoPanelDiv getServiceJokyoPanel() {
        return ServiceJokyoPanel;
    }

    /*
     * setServiceJokyoPanel
     * @param ServiceJokyoPanel ServiceJokyoPanel
     */
    @JsonProperty("ServiceJokyoPanel")
    public void setServiceJokyoPanel(ServiceJokyoPanelDiv ServiceJokyoPanel) {
        this.ServiceJokyoPanel = ServiceJokyoPanel;
    }

    /*
     * getradServiceKubun
     * @return radServiceKubun
     */
    @JsonProperty("radServiceKubun")
    public RadioButton getRadServiceKubun() {
        return radServiceKubun;
    }

    /*
     * setradServiceKubun
     * @param radServiceKubun radServiceKubun
     */
    @JsonProperty("radServiceKubun")
    public void setRadServiceKubun(RadioButton radServiceKubun) {
        this.radServiceKubun = radServiceKubun;
    }

    /*
     * getrdoJutakuKaishu
     * @return rdoJutakuKaishu
     */
    @JsonProperty("rdoJutakuKaishu")
    public RadioButton getRdoJutakuKaishu() {
        return rdoJutakuKaishu;
    }

    /*
     * setrdoJutakuKaishu
     * @param rdoJutakuKaishu rdoJutakuKaishu
     */
    @JsonProperty("rdoJutakuKaishu")
    public void setRdoJutakuKaishu(RadioButton rdoJutakuKaishu) {
        this.rdoJutakuKaishu = rdoJutakuKaishu;
    }

    /*
     * getKubetsuKyufuPanel
     * @return KubetsuKyufuPanel
     */
    @JsonProperty("KubetsuKyufuPanel")
    public KubetsuKyufuPanelDiv getKubetsuKyufuPanel() {
        return KubetsuKyufuPanel;
    }

    /*
     * setKubetsuKyufuPanel
     * @param KubetsuKyufuPanel KubetsuKyufuPanel
     */
    @JsonProperty("KubetsuKyufuPanel")
    public void setKubetsuKyufuPanel(KubetsuKyufuPanelDiv KubetsuKyufuPanel) {
        this.KubetsuKyufuPanel = KubetsuKyufuPanel;
    }

    /*
     * getZaitakuServicePanel
     * @return ZaitakuServicePanel
     */
    @JsonProperty("ZaitakuServicePanel")
    public ZaitakuServicePanelDiv getZaitakuServicePanel() {
        return ZaitakuServicePanel;
    }

    /*
     * setZaitakuServicePanel
     * @param ZaitakuServicePanel ZaitakuServicePanel
     */
    @JsonProperty("ZaitakuServicePanel")
    public void setZaitakuServicePanel(ZaitakuServicePanelDiv ZaitakuServicePanel) {
        this.ZaitakuServicePanel = ZaitakuServicePanel;
    }

    /*
     * getRiyoShisetsuPanel
     * @return RiyoShisetsuPanel
     */
    @JsonProperty("RiyoShisetsuPanel")
    public RiyoShisetsuPanelDiv getRiyoShisetsuPanel() {
        return RiyoShisetsuPanel;
    }

    /*
     * setRiyoShisetsuPanel
     * @param RiyoShisetsuPanel RiyoShisetsuPanel
     */
    @JsonProperty("RiyoShisetsuPanel")
    public void setRiyoShisetsuPanel(RiyoShisetsuPanelDiv RiyoShisetsuPanel) {
        this.RiyoShisetsuPanel = RiyoShisetsuPanel;
    }

    /*
     * gettxtRiyoShisetsuShimei
     * @return txtRiyoShisetsuShimei
     */
    @JsonProperty("txtRiyoShisetsuShimei")
    public TextBox getTxtRiyoShisetsuShimei() {
        return txtRiyoShisetsuShimei;
    }

    /*
     * settxtRiyoShisetsuShimei
     * @param txtRiyoShisetsuShimei txtRiyoShisetsuShimei
     */
    @JsonProperty("txtRiyoShisetsuShimei")
    public void setTxtRiyoShisetsuShimei(TextBox txtRiyoShisetsuShimei) {
        this.txtRiyoShisetsuShimei = txtRiyoShisetsuShimei;
    }

    /*
     * gettxtRiyoShisetsuJusho
     * @return txtRiyoShisetsuJusho
     */
    @JsonProperty("txtRiyoShisetsuJusho")
    public TextBox getTxtRiyoShisetsuJusho() {
        return txtRiyoShisetsuJusho;
    }

    /*
     * settxtRiyoShisetsuJusho
     * @param txtRiyoShisetsuJusho txtRiyoShisetsuJusho
     */
    @JsonProperty("txtRiyoShisetsuJusho")
    public void setTxtRiyoShisetsuJusho(TextBox txtRiyoShisetsuJusho) {
        this.txtRiyoShisetsuJusho = txtRiyoShisetsuJusho;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBox getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBox txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * getGaikyoTokkiTextPanel
     * @return GaikyoTokkiTextPanel
     */
    @JsonProperty("GaikyoTokkiTextPanel")
    public GaikyoTokkiTextPanelDiv getGaikyoTokkiTextPanel() {
        return GaikyoTokkiTextPanel;
    }

    /*
     * setGaikyoTokkiTextPanel
     * @param GaikyoTokkiTextPanel GaikyoTokkiTextPanel
     */
    @JsonProperty("GaikyoTokkiTextPanel")
    public void setGaikyoTokkiTextPanel(GaikyoTokkiTextPanelDiv GaikyoTokkiTextPanel) {
        this.GaikyoTokkiTextPanel = GaikyoTokkiTextPanel;
    }

    /*
     * getGaikyoTokkiImagePanel
     * @return GaikyoTokkiImagePanel
     */
    @JsonProperty("GaikyoTokkiImagePanel")
    public GaikyoTokkiImagePanelDiv getGaikyoTokkiImagePanel() {
        return GaikyoTokkiImagePanel;
    }

    /*
     * setGaikyoTokkiImagePanel
     * @param GaikyoTokkiImagePanel GaikyoTokkiImagePanel
     */
    @JsonProperty("GaikyoTokkiImagePanel")
    public void setGaikyoTokkiImagePanel(GaikyoTokkiImagePanelDiv GaikyoTokkiImagePanel) {
        this.GaikyoTokkiImagePanel = GaikyoTokkiImagePanel;
    }

    /*
     * getbtnBack
     * @return btnBack
     */
    @JsonProperty("btnBack")
    public Button getBtnBack() {
        return btnBack;
    }

    /*
     * setbtnBack
     * @param btnBack btnBack
     */
    @JsonProperty("btnBack")
    public void setBtnBack(Button btnBack) {
        this.btnBack = btnBack;
    }

    /*
     * getshinseishoKanriNo
     * @return shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /*
     * setshinseishoKanriNo
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /*
     * getninteichosaRirekiNo
     * @return ninteichosaRirekiNo
     */
    @JsonProperty("ninteichosaRirekiNo")
    public RString getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /*
     * setninteichosaRirekiNo
     * @param ninteichosaRirekiNo ninteichosaRirekiNo
     */
    @JsonProperty("ninteichosaRirekiNo")
    public void setNinteichosaRirekiNo(RString ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /*
     * getgaikyoChosaTextImageKubun
     * @return gaikyoChosaTextImageKubun
     */
    @JsonProperty("gaikyoChosaTextImageKubun")
    public RString getGaikyoChosaTextImageKubun() {
        return gaikyoChosaTextImageKubun;
    }

    /*
     * setgaikyoChosaTextImageKubun
     * @param gaikyoChosaTextImageKubun gaikyoChosaTextImageKubun
     */
    @JsonProperty("gaikyoChosaTextImageKubun")
    public void setGaikyoChosaTextImageKubun(RString gaikyoChosaTextImageKubun) {
        this.gaikyoChosaTextImageKubun = gaikyoChosaTextImageKubun;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void onLoad(List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList, List<RembanServiceJokyoBusiness> serviceJokyos,
            List<NinteichosahyoShisetsuRiyo> shisetsuRiyos) {
        new ChosaKekkaInfoGaikyoHandler(this).onLoad(chosaKekkaInfoGaikyoList, serviceJokyos, shisetsuRiyos);
    }
}
