/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuThreeEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable.TainoMaxRirekiNoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス3クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoHaakuThreeProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuThreeEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHakuListMainMapper.find最大履歴情報");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(TainoMaxRirekiNoTempTableEntity.class)
                .tempTableName(TainoMaxRirekiNoTempTableEntity.TABLE_NAME).build();
    }

    private TainoMaxRirekiNoTempTableEntity create滞納者対策最大履歴番号一時テーブル情報(ShiharaiHohoHenkoHaakuThreeEntity t) {
        TainoMaxRirekiNoTempTableEntity result = new TainoMaxRirekiNoTempTableEntity();
        result.setShoKisaiHokenshaNo(t.get証記載保険者番号());
        result.setHihokenshaNo(new HihokenshaNo(t.get被保険者番号()));
        result.setKanriKubun(t.get管理区分());
        result.setMaxRirekiNo(edit履歴番号(t));

        return result;
    }

    @Override
    protected void process(ShiharaiHohoHenkoHaakuThreeEntity t) {
        TainoMaxRirekiNoTempTableEntity tempTableEntity = create滞納者対策最大履歴番号一時テーブル情報(t);
        tmpTableWriter.insert(tempTableEntity);
    }

    private int edit履歴番号(ShiharaiHohoHenkoHaakuThreeEntity t) {
        if (ShiharaiHenkoKanriKubun._２号差止.getコード().equals(t.get管理区分())) {
            return Integer.parseInt(t.get履歴番号().toString());
        } else if (ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(t.get管理区分())) {
            return Integer.parseInt(t.get履歴番号().toString());
        } else {
            return 0;
        }
    }
}
