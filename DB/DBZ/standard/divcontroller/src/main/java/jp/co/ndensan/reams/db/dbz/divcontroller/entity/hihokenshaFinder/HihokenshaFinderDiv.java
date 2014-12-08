package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaFinderDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IAtenaFinderDiv;
import jp.co.ndensan.reams.ur.urz.business.IRecentUsed;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ScopeCode;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ur.urz.realservice.ISaikinShorishaManager;
import jp.co.ndensan.reams.ur.urz.realservice.RecentUsedManagerFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;

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
    private static final RString みなし２号含む = new RString("含む");
    private static final int 最大表示件数 = 100;

    @Override
    public RString get保険者() {
        DropDownList item = KaigoFinder.getDdlHokensha();
        return (item != null && item.isVisible()) ? item.getSelectedKey() : null;
    }

    @Override
    public RString get被保険者番号() {
        TextBoxCode item = KaigoFinder.getTxtHihokenshaNo();
        return (item != null && !item.getValue().trim().isEmpty()) ? item.getValue() : null;
    }

    @Override
    public RString get通知書番号() {
        TextBoxCode item = KaigoFinder.getTxtTuchishoNo();
        return (item != null && !item.getValue().trim().isEmpty()) ? item.getValue() : null;
    }

    @Override
    public FlexibleYear get賦課年度() {
        DropDownList item = KaigoFinder.getDdlFukaNendo();
        return (item != null && item.getSelectedKey() != null && !item.getSelectedKey().equals(FlexibleYear.MAX.toDateString()))
                ? new FlexibleYear(item.getSelectedKey().toString()) : FlexibleYear.MAX;
    }

    @Override
    public boolean is被保険者台帳登録者() {
        return !KaigoFinder.getKaigoFinderDetail().getChkHihokenshaDaicho().getSelectedValues().isEmpty();
    }

    @Override
    public boolean is受給者台帳登録者() {
        return !KaigoFinder.getKaigoFinderDetail().getChkJukyushaDaicho().getSelectedValues().isEmpty();
    }

    @Override
    public boolean is住所地特例者() {
        return !KaigoFinder.getKaigoFinderDetail().getChkJushochiTokureisha().getSelectedValues().isEmpty();
    }

    @Override
    public boolean isみなし２号含む() {
        return KaigoFinder.getKaigoFinderDetail().getRadMinashiNigo().getSelectedValue().equals(みなし２号含む);
    }

    @Override
    public int get最大表示件数() {
        TextBoxNum item = ButtonsForHihokenshaFinder.getTxtMaxNumber();
        return (item != null && item.getValue() != null) ? item.getValue().intValue() : 最大表示件数;
    }

    @Override
    public IShikibetsuTaishoSearchKey get宛名条件() {
        ccdAtenaFinder.load(ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先));
        return ccdAtenaFinder.makeShikibetsuTaishoSearchKey(ccdAtenaFinder);
    }

    @Override
    public void load最近処理者() {
        ccdSaikinShorisha.getWrappedSaikinShorishaRireki().setInitialLoad(ScopeCode.識別対象);
    }

    @Override
    public void save最近処理者(RString 識別コード, RString 名称) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        ISaikinShorishaManager manager = RecentUsedManagerFactory.createInstance();
        manager.save(controlData, ScopeCode.識別対象, 識別コード, 名称);
    }

    @Override
    public RString get最近処理者() {
        IRecentUsed 最近処理者 = ccdSaikinShorisha.getWrappedSaikinShorishaRireki().getRecentUsed();
        return 最近処理者 != null ? 最近処理者.get最近処理対象コード() : null;
    }
}
