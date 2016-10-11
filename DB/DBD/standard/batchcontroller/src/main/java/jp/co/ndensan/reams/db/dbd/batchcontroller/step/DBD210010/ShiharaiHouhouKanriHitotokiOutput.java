/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD210010;

import jp.co.ndensan.reams.db.dbd.business.core.dbd210010.ShiharaiHouhouKanriHitotokiDataManager;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd210010.DBD210010ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.ShiharaiHouhouKanriHitotokiTempEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付制限対象者一覧CSVのprocessクラスです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
public class ShiharaiHouhouKanriHitotokiOutput extends BatchProcessBase<ShiharaiHohoHenkoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate"
            + ".kyufuseigentaishoichiran.IShiharaiHohoHenkoMapper.get支払方法管理情報");
    private DBD210010ProcessParameter processParameter;
    private IShikibetsuTaishoPSMSearchKey searchKey;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter shiharaiHouhouKanriHitotokiTemp;

    @Override
    protected void initialize() {
        searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toDBD210010MybatisParameter(searchKey));
    }

    @Override
    protected void createWriter() {
        shiharaiHouhouKanriHitotokiTemp = new BatchEntityCreatedTempTableWriter(ShiharaiHouhouKanriHitotokiTempEntity.TABLE_NAME,
                ShiharaiHouhouKanriHitotokiTempEntity.class);
    }

    @Override
    protected void process(ShiharaiHohoHenkoEntity t) {
        ShiharaiHouhouKanriHitotokiDataManager manager = new ShiharaiHouhouKanriHitotokiDataManager();
        ShiharaiHouhouKanriHitotokiTempEntity tempTable = manager.set支払方法管理一時テーブル(t);
        shiharaiHouhouKanriHitotokiTemp.insert(tempTable);
    }
}
