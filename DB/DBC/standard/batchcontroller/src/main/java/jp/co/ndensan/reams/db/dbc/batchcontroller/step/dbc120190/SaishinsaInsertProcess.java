/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120190;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKetteiHokenshaInCSVGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKetteiHokenshaInCSVHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKetteiHokenshaInCSVMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInBatchCreate;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ファイルのデータを一時テーブルに設定する。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaInsertProcess extends BatchProcessBase<RString> {

    /**
     * ファイルパス
     */
    public static final RString PARAMETER_FILEPATH;

    static {
        PARAMETER_FILEPATH = new RString("filePath");
    }
    /**
     * MEISAI_TABLE_NAME
     */
    public static final RString MEISAI_TABLE_NAME;
    /**
     * GOKEI_TABLE_NAME
     */
    public static final RString GOKEI_TABLE_NAME;

    static {
        MEISAI_TABLE_NAME = new RString("SaishinsaKetteiTsuchishoJohoMeisai");
        GOKEI_TABLE_NAME = new RString("SaishinsaKetteiTsuchishoJohoShukei");
    }

    private static final RString レコード種別ヘッダ部 = new RString("H1");
    private static final RString レコード種別明細部 = new RString("D1");
    private static final RString レコード種別集計部 = new RString("T1");
    private static final RString 区切り文字 = new RString(",");
    private static final int INDEX_1 = 1;

    private SaishinsaKetteiHokenshaInCSVHeadEntity csvHeaderEntity;
    private List<SaishinsaKetteiHokenshaInCSVMeisaiEntity> csvMeisaiList;
    private SaishinsaKetteiHokenshaInCSVMeisaiEntity csvMeisaiEntity;
    private SaishinsaKetteiHokenshaInCSVGokeiEntity csvGokeiEntity;
    private SaishinsaKetteiHokenshaInBatchCreate batchCreate;
    InputParameter<RString> filePath;

    @BatchWriter
    BatchEntityCreatedTempTableWriter meisaiTableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter gokeiTableWriter;

    @Override
    protected void initialize() {
        super.initialize();
        csvMeisaiList = new ArrayList<>();
        batchCreate = new SaishinsaKetteiHokenshaInBatchCreate();
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(filePath.getValue());
    }

    @Override
    protected void createWriter() {

        meisaiTableWriter
                = new BatchEntityCreatedTempTableWriter(MEISAI_TABLE_NAME,
                        SaishinsaKetteiHokenshaInMeisaiEntity.class);
        gokeiTableWriter
                = new BatchEntityCreatedTempTableWriter(GOKEI_TABLE_NAME,
                        SaishinsaKetteiHokenshaInGokeiEntity.class);
    }

    @Override
    protected void process(RString line) {

        List<RString> data = line.split(区切り文字.toString());
        if (data == null || INDEX_1 >= data.size()) {
            return;
        }
        if (レコード種別ヘッダ部.equals(data.get(INDEX_1))) {
            csvHeaderEntity = ListToObjectMappingHelper.toObject(SaishinsaKetteiHokenshaInCSVHeadEntity.class, data);
        } else if (レコード種別明細部.equals(data.get(INDEX_1))) {
            csvMeisaiEntity = ListToObjectMappingHelper.toObject(SaishinsaKetteiHokenshaInCSVMeisaiEntity.class, data);
            csvMeisaiList.add(csvMeisaiEntity);
        } else if (レコード種別集計部.equals(data.get(INDEX_1))) {
            csvGokeiEntity = ListToObjectMappingHelper.toObject(SaishinsaKetteiHokenshaInCSVGokeiEntity.class, data);
        }
    }

    @Override
    protected void afterExecute() {
        Decimal 連番 = Decimal.ONE;
        if (csvMeisaiList != null && !csvMeisaiList.isEmpty() && csvHeaderEntity != null) {
            for (SaishinsaKetteiHokenshaInCSVMeisaiEntity 明細Entity : csvMeisaiList) {
                meisaiTableWriter.insert(batchCreate.createMeisaiEntity(csvHeaderEntity, 明細Entity, 連番));
                連番 = 連番.add(Decimal.ONE);
            }
        }
        if (csvGokeiEntity != null) {
            gokeiTableWriter.insert(batchCreate.createGokeiEntity(csvHeaderEntity, csvGokeiEntity));
        }
    }
}
