/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.config.GaitoshaKensakuConfig;
import static jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysHizuke.日付関連_当初年度;
import static jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysHizuke.日付関連_所得年度;
import static jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysHizuke.日付関連_調定年度;
import static jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysHizuke.日付関連_遡及年度;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenuGroup;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.helper.FukaTaishoshaSearchValidationHelper;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCode;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCodeType;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.SaikinShorishaRireki.RecentUsedDdlValue;
import jp.co.ndensan.reams.ur.urz.service.core.saikinshoririreki.ISaikinShorishaManager;
import jp.co.ndensan.reams.ur.urz.service.core.saikinshoririreki.RecentUsedManagerFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 被保険者検索Divの操作を行うクラスです。
 *
 * @author N8156 宮本 康
 */
//TODO n3317 塚田萌　ビルドを通すための暫定対応。見直しのタイミングで対応してください。
public class HihokenshaFinderHandler {

    private final HihokenshaFinderDiv div;
    private final ISaikinShorishaManager saikinShorishaManager;
    private final int 最大表示件数 = new GaitoshaKensakuConfig().get最大取得件数();

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
     * 最大表示件数を返します。
     *
     * @return 最大表示件数
     */
    int get最大表示件数() {
        TextBoxNum item = div.getButtonsForHihokenshaFinder().getTxtMaxNumber();
        return (item != null && item.getValue() != null) ? item.getValue().intValue() : 最大表示件数;
    }

    /**
     * 宛名条件を返します。
     *
     * @return 宛名条件
     */
    IShikibetsuTaishoSearchKey get宛名条件() {
        // div.getCcdAtenaFinder().load(ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先));
        return div.getCcdAtenaFinder().makeShikibetsuTaishoSearchKey();
    }

    /**
     * 最近処理者を読み込みます。
     */
    void load最近処理者() {
        div.getCcdSaikinShorisha().setInitialLoad(new ScopeCode(ScopeCodeType.識別対象.getCode()));
    }

    /**
     * 最近処理者を保存します。
     *
     * @param 識別コード 識別コード
     * @param 名称 名称
     */
    void save最近処理者(ShikibetsuCode 識別コード, AtenaMeisho 名称) {
        saikinShorishaManager.save(new ScopeCode(ScopeCodeType.識別対象.getCode()), 識別コード.value(), 名称.value());
    }

    /**
     * 選択中の最近処理者を返します。
     *
     * @return 最近処理者
     */
    RString get最近処理者() {
//        RecentUsedDdlValue 最近処理者 = div.getCcdSaikinShorisha().getWrappedSaikinShorishaRireki().getRecentUsed();
        RecentUsedDdlValue 最近処理者 = div.getCcdSaikinShorisha().getRecentUsed();
        return 最近処理者 != null ? 最近処理者.get最近処理対象コード() : RString.EMPTY;
    }

