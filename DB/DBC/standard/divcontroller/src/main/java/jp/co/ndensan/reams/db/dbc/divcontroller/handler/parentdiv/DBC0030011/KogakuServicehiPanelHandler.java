/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuResultEntity;
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
    }

    /**
     * 検索処理、対象者一覧（パネル）初期化する。
     */
    public void load該当者一覧情報() {
        KogakuShokaiTaishoshaKensakuSearch searchCondition = new KogakuShokaiTaishoshaKensakuSearch();
        if (指定_被保険者.equals(div.getSearchKogakuServicehiPanel().getRadSearchKubun().getSelectedKey())) {
            SearchKogakuHihokenshaDiv panel = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha();
            searchCondition.set指定して場合(Boolean.TRUE);
            RString 被保険者番号 = panel.getTxtHihoNo().getValue();
            if (被保険者番号.isNullOrEmpty()) {
                searchCondition.set被保険者番号(new HihokenshaNo(被保険者番号));
            }
            RDate 提供年月From = panel.getTxtTeikyoYMRange().getFromValue();
            if (提供年月From != null) {
                searchCondition.set提供年月From(new FlexibleYearMonth(提供年月From.getYearMonth().toString()));
            }
            RDate 提供年月To = panel.getTxtTeikyoYMRange().getToValue();
            if (提供年月To != null) {
                searchCondition.set提供年月To(new FlexibleYearMonth(提供年月To.getYearMonth().toString()));
            }
            RDate 申請年月From = panel.getTxtShinseiYMRange().getFromValue();
            if (申請年月From != null) {
                searchCondition.set申請年月From(new FlexibleYearMonth(申請年月From.getYearMonth().toString()));
            }
            RDate 申請年月To = panel.getTxtShinseiYMRange().getToValue();
            if (申請年月To != null) {
                searchCondition.set申請年月To(new FlexibleYearMonth(申請年月To.getYearMonth().toString()));
            }
            RDate 決定年月From = panel.getTxtKetteiYMRange().getFromValue();
            if (決定年月From != null) {
                searchCondition.set決定年月From(new FlexibleYearMonth(決定年月From.getYearMonth().toString()));
            }
            RDate 決定年月To = panel.getTxtKetteiYMRange().getToValue();
            if (決定年月To != null) {
                searchCondition.set決定年月To(new FlexibleYearMonth(決定年月To.getYearMonth().toString()));
            }
        } else {
            SearchYMDiv panel = div.getSearchKogakuServicehiPanel().getSearchYM();
            searchCondition.set指定して場合(Boolean.FALSE);
            RDate 提供年月 = panel.getTxtTeikyoYM().getValue();
            if (提供年月 != null) {
                searchCondition.set提供年月(new FlexibleYearMonth(提供年月.getYearMonth().toString()));
            }
            RDate 申請年月 = panel.getTxtShinseiYM().getValue();
            if (申請年月 != null) {
                searchCondition.set申請年月(new FlexibleYearMonth(申請年月.getYearMonth().toString()));
            }
            RDate 決定年月 = panel.getTxtKetteiYM().getValue();
            if (決定年月 != null) {
                searchCondition.set決定年月(new FlexibleYearMonth(決定年月.getYearMonth().toString()));
            }
        }
        List<KogakuShokaiTaishoshaKensakuResultEntity> 該当者一覧情報 = KogakuShokaiTaishoshaKensaku.createInstance().selectTaishosha(searchCondition);
        if (該当者一覧情報 == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        set該当者一覧エリア(該当者一覧情報);
    }

    private void set該当者一覧エリア(List<KogakuShokaiTaishoshaKensakuResultEntity> 該当者一覧情報) {
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
            row.setTxtShikyuKubun(entity.getEntity().get支給区分コード());
            row.getTxtShikyuKingaku().setValue(entity.getEntity().get支給金額());
            // TODO boolean?entity.getEntity().is高額自動償還()
            row.setTxtKogakuAutoShokan(new RString("true"));
            Decimal 履歴番号 = entity.getEntity().get履歴番号();
            if (履歴番号 != null) {
                row.setTxtRirekiNo(new RString(履歴番号.toString()));
            }
            dataSource.add(row);
        }
        div.getKogakuServicehiListPanel().getDgKogakuServicehiRireki().setDataSource(dataSource);
    }

}
