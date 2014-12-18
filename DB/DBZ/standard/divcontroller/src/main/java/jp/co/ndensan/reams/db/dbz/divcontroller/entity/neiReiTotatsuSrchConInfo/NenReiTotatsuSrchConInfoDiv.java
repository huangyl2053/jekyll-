package jp.co.ndensan.reams.db.dbz.divcontroller.entity.neiReiTotatsuSrchConInfo;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.neiReiTotatsuSrchConInfo.INenReiTotatsuSrchConInfoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * NenReiTotatsuSrchConInfo のクラスファイル
 *
 * @author 自動生成
 */
public class NenReiTotatsuSrchConInfoDiv extends Panel implements INenReiTotatsuSrchConInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtZenkaiFrom")
    private TextBoxFlexibleDate txtZenkaiFrom;
    @JsonProperty("txtZenkaiTo")
    private TextBoxFlexibleDate txtZenkaiTo;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("txtNenreiTotatsuKikanFrom")
    private TextBoxFlexibleDate txtNenreiTotatsuKikanFrom;
    @JsonProperty("txtNenreiTotatsuKikanTo")
    private TextBoxFlexibleDate txtNenreiTotatsuKikanTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtZenkaiFrom")
    @Override
    public TextBoxFlexibleDate getTxtZenkaiFrom() {
        return txtZenkaiFrom;
    }

    @JsonProperty("txtZenkaiFrom")
    @Override
    public void setTxtZenkaiFrom(TextBoxFlexibleDate txtZenkaiFrom) {
        this.txtZenkaiFrom = txtZenkaiFrom;
    }

    @JsonProperty("txtZenkaiTo")
    @Override
    public TextBoxFlexibleDate getTxtZenkaiTo() {
        return txtZenkaiTo;
    }

    @JsonProperty("txtZenkaiTo")
    @Override
    public void setTxtZenkaiTo(TextBoxFlexibleDate txtZenkaiTo) {
        this.txtZenkaiTo = txtZenkaiTo;
    }

    @JsonProperty("btnKensaku")
    @Override
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    @JsonProperty("btnKensaku")
    @Override
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    @JsonProperty("txtNenreiTotatsuKikanFrom")
    @Override
    public TextBoxFlexibleDate getTxtNenreiTotatsuKikanFrom() {
        return txtNenreiTotatsuKikanFrom;
    }

    @JsonProperty("txtNenreiTotatsuKikanFrom")
    @Override
    public void setTxtNenreiTotatsuKikanFrom(TextBoxFlexibleDate txtNenreiTotatsuKikanFrom) {
        this.txtNenreiTotatsuKikanFrom = txtNenreiTotatsuKikanFrom;
    }

    @JsonProperty("txtNenreiTotatsuKikanTo")
    @Override
    public TextBoxFlexibleDate getTxtNenreiTotatsuKikanTo() {
        return txtNenreiTotatsuKikanTo;
    }

    @JsonProperty("txtNenreiTotatsuKikanTo")
    @Override
    public void setTxtNenreiTotatsuKikanTo(TextBoxFlexibleDate txtNenreiTotatsuKikanTo) {
        this.txtNenreiTotatsuKikanTo = txtNenreiTotatsuKikanTo;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        KensakuInput("KensakuInput"),
        ChushutsuInput("ChushutsuInput");

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

    @Override
    public DisplayMode getMode_DisplayMode() {
        return (DisplayMode) _CommonChildDivModeUtil.getMode(this.modes, DisplayMode.class);
    }

    @Override
    public void setMode_DisplayMode(DisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, DisplayMode.class, value);
    }

//--------------- この行より下にコードを追加してください -------------------
//     @JsonIgnore
//    public NenReiTotatsuSrchConInfoHandler getHandler() {
//        return new NenReiTotatsuSrchConInfoHandler(this);
//    }
}
