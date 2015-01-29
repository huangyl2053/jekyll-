package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshafinder;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigosaikinshorisharireki.IKaigoSaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigosaikinshorisharireki.KaigoSaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaFinderDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IAtenaFinderDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;

/**
 * HihokenshaFinder のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaFinderDiv extends Panel implements IHihokenshaFinderDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("KaigoFinder")
    private KaigoFinderDiv KaigoFinder;
    @JsonProperty("ccdAtenaFinder")
    private AtenaFinderDiv ccdAtenaFinder;
    @JsonProperty("ButtonsForHihokenshaFinder")
    private ButtonsForHihokenshaFinderDiv ButtonsForHihokenshaFinder;
    @JsonProperty("ccdSaikinShorisha")
    private KaigoSaikinShorishaRirekiDiv ccdSaikinShorisha;
    @JsonProperty("btnHihokenshaFinderHyoji")
    private Button btnHihokenshaFinderHyoji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KaigoFinder")
    public KaigoFinderDiv getKaigoFinder() {
        return KaigoFinder;
    }

    @JsonProperty("KaigoFinder")
    public void setKaigoFinder(KaigoFinderDiv KaigoFinder) {
        this.KaigoFinder = KaigoFinder;
    }

    @JsonProperty("ccdAtenaFinder")
    public IAtenaFinderDiv getCcdAtenaFinder() {
        return ccdAtenaFinder;
    }

    @JsonProperty("ButtonsForHihokenshaFinder")
    public ButtonsForHihokenshaFinderDiv getButtonsForHihokenshaFinder() {
        return ButtonsForHihokenshaFinder;
    }

    @JsonProperty("ButtonsForHihokenshaFinder")
    public void setButtonsForHihokenshaFinder(ButtonsForHihokenshaFinderDiv ButtonsForHihokenshaFinder) {
        this.ButtonsForHihokenshaFinder = ButtonsForHihokenshaFinder;
    }

    @JsonProperty("ccdSaikinShorisha")
    public IKaigoSaikinShorishaRirekiDiv getCcdSaikinShorisha() {
        return ccdSaikinShorisha;
    }

    @JsonProperty("btnHihokenshaFinderHyoji")
    public Button getBtnHihokenshaFinderHyoji() {
        return btnHihokenshaFinderHyoji;
    }

    @JsonProperty("btnHihokenshaFinderHyoji")
    public void setBtnHihokenshaFinderHyoji(Button btnHihokenshaFinderHyoji) {
        this.btnHihokenshaFinderHyoji = btnHihokenshaFinderHyoji;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum 保険者 implements ICommonChildDivMode {

        表示する("表示する"),
        表示しない("表示しない");

        private final String name;

        private 保険者(final String name) {
            this.name = name;
        }

        public static 保険者 getEnum(String str) {
            保険者[] enumArray = 保険者.values();

            for (保険者 enumStr : enumArray) {
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

    public 保険者 getMode_保険者() {
        return (保険者) _CommonChildDivModeUtil.getMode(this.modes, 保険者.class);
    }

    public void setMode_保険者(保険者 value) {
        _CommonChildDivModeUtil.setMode(this.modes, 保険者.class, value);
    }

    public static enum 表示モード implements ICommonChildDivMode {

        資格系("資格系"),
        賦課系("賦課系");

        private final String name;

        private 表示モード(final String name) {
            this.name = name;
        }

        public static 表示モード getEnum(String str) {
            表示モード[] enumArray = 表示モード.values();

            for (表示モード enumStr : enumArray) {
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

    public 表示モード getMode_表示モード() {
        return (表示モード) _CommonChildDivModeUtil.getMode(this.modes, 表示モード.class);
    }

    public void setMode_表示モード(表示モード value) {
        _CommonChildDivModeUtil.setMode(this.modes, 表示モード.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public RString get保険者() {
        return getHandler().get保険者();
    }

    @Override
    public RString get被保険者番号() {
        return getHandler().get被保険者番号();
    }

    @Override
    public RString get通知書番号() {
        return getHandler().get通知書番号();
    }

    @Override
    public FlexibleYear get賦課年度() {
        return getHandler().get賦課年度();
    }

    @Override
    public boolean is被保険者台帳登録者() {
        return getHandler().is被保険者台帳登録者();
    }

    @Override
    public boolean is受給者台帳登録者() {
        return getHandler().is受給者台帳登録者();
    }

    @Override
    public boolean is住所地特例者() {
        return getHandler().is住所地特例者();
    }

    @Override
    public boolean isみなし２号含む() {
        return getHandler().isみなし２号含む();
    }

    @Override
    public int get最大表示件数() {
        return getHandler().get最大表示件数();
    }

    @Override
    public IShikibetsuTaishoSearchKey get宛名条件() {
        return getHandler().get宛名条件();
    }

    @Override
    public void load最近処理者() {
        getHandler().load最近処理者();
    }

    @Override
    public void save最近処理者(ShikibetsuCode 識別コード, AtenaMeisho 名称) {
        getHandler().save最近処理者(識別コード, 名称);
    }

    @Override
    public RString get最近処理者() {
        return getHandler().get最近処理者();
    }

    @JsonIgnore
    public HihokenshaFinderHandler getHandler() {
        return new HihokenshaFinderHandler(this);
    }
}
