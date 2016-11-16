/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannKihonSofuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannKooGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannShouKannTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.setaiyin.SetaiYinEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka.IHonnSanteiFukaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.honnsanteifuka.HonnSanteiFukaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動中間更新データです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
public class IdouKoushinnProcess extends BatchProcessBase<SetaiYinEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka."
            + "IHonnSanteiFukaMapper.select世帯員所得情報");
    IHonnSanteiFukaMapper mapper;
    private static final RString 区分_1 = new RString("1");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter<IdouChuukannKihonSofuTempEntity> 異動中間基本送付一時;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter<IdouChuukannShouKannTempEntity> 異動中間償還送付一時;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter<IdouChuukannKooGakuTempEntity> 異動中間高額送付一時;
    private static final RString TABLE_異動中間高額送付一時 = new RString("IdouChuukannKooGakuIttokiTemp");
    private static final RString TABLE_異動中間基本送付一時 = new RString("IdouChuukannKihonSofuIttokiTemp");
    private static final RString TABLE_異動中間償還送付一時 = new RString("IdouChuukannShouKannIttokiTemp");

    @Override
    protected void initialize() {
        mapper = getMapper(IHonnSanteiFukaMapper.class);
    }

    @Override
    protected void createWriter() {
        異動中間高額送付一時 = new BatchEntityCreatedTempTableWriter(TABLE_異動中間高額送付一時,
                IdouChuukannKooGakuTempEntity.class);
        異動中間基本送付一時 = new BatchEntityCreatedTempTableWriter(TABLE_異動中間基本送付一時,
                IdouChuukannKihonSofuTempEntity.class);
        異動中間償還送付一時 = new BatchEntityCreatedTempTableWriter(TABLE_異動中間償還送付一時,
                IdouChuukannShouKannTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(SetaiYinEntity entity) {
    }

    @Override
    protected void afterExecute() {
        List<IdouChuukannKihonSofuTempEntity> 異動中間基本送付 = mapper.select異動中間基本送付();
        List<IdouChuukannShouKannTempEntity> 異動中間償還送付 = mapper.select異動中間償還送付();
        List<IdouChuukannKooGakuTempEntity> 異動中間高額送付 = mapper.select異動中間高額送付();
        List<RString> 証記載保険者番号と市町村名 = HonnSanteiFukaManager.createInstance().get証記載保険者番号と市町村名();
        for (IdouChuukannKihonSofuTempEntity 基本送付 : 異動中間基本送付) {
            基本送付.set証記載保険者番号(new ShoKisaiHokenshaNo(証記載保険者番号と市町村名.get(0)));
            if (!区分_1.equals(基本送付.get住所地特例フラグ())) {
                基本送付.set住所(証記載保険者番号と市町村名.get(1).concat(基本送付.get住所()));
            }
            異動中間基本送付一時.update(基本送付);
        }
        for (IdouChuukannShouKannTempEntity 償還送付 : 異動中間償還送付) {
            償還送付.set証記載保険者番号(new ShoKisaiHokenshaNo(証記載保険者番号と市町村名.get(0)));
            異動中間償還送付一時.update(償還送付);
        }
        for (IdouChuukannKooGakuTempEntity 高額送付 : 異動中間高額送付) {
            高額送付.set証記載保険者番号(new ShoKisaiHokenshaNo(証記載保険者番号と市町村名.get(0)));
            異動中間高額送付一時.update(高額送付);
        }
    }
}
