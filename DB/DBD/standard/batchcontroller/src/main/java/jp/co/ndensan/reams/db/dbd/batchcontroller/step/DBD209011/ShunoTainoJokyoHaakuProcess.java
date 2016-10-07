/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd209011.ShunoTainoJokyoHaakuBusiness;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd209011.ShunoTainoJokyoHaakuProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.ShunoTainoJokyoHaakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoTainoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 収納滞納状況把握情報の取得_Process処理クラスです．
 *
 * @reamsid_L DBD-3610-030 x_lilh
 */
public class ShunoTainoJokyoHaakuProcess extends BatchProcessBase<ShunoTainoJokyoHaakuEntity> {

    private ShunoTainoJokyoHaakuProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugengakulist."
            + "IShunoJokyoHaakuMapper.get収納滞納状況把握情報");
    private List<ShunoTainoJokyoHaakuEntity> 滞納状況把握情報List;
    private HihokenshaNo 当該被保険者番号;
    private RDate 最古の滞納納期限;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected void initialize() {
        滞納状況把握情報List = new ArrayList<>();
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShunoTainoJokyoTempTableEntity.class)
                .tempTableName(ShunoTainoJokyoTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShunoTainoJokyoHaakuEntity entity) {
        if (!entity.get対象者TmpTblEntity().getHihokenshaNo2().equals(当該被保険者番号)) {
            if (当該被保険者番号 != null) {
                RDate 納期限;
                for (ShunoTainoJokyoHaakuEntity haakuEntity : 滞納状況把握情報List) {
                    納期限 = haakuEntity.get収納状況TmpTblEntity().getTmp_nokigen();
                    if ((最古の滞納納期限 == null || (納期限 != null && 納期限.isBefore(最古の滞納納期限)))
                            && MinoKannoKubun.未納あり.getコード().equals(haakuEntity.get収納状況TmpTblEntity().getTmp_minoKannoKubun())) {
                        最古の滞納納期限 = 納期限;
                    }
                }
                一時テーブル登録(滞納状況把握情報List, 最古の滞納納期限);
                滞納状況把握情報List = new ArrayList<>();
                最古の滞納納期限 = null;
            }
            当該被保険者番号 = entity.get対象者TmpTblEntity().getHihokenshaNo2();
        }
        滞納状況把握情報List.add(entity);
    }

    @Override
    protected void afterExecute() {
        if (当該被保険者番号 != null) {
            RDate 納期限;
            for (ShunoTainoJokyoHaakuEntity haakuEntity : 滞納状況把握情報List) {
                納期限 = haakuEntity.get収納状況TmpTblEntity().getTmp_nokigen();
                if ((最古の滞納納期限 == null || (納期限 != null && 納期限.isBefore(最古の滞納納期限)))
                        && MinoKannoKubun.未納あり.getコード().equals(haakuEntity.get収納状況TmpTblEntity().getTmp_minoKannoKubun())) {
                    最古の滞納納期限 = 納期限;
                }
            }
            一時テーブル登録(滞納状況把握情報List, 最古の滞納納期限);
        }
    }

    private void 一時テーブル登録(List<ShunoTainoJokyoHaakuEntity> 滞納状況把握情報List, RDate 最古の滞納納期限) {
        ShunoTainoJokyoHaakuBusiness business = new ShunoTainoJokyoHaakuBusiness();
        for (ShunoTainoJokyoHaakuEntity entity : 滞納状況把握情報List) {
            tmpTableWriter.insert(business.edit収納滞納状況把握情報(entity, parameter.get基準日(), 最古の滞納納期限));
        }
    }

}
