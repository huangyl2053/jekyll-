/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb112001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.shutokujohoshuchutsurenkei.ShutokuJohoShuchutsuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 所得情報抽出・連携バッチの業務コンフィグの更新Processです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public class ConfigUpdateProcess extends SimpleBatchProcessBase {

    private static final RString 当初_広域_1 = new RString("1");
    private static final RString 当初_単一_3 = new RString("3");

    private RString 日付関連_調定年度;
    private ShutokuJohoShuchutsuRenkeiProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        日付関連_調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
    }

    @Override
    protected void process() {
        if (当初_広域_1.equals(processParameter.get処理区分()) || 当初_単一_3.equals(processParameter.get処理区分())) {
            BusinessConfig.update(SubGyomuCode.DBB介護賦課,
                    ConfigNameDBB.日付関連_所得年度, 日付関連_調定年度, RString.EMPTY, RString.EMPTY, RDate.getNowDate());
        }
    }
}
