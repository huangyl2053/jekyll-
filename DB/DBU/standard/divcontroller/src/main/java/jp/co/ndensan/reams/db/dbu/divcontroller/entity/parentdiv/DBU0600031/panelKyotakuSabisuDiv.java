package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelKyotakuSabisu のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelKyotakuSabisuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTodokede")
    private TextBoxDate txtTodokede;
    @JsonProperty("txtKeikakuSakuseiKubun")
    private TextBox txtKeikakuSakuseiKubun;
    @JsonProperty("txtTekyouKikan")
    private TextBoxDateRange txtTekyouKikan;
    @JsonProperty("txtZigyoushaKodo")
    private TextBoxCode txtZigyoushaKodo;
    @JsonProperty("txtZigyoushaMesai")
    private TextBox txtZigyoushaMesai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTodokede
     * @return txtTodokede
     */
    @JsonProperty("txtTodokede")
    public TextBoxDate getTxtTodokede() {
        return txtTodokede;
    }

    /*
     * settxtTodokede
     * @param txtTodokede txtTodokede
     */
    @JsonProperty("txtTodokede")
    public void setTxtTodokede(TextBoxDate txtTodokede) {
        this.txtTodokede = txtTodokede;
    }

    /*
     * gettxtKeikakuSakuseiKubun
     * @return txtKeikakuSakuseiKubun
     */
    @JsonProperty("txtKeikakuSakuseiKubun")
    public TextBox getTxtKeikakuSakuseiKubun() {
        return txtKeikakuSakuseiKubun;
    }

    /*
     * settxtKeikakuSakuseiKubun
     * @param txtKeikakuSakuseiKubun txtKeikakuSakuseiKubun
     */
    @JsonProperty("txtKeikakuSakuseiKubun")
    public void setTxtKeikakuSakuseiKubun(TextBox txtKeikakuSakuseiKubun) {
        this.txtKeikakuSakuseiKubun = txtKeikakuSakuseiKubun;
    }

    /*
     * gettxtTekyouKikan
     * @return txtTekyouKikan
     */
    @JsonProperty("txtTekyouKikan")
    public TextBoxDateRange getTxtTekyouKikan() {
        return txtTekyouKikan;
    }

    /*
     * settxtTekyouKikan
     * @param txtTekyouKikan txtTekyouKikan
     */
    @JsonProperty("txtTekyouKikan")
    public void setTxtTekyouKikan(TextBoxDateRange txtTekyouKikan) {
        this.txtTekyouKikan = txtTekyouKikan;
    }

    /*
     * gettxtZigyoushaKodo
     * @return txtZigyoushaKodo
     */
    @JsonProperty("txtZigyoushaKodo")
    public TextBoxCode getTxtZigyoushaKodo() {
        return txtZigyoushaKodo;
    }

    /*
     * settxtZigyoushaKodo
     * @param txtZigyoushaKodo txtZigyoushaKodo
     */
    @JsonProperty("txtZigyoushaKodo")
    public void setTxtZigyoushaKodo(TextBoxCode txtZigyoushaKodo) {
        this.txtZigyoushaKodo = txtZigyoushaKodo;
    }

    /*
     * gettxtZigyoushaMesai
     * @return txtZigyoushaMesai
     */
    @JsonProperty("txtZigyoushaMesai")
    public TextBox getTxtZigyoushaMesai() {
        return txtZigyoushaMesai;
    }

    /*
     * settxtZigyoushaMesai
     * @param txtZigyoushaMesai txtZigyoushaMesai
     */
    @JsonProperty("txtZigyoushaMesai")
    public void setTxtZigyoushaMesai(TextBox txtZigyoushaMesai) {
        this.txtZigyoushaMesai = txtZigyoushaMesai;
    }

    // </editor-fold>
}
