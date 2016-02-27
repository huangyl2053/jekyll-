package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KonkaiInfoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class KonkaiInfoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSofuShichoShon")
    private TextBox txtSofuShichoShon;
    @JsonProperty("tblkonkaiInfoInput")
    private tblkonkaiInfoInputDiv tblkonkaiInfoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSofuShichoShon
     * @return txtSofuShichoShon
     */
    @JsonProperty("txtSofuShichoShon")
    public TextBox getTxtSofuShichoShon() {
        return txtSofuShichoShon;
    }

    /*
     * settxtSofuShichoShon
     * @param txtSofuShichoShon txtSofuShichoShon
     */
    @JsonProperty("txtSofuShichoShon")
    public void setTxtSofuShichoShon(TextBox txtSofuShichoShon) {
        this.txtSofuShichoShon = txtSofuShichoShon;
    }

    /*
     * gettblkonkaiInfoInput
     * @return tblkonkaiInfoInput
     */
    @JsonProperty("tblkonkaiInfoInput")
    public tblkonkaiInfoInputDiv getTblkonkaiInfoInput() {
        return tblkonkaiInfoInput;
    }

    /*
     * settblkonkaiInfoInput
     * @param tblkonkaiInfoInput tblkonkaiInfoInput
     */
    @JsonProperty("tblkonkaiInfoInput")
    public void setTblkonkaiInfoInput(tblkonkaiInfoInputDiv tblkonkaiInfoInput) {
        this.tblkonkaiInfoInput = tblkonkaiInfoInput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblStYMD() {
        return this.getTblkonkaiInfoInput().getLblStYMD();
    }

    @JsonIgnore
    public Label getLblStTime() {
        return this.getTblkonkaiInfoInput().getLblStTime();
    }

    @JsonIgnore
    public Label getLblEdYMD() {
        return this.getTblkonkaiInfoInput().getLblEdYMD();
    }

    @JsonIgnore
    public Label getLblEdTime() {
        return this.getTblkonkaiInfoInput().getLblEdTime();
    }

    @JsonIgnore
    public ZenkenDiv getZenken() {
        return this.getTblkonkaiInfoInput().getZenken();
    }

    @JsonIgnore
    public CheckBoxList getChkZenken() {
        return this.getTblkonkaiInfoInput().getZenken().getChkZenken();
    }

    @JsonIgnore
    public void  setChkZenken(CheckBoxList chkZenken) {
        this.getTblkonkaiInfoInput().getZenken().setChkZenken(chkZenken);
    }

    @JsonIgnore
    public Label getLblZenkaiChushutsu() {
        return this.getTblkonkaiInfoInput().getLblZenkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuFromYMD() {
        return this.getTblkonkaiInfoInput().getTxtZenkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuFromTime() {
        return this.getTblkonkaiInfoInput().getTxtZenkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara() {
        return this.getTblkonkaiInfoInput().getLblKara();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuToYMD() {
        return this.getTblkonkaiInfoInput().getTxtZenkaiChushutsuToYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuToTime() {
        return this.getTblkonkaiInfoInput().getTxtZenkaiChushutsuToTime();
    }

    @JsonIgnore
    public Label getLblKonkaiChushutsu() {
        return this.getTblkonkaiInfoInput().getLblKonkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiChushutsuFromYMD() {
        return this.getTblkonkaiInfoInput().getTxtKonkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiChushutsuFromTime() {
        return this.getTblkonkaiInfoInput().getTxtKonkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.getTblkonkaiInfoInput().getLblKara2();
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getTblkonkaiInfoInput().getBtnKakutei();
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getTblkonkaiInfoInput().getBtnClose();
    }

    // </editor-fold>
}
