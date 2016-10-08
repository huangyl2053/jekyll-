/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsKihonTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanrenrakuhyoout.ShokanRenrakuhyoOutManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の償還払請求基本情報取得processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutInsKihonTempProcess extends BatchProcessBase<InsKihonTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get償還払請求基本情報データ");
    private static final RString 一時TABLE_NAME = new RString("DbWT2112ShokanMeisai");
    private static final RString データ区分_01 = new RString("01");
    private static final RString 連番_0 = new RString("0");

    private ShokanRenrakuhyoOutProcessParameter parameter;
    private ShokanRenrakuhyoOutManager manager;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 一時tableWriter;

    @Override
    protected void initialize() {
        manager = ShokanRenrakuhyoOutManager.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_PATH, parameter.toSofuMeisaiParameter());
    }

    @Override
    protected void createWriter() {
        一時tableWriter = new BatchEntityCreatedTempTableWriter(一時TABLE_NAME, DbWT2112ShokanMeisaiTempEntity.class);
    }

    @Override
    protected void process(InsKihonTempEntity entity) {
        一時tableWriter.insert(getTempEntity(entity));
    }

    private DbWT2112ShokanMeisaiTempEntity getTempEntity(InsKihonTempEntity entity) {
        DbWT2112ShokanMeisaiTempEntity tempEntity = new DbWT2112ShokanMeisaiTempEntity();
        tempEntity.setHiHokenshaNo(entity.get償還払支給申請一時Entity().getHiHokenshaNo());
        tempEntity.setServiceTeikyoYM(entity.get償還払支給申請一時Entity().getServiceTeikyoYM());
        tempEntity.setSeiriNo(entity.get償還払支給申請一時Entity().getSeiriNo());
        tempEntity.setDataKubun(データ区分_01);
        tempEntity.setJigyoshaNo(entity.get基本Entity().getJigyoshaNo());
        tempEntity.setYoshikiNo(entity.get基本Entity().getYoshikiNo());
        tempEntity.setMeisaiNo(entity.get基本Entity().getMeisaiNo());
        tempEntity.setRenban(連番_0);
        manager.set償還払支給申請一時情報(tempEntity, entity.get償還払支給申請一時Entity());
        manager.set被保険者一時情報(tempEntity, entity.get被保険者一時Entity());
        tempEntity.setKyuSochiNyushoshaTokureiCode(entity.get基本Entity().getKyuSochiNyushoshaTokureiCode());
        tempEntity.setKyotakuServiceSakuseiKubunCode(entity.get基本Entity().getKyotakuServiceSakuseiKubunCode());
        tempEntity.setKyotakuserviceJigyoshaNo(entity.get基本Entity().getKyotakuserviceJigyoshaNo());
        tempEntity.setKaishiYMD(entity.get基本Entity().getKaishiYMD());
        tempEntity.setChushiYMD(entity.get基本Entity().getChushiYMD());
        tempEntity.setChushiRiyuNyushomaeJyokyoCode(entity.get基本Entity().getChushiRiyuNyushomaeJyokyoCode());
        tempEntity.setNyushoYMD(entity.get基本Entity().getNyushoYMD());
        tempEntity.setTaishoYMD(entity.get基本Entity().getTaishoYMD());
        tempEntity.setNyushoJitsuNissu(entity.get基本Entity().getNyushoJitsuNissu());
        tempEntity.setGaihakuNissu(entity.get基本Entity().getGaihakuNissu());
        tempEntity.setTaishogoJotaiCode(entity.get基本Entity().getTaishogoJotaiCode());
        tempEntity.setHokenKyufuritsu(entity.get基本Entity().getHokenKyufuritsu());
        tempEntity.setServiceTanisu(entity.get基本Entity().getServiceTanisu());
        tempEntity.setHokenSeikyugaku(entity.get基本Entity().getHokenSeikyugaku());
        tempEntity.setRiyoshaFutangaku(entity.get基本Entity().getRiyoshaFutangaku());
        tempEntity.setKinkyuShisetsuRyoyoSeikyugaku(entity.get基本Entity().getKinkyuShisetsuRyoyoSeikyugaku());
        tempEntity.setTokuteiShinryoSeikyugaku(entity.get基本Entity().getTokuteiShinryoSeikyugaku());
        tempEntity.setTokuteiNyushoshaKaigoServiceSeikyugaku(entity.get基本Entity().getTokuteiNyushoshaKaigoServiceSeikyugaku());
        return tempEntity;
    }

}
