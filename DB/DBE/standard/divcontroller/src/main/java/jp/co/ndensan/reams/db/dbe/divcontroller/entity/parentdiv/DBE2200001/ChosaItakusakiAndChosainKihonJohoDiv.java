package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaItakusakiAndChosainKihonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakusakiAndChosainKihonJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChosaItakusakiCode")
    private TextBoxCode txtChosaItakusakiCode;
    @JsonProperty("txtChosaItakusakiMeisho")
    private TextBox txtChosaItakusakiMeisho;
    @JsonProperty("txtChosaItakusakiChiku")
    private TextBox txtChosaItakusakiChiku;
    @JsonProperty("txtChosainCode")
    private TextBoxCode txtChosainCode;
    @JsonProperty("txtChosainShimei")
    private TextBox txtChosainShimei;
    @JsonProperty("txtChosainChiku")
    private TextBox txtChosainChiku;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChosaItakusakiCode
     * @return txtChosaItakusakiCode
     */
    @JsonProperty("txtChosaItakusakiCode")
    public TextBoxCode getTxtChosaItakusakiCode() {
        return txtChosaItakusakiCode;
    }

    /*
     * settxtChosaItakusakiCode
     * @param txtChosaItakusakiCode txtChosaItakusakiCode
     */
    @JsonProperty("txtChosaItakusakiCode")
    public void setTxtChosaItakusakiCode(TextBoxCode txtChosaItakusakiCode) {
        this.txtChosaItakusakiCode = txtChosaItakusakiCode;
    }

    /*
     * gettxtChosaItakusakiMeisho
     * @return txtChosaItakusakiMeisho
     */
    @JsonProperty("txtChosaItakusakiMeisho")
    public TextBox getTxtChosaItakusakiMeisho() {
        return txtChosaItakusakiMeisho;
    }

    /*
     * settxtChosaItakusakiMeisho
     * @param txtChosaItakusakiMeisho txtChosaItakusakiMeisho
     */
    @JsonProperty("txtChosaItakusakiMeisho")
    public void setTxtChosaItakusakiMeisho(TextBox txtChosaItakusakiMeisho) {
        this.txtChosaItakusakiMeisho = txtChosaItakusakiMeisho;
    }

    /*
     * gettxtChosaItakusakiChiku
     * @return txtChosaItakusakiChiku
     */
    @JsonProperty("txtChosaItakusakiChiku")
    public TextBox getTxtChosaItakusakiChiku() {
        return txtChosaItakusakiChiku;
    }

    /*
     * settxtChosaItakusakiChiku
     * @param txtChosaItakusakiChiku txtChosaItakusakiChiku
     */
    @JsonProperty("txtChosaItakusakiChiku")
    public void setTxtChosaItakusakiChiku(TextBox txtChosaItakusakiChiku) {
        this.txtChosaItakusakiChiku = txtChosaItakusakiChiku;
    }

    /*
     * gettxtChosainCode
     * @return txtChosainCode
     */
    @JsonProperty("txtChosainCode")
    public TextBoxCode getTxtChosainCode() {
        return txtChosainCode;
    }

    /*
     * settxtChosainCode
     * @param txtChosainCode txtChosainCode
     */
    @JsonProperty("txtChosainCode")
    public void setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.txtChosainCode = txtChosainCode;
    }

    /*
     * gettxtChosainShimei
     * @return txtChosainShimei
     */
    @JsonProperty("txtChosainShimei")
    public TextBox getTxtChosainShimei() {
        return txtChosainShimei;
    }

    /*
     * settxtChosainShimei
     * @param txtChosainShimei txtChosainShimei
     */
    @JsonProperty("txtChosainShimei")
    public void setTxtChosainShimei(TextBox txtChosainShimei) {
        this.txtChosainShimei = txtChosainShimei;
    }

    /*
     * gettxtChosainChiku
     * @return txtChosainChiku
     */
    @JsonProperty("txtChosainChiku")
    public TextBox getTxtChosainChiku() {
        return txtChosainChiku;
    }

    /*
     * settxtChosainChiku
     * @param txtChosainChiku txtChosainChiku
     */
    @JsonProperty("txtChosainChiku")
    public void setTxtChosainChiku(TextBox txtChosainChiku) {
        this.txtChosainChiku = txtChosainChiku;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}
