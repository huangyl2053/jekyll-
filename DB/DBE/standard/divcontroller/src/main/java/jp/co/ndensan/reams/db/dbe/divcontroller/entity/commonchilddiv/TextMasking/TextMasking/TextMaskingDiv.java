package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TextMasking.TextMasking;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * TextMasking のクラスファイル
 *
 * @author 自動生成
 */
public class TextMaskingDiv extends Panel implements ITextMaskingDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblTextMasking")
    private tblTextMaskingDiv tblTextMasking;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("btnHozon")
    private Button btnHozon;
    @JsonProperty("hdnTextMasking")
    private RString hdnTextMasking;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblTextMasking
     * @return tblTextMasking
     */
    @JsonProperty("tblTextMasking")
    public tblTextMaskingDiv getTblTextMasking() {
        return tblTextMasking;
    }

    /*
     * settblTextMasking
     * @param tblTextMasking tblTextMasking
     */
    @JsonProperty("tblTextMasking")
    public void setTblTextMasking(tblTextMaskingDiv tblTextMasking) {
        this.tblTextMasking = tblTextMasking;
    }

    /*
     * getbtnModoru
     * @return btnModoru
     */
    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    /*
     * setbtnModoru
     * @param btnModoru btnModoru
     */
    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    /*
     * getbtnHozon
     * @return btnHozon
     */
    @JsonProperty("btnHozon")
    public Button getBtnHozon() {
        return btnHozon;
    }

    /*
     * setbtnHozon
     * @param btnHozon btnHozon
     */
    @JsonProperty("btnHozon")
    public void setBtnHozon(Button btnHozon) {
        this.btnHozon = btnHozon;
    }

    /*
     * gethdnTextMasking
     * @return hdnTextMasking
     */
    @JsonProperty("hdnTextMasking")
    public RString getHdnTextMasking() {
        return hdnTextMasking;
    }

    /*
     * sethdnTextMasking
     * @param hdnTextMasking hdnTextMasking
     */
    @JsonProperty("hdnTextMasking")
    public void setHdnTextMasking(RString hdnTextMasking) {
        this.hdnTextMasking = hdnTextMasking;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtChosaKomokuNo() {
        return this.getTblTextMasking().getTxtChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblHyphen() {
        return this.getTblTextMasking().getLblHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtChosaKomokuRenban() {
        return this.getTblTextMasking().getTxtChosaKomokuRenban();
    }

    @JsonIgnore
    public TextBox getTxtChosaKomokuMeisho() {
        return this.getTblTextMasking().getTxtChosaKomokuMeisho();
    }

    @JsonIgnore
    public Label getLblBeforeMasking() {
        return this.getTblTextMasking().getLblBeforeMasking();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBeforeMasking() {
        return this.getTblTextMasking().getTxtBeforeMasking();
    }

    @JsonIgnore
    public Label getLblAfterMasking() {
        return this.getTblTextMasking().getLblAfterMasking();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtAfterMasking() {
        return this.getTblTextMasking().getTxtAfterMasking();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
