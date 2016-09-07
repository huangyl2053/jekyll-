/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0060031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiDataIdentifier;
import jp.co.ndensan.reams.db.dbu.definition.core.zigyouhoukokunenpou.ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpo.SearchJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.DBU0060031StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.DBU0060031TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.NenpoYoushiki2No8Div;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.dgChiikimitchakuyobosabisujukyu_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.dgHisetsugaigosabisujukyu_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.dgItakuyobosabisujukyusu_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0060031.NenpoYoushiki2No8Handler;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokunenpo.JigyoHokokuNenpoHoseiHakoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 事業報告（年報）補正、発行_様式２の８画面
 *
 * @reamsid_L DBU-1060-030 zhengshukai
 *
 */
public class NenpoYoushiki2No8 {

    private static final Code 集計番号_0601 = new Code("0601");
    private static final Code 集計番号_0602 = new Code("0602");
    private static final Code 集計番号_0603 = new Code("0603");
    private static final Decimal 横番号_10 = new Decimal("10");
    private static final Decimal 横番号_8 = new Decimal("8");
    private static final Decimal 横番号_9 = new Decimal("9");
    private static final Decimal 横番号_12 = new Decimal("12");
    private static final Decimal 横番号_1 = new Decimal("1");
    private static final Decimal 横番号_2 = new Decimal("2");
    private static final Decimal 横番号_3 = new Decimal("3");
    private static final Decimal 横番号_4 = new Decimal("4");
    private static final Decimal 横番号_5 = new Decimal("5");
    private static final Decimal 横番号_6 = new Decimal("6");
    private static final Decimal 横番号_7 = new Decimal("7");
    private static final Decimal 横番号_13 = new Decimal("13");
    private static final RString エリア_件数 = new RString("ア　件数");
    private static final RString エリア_費用額 = new RString("イ　費用額");
    private static final RString エリア_給付額 = new RString("ウ　給付額");
    private static final RString フラグ_修正 = new RString("修正");
    private static final RString フラグ_削除 = new RString("削除");
    private FlexibleYear 報告年;
    private FlexibleYear 集計対象年;
    private LasdecCode 市町村コード;
    private RString 様式種類コード;
    private RString 補正フラグ;
    private RDate 報告年度;
    private RDate 集計年度;
    private RString 保険者コード;
    private RString 保険者名称;

