/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001.GennendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.gennendohonsanteiidou.GenNendoHonsanteiIdou;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「処理日付管理テーブル更新」処理クラスです。
 *
 * @reamsid_L DBB-0930-010 yuanzhenxia
 */
public class SystemTimeUpdateProcess extends SimpleBatchProcessBase {

    private GenNendoHonsanteiIdou business;
    private GennendoIdoFukaProcessParameter processParameter;
    private final RString 枝番0001 = new RString("0001");
    private final RString 枝番0004 = new RString("0004");
    private final RString 枝番0005 = new RString("0005");
    private final RString 枝番0006 = new RString("0006");

    @Override
    protected void beforeExecute() {
        business = GenNendoHonsanteiIdou.createInstance();
    }

    @Override
    protected void process() {
        RString 処理名 = new RString(ShoriName.依頼金額計算.toString());
        RString 処理枝番 = 枝番0001;
        RString 年度内連番 = 枝番0001;
        FlexibleYear 年度 = processParameter.get調定年度();
        YMDHMS システム日時 = new YMDHMS(processParameter.get調定日時());
        business.insert処理日付管理(processParameter, システム日時, 処理枝番, 年度内連番);
        年度内連番 = 枝番0004;
        business.update処理日付管理(処理名, 処理枝番, 年度, 年度内連番, システム日時);
        年度内連番 = 枝番0005;
        business.update処理日付管理(処理名, 処理枝番, 年度, 年度内連番, システム日時);
        年度内連番 = 枝番0006;
        business.update処理日付管理(処理名, 処理枝番, 年度, 年度内連番, システム日時);
    }
}
