/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiKoseiShichoson;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiNinteichosa;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chikuninteichosain.ChosainJohoParameter;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.chikuninteichosainmapper.ChosainJohoFander;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 *
 * @author 863
 */
public class NinteiChosaScheduleShosaiHander {

    private final NinteiChosaScheduleShosaiDiv div;
    public static RString Temp_遷移元画面番号 = new RString("1");
    public static FlexibleDate Temp_設定日 = new FlexibleDate("20121212");
    public static Code Temp_地区コード = new Code("");
    public static Code Temp_地区コード1 = new Code("");
    public static Code Temp_地区コード3 = new Code("");
    public static Code Temp_地区コード10 = new Code("");
    public static RString Temp_画面番号 = new RString("2");
    public static ShinseishoKanriNo Temp_申請書管理番号2 = new ShinseishoKanriNo("");
    public static RString Temp_申請書管理番号3 = new RString("");
    public static RString Temp_対象者区分 = new RString("");
    public static LasdecCode Temp_保険者 = new LasdecCode("");
    public static boolean Temp_調査員状況02 = true;
    public static RString Temp_認定調査委託先コード = new RString("");
    public static RString Temp_時間枠 = new RString("");
    public static RString Temp_認定調査員コード = new RString("");
    public static RString Temp_画面ステート = new RString("1");
    public static boolean GRIDFLG = false;
    public static boolean ボタン活性 = true;
    public static boolean ボタン非活性 = false;

    public NinteiChosaScheduleShosaiHander(NinteiChosaScheduleShosaiDiv div) {
        this.div = div;
    }

    public void onLoad(
            int 通常件数,
            int 重要件数,
            List<UzT0007CodeEntity> 対象地区List,
            RString 遷移元画面番号,
            List<ChikuNinteiChosain> 認定調査スケジュールList) {
        div.getTxtSetteiDate().setValue(Temp_設定日);
        if (通常件数 > 0) {
            div.getTxtTsujoMemo().setValue(new RString("通常あり"));
        }
        if (重要件数 > 0) {
            div.getTxtJuyoMemo().setValue(new RString("重要あり"));
        }
        set対象地区DDL(対象地区List, Temp_地区コード);
        div.getRadChosainJokyo().setSelectedKey(new RString("0"));
        div.getDgNinteiChosaSchedule().setVisible(GRIDFLG);
        div.getBtnKensaku().setDisabled(ボタン活性);
//            Temp_設定日.getYearMonth().;
        div.getBtnSetteiDateToJijitsu().setDisabled(ボタン活性);
        div.getBtnSetteiDateToZenjitsu().setDisabled(ボタン活性);
//        if ("10".equals(遷移元画面番号)) {
//            set認定調査スケジュール詳細情報(認定調査スケジュールList);
//        }
    }

    public void onselect_保険者名称取得(
            List<ChikuNinteiKoseiShichoson> 保険者List,
            int 通常件数,
            int 重要件数) {
        set保険者DDL(保険者List);
        if (通常件数 > 0) {
            div.getTxtTsujoMemo().setValue(new RString("通常あり"));
        }
        if (重要件数 > 0) {
            div.getTxtJuyoMemo().setValue(new RString("重要あり"));
        }
    }

    public void onSelect前日() {
    }

    public void onSelect次日() {
    }

    public void onclick編集() {
        Temp_地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        Temp_保険者 = new LasdecCode(div.getDdlHokensha().getSelectedKey());
        Temp_認定調査委託先コード = div.getDdlninteiChosaItakusaki().getSelectedKey();
        dgNinteiChosaSchedule_Row row = div.getDgNinteiChosaSchedule().getActiveRow();
        RString 認定調査員コード = row.getNinteiChosainCode();
        row.getNinteiChosainName();
        Temp_設定日 = div.getSearchNinteiChosaSchedule().getTxtSetteiDate().getValue();
//        div.getNchosainScheduleIchiran()
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_申請書管理番号(Temp_地区コード, Temp_保険者, Temp_認定調査委託先コード, 認定調査員コード, Temp_設定日, Temp_遷移元画面番号, Temp_遷移元画面番号, Temp_地区コード);
        NinteichosaSchedule 申請書管理番号 = ChosainJohoFander.createInstance().get申請書管理番号(parameter);
        if (申請書管理番号 == null) {
            Temp_申請書管理番号2 = new ShinseishoKanriNo("");
        } else {
            Temp_申請書管理番号2 = 申請書管理番号.getTemp_申請書管理番号2();
        }
    }

