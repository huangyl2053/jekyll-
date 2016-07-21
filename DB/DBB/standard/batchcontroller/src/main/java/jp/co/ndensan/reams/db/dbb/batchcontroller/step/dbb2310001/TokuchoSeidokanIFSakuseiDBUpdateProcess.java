/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiDBUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.tokuchosoufujohosakuseibatch.TokuChoSoufuJohoSakuseiBatch;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT1704KaigoTokuchoTorikomiRirekiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
public class TokuchoSeidokanIFSakuseiDBUpdateProcess extends BatchProcessBase<UeT0511NenkinTokuchoKaifuJohoEntity> {

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
    private static final RString T_特徴回付情報TMP = new RString("NenkinTokuchoKaifuJohoTemp");
    private static final RString T_対象者情報追加TMP = new RString("KaigohokenNenkinTokuchoTaishoshaJohoTemp");
    private TokuchoSeidokanIFSakuseiDBUpdateProcessParameter parameter;
    private RDateTime システム日時;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 特徴回付情報Temp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 対象者情報追加Temp;
    @BatchWriter
    BatchPermanentTableWriter<UeT1704KaigoTokuchoTorikomiRirekiEntity> ueT1704Writer;
    @BatchWriter
    BatchPermanentTableWriter<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> ueT0515Writer;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        システム日時 = RDateTime.now();
    }

    @Override
    protected void process(UeT0511NenkinTokuchoKaifuJohoEntity entity) {
    }

    @Override
    protected void createWriter() {
        特徴回付情報Temp = new BatchEntityCreatedTempTableWriter(T_特徴回付情報TMP,
                UeT0511NenkinTokuchoKaifuJohoEntity.class);
        対象者情報追加Temp = new BatchEntityCreatedTempTableWriter(T_対象者情報追加TMP,
                UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity.class);
        ueT1704Writer = new BatchPermanentTableWriter(UeT1704KaigoTokuchoTorikomiRirekiEntity.class);
        ueT0515Writer = new BatchPermanentTableWriter(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity.class);
    }

    @Override
    protected void afterExecute() {
        TokuChoSoufuJohoSakuseiBatch sakuseiBatch = TokuChoSoufuJohoSakuseiBatch.createInstance();
        List<UeT0511NenkinTokuchoKaifuJohoEntity> uet0511Entitys = sakuseiBatch.selectNenkinTokuChoKaifuJoho(
                parameter.get処理年度(), parameter.get特別徴収開始年月(), parameter.get遷移元メニュー());
        for (UeT0511NenkinTokuchoKaifuJohoEntity entity : uet0511Entitys) {
            特徴回付情報Temp.insert(entity);
        }
        UeT1704KaigoTokuchoTorikomiRirekiEntity uet1704Entity = sakuseiBatch.intTokuChoJohoTorikomiRireki(
                parameter.get処理年度(), parameter.get特別徴収開始年月(), parameter.get遷移元メニュー(), システム日時);
        ueT1704Writer.insert(uet1704Entity);
        List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> uet0515Entitys = sakuseiBatch.setTuikaData(
                parameter.get処理年度(), parameter.get特別徴収開始年月(), システム日時);
        for (UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity entity : uet0515Entitys) {
            対象者情報追加Temp.insert(entity);
        }
        List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> uet0515EntityList = sakuseiBatch.intNenkinTokuChoTaishosyaJoho();
        if (uet0515EntityList != null && !uet0515EntityList.isEmpty()) {
            for (UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity entity : uet0515EntityList) {
                ueT0515Writer.insert(entity);
            }
        }
        updateDB();
    }

    private void updateDB() {
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

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }
}
