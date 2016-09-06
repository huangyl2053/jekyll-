package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShoriJokyo のクラスファイル
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public class ShoriJokyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokuchoInfoDownloadShoriNaiyo")
    private TokuchoInfoDownloadShoriNaiyoDiv TokuchoInfoDownloadShoriNaiyo;
    @JsonProperty("TokuchoInfoDownloadShoriKakunin")
    private TokuchoInfoDownloadShoriKakuninDiv TokuchoInfoDownloadShoriKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokuchoInfoDownloadShoriNaiyo
     * @return TokuchoInfoDownloadShoriNaiyo
     */
    @JsonProperty("TokuchoInfoDownloadShoriNaiyo")
    public TokuchoInfoDownloadShoriNaiyoDiv getTokuchoInfoDownloadShoriNaiyo() {
        return TokuchoInfoDownloadShoriNaiyo;
    }

    /*
     * setTokuchoInfoDownloadShoriNaiyo
     * @param TokuchoInfoDownloadShoriNaiyo TokuchoInfoDownloadShoriNaiyo
     */
    @JsonProperty("TokuchoInfoDownloadShoriNaiyo")
    public void setTokuchoInfoDownloadShoriNaiyo(TokuchoInfoDownloadShoriNaiyoDiv TokuchoInfoDownloadShoriNaiyo) {
        this.TokuchoInfoDownloadShoriNaiyo = TokuchoInfoDownloadShoriNaiyo;
    }

    /*
     * getTokuchoInfoDownloadShoriKakunin
     * @return TokuchoInfoDownloadShoriKakunin
     */
    @JsonProperty("TokuchoInfoDownloadShoriKakunin")
    public TokuchoInfoDownloadShoriKakuninDiv getTokuchoInfoDownloadShoriKakunin() {
        return TokuchoInfoDownloadShoriKakunin;
    }

    /*
     * setTokuchoInfoDownloadShoriKakunin
     * @param TokuchoInfoDownloadShoriKakunin TokuchoInfoDownloadShoriKakunin
     */
    @JsonProperty("TokuchoInfoDownloadShoriKakunin")
    public void setTokuchoInfoDownloadShoriKakunin(TokuchoInfoDownloadShoriKakuninDiv TokuchoInfoDownloadShoriKakunin) {
        this.TokuchoInfoDownloadShoriKakunin = TokuchoInfoDownloadShoriKakunin;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChoteiNendo() {
        return this.getTokuchoInfoDownloadShoriNaiyo().getLblChoteiNendo();
    }

    @JsonIgnore
    public void setLblChoteiNendo(Label lblChoteiNendo) {
        this.getTokuchoInfoDownloadShoriNaiyo().setLblChoteiNendo(lblChoteiNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoriNendo() {
        return this.getTokuchoInfoDownloadShoriNaiyo().getTxtShoriNendo();
    }

    @JsonIgnore
    public void setTxtShoriNendo(TextBoxDate txtShoriNendo) {
        this.getTokuchoInfoDownloadShoriNaiyo().setTxtShoriNendo(txtShoriNendo);
    }

    @JsonIgnore
    public ShoriTaishoShichoshonTsukiDiv getShoriTaishoShichoshonTsuki() {
        return this.getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki();
    }

    @JsonIgnore
    public void setShoriTaishoShichoshonTsuki(ShoriTaishoShichoshonTsukiDiv ShoriTaishoShichoshonTsuki) {
        this.getTokuchoInfoDownloadShoriNaiyo().setShoriTaishoShichoshonTsuki(ShoriTaishoShichoshonTsuki);
    }

    @JsonIgnore
    public RadioButton getRadShichosonSelect() {
        return this.getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().getRadShichosonSelect();
    }

    @JsonIgnore
    public void setRadShichosonSelect(RadioButton radShichosonSelect) {
        this.getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().setRadShichosonSelect(radShichosonSelect);
    }

    @JsonIgnore
    public DropDownList getDdlShichosonSelect() {
        return this.getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().getDdlShichosonSelect();
    }

    @JsonIgnore
    public void setDdlShichosonSelect(DropDownList ddlShichosonSelect) {
        this.getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().setDdlShichosonSelect(ddlShichosonSelect);
    }

    @JsonIgnore
    public RadioButton getRadTsukiSelect() {
        return this.getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().getRadTsukiSelect();
    }

    @JsonIgnore
    public void setRadTsukiSelect(RadioButton radTsukiSelect) {
        this.getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().setRadTsukiSelect(radTsukiSelect);
    }

    @JsonIgnore
    public DropDownList getDdlTsuki() {
        return this.getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().getDdlTsuki();
    }

    @JsonIgnore
    public void setDdlTsuki(DropDownList ddlTsuki) {
        this.getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().setDdlTsuki(ddlTsuki);
    }

    @JsonIgnore
    public DataGrid<dgShoriKakunin_Row> getDgShoriKakunin() {
        return this.getTokuchoInfoDownloadShoriKakunin().getDgShoriKakunin();
    }

    @JsonIgnore
    public void setDgShoriKakunin(DataGrid<dgShoriKakunin_Row> dgShoriKakunin) {
        this.getTokuchoInfoDownloadShoriKakunin().setDgShoriKakunin(dgShoriKakunin);
    }

    // </editor-fold>
}