    public void set認定調査スケジュール詳細情報(List<ChikuNinteiChosain> list) {
        List<dgNinteiChosaSchedule_Row> rowlist = new ArrayList<>();
        for (ChikuNinteiChosain guide : list) {
            dgNinteiChosaSchedule_Row row = new dgNinteiChosaSchedule_Row();
            row.setNinteiChosainCode(guide.get認定調査員コード());
            row.setNinteiChosainName(guide.get認定調査員氏名());
            switch (guide.get認定調査時間枠数().toString()) {
//                case "1":
//                    if ("1".equals(guide.get認定調査時間枠数())) {
//                        row.setChosaTimeFrame1(new RString(guide.get認定調査予定開始時間() + "-" + guide.get認定調査予定終了時間()));
//                        row.getChosaTimeFrameMemo1().setDisabled(false);
//                    }
//                case "2":
//                    if ("2".equals(guide.get認定調査時間枠数())) {
//                        row.setChosaTimeFrame2(new RString(guide.get認定調査予定開始時間() + "-" + guide.get認定調査予定終了時間()));
//                        row.getChosaTimeFrameMemo2().setDisabled(false);
//                    }
//                case "3":
//                    if ("3".equals(guide.get認定調査時間枠数())) {
//                        row.setChosaTimeFrame3(new RString(guide.get認定調査予定開始時間() + "-" + guide.get認定調査予定終了時間()));
//                        row.getChosaTimeFrameMemo3().setDisabled(false);
//                    }
//                case "4":
//                    if ("4".equals(guide.get認定調査時間枠数())) {
//                        row.setChosaTimeFrame4(new RString(guide.get認定調査予定開始時間() + "-" + guide.get認定調査予定終了時間()));
//                        row.getChosaTimeFrameMemo4().setDisabled(false);
//                    }
//                case "5":
//                    if ("5".equals(guide.get認定調査時間枠数())) {
//                        row.setChosaTimeFrame5(new RString(guide.get認定調査予定開始時間() + "-" + guide.get認定調査予定終了時間()));
//                        row.getChosaTimeFrameMemo5().setDisabled(false);
//                    }
//                case "6":
//                    if ("6".equals(guide.get認定調査時間枠数())) {
//                        row.setChosaTimeFrame6(new RString(guide.get認定調査予定開始時間() + "-" + guide.get認定調査予定終了時間()));
//                        row.getChosaTimeFrameMemo6().setDisabled(false);
//                    }
//                case "7":
//                    if ("7".equals(guide.get認定調査時間枠数())) {
//                        row.getChosaTimeFrameMemo7().setDisabled(false);
//                        row.setChosaTimeFrame7(new RString(guide.get認定調査予定開始時間() + "-" + guide.get認定調査予定終了時間()));
//                    }
//                case "8":
//                    if ("8".equals(guide.get認定調査時間枠数())) {
//                        row.setChosaTimeFrame8(new RString(guide.get認定調査予定開始時間() + "-" + guide.get認定調査予定終了時間()));
//                        row.getChosaTimeFrameMemo8().setDisabled(false);
//                    }
//                case "9":
//                    if ("9".equals(guide.get認定調査時間枠数())) {
//                        row.setChosaTimeFrame9(new RString(guide.get認定調査予定開始時間() + "-" + guide.get認定調査予定終了時間()));
//                        row.getChosaTimeFrameMemo9().setDisabled(false);
//                    }
//                case "10":
//                    if ("10".equals(guide.get認定調査時間枠数())) {
//                        row.setChosaTimeFrame10(new RString(guide.get認定調査予定開始時間() + "-" + guide.get認定調査予定終了時間()));
//                        row.getChosaTimeFrameMemo10().setDisabled(false);
//                    }
                default:
                    break;
            }
            rowlist.add(row);
        }
        div.getDgNinteiChosaSchedule().setDataSource(rowlist);
    }

    public List<UzT0007CodeEntity> get対象地区List() {
        return CodeMaster.getCode(new CodeShubetsu("5002"));
    }

    public void set対象地区DDL(List<UzT0007CodeEntity> list, Code 地区コード) {
        List<KeyValueDataSource> dataList = new ArrayList<>();
        for (UzT0007CodeEntity entity : list) {
            KeyValueDataSource DataSource = new KeyValueDataSource();
            DataSource.setKey(entity.getコード().value());
            DataSource.setValue(entity.getコード名称());
            dataList.add(DataSource);
        }
        div.getDdlTaishoChiku().setDataSource(dataList);
        div.getDdlTaishoChiku().setSelectedKey(地区コード.value());
    }

    public void set保険者DDL(List<ChikuNinteiKoseiShichoson> 保険者List) {
        List<KeyValueDataSource> dataList = new ArrayList<>();
        for (ChikuNinteiKoseiShichoson entity : 保険者List) {
            KeyValueDataSource DataSource = new KeyValueDataSource();
            DataSource.setKey(entity.get市町村コード().value());
            DataSource.setValue(entity.get市町村名称());
            dataList.add(DataSource);
        }
        div.getDdlHokensha().setDataSource(dataList);
    }

    public void set認定調査委託先DDL(List<ChikuNinteiNinteichosa> 認定調査委託先名List) {
        List<KeyValueDataSource> dataList = new ArrayList<>();
        for (ChikuNinteiNinteichosa entity : 認定調査委託先名List) {
            KeyValueDataSource DataSource = new KeyValueDataSource();
            DataSource.setKey(entity.get認定調査委託先コード());
            DataSource.setValue(entity.get認定調査委託先名称());
            dataList.add(DataSource);
        }
        div.getDdlTaishoChiku().setDataSource(dataList);
    }
}
