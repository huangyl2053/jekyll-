package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome2go.IchijiSashitome2Go;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TorokuJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TorokuJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTorokuJokyo")
    private TextBox txtTorokuJokyo;
    @JsonProperty("txtTekiyoKaishi")
    private TextBoxFlexibleDate txtTekiyoKaishi;
    @JsonProperty("txtTekiyoShuryo")
    private TextBoxFlexibleDate txtTekiyoShuryo;
    @JsonProperty("ddlShuryoJokyo")
    private DropDownList ddlShuryoJokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTorokuJokyo
     * @return txtTorokuJokyo
     */
    @JsonProperty("txtTorokuJokyo")
    public TextBox getTxtTorokuJokyo() {
        return txtTorokuJokyo;
    }

    /*
     * settxtTorokuJokyo
     * @param txtTorokuJokyo txtTorokuJokyo
     */
    @JsonProperty("txtTorokuJokyo")
    public void setTxtTorokuJokyo(TextBox txtTorokuJokyo) {
        this.txtTorokuJokyo = txtTorokuJokyo;
    }

    /*
     * gettxtTekiyoKaishi
     * @return txtTekiyoKaishi
     */
    @JsonProperty("txtTekiyoKaishi")
    public TextBoxFlexibleDate getTxtTekiyoKaishi() {
        return txtTekiyoKaishi;
    }

    /*
     * settxtTekiyoKaishi
     * @param txtTekiyoKaishi txtTekiyoKaishi
     */
    @JsonProperty("txtTekiyoKaishi")
    public void setTxtTekiyoKaishi(TextBoxFlexibleDate txtTekiyoKaishi) {
        this.txtTekiyoKaishi = txtTekiyoKaishi;
    }

    /*
     * gettxtTekiyoShuryo
     * @return txtTekiyoShuryo
     */
    @JsonProperty("txtTekiyoShuryo")
    public TextBoxFlexibleDate getTxtTekiyoShuryo() {
        return txtTekiyoShuryo;
    }

    /*
     * settxtTekiyoShuryo
     * @param txtTekiyoShuryo txtTekiyoShuryo
     */
    @JsonProperty("txtTekiyoShuryo")
    public void setTxtTekiyoShuryo(TextBoxFlexibleDate txtTekiyoShuryo) {
        this.txtTekiyoShuryo = txtTekiyoShuryo;
    }

    /*
     * getddlShuryoJokyo
     * @return ddlShuryoJokyo
     */
    @JsonProperty("ddlShuryoJokyo")
    public DropDownList getDdlShuryoJokyo() {
        return ddlShuryoJokyo;
    }

    /*
     * setddlShuryoJokyo
     * @param ddlShuryoJokyo ddlShuryoJokyo
     */
    @JsonProperty("ddlShuryoJokyo")
    public void setDdlShuryoJokyo(DropDownList ddlShuryoJokyo) {
        this.ddlShuryoJokyo = ddlShuryoJokyo;
    }

    // </editor-fold>
}
