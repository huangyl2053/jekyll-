package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKaigoSonotaConfigInfoDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.BarCodeDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.HyojiCodeBusuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.HyojiCodeNameDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.InnojiBusuInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SonotaConfigInfo2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SonotaConfigInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoSonotaConfigInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoSonotaConfigInfoDiv extends Panel implements IKaigoSonotaConfigInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HyojiCodeBusu")
    private HyojiCodeBusuDiv HyojiCodeBusu;
    @JsonProperty("SonotaConfigInfo")
    private SonotaConfigInfoDiv SonotaConfigInfo;
    @JsonProperty("SonotaConfigInfo2")
    private SonotaConfigInfo2Div SonotaConfigInfo2;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("BarCode")
    private BarCodeDiv BarCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HyojiCodeBusu")
    public HyojiCodeBusuDiv getHyojiCodeBusu() {
        return HyojiCodeBusu;
    }

    @JsonProperty("HyojiCodeBusu")
    public void setHyojiCodeBusu(HyojiCodeBusuDiv HyojiCodeBusu) {
        this.HyojiCodeBusu=HyojiCodeBusu;
    }

    @JsonProperty("SonotaConfigInfo")
    public SonotaConfigInfoDiv getSonotaConfigInfo() {
        return SonotaConfigInfo;
    }

    @JsonProperty("SonotaConfigInfo")
    public void setSonotaConfigInfo(SonotaConfigInfoDiv SonotaConfigInfo) {
        this.SonotaConfigInfo=SonotaConfigInfo;
    }

    @JsonProperty("SonotaConfigInfo2")
    public SonotaConfigInfo2Div getSonotaConfigInfo2() {
        return SonotaConfigInfo2;
    }

    @JsonProperty("SonotaConfigInfo2")
    public void setSonotaConfigInfo2(SonotaConfigInfo2Div SonotaConfigInfo2) {
        this.SonotaConfigInfo2=SonotaConfigInfo2;
    }

    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1=lin1;
    }

    @JsonProperty("BarCode")
    public BarCodeDiv getBarCode() {
        return BarCode;
    }

    @JsonProperty("BarCode")
    public void setBarCode(BarCodeDiv BarCode) {
        this.BarCode=BarCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HyojiCodeNameDiv getHyojiCodeName() {
        return this.getHyojiCodeBusu().getHyojiCodeName();
    }

    @JsonIgnore
    public void  setHyojiCodeName(HyojiCodeNameDiv HyojiCodeName) {
        this.getHyojiCodeBusu().setHyojiCodeName(HyojiCodeName);
    }

    @JsonIgnore
    public DropDownList getDdlHyojiCodeName1() {
        return this.getHyojiCodeBusu().getHyojiCodeName().getDdlHyojiCodeName1();
    }

    @JsonIgnore
    public void  setDdlHyojiCodeName1(DropDownList ddlHyojiCodeName1) {
        this.getHyojiCodeBusu().getHyojiCodeName().setDdlHyojiCodeName1(ddlHyojiCodeName1);
    }

    @JsonIgnore
    public DropDownList getDdlHyojiCodeName2() {
        return this.getHyojiCodeBusu().getHyojiCodeName().getDdlHyojiCodeName2();
    }

    @JsonIgnore
    public void  setDdlHyojiCodeName2(DropDownList ddlHyojiCodeName2) {
        this.getHyojiCodeBusu().getHyojiCodeName().setDdlHyojiCodeName2(ddlHyojiCodeName2);
    }

    @JsonIgnore
    public DropDownList getDdlHyojiCodeName3() {
        return this.getHyojiCodeBusu().getHyojiCodeName().getDdlHyojiCodeName3();
    }

    @JsonIgnore
    public void  setDdlHyojiCodeName3(DropDownList ddlHyojiCodeName3) {
        this.getHyojiCodeBusu().getHyojiCodeName().setDdlHyojiCodeName3(ddlHyojiCodeName3);
    }

    @JsonIgnore
    public InnojiBusuInputDiv getInnojiBusuInput() {
        return this.getHyojiCodeBusu().getInnojiBusuInput();
    }

    @JsonIgnore
    public void  setInnojiBusuInput(InnojiBusuInputDiv InnojiBusuInput) {
        this.getHyojiCodeBusu().setInnojiBusuInput(InnojiBusuInput);
    }

    @JsonIgnore
    public TextBox getTxtInnojiCrtl() {
        return this.getHyojiCodeBusu().getInnojiBusuInput().getTxtInnojiCrtl();
    }

    @JsonIgnore
    public void  setTxtInnojiCrtl(TextBox txtInnojiCrtl) {
        this.getHyojiCodeBusu().getInnojiBusuInput().setTxtInnojiCrtl(txtInnojiCrtl);
    }

    @JsonIgnore
    public TextBox getTxtHakkoBusu() {
        return this.getHyojiCodeBusu().getInnojiBusuInput().getTxtHakkoBusu();
    }

    @JsonIgnore
    public void  setTxtHakkoBusu(TextBox txtHakkoBusu) {
        this.getHyojiCodeBusu().getInnojiBusuInput().setTxtHakkoBusu(txtHakkoBusu);
    }

    @JsonIgnore
    public RadioButton getRadBatchHakkoUmu() {
        return this.getSonotaConfigInfo2().getRadBatchHakkoUmu();
    }

    @JsonIgnore
    public void  setRadBatchHakkoUmu(RadioButton radBatchHakkoUmu) {
        this.getSonotaConfigInfo2().setRadBatchHakkoUmu(radBatchHakkoUmu);
    }

    @JsonIgnore
    public RadioButton getRadMonjiKireCrtl() {
        return this.getSonotaConfigInfo2().getRadMonjiKireCrtl();
    }

    @JsonIgnore
    public void  setRadMonjiKireCrtl(RadioButton radMonjiKireCrtl) {
        this.getSonotaConfigInfo2().setRadMonjiKireCrtl(radMonjiKireCrtl);
    }

    @JsonIgnore
    public RadioButton getRadMojiKireBunriKbn() {
        return this.getSonotaConfigInfo2().getRadMojiKireBunriKbn();
    }

    @JsonIgnore
    public void  setRadMojiKireBunriKbn(RadioButton radMojiKireBunriKbn) {
        this.getSonotaConfigInfo2().setRadMojiKireBunriKbn(radMojiKireBunriKbn);
    }

    @JsonIgnore
    public RadioButton getRadInjiIchi() {
        return this.getSonotaConfigInfo2().getRadInjiIchi();
    }

    @JsonIgnore
    public void  setRadInjiIchi(RadioButton radInjiIchi) {
        this.getSonotaConfigInfo2().setRadInjiIchi(radInjiIchi);
    }

    @JsonIgnore
    public DropDownList getDdlBarCodeUmu() {
        return this.getBarCode().getDdlBarCodeUmu();
    }

    @JsonIgnore
    public void  setDdlBarCodeUmu(DropDownList ddlBarCodeUmu) {
        this.getBarCode().setDdlBarCodeUmu(ddlBarCodeUmu);
    }

    @JsonIgnore
    public DropDownList getDdlBarCodeHenshuHoho() {
        return this.getBarCode().getDdlBarCodeHenshuHoho();
    }

    @JsonIgnore
    public void  setDdlBarCodeHenshuHoho(DropDownList ddlBarCodeHenshuHoho) {
        this.getBarCode().setDdlBarCodeHenshuHoho(ddlBarCodeHenshuHoho);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
