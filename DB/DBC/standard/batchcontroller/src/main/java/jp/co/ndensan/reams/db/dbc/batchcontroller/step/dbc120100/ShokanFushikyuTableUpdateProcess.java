/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120100;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanfushikyuketteiin.ShokanFushikyuKetteiInPSMParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanfushikyuketteiin.ShokanFushikyuKetteiInParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShikibetsuTaishoPSMEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.SinHihokenshaBangoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanfushikyuketteiin.IShokanFushikyuKetteiInMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一時テーブルの更新
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
public class ShokanFushikyuTableUpdateProcess extends BatchProcessBase<ShokanFushikyuKetteiInEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.shokanfushikyuketteiin."
            + "IShokanFushikyuKetteiInMapper.select被保険者番号");

    private IShokanFushikyuKetteiInMapper mapper;
    private List<SinHihokenshaBangoEntity> targetList;

    @Override
    protected void initialize() {
        super.initialize();
        mapper = getMapper(IShokanFushikyuKetteiInMapper.class);
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
    protected void process(ShokanFushikyuKetteiInEntity entity) {
        HihokenshaNo 被保険者番号 = entity.getHiHokenshaNo();
        ShokanFushikyuKetteiInParameter parameter = ShokanFushikyuKetteiInParameter.createParameter(被保険者番号);
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理 = mapper.select市町村コードFrom被保険者台帳管理(parameter);
        if (被保険者台帳管理 != null) {
            LasdecCode 市町村コード = 被保険者台帳管理.getShichosonCode();
            parameter = ShokanFushikyuKetteiInParameter.createParameter(被保険者番号, 市町村コード);
            SinHihokenshaBangoEntity ichijiEntity = mapper.select新被保険者番号From新旧被保険者番号変換(parameter);
            targetList.add(ichijiEntity);
        }
    }

    @Override
    protected void afterExecute() {
        for (SinHihokenshaBangoEntity bangoEntity : targetList) {
            mapper.insert新被保険者番号一時テーブル(bangoEntity);
        }
        mapper.update償還払不支給決定情報一時テーブル();
        List<ShokanFushikyuKetteiInEntity> entityList_被保険者番号 = mapper.select被保険者番号();
        for (ShokanFushikyuKetteiInEntity entity_被保険者番号 : entityList_被保険者番号) {
            HihokenshaNo 被保険者番号 = entity_被保険者番号.getHiHokenshaNo();
            ShokanFushikyuKetteiInParameter parameter_被保険者番号 = ShokanFushikyuKetteiInParameter.createParameter(被保険者番号);
            DbT1001HihokenshaDaichoEntity entity = mapper.select市町村コードFrom被保険者台帳管理(parameter_被保険者番号);
            if (entity != null) {
                mapper.update償還払不支給決定情報一時テーブル_被保険者番号(entity);
            }
        }

        List<ShokanFushikyuKetteiInEntity> entityList_識別コード = mapper.select識別コード();
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        for (ShokanFushikyuKetteiInEntity entity_識別コード : entityList_識別コード) {
            builder.set識別コード(entity_識別コード.getShikibetsuCode());
            IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
            ShokanFushikyuKetteiInPSMParameter parameter_宛名 = ShokanFushikyuKetteiInPSMParameter.createSelectByKeyParam(searchKey);
            ShikibetsuTaishoPSMEntity psm_entity = mapper.select宛名情報Entity(parameter_宛名);
            if (psm_entity != null) {
                mapper.update償還払不支給決定情報一時テーブル_識別コード(psm_entity);
            }
        }
    }
}
