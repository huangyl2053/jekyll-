package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShisetsuJohoCommonChildDiv のクラスファイル
 *
 * @reamsid_L DBA-0190-010 houtianpeng
 */
public class ShisetsuJohoCommonChildDivDiv extends Panel implements IShisetsuJohoCommonChildDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
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
    private TextBoxCode txtNyuryokuShisetsuKodo;
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
    @Override
    public RadioButton getRadKaigoHokenShisetsu() {
        return radKaigoHokenShisetsu;
    }

    /*
     * setradKaigoHokenShisetsu
     * @param radKaigoHokenShisetsu radKaigoHokenShisetsu
     */
    @JsonProperty("radKaigoHokenShisetsu")
    @Override
    public void setRadKaigoHokenShisetsu(RadioButton radKaigoHokenShisetsu) {
        this.radKaigoHokenShisetsu = radKaigoHokenShisetsu;
    }

    /*
     * getradOtherTokureiShisetsu
     * @return radOtherTokureiShisetsu
     */
    @JsonProperty("radOtherTokureiShisetsu")
    @Override
    public RadioButton getRadOtherTokureiShisetsu() {
        return radOtherTokureiShisetsu;
    }

    /*
     * setradOtherTokureiShisetsu
     * @param radOtherTokureiShisetsu radOtherTokureiShisetsu
     */
    @JsonProperty("radOtherTokureiShisetsu")
    @Override
    public void setRadOtherTokureiShisetsu(RadioButton radOtherTokureiShisetsu) {
        this.radOtherTokureiShisetsu = radOtherTokureiShisetsu;
    }

    /*
     * getradTekiyoJyogaiShisetsu
     * @return radTekiyoJyogaiShisetsu
     */
    @JsonProperty("radTekiyoJyogaiShisetsu")
    @Override
    public RadioButton getRadTekiyoJyogaiShisetsu() {
        return radTekiyoJyogaiShisetsu;
    }

    /*
     * setradTekiyoJyogaiShisetsu
     * @param radTekiyoJyogaiShisetsu radTekiyoJyogaiShisetsu
     */
    @JsonProperty("radTekiyoJyogaiShisetsu")
    @Override
    public void setRadTekiyoJyogaiShisetsu(RadioButton radTekiyoJyogaiShisetsu) {
        this.radTekiyoJyogaiShisetsu = radTekiyoJyogaiShisetsu;
    }

    /*
     * gettxtNyuryokuShisetsuKodo
     * @return txtNyuryokuShisetsuKodo
     */
    @JsonProperty("txtNyuryokuShisetsuKodo")
    @Override
    public TextBoxCode getTxtNyuryokuShisetsuKodo() {
        return txtNyuryokuShisetsuKodo;
    }

    /*
     * settxtNyuryokuShisetsuKodo
     * @param txtNyuryokuShisetsuKodo txtNyuryokuShisetsuKodo
     */
    @JsonProperty("txtNyuryokuShisetsuKodo")
    public void setTxtNyuryokuShisetsuKodo(TextBoxCode txtNyuryokuShisetsuKodo) {
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
    @Override
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
    public void setNyuryokuShisetsuKodo(RString nyuryokuShisetsucode) {
        getHandler().setNyuryokuShisetsuKodo(nyuryokuShisetsucode);
    }

    /**
     * 台帳種別の取得。
     *
     *
     * @return 台帳種別
     */
    @Override
    public RString getDaichoShubetsu() {
        return getHandler().getDdlDaichoShubetsu();
    }

    /**
     * 台帳種別の設定。
     *
     * @param key 台帳種別
     */
    @Override
    public void set台帳種別(RString key) {
        getHandler().set台帳種別(key);
    }

    /**
     * 施設種類の取得。
     *
     * @return 施設種類
     */
    @Override
    public RString get施設種類() {
        return getHandler().get施設種類();
    }

    @Override
    public ValidationMessageControlPairs validate施設種類() {
        return getHandler().validate施設種類();
    }

    /**
     * 施設種類の設定。
     *
     * @param key 施設種類
     */
    @Override
    public void set施設種類(RString key) {
        getHandler().set施設種類(key);
    }

    /**
     * クリア.
     *
     */
    @Override
    public void clear() {
        getHandler().clear();
    }

    /**
     * 事業者名称の設定.
     *
     * @param meisho 事業者名称
     */
    @Override
    public void setShisetsuMeisho(RString meisho) {
        getHandler().setShisetsuMeisho(meisho);
    }

    /**
     * 入所施設名称の設定.
     *
     * @param 入所施設コード 入所施設コード
     */
    @Override
    public void get入所施設名称(JigyoshaNo 入所施設コード) {
        getHandler().get入所施設名称(入所施設コード);
    }

    /**
     * サービス種類抽出区分とサービス種類の設定.
     *
     * @param サービス種類抽出区分 RString
     * @param サービス種類 List<RString>
     */
    @Override
    public void setサービス種類(RString サービス種類抽出区分, List<RString> サービス種類) {
        getHandler().setサービス種類(サービス種類抽出区分, サービス種類);
    }
}
