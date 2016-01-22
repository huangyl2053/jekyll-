/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0060031;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiDataIdentifier;
import jp.co.ndensan.reams.db.dbu.definition.core.nenpoyoushiki2no8.NenpoYoushiki2No8ViewStateKeys;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.DeleteJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.SearchJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060011.DBU0060011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.NenpoYoushiki2No8Div;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.dgChiikimitchakuyobosabisujukyu_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.dgHisetsugaigosabisujukyu_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.dgItakuyobosabisujukyusu_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0060031.NenpoYoushiki2No8Handler;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokunenpo.JigyoHokokuNenpoHoseiHakoManager;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 *
 * @author soft863
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
    private boolean 修正FLG = false;

    /**
     * 画面初期化を表示です。
     *
     * @param div NenpoYoushiki2No8Div
     * @return ResponseData<NenpoYoushiki2No8Div>
     */
    public ResponseData<NenpoYoushiki2No8Div> onLoad(NenpoYoushiki2No8Div div) {
        ViewStateHolder.put(NenpoYoushiki2No8ViewStateKeys.報告年, new FlexibleYear("1990"));
        ViewStateHolder.put(NenpoYoushiki2No8ViewStateKeys.集計対象年, new FlexibleYear("2016"));
        ViewStateHolder.put(NenpoYoushiki2No8ViewStateKeys.市町村コード, new LasdecCode("123456"));
        ViewStateHolder.put(NenpoYoushiki2No8ViewStateKeys.様式種類コード, new RString("001"));
        報告年 = ViewStateHolder.get(NenpoYoushiki2No8ViewStateKeys.報告年, FlexibleYear.class);
        集計対象年 = ViewStateHolder.get(NenpoYoushiki2No8ViewStateKeys.集計対象年, FlexibleYear.class);
        市町村コード = ViewStateHolder.get(NenpoYoushiki2No8ViewStateKeys.市町村コード, LasdecCode.class);
        様式種類コード = ViewStateHolder.get(NenpoYoushiki2No8ViewStateKeys.様式種類コード, RString.class);
        補正フラグ = ViewStateHolder.get(NenpoYoushiki2No8ViewStateKeys.補正フラグ, RString.class);
        List<dgItakuyobosabisujukyusu_Row> dgItakuyobosabiList = this.get件数タブ();
        List<dgChiikimitchakuyobosabisujukyu_Row> dgChiikimitchList = this.get費用額();
        List<dgHisetsugaigosabisujukyu_Row> dgHisetsugaigoList = this.get給付額();
        getHandler(div).初期状態(補正フラグ);
        if ((dgItakuyobosabiList == null || dgItakuyobosabiList.isEmpty())
                && (dgChiikimitchList == null || dgChiikimitchList.isEmpty())
                && (dgHisetsugaigoList == null || dgHisetsugaigoList.isEmpty())) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        } else {
            div.getShisetsugaigosabisujukyuMeisai().getTabShisetsugaigosabisujukyu().
                    getDgItakuyobosabisujukyusu().setDataSource(dgItakuyobosabiList);
            div.getShisetsugaigosabisujukyuMeisai().getTabShisetsugaigosabisujukyu().
                    getDgChiikimitchakuyobosabisujukyu().setDataSource(dgChiikimitchList);
            div.getShisetsugaigosabisujukyuMeisai().getTabHisetsugaigosabisujukyuInput().
                    getDgHisetsugaigosabisujukyu().setDataSource(dgHisetsugaigoList);
        }
        return ResponseData.of(div).respond();
    }

    public ResponseData<NenpoYoushiki2No8Div> onChange_tab(NenpoYoushiki2No8Div div) {
        if (div.getShisetsugaigosabisujukyuMeisai().getTablitakuyobosabisujukyusuInput().getTitle().equals(エリア_件数)) {
            onLoad(div);
        }
        if (div.getShisetsugaigosabisujukyuMeisai().getTabChiikimitchakuyobosabisujukyuInput().getTitle().equals(エリア_費用額)) {
            List<dgChiikimitchakuyobosabisujukyu_Row> dgChiikimitchList = this.get費用額();
            div.getShisetsugaigosabisujukyuMeisai().getTabShisetsugaigosabisujukyu().
                    getDgChiikimitchakuyobosabisujukyu().setDataSource(dgChiikimitchList);
            return ResponseData.of(div).respond();
        }
        if (div.getShisetsugaigosabisujukyuMeisai().getTabHisetsugaigosabisujukyuInput().getTitle().equals(エリア_給付額)) {
            List<dgHisetsugaigosabisujukyu_Row> dgHisetsugaigoList = this.get給付額();
            div.getShisetsugaigosabisujukyuMeisai().getTabHisetsugaigosabisujukyuInput().
                    getDgHisetsugaigosabisujukyu().setDataSource(dgHisetsugaigoList);
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    public ResponseData<NenpoYoushiki2No8Div> click_一覧へ戻る(NenpoYoushiki2No8Div div) {
        List<JigyoHokokuTokeiData> 修正データリスト = get修正データ(div);
        if (修正データリスト == null || 修正データリスト.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBU0060011TransitionEventName.様式２の８に遷移).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    public ResponseData<NenpoYoushiki2No8Div> onClick_保存(NenpoYoushiki2No8Div div) {
        補正フラグ = ViewStateHolder.get(NenpoYoushiki2No8ViewStateKeys.補正フラグ, RString.class);
        if (補正フラグ.equals(フラグ_修正)) {
            List<JigyoHokokuTokeiData> 修正データリスト = get修正データ(div);
            if (修正データリスト == null || 修正データリスト.isEmpty()) {
                throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
            }
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
            }
            JigyoHokokuNenpoHoseiHakoManager.createInstance().updateJigyoHokokuNenpoData(修正データリスト);
            return ResponseData.of(div).respond();
        }
        if (補正フラグ.equals(フラグ_削除)) {
            JigyoHokokuNenpoHoseiHakoManager.createInstance().
                    deleteJigyoHokokuNenpoData(new DeleteJigyoHokokuNenpo(報告年, 集計対象年, 市町村コード, 様式種類コード));
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private List<JigyoHokokuTokeiData> get修正データ(NenpoYoushiki2No8Div div) {
        List<JigyoHokokuTokeiData> list = new ArrayList<>();
        if (div.getShisetsugaigosabisujukyuMeisai().getTablitakuyobosabisujukyusuInput().getTitle().equals(エリア_件数)) {
            Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 件数タブデータ = ViewStateHolder.get(NenpoYoushiki2No8ViewStateKeys.件数データグリッド, Models.class);
            List<dgItakuyobosabisujukyusu_Row> dgItakuyobosabisujukyusu = div.getShisetsugaigosabisujukyuMeisai().getDgItakuyobosabisujukyusu().getDataSource();
            for (dgItakuyobosabisujukyusu_Row 画面データ : dgItakuyobosabisujukyusu) {
                for (JigyoHokokuTokeiData viewdata : 件数タブデータ) {
                    if (修正FLG) {
                        list.add(get修正後件数データ(画面データ, viewdata));
                    }
                }
            }
        }
        if (div.getShisetsugaigosabisujukyuMeisai().getTablitakuyobosabisujukyusuInput().getTitle().equals(エリア_費用額)) {
            Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 件数タブデータ = ViewStateHolder.get(NenpoYoushiki2No8ViewStateKeys.件数データグリッド, Models.class);
            List<dgChiikimitchakuyobosabisujukyu_Row> dgItakuyobosabisujukyusu = div.getShisetsugaigosabisujukyuMeisai().getDgChiikimitchakuyobosabisujukyu().getDataSource();
            for (dgChiikimitchakuyobosabisujukyu_Row 画面データ : dgItakuyobosabisujukyusu) {
                for (JigyoHokokuTokeiData viewdata : 件数タブデータ) {
                    if (修正FLG) {
                        list.add(get修正後費用額データ(画面データ, viewdata));
                    }
                }
            }
        }
        if (div.getShisetsugaigosabisujukyuMeisai().getTablitakuyobosabisujukyusuInput().getTitle().equals(エリア_給付額)) {
            Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 件数タブデータ = ViewStateHolder.get(NenpoYoushiki2No8ViewStateKeys.件数データグリッド, Models.class);
            List<dgHisetsugaigosabisujukyu_Row> dgItakuyobosabisujukyusu = div.getShisetsugaigosabisujukyuMeisai().getDgHisetsugaigosabisujukyu().getDataSource();
            for (dgHisetsugaigosabisujukyu_Row 画面データ : dgItakuyobosabisujukyusu) {
                for (JigyoHokokuTokeiData viewdata : 件数タブデータ) {
                    if (修正FLG) {
                        list.add(get修正後給付額データ(画面データ, viewdata));
                    }
                }
            }
        }
        return list;
    }

    private JigyoHokokuTokeiData get修正後件数データ(dgItakuyobosabisujukyusu_Row 画面データ, JigyoHokokuTokeiData viewdata) {
        if (画面データ.getTxtYokaigoIchi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYoshienNi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYoshienKei().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtKekkaYokaigo().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoIchi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoNi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoSan().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoYon().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoGo().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoKei().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtGokei().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoIchi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoIchi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYoshienNi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYoshienNi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYoshienKei().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYoshienKei().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtKekkaYokaigo().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtKekkaYokaigo().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoIchi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoIchi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoNi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoNi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoSan().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoSan().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoYon().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoYon().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoGo().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoGo().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoKei().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoKei().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtGokei().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtGokei().getValue());
            修正FLG = true;
            return viewdata;
        }
        修正FLG = false;
        return viewdata;
    }

    private JigyoHokokuTokeiData get修正後費用額データ(dgChiikimitchakuyobosabisujukyu_Row 画面データ, JigyoHokokuTokeiData viewdata) {
        if (画面データ.getTxtYokaigoIchi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYoshienNi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYoshienKei().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtKekkaYokaigo().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoIchi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoNi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoSan().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoYon().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoGo().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoKei().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtGokei().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoIchi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoIchi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYoshienNi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYoshienNi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYoshienKei().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYoshienKei().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtKekkaYokaigo().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtKekkaYokaigo().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoIchi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoIchi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoNi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoNi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoSan().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoSan().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoYon().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoYon().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoGo().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoGo().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoKei().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoKei().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtGokei().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtGokei().getValue());
            修正FLG = true;
            return viewdata;
        }
        修正FLG = false;
        return viewdata;
    }

    private JigyoHokokuTokeiData get修正後給付額データ(dgHisetsugaigosabisujukyu_Row 画面データ, JigyoHokokuTokeiData viewdata) {
        if (画面データ.getTxtYokaigoIchi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYoshienNi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYoshienKei().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtKekkaYokaigo().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoIchi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoNi().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoSan().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoYon().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoGo().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtYokaigoKei().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (画面データ.getTxtGokei().getValue().toString().isEmpty()) {
            viewdata.createBuilderForEdit().set集計結果値(Decimal.ZERO);
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoIchi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoIchi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYoshienNi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYoshienNi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYoshienKei().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYoshienKei().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtKekkaYokaigo().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtKekkaYokaigo().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoIchi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoIchi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoNi().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoNi().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoSan().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoSan().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoYon().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoYon().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoGo().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoGo().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtYokaigoKei().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtYokaigoKei().getValue());
            修正FLG = true;
            return viewdata;
        }
        if (!画面データ.getTxtGokei().getValue().equals(viewdata.get集計結果値())) {
            viewdata.createBuilderForEdit().set集計結果値(画面データ.getTxtGokei().getValue());
            修正FLG = true;
            return viewdata;
        }
        修正FLG = false;
        return viewdata;
    }

    private List<Decimal> get行番(SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch) {
        List<Decimal> 行番list = new ArrayList<>();
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = JigyoHokokuNenpoHoseiHakoManager.createInstance().getJigyoHokokuNenpoDetal(jigyoHokokuNenpoSearch).records();
        Collections.sort(事業報告集計一覧データリスト);
        for (JigyoHokokuTokeiData list : 事業報告集計一覧データリスト) {
            行番list.add(list.get縦番号());
        }
        return new ArrayList<>(new LinkedHashSet<>(行番list));
    }

    private List<dgItakuyobosabisujukyusu_Row> get件数タブ() {
        SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch = new SearchJigyoHokokuNenpo(報告年, 集計対象年, 市町村コード, 様式種類コード, 集計番号_0601);
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = JigyoHokokuNenpoHoseiHakoManager.createInstance().getJigyoHokokuNenpoDetal(jigyoHokokuNenpoSearch).records();
        ViewStateHolder.put(NenpoYoushiki2No8ViewStateKeys.件数データグリッド, Models.create(事業報告集計一覧データリスト));
        dgItakuyobosabisujukyusu_Row dgItakuyobosabi = new dgItakuyobosabisujukyusu_Row();
        List<dgItakuyobosabisujukyusu_Row> dgItakuyobosabiList = new ArrayList<>();
        for (Decimal 行番号 : get行番(jigyoHokokuNenpoSearch)) {
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
                    dgItakuyobosabiList.add(dgItakuyobosabi);
                }
            }
        }
        return dgItakuyobosabiList;
    }

    private List<dgChiikimitchakuyobosabisujukyu_Row> get費用額() {
        SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch = new SearchJigyoHokokuNenpo(報告年, 集計対象年, 市町村コード, 様式種類コード, 集計番号_0602);
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = JigyoHokokuNenpoHoseiHakoManager.createInstance().getJigyoHokokuNenpoDetal(jigyoHokokuNenpoSearch).records();
        ViewStateHolder.put(NenpoYoushiki2No8ViewStateKeys.費用額データグリッド, Models.create(事業報告集計一覧データリスト));
        List<dgChiikimitchakuyobosabisujukyu_Row> dgChiikimitchList = new ArrayList<>();
        dgChiikimitchakuyobosabisujukyu_Row dgChiikimitch = new dgChiikimitchakuyobosabisujukyu_Row();
        for (Decimal 行番号 : get行番(jigyoHokokuNenpoSearch)) {
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
                    dgChiikimitchList.add(dgChiikimitch);
                }
            }
        }
        return dgChiikimitchList;
    }

    private List<dgHisetsugaigosabisujukyu_Row> get給付額() {
        SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch = new SearchJigyoHokokuNenpo(報告年, 集計対象年, 市町村コード, 様式種類コード, 集計番号_0603);
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = JigyoHokokuNenpoHoseiHakoManager.createInstance().getJigyoHokokuNenpoDetal(jigyoHokokuNenpoSearch).records();
        ViewStateHolder.put(NenpoYoushiki2No8ViewStateKeys.給付額データグリッド, Models.create(事業報告集計一覧データリスト));
        List<dgHisetsugaigosabisujukyu_Row> dgHisetsugaigoList = new ArrayList<>();
        dgHisetsugaigosabisujukyu_Row dgHisetsugaigo = new dgHisetsugaigosabisujukyu_Row();
        for (Decimal 行番号 : get行番(jigyoHokokuNenpoSearch)) {
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
                    dgHisetsugaigoList.add(dgHisetsugaigo);
                }
            }
        }
        return dgHisetsugaigoList;
    }

    private NenpoYoushiki2No8Handler getHandler(NenpoYoushiki2No8Div div) {
        return new NenpoYoushiki2No8Handler(div);
    }
}
