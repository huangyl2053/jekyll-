/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain.ShichosonHihokenshaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoketteiMesaiIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.SinHihokenshaBangoIchijiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteikohifutanshain.IKagoKetteiKohishaMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一時テーブルにデータの編集です。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public class KohifutanshaTempTableUpdateProcess extends BatchProcessBase<KagoketteiMesaiIchijiEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kagoketteikohifutanshain."
            + "IKagoKetteiKohishaMapper.select被保険者番号From一時テーブル");

    private IKagoKetteiKohishaMapper mapper;
    private List<SinHihokenshaBangoIchijiEntity> targetList;

    @Override
    protected void initialize() {
        super.initialize();
        mapper = getMapper(IKagoKetteiKohishaMapper.class);
        targetList = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
        mapper.create新被保険者番号一時テーブル();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(KagoketteiMesaiIchijiEntity entity) {
        HihokenshaNo 被保険者番号 = entity.get被保険者番号();
        ShichosonHihokenshaParameter parameter = ShichosonHihokenshaParameter.createParameter(被保険者番号);
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理 = mapper.select市町村コードFrom被保険者台帳管理(parameter);
        if (null != 被保険者台帳管理) {
            LasdecCode 市町村コード = 被保険者台帳管理.getShichosonCode();
            parameter = ShichosonHihokenshaParameter.createParameter(被保険者番号, 市町村コード);
            SinHihokenshaBangoIchijiEntity ichijiEntity = mapper.select新被保険者番号From新旧被保険者番号変換(parameter);
            targetList.add(ichijiEntity);
        }
    }

    @Override
    protected void afterExecute() {
        for (SinHihokenshaBangoIchijiEntity ichijiEntity : targetList) {
            mapper.insert新被保険者番号一時テーブル(ichijiEntity);
        }
        mapper.update過誤決定明細一時テーブル();
    }

}