    /**
     * 賦課年度ドロップダウンの値を設定します。
     */
    public void set賦課年度ドロップダウン() {
        List<KeyValueDataSource> ddlSourceList = new ArrayList<>();
        SubGyomuCode subGyomuCode = SubGyomuCode.DBB介護賦課;
        int 調定年度 = Integer.parseInt(BusinessConfig.getConfigInfo(日付関連_調定年度, subGyomuCode).getConfigValue().toString());
        int 所得年度 = Integer.parseInt(BusinessConfig.getConfigInfo(日付関連_所得年度, subGyomuCode).getConfigValue().toString());
        int 遡及年度 = Integer.parseInt(BusinessConfig.getConfigInfo(日付関連_遡及年度, subGyomuCode).getConfigValue().toString());
        int 当初年度 = Integer.parseInt(BusinessConfig.getConfigInfo(日付関連_当初年度, subGyomuCode).getConfigValue().toString());
        FukaSearchMenu menu = FukaSearchMenu.toValue(ResponseHolder.getUIContainerId());

        int 開始年度 = 0;
        int 終了年度 = 0;
        int firstIndex = 0;
        if (menu.is(FukaSearchMenuGroup.更正計算系)) {
            開始年度 = 調定年度;
            終了年度 = 遡及年度;
            firstIndex = 0;
        } else if (menu.is(FukaSearchMenuGroup.所得照会系)) {
            開始年度 = 所得年度;
            終了年度 = 当初年度;
            firstIndex = 0;
        } else if (menu.is(FukaSearchMenuGroup.照会系)) {
            開始年度 = 調定年度;
            終了年度 = 当初年度;
            firstIndex = 1;
            ddlSourceList.add(new KeyValueDataSource(new RString("9999"), new RString("全年度")));
        }
        for (int i = 開始年度; i >= 終了年度; i--) {
            KeyValueDataSource source = new KeyValueDataSource(new RString(String.valueOf(i)), new RString("平").concat(new RString(String.valueOf(i - 1988))));
            ddlSourceList.add(source);
        }
        div.getKaigoFinder().getDdlFukaNendo().setDataSource(ddlSourceList);
        int size = ddlSourceList.size();
        div.getKaigoFinder().getDdlFukaNendo().setSelectedIndex(firstIndex <= size - 1 ? firstIndex : 0);
    }

    /**
     * 最大表示件数の値を設定します。
     */
    public void set最大表示件数() {
        div.getButtonsForHihokenshaFinder().getTxtMaxNumber().setValue(Decimal.valueOf(最大表示件数));
    }

    /**
     * 最大取得件数上限超過かどうかをチェックします。
     *
     * @param pairs ValidationMessageControlPairs
     */
    public void check最大表示件数(ValidationMessageControlPairs pairs) {
        TextBoxNum 最大表示件数入力値 = div.getButtonsForHihokenshaFinder().getTxtMaxNumber();
        pairs.add(FukaTaishoshaSearchValidationHelper.validate最大表示件数(最大表示件数, 最大表示件数入力値));
    }

    /**
     * 対象者検索（賦課系）の介護検索条件と宛名検索条件のクリアします。
     */
    public void onClick_BtnClear_Fuka() {
        // 介護検索条件のクリア
        div.getKaigoFinder().getTxtHihokenshaNo().clearValue();
        div.getKaigoFinder().getTxtTuchishoNo().clearValue();
        div.getKaigoFinder().getDdlFukaNendo().setSelectedKey(div.getKaigoFinder().getDdlFukaNendo().getDataSource().get(0).getKey());
        div.getKaigoFinder().getKaigoFinderDetail().getChkHihokenshaDaicho().setSelectedItems(Collections.EMPTY_LIST);
        // 宛名検索条件のクリア
        // TOOO jp.co.ndensan.reams.uz.uza.lang.SystemException: コントロール：
        // ccdSearchCondition_ccdAtenaFinder_ddlAtenaSearchKubunのdataSourceに指定されたselectedKey：0が存在しません。
        div.getCcdAtenaFinder().clear();
    }

    /**
     * 対象者検索（資格系）の介護検索条件と宛名検索条件のクリアします。
     */
    public void onClick_BtnClear_Shikaku() {
        // 介護検索条件のクリア
        div.getKaigoFinder().getTxtHihokenshaNo().clearValue();
        div.getKaigoFinder().getKaigoFinderDetail().getChkHihokenshaDaicho().setSelectedItems(Collections.EMPTY_LIST);
        div.getKaigoFinder().getKaigoFinderDetail().getChkJukyushaDaicho().setSelectedItems(Collections.EMPTY_LIST);
        div.getKaigoFinder().getKaigoFinderDetail().getChkJushochiTokureisha().setSelectedItems(Collections.EMPTY_LIST);
        // 宛名検索条件のクリア
        // TOOO jp.co.ndensan.reams.uz.uza.lang.SystemException: コントロール：
        // ccdSearchCondition_ccdAtenaFinder_ddlAtenaSearchKubunのdataSourceに指定されたselectedKey：0が存在しません。
        div.getCcdAtenaFinder().clear();
    }

}
