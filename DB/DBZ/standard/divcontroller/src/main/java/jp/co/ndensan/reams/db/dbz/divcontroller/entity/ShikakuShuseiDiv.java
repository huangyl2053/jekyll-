package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShutokuKeiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SoushitsuKeiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShikakuShusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShuseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkMushi")
    private CheckBoxList chkMushi;
    @JsonProperty("txtFusugoNaiyo")
    private TextBox txtFusugoNaiyo;
    @JsonProperty("txtHihoNo")
    private TextBoxCode txtHihoNo;
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("txtJuminShubetsu")
    private TextBox txtJuminShubetsu;
    @JsonProperty("txtSeibetsu")
    private TextBox txtSeibetsu;
    @JsonProperty("txtUmareYmd")
    private TextBoxFlexibleDate txtUmareYmd;
    @JsonProperty("txtNenrei")
    private TextBox txtNenrei;
    @JsonProperty("txtSelectedRow")
    private TextBox txtSelectedRow;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("ShutokuKei")
    private ShutokuKeiDiv ShutokuKei;
    @JsonProperty("SoushitsuKei")
    private SoushitsuKeiDiv SoushitsuKei;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnCommitDialog")
    private ButtonDialog btnCommitDialog;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkMushi")
    public CheckBoxList getChkMushi() {
        return chkMushi;
    }

    @JsonProperty("chkMushi")
    public void setChkMushi(CheckBoxList chkMushi) {
        this.chkMushi=chkMushi;
    }

    @JsonProperty("txtFusugoNaiyo")
    public TextBox getTxtFusugoNaiyo() {
        return txtFusugoNaiyo;
    }

    @JsonProperty("txtFusugoNaiyo")
    public void setTxtFusugoNaiyo(TextBox txtFusugoNaiyo) {
        this.txtFusugoNaiyo=txtFusugoNaiyo;
    }

    @JsonProperty("txtHihoNo")
    public TextBoxCode getTxtHihoNo() {
        return txtHihoNo;
    }

    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.txtHihoNo=txtHihoNo;
    }

    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode=txtShikibetsuCode;
    }

    @JsonProperty("txtJuminShubetsu")
    public TextBox getTxtJuminShubetsu() {
        return txtJuminShubetsu;
    }

    @JsonProperty("txtJuminShubetsu")
    public void setTxtJuminShubetsu(TextBox txtJuminShubetsu) {
        this.txtJuminShubetsu=txtJuminShubetsu;
    }

    @JsonProperty("txtSeibetsu")
    public TextBox getTxtSeibetsu() {
        return txtSeibetsu;
    }

    @JsonProperty("txtSeibetsu")
    public void setTxtSeibetsu(TextBox txtSeibetsu) {
        this.txtSeibetsu=txtSeibetsu;
    }

    @JsonProperty("txtUmareYmd")
    public TextBoxFlexibleDate getTxtUmareYmd() {
        return txtUmareYmd;
    }

    @JsonProperty("txtUmareYmd")
    public void setTxtUmareYmd(TextBoxFlexibleDate txtUmareYmd) {
        this.txtUmareYmd=txtUmareYmd;
    }

    @JsonProperty("txtNenrei")
    public TextBox getTxtNenrei() {
        return txtNenrei;
    }

    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBox txtNenrei) {
        this.txtNenrei=txtNenrei;
    }

    @JsonProperty("txtSelectedRow")
    public TextBox getTxtSelectedRow() {
        return txtSelectedRow;
    }

    @JsonProperty("txtSelectedRow")
    public void setTxtSelectedRow(TextBox txtSelectedRow) {
        this.txtSelectedRow=txtSelectedRow;
    }

    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

    @JsonProperty("ShutokuKei")
    public ShutokuKeiDiv getShutokuKei() {
        return ShutokuKei;
    }

    @JsonProperty("ShutokuKei")
    public void setShutokuKei(ShutokuKeiDiv ShutokuKei) {
        this.ShutokuKei=ShutokuKei;
    }

    @JsonProperty("SoushitsuKei")
    public SoushitsuKeiDiv getSoushitsuKei() {
        return SoushitsuKei;
    }

    @JsonProperty("SoushitsuKei")
    public void setSoushitsuKei(SoushitsuKeiDiv SoushitsuKei) {
        this.SoushitsuKei=SoushitsuKei;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

    @JsonProperty("btnCommitDialog")
    public ButtonDialog getBtnCommitDialog() {
        return btnCommitDialog;
    }

    @JsonProperty("btnCommitDialog")
    public void setBtnCommitDialog(ButtonDialog btnCommitDialog) {
        this.btnCommitDialog=btnCommitDialog;
    }

}
