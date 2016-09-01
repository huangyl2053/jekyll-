package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;

/**
 * KaigoSienSenmoninToroku のクラスファイル
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class KaigoSienSenmoninTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaigoSienSenmoninBango")
    private TextBoxCode txtKaigoSienSenmoninBango;
    @JsonProperty("txtKaigoSienSenmoninShimei")
    private TextBox txtKaigoSienSenmoninShimei;
    @JsonProperty("txtKaingoSienSenmoninShimeiKana")
    private TextBoxKana txtKaingoSienSenmoninShimeiKana;
    @JsonProperty("txtYukoKikan")
    private TextBoxDateRange txtYukoKikan;
    @JsonProperty("ccdShozokuJigyosha")
    private ShisetsuJohoCommonChildDivDiv ccdShozokuJigyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKaigoSienSenmoninBango
     * @return txtKaigoSienSenmoninBango
     */
    @JsonProperty("txtKaigoSienSenmoninBango")
    public TextBoxCode getTxtKaigoSienSenmoninBango() {
        return txtKaigoSienSenmoninBango;
    }

    /*
     * settxtKaigoSienSenmoninBango
     * @param txtKaigoSienSenmoninBango txtKaigoSienSenmoninBango
     */
    @JsonProperty("txtKaigoSienSenmoninBango")
    public void setTxtKaigoSienSenmoninBango(TextBoxCode txtKaigoSienSenmoninBango) {
        this.txtKaigoSienSenmoninBango = txtKaigoSienSenmoninBango;
    }

    /*
     * gettxtKaigoSienSenmoninShimei
     * @return txtKaigoSienSenmoninShimei
     */
    @JsonProperty("txtKaigoSienSenmoninShimei")
    public TextBox getTxtKaigoSienSenmoninShimei() {
        return txtKaigoSienSenmoninShimei;
    }

    /*
     * settxtKaigoSienSenmoninShimei
     * @param txtKaigoSienSenmoninShimei txtKaigoSienSenmoninShimei
     */
    @JsonProperty("txtKaigoSienSenmoninShimei")
    public void setTxtKaigoSienSenmoninShimei(TextBox txtKaigoSienSenmoninShimei) {
        this.txtKaigoSienSenmoninShimei = txtKaigoSienSenmoninShimei;
    }

    /*
     * gettxtKaingoSienSenmoninShimeiKana
     * @return txtKaingoSienSenmoninShimeiKana
     */
    @JsonProperty("txtKaingoSienSenmoninShimeiKana")
    public TextBoxKana getTxtKaingoSienSenmoninShimeiKana() {
        return txtKaingoSienSenmoninShimeiKana;
    }

    /*
     * settxtKaingoSienSenmoninShimeiKana
     * @param txtKaingoSienSenmoninShimeiKana txtKaingoSienSenmoninShimeiKana
     */
    @JsonProperty("txtKaingoSienSenmoninShimeiKana")
    public void setTxtKaingoSienSenmoninShimeiKana(TextBoxKana txtKaingoSienSenmoninShimeiKana) {
        this.txtKaingoSienSenmoninShimeiKana = txtKaingoSienSenmoninShimeiKana;
    }

    /*
     * gettxtYukoKikan
     * @return txtYukoKikan
     */
    @JsonProperty("txtYukoKikan")
    public TextBoxDateRange getTxtYukoKikan() {
        return txtYukoKikan;
    }

    /*
     * settxtYukoKikan
     * @param txtYukoKikan txtYukoKikan
     */
    @JsonProperty("txtYukoKikan")
    public void setTxtYukoKikan(TextBoxDateRange txtYukoKikan) {
        this.txtYukoKikan = txtYukoKikan;
    }

    /*
     * getccdShozokuJigyosha
     * @return ccdShozokuJigyosha
     */
    @JsonProperty("ccdShozokuJigyosha")
    public IShisetsuJohoCommonChildDiv getCcdShozokuJigyosha() {
        return ccdShozokuJigyosha;
    }

    // </editor-fold>
}
