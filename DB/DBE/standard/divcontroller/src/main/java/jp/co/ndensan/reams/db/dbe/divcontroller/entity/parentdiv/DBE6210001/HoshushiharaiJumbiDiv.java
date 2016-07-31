package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6210001;
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
 * HoshushiharaiJumbi のクラスファイル 
 * 
 * @author 自動生成
 */
public class HoshushiharaiJumbiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShutsuryokuJyoken")
    private ShutsuryokuJyokenDiv ShutsuryokuJyoken;
    @JsonProperty("ShutsuryokuTaisho")
    private ShutsuryokuTaishoDiv ShutsuryokuTaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShutsuryokuJyoken
     * @return ShutsuryokuJyoken
     */
    @JsonProperty("ShutsuryokuJyoken")
    public ShutsuryokuJyokenDiv getShutsuryokuJyoken() {
        return ShutsuryokuJyoken;
    }

    /*
     * setShutsuryokuJyoken
     * @param ShutsuryokuJyoken ShutsuryokuJyoken
     */
    @JsonProperty("ShutsuryokuJyoken")
    public void setShutsuryokuJyoken(ShutsuryokuJyokenDiv ShutsuryokuJyoken) {
        this.ShutsuryokuJyoken = ShutsuryokuJyoken;
    }

    /*
     * getShutsuryokuTaisho
     * @return ShutsuryokuTaisho
     */
    @JsonProperty("ShutsuryokuTaisho")
    public ShutsuryokuTaishoDiv getShutsuryokuTaisho() {
        return ShutsuryokuTaisho;
    }

    /*
     * setShutsuryokuTaisho
     * @param ShutsuryokuTaisho ShutsuryokuTaisho
     */
    @JsonProperty("ShutsuryokuTaisho")
    public void setShutsuryokuTaisho(ShutsuryokuTaishoDiv ShutsuryokuTaisho) {
        this.ShutsuryokuTaisho = ShutsuryokuTaisho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtJissekiDateRange() {
        return this.getShutsuryokuJyoken().getTxtJissekiDateRange();
    }

    @JsonIgnore
    public void  setTxtJissekiDateRange(TextBoxDateRange txtJissekiDateRange) {
        this.getShutsuryokuJyoken().setTxtJissekiDateRange(txtJissekiDateRange);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFurikomiShiteiDay() {
        return this.getShutsuryokuJyoken().getTxtFurikomiShiteiDay();
    }

    @JsonIgnore
    public void  setTxtFurikomiShiteiDay(TextBoxFlexibleDate txtFurikomiShiteiDay) {
        this.getShutsuryokuJyoken().setTxtFurikomiShiteiDay(txtFurikomiShiteiDay);
    }

    @JsonIgnore
    public CheckBoxList getChkChosa() {
        return this.getShutsuryokuTaisho().getChkChosa();
    }

    @JsonIgnore
    public void  setChkChosa(CheckBoxList chkChosa) {
        this.getShutsuryokuTaisho().setChkChosa(chkChosa);
    }

    @JsonIgnore
    public CheckBoxList getChkShujii() {
        return this.getShutsuryokuTaisho().getChkShujii();
    }

    @JsonIgnore
    public void  setChkShujii(CheckBoxList chkShujii) {
        this.getShutsuryokuTaisho().setChkShujii(chkShujii);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsakai() {
        return this.getShutsuryokuTaisho().getChkShinsakai();
    }

    @JsonIgnore
    public void  setChkShinsakai(CheckBoxList chkShinsakai) {
        this.getShutsuryokuTaisho().setChkShinsakai(chkShinsakai);
    }

    // </editor-fold>
}
