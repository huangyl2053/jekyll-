package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanShinseiList.ShokanShinseiList;
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
 * ShokanShinseiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShinseiListDiv extends Panel implements IShokanShinseiListDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceYM")
    private TextBoxDate txtServiceYM;
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("line")
    private HorizontalLine line;
    @JsonProperty("txtServiceYMFrom")
    private TextBoxDate txtServiceYMFrom;
    @JsonProperty("txtServiceYMTo")
    private TextBoxDate txtServiceYMTo;
    @JsonProperty("btnSelect")
    private Button btnSelect;
    @JsonProperty("dgShinseiList")
    private DataGrid<dgShinseiList_Row> dgShinseiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceYM
     * @return txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public TextBoxDate getTxtServiceYM() {
        return txtServiceYM;
    }

    /*
     * settxtServiceYM
     * @param txtServiceYM txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public void setTxtServiceYM(TextBoxDate txtServiceYM) {
        this.txtServiceYM = txtServiceYM;
    }

    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getline
     * @return line
     */
    @JsonProperty("line")
    public HorizontalLine getLine() {
        return line;
    }

    /*
     * setline
     * @param line line
     */
    @JsonProperty("line")
    public void setLine(HorizontalLine line) {
        this.line = line;
    }

    /*
     * gettxtServiceYMFrom
     * @return txtServiceYMFrom
     */
    @JsonProperty("txtServiceYMFrom")
    public TextBoxDate getTxtServiceYMFrom() {
        return txtServiceYMFrom;
    }

    /*
     * settxtServiceYMFrom
     * @param txtServiceYMFrom txtServiceYMFrom
     */
    @JsonProperty("txtServiceYMFrom")
    public void setTxtServiceYMFrom(TextBoxDate txtServiceYMFrom) {
        this.txtServiceYMFrom = txtServiceYMFrom;
    }

    /*
     * gettxtServiceYMTo
     * @return txtServiceYMTo
     */
    @JsonProperty("txtServiceYMTo")
    public TextBoxDate getTxtServiceYMTo() {
        return txtServiceYMTo;
    }

    /*
     * settxtServiceYMTo
     * @param txtServiceYMTo txtServiceYMTo
     */
    @JsonProperty("txtServiceYMTo")
    public void setTxtServiceYMTo(TextBoxDate txtServiceYMTo) {
        this.txtServiceYMTo = txtServiceYMTo;
    }

    /*
     * getbtnSelect
     * @return btnSelect
     */
    @JsonProperty("btnSelect")
    public Button getBtnSelect() {
        return btnSelect;
    }

    /*
     * setbtnSelect
     * @param btnSelect btnSelect
     */
    @JsonProperty("btnSelect")
    public void setBtnSelect(Button btnSelect) {
        this.btnSelect = btnSelect;
    }

    /*
     * getdgShinseiList
     * @return dgShinseiList
     */
    @JsonProperty("dgShinseiList")
    public DataGrid<dgShinseiList_Row> getDgShinseiList() {
        return dgShinseiList;
    }

    /*
     * setdgShinseiList
     * @param dgShinseiList dgShinseiList
     */
    @JsonProperty("dgShinseiList")
    public void setDgShinseiList(DataGrid<dgShinseiList_Row> dgShinseiList) {
        this.dgShinseiList = dgShinseiList;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayType implements ICommonChildDivMode {

        shokai("shokai"),
        toroku("toroku");

        private final String name;

        private DisplayType(final String name) {
            this.name = name;
        }

        public static DisplayType getEnum(String str) {
            DisplayType[] enumArray = DisplayType.values();

            for (DisplayType enumStr : enumArray) {
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

    public DisplayType getMode_DisplayType() {
        return (DisplayType) _CommonChildDivModeUtil.getMode( this.modes, DisplayType.class );
    }

    public void setMode_DisplayType( DisplayType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayType.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
