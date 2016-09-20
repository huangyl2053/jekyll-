/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB231001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei.UpdateShorikanriMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiDBUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakusei.ITokuChoSoufuJohoSakuseiMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタ更新のプロセスクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class UpdShoriDateKanriProcess extends SimpleBatchProcessBase {

    private static final int NUM2 = 2;
    private static final int NUM4 = 4;
    private static final int NUM6 = 6;
    private static final int NUM8 = 8;
    private static final int NUM10 = 10;
    private static final int NUM12 = 12;
    private static final RString 年度内年番_0001 = new RString("0001");
    private static final RString 年度内年番_0002 = new RString("0002");
    private static final RString 年度内年番_0003 = new RString("0003");
    private static final RString 年度内年番_0004 = new RString("0004");
    private static final RString 年度内年番_0005 = new RString("0005");
    private static final RString 年度内年番_0006 = new RString("0006");
    private final RString 日付_FORMAT = new RString("yyyyMMddHHmmss");
    private TokuchoSeidokanIFSakuseiDBUpdateProcessParameter parameter;
    private UpdateShorikanriMyBatisParameter myBatisParam;

    @Override
    protected void process() {
        updateShoriDateKanriJunbi();
        getMapper(ITokuChoSoufuJohoSakuseiMapper.class).updateShoriDateKanri(myBatisParam);
    }

    private void updateShoriDateKanriJunbi() {
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
        RString 処理名 = ShoriName.特別徴収制度間ＩＦ作成.get名称();
        RString 処理年度 = parameter.get処理年度() == null ? RString.EMPTY : parameter.get処理年度().toDateString();
        RDateTime lastUpdateTimestamp = RDateTime.now();
        RString 起動時処理日時 = parameter.getシステム日時().format西暦(日付_FORMAT.toString());
        myBatisParam
                = new UpdateShorikanriMyBatisParameter(処理名, 処理年度, 年度内連番, lastUpdateTimestamp, 起動時処理日時);
    }

}
