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
 * JikoFutangakuHoseiTotsugo1 のクラスファイル
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class JikoFutangakuHoseiTotsugo1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKoukiHokenjaNO")
    private TextBox txtKoukiHokenjaNO;
    @JsonProperty("txtKoukiHihokenshaNO")
    private TextBox txtKoukiHihokenshaNO;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKoukiHokenjaNO
     * @return txtKoukiHokenjaNO
     */
    @JsonProperty("txtKoukiHokenjaNO")
    public TextBox getTxtKoukiHokenjaNO() {
        return txtKoukiHokenjaNO;
    }

    /*
     * settxtKoukiHokenjaNO
     * @param txtKoukiHokenjaNO txtKoukiHokenjaNO
     */
    @JsonProperty("txtKoukiHokenjaNO")
    public void setTxtKoukiHokenjaNO(TextBox txtKoukiHokenjaNO) {
        this.txtKoukiHokenjaNO = txtKoukiHokenjaNO;
    }

    /*
     * gettxtKoukiHihokenshaNO
     * @return txtKoukiHihokenshaNO
     */
    @JsonProperty("txtKoukiHihokenshaNO")
    public TextBox getTxtKoukiHihokenshaNO() {
        return txtKoukiHihokenshaNO;
    }

    /*
     * settxtKoukiHihokenshaNO
     * @param txtKoukiHihokenshaNO txtKoukiHihokenshaNO
     */
    @JsonProperty("txtKoukiHihokenshaNO")
    public void setTxtKoukiHihokenshaNO(TextBox txtKoukiHihokenshaNO) {
        this.txtKoukiHihokenshaNO = txtKoukiHihokenshaNO;
    }

    // </editor-fold>
}
