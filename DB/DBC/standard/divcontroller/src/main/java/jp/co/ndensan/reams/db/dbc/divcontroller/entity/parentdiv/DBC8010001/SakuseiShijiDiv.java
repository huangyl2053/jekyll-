package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SakuseiShiji のクラスファイル 
 * 
 * @author 自動生成
 */
public class SakuseiShijiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShoriTaisho")
    private DropDownList ddlShoriTaisho;
    @JsonProperty("radShoriSentakuFurikomiDataSakusei")
    private RadioButton radShoriSentakuFurikomiDataSakusei;
    @JsonProperty("spc01")
    private Space spc01;
    @JsonProperty("FurikomiDataSakuseiShiji")
    private FurikomiDataSakuseiShijiDiv FurikomiDataSakuseiShiji;
    @JsonProperty("radShoriSentakuFurikomiDataModify")
    private RadioButton radShoriSentakuFurikomiDataModify;
    @JsonProperty("spc02")
    private Space spc02;
    @JsonProperty("FurikomiDataModifyShiji")
    private FurikomiDataModifyShijiDiv FurikomiDataModifyShiji;
    @JsonProperty("radShoriSentakuIchiranhyoSakusei")
    private RadioButton radShoriSentakuIchiranhyoSakusei;
    @JsonProperty("spc03")
    private Space spc03;
    @JsonProperty("IchiranhyoSakuseiShiji")
    private IchiranhyoSakuseiShijiDiv IchiranhyoSakuseiShiji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShoriTaisho
     * @return ddlShoriTaisho
     */
    @JsonProperty("ddlShoriTaisho")
    public DropDownList getDdlShoriTaisho() {
        return ddlShoriTaisho;
    }

    /*
     * setddlShoriTaisho
     * @param ddlShoriTaisho ddlShoriTaisho
     */
    @JsonProperty("ddlShoriTaisho")
    public void setDdlShoriTaisho(DropDownList ddlShoriTaisho) {
        this.ddlShoriTaisho = ddlShoriTaisho;
    }

    /*
     * getradShoriSentakuFurikomiDataSakusei
     * @return radShoriSentakuFurikomiDataSakusei
     */
    @JsonProperty("radShoriSentakuFurikomiDataSakusei")
    public RadioButton getRadShoriSentakuFurikomiDataSakusei() {
        return radShoriSentakuFurikomiDataSakusei;
    }

    /*
     * setradShoriSentakuFurikomiDataSakusei
     * @param radShoriSentakuFurikomiDataSakusei radShoriSentakuFurikomiDataSakusei
     */
    @JsonProperty("radShoriSentakuFurikomiDataSakusei")
    public void setRadShoriSentakuFurikomiDataSakusei(RadioButton radShoriSentakuFurikomiDataSakusei) {
        this.radShoriSentakuFurikomiDataSakusei = radShoriSentakuFurikomiDataSakusei;
    }

    /*
     * getspc01
     * @return spc01
     */
    @JsonProperty("spc01")
    public Space getSpc01() {
        return spc01;
    }

    /*
     * setspc01
     * @param spc01 spc01
     */
    @JsonProperty("spc01")
    public void setSpc01(Space spc01) {
        this.spc01 = spc01;
    }

    /*
     * getFurikomiDataSakuseiShiji
     * @return FurikomiDataSakuseiShiji
     */
    @JsonProperty("FurikomiDataSakuseiShiji")
    public FurikomiDataSakuseiShijiDiv getFurikomiDataSakuseiShiji() {
        return FurikomiDataSakuseiShiji;
    }

    /*
     * setFurikomiDataSakuseiShiji
     * @param FurikomiDataSakuseiShiji FurikomiDataSakuseiShiji
     */
    @JsonProperty("FurikomiDataSakuseiShiji")
    public void setFurikomiDataSakuseiShiji(FurikomiDataSakuseiShijiDiv FurikomiDataSakuseiShiji) {
        this.FurikomiDataSakuseiShiji = FurikomiDataSakuseiShiji;
    }

    /*
     * getradShoriSentakuFurikomiDataModify
     * @return radShoriSentakuFurikomiDataModify
     */
    @JsonProperty("radShoriSentakuFurikomiDataModify")
    public RadioButton getRadShoriSentakuFurikomiDataModify() {
        return radShoriSentakuFurikomiDataModify;
    }

    /*
     * setradShoriSentakuFurikomiDataModify
     * @param radShoriSentakuFurikomiDataModify radShoriSentakuFurikomiDataModify
     */
    @JsonProperty("radShoriSentakuFurikomiDataModify")
    public void setRadShoriSentakuFurikomiDataModify(RadioButton radShoriSentakuFurikomiDataModify) {
        this.radShoriSentakuFurikomiDataModify = radShoriSentakuFurikomiDataModify;
    }

    /*
     * getspc02
     * @return spc02
     */
    @JsonProperty("spc02")
    public Space getSpc02() {
        return spc02;
    }

    /*
     * setspc02
     * @param spc02 spc02
     */
    @JsonProperty("spc02")
    public void setSpc02(Space spc02) {
        this.spc02 = spc02;
    }

    /*
     * getFurikomiDataModifyShiji
     * @return FurikomiDataModifyShiji
     */
    @JsonProperty("FurikomiDataModifyShiji")
    public FurikomiDataModifyShijiDiv getFurikomiDataModifyShiji() {
        return FurikomiDataModifyShiji;
    }

    /*
     * setFurikomiDataModifyShiji
     * @param FurikomiDataModifyShiji FurikomiDataModifyShiji
     */
    @JsonProperty("FurikomiDataModifyShiji")
    public void setFurikomiDataModifyShiji(FurikomiDataModifyShijiDiv FurikomiDataModifyShiji) {
        this.FurikomiDataModifyShiji = FurikomiDataModifyShiji;
    }

    /*
     * getradShoriSentakuIchiranhyoSakusei
     * @return radShoriSentakuIchiranhyoSakusei
     */
    @JsonProperty("radShoriSentakuIchiranhyoSakusei")
    public RadioButton getRadShoriSentakuIchiranhyoSakusei() {
        return radShoriSentakuIchiranhyoSakusei;
    }

    /*
     * setradShoriSentakuIchiranhyoSakusei
     * @param radShoriSentakuIchiranhyoSakusei radShoriSentakuIchiranhyoSakusei
     */
    @JsonProperty("radShoriSentakuIchiranhyoSakusei")
    public void setRadShoriSentakuIchiranhyoSakusei(RadioButton radShoriSentakuIchiranhyoSakusei) {
        this.radShoriSentakuIchiranhyoSakusei = radShoriSentakuIchiranhyoSakusei;
    }

    /*
     * getspc03
     * @return spc03
     */
    @JsonProperty("spc03")
    public Space getSpc03() {
        return spc03;
    }

    /*
     * setspc03
     * @param spc03 spc03
     */
    @JsonProperty("spc03")
    public void setSpc03(Space spc03) {
        this.spc03 = spc03;
    }

    /*
     * getIchiranhyoSakuseiShiji
     * @return IchiranhyoSakuseiShiji
     */
    @JsonProperty("IchiranhyoSakuseiShiji")
    public IchiranhyoSakuseiShijiDiv getIchiranhyoSakuseiShiji() {
        return IchiranhyoSakuseiShiji;
    }

    /*
     * setIchiranhyoSakuseiShiji
     * @param IchiranhyoSakuseiShiji IchiranhyoSakuseiShiji
     */
    @JsonProperty("IchiranhyoSakuseiShiji")
    public void setIchiranhyoSakuseiShiji(IchiranhyoSakuseiShijiDiv IchiranhyoSakuseiShiji) {
        this.IchiranhyoSakuseiShiji = IchiranhyoSakuseiShiji;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtFurikomiShiteiYMD() {
        return this.getFurikomiDataSakuseiShiji().getTxtFurikomiShiteiYMD();
    }

    @JsonIgnore
    public void  setTxtFurikomiShiteiYMD(TextBoxDate txtFurikomiShiteiYMD) {
        this.getFurikomiDataSakuseiShiji().setTxtFurikomiShiteiYMD(txtFurikomiShiteiYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkSaisakusei() {
        return this.getFurikomiDataSakuseiShiji().getChkSaisakusei();
    }

    @JsonIgnore
    public void  setChkSaisakusei(CheckBoxList chkSaisakusei) {
        this.getFurikomiDataSakuseiShiji().setChkSaisakusei(chkSaisakusei);
    }

    @JsonIgnore
    public TextBoxDate getTxtWrongFurikomiShiteiYMD() {
        return this.getFurikomiDataModifyShiji().getTxtWrongFurikomiShiteiYMD();
    }

    @JsonIgnore
    public void  setTxtWrongFurikomiShiteiYMD(TextBoxDate txtWrongFurikomiShiteiYMD) {
        this.getFurikomiDataModifyShiji().setTxtWrongFurikomiShiteiYMD(txtWrongFurikomiShiteiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtCorrectFurikomiShiteiYMD() {
        return this.getFurikomiDataModifyShiji().getTxtCorrectFurikomiShiteiYMD();
    }

    @JsonIgnore
    public void  setTxtCorrectFurikomiShiteiYMD(TextBoxDate txtCorrectFurikomiShiteiYMD) {
        this.getFurikomiDataModifyShiji().setTxtCorrectFurikomiShiteiYMD(txtCorrectFurikomiShiteiYMD);
    }

    @JsonIgnore
    public RadioButton getRadSiharaihohou() {
        return this.getIchiranhyoSakuseiShiji().getRadSiharaihohou();
    }

    @JsonIgnore
    public void  setRadSiharaihohou(RadioButton radSiharaihohou) {
        this.getIchiranhyoSakuseiShiji().setRadSiharaihohou(radSiharaihohou);
    }

    // </editor-fold>
}
