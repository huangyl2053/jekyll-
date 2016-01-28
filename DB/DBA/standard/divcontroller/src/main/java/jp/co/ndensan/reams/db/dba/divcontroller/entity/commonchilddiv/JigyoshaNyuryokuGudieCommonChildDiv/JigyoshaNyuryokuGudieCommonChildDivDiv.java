package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JigyoshaNyuryokuGudieCommonChildDiv のクラスファイル
 *
 * @author 自動生成
 */
public class JigyoshaNyuryokuGudieCommonChildDivDiv extends Panel implements IJigyoshaNyuryokuGudieCommonChildDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TaishoJigyoshaKensaku")
    private TaishoJigyoshaKensakuDiv TaishoJigyoshaKensaku;
    @JsonProperty("JigyoshaItirann")
    private JigyoshaItirannDiv JigyoshaItirann;
    @JsonProperty("JigyoshaMode")
    private RString JigyoshaMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTaishoJigyoshaKensaku
     * @return TaishoJigyoshaKensaku
     */
    @JsonProperty("TaishoJigyoshaKensaku")
    public TaishoJigyoshaKensakuDiv getTaishoJigyoshaKensaku() {
        return TaishoJigyoshaKensaku;
    }

    /*
     * setTaishoJigyoshaKensaku
     * @param TaishoJigyoshaKensaku TaishoJigyoshaKensaku
     */
    @JsonProperty("TaishoJigyoshaKensaku")
    public void setTaishoJigyoshaKensaku(TaishoJigyoshaKensakuDiv TaishoJigyoshaKensaku) {
        this.TaishoJigyoshaKensaku = TaishoJigyoshaKensaku;
    }

    /*
     * getJigyoshaItirann
     * @return JigyoshaItirann
     */
    @JsonProperty("JigyoshaItirann")
    public JigyoshaItirannDiv getJigyoshaItirann() {
        return JigyoshaItirann;
    }

    /*
     * setJigyoshaItirann
     * @param JigyoshaItirann JigyoshaItirann
     */
    @JsonProperty("JigyoshaItirann")
    public void setJigyoshaItirann(JigyoshaItirannDiv JigyoshaItirann) {
        this.JigyoshaItirann = JigyoshaItirann;
    }

    /*
     * getJigyoshaMode
     * @return JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public RString getJigyoshaMode() {
        return JigyoshaMode;
    }

    /*
     * setJigyoshaMode
     * @param JigyoshaMode JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public void setJigyoshaMode(RString JigyoshaMode) {
        this.JigyoshaMode = JigyoshaMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KennsakuJyokennDiv getKennsakuJyokenn() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn();
    }

    @JsonIgnore
    public void  setKennsakuJyokenn(KennsakuJyokennDiv KennsakuJyokenn) {
        this.getTaishoJigyoshaKensaku().setKennsakuJyokenn(KennsakuJyokenn);
    }

    @JsonIgnore
    public OtherTokureiShisetsuDiv getOtherTokureiShisetsu() {
        return this.getTaishoJigyoshaKensaku().getOtherTokureiShisetsu();
    }

    @JsonIgnore
    public void  setOtherTokureiShisetsu(OtherTokureiShisetsuDiv OtherTokureiShisetsu) {
        this.getTaishoJigyoshaKensaku().setOtherTokureiShisetsu(OtherTokureiShisetsu);
    }

    @JsonIgnore
    public RadioButton getRadKannaiKanngaiKubun() {
        return this.getTaishoJigyoshaKensaku().getOtherTokureiShisetsu().getRadKannaiKanngaiKubun();
    }

    @JsonIgnore
    public void  setRadKannaiKanngaiKubun(RadioButton radKannaiKanngaiKubun) {
        this.getTaishoJigyoshaKensaku().getOtherTokureiShisetsu().setRadKannaiKanngaiKubun(radKannaiKanngaiKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxHyojiKensu() {
        return this.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu();
    }

    @JsonIgnore
    public void  setTxtMaxHyojiKensu(TextBoxNum txtMaxHyojiKensu) {
        this.getTaishoJigyoshaKensaku().setTxtMaxHyojiKensu(txtMaxHyojiKensu);
    }

    @JsonIgnore
    public Button getBtnTaishoJigyoshaKensaku() {
        return this.getTaishoJigyoshaKensaku().getBtnTaishoJigyoshaKensaku();
    }

    @JsonIgnore
    public void  setBtnTaishoJigyoshaKensaku(Button btnTaishoJigyoshaKensaku) {
        this.getTaishoJigyoshaKensaku().setBtnTaishoJigyoshaKensaku(btnTaishoJigyoshaKensaku);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getTaishoJigyoshaKensaku().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getTaishoJigyoshaKensaku().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnYameru() {
        return this.getTaishoJigyoshaKensaku().getBtnYameru();
    }

    @JsonIgnore
    public void  setBtnYameru(Button btnYameru) {
        this.getTaishoJigyoshaKensaku().setBtnYameru(btnYameru);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
