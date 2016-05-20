package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0030011;
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
 * JigyoJokyoHokokuGeppo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JigyoJokyoHokokuGeppoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JikkoTanni")
    private JikkoTanniDiv JikkoTanni;
    @JsonProperty("tblShutsuryokuTaisho")
    private tblShutsuryokuTaishoDiv tblShutsuryokuTaisho;
    @JsonProperty("shukeiNengetsu3")
    private RString shukeiNengetsu3;
    @JsonProperty("shukeiNengetsu5")
    private RString shukeiNengetsu5;
    @JsonProperty("shichosonCode")
    private RString shichosonCode;
    @JsonProperty("koikiKoseiKubun")
    private RString koikiKoseiKubun;
    @JsonProperty("gappeiKubun")
    private RString gappeiKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJikkoTanni
     * @return JikkoTanni
     */
    @JsonProperty("JikkoTanni")
    public JikkoTanniDiv getJikkoTanni() {
        return JikkoTanni;
    }

    /*
     * setJikkoTanni
     * @param JikkoTanni JikkoTanni
     */
    @JsonProperty("JikkoTanni")
    public void setJikkoTanni(JikkoTanniDiv JikkoTanni) {
        this.JikkoTanni = JikkoTanni;
    }

    /*
     * gettblShutsuryokuTaisho
     * @return tblShutsuryokuTaisho
     */
    @JsonProperty("tblShutsuryokuTaisho")
    public tblShutsuryokuTaishoDiv getTblShutsuryokuTaisho() {
        return tblShutsuryokuTaisho;
    }

    /*
     * settblShutsuryokuTaisho
     * @param tblShutsuryokuTaisho tblShutsuryokuTaisho
     */
    @JsonProperty("tblShutsuryokuTaisho")
    public void setTblShutsuryokuTaisho(tblShutsuryokuTaishoDiv tblShutsuryokuTaisho) {
        this.tblShutsuryokuTaisho = tblShutsuryokuTaisho;
    }

    /*
     * getshukeiNengetsu3
     * @return shukeiNengetsu3
     */
    @JsonProperty("shukeiNengetsu3")
    public RString getShukeiNengetsu3() {
        return shukeiNengetsu3;
    }

    /*
     * setshukeiNengetsu3
     * @param shukeiNengetsu3 shukeiNengetsu3
     */
    @JsonProperty("shukeiNengetsu3")
    public void setShukeiNengetsu3(RString shukeiNengetsu3) {
        this.shukeiNengetsu3 = shukeiNengetsu3;
    }

    /*
     * getshukeiNengetsu5
     * @return shukeiNengetsu5
     */
    @JsonProperty("shukeiNengetsu5")
    public RString getShukeiNengetsu5() {
        return shukeiNengetsu5;
    }

    /*
     * setshukeiNengetsu5
     * @param shukeiNengetsu5 shukeiNengetsu5
     */
    @JsonProperty("shukeiNengetsu5")
    public void setShukeiNengetsu5(RString shukeiNengetsu5) {
        this.shukeiNengetsu5 = shukeiNengetsu5;
    }

    /*
     * getshichosonCode
     * @return shichosonCode
     */
    @JsonProperty("shichosonCode")
    public RString getShichosonCode() {
        return shichosonCode;
    }

    /*
     * setshichosonCode
     * @param shichosonCode shichosonCode
     */
    @JsonProperty("shichosonCode")
    public void setShichosonCode(RString shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /*
     * getkoikiKoseiKubun
     * @return koikiKoseiKubun
     */
    @JsonProperty("koikiKoseiKubun")
    public RString getKoikiKoseiKubun() {
        return koikiKoseiKubun;
    }

    /*
     * setkoikiKoseiKubun
     * @param koikiKoseiKubun koikiKoseiKubun
     */
    @JsonProperty("koikiKoseiKubun")
    public void setKoikiKoseiKubun(RString koikiKoseiKubun) {
        this.koikiKoseiKubun = koikiKoseiKubun;
    }

    /*
     * getgappeiKubun
     * @return gappeiKubun
     */
    @JsonProperty("gappeiKubun")
    public RString getGappeiKubun() {
        return gappeiKubun;
    }

    /*
     * setgappeiKubun
     * @param gappeiKubun gappeiKubun
     */
    @JsonProperty("gappeiKubun")
    public void setGappeiKubun(RString gappeiKubun) {
        this.gappeiKubun = gappeiKubun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShutsuryokuTaisho() {
        return this.getTblShutsuryokuTaisho().getLblShutsuryokuTaisho();
    }

    @JsonIgnore
    public Label getLblShukeiHoho() {
        return this.getTblShutsuryokuTaisho().getLblShukeiHoho();
    }

    @JsonIgnore
    public CheckBoxList getCblShutsuryokuAll() {
        return this.getTblShutsuryokuTaisho().getCblShutsuryokuAll();
    }

    @JsonIgnore
    public CheckBoxList getCblIppan1to10() {
        return this.getTblShutsuryokuTaisho().getCblIppan1to10();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM1() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiYM1();
    }

    @JsonIgnore
    public Label getLblShukeiType1() {
        return this.getTblShutsuryokuTaisho().getLblShukeiType1();
    }

    @JsonIgnore
    public Gassan1Div getGassan1() {
        return this.getTblShutsuryokuTaisho().getGassan1();
    }

    @JsonIgnore
    public CheckBoxList getCblGassan1() {
        return this.getTblShutsuryokuTaisho().getGassan1().getCblGassan1();
    }

    @JsonIgnore
    public void  setCblGassan1(CheckBoxList cblGassan1) {
        this.getTblShutsuryokuTaisho().getGassan1().setCblGassan1(cblGassan1);
    }

    @JsonIgnore
    public CheckBoxList getCblIppanGembutsu() {
        return this.getTblShutsuryokuTaisho().getCblIppanGembutsu();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM2() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiYM2();
    }

    @JsonIgnore
    public Label getLblShukeiType2() {
        return this.getTblShutsuryokuTaisho().getLblShukeiType2();
    }

    @JsonIgnore
    public CheckBoxList getCblIppanShokan() {
        return this.getTblShutsuryokuTaisho().getCblIppanShokan();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM3() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiYM3();
    }

    @JsonIgnore
    public RadioButton getRadShukeiType3() {
        return this.getTblShutsuryokuTaisho().getRadShukeiType3();
    }

    @JsonIgnore
    public Gassan2Div getGassan2() {
        return this.getTblShutsuryokuTaisho().getGassan2();
    }

    @JsonIgnore
    public CheckBoxList getCblGassan2() {
        return this.getTblShutsuryokuTaisho().getGassan2().getCblGassan2();
    }

    @JsonIgnore
    public void  setCblGassan2(CheckBoxList cblGassan2) {
        this.getTblShutsuryokuTaisho().getGassan2().setCblGassan2(cblGassan2);
    }

    @JsonIgnore
    public CheckBoxList getCblHokenKyufuGembutsu() {
        return this.getTblShutsuryokuTaisho().getCblHokenKyufuGembutsu();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM4() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiYM4();
    }

    @JsonIgnore
    public Label getLblShukeiType4() {
        return this.getTblShutsuryokuTaisho().getLblShukeiType4();
    }

    @JsonIgnore
    public CheckBoxList getCblHokenKyufuShokan() {
        return this.getTblShutsuryokuTaisho().getCblHokenKyufuShokan();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM5() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiYM5();
    }

    @JsonIgnore
    public RadioButton getRadShukeiType5() {
        return this.getTblShutsuryokuTaisho().getRadShukeiType5();
    }

    // </editor-fold>
}
