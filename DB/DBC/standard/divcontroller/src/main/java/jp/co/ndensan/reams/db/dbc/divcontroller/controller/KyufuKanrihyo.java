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
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票情報照会の給付管理票情報Panelのコントロールクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuKanrihyo {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0060000/KyufuKanrihyo.yml"));
    }

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
        if (new FlexibleDate(row.getTxtTaishoYM().replace(".", "").concat("01")).getYearMonth().
                isBefore(new FlexibleDate("20020101").getYearMonth())) {
            return 対象期間区切.H1204_H1312;
        } else if (new FlexibleDate(row.getTxtTaishoYM().replace(".", "").concat("01")).getYearMonth().
                isBefore(new FlexibleDate("20060401").getYearMonth())) {
            return 対象期間区切.H1401_H1803;
        } else {
            return 対象期間区切.H1804_;
        }
    }

    private void setData(KyufuKanrihyoDiv panel, dgKyufuKanrihyoList_Row row, 対象期間区切 kugiri) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
        panel.getTxtTaishoYM().setValue(new RDate(new FlexibleDate(row.getTxtTaishoYM().replace(".", "").concat("01")).toString()));
        panel.getTxtKaigoJotai().setValue(cg.getAsRString("要介護状態"));
        panel.getTxtHokenshaNo().setValue(row.getTxtHihoNo());
        panel.getTxtShinsaYM().setValue(new RDate(new FlexibleDate(row.getTxtTaishoYM().replace(".", "").concat("01")).toString()));
        if (kugiri.equals(対象期間区切.H1204_H1312)) {
            KyufuKanrihyoInfoDiv homon = panel.getTabKyufuKanrihyo().getKyufuKanrihyoHomonTsusho().getKyufuKanrihyoInfoHomonTsusho();
            KyufuKanrihyoInfoDiv tanki = panel.getTabKyufuKanrihyo().getKyufuKanrihyoTankiNyusho().getKyufuKanrihyoInfoTankiNyusho();
            bindInfoDiv(homon, row, 1);
            bindInfoGrid(homon);
            bindInfoDiv(tanki, row, 2);
            bindInfoGrid(tanki);
        } else if (kugiri.equals(対象期間区切.H1401_H1803)) {
            KyufuKanrihyoInfoDiv info = panel.getKyufuKanrihyoInfoKyotaku();
            bindInfoDiv(info, row, 3);
            bindInfoGrid(info);
        } else {
            KyufuKanrihyoInfoDiv info = panel.getKyufuKanrihyoInfoKyotaku();
            bindInfoDiv(info, row, 4);
            bindInfoGrid(info);
        }
    }

    private void bindInfoDiv(KyufuKanrihyoInfoDiv div, dgKyufuKanrihyoList_Row row, int index) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(index));
        div.getTxtSakuseiKubun().setValue(row.getTxtSakuseiKubun());
        div.getTxtSakuseiYMD().setValue(new RDate(new FlexibleDate(row.getTxtTaishoYM().replace(".", "").concat("01")).toString()));
        div.getTxtZengetsuNissu().setValue(cg.getAsDecimal("前月までの給付計画日数"));
        div.getTxtKeikakuSakuseiKubun().setValue(cg.getAsRString("計画作成区分"));
        div.getTxtShienJigyoshaNo().setValue(cg.getAsRString("支援事業者番号"));
        div.getTxtShienJigyoshaName().setValue(cg.getAsRString("支援事業者名"));
        div.getTxtShikyuGendogaku().setValue(cg.getAsDecimal("支給限度額"));
        div.getTxtGendogakuTekiyoKikan().setFromValue(cg.getAsRDate("限度額適用期間開始"));
        div.getTxtGendogakuTekiyoKikan().setToValue(cg.getAsRDate("限度額適用期間終了"));
        div.getTxtShiteiServiceShokei().setValue(cg.getAsDecimal("指定サービス分小計"));
        div.getTxtKijunServiceShokei().setValue(cg.getAsDecimal("基準該当等サービス分小計"));
        div.getTxtGokeiTanisu().setValue(cg.getAsDecimal("給付計画合計"));
        div.getTxtTantoSenmonNo().setValue(cg.getAsRString("担当介護支援専門員番号"));
        div.getTxtItakuJigyoshaNo().setValue(cg.getAsRString("委託先事業所番号"));
        div.getTxtItakuJigyoshaName().setValue(cg.getAsRString("委託先事業所名"));
        div.getTxtItakuSenmonNo().setValue(cg.getAsRString("委託先担当介護支援専門員番号"));
    }

    private void bindInfoGrid(KyufuKanrihyoInfoDiv div) {
        List<dgMeisaiList_Row> dgRowList = div.getDgMeisaiList().getDataSource();
        dgRowList.clear();
        for (int i = 5; i < 8; i++) {
            ControlGenerator cg = new ControlGenerator(getYaml().get(i));
            dgRowList.add(new dgMeisaiList_Row(
                    cg.getAsRString("明細"),
                    cg.getAsRString("サービス種類"),
                    cg.getAsRString("計画単位数"),
                    cg.getAsRString("サービス事業者"),
                    cg.getAsRString("事業者区分")));
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
