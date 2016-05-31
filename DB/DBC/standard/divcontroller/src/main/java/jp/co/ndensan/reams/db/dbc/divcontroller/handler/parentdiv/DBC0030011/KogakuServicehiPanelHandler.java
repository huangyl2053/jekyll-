/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuResultEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuSearch;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.KogakuServicehiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.SearchKogakuHihokenshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.SearchYMDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.dgKogakuServicehiRireki_Row;
import jp.co.ndensan.reams.db.dbc.service.core.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensaku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費照会（対象者検索）のHandler
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class KogakuServicehiPanelHandler {

    private final KogakuServicehiPanelDiv div;
    private static final RString 月初 = new RString("01");
    private static final RString 指定R = new RString("指定");
    private static final RString 被保険者番号R = new RString("被保険者番号");
    private static final RString 提供年月FROMR = new RString("提供年月From");
    private static final RString 提供年月TOR = new RString("提供年月To");
    private static final RString 申請年月FROMR = new RString("申請年月From");
    private static final RString 申請年月TOR = new RString("申請年月To");
    private static final RString 決定年月FROMR = new RString("決定年月From");
    private static final RString 決定年月TOR = new RString("決定年月To");
    private static final RString 提供年月R = new RString("提供年月");
    private static final RString 申請年月R = new RString("申請年月");
    private static final RString 決定年月R = new RString("決定年月");
    private static final RString 履歴番号R = new RString("履歴番号R");
    private static final RString サービス提供年月R = new RString("サービス提供年月R");
    private static final RString 指定_年月 = new RString("YMShitei");
    private static final RString 指定_被保険者 = new RString("hihokenshaShitei");

    /**
     * 高額介護サービス費照会（対象者検索）のHandlerです。
     *
     * @param div KogakuServicehiPanelDiv
     */
    public KogakuServicehiPanelHandler(KogakuServicehiPanelDiv div) {
        this.div = div;
    }

    /**
     * 「条件をクリアする」ボタンを押下した際に実行します。
     */
    public void click条件をクリアする() {
        SearchKogakuHihokenshaDiv panel指定_被保険者 = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha();
        SearchYMDiv panel指定_年月 = div.getSearchKogakuServicehiPanel().getSearchYM();
        panel指定_被保険者.getTxtHihoNo().clearValue();
        panel指定_被保険者.getTxtHihoName().clearValue();
        panel指定_被保険者.getTxtKetteiYMRange().clearFromValue();
        panel指定_被保険者.getTxtKetteiYMRange().clearToValue();
        panel指定_被保険者.getTxtShinseiYMRange().clearFromValue();
        panel指定_被保険者.getTxtShinseiYMRange().clearToValue();
        panel指定_被保険者.getTxtTeikyoYMRange().clearFromValue();
        panel指定_被保険者.getTxtTeikyoYMRange().clearToValue();
        panel指定_年月.getTxtKetteiYM().clearValue();
        panel指定_年月.getTxtShinseiYM().clearValue();
        panel指定_年月.getTxtTeikyoYM().clearValue();
        div.getSearchKogakuServicehiPanel().getRadSearchKubun().setSelectedKey(指定_被保険者);
        div.getSearchKogakuServicehiPanel().getSearchYM().setDisabled(true);
        div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setDisabled(false);
    }

    /**
     * 検索処理、対象者一覧（パネル）初期化する。
     */
    public void load該当者一覧情報() {
        KogakuShokaiTaishoshaKensakuSearch searchCondition;
        if (指定_被保険者.equals(div.getSearchKogakuServicehiPanel().getRadSearchKubun().getSelectedKey())) {
            SearchKogakuHihokenshaDiv panel = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha();
            RString 被保険者番号 = panel.getTxtHihoNo().getValue();
            RDate 提供年月From = panel.getTxtTeikyoYMRange().getFromValue();
            RDate 提供年月To = panel.getTxtTeikyoYMRange().getToValue();
            RDate 申請年月From = panel.getTxtShinseiYMRange().getFromValue();
            RDate 申請年月To = panel.getTxtShinseiYMRange().getToValue();
            RDate 決定年月From = panel.getTxtKetteiYMRange().getFromValue();
            RDate 決定年月To = panel.getTxtKetteiYMRange().getToValue();
            searchCondition = getパラメータ(Boolean.TRUE, 被保険者番号, 提供年月From, 提供年月To, 申請年月From, 申請年月To,
                    決定年月From, 決定年月To, null, null, null);
        } else {
            SearchYMDiv panel = div.getSearchKogakuServicehiPanel().getSearchYM();
            RDate 提供年月 = panel.getTxtTeikyoYM().getValue();
            RDate 申請年月 = panel.getTxtShinseiYM().getValue();
            RDate 決定年月 = panel.getTxtKetteiYM().getValue();
            searchCondition = getパラメータ(Boolean.FALSE, null, null, null, null, null, null, null, 提供年月, 申請年月, 決定年月);
        }
        set該当者一覧エリア(searchCondition);
    }

    /**
     *
     * @param 指定して場合 boolean
     * @param 被保険者番号 RString
     * @param 提供年月From RDate
     * @param 提供年月To RDate
     * @param 申請年月From RDate
     * @param 申請年月To RDate
     * @param 決定年月From RDate
     * @param 決定年月To RDate
     * @param 提供年月 RDate
     * @param 申請年月 RDate
     * @param 決定年月 RDate
     * @return searchパラメータ KogakuShokaiTaishoshaKensakuSearch
     */
    public KogakuShokaiTaishoshaKensakuSearch getパラメータ(boolean 指定して場合, RString 被保険者番号, RDate 提供年月From,
            RDate 提供年月To, RDate 申請年月From, RDate 申請年月To, RDate 決定年月From, RDate 決定年月To,
            RDate 提供年月, RDate 申請年月, RDate 決定年月) {
        KogakuShokaiTaishoshaKensakuSearch searchCondition = new KogakuShokaiTaishoshaKensakuSearch();
        searchCondition.set指定して場合(指定して場合);
        if (被保険者番号 != null && !被保険者番号.isNullOrEmpty()) {
            searchCondition.set被保険者番号(new HihokenshaNo(被保険者番号));
        }
        if (提供年月From != null) {
            searchCondition.set提供年月From(new FlexibleYearMonth(提供年月From.getYearMonth().toString()));
        }
        if (提供年月To != null) {
            searchCondition.set提供年月To(new FlexibleYearMonth(提供年月To.getYearMonth().toString()));
        }
        if (申請年月From != null) {
            searchCondition.set申請年月From(new FlexibleDate(申請年月From.getYearMonth().toString().concat(月初.toString())));
        }
        if (申請年月To != null) {
            searchCondition.set申請年月To(new FlexibleDate(申請年月To.getYearMonth().toString()
                    .concat(String.valueOf(申請年月To.getYearMonth().getLastDay()))));
        }
        if (決定年月From != null) {
            searchCondition.set決定年月From(new FlexibleDate(決定年月From.getYearMonth().toString().concat(月初.toString())));
        }
        if (決定年月To != null) {
            searchCondition.set決定年月To(new FlexibleDate(決定年月To.getYearMonth().toString()
                    .concat(String.valueOf(決定年月To.getYearMonth().getLastDay()))));
        }
        if (提供年月 != null) {
            searchCondition.set提供年月(new FlexibleYearMonth(提供年月.getYearMonth().toString()));
        }
        if (申請年月 != null) {
            searchCondition.set申請年月初(new FlexibleDate(申請年月.getYearMonth().toString().concat(月初.toString())));
            searchCondition.set申請年月末(new FlexibleDate(申請年月.getYearMonth().toString()
                    .concat(String.valueOf(申請年月.getYearMonth().getLastDay()))));
        }
        if (決定年月 != null) {
            searchCondition.set決定年月初(new FlexibleDate(決定年月.getYearMonth().toString().concat(月初.toString())));
            searchCondition.set決定年月末(new FlexibleDate(決定年月.getYearMonth().toString()
                    .concat(String.valueOf(決定年月.getYearMonth().getLastDay()))));
        }
        return searchCondition;
    }

    /**
     * 該当者一覧エリアを初期化メソッドです。
     *
     * @param searchCondition searchパラメータ
     */
    public void set該当者一覧エリア(KogakuShokaiTaishoshaKensakuSearch searchCondition) {
        List<KogakuShokaiTaishoshaKensakuResultEntity> 該当者一覧情報
                = KogakuShokaiTaishoshaKensaku.createInstance().selectTaishosha(searchCondition);
        if (該当者一覧情報 == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        List<dgKogakuServicehiRireki_Row> dataSource = new ArrayList<>();
        for (KogakuShokaiTaishoshaKensakuResultEntity entity : 該当者一覧情報) {
            dgKogakuServicehiRireki_Row row = new dgKogakuServicehiRireki_Row();
            HihokenshaNo 被保険者番号 = entity.getEntity().get被保険者番号();
            if (被保険者番号 != null && !被保険者番号.isEmpty()) {
                row.setTxtHihoNo(被保険者番号.getColumnValue());
            }
            AtenaMeisho 申請者氏名 = entity.getEntity().get申請者氏名();
            if (申請者氏名 != null && !申請者氏名.isEmpty()) {
                row.setTxtHihoName(申請者氏名.getColumnValue());
            }
            FlexibleYearMonth サービス提供年月 = entity.getEntity().getサービス提供年月();
            if (サービス提供年月 != null && !サービス提供年月.isEmpty()) {
                row.setTxtTeikyoYM(サービス提供年月.toDateString());
            }
            row.getTxtKogakuShikyuAmount().setValue(entity.getEntity().get高額支給額());
            FlexibleDate 申請日 = entity.getEntity().get申請日();
            if (申請日 != null && !申請日.isEmpty()) {
                row.setTxtShinseiDate(new RString(申請日.toString()));
            }
            FlexibleDate 決定日 = entity.getEntity().get決定日();
            if (決定日 != null && !決定日.isEmpty()) {
                row.setTxtKetteiDate(new RString(決定日.toString()));
            }
            RString 支給区分コード = entity.getEntity().get支給区分コード();
            if (支給区分コード != null && !支給区分コード.isEmpty()) {
                row.setTxtShikyuKubun(ShikyuFushikyuKubun.toValue(支給区分コード).get名称());
            }
            row.getTxtShikyuKingaku().setValue(entity.getEntity().get支給金額());
            // TODO QA780 boolean?entity.getEntity().is高額自動償還()
            row.setTxtKogakuAutoShokan(new RString("true"));
            Decimal 履歴番号 = entity.getEntity().get履歴番号();
            if (履歴番号 != null) {
                row.setTxtRirekiNo(new RString(履歴番号.toString()));
            }
            dataSource.add(row);
        }
        div.getKogakuServicehiListPanel().getDgKogakuServicehiRireki().setDataSource(dataSource);
    }

    /**
     * 検索条件エリアの検索条件のonChange事件です。
     */
    public void onChange検索条件エリア() {
        if (指定_被保険者.equals(div.getSearchKogakuServicehiPanel().getRadSearchKubun().getSelectedKey())) {
            div.getSearchKogakuServicehiPanel().getSearchYM().getTxtKetteiYM().clearValue();
            div.getSearchKogakuServicehiPanel().getSearchYM().getTxtShinseiYM().clearValue();
            div.getSearchKogakuServicehiPanel().getSearchYM().getTxtTeikyoYM().clearValue();
            div.getSearchKogakuServicehiPanel().getSearchYM().setDisabled(true);
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setDisabled(false);
        } else {
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtHihoNo().clearValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtHihoName().clearValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtKetteiYMRange().clearToValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtKetteiYMRange().clearFromValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtShinseiYMRange().clearToValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtShinseiYMRange().clearFromValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtTeikyoYMRange().clearToValue();
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtTeikyoYMRange().clearFromValue();
            div.getSearchKogakuServicehiPanel().getSearchYM().setDisabled(false);
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setDisabled(true);
        }
    }

    /**
     * 検索条件エリアのRString内容をを返しする。
     *
     * @return 検索条件エリアの内容 Mapper<RString, RString>
     */
    public Map<RString, RString> get検索条件エリアRStr() {
        Map<RString, RString> map = new HashMap<>();
        map.put(指定R, div.getSearchKogakuServicehiPanel().getRadSearchKubun().getSelectedKey());
        map.put(被保険者番号R, div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtHihoNo().getValue());
        return map;
    }

    /**
     * 検索条件エリアのRDate内容をを返しする。
     *
     * @return 検索条件エリアの内容 Mapper<RString, RString>
     */
    public Map<RString, RDate> get検索条件エリアRDate() {
        Map<RString, RDate> map = new HashMap<>();
        SearchKogakuHihokenshaDiv panel_被保険者 = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha();
        SearchYMDiv panel年月 = div.getSearchKogakuServicehiPanel().getSearchYM();
        map.put(提供年月FROMR, panel_被保険者.getTxtTeikyoYMRange().getFromValue());
        map.put(提供年月TOR, panel_被保険者.getTxtTeikyoYMRange().getToValue());
        map.put(申請年月FROMR, panel_被保険者.getTxtShinseiYMRange().getFromValue());
        map.put(申請年月TOR, panel_被保険者.getTxtShinseiYMRange().getToValue());
        map.put(決定年月FROMR, panel_被保険者.getTxtKetteiYMRange().getFromValue());
        map.put(決定年月TOR, panel_被保険者.getTxtKetteiYMRange().getToValue());
        map.put(提供年月R, panel年月.getTxtTeikyoYM().getValue());
        map.put(申請年月R, panel年月.getTxtShinseiYM().getValue());
        map.put(決定年月R, panel年月.getTxtKetteiYM().getValue());
        return map;
    }

    /**
     * 検索条件を復活する。
     *
     * @param 指定 RString
     * @param 被保険者番号 RString
     * @param 提供年月From RDate
     * @param 提供年月To RDate
     * @param 申請年月From RDate
     * @param 申請年月To RDate
     * @param 決定年月From RDate
     * @param 決定年月To RDate
     * @param 提供年月 RDate
     * @param 申請年月 RDate
     * @param 決定年月 RDate
     */
    public void set検索条件(RString 指定, RString 被保険者番号, RDate 提供年月From, RDate 提供年月To, RDate 申請年月From,
            RDate 申請年月To, RDate 決定年月From, RDate 決定年月To, RDate 提供年月, RDate 申請年月, RDate 決定年月) {
        if (指定_被保険者.equals(指定)) {
            div.getSearchKogakuServicehiPanel().getRadSearchKubun().setSelectedKey(指定_被保険者);
            SearchKogakuHihokenshaDiv panel被保険者 = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha();
            panel被保険者.getTxtHihoNo().setValue(被保険者番号);
            panel被保険者.getTxtTeikyoYMRange().setFromValue(提供年月From);
            panel被保険者.getTxtTeikyoYMRange().setToValue(提供年月To);
            panel被保険者.getTxtShinseiYMRange().setFromValue(申請年月From);
            panel被保険者.getTxtShinseiYMRange().setToValue(申請年月To);
            panel被保険者.getTxtKetteiYMRange().setFromValue(決定年月From);
            panel被保険者.getTxtKetteiYMRange().setToValue(決定年月To);
            div.getSearchKogakuServicehiPanel().getSearchYM().setDisabled(true);
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setDisabled(false);
        } else {
            div.getSearchKogakuServicehiPanel().getRadSearchKubun().setSelectedKey(指定_年月);
            SearchYMDiv panel年月 = div.getSearchKogakuServicehiPanel().getSearchYM();
            panel年月.getTxtTeikyoYM().setValue(提供年月);
            panel年月.getTxtShinseiYM().setValue(申請年月);
            panel年月.getTxtKetteiYM().setValue(決定年月);
            div.getSearchKogakuServicehiPanel().getSearchYM().setDisabled(false);
            div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setDisabled(true);
        }
    }

    /**
     * 該当者一覧で選択した行の検索キーを返しする。
     *
     * @return 該当者一覧で選択した行の検索キー Map<RString, RString>
     */
    public Map<RString, RString> onClick_選択() {
        Map<RString, RString> map = new HashMap<>();
        dgKogakuServicehiRireki_Row row = div.getKogakuServicehiListPanel().getDgKogakuServicehiRireki().getClickedItem();
        RString 被保険者番号Row = row.getTxtHihoNo();
        RString サービス提供年月Row = row.getTxtTeikyoYM();
        RString 履歴番号Row = row.getTxtRirekiNo();
        map.put(被保険者番号R, 被保険者番号Row);
        map.put(サービス提供年月R, サービス提供年月Row);
        map.put(履歴番号R, 履歴番号Row);
        return map;
    }

}
