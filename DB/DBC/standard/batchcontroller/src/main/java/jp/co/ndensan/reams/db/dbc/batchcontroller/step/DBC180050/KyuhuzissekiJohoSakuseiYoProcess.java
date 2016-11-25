/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufusakuseikubun.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KyuhuzissekiJohoSakuseiYoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KyuhuzissekiJohoSakuseiYoTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(給付実績情報作成用Process)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class KyuhuzissekiJohoSakuseiYoProcess extends BatchProcessBase<KyuhuzissekiJohoSakuseiYoResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.get給付実績情報作成用データ");
    @BatchWriter
    private IBatchTableWriter<KyuhuzissekiJohoSakuseiYoTempEntity> tempTableWriter;
    private static final RString TEMP_TABLE = new RString("kyuhuzissekiJohoSakuseiYoTemp");
    private KyuhuzissekiJohoSakuseiYoTempEntity tempTable;
    private List<KyuhuzissekiJohoSakuseiYoResultEntity> emptyResultList;
    private List<KyuhuzissekiJohoSakuseiYoResultEntity> bigestResultList;
    private boolean 開始Flag;
    private boolean emptyFlag;
    private boolean 審査年月Flag;
    private FlexibleYearMonth 審査年月;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private NyuryokuShikibetsuNo 入力識別番号;
    private JigyoshaNo 事業所番号;
    private RString 通し番号;
    private static final int INT_1 = 1;

    @Override
    protected void initialize() {
        審査年月Flag = true;
        開始Flag = true;
        emptyFlag = false;
        審査年月 = FlexibleYearMonth.EMPTY;
        被保険者番号 = HihokenshaNo.EMPTY;
        サービス提供年月 = FlexibleYearMonth.EMPTY;
        入力識別番号 = NyuryokuShikibetsuNo.EMPTY;
        事業所番号 = JigyoshaNo.EMPTY;
        通し番号 = RString.EMPTY;
        emptyResultList = new ArrayList<>();
        bigestResultList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tempTableWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                KyuhuzissekiJohoSakuseiYoTempEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(KyuhuzissekiJohoSakuseiYoResultEntity entity) {
        if (開始Flag) {
            set判断引数の値(entity);
        }
        if (被保険者番号.equals(entity.get被保険者番号())
                && サービス提供年月.equals(entity.getサービス提供年月())
                && 入力識別番号.equals(entity.get入力識別番号())
                && 事業所番号.equals(entity.get事業所番号())
                && 通し番号.equals(entity.get通し番号())) {
            getResultList(entity);
            開始Flag = false;
        } else {
            set判断引数の値(entity);
            insertTempTable();
            emptyResultList.clear();
            bigestResultList.clear();
            getResultList(entity);
        }
    }

    @Override
    protected void afterExecute() {
        insertTempTable();
        emptyResultList.clear();
        bigestResultList.clear();
    }

    private void insertTempTable() {
        if (!emptyResultList.isEmpty()) {
            for (KyuhuzissekiJohoSakuseiYoResultEntity emptyResultEntity : emptyResultList) {
                getTempTable(emptyResultEntity);
            }
        } else if (bigestResultList.size() == INT_1) {
            getTempTable(bigestResultList.get(0));
        } else {
            for (KyuhuzissekiJohoSakuseiYoResultEntity bigestResultEntity : bigestResultList) {
                if (KyufuSakuseiKubun.新規.getコード().equals(bigestResultEntity.get給付実績情報作成区分コード())) {
                    getTempTable(bigestResultEntity);
                }
            }
        }
    }

    private void getTempTable(KyuhuzissekiJohoSakuseiYoResultEntity entity) {
        tempTable = new KyuhuzissekiJohoSakuseiYoTempEntity();
        tempTable.setサービス提供年月(entity.getサービス提供年月());
        tempTable.set事業所番号(entity.get事業所番号());
        tempTable.set保険給付率(entity.get保険給付率());
        tempTable.set入力識別番号(entity.get入力識別番号());
        tempTable.set審査年月(entity.get審査年月());
        tempTable.set年度(entity.get年度());
        tempTable.set年月(entity.get年月());
        tempTable.set整理番号(entity.get整理番号());
        tempTable.set給付実績情報作成区分コード(entity.get給付実績情報作成区分コード());
        tempTable.set被保険者番号(entity.get被保険者番号());
        tempTable.set証記載保険者番号(entity.get証記載保険者番号());
        tempTable.set通し番号(entity.get通し番号());
        tempTableWriter.insert(tempTable);
    }

    private void getResultList(KyuhuzissekiJohoSakuseiYoResultEntity entity) {
        if (entity.get審査年月().isEmpty()) {
            emptyResultList.add(entity);
            emptyFlag = true;
        } else if (!emptyFlag) {
            if (審査年月Flag || 審査年月.equals(entity.get審査年月())) {
                審査年月 = entity.get審査年月();
                bigestResultList.add(entity);
                審査年月Flag = false;
            }

            if (審査年月.isBefore(entity.get審査年月())) {
                審査年月 = entity.get審査年月();
                bigestResultList.clear();
                bigestResultList.add(entity);
            }
        }
    }

    private void set判断引数の値(KyuhuzissekiJohoSakuseiYoResultEntity entity) {
        被保険者番号 = entity.get被保険者番号();
        サービス提供年月 = entity.getサービス提供年月();
        入力識別番号 = entity.get入力識別番号();
        事業所番号 = entity.get事業所番号();
        通し番号 = entity.get通し番号();
        審査年月Flag = true;
        emptyFlag = false;
    }

}
