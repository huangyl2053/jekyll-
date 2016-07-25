/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiDBUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタ更新のプロセスクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class ShoriDateKanriUpdateProcess extends BatchProcessBase<UeT0511NenkinTokuchoKaifuJohoEntity> {

    private static final int NUM2 = 2;
    private static final int NUM4 = 4;
    private static final int NUM6 = 6;
    private static final int NUM8 = 8;
    private static final int NUM10 = 10;
    private static final int NUM12 = 12;
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic."
            + "IUeT0511NenkinTokuchoKaifuJohoMapper.selectAllNoDeleted");
    private static final RString 年度内年番_0001 = new RString("0001");
    private static final RString 年度内年番_0002 = new RString("0002");
    private static final RString 年度内年番_0003 = new RString("0003");
    private static final RString 年度内年番_0004 = new RString("0004");
    private static final RString 年度内年番_0005 = new RString("0005");
    private static final RString 年度内年番_0006 = new RString("0006");
    private TokuchoSeidokanIFSakuseiDBUpdateProcessParameter parameter;
    private RDateTime システム日時;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        システム日時 = parameter.getシステム日時();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void process(UeT0511NenkinTokuchoKaifuJohoEntity entity) {
    }

    @Override
    protected void afterExecute() {
        updateShoriDateKanriTable();
    }

    private void updateShoriDateKanriTable() {
        if (parameter.get特別徴収開始年月() == null) {
            return;
        }
        RString 年度内連番;
        switch (parameter.get特別徴収開始年月().getMonthValue()) {
            case NUM8:
                年度内連番 = 年度内年番_0001;
                break;
            case NUM10:
                年度内連番 = 年度内年番_0002;
                break;
            case NUM12:
                年度内連番 = 年度内年番_0003;
                break;
            case NUM2:
                年度内連番 = 年度内年番_0004;
                break;
            case NUM4:
                年度内連番 = 年度内年番_0005;
                break;
            case NUM6:
                年度内連番 = 年度内年番_0006;
                break;
            default:
                年度内連番 = null;
        }
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        RString 処理名 = ShoriName.特別徴収制度間ＩＦ作成.get名称();
        manager.update基準日時(処理名, 年度内連番, parameter.get処理年度(), new YMDHMS(システム日時));
    }

}
