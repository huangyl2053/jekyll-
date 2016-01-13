package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * KobetsuJikoRenkeiInfoSakuseiKoikiBP のクラスファイル 
 * 
 * @author 自動生成
 */
public class KobetsuJikoRenkeiInfoSakuseiKoikiBPDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKobetsuJikoRenkeiInfoSakuseiKoik")
    private DataGrid<dgKobetsuJikoRenkeiInfoSakuseiKoik_Row> dgKobetsuJikoRenkeiInfoSakuseiKoik;
    @JsonProperty("KonkaiInfoInput")
    private KonkaiInfoInputDiv KonkaiInfoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKobetsuJikoRenkeiInfoSakuseiKoik
     * @return dgKobetsuJikoRenkeiInfoSakuseiKoik
     */
    @JsonProperty("dgKobetsuJikoRenkeiInfoSakuseiKoik")
    public DataGrid<dgKobetsuJikoRenkeiInfoSakuseiKoik_Row> getDgKobetsuJikoRenkeiInfoSakuseiKoik() {
        return dgKobetsuJikoRenkeiInfoSakuseiKoik;
    }

    /*
     * setdgKobetsuJikoRenkeiInfoSakuseiKoik
     * @param dgKobetsuJikoRenkeiInfoSakuseiKoik dgKobetsuJikoRenkeiInfoSakuseiKoik
     */
    @JsonProperty("dgKobetsuJikoRenkeiInfoSakuseiKoik")
    public void setDgKobetsuJikoRenkeiInfoSakuseiKoik(DataGrid<dgKobetsuJikoRenkeiInfoSakuseiKoik_Row> dgKobetsuJikoRenkeiInfoSakuseiKoik) {
        this.dgKobetsuJikoRenkeiInfoSakuseiKoik = dgKobetsuJikoRenkeiInfoSakuseiKoik;
    }

    /*
     * getKonkaiInfoInput
     * @return KonkaiInfoInput
     */
    @JsonProperty("KonkaiInfoInput")
    public KonkaiInfoInputDiv getKonkaiInfoInput() {
        return KonkaiInfoInput;
    }

    /*
     * setKonkaiInfoInput
     * @param KonkaiInfoInput KonkaiInfoInput
     */
    @JsonProperty("KonkaiInfoInput")
    public void setKonkaiInfoInput(KonkaiInfoInputDiv KonkaiInfoInput) {
        this.KonkaiInfoInput = KonkaiInfoInput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtSofuShichoShon() {
        return this.getKonkaiInfoInput().getTxtSofuShichoShon();
    }

    @JsonIgnore
    public void  setTxtSofuShichoShon(TextBox txtSofuShichoShon) {
        this.getKonkaiInfoInput().setTxtSofuShichoShon(txtSofuShichoShon);
    }

    @JsonIgnore
    public tblkonkaiInfoInputDiv getTblkonkaiInfoInput() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput();
    }

    @JsonIgnore
    public void  setTblkonkaiInfoInput(tblkonkaiInfoInputDiv tblkonkaiInfoInput) {
        this.getKonkaiInfoInput().setTblkonkaiInfoInput(tblkonkaiInfoInput);
    }

    @JsonIgnore
    public Label getLblStYMD() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getLblStYMD();
    }

    @JsonIgnore
    public Label getLblStTime() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getLblStTime();
    }

    @JsonIgnore
    public Label getLblEdYMD() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getLblEdYMD();
    }

    @JsonIgnore
    public Label getLblEdTime() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getLblEdTime();
    }

    @JsonIgnore
    public ZenkenDiv getZenken() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getZenken();
    }

    @JsonIgnore
    public CheckBoxList getChkZenken() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getZenken().getChkZenken();
    }

    @JsonIgnore
    public void  setChkZenken(CheckBoxList chkZenken) {
        this.getKonkaiInfoInput().getTblkonkaiInfoInput().getZenken().setChkZenken(chkZenken);
    }

    @JsonIgnore
    public Label getLblZenkaiChushutsu() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getLblZenkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuFromYMD() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtZenkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuFromTime() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtZenkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getLblKara();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuToYMD() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtZenkaiChushutsuToYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuToTime() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtZenkaiChushutsuToTime();
    }

    @JsonIgnore
    public Label getLblKonkaiChushutsu() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getLblKonkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiChushutsuFromYMD() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtKonkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiChushutsuFromTime() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getTxtKonkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getLblKara2();
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getBtnKakutei();
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getKonkaiInfoInput().getTblkonkaiInfoInput().getBtnClose();
    }

    // </editor-fold>
}
