/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.config.GaitoshaKensakuConfig;
import jp.co.ndensan.reams.db.dbz.business.core.taishoshasearch.DbV7902FukaSearchBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.taishoshasearch.FukaTaishoshaRelateBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenuGroup;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.helper.FukaTaishoshaSearchValidationHelper;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder.HihokenshaFinderDiv;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0300001.DBZ0300001StateName.検索条件;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0300001.DBZ0300001StateName.該当者一覧;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0300001.DBZ0300001TransitionEventName.対象者特定;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0300001.FukaTaishoshaSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0300001.dgFukaGaitoshaList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaFinder;
import jp.co.ndensan.reams.db.dbz.service.core.search.FukaSearchItem;
import jp.co.ndensan.reams.db.dbz.service.core.util.SearchResult;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import static jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory.createKojin;
import static jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory.createShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.FlexibleYearOperator;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.IIgnoredValueJudge;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.INewSearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.SearchConditionFactory;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.StringOperator;

/**
 * 対象者検索のコントローラークラスです。（賦課系）
 *
 * @author N8156 宮本 康
 */
public class FukaTaishoshaSearch {

    private static final ISearchCondition 条件無 = null;
    private static final int 最近処理者検索数 = 1;
    private static final int 最大取得件数 = new GaitoshaKensakuConfig().get最大取得件数();
    private static final RString フラグ_1 = new RString("1");
    private static final RString フラグ_2 = new RString("2");

