/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujisseki.HokenshaKyufujissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujisseki.DbWT1111KyufuJissekiTempTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikogakukaigoservicehi.DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成の高額データの取得Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class InsKogakuTempProcess extends BatchProcessBase<DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get高額一時データ");
    private static final RString データ区分 = new RString("14");

    private static final RString 給付実績一時NAME = new RString("DbWT1111KyufuJissekiTemp");
    private static final int INT_0 = 0;
    private static final RString RSTRING_0 = new RString("0");

    private HokenshaKyufujissekiProcessParameter processParameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, processParameter.toHokenshaKyufujissekiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        給付実績一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績一時NAME, DbWT1111KyufuJissekiTempTempEntity.class);
    }

    @Override
    protected void process(DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity entity) {
        DbWT1111KyufuJissekiTempTempEntity 給付実績一時entity = new DbWT1111KyufuJissekiTempTempEntity();
        給付実績一時entity.setDbWT1132_kokanJohoShikibetsuNo(entity.getKokanJohoShikibetsuNo());
        給付実績一時entity.setDbWT1132_inputShikibetsuNo(entity.getInputShikibetsuNo());
        給付実績一時entity.setDbWT1132_recodeShubetsuCode(entity.getRecodeShubetsuCode());
        給付実績一時entity.setDbWT1132_shokisaiHokenshaNo(entity.getShokisaiHokenshaNo());
        給付実績一時entity.setDbWT1132_hiHokenshaNo(entity.getHiHokenshaNo());
        給付実績一時entity.setDbWT1132_serviceTeikyoYM(entity.getServiceTeikyoYM());
        給付実績一時entity.setDbWT1132_kyufuSakuseiKubunCode(entity.getKyufuSakuseiKubunCode());
        給付実績一時entity.setDbWT1132_kyufuJissekiKubunCode(entity.getKyufuJissekiKubunCode());
        給付実績一時entity.setDbWT1132_toshiNo(entity.getToshiNo());
        給付実績一時entity.setDbWT1132_uketsukeYMD(entity.getUketsukeYMD());
        給付実績一時entity.setDbWT1132_ketteiYMD(entity.getKetteiYMD());
        給付実績一時entity.setDbWT1132_kohi1FutanNo(entity.getKohi1FutanNo());
        給付実績一時entity.setDbWT1132_kohi2FutanNo(entity.getKohi2FutanNo());
        給付実績一時entity.setDbWT1132_kohi3FutanNo(entity.getKohi3FutanNo());
        給付実績一時entity.setDbWT1132_riyoshaFutangaku(entity.getRiyoshaFutangaku());
        給付実績一時entity.setDbWT1132_kohi1Futangaku(entity.getKohi1Futangaku());
        給付実績一時entity.setDbWT1132_kohi2Futangaku(entity.getKohi2Futangaku());
        給付実績一時entity.setDbWT1132_kohi3Futangaku(entity.getKohi3Futangaku());
        給付実績一時entity.setDbWT1132_shikyugaku(entity.getShikyugaku());
        給付実績一時entity.setDbWT1132_kohi1Shikyugaku(entity.getKohi1Shikyugaku());
        給付実績一時entity.setDbWT1132_kohi2Shikyugaku(entity.getKohi2Shikyugaku());
        給付実績一時entity.setDbWT1132_kohi3Shikyugaku(entity.getKohi3Shikyugaku());
        給付実績一時entity.setDbWT1132_shinsaYM(entity.getShinsaYM());
        給付実績一時entity.setDbWT1132_seiriNo(entity.getSeiriNo());
        給付実績一時entity.setDbWT1132_sofuYM(entity.getSofuYM());
        給付実績一時entity.setDbWT1132_torikomiYM(entity.getTorikomiYM());
        給付実績一時entity.setDbWT1132_sakuseiKubun(entity.getSakuseiKubun());
        給付実績一時entity.setDbWT1132_kanriNo(entity.getKanriNo());
        給付実績一時entity.setDbWT1132_hokenshaHoyuKyufujissekiJohoSakujoZumiFlag(entity.isHokenshaHoyuKyufujissekiJohoSakujoZumiFlag());
        給付実績一時entity.setDbWT1132_renban(entity.getRenban());
        給付実績一時entity.setDbWT1132_sofuJogaiFlag(entity.isSofuJogaiFlag());
        給付実績一時entity.setDbWT1132_hokenshaNo(entity.getHokenshaNo());
        給付実績一時entity.setDbWT1132_hokenshaName(entity.getHokenshaName());
        給付実績一時entity.setDbWT1132_sofuHihokenshaNo(entity.getSofuHihokenshaNo());
        給付実績一時entity.setDataKunbun(データ区分);
        給付実績一時entity.setRenban2(INT_0);
        給付実績一時entity.setInputShikibetsuNo(entity.getInputShikibetsuNo());
        給付実績一時entity.setHiHokenshaNo(entity.getHiHokenshaNo());
        給付実績一時entity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        給付実績一時entity.setJigyoshoNo(new JigyoshaNo(RSTRING_0));
        給付実績一時entity.setToshiNo(entity.getToshiNo());
        給付実績一時entity.setRenban1(entity.getRenban());
        給付実績一時tableWriter.insert(給付実績一時entity);
    }
}
