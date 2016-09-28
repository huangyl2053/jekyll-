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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * GemmenJisshiJokyoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class GemmenJisshiJokyoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShutsuryokuChohyo")
    private RadioButton radShutsuryokuChohyo;
    @JsonProperty("txtTaishoNendo")
    private TextBoxYear txtTaishoNendo;
    @JsonProperty("GemmenJisshiJokyoTaishoHizukeKubun")
    private GemmenJisshiJokyoTaishoHizukeKubunDiv GemmenJisshiJokyoTaishoHizukeKubun;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("ccdAtenaJoken")
    private HanyoListAtenaSelectDiv ccdAtenaJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShutsuryokuChohyo
     * @return radShutsuryokuChohyo
     */
    @JsonProperty("radShutsuryokuChohyo")
    public RadioButton getRadShutsuryokuChohyo() {
        return radShutsuryokuChohyo;
    }

    /*
     * setradShutsuryokuChohyo
     * @param radShutsuryokuChohyo radShutsuryokuChohyo
     */
    @JsonProperty("radShutsuryokuChohyo")
    public void setRadShutsuryokuChohyo(RadioButton radShutsuryokuChohyo) {
        this.radShutsuryokuChohyo = radShutsuryokuChohyo;
    }

    /*
     * gettxtTaishoNendo
     * @return txtTaishoNendo
     */
    @JsonProperty("txtTaishoNendo")
    public TextBoxYear getTxtTaishoNendo() {
        return txtTaishoNendo;
    }

    /*
     * settxtTaishoNendo
     * @param txtTaishoNendo txtTaishoNendo
     */
    @JsonProperty("txtTaishoNendo")
    public void setTxtTaishoNendo(TextBoxYear txtTaishoNendo) {
        this.txtTaishoNendo = txtTaishoNendo;
    }

    /*
     * getGemmenJisshiJokyoTaishoHizukeKubun
     * @return GemmenJisshiJokyoTaishoHizukeKubun
     */
    @JsonProperty("GemmenJisshiJokyoTaishoHizukeKubun")
    public GemmenJisshiJokyoTaishoHizukeKubunDiv getGemmenJisshiJokyoTaishoHizukeKubun() {
        return GemmenJisshiJokyoTaishoHizukeKubun;
    }

    /*
     * setGemmenJisshiJokyoTaishoHizukeKubun
     * @param GemmenJisshiJokyoTaishoHizukeKubun GemmenJisshiJokyoTaishoHizukeKubun
     */
    @JsonProperty("GemmenJisshiJokyoTaishoHizukeKubun")
    public void setGemmenJisshiJokyoTaishoHizukeKubun(GemmenJisshiJokyoTaishoHizukeKubunDiv GemmenJisshiJokyoTaishoHizukeKubun) {
        this.GemmenJisshiJokyoTaishoHizukeKubun = GemmenJisshiJokyoTaishoHizukeKubun;
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
     * getccdAtenaJoken
     * @return ccdAtenaJoken
     */
    @JsonProperty("ccdAtenaJoken")
    public IHanyoListAtenaSelectDiv getCcdAtenaJoken() {
        return ccdAtenaJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadKijunBi() {
        return this.getGemmenJisshiJokyoTaishoHizukeKubun().getRadKijunBi();
    }

    @JsonIgnore
    public void  setRadKijunBi(RadioButton radKijunBi) {
        this.getGemmenJisshiJokyoTaishoHizukeKubun().setRadKijunBi(radKijunBi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKijunBi() {
        return this.getGemmenJisshiJokyoTaishoHizukeKubun().getTxtKijunBi();
    }

    @JsonIgnore
    public void  setTxtKijunBi(TextBoxNum txtKijunBi) {
        this.getGemmenJisshiJokyoTaishoHizukeKubun().setTxtKijunBi(txtKijunBi);
    }

    @JsonIgnore
    public RadioButton getRadKijunNengetsu() {
        return this.getGemmenJisshiJokyoTaishoHizukeKubun().getRadKijunNengetsu();
    }

    @JsonIgnore
    public void  setRadKijunNengetsu(RadioButton radKijunNengetsu) {
        this.getGemmenJisshiJokyoTaishoHizukeKubun().setRadKijunNengetsu(radKijunNengetsu);
    }

    // </editor-fold>
}
