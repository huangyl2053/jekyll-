package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 *
 * 画面設計_DBBGM84001_2_特徴制度間Ｉ／Ｆ（単一他社）
 *
 * @reamsid_L DBB-1830-010 yangchenbing
 */
public class TokuchoSeidokanIFSakuseiBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriJokyo")
    private ShoriJokyoDiv ShoriJokyo;
    @JsonProperty("TanitsuShoriInfo")
    private TanitsuShoriInfoDiv TanitsuShoriInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShoriJokyo
     * @return ShoriJokyo
     */
    @JsonProperty("ShoriJokyo")
    public ShoriJokyoDiv getShoriJokyo() {
        return ShoriJokyo;
    }

    /*
     * setShoriJokyo
     * @param ShoriJokyo ShoriJokyo
     */
    @JsonProperty("ShoriJokyo")
    public void setShoriJokyo(ShoriJokyoDiv ShoriJokyo) {
        this.ShoriJokyo = ShoriJokyo;
    }

    /*
     * getTanitsuShoriInfo
     * @return TanitsuShoriInfo
     */
    @JsonProperty("TanitsuShoriInfo")
    public TanitsuShoriInfoDiv getTanitsuShoriInfo() {
        return TanitsuShoriInfo;
    }

    /*
     * setTanitsuShoriInfo
     * @param TanitsuShoriInfo TanitsuShoriInfo
     */
    @JsonProperty("TanitsuShoriInfo")
    public void setTanitsuShoriInfo(TanitsuShoriInfoDiv TanitsuShoriInfo) {
        this.TanitsuShoriInfo = TanitsuShoriInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TokuchoSeidokanIFSakuseiShoriNaiyoDiv getTokuchoSeidokanIFSakuseiShoriNaiyo() {
        return this.getShoriJokyo().getTokuchoSeidokanIFSakuseiShoriNaiyo();
    }

    @JsonIgnore
    public void setTokuchoSeidokanIFSakuseiShoriNaiyo(TokuchoSeidokanIFSakuseiShoriNaiyoDiv TokuchoSeidokanIFSakuseiShoriNaiyo) {
        this.getShoriJokyo().setTokuchoSeidokanIFSakuseiShoriNaiyo(TokuchoSeidokanIFSakuseiShoriNaiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtChoteiNendo() {
        return this.getShoriJokyo().getTokuchoSeidokanIFSakuseiShoriNaiyo().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void setTxtChoteiNendo(TextBoxDate txtChoteiNendo) {
        this.getShoriJokyo().getTokuchoSeidokanIFSakuseiShoriNaiyo().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public DropDownList getDdlKaishiYM() {
        return this.getShoriJokyo().getTokuchoSeidokanIFSakuseiShoriNaiyo().getDdlKaishiYM();
    }

    @JsonIgnore
    public void setDdlKaishiYM(DropDownList ddlKaishiYM) {
        this.getShoriJokyo().getTokuchoSeidokanIFSakuseiShoriNaiyo().setDdlKaishiYM(ddlKaishiYM);
    }

    @JsonIgnore
    public Label getLblZenShoriYMD() {
        return this.getTanitsuShoriInfo().getLblZenShoriYMD();
    }

    @JsonIgnore
    public void setLblZenShoriYMD(Label lblZenShoriYMD) {
        this.getTanitsuShoriInfo().setLblZenShoriYMD(lblZenShoriYMD);
    }

    @JsonIgnore
    public Label getLblZenShoriTime() {
        return this.getTanitsuShoriInfo().getLblZenShoriTime();
    }

    @JsonIgnore
    public void setLblZenShoriTime(Label lblZenShoriTime) {
        this.getTanitsuShoriInfo().setLblZenShoriTime(lblZenShoriTime);
    }

    @JsonIgnore
    public TextBox getTxtShoriJotai() {
        return this.getTanitsuShoriInfo().getTxtShoriJotai();
    }

    @JsonIgnore
    public void setTxtShoriJotai(TextBox txtShoriJotai) {
        this.getTanitsuShoriInfo().setTxtShoriJotai(txtShoriJotai);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenKaiShoriYMD() {
        return this.getTanitsuShoriInfo().getTxtZenKaiShoriYMD();
    }

    @JsonIgnore
    public void setTxtZenKaiShoriYMD(TextBoxDate txtZenKaiShoriYMD) {
        this.getTanitsuShoriInfo().setTxtZenKaiShoriYMD(txtZenKaiShoriYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenKaiShoriTime() {
        return this.getTanitsuShoriInfo().getTxtZenKaiShoriTime();
    }

    @JsonIgnore
    public void setTxtZenKaiShoriTime(TextBoxTime txtZenKaiShoriTime) {
        this.getTanitsuShoriInfo().setTxtZenKaiShoriTime(txtZenKaiShoriTime);
    }

    // </editor-fold>
}
