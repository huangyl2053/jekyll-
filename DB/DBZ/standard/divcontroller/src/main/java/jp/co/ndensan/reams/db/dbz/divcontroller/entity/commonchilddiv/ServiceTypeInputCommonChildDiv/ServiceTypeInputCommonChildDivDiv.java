package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv;
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
 * ServiceTypeInputCommonChildDiv のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceTypeInputCommonChildDivDiv extends Panel implements IServiceTypeInputCommonChildDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceType")
    private TextBoxCode txtServiceType;
    @JsonProperty("btnKensaku")
    private ButtonDialog btnKensaku;
    @JsonProperty("txtServiceTypeName")
    private TextBox txtServiceTypeName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceType
     * @return txtServiceType
     */
    @JsonProperty("txtServiceType")
    public TextBoxCode getTxtServiceType() {
        return txtServiceType;
    }

    /*
     * settxtServiceType
     * @param txtServiceType txtServiceType
     */
    @JsonProperty("txtServiceType")
    public void setTxtServiceType(TextBoxCode txtServiceType) {
        this.txtServiceType = txtServiceType;
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
     * gettxtServiceTypeName
     * @return txtServiceTypeName
     */
    @JsonProperty("txtServiceTypeName")
    public TextBox getTxtServiceTypeName() {
        return txtServiceTypeName;
    }

    /*
     * settxtServiceTypeName
     * @param txtServiceTypeName txtServiceTypeName
     */
    @JsonProperty("txtServiceTypeName")
    public void setTxtServiceTypeName(TextBox txtServiceTypeName) {
        this.txtServiceTypeName = txtServiceTypeName;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum State implements ICommonChildDivMode {

        入力("入力"),
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
