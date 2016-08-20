/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120060;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KyufuJissekiRecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufujissekikoshinin.KyufuJissekiKoshinReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoControlCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvRecordKensuEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT1111KyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekikoshinin.KyufuJissekiKoshinReadCsvFileService;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績更新結果情報取込・ファイル読込を実行する。
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
public class KyufuJissekiKoshinReadCsvFileProcess extends BatchProcessBase<RString> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KyufuJissekiKoshinReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private final RString レコード種別 = new RString("1");
    private final RString 交換情報識別番号_1141 = new RString("1141");
    private final RString 交換情報識別番号_1142 = new RString("1142");
    private final RString 交換情報識別番号_1143 = new RString("1143");
    private final RString 交換情報識別番号_1144 = new RString("1144");
    private final RString 交換情報識別番号_1145 = new RString("1145");
    private final RString 交換情報識別番号_1146 = new RString("1146");
    private final RString 交換情報識別番号_1147 = new RString("1147");
    private final RString 交換情報識別番号_1148 = new RString("1148");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_2 = 2;
    private static final Integer INDEX_4 = 4;
    private static final RString エラー区分_登録対象なし = new RString("99");

    private KyufuJissekiKoshinJohoControlCSVEntity controlCsvEntity;
    private KyufuJissekiKoshinJohoDataEntity dataEntity;
    private KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity kihonMeisaiOneEntity;
    private KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity kihonMeisaiTwoEntity;
    private KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity kougakuKaigoMeisaiEntity;
    private KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity taisyogaiMeisaiEntity;
    private List<KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity> listCsvTaisyogaiMeisaiEntity;
    private KyufuJissekiKoshinReadCsvFileService service;

    @BatchWriter
    private IBatchTableWriter 被保険者一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 給付実績一時tableWriter;
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 給付実績一時_TABLE_NAME = new RString("DbWT1111KyufuJisseki");

    private OutputParameter<FlowEntity> flowEntity;
    private FlowEntity returnEntity;
    int 連番;

    @Override
    protected void initialize() {
        service = KyufuJissekiKoshinReadCsvFileService.createInstance();
        controlCsvEntity = new KyufuJissekiKoshinJohoControlCSVEntity();
        listCsvTaisyogaiMeisaiEntity = new ArrayList<>();
        returnEntity = new FlowEntity();
        連番 = parameter.get連番();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.get保存先フォルダ());
    }

    @Override
    protected void createWriter() {
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaIchijiEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
        給付実績一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績一時_TABLE_NAME, DbWT1111KyufuJissekiEntity.class);
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(カンマ.toString());
        if (レコード種別.equals(data.get(INDEX_0))) {
            controlCsvEntity = ListToObjectMappingHelper.
                    toObject(KyufuJissekiKoshinJohoControlCSVEntity.class, data);
        } else {
            if (KyufuJissekiRecordShubetsu.基本情報レコード.getコード().equals(data.get(INDEX_4))
                    && (交換情報識別番号_1141.equals(data.get(INDEX_2))
                    || 交換情報識別番号_1142.equals(data.get(INDEX_2))
                    || 交換情報識別番号_1143.equals(data.get(INDEX_2))
                    || 交換情報識別番号_1144.equals(data.get(INDEX_2)))) {
                addMeisai();
                kihonMeisaiOneEntity = ListToObjectMappingHelper.
                        toObject(KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity.class, data);
            } else if (KyufuJissekiRecordShubetsu.基本情報レコード.getコード().equals(data.get(INDEX_4))
                    && (交換情報識別番号_1145.equals(data.get(INDEX_2))
                    || 交換情報識別番号_1146.equals(data.get(INDEX_2))
                    || 交換情報識別番号_1147.equals(data.get(INDEX_2))
                    || 交換情報識別番号_1148.equals(data.get(INDEX_2)))) {
                addMeisai();
                kihonMeisaiTwoEntity = ListToObjectMappingHelper.
                        toObject(KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity.class, data);
            } else if (KyufuJissekiRecordShubetsu.介護給付費_高額介護サービス費情報レコード.getコード().equals(data.get(INDEX_4))
                    || KyufuJissekiRecordShubetsu.総合事業費_高額介護サービス費情報レコード.getコード().equals(data.get(INDEX_4))) {
                addMeisai();
                kougakuKaigoMeisaiEntity = ListToObjectMappingHelper.
                        toObject(KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity.class, data);
            } else {
                taisyogaiMeisaiEntity = ListToObjectMappingHelper.
                        toObject(KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity.class, data);
                listCsvTaisyogaiMeisaiEntity.add(taisyogaiMeisaiEntity);
            }
        }
    }

    @Override
    protected void afterExecute() {
        addMeisai();
        if (parameter.isLast() && 連番 == INDEX_0) {
            DbWT0002KokuhorenTorikomiErrorEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorEntity();
            errorTempentity.setShoHokanehshaNo(null);
            errorTempentity.setHihokenshaNo(null);
            errorTempentity.setErrorKubun(エラー区分_登録対象なし);
            errorTempentity.setState(EntityDataState.Added);
            処理結果リスト一時tableWriter.insert(errorTempentity);
        }
        do処理対象年月設定();
        returnEntity.setCodeNum(連番);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);

    }

    private void addMeisai() {
        if (null != kihonMeisaiOneEntity) {
            dataEntity = service.addMeisai(kihonMeisaiOneEntity, null, null, listCsvTaisyogaiMeisaiEntity, 処理結果リスト一時tableWriter);
            if (null != dataEntity) {
                KyufuJissekiKoshinJohoCsvRecordKensuEntity recordKensu = dataEntity.getRecordNumber();
                KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity kihonMeisaiOne = dataEntity.getKihonMeisaiOneEntity();
                連番 = 連番 + 1;
                service.insert給付実績一時TBL(連番, recordKensu, controlCsvEntity, kihonMeisaiOne, null, null, 給付実績一時tableWriter);
                service.insert被保険者一時TBL(連番, kihonMeisaiOne, null, null, 被保険者一時tableWriter);
            }
            kihonMeisaiOneEntity = null;
            listCsvTaisyogaiMeisaiEntity = new ArrayList<>();
        } else if (null != kihonMeisaiTwoEntity) {
            dataEntity = service.addMeisai(null, kihonMeisaiTwoEntity, null, listCsvTaisyogaiMeisaiEntity, 処理結果リスト一時tableWriter);
            if (null != dataEntity) {
                KyufuJissekiKoshinJohoCsvRecordKensuEntity recordKensu = dataEntity.getRecordNumber();
                KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity kihonMeisaiTwo = dataEntity.getKihonMeisaiTwoEntity();
                連番 = 連番 + 1;
                service.insert給付実績一時TBL(連番, recordKensu, controlCsvEntity, null, kihonMeisaiTwo, null, 給付実績一時tableWriter);
                service.insert被保険者一時TBL(連番, null, kihonMeisaiTwo, null, 被保険者一時tableWriter);
            }
            kihonMeisaiTwoEntity = null;
            listCsvTaisyogaiMeisaiEntity = new ArrayList<>();
        } else if (null != kougakuKaigoMeisaiEntity) {
            dataEntity = service.addMeisai(null, null, kougakuKaigoMeisaiEntity, listCsvTaisyogaiMeisaiEntity, 処理結果リスト一時tableWriter);
            if (null != dataEntity) {
                KyufuJissekiKoshinJohoCsvRecordKensuEntity recordKensu = dataEntity.getRecordNumber();
                KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity kougakuKaigoMeisai = dataEntity.getKougakuKaigoMeisaiEntity();
                連番 = 連番 + 1;
                service.insert給付実績一時TBL(連番, recordKensu, controlCsvEntity, null, null, kougakuKaigoMeisai, 給付実績一時tableWriter);
                service.insert被保険者一時TBL(連番, null, null, kougakuKaigoMeisai, 被保険者一時tableWriter);
            }
            kougakuKaigoMeisaiEntity = null;
            listCsvTaisyogaiMeisaiEntity = new ArrayList<>();
        }
    }

    private void do処理対象年月設定() {
        if (null == returnEntity.getShoriYM()) {
            FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(controlCsvEntity.get処理対象年月());
            returnEntity.setShoriYM(処理対象年月);
        }
    }
}
