package jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuKanrihyoInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuKanrihyoInfo.dgMeisaiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyufuKanrihyoInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuKanrihyoInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSakuseiKubun")
    private TextBox txtSakuseiKubun;
    @JsonProperty("txtSakuseiYMD")
    private TextBoxDate txtSakuseiYMD;
    @JsonProperty("txtZengetsuNissu")
    private TextBoxNum txtZengetsuNissu;
    @JsonProperty("txtKeikakuSakuseiKubun")
    private TextBox txtKeikakuSakuseiKubun;
    @JsonProperty("txtShienJigyoshaNo")
    private TextBoxCode txtShienJigyoshaNo;
    @JsonProperty("txtShienJigyoshaName")
    private TextBox txtShienJigyoshaName;
    @JsonProperty("txtShikyuGendogaku")
    private TextBoxNum txtShikyuGendogaku;
    @JsonProperty("txtGendogakuTekiyoKikan")
    private TextBoxDateRange txtGendogakuTekiyoKikan;
    @JsonProperty("txtShiteiServiceShokei")
    private TextBoxNum txtShiteiServiceShokei;
    @JsonProperty("txtKijunServiceShokei")
    private TextBoxNum txtKijunServiceShokei;
    @JsonProperty("txtGokeiTanisu")
    private TextBoxNum txtGokeiTanisu;
    @JsonProperty("dgMeisaiList")
    private DataGrid<dgMeisaiList_Row> dgMeisaiList;
    @JsonProperty("txtTantoSenmonNo")
    private TextBoxCode txtTantoSenmonNo;
    @JsonProperty("txtItakuJigyoshaNo")
    private TextBoxCode txtItakuJigyoshaNo;
    @JsonProperty("txtItakuJigyoshaName")
    private TextBox txtItakuJigyoshaName;
    @JsonProperty("txtItakuSenmonNo")
    private TextBoxCode txtItakuSenmonNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSakuseiKubun")
    public TextBox getTxtSakuseiKubun() {
        return txtSakuseiKubun;
    }

    @JsonProperty("txtSakuseiKubun")
    public void setTxtSakuseiKubun(TextBox txtSakuseiKubun) {
        this.txtSakuseiKubun=txtSakuseiKubun;
    }

    @JsonProperty("txtSakuseiYMD")
    public TextBoxDate getTxtSakuseiYMD() {
        return txtSakuseiYMD;
    }

    @JsonProperty("txtSakuseiYMD")
    public void setTxtSakuseiYMD(TextBoxDate txtSakuseiYMD) {
        this.txtSakuseiYMD=txtSakuseiYMD;
    }

    @JsonProperty("txtZengetsuNissu")
    public TextBoxNum getTxtZengetsuNissu() {
        return txtZengetsuNissu;
    }

    @JsonProperty("txtZengetsuNissu")
    public void setTxtZengetsuNissu(TextBoxNum txtZengetsuNissu) {
        this.txtZengetsuNissu=txtZengetsuNissu;
    }

    @JsonProperty("txtKeikakuSakuseiKubun")
    public TextBox getTxtKeikakuSakuseiKubun() {
        return txtKeikakuSakuseiKubun;
    }

    @JsonProperty("txtKeikakuSakuseiKubun")
    public void setTxtKeikakuSakuseiKubun(TextBox txtKeikakuSakuseiKubun) {
        this.txtKeikakuSakuseiKubun=txtKeikakuSakuseiKubun;
    }

    @JsonProperty("txtShienJigyoshaNo")
    public TextBoxCode getTxtShienJigyoshaNo() {
        return txtShienJigyoshaNo;
    }

    @JsonProperty("txtShienJigyoshaNo")
    public void setTxtShienJigyoshaNo(TextBoxCode txtShienJigyoshaNo) {
        this.txtShienJigyoshaNo=txtShienJigyoshaNo;
    }

    @JsonProperty("txtShienJigyoshaName")
    public TextBox getTxtShienJigyoshaName() {
        return txtShienJigyoshaName;
    }

    @JsonProperty("txtShienJigyoshaName")
    public void setTxtShienJigyoshaName(TextBox txtShienJigyoshaName) {
        this.txtShienJigyoshaName=txtShienJigyoshaName;
    }

    @JsonProperty("txtShikyuGendogaku")
    public TextBoxNum getTxtShikyuGendogaku() {
        return txtShikyuGendogaku;
    }

    @JsonProperty("txtShikyuGendogaku")
    public void setTxtShikyuGendogaku(TextBoxNum txtShikyuGendogaku) {
        this.txtShikyuGendogaku=txtShikyuGendogaku;
    }

    @JsonProperty("txtGendogakuTekiyoKikan")
    public TextBoxDateRange getTxtGendogakuTekiyoKikan() {
        return txtGendogakuTekiyoKikan;
    }

    @JsonProperty("txtGendogakuTekiyoKikan")
    public void setTxtGendogakuTekiyoKikan(TextBoxDateRange txtGendogakuTekiyoKikan) {
        this.txtGendogakuTekiyoKikan=txtGendogakuTekiyoKikan;
    }

    @JsonProperty("txtShiteiServiceShokei")
    public TextBoxNum getTxtShiteiServiceShokei() {
        return txtShiteiServiceShokei;
    }

    @JsonProperty("txtShiteiServiceShokei")
    public void setTxtShiteiServiceShokei(TextBoxNum txtShiteiServiceShokei) {
        this.txtShiteiServiceShokei=txtShiteiServiceShokei;
    }

    @JsonProperty("txtKijunServiceShokei")
    public TextBoxNum getTxtKijunServiceShokei() {
        return txtKijunServiceShokei;
    }

    @JsonProperty("txtKijunServiceShokei")
    public void setTxtKijunServiceShokei(TextBoxNum txtKijunServiceShokei) {
        this.txtKijunServiceShokei=txtKijunServiceShokei;
    }

    @JsonProperty("txtGokeiTanisu")
    public TextBoxNum getTxtGokeiTanisu() {
        return txtGokeiTanisu;
    }

    @JsonProperty("txtGokeiTanisu")
    public void setTxtGokeiTanisu(TextBoxNum txtGokeiTanisu) {
        this.txtGokeiTanisu=txtGokeiTanisu;
    }

    @JsonProperty("dgMeisaiList")
    public DataGrid<dgMeisaiList_Row> getDgMeisaiList() {
        return dgMeisaiList;
    }

    @JsonProperty("dgMeisaiList")
    public void setDgMeisaiList(DataGrid<dgMeisaiList_Row> dgMeisaiList) {
        this.dgMeisaiList=dgMeisaiList;
    }

    @JsonProperty("txtTantoSenmonNo")
    public TextBoxCode getTxtTantoSenmonNo() {
        return txtTantoSenmonNo;
    }

    @JsonProperty("txtTantoSenmonNo")
    public void setTxtTantoSenmonNo(TextBoxCode txtTantoSenmonNo) {
        this.txtTantoSenmonNo=txtTantoSenmonNo;
    }

    @JsonProperty("txtItakuJigyoshaNo")
    public TextBoxCode getTxtItakuJigyoshaNo() {
        return txtItakuJigyoshaNo;
    }

    @JsonProperty("txtItakuJigyoshaNo")
    public void setTxtItakuJigyoshaNo(TextBoxCode txtItakuJigyoshaNo) {
        this.txtItakuJigyoshaNo=txtItakuJigyoshaNo;
    }

    @JsonProperty("txtItakuJigyoshaName")
    public TextBox getTxtItakuJigyoshaName() {
        return txtItakuJigyoshaName;
    }

    @JsonProperty("txtItakuJigyoshaName")
    public void setTxtItakuJigyoshaName(TextBox txtItakuJigyoshaName) {
        this.txtItakuJigyoshaName=txtItakuJigyoshaName;
    }

    @JsonProperty("txtItakuSenmonNo")
    public TextBoxCode getTxtItakuSenmonNo() {
        return txtItakuSenmonNo;
    }

    @JsonProperty("txtItakuSenmonNo")
    public void setTxtItakuSenmonNo(TextBoxCode txtItakuSenmonNo) {
        this.txtItakuSenmonNo=txtItakuSenmonNo;
    }

}
