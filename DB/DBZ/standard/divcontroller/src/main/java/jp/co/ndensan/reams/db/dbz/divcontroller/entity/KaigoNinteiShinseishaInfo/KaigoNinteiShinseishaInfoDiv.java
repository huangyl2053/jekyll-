package jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiShinseishaInfo;

/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiShinseishaInfo.IKaigoNinteiShinseishaInfoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KaigoNinteiShinseishaInfo のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoNinteiShinseishaInfoDiv extends Panel implements IKaigoNinteiShinseishaInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    private KaigoNinteiAtenaInfoDiv ccdKaigoNinteiAtenaInfo;
    @JsonProperty("ccdKaigoShikakuKihon")
    private IKaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("hdnKaigoDonyuDantaiKeitai")
    private RString hdnKaigoDonyuDantaiKeitai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    public IKaigoNinteiAtenaInfoDiv getCcdKaigoNinteiAtenaInfo() {
        return ccdKaigoNinteiAtenaInfo;
    }

    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    @JsonProperty("hdnKaigoDonyuDantaiKeitai")
    public RString getHdnKaigoDonyuDantaiKeitai() {
        return hdnKaigoDonyuDantaiKeitai;
    }

    @JsonProperty("hdnKaigoDonyuDantaiKeitai")
    public void setHdnKaigoDonyuDantaiKeitai(RString hdnKaigoDonyuDantaiKeitai) {
        this.hdnKaigoDonyuDantaiKeitai = hdnKaigoDonyuDantaiKeitai;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum AtenaMode implements ICommonChildDivMode {

        AtenaMode("AtenaMode"),
        AtenNoneMode("AtenNoneMode");

        private final String name;

        private AtenaMode(final String name) {
            this.name = name;
        }

        public static AtenaMode getEnum(String str) {
            AtenaMode[] enumArray = AtenaMode.values();

            for (AtenaMode enumStr : enumArray) {
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

    public AtenaMode getMode_AtenaMode() {
        return (AtenaMode) _CommonChildDivModeUtil.getMode(this.modes, AtenaMode.class);
    }

    public void setMode_AtenaMode(AtenaMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, AtenaMode.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
}
