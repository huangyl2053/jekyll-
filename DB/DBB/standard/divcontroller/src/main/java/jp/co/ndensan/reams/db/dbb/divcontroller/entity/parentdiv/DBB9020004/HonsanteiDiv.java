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
 * Honsantei のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class HonsanteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SaGakuH")
    private SaGakuHDiv SaGakuH;
    @JsonProperty("ToshoShutsuryokuH")
    private ToshoShutsuryokuHDiv ToshoShutsuryokuH;
    @JsonProperty("KanendoMongon")
    private KanendoMongonDiv KanendoMongon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSaGakuH
     * @return SaGakuH
     */
    @JsonProperty("SaGakuH")
    public SaGakuHDiv getSaGakuH() {
        return SaGakuH;
    }

    /*
     * setSaGakuH
     * @param SaGakuH SaGakuH
     */
    @JsonProperty("SaGakuH")
    public void setSaGakuH(SaGakuHDiv SaGakuH) {
        this.SaGakuH = SaGakuH;
    }

    /*
     * getToshoShutsuryokuH
     * @return ToshoShutsuryokuH
     */
    @JsonProperty("ToshoShutsuryokuH")
    public ToshoShutsuryokuHDiv getToshoShutsuryokuH() {
        return ToshoShutsuryokuH;
    }

    /*
     * setToshoShutsuryokuH
     * @param ToshoShutsuryokuH ToshoShutsuryokuH
     */
    @JsonProperty("ToshoShutsuryokuH")
    public void setToshoShutsuryokuH(ToshoShutsuryokuHDiv ToshoShutsuryokuH) {
        this.ToshoShutsuryokuH = ToshoShutsuryokuH;
    }

    /*
     * getKanendoMongon
     * @return KanendoMongon
     */
    @JsonProperty("KanendoMongon")
    public KanendoMongonDiv getKanendoMongon() {
        return KanendoMongon;
    }

    /*
     * setKanendoMongon
     * @param KanendoMongon KanendoMongon
     */
    @JsonProperty("KanendoMongon")
    public void setKanendoMongon(KanendoMongonDiv KanendoMongon) {
        this.KanendoMongon = KanendoMongon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadSagakuReishoHakkoUmuH() {
        return this.getSaGakuH().getRadSagakuReishoHakkoUmuH();
    }

    @JsonIgnore
    public void setRadSagakuReishoHakkoUmuH(RadioButton radSagakuReishoHakkoUmuH) {
        this.getSaGakuH().setRadSagakuReishoHakkoUmuH(radSagakuReishoHakkoUmuH);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getSaGakuH().getLin3();
    }

    @JsonIgnore
    public void setLin3(HorizontalLine lin3) {
        this.getSaGakuH().setLin3(lin3);
    }

    @JsonIgnore
    public RadioButton getRadBarCodeHyojiH() {
        return this.getSaGakuH().getRadBarCodeHyojiH();
    }

    @JsonIgnore
    public void setRadBarCodeHyojiH(RadioButton radBarCodeHyojiH) {
        this.getSaGakuH().setRadBarCodeHyojiH(radBarCodeHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadKozaNofushoHyojiH() {
        return this.getSaGakuH().getRadKozaNofushoHyojiH();
    }

    @JsonIgnore
    public void setRadKozaNofushoHyojiH(RadioButton radKozaNofushoHyojiH) {
        this.getSaGakuH().setRadKozaNofushoHyojiH(radKozaNofushoHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadNofishoHakkoYMDHyojiH() {
        return this.getSaGakuH().getRadNofishoHakkoYMDHyojiH();
    }

    @JsonIgnore
    public void setRadNofishoHakkoYMDHyojiH(RadioButton radNofishoHakkoYMDHyojiH) {
        this.getSaGakuH().setRadNofishoHakkoYMDHyojiH(radNofishoHakkoYMDHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadNofishoToriatsukaiKigenHyojiH() {
        return this.getSaGakuH().getRadNofishoToriatsukaiKigenHyojiH();
    }

    @JsonIgnore
    public void setRadNofishoToriatsukaiKigenHyojiH(RadioButton radNofishoToriatsukaiKigenHyojiH) {
        this.getSaGakuH().setRadNofishoToriatsukaiKigenHyojiH(radNofishoToriatsukaiKigenHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadToshoShutsuryokuH() {
        return this.getToshoShutsuryokuH().getRadToshoShutsuryokuH();
    }

    @JsonIgnore
    public void setRadToshoShutsuryokuH(RadioButton radToshoShutsuryokuH) {
        this.getToshoShutsuryokuH().setRadToshoShutsuryokuH(radToshoShutsuryokuH);
    }

    @JsonIgnore
    public DropDownList getDdlChukiKaishiKiH() {
        return this.getToshoShutsuryokuH().getDdlChukiKaishiKiH();
    }

    @JsonIgnore
    public void setDdlChukiKaishiKiH(DropDownList ddlChukiKaishiKiH) {
        this.getToshoShutsuryokuH().setDdlChukiKaishiKiH(ddlChukiKaishiKiH);
    }

    @JsonIgnore
    public DropDownList getDdlKokiKaishiKiH() {
        return this.getToshoShutsuryokuH().getDdlKokiKaishiKiH();
    }

    @JsonIgnore
    public void setDdlKokiKaishiKiH(DropDownList ddlKokiKaishiKiH) {
        this.getToshoShutsuryokuH().setDdlKokiKaishiKiH(ddlKokiKaishiKiH);
    }

    @JsonIgnore
    public RadioButton getRadKanendoMongon1() {
        return this.getKanendoMongon().getRadKanendoMongon1();
    }

    @JsonIgnore
    public void setRadKanendoMongon1(RadioButton radKanendoMongon1) {
        this.getKanendoMongon().setRadKanendoMongon1(radKanendoMongon1);
    }

    @JsonIgnore
    public RadioButton getRadKanendoMongon2() {
        return this.getKanendoMongon().getRadKanendoMongon2();
    }

    @JsonIgnore
    public void setRadKanendoMongon2(RadioButton radKanendoMongon2) {
        this.getKanendoMongon().setRadKanendoMongon2(radKanendoMongon2);
    }

    // </editor-fold>
}
