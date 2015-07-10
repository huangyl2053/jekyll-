package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigosaikinshorisharireki;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigosaikinshorisharireki.IKaigoSaikinShorishaRirekiDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.ISaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.SaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KaigoSaikinShorishaRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoSaikinShorishaRirekiDiv extends Panel implements IKaigoSaikinShorishaRirekiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("wrappedSaikinShorishaRireki")
    private SaikinShorishaRirekiDiv wrappedSaikinShorishaRireki;
    @JsonProperty("btnKaigoSaikinShorishaHyoji")
    private Button btnKaigoSaikinShorishaHyoji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("wrappedSaikinShorishaRireki")
    public ISaikinShorishaRirekiDiv getWrappedSaikinShorishaRireki() {
        return wrappedSaikinShorishaRireki;
    }

    @JsonProperty("btnKaigoSaikinShorishaHyoji")
    public Button getBtnKaigoSaikinShorishaHyoji() {
        return btnKaigoSaikinShorishaHyoji;
    }

    @JsonProperty("btnKaigoSaikinShorishaHyoji")
    public void setBtnKaigoSaikinShorishaHyoji(Button btnKaigoSaikinShorishaHyoji) {
        this.btnKaigoSaikinShorishaHyoji=btnKaigoSaikinShorishaHyoji;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DummyMode1 implements ICommonChildDivMode {

        val1("val1");

        private final String name;

        private DummyMode1(final String name) {
            this.name = name;
        }

        public static DummyMode1 getEnum(String str) {
            DummyMode1[] enumArray = DummyMode1.values();

            for (DummyMode1 enumStr : enumArray) {
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

    public DummyMode1 getMode_DummyMode1() {
        return (DummyMode1) _CommonChildDivModeUtil.getMode( this.modes, DummyMode1.class );
    }

    public void setMode_DummyMode1( DummyMode1 value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DummyMode1.class , value );
    }

    //--------------- この行より下にコードを追加してください -------------------

}
