/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470ToukeihyoMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.HihokenshaShikibetsuTaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 給付実績特定入所者介護サービス費用情報の取得処理Processクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
public class HihokenshaShikibetsuTaishoGetProcess
        extends BatchProcessBase<HihokenshaShikibetsuTaishoEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecoderiyojokyo."
                    + "IServicecodeRiyojokyoMapper.get被保険者宛名情報");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 統計表明細一時tableWriter;
    private static final RString 統計表明細一時_TABLE_NAME = new RString("DbWT3470ToukeihyoMeisai");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        統計表明細一時tableWriter = new BatchEntityCreatedTempTableWriter(
                統計表明細一時_TABLE_NAME, DbWT3470ToukeihyoMeisaiTempEntity.class);
    }

    @Override
    protected void process(HihokenshaShikibetsuTaishoEntity entity) {
        DbWT3470ToukeihyoMeisaiTempEntity toukeihyoMeisaiTempEntity = entity.get給付実績();
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理 = entity.get被保険者台帳管理();
        if (被保険者台帳管理 != null) {
            toukeihyoMeisaiTempEntity.setShichosonCode(被保険者台帳管理.getShichosonCode());
            toukeihyoMeisaiTempEntity.setKoikinaiJushochiTokureiFlag(被保険者台帳管理.getKoikinaiJushochiTokureiFlag());
            toukeihyoMeisaiTempEntity.setKoikinaiTokureiSochimotoShichosonCode(被保険者台帳管理.getKoikinaiTokureiSochimotoShichosonCode());
            toukeihyoMeisaiTempEntity.setKyuShichosonCode(被保険者台帳管理.getKyuShichosonCode());
        }
        UaFt200FindShikibetsuTaishoEntity 宛名 = entity.get宛名();
        if (宛名 != null) {
            IShikibetsuTaisho 識別対象 = ShikibetsuTaishoFactory.createKojin(宛名);
            set宛名(識別対象, toukeihyoMeisaiTempEntity);
        }
        統計表明細一時tableWriter.update(toukeihyoMeisaiTempEntity);
    }

    private void set宛名(IShikibetsuTaisho 識別対象, DbWT3470ToukeihyoMeisaiTempEntity toukeihyoMeisaiTempEntity) {
        if (識別対象.get住所() != null) {
            toukeihyoMeisaiTempEntity.setMachiikiCode(識別対象.get住所().get町域コード());
        }
        if (識別対象.get行政区画() != null) {
            if (識別対象.get行政区画().getGyoseiku() != null) {
                toukeihyoMeisaiTempEntity.setGyoseikuCode(識別対象.get行政区画().getGyoseiku().getコード());
            }
            if (識別対象.get行政区画().getChiku1() != null) {
                toukeihyoMeisaiTempEntity.setChikuCode1(
                        getColumnValue(識別対象.get行政区画().getChiku1().getコード()));
            }
            if (識別対象.get行政区画().getChiku2() != null) {
                toukeihyoMeisaiTempEntity.setChikuCode2(
                        getColumnValue(識別対象.get行政区画().getChiku2().getコード()));
            }
            if (識別対象.get行政区画().getChiku3() != null) {
                toukeihyoMeisaiTempEntity.setChikuCode3(
                        getColumnValue(識別対象.get行政区画().getChiku3().getコード()));
            }
        }
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
