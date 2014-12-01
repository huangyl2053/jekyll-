package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKaigoAtenaInfoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IAtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KaigoAtenaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoAtenaInfoDiv extends Panel implements IKaigoAtenaInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("atenaInfo")
    private AtenaShokaiSimpleDiv atenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("atenaInfo")
    public IAtenaShokaiSimpleDiv getAtenaInfo() {
        return atenaInfo;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum BtnEltaxDisplay implements ICommonChildDivMode {

        指定無し("指定無し"),
        表示しない("表示しない");

        private final String name;

        private BtnEltaxDisplay(final String name) {
            this.name = name;
        }

        public static BtnEltaxDisplay getEnum(String str) {
            BtnEltaxDisplay[] enumArray = BtnEltaxDisplay.values();

            for (BtnEltaxDisplay enumStr : enumArray) {
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

    public BtnEltaxDisplay getMode_BtnEltaxDisplay() {
        return (BtnEltaxDisplay) _CommonChildDivModeUtil.getMode( this.modes, BtnEltaxDisplay.class );
    }

    public void setMode_BtnEltaxDisplay( BtnEltaxDisplay value ) {
        _CommonChildDivModeUtil.setMode( this.modes, BtnEltaxDisplay.class , value );
    }

    public static enum BtnAtesakiDisplay implements ICommonChildDivMode {

        指定無し("指定無し"),
        表示しない("表示しない");

        private final String name;

        private BtnAtesakiDisplay(final String name) {
            this.name = name;
        }

        public static BtnAtesakiDisplay getEnum(String str) {
            BtnAtesakiDisplay[] enumArray = BtnAtesakiDisplay.values();

            for (BtnAtesakiDisplay enumStr : enumArray) {
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

    public BtnAtesakiDisplay getMode_BtnAtesakiDisplay() {
        return (BtnAtesakiDisplay) _CommonChildDivModeUtil.getMode( this.modes, BtnAtesakiDisplay.class );
    }

    public void setMode_BtnAtesakiDisplay( BtnAtesakiDisplay value ) {
        _CommonChildDivModeUtil.setMode( this.modes, BtnAtesakiDisplay.class , value );
    }

    public static enum BtnDainoninDisplay implements ICommonChildDivMode {

        指定無し("指定無し"),
        表示しない("表示しない");

        private final String name;

        private BtnDainoninDisplay(final String name) {
            this.name = name;
        }

        public static BtnDainoninDisplay getEnum(String str) {
            BtnDainoninDisplay[] enumArray = BtnDainoninDisplay.values();

            for (BtnDainoninDisplay enumStr : enumArray) {
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

    public BtnDainoninDisplay getMode_BtnDainoninDisplay() {
        return (BtnDainoninDisplay) _CommonChildDivModeUtil.getMode( this.modes, BtnDainoninDisplay.class );
    }

    public void setMode_BtnDainoninDisplay( BtnDainoninDisplay value ) {
        _CommonChildDivModeUtil.setMode( this.modes, BtnDainoninDisplay.class , value );
    }

    public static enum BtnKozaDisplay implements ICommonChildDivMode {

        指定無し("指定無し"),
        表示しない("表示しない");

        private final String name;

        private BtnKozaDisplay(final String name) {
            this.name = name;
        }

        public static BtnKozaDisplay getEnum(String str) {
            BtnKozaDisplay[] enumArray = BtnKozaDisplay.values();

            for (BtnKozaDisplay enumStr : enumArray) {
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

    public BtnKozaDisplay getMode_BtnKozaDisplay() {
        return (BtnKozaDisplay) _CommonChildDivModeUtil.getMode( this.modes, BtnKozaDisplay.class );
    }

    public void setMode_BtnKozaDisplay( BtnKozaDisplay value ) {
        _CommonChildDivModeUtil.setMode( this.modes, BtnKozaDisplay.class , value );
    }

    public static enum BtnSetaiDisplay implements ICommonChildDivMode {

        指定無し("指定無し"),
        表示しない("表示しない");

        private final String name;

        private BtnSetaiDisplay(final String name) {
            this.name = name;
        }

        public static BtnSetaiDisplay getEnum(String str) {
            BtnSetaiDisplay[] enumArray = BtnSetaiDisplay.values();

            for (BtnSetaiDisplay enumStr : enumArray) {
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

    public BtnSetaiDisplay getMode_BtnSetaiDisplay() {
        return (BtnSetaiDisplay) _CommonChildDivModeUtil.getMode( this.modes, BtnSetaiDisplay.class );
    }

    public void setMode_BtnSetaiDisplay( BtnSetaiDisplay value ) {
        _CommonChildDivModeUtil.setMode( this.modes, BtnSetaiDisplay.class , value );
    }

    public static enum DisplayType implements ICommonChildDivMode {

        一行タイプ("一行タイプ"),
        三行タイプ("三行タイプ"),
        指定無し("指定無し");

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

    public static enum BtnSofusakiDisplay implements ICommonChildDivMode {

        指定無し("指定無し"),
        表示しない("表示しない");

        private final String name;

        private BtnSofusakiDisplay(final String name) {
            this.name = name;
        }

        public static BtnSofusakiDisplay getEnum(String str) {
            BtnSofusakiDisplay[] enumArray = BtnSofusakiDisplay.values();

            for (BtnSofusakiDisplay enumStr : enumArray) {
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

    public BtnSofusakiDisplay getMode_BtnSofusakiDisplay() {
        return (BtnSofusakiDisplay) _CommonChildDivModeUtil.getMode( this.modes, BtnSofusakiDisplay.class );
    }

    public void setMode_BtnSofusakiDisplay( BtnSofusakiDisplay value ) {
        _CommonChildDivModeUtil.setMode( this.modes, BtnSofusakiDisplay.class , value );
    }

    //--------------- この行より下にコードを追加してください -------------------

}
