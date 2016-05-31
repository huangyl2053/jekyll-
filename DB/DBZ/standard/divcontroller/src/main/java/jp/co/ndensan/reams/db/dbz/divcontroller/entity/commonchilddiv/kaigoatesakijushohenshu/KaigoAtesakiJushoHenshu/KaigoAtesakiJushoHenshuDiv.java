package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushohenshu.KaigoAtesakiJushoHenshu;
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
 * KaigoAtesakiJushoHenshu のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoAtesakiJushoHenshuDiv extends Panel implements IKaigoAtesakiJushoHenshuDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JushoHenshu1")
    private JushoHenshu1Div JushoHenshu1;
    @JsonProperty("JushoHenshu2")
    private JushoHenshu2Div JushoHenshu2;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("hdnTodofukenMei")
    private RString hdnTodofukenMei;
    @JsonProperty("hdnGunMei")
    private RString hdnGunMei;
    @JsonProperty("hdnShichosonMei")
    private RString hdnShichosonMei;
    @JsonProperty("hdnHensyuHoho")
    private RString hdnHensyuHoho;
    @JsonProperty("hdnKatagaki")
    private RString hdnKatagaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJushoHenshu1
     * @return JushoHenshu1
     */
    @JsonProperty("JushoHenshu1")
    public JushoHenshu1Div getJushoHenshu1() {
        return JushoHenshu1;
    }

    /*
     * setJushoHenshu1
     * @param JushoHenshu1 JushoHenshu1
     */
    @JsonProperty("JushoHenshu1")
    public void setJushoHenshu1(JushoHenshu1Div JushoHenshu1) {
        this.JushoHenshu1 = JushoHenshu1;
    }

    /*
     * getJushoHenshu2
     * @return JushoHenshu2
     */
    @JsonProperty("JushoHenshu2")
    public JushoHenshu2Div getJushoHenshu2() {
        return JushoHenshu2;
    }

    /*
     * setJushoHenshu2
     * @param JushoHenshu2 JushoHenshu2
     */
    @JsonProperty("JushoHenshu2")
    public void setJushoHenshu2(JushoHenshu2Div JushoHenshu2) {
        this.JushoHenshu2 = JushoHenshu2;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * gethdnTodofukenMei
     * @return hdnTodofukenMei
     */
    @JsonProperty("hdnTodofukenMei")
    public RString getHdnTodofukenMei() {
        return hdnTodofukenMei;
    }

    /*
     * sethdnTodofukenMei
     * @param hdnTodofukenMei hdnTodofukenMei
     */
    @JsonProperty("hdnTodofukenMei")
    public void setHdnTodofukenMei(RString hdnTodofukenMei) {
        this.hdnTodofukenMei = hdnTodofukenMei;
    }

    /*
     * gethdnGunMei
     * @return hdnGunMei
     */
    @JsonProperty("hdnGunMei")
    public RString getHdnGunMei() {
        return hdnGunMei;
    }

    /*
     * sethdnGunMei
     * @param hdnGunMei hdnGunMei
     */
    @JsonProperty("hdnGunMei")
    public void setHdnGunMei(RString hdnGunMei) {
        this.hdnGunMei = hdnGunMei;
    }

    /*
     * gethdnShichosonMei
     * @return hdnShichosonMei
     */
    @JsonProperty("hdnShichosonMei")
    public RString getHdnShichosonMei() {
        return hdnShichosonMei;
    }

    /*
     * sethdnShichosonMei
     * @param hdnShichosonMei hdnShichosonMei
     */
    @JsonProperty("hdnShichosonMei")
    public void setHdnShichosonMei(RString hdnShichosonMei) {
        this.hdnShichosonMei = hdnShichosonMei;
    }

    /*
     * gethdnHensyuHoho
     * @return hdnHensyuHoho
     */
    @JsonProperty("hdnHensyuHoho")
    public RString getHdnHensyuHoho() {
        return hdnHensyuHoho;
    }

    /*
     * sethdnHensyuHoho
     * @param hdnHensyuHoho hdnHensyuHoho
     */
    @JsonProperty("hdnHensyuHoho")
    public void setHdnHensyuHoho(RString hdnHensyuHoho) {
        this.hdnHensyuHoho = hdnHensyuHoho;
    }

    /*
     * gethdnKatagaki
     * @return hdnKatagaki
     */
    @JsonProperty("hdnKatagaki")
    public RString getHdnKatagaki() {
        return hdnKatagaki;
    }

    /*
     * sethdnKatagaki
     * @param hdnKatagaki hdnKatagaki
     */
    @JsonProperty("hdnKatagaki")
    public void setHdnKatagaki(RString hdnKatagaki) {
        this.hdnKatagaki = hdnKatagaki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadKenmeiHyojiUmu() {
        return this.getJushoHenshu1().getRadKenmeiHyojiUmu();
    }

    @JsonIgnore
    public void  setRadKenmeiHyojiUmu(RadioButton radKenmeiHyojiUmu) {
        this.getJushoHenshu1().setRadKenmeiHyojiUmu(radKenmeiHyojiUmu);
    }

    @JsonIgnore
    public RadioButton getRadGunmeiHyojiUmu() {
        return this.getJushoHenshu1().getRadGunmeiHyojiUmu();
    }

    @JsonIgnore
    public void  setRadGunmeiHyojiUmu(RadioButton radGunmeiHyojiUmu) {
        this.getJushoHenshu1().setRadGunmeiHyojiUmu(radGunmeiHyojiUmu);
    }

    @JsonIgnore
    public RadioButton getRadCitymeiHyojiUmu() {
        return this.getJushoHenshu1().getRadCitymeiHyojiUmu();
    }

    @JsonIgnore
    public void  setRadCitymeiHyojiUmu(RadioButton radCitymeiHyojiUmu) {
        this.getJushoHenshu1().setRadCitymeiHyojiUmu(radCitymeiHyojiUmu);
    }

    @JsonIgnore
    public DropDownList getDdlChoikiHenshu() {
        return this.getJushoHenshu2().getDdlChoikiHenshu();
    }

    @JsonIgnore
    public void  setDdlChoikiHenshu(DropDownList ddlChoikiHenshu) {
        this.getJushoHenshu2().setDdlChoikiHenshu(ddlChoikiHenshu);
    }

    @JsonIgnore
    public RadioButton getRadKatagakiHyojiUmu() {
        return this.getJushoHenshu2().getRadKatagakiHyojiUmu();
    }

    @JsonIgnore
    public void  setRadKatagakiHyojiUmu(RadioButton radKatagakiHyojiUmu) {
        this.getJushoHenshu2().setRadKatagakiHyojiUmu(radKatagakiHyojiUmu);
    }

    @JsonIgnore
    public Space getSpaceJusho() {
        return this.getJushoHenshu2().getSpaceJusho();
    }

    @JsonIgnore
    public void  setSpaceJusho(Space SpaceJusho) {
        this.getJushoHenshu2().setSpaceJusho(SpaceJusho);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
