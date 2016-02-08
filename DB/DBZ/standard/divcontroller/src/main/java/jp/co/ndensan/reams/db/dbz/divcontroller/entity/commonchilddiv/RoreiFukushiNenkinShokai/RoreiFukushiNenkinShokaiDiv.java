package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * RoreiFukushiNenkinShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class RoreiFukushiNenkinShokaiDiv extends Panel implements IRoreiFukushiNenkinShokaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelRireki")
    private panelRirekiDiv panelRireki;
    @JsonProperty("panelInput")
    private panelInputDiv panelInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelRireki
     * @return panelRireki
     */
    @JsonProperty("panelRireki")
    public panelRirekiDiv getPanelRireki() {
        return panelRireki;
    }

    /*
     * setpanelRireki
     * @param panelRireki panelRireki
     */
    @JsonProperty("panelRireki")
    public void setPanelRireki(panelRirekiDiv panelRireki) {
        this.panelRireki = panelRireki;
    }

    /*
     * getpanelInput
     * @return panelInput
     */
    @JsonProperty("panelInput")
    public panelInputDiv getPanelInput() {
        return panelInput;
    }

    /*
     * setpanelInput
     * @param panelInput panelInput
     */
    @JsonProperty("panelInput")
    public void setPanelInput(panelInputDiv panelInput) {
        this.panelInput = panelInput;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ModeC implements ICommonChildDivMode {

        init("init");

        private final String name;

        private ModeC(final String name) {
            this.name = name;
        }

        public static ModeC getEnum(String str) {
            ModeC[] enumArray = ModeC.values();

            for (ModeC enumStr : enumArray) {
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

    public ModeC getMode_ModeC() {
        return (ModeC) _CommonChildDivModeUtil.getMode( this.modes, ModeC.class );
    }

    public void setMode_ModeC( ModeC value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ModeC.class , value );
    }

    public static enum ModeA implements ICommonChildDivMode {

        init("init");

        private final String name;

        private ModeA(final String name) {
            this.name = name;
        }

        public static ModeA getEnum(String str) {
            ModeA[] enumArray = ModeA.values();

            for (ModeA enumStr : enumArray) {
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

    public ModeA getMode_ModeA() {
        return (ModeA) _CommonChildDivModeUtil.getMode( this.modes, ModeA.class );
    }

    public void setMode_ModeA( ModeA value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ModeA.class , value );
    }

    public static enum ModeB implements ICommonChildDivMode {

        update("update");

        private final String name;

        private ModeB(final String name) {
            this.name = name;
        }

        public static ModeB getEnum(String str) {
            ModeB[] enumArray = ModeB.values();

            for (ModeB enumStr : enumArray) {
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

    public ModeB getMode_ModeB() {
        return (ModeB) _CommonChildDivModeUtil.getMode( this.modes, ModeB.class );
    }

    public void setMode_ModeB( ModeB value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ModeB.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getPanelRireki().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getPanelRireki().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<datagridRireki_Row> getDatagridRireki() {
        return this.getPanelRireki().getDatagridRireki();
    }

    @JsonIgnore
    public void  setDatagridRireki(DataGrid<datagridRireki_Row> datagridRireki) {
        this.getPanelRireki().setDatagridRireki(datagridRireki);
    }

    @JsonIgnore
    public TextBoxDate getTxtStartDate() {
        return this.getPanelInput().getTxtStartDate();
    }

    @JsonIgnore
    public void  setTxtStartDate(TextBoxDate txtStartDate) {
        this.getPanelInput().setTxtStartDate(txtStartDate);
    }

    @JsonIgnore
    public TextBoxDate getTxtEndDate() {
        return this.getPanelInput().getTxtEndDate();
    }

    @JsonIgnore
    public void  setTxtEndDate(TextBoxDate txtEndDate) {
        this.getPanelInput().setTxtEndDate(txtEndDate);
    }

    @JsonIgnore
    public Button getBtnSave() {
        return this.getPanelInput().getBtnSave();
    }

    @JsonIgnore
    public void  setBtnSave(Button btnSave) {
        this.getPanelInput().setBtnSave(btnSave);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelInput().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelInput().setBtnCancel(btnCancel);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
