package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.shunojoho.ShunoJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ShunoJohoFucho のクラスファイル
 *
 * @reamsid_L DBB-5710-010 xuxin
 */
public class ShunoJohoFuchoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgFucho")
    private DataGrid<dgFucho_Row> dgFucho;
    @JsonProperty("txtFuChoteiGokei")
    private TextBoxNum txtFuChoteiGokei;
    @JsonProperty("txtFuShunyuGokei")
    private TextBoxNum txtFuShunyuGokei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgFucho
     * @return dgFucho
     */
    @JsonProperty("dgFucho")
    public DataGrid<dgFucho_Row> getDgFucho() {
        return dgFucho;
    }

    /*
     * setdgFucho
     * @param dgFucho dgFucho
     */
    @JsonProperty("dgFucho")
    public void setDgFucho(DataGrid<dgFucho_Row> dgFucho) {
        this.dgFucho = dgFucho;
    }

    /*
     * gettxtFuChoteiGokei
     * @return txtFuChoteiGokei
     */
    @JsonProperty("txtFuChoteiGokei")
    public TextBoxNum getTxtFuChoteiGokei() {
        return txtFuChoteiGokei;
    }

    /*
     * settxtFuChoteiGokei
     * @param txtFuChoteiGokei txtFuChoteiGokei
     */
    @JsonProperty("txtFuChoteiGokei")
    public void setTxtFuChoteiGokei(TextBoxNum txtFuChoteiGokei) {
        this.txtFuChoteiGokei = txtFuChoteiGokei;
    }

    /*
     * gettxtFuShunyuGokei
     * @return txtFuShunyuGokei
     */
    @JsonProperty("txtFuShunyuGokei")
    public TextBoxNum getTxtFuShunyuGokei() {
        return txtFuShunyuGokei;
    }

    /*
     * settxtFuShunyuGokei
     * @param txtFuShunyuGokei txtFuShunyuGokei
     */
    @JsonProperty("txtFuShunyuGokei")
    public void setTxtFuShunyuGokei(TextBoxNum txtFuShunyuGokei) {
        this.txtFuShunyuGokei = txtFuShunyuGokei;
    }

    // </editor-fold>
}
