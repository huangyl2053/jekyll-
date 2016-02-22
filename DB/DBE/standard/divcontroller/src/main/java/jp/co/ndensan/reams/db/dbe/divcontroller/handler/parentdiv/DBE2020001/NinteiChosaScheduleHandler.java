/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.chikushichoson.ChikuShichosonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaschedule.NinteichosaScheduleBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichousasukejuru.NinteiChousaSukejuruParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020001.NinteiChosaSchedulePanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020001.dgNinteiChosaSchedule_Row;
import jp.co.ndensan.reams.db.dbe.service.core.basic.sukejurutouroku.SukejuruTourokuFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.DayOfWeek;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Seireki;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査スケジュール登録1の取得処理。
 */
public class NinteiChosaScheduleHandler {

    private final NinteiChosaSchedulePanelDiv ninteidiv;
    private static final RString 状態_初期状態 = new RString("初期状態");

    /**
     * コンストラクタです。
     *
     * @param ninteidiv
     */
    public NinteiChosaScheduleHandler(NinteiChosaSchedulePanelDiv ninteidiv) {
        this.ninteidiv = ninteidiv;
    }

    /**
     * onLoad処理です。
     *
     */
    public void initialize() {

        状態_初期状態.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class));
        ninteidiv.getTxtSetteiYM().setValue(new FlexibleDate(RDate.getNowDate().toString()));
        List<ChikuShichosonBusiness> chikuList = SukejuruTourokuFinder.createInstance()
                .getChikuShichosonList().records();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (ChikuShichosonBusiness jigyoshaInput : chikuList) {
            dataSource.add(new KeyValueDataSource(jigyoshaInput.getChosaChikuCode().getKey(), jigyoshaInput.getChosaChikuCode().value()));
        }
        ninteidiv.getSearchConditionPanel().getDdlTaishoChiku().setDataSource(dataSource);
        List<dgNinteiChosaSchedule_Row> dgKoufuKaishuList = new ArrayList<>();
        ninteidiv.getDgNinteiChosaSchedule().setDataSource(dgKoufuKaishuList);

    }

    /**
     * 認定調査スケジュール登録1検索処理する。
     *
     */
    public void kennsaku() {
        List<dgNinteiChosaSchedule_Row> dgKoufuKaishuList = new ArrayList<>();
        if (ninteidiv.getSearchConditionPanel().getTxtSetteiYM().getValue() != null
                && !ninteidiv.getSearchConditionPanel().getTxtSetteiYM().getValue().isEmpty()
                && ninteidiv.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey() != null
                && !ninteidiv.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey().isEmpty()) {
            Seireki date2 = ninteidiv.getSearchConditionPanel().getTxtSetteiYM().getValue().seireki();
            FlexibleDate date = new FlexibleDate(Integer.parseInt(date2.getYear().toString()), Integer.parseInt(date2.getMonth().toString()), 1);
            NinteiChousaSukejuruParameter ninteiParameter = NinteiChousaSukejuruParameter.
                    createGamenParam(new RString(ninteidiv.getSearchConditionPanel().getTxtSetteiYM().getValue().toString()),
                            new RString(ninteidiv.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey().toString()),
                            new RString(date.toString()), new RString(date.plusMonth(1).minusDay(1).toString()));
            List<NinteichosaScheduleBusiness> ninteiList = SukejuruTourokuFinder.createInstance()
                    .getcheMapper(ninteiParameter).records();

            Map<RString, NinteichosaScheduleBusiness> data_map = new HashMap<>();
            if (ninteiList != null && !ninteiList.isEmpty()) {
                for (NinteichosaScheduleBusiness jigyoshaInput : ninteiList) {
                    data_map.put(jigyoshaInput.getメモ年月日().seireki().fillType(FillType.ZERO).toDateString(), jigyoshaInput);
                }
            }

            int dayCount = date.getLastDay();
            FlexibleDate dateIndex = date;
            for (int i = 0; i < dayCount; i++) {
                dgNinteiChosaSchedule_Row dgJigyoshaItiran = new dgNinteiChosaSchedule_Row();
                if (data_map.containsKey(dateIndex.seireki().fillType(FillType.ZERO).toDateString())) {
                    NinteichosaScheduleBusiness jigyoshaInput = data_map.get(dateIndex.seireki().fillType(FillType.ZERO).toDateString());
                    if (jigyoshaInput.getメモ年月日().getDayOfWeek() == DayOfWeek.SATURDAY) {
                        dgJigyoshaItiran.setRowBgColor(DataGridCellBgColor.bgColorGreen);
                    } else if (jigyoshaInput.getメモ年月日().getDayOfWeek() == DayOfWeek.SUNDAY
                            && (new RDate(jigyoshaInput.getメモ年月日().toString()).isNationalHoliday())) {
                        dgJigyoshaItiran.setRowBgColor(DataGridCellBgColor.bgColorRed);
                    }
                    if (jigyoshaInput.getメモ年月日() != null) {
                        dgJigyoshaItiran.setDate(new RString(jigyoshaInput.getメモ年月日().toString()));
                        dgJigyoshaItiran.setDay(new RString(jigyoshaInput.getメモ年月日().getDayOfWeek().getMiddleTerm()));
                    }
                    if (jigyoshaInput.get全午前件数() != 0) {
                        dgJigyoshaItiran.setAkiAM(new RString("○"));
                    }
                    dgJigyoshaItiran.setAkiAMCount(new RString(String.valueOf(jigyoshaInput.get全午前件数() - jigyoshaInput.get午前の仮予約件数() - jigyoshaInput.get午前の確定件数())));
                    if (jigyoshaInput.get全午後件数() != 0) {
                        dgJigyoshaItiran.setAkiPM(new RString("●"));
                    }
                    dgJigyoshaItiran.setAkiPMCount(new RString(String.valueOf(jigyoshaInput.get全午後件数())));
                    if (jigyoshaInput.get午前の仮予約件数() != 0) {
                        dgJigyoshaItiran.setKariYoyakuAM(new RString("△"));
                    }
                    dgJigyoshaItiran.setKariYoyakuAMCount(new RString(String.valueOf(jigyoshaInput.get午前の仮予約件数())));
                    if (jigyoshaInput.get午後の仮予約件数() != 0) {
                        dgJigyoshaItiran.setKariYoyakuPM(new RString("▲"));
                    }
                    dgJigyoshaItiran.setKariYoyakuPMCount(new RString(String.valueOf(jigyoshaInput.get午後の仮予約件数())));
                    if (jigyoshaInput.get午前の確定件数() != 0) {
                        dgJigyoshaItiran.setKakuteiAM(new RString("◇"));
                    }
                    dgJigyoshaItiran.setKakuteiAMCount(new RString(String.valueOf(jigyoshaInput.get午前の確定件数())));
                    if (jigyoshaInput.get午後の確定件数() != 0) {
                        dgJigyoshaItiran.setKakuteiPM(new RString("◆"));
                    }
                    dgJigyoshaItiran.setKakuteiPMCount(new RString(String.valueOf(jigyoshaInput.get午後の確定件数())));
                    if (jigyoshaInput.get通常メモ件数() != 0) {
                        dgJigyoshaItiran.setMemoNormal(new RString("◎"));
                    }
                    dgJigyoshaItiran.setMemoNormalCount(new RString(String.valueOf(jigyoshaInput.get通常メモ件数())));
                    if (jigyoshaInput.get重要メモ件数() != 0) {
                        dgJigyoshaItiran.setMemoImportant(new RString("◎"));
                    }
                    dgJigyoshaItiran.setMemoImportantCount(new RString(String.valueOf(jigyoshaInput.get重要メモ件数())));
                } else {
                    if (dateIndex.getDayOfWeek() == DayOfWeek.SATURDAY) {
                        dgJigyoshaItiran.setRowBgColor(DataGridCellBgColor.bgColorGreen);
                    }
                    if (dateIndex.getDayOfWeek() == DayOfWeek.SUNDAY) {
                        dgJigyoshaItiran.setRowBgColor(DataGridCellBgColor.bgColorRed);
                    }
                    if (new RDate(dateIndex.toString()).isNationalHoliday()) {
                        dgJigyoshaItiran.setRowBgColor(DataGridCellBgColor.bgColorRed);
                    }
                    dgJigyoshaItiran.setDate(new RString(dateIndex.toString()));
                    dgJigyoshaItiran.setDay(new RString(dateIndex.getDayOfWeek().getMiddleTerm()));
                }
                dateIndex = dateIndex.plusDay(1);
                dgKoufuKaishuList.add(dgJigyoshaItiran);
            }
            ninteidiv.getDgNinteiChosaSchedule().setDataSource(dgKoufuKaishuList);
        }
    }
}
