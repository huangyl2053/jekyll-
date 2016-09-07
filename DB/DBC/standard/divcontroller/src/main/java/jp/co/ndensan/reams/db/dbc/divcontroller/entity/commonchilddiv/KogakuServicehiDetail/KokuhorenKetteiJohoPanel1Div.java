package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KokuhorenKetteiJohoPanel1 のクラスファイル
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class KokuhorenKetteiJohoPanel1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTsuchiBango")
    private TextBoxCode txtTsuchiBango;
    @JsonProperty("txtShikyuKubun")
    private TextBox txtShikyuKubun;
    @JsonProperty("txtKetteiYM")
    private TextBoxDate txtKetteiYM;
    @JsonProperty("txtShiharaiKingakuGokei")
    private TextBoxNum txtShiharaiKingakuGokei;
    @JsonProperty("txtKogakuShikyuGaku")
    private TextBoxNum txtKogakuShikyuGaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTsuchiBango
     * @return txtTsuchiBango
     */
    @JsonProperty("txtTsuchiBango")
    public TextBoxCode getTxtTsuchiBango() {
        return txtTsuchiBango;
    }

    /*
     * settxtTsuchiBango
     * @param txtTsuchiBango txtTsuchiBango
     */
    @JsonProperty("txtTsuchiBango")
    public void setTxtTsuchiBango(TextBoxCode txtTsuchiBango) {
        this.txtTsuchiBango = txtTsuchiBango;
    }

    /*
     * gettxtShikyuKubun
     * @return txtShikyuKubun
     */
    @JsonProperty("txtShikyuKubun")
    public TextBox getTxtShikyuKubun() {
        return txtShikyuKubun;
    }

    /*
     * settxtShikyuKubun
     * @param txtShikyuKubun txtShikyuKubun
     */
    @JsonProperty("txtShikyuKubun")
    public void setTxtShikyuKubun(TextBox txtShikyuKubun) {
        this.txtShikyuKubun = txtShikyuKubun;
    }

    /*
     * gettxtKetteiYM
     * @return txtKetteiYM
     */
    @JsonProperty("txtKetteiYM")
    public TextBoxDate getTxtKetteiYM() {
        return txtKetteiYM;
    }

    /*
     * settxtKetteiYM
     * @param txtKetteiYM txtKetteiYM
     */
    @JsonProperty("txtKetteiYM")
    public void setTxtKetteiYM(TextBoxDate txtKetteiYM) {
        this.txtKetteiYM = txtKetteiYM;
    }

    /*
     * gettxtShiharaiKingakuGokei
     * @return txtShiharaiKingakuGokei
     */
    @JsonProperty("txtShiharaiKingakuGokei")
    public TextBoxNum getTxtShiharaiKingakuGokei() {
        return txtShiharaiKingakuGokei;
    }

    /*
     * settxtShiharaiKingakuGokei
     * @param txtShiharaiKingakuGokei txtShiharaiKingakuGokei
     */
    @JsonProperty("txtShiharaiKingakuGokei")
    public void setTxtShiharaiKingakuGokei(TextBoxNum txtShiharaiKingakuGokei) {
        this.txtShiharaiKingakuGokei = txtShiharaiKingakuGokei;
    }

    /*
     * gettxtKogakuShikyuGaku
     * @return txtKogakuShikyuGaku
     */
    @JsonProperty("txtKogakuShikyuGaku")
    public TextBoxNum getTxtKogakuShikyuGaku() {
        return txtKogakuShikyuGaku;
    }

    /*
     * settxtKogakuShikyuGaku
     * @param txtKogakuShikyuGaku txtKogakuShikyuGaku
     */
    @JsonProperty("txtKogakuShikyuGaku")
    public void setTxtKogakuShikyuGaku(TextBoxNum txtKogakuShikyuGaku) {
        this.txtKogakuShikyuGaku = txtKogakuShikyuGaku;
    }

    // </editor-fold>
}
