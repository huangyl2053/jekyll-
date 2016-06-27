/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120160;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteihokenshain.KagoKetteiHokenshaInParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.ShihihokenshabangoTempTableEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshain.IKagoKetteiHokenshaInMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一時テーブルのデータの編集
 *
 * @reamsid_L DBC-0980-300 xupeng
 */
public class KagoKetteiHokenshaInUpdataTempTableProcess extends BatchProcessBase<KagoKetteiHokenshaInMeisaiEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kagoketteihokenshain."
            + "IKagoKetteiHokenshaInMapper.select被保険者番号From一時テーブル");

    private IKagoKetteiHokenshaInMapper mapper;

    @Override
    protected void initialize() {
        super.initialize();
        mapper = getMapper(IKagoKetteiHokenshaInMapper.class);
    }

    @Override
    protected void beforeExecute() {
        mapper.create新被保険者番号();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(KagoKetteiHokenshaInMeisaiEntity entity) {
        KagoKetteiHokenshaInParameter parameter = KagoKetteiHokenshaInParameter.createParameter(entity.getHiHokenshaNo());
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理 = mapper.get市町村コード(parameter);
        if (null != 被保険者台帳管理) {
            LasdecCode 市町村コード = 被保険者台帳管理.getShichosonCode();
            parameter = KagoKetteiHokenshaInParameter.createParameter(entity.getHiHokenshaNo(), 市町村コード);
            ShihihokenshabangoTempTableEntity ichijiEntity = mapper.get新被保険者番号(parameter);
            if (ichijiEntity != null) {
                mapper.insert新被保険者番号(ichijiEntity);
            }
        }
    }

    @Override
    protected void afterExecute() {
        mapper.update保険者分情報_明細();
    }

}