    /**
     * 「初期化」時の処理です。
     *
     * @param div FukaTaishoshaSearchDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<FukaTaishoshaSearchDiv> onLoad(FukaTaishoshaSearchDiv div) {

        //AtenaFinderを初期化
        div.getSearchCondition().getCcdSearchCondition().getCcdAtenaFinder().initialize();
        IShikibetsuTaishoGyomuHanteiKey gyomuHanteiKey = ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        div.getSearchCondition().getCcdSearchCondition().getCcdAtenaFinder().load(gyomuHanteiKey);

        // TODO 保険者ドロップダウンの表示制御
        // div.getSearchCondition().getCcdSearchCondition().set保険者ドロップダウン();
        // 賦課年度ドロップダウンの値を設定
        div.getSearchCondition().getCcdSearchCondition().set賦課年度ドロップダウン();
        // 最大表示件数の取得
//        div.getSearchCondition().getCcdSearchCondition().set最大表示件数();
        // 最近処理者履歴 のロード
        div.getSearchCondition().getCcdSearchCondition().load最近処理者();
        // 最大取得件数の取得
        div.getSearchCondition().getCcdSearchCondition().getButtonsForHihokenshaFinder().getTxtMaxNumber().setValue(new Decimal(最大取得件数));

        div.getSearchCondition().setIsOpen(true);
        div.getGaitoshaList().setIsOpen(false);

        return ResponseDatas.newResponseData(div);
    }

    /**
     * 「最大表示件数テキストボックス」のバリデーション実施時の処理です。
     *
     * @param div FukaTaishoshaSearchDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<FukaTaishoshaSearchDiv> onBlur_txtMaxNumber(FukaTaishoshaSearchDiv div) {

        // 最大取得件数上限超過チェック
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
//        div.getSearchCondition().getCcdSearchCondition().check最大表示件数(pairs);
        ResponseData<FukaTaishoshaSearchDiv> responseData = ResponseData.of(div).addValidationMessages(pairs).respond();
//        responseData.setValidateMessageIgnoreWarningRequest(false);
        return responseData;
    }

    /**
     * 「条件をクリアする」ボタンクリック時に呼び出される処理です。
     *
     * @param div FukaTaishoshaSearchDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<FukaTaishoshaSearchDiv> onClick_btnClear(FukaTaishoshaSearchDiv div) {

        // 介護検索条件と宛名検索条件のクリア
//        div.getSearchCondition().getCcdSearchCondition().onClick_BtnClear_Fuka();
        div.getSearchCondition().getCcdSearchCondition().getCcdAtenaFinder().clear();
        div.getSearchCondition().getCcdSearchCondition().getKaigoFinder().clear();
        div.getSearchCondition().getCcdSearchCondition().getButtonsForHihokenshaFinder().getTxtMaxNumber().setValue(new Decimal(最大取得件数));
        return ResponseDatas.newResponseData(div);
    }

    /**
     * 「検索する」ボタンクリック時に呼び出される処理です。
     *
     * @param div FukaTaishoshaSearchDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<FukaTaishoshaSearchDiv> onClick_btnSearch(FukaTaishoshaSearchDiv div) {

        ResponseData<FukaTaishoshaSearchDiv> responseData = this.onBlur_txtMaxNumber(div);
        if (!responseData.getValidateErrorMessage().isEmpty()) {
            return responseData;
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();

        // 検索条件未指定チェック
        HihokenshaFinderDiv 検索条件Div = div.getSearchCondition().getCcdSearchCondition();
        boolean 検索条件Flag = 検索条件Div.getKaigoFinder().getTxtHihokenshaNo().getValue().isEmpty()
                && 検索条件Div.getKaigoFinder().getTxtTuchishoNo().getValue().isEmpty()
                && 検索条件Div.getKaigoFinder().getDdlFukaNendo().getSelectedKey().isEmpty()
                && 検索条件Div.getKaigoFinder().getKaigoFinderDetail().getChkHihokenshaDaicho().getSelectedItems().isEmpty(); //&& !検索条件Div.getCcdAtenaFinder().hasChanged()

        boolean 宛名条件修正Flag = 検索条件Div.getCcdAtenaFinder().hasChanged();
        if (検索条件Flag && !宛名条件修正Flag) {
            pairs.add(FukaTaishoshaSearchValidationHelper.validate検索条件(検索条件Flag, div.getSearchCondition()));
            responseData = ResponseData.of(div).addValidationMessages(pairs).respond();
//            responseData.setValidateMessageIgnoreWarningRequest(false);
            return responseData;
        }

//        boolean 介護検索条件のみ = 検索条件Flag && !宛名条件修正Flag;
        // 該当者を検索する
        SearchResult<FukaTaishoshaRelateBusiness> result = get対象者(div.getSearchCondition().getCcdSearchCondition());

        // 検索結果の絞り込み
        // TODO 【資格、賦課共通】部分
        boolean is全年度 = div.getSearchCondition().getCcdSearchCondition().get賦課年度().isMaxOrMin();
        IItemList<FukaTaishoshaRelateBusiness> list = ItemList.empty();
        if (!result.records().isEmpty()) {
            list = editList(result, is全年度);
        }
        SearchResult<FukaTaishoshaRelateBusiness> newResult = SearchResult.of(list);

        // 検索結果の件数判定
        int 検索結果件数 = newResult.totalCount();
        // 検索結果が０件の場合
        if (検索結果件数 == 0) {
            // 該当有無のメッセージ表示
            pairs.add(FukaTaishoshaSearchValidationHelper.validate検索結果件数(true, div.getSearchCondition()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
            // 検索結果が1件の場合
        } else if (検索結果件数 == 1) {
            FukaTaishoshaRelateBusiness 対象者 = newResult.records().toList().get(0);
            // ViewState_個人確定キーの保存
            put対象者Key(create対象者Key(対象者));
            // 最近処理者履歴の保存
            save最近処理者(div, 対象者);
            div.getGaitoshaList().getDgFukaGaitoshaList().setDataSource(toRowList(newResult));
            set賦課年度(div);
            ViewStateHolder.put(ViewStateKeys.各種通知書作成フラグ, フラグ_1);
            ViewStateHolder.put(ViewStateKeys.is経由該当者一覧画面, Boolean.FALSE);
            // 次画面遷移
            return ResponseData.of(div).forwardWithEventName(対象者特定).respond();
            // 検索結果が２件以上の場合
        } else {
            // 最大表示件数チェック
            int 最大表示件数 = div.getSearchCondition().getCcdSearchCondition().get最大表示件数();
            DataGridSetting dataGridSetting = div.getGaitoshaList().getDgFukaGaitoshaList().getGridSetting();
            if (検索結果件数 > 最大表示件数) {
                dataGridSetting.setLimitRowCount(最大表示件数);
                dataGridSetting.setSelectedRowCount(検索結果件数);
            } else {
                dataGridSetting.setLimitRowCount(最大取得件数);
                dataGridSetting.setSelectedRowCount(最大取得件数);
            }
            // 検索結果の表示
            set賦課年度(div);
            div.getGaitoshaList().getDgFukaGaitoshaList().setDataSource(toRowList(newResult));
            div.getSearchCondition().getCcdSearchCondition().getButtonsForHihokenshaFinder()
                    .getTxtMaxNumber().setValue(new Decimal(最大表示件数));
            ViewStateHolder.put(ViewStateKeys.is経由該当者一覧画面, Boolean.TRUE);
            // 画面状態遷移
            return ResponseData.of(div).setState(該当者一覧);
        }
    }

    private IItemList<FukaTaishoshaRelateBusiness> editList(
            SearchResult<FukaTaishoshaRelateBusiness> result,
            boolean is全年度) {
        IItemList<FukaTaishoshaRelateBusiness> list = ItemList.empty();
        if (is全年度) {
            RString 被保険者番号 = RString.EMPTY;
            for (FukaTaishoshaRelateBusiness entity : result.records().toList()) {
                RString 被保険者番号_絞り込み前 = RString.EMPTY;
                if (entity.get賦課検索エンティティ().getHihokenshaNo() != null) {
                    被保険者番号_絞り込み前 = entity.get賦課検索エンティティ().getHihokenshaNo().value();
                }
                if (!被保険者番号.equals(被保険者番号_絞り込み前)) {
                    list = list.added(entity);
                    被保険者番号 = 被保険者番号_絞り込み前;
                }
            }
        } else {
            RString 被保険者番号 = RString.EMPTY;
            RString 賦課年度 = RString.EMPTY;
            RString 通知書番号 = RString.EMPTY;
            for (FukaTaishoshaRelateBusiness entity : result.records().toList()) {
                RString 被保険者番号_絞り込み前 = RString.EMPTY;
                RString 賦課年度_絞り込み前 = RString.EMPTY;
                RString 通知書番号_絞り込み前 = RString.EMPTY;
                if (entity.get賦課検索エンティティ().getHihokenshaNo() != null) {
                    被保険者番号_絞り込み前 = entity.get賦課検索エンティティ().getHihokenshaNo().value();
                }
                if (entity.get賦課検索エンティティ().getFukaNendo() != null) {
                    賦課年度_絞り込み前 = entity.get賦課検索エンティティ().getFukaNendo().toDateString();
                }
                if (entity.get賦課検索エンティティ().getTsuchishoNo() != null) {
                    通知書番号_絞り込み前 = entity.get賦課検索エンティティ().getTsuchishoNo().value();
                }
                if (!(被保険者番号.equals(被保険者番号_絞り込み前) && 賦課年度.equals(賦課年度_絞り込み前)
                        && 通知書番号.equals(通知書番号_絞り込み前))) {
                    list = list.added(entity);
                    被保険者番号 = 被保険者番号_絞り込み前;
                    賦課年度 = 賦課年度_絞り込み前;
                    通知書番号 = 通知書番号_絞り込み前;
                }
            }
        }
        return list;
    }

    /**
     * 「表示する」ボタンクリック時に呼び出される処理です。
     *
     * @param div FukaTaishoshaSearchDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<FukaTaishoshaSearchDiv> onClick_btnSaikinShorishaHyoji(FukaTaishoshaSearchDiv div) {

        // 直前処理者の取得
        RString 最近処理者 = div.getSearchCondition().getCcdSearchCondition().get最近処理者();

        // 該当者を検索する
        ShikibetsuCode 識別コード = new ShikibetsuCode(最近処理者);
        IShikibetsuTaishoGyomuHanteiKey 業務判定キー
                = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先);
        IShikibetsuTaishoSearchKey 検索キー
                = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー, true).set識別コード(識別コード).build();
        TaishoshaFinder finder = new TaishoshaFinder();
        SearchResult<FukaTaishoshaRelateBusiness> 対象者 = finder.get賦課対象者(条件無, 条件無, 検索キー, 最近処理者検索数);
        if (!対象者.records().isEmpty()) {
            for (FukaTaishoshaRelateBusiness entity : 対象者.records()) {
                put対象者Key(create対象者Key(entity));
                save最近処理者(div, entity);
                FlexibleYear 賦課年度 = entity.get賦課検索エンティティ().getFukaNendo();
                if (賦課年度 != null) {
                    div.getGaitoshaList().getTxtFukanendo().setValue(new RDate(賦課年度.toString()));
                }
            }
            div.getGaitoshaList().getDgFukaGaitoshaList().setDataSource(toRowList(対象者));
        }
        ViewStateHolder.put(ViewStateKeys.各種通知書作成フラグ, フラグ_1);
        ViewStateHolder.put(ViewStateKeys.is経由該当者一覧画面, Boolean.FALSE);
        return ResponseData.of(div).forwardWithEventName(対象者特定).respond();
    }

    /**
     * 「該当者一覧」選択時に呼び出される処理です。<br/>
     * （行クリックイベント、行ダブルクリックイベント）
     *
     * @param div FukaTaishoshaSearchDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<FukaTaishoshaSearchDiv> onSelect_dgGaitoshaList(FukaTaishoshaSearchDiv div) {

        // 最近処理者履歴の保存
        save最近処理者(div);
        // ViewState_個人確定キーの保存
        put対象者Key(create対象者Key(div));
        ViewStateHolder.put(ViewStateKeys.各種通知書作成フラグ, フラグ_2);
        if (該当者一覧.getName().equals(ResponseHolder.getState())) {
            ViewStateHolder.put(ViewStateKeys.is経由該当者一覧画面, Boolean.TRUE);
        } else {
            ViewStateHolder.put(ViewStateKeys.is経由該当者一覧画面, Boolean.FALSE);
        }
        // 次画面遷移
        return ResponseData.of(div).forwardWithEventName(対象者特定).respond();
    }

    /**
     * 「再検索する」ボタンクリック時に呼び出される処理です。
     *
     * @param div FukaTaishoshaSearchDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<FukaTaishoshaSearchDiv> onClick_btnReSearch(FukaTaishoshaSearchDiv div) {

        // 一覧グリッドのクリア
        div.getGaitoshaList().getDgFukaGaitoshaList().setDataSource(Collections.EMPTY_LIST);
        div.getGaitoshaList().getDgFukaGaitoshaList().getGridSetting().setLimitRowCount(最大取得件数);
        div.getGaitoshaList().getDgFukaGaitoshaList().getGridSetting().setSelectedRowCount(最大取得件数);
        div.getGaitoshaList().getTxtFukanendo().clearValue();

        // 画面状態遷移
        return ResponseData.of(div).setState(検索条件);
    }

    private void set賦課年度(FukaTaishoshaSearchDiv div) {
        FlexibleYear 賦課年度 = div.getSearchCondition().getCcdSearchCondition().get賦課年度();
        boolean is全年度 = 賦課年度.isMaxOrMin();
        div.getGaitoshaList().getTxtFukanendo().setDisplayNone(is全年度);
        div.getGaitoshaList().getTxtFukanendo().setValue(new RDate(賦課年度.toString()));
    }

    private SearchResult<FukaTaishoshaRelateBusiness> get対象者(HihokenshaFinderDiv div) {
        TaishoshaFinder finder = new TaishoshaFinder();
        FukaSearchMenu menu = FukaSearchMenu.toValue(ResponseHolder.getMenuID());
//        FukaSearchMenu menu = FukaSearchMenu.toValue(new RString("DBBMN11001"));
        // FukaSearchMenu menu = FukaSearchMenu.toValue(UrControlDataFactory.createInstance().getMenuID());

//       ShikibetsuTaishoSearchKeyBuilder keyBuilder = new ShikibetsuTaishoSearchKeyBuilder(div.get宛名条件().getPSMSearchKey());
//        if (介護条件のみ) {
//            Optional<Fuka> modeloid = Optional.of(new FukaManager().get介護賦課(fukaKey.get調定年度(), 前年度, fukaKey.get通知書番号(), fukaKey.get履歴番号()));
//            keyBuilder.set識別コードリスト(null);
//        } else {
//
//        }
        return finder.get賦課対象者(get介護条件(div), get介護除外条件(div, menu), div.get宛名条件(), 最大取得件数);
    }

    private ISearchCondition get介護条件(HihokenshaFinderDiv div) {

        List<INewSearchCondition> 条件List = new ArrayList<>();

        if (div.get被保険者番号() != null && !div.get被保険者番号().isEmpty()) {
            INewSearchCondition 被保険者番号条件 = SearchConditionFactory.condition(
                    FukaSearchItem.賦課マスタ_被保険者番号, StringOperator.完全一致, div.get被保険者番号());
            条件List.add(被保険者番号条件);
        }
        if (div.get通知書番号() != null && !div.get通知書番号().isEmpty()) {
            INewSearchCondition 通知書番号条件 = SearchConditionFactory.condition(
                    FukaSearchItem.通知書番号, StringOperator.完全一致, div.get通知書番号());
            条件List.add(通知書番号条件);
        }
        if (!div.get賦課年度().isMaxOrMin()) {
            INewSearchCondition 賦課年度条件 = SearchConditionFactory.condition(
                    FukaSearchItem.賦課年度, FlexibleYearOperator.等しい, div.get賦課年度());
            条件List.add(賦課年度条件);
        }
        ISearchCondition 介護条件 = null;
        for (INewSearchCondition 条件 : 条件List) {
            介護条件 = (介護条件 == null) ? 条件 : 条件.and(介護条件);
        }

        return 介護条件;
    }

    private ISearchCondition get介護除外条件(HihokenshaFinderDiv div, FukaSearchMenu menu) {
        List<INewSearchCondition> 条件List = new ArrayList<>();

        IIgnoredValueJudge judge = new IIgnoredValueJudge() {
            @Override
            public boolean canIgnore(Object e) {
                return false;
            }
        };
        if (div.is被保険者台帳登録者()) {
            条件List.add(SearchConditionFactory.condition(
                    FukaSearchItem.被保険者台帳_被保険者番号, StringOperator.完全一致, RString.EMPTY, judge));
        }
        if (menu.is(FukaSearchMenuGroup.照会系)) {
            条件List.add(SearchConditionFactory.condition(
                    FukaSearchItem.通知書番号, StringOperator.完全一致, RString.EMPTY, judge));
        }
        if (menu.is(FukaSearchMenuGroup.更正計算系)) {
            条件List.add(SearchConditionFactory.condition(
                    FukaSearchItem.賦課マスタ_被保険者番号, StringOperator.完全一致, RString.EMPTY, judge));
        }
        ISearchCondition 介護除外条件 = null;
        for (INewSearchCondition 条件 : 条件List) {
            介護除外条件 = (介護除外条件 == null) ? 条件 : 条件.or(介護除外条件);
        }

        return 介護除外条件;
    }

    private FukaTaishoshaKey create対象者Key(FukaTaishoshaSearchDiv div) {
        dgFukaGaitoshaList_Row row = div.getGaitoshaList().getDgFukaGaitoshaList().getClickedItem();
        return new FukaTaishoshaKey(
                row.getTxtHihoNo() != null ? new HihokenshaNo(row.getTxtHihoNo()) : new HihokenshaNo(RString.EMPTY),
                row.getTxtShikbetsuCode() != null ? new ShikibetsuCode(row.getTxtShikbetsuCode()) : new ShikibetsuCode(RString.EMPTY),
                row.getTxtSetaiCode() != null ? new SetaiCode(row.getTxtSetaiCode()) : new SetaiCode(RString.EMPTY),
                row.getTxtShichosonCode() != null ? new LasdecCode(row.getTxtShichosonCode()) : new LasdecCode(RString.EMPTY),
                row.getTxtFukaNendo() != null ? new FlexibleYear(row.getTxtFukaNendo()) : new FlexibleYear(RString.EMPTY),
                row.getTxtTsuchiNo() != null ? new TsuchishoNo(row.getTxtTsuchiNo()) : new TsuchishoNo(RString.EMPTY),
                row.getTxtChoteiNendo() != null ? new FlexibleYear(row.getTxtChoteiNendo()) : new FlexibleYear(RString.EMPTY));

    }

    private FukaTaishoshaKey create対象者Key(FukaTaishoshaRelateBusiness entity) {
        DbV7902FukaSearchBusiness 賦課検索 = new DbV7902FukaSearchBusiness(entity.get賦課検索エンティティ());
//        UaFt200FindShikibetsuTaishoEntity 住基個人住登外 = entity.get住基個人住登外エンティティ();
        IKojin 個人 = createKojin(entity.get住基個人住登外エンティティ());
        IShikibetsuTaisho 識別対象 = createShikibetsuTaisho(entity.get住基個人住登外エンティティ());
        return new FukaTaishoshaKey(
                賦課検索.getHihokenshaNo() != null ? 賦課検索.getHihokenshaNo() : new HihokenshaNo(RString.EMPTY),
                賦課検索.getShikibetsuCode() != null ? 賦課検索.getShikibetsuCode() : new ShikibetsuCode(RString.EMPTY),
                個人.get世帯コード() != null ? 個人.get世帯コード() : new SetaiCode(RString.EMPTY),
                識別対象.get現全国地方公共団体コード() != null ? new LasdecCode(識別対象.get現全国地方公共団体コード().value()) : new LasdecCode(RString.EMPTY),
                賦課検索.getFukaNendo() != null ? 賦課検索.getFukaNendo() : new FlexibleYear(RString.EMPTY),
                賦課検索.getTsuchishoNo() != null ? 賦課検索.getTsuchishoNo() : new TsuchishoNo(RString.EMPTY),
                賦課検索.getChoteiNendo() != null ? 賦課検索.getChoteiNendo() : new FlexibleYear(RString.EMPTY)
        );
    }

    private void put対象者Key(FukaTaishoshaKey key) {
        ViewStateHolder.put(ViewStateKeys.賦課対象者, key);
    }

    private void save最近処理者(FukaTaishoshaSearchDiv div) {
        dgFukaGaitoshaList_Row row = div.getGaitoshaList().getDgFukaGaitoshaList().getClickedItem();
        div.getSearchCondition().getCcdSearchCondition().save最近処理者(
                new ShikibetsuCode(row.getTxtShikbetsuCode()), new AtenaMeisho(row.getTxtName()));
    }

    private void save最近処理者(FukaTaishoshaSearchDiv div, FukaTaishoshaRelateBusiness entity) {
        div.getSearchCondition().getCcdSearchCondition().save最近処理者(
                entity.get賦課検索エンティティ().getShikibetsuCode(),
                createShikibetsuTaisho(entity.get住基個人住登外エンティティ()).get名称().getName());
    }

    private List<dgFukaGaitoshaList_Row> toRowList(SearchResult<FukaTaishoshaRelateBusiness> result) {
        List<dgFukaGaitoshaList_Row> rowList = new ArrayList<>();
        for (FukaTaishoshaRelateBusiness 対象者 : result.records()) {
//            UaFt200FindShikibetsuTaishoEntity 住基個人住登外 = 対象者.get住基個人住登外エンティティ();
            DbV7902FukaSearchBusiness 賦課検索 = new DbV7902FukaSearchBusiness(対象者.get賦課検索エンティティ());
            IKojin 個人 = createKojin(対象者.get住基個人住登外エンティティ());
            IShikibetsuTaisho 識別対象 = createShikibetsuTaisho(対象者.get住基個人住登外エンティティ());
            rowList.add(new dgFukaGaitoshaList_Row(
                    賦課検索.getChoteiNendo() != null ? 賦課検索.getChoteiNendo().toDateString() : RString.EMPTY,
                    賦課検索.getFukaNendo() != null ? 賦課検索.getFukaNendo().toDateString() : RString.EMPTY,
                    識別対象.get現全国地方公共団体コード() != null ? 識別対象.get現全国地方公共団体コード().value() : RString.EMPTY,
                    賦課検索.getTsuchishoNo() != null ? 賦課検索.getTsuchishoNo().value() : RString.EMPTY,
                    賦課検索.getHihokenshaNo() != null ? 賦課検索.getHihokenshaNo().value() : RString.EMPTY,
                    識別対象.get名称() != null ? (識別対象.get名称().getName() != null ? 識別対象.get名称().getName().value() : RString.EMPTY) : RString.EMPTY,
                    個人.get生年月日() != null ? new RString(個人.get生年月日().toFlexibleDate().wareki().separator(Separator.PERIOD).toDateString().toString()) : RString.EMPTY,
                    個人.get年齢算出().get年齢(),
                    個人.get性別() != null ? (個人.get性別().getName() != null ? 個人.get性別().getName().getShortJapanese() : RString.EMPTY) : RString.EMPTY,
                    個人.get住民状態() != null ? 個人.get住民状態().住民状態略称() : RString.EMPTY,
                    識別対象.get住所() != null ? ((識別対象.get住所().get住所() != null && 識別対象.get住所().get番地() != null)
                    ? 識別対象.get住所().get住所().concat(識別対象.get住所().get番地().getBanchi().value())
                    : 識別対象.get住所().get住所()) : RString.EMPTY,
                    識別対象.get識別コード() != null ? 識別対象.get識別コード().value() : RString.EMPTY,
                    個人.get世帯コード() != null ? 個人.get世帯コード().value() : RString.EMPTY));
        }
        return rowList;
    }
}
