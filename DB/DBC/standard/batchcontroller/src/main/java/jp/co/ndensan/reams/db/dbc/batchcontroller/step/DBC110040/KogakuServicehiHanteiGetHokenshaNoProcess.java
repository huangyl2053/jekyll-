/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.KogakuServicehiHanteiGetHokenshaNoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額サービス費給付判定結果情報作成・保険者番号取得を実行する。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
public class KogakuServicehiHanteiGetHokenshaNoProcess extends BatchProcessBase<KogakuServicehiHanteiGetHokenshaNoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakuservicehihanteikekkaout.IKogakuServicehiHanteikekkaOutJohoMapper.select保険者番号取得関連リスト");
    private List<RString> hokenshaNoList;
    private List<Integer> レコード件数List;
    private static final RString エラー区分_名称取得エラー = new RString("01");
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    /**
     * エントリ情報Listです。
     */
    public static final RString PARAMETER_OUT_OUTPUTENTRY;
    /**
     * レコード件数です。
     */
    public static final RString PARAMETER_OUT_OUTPUTCOUNT;

    static {
        PARAMETER_OUT_OUTPUTENTRY = new RString("outputEntry");
        PARAMETER_OUT_OUTPUTCOUNT = new RString("outputCount");
    }
    private OutputParameter<List> outputEntry;
    private OutputParameter<List> outputCount;

    @Override
    protected void initialize() {
        outputEntry = new OutputParameter<>();
        outputCount = new OutputParameter<>();
        hokenshaNoList = new ArrayList<>();
        レコード件数List = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(KogakuServicehiHanteiGetHokenshaNoEntity entity) {
        hokenshaNoList.add(entity.get保険者番号().getColumnValue());
        レコード件数List.add(entity.getレコード件数());
    }

    @Override
    protected void afterExecute() {
        outputEntry.setValue(hokenshaNoList);
        outputCount.setValue(レコード件数List);
        if (hokenshaNoList.isEmpty()) {
            DbWT1002KokuhorenSakuseiErrorTempEntity 処理結果 = new DbWT1002KokuhorenSakuseiErrorTempEntity();
            処理結果.setErrorKubun(エラー区分_名称取得エラー);
            処理結果.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
            処理結果.setHihokenshaNo(HihokenshaNo.EMPTY);
            処理結果.setKey1(RString.EMPTY);
            処理結果.setKey2(RString.EMPTY);
            処理結果.setKey3(RString.EMPTY);
            処理結果.setKey4(RString.EMPTY);
            処理結果.setKey4(RString.EMPTY);
            処理結果.setHihokenshaKanaShimei(RString.EMPTY);
            処理結果.setHihokenshaShimei(RString.EMPTY);
            処理結果.setBiko(RString.EMPTY);
            処理結果.setState(EntityDataState.Added);
            処理結果リスト一時tableWriter.insert(処理結果);
        }
    }
}
