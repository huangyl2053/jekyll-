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
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChosaChiku;
import jp.co.ndensan.reams.db.dbe.business.core.chikushichoson.ChikuShichosonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaschedule.NinteichosaScheduleBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020001.NinteiChosaSchedulePanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020001.dgNinteiChosaSchedule_Row;
import jp.co.ndensan.reams.db.dbe.service.core.basic.sukejurutouroku.SukejuruTourokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.DayOfWeek;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Seireki;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 認定調査スケジュール登録1の取得処理。
 *
 * @reamsid_L DBE-0020-010 lizhuoxuan
 */
public class NinteiChosaScheduleHandler {

    private final NinteiChosaSchedulePanelDiv ninteidiv;

    /**
     * コンストラクタです。
     *
     * @param ninteidiv NinteiChosaSchedulePanelDiv
     */
    public NinteiChosaScheduleHandler(NinteiChosaSchedulePanelDiv ninteidiv) {
        this.ninteidiv = ninteidiv;
    }

    /**
     * onLoad処理です。
     *
     */
    public void initialize() {
        ninteidiv.getTxtSetteiYM().setValue(new FlexibleDate(RDate.getNowDate().toString()));
        List<ChikuShichosonBusiness> chikuList = SukejuruTourokuFinder.createInstance()
                .getChikuShichosonList().records();
        List<ChosaChiku> list = get対象地区List(chikuList);
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (ChosaChiku chosaChiku : list) {
            dataSource.add(new KeyValueDataSource(chosaChiku.get調査地区コード(), chosaChiku.get調査地区名称()));
        }
        ninteidiv.getSearchConditionPanel().getDdlTaishoChiku().setDataSource(dataSource);
        List<dgNinteiChosaSchedule_Row> dgKoufuKaishuList = new ArrayList<>();
        ninteidiv.getDgNinteiChosaSchedule().setDataSource(dgKoufuKaishuList);
    }

    private List<ChosaChiku> get対象地区List(List<ChikuShichosonBusiness> chikuList) {
        List<ChosaChiku> list = new ArrayList<>();
        for (ChikuShichosonBusiness chikuShichosonBusiness : chikuList) {
            RString 調査地区名称 = CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                    DBECodeShubetsu.調査地区コード.getコード(), chikuShichosonBusiness.getChosaChikuCode(), FlexibleDate.getNowDate());
            ChosaChiku chiku = new ChosaChiku();
            if (!RString.isNullOrEmpty(調査地区名称)) {
                chiku.set調査地区名称(調査地区名称);
                chiku.set調査地区コード(chikuShichosonBusiness.getChosaChikuCode().getColumnValue());
                list.add(chiku);
            } else {
                throw new ApplicationException(UrErrorMessages.コードマスタなし.getMessage());
            }
        }
        return list;
    }

    /**
     * 認定調査スケジュール登録1検索処理する。
     *
     * @param ninteiList List<NinteichosaScheduleBusiness>
     */
    public void kennsaku(List<NinteichosaScheduleBusiness> ninteiList) {
        List<dgNinteiChosaSchedule_Row> dgKoufuKaishuList = new ArrayList<>();
        Seireki date2 = ninteidiv.getSearchConditionPanel().getTxtSetteiYM().getValue().seireki();
        FlexibleDate date = new FlexibleDate(Integer.parseInt(date2.getYear().toString()), Integer.parseInt(date2.getMonth().toString()), 1);
        Map<RString, NinteichosaScheduleBusiness> data_map = new HashMap<>();
        for (NinteichosaScheduleBusiness jigyoshaInput : ninteiList) {
            if (jigyoshaInput.getメモ年月日() != null) {
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
                    dgJigyoshaItiran.setRowBgColor(DataGridCellBgColor.bgColorLightGreen);
                } else if (jigyoshaInput.getメモ年月日().getDayOfWeek() == DayOfWeek.SUNDAY
                           && (new RDate(jigyoshaInput.getメモ年月日().toString()).isNationalHoliday())) {
                    dgJigyoshaItiran.setRowBgColor(DataGridCellBgColor.bgColorLightRed);
                }
                if (jigyoshaInput.getメモ年月日() != null) {
                    dgJigyoshaItiran.getDate().setValue(new RDate(jigyoshaInput.getメモ年月日().toString()));
                    dgJigyoshaItiran.setDay(new RString(jigyoshaInput.getメモ年月日().getDayOfWeek().getMiddleTerm()));
                }
                if (jigyoshaInput.get全午前件数() != 0) {
                    dgJigyoshaItiran.setAkiAM(new RString("○"));
                }
                dgJigyoshaItiran.setAkiAMCount(new RString(String.valueOf(jigyoshaInput.get全午前件数() - jigyoshaInput.get午前の仮予約件数()
                                                                          - jigyoshaInput.get午前の確定件数())));
                if (jigyoshaInput.get全午後件数() != 0) {
                    dgJigyoshaItiran.setAkiPM(new RString("●"));
                }
                dgJigyoshaItiran.setAkiPMCount(new RString(String.valueOf(jigyoshaInput.get全午後件数() - jigyoshaInput.get午後の仮予約件数()
                                                                          - jigyoshaInput.get午後の確定件数())));
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
                hiduke(dgJigyoshaItiran, dateIndex);
                dgJigyoshaItiran.getDate().setValue(new RDate(dateIndex.toString()));
                dgJigyoshaItiran.setDay(new RString(dateIndex.getDayOfWeek().getMiddleTerm()));
            }
            dateIndex = dateIndex.plusDay(1);
            dgKoufuKaishuList.add(dgJigyoshaItiran);
        }
        ninteidiv.getDgNinteiChosaSchedule().setDataSource(dgKoufuKaishuList);
    }

    private void hiduke(dgNinteiChosaSchedule_Row dgJigyoshaItiran, FlexibleDate dateIndex) {
        if (dateIndex.getDayOfWeek() == DayOfWeek.SATURDAY) {
            dgJigyoshaItiran.setRowBgColor(DataGridCellBgColor.bgColorLightGreen);
        }
        if (dateIndex.getDayOfWeek() == DayOfWeek.SUNDAY) {
            dgJigyoshaItiran.setRowBgColor(DataGridCellBgColor.bgColorLightRed);
        }
        if (new RDate(dateIndex.toString()).isNationalHoliday()) {
            dgJigyoshaItiran.setRowBgColor(DataGridCellBgColor.bgColorLightRed);
        }
    }

    /**
     * check_btnKakuninn
     *
     * @param ninteidiv NinteiChosaSchedulePanelDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_btnKakuninn(NinteiChosaSchedulePanelDiv ninteidiv) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        getValidationHandler(ninteidiv).一覧データなしチェック(validationMessages);
        return validationMessages;
    }

    private ValidationHandler getValidationHandler(NinteiChosaSchedulePanelDiv ninteidiv) {
        return new ValidationHandler(ninteidiv);
    }
}
