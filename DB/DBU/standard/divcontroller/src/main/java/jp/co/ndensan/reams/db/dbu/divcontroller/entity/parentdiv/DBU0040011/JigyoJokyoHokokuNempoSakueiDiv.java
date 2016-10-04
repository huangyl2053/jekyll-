package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0040011;
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
 * JigyoJokyoHokokuNempoSakuei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JigyoJokyoHokokuNempoSakueiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblJikkoTani")
    private tblJikkoTaniDiv tblJikkoTani;
    @JsonProperty("tblShutsuryokuTaisho")
    private tblShutsuryokuTaishoDiv tblShutsuryokuTaisho;
    @JsonProperty("shichosonKubun")
    private RString shichosonKubun;
    @JsonProperty("shichosonList")
    private RString shichosonList;
    @JsonProperty("hiddenGappei")
    private RString hiddenGappei;
    @JsonProperty("hiddenKouiki")
    private RString hiddenKouiki;
    @JsonProperty("hiddenJikkoTaniZen")
    private RString hiddenJikkoTaniZen;
    @JsonProperty("hiddenShukeiFromYM5")
    private RString hiddenShukeiFromYM5;
    @JsonProperty("hiddenShukeiFromYM6")
    private RString hiddenShukeiFromYM6;
    @JsonProperty("hiddenShukeiToYM5")
    private RString hiddenShukeiToYM5;
    @JsonProperty("hiddenShukeiToYM6")
    private RString hiddenShukeiToYM6;
    @JsonProperty("kyuShichoson")
    private RString kyuShichoson;
    @JsonProperty("hiddenGappeiKoseiKubun")
    private RString hiddenGappeiKoseiKubun;
    @JsonProperty("hiddenDonyuKeitaiCode")
    private RString hiddenDonyuKeitaiCode;
    @JsonProperty("hiddenTanitsu")
    private RString hiddenTanitsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblJikkoTani
     * @return tblJikkoTani
     */
    @JsonProperty("tblJikkoTani")
    public tblJikkoTaniDiv getTblJikkoTani() {
        return tblJikkoTani;
    }

    /*
     * settblJikkoTani
     * @param tblJikkoTani tblJikkoTani
     */
    @JsonProperty("tblJikkoTani")
    public void setTblJikkoTani(tblJikkoTaniDiv tblJikkoTani) {
        this.tblJikkoTani = tblJikkoTani;
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
     * getshichosonKubun
     * @return shichosonKubun
     */
    @JsonProperty("shichosonKubun")
    public RString getShichosonKubun() {
        return shichosonKubun;
    }

    /*
     * setshichosonKubun
     * @param shichosonKubun shichosonKubun
     */
    @JsonProperty("shichosonKubun")
    public void setShichosonKubun(RString shichosonKubun) {
        this.shichosonKubun = shichosonKubun;
    }

    /*
     * getshichosonList
     * @return shichosonList
     */
    @JsonProperty("shichosonList")
    public RString getShichosonList() {
        return shichosonList;
    }

    /*
     * setshichosonList
     * @param shichosonList shichosonList
     */
    @JsonProperty("shichosonList")
    public void setShichosonList(RString shichosonList) {
        this.shichosonList = shichosonList;
    }

    /*
     * gethiddenGappei
     * @return hiddenGappei
     */
    @JsonProperty("hiddenGappei")
    public RString getHiddenGappei() {
        return hiddenGappei;
    }

    /*
     * sethiddenGappei
     * @param hiddenGappei hiddenGappei
     */
    @JsonProperty("hiddenGappei")
    public void setHiddenGappei(RString hiddenGappei) {
        this.hiddenGappei = hiddenGappei;
    }

    /*
     * gethiddenKouiki
     * @return hiddenKouiki
     */
    @JsonProperty("hiddenKouiki")
    public RString getHiddenKouiki() {
        return hiddenKouiki;
    }

    /*
     * sethiddenKouiki
     * @param hiddenKouiki hiddenKouiki
     */
    @JsonProperty("hiddenKouiki")
    public void setHiddenKouiki(RString hiddenKouiki) {
        this.hiddenKouiki = hiddenKouiki;
    }

    /*
     * gethiddenJikkoTaniZen
     * @return hiddenJikkoTaniZen
     */
    @JsonProperty("hiddenJikkoTaniZen")
    public RString getHiddenJikkoTaniZen() {
        return hiddenJikkoTaniZen;
    }

    /*
     * sethiddenJikkoTaniZen
     * @param hiddenJikkoTaniZen hiddenJikkoTaniZen
     */
    @JsonProperty("hiddenJikkoTaniZen")
    public void setHiddenJikkoTaniZen(RString hiddenJikkoTaniZen) {
        this.hiddenJikkoTaniZen = hiddenJikkoTaniZen;
    }

    /*
     * gethiddenShukeiFromYM5
     * @return hiddenShukeiFromYM5
     */
    @JsonProperty("hiddenShukeiFromYM5")
    public RString getHiddenShukeiFromYM5() {
        return hiddenShukeiFromYM5;
    }

    /*
     * sethiddenShukeiFromYM5
     * @param hiddenShukeiFromYM5 hiddenShukeiFromYM5
     */
    @JsonProperty("hiddenShukeiFromYM5")
    public void setHiddenShukeiFromYM5(RString hiddenShukeiFromYM5) {
        this.hiddenShukeiFromYM5 = hiddenShukeiFromYM5;
    }

    /*
     * gethiddenShukeiFromYM6
     * @return hiddenShukeiFromYM6
     */
    @JsonProperty("hiddenShukeiFromYM6")
    public RString getHiddenShukeiFromYM6() {
        return hiddenShukeiFromYM6;
    }

    /*
     * sethiddenShukeiFromYM6
     * @param hiddenShukeiFromYM6 hiddenShukeiFromYM6
     */
    @JsonProperty("hiddenShukeiFromYM6")
    public void setHiddenShukeiFromYM6(RString hiddenShukeiFromYM6) {
        this.hiddenShukeiFromYM6 = hiddenShukeiFromYM6;
    }

    /*
     * gethiddenShukeiToYM5
     * @return hiddenShukeiToYM5
     */
    @JsonProperty("hiddenShukeiToYM5")
    public RString getHiddenShukeiToYM5() {
        return hiddenShukeiToYM5;
    }

    /*
     * sethiddenShukeiToYM5
     * @param hiddenShukeiToYM5 hiddenShukeiToYM5
     */
    @JsonProperty("hiddenShukeiToYM5")
    public void setHiddenShukeiToYM5(RString hiddenShukeiToYM5) {
        this.hiddenShukeiToYM5 = hiddenShukeiToYM5;
    }

    /*
     * gethiddenShukeiToYM6
     * @return hiddenShukeiToYM6
     */
    @JsonProperty("hiddenShukeiToYM6")
    public RString getHiddenShukeiToYM6() {
        return hiddenShukeiToYM6;
    }

    /*
     * sethiddenShukeiToYM6
     * @param hiddenShukeiToYM6 hiddenShukeiToYM6
     */
    @JsonProperty("hiddenShukeiToYM6")
    public void setHiddenShukeiToYM6(RString hiddenShukeiToYM6) {
        this.hiddenShukeiToYM6 = hiddenShukeiToYM6;
    }

    /*
     * getkyuShichoson
     * @return kyuShichoson
     */
    @JsonProperty("kyuShichoson")
    public RString getKyuShichoson() {
        return kyuShichoson;
    }

    /*
     * setkyuShichoson
     * @param kyuShichoson kyuShichoson
     */
    @JsonProperty("kyuShichoson")
    public void setKyuShichoson(RString kyuShichoson) {
        this.kyuShichoson = kyuShichoson;
    }

    /*
     * gethiddenGappeiKoseiKubun
     * @return hiddenGappeiKoseiKubun
     */
    @JsonProperty("hiddenGappeiKoseiKubun")
    public RString getHiddenGappeiKoseiKubun() {
        return hiddenGappeiKoseiKubun;
    }

    /*
     * sethiddenGappeiKoseiKubun
     * @param hiddenGappeiKoseiKubun hiddenGappeiKoseiKubun
     */
    @JsonProperty("hiddenGappeiKoseiKubun")
    public void setHiddenGappeiKoseiKubun(RString hiddenGappeiKoseiKubun) {
        this.hiddenGappeiKoseiKubun = hiddenGappeiKoseiKubun;
    }

    /*
     * gethiddenDonyuKeitaiCode
     * @return hiddenDonyuKeitaiCode
     */
    @JsonProperty("hiddenDonyuKeitaiCode")
    public RString getHiddenDonyuKeitaiCode() {
        return hiddenDonyuKeitaiCode;
    }

    /*
     * sethiddenDonyuKeitaiCode
     * @param hiddenDonyuKeitaiCode hiddenDonyuKeitaiCode
     */
    @JsonProperty("hiddenDonyuKeitaiCode")
    public void setHiddenDonyuKeitaiCode(RString hiddenDonyuKeitaiCode) {
        this.hiddenDonyuKeitaiCode = hiddenDonyuKeitaiCode;
    }

    /*
     * gethiddenTanitsu
     * @return hiddenTanitsu
     */
    @JsonProperty("hiddenTanitsu")
    public RString getHiddenTanitsu() {
        return hiddenTanitsu;
    }

    /*
     * sethiddenTanitsu
     * @param hiddenTanitsu hiddenTanitsu
     */
    @JsonProperty("hiddenTanitsu")
    public void setHiddenTanitsu(RString hiddenTanitsu) {
        this.hiddenTanitsu = hiddenTanitsu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblJikkoTaniTitle() {
        return this.getTblJikkoTani().getLblJikkoTaniTitle();
    }

    @JsonIgnore
    public RadioButton getRadJikkoTaniShukeiOnly() {
        return this.getTblJikkoTani().getRadJikkoTaniShukeiOnly();
    }

    @JsonIgnore
    public HokokuNendoDiv getHokokuNendo() {
        return this.getTblJikkoTani().getHokokuNendo();
    }

    @JsonIgnore
    public DropDownList getDdlHokokuNendo() {
        return this.getTblJikkoTani().getHokokuNendo().getDdlHokokuNendo();
    }

    @JsonIgnore
    public void  setDdlHokokuNendo(DropDownList ddlHokokuNendo) {
        this.getTblJikkoTani().getHokokuNendo().setDdlHokokuNendo(ddlHokokuNendo);
    }

    @JsonIgnore
    public Label getLblHokokuYM() {
        return this.getTblJikkoTani().getHokokuNendo().getLblHokokuYM();
    }

    @JsonIgnore
    public void  setLblHokokuYM(Label lblHokokuYM) {
        this.getTblJikkoTani().getHokokuNendo().setLblHokokuYM(lblHokokuYM);
    }

    @JsonIgnore
    public DropDownList getDdlShukeiFromYM() {
        return this.getTblJikkoTani().getHokokuNendo().getDdlShukeiFromYM();
    }

    @JsonIgnore
    public void  setDdlShukeiFromYM(DropDownList ddlShukeiFromYM) {
        this.getTblJikkoTani().getHokokuNendo().setDdlShukeiFromYM(ddlShukeiFromYM);
    }

    @JsonIgnore
    public Label getLblShukeiHani() {
        return this.getTblJikkoTani().getHokokuNendo().getLblShukeiHani();
    }

    @JsonIgnore
    public void  setLblShukeiHani(Label lblShukeiHani) {
        this.getTblJikkoTani().getHokokuNendo().setLblShukeiHani(lblShukeiHani);
    }

    @JsonIgnore
    public DropDownList getDdlShukeiToYM() {
        return this.getTblJikkoTani().getHokokuNendo().getDdlShukeiToYM();
    }

    @JsonIgnore
    public void  setDdlShukeiToYM(DropDownList ddlShukeiToYM) {
        this.getTblJikkoTani().getHokokuNendo().setDdlShukeiToYM(ddlShukeiToYM);
    }

    @JsonIgnore
    public RadioButton getRadJikkoTani2() {
        return this.getTblJikkoTani().getRadJikkoTani2();
    }

    @JsonIgnore
    public RadioButton getRadJikkoTani3() {
        return this.getTblJikkoTani().getRadJikkoTani3();
    }

    @JsonIgnore
    public DropDownList getDdlKakoHokokuNendo() {
        return this.getTblJikkoTani().getDdlKakoHokokuNendo();
    }

    @JsonIgnore
    public RadioButton getRadGappeiShichoson() {
        return this.getTblJikkoTani().getRadGappeiShichoson();
    }

    @JsonIgnore
    public RadioButton getRadKoikiRengo() {
        return this.getTblJikkoTani().getRadKoikiRengo();
    }

    @JsonIgnore
    public ButtonDialog getBtnShichosonSelect() {
        return this.getTblJikkoTani().getBtnShichosonSelect();
    }

    @JsonIgnore
    public Label getLblShutsuryokuTaisho() {
        return this.getTblShutsuryokuTaisho().getLblShutsuryokuTaisho();
    }

    @JsonIgnore
    public Label getLblShukeiHohoTitle() {
        return this.getTblShutsuryokuTaisho().getLblShukeiHohoTitle();
    }

    @JsonIgnore
    public Label getLblSakuseiDateTitle() {
        return this.getTblShutsuryokuTaisho().getLblSakuseiDateTitle();
    }

    @JsonIgnore
    public CheckBoxList getCblShutsuryokuTaishoAll() {
        return this.getTblShutsuryokuTaisho().getCblShutsuryokuTaishoAll();
    }

    @JsonIgnore
    public CheckBoxList getCblShutsuryokuTaishoYoshiki1() {
        return this.getTblShutsuryokuTaisho().getCblShutsuryokuTaishoYoshiki1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxttxtShukeiNendo1() {
        return this.getTblShutsuryokuTaisho().getTxttxtShukeiNendo1();
    }

    @JsonIgnore
    public Label getLblShukeiKikan1() {
        return this.getTblShutsuryokuTaisho().getLblShukeiKikan1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiFromYM1() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiFromYM1();
    }

    @JsonIgnore
    public Label getLblShukeiHani21() {
        return this.getTblShutsuryokuTaisho().getLblShukeiHani21();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiToYM1() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiToYM1();
    }

    @JsonIgnore
    public Label getLblShukeiType1() {
        return this.getTblShutsuryokuTaisho().getLblShukeiType1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiYMD1() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiYMD1();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime1() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiTime1();
    }

    @JsonIgnore
    public CheckBoxList getCblShutsuryokuTaishoIppan1to11() {
        return this.getTblShutsuryokuTaisho().getCblShutsuryokuTaishoIppan1to11();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiNendo2() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiNendo2();
    }

    @JsonIgnore
    public Label getLblShukeiKikan2() {
        return this.getTblShutsuryokuTaisho().getLblShukeiKikan2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiFromYM2() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiFromYM2();
    }

    @JsonIgnore
    public Label getLblShukeiHani22() {
        return this.getTblShutsuryokuTaisho().getLblShukeiHani22();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiToYM2() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiToYM2();
    }

    @JsonIgnore
    public Label getLblShukeiType2() {
        return this.getTblShutsuryokuTaisho().getLblShukeiType2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiYMD2() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiYMD2();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime2() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiTime2();
    }

    @JsonIgnore
    public CheckBoxList getCblShutsuryokuTaishoIppanGembutsu() {
        return this.getTblShutsuryokuTaisho().getCblShutsuryokuTaishoIppanGembutsu();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiNendo3() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiNendo3();
    }

    @JsonIgnore
    public Label getLblShukeiKikan3() {
        return this.getTblShutsuryokuTaisho().getLblShukeiKikan3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiFromYM3() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiFromYM3();
    }

    @JsonIgnore
    public Label getLblShukeiHani23() {
        return this.getTblShutsuryokuTaisho().getLblShukeiHani23();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiToYM3() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiToYM3();
    }

    @JsonIgnore
    public Label getLblShukeiType3() {
        return this.getTblShutsuryokuTaisho().getLblShukeiType3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiYMD3() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiYMD3();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime3() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiTime3();
    }

    @JsonIgnore
    public CheckBoxList getCblShutsuryokuTaishoHokenGembutsu() {
        return this.getTblShutsuryokuTaisho().getCblShutsuryokuTaishoHokenGembutsu();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiNendo4() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiNendo4();
    }

    @JsonIgnore
    public Label getLblShukeiKikan4() {
        return this.getTblShutsuryokuTaisho().getLblShukeiKikan4();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiFromYM4() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiFromYM4();
    }

    @JsonIgnore
    public Label getLblShukeiHani24() {
        return this.getTblShutsuryokuTaisho().getLblShukeiHani24();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiToYM4() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiToYM4();
    }

    @JsonIgnore
    public Label getLblShukeiType4() {
        return this.getTblShutsuryokuTaisho().getLblShukeiType4();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiYMD4() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiYMD4();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime4() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiTime4();
    }

    @JsonIgnore
    public ShutsuryokuTaishoIppanShokanDiv getShutsuryokuTaishoIppanShokan() {
        return this.getTblShutsuryokuTaisho().getShutsuryokuTaishoIppanShokan();
    }

    @JsonIgnore
    public CheckBoxList getCblShutsuryokuTaishoIppanShokan() {
        return this.getTblShutsuryokuTaisho().getShutsuryokuTaishoIppanShokan().getCblShutsuryokuTaishoIppanShokan();
    }

    @JsonIgnore
    public void  setCblShutsuryokuTaishoIppanShokan(CheckBoxList cblShutsuryokuTaishoIppanShokan) {
        this.getTblShutsuryokuTaisho().getShutsuryokuTaishoIppanShokan().setCblShutsuryokuTaishoIppanShokan(cblShutsuryokuTaishoIppanShokan);
    }

    @JsonIgnore
    public ShukeiYM5Div getShukeiYM5() {
        return this.getTblShutsuryokuTaisho().getShukeiYM5();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiNendo5() {
        return this.getTblShutsuryokuTaisho().getShukeiYM5().getTxtShukeiNendo5();
    }

    @JsonIgnore
    public void  setTxtShukeiNendo5(TextBoxFlexibleDate txtShukeiNendo5) {
        this.getTblShutsuryokuTaisho().getShukeiYM5().setTxtShukeiNendo5(txtShukeiNendo5);
    }

    @JsonIgnore
    public Label getLblShukeiKikan5() {
        return this.getTblShutsuryokuTaisho().getShukeiYM5().getLblShukeiKikan5();
    }

    @JsonIgnore
    public void  setLblShukeiKikan5(Label lblShukeiKikan5) {
        this.getTblShutsuryokuTaisho().getShukeiYM5().setLblShukeiKikan5(lblShukeiKikan5);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiFromYM5() {
        return this.getTblShutsuryokuTaisho().getShukeiYM5().getTxtShukeiFromYM5();
    }

    @JsonIgnore
    public void  setTxtShukeiFromYM5(TextBoxFlexibleDate txtShukeiFromYM5) {
        this.getTblShutsuryokuTaisho().getShukeiYM5().setTxtShukeiFromYM5(txtShukeiFromYM5);
    }

    @JsonIgnore
    public Label getLblShukeiHani25() {
        return this.getTblShutsuryokuTaisho().getShukeiYM5().getLblShukeiHani25();
    }

    @JsonIgnore
    public void  setLblShukeiHani25(Label lblShukeiHani25) {
        this.getTblShutsuryokuTaisho().getShukeiYM5().setLblShukeiHani25(lblShukeiHani25);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiToYM5() {
        return this.getTblShutsuryokuTaisho().getShukeiYM5().getTxtShukeiToYM5();
    }

    @JsonIgnore
    public void  setTxtShukeiToYM5(TextBoxFlexibleDate txtShukeiToYM5) {
        this.getTblShutsuryokuTaisho().getShukeiYM5().setTxtShukeiToYM5(txtShukeiToYM5);
    }

    @JsonIgnore
    public RadioButton getRadlblShukeiType4() {
        return this.getTblShutsuryokuTaisho().getRadlblShukeiType4();
    }

    @JsonIgnore
    public SakuseiDate5Div getSakuseiDate5() {
        return this.getTblShutsuryokuTaisho().getSakuseiDate5();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiYMD5() {
        return this.getTblShutsuryokuTaisho().getSakuseiDate5().getTxtSakuseiYMD5();
    }

    @JsonIgnore
    public void  setTxtSakuseiYMD5(TextBoxFlexibleDate txtSakuseiYMD5) {
        this.getTblShutsuryokuTaisho().getSakuseiDate5().setTxtSakuseiYMD5(txtSakuseiYMD5);
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime5() {
        return this.getTblShutsuryokuTaisho().getSakuseiDate5().getTxtSakuseiTime5();
    }

    @JsonIgnore
    public void  setTxtSakuseiTime5(TextBoxTime txtSakuseiTime5) {
        this.getTblShutsuryokuTaisho().getSakuseiDate5().setTxtSakuseiTime5(txtSakuseiTime5);
    }

    @JsonIgnore
    public ShutsuryokuTaishoHokenShokanDiv getShutsuryokuTaishoHokenShokan() {
        return this.getTblShutsuryokuTaisho().getShutsuryokuTaishoHokenShokan();
    }

    @JsonIgnore
    public CheckBoxList getCblShutsuryokuTaishoHokenShokan() {
        return this.getTblShutsuryokuTaisho().getShutsuryokuTaishoHokenShokan().getCblShutsuryokuTaishoHokenShokan();
    }

    @JsonIgnore
    public void  setCblShutsuryokuTaishoHokenShokan(CheckBoxList cblShutsuryokuTaishoHokenShokan) {
        this.getTblShutsuryokuTaisho().getShutsuryokuTaishoHokenShokan().setCblShutsuryokuTaishoHokenShokan(cblShutsuryokuTaishoHokenShokan);
    }

    @JsonIgnore
    public ShukeiYM6Div getShukeiYM6() {
        return this.getTblShutsuryokuTaisho().getShukeiYM6();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiNendo6() {
        return this.getTblShutsuryokuTaisho().getShukeiYM6().getTxtShukeiNendo6();
    }

    @JsonIgnore
    public void  setTxtShukeiNendo6(TextBoxFlexibleDate txtShukeiNendo6) {
        this.getTblShutsuryokuTaisho().getShukeiYM6().setTxtShukeiNendo6(txtShukeiNendo6);
    }

    @JsonIgnore
    public Label getLblShukeiKikan6() {
        return this.getTblShutsuryokuTaisho().getShukeiYM6().getLblShukeiKikan6();
    }

    @JsonIgnore
    public void  setLblShukeiKikan6(Label lblShukeiKikan6) {
        this.getTblShutsuryokuTaisho().getShukeiYM6().setLblShukeiKikan6(lblShukeiKikan6);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiFromYM6() {
        return this.getTblShutsuryokuTaisho().getShukeiYM6().getTxtShukeiFromYM6();
    }

    @JsonIgnore
    public void  setTxtShukeiFromYM6(TextBoxFlexibleDate txtShukeiFromYM6) {
        this.getTblShutsuryokuTaisho().getShukeiYM6().setTxtShukeiFromYM6(txtShukeiFromYM6);
    }

    @JsonIgnore
    public Label getLblShukeiHani26() {
        return this.getTblShutsuryokuTaisho().getShukeiYM6().getLblShukeiHani26();
    }

    @JsonIgnore
    public void  setLblShukeiHani26(Label lblShukeiHani26) {
        this.getTblShutsuryokuTaisho().getShukeiYM6().setLblShukeiHani26(lblShukeiHani26);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiToYM6() {
        return this.getTblShutsuryokuTaisho().getShukeiYM6().getTxtShukeiToYM6();
    }

    @JsonIgnore
    public void  setTxtShukeiToYM6(TextBoxFlexibleDate txtShukeiToYM6) {
        this.getTblShutsuryokuTaisho().getShukeiYM6().setTxtShukeiToYM6(txtShukeiToYM6);
    }

    @JsonIgnore
    public RadioButton getRadlblShukeiType5() {
        return this.getTblShutsuryokuTaisho().getRadlblShukeiType5();
    }

    @JsonIgnore
    public SakuseiDate6Div getSakuseiDate6() {
        return this.getTblShutsuryokuTaisho().getSakuseiDate6();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiYMD6() {
        return this.getTblShutsuryokuTaisho().getSakuseiDate6().getTxtSakuseiYMD6();
    }

    @JsonIgnore
    public void  setTxtSakuseiYMD6(TextBoxFlexibleDate txtSakuseiYMD6) {
        this.getTblShutsuryokuTaisho().getSakuseiDate6().setTxtSakuseiYMD6(txtSakuseiYMD6);
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime6() {
        return this.getTblShutsuryokuTaisho().getSakuseiDate6().getTxtSakuseiTime6();
    }

    @JsonIgnore
    public void  setTxtSakuseiTime6(TextBoxTime txtSakuseiTime6) {
        this.getTblShutsuryokuTaisho().getSakuseiDate6().setTxtSakuseiTime6(txtSakuseiTime6);
    }

    @JsonIgnore
    public CheckBoxList getCblShutsuryokuTaishoHokenKogaku() {
        return this.getTblShutsuryokuTaisho().getCblShutsuryokuTaishoHokenKogaku();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiNendo7() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiNendo7();
    }

    @JsonIgnore
    public Label getLblShukeiKikan7() {
        return this.getTblShutsuryokuTaisho().getLblShukeiKikan7();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiFromYM7() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiFromYM7();
    }

    @JsonIgnore
    public Label getLblShukeiHani27() {
        return this.getTblShutsuryokuTaisho().getLblShukeiHani27();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiToYM7() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiToYM7();
    }

    @JsonIgnore
    public Label getLblShukeiType8() {
        return this.getTblShutsuryokuTaisho().getLblShukeiType8();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiYMD7() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiYMD7();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime7() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiTime7();
    }

    @JsonIgnore
    public CheckBoxList getCblShutsuryokuTaishoHokenKogakuGassan() {
        return this.getTblShutsuryokuTaisho().getCblShutsuryokuTaishoHokenKogakuGassan();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiNendo8() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiNendo8();
    }

    @JsonIgnore
    public Label getLblShukeiKikan8() {
        return this.getTblShutsuryokuTaisho().getLblShukeiKikan8();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiFromYM8() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiFromYM8();
    }

    @JsonIgnore
    public Label getLblShukeiHani28() {
        return this.getTblShutsuryokuTaisho().getLblShukeiHani28();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiToYM8() {
        return this.getTblShutsuryokuTaisho().getTxtShukeiToYM8();
    }

    @JsonIgnore
    public Label getLblShukeiType9() {
        return this.getTblShutsuryokuTaisho().getLblShukeiType9();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiYMD8() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiYMD8();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime8() {
        return this.getTblShutsuryokuTaisho().getTxtSakuseiTime8();
    }

    // </editor-fold>
}
