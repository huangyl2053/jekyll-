package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DataTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class DataTorikomiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTorikomiTaishoData")
    private RadioButton radTorikomiTaishoData;
    @JsonProperty("radTorikomiNaiyo")
    private RadioButton radTorikomiNaiyo;
    @JsonProperty("radShinsain")
    private RadioButton radShinsain;
    @JsonProperty("lblTorikomiTaisho")
    private Label lblTorikomiTaisho;
    @JsonProperty("dgTorikomiTaiasho")
    private DataGrid<dgTorikomiTaiasho_Row> dgTorikomiTaiasho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTorikomiTaishoData
     * @return radTorikomiTaishoData
     */
    @JsonProperty("radTorikomiTaishoData")
    public RadioButton getRadTorikomiTaishoData() {
        return radTorikomiTaishoData;
    }

    /*
     * setradTorikomiTaishoData
     * @param radTorikomiTaishoData radTorikomiTaishoData
     */
    @JsonProperty("radTorikomiTaishoData")
    public void setRadTorikomiTaishoData(RadioButton radTorikomiTaishoData) {
        this.radTorikomiTaishoData = radTorikomiTaishoData;
    }

    /*
     * getradTorikomiNaiyo
     * @return radTorikomiNaiyo
     */
    @JsonProperty("radTorikomiNaiyo")
    public RadioButton getRadTorikomiNaiyo() {
        return radTorikomiNaiyo;
    }

    /*
     * setradTorikomiNaiyo
     * @param radTorikomiNaiyo radTorikomiNaiyo
     */
    @JsonProperty("radTorikomiNaiyo")
    public void setRadTorikomiNaiyo(RadioButton radTorikomiNaiyo) {
        this.radTorikomiNaiyo = radTorikomiNaiyo;
    }

    /*
     * getradShinsain
     * @return radShinsain
     */
    @JsonProperty("radShinsain")
    public RadioButton getRadShinsain() {
        return radShinsain;
    }

    /*
     * setradShinsain
     * @param radShinsain radShinsain
     */
    @JsonProperty("radShinsain")
    public void setRadShinsain(RadioButton radShinsain) {
        this.radShinsain = radShinsain;
    }

    /*
     * getlblTorikomiTaisho
     * @return lblTorikomiTaisho
     */
    @JsonProperty("lblTorikomiTaisho")
    public Label getLblTorikomiTaisho() {
        return lblTorikomiTaisho;
    }

    /*
     * setlblTorikomiTaisho
     * @param lblTorikomiTaisho lblTorikomiTaisho
     */
    @JsonProperty("lblTorikomiTaisho")
    public void setLblTorikomiTaisho(Label lblTorikomiTaisho) {
        this.lblTorikomiTaisho = lblTorikomiTaisho;
    }

    /*
     * getdgTorikomiTaiasho
     * @return dgTorikomiTaiasho
     */
    @JsonProperty("dgTorikomiTaiasho")
    public DataGrid<dgTorikomiTaiasho_Row> getDgTorikomiTaiasho() {
        return dgTorikomiTaiasho;
    }

    /*
     * setdgTorikomiTaiasho
     * @param dgTorikomiTaiasho dgTorikomiTaiasho
     */
    @JsonProperty("dgTorikomiTaiasho")
    public void setDgTorikomiTaiasho(DataGrid<dgTorikomiTaiasho_Row> dgTorikomiTaiasho) {
        this.dgTorikomiTaiasho = dgTorikomiTaiasho;
    }

    // </editor-fold>
}
