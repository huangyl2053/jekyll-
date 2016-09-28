package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * ShinseiDaihyosha のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class ShinseiDaihyoshaDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtDaihyoshaShimei")
    private TextBox txtDaihyoshaShimei;
    @JsonProperty("txtDaihyoshaTelNo")
    private TextBoxTelNo txtDaihyoshaTelNo;
    @JsonProperty("txtDaihyoshaYubinNo")
    private TextBoxYubinNo txtDaihyoshaYubinNo;
    @JsonProperty("txtDaihyoshaJusho")
    private TextBox txtDaihyoshaJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtDaihyoshaShimei
     * @return txtDaihyoshaShimei
     */
    @JsonProperty("txtDaihyoshaShimei")
    public TextBox getTxtDaihyoshaShimei() {
        return txtDaihyoshaShimei;
    }

    /*
     * settxtDaihyoshaShimei
     * @param txtDaihyoshaShimei txtDaihyoshaShimei
     */
    @JsonProperty("txtDaihyoshaShimei")
    public void setTxtDaihyoshaShimei(TextBox txtDaihyoshaShimei) {
        this.txtDaihyoshaShimei = txtDaihyoshaShimei;
    }

    /*
     * gettxtDaihyoshaTelNo
     * @return txtDaihyoshaTelNo
     */
    @JsonProperty("txtDaihyoshaTelNo")
    public TextBoxTelNo getTxtDaihyoshaTelNo() {
        return txtDaihyoshaTelNo;
    }

    /*
     * settxtDaihyoshaTelNo
     * @param txtDaihyoshaTelNo txtDaihyoshaTelNo
     */
    @JsonProperty("txtDaihyoshaTelNo")
    public void setTxtDaihyoshaTelNo(TextBoxTelNo txtDaihyoshaTelNo) {
        this.txtDaihyoshaTelNo = txtDaihyoshaTelNo;
    }

    /*
     * gettxtDaihyoshaYubinNo
     * @return txtDaihyoshaYubinNo
     */
    @JsonProperty("txtDaihyoshaYubinNo")
    public TextBoxYubinNo getTxtDaihyoshaYubinNo() {
        return txtDaihyoshaYubinNo;
    }

    /*
     * settxtDaihyoshaYubinNo
     * @param txtDaihyoshaYubinNo txtDaihyoshaYubinNo
     */
    @JsonProperty("txtDaihyoshaYubinNo")
    public void setTxtDaihyoshaYubinNo(TextBoxYubinNo txtDaihyoshaYubinNo) {
        this.txtDaihyoshaYubinNo = txtDaihyoshaYubinNo;
    }

    /*
     * gettxtDaihyoshaJusho
     * @return txtDaihyoshaJusho
     */
    @JsonProperty("txtDaihyoshaJusho")
    public TextBox getTxtDaihyoshaJusho() {
        return txtDaihyoshaJusho;
    }

    /*
     * settxtDaihyoshaJusho
     * @param txtDaihyoshaJusho txtDaihyoshaJusho
     */
    @JsonProperty("txtDaihyoshaJusho")
    public void setTxtDaihyoshaJusho(TextBox txtDaihyoshaJusho) {
        this.txtDaihyoshaJusho = txtDaihyoshaJusho;
    }

    // </editor-fold>
}
