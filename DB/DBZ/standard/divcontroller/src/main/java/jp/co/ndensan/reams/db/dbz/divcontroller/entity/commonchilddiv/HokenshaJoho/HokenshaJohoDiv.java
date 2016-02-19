package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho;
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
 * HokenshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenshaJohoDiv extends Panel implements IHokenshaJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenshaNo")
    private TextBoxCode txtHokenshaNo;
    @JsonProperty("btnHokenshaSelect")
    private ButtonDialog btnHokenshaSelect;
    @JsonProperty("txtHokenshaMeisho")
    private TextBox txtHokenshaMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHokenshaNo
     * @return txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public TextBoxCode getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    /*
     * settxtHokenshaNo
     * @param txtHokenshaNo txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public void setTxtHokenshaNo(TextBoxCode txtHokenshaNo) {
        this.txtHokenshaNo = txtHokenshaNo;
    }

    /*
     * getbtnHokenshaSelect
     * @return btnHokenshaSelect
     */
    @JsonProperty("btnHokenshaSelect")
    public ButtonDialog getBtnHokenshaSelect() {
        return btnHokenshaSelect;
    }

    /*
     * setbtnHokenshaSelect
     * @param btnHokenshaSelect btnHokenshaSelect
     */
    @JsonProperty("btnHokenshaSelect")
    public void setBtnHokenshaSelect(ButtonDialog btnHokenshaSelect) {
        this.btnHokenshaSelect = btnHokenshaSelect;
    }

    /*
     * gettxtHokenshaMeisho
     * @return txtHokenshaMeisho
     */
    @JsonProperty("txtHokenshaMeisho")
    public TextBox getTxtHokenshaMeisho() {
        return txtHokenshaMeisho;
    }

    /*
     * settxtHokenshaMeisho
     * @param txtHokenshaMeisho txtHokenshaMeisho
     */
    @JsonProperty("txtHokenshaMeisho")
    public void setTxtHokenshaMeisho(TextBox txtHokenshaMeisho) {
        this.txtHokenshaMeisho = txtHokenshaMeisho;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum State implements ICommonChildDivMode {

        reference("reference"),
        modify("modify");

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
