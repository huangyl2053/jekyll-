package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShisetsuJohoCommonChildDiv のクラスファイル
 *
 * @author 自動生成
 */
public class ShisetsuJohoCommonChildDivDiv extends Panel implements IShisetsuJohoCommonChildDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlDaichoShubetsu")
    private DropDownList ddlDaichoShubetsu;
    @JsonProperty("radKaigoHokenShisetsu")
    private RadioButton radKaigoHokenShisetsu;
    @JsonProperty("radOtherTokureiShisetsu")
    private RadioButton radOtherTokureiShisetsu;
    @JsonProperty("radTekiyoJyogaiShisetsu")
    private RadioButton radTekiyoJyogaiShisetsu;
    @JsonProperty("txtNyuryokuShisetsuKodo")
    private TextBox txtNyuryokuShisetsuKodo;
    @JsonProperty("btnJigyoshaKensaku")
    private ButtonDialog btnJigyoshaKensaku;
    @JsonProperty("txtNyuryokuShisetsuMeisho")
    private TextBox txtNyuryokuShisetsuMeisho;
    @JsonProperty("JigyoshaMode")
    private RString JigyoshaMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlDaichoShubetsu
     * @return ddlDaichoShubetsu
     */
    @JsonProperty("ddlDaichoShubetsu")
    public DropDownList getDdlDaichoShubetsu() {
        return ddlDaichoShubetsu;
    }

    /*
     * setddlDaichoShubetsu
     * @param ddlDaichoShubetsu ddlDaichoShubetsu
     */
    @JsonProperty("ddlDaichoShubetsu")
    public void setDdlDaichoShubetsu(DropDownList ddlDaichoShubetsu) {
        this.ddlDaichoShubetsu = ddlDaichoShubetsu;
    }

    /*
     * getradKaigoHokenShisetsu
     * @return radKaigoHokenShisetsu
     */
    @JsonProperty("radKaigoHokenShisetsu")
    public RadioButton getRadKaigoHokenShisetsu() {
        return radKaigoHokenShisetsu;
    }

    /*
     * setradKaigoHokenShisetsu
     * @param radKaigoHokenShisetsu radKaigoHokenShisetsu
     */
    @JsonProperty("radKaigoHokenShisetsu")
    public void setRadKaigoHokenShisetsu(RadioButton radKaigoHokenShisetsu) {
        this.radKaigoHokenShisetsu = radKaigoHokenShisetsu;
    }

    /*
     * getradOtherTokureiShisetsu
     * @return radOtherTokureiShisetsu
     */
    @JsonProperty("radOtherTokureiShisetsu")
    public RadioButton getRadOtherTokureiShisetsu() {
        return radOtherTokureiShisetsu;
    }

    /*
     * setradOtherTokureiShisetsu
     * @param radOtherTokureiShisetsu radOtherTokureiShisetsu
     */
    @JsonProperty("radOtherTokureiShisetsu")
    public void setRadOtherTokureiShisetsu(RadioButton radOtherTokureiShisetsu) {
        this.radOtherTokureiShisetsu = radOtherTokureiShisetsu;
    }

    /*
     * getradTekiyoJyogaiShisetsu
     * @return radTekiyoJyogaiShisetsu
     */
    @JsonProperty("radTekiyoJyogaiShisetsu")
    public RadioButton getRadTekiyoJyogaiShisetsu() {
        return radTekiyoJyogaiShisetsu;
    }

    /*
     * setradTekiyoJyogaiShisetsu
     * @param radTekiyoJyogaiShisetsu radTekiyoJyogaiShisetsu
     */
    @JsonProperty("radTekiyoJyogaiShisetsu")
    public void setRadTekiyoJyogaiShisetsu(RadioButton radTekiyoJyogaiShisetsu) {
        this.radTekiyoJyogaiShisetsu = radTekiyoJyogaiShisetsu;
    }

    /*
     * gettxtNyuryokuShisetsuKodo
     * @return txtNyuryokuShisetsuKodo
     */
    @JsonProperty("txtNyuryokuShisetsuKodo")
    public TextBox getTxtNyuryokuShisetsuKodo() {
        return txtNyuryokuShisetsuKodo;
    }

    /*
     * settxtNyuryokuShisetsuKodo
     * @param txtNyuryokuShisetsuKodo txtNyuryokuShisetsuKodo
     */
    @JsonProperty("txtNyuryokuShisetsuKodo")
    public void setTxtNyuryokuShisetsuKodo(TextBox txtNyuryokuShisetsuKodo) {
        this.txtNyuryokuShisetsuKodo = txtNyuryokuShisetsuKodo;
    }

    /*
     * getbtnJigyoshaKensaku
     * @return btnJigyoshaKensaku
     */
    @JsonProperty("btnJigyoshaKensaku")
    public ButtonDialog getBtnJigyoshaKensaku() {
        return btnJigyoshaKensaku;
    }

    /*
     * setbtnJigyoshaKensaku
     * @param btnJigyoshaKensaku btnJigyoshaKensaku
     */
    @JsonProperty("btnJigyoshaKensaku")
    public void setBtnJigyoshaKensaku(ButtonDialog btnJigyoshaKensaku) {
        this.btnJigyoshaKensaku = btnJigyoshaKensaku;
    }

    /*
     * gettxtNyuryokuShisetsuMeisho
     * @return txtNyuryokuShisetsuMeisho
     */
    @JsonProperty("txtNyuryokuShisetsuMeisho")
    public TextBox getTxtNyuryokuShisetsuMeisho() {
        return txtNyuryokuShisetsuMeisho;
    }

    /*
     * settxtNyuryokuShisetsuMeisho
     * @param txtNyuryokuShisetsuMeisho txtNyuryokuShisetsuMeisho
     */
    @JsonProperty("txtNyuryokuShisetsuMeisho")
    public void setTxtNyuryokuShisetsuMeisho(TextBox txtNyuryokuShisetsuMeisho) {
        this.txtNyuryokuShisetsuMeisho = txtNyuryokuShisetsuMeisho;
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
        
        DaichoShubetsuAriMode("DaichoShubetsuAriMode"),
        DaichoShubetsuNashiMode("DaichoShubetsuNashiMode"),
        KaigoHokenMode("KaigoHokenMode"),
        OtherTokureiMode("OtherTokureiMode"),
        TekiyoJogaiMode("TekiyoJogaiMode"),
        JigyoshaInputGuideMode("JigyoshaInputGuideMode");
        
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private ShisetsuJohoHandler getHandler() {
        return new ShisetsuJohoHandler(this);
    }

    /**
     * 共通子DIVの初期化処理です。
     *
     *
     */
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    /**
     * 共通子DIVのget入所施設コードです。
     *
     * @return 入所施設コード
     */
    @Override
    public RString getNyuryokuShisetsuKodo() {
        return getHandler().getNyuryokuShisetsuKodo();
    }

    /**
     * 共通子DIVのget入所施設名称です。
     *
     * @return 入所施設名称
     */
    @Override
    public RString getNyuryokuShisetsuMeisho() {
        return getHandler().getNyuryokuShisetsuMeisho();
    }

    /**
     * 共通子DIVの入所施設コードを渡すと入所施設名称を取得して表示するメソッドです。
     *
     * @param nyuryokuShisetsucode 入所施設コード
     */
    @Override
    public void setNyuryokuShisetsuMeisho(RString nyuryokuShisetsucode) {
        getHandler().setNyuryokuShisetsuMeisho(nyuryokuShisetsucode);
    }
}
