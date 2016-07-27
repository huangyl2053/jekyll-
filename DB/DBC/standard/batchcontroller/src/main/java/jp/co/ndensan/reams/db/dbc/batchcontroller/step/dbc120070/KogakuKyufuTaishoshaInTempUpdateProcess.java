/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukyufutaishoshain.KogakuKyufuTaishoshaInParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain.DbTKogakuKyufuTaishoshaDataTempTableEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyufutaishoshain.IKogakuKyufuTaishoshaInMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費給付対象者取込の一時テーブル編集
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public class KogakuKyufuTaishoshaInTempUpdateProcess extends BatchProcessBase<DbTKogakuKyufuTaishoshaDataTempTableEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kogakukyufutaishoshain.IKogakuKyufuTaishoshaInMapper.select被保険者番号From一時テーブル");
    private IKogakuKyufuTaishoshaInMapper mapper;
    private List<DbT7026ShinKyuHihokenshaNoHenkanEntity> targetList;

    @Override
    protected void initialize() {
        super.initialize();
        mapper = getMapper(IKogakuKyufuTaishoshaInMapper.class);
        targetList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(DbTKogakuKyufuTaishoshaDataTempTableEntity 一時Entity) {
        HihokenshaNo 被保険者番号 = 一時Entity.getHihokenshaNo();
        KogakuKyufuTaishoshaInParameter parameter = KogakuKyufuTaishoshaInParameter.createParameter(被保険者番号);
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理 = mapper.select市町村コードFrom被保険者台帳管理(parameter);
        if (null != 被保険者台帳管理) {
            LasdecCode 市町村コード = 被保険者台帳管理.getShichosonCode();
            parameter = KogakuKyufuTaishoshaInParameter.createParameter(被保険者番号, 市町村コード);
            DbT7026ShinKyuHihokenshaNoHenkanEntity 番号変換Entity = mapper.select新被保険者番号From新旧被保険者番号変換(parameter);
            targetList.add(番号変換Entity);
        }
    }

    @Override
    protected void afterExecute() {
        if (targetList != null && !targetList.isEmpty()) {
            for (DbT7026ShinKyuHihokenshaNoHenkanEntity 番号変換Entity : targetList) {
                mapper.update一時TBL被保険者番号(番号変換Entity);
            }
        }
        List<DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity> 世帯集約List = mapper.select世帯集約番号();
        if (世帯集約List != null && !世帯集約List.isEmpty()) {
            for (DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity 世帯集約Entity : 世帯集約List) {
                mapper.update世帯集約番号(世帯集約Entity);
            }
        }

    }
}
