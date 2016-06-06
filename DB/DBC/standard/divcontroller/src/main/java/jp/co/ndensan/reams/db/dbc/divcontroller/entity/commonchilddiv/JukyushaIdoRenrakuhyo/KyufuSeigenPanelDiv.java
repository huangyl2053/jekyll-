package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuSeigenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuSeigenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKohiFutanJogenGengakuAriFlag")
    private RadioButton radKohiFutanJogenGengakuAriFlag;
    @JsonProperty("btnKyufuSeigenRireki")
    private Button btnKyufuSeigenRireki;
    @JsonProperty("txtShokanbaraikaYMD")
    private TextBoxDateRange txtShokanbaraikaYMD;
    @JsonProperty("txtKyufuritsuHikisage")
    private TextBoxDateRange txtKyufuritsuHikisage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKohiFutanJogenGengakuAriFlag
     * @return radKohiFutanJogenGengakuAriFlag
     */
    @JsonProperty("radKohiFutanJogenGengakuAriFlag")
    public RadioButton getRadKohiFutanJogenGengakuAriFlag() {
        return radKohiFutanJogenGengakuAriFlag;
    }

    /*
     * setradKohiFutanJogenGengakuAriFlag
     * @param radKohiFutanJogenGengakuAriFlag radKohiFutanJogenGengakuAriFlag
     */
    @JsonProperty("radKohiFutanJogenGengakuAriFlag")
    public void setRadKohiFutanJogenGengakuAriFlag(RadioButton radKohiFutanJogenGengakuAriFlag) {
        this.radKohiFutanJogenGengakuAriFlag = radKohiFutanJogenGengakuAriFlag;
    }

    /*
     * getbtnKyufuSeigenRireki
     * @return btnKyufuSeigenRireki
     */
    @JsonProperty("btnKyufuSeigenRireki")
    public Button getBtnKyufuSeigenRireki() {
        return btnKyufuSeigenRireki;
    }

    /*
     * setbtnKyufuSeigenRireki
     * @param btnKyufuSeigenRireki btnKyufuSeigenRireki
     */
    @JsonProperty("btnKyufuSeigenRireki")
    public void setBtnKyufuSeigenRireki(Button btnKyufuSeigenRireki) {
        this.btnKyufuSeigenRireki = btnKyufuSeigenRireki;
    }

    /*
     * gettxtShokanbaraikaYMD
     * @return txtShokanbaraikaYMD
     */
    @JsonProperty("txtShokanbaraikaYMD")
    public TextBoxDateRange getTxtShokanbaraikaYMD() {
        return txtShokanbaraikaYMD;
    }

    /*
     * settxtShokanbaraikaYMD
     * @param txtShokanbaraikaYMD txtShokanbaraikaYMD
     */
    @JsonProperty("txtShokanbaraikaYMD")
    public void setTxtShokanbaraikaYMD(TextBoxDateRange txtShokanbaraikaYMD) {
        this.txtShokanbaraikaYMD = txtShokanbaraikaYMD;
    }

    /*
     * gettxtKyufuritsuHikisage
     * @return txtKyufuritsuHikisage
     */
    @JsonProperty("txtKyufuritsuHikisage")
    public TextBoxDateRange getTxtKyufuritsuHikisage() {
        return txtKyufuritsuHikisage;
    }

    /*
     * settxtKyufuritsuHikisage
     * @param txtKyufuritsuHikisage txtKyufuritsuHikisage
     */
    @JsonProperty("txtKyufuritsuHikisage")
    public void setTxtKyufuritsuHikisage(TextBoxDateRange txtKyufuritsuHikisage) {
        this.txtKyufuritsuHikisage = txtKyufuritsuHikisage;
    }

    // </editor-fold>
}
