/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.ShunoTainoJokyoHaakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoTainoJokyoTempTableEntity;
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
 * @reamsid_L DBD-3610-030 x_lilh
 */
public class ShunoTainoJokyoHaakuProcess extends BatchProcessBase<ShunoTainoJokyoHaakuEntity> {

//    private ShunoTainoJokyoHaakuProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugengakulist."
                    + "IShunoJokyoHaakuMapper.get収納滞納状況把握情報");

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
        tmpTableWriter.insert(edit収納滞納状況把握情報(entity));
    }

    private ShunoTainoJokyoTempTableEntity edit収納滞納状況把握情報(ShunoTainoJokyoHaakuEntity entity) {

        ShunoTainoJokyoTempTableEntity insertEntity = new ShunoTainoJokyoTempTableEntity();
        ShunoJokyoTempTableEntity 収納状況TmpTblEntity = entity.get収納状況TmpTblEntity();
//        DbT4025ShiharaiHohoHenkoGengakuEntity 支払方法変更減額Entity = entity.get支払方法変更減額Entity();

        insertEntity.setTmp_hihokenshaNo(収納状況TmpTblEntity.getTmp_hihokenshaNo());
        insertEntity.setTmp_shikibetsuCode(収納状況TmpTblEntity.getTmp_shikibetsuCode());
        insertEntity.setTmp_hihokenshaShimeiKana(収納状況TmpTblEntity.getTmp_hihokenshaShimeiKana());
        insertEntity.setTmp_setaiCode(収納状況TmpTblEntity.getTmp_setaiCode());
        insertEntity.setTmp_gyoseikuCode(収納状況TmpTblEntity.getTmp_gyoseikuCode());
        insertEntity.setTmp_gyoseikuName(収納状況TmpTblEntity.getTmp_gyoseikuName());
        insertEntity.setTmp_jushoCode(収納状況TmpTblEntity.getTmp_jushoCode());
        insertEntity.setTmp_yubinNo(収納状況TmpTblEntity.getTmp_yubinNo());
        insertEntity.setTmp_jusho(収納状況TmpTblEntity.getTmp_jusho());
        insertEntity.setTmp_shikakuShutokuYMD(収納状況TmpTblEntity.getTmp_shikakuShutokuYMD());
        insertEntity.setTmp_shikakuSoshitsuYMD(収納状況TmpTblEntity.getTmp_shikakuSoshitsuYMD());
        insertEntity.setTmp_shikakuSoshitsuJiyuCode(収納状況TmpTblEntity.getTmp_shikakuSoshitsuJiyuCode());
        insertEntity.setTmp_shikakuKubunCode(収納状況TmpTblEntity.getTmp_shikakuKubunCode());
        insertEntity.setTmp_koikinaiJushochiTokureiFlag(収納状況TmpTblEntity.getTmp_koikinaiJushochiTokureiFlag());
        insertEntity.setTmp_seihoFlag(収納状況TmpTblEntity.isTmp_seihoFlag());
        insertEntity.setTmp_koroshoIfShikibetsuCode(収納状況TmpTblEntity.getTmp_koroshoIfShikibetsuCode());
        insertEntity.setTmp_yokaigoJotaiKubunCode(収納状況TmpTblEntity.getTmp_yokaigoJotaiKubunCode());
        insertEntity.setTmp_ninteiYukoKikanKaishiYMD(収納状況TmpTblEntity.getTmp_ninteiYukoKikanKaishiYMD());
        insertEntity.setTmp_ninteiYukoKikanShuryoYMD(収納状況TmpTblEntity.getTmp_ninteiYukoKikanShuryoYMD());
        insertEntity.setTmp_ninteiYMD(収納状況TmpTblEntity.getTmp_ninteiYMD());
        insertEntity.setTmp_shiseityuFlag(収納状況TmpTblEntity.isTmp_shiseityuFlag());
        insertEntity.setTmp_jukyuShinseiYMD(収納状況TmpTblEntity.getTmp_jukyuShinseiYMD());
        insertEntity.setTmp_choteiNendo(収納状況TmpTblEntity.getTmp_choteiNendo());
        insertEntity.setTmp_fukaNendo(収納状況TmpTblEntity.getTmp_fukaNendo());
        insertEntity.setTmp_tokucho_FuchoKubun(収納状況TmpTblEntity.getTmp_tokucho_FuchoKubun());
        insertEntity.setTmp_tsuchishoNo(収納状況TmpTblEntity.getTmp_tsuchishoNo());
        insertEntity.setTmp_kibetsu(収納状況TmpTblEntity.getTmp_kibetsu());
        insertEntity.setTmp_choteigaku(収納状況TmpTblEntity.getTmp_choteigaku());
        insertEntity.setTmp_shunyugaku(収納状況TmpTblEntity.getTmp_shunyugaku());
        insertEntity.setTmp_minogaku(収納状況TmpTblEntity.getTmp_minogaku());
        insertEntity.setTmp_shunyuYMD(収納状況TmpTblEntity.getTmp_shunyuYMD());
        insertEntity.setTmp_tokusokujoHakkoYMD(収納状況TmpTblEntity.getTmp_tokusokujoHakkoYMD());
        insertEntity.setTmp_jikoKisanYMD(収納状況TmpTblEntity.getTmp_jikoKisanYMD());
        insertEntity.setTmp_jikoKisanJiyu(収納状況TmpTblEntity.getTmp_jikoKisanJiyu());
        insertEntity.setTmp_minoKannoKubun(収納状況TmpTblEntity.getTmp_minoKannoKubun());
        insertEntity.setTmp_jikoKubun(収納状況TmpTblEntity.getTmp_jikoKubun());

//        RString 滞納区分 = RString.EMPTY;  QA98540
//
//        if (JikoKubun.時効到来.getコード().equals(支払方法変更減額Entity.getJikoKubun())) {
//            滞納区分 = new RString("1");
//        } else if (JikoKubun.時効未到来.getコード().equals(支払方法変更減額Entity.getJikoKubun())
//                && JikoKubun.時効到来.getコード().equals(支払方法変更減額Entity.getJikoKubun())) {
//            滞納区分 = new RString("2");
//        } else if (JikoKubun.空.getコード().equals(支払方法変更減額Entity.getJikoKubun())) {
//            滞納区分 = new RString("3");
//        } else if (支払方法変更減額Entity.getNinteiYMD().isBeforeOrEquals(parameter.get基準日())) {
//            滞納区分 = new RString("4");
//        }
//        insertEntity.setTmp_tainoKubun(滞納区分);
        return insertEntity;
    }
}
