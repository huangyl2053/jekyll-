package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * Karisantei のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class KarisanteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SaGakuK")
    private SaGakuKDiv SaGakuK;
    @JsonProperty("ToshoShutsuryokuK")
    private ToshoShutsuryokuKDiv ToshoShutsuryokuK;
    @JsonProperty("SanteiKisoShutsuryokuHoho")
    private SanteiKisoShutsuryokuHohoDiv SanteiKisoShutsuryokuHoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSaGakuK
     * @return SaGakuK
     */
    @JsonProperty("SaGakuK")
    public SaGakuKDiv getSaGakuK() {
        return SaGakuK;
    }

    /*
     * setSaGakuK
     * @param SaGakuK SaGakuK
     */
    @JsonProperty("SaGakuK")
    public void setSaGakuK(SaGakuKDiv SaGakuK) {
        this.SaGakuK = SaGakuK;
    }

    /*
     * getToshoShutsuryokuK
     * @return ToshoShutsuryokuK
     */
    @JsonProperty("ToshoShutsuryokuK")
    public ToshoShutsuryokuKDiv getToshoShutsuryokuK() {
        return ToshoShutsuryokuK;
    }

    /*
     * setToshoShutsuryokuK
     * @param ToshoShutsuryokuK ToshoShutsuryokuK
     */
    @JsonProperty("ToshoShutsuryokuK")
    public void setToshoShutsuryokuK(ToshoShutsuryokuKDiv ToshoShutsuryokuK) {
        this.ToshoShutsuryokuK = ToshoShutsuryokuK;
    }

    /*
     * getSanteiKisoShutsuryokuHoho
     * @return SanteiKisoShutsuryokuHoho
     */
    @JsonProperty("SanteiKisoShutsuryokuHoho")
    public SanteiKisoShutsuryokuHohoDiv getSanteiKisoShutsuryokuHoho() {
        return SanteiKisoShutsuryokuHoho;
    }

    /*
     * setSanteiKisoShutsuryokuHoho
     * @param SanteiKisoShutsuryokuHoho SanteiKisoShutsuryokuHoho
     */
    @JsonProperty("SanteiKisoShutsuryokuHoho")
    public void setSanteiKisoShutsuryokuHoho(SanteiKisoShutsuryokuHohoDiv SanteiKisoShutsuryokuHoho) {
        this.SanteiKisoShutsuryokuHoho = SanteiKisoShutsuryokuHoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadSagakuReishoHakkoUmuK() {
        return this.getSaGakuK().getRadSagakuReishoHakkoUmuK();
    }

    @JsonIgnore
    public void setRadSagakuReishoHakkoUmuK(RadioButton radSagakuReishoHakkoUmuK) {
        this.getSaGakuK().setRadSagakuReishoHakkoUmuK(radSagakuReishoHakkoUmuK);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getSaGakuK().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getSaGakuK().setLin2(lin2);
    }

    @JsonIgnore
    public RadioButton getRadBarCodeHyojiK() {
        return this.getSaGakuK().getRadBarCodeHyojiK();
    }

    @JsonIgnore
    public void setRadBarCodeHyojiK(RadioButton radBarCodeHyojiK) {
        this.getSaGakuK().setRadBarCodeHyojiK(radBarCodeHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadKozaNofushoHyojiK() {
        return this.getSaGakuK().getRadKozaNofushoHyojiK();
    }

    @JsonIgnore
    public void setRadKozaNofushoHyojiK(RadioButton radKozaNofushoHyojiK) {
        this.getSaGakuK().setRadKozaNofushoHyojiK(radKozaNofushoHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadNofishoHakkoYMDHyojiK() {
        return this.getSaGakuK().getRadNofishoHakkoYMDHyojiK();
    }

    @JsonIgnore
    public void setRadNofishoHakkoYMDHyojiK(RadioButton radNofishoHakkoYMDHyojiK) {
        this.getSaGakuK().setRadNofishoHakkoYMDHyojiK(radNofishoHakkoYMDHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadNofishoToriatsukaiKigenHyojiK() {
        return this.getSaGakuK().getRadNofishoToriatsukaiKigenHyojiK();
    }

    @JsonIgnore
    public void setRadNofishoToriatsukaiKigenHyojiK(RadioButton radNofishoToriatsukaiKigenHyojiK) {
        this.getSaGakuK().setRadNofishoToriatsukaiKigenHyojiK(radNofishoToriatsukaiKigenHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadToshoShutsuryokuK() {
        return this.getToshoShutsuryokuK().getRadToshoShutsuryokuK();
    }

    @JsonIgnore
    public void setRadToshoShutsuryokuK(RadioButton radToshoShutsuryokuK) {
        this.getToshoShutsuryokuK().setRadToshoShutsuryokuK(radToshoShutsuryokuK);
    }

    @JsonIgnore
    public DropDownList getDdlChukiKaishiKiK() {
        return this.getToshoShutsuryokuK().getDdlChukiKaishiKiK();
    }

    @JsonIgnore
    public void setDdlChukiKaishiKiK(DropDownList ddlChukiKaishiKiK) {
        this.getToshoShutsuryokuK().setDdlChukiKaishiKiK(ddlChukiKaishiKiK);
    }

    @JsonIgnore
    public DropDownList getDdlKokiKaishiKiK() {
        return this.getToshoShutsuryokuK().getDdlKokiKaishiKiK();
    }

    @JsonIgnore
    public void setDdlKokiKaishiKiK(DropDownList ddlKokiKaishiKiK) {
        this.getToshoShutsuryokuK().setDdlKokiKaishiKiK(ddlKokiKaishiKiK);
    }

    @JsonIgnore
    public DropDownList getDdlKiso1() {
        return this.getSanteiKisoShutsuryokuHoho().getDdlKiso1();
    }

    @JsonIgnore
    public void setDdlKiso1(DropDownList ddlKiso1) {
        this.getSanteiKisoShutsuryokuHoho().setDdlKiso1(ddlKiso1);
    }

    @JsonIgnore
    public DropDownList getDdlKiso2() {
        return this.getSanteiKisoShutsuryokuHoho().getDdlKiso2();
    }

    @JsonIgnore
    public void setDdlKiso2(DropDownList ddlKiso2) {
        this.getSanteiKisoShutsuryokuHoho().setDdlKiso2(ddlKiso2);
    }

    @JsonIgnore
    public DropDownList getDdlKiso3() {
        return this.getSanteiKisoShutsuryokuHoho().getDdlKiso3();
    }

    @JsonIgnore
    public void setDdlKiso3(DropDownList ddlKiso3) {
        this.getSanteiKisoShutsuryokuHoho().setDdlKiso3(ddlKiso3);
    }

    // </editor-fold>
}
