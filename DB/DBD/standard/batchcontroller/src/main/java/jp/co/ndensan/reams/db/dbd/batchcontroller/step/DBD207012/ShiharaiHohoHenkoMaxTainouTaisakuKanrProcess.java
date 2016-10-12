/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ShiharaiHohoHenkoMaxTainouTaisakuKanrProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuThreeEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHakuListMainMapper.find最大履歴情報");

    private Map<RString, List<ShiharaiHohoHenkoHaakuThreeEntity>> resultMap;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected void initialize() {
        resultMap = new HashMap<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(TainoMaxRirekiNoTempTableEntity.class)
                .tempTableName(TainoMaxRirekiNoTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShiharaiHohoHenkoHaakuThreeEntity t) {
        if (resultMap.containsKey(t.get被保険者番号())) {
            resultMap.get(t.get被保険者番号()).add(t);
        } else {
            List<ShiharaiHohoHenkoHaakuThreeEntity> list = new ArrayList<>();
            list.add(t);
            resultMap.put(t.get被保険者番号(), list);
        }
    }

    @Override
    protected void afterExecute() {
        滞納者対策最大履歴番号一時テーブル情報追加(resultMap);
    }

    private void 滞納者対策最大履歴番号一時テーブル情報追加(Map<RString, List<ShiharaiHohoHenkoHaakuThreeEntity>> resultMap) {
        for (RString key : resultMap.keySet()) {
            List<ShiharaiHohoHenkoHaakuThreeEntity> dataList = resultMap.get(key);

            boolean 管理区分_差止 = false;
            boolean 管理区分_償還払い化 = false;

            int 履歴番号 = 0;

            for (ShiharaiHohoHenkoHaakuThreeEntity data : dataList) {
                if (ShiharaiHenkoKanriKubun._２号差止.getコード().equals(data.get管理区分())) {
                    管理区分_差止 = true;
                    履歴番号 = data.get履歴番号();
                    break;
                } else if (ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(data.get管理区分())) {
                    履歴番号 = data.get履歴番号();
                    管理区分_償還払い化 = true;
                }
            }

            if (管理区分_差止 || 管理区分_償還払い化) {
                for (ShiharaiHohoHenkoHaakuThreeEntity data : dataList) {
                    data.set履歴番号(履歴番号);
                }
            }

            for (ShiharaiHohoHenkoHaakuThreeEntity data : dataList) {
                TainoMaxRirekiNoTempTableEntity result = new TainoMaxRirekiNoTempTableEntity();
                result.setShoKisaiHokenshaNo(data.get証記載保険者番号());
                result.setHihokenshaNo(new HihokenshaNo(data.get被保険者番号()));
                result.setKanriKubun(data.get管理区分());
                result.setMaxRirekiNo(data.get履歴番号());
                tmpTableWriter.insert(result);
            }
        }
    }
}
