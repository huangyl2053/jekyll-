package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;
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

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * JigyoshaNyuryokuGudieCommonChildDiv のクラスファイル
 *
 * @reamsid_L DBA-0140-010 houtianpeng
 */
public class JigyoshaNyuryokuGudieCommonChildDivDiv extends Panel implements IJigyoshaNyuryokuGudieCommonChildDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum State implements ICommonChildDivMode {

        サービス事業者処理モード("サービス事業者処理モード"),
        その他特例施設処理モード("その他特例施設処理モード"),
        適用除外施設処理モード("適用除外施設処理モード"),
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
        return (State) _CommonChildDivModeUtil.getMode(this.modes, State.class);
    }

    public void setMode_State(State value) {
        _CommonChildDivModeUtil.setMode(this.modes, State.class, value);
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KennsakuJyokennDiv getKennsakuJyokenn() {
        return this.getTaishoJigyoshaKensaku().getKennsakuJyokenn();
    }

    @JsonIgnore
    public void setKennsakuJyokenn(KennsakuJyokennDiv KennsakuJyokenn) {
        this.getTaishoJigyoshaKensaku().setKennsakuJyokenn(KennsakuJyokenn);
    }

    @JsonIgnore
    public OtherTokureiShisetsuDiv getOtherTokureiShisetsu() {
        return this.getTaishoJigyoshaKensaku().getOtherTokureiShisetsu();
    }

    @JsonIgnore
    public void setOtherTokureiShisetsu(OtherTokureiShisetsuDiv OtherTokureiShisetsu) {
        this.getTaishoJigyoshaKensaku().setOtherTokureiShisetsu(OtherTokureiShisetsu);
    }

    @JsonIgnore
    public RadioButton getRadKannaiKanngaiKubun() {
        return this.getTaishoJigyoshaKensaku().getOtherTokureiShisetsu().getRadKannaiKanngaiKubun();
    }

    @JsonIgnore
    public void setRadKannaiKanngaiKubun(RadioButton radKannaiKanngaiKubun) {
        this.getTaishoJigyoshaKensaku().getOtherTokureiShisetsu().setRadKannaiKanngaiKubun(radKannaiKanngaiKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxHyojiKensu() {
        return this.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu();
    }

    @JsonIgnore
    public void setTxtMaxHyojiKensu(TextBoxNum txtMaxHyojiKensu) {
        this.getTaishoJigyoshaKensaku().setTxtMaxHyojiKensu(txtMaxHyojiKensu);
    }

    @JsonIgnore
    public Button getBtnTaishoJigyoshaKensaku() {
        return this.getTaishoJigyoshaKensaku().getBtnTaishoJigyoshaKensaku();
    }

    @JsonIgnore
    public void setBtnTaishoJigyoshaKensaku(Button btnTaishoJigyoshaKensaku) {
        this.getTaishoJigyoshaKensaku().setBtnTaishoJigyoshaKensaku(btnTaishoJigyoshaKensaku);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getTaishoJigyoshaKensaku().getBtnClear();
    }

    @JsonIgnore
    public void setBtnClear(Button btnClear) {
        this.getTaishoJigyoshaKensaku().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnYameru() {
        return this.getTaishoJigyoshaKensaku().getBtnYameru();
    }

    @JsonIgnore
    public void setBtnYameru(Button btnYameru) {
        this.getTaishoJigyoshaKensaku().setBtnYameru(btnYameru);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private JiGyoSyaHandler getHandler() {
        return new JiGyoSyaHandler(this);
    }

    /**
     * 共通子DIVの初期化処理です。
     *
     *
     * @param mode JigyoshaMode
     */
    @Override
    public void initialize(JigyoshaMode mode) {
        getHandler().initialize(mode);
    }

    /**
     * やめるを実行します。
     *
     */
    @Override
    public void setYaMeRu() {
        getHandler().setYaMeRu();
    }

    /**
     * 共通子DIVの初期化処理です。
     *
     *
     */
    @Override
    public void select_BtnSenTaKu() {
    }

    @Override
    public JigyoshaNyuryokuGudieCommonChildDivDiv getJigyoshaNyuryokuGudieCommonChildDiv() {
        return this;
    }

}
