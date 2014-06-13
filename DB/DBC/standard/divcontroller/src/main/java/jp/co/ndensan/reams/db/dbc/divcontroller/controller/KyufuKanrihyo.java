/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000.KyufuKanrihyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000.KyufuKanrihyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000.dgKyufuKanrihyoList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuKanrihyoInfo.KyufuKanrihyoInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuKanrihyoInfo.dgMeisaiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付管理票情報照会の給付管理票情報Panelのコントロールクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuKanrihyo {

    /**
     * データグリッドの選択時の処理。
     *
     * @param panel panel
     * @param listPanel listPanel
     * @return ResponseData
     */
    public ResponseData onSelectKyufuKanrihyoList(KyufuKanrihyoDiv panel, KyufuKanrihyoListDiv listPanel) {
        ResponseData<KyufuKanrihyoDiv> response = new ResponseData<>();
        dgKyufuKanrihyoList_Row selectRow = listPanel.getDgKyufuKanrihyoList().getActiveRow();
        対象期間区切 kugiri = kugiriHantei(selectRow);
        setVisible(panel, kugiri);
        setData(panel, selectRow, kugiri);

        response.data = panel;
        return response;
    }

    private enum 対象期間区切 {

        H1204_H1312,
        H1401_H1803,
        H1804_
    }

    private 対象期間区切 kugiriHantei(dgKyufuKanrihyoList_Row row) {
        if (new FlexibleDate(row.getTxtTaishoYM().replace(".", "").concat("01")).getYearMonth().isBefore(new FlexibleDate("20020101").getYearMonth())) {
            return 対象期間区切.H1204_H1312;
        } else if (new FlexibleDate(row.getTxtTaishoYM().replace(".", "").concat("01")).getYearMonth().isBefore(new FlexibleDate("20060401").getYearMonth())) {
            return 対象期間区切.H1401_H1803;
        } else {
            return 対象期間区切.H1804_;
        }
    }

    private void setData(KyufuKanrihyoDiv panel, dgKyufuKanrihyoList_Row row, 対象期間区切 kugiri) {
        panel.getTxtTaishoYM().setValue(new RDate(new FlexibleDate(row.getTxtTaishoYM().replace(".", "").concat("01")).toString()));
        panel.getTxtKaigoJotai().setValue(new RString("要介護１"));
        panel.getTxtHokenshaNo().setValue(row.getTxtHihoNo());
        panel.getTxtShinsaYM().setValue(new RDate(new FlexibleDate(row.getTxtTaishoYM().replace(".", "").concat("01")).toString()));
        if (kugiri.equals(対象期間区切.H1204_H1312)) {
            KyufuKanrihyoInfoDiv homon = panel.getTabKyufuKanrihyo().getKyufuKanrihyoHomonTsusho().getKyufuKanrihyoInfoHomonTsusho();
            KyufuKanrihyoInfoDiv tanki = panel.getTabKyufuKanrihyo().getKyufuKanrihyoTankiNyusho().getKyufuKanrihyoInfoTankiNyusho();
            bindInfoDiv(homon, row, 0);
            bindInfoGrid(homon);
            bindInfoDiv(tanki, row, 1);
            bindInfoGrid(tanki);
        } else if (kugiri.equals(対象期間区切.H1401_H1803)) {
            KyufuKanrihyoInfoDiv info = panel.getKyufuKanrihyoInfoKyotaku();
            bindInfoDiv(info, row, 2);
            bindInfoGrid(info);
        } else {
            KyufuKanrihyoInfoDiv info = panel.getKyufuKanrihyoInfoKyotaku();
            bindInfoDiv(info, row, 3);
            bindInfoGrid(info);
        }
    }

    private void bindInfoDiv(KyufuKanrihyoInfoDiv div, dgKyufuKanrihyoList_Row row, int index) {
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("dbc0060000/KyufuKanrihyoSummary.yml"));
        HashMap source = sourceList.get(index);
        div.getTxtSakuseiKubun().setValue(row.getTxtSakuseiKubun());
        div.getTxtSakuseiYMD().setValue(new RDate(new FlexibleDate(row.getTxtTaishoYM().replace(".", "").concat("01")).toString()));
        div.getTxtZengetsuNissu().setValue(new Decimal(source.get("前月までの給付計画日数").toString()));
        div.getTxtKeikakuSakuseiKubun().setValue(new RString(source.get("計画作成区分").toString()));
        div.getTxtShienJigyoshaNo().setValue(new RString(source.get("支援事業者番号").toString()));
        div.getTxtShienJigyoshaName().setValue(new RString(source.get("支援事業者名").toString()));
        div.getTxtShikyuGendogaku().setValue(new Decimal(source.get("支給限度額").toString()));
        div.getTxtGendogakuTekiyoKikan().setFromValue(new RDate(source.get("限度額適用期間開始").toString()));
        div.getTxtGendogakuTekiyoKikan().setToValue(new RDate(source.get("限度額適用期間終了").toString()));
        div.getTxtShiteiServiceShokei().setValue(new Decimal(source.get("指定サービス分小計").toString()));
        div.getTxtKijunServiceShokei().setValue(new Decimal(source.get("基準該当等サービス分小計").toString()));
        div.getTxtGokeiTanisu().setValue(new Decimal(source.get("給付計画合計").toString()));
        div.getTxtTantoSenmonNo().setValue(new RString(source.get("担当介護支援専門員番号").toString()));
        div.getTxtItakuJigyoshaNo().setValue(new RString(source.get("委託先事業所番号").toString()));
        div.getTxtItakuJigyoshaName().setValue(new RString(source.get("委託先事業所名").toString()));
        div.getTxtItakuSenmonNo().setValue(new RString(source.get("委託先担当介護支援専門員番号").toString()));
    }

    private void bindInfoGrid(KyufuKanrihyoInfoDiv div) {
        List<dgMeisaiList_Row> dgRowList = div.getDgMeisaiList().getDataSource();
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("dbc0060000/KyufuKanrihyoDataGrid.yml"));
        dgRowList.clear();
        for (HashMap source : sourceList) {
            dgRowList.add(new dgMeisaiList_Row(
                    new RString(String.format("%1$02d", source.get("明細"))),
                    new RString(source.get("サービス種類").toString()),
                    new RString(source.get("計画単位数").toString()),
                    new RString(source.get("サービス事業者").toString()),
                    new RString(source.get("事業者区分").toString())));
        }
        div.getDgMeisaiList().setDataSource(dgRowList);
    }

    private void setVisible(KyufuKanrihyoDiv panel, 対象期間区切 kugiri) {
        if (kugiri.equals(対象期間区切.H1204_H1312)) {
            panel.getTabKyufuKanrihyo().setVisible(true);
            panel.getTabKyufuKanrihyo().setDisplayNone(false);
            panel.getKyufuKanrihyoInfoKyotaku().setVisible(false);
            panel.getKyufuKanrihyoInfoKyotaku().setDisplayNone(true);
        } else if (kugiri.equals(対象期間区切.H1401_H1803)) {
            panel.getTabKyufuKanrihyo().setVisible(false);
            panel.getTabKyufuKanrihyo().setDisplayNone(true);
            panel.getKyufuKanrihyoInfoKyotaku().setVisible(true);
            panel.getKyufuKanrihyoInfoKyotaku().setDisplayNone(false);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtTantoSenmonNo().setVisible(false);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtTantoSenmonNo().setDisplayNone(true);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuJigyoshaNo().setVisible(false);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuJigyoshaNo().setDisplayNone(true);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuJigyoshaName().setVisible(false);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuJigyoshaName().setDisplayNone(true);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuSenmonNo().setVisible(false);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuSenmonNo().setDisplayNone(true);
        } else {
            panel.getTabKyufuKanrihyo().setVisible(false);
            panel.getTabKyufuKanrihyo().setDisplayNone(true);
            panel.getKyufuKanrihyoInfoKyotaku().setVisible(true);
            panel.getKyufuKanrihyoInfoKyotaku().setDisplayNone(false);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtTantoSenmonNo().setVisible(true);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtTantoSenmonNo().setDisplayNone(false);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuJigyoshaNo().setVisible(true);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuJigyoshaNo().setDisplayNone(false);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuJigyoshaName().setVisible(true);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuJigyoshaName().setDisplayNone(false);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuSenmonNo().setVisible(true);
            panel.getKyufuKanrihyoInfoKyotaku().getTxtItakuSenmonNo().setDisplayNone(false);
        }
    }
}
