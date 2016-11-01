/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180060.DBC180060_KenkoKaruteRenkeiDataSakuseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180065.DBC180065_KenkoKaruteRenkeiDataSakuseiControlParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180070.DBC180070_KenkoKaruteRenkeiDataSakuseiKoikiParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 健康かるて連携データ作成のバッチ定義クラスです。
 *
 * @reamsid_L DBC-5020-030 wangxiaodong
 */
public class DBC180065_KenkoKaruteRenkeiDataSakuseiControl extends BatchFlowBase<DBC180065_KenkoKaruteRenkeiDataSakuseiControlParameter> {

    private static final RString その他広域 = new RString("0");
    private static final String 健康かるて連携データ作成 = "KenkoKaruteRenkeiDataSakusei";
    private static final String 健康かるて連携データ作成_広域用 = "KenkoKaruteRenkeiDataSakuseiKoiki";
    private static final RString FLOWID_健康かるて連携データ作成 = new RString("DBC180060_KenkoKaruteRenkeiDataSakusei");
    private static final RString FLOWID_健康かるて連携データ作成_広域用 = new RString("DBC180070_KenkoKaruteRenkeiDataSakuseiKoiki");

    @Override
    protected void defineFlow() {
        if (その他広域.equals(DbBusinessConfig.get(ConfigNameDBU.保険者情報_広域タイプ, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            executeStep(健康かるて連携データ作成);
        } else {
            executeStep(健康かるて連携データ作成_広域用);
        }
    }

    /**
     * 健康かるて連携データを作成します。
     *
     * @return バッチコマンド
     */
    @Step(健康かるて連携データ作成)
    IBatchFlowCommand exeKenkoKaruteRenkeiDataSakusei() {
        DBC180060_KenkoKaruteRenkeiDataSakuseiParameter parameter = new DBC180060_KenkoKaruteRenkeiDataSakuseiParameter();
        return otherBatchFlow(FLOWID_健康かるて連携データ作成, SubGyomuCode.DBC介護給付, parameter).define();
    }

    /**
     * 健康かるて連携データを作成します。
     *
     * @return バッチコマンド
     */
    @Step(健康かるて連携データ作成_広域用)
    IBatchFlowCommand exeKenkoKaruteRenkeiDataSakuseiKoiki() {
        DBC180070_KenkoKaruteRenkeiDataSakuseiKoikiParameter parameter = new DBC180070_KenkoKaruteRenkeiDataSakuseiKoikiParameter();
        return otherBatchFlow(FLOWID_健康かるて連携データ作成_広域用, SubGyomuCode.DBC介護給付, parameter).define();
    }

}
