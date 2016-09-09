package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020003;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ChishutsuJokenParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChishutsuJokenParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChishutsuJoken")
    private ChishutsuJokenDiv ChishutsuJoken;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChishutsuJoken
     * @return ChishutsuJoken
     */
    @JsonProperty("ChishutsuJoken")
    public ChishutsuJokenDiv getChishutsuJoken() {
        return ChishutsuJoken;
    }

    /*
     * setChishutsuJoken
     * @param ChishutsuJoken ChishutsuJoken
     */
    @JsonProperty("ChishutsuJoken")
    public void setChishutsuJoken(ChishutsuJokenDiv ChishutsuJoken) {
        this.ChishutsuJoken = ChishutsuJoken;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadJikoKisanbiTorokushaNomi() {
        return this.getChishutsuJoken().getJIkoKisanbiJoken().getRadJikoKisanbiTorokushaNomi();
    }

    @JsonIgnore
    public void  setRadJikoKisanbiTorokushaNomi(RadioButton radJikoKisanbiTorokushaNomi) {
        this.getChishutsuJoken().getJIkoKisanbiJoken().setRadJikoKisanbiTorokushaNomi(radJikoKisanbiTorokushaNomi);
    }

    @JsonIgnore
    public RadioButton getRadJikoKisanbiTorokushaIgai() {
        return this.getChishutsuJoken().getJIkoKisanbiJoken().getRadJikoKisanbiTorokushaIgai();
    }

    @JsonIgnore
    public void  setRadJikoKisanbiTorokushaIgai(RadioButton radJikoKisanbiTorokushaIgai) {
        this.getChishutsuJoken().getJIkoKisanbiJoken().setRadJikoKisanbiTorokushaIgai(radJikoKisanbiTorokushaIgai);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaZenin() {
        return this.getChishutsuJoken().getShosaiJoken().getRadHihokenshaZenin();
    }

    @JsonIgnore
    public void  setRadHihokenshaZenin(RadioButton radHihokenshaZenin) {
        this.getChishutsuJoken().getShosaiJoken().setRadHihokenshaZenin(radHihokenshaZenin);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaIgai() {
        return this.getChishutsuJoken().getShosaiJoken().getRadHihokenshaIgai();
    }

    @JsonIgnore
    public void  setRadHihokenshaIgai(RadioButton radHihokenshaIgai) {
        this.getChishutsuJoken().getShosaiJoken().setRadHihokenshaIgai(radHihokenshaIgai);
    }

    @JsonIgnore
    public JukyushaJokenDiv getJukyushaJoken() {
        return this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken();
    }

    @JsonIgnore
    public void  setJukyushaJoken(JukyushaJokenDiv JukyushaJoken) {
        this.getChishutsuJoken().getShosaiJoken().setJukyushaJoken(JukyushaJoken);
    }

    @JsonIgnore
    public CheckBoxList getChkJukyushaZenin() {
        return this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().getChkJukyushaZenin();
    }

    @JsonIgnore
    public void  setChkJukyushaZenin(CheckBoxList chkJukyushaZenin) {
        this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().setChkJukyushaZenin(chkJukyushaZenin);
    }

    @JsonIgnore
    public CheckBoxList getChkJukyuNinteiShinseityusha() {
        return this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().getChkJukyuNinteiShinseityusha();
    }

    @JsonIgnore
    public void  setChkJukyuNinteiShinseityusha(CheckBoxList chkJukyuNinteiShinseityusha) {
        this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().setChkJukyuNinteiShinseityusha(chkJukyuNinteiShinseityusha);
    }

    @JsonIgnore
    public CheckBoxList getChkJukyuNinteibiChushutsu() {
        return this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().getChkJukyuNinteibiChushutsu();
    }

    @JsonIgnore
    public void  setChkJukyuNinteibiChushutsu(CheckBoxList chkJukyuNinteibiChushutsu) {
        this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().setChkJukyuNinteibiChushutsu(chkJukyuNinteibiChushutsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJukyuNinteibiKaishi() {
        return this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().getTxtJukyuNinteibiKaishi();
    }

    @JsonIgnore
    public void  setTxtJukyuNinteibiKaishi(TextBoxFlexibleDate txtJukyuNinteibiKaishi) {
        this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().setTxtJukyuNinteibiKaishi(txtJukyuNinteibiKaishi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJukyuNinteibiShuryo() {
        return this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().getTxtJukyuNinteibiShuryo();
    }

    @JsonIgnore
    public void  setTxtJukyuNinteibiShuryo(TextBoxFlexibleDate txtJukyuNinteibiShuryo) {
        this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().setTxtJukyuNinteibiShuryo(txtJukyuNinteibiShuryo);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiYukoShuryobiChushutsu() {
        return this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().getChkNinteiYukoShuryobiChushutsu();
    }

    @JsonIgnore
    public void  setChkNinteiYukoShuryobiChushutsu(CheckBoxList chkNinteiYukoShuryobiChushutsu) {
        this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().setChkNinteiYukoShuryobiChushutsu(chkNinteiYukoShuryobiChushutsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoShuryobiKaishi() {
        return this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().getTxtNinteiYukoShuryobiKaishi();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoShuryobiKaishi(TextBoxFlexibleDate txtNinteiYukoShuryobiKaishi) {
        this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().setTxtNinteiYukoShuryobiKaishi(txtNinteiYukoShuryobiKaishi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoShuryobiShuryo() {
        return this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().getTxtNinteiYukoShuryobiShuryo();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoShuryobiShuryo(TextBoxFlexibleDate txtNinteiYukoShuryobiShuryo) {
        this.getChishutsuJoken().getShosaiJoken().getJukyushaJoken().setTxtNinteiYukoShuryobiShuryo(txtNinteiYukoShuryobiShuryo);
    }

    // </editor-fold>
}
