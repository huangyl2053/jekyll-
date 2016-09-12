package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChushutsuJoken")
    private RadioButton radChushutsuJoken;
    @JsonProperty("KensakuJokenTaishoKikan")
    private KensakuJokenTaishoKikanDiv KensakuJokenTaishoKikan;
    @JsonProperty("KensakuJokenHihokensha")
    private KensakuJokenHihokenshaDiv KensakuJokenHihokensha;
    @JsonProperty("CommonChildDiv1")
    private HokenshaListDiv CommonChildDiv1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradChushutsuJoken
     * @return radChushutsuJoken
     */
    @JsonProperty("radChushutsuJoken")
    public RadioButton getRadChushutsuJoken() {
        return radChushutsuJoken;
    }

    /*
     * setradChushutsuJoken
     * @param radChushutsuJoken radChushutsuJoken
     */
    @JsonProperty("radChushutsuJoken")
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.radChushutsuJoken = radChushutsuJoken;
    }

    /*
     * getKensakuJokenTaishoKikan
     * @return KensakuJokenTaishoKikan
     */
    @JsonProperty("KensakuJokenTaishoKikan")
    public KensakuJokenTaishoKikanDiv getKensakuJokenTaishoKikan() {
        return KensakuJokenTaishoKikan;
    }

    /*
     * setKensakuJokenTaishoKikan
     * @param KensakuJokenTaishoKikan KensakuJokenTaishoKikan
     */
    @JsonProperty("KensakuJokenTaishoKikan")
    public void setKensakuJokenTaishoKikan(KensakuJokenTaishoKikanDiv KensakuJokenTaishoKikan) {
        this.KensakuJokenTaishoKikan = KensakuJokenTaishoKikan;
    }

    /*
     * getKensakuJokenHihokensha
     * @return KensakuJokenHihokensha
     */
    @JsonProperty("KensakuJokenHihokensha")
    public KensakuJokenHihokenshaDiv getKensakuJokenHihokensha() {
        return KensakuJokenHihokensha;
    }

    /*
     * setKensakuJokenHihokensha
     * @param KensakuJokenHihokensha KensakuJokenHihokensha
     */
    @JsonProperty("KensakuJokenHihokensha")
    public void setKensakuJokenHihokensha(KensakuJokenHihokenshaDiv KensakuJokenHihokensha) {
        this.KensakuJokenHihokensha = KensakuJokenHihokensha;
    }

    /*
     * getCommonChildDiv1
     * @return CommonChildDiv1
     */
    @JsonProperty("CommonChildDiv1")
    public IHokenshaListDiv getCommonChildDiv1() {
        return CommonChildDiv1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtZenkaiKaishiDay() {
        return this.getKensakuJokenTaishoKikan().getTxtZenkaiKaishiDay();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiDay(TextBoxDate txtZenkaiKaishiDay) {
        this.getKensakuJokenTaishoKikan().setTxtZenkaiKaishiDay(txtZenkaiKaishiDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiKaishiTime() {
        return this.getKensakuJokenTaishoKikan().getTxtZenkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiTime(TextBoxTime txtZenkaiKaishiTime) {
        this.getKensakuJokenTaishoKikan().setTxtZenkaiKaishiTime(txtZenkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblZenkaiFor() {
        return this.getKensakuJokenTaishoKikan().getLblZenkaiFor();
    }

    @JsonIgnore
    public void  setLblZenkaiFor(Label lblZenkaiFor) {
        this.getKensakuJokenTaishoKikan().setLblZenkaiFor(lblZenkaiFor);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShuryoDay() {
        return this.getKensakuJokenTaishoKikan().getTxtZenkaiShuryoDay();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoDay(TextBoxDate txtZenkaiShuryoDay) {
        this.getKensakuJokenTaishoKikan().setTxtZenkaiShuryoDay(txtZenkaiShuryoDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiShuryoTime() {
        return this.getKensakuJokenTaishoKikan().getTxtZenkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoTime(TextBoxTime txtZenkaiShuryoTime) {
        this.getKensakuJokenTaishoKikan().setTxtZenkaiShuryoTime(txtZenkaiShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiKaishiDay() {
        return this.getKensakuJokenTaishoKikan().getTxtKonkaiKaishiDay();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiDay(TextBoxDate txtKonkaiKaishiDay) {
        this.getKensakuJokenTaishoKikan().setTxtKonkaiKaishiDay(txtKonkaiKaishiDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiKaishiTime() {
        return this.getKensakuJokenTaishoKikan().getTxtKonkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiTime(TextBoxTime txtKonkaiKaishiTime) {
        this.getKensakuJokenTaishoKikan().setTxtKonkaiKaishiTime(txtKonkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblKonkaiFor() {
        return this.getKensakuJokenTaishoKikan().getLblKonkaiFor();
    }

    @JsonIgnore
    public void  setLblKonkaiFor(Label lblKonkaiFor) {
        this.getKensakuJokenTaishoKikan().setLblKonkaiFor(lblKonkaiFor);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiShuryoDay() {
        return this.getKensakuJokenTaishoKikan().getTxtKonkaiShuryoDay();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoDay(TextBoxDate txtKonkaiShuryoDay) {
        this.getKensakuJokenTaishoKikan().setTxtKonkaiShuryoDay(txtKonkaiShuryoDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiShuryoTime() {
        return this.getKensakuJokenTaishoKikan().getTxtKonkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoTime(TextBoxTime txtKonkaiShuryoTime) {
        this.getKensakuJokenTaishoKikan().setTxtKonkaiShuryoTime(txtKonkaiShuryoTime);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getKensakuJokenHihokensha().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.getKensakuJokenHihokensha().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHihokenshaGuide() {
        return this.getKensakuJokenHihokensha().getBtnHihokenshaGuide();
    }

    @JsonIgnore
    public void  setBtnHihokenshaGuide(ButtonDialog btnHihokenshaGuide) {
        this.getKensakuJokenHihokensha().setBtnHihokenshaGuide(btnHihokenshaGuide);
    }

    @JsonIgnore
    public Button getBtnhihokensha() {
        return this.getKensakuJokenHihokensha().getBtnhihokensha();
    }

    @JsonIgnore
    public void  setBtnhihokensha(Button btnhihokensha) {
        this.getKensakuJokenHihokensha().setBtnhihokensha(btnhihokensha);
    }

    // </editor-fold>
}
