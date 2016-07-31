package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * TokuchoHosoku のクラスファイル
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public class TokuchoHosokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("xtTaishoTokuchoKaishiTsuki")
    private TextBox xtTaishoTokuchoKaishiTsuki;
    @JsonProperty("radTokuchoHosokuIraiKingakuKeisan")
    private RadioButton radTokuchoHosokuIraiKingakuKeisan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getxtTaishoTokuchoKaishiTsuki
     * @return xtTaishoTokuchoKaishiTsuki
     */
    @JsonProperty("xtTaishoTokuchoKaishiTsuki")
    public TextBox getXtTaishoTokuchoKaishiTsuki() {
        return xtTaishoTokuchoKaishiTsuki;
    }

    /*
     * setxtTaishoTokuchoKaishiTsuki
     * @param xtTaishoTokuchoKaishiTsuki xtTaishoTokuchoKaishiTsuki
     */
    @JsonProperty("xtTaishoTokuchoKaishiTsuki")
    public void setXtTaishoTokuchoKaishiTsuki(TextBox xtTaishoTokuchoKaishiTsuki) {
        this.xtTaishoTokuchoKaishiTsuki = xtTaishoTokuchoKaishiTsuki;
    }

    /*
     * getradTokuchoHosokuIraiKingakuKeisan
     * @return radTokuchoHosokuIraiKingakuKeisan
     */
    @JsonProperty("radTokuchoHosokuIraiKingakuKeisan")
    public RadioButton getRadTokuchoHosokuIraiKingakuKeisan() {
        return radTokuchoHosokuIraiKingakuKeisan;
    }

    /*
     * setradTokuchoHosokuIraiKingakuKeisan
     * @param radTokuchoHosokuIraiKingakuKeisan radTokuchoHosokuIraiKingakuKeisan
     */
    @JsonProperty("radTokuchoHosokuIraiKingakuKeisan")
    public void setRadTokuchoHosokuIraiKingakuKeisan(RadioButton radTokuchoHosokuIraiKingakuKeisan) {
        this.radTokuchoHosokuIraiKingakuKeisan = radTokuchoHosokuIraiKingakuKeisan;
    }

    // </editor-fold>
}
