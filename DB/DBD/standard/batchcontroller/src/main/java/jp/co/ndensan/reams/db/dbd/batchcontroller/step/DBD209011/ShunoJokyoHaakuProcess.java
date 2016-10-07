/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd209011.ShunoJokyoHaakuBusiness;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd209011.ShunoJokyoHaakuProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.ShunoJokyoHaakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 収納状況把握情報の取得_Process処理クラスです．
 *
 * @reamsid_L DBD-3610-030 x_lilh
 */
public class ShunoJokyoHaakuProcess extends BatchProcessBase<ShunoJokyoHaakuEntity> {

    private ShunoJokyoHaakuProcessParameter parameter;
    private FlexibleYear 日付関連_調定年度;
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugengakulist."
            + "IShunoTainoJokyoHaakuMapper.get収納状況把握情報");
    private static final int INT_9 = 9;

    @Override
    protected void initialize() {
        RString 日付関連_調定年度コンフィング = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        日付関連_調定年度 = new FlexibleYear(日付関連_調定年度コンフィング).minusYear(INT_9);
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        key.set基準日(parameter.get基準日());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());

        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toShunoJokyoHaakuMybatisParameter(parameter.get基準日(),
                日付関連_調定年度, psmShikibetsuTaisho));
    }
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShunoJokyoTempTableEntity.class)
                .tempTableName(ShunoJokyoTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShunoJokyoHaakuEntity shunoJokyoEntity) {
        ShunoJokyoHaakuBusiness business = new ShunoJokyoHaakuBusiness();
        List<ShunoJokyoTempTableEntity> insertEnList = business.edit収納状況把握情報(shunoJokyoEntity, parameter.get基準日());
        if (insertEnList != null) {
            for (ShunoJokyoTempTableEntity entity : insertEnList) {
                tmpTableWriter.insert(entity);
            }
        }
    }

}
