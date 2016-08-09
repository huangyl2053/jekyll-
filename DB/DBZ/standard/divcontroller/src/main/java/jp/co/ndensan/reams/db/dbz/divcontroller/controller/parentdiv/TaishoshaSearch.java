/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.config.GaitoshaKensakuConfig;
import jp.co.ndensan.reams.db.dbz.business.core.taishoshasearch.DbV7901ShikakuSearchBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.taishoshasearch.TaishoshaRelateBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.HihoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.jushochitokureisha.JushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.helper.TaishoshaSearchValidationHelper;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder.IHihokenshaFinderDiv;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0200001.DBZ0200001StateName.検索条件;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0200001.DBZ0200001StateName.該当者一覧;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0200001.TaishoshaSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0200001.dgGaitoshaList_Row;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0300001.DBZ0300001TransitionEventName.対象者特定;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
//import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7901ShikakuSearchEntity;
//import jp.co.ndensan.reams.db.dbz.entity.db.relate.TaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaFinder;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.search.ShikakuSearchItem;
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
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
//import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.FlexibleDateOperator;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.IIgnoredValueJudge;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.INewSearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.SearchConditionFactory;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.StringOperator;

/**
 * 対象者検索のコントローラークラスです。（資格系）
 *
 * @author N8156 宮本 康
 */
public class TaishoshaSearch {

    private static final ISearchCondition 条件無 = null;
    private static final int 最近処理者検索数 = 1;
    private static final int 最大取得件数 = new GaitoshaKensakuConfig().get最大取得件数();

    /**
     * 「初期化」時の処理です。
     *
     * @param div TaishoshaSearchDiv
     * @return ResponseData<TaishoshaSearchDiv>
     */
    public ResponseData<TaishoshaSearchDiv> onLoad(TaishoshaSearchDiv div) {

        //AtenaFinderを初期化
        IShikibetsuTaishoGyomuHanteiKey gyomuHanteiKey = ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        div.getSearchCondition().getCcdSearchCondition().getCcdAtenaFinder().load(gyomuHanteiKey);

        // TODO 保険者ドロップダウンの表示制御
        // div.getSearchCondition().getCcdSearchCondition().set保険者ドロップダウン();
        // 最大表示件数の取得
        div.getSearchCondition().getCcdSearchCondition().getButtonsForHihokenshaFinder().getTxtMaxNumber().setValue(new Decimal(最大取得件数));
        // 最近処理者履歴 のロード
        div.getSearchCondition().getCcdSearchCondition().load最近処理者();

        div.getSearchCondition().setIsOpen(true);
        div.getGaitoshaList().setIsOpen(false);

        return ResponseDatas.newResponseData(div);
    }

    /**
     * 「最大表示件数テキストボックス」のバリデーション実施時の処理です。
     *
     * @param div TaishoshaSearchDiv
     * @return ResponseData<TaishoshaSearchDiv>
     */
    public ResponseData<TaishoshaSearchDiv> onBlur_txtMaxNumber(TaishoshaSearchDiv div) {

        // 最大取得件数上限超過チェック
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
//        div.getSearchCondition().getCcdSearchCondition().check最大表示件数(pairs);
        ResponseData<TaishoshaSearchDiv> responseData = ResponseData.of(div).addValidationMessages(pairs).respond();

        //UZの仕様変更により不要になったため削除
//        responseData.setValidateMessageIgnoreWarningRequest(false);
        return responseData;
    }

    /**
     * 「条件をクリアする」ボタンクリック時に呼び出される処理です。
     *
     * @param div TaishoshaSearchDiv
     * @return ResponseData<TaishoshaSearchDiv>
     */
    public ResponseData<TaishoshaSearchDiv> onClick_btnClear(TaishoshaSearchDiv div) {

        // 介護検索条件と宛名検索条件のクリア
        div.getSearchCondition().getCcdSearchCondition().getCcdAtenaFinder().clear();
        div.getSearchCondition().getCcdSearchCondition().getKaigoFinder().clear();
        div.getSearchCondition().getCcdSearchCondition().getButtonsForHihokenshaFinder().getTxtMaxNumber().setValue(new Decimal(最大取得件数));
        return ResponseDatas.newResponseData(div);
    }

