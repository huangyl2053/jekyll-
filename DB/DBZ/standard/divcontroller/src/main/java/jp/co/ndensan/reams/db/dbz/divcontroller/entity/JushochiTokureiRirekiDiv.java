package jp.co.ndensan.reams.db.dbz.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IJushochiTokureiRirekiDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgJushochiTokureiRireki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * JushochiTokureiRireki のクラスファイル
 *
 * @author 自動生成
 */
public class JushochiTokureiRirekiDiv extends Panel implements IJushochiTokureiRirekiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgJushochiTokureiRireki")
    private DataGrid<dgJushochiTokureiRireki_Row> dgJushochiTokureiRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    @Override
    @JsonProperty("dgJushochiTokureiRireki")
    public DataGrid<dgJushochiTokureiRireki_Row> getDgJushochiTokureiRireki() {
        return dgJushochiTokureiRireki;
    }

    @JsonProperty("dgJushochiTokureiRireki")
    public void setDgJushochiTokureiRireki(DataGrid<dgJushochiTokureiRireki_Row> dgJushochiTokureiRireki) {
        this.dgJushochiTokureiRireki = dgJushochiTokureiRireki;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum TashichosonTeiseiDisplayMode implements ICommonChildDivMode {

        Shokai("Shokai"),
        IdoToroku("IdoToroku"),
        IdoToroku_SelectButton("IdoToroku_SelectButton");

        private final String name;

        private TashichosonTeiseiDisplayMode(final String name) {
            this.name = name;
        }

        public static TashichosonTeiseiDisplayMode getEnum(String str) {
            TashichosonTeiseiDisplayMode[] enumArray = TashichosonTeiseiDisplayMode.values();

            for (TashichosonTeiseiDisplayMode enumStr : enumArray) {
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

    public TashichosonTeiseiDisplayMode getMode_TashichosonTeiseiDisplayMode() {
        return (TashichosonTeiseiDisplayMode) _CommonChildDivModeUtil.getMode(this.modes, TashichosonTeiseiDisplayMode.class);
    }

    public void setMode_TashichosonTeiseiDisplayMode(TashichosonTeiseiDisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, TashichosonTeiseiDisplayMode.class, value);
    }

    public static enum TashichosonDisplayMode implements ICommonChildDivMode {

        Shokai("Shokai"),
        IdoToroku("IdoToroku");

        private final String name;

        private TashichosonDisplayMode(final String name) {
            this.name = name;
        }

        public static TashichosonDisplayMode getEnum(String str) {
            TashichosonDisplayMode[] enumArray = TashichosonDisplayMode.values();

            for (TashichosonDisplayMode enumStr : enumArray) {
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

    public TashichosonDisplayMode getMode_TashichosonDisplayMode() {
        return (TashichosonDisplayMode) _CommonChildDivModeUtil.getMode(this.modes, TashichosonDisplayMode.class);
    }

    public void setMode_TashichosonDisplayMode(TashichosonDisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, TashichosonDisplayMode.class, value);
    }

    public static enum TekiyoJogaiDisplayMode implements ICommonChildDivMode {

        Shokai("Shokai"),
        IdoToroku("IdoToroku");

        private final String name;

        private TekiyoJogaiDisplayMode(final String name) {
            this.name = name;
        }

        public static TekiyoJogaiDisplayMode getEnum(String str) {
            TekiyoJogaiDisplayMode[] enumArray = TekiyoJogaiDisplayMode.values();

            for (TekiyoJogaiDisplayMode enumStr : enumArray) {
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

    public TekiyoJogaiDisplayMode getMode_TekiyoJogaiDisplayMode() {
        return (TekiyoJogaiDisplayMode) _CommonChildDivModeUtil.getMode(this.modes, TekiyoJogaiDisplayMode.class);
    }

    public void setMode_TekiyoJogaiDisplayMode(TekiyoJogaiDisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, TekiyoJogaiDisplayMode.class, value);
    }

    public static enum TekiyoJogaiTeiseiDisplayMode implements ICommonChildDivMode {

        Shokai("Shokai"),
        IdoToroku("IdoToroku"),
        IdoToroku_SelectButton("IdoToroku_SelectButton");

        private final String name;

        private TekiyoJogaiTeiseiDisplayMode(final String name) {
            this.name = name;
        }

        public static TekiyoJogaiTeiseiDisplayMode getEnum(String str) {
            TekiyoJogaiTeiseiDisplayMode[] enumArray = TekiyoJogaiTeiseiDisplayMode.values();

            for (TekiyoJogaiTeiseiDisplayMode enumStr : enumArray) {
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

    public TekiyoJogaiTeiseiDisplayMode getMode_TekiyoJogaiTeiseiDisplayMode() {
        return (TekiyoJogaiTeiseiDisplayMode) _CommonChildDivModeUtil.getMode(this.modes, TekiyoJogaiTeiseiDisplayMode.class);
    }

    public void setMode_TekiyoJogaiTeiseiDisplayMode(TekiyoJogaiTeiseiDisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, TekiyoJogaiTeiseiDisplayMode.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
}
