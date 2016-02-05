package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ServiceCodeInputCommonChildDiv のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceCodeInputCommonChildDivDiv extends Panel implements IServiceCodeInputCommonChildDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblServiceCode")
    private Label lblServiceCode;
    @JsonProperty("txtServiceCode1")
    private TextBoxCode txtServiceCode1;
    @JsonProperty("txtServiceCode2")
    private TextBoxCode txtServiceCode2;
    @JsonProperty("btnKensaku")
    private ButtonDialog btnKensaku;
    @JsonProperty("txtServiceCodeName")
    private TextBox txtServiceCodeName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblServiceCode
     * @return lblServiceCode
     */
    @JsonProperty("lblServiceCode")
    public Label getLblServiceCode() {
        return lblServiceCode;
    }

    /*
     * setlblServiceCode
     * @param lblServiceCode lblServiceCode
     */
    @JsonProperty("lblServiceCode")
    public void setLblServiceCode(Label lblServiceCode) {
        this.lblServiceCode = lblServiceCode;
    }

    /*
     * gettxtServiceCode1
     * @return txtServiceCode1
     */
    @JsonProperty("txtServiceCode1")
    public TextBoxCode getTxtServiceCode1() {
        return txtServiceCode1;
    }

    /*
     * settxtServiceCode1
     * @param txtServiceCode1 txtServiceCode1
     */
    @JsonProperty("txtServiceCode1")
    public void setTxtServiceCode1(TextBoxCode txtServiceCode1) {
        this.txtServiceCode1 = txtServiceCode1;
    }

    /*
     * gettxtServiceCode2
     * @return txtServiceCode2
     */
    @JsonProperty("txtServiceCode2")
    public TextBoxCode getTxtServiceCode2() {
        return txtServiceCode2;
    }

    /*
     * settxtServiceCode2
     * @param txtServiceCode2 txtServiceCode2
     */
    @JsonProperty("txtServiceCode2")
    public void setTxtServiceCode2(TextBoxCode txtServiceCode2) {
        this.txtServiceCode2 = txtServiceCode2;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public ButtonDialog getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(ButtonDialog btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * gettxtServiceCodeName
     * @return txtServiceCodeName
     */
    @JsonProperty("txtServiceCodeName")
    public TextBox getTxtServiceCodeName() {
        return txtServiceCodeName;
    }

    /*
     * settxtServiceCodeName
     * @param txtServiceCodeName txtServiceCodeName
     */
    @JsonProperty("txtServiceCodeName")
    public void setTxtServiceCodeName(TextBox txtServiceCodeName) {
        this.txtServiceCodeName = txtServiceCodeName;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum State implements ICommonChildDivMode {

        入力("入力"),
        入力2("入力2"),
        照会("照会");

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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
