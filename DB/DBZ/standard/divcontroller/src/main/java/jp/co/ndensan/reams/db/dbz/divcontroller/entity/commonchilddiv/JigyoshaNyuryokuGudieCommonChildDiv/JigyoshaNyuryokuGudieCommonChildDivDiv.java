package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

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
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum State implements ICommonChildDivMode {

        ServiceJigyoshaMode("ServiceJigyoshaMode"),
        OtherTokureiShisetsuMode("OtherTokureiShisetsuMode"),
        ShitekiJogaiShisetsuMode("ShitekiJogaiShisetsuMode"),
        サービス事業者修正削除モード("サービス事業者修正削除モード"),
        その他特例施設修正削除モード("その他特例施設修正削除モード"),
        適用除外施設修正削除モード("適用除外施設修正削除モード");

        private final String name;

        private State(final String name) {
            this.name = name;
        }

        public static State getEnum(String str) {
            State[] enumArray = State.values();

            for (State enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) { 
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public State getMode_State() {
        return (State) _CommonChildDivModeUtil.getMode( this.modes, State.class );
    }

    public void setMode_State( State value ) {
        _CommonChildDivModeUtil.setMode( this.modes, State.class , value );
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
    public TextBox getTxtJIgyoshaNo() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getTxtJIgyoshaNo();
    }

    @JsonIgnore
    public void  setTxtJIgyoshaNo(TextBox txtJIgyoshaNo) {
        this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().setTxtJIgyoshaNo(txtJIgyoshaNo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtYukouKaishibi() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getTxtYukouKaishibi();
    }

    @JsonIgnore
    public void  setTxtYukouKaishibi(TextBoxDateRange txtYukouKaishibi) {
        this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().setTxtYukouKaishibi(txtYukouKaishibi);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshamei() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getTxtJigyoshamei();
    }

    @JsonIgnore
    public void  setTxtJigyoshamei(TextBox txtJigyoshamei) {
        this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().setTxtJigyoshamei(txtJigyoshamei);
    }

    @JsonIgnore
    public DropDownList getDdlKennsakuKubun() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getDdlKennsakuKubun();
    }

    @JsonIgnore
    public void  setDdlKennsakuKubun(DropDownList ddlKennsakuKubun) {
        this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().setDdlKennsakuKubun(ddlKennsakuKubun);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public ServiceJigyoshaDiv getServiceJigyosha() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getServiceJigyosha();
    }

    @JsonIgnore
    public void  setServiceJigyosha(ServiceJigyoshaDiv ServiceJigyosha) {
        this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().setServiceJigyosha(ServiceJigyosha);
    }

    @JsonIgnore
    public DropDownList getDdlKennCode() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getServiceJigyosha().getDdlKennCode();
    }

    @JsonIgnore
    public void  setDdlKennCode(DropDownList ddlKennCode) {
        this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getServiceJigyosha().setDdlKennCode(ddlKennCode);
    }

    @JsonIgnore
    public DropDownList getDdlJigyoshaKubun() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getServiceJigyosha().getDdlJigyoshaKubun();
    }

    @JsonIgnore
    public void  setDdlJigyoshaKubun(DropDownList ddlJigyoshaKubun) {
        this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getServiceJigyosha().setDdlJigyoshaKubun(ddlJigyoshaKubun);
    }

    @JsonIgnore
    public DropDownList getDdlGunshiCode() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getServiceJigyosha().getDdlGunshiCode();
    }

    @JsonIgnore
    public void  setDdlGunshiCode(DropDownList ddlGunshiCode) {
        this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getServiceJigyosha().setDdlGunshiCode(ddlGunshiCode);
    }

    @JsonIgnore
    public DropDownList getDdlServiceShurui() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getServiceJigyosha().getDdlServiceShurui();
    }

    @JsonIgnore
    public void  setDdlServiceShurui(DropDownList ddlServiceShurui) {
        this.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getServiceJigyosha().setDdlServiceShurui(ddlServiceShurui);
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

    @JsonIgnore
    public DataGrid<dgJigyoshaItiran_Row> getDgJigyoshaItiran() {
        return this.getJigyoshaItirann().getDgJigyoshaItiran();
    }

    @JsonIgnore
    public void  setDgJigyoshaItiran(DataGrid<dgJigyoshaItiran_Row> dgJigyoshaItiran) {
        this.getJigyoshaItirann().setDgJigyoshaItiran(dgJigyoshaItiran);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
