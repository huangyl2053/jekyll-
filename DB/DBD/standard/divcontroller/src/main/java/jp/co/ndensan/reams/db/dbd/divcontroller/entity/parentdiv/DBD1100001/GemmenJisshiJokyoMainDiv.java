package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1100001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.HanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.IHanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * GemmenJisshiJokyoMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class GemmenJisshiJokyoMainDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnBatchParameterSave")
    private ButtonBatchParameterSave btnBatchParameterSave;
    @JsonProperty("btnBatchParameterRestore")
    private ButtonBatchParameterRestore btnBatchParameterRestore;
    @JsonProperty("GemmenJisshiJokyoJoken")
    private GemmenJisshiJokyoJokenDiv GemmenJisshiJokyoJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnBatchParameterSave
     * @return btnBatchParameterSave
     */
    @JsonProperty("btnBatchParameterSave")
    public ButtonBatchParameterSave getBtnBatchParameterSave() {
        return btnBatchParameterSave;
    }

    /*
     * setbtnBatchParameterSave
     * @param btnBatchParameterSave btnBatchParameterSave
     */
    @JsonProperty("btnBatchParameterSave")
    public void setBtnBatchParameterSave(ButtonBatchParameterSave btnBatchParameterSave) {
        this.btnBatchParameterSave = btnBatchParameterSave;
    }

    /*
     * getbtnBatchParameterRestore
     * @return btnBatchParameterRestore
     */
    @JsonProperty("btnBatchParameterRestore")
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return btnBatchParameterRestore;
    }

    /*
     * setbtnBatchParameterRestore
     * @param btnBatchParameterRestore btnBatchParameterRestore
     */
    @JsonProperty("btnBatchParameterRestore")
    public void setBtnBatchParameterRestore(ButtonBatchParameterRestore btnBatchParameterRestore) {
        this.btnBatchParameterRestore = btnBatchParameterRestore;
    }

    /*
     * getGemmenJisshiJokyoJoken
     * @return GemmenJisshiJokyoJoken
     */
    @JsonProperty("GemmenJisshiJokyoJoken")
    public GemmenJisshiJokyoJokenDiv getGemmenJisshiJokyoJoken() {
        return GemmenJisshiJokyoJoken;
    }

    /*
     * setGemmenJisshiJokyoJoken
     * @param GemmenJisshiJokyoJoken GemmenJisshiJokyoJoken
     */
    @JsonProperty("GemmenJisshiJokyoJoken")
    public void setGemmenJisshiJokyoJoken(GemmenJisshiJokyoJokenDiv GemmenJisshiJokyoJoken) {
        this.GemmenJisshiJokyoJoken = GemmenJisshiJokyoJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadShutsuryokuChohyo() {
        return this.getGemmenJisshiJokyoJoken().getRadShutsuryokuChohyo();
    }

    @JsonIgnore
    public void  setRadShutsuryokuChohyo(RadioButton radShutsuryokuChohyo) {
        this.getGemmenJisshiJokyoJoken().setRadShutsuryokuChohyo(radShutsuryokuChohyo);
    }

    @JsonIgnore
    public TextBoxYear getTxtTaishoNendo() {
        return this.getGemmenJisshiJokyoJoken().getTxtTaishoNendo();
    }

    @JsonIgnore
    public void  setTxtTaishoNendo(TextBoxYear txtTaishoNendo) {
        this.getGemmenJisshiJokyoJoken().setTxtTaishoNendo(txtTaishoNendo);
    }

    @JsonIgnore
    public GemmenJisshiJokyoTaishoHizukeKubunDiv getGemmenJisshiJokyoTaishoHizukeKubun() {
        return this.getGemmenJisshiJokyoJoken().getGemmenJisshiJokyoTaishoHizukeKubun();
    }

    @JsonIgnore
    public void  setGemmenJisshiJokyoTaishoHizukeKubun(GemmenJisshiJokyoTaishoHizukeKubunDiv GemmenJisshiJokyoTaishoHizukeKubun) {
        this.getGemmenJisshiJokyoJoken().setGemmenJisshiJokyoTaishoHizukeKubun(GemmenJisshiJokyoTaishoHizukeKubun);
    }

    @JsonIgnore
    public RadioButton getRadKijunBi() {
        return this.getGemmenJisshiJokyoJoken().getGemmenJisshiJokyoTaishoHizukeKubun().getRadKijunBi();
    }

    @JsonIgnore
    public void  setRadKijunBi(RadioButton radKijunBi) {
        this.getGemmenJisshiJokyoJoken().getGemmenJisshiJokyoTaishoHizukeKubun().setRadKijunBi(radKijunBi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKijunBi() {
        return this.getGemmenJisshiJokyoJoken().getGemmenJisshiJokyoTaishoHizukeKubun().getTxtKijunBi();
    }

    @JsonIgnore
    public void  setTxtKijunBi(TextBoxNum txtKijunBi) {
        this.getGemmenJisshiJokyoJoken().getGemmenJisshiJokyoTaishoHizukeKubun().setTxtKijunBi(txtKijunBi);
    }

    @JsonIgnore
    public RadioButton getRadKijunNengetsu() {
        return this.getGemmenJisshiJokyoJoken().getGemmenJisshiJokyoTaishoHizukeKubun().getRadKijunNengetsu();
    }

    @JsonIgnore
    public void  setRadKijunNengetsu(RadioButton radKijunNengetsu) {
        this.getGemmenJisshiJokyoJoken().getGemmenJisshiJokyoTaishoHizukeKubun().setRadKijunNengetsu(radKijunNengetsu);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getGemmenJisshiJokyoJoken().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getGemmenJisshiJokyoJoken().setLin1(lin1);
    }

    @JsonIgnore
    public IHanyoListAtenaSelectDiv getCcdAtenaJoken() {
        return this.getGemmenJisshiJokyoJoken().getCcdAtenaJoken();
    }

    // </editor-fold>
}
