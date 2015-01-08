/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshafinder;

import jp.co.ndensan.reams.db.dbz.business.config.GaitoshaKensakuConfig;
import jp.co.ndensan.reams.ur.urz.business.IRecentUsed;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ScopeCode;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ur.urz.realservice.ISaikinShorishaManager;
import jp.co.ndensan.reams.ur.urz.realservice.RecentUsedManagerFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 被保険者検索Divの操作を行うクラスです。
 *
 * @author N8156 宮本 康
 */
public class HihokenshaFinderHandler {

    private final HihokenshaFinderDiv div;
    private final ISaikinShorishaManager saikinShorishaManager;

    private static final RString みなし２号含む = new RString("含む");

    /**
     * コンストラクタです。
     *
     * @param div 介護資格基本情報Div
     */
    public HihokenshaFinderHandler(HihokenshaFinderDiv div) {
        this.div = div;
        this.saikinShorishaManager = RecentUsedManagerFactory.createInstance();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param div 介護資格基本情報Div
     * @param saikinShorishaManager 最近処理者Manager
     */
    HihokenshaFinderHandler(HihokenshaFinderDiv div, ISaikinShorishaManager saikinShorishaManager) {
        this.div = div;
        this.saikinShorishaManager = saikinShorishaManager;
    }

    /**
     * 保険者を返します。
     *
     * @return 保険者
     */
    RString get保険者() {
        DropDownList item = div.getKaigoFinder().getDdlHokensha();
        return (item != null && item.isVisible()) ? item.getSelectedKey() : RString.EMPTY;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    RString get被保険者番号() {
        TextBoxCode item = div.getKaigoFinder().getTxtHihokenshaNo();
        return (item != null && !item.getValue().trim().isEmpty()) ? item.getValue() : RString.EMPTY;
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    RString get通知書番号() {
        TextBoxCode item = div.getKaigoFinder().getTxtTuchishoNo();
        return (item != null && !item.getValue().trim().isEmpty()) ? item.getValue() : RString.EMPTY;
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    FlexibleYear get賦課年度() {
        DropDownList item = div.getKaigoFinder().getDdlFukaNendo();
        return (item != null && item.getSelectedKey() != null && !item.getSelectedKey().equals(FlexibleYear.MAX.toDateString()))
                ? new FlexibleYear(item.getSelectedKey().toString()) : FlexibleYear.MAX;
    }

    /**
     * 被保険者台帳登録者かどうかを返します。
     *
     * @return true:登録者、false:登録者ではない
     */
    boolean is被保険者台帳登録者() {
        return !div.getKaigoFinder().getKaigoFinderDetail().getChkHihokenshaDaicho().getSelectedValues().isEmpty();
    }

    /**
     * 受給者台帳登録者かどうかを返します。
     *
     * @return true:登録者、false:登録者ではない
     */
    boolean is受給者台帳登録者() {
        return !div.getKaigoFinder().getKaigoFinderDetail().getChkJukyushaDaicho().getSelectedValues().isEmpty();
    }

    /**
     * 住所地特例者かどうかを返します。
     *
     * @return true:特例者、false:特例者ではない
     */
    boolean is住所地特例者() {
        return !div.getKaigoFinder().getKaigoFinderDetail().getChkJushochiTokureisha().getSelectedValues().isEmpty();
    }

    /**
     * みなし２号を含むかどうかを返します。
     *
     * @return true:含む、false:含まない
     */
    boolean isみなし２号含む() {
        return div.getKaigoFinder().getKaigoFinderDetail().getRadMinashiNigo().getSelectedValue().equals(みなし２号含む);
    }

    /**
     * 最大表示件数を返します。
     *
     * @return 最大表示件数
     */
    int get最大表示件数() {
        TextBoxNum item = div.getButtonsForHihokenshaFinder().getTxtMaxNumber();
        return (item != null && item.getValue() != null) ? item.getValue().intValue() : new GaitoshaKensakuConfig().get最大取得件数();
    }

    /**
     * 宛名条件を返します。
     *
     * @return 宛名条件
     */
    IShikibetsuTaishoSearchKey get宛名条件() {
        div.getCcdAtenaFinder().load(ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先));
        return div.getCcdAtenaFinder().makeShikibetsuTaishoSearchKey(div.getCcdAtenaFinder());
    }

    /**
     * 最近処理者を読み込みます。
     */
    void load最近処理者() {
        div.getCcdSaikinShorisha().getWrappedSaikinShorishaRireki().setInitialLoad(ScopeCode.識別対象);
    }

    /**
     * 最近処理者を保存します。
     *
     * @param 識別コード 識別コード
     * @param 名称 名称
     */
    void save最近処理者(ShikibetsuCode 識別コード, AtenaMeisho 名称) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        saikinShorishaManager.save(controlData, ScopeCode.識別対象, 識別コード.value(), 名称.value());
    }

    /**
     * 選択中の最近処理者を返します。
     *
     * @return 最近処理者
     */
    RString get最近処理者() {
        IRecentUsed 最近処理者 = div.getCcdSaikinShorisha().getWrappedSaikinShorishaRireki().getRecentUsed();
        return 最近処理者 != null ? 最近処理者.get最近処理対象コード() : RString.EMPTY;
    }
}
