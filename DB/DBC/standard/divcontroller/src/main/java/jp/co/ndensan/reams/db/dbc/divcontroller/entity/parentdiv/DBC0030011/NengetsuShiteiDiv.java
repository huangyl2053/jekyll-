package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * NengetsuShitei のクラスファイル
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class NengetsuShiteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radNengetsuShitei")
    private RadioButton radNengetsuShitei;
    @JsonProperty("NengetsuKensakuJoken")
    private NengetsuKensakuJokenDiv NengetsuKensakuJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradNengetsuShitei
     * @return radNengetsuShitei
     */
    @JsonProperty("radNengetsuShitei")
    public RadioButton getRadNengetsuShitei() {
        return radNengetsuShitei;
    }

    /*
     * setradNengetsuShitei
     * @param radNengetsuShitei radNengetsuShitei
     */
    @JsonProperty("radNengetsuShitei")
    public void setRadNengetsuShitei(RadioButton radNengetsuShitei) {
        this.radNengetsuShitei = radNengetsuShitei;
    }

    /*
     * getNengetsuKensakuJoken
     * @return NengetsuKensakuJoken
     */
    @JsonProperty("NengetsuKensakuJoken")
    public NengetsuKensakuJokenDiv getNengetsuKensakuJoken() {
        return NengetsuKensakuJoken;
    }

    /*
     * setNengetsuKensakuJoken
     * @param NengetsuKensakuJoken NengetsuKensakuJoken
     */
    @JsonProperty("NengetsuKensakuJoken")
    public void setNengetsuKensakuJoken(NengetsuKensakuJokenDiv NengetsuKensakuJoken) {
        this.NengetsuKensakuJoken = NengetsuKensakuJoken;
    }

    // </editor-fold>
}
