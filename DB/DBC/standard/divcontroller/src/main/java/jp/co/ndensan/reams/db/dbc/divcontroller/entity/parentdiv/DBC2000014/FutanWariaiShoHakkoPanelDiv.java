package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000014;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FutanWariaiShoHakkoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanWariaiShoHakkoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PanelJoken")
    private PanelJokenDiv PanelJoken;
    @JsonProperty("PanelKikan")
    private PanelKikanDiv PanelKikan;
    @JsonProperty("ccdShutsuryokuJun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokuJun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPanelJoken
     * @return PanelJoken
     */
    @JsonProperty("PanelJoken")
    public PanelJokenDiv getPanelJoken() {
        return PanelJoken;
    }

    /*
     * setPanelJoken
     * @param PanelJoken PanelJoken
     */
    @JsonProperty("PanelJoken")
    public void setPanelJoken(PanelJokenDiv PanelJoken) {
        this.PanelJoken = PanelJoken;
    }

    /*
     * getPanelKikan
     * @return PanelKikan
     */
    @JsonProperty("PanelKikan")
    public PanelKikanDiv getPanelKikan() {
        return PanelKikan;
    }

    /*
     * setPanelKikan
     * @param PanelKikan PanelKikan
     */
    @JsonProperty("PanelKikan")
    public void setPanelKikan(PanelKikanDiv PanelKikan) {
        this.PanelKikan = PanelKikan;
    }

    /*
     * getccdShutsuryokuJun
     * @return ccdShutsuryokuJun
     */
    @JsonProperty("ccdShutsuryokuJun")
    public IChohyoShutsuryokujunDiv getCcdShutsuryokuJun() {
        return ccdShutsuryokuJun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlNendo() {
        return this.getPanelJoken().getDdlNendo();
    }

    @JsonIgnore
    public void  setDdlNendo(DropDownList ddlNendo) {
        this.getPanelJoken().setDdlNendo(ddlNendo);
    }

    @JsonIgnore
    public RadioButton getRadKubun() {
        return this.getPanelJoken().getRadKubun();
    }

    @JsonIgnore
    public void  setRadKubun(RadioButton radKubun) {
        this.getPanelJoken().setRadKubun(radKubun);
    }

    @JsonIgnore
    public RadioButton getRadHakkoKubun() {
        return this.getPanelJoken().getRadHakkoKubun();
    }

    @JsonIgnore
    public void  setRadHakkoKubun(RadioButton radHakkoKubun) {
        this.getPanelJoken().setRadHakkoKubun(radHakkoKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtKofubi() {
        return this.getPanelJoken().getTxtKofubi();
    }

    @JsonIgnore
    public void  setTxtKofubi(TextBoxDate txtKofubi) {
        this.getPanelJoken().setTxtKofubi(txtKofubi);
    }

    @JsonIgnore
    public Label getLblIdoTaishoKikan() {
        return this.getPanelKikan().getLblIdoTaishoKikan();
    }

    @JsonIgnore
    public void  setLblIdoTaishoKikan(Label lblIdoTaishoKikan) {
        this.getPanelKikan().setLblIdoTaishoKikan(lblIdoTaishoKikan);
    }

    @JsonIgnore
    public Label getLblKaishiDate() {
        return this.getPanelKikan().getLblKaishiDate();
    }

    @JsonIgnore
    public void  setLblKaishiDate(Label lblKaishiDate) {
        this.getPanelKikan().setLblKaishiDate(lblKaishiDate);
    }

    @JsonIgnore
    public Label getLblKaishiTime() {
        return this.getPanelKikan().getLblKaishiTime();
    }

    @JsonIgnore
    public void  setLblKaishiTime(Label lblKaishiTime) {
        this.getPanelKikan().setLblKaishiTime(lblKaishiTime);
    }

    @JsonIgnore
    public Label getLblShuryoDate() {
        return this.getPanelKikan().getLblShuryoDate();
    }

    @JsonIgnore
    public void  setLblShuryoDate(Label lblShuryoDate) {
        this.getPanelKikan().setLblShuryoDate(lblShuryoDate);
    }

    @JsonIgnore
    public Label getLblShuryoTime() {
        return this.getPanelKikan().getLblShuryoTime();
    }

    @JsonIgnore
    public void  setLblShuryoTime(Label lblShuryoTime) {
        this.getPanelKikan().setLblShuryoTime(lblShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiKaishiDate() {
        return this.getPanelKikan().getTxtZenkaiKaishiDate();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiDate(TextBoxDate txtZenkaiKaishiDate) {
        this.getPanelKikan().setTxtZenkaiKaishiDate(txtZenkaiKaishiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiKaishiTime() {
        return this.getPanelKikan().getTxtZenkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiTime(TextBoxTime txtZenkaiKaishiTime) {
        this.getPanelKikan().setTxtZenkaiKaishiTime(txtZenkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblNamisen1() {
        return this.getPanelKikan().getLblNamisen1();
    }

    @JsonIgnore
    public void  setLblNamisen1(Label lblNamisen1) {
        this.getPanelKikan().setLblNamisen1(lblNamisen1);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShuryoDate() {
        return this.getPanelKikan().getTxtZenkaiShuryoDate();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoDate(TextBoxDate txtZenkaiShuryoDate) {
        this.getPanelKikan().setTxtZenkaiShuryoDate(txtZenkaiShuryoDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiShuryoTime() {
        return this.getPanelKikan().getTxtZenkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoTime(TextBoxTime txtZenkaiShuryoTime) {
        this.getPanelKikan().setTxtZenkaiShuryoTime(txtZenkaiShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiKaishiDate() {
        return this.getPanelKikan().getTxtKonkaiKaishiDate();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiDate(TextBoxDate txtKonkaiKaishiDate) {
        this.getPanelKikan().setTxtKonkaiKaishiDate(txtKonkaiKaishiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiKaishiTime() {
        return this.getPanelKikan().getTxtKonkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiTime(TextBoxTime txtKonkaiKaishiTime) {
        this.getPanelKikan().setTxtKonkaiKaishiTime(txtKonkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblNamisen2() {
        return this.getPanelKikan().getLblNamisen2();
    }

    @JsonIgnore
    public void  setLblNamisen2(Label lblNamisen2) {
        this.getPanelKikan().setLblNamisen2(lblNamisen2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiShuryoDate() {
        return this.getPanelKikan().getTxtKonkaiShuryoDate();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoDate(TextBoxDate txtKonkaiShuryoDate) {
        this.getPanelKikan().setTxtKonkaiShuryoDate(txtKonkaiShuryoDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiShuryoTime() {
        return this.getPanelKikan().getTxtKonkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoTime(TextBoxTime txtKonkaiShuryoTime) {
        this.getPanelKikan().setTxtKonkaiShuryoTime(txtKonkaiShuryoTime);
    }

    // </editor-fold>
}
