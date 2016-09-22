/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD204010;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd204010.TaishoKyufuJissekiTokuteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd204010.KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd204010.temptable.KyufuJisekiKeyTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績参照キー作成です
 *
 * @reamsid_L DBD-3880-030 jinge
 */
public class TaishoKyufuJissekiTokuteiProcess extends BatchProcessBase<KyufujissekiKihonEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.tokubetsuchiikikasankeigenlist."
            + "ITokubetsuChiikiKasanKeigenListMapper.get給付実績参照キー作成情報");

    TaishoKyufuJissekiTokuteiProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toTaishoKyufuJissekiTokuteiMybatisprmParamter());
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(KyufuJisekiKeyTempTableEntity.class)
                .tempTableName(KyufuJisekiKeyTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(KyufujissekiKihonEntity t) {
        KyufuJisekiKeyTempTableEntity tempTableEntity = set給付実績キー一時テーブル(t.getInputShikibetsuNo(), t.getShokisaiHokenshaNo(),
                t.getHihokenshaNo(), t.getShinsaYM(), t.getServiceTeikyoYM(), t.getJigyoshoNo(), t.getToshiNo(), t.getKyufuSakuseiKubunCode());
        tmpTableWriter.insert(tempTableEntity);
    }

    private KyufuJisekiKeyTempTableEntity set給付実績キー一時テーブル(NyuryokuShikibetsuNo 入力識別番号, HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth 審査年月, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業者番号, RString 通し番号,
            RString 給付実績情報作成区分コード) {
        KyufuJisekiKeyTempTableEntity tempTable
                = new KyufuJisekiKeyTempTableEntity();
        tempTable.setInputShikibetsuNo(入力識別番号);
        tempTable.setShokisaiHokenshaNo(証記載保険者番号);
        tempTable.setHihokenshaNo(被保険者番号);
        tempTable.setShinsaYM(審査年月);
        tempTable.setServiceTeikyoYM(サービス提供年月);
        tempTable.setJigyoshoNo(事業者番号);
        tempTable.setToshiNo(通し番号);
        tempTable.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
        return tempTable;
    }
}
