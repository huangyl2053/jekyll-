package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0010011;
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
 * JigyoJokyoHokokuGeppoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JigyoJokyoHokokuGeppoSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblJikkoTani")
    private tblJikkoTaniDiv tblJikkoTani;
    @JsonProperty("tblOutputTaisho")
    private tblOutputTaishoDiv tblOutputTaisho;
    @JsonProperty("shichosonKubun")
    private RString shichosonKubun;
    @JsonProperty("shichosonList")
    private RString shichosonList;
    @JsonProperty("txtShukeiYM4Bak")
    private RString txtShukeiYM4Bak;
    @JsonProperty("txtShukeiYM5Bak")
    private RString txtShukeiYM5Bak;
    @JsonProperty("kyuShichoson")
    private RString kyuShichoson;

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
     * gettblOutputTaisho
     * @return tblOutputTaisho
     */
    @JsonProperty("tblOutputTaisho")
    public tblOutputTaishoDiv getTblOutputTaisho() {
        return tblOutputTaisho;
    }

    /*
     * settblOutputTaisho
     * @param tblOutputTaisho tblOutputTaisho
     */
    @JsonProperty("tblOutputTaisho")
    public void setTblOutputTaisho(tblOutputTaishoDiv tblOutputTaisho) {
        this.tblOutputTaisho = tblOutputTaisho;
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
     * gettxtShukeiYM4Bak
     * @return txtShukeiYM4Bak
     */
    @JsonProperty("txtShukeiYM4Bak")
    public RString getTxtShukeiYM4Bak() {
        return txtShukeiYM4Bak;
    }

    /*
     * settxtShukeiYM4Bak
     * @param txtShukeiYM4Bak txtShukeiYM4Bak
     */
    @JsonProperty("txtShukeiYM4Bak")
    public void setTxtShukeiYM4Bak(RString txtShukeiYM4Bak) {
        this.txtShukeiYM4Bak = txtShukeiYM4Bak;
    }

    /*
     * gettxtShukeiYM5Bak
     * @return txtShukeiYM5Bak
     */
    @JsonProperty("txtShukeiYM5Bak")
    public RString getTxtShukeiYM5Bak() {
        return txtShukeiYM5Bak;
    }

    /*
     * settxtShukeiYM5Bak
     * @param txtShukeiYM5Bak txtShukeiYM5Bak
     */
    @JsonProperty("txtShukeiYM5Bak")
    public void setTxtShukeiYM5Bak(RString txtShukeiYM5Bak) {
        this.txtShukeiYM5Bak = txtShukeiYM5Bak;
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
    public TextBoxDate getTxtHokokuYM() {
        return this.getTblJikkoTani().getTxtHokokuYM();
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getTblJikkoTani().getBtnKakutei();
    }

    @JsonIgnore
    public RadioButton getRadJikkoTaniShukeiAfterPrint() {
        return this.getTblJikkoTani().getRadJikkoTaniShukeiAfterPrint();
    }

    @JsonIgnore
    public RadioButton getRadJikkoTaniKakoShukeiKekka() {
        return this.getTblJikkoTani().getRadJikkoTaniKakoShukeiKekka();
    }

    @JsonIgnore
    public DropDownList getDdlKakoHokokuYM() {
        return this.getTblJikkoTani().getDdlKakoHokokuYM();
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
    public Label getLblOutputTaishoTitle() {
        return this.getTblOutputTaisho().getLblOutputTaishoTitle();
    }

    @JsonIgnore
    public Label getLblShukeiHohoTitle() {
        return this.getTblOutputTaisho().getLblShukeiHohoTitle();
    }

    @JsonIgnore
    public Label getLblSakuseiDateTitle() {
        return this.getTblOutputTaisho().getLblSakuseiDateTitle();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaishoAll() {
        return this.getTblOutputTaisho().getCblOutputTaishoAll();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho1() {
        return this.getTblOutputTaisho().getCblOutputTaisho1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM1() {
        return this.getTblOutputTaisho().getTxtShukeiYM1();
    }

    @JsonIgnore
    public Label getLblShukeiType1() {
        return this.getTblOutputTaisho().getLblShukeiType1();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD1() {
        return this.getTblOutputTaisho().getTxtSakuseiYMD1();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime1() {
        return this.getTblOutputTaisho().getTxtSakuseiTime1();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho2() {
        return this.getTblOutputTaisho().getCblOutputTaisho2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM2() {
        return this.getTblOutputTaisho().getTxtShukeiYM2();
    }

    @JsonIgnore
    public Label getLblShukeiType2() {
        return this.getTblOutputTaisho().getLblShukeiType2();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD2() {
        return this.getTblOutputTaisho().getTxtSakuseiYMD2();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime2() {
        return this.getTblOutputTaisho().getTxtSakuseiTime2();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho3() {
        return this.getTblOutputTaisho().getCblOutputTaisho3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM3() {
        return this.getTblOutputTaisho().getTxtShukeiYM3();
    }

    @JsonIgnore
    public Label getLblShukeiType3() {
        return this.getTblOutputTaisho().getLblShukeiType3();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD3() {
        return this.getTblOutputTaisho().getTxtSakuseiYMD3();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime3() {
        return this.getTblOutputTaisho().getTxtSakuseiTime3();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho4() {
        return this.getTblOutputTaisho().getCblOutputTaisho4();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM4() {
        return this.getTblOutputTaisho().getTxtShukeiYM4();
    }

    @JsonIgnore
    public RadioButton getRadlblShukeiType4() {
        return this.getTblOutputTaisho().getRadlblShukeiType4();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD4() {
        return this.getTblOutputTaisho().getTxtSakuseiYMD4();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime4() {
        return this.getTblOutputTaisho().getTxtSakuseiTime4();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho5() {
        return this.getTblOutputTaisho().getCblOutputTaisho5();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM5() {
        return this.getTblOutputTaisho().getTxtShukeiYM5();
    }

    @JsonIgnore
    public RadioButton getRadlblShukeiType5() {
        return this.getTblOutputTaisho().getRadlblShukeiType5();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD5() {
        return this.getTblOutputTaisho().getTxtSakuseiYMD5();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime5() {
        return this.getTblOutputTaisho().getTxtSakuseiTime5();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho6() {
        return this.getTblOutputTaisho().getCblOutputTaisho6();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM6() {
        return this.getTblOutputTaisho().getTxtShukeiYM6();
    }

    @JsonIgnore
    public Label getLblShukeiType6() {
        return this.getTblOutputTaisho().getLblShukeiType6();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD6() {
        return this.getTblOutputTaisho().getTxtSakuseiYMD6();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime6() {
        return this.getTblOutputTaisho().getTxtSakuseiTime6();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho7() {
        return this.getTblOutputTaisho().getCblOutputTaisho7();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM7() {
        return this.getTblOutputTaisho().getTxtShukeiYM7();
    }

    @JsonIgnore
    public Label getLblShukeiType7() {
        return this.getTblOutputTaisho().getLblShukeiType7();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD7() {
        return this.getTblOutputTaisho().getTxtSakuseiYMD7();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime7() {
        return this.getTblOutputTaisho().getTxtSakuseiTime7();
    }

    // </editor-fold>
}
