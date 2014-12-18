package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IKyufuJissekiHeaderDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyufuJissekiHeader のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiHeaderDiv extends Panel implements IKyufuJissekiHeaderDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihoNo")
    private TextBox txtHihoNo;
    @JsonProperty("txtJuminShubetsu")
    private TextBox txtJuminShubetsu;
    @JsonProperty("txtYoKaigodo")
    private TextBox txtYoKaigodo;
    @JsonProperty("txtYukoKikan")
    private TextBoxDateRange txtYukoKikan;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtSeibetsu")
    private TextBox txtSeibetsu;
    @JsonProperty("txtSeinengappi")
    private TextBoxDate txtSeinengappi;
    @JsonProperty("txtTeikyoNengetsu")
    private TextBoxDate txtTeikyoNengetsu;
    @JsonProperty("txtJissekiKubun")
    private TextBox txtJissekiKubun;
    @JsonProperty("txtSeiriNo")
    private TextBox txtSeiriNo;
    @JsonProperty("txtHokensha")
    private TextBox txtHokensha;
    @JsonProperty("txtYoshikiNo")
    private TextBox txtYoshikiNo;
    @JsonProperty("txtJigyosha")
    private TextBox txtJigyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHihoNo")
    public TextBox getTxtHihoNo() {
        return txtHihoNo;
    }

    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBox txtHihoNo) {
        this.txtHihoNo=txtHihoNo;
    }

    @JsonProperty("txtJuminShubetsu")
    public TextBox getTxtJuminShubetsu() {
        return txtJuminShubetsu;
    }

    @JsonProperty("txtJuminShubetsu")
    public void setTxtJuminShubetsu(TextBox txtJuminShubetsu) {
        this.txtJuminShubetsu=txtJuminShubetsu;
    }

    @JsonProperty("txtYoKaigodo")
    public TextBox getTxtYoKaigodo() {
        return txtYoKaigodo;
    }

    @JsonProperty("txtYoKaigodo")
    public void setTxtYoKaigodo(TextBox txtYoKaigodo) {
        this.txtYoKaigodo=txtYoKaigodo;
    }

    @JsonProperty("txtYukoKikan")
    public TextBoxDateRange getTxtYukoKikan() {
        return txtYukoKikan;
    }

    @JsonProperty("txtYukoKikan")
    public void setTxtYukoKikan(TextBoxDateRange txtYukoKikan) {
        this.txtYukoKikan=txtYukoKikan;
    }

    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

    @JsonProperty("txtSeibetsu")
    public TextBox getTxtSeibetsu() {
        return txtSeibetsu;
    }

    @JsonProperty("txtSeibetsu")
    public void setTxtSeibetsu(TextBox txtSeibetsu) {
        this.txtSeibetsu=txtSeibetsu;
    }

    @JsonProperty("txtSeinengappi")
    public TextBoxDate getTxtSeinengappi() {
        return txtSeinengappi;
    }

    @JsonProperty("txtSeinengappi")
    public void setTxtSeinengappi(TextBoxDate txtSeinengappi) {
        this.txtSeinengappi=txtSeinengappi;
    }

    @JsonProperty("txtTeikyoNengetsu")
    public TextBoxDate getTxtTeikyoNengetsu() {
        return txtTeikyoNengetsu;
    }

    @JsonProperty("txtTeikyoNengetsu")
    public void setTxtTeikyoNengetsu(TextBoxDate txtTeikyoNengetsu) {
        this.txtTeikyoNengetsu=txtTeikyoNengetsu;
    }

    @JsonProperty("txtJissekiKubun")
    public TextBox getTxtJissekiKubun() {
        return txtJissekiKubun;
    }

    @JsonProperty("txtJissekiKubun")
    public void setTxtJissekiKubun(TextBox txtJissekiKubun) {
        this.txtJissekiKubun=txtJissekiKubun;
    }

    @JsonProperty("txtSeiriNo")
    public TextBox getTxtSeiriNo() {
        return txtSeiriNo;
    }

    @JsonProperty("txtSeiriNo")
    public void setTxtSeiriNo(TextBox txtSeiriNo) {
        this.txtSeiriNo=txtSeiriNo;
    }

    @JsonProperty("txtHokensha")
    public TextBox getTxtHokensha() {
        return txtHokensha;
    }

    @JsonProperty("txtHokensha")
    public void setTxtHokensha(TextBox txtHokensha) {
        this.txtHokensha=txtHokensha;
    }

    @JsonProperty("txtYoshikiNo")
    public TextBox getTxtYoshikiNo() {
        return txtYoshikiNo;
    }

    @JsonProperty("txtYoshikiNo")
    public void setTxtYoshikiNo(TextBox txtYoshikiNo) {
        this.txtYoshikiNo=txtYoshikiNo;
    }

    @JsonProperty("txtJigyosha")
    public TextBox getTxtJigyosha() {
        return txtJigyosha;
    }

    @JsonProperty("txtJigyosha")
    public void setTxtJigyosha(TextBox txtJigyosha) {
        this.txtJigyosha=txtJigyosha;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
