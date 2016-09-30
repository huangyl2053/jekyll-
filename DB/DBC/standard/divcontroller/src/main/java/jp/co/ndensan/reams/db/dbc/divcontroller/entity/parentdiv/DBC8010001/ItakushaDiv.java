package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Itakusha のクラスファイル 
 * 
 * @author 自動生成
 */
public class ItakushaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtItakushaCode")
    private TextBox txtItakushaCode;
    @JsonProperty("txtItakushamei")
    private TextBox txtItakushamei;
    @JsonProperty("txtFurikomiGroupCode")
    private TextBox txtFurikomiGroupCode;
    @JsonProperty("txtFurikomiGroupMeisho")
    private TextBox txtFurikomiGroupMeisho;
    @JsonProperty("itakushaId")
    private RString itakushaId;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtItakushaCode
     * @return txtItakushaCode
     */
    @JsonProperty("txtItakushaCode")
    public TextBox getTxtItakushaCode() {
        return txtItakushaCode;
    }

    /*
     * settxtItakushaCode
     * @param txtItakushaCode txtItakushaCode
     */
    @JsonProperty("txtItakushaCode")
    public void setTxtItakushaCode(TextBox txtItakushaCode) {
        this.txtItakushaCode = txtItakushaCode;
    }

    /*
     * gettxtItakushamei
     * @return txtItakushamei
     */
    @JsonProperty("txtItakushamei")
    public TextBox getTxtItakushamei() {
        return txtItakushamei;
    }

    /*
     * settxtItakushamei
     * @param txtItakushamei txtItakushamei
     */
    @JsonProperty("txtItakushamei")
    public void setTxtItakushamei(TextBox txtItakushamei) {
        this.txtItakushamei = txtItakushamei;
    }

    /*
     * gettxtFurikomiGroupCode
     * @return txtFurikomiGroupCode
     */
    @JsonProperty("txtFurikomiGroupCode")
    public TextBox getTxtFurikomiGroupCode() {
        return txtFurikomiGroupCode;
    }

    /*
     * settxtFurikomiGroupCode
     * @param txtFurikomiGroupCode txtFurikomiGroupCode
     */
    @JsonProperty("txtFurikomiGroupCode")
    public void setTxtFurikomiGroupCode(TextBox txtFurikomiGroupCode) {
        this.txtFurikomiGroupCode = txtFurikomiGroupCode;
    }

    /*
     * gettxtFurikomiGroupMeisho
     * @return txtFurikomiGroupMeisho
     */
    @JsonProperty("txtFurikomiGroupMeisho")
    public TextBox getTxtFurikomiGroupMeisho() {
        return txtFurikomiGroupMeisho;
    }

    /*
     * settxtFurikomiGroupMeisho
     * @param txtFurikomiGroupMeisho txtFurikomiGroupMeisho
     */
    @JsonProperty("txtFurikomiGroupMeisho")
    public void setTxtFurikomiGroupMeisho(TextBox txtFurikomiGroupMeisho) {
        this.txtFurikomiGroupMeisho = txtFurikomiGroupMeisho;
    }

    /*
     * getitakushaId
     * @return itakushaId
     */
    @JsonProperty("itakushaId")
    public RString getItakushaId() {
        return itakushaId;
    }

    /*
     * setitakushaId
     * @param itakushaId itakushaId
     */
    @JsonProperty("itakushaId")
    public void setItakushaId(RString itakushaId) {
        this.itakushaId = itakushaId;
    }

    // </editor-fold>
}
