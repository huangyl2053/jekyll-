/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc040040;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040.HihokenshaDaichoJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040.KogakuGassanTempEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額合算情報Updateのprocessクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public class KogakuGassanTempUpdateProcess extends BatchProcessBase<HihokenshaDaichoJohoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040040."
                    + "IJikofutanShomeishoMapper.select被保険者台帳宛名情報");
    private static final RString TABLE_NAME = new RString("KogakuGassanTemp");

    @BatchWriter
    IBatchTableWriter tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, KogakuGassanTempEntity.class);
    }

    @Override
    protected void process(HihokenshaDaichoJohoEntity entity) {
        KogakuGassanTempEntity tempEntity = entity.get高額合算一時();
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.get宛名());

        tempEntity.setAtena_HihokenshaKanaShimei(宛名.to個人().get名称().getKana());
        tempEntity.setAtena_HihokenshaShimei(宛名.to個人().get名称().getName());
        tempEntity.setAtena_SeinengappiYMD(宛名.to個人().get生年月日().toFlexibleDate());
        tempEntity.setAtena_Seibetsu(宛名.to個人().get性別().getCode());
        tempEntity.setShikibetsuCode(宛名.to個人().get識別コード());

        tableWriter.update(tempEntity);
    }

}