    /**
     * 「検索する」ボタンクリック時に呼び出される処理です。<br/>
     * 対象者が1件の場合は次画面に遷移します。次画面へ渡されるViewStateは以下の通り<br/>
     * ViewStateEnum：ViewStateKeys.資格対象者<br/>
     * 渡すクラス：jp.co.ndensan.reams.db.dbz.service.TaishoshaKey<br/>
     * クラス構成：被保険者番号、識別コード、世帯コード
     *
     * @param div TaishoshaSearchDiv
     * @return ResponseData<TaishoshaSearchDiv>
     */
    public ResponseData<TaishoshaSearchDiv> onClick_btnSearch(TaishoshaSearchDiv div) {

        ResponseData<TaishoshaSearchDiv> responseData = this.onBlur_txtMaxNumber(div);
        if (!responseData.getValidateErrorMessage().isEmpty()) {
            return responseData;
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();

        // 検索条件未指定チェック
        IHihokenshaFinderDiv 検索条件Div = div.getSearchCondition().getCcdSearchCondition();
        boolean 検索条件Flag = 検索条件Div.getKaigoFinder().getTxtHihokenshaNo().getValue().isEmpty()
                && 検索条件Div.getKaigoFinder().getKaigoFinderDetail().getChkHihokenshaDaicho().getSelectedItems().isEmpty()
                && 検索条件Div.getKaigoFinder().getKaigoFinderDetail().getChkJukyushaDaicho().getSelectedItems().isEmpty()
                && 検索条件Div.getKaigoFinder().getKaigoFinderDetail().getChkJushochiTokureisha().getSelectedItems().isEmpty(); //&& !検索条件Div.getCcdAtenaFinder().hasChanged()

        boolean 宛名条件修正Flag = 検索条件Div.getCcdAtenaFinder().hasChanged();

        if (検索条件Flag && !宛名条件修正Flag) {
            pairs.add(TaishoshaSearchValidationHelper.validate検索条件(検索条件Flag, div.getSearchCondition()));
            responseData = ResponseData.of(div).addValidationMessages(pairs).respond();

            //UZの仕様変更により不要になったため削除
//            responseData.setValidateMessageIgnoreWarningRequest(false);
            return responseData;
        }
        // 該当者を検索する
        SearchResult<TaishoshaRelateBusiness> result = get対象者(div.getSearchCondition().getCcdSearchCondition());

        // 検索結果の絞り込み
        // TODO 【資格、賦課共通】部分
        // 検索結果の件数判定
        int 検索結果件数 = result.totalCount();
        // 検索結果が０件の場合
        if (検索結果件数 == 0) {
            // 該当有無のメッセージ表示
            pairs.add(TaishoshaSearchValidationHelper.validate検索結果件数(true, div.getSearchCondition()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
            // 検索結果が1件の場合
        } else if (検索結果件数 == 1) {
            TaishoshaRelateBusiness 対象者 = result.records().toList().get(0);
            // ViewState_個人確定キーの保存
            put対象者Key(create対象者Key(対象者));
            // 最近処理者履歴の保存
            save最近処理者(div, 対象者);
            div.getGaitoshaList().getDgGaitoshaList().setDataSource(toRowList(result));
            // 次画面遷移
            return ResponseData.of(div).forwardWithEventName(対象者特定).respond();
            // 検索結果が２件以上の場合
        } else {
            // 最大表示件数チェック
            int 最大表示件数 = div.getSearchCondition().getCcdSearchCondition().get最大表示件数();
            DataGridSetting dataGridSetting = div.getGaitoshaList().getDgGaitoshaList().getGridSetting();
            if (検索結果件数 > 最大表示件数) {
                dataGridSetting.setLimitRowCount(最大表示件数);
                dataGridSetting.setSelectedRowCount(検索結果件数);
            } else {
                dataGridSetting.setLimitRowCount(最大取得件数);
                dataGridSetting.setSelectedRowCount(最大取得件数);
            }
            // 検索結果の表示
            div.getGaitoshaList().getDgGaitoshaList().setDataSource(toRowList(result));
            div.getSearchCondition().getCcdSearchCondition().getButtonsForHihokenshaFinder()
                    .getTxtMaxNumber().setValue(new Decimal(最大表示件数));
            // 画面状態遷移
            return ResponseData.of(div).setState(該当者一覧);
        }
    }

    /**
     * 「表示する」ボタンクリック時に呼び出される処理です。
     *
     * @param div TaishoshaSearchDiv
     * @return ResponseData<TaishoshaSearchDiv>
     */
    public ResponseData<TaishoshaSearchDiv> onClick_btnSaikinShorishaHyoji(TaishoshaSearchDiv div) {

        // 直前処理者の取得
        RString 最近処理者 = div.getSearchCondition().getCcdSearchCondition().get最近処理者();

        // 該当者を検索する
        ShikibetsuCode 識別コード = new ShikibetsuCode(最近処理者);
        IShikibetsuTaishoGyomuHanteiKey 業務判定キー
                = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先);
        IShikibetsuTaishoSearchKey 検索キー
                = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー, true).set識別コード(識別コード).build();
        TaishoshaFinder finder = new TaishoshaFinder();
        SearchResult<TaishoshaRelateBusiness> 対象者 = finder.get資格対象者(条件無, 条件無, 検索キー, 最近処理者検索数);
        if (!対象者.records().isEmpty()) {
            for (TaishoshaRelateBusiness entity : 対象者.records()) {
                put対象者Key(create対象者Key(entity));
                save最近処理者(div, entity);
            }
            div.getGaitoshaList().getDgGaitoshaList().setDataSource(toRowList(対象者));
        }
        return ResponseData.of(div).forwardWithEventName(対象者特定).respond();
    }

    /**
     * 「該当者一覧」選択時に呼び出される処理です。<br/>
     * （行クリックイベント、行ダブルクリックイベント）<br/>
     * 選択したデータのキー項目を次画面へ渡します。次画面へ渡されるViewStateは以下の通り<br/>
     * ViewStateEnum：ViewStateKeys.資格対象者<br/>
     * 渡すクラス：jp.co.ndensan.reams.db.dbz.service.TaishoshaKey<br/>
     * クラス構成：被保険者番号、識別コード、世帯コード
     *
     * @param div TaishoshaSearchDiv
     * @return ResponseData<TaishoshaSearchDiv>
     */
    public ResponseData<TaishoshaSearchDiv> onSelect_dgGaitoshaList(TaishoshaSearchDiv div) {

        // 最近処理者履歴の保存
        save最近処理者(div);
        // ViewState_個人確定キーの保存
        put対象者Key(create対象者Key(div));
        // 次画面遷移
        return ResponseData.of(div).forwardWithEventName(対象者特定).respond();
    }

    /**
     * 「再検索する」ボタンクリック時に呼び出される処理です。
     *
     * @param div TaishoshaSearchDiv
     * @return ResponseData<TaishoshaSearchDiv>
     */
    public ResponseData<TaishoshaSearchDiv> onClick_btnReSearch(TaishoshaSearchDiv div) {

        // 一覧グリッドのクリア
        div.getGaitoshaList().getDgGaitoshaList().setDataSource(Collections.EMPTY_LIST);
        div.getGaitoshaList().getDgGaitoshaList().getGridSetting().setLimitRowCount(最大取得件数);
        div.getGaitoshaList().getDgGaitoshaList().getGridSetting().setSelectedRowCount(最大取得件数);
        // 画面状態遷移
        return ResponseData.of(div).setState(検索条件);
    }

    private SearchResult<TaishoshaRelateBusiness> get対象者(IHihokenshaFinderDiv div) {
        TaishoshaFinder finder = new TaishoshaFinder();
        return finder.get資格対象者(get介護条件(div), get介護除外条件(div), div.get宛名条件(), 最大取得件数);
    }

    private ISearchCondition get介護条件(IHihokenshaFinderDiv div) {
        List<INewSearchCondition> 条件List = new ArrayList<>();

        IIgnoredValueJudge judge = new IIgnoredValueJudge() {
            @Override
            public boolean canIgnore(Object e) {
                return false;
            }
        };
        if (div.get被保険者番号() != null && !div.get被保険者番号().isEmpty()) {
            条件List.add(SearchConditionFactory.condition(
                    ShikakuSearchItem.被保険者番号, StringOperator.完全一致, div.get被保険者番号()));
        }
        if (div.is被保険者台帳登録者()) {
            条件List.add(SearchConditionFactory.condition(
                    ShikakuSearchItem.資格喪失日, FlexibleDateOperator.等しい, FlexibleDate.EMPTY, judge));
        }
        if (div.is住所地特例者()) {
            条件List.add(SearchConditionFactory.condition(
                    ShikakuSearchItem.住所地特例フラグ, StringOperator.完全一致, JushochitokureishaKubun.住所地特例者.getコード()));
        }
        ISearchCondition 介護条件 = null;
        if (条件List.size() > 0) {
            for (INewSearchCondition 条件 : 条件List) {
                介護条件 = (介護条件 == null) ? 条件 : 条件.and(介護条件);
            }
        }
        return 介護条件;
    }

    private ISearchCondition get介護除外条件(IHihokenshaFinderDiv div) {
        List<INewSearchCondition> 条件List = new ArrayList<>();

        IIgnoredValueJudge judge = new IIgnoredValueJudge() {
            @Override
            public boolean canIgnore(Object e) {
                return false;
            }
        };
        if (div.is被保険者台帳登録者()) {
            条件List.add(SearchConditionFactory.condition(
                    ShikakuSearchItem.被保険者番号, StringOperator.完全一致, RString.EMPTY, judge));
        }
        if (div.is受給者台帳登録者()) {
            条件List.add(SearchConditionFactory.condition(
                    ShikakuSearchItem.受給者台帳_被保険者番号, StringOperator.完全一致, RString.EMPTY, judge));
        }
        ISearchCondition 介護除外条件 = null;
        for (INewSearchCondition 条件 : 条件List) {
            介護除外条件 = (介護除外条件 == null) ? 条件 : 条件.or(介護除外条件);
        }

        return 介護除外条件;
    }

    private TaishoshaKey create対象者Key(TaishoshaSearchDiv div) {
        dgGaitoshaList_Row row = div.getGaitoshaList().getDgGaitoshaList().getClickedItem();
        return new TaishoshaKey(
                row.getHihokenshaNo() != null ? new HihokenshaNo(row.getHihokenshaNo()) : new HihokenshaNo(RString.EMPTY),
                row.getShikibetsuCode() != null ? new ShikibetsuCode(row.getShikibetsuCode()) : new ShikibetsuCode(RString.EMPTY),
                row.getSetaiCode() != null ? new SetaiCode(row.getSetaiCode()) : new SetaiCode(RString.EMPTY));
    }

    private TaishoshaKey create対象者Key(TaishoshaRelateBusiness entity) {
        UaFt200FindShikibetsuTaishoEntity shikibetsuTaisho = entity.get住基個人住登外エンティティ();
        DbV7901ShikakuSearchBusiness 資格検索 = new DbV7901ShikakuSearchBusiness(entity.get資格検索エンティティ());
        IKojin 個人 = createKojin(entity.get住基個人住登外エンティティ());
        return new TaishoshaKey(
                資格検索.getHihokenshaNo() != null ? 資格検索.getHihokenshaNo() : new HihokenshaNo(RString.EMPTY),
                shikibetsuTaisho.getShikibetsuCode() != null ? shikibetsuTaisho.getShikibetsuCode() : new ShikibetsuCode(RString.EMPTY),
                個人.get世帯コード() != null ? 個人.get世帯コード() : new SetaiCode(RString.EMPTY));
    }

    private void put対象者Key(TaishoshaKey key) {
        ViewStateHolder.put(ViewStateKeys.資格対象者, key);
    }

    private void save最近処理者(TaishoshaSearchDiv div) {
        dgGaitoshaList_Row row = div.getGaitoshaList().getDgGaitoshaList().getClickedItem();
        div.getSearchCondition().getCcdSearchCondition().save最近処理者(
                new ShikibetsuCode(row.getShikibetsuCode()), new AtenaMeisho(row.getShimei()));
    }

    private void save最近処理者(TaishoshaSearchDiv div, TaishoshaRelateBusiness entity) {
        div.getSearchCondition().getCcdSearchCondition().save最近処理者(
                entity.get住基個人住登外エンティティ().getShikibetsuCode(),
                createKojin(entity.get住基個人住登外エンティティ()).get名称().getName());
    }

    private List<dgGaitoshaList_Row> toRowList(SearchResult<TaishoshaRelateBusiness> result) {
        List<dgGaitoshaList_Row> rowList = new ArrayList<>();
        for (TaishoshaRelateBusiness 対象者 : result.records()) {
//            UaFt200FindShikibetsuTaishoEntity 住基個人住登外 = 対象者.get住基個人住登外エンティティ();
            DbV7901ShikakuSearchBusiness 資格検索結果 = new DbV7901ShikakuSearchBusiness(対象者.get資格検索エンティティ());
            IKojin 個人 = createKojin(対象者.get住基個人住登外エンティティ());
            IShikibetsuTaisho 識別対象 = createShikibetsuTaisho(対象者.get住基個人住登外エンティティ());
            HihoKubun 被保険者区分 = judge被保険者区分(資格検索結果);

            rowList.add(createdgGaitoshaList_Row(資格検索結果, 個人, 識別対象, 被保険者区分));
        }
        return rowList;
    }

    private HihoKubun judge被保険者区分(DbV7901ShikakuSearchBusiness 資格検索) {
        HihoKubun 被保険者区分 = HihoKubun.UNKNOWN;
        if (資格検索.getTekiyoJogaiTekiyoJiyuCode() != null && !資格検索.getTekiyoJogaiTekiyoJiyuCode().isEmpty()) {
            被保険者区分 = HihoKubun.適除;
        } else if (資格検索.getTatokureiTekiyoJiyuCode() != null && !資格検索.getTatokureiTekiyoJiyuCode().isEmpty()) {
            被保険者区分 = HihoKubun.他住;
        } else if (Objects.equals(new RString("1"), 資格検索.getJushochiTokureiFlag())) {
            被保険者区分 = HihoKubun.自住;
        } else if (資格検索.getJukyushaDaichoHihokenshaNo() != null && !資格検索.getJukyushaDaichoHihokenshaNo().isEmpty()) {
            被保険者区分 = HihoKubun.受給;
        } else if ((資格検索.getHihokenshaNo() != null && !資格検索.getHihokenshaNo().isEmpty())
                && (資格検索.getShikakuSoshitsuYMD() == null || 資格検索.getShikakuSoshitsuYMD().isEmpty())) {
            被保険者区分 = HihoKubun.資格;
        }
        return 被保険者区分;
    }

    private dgGaitoshaList_Row createdgGaitoshaList_Row(DbV7901ShikakuSearchBusiness 資格検索結果, IKojin 個人, IShikibetsuTaisho 識別対象, HihoKubun 被保険者区分) {

        RString 名称 = 識別対象.get名称() != null ? (識別対象.get名称().getName() != null ? 識別対象.get名称().getName().value() : RString.EMPTY) : RString.EMPTY;
        RString 名称カナ = 識別対象.get名称() != null ? (識別対象.get名称().getKana() != null ? 識別対象.get名称().getKana().value() : RString.EMPTY) : RString.EMPTY;
        RString 生年月日 = 個人.get生年月日() != null ? new RString(個人.get生年月日().toFlexibleDate().wareki().separator(Separator.PERIOD).toDateString().toString()) : RString.EMPTY;
        RString 郵便番号 = 識別対象.get住所() != null ? (識別対象.get住所().get郵便番号() != null ? 識別対象.get住所().get郵便番号().getEditedYubinNo() : RString.EMPTY) : RString.EMPTY;
        RString 住所 = 識別対象.get住所() != null ? 識別対象.get住所().get住所() : RString.EMPTY;
        RString 番地 = 識別対象.get住所().get番地() != null ? 識別対象.get住所().get番地().getBanchi().value() : RString.EMPTY;
        RString 住所番地 = 住所.concat(番地);

        dgGaitoshaList_Row newRow = new dgGaitoshaList_Row(
                資格検索結果.getHihokenshaNo() != null ? 資格検索結果.getHihokenshaNo().value() : RString.EMPTY,
                識別対象.get識別コード() != null ? 識別対象.get識別コード().getColumnValue() : RString.EMPTY,
                被保険者区分 != null ? 被保険者区分.getName() : RString.EMPTY,
                名称,
                名称カナ,
                識別対象.get名称() != null ? 名称.concat(名称カナ) : RString.EMPTY,
                個人.get性別() != null ? (個人.get性別().getName() != null ? 個人.get性別().getName().getShortJapanese() : RString.EMPTY) : RString.EMPTY,
                new TextBoxNum(),
                生年月日,
                個人.get年齢算出().get年齢(),
                郵便番号,
                住所番地,
                個人.get個人番号() != null ? 個人.get個人番号().value() : RString.EMPTY,
                個人.get住民状態() != null ? 個人.get住民状態().住民状態略称() : RString.EMPTY,
                個人.get世帯コード() != null ? 個人.get世帯コード().value() : RString.EMPTY);

        if (!個人.get年齢算出().get年齢().isEmpty()) {
            newRow.getIntNenrei().setValue(new Decimal(個人.get年齢算出().get年齢().toString()));
        }
        return newRow;
    }

}
