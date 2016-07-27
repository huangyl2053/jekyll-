/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120090;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshikyuketteiin.ShokanShikyuKetteiInMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.IShikibetsuTaishoPSMEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.ShokanBaraiShikyuKetteiJohoItijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.SinHiBokenIchijiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanbaraishikyuketteijoho.IShokanBaraiShikyuKetteiJohoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * @reamsid_L DBC-0980-330 gongliang
 */
public class TempTableEditProcess extends BatchProcessBase<ShokanBaraiShikyuKetteiJohoItijiEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.shokanbaraishikyuketteijoho."
            + "IShokanBaraiShikyuKetteiJohoMapper.select被保険者番号");
    private IShokanBaraiShikyuKetteiJohoMapper mapper;
    private List<SinHiBokenIchijiEntity> targetList;
    private List<DbT1001HihokenshaDaichoEntity> 被保険者台帳管理_識別コードList;
    private List<IShikibetsuTaishoPSMEntity> entityList_PSM;

    @Override
    protected void initialize() {
        super.initialize();
        mapper = getMapper(IShokanBaraiShikyuKetteiJohoMapper.class);
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
    protected void process(ShokanBaraiShikyuKetteiJohoItijiEntity entity) {
        HihokenshaNo 被保険者番号 = entity.get被保険者番号();
        ShokanShikyuKetteiInMybatisParameter parameter = ShokanShikyuKetteiInMybatisParameter.createParameter(被保険者番号);
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理 = mapper.select被保険者台帳管理(parameter);
        if (被保険者台帳管理 != null) {
            LasdecCode 市町村コード = 被保険者台帳管理.getShichosonCode();
            parameter = ShokanShikyuKetteiInMybatisParameter.createParameter(被保険者番号, 市町村コード);
            SinHiBokenIchijiEntity ichijiEntity = mapper.select新被保険者番号(parameter);
            targetList.add(ichijiEntity);
        }
    }

    @Override
    protected void afterExecute() {
        for (SinHiBokenIchijiEntity ichijiEntity : targetList) {
            mapper.insert新被保険者番号一時テーブル(ichijiEntity);
        }
        mapper.update償還払支給決定情報一時TBL();

        List<ShokanBaraiShikyuKetteiJohoItijiEntity> entityList_識別コード = mapper.select被保険者番号();
        for (ShokanBaraiShikyuKetteiJohoItijiEntity entity_識別コード : entityList_識別コード) {
            HihokenshaNo 被保険者番号_識別コード = entity_識別コード.get被保険者番号();
            ShokanShikyuKetteiInMybatisParameter parameter_識別コード = ShokanShikyuKetteiInMybatisParameter
                    .createParameter(被保険者番号_識別コード);
            DbT1001HihokenshaDaichoEntity 被保険者台帳管理_識別コード = mapper.select被保険者台帳管理(parameter_識別コード);
            被保険者台帳管理_識別コードList.add(被保険者台帳管理_識別コード);
        }

        for (DbT1001HihokenshaDaichoEntity 被保険者台帳管理entity : 被保険者台帳管理_識別コードList) {
            mapper.update償還払支給決定情報一時TBL_識別コード(被保険者台帳管理entity);
        }

        List<ShokanBaraiShikyuKetteiJohoItijiEntity> entityList_宛名 = mapper.select識別コード();
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        for (ShokanBaraiShikyuKetteiJohoItijiEntity entity_宛名 : entityList_宛名) {
            builder.setデータ取得区分(DataShutokuKubun.直近レコード);
            builder.set識別コード(entity_宛名.get識別コード());
            IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
            ShokanShikyuKetteiInMybatisParameter parameter_宛名 = ShokanShikyuKetteiInMybatisParameter.createParameter(searchKey);
            entityList_PSM = mapper.select宛名情報Entity(parameter_宛名);

        }

        for (IShikibetsuTaishoPSMEntity entity_PSM : entityList_PSM) {
            mapper.update償還払支給決定情報一時TBL_宛名(entity_PSM);
        }
    }
}
