package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020003;
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
 * ShosaiJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShosaiJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHihokenshaZenin")
    private RadioButton radHihokenshaZenin;
    @JsonProperty("radHihokenshaIgai")
    private RadioButton radHihokenshaIgai;
    @JsonProperty("JukyushaJoken")
    private JukyushaJokenDiv JukyushaJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHihokenshaZenin
     * @return radHihokenshaZenin
     */
    @JsonProperty("radHihokenshaZenin")
    public RadioButton getRadHihokenshaZenin() {
        return radHihokenshaZenin;
    }

    /*
     * setradHihokenshaZenin
     * @param radHihokenshaZenin radHihokenshaZenin
     */
    @JsonProperty("radHihokenshaZenin")
    public void setRadHihokenshaZenin(RadioButton radHihokenshaZenin) {
        this.radHihokenshaZenin = radHihokenshaZenin;
    }

    /*
     * getradHihokenshaIgai
     * @return radHihokenshaIgai
     */
    @JsonProperty("radHihokenshaIgai")
    public RadioButton getRadHihokenshaIgai() {
        return radHihokenshaIgai;
    }

    /*
     * setradHihokenshaIgai
     * @param radHihokenshaIgai radHihokenshaIgai
     */
    @JsonProperty("radHihokenshaIgai")
    public void setRadHihokenshaIgai(RadioButton radHihokenshaIgai) {
        this.radHihokenshaIgai = radHihokenshaIgai;
    }

    /*
     * getJukyushaJoken
     * @return JukyushaJoken
     */
    @JsonProperty("JukyushaJoken")
    public JukyushaJokenDiv getJukyushaJoken() {
        return JukyushaJoken;
    }

    /*
     * setJukyushaJoken
     * @param JukyushaJoken JukyushaJoken
     */
    @JsonProperty("JukyushaJoken")
    public void setJukyushaJoken(JukyushaJokenDiv JukyushaJoken) {
        this.JukyushaJoken = JukyushaJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkJukyushaZenin() {
        return this.getJukyushaJoken().getChkJukyushaZenin();
    }

    @JsonIgnore
    public void  setChkJukyushaZenin(CheckBoxList chkJukyushaZenin) {
        this.getJukyushaJoken().setChkJukyushaZenin(chkJukyushaZenin);
    }

    @JsonIgnore
    public CheckBoxList getChkJukyuNinteiShinseityusha() {
        return this.getJukyushaJoken().getChkJukyuNinteiShinseityusha();
    }

    @JsonIgnore
    public void  setChkJukyuNinteiShinseityusha(CheckBoxList chkJukyuNinteiShinseityusha) {
        this.getJukyushaJoken().setChkJukyuNinteiShinseityusha(chkJukyuNinteiShinseityusha);
    }

    @JsonIgnore
    public CheckBoxList getChkJukyuNinteibiChushutsu() {
        return this.getJukyushaJoken().getChkJukyuNinteibiChushutsu();
    }

    @JsonIgnore
    public void  setChkJukyuNinteibiChushutsu(CheckBoxList chkJukyuNinteibiChushutsu) {
        this.getJukyushaJoken().setChkJukyuNinteibiChushutsu(chkJukyuNinteibiChushutsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJukyuNinteibiKaishi() {
        return this.getJukyushaJoken().getTxtJukyuNinteibiKaishi();
    }

    @JsonIgnore
    public void  setTxtJukyuNinteibiKaishi(TextBoxFlexibleDate txtJukyuNinteibiKaishi) {
        this.getJukyushaJoken().setTxtJukyuNinteibiKaishi(txtJukyuNinteibiKaishi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJukyuNinteibiShuryo() {
        return this.getJukyushaJoken().getTxtJukyuNinteibiShuryo();
    }

    @JsonIgnore
    public void  setTxtJukyuNinteibiShuryo(TextBoxFlexibleDate txtJukyuNinteibiShuryo) {
        this.getJukyushaJoken().setTxtJukyuNinteibiShuryo(txtJukyuNinteibiShuryo);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiYukoShuryobiChushutsu() {
        return this.getJukyushaJoken().getChkNinteiYukoShuryobiChushutsu();
    }

    @JsonIgnore
    public void  setChkNinteiYukoShuryobiChushutsu(CheckBoxList chkNinteiYukoShuryobiChushutsu) {
        this.getJukyushaJoken().setChkNinteiYukoShuryobiChushutsu(chkNinteiYukoShuryobiChushutsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoShuryobiKaishi() {
        return this.getJukyushaJoken().getTxtNinteiYukoShuryobiKaishi();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoShuryobiKaishi(TextBoxFlexibleDate txtNinteiYukoShuryobiKaishi) {
        this.getJukyushaJoken().setTxtNinteiYukoShuryobiKaishi(txtNinteiYukoShuryobiKaishi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoShuryobiShuryo() {
        return this.getJukyushaJoken().getTxtNinteiYukoShuryobiShuryo();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoShuryobiShuryo(TextBoxFlexibleDate txtNinteiYukoShuryobiShuryo) {
        this.getJukyushaJoken().setTxtNinteiYukoShuryobiShuryo(txtNinteiYukoShuryobiShuryo);
    }

    // </editor-fold>
}
