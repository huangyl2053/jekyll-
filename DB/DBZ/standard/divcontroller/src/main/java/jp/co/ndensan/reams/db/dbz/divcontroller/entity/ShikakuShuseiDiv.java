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
    @JsonProperty("txtFusugoNaiyo")
    private TextBox txtFusugoNaiyo;
    @JsonProperty("txtHihoNo")
    private TextBoxCode txtHihoNo;
    @JsonProperty("txtShikibetsuCode")
    private TextBoxShikibetsuCode txtShikibetsuCode;
    @JsonProperty("txtAtenaKanaMeisho")
    private TextBoxAtenaKanaMeisho txtAtenaKanaMeisho;
    @JsonProperty("txtJuminShubetsu")
    private TextBox txtJuminShubetsu;
    @JsonProperty("txtSeibetsu")
    private TextBox txtSeibetsu;
    @JsonProperty("txtUmareYmd")
    private TextBoxFlexibleDate txtUmareYmd;
    @JsonProperty("txtNenrei")
    private TextBox txtNenrei;
    @JsonProperty("ShutokuKei")
    private ShutokuKeiDiv ShutokuKei;
    @JsonProperty("SoushitsuKei")
    private SoushitsuKeiDiv SoushitsuKei;
    @JsonProperty("btnShikakuCancel")
    private ButtonSubmit btnShikakuCancel;
    @JsonProperty("btnShikakuSubmit")
    private ButtonSubmit btnShikakuSubmit;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
    public TextBoxShikibetsuCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxShikibetsuCode txtShikibetsuCode) {
        this.txtShikibetsuCode=txtShikibetsuCode;
    }

    @JsonProperty("txtAtenaKanaMeisho")
    public TextBoxAtenaKanaMeisho getTxtAtenaKanaMeisho() {
        return txtAtenaKanaMeisho;
    }

    @JsonProperty("txtAtenaKanaMeisho")
    public void setTxtAtenaKanaMeisho(TextBoxAtenaKanaMeisho txtAtenaKanaMeisho) {
        this.txtAtenaKanaMeisho=txtAtenaKanaMeisho;
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

    @JsonProperty("btnShikakuCancel")
    public ButtonSubmit getBtnShikakuCancel() {
        return btnShikakuCancel;
    }

    @JsonProperty("btnShikakuCancel")
    public void setBtnShikakuCancel(ButtonSubmit btnShikakuCancel) {
        this.btnShikakuCancel=btnShikakuCancel;
    }

    @JsonProperty("btnShikakuSubmit")
    public ButtonSubmit getBtnShikakuSubmit() {
        return btnShikakuSubmit;
    }

    @JsonProperty("btnShikakuSubmit")
    public void setBtnShikakuSubmit(ButtonSubmit btnShikakuSubmit) {
        this.btnShikakuSubmit=btnShikakuSubmit;
    }

}
