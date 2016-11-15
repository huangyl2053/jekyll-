package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * GaigyoShisetsuRenrakusaki のクラスファイル 
 * 
 * @author 自動生成
 */
public class GaigyoShisetsuRenrakusakiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShisetsuMeisdho")
    private TextBox txtShisetsuMeisdho;
    @JsonProperty("txtShisetsuYubinNo")
    private TextBoxYubinNo txtShisetsuYubinNo;
    @JsonProperty("txtShisetsuJusho")
    private TextBoxJusho txtShisetsuJusho;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShisetsuMeisdho
     * @return txtShisetsuMeisdho
     */
    @JsonProperty("txtShisetsuMeisdho")
    public TextBox getTxtShisetsuMeisdho() {
        return txtShisetsuMeisdho;
    }

    /*
     * settxtShisetsuMeisdho
     * @param txtShisetsuMeisdho txtShisetsuMeisdho
     */
    @JsonProperty("txtShisetsuMeisdho")
    public void setTxtShisetsuMeisdho(TextBox txtShisetsuMeisdho) {
        this.txtShisetsuMeisdho = txtShisetsuMeisdho;
    }

    /*
     * gettxtShisetsuYubinNo
     * @return txtShisetsuYubinNo
     */
    @JsonProperty("txtShisetsuYubinNo")
    public TextBoxYubinNo getTxtShisetsuYubinNo() {
        return txtShisetsuYubinNo;
    }

    /*
     * settxtShisetsuYubinNo
     * @param txtShisetsuYubinNo txtShisetsuYubinNo
     */
    @JsonProperty("txtShisetsuYubinNo")
    public void setTxtShisetsuYubinNo(TextBoxYubinNo txtShisetsuYubinNo) {
        this.txtShisetsuYubinNo = txtShisetsuYubinNo;
    }

    /*
     * gettxtShisetsuJusho
     * @return txtShisetsuJusho
     */
    @JsonProperty("txtShisetsuJusho")
    public TextBoxJusho getTxtShisetsuJusho() {
        return txtShisetsuJusho;
    }

    /*
     * settxtShisetsuJusho
     * @param txtShisetsuJusho txtShisetsuJusho
     */
    @JsonProperty("txtShisetsuJusho")
    public void setTxtShisetsuJusho(TextBoxJusho txtShisetsuJusho) {
        this.txtShisetsuJusho = txtShisetsuJusho;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    // </editor-fold>
}
