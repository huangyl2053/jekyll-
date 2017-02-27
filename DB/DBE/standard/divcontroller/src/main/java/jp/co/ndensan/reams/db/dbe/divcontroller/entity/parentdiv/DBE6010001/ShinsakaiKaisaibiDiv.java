package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiKaisaibi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKaisaibiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiKaisaibi")
    private TextBoxDateRange txtShinsakaiKaisaibi;
    @JsonProperty("radShutsuryokuHoho")
    private RadioButton radShutsuryokuHoho;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("btnKensakuClear")
    private Button btnKensakuClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiKaisaibi
     * @return txtShinsakaiKaisaibi
     */
    @JsonProperty("txtShinsakaiKaisaibi")
    public TextBoxDateRange getTxtShinsakaiKaisaibi() {
        return txtShinsakaiKaisaibi;
    }

    /*
     * settxtShinsakaiKaisaibi
     * @param txtShinsakaiKaisaibi txtShinsakaiKaisaibi
     */
    @JsonProperty("txtShinsakaiKaisaibi")
    public void setTxtShinsakaiKaisaibi(TextBoxDateRange txtShinsakaiKaisaibi) {
        this.txtShinsakaiKaisaibi = txtShinsakaiKaisaibi;
    }

    /*
     * getradShutsuryokuHoho
     * @return radShutsuryokuHoho
     */
    @JsonProperty("radShutsuryokuHoho")
    public RadioButton getRadShutsuryokuHoho() {
        return radShutsuryokuHoho;
    }

    /*
     * setradShutsuryokuHoho
     * @param radShutsuryokuHoho radShutsuryokuHoho
     */
    @JsonProperty("radShutsuryokuHoho")
    public void setRadShutsuryokuHoho(RadioButton radShutsuryokuHoho) {
        this.radShutsuryokuHoho = radShutsuryokuHoho;
    }

    /*
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    /*
     * getbtnKensakuClear
     * @return btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public Button getBtnKensakuClear() {
        return btnKensakuClear;
    }

    /*
     * setbtnKensakuClear
     * @param btnKensakuClear btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public void setBtnKensakuClear(Button btnKensakuClear) {
        this.btnKensakuClear = btnKensakuClear;
    }

    // </editor-fold>
}
