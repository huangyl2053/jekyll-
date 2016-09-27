/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32003.ShunoTainoJokyoHaakuProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.ShunoTainoJokyoHaakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoTainoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 収納滞納状況把握情報の取得_Process処理クラスです．
 *
 * @reamsid_L DBD-3610-050 x_lilh
 */
public class ShunoTainoJokyoHaakuProcess extends BatchProcessBase<ShunoTainoJokyoHaakuEntity> {

    private ShunoTainoJokyoHaakuProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugengakulist."
                    + "IShunoJokyoHaakuMapper.get対象者把握情報");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShunoTainoJokyoTempTableEntity.class)
                .tempTableName(ShunoTainoJokyoTempTableEntity.TABLE_NAME).build();
    }

    @Override

    protected void process(ShunoTainoJokyoHaakuEntity entity) {
        tmpTableWriter.insert(create重複処理(entity));
    }

    private ShunoTainoJokyoTempTableEntity create重複処理(ShunoTainoJokyoHaakuEntity entity) {
        ShunoTainoJokyoTempTableEntity daTableEntity = new ShunoTainoJokyoTempTableEntity();
        daTableEntity.setHihokenshaNo(entity.getHihokenshaNo());
        daTableEntity.setShikibetsuCode(entity.getShikibetsuCode());
        daTableEntity.setHihokenshaShimeiKana(entity.getHihokenshaShimeiKana());
        daTableEntity.setSetaiCode(entity.getSetaiCode());
        daTableEntity.setGyoseikuCode(entity.getGyoseikuCode());
        daTableEntity.setGyoseikuName(entity.getGyoseikuName());
        daTableEntity.setJushoCode(entity.getJushoCode());
        daTableEntity.setYubinNo(entity.getYubinNo());
        daTableEntity.setJusho(entity.getJusho().getColumnValue());
        daTableEntity.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        daTableEntity.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        daTableEntity.setShikakuSoshitsuJiyuCode(entity.getShikakuSoshitsuJiyuCode());
        daTableEntity.set資格区分(entity.getHihokennshaKubunCode());
        daTableEntity.setKoikinaiJushochiTokureiFlag(entity.getKoikinaiJushochiTokureiFlag());
        daTableEntity.setSeihoFlag(entity.isSeihoFlag());
        daTableEntity.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        daTableEntity.setYokaigoJotaiKubunCode(entity.getYokaigoJotaiKubunCode());
        daTableEntity.setNinteiYukoKikanKaishiYMD(entity.getNinteiYukoKikanKaishiYMD());
        daTableEntity.setNinteiYukoKikanShuryoYMD(entity.getNinteiYukoKikanShuryoYMD());
        daTableEntity.setNinteiYMD(entity.getNinteiYMD());
        daTableEntity.setShiseityuFlag(entity.isShiseityuFlag());
        daTableEntity.setJukyuShinseiYMD(entity.getJukyuShinseiYMD());
        daTableEntity.setChoteiNendo(entity.getChoteiNendo());
        daTableEntity.setFukaNendo(entity.getFukaNendo());
        daTableEntity.setTokucho_FuchoKubun(entity.getTokucho_FuchoKubun());
        daTableEntity.setTsuchishoNo(entity.getTsuchishoNo());
        daTableEntity.setKibetsu(entity.getKibetsu());
        daTableEntity.setChoteigaku(entity.getChoteigaku());
        daTableEntity.setShunyugaku(entity.getShunyugaku());
        daTableEntity.setMinogaku(entity.getMinogaku());
        daTableEntity.setShunyuYMD(entity.getShunyuYMD());
        daTableEntity.setTokusokujoHakkoYMD(entity.getTokusokujoHakkoYMD());
        daTableEntity.setJikoKisanYMD(entity.getJikoKisanYMD());
        daTableEntity.setJikoKisanJiyu(entity.getJikoKisanJiyu());
        daTableEntity.setMinoKannoKubun(entity.getMinoKannoKubun());
        daTableEntity.setJikoKubun(entity.getJikoKubun());
        RString 滞納区分 = RString.EMPTY;
        if (JikoKubun.時効到来.getコード().equals(entity.getJikoKubun())) {
            滞納区分 = new RString("1");
        } else if (JikoKubun.時効未到来.getコード().equals(entity.getJikoKubun())
                && JikoKubun.時効到来.getコード().equals(entity.getJikoKubun())) {
            滞納区分 = new RString("2");
        } else if (JikoKubun.空.getコード().equals(entity.getJikoKubun())) {
            滞納区分 = new RString("3");
        } else if (entity.getNinteiYMD().isBeforeOrEquals(parameter.get基準日())) {
            滞納区分 = new RString("4");
        }
        daTableEntity.setTainoKubun(滞納区分);
        return daTableEntity;
    }
}
