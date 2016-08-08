package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * JikoFutangakuHoseiTotsugo2 のクラスファイル
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class JikoFutangakuHoseiTotsugo2Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKokuhoHokenjaNO")
    private TextBox txtKokuhoHokenjaNO;
    @JsonProperty("txtKokuhoHihokenshaKojinNO")
    private TextBox txtKokuhoHihokenshaKojinNO;
    @JsonProperty("txtKokuhoHihokenshashouNO")
    private TextBox txtKokuhoHihokenshashouNO;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKokuhoHokenjaNO
     * @return txtKokuhoHokenjaNO
     */
    @JsonProperty("txtKokuhoHokenjaNO")
    public TextBox getTxtKokuhoHokenjaNO() {
        return txtKokuhoHokenjaNO;
    }

    /*
     * settxtKokuhoHokenjaNO
     * @param txtKokuhoHokenjaNO txtKokuhoHokenjaNO
     */
    @JsonProperty("txtKokuhoHokenjaNO")
    public void setTxtKokuhoHokenjaNO(TextBox txtKokuhoHokenjaNO) {
        this.txtKokuhoHokenjaNO = txtKokuhoHokenjaNO;
    }

    /*
     * gettxtKokuhoHihokenshaKojinNO
     * @return txtKokuhoHihokenshaKojinNO
     */
    @JsonProperty("txtKokuhoHihokenshaKojinNO")
    public TextBox getTxtKokuhoHihokenshaKojinNO() {
        return txtKokuhoHihokenshaKojinNO;
    }

    /*
     * settxtKokuhoHihokenshaKojinNO
     * @param txtKokuhoHihokenshaKojinNO txtKokuhoHihokenshaKojinNO
     */
    @JsonProperty("txtKokuhoHihokenshaKojinNO")
    public void setTxtKokuhoHihokenshaKojinNO(TextBox txtKokuhoHihokenshaKojinNO) {
        this.txtKokuhoHihokenshaKojinNO = txtKokuhoHihokenshaKojinNO;
    }

    /*
     * gettxtKokuhoHihokenshashouNO
     * @return txtKokuhoHihokenshashouNO
     */
    @JsonProperty("txtKokuhoHihokenshashouNO")
    public TextBox getTxtKokuhoHihokenshashouNO() {
        return txtKokuhoHihokenshashouNO;
    }

    /*
     * settxtKokuhoHihokenshashouNO
     * @param txtKokuhoHihokenshashouNO txtKokuhoHihokenshashouNO
     */
    @JsonProperty("txtKokuhoHihokenshashouNO")
    public void setTxtKokuhoHihokenshashouNO(TextBox txtKokuhoHihokenshashouNO) {
        this.txtKokuhoHihokenshashouNO = txtKokuhoHihokenshashouNO;
    }

    // </editor-fold>
}
