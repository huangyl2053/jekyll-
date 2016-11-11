/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.honnsanteifuka.HonnsanteiFukaMybatisParamter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.honnsanteifuka.HonnsanteiFukaProcessParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannKooGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.JukyushaDaichoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.ShotaiinHaakuIttokiTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.honnsanteifuka.HonnSanteiFukaManager;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握トリガ一時バックアップです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
public class IdouDetaTyuushutuProcess extends BatchProcessBase<JukyushaDaichoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka."
            + "IHonnSanteiFukaMapper.select受給者台帳情報");
    private HonnsanteiFukaProcessParamter processParameter;
    private static final RString TABLE_世帯員把握トリガ一時 = new RString("SetaiYinHaAKuToRiGaTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 世帯員把握トリガ一時;

    @Override
    protected void createWriter() {
        世帯員把握トリガ一時 = new BatchEntityCreatedTempTableWriter(TABLE_世帯員把握トリガ一時,
                ShotaiinHaakuIttokiTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        HonnsanteiFukaMybatisParamter sqlParam
                = HonnsanteiFukaMybatisParamter.createParam(processParameter.toSyoriMybitisParamter(),
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, sqlParam);
    }

    @Override
    protected void process(JukyushaDaichoRelateEntity entity) {
    }

    @Override
    protected void afterExecute() {
        List<IdouChuukannKooGakuTempEntity> 異動中間高額送付情報 = HonnSanteiFukaManager.createInstance().
                set異動中間高額送付(processParameter.get処理対象年月(), processParameter.get合併区分());
        List<ShotaiinHaakuIttokiTempEntity> 世帯員把握情報 = HonnSanteiFukaManager.createInstance().
                set世帯員把握情報(異動中間高額送付情報, processParameter.get処理対象年月());
        for (ShotaiinHaakuIttokiTempEntity 世帯員情報 : 世帯員把握情報) {
            世帯員把握トリガ一時.insert(世帯員情報);
        }
    }
}
