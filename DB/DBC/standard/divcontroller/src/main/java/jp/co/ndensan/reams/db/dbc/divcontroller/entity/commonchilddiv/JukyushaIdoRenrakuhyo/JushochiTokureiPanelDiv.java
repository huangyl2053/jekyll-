package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.IHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.HokenshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JushochiTokureiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JushochiTokureiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJushochiTokureiTaishoshaKubun")
    private RadioButton radJushochiTokureiTaishoshaKubun;
    @JsonProperty("txtJushochiTokureiTekiyoDateRange")
    private TextBoxDateRange txtJushochiTokureiTekiyoDateRange;
    @JsonProperty("ccdHokenshaJoho")
    private HokenshaJohoDiv ccdHokenshaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJushochiTokureiTaishoshaKubun
     * @return radJushochiTokureiTaishoshaKubun
     */
    @JsonProperty("radJushochiTokureiTaishoshaKubun")
    public RadioButton getRadJushochiTokureiTaishoshaKubun() {
        return radJushochiTokureiTaishoshaKubun;
    }

    /*
     * setradJushochiTokureiTaishoshaKubun
     * @param radJushochiTokureiTaishoshaKubun radJushochiTokureiTaishoshaKubun
     */
    @JsonProperty("radJushochiTokureiTaishoshaKubun")
    public void setRadJushochiTokureiTaishoshaKubun(RadioButton radJushochiTokureiTaishoshaKubun) {
        this.radJushochiTokureiTaishoshaKubun = radJushochiTokureiTaishoshaKubun;
    }

    /*
     * gettxtJushochiTokureiTekiyoDateRange
     * @return txtJushochiTokureiTekiyoDateRange
     */
    @JsonProperty("txtJushochiTokureiTekiyoDateRange")
    public TextBoxDateRange getTxtJushochiTokureiTekiyoDateRange() {
        return txtJushochiTokureiTekiyoDateRange;
    }

    /*
     * settxtJushochiTokureiTekiyoDateRange
     * @param txtJushochiTokureiTekiyoDateRange txtJushochiTokureiTekiyoDateRange
     */
    @JsonProperty("txtJushochiTokureiTekiyoDateRange")
    public void setTxtJushochiTokureiTekiyoDateRange(TextBoxDateRange txtJushochiTokureiTekiyoDateRange) {
        this.txtJushochiTokureiTekiyoDateRange = txtJushochiTokureiTekiyoDateRange;
    }

    /*
     * getccdHokenshaJoho
     * @return ccdHokenshaJoho
     */
    @JsonProperty("ccdHokenshaJoho")
    public IHokenshaJohoDiv getCcdHokenshaJoho() {
        return ccdHokenshaJoho;
    }

    // </editor-fold>
}
