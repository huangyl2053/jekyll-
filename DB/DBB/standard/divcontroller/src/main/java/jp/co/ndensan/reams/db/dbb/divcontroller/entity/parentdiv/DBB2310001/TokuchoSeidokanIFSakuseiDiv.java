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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 *
 * 画面設計_DBBGM84001_2_特徴制度間Ｉ／Ｆ（単一他社）
 *
 * @reamsid_L DBB-1830-010 yangchenbing
 */
public class TokuchoSeidokanIFSakuseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokuchoSeidokanIFSakuseiBatchParameter")
    private TokuchoSeidokanIFSakuseiBatchParameterDiv TokuchoSeidokanIFSakuseiBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokuchoSeidokanIFSakuseiBatchParameter
     * @return TokuchoSeidokanIFSakuseiBatchParameter
     */
    @JsonProperty("TokuchoSeidokanIFSakuseiBatchParameter")
    public TokuchoSeidokanIFSakuseiBatchParameterDiv getTokuchoSeidokanIFSakuseiBatchParameter() {
        return TokuchoSeidokanIFSakuseiBatchParameter;
    }

    /*
     * setTokuchoSeidokanIFSakuseiBatchParameter
     * @param TokuchoSeidokanIFSakuseiBatchParameter TokuchoSeidokanIFSakuseiBatchParameter
     */
    @JsonProperty("TokuchoSeidokanIFSakuseiBatchParameter")
    public void setTokuchoSeidokanIFSakuseiBatchParameter(TokuchoSeidokanIFSakuseiBatchParameterDiv TokuchoSeidokanIFSakuseiBatchParameter) {
        this.TokuchoSeidokanIFSakuseiBatchParameter = TokuchoSeidokanIFSakuseiBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShoriJokyoDiv getShoriJokyo() {
        return this.getTokuchoSeidokanIFSakuseiBatchParameter().getShoriJokyo();
    }

    @JsonIgnore
    public void setShoriJokyo(ShoriJokyoDiv ShoriJokyo) {
        this.getTokuchoSeidokanIFSakuseiBatchParameter().setShoriJokyo(ShoriJokyo);
    }

    @JsonIgnore
    public TokuchoSeidokanIFSakuseiShoriNaiyoDiv getTokuchoSeidokanIFSakuseiShoriNaiyo() {
        return this.getTokuchoSeidokanIFSakuseiBatchParameter().getShoriJokyo().getTokuchoSeidokanIFSakuseiShoriNaiyo();
    }

    @JsonIgnore
    public void setTokuchoSeidokanIFSakuseiShoriNaiyo(TokuchoSeidokanIFSakuseiShoriNaiyoDiv TokuchoSeidokanIFSakuseiShoriNaiyo) {
        this.getTokuchoSeidokanIFSakuseiBatchParameter().getShoriJokyo().setTokuchoSeidokanIFSakuseiShoriNaiyo(TokuchoSeidokanIFSakuseiShoriNaiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtChoteiNendo() {
        return this.getTokuchoSeidokanIFSakuseiBatchParameter().getShoriJokyo().getTokuchoSeidokanIFSakuseiShoriNaiyo().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void setTxtChoteiNendo(TextBoxDate txtChoteiNendo) {
        this.getTokuchoSeidokanIFSakuseiBatchParameter().getShoriJokyo().getTokuchoSeidokanIFSakuseiShoriNaiyo().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public DropDownList getDdlKaishiYM() {
        return this.getTokuchoSeidokanIFSakuseiBatchParameter().getShoriJokyo().getTokuchoSeidokanIFSakuseiShoriNaiyo().getDdlKaishiYM();
    }

    @JsonIgnore
    public void setDdlKaishiYM(DropDownList ddlKaishiYM) {
        this.getTokuchoSeidokanIFSakuseiBatchParameter().getShoriJokyo().getTokuchoSeidokanIFSakuseiShoriNaiyo().setDdlKaishiYM(ddlKaishiYM);
    }

    @JsonIgnore
    public TanitsuShoriInfoDiv getTanitsuShoriInfo() {
        return this.getTokuchoSeidokanIFSakuseiBatchParameter().getTanitsuShoriInfo();
    }

    @JsonIgnore
    public void setTanitsuShoriInfo(TanitsuShoriInfoDiv TanitsuShoriInfo) {
        this.getTokuchoSeidokanIFSakuseiBatchParameter().setTanitsuShoriInfo(TanitsuShoriInfo);
    }

    @JsonIgnore
    public Label getLblZenShoriYMD() {
        return this.getTokuchoSeidokanIFSakuseiBatchParameter().getTanitsuShoriInfo().getLblZenShoriYMD();
    }

    @JsonIgnore
    public void setLblZenShoriYMD(Label lblZenShoriYMD) {
        this.getTokuchoSeidokanIFSakuseiBatchParameter().getTanitsuShoriInfo().setLblZenShoriYMD(lblZenShoriYMD);
    }

    @JsonIgnore
    public Label getLblZenShoriTime() {
        return this.getTokuchoSeidokanIFSakuseiBatchParameter().getTanitsuShoriInfo().getLblZenShoriTime();
    }

    @JsonIgnore
    public void setLblZenShoriTime(Label lblZenShoriTime) {
        this.getTokuchoSeidokanIFSakuseiBatchParameter().getTanitsuShoriInfo().setLblZenShoriTime(lblZenShoriTime);
    }

    @JsonIgnore
    public TextBox getTxtShoriJotai() {
        return this.getTokuchoSeidokanIFSakuseiBatchParameter().getTanitsuShoriInfo().getTxtShoriJotai();
    }

    @JsonIgnore
    public void setTxtShoriJotai(TextBox txtShoriJotai) {
        this.getTokuchoSeidokanIFSakuseiBatchParameter().getTanitsuShoriInfo().setTxtShoriJotai(txtShoriJotai);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenKaiShoriYMD() {
        return this.getTokuchoSeidokanIFSakuseiBatchParameter().getTanitsuShoriInfo().getTxtZenKaiShoriYMD();
    }

    @JsonIgnore
    public void setTxtZenKaiShoriYMD(TextBoxDate txtZenKaiShoriYMD) {
        this.getTokuchoSeidokanIFSakuseiBatchParameter().getTanitsuShoriInfo().setTxtZenKaiShoriYMD(txtZenKaiShoriYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenKaiShoriTime() {
        return this.getTokuchoSeidokanIFSakuseiBatchParameter().getTanitsuShoriInfo().getTxtZenKaiShoriTime();
    }

    @JsonIgnore
    public void setTxtZenKaiShoriTime(TextBoxTime txtZenKaiShoriTime) {
        this.getTokuchoSeidokanIFSakuseiBatchParameter().getTanitsuShoriInfo().setTxtZenKaiShoriTime(txtZenKaiShoriTime);
    }

    // </editor-fold>
}
