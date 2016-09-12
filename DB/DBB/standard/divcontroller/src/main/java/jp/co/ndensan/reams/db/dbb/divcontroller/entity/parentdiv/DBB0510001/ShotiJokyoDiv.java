package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYear;

/**
 * ShotiJokyo のクラスファイル
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public class ShotiJokyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HonsanteiIdoShoriNaiyo")
    private HonsanteiIdoShoriNaiyoDiv HonsanteiIdoShoriNaiyo;
    @JsonProperty("dgHonsanteiIdoShoriKakunin")
    private DataGrid<dgHonsanteiIdoShoriKakunin_Row> dgHonsanteiIdoShoriKakunin;
    @JsonProperty("TokuchoHosoku")
    private TokuchoHosokuDiv TokuchoHosoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHonsanteiIdoShoriNaiyo
     * @return HonsanteiIdoShoriNaiyo
     */
    @JsonProperty("HonsanteiIdoShoriNaiyo")
    public HonsanteiIdoShoriNaiyoDiv getHonsanteiIdoShoriNaiyo() {
        return HonsanteiIdoShoriNaiyo;
    }

    /*
     * setHonsanteiIdoShoriNaiyo
     * @param HonsanteiIdoShoriNaiyo HonsanteiIdoShoriNaiyo
     */
    @JsonProperty("HonsanteiIdoShoriNaiyo")
    public void setHonsanteiIdoShoriNaiyo(HonsanteiIdoShoriNaiyoDiv HonsanteiIdoShoriNaiyo) {
        this.HonsanteiIdoShoriNaiyo = HonsanteiIdoShoriNaiyo;
    }

    /*
     * getdgHonsanteiIdoShoriKakunin
     * @return dgHonsanteiIdoShoriKakunin
     */
    @JsonProperty("dgHonsanteiIdoShoriKakunin")
    public DataGrid<dgHonsanteiIdoShoriKakunin_Row> getDgHonsanteiIdoShoriKakunin() {
        return dgHonsanteiIdoShoriKakunin;
    }

    /*
     * setdgHonsanteiIdoShoriKakunin
     * @param dgHonsanteiIdoShoriKakunin dgHonsanteiIdoShoriKakunin
     */
    @JsonProperty("dgHonsanteiIdoShoriKakunin")
    public void setDgHonsanteiIdoShoriKakunin(DataGrid<dgHonsanteiIdoShoriKakunin_Row> dgHonsanteiIdoShoriKakunin) {
        this.dgHonsanteiIdoShoriKakunin = dgHonsanteiIdoShoriKakunin;
    }

    /*
     * getTokuchoHosoku
     * @return TokuchoHosoku
     */
    @JsonProperty("TokuchoHosoku")
    public TokuchoHosokuDiv getTokuchoHosoku() {
        return TokuchoHosoku;
    }

    /*
     * setTokuchoHosoku
     * @param TokuchoHosoku TokuchoHosoku
     */
    @JsonProperty("TokuchoHosoku")
    public void setTokuchoHosoku(TokuchoHosokuDiv TokuchoHosoku) {
        this.TokuchoHosoku = TokuchoHosoku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxYear getTxtChoteiNendo() {
        return this.getHonsanteiIdoShoriNaiyo().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void setTxtChoteiNendo(TextBoxYear txtChoteiNendo) {
        this.getHonsanteiIdoShoriNaiyo().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public TextBoxYear getTxtFukaNendo() {
        return this.getHonsanteiIdoShoriNaiyo().getTxtFukaNendo();
    }

    @JsonIgnore
    public void setTxtFukaNendo(TextBoxYear txtFukaNendo) {
        this.getHonsanteiIdoShoriNaiyo().setTxtFukaNendo(txtFukaNendo);
    }

    @JsonIgnore
    public DropDownList getDdlShoritsuki() {
        return this.getHonsanteiIdoShoriNaiyo().getDdlShoritsuki();
    }

    @JsonIgnore
    public void setDdlShoritsuki(DropDownList ddlShoritsuki) {
        this.getHonsanteiIdoShoriNaiyo().setDdlShoritsuki(ddlShoritsuki);
    }

    @JsonIgnore
    public RadioButton getRadShoriTaisho() {
        return this.getHonsanteiIdoShoriNaiyo().getRadShoriTaisho();
    }

    @JsonIgnore
    public void setRadShoriTaisho(RadioButton radShoriTaisho) {
        this.getHonsanteiIdoShoriNaiyo().setRadShoriTaisho(radShoriTaisho);
    }

    @JsonIgnore
    public DropDownList getDdlTokuchoTeishiSelect() {
        return this.getHonsanteiIdoShoriNaiyo().getDdlTokuchoTeishiSelect();
    }

    @JsonIgnore
    public void setDdlTokuchoTeishiSelect(DropDownList ddlTokuchoTeishiSelect) {
        this.getHonsanteiIdoShoriNaiyo().setDdlTokuchoTeishiSelect(ddlTokuchoTeishiSelect);
    }

    @JsonIgnore
    public TextBox getXtTaishoTokuchoKaishiTsuki() {
        return this.getTokuchoHosoku().getXtTaishoTokuchoKaishiTsuki();
    }

    @JsonIgnore
    public void setXtTaishoTokuchoKaishiTsuki(TextBox xtTaishoTokuchoKaishiTsuki) {
        this.getTokuchoHosoku().setXtTaishoTokuchoKaishiTsuki(xtTaishoTokuchoKaishiTsuki);
    }

    @JsonIgnore
    public RadioButton getRadTokuchoHosokuIraiKingakuKeisan() {
        return this.getTokuchoHosoku().getRadTokuchoHosokuIraiKingakuKeisan();
    }

    @JsonIgnore
    public void setRadTokuchoHosokuIraiKingakuKeisan(RadioButton radTokuchoHosokuIraiKingakuKeisan) {
        this.getTokuchoHosoku().setRadTokuchoHosokuIraiKingakuKeisan(radTokuchoHosokuIraiKingakuKeisan);
    }

    // </editor-fold>
}
