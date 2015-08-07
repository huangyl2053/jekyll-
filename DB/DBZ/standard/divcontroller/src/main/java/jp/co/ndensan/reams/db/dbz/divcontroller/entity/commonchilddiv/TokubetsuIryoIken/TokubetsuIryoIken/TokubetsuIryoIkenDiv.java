package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TokubetsuIryoIken.TokubetsuIryoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TokubetsuIryoIken.TokubetsuIryoIken.ITokubetsuIryoIkenDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuIryoIken のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuIryoIkenDiv extends Panel implements ITokubetsuIryoIkenDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
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
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkTokubetsuIryo")
    public CheckBoxList getChkTokubetsuIryo() {
        return chkTokubetsuIryo;
    }

    @JsonProperty("chkTokubetsuIryo")
    public void setChkTokubetsuIryo(CheckBoxList chkTokubetsuIryo) {
        this.chkTokubetsuIryo=chkTokubetsuIryo;
    }

    @JsonProperty("chkTokubetsuTaiou")
    public CheckBoxList getChkTokubetsuTaiou() {
        return chkTokubetsuTaiou;
    }

    @JsonProperty("chkTokubetsuTaiou")
    public void setChkTokubetsuTaiou(CheckBoxList chkTokubetsuTaiou) {
        this.chkTokubetsuTaiou=chkTokubetsuTaiou;
    }

    @JsonProperty("chkShikkinTaio")
    public CheckBoxList getChkShikkinTaio() {
        return chkShikkinTaio;
    }

    @JsonProperty("chkShikkinTaio")
    public void setChkShikkinTaio(CheckBoxList chkShikkinTaio) {
        this.chkShikkinTaio=chkShikkinTaio;
    }

    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei=btnKakutei;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
