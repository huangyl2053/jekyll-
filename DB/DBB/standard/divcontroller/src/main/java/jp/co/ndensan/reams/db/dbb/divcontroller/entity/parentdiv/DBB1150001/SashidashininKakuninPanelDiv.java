package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001;
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
 * SashidashininKakuninPanel のクラスファイル
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class SashidashininKakuninPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSashidashiNinYubinNo")
    private TextBoxYubinNo txtSashidashiNinYubinNo;
    @JsonProperty("txtSashidashiNinJusho")
    private TextBox txtSashidashiNinJusho;
    @JsonProperty("txtSashidashiNinTanto")
    private TextBox txtSashidashiNinTanto;
    @JsonProperty("txtSashidashiNinTellNo")
    private TextBoxTelNo txtSashidashiNinTellNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSashidashiNinYubinNo
     * @return txtSashidashiNinYubinNo
     */
    @JsonProperty("txtSashidashiNinYubinNo")
    public TextBoxYubinNo getTxtSashidashiNinYubinNo() {
        return txtSashidashiNinYubinNo;
    }

    /*
     * settxtSashidashiNinYubinNo
     * @param txtSashidashiNinYubinNo txtSashidashiNinYubinNo
     */
    @JsonProperty("txtSashidashiNinYubinNo")
    public void setTxtSashidashiNinYubinNo(TextBoxYubinNo txtSashidashiNinYubinNo) {
        this.txtSashidashiNinYubinNo = txtSashidashiNinYubinNo;
    }

    /*
     * gettxtSashidashiNinJusho
     * @return txtSashidashiNinJusho
     */
    @JsonProperty("txtSashidashiNinJusho")
    public TextBox getTxtSashidashiNinJusho() {
        return txtSashidashiNinJusho;
    }

    /*
     * settxtSashidashiNinJusho
     * @param txtSashidashiNinJusho txtSashidashiNinJusho
     */
    @JsonProperty("txtSashidashiNinJusho")
    public void setTxtSashidashiNinJusho(TextBox txtSashidashiNinJusho) {
        this.txtSashidashiNinJusho = txtSashidashiNinJusho;
    }

    /*
     * gettxtSashidashiNinTanto
     * @return txtSashidashiNinTanto
     */
    @JsonProperty("txtSashidashiNinTanto")
    public TextBox getTxtSashidashiNinTanto() {
        return txtSashidashiNinTanto;
    }

    /*
     * settxtSashidashiNinTanto
     * @param txtSashidashiNinTanto txtSashidashiNinTanto
     */
    @JsonProperty("txtSashidashiNinTanto")
    public void setTxtSashidashiNinTanto(TextBox txtSashidashiNinTanto) {
        this.txtSashidashiNinTanto = txtSashidashiNinTanto;
    }

    /*
     * gettxtSashidashiNinTellNo
     * @return txtSashidashiNinTellNo
     */
    @JsonProperty("txtSashidashiNinTellNo")
    public TextBoxTelNo getTxtSashidashiNinTellNo() {
        return txtSashidashiNinTellNo;
    }

    /*
     * settxtSashidashiNinTellNo
     * @param txtSashidashiNinTellNo txtSashidashiNinTellNo
     */
    @JsonProperty("txtSashidashiNinTellNo")
    public void setTxtSashidashiNinTellNo(TextBoxTelNo txtSashidashiNinTellNo) {
        this.txtSashidashiNinTellNo = txtSashidashiNinTellNo;
    }

    // </editor-fold>
}
