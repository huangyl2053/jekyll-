package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.AtenaFinderDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.IAtenaFinderDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.SaikinShorishaRireki.ISaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.SaikinShorishaRireki.SaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigosaikinshorisharireki.IKaigoSaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigosaikinshorisharireki.KaigoSaikinShorishaRirekiDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * HihokenshaFinder のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaFinderDiv extends Panel implements IHihokenshaFinderDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    private SaikinShorishaRirekiDiv ccdSaikinShorisha;
    @JsonProperty("btnHihokenshaFinderHyoji")
    private Button btnHihokenshaFinderHyoji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoFinder
     * @return KaigoFinder
     */
    @Override
    @JsonProperty("KaigoFinder")
    public KaigoFinderDiv getKaigoFinder() {
        return KaigoFinder;
    }

    /*
     * setKaigoFinder
     * @param KaigoFinder KaigoFinder
     */
    @JsonProperty("KaigoFinder")
    public void setKaigoFinder(KaigoFinderDiv KaigoFinder) {
        this.KaigoFinder = KaigoFinder;
    }

    /*
     * getccdAtenaFinder
     * @return ccdAtenaFinder
     */
    @Override
    @JsonProperty("ccdAtenaFinder")
    public IAtenaFinderDiv getCcdAtenaFinder() {
        return ccdAtenaFinder;
    }

    /*
     * getButtonsForHihokenshaFinder
     * @return ButtonsForHihokenshaFinder
     */
    @Override
    @JsonProperty("ButtonsForHihokenshaFinder")
    public ButtonsForHihokenshaFinderDiv getButtonsForHihokenshaFinder() {
        return ButtonsForHihokenshaFinder;
    }

    /*
     * setButtonsForHihokenshaFinder
     * @param ButtonsForHihokenshaFinder ButtonsForHihokenshaFinder
     */
    @JsonProperty("ButtonsForHihokenshaFinder")
    public void setButtonsForHihokenshaFinder(ButtonsForHihokenshaFinderDiv ButtonsForHihokenshaFinder) {
        this.ButtonsForHihokenshaFinder = ButtonsForHihokenshaFinder;
    }

    /*
     * getccdSaikinShorisha
     * @return ccdSaikinShorisha
     */
    @JsonProperty("ccdSaikinShorisha")
    public ISaikinShorishaRirekiDiv getCcdSaikinShorisha() {
        return ccdSaikinShorisha;
    }

    /*
     * getbtnHihokenshaFinderHyoji
     * @return btnHihokenshaFinderHyoji
     */
    @JsonProperty("btnHihokenshaFinderHyoji")
    public Button getBtnHihokenshaFinderHyoji() {
        return btnHihokenshaFinderHyoji;
    }

    /*
     * setbtnHihokenshaFinderHyoji
     * @param btnHihokenshaFinderHyoji btnHihokenshaFinderHyoji
     */
    @JsonProperty("btnHihokenshaFinderHyoji")
    public void setBtnHihokenshaFinderHyoji(Button btnHihokenshaFinderHyoji) {
        this.btnHihokenshaFinderHyoji = btnHihokenshaFinderHyoji;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum Hokensha implements ICommonChildDivMode {

        HyojiSuru("HyojiSuru"),
        HyojiShinai("HyojiShinai");

        private final String name;

        private Hokensha(final String name) {
            this.name = name;
        }

        public static Hokensha getEnum(String str) {
            Hokensha[] enumArray = Hokensha.values();

            for (Hokensha enumStr : enumArray) {
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

    public Hokensha getMode_Hokensha() {
        return (Hokensha) _CommonChildDivModeUtil.getMode(this.modes, Hokensha.class);
    }

    public void setMode_Hokensha(Hokensha value) {
        _CommonChildDivModeUtil.setMode(this.modes, Hokensha.class, value);
    }

    public static enum HyojiMode implements ICommonChildDivMode {

        Shikakukei("Shikakukei"),
        Fukakei("Fukakei");

        private final String name;

        private HyojiMode(final String name) {
            this.name = name;
        }

        public static HyojiMode getEnum(String str) {
            HyojiMode[] enumArray = HyojiMode.values();

            for (HyojiMode enumStr : enumArray) {
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

    public HyojiMode getMode_HyojiMode() {
        return (HyojiMode) _CommonChildDivModeUtil.getMode(this.modes, HyojiMode.class);
    }

    public void setMode_HyojiMode(HyojiMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, HyojiMode.class, value);
    }

    // </editor-fold>
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

//    @Override
//    public boolean isみなし２号含む() {
//        return getHandler().isみなし２号含む();
//    }
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

    @Override
    public void set賦課年度ドロップダウン() {
        getHandler().set賦課年度ドロップダウン();
    }

    @JsonIgnore
    private HihokenshaFinderHandler getHandler() {
        return new HihokenshaFinderHandler(this);
    }

}
