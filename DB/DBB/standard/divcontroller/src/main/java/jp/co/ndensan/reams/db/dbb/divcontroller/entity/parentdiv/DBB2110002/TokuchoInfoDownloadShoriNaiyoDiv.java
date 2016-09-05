package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * TokuchoInfoDownloadShoriNaiyo のクラスファイル
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public class TokuchoInfoDownloadShoriNaiyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChoteiNendo")
    private Label lblChoteiNendo;
    @JsonProperty("txtShoriNendo")
    private TextBoxDate txtShoriNendo;
    @JsonProperty("ShoriTaishoShichoshonTsuki")
    private ShoriTaishoShichoshonTsukiDiv ShoriTaishoShichoshonTsuki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChoteiNendo
     * @return lblChoteiNendo
     */
    @JsonProperty("lblChoteiNendo")
    public Label getLblChoteiNendo() {
        return lblChoteiNendo;
    }

    /*
     * setlblChoteiNendo
     * @param lblChoteiNendo lblChoteiNendo
     */
    @JsonProperty("lblChoteiNendo")
    public void setLblChoteiNendo(Label lblChoteiNendo) {
        this.lblChoteiNendo = lblChoteiNendo;
    }

    /*
     * gettxtShoriNendo
     * @return txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public TextBoxDate getTxtShoriNendo() {
        return txtShoriNendo;
    }

    /*
     * settxtShoriNendo
     * @param txtShoriNendo txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public void setTxtShoriNendo(TextBoxDate txtShoriNendo) {
        this.txtShoriNendo = txtShoriNendo;
    }

    /*
     * getShoriTaishoShichoshonTsuki
     * @return ShoriTaishoShichoshonTsuki
     */
    @JsonProperty("ShoriTaishoShichoshonTsuki")
    public ShoriTaishoShichoshonTsukiDiv getShoriTaishoShichoshonTsuki() {
        return ShoriTaishoShichoshonTsuki;
    }

    /*
     * setShoriTaishoShichoshonTsuki
     * @param ShoriTaishoShichoshonTsuki ShoriTaishoShichoshonTsuki
     */
    @JsonProperty("ShoriTaishoShichoshonTsuki")
    public void setShoriTaishoShichoshonTsuki(ShoriTaishoShichoshonTsukiDiv ShoriTaishoShichoshonTsuki) {
        this.ShoriTaishoShichoshonTsuki = ShoriTaishoShichoshonTsuki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadShichosonSelect() {
        return this.getShoriTaishoShichoshonTsuki().getRadShichosonSelect();
    }

    @JsonIgnore
    public void setRadShichosonSelect(RadioButton radShichosonSelect) {
        this.getShoriTaishoShichoshonTsuki().setRadShichosonSelect(radShichosonSelect);
    }

    @JsonIgnore
    public DropDownList getDdlShichosonSelect() {
        return this.getShoriTaishoShichoshonTsuki().getDdlShichosonSelect();
    }

    @JsonIgnore
    public void setDdlShichosonSelect(DropDownList ddlShichosonSelect) {
        this.getShoriTaishoShichoshonTsuki().setDdlShichosonSelect(ddlShichosonSelect);
    }

    @JsonIgnore
    public RadioButton getRadTsukiSelect() {
        return this.getShoriTaishoShichoshonTsuki().getRadTsukiSelect();
    }

    @JsonIgnore
    public void setRadTsukiSelect(RadioButton radTsukiSelect) {
        this.getShoriTaishoShichoshonTsuki().setRadTsukiSelect(radTsukiSelect);
    }

    @JsonIgnore
    public DropDownList getDdlTsuki() {
        return this.getShoriTaishoShichoshonTsuki().getDdlTsuki();
    }

    @JsonIgnore
    public void setDdlTsuki(DropDownList ddlTsuki) {
        this.getShoriTaishoShichoshonTsuki().setDdlTsuki(ddlTsuki);
    }

    // </editor-fold>
}
