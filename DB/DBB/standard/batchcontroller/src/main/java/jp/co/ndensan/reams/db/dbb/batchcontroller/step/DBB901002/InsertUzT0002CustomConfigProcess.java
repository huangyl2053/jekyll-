/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB901002;

import jp.co.ndensan.reams.db.dbb.definition.processprm.nendokirikae.NendoKirikaeProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 業務コンフィグ年度切替processのクラスです。
 *
 * @reamsid_L DBB-5722-030 xuhao
 */
public class InsertUzT0002CustomConfigProcess extends SimpleBatchProcessBase {

    private NendoKirikaeProcessParameter processParameter;
    private static final int INT_1 = 1;

    @Override
    protected void process() {
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.日付関連_調定年度,
                processParameter.get調定年度().plusYear(INT_1).toDateString(), RString.EMPTY, RString.EMPTY, RDate.getNowDate());
    }
}
