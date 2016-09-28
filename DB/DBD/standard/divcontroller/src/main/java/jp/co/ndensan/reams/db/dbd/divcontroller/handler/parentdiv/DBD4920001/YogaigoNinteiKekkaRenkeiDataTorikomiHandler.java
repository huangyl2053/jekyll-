/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4920001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001.YogaigoNinteiKekkaRenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbd.service.core.yogaigoninteikekkarenkeidatatorikomi.YogaigoNinteiKekkaRenkeiDataTorikomiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請連携データ取込のHandlerクラスです。
 *
 * @reamsid_L DBE_1510-010 miaojin
 */
public class YogaigoNinteiKekkaRenkeiDataTorikomiHandler {

    private final YogaigoNinteiKekkaRenkeiDataTorikomiDiv div;
    private final RDate 基準日 = RDate.getNowDate();
    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
//    private static final RString なし = new RString("0");
//    private static final RString あり = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div div
     */
    public YogaigoNinteiKekkaRenkeiDataTorikomiHandler(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
        this.div = div;
    }

    /**
     * 初期化の設定します。
     *
     */
    public void onLoad() {
        div.getYogaigoNinteiKekkaRenkeiDataTorikomiBatchParameter().getHokenshaList().loadHokenshaList();
        List<FlexibleDate> 法改正施行年月日 = YogaigoNinteiKekkaRenkeiDataTorikomiFinder.createInstance().get法改正施行年月日();
        if (!法改正施行年月日.isEmpty()) {
            if (法改正施行年月日.get(0).isBeforeOrEquals(FlexibleDate.getNowDate())) {
                div.getYogaigoNinteiKekkaRenkeiDataTorikomiBatchParameter().getRadIfType().setSelectedKey(KEY0);
            } else {
                div.getYogaigoNinteiKekkaRenkeiDataTorikomiBatchParameter().getRadIfType().setSelectedKey(KEY1);
            }
        }
        RString 連携の設定値 = DbBusinessConfig.get(ConfigNameDBE.日次進捗データ連携, 基準日, SubGyomuCode.DBE認定支援);
        if (連携の設定値.equals(KEY1)) {
            set手動読込初期化状態();
        } else if (連携の設定値.equals(KEY2)) {
            set自動読込初期化状態();
        }
    }

    private void set手動読込初期化状態() {

    }

    private void set自動読込初期化状態() {
//        RString 要介護認定Z8NCI242 = DbBusinessConfig.get(ConfigNameDBE.要介護認定結果連携データ送信ファイル名_新, 基準日, SubGyomuCode.DBE認定支援);
//        RString 要介護認定Z7NCI242 = DbBusinessConfig.get(ConfigNameDBE.要介護認定結果連携データ送信ファイル名_旧, 基準日, SubGyomuCode.DBE認定支援);
//        RString 取込みデータKey = div.getYogaigoNinteiKekkaRenkeiDataTorikomiBatchParameter().getRadDataSelect().getSelectedKey();
//        if (取込みデータKey.equals(new RString("key0"))) {
//            RString 日次進捗Z8NCI242 = DbBusinessConfig.get(ConfigNameDBE.日次進捗データ送信ファイル名_新, 基準日, SubGyomuCode.DBE認定支援);
//            RString 日次進捗Z7NCI242 = DbBusinessConfig.get(ConfigNameDBE.日次進捗データ送信ファイル名_旧, 基準日, SubGyomuCode.DBE認定支援);
//            div.getDataGridFile().setDataSource()
//        }
    }

//    private void getFileCount(RString path, RString ファイル, DataGridFile_Row row) {
//        RStringBuilder builder = new RStringBuilder();
//        builder.append(path).append(File.separator).append(ファイル);
//        File file = new File(builder.toString());
//        if (file.exists()) {
//            row.setTotal(あり);
//        } else {
//            row.setTotal(なし);
//        }
//    }
//    private DataGridFile_Row setRowFile(RString path, RString フォーマット, RString 名称, RString ファイル名) {
//        DataGridFile_Row row = new DataGridFile_Row();
//        row.setSelected(Boolean.TRUE);
//        row.setFileFormat(フォーマット);
//        row.setMeisho(名称);
//        row.setFileName(ファイル名);
//        getFileCount(path, ファイル名, row);
//        return row;
//    }
}
