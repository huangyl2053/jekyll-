package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu.IKaigoChohyoSeigyoKyotsuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * tabNotsuInfo のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class tabNotsuInfoDiv extends TabContainer {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplAtesaki")
    private tplAtesakiDiv tplAtesaki;
    @JsonProperty("tplKozaMongoRyoshuHizukei")
    private tplKozaMongoRyoshuHizukeiDiv tplKozaMongoRyoshuHizukei;
    @JsonProperty("tplSagakureishoToshoHoho")
    private tplSagakureishoToshoHohoDiv tplSagakureishoToshoHoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplAtesaki
     * @return tplAtesaki
     */
    @JsonProperty("tplAtesaki")
    public tplAtesakiDiv getTplAtesaki() {
        return tplAtesaki;
    }

    /*
     * settplAtesaki
     * @param tplAtesaki tplAtesaki
     */
    @JsonProperty("tplAtesaki")
    public void setTplAtesaki(tplAtesakiDiv tplAtesaki) {
        this.tplAtesaki = tplAtesaki;
    }

    /*
     * gettplKozaMongoRyoshuHizukei
     * @return tplKozaMongoRyoshuHizukei
     */
    @JsonProperty("tplKozaMongoRyoshuHizukei")
    public tplKozaMongoRyoshuHizukeiDiv getTplKozaMongoRyoshuHizukei() {
        return tplKozaMongoRyoshuHizukei;
    }

    /*
     * settplKozaMongoRyoshuHizukei
     * @param tplKozaMongoRyoshuHizukei tplKozaMongoRyoshuHizukei
     */
    @JsonProperty("tplKozaMongoRyoshuHizukei")
    public void setTplKozaMongoRyoshuHizukei(tplKozaMongoRyoshuHizukeiDiv tplKozaMongoRyoshuHizukei) {
        this.tplKozaMongoRyoshuHizukei = tplKozaMongoRyoshuHizukei;
    }

    /*
     * gettplSagakureishoToshoHoho
     * @return tplSagakureishoToshoHoho
     */
    @JsonProperty("tplSagakureishoToshoHoho")
    public tplSagakureishoToshoHohoDiv getTplSagakureishoToshoHoho() {
        return tplSagakureishoToshoHoho;
    }

    /*
     * settplSagakureishoToshoHoho
     * @param tplSagakureishoToshoHoho tplSagakureishoToshoHoho
     */
    @JsonProperty("tplSagakureishoToshoHoho")
    public void setTplSagakureishoToshoHoho(tplSagakureishoToshoHohoDiv tplSagakureishoToshoHoho) {
        this.tplSagakureishoToshoHoho = tplSagakureishoToshoHoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public NonyuTsuchishoInfoDiv getNonyuTsuchishoInfo() {
        return this.getTplAtesaki().getNonyuTsuchishoInfo();
    }

    @JsonIgnore
    public void setNonyuTsuchishoInfo(NonyuTsuchishoInfoDiv NonyuTsuchishoInfo) {
        this.getTplAtesaki().setNonyuTsuchishoInfo(NonyuTsuchishoInfo);
    }

    @JsonIgnore
    public TextBox getTxtHakkoBusu() {
        return this.getTplAtesaki().getNonyuTsuchishoInfo().getTxtHakkoBusu();
    }

    @JsonIgnore
    public void setTxtHakkoBusu(TextBox txtHakkoBusu) {
        this.getTplAtesaki().getNonyuTsuchishoInfo().setTxtHakkoBusu(txtHakkoBusu);
    }

    @JsonIgnore
    public RadioButton getRadSokuhoTorikomiKubun() {
        return this.getTplAtesaki().getNonyuTsuchishoInfo().getRadSokuhoTorikomiKubun();
    }

    @JsonIgnore
    public void setRadSokuhoTorikomiKubun(RadioButton radSokuhoTorikomiKubun) {
        this.getTplAtesaki().getNonyuTsuchishoInfo().setRadSokuhoTorikomiKubun(radSokuhoTorikomiKubun);
    }

    @JsonIgnore
    public TanpyoHakkoShokiDiv getTanpyoHakkoShoki() {
        return this.getTplAtesaki().getNonyuTsuchishoInfo().getTanpyoHakkoShoki();
    }

    @JsonIgnore
    public void setTanpyoHakkoShoki(TanpyoHakkoShokiDiv TanpyoHakkoShoki) {
        this.getTplAtesaki().getNonyuTsuchishoInfo().setTanpyoHakkoShoki(TanpyoHakkoShoki);
    }

    @JsonIgnore
    public RadioButton getRadSokujiHakkoHoshiki() {
        return this.getTplAtesaki().getNonyuTsuchishoInfo().getTanpyoHakkoShoki().getRadSokujiHakkoHoshiki();
    }

    @JsonIgnore
    public void setRadSokujiHakkoHoshiki(RadioButton radSokujiHakkoHoshiki) {
        this.getTplAtesaki().getNonyuTsuchishoInfo().getTanpyoHakkoShoki().setRadSokujiHakkoHoshiki(radSokujiHakkoHoshiki);
    }

    @JsonIgnore
    public RadioButton getRadSokujiHakkoKeishiki() {
        return this.getTplAtesaki().getNonyuTsuchishoInfo().getTanpyoHakkoShoki().getRadSokujiHakkoKeishiki();
    }

    @JsonIgnore
    public void setRadSokujiHakkoKeishiki(RadioButton radSokujiHakkoKeishiki) {
        this.getTplAtesaki().getNonyuTsuchishoInfo().getTanpyoHakkoShoki().setRadSokujiHakkoKeishiki(radSokujiHakkoKeishiki);
    }

    @JsonIgnore
    public IKaigoChohyoSeigyoKyotsuDiv getCcdKaigoChohyoSeigyoKyotsu() {
        return this.getTplAtesaki().getCcdKaigoChohyoSeigyoKyotsu();
    }

    @JsonIgnore
    public KozaMongonDiv getKozaMongon() {
        return this.getTplKozaMongoRyoshuHizukei().getKozaMongon();
    }

    @JsonIgnore
    public void setKozaMongon(KozaMongonDiv KozaMongon) {
        this.getTplKozaMongoRyoshuHizukei().setKozaMongon(KozaMongon);
    }

    @JsonIgnore
    public DropDownList getDdlKozaMongonRyoshushoNofugaku() {
        return this.getTplKozaMongoRyoshuHizukei().getKozaMongon().getDdlKozaMongonRyoshushoNofugaku();
    }

    @JsonIgnore
    public void setDdlKozaMongonRyoshushoNofugaku(DropDownList ddlKozaMongonRyoshushoNofugaku) {
        this.getTplKozaMongoRyoshuHizukei().getKozaMongon().setDdlKozaMongonRyoshushoNofugaku(ddlKozaMongonRyoshushoNofugaku);
    }

    @JsonIgnore
    public DropDownList getDdlKozaMongonNofushoNofugaku() {
        return this.getTplKozaMongoRyoshuHizukei().getKozaMongon().getDdlKozaMongonNofushoNofugaku();
    }

    @JsonIgnore
    public void setDdlKozaMongonNofushoNofugaku(DropDownList ddlKozaMongonNofushoNofugaku) {
        this.getTplKozaMongoRyoshuHizukei().getKozaMongon().setDdlKozaMongonNofushoNofugaku(ddlKozaMongonNofushoNofugaku);
    }

    @JsonIgnore
    public DropDownList getDdlKozaMongonRyoshushoRyoshuin() {
        return this.getTplKozaMongoRyoshuHizukei().getKozaMongon().getDdlKozaMongonRyoshushoRyoshuin();
    }

    @JsonIgnore
    public void setDdlKozaMongonRyoshushoRyoshuin(DropDownList ddlKozaMongonRyoshushoRyoshuin) {
        this.getTplKozaMongoRyoshuHizukei().getKozaMongon().setDdlKozaMongonRyoshushoRyoshuin(ddlKozaMongonRyoshushoRyoshuin);
    }

    @JsonIgnore
    public DropDownList getDdlKozaMongonNofushoRyoshuin() {
        return this.getTplKozaMongoRyoshuHizukei().getKozaMongon().getDdlKozaMongonNofushoRyoshuin();
    }

    @JsonIgnore
    public void setDdlKozaMongonNofushoRyoshuin(DropDownList ddlKozaMongonNofushoRyoshuin) {
        this.getTplKozaMongoRyoshuHizukei().getKozaMongon().setDdlKozaMongonNofushoRyoshuin(ddlKozaMongonNofushoRyoshuin);
    }

    @JsonIgnore
    public ShutsuryokuHohoDiv getShutsuryokuHoho() {
        return this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho();
    }

    @JsonIgnore
    public void setShutsuryokuHoho(ShutsuryokuHohoDiv ShutsuryokuHoho) {
        this.getTplKozaMongoRyoshuHizukei().setShutsuryokuHoho(ShutsuryokuHoho);
    }

    @JsonIgnore
    public DropDownList getDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn() {
        return this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn();
    }

    @JsonIgnore
    public void setDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn(DropDownList ddlShutsuryokuHohoRyoshushoRyoshuHidukeIn) {
        this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn(ddlShutsuryokuHohoRyoshushoRyoshuHidukeIn);
    }

    @JsonIgnore
    public DropDownList getDdlShutsuryokuHohoNofushoRyoshuHiduke() {
        return this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getDdlShutsuryokuHohoNofushoRyoshuHiduke();
    }

    @JsonIgnore
    public void setDdlShutsuryokuHohoNofushoRyoshuHiduke(DropDownList ddlShutsuryokuHohoNofushoRyoshuHiduke) {
        this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setDdlShutsuryokuHohoNofushoRyoshuHiduke(ddlShutsuryokuHohoNofushoRyoshuHiduke);
    }

    @JsonIgnore
    public DropDownList getDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi() {
        return this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi();
    }

    @JsonIgnore
    public void setDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi(DropDownList ddlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi) {
        this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi(ddlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setLin1(lin1);
    }

    @JsonIgnore
    public DropDownList getDdlNofushoShichosonNameUmu() {
        return this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getDdlNofushoShichosonNameUmu();
    }

    @JsonIgnore
    public void setDdlNofushoShichosonNameUmu(DropDownList ddlNofushoShichosonNameUmu) {
        this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setDdlNofushoShichosonNameUmu(ddlNofushoShichosonNameUmu);
    }

    @JsonIgnore
    public TextBox getTxtNofushoShichosonName() {
        return this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getTxtNofushoShichosonName();
    }

    @JsonIgnore
    public void setTxtNofushoShichosonName(TextBox txtNofushoShichosonName) {
        this.getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setTxtNofushoShichosonName(txtNofushoShichosonName);
    }

    @JsonIgnore
    public NokigenOCRDiv getNokigenOCR() {
        return this.getTplKozaMongoRyoshuHizukei().getNokigenOCR();
    }

    @JsonIgnore
    public void setNokigenOCR(NokigenOCRDiv NokigenOCR) {
        this.getTplKozaMongoRyoshuHizukei().setNokigenOCR(NokigenOCR);
    }

    @JsonIgnore
    public DropDownList getDdlNokigenShutsuryokuHoho() {
        return this.getTplKozaMongoRyoshuHizukei().getNokigenOCR().getDdlNokigenShutsuryokuHoho();
    }

    @JsonIgnore
    public void setDdlNokigenShutsuryokuHoho(DropDownList ddlNokigenShutsuryokuHoho) {
        this.getTplKozaMongoRyoshuHizukei().getNokigenOCR().setDdlNokigenShutsuryokuHoho(ddlNokigenShutsuryokuHoho);
    }

    @JsonIgnore
    public DropDownList getDdlOCRShutsuryokuHoho() {
        return this.getTplKozaMongoRyoshuHizukei().getNokigenOCR().getDdlOCRShutsuryokuHoho();
    }

    @JsonIgnore
    public void setDdlOCRShutsuryokuHoho(DropDownList ddlOCRShutsuryokuHoho) {
        this.getTplKozaMongoRyoshuHizukei().getNokigenOCR().setDdlOCRShutsuryokuHoho(ddlOCRShutsuryokuHoho);
    }

    @JsonIgnore
    public KarisanteiDiv getKarisantei() {
        return this.getTplSagakureishoToshoHoho().getKarisantei();
    }

    @JsonIgnore
    public void setKarisantei(KarisanteiDiv Karisantei) {
        this.getTplSagakureishoToshoHoho().setKarisantei(Karisantei);
    }

    @JsonIgnore
    public SaGakuKDiv getSaGakuK() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK();
    }

    @JsonIgnore
    public void setSaGakuK(SaGakuKDiv SaGakuK) {
        this.getTplSagakureishoToshoHoho().getKarisantei().setSaGakuK(SaGakuK);
    }

    @JsonIgnore
    public RadioButton getRadSagakuReishoHakkoUmuK() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getRadSagakuReishoHakkoUmuK();
    }

    @JsonIgnore
    public void setRadSagakuReishoHakkoUmuK(RadioButton radSagakuReishoHakkoUmuK) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setRadSagakuReishoHakkoUmuK(radSagakuReishoHakkoUmuK);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setLin2(lin2);
    }

    @JsonIgnore
    public RadioButton getRadBarCodeHyojiK() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getRadBarCodeHyojiK();
    }

    @JsonIgnore
    public void setRadBarCodeHyojiK(RadioButton radBarCodeHyojiK) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setRadBarCodeHyojiK(radBarCodeHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadKozaNofushoHyojiK() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getRadKozaNofushoHyojiK();
    }

    @JsonIgnore
    public void setRadKozaNofushoHyojiK(RadioButton radKozaNofushoHyojiK) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setRadKozaNofushoHyojiK(radKozaNofushoHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadNofishoHakkoYMDHyojiK() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getRadNofishoHakkoYMDHyojiK();
    }

    @JsonIgnore
    public void setRadNofishoHakkoYMDHyojiK(RadioButton radNofishoHakkoYMDHyojiK) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setRadNofishoHakkoYMDHyojiK(radNofishoHakkoYMDHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadNofishoToriatsukaiKigenHyojiK() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getRadNofishoToriatsukaiKigenHyojiK();
    }

    @JsonIgnore
    public void setRadNofishoToriatsukaiKigenHyojiK(RadioButton radNofishoToriatsukaiKigenHyojiK) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setRadNofishoToriatsukaiKigenHyojiK(radNofishoToriatsukaiKigenHyojiK);
    }

    @JsonIgnore
    public ToshoShutsuryokuKDiv getToshoShutsuryokuK() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK();
    }

    @JsonIgnore
    public void setToshoShutsuryokuK(ToshoShutsuryokuKDiv ToshoShutsuryokuK) {
        this.getTplSagakureishoToshoHoho().getKarisantei().setToshoShutsuryokuK(ToshoShutsuryokuK);
    }

    @JsonIgnore
    public RadioButton getRadToshoShutsuryokuK() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().getRadToshoShutsuryokuK();
    }

    @JsonIgnore
    public void setRadToshoShutsuryokuK(RadioButton radToshoShutsuryokuK) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().setRadToshoShutsuryokuK(radToshoShutsuryokuK);
    }

    @JsonIgnore
    public DropDownList getDdlChukiKaishiKiK() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().getDdlChukiKaishiKiK();
    }

    @JsonIgnore
    public void setDdlChukiKaishiKiK(DropDownList ddlChukiKaishiKiK) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().setDdlChukiKaishiKiK(ddlChukiKaishiKiK);
    }

    @JsonIgnore
    public DropDownList getDdlKokiKaishiKiK() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().getDdlKokiKaishiKiK();
    }

    @JsonIgnore
    public void setDdlKokiKaishiKiK(DropDownList ddlKokiKaishiKiK) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().setDdlKokiKaishiKiK(ddlKokiKaishiKiK);
    }

    @JsonIgnore
    public SanteiKisoShutsuryokuHohoDiv getSanteiKisoShutsuryokuHoho() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho();
    }

    @JsonIgnore
    public void setSanteiKisoShutsuryokuHoho(SanteiKisoShutsuryokuHohoDiv SanteiKisoShutsuryokuHoho) {
        this.getTplSagakureishoToshoHoho().getKarisantei().setSanteiKisoShutsuryokuHoho(SanteiKisoShutsuryokuHoho);
    }

    @JsonIgnore
    public DropDownList getDdlKiso1() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().getDdlKiso1();
    }

    @JsonIgnore
    public void setDdlKiso1(DropDownList ddlKiso1) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().setDdlKiso1(ddlKiso1);
    }

    @JsonIgnore
    public DropDownList getDdlKiso2() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().getDdlKiso2();
    }

    @JsonIgnore
    public void setDdlKiso2(DropDownList ddlKiso2) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().setDdlKiso2(ddlKiso2);
    }

    @JsonIgnore
    public DropDownList getDdlKiso3() {
        return this.getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().getDdlKiso3();
    }

    @JsonIgnore
    public void setDdlKiso3(DropDownList ddlKiso3) {
        this.getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().setDdlKiso3(ddlKiso3);
    }

    @JsonIgnore
    public HonsanteiDiv getHonsantei() {
        return this.getTplSagakureishoToshoHoho().getHonsantei();
    }

    @JsonIgnore
    public void setHonsantei(HonsanteiDiv Honsantei) {
        this.getTplSagakureishoToshoHoho().setHonsantei(Honsantei);
    }

    @JsonIgnore
    public SaGakuHDiv getSaGakuH() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH();
    }

    @JsonIgnore
    public void setSaGakuH(SaGakuHDiv SaGakuH) {
        this.getTplSagakureishoToshoHoho().getHonsantei().setSaGakuH(SaGakuH);
    }

    @JsonIgnore
    public RadioButton getRadSagakuReishoHakkoUmuH() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getRadSagakuReishoHakkoUmuH();
    }

    @JsonIgnore
    public void setRadSagakuReishoHakkoUmuH(RadioButton radSagakuReishoHakkoUmuH) {
        this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setRadSagakuReishoHakkoUmuH(radSagakuReishoHakkoUmuH);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getLin3();
    }

    @JsonIgnore
    public void setLin3(HorizontalLine lin3) {
        this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setLin3(lin3);
    }

    @JsonIgnore
    public RadioButton getRadBarCodeHyojiH() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getRadBarCodeHyojiH();
    }

    @JsonIgnore
    public void setRadBarCodeHyojiH(RadioButton radBarCodeHyojiH) {
        this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setRadBarCodeHyojiH(radBarCodeHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadKozaNofushoHyojiH() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getRadKozaNofushoHyojiH();
    }

    @JsonIgnore
    public void setRadKozaNofushoHyojiH(RadioButton radKozaNofushoHyojiH) {
        this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setRadKozaNofushoHyojiH(radKozaNofushoHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadNofishoHakkoYMDHyojiH() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getRadNofishoHakkoYMDHyojiH();
    }

    @JsonIgnore
    public void setRadNofishoHakkoYMDHyojiH(RadioButton radNofishoHakkoYMDHyojiH) {
        this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setRadNofishoHakkoYMDHyojiH(radNofishoHakkoYMDHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadNofishoToriatsukaiKigenHyojiH() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getRadNofishoToriatsukaiKigenHyojiH();
    }

    @JsonIgnore
    public void setRadNofishoToriatsukaiKigenHyojiH(RadioButton radNofishoToriatsukaiKigenHyojiH) {
        this.getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setRadNofishoToriatsukaiKigenHyojiH(radNofishoToriatsukaiKigenHyojiH);
    }

    @JsonIgnore
    public ToshoShutsuryokuHDiv getToshoShutsuryokuH() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH();
    }

    @JsonIgnore
    public void setToshoShutsuryokuH(ToshoShutsuryokuHDiv ToshoShutsuryokuH) {
        this.getTplSagakureishoToshoHoho().getHonsantei().setToshoShutsuryokuH(ToshoShutsuryokuH);
    }

    @JsonIgnore
    public RadioButton getRadToshoShutsuryokuH() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().getRadToshoShutsuryokuH();
    }

    @JsonIgnore
    public void setRadToshoShutsuryokuH(RadioButton radToshoShutsuryokuH) {
        this.getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().setRadToshoShutsuryokuH(radToshoShutsuryokuH);
    }

    @JsonIgnore
    public DropDownList getDdlChukiKaishiKiH() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().getDdlChukiKaishiKiH();
    }

    @JsonIgnore
    public void setDdlChukiKaishiKiH(DropDownList ddlChukiKaishiKiH) {
        this.getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().setDdlChukiKaishiKiH(ddlChukiKaishiKiH);
    }

    @JsonIgnore
    public DropDownList getDdlKokiKaishiKiH() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().getDdlKokiKaishiKiH();
    }

    @JsonIgnore
    public void setDdlKokiKaishiKiH(DropDownList ddlKokiKaishiKiH) {
        this.getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().setDdlKokiKaishiKiH(ddlKokiKaishiKiH);
    }

    @JsonIgnore
    public KanendoMongonDiv getKanendoMongon() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getKanendoMongon();
    }

    @JsonIgnore
    public void setKanendoMongon(KanendoMongonDiv KanendoMongon) {
        this.getTplSagakureishoToshoHoho().getHonsantei().setKanendoMongon(KanendoMongon);
    }

    @JsonIgnore
    public RadioButton getRadKanendoMongon1() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getKanendoMongon().getRadKanendoMongon1();
    }

    @JsonIgnore
    public void setRadKanendoMongon1(RadioButton radKanendoMongon1) {
        this.getTplSagakureishoToshoHoho().getHonsantei().getKanendoMongon().setRadKanendoMongon1(radKanendoMongon1);
    }

    @JsonIgnore
    public RadioButton getRadKanendoMongon2() {
        return this.getTplSagakureishoToshoHoho().getHonsantei().getKanendoMongon().getRadKanendoMongon2();
    }

    @JsonIgnore
    public void setRadKanendoMongon2(RadioButton radKanendoMongon2) {
        this.getTplSagakureishoToshoHoho().getHonsantei().getKanendoMongon().setRadKanendoMongon2(radKanendoMongon2);
    }

    // </editor-fold>
}
