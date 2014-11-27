package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IIryoHokenRirekiDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgIryoHokenRireki_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.Dba3030011IryoHokenRirekiHandler;

/**
 * IryoHokenRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryoHokenRirekiDiv extends Panel implements IIryoHokenRirekiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddIryoHoken")
    private Button btnAddIryoHoken;
    @JsonProperty("dgIryoHokenRireki")
    private DataGrid<dgIryoHokenRireki_Row> dgIryoHokenRireki;
    @JsonProperty("mode")
    private RString mode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddIryoHoken")
    public Button getBtnAddIryoHoken() {
        return btnAddIryoHoken;
    }

    @JsonProperty("btnAddIryoHoken")
    public void setBtnAddIryoHoken(Button btnAddIryoHoken) {
        this.btnAddIryoHoken=btnAddIryoHoken;
    }

    @JsonProperty("dgIryoHokenRireki")
    public DataGrid<dgIryoHokenRireki_Row> getDgIryoHokenRireki() {
        return dgIryoHokenRireki;
    }

    @JsonProperty("dgIryoHokenRireki")
    public void setDgIryoHokenRireki(DataGrid<dgIryoHokenRireki_Row> dgIryoHokenRireki) {
        this.dgIryoHokenRireki=dgIryoHokenRireki;
    }

    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode=mode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        Shokai("Shokai"),
        Toroku("Toroku"),
        ShikakuIdo("ShikakuIdo");

        private final String name;

        private DisplayMode(final String name) {
            this.name = name;
        }

        public static DisplayMode getEnum(String str) {
            DisplayMode[] enumArray = DisplayMode.values();

            for (DisplayMode enumStr : enumArray) {
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

    public DisplayMode getMode_DisplayMode() {
        return (DisplayMode) _CommonChildDivModeUtil.getMode( this.modes, DisplayMode.class );
    }

    public void setMode_DisplayMode( DisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayMode.class , value );
    }

    public static enum WidthMode implements ICommonChildDivMode {

        Width1("Width1"),
        Width2("Width2");

        private final String name;

        private WidthMode(final String name) {
            this.name = name;
        }

        public static WidthMode getEnum(String str) {
            WidthMode[] enumArray = WidthMode.values();

            for (WidthMode enumStr : enumArray) {
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

    public WidthMode getMode_WidthMode() {
        return (WidthMode) _CommonChildDivModeUtil.getMode( this.modes, WidthMode.class );
    }

    public void setMode_WidthMode( WidthMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, WidthMode.class , value );
    }

    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void onClick_btnAddIryoHoken() {
        getHandler().onClick_btnAddIryoHoken();
    }

    @Override
    public void onClick_btnAddUpdate() {
        getHandler().onClick_btnAddUpdate();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @JsonIgnore
    public Dba3030011IryoHokenRirekiHandler getHandler() {
        return new Dba3030011IryoHokenRirekiHandler(this);
    }
}
