package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * JikoFutangakuHoseiAtesaki のクラスファイル
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class JikoFutangakuHoseiAtesakiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtAtesakiShimei")
    private TextBox txtAtesakiShimei;
    @JsonProperty("txtAtesakiYubinNO")
    private TextBoxYubinNo txtAtesakiYubinNO;
    @JsonProperty("txtAtesakiJusho")
    private TextBox txtAtesakiJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtAtesakiShimei
     * @return txtAtesakiShimei
     */
    @JsonProperty("txtAtesakiShimei")
    public TextBox getTxtAtesakiShimei() {
        return txtAtesakiShimei;
    }

    /*
     * settxtAtesakiShimei
     * @param txtAtesakiShimei txtAtesakiShimei
     */
    @JsonProperty("txtAtesakiShimei")
    public void setTxtAtesakiShimei(TextBox txtAtesakiShimei) {
        this.txtAtesakiShimei = txtAtesakiShimei;
    }

    /*
     * gettxtAtesakiYubinNO
     * @return txtAtesakiYubinNO
     */
    @JsonProperty("txtAtesakiYubinNO")
    public TextBoxYubinNo getTxtAtesakiYubinNO() {
        return txtAtesakiYubinNO;
    }

    /*
     * settxtAtesakiYubinNO
     * @param txtAtesakiYubinNO txtAtesakiYubinNO
     */
    @JsonProperty("txtAtesakiYubinNO")
    public void setTxtAtesakiYubinNO(TextBoxYubinNo txtAtesakiYubinNO) {
        this.txtAtesakiYubinNO = txtAtesakiYubinNO;
    }

    /*
     * gettxtAtesakiJusho
     * @return txtAtesakiJusho
     */
    @JsonProperty("txtAtesakiJusho")
    public TextBox getTxtAtesakiJusho() {
        return txtAtesakiJusho;
    }

    /*
     * settxtAtesakiJusho
     * @param txtAtesakiJusho txtAtesakiJusho
     */
    @JsonProperty("txtAtesakiJusho")
    public void setTxtAtesakiJusho(TextBox txtAtesakiJusho) {
        this.txtAtesakiJusho = txtAtesakiJusho;
    }

    // </editor-fold>
}
