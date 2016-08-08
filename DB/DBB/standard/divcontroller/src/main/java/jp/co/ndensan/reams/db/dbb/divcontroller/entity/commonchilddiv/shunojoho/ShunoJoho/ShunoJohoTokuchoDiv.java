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
 * ShunoJohoTokucho のクラスファイル
 *
 * @reamsid_L DBB-5710-010 xuxin
 */
public class ShunoJohoTokuchoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokucho")
    private DataGrid<dgTokucho_Row> dgTokucho;
    @JsonProperty("txtTokuChoteiGeoukei")
    private TextBoxNum txtTokuChoteiGeoukei;
    @JsonProperty("txtTokuShunyuGokei")
    private TextBoxNum txtTokuShunyuGokei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTokucho
     * @return dgTokucho
     */
    @JsonProperty("dgTokucho")
    public DataGrid<dgTokucho_Row> getDgTokucho() {
        return dgTokucho;
    }

    /*
     * setdgTokucho
     * @param dgTokucho dgTokucho
     */
    @JsonProperty("dgTokucho")
    public void setDgTokucho(DataGrid<dgTokucho_Row> dgTokucho) {
        this.dgTokucho = dgTokucho;
    }

    /*
     * gettxtTokuChoteiGeoukei
     * @return txtTokuChoteiGeoukei
     */
    @JsonProperty("txtTokuChoteiGeoukei")
    public TextBoxNum getTxtTokuChoteiGeoukei() {
        return txtTokuChoteiGeoukei;
    }

    /*
     * settxtTokuChoteiGeoukei
     * @param txtTokuChoteiGeoukei txtTokuChoteiGeoukei
     */
    @JsonProperty("txtTokuChoteiGeoukei")
    public void setTxtTokuChoteiGeoukei(TextBoxNum txtTokuChoteiGeoukei) {
        this.txtTokuChoteiGeoukei = txtTokuChoteiGeoukei;
    }

    /*
     * gettxtTokuShunyuGokei
     * @return txtTokuShunyuGokei
     */
    @JsonProperty("txtTokuShunyuGokei")
    public TextBoxNum getTxtTokuShunyuGokei() {
        return txtTokuShunyuGokei;
    }

    /*
     * settxtTokuShunyuGokei
     * @param txtTokuShunyuGokei txtTokuShunyuGokei
     */
    @JsonProperty("txtTokuShunyuGokei")
    public void setTxtTokuShunyuGokei(TextBoxNum txtTokuShunyuGokei) {
        this.txtTokuShunyuGokei = txtTokuShunyuGokei;
    }

    // </editor-fold>
}
