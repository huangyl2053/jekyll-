package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokubetsuIryoIken.TokubetsuIryoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.IDialogDiv;

/**
 * TokubetsuIryoIken のクラスファイル
 *
 * @author 自動生成
 */
public class TokubetsuIryoIkenDiv extends Panel implements ITokubetsuIryoIkenDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkTokubetsuIryo")
    private CheckBoxList chkTokubetsuIryo;
    @JsonProperty("chkTokubetsuTaiou")
    private CheckBoxList chkTokubetsuTaiou;
    @JsonProperty("chkShikkinTaio")
    private CheckBoxList chkShikkinTaio;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("hiddenHenSyu")
    private RString hiddenHenSyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkTokubetsuIryo
     * @return chkTokubetsuIryo
     */
    @JsonProperty("chkTokubetsuIryo")
    public CheckBoxList getChkTokubetsuIryo() {
        return chkTokubetsuIryo;
    }

    /*
     * setchkTokubetsuIryo
     * @param chkTokubetsuIryo chkTokubetsuIryo
     */
    @JsonProperty("chkTokubetsuIryo")
    public void setChkTokubetsuIryo(CheckBoxList chkTokubetsuIryo) {
        this.chkTokubetsuIryo = chkTokubetsuIryo;
    }

    /*
     * getchkTokubetsuTaiou
     * @return chkTokubetsuTaiou
     */
    @JsonProperty("chkTokubetsuTaiou")
    public CheckBoxList getChkTokubetsuTaiou() {
        return chkTokubetsuTaiou;
    }

    /*
     * setchkTokubetsuTaiou
     * @param chkTokubetsuTaiou chkTokubetsuTaiou
     */
    @JsonProperty("chkTokubetsuTaiou")
    public void setChkTokubetsuTaiou(CheckBoxList chkTokubetsuTaiou) {
        this.chkTokubetsuTaiou = chkTokubetsuTaiou;
    }

    /*
     * getchkShikkinTaio
     * @return chkShikkinTaio
     */
    @JsonProperty("chkShikkinTaio")
    public CheckBoxList getChkShikkinTaio() {
        return chkShikkinTaio;
    }

    /*
     * setchkShikkinTaio
     * @param chkShikkinTaio chkShikkinTaio
     */
    @JsonProperty("chkShikkinTaio")
    public void setChkShikkinTaio(CheckBoxList chkShikkinTaio) {
        this.chkShikkinTaio = chkShikkinTaio;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
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
     * gethiddenHenSyu
     * @return hiddenHenSyu
     */
    @JsonProperty("hiddenHenSyu")
    public RString getHiddenHenSyu() {
        return hiddenHenSyu;
    }

    /*
     * sethiddenHenSyu
     * @param hiddenHenSyu hiddenHenSyu
     */
    @JsonProperty("hiddenHenSyu")
    public void setHiddenHenSyu(RString hiddenHenSyu) {
        this.hiddenHenSyu = hiddenHenSyu;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