    /**
     * 画面初期化を表示です。
     *
     * @param div NenpoYoushiki2No8Div
     * @return ResponseData<NenpoYoushiki2No8Div>
     */
    public ResponseData<NenpoYoushiki2No8Div> onLoad(NenpoYoushiki2No8Div div) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity
                = ViewStateHolder.get(ViewStateKeys.補正検索画面情報, ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity.class);
        報告年度 = new RDate(entity.get画面報告年度().toString());
        集計年度 = new RDate(entity.get画面集計年度().toString());
        保険者コード = entity.get保険者コード();
        保険者名称 = entity.get市町村名称();
        補正フラグ = entity.get補正フラグ();
        getHandler(div).初期状態(補正フラグ, 報告年度, 集計年度, 保険者コード, 保険者名称);
        if (!this.get件数タブ(div)
                && !this.get費用額(div)
                && !this.get給付額(div)) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
            }
            if (new RString(UrInformationMessages.該当データなし.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
                return ResponseData.of(div).forwardWithEventName(DBU0060031TransitionEventName.検索に戻る).respond();
            }
        }
        return ResponseData.of(div).setState(DBU0060031StateName.初期状態);
    }

    /**
     * タブを切り替え時に設定です。
     *
     * @param div NenpoYoushiki2No8Div
     * @return ResponseData<NenpoYoushiki2No8Div>
     */
    public ResponseData<NenpoYoushiki2No8Div> onChange_tab(NenpoYoushiki2No8Div div) {
        RString title = div.getShisetsugaigosabisujukyuMeisai().getTabShisetsugaigosabisujukyu().getSelectedItem().getTitle();
        if (title.equals(エリア_件数)) {
            onLoad(div);
        }
        if (title.equals(エリア_費用額)) {
            get費用額(div);
            return ResponseData.of(div).respond();
        }
        if (title.equals(エリア_給付額)) {
            get給付額(div);
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧へ戻るを処理します。
     *
     * @param div NenpoYoushiki2No8Div
     * @return ResponseData<NenpoYoushiki2No8Div>
     */
    public ResponseData<NenpoYoushiki2No8Div> onClick_modoru(NenpoYoushiki2No8Div div) {
        Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 件数タブデータ = ViewStateHolder.
                get(ViewStateKeys.件数データグリッド, Models.class);
        Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 費用額データ = ViewStateHolder.
                get(ViewStateKeys.費用額データグリッド, Models.class);
        Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 給付額データ = ViewStateHolder.
                get(ViewStateKeys.給付額データグリッド, Models.class);
        List<JigyoHokokuTokeiData> 修正データリスト
                = getHandler(div).get修正データ(件数タブデータ, 費用額データ, 給付額データ);
        if (修正データリスト == null || 修正データリスト.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBU0060031TransitionEventName.検索に戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBU0060031TransitionEventName.検索に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存を処理します。
     *
     * @param div NenpoYoushiki2No8Div
     * @return ResponseData<NenpoYoushiki2No8Div>
     */
    public ResponseData<NenpoYoushiki2No8Div> onClick_hozon(NenpoYoushiki2No8Div div) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity
                = ViewStateHolder.get(ViewStateKeys.補正検索画面情報, ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity.class);
        補正フラグ = entity.get補正フラグ();
        if (補正フラグ.equals(フラグ_修正)) {
            Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 件数タブデータ = ViewStateHolder.
                    get(ViewStateKeys.件数データグリッド, Models.class);
            Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 費用額データ = ViewStateHolder.
                    get(ViewStateKeys.費用額データグリッド, Models.class);
            Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 給付額データ = ViewStateHolder.
                    get(ViewStateKeys.給付額データグリッド, Models.class);
            List<JigyoHokokuTokeiData> 修正データリスト
                    = getHandler(div).get修正データ(件数タブデータ, 費用額データ, 給付額データ);
            if (修正データリスト == null || 修正データリスト.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            }
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                        UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                JigyoHokokuNenpoHoseiHakoManager.createInstance().updateJigyoHokokuNenpoData(修正データリスト);
                div.getKanryoMsg().getCcdKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                        .replace("修正").evaluate()),
                        RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBU0060031StateName.完了状態);
            }
        }
        if (補正フラグ.equals(フラグ_削除)) {
            JigyoHokokuNenpoHoseiHakoManager.createInstance().deleteJigyoHokokuNenpoData(del事業報告集計情報());
            div.getKanryoMsg().getCcdKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("削除").evaluate()),
                    RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBU0060031StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    private List<JigyoHokokuTokeiData> del事業報告集計情報() {
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = new ArrayList<>();
        Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 件数タブデータ
                = ViewStateHolder.get(ViewStateKeys.件数データグリッド, Models.class);
        if (件数タブデータ != null) {
            for (JigyoHokokuTokeiData 件数 : 件数タブデータ) {
                事業報告集計一覧データリスト.add(件数);
            }
        }
        Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 費用額データ
                = ViewStateHolder.get(ViewStateKeys.費用額データグリッド, Models.class);
        if (費用額データ != null) {
            for (JigyoHokokuTokeiData 費用額 : 費用額データ) {
                事業報告集計一覧データリスト.add(費用額);
            }
        }
        Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 給付額データ
                = ViewStateHolder.get(ViewStateKeys.給付額データグリッド, Models.class);
        if (給付額データ != null) {
            for (JigyoHokokuTokeiData 給付額 : 給付額データ) {
                事業報告集計一覧データリスト.add(給付額);
            }
        }
        return 事業報告集計一覧データリスト;
    }

    private boolean get件数タブ(NenpoYoushiki2No8Div div) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity
                = ViewStateHolder.get(ViewStateKeys.補正検索画面情報, ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity.class);
        報告年 = new FlexibleYear(entity.get行報告年());
        集計対象年 = new FlexibleYear(entity.get行集計対象年());
        市町村コード = new LasdecCode(entity.get行市町村コード());
        様式種類コード = entity.get事業報告年報補正表示のコード();
        SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch = new SearchJigyoHokokuNenpo(報告年, 集計対象年, 市町村コード, 様式種類コード, 集計番号_0601);
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = JigyoHokokuNenpoHoseiHakoManager.createInstance().
                getJigyoHokokuNenpoDetal(jigyoHokokuNenpoSearch).records();
        ViewStateHolder.put(ViewStateKeys.件数データグリッド, Models.create(事業報告集計一覧データリスト));
        List<dgItakuyobosabisujukyusu_Row> dgItakuyobosabiList = new ArrayList<>();
        for (Decimal 行番号 : getHandler(div).get行番(jigyoHokokuNenpoSearch)) {
            dgItakuyobosabisujukyusu_Row dgItakuyobosabi = new dgItakuyobosabisujukyusu_Row();
            for (JigyoHokokuTokeiData jigyoHokokuNenpo : 事業報告集計一覧データリスト) {
                if (jigyoHokokuNenpo.get縦番号().equals(行番号)) {
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_10)) {
                        dgItakuyobosabi.setTxtRowMeisho(jigyoHokokuNenpo.get集計項目名称());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_8)) {
                        dgItakuyobosabi.getTxtYoshienIchi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_9)) {
                        dgItakuyobosabi.getTxtYoshienNi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_12)) {
                        dgItakuyobosabi.getTxtYoshienKei().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_1)) {
                        dgItakuyobosabi.getTxtKekkaYokaigo().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_2)) {
                        dgItakuyobosabi.getTxtYokaigoIchi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_3)) {
                        dgItakuyobosabi.getTxtYokaigoNi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_4)) {
                        dgItakuyobosabi.getTxtYokaigoSan().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_5)) {
                        dgItakuyobosabi.getTxtYokaigoYon().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_6)) {
                        dgItakuyobosabi.getTxtYokaigoGo().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_7)) {
                        dgItakuyobosabi.getTxtYokaigoKei().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_13)) {
                        dgItakuyobosabi.getTxtGokei().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                }
            }
            dgItakuyobosabiList.add(dgItakuyobosabi);
        }
        div.getShisetsugaigosabisujukyuMeisai().getTablitakuyobosabisujukyusuInput().
                getDgItakuyobosabisujukyusu().setDataSource(dgItakuyobosabiList);
        return !dgItakuyobosabiList.isEmpty();
    }

    private boolean get費用額(NenpoYoushiki2No8Div div) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity
                = ViewStateHolder.get(ViewStateKeys.補正検索画面情報, ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity.class);
        報告年 = new FlexibleYear(entity.get行報告年());
        集計対象年 = new FlexibleYear(entity.get行集計対象年());
        市町村コード = new LasdecCode(entity.get行市町村コード());
        様式種類コード = entity.get事業報告年報補正表示のコード();
        SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch = new SearchJigyoHokokuNenpo(報告年, 集計対象年, 市町村コード, 様式種類コード, 集計番号_0602);
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = JigyoHokokuNenpoHoseiHakoManager.createInstance().
                getJigyoHokokuNenpoDetal(jigyoHokokuNenpoSearch).records();
        ViewStateHolder.put(ViewStateKeys.費用額データグリッド, Models.create(事業報告集計一覧データリスト));
        List<dgChiikimitchakuyobosabisujukyu_Row> dgChiikimitchList = new ArrayList<>();
        for (Decimal 行番号 : getHandler(div).get行番(jigyoHokokuNenpoSearch)) {
            dgChiikimitchakuyobosabisujukyu_Row dgChiikimitch = new dgChiikimitchakuyobosabisujukyu_Row();
            for (JigyoHokokuTokeiData jigyoHokokuNenpo : 事業報告集計一覧データリスト) {
                if (jigyoHokokuNenpo.get縦番号().equals(行番号)) {
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_10)) {
                        dgChiikimitch.setTxtRowMeisho(new RString(jigyoHokokuNenpo.get集計結果値().toString()));
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_8)) {
                        dgChiikimitch.getTxtYoshienIchi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_9)) {
                        dgChiikimitch.getTxtYoshienNi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_12)) {
                        dgChiikimitch.getTxtYoshienKei().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_1)) {
                        dgChiikimitch.getTxtKekkaYokaigo().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_2)) {
                        dgChiikimitch.getTxtYokaigoIchi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_3)) {
                        dgChiikimitch.getTxtYokaigoNi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_4)) {
                        dgChiikimitch.getTxtYokaigoSan().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_5)) {
                        dgChiikimitch.getTxtYokaigoYon().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_6)) {
                        dgChiikimitch.getTxtYokaigoGo().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_7)) {
                        dgChiikimitch.getTxtYokaigoKei().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_13)) {
                        dgChiikimitch.getTxtGokei().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                }
            }
            dgChiikimitchList.add(dgChiikimitch);
        }
        div.getShisetsugaigosabisujukyuMeisai().getTabShisetsugaigosabisujukyu().
                getDgChiikimitchakuyobosabisujukyu().setDataSource(dgChiikimitchList);
        return !dgChiikimitchList.isEmpty();
    }

    private boolean get給付額(NenpoYoushiki2No8Div div) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity
                = ViewStateHolder.get(ViewStateKeys.補正検索画面情報, ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity.class);
        報告年 = new FlexibleYear(entity.get行報告年());
        集計対象年 = new FlexibleYear(entity.get行集計対象年());
        市町村コード = new LasdecCode(entity.get行市町村コード());
        様式種類コード = entity.get事業報告年報補正表示のコード();
        SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch = new SearchJigyoHokokuNenpo(報告年, 集計対象年, 市町村コード, 様式種類コード, 集計番号_0603);
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = JigyoHokokuNenpoHoseiHakoManager.createInstance().
                getJigyoHokokuNenpoDetal(jigyoHokokuNenpoSearch).records();
        ViewStateHolder.put(ViewStateKeys.給付額データグリッド, Models.create(事業報告集計一覧データリスト));
        List<dgHisetsugaigosabisujukyu_Row> dgHisetsugaigoList = new ArrayList<>();
        for (Decimal 行番号 : getHandler(div).get行番(jigyoHokokuNenpoSearch)) {
            dgHisetsugaigosabisujukyu_Row dgHisetsugaigo = new dgHisetsugaigosabisujukyu_Row();
            for (JigyoHokokuTokeiData jigyoHokokuNenpo : 事業報告集計一覧データリスト) {
                if (jigyoHokokuNenpo.get縦番号().equals(行番号)) {
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_10)) {
                        dgHisetsugaigo.setTxtRowMeisho(new RString(jigyoHokokuNenpo.get集計結果値().toString()));
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_8)) {
                        dgHisetsugaigo.getTxtYoshienIchi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_9)) {
                        dgHisetsugaigo.getTxtYoshienNi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_12)) {
                        dgHisetsugaigo.getTxtYoshienKei().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_1)) {
                        dgHisetsugaigo.getTxtKekkaYokaigo().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_2)) {
                        dgHisetsugaigo.getTxtYokaigoIchi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_3)) {
                        dgHisetsugaigo.getTxtYokaigoNi().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_4)) {
                        dgHisetsugaigo.getTxtYokaigoSan().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_5)) {
                        dgHisetsugaigo.getTxtYokaigoYon().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_6)) {
                        dgHisetsugaigo.getTxtYokaigoGo().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_7)) {
                        dgHisetsugaigo.getTxtYokaigoKei().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                    if (jigyoHokokuNenpo.get横番号().equals(横番号_13)) {
                        dgHisetsugaigo.getTxtGokei().setValue(jigyoHokokuNenpo.get集計結果値());
                    }
                }
            }
            dgHisetsugaigoList.add(dgHisetsugaigo);
        }
        div.getShisetsugaigosabisujukyuMeisai().getTabHisetsugaigosabisujukyuInput().
                getDgHisetsugaigosabisujukyu().setDataSource(dgHisetsugaigoList);
        return !dgHisetsugaigoList.isEmpty();
    }

    private NenpoYoushiki2No8Handler getHandler(NenpoYoushiki2No8Div div) {
        return new NenpoYoushiki2No8Handler(div);
    }
}
