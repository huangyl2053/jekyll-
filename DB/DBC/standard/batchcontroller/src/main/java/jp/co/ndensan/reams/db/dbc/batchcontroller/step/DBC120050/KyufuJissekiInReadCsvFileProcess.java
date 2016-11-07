/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufujissekikoshinin.KyufuJissekiKoshinReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenkyotsu.KokuhorenkyoutsuControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111AKyufuJissekiH11CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111AKyufuJissekiH12CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111BKyufuJissekiD1CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111CKyufuJissekiD2CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111DKyufuJissekiD31CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111EKyufuJissekiD32CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111FKyufuJissekiD4CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111GKyufuJissekiD51CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111GKyufuJissekiD52CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111GKyufuJissekiD53CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111HKyufuJissekiD6CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111IKyufuJissekiD7CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111JKyufuJissekiD8CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111KKyufuJissekiD9CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111LKyufuJissekiDACsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111MKyufuJissekiDBCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111NKyufuJissekiDCCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111OKyufuJissekiDDCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.DbWT111ZKyufuJissekiT1CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111AKyufuJissekiH1Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111BKyufuJissekiD1Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111CKyufuJissekiD2Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111DKyufuJissekiD31Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111EKyufuJissekiD32Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111FKyufuJissekiD4Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111GKyufuJissekiD5Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111HKyufuJissekiD6Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111IKyufuJissekiD7Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111JKyufuJissekiD8Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111KKyufuJissekiD9Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111LKyufuJissekiDAEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111MKyufuJissekiDBEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111NKyufuJissekiDCEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111OKyufuJissekiDDEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111ZKyufuJissekiT1Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvListReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績情報取込
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class KyufuJissekiInReadCsvFileProcess extends BatchProcessBase<List<RString>> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KyufuJissekiKoshinReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private OutputParameter<FlowEntity> flowEntity;
    FlowEntity returnEntity;

    private final RString 区切り文字 = new RString(",");
    private final RString レコード種別 = new RString("1");
    private final RString レコード種別_エンド = new RString("3");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private final RString 帳票レコード種別_D2 = new RString("D2");
    private final RString 帳票レコード種別_D3 = new RString("D3");
    private final RString 帳票レコード種別_D4 = new RString("D4");
    private final RString 帳票レコード種別_D5 = new RString("D5");
    private final RString 帳票レコード種別_D6 = new RString("D6");
    private final RString 帳票レコード種別_D7 = new RString("D7");
    private final RString 帳票レコード種別_D8 = new RString("D8");
    private final RString 帳票レコード種別_DE = new RString("DE");
    private final RString 帳票レコード種別_D9 = new RString("D9");
    private final RString 帳票レコード種別_DA = new RString("DA");
    private final RString 帳票レコード種別_DB = new RString("DB");
    private final RString 帳票レコード種別_DC = new RString("DC");
    private final RString 帳票レコード種別_DD = new RString("DD");
    private final RString 帳票レコード種別_T1 = new RString("T1");
    private final NyuryokuShikibetsuNo 入力識別番号_3411 = new NyuryokuShikibetsuNo("3411");
    private final NyuryokuShikibetsuNo 入力識別番号_3421 = new NyuryokuShikibetsuNo("3421");

    private static final RString DATA_1111 = new RString("1111");
    private static final RString DATA_1112 = new RString("1112");
    private static final RString DATA_1113 = new RString("1113");
    private static final RString DATA_1114 = new RString("1114");
    private static final RString DATA_1115 = new RString("1115");
    private static final RString DATA_1116 = new RString("1116");
    private static final Integer INDEX_0 = 0;
    private static final Integer INT_1 = 1;
    private static final Integer INT_2 = 2;
    private static final Integer INDEX_4 = 4;
    private static final int DATA_10 = 10;
    private static final int DATA_100 = 100;
    private static final RString 国保連受取 = new RString("0");
    private static final RString 事業所番号_0 = new RString("0000000000");

    private int endIndex;
    private int beginIndex;
    private int 連番;
    private int データ件数;
    private int レコード番号h1;
    private int レコード番号d1;
    private int レコード番号dd;
    private int レコード番号d2;
    private int レコード番号dc;
    private int レコード番号d3;
    private int レコード番号d4;
    private int レコード番号d5;
    private int レコード番号d6;
    private int レコード番号d7;
    private int レコード番号d8;
    private int レコード番号de;
    private int レコード番号t1;
    private int レコード番号d9;
    private int レコード番号da;
    private int レコード番号db;

    private KokuhorenkyoutsuControlCsvEntity controlCsvEntity;
    private DbWT111AKyufuJissekiH11CsvEntity h11CsvEntity;
    private DbWT111AKyufuJissekiH12CsvEntity h12CsvEntity;
    private DbWT111ZKyufuJissekiT1CsvEntity t1CsvEntity;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績H1一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績D1一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績D2一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績D31一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績D32一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績D4一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績D5一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績D6一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績D7一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績D8一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績D9一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績DA一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績DB一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績DC一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績DD一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績T1一時tableWriter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;

    private static final RString 給付実績H1一時_TABLE_NAME = new RString("DbWT111AKyufuJissekiH1");
    private static final RString 給付実績D1一時_TABLE_NAME = new RString("DbWT111BKyufuJissekiD1");
    private static final RString 給付実績D2一時_TABLE_NAME = new RString("DbWT111CKyufuJissekiD2");
    private static final RString 給付実績D31一時_TABLE_NAME = new RString("DbWT111DKyufuJissekiD31");
    private static final RString 給付実績D32一時_TABLE_NAME = new RString("DbWT111EKyufuJissekiD32");
    private static final RString 給付実績D4一時_TABLE_NAME = new RString("DbWT111FKyufuJissekiD4");
    private static final RString 給付実績D5一時_TABLE_NAME = new RString("DbWT111GKyufuJissekiD5");
    private static final RString 給付実績D6一時_TABLE_NAME = new RString("DbWT111HKyufuJissekiD6");
    private static final RString 給付実績D7一時_TABLE_NAME = new RString("DbWT111IKyufuJissekiD7");
    private static final RString 給付実績D8一時_TABLE_NAME = new RString("DbWT111JKyufuJissekiD8");
    private static final RString 給付実績D9一時_TABLE_NAME = new RString("DbWT111KKyufuJissekiD9");
    private static final RString 給付実績DA一時_TABLE_NAME = new RString("DbWT111LKyufuJissekiDA");
    private static final RString 給付実績DB一時_TABLE_NAME = new RString("DbWT111MKyufuJissekiDB");
    private static final RString 給付実績DC一時_TABLE_NAME = new RString("DbWT111NKyufuJissekiDC");
    private static final RString 給付実績DD一時_TABLE_NAME = new RString("DbWT111OKyufuJissekiDD");
    private static final RString 給付実績T1一時_TABLE_NAME = new RString("DbWT111ZKyufuJissekiT1");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");

    @Override
    protected void initialize() {
        returnEntity = new FlowEntity();
        controlCsvEntity = new KokuhorenkyoutsuControlCsvEntity();
        連番 = parameter.get連番();
        データ件数 = parameter.getデータ登録件数();
        レコード番号h1 = INDEX_0;
        レコード番号d1 = INDEX_0;
        レコード番号dd = INDEX_0;
        レコード番号d2 = INDEX_0;
        レコード番号dc = INDEX_0;
        レコード番号d3 = INDEX_0;
        レコード番号d4 = INDEX_0;
        レコード番号d5 = INDEX_0;
        レコード番号d6 = INDEX_0;
        レコード番号d7 = INDEX_0;
        レコード番号d8 = INDEX_0;
        レコード番号de = INDEX_0;
        レコード番号d9 = INDEX_0;
        レコード番号da = INDEX_0;
        レコード番号db = INDEX_0;
        flowEntity = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchCsvListReader(new CsvListReader.InstanceBuilder(parameter.get保存先フォルダ())
                .setDelimiter(区切り文字).setEncode(Encode.SJIS).hasHeader(false).setNewLine(NewLine.CRLF).build());
    }

    @Override
    protected void createWriter() {
        給付実績H1一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績H1一時_TABLE_NAME, DbWT111AKyufuJissekiH1Entity.class);
        給付実績D1一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D1一時_TABLE_NAME, DbWT111BKyufuJissekiD1Entity.class);
        給付実績D2一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D2一時_TABLE_NAME, DbWT111CKyufuJissekiD2Entity.class);
        給付実績D31一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D31一時_TABLE_NAME, DbWT111DKyufuJissekiD31Entity.class);
        給付実績D32一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D32一時_TABLE_NAME, DbWT111EKyufuJissekiD32Entity.class);
        給付実績D4一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D4一時_TABLE_NAME, DbWT111FKyufuJissekiD4Entity.class);
        給付実績D5一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D5一時_TABLE_NAME, DbWT111GKyufuJissekiD5Entity.class);
        給付実績D6一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D6一時_TABLE_NAME, DbWT111HKyufuJissekiD6Entity.class);
        給付実績D7一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D7一時_TABLE_NAME, DbWT111IKyufuJissekiD7Entity.class);
        給付実績D8一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D8一時_TABLE_NAME, DbWT111JKyufuJissekiD8Entity.class);
        給付実績D9一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D9一時_TABLE_NAME, DbWT111KKyufuJissekiD9Entity.class);
        給付実績DA一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績DA一時_TABLE_NAME, DbWT111LKyufuJissekiDAEntity.class);
        給付実績DB一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績DB一時_TABLE_NAME, DbWT111MKyufuJissekiDBEntity.class);
        給付実績DC一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績DC一時_TABLE_NAME, DbWT111NKyufuJissekiDCEntity.class);
        給付実績DD一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績DD一時_TABLE_NAME, DbWT111OKyufuJissekiDDEntity.class);
        給付実績T1一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績T1一時_TABLE_NAME, DbWT111ZKyufuJissekiT1Entity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(List<RString> data) {
        if (data != null && !data.isEmpty()) {
            if (レコード種別_エンド.equals(data.get(INDEX_0))) {
                return;
            }
            if (レコード種別.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.
                        toObject(KokuhorenkyoutsuControlCsvEntity.class, data);
                returnEntity.setShoriYM(new FlexibleYearMonth(controlCsvEntity.getShoriYM()));
            } else {
                get一時TBL(data);
            }

        }
    }

    @Override
    protected void afterExecute() {
        returnEntity.set明細データ登録件数(データ件数);
        returnEntity.set集計データ登録件数(連番);
        returnEntity.setCodeNum(Integer.valueOf(controlCsvEntity.getCodeNum().toString()));
        flowEntity.setValue(returnEntity);
    }

    private void get一時TBL(List<RString> data) {
        if (帳票レコード種別_H1.equals(data.get(INDEX_4))) {
            連番 = 連番 + INT_1;
            データ件数 = データ件数 + INT_1;
            レコード番号h1 = レコード番号h1 + INT_1;
            get交換情報識別番号h1(data, レコード番号h1);
        } else if (帳票レコード種別_D1.equals(data.get(INDEX_4))) {
            DbWT111BKyufuJissekiD1CsvEntity d1CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111BKyufuJissekiD1CsvEntity.class, data);
            データ件数 = データ件数 + INT_1;
            レコード番号d1 = レコード番号d1 + INT_1;
            d1一時TBLに登録する(d1CsvEntity, レコード番号d1);
        } else if (帳票レコード種別_D2.equals(data.get(INDEX_4))) {
            DbWT111CKyufuJissekiD2CsvEntity d2CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111CKyufuJissekiD2CsvEntity.class, data);
            データ件数 = データ件数 + INT_1;
            レコード番号d2 = レコード番号d2 + INT_1;
            d2一時TBLに登録する(d2CsvEntity, レコード番号d2);
        } else if (帳票レコード種別_D3.equals(data.get(INDEX_4))) {
            データ件数 = データ件数 + INT_1;
            レコード番号d3 = レコード番号d3 + INT_1;
            get交換情報識別番号d3(data, レコード番号d3);
        } else if (帳票レコード種別_D4.equals(data.get(INDEX_4))) {
            DbWT111FKyufuJissekiD4CsvEntity d4CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111FKyufuJissekiD4CsvEntity.class, data);
            データ件数 = データ件数 + INT_1;
            レコード番号d4 = レコード番号d4 + INT_1;
            d4一時TBLに登録する(d4CsvEntity, レコード番号d4);
        } else if (帳票レコード種別_D5.equals(data.get(INDEX_4))) {
            データ件数 = データ件数 + INT_1;
            レコード番号d5 = レコード番号d5 + INT_1;
            get交換情報識別番号d5(data, レコード番号d5);
        } else if (帳票レコード種別_D6.equals(data.get(INDEX_4))) {
            DbWT111HKyufuJissekiD6CsvEntity d6CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111HKyufuJissekiD6CsvEntity.class, data);
            データ件数 = データ件数 + INT_1;
            レコード番号d6 = レコード番号d6 + INT_1;
            d6一時TBLに登録する(d6CsvEntity, レコード番号d6);
        } else if (帳票レコード種別_D7.equals(data.get(INDEX_4))) {
            DbWT111IKyufuJissekiD7CsvEntity d7CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111IKyufuJissekiD7CsvEntity.class, data);
            データ件数 = データ件数 + INT_1;
            レコード番号d7 = レコード番号d7 + INT_1;
            d7一時TBLに登録する(d7CsvEntity, レコード番号d7);
        } else if (帳票レコード種別_D8.equals(data.get(INDEX_4))) {
            DbWT111JKyufuJissekiD8CsvEntity d8CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111JKyufuJissekiD8CsvEntity.class, data);
            連番 = 連番 + INT_1;
            データ件数 = データ件数 + INT_1;
            レコード番号d8 = レコード番号d8 + INT_1;
            d8一時TBLに登録する(d8CsvEntity, レコード番号d8);
        } else if (帳票レコード種別_DE.equals(data.get(INDEX_4))) {
            DbWT111JKyufuJissekiD8CsvEntity d8CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111JKyufuJissekiD8CsvEntity.class, data);
            連番 = 連番 + INT_1;
            データ件数 = データ件数 + INT_1;
            レコード番号de = レコード番号de + INT_1;
            d8一時TBLに登録する(d8CsvEntity, レコード番号de);
        } else if (帳票レコード種別_D9.equals(data.get(INDEX_4))) {
            DbWT111KKyufuJissekiD9CsvEntity d9CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111KKyufuJissekiD9CsvEntity.class, data);
            データ件数 = データ件数 + INT_1;
            レコード番号d9 = レコード番号d9 + INT_1;
            d9一時TBLに登録する(d9CsvEntity, レコード番号d9);
        } else if (帳票レコード種別_DA.equals(data.get(INDEX_4))) {
            DbWT111LKyufuJissekiDACsvEntity daCsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111LKyufuJissekiDACsvEntity.class, data);
            データ件数 = データ件数 + INT_1;
            レコード番号da = レコード番号da + INT_1;
            da一時TBLに登録する(daCsvEntity, レコード番号da);
        } else if (帳票レコード種別_DB.equals(data.get(INDEX_4))) {
            DbWT111MKyufuJissekiDBCsvEntity dbCsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111MKyufuJissekiDBCsvEntity.class, data);
            データ件数 = データ件数 + INT_1;
            レコード番号db = レコード番号db + INT_1;
            db一時TBLに登録する(dbCsvEntity, レコード番号db);
        } else if (帳票レコード種別_DC.equals(data.get(INDEX_4))) {
            DbWT111NKyufuJissekiDCCsvEntity dcCsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111NKyufuJissekiDCCsvEntity.class, data);
            データ件数 = データ件数 + INT_1;
            レコード番号dc = レコード番号dc + INT_1;
            dc一時TBLに登録する(dcCsvEntity, レコード番号dc);
        } else if (帳票レコード種別_DD.equals(data.get(INDEX_4))) {
            DbWT111OKyufuJissekiDDCsvEntity ddCsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111OKyufuJissekiDDCsvEntity.class, data);
            データ件数 = データ件数 + INT_1;
            レコード番号dd = レコード番号dd + INT_1;
            dd一時TBLに登録する(ddCsvEntity, レコード番号dd);
        } else if (帳票レコード種別_T1.equals(data.get(INDEX_4))) {
            t1CsvEntity = new DbWT111ZKyufuJissekiT1CsvEntity();
            t1CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111ZKyufuJissekiT1CsvEntity.class, data);
            データ件数 = データ件数 + INT_1;
            レコード番号t1 = レコード番号t1 + INT_1;
            t1一時TBLに登録する(t1CsvEntity, レコード番号t1);
        }

    }

    private void get交換情報識別番号h1(List<RString> data, int レコード番号) {
        if (data.get(INT_2).equals(DATA_1111)
                || data.get(INT_2).equals(DATA_1112)
                || data.get(INT_2).equals(DATA_1113)
                || data.get(INT_2).equals(DATA_1114)) {
            h11CsvEntity = new DbWT111AKyufuJissekiH11CsvEntity();
            h11CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111AKyufuJissekiH11CsvEntity.class, data);
            h11一時TBLに登録する(h11CsvEntity, レコード番号);
        } else if (DATA_1115.compareTo(data.get(INT_2)) <= INDEX_0) {
            h12CsvEntity = new DbWT111AKyufuJissekiH12CsvEntity();
            h12CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111AKyufuJissekiH12CsvEntity.class, data);
            h12一時TBLに登録する(h12CsvEntity, レコード番号);
        }
    }

    private void get交換情報識別番号d3(List<RString> data, int レコード番号) {
        if (data.get(INT_2).equals(DATA_1111)) {
            DbWT111DKyufuJissekiD31CsvEntity d31CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111DKyufuJissekiD31CsvEntity.class, data);
            d31一時TBLに登録する(d31CsvEntity, レコード番号);
        } else if (DATA_1112.compareTo(data.get(INT_2)) <= INDEX_0) {
            DbWT111EKyufuJissekiD32CsvEntity d32CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111EKyufuJissekiD32CsvEntity.class, data);
            d32一時TBLに登録する(d32CsvEntity, レコード番号);
        }
    }

    private void get交換情報識別番号d5(List<RString> data, int レコード番号) {
        if (data.get(INT_2).equals(DATA_1111)
                || data.get(INT_2).equals(DATA_1112)
                || data.get(INT_2).equals(DATA_1113)) {
            DbWT111GKyufuJissekiD51CsvEntity d51CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111GKyufuJissekiD51CsvEntity.class, data);
            d51一時TBLに登録する(d51CsvEntity, レコード番号);
        } else if (data.get(INT_2).equals(DATA_1114)
                || data.get(INT_2).equals(DATA_1115)) {
            DbWT111GKyufuJissekiD52CsvEntity d52CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111GKyufuJissekiD52CsvEntity.class, data);
            d52一時TBLに登録する(d52CsvEntity, レコード番号);
        } else if (DATA_1116.compareTo(data.get(INT_2)) <= INDEX_0) {
            DbWT111GKyufuJissekiD53CsvEntity d53CsvEntity = ListToObjectMappingHelper.
                    toObject(DbWT111GKyufuJissekiD53CsvEntity.class, data);
            d53一時TBLに登録する(d53CsvEntity, レコード番号);
        }
    }

    private void h11一時TBLに登録する(DbWT111AKyufuJissekiH11CsvEntity h11CsvEntity, int レコード番号) {
        DbWT111AKyufuJissekiH1Entity 登録H11Entity = new DbWT111AKyufuJissekiH1Entity();
        登録H11Entity.setRenban(連番);
        登録H11Entity.setRecordNo(new RString(レコード番号));
        登録H11Entity.setKokanShikibetsuNo(h11CsvEntity.get交換情報識別番号());
        登録H11Entity.setInputShikibetsuNo(h11CsvEntity.get入力識別番号());
        登録H11Entity.setRecodeShubetsuCode(get非空文字列(h11CsvEntity.getレコード種別コード()));
        登録H11Entity.setShokisaiHokenshaNo(h11CsvEntity.get証記載保険者番号());
        登録H11Entity.setHiHokenshaNo(h11CsvEntity.get被保険者番号());
        登録H11Entity.setServiceTeikyoYM(get非空年月(h11CsvEntity.getサービス提供年月()));
        登録H11Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(h11CsvEntity.get事業所番号())));
        登録H11Entity.setKyufuSakuseiKubunCode(get非空文字列(h11CsvEntity.get給付実績情報作成区分コード()));
        登録H11Entity.setKyufuJissekiKubunCode(get非空文字列(h11CsvEntity.get給付実績区分コード()));
        登録H11Entity.setToshiNo(RString.EMPTY);
        登録H11Entity.setKohi1FutanshaNo(get非空文字列(h11CsvEntity.get公費１_負担者番号()));
        登録H11Entity.setKohi1JukyushaNo(get非空文字列(h11CsvEntity.get公費１_受給者番号()));
        登録H11Entity.setKohi2FutanshaNo(get非空文字列(h11CsvEntity.get公費２_負担者番号()));
        登録H11Entity.setKohi2JukyushaNo(get非空文字列(h11CsvEntity.get公費２_受給者番号()));
        登録H11Entity.setKohi3FutanshaNo(get非空文字列(h11CsvEntity.get公費３_負担者番号()));
        登録H11Entity.setKohi3JukyushaNo(get非空文字列(h11CsvEntity.get公費３_受給者番号()));
        登録H11Entity.setUmareYMD(get非空年月日(h11CsvEntity.get生年月日()));
        登録H11Entity.setSeibetsuCode(get非空文字列(h11CsvEntity.get性別コード()));
        登録H11Entity.setYoKaigoJotaiKubunCode(get非空文字列(h11CsvEntity.get要介護状態区分コード()));
        登録H11Entity.setKyuSochiNyushoshaTokureiCode(get非空文字列(h11CsvEntity.get旧措置入所者特例コード()));
        登録H11Entity.setNinteiYukoKaishiYMD(get非空年月日(h11CsvEntity.get認定有効期間_開始年月日()));
        登録H11Entity.setNinteiYukoShuryoYMD(get非空年月日(h11CsvEntity.get認定有功期間_終了年月日()));
        登録H11Entity.setRojinHokenShichosonNo(get非空文字列(h11CsvEntity.get老人保健市町村番号()));
        登録H11Entity.setRojinhokenJukyushaNo(get非空文字列(h11CsvEntity.get老人保健受給者番号()));
        登録H11Entity.setKokiHokenshaNo(RString.EMPTY);
        登録H11Entity.setKokiHiHokenshaNo(RString.EMPTY);
        登録H11Entity.setKokuhoHokenshaNo(RString.EMPTY);
        登録H11Entity.setKokuhoHiHokenshashoNo(RString.EMPTY);
        登録H11Entity.setKokuhoKojinNo(RString.EMPTY);
        登録H11Entity.setKyotakuServiceSakuseiKubunCode(get非空文字列(h11CsvEntity.get居宅サービス計画作成区分コード()));
        登録H11Entity.setKyotakuKaigoShienJigyoshoNo(new JigyoshaNo(get事業所番号(
                h11CsvEntity.get事業所番号_居宅介護支援事業所等())));
        登録H11Entity.setKaishiYMD(get非空年月日(h11CsvEntity.get開始年月日()));
        登録H11Entity.setChushiYMD(get非空年月日(h11CsvEntity.get中止年月日()));
        登録H11Entity.setChushiRiyuNyushomaeJyokyoCode(get非空文字列(h11CsvEntity.get中止理由_入所院前の状況コード()));
        登録H11Entity.setNyushoYMD(get非空年月日(h11CsvEntity.get入所年月日()));
        登録H11Entity.setTaishoYMD(get非空年月日(h11CsvEntity.get退所年月日()));
        登録H11Entity.setNyushoJitsunissu(h11CsvEntity.get入所実日数());
        登録H11Entity.setGaihakuNissu(h11CsvEntity.get外泊日数());
        登録H11Entity.setTaishogoJotaiCode(get非空文字列(h11CsvEntity.get退所後の状態コード()));
        登録H11Entity.setHokenKyufuritsu(get非空給付率(h11CsvEntity.get保険給付率()));
        登録H11Entity.setKohi1Kyufuritsu(get非空給付率(h11CsvEntity.get公費１給付率()));
        登録H11Entity.setKohi2Kyufuritsu(get非空給付率(h11CsvEntity.get公費２給付率()));
        登録H11Entity.setKohi3Kyufuritsu(get非空給付率(h11CsvEntity.get公費３給付率()));
        登録H11Entity.setMaeHokenServiceTanisu(h11CsvEntity.get前_保険_サービス単位数());
        登録H11Entity.setMaeHokenSeikyugaku(get非空数字(h11CsvEntity.get前_保険_請求額()));
        登録H11Entity.setMaeHokenRiyoshaFutangaku(h11CsvEntity.get前_保険_利用者負担額());
        登録H11Entity.setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(get非空数字(h11CsvEntity.get前_保険_緊急時施設療養費請求額()));
        登録H11Entity.setMaeHokenTokuteiShinryohiSeikyugaku(get非空数字(h11CsvEntity.get前_保険_特定診療費請求額()));
        登録H11Entity.setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(
                get非空数字(h11CsvEntity.get前_保険_特定入所者介護サービス費等請求額()));
        登録H11Entity.setMaeKohi1ServiceTanisu(h11CsvEntity.get前_公費１_サービス単位数());
        登録H11Entity.setMaeKohi1Seikyugaku(h11CsvEntity.get前_公費１_請求額());
        登録H11Entity.setMaeKohi1RiyoshaFutangaku(h11CsvEntity.get前_公費１_本人負担額());
        登録H11Entity.setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(h11CsvEntity.get前_公費１_緊急時施設療養費請求額());
        登録H11Entity.setMaeKohi1TokuteiShinryohiSeikyugaku(h11CsvEntity.get前_公費１_特定診療費請求額());
        登録H11Entity.setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(h11CsvEntity.get前_公費１_特定入所者介護サービス費等請求額());
        登録H11Entity.setMaeKohi2ServiceTanisu(h11CsvEntity.get前_公費２_サービス単位数());
        登録H11Entity.setMaeKohi2Seikyugaku(h11CsvEntity.get前_公費２_請求額());
        登録H11Entity.setMaeKohi2RiyoshaFutangaku(h11CsvEntity.get前_公費２_本人負担額());
        登録H11Entity.setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(h11CsvEntity.get前_公費２_緊急時施設療養費請求額());
        登録H11Entity.setMaeKohi2TokuteiShinryohiSeikyugaku(h11CsvEntity.get前_公費２_特定診療費請求額());
        登録H11Entity.setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(h11CsvEntity.get前_公費２_特定入所者介護サービス費等請求額());
        登録H11Entity.setMaeKohi3ServiceTanisu(h11CsvEntity.get前_公費３_サービス単位数());
        登録H11Entity.setMaeKohi3Seikyugaku(h11CsvEntity.get前_公費３_請求額());
        登録H11Entity.setMaeKohi3RiyoshaFutangaku(h11CsvEntity.get前_公費３_本人負担額());
        登録H11Entity.setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(h11CsvEntity.get後_公費３_緊急時施設療養費請求額());
        登録H11Entity.setMaeKohi3TokuteiShinryohiSeikyugaku(h11CsvEntity.get前_公費３_特定診療費請求額());
        登録H11Entity.setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(h11CsvEntity.get前_公費３_特定入所者介護サービス費等請求額());
        登録H11Entity.setAtoHokenServiceTanisu(h11CsvEntity.get後_保険_サービス単位数());
        登録H11Entity.setAtoHokenSeikyugaku(get非空数字(h11CsvEntity.get後_保険_請求額()));
        登録H11Entity.setAtoHokenRiyoshaFutangaku(h11CsvEntity.get後_保険_利用者負担額());
        登録H11Entity.setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(get非空数字(h11CsvEntity.get後_緊急時施設療養費請求額()));
        登録H11Entity.setAtoHokenTokuteiShinryohiSeikyugaku(get非空数字(h11CsvEntity.get後_保険_特定診療費請求額()));
        登録H11Entity.setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(h11CsvEntity.get後_保険_特定入所者介護サービス費等請求額());
        登録H11Entity.setAtoKohi1ServiceTanisu(h11CsvEntity.get後_公費１_サービス単位数());
        登録H11Entity.setAtoKohi1Seikyugaku(h11CsvEntity.get後_公費１_請求額());
        登録H11Entity.setAtoKohi1RiyoshaFutangaku(h11CsvEntity.get後_公費１_本人負担額());
        登録H11Entity.setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(h11CsvEntity.get後_公費１_緊急時施設療養費請求額());
        登録H11Entity.setAtoKohi1TokuteiShinryohiSeikyugaku(h11CsvEntity.get後_公費１_特定診療費請求額());
        登録H11Entity.setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(h11CsvEntity.get後_公費１_特定入所者介護サービス費等請求額());
        登録H11Entity.setAtoKohi2ServiceTanisu(h11CsvEntity.get後_公費２_サービス単位数());
        登録H11Entity.setAtoKohi2Seikyugaku(h11CsvEntity.get後_公費２_請求額());
        登録H11Entity.setAtoKohi2RiyoshaFutangaku(h11CsvEntity.get後_公費２_本人負担額());
        登録H11Entity.setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(h11CsvEntity.get後_公費２_緊急時施設療養費請求額());
        登録H11Entity.setAtoKohi2TokuteiShinryohiSeikyugaku(h11CsvEntity.get後_公費２_特定診療費請求額());
        登録H11Entity.setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(h11CsvEntity.get後_公費２_特定入所者介護サービス費等請求額());
        登録H11Entity.setAtoKohi3ServiceTanisu(h11CsvEntity.get後_公費３_サービス単位数());
        登録H11Entity.setAtoKohi3Seikyugaku(h11CsvEntity.get後_公費３_請求額());
        登録H11Entity.setAtoKohi3RiyoshaFutangaku(h11CsvEntity.get後_公費３_本人負担額());
        登録H11Entity.setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(h11CsvEntity.get後_公費３_緊急時施設療養費請求額());
        登録H11Entity.setAtoKohi3TokuteiShinryohiSeikyugaku(h11CsvEntity.get後_公費３_特定診療費請求額());
        登録H11Entity.setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(h11CsvEntity.get後_公費３_特定入所者介護サービス費等請求額());
        登録H11Entity.setKeikaiKubunCode(get非空文字列(h11CsvEntity.get警告区分コード()));
        登録H11Entity.setShinsaYM(get非空年月(h11CsvEntity.get審査年月()));
        登録H11Entity.setSeiriNo(get非空文字列(h11CsvEntity.get整理番号()));
        登録H11Entity.setSofuYM(FlexibleYearMonth.EMPTY);
        登録H11Entity.setTorikomiYM(get非空年月(parameter.get処理年月()));
        登録H11Entity.setDokujiSakuseiKubun(国保連受取);
        登録H11Entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(false);
        給付実績H1一時tableWriter.insert(登録H11Entity);
    }

    private void h12一時TBLに登録する(DbWT111AKyufuJissekiH12CsvEntity h12CsvEntity, int レコード番号) {
        DbWT111AKyufuJissekiH1Entity 登録H11Entity = new DbWT111AKyufuJissekiH1Entity();
        登録H11Entity.setRenban(連番);
        登録H11Entity.setRecordNo(new RString(レコード番号));
        登録H11Entity.setKokanShikibetsuNo(h12CsvEntity.get交換情報識別番号());
        登録H11Entity.setInputShikibetsuNo(h12CsvEntity.get入力識別番号());
        登録H11Entity.setRecodeShubetsuCode(get非空文字列(h12CsvEntity.getレコード種別コード()));
        登録H11Entity.setShokisaiHokenshaNo(h12CsvEntity.get証記載保険者番号());
        登録H11Entity.setHiHokenshaNo(h12CsvEntity.get被保険者番号());
        登録H11Entity.setServiceTeikyoYM(get非空年月(h12CsvEntity.getサービス提供年月()));
        登録H11Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(h12CsvEntity.get事業所番号())));
        登録H11Entity.setKyufuSakuseiKubunCode(get非空文字列(h12CsvEntity.get給付実績情報作成区分コード()));
        登録H11Entity.setKyufuJissekiKubunCode(get非空文字列(h12CsvEntity.get給付実績区分コード()));
        登録H11Entity.setToshiNo(RString.EMPTY);
        登録H11Entity.setKohi1FutanshaNo(get非空文字列(h12CsvEntity.get公費１_負担者番号()));
        登録H11Entity.setKohi1JukyushaNo(get非空文字列(h12CsvEntity.get公費１_受給者番号()));
        登録H11Entity.setKohi2FutanshaNo(get非空文字列(h12CsvEntity.get公費２_負担者番号()));
        登録H11Entity.setKohi2JukyushaNo(get非空文字列(h12CsvEntity.get公費２_受給者番号()));
        登録H11Entity.setKohi3FutanshaNo(get非空文字列(h12CsvEntity.get公費３_負担者番号()));
        登録H11Entity.setKohi3JukyushaNo(get非空文字列(h12CsvEntity.get公費３_受給者番号()));
        登録H11Entity.setUmareYMD(get非空年月日(h12CsvEntity.get生年月日()));
        登録H11Entity.setSeibetsuCode(get非空文字列(h12CsvEntity.get性別コード()));
        登録H11Entity.setYoKaigoJotaiKubunCode(get非空文字列(h12CsvEntity.get要介護状態区分コード()));
        登録H11Entity.setKyuSochiNyushoshaTokureiCode(get非空文字列(h12CsvEntity.get旧措置入所者特例コード()));
        登録H11Entity.setNinteiYukoKaishiYMD(get非空年月日(h12CsvEntity.get認定有効期間_開始年月日()));
        登録H11Entity.setNinteiYukoShuryoYMD(get非空年月日(h12CsvEntity.get認定有功期間_終了年月日()));
        登録H11Entity.setRojinHokenShichosonNo(get非空文字列(h12CsvEntity.get老人保健市町村番号()));
        登録H11Entity.setRojinhokenJukyushaNo(get非空文字列(h12CsvEntity.get老人保健受給者番号()));
        登録H11Entity.setKokiHokenshaNo(get非空文字列(h12CsvEntity.get保険者番号_後期()));
        登録H11Entity.setKokiHiHokenshaNo(get非空文字列(h12CsvEntity.get被保険者番号_後期()));
        登録H11Entity.setKokuhoHokenshaNo(get非空文字列(h12CsvEntity.get保険者番号_国保()));
        登録H11Entity.setKokuhoHiHokenshashoNo(get非空文字列(h12CsvEntity.get被保険者証番号_国保()));
        登録H11Entity.setKokuhoKojinNo(get非空文字列(h12CsvEntity.get宛名番号()));
        登録H11Entity.setKyotakuServiceSakuseiKubunCode(get非空文字列(h12CsvEntity.get居宅サービス計画作成区分コード()));
        登録H11Entity.setKyotakuKaigoShienJigyoshoNo(new JigyoshaNo(get事業所番号(
                h12CsvEntity.get事業所番号_居宅介護支援事業所等())));
        登録H11Entity.setKaishiYMD(get非空年月日(h12CsvEntity.get開始年月日()));
        登録H11Entity.setChushiYMD(get非空年月日(h12CsvEntity.get中止年月日()));
        登録H11Entity.setChushiRiyuNyushomaeJyokyoCode(get非空文字列(h12CsvEntity.get中止理由_入所院前の状況コード()));
        登録H11Entity.setNyushoYMD(get非空年月日(h12CsvEntity.get入所年月日()));
        登録H11Entity.setTaishoYMD(get非空年月日(h12CsvEntity.get退所年月日()));
        登録H11Entity.setNyushoJitsunissu(h12CsvEntity.get入所実日数());
        登録H11Entity.setGaihakuNissu(h12CsvEntity.get外泊日数());
        登録H11Entity.setTaishogoJotaiCode(get非空文字列(h12CsvEntity.get退所後の状態コード()));
        登録H11Entity.setHokenKyufuritsu(get非空給付率(h12CsvEntity.get保険給付率()));
        登録H11Entity.setKohi1Kyufuritsu(get非空給付率(h12CsvEntity.get公費１給付率()));
        登録H11Entity.setKohi2Kyufuritsu(get非空給付率(h12CsvEntity.get公費２給付率()));
        登録H11Entity.setKohi3Kyufuritsu(get非空給付率(h12CsvEntity.get公費３給付率()));
        登録H11Entity.setMaeHokenServiceTanisu(h12CsvEntity.get前_保険_サービス単位数());
        登録H11Entity.setMaeHokenSeikyugaku(get非空数字(h12CsvEntity.get前_保険_請求額()));
        登録H11Entity.setMaeHokenRiyoshaFutangaku(h12CsvEntity.get前_保険_利用者負担額());
        登録H11Entity.setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(get非空数字(h12CsvEntity.get前_保険_緊急時施設療養費請求額()));
        登録H11Entity.setMaeHokenTokuteiShinryohiSeikyugaku(get非空数字(h12CsvEntity.get前_保険_特定診療費請求額()));
        登録H11Entity.setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(
                get非空数字(h12CsvEntity.get前_保険_特定入所者介護サービス費等請求額()));
        登録H11Entity.setMaeKohi1ServiceTanisu(h12CsvEntity.get前_公費１_サービス単位数());
        登録H11Entity.setMaeKohi1Seikyugaku(h12CsvEntity.get前_公費１_請求額());
        登録H11Entity.setMaeKohi1RiyoshaFutangaku(h12CsvEntity.get前_公費１_本人負担額());
        登録H11Entity.setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(h12CsvEntity.get前_公費１_緊急時施設療養費請求額());
        登録H11Entity.setMaeKohi1TokuteiShinryohiSeikyugaku(h12CsvEntity.get前_公費１_特定診療費請求額());
        登録H11Entity.setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(h12CsvEntity.get前_公費１_特定入所者介護サービス費等請求額());
        登録H11Entity.setMaeKohi2ServiceTanisu(h12CsvEntity.get前_公費２_サービス単位数());
        登録H11Entity.setMaeKohi2Seikyugaku(h12CsvEntity.get前_公費２_請求額());
        登録H11Entity.setMaeKohi2RiyoshaFutangaku(h12CsvEntity.get前_公費２_本人負担額());
        登録H11Entity.setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(h12CsvEntity.get前_公費２_緊急時施設療養費請求額());
        登録H11Entity.setMaeKohi2TokuteiShinryohiSeikyugaku(h12CsvEntity.get前_公費２_特定診療費請求額());
        登録H11Entity.setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(h12CsvEntity.get前_公費２_特定入所者介護サービス費等請求額());
        登録H11Entity.setMaeKohi3ServiceTanisu(h12CsvEntity.get前_公費３_サービス単位数());
        登録H11Entity.setMaeKohi3Seikyugaku(h12CsvEntity.get前_公費３_請求額());
        登録H11Entity.setMaeKohi3RiyoshaFutangaku(h12CsvEntity.get前_公費３_本人負担額());
        登録H11Entity.setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(h12CsvEntity.get後_公費３_緊急時施設療養費請求額());
        登録H11Entity.setMaeKohi3TokuteiShinryohiSeikyugaku(h12CsvEntity.get前_公費３_特定診療費請求額());
        登録H11Entity.setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(h12CsvEntity.get前_公費３_特定入所者介護サービス費等請求額());
        登録H11Entity.setAtoHokenServiceTanisu(h12CsvEntity.get後_保険_サービス単位数());
        登録H11Entity.setAtoHokenSeikyugaku(get非空数字(h12CsvEntity.get後_保険_請求額()));
        登録H11Entity.setAtoHokenRiyoshaFutangaku(h12CsvEntity.get後_保険_利用者負担額());
        登録H11Entity.setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(get非空数字(h12CsvEntity.get後_保険_緊急時施設療養費請求額()));
        登録H11Entity.setAtoHokenTokuteiShinryohiSeikyugaku(get非空数字(h12CsvEntity.get後_保険_特定診療費請求額()));
        登録H11Entity.setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(h12CsvEntity.get後_保険_特定入所者介護サービス費等請求額());
        登録H11Entity.setAtoKohi1ServiceTanisu(h12CsvEntity.get後_公費１_サービス単位数());
        登録H11Entity.setAtoKohi1Seikyugaku(h12CsvEntity.get後_公費１_請求額());
        登録H11Entity.setAtoKohi1RiyoshaFutangaku(h12CsvEntity.get後_公費１_本人負担額());
        登録H11Entity.setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(h12CsvEntity.get後_公費１_緊急時施設療養費請求額());
        登録H11Entity.setAtoKohi1TokuteiShinryohiSeikyugaku(h12CsvEntity.get後_公費１_特定診療費請求額());
        登録H11Entity.setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(h12CsvEntity.get後_公費１_特定入所者介護サービス費等請求額());
        登録H11Entity.setAtoKohi2ServiceTanisu(h12CsvEntity.get後_公費２_サービス単位数());
        登録H11Entity.setAtoKohi2Seikyugaku(h12CsvEntity.get後_公費２_請求額());
        登録H11Entity.setAtoKohi2RiyoshaFutangaku(h12CsvEntity.get後_公費２_本人負担額());
        登録H11Entity.setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(h12CsvEntity.get後_公費２_緊急時施設療養費請求額());
        登録H11Entity.setAtoKohi2TokuteiShinryohiSeikyugaku(h12CsvEntity.get後_公費２_特定診療費請求額());
        登録H11Entity.setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(h12CsvEntity.get後_公費２_特定入所者介護サービス費等請求額());
        登録H11Entity.setAtoKohi3ServiceTanisu(h12CsvEntity.get後_公費３_サービス単位数());
        登録H11Entity.setAtoKohi3Seikyugaku(h12CsvEntity.get後_公費３_請求額());
        登録H11Entity.setAtoKohi3RiyoshaFutangaku(h12CsvEntity.get後_公費３_本人負担額());
        登録H11Entity.setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(h12CsvEntity.get後_公費３_緊急時施設療養費請求額());
        登録H11Entity.setAtoKohi3TokuteiShinryohiSeikyugaku(h12CsvEntity.get後_公費３_特定診療費請求額());
        登録H11Entity.setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(h12CsvEntity.get後_公費３_特定入所者介護サービス費等請求額());
        登録H11Entity.setKeikaiKubunCode(get非空文字列(h12CsvEntity.get警告区分コード()));
        登録H11Entity.setShinsaYM(get非空年月(h12CsvEntity.get審査年月()));
        登録H11Entity.setSeiriNo(get非空文字列(h12CsvEntity.get整理番号()));
        登録H11Entity.setSofuYM(FlexibleYearMonth.EMPTY);
        登録H11Entity.setTorikomiYM(get非空年月(parameter.get処理年月()));
        登録H11Entity.setDokujiSakuseiKubun(国保連受取);
        登録H11Entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(false);
        給付実績H1一時tableWriter.insert(登録H11Entity);
    }

    private void d1一時TBLに登録する(DbWT111BKyufuJissekiD1CsvEntity d1CsvEntity, int レコード番号) {
        DbWT111BKyufuJissekiD1Entity d1Entity = new DbWT111BKyufuJissekiD1Entity();
        d1Entity.setRenban(連番);
        d1Entity.setRecordNo(new RString(レコード番号));
        d1Entity.setKokanJohoShikibetsuNo(d1CsvEntity.get交換情報識別番号());
        d1Entity.setInputShikibetsuNo(d1CsvEntity.get入力識別番号());
        d1Entity.setRecodeShubetsuCode(get非空文字列(d1CsvEntity.getレコード種別コード()));
        d1Entity.setShokisaiHokenshaNo(d1CsvEntity.get証記載保険者番号());
        d1Entity.setHiHokenshaNo(d1CsvEntity.get被保険者番号());
        d1Entity.setServiceTeikyoYM(get非空年月(d1CsvEntity.getサービス提供年月()));
        d1Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(d1CsvEntity.get事業所番号())));
        d1Entity.setToshiNo(RString.EMPTY);
        d1Entity.setServiceShuruiCode(get非空サービス種類コード(d1CsvEntity.getサービス種類コード()));
        d1Entity.setServiceKomokuCode(get非空サービス項目コード(d1CsvEntity.getサービス項目コード()));
        d1Entity.setTanisu(get非空数字(d1CsvEntity.get単位数()));
        d1Entity.setNissuKaisu(d1CsvEntity.get日数_回数());
        d1Entity.setKohi1TaishoNissuKaisu(d1CsvEntity.get公費１対象日数_回数());
        d1Entity.setKohi2TaishoNissuKaisu(d1CsvEntity.get公費２対象日数_回数());
        d1Entity.setKohi3TaishoNissuKaisu(d1CsvEntity.get公費３対象日数_回数());
        d1Entity.setServiceTanisu(get非空数字(d1CsvEntity.getサービス単位数()));
        d1Entity.setKohi1TaishoServiceTanisu(get非空数字(d1CsvEntity.get公費１対象サービス単位数()));
        d1Entity.setKohi2TaishoServiceTanisu(get非空数字(d1CsvEntity.get公費２対象サービス単位数()));
        d1Entity.setKohi3TaishoServiceTanisu(get非空数字(d1CsvEntity.get公費３対象サービス単位数()));
        d1Entity.setTekiyo(get非空文字列(d1CsvEntity.get摘要()));
        d1Entity.setAtoTanisu(get非空数字(d1CsvEntity.get後_単位数()));
        d1Entity.setAtoNissuKaisu(d1CsvEntity.get後_日数_回数());
        d1Entity.setAtoKohi1TaishoNissuKaisu(d1CsvEntity.get後_公費１対象日数_回数());
        d1Entity.setAtoKohi2TaishoNissukaisu(d1CsvEntity.get後_公費２対象日数_回数());
        d1Entity.setAtoKohi3TaishoNissuKaisu(d1CsvEntity.get後_公費３対象日数_回数());
        d1Entity.setAtoServiceTanisu(get非空数字(d1CsvEntity.get後_サービス単位数()));
        d1Entity.setAtoKohi1TaishoServiceTanisu(get非空数字(d1CsvEntity.get後_公費１対象サービス単位数()));
        d1Entity.setAtoKohi2TaishoServiceTanisu(get非空数字(d1CsvEntity.get後_公費２対象サービス単位数()));
        d1Entity.setAtoKohi3TaishoServiceTanisu(get非空数字(d1CsvEntity.get後_公費３対象サービス単位数()));
        d1Entity.setSaishinsaKaisu(d1CsvEntity.get再審査回数());
        d1Entity.setKagoKaisu(d1CsvEntity.get過誤回数());
        d1Entity.setShinsaYM(get非空年月(d1CsvEntity.get審査年月()));
        d1Entity.setSeiriNo(get非空文字列(d1CsvEntity.get整理番号()));
        d1Entity.setTorikomiYM(get非空年月(parameter.get処理年月()));
        給付実績D1一時tableWriter.insert(d1Entity);
    }

    private void d2一時TBLに登録する(DbWT111CKyufuJissekiD2CsvEntity d2CsvEntity, int レコード番号) {
        DbWT111CKyufuJissekiD2Entity d2EnTity = new DbWT111CKyufuJissekiD2Entity();
        d2EnTity.setRenban(連番);
        d2EnTity.setRecordNo(new RString(レコード番号));
        d2EnTity.setKokanJohoShikibetsuNo(d2CsvEntity.get交換情報識別番号());
        d2EnTity.setInputShikibetsuNo(d2CsvEntity.get入力識別番号());
        d2EnTity.setRecodeShubetsuCode(get非空文字列(d2CsvEntity.getレコード種別コード()));
        d2EnTity.setShokisaiHokenshaNo(d2CsvEntity.get証記載保険者番号());
        d2EnTity.setHiHokenshaNo(d2CsvEntity.get被保険者番号());
        d2EnTity.setServiceTeikyoYM(get非空年月(d2CsvEntity.getサービス提供年月()));
        d2EnTity.setJigyoshoNo(new JigyoshaNo(get事業所番号(d2CsvEntity.get事業所番号())));
        d2EnTity.setToshiNo(RString.EMPTY);
        d2EnTity.setRecodeJunjiNo(get非空文字列(d2CsvEntity.get緊急時施設療養情報レコード順次番号()));
        d2EnTity.setKinkyuShobyoName1(get非空文字列(d2CsvEntity.get緊急時傷病名１()));
        d2EnTity.setKinkyuShobyoName2(get非空文字列(d2CsvEntity.get緊急時傷病名２()));
        d2EnTity.setKinkyuShobyoName3(get非空文字列(d2CsvEntity.get緊急時傷病名３()));
        d2EnTity.setKinkyuChiryoKaishiYMD1(get非空年月日(d2CsvEntity.get緊急時治療開始年月日１()));
        d2EnTity.setKinkyuChiryoKaishiYMD2(get非空年月日(d2CsvEntity.get緊急時治療開始年月日２()));
        d2EnTity.setKinkyuChiryoKaishiYMD3(get非空年月日(d2CsvEntity.get緊急時治療開始年月日３()));
        d2EnTity.setOshinNissu(d2CsvEntity.get往診日数());
        d2EnTity.setOshinIryoKikanName(get非空文字列(d2CsvEntity.get往診医療機関名()));
        d2EnTity.setTsuinNissu(d2CsvEntity.get通院日数());
        d2EnTity.setTsuinIryoKikanName(get非空文字列(d2CsvEntity.get通院医療機関名()));
        d2EnTity.setKinkyuChiryoKanriTanisu(d2CsvEntity.get緊急時治療管理単位数());
        d2EnTity.setKinkyuChiryoKanriNissu(d2CsvEntity.get緊急時治療管理日数());
        d2EnTity.setKinkyuChiryoKanriSubTotal(d2CsvEntity.get緊急時治療管理小計());
        d2EnTity.setRehabilitationTensu(d2CsvEntity.getリハビリテーション点数());
        d2EnTity.setShochiTensu(d2CsvEntity.get処置点数());
        d2EnTity.setShujutsuTensu(d2CsvEntity.get手術点数());
        d2EnTity.setMasuiTensu(d2CsvEntity.get麻酔点数());
        d2EnTity.setHoshasenChiryoTensu(d2CsvEntity.get放射線治療点数());
        d2EnTity.setTekiyo1(get非空文字列(d2CsvEntity.get摘要1()));
        d2EnTity.setTekiyo2(get非空文字列(d2CsvEntity.get摘要2()));
        d2EnTity.setTekiyo3(get非空文字列(d2CsvEntity.get摘要3()));
        d2EnTity.setTekiyo4(get非空文字列(d2CsvEntity.get摘要4()));
        d2EnTity.setTekiyo5(get非空文字列(d2CsvEntity.get摘要5()));
        d2EnTity.setTekiyo6(get非空文字列(d2CsvEntity.get摘要6()));
        d2EnTity.setTekiyo7(get非空文字列(d2CsvEntity.get摘要7()));
        d2EnTity.setTekiyo8(get非空文字列(d2CsvEntity.get摘要8()));
        d2EnTity.setTekiyo9(get非空文字列(d2CsvEntity.get摘要9()));
        d2EnTity.setTekiyo10(get非空文字列(d2CsvEntity.get摘要10()));
        d2EnTity.setTekiyo11(get非空文字列(d2CsvEntity.get摘要11()));
        d2EnTity.setTekiyo12(get非空文字列(d2CsvEntity.get摘要12()));
        d2EnTity.setTekiyo13(get非空文字列(d2CsvEntity.get摘要13()));
        d2EnTity.setTekiyo14(get非空文字列(d2CsvEntity.get摘要14()));
        d2EnTity.setTekiyo15(get非空文字列(d2CsvEntity.get摘要15()));
        d2EnTity.setTekiyo16(get非空文字列(d2CsvEntity.get摘要16()));
        d2EnTity.setTekiyo17(get非空文字列(d2CsvEntity.get摘要17()));
        d2EnTity.setTekiyo18(get非空文字列(d2CsvEntity.get摘要18()));
        d2EnTity.setTekiyo19(get非空文字列(d2CsvEntity.get摘要19()));
        d2EnTity.setTekiyo20(get非空文字列(d2CsvEntity.get摘要20()));
        d2EnTity.setKinkyuShisetsuRyoyoHiTotalTensu(d2CsvEntity.get緊急時施設療養費合計点数());
        d2EnTity.setAtoOshinNissu(d2CsvEntity.get後_往診日数());
        d2EnTity.setAtoTsuinNissu(d2CsvEntity.get後_通院日数());
        d2EnTity.setAtoKinkyuChiryoKanriTanisu(d2CsvEntity.get後_緊急時治療管理単位数());
        d2EnTity.setAtoKinkyuChiryoKanriNissu(d2CsvEntity.get後_緊急時治療管理日数());
        d2EnTity.setAtoRehabilitationTensu(d2CsvEntity.get後_リハビリテーション点数());
        d2EnTity.setAtoShochiTensu(d2CsvEntity.get後_処置点数());
        d2EnTity.setAtoShujutsuTensu(d2CsvEntity.get後_手術点数());
        d2EnTity.setAtoMasuiTensu(d2CsvEntity.get後_麻酔点数());
        d2EnTity.setAtoHoshasenChiryoTensu(d2CsvEntity.get後_放射線治療点数());
        d2EnTity.setSaishinsaKaisu(d2CsvEntity.get再審査回数());
        d2EnTity.setKagoKaisu(d2CsvEntity.get過誤回数());
        d2EnTity.setShinsaYM(get非空年月(d2CsvEntity.get審査年月()));
        d2EnTity.setSeiriNo(get非空文字列(d2CsvEntity.get整理番号()));
        d2EnTity.setTorikomiYM(get非空年月(parameter.get処理年月()));
        給付実績D2一時tableWriter.insert(d2EnTity);
    }

    private void d31一時TBLに登録する(DbWT111DKyufuJissekiD31CsvEntity d31CsvEntity, int レコード番号) {
        DbWT111DKyufuJissekiD31Entity d31Entity = new DbWT111DKyufuJissekiD31Entity();
        d31Entity.setRenban(連番);
        d31Entity.setRecordNo(new RString(レコード番号));
        d31Entity.setKokanJohoShikibetsuNo(d31CsvEntity.get交換情報識別番号());
        d31Entity.setInputShikibetsuNo(d31CsvEntity.get入力識別番号());
        d31Entity.setRecodeShubetsuCode(get非空文字列(d31CsvEntity.getレコード種別コード()));
        d31Entity.setShokisaiHokenshaNo(d31CsvEntity.get証記載保険者番号());
        d31Entity.setHiHokenshaNo(d31CsvEntity.get被保険者番号());
        d31Entity.setServiceTeikyoYM(get非空年月(d31CsvEntity.getサービス提供年月()));
        d31Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(d31CsvEntity.get事業所番号())));
        d31Entity.setToshiNo(RString.EMPTY);
        d31Entity.setRecodeJunjiNo(get非空文字列(d31CsvEntity.get特定診療情報レコード順次番号()));
        d31Entity.setShobyoName(get非空文字列(d31CsvEntity.get傷病名()));
        d31Entity.setHokenShidoKanriryo(d31CsvEntity.get保険_指導管理料等());
        d31Entity.setHokenTanjunXsen(d31CsvEntity.get保険_単純エックス線());
        d31Entity.setHokenRehabilitation(d31CsvEntity.get保険_リハビリテーション());
        d31Entity.setHokenSeishinkaSemmonRyoho(d31CsvEntity.get保険_精神科専門療法());
        d31Entity.setHokenTotalTanisu(d31CsvEntity.get保険_合計単位数());
        d31Entity.setKohi1ShidoKanriryo(d31CsvEntity.get公費１_指導管理料等());
        d31Entity.setKohi1TanjunXsen(d31CsvEntity.get公費１_単純エックス線());
        d31Entity.setKohi1Rehabilitation(d31CsvEntity.get公費１_リハビリテーション());
        d31Entity.setKohi1SeishinkaSemmonRyoho(d31CsvEntity.get公費１_精神科専門療法());
        d31Entity.setKohi1TotalTanisu(d31CsvEntity.get公費１_合計単位数());
        d31Entity.setKohi2ShidoKanriryo(d31CsvEntity.get公費２_指導管理料等());
        d31Entity.setKohi2TanjunXsen(d31CsvEntity.get公費２_単純エックス線());
        d31Entity.setKohi2Rehabilitation(d31CsvEntity.get公費２_リハビリテーション());
        d31Entity.setKohi2SeishinkaSemmonRyoho(d31CsvEntity.get公費２_精神科専門療法());
        d31Entity.setKohi2TotalTanisu(d31CsvEntity.get公費２_合計単位数());
        d31Entity.setKohi3ShidoKanriryo(d31CsvEntity.get公費３_指導管理料等());
        d31Entity.setKohi3TanjunXsen(d31CsvEntity.get公費３_単純エックス線());
        d31Entity.setKohi3Rehabilitation(d31CsvEntity.get公費３_リハビリテーション());
        d31Entity.setKohi3SeishinkaSemmonRyoho(d31CsvEntity.get公費３_精神科専門療法());
        d31Entity.setKohi3TotalTanisu(d31CsvEntity.get公費３_合計単位数());
        d31Entity.setTekiyo1(get非空文字列(d31CsvEntity.get摘要1()));
        d31Entity.setTekiyo2(get非空文字列(d31CsvEntity.get摘要2()));
        d31Entity.setTekiyo3(get非空文字列(d31CsvEntity.get摘要3()));
        d31Entity.setTekiyo4(get非空文字列(d31CsvEntity.get摘要4()));
        d31Entity.setTekiyo5(get非空文字列(d31CsvEntity.get摘要5()));
        d31Entity.setTekiyo6(get非空文字列(d31CsvEntity.get摘要6()));
        d31Entity.setTekiyo7(get非空文字列(d31CsvEntity.get摘要7()));
        d31Entity.setTekiyo8(get非空文字列(d31CsvEntity.get摘要8()));
        d31Entity.setTekiyo9(get非空文字列(d31CsvEntity.get摘要9()));
        d31Entity.setTekiyo10(get非空文字列(d31CsvEntity.get摘要10()));
        d31Entity.setTekiyo11(get非空文字列(d31CsvEntity.get摘要11()));
        d31Entity.setTekiyo12(get非空文字列(d31CsvEntity.get摘要12()));
        d31Entity.setTekiyo13(get非空文字列(d31CsvEntity.get摘要13()));
        d31Entity.setTekiyo14(get非空文字列(d31CsvEntity.get摘要14()));
        d31Entity.setTekiyo15(get非空文字列(d31CsvEntity.get摘要15()));
        d31Entity.setTekiyo16(get非空文字列(d31CsvEntity.get摘要16()));
        d31Entity.setTekiyo17(get非空文字列(d31CsvEntity.get摘要17()));
        d31Entity.setTekiyo18(get非空文字列(d31CsvEntity.get摘要18()));
        d31Entity.setTekiyo19(get非空文字列(d31CsvEntity.get摘要19()));
        d31Entity.setTekiyo20(get非空文字列(d31CsvEntity.get摘要20()));
        d31Entity.setAtoHokenShidoKanriryo(d31CsvEntity.get後_保険_指導管理料等());
        d31Entity.setAtoHokenTanjunXsen(d31CsvEntity.get後_保険_単純エックス線());
        d31Entity.setAtoHokenRehabilitation(d31CsvEntity.get後_保険_リハビリテーション());
        d31Entity.setAtoHokenSeishinkaSemmonRyoho(d31CsvEntity.get後_保険_精神科専門療法());
        d31Entity.setAtoKohi1ShidoKanriryo(d31CsvEntity.get後_公費１_指導管理料等());
        d31Entity.setAtoKohi1TanjunXsen(d31CsvEntity.get後_公費１_単純エックス線());
        d31Entity.setAtoKohi1Rehabilitation(d31CsvEntity.get後_公費１_リハビリテーション());
        d31Entity.setAtoKohi1SeishinkaSemmonRyoho(d31CsvEntity.get後_公費１_精神科専門療法());
        d31Entity.setAtoKohi2ShidoKanriryo(d31CsvEntity.get後_公費２_指導管理料等());
        d31Entity.setAtoKohi2TanjunXsen(d31CsvEntity.get後_公費２_単純エックス線());
        d31Entity.setAtoKohi2Rehabilitation(d31CsvEntity.get後_公費２_リハビリテーション());
        d31Entity.setAtoKohi2SeishinkaSemmonRyoho(d31CsvEntity.get後_公費２_精神科専門療法());
        d31Entity.setAtoKohi3ShidoKanriryo(d31CsvEntity.get後_公費３_指導管理料等());
        d31Entity.setAtoKohi3TanjunXsen(d31CsvEntity.get後_公費３_単純エックス線());
        d31Entity.setAtoKohi3Rehabilitation(d31CsvEntity.get後_公費３_リハビリテーション());
        d31Entity.setAtoKohi3SeishinkaSemmonRyoho(d31CsvEntity.get後_公費３_精神科専門療法());
        d31Entity.setSaishinsaKaisu(d31CsvEntity.get再審査回数());
        d31Entity.setKagoKaisu(d31CsvEntity.get過誤回数());
        d31Entity.setShinsaYM(get非空年月(d31CsvEntity.get審査年月()));
        d31Entity.setSeiriNo(get非空文字列(d31CsvEntity.get整理番号()));
        d31Entity.setTorikomiYM(get非空年月(parameter.get処理年月()));
        給付実績D31一時tableWriter.insert(d31Entity);
    }

    private void d32一時TBLに登録する(DbWT111EKyufuJissekiD32CsvEntity d32CsvEntity, int レコード番号) {
        DbWT111EKyufuJissekiD32Entity d32Entity = new DbWT111EKyufuJissekiD32Entity();
        d32Entity.setRenban(連番);
        d32Entity.setRecordNo(new RString(レコード番号));
        d32Entity.setKokanJohoShikibetsuNo(d32CsvEntity.get交換情報識別番号());
        d32Entity.setInputShikibetsuNo(d32CsvEntity.get入力識別番号());
        d32Entity.setRecodeShubetsuCode(get非空文字列(d32CsvEntity.getレコード種別コード()));
        d32Entity.setShokisaiHokenshaNo(d32CsvEntity.get証記載保険者番号());
        d32Entity.setHiHokenshaNo(d32CsvEntity.get被保険者番号());
        d32Entity.setServiceTeikyoYM(get非空年月(d32CsvEntity.getサービス提供年月()));
        d32Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(d32CsvEntity.get事業所番号())));
        d32Entity.setToshiNo(RString.EMPTY);
        d32Entity.setRecodeJunjiNo(get非空文字列(d32CsvEntity.get特定診療情報レコード順次番号()));
        d32Entity.setShobyoName(get非空文字列(d32CsvEntity.get傷病名()));
        d32Entity.setShikibetsuNo(get非空文字列(d32CsvEntity.get識別番号()));
        d32Entity.setTanisu(d32CsvEntity.get単位数());
        d32Entity.setHokenKaisu(d32CsvEntity.get保険_回数());
        d32Entity.setHokenServiceTanisu(d32CsvEntity.get保険_ｻｰﾋﾞｽ単位数());
        d32Entity.setHokenTotalTanisu(d32CsvEntity.get保険_合計単位数());
        d32Entity.setKohi1Kaisu(d32CsvEntity.get公費１_回数());
        d32Entity.setKohi1ServiceTanisu(d32CsvEntity.get公費１_ｻｰﾋﾞｽ単位数());
        d32Entity.setKohi1TotalTanisu(d32CsvEntity.get公費１_合計単位数());
        d32Entity.setKohi2Kaisu(d32CsvEntity.get公費２_回数());
        d32Entity.setKohi2ServiceTanisu(d32CsvEntity.get公費２_ｻｰﾋﾞｽ単位数());
        d32Entity.setKohi2TotalTanisu(d32CsvEntity.get公費２_合計単位数());
        d32Entity.setKohi3Kaisu(d32CsvEntity.get公費３_回数());
        d32Entity.setKohi3ServiceTanisu(d32CsvEntity.get公費３_ｻｰﾋﾞｽ単位数());
        d32Entity.setKohi3TotalTanisu(d32CsvEntity.get公費３_合計単位数());
        d32Entity.setTekiyo(get非空文字列(d32CsvEntity.get摘要()));
        d32Entity.setAtoTanisu(d32CsvEntity.get後_単位数());
        d32Entity.setAtoHokenKaisu(d32CsvEntity.get後_保険_回数());
        d32Entity.setAtoHokenServiceTanisu(d32CsvEntity.get後_保険_ｻｰﾋﾞｽ単位数());
        d32Entity.setAtoHokenTotalTanisu(d32CsvEntity.get後_保険_合計単位数());
        d32Entity.setAtoKohi1Kaisu(d32CsvEntity.get後_公費１_回数());
        d32Entity.setAtoKohi1ServiceTanisu(d32CsvEntity.get後_公費１_ｻｰﾋﾞｽ単位数());
        d32Entity.setAtoKohi1TotalTanisu(d32CsvEntity.get後_公費１_合計単位数());
        d32Entity.setAtoKohi2Kaisu(d32CsvEntity.get後_公費２_回数());
        d32Entity.setAtoKohi2ServiceTanisu(d32CsvEntity.get後_公費２_ｻｰﾋﾞｽ単位数());
        d32Entity.setAtoKohi3TotalTanisu(d32CsvEntity.get後_公費２_合計単位数());
        d32Entity.setSaishinsaKaisu(d32CsvEntity.get再審査回数());
        d32Entity.setKagoKaisu(d32CsvEntity.get過誤回数());
        d32Entity.setShinsaYM(get非空年月(d32CsvEntity.get審査年月()));
        d32Entity.setSeiriNo(get非空文字列(d32CsvEntity.get整理番号()));
        d32Entity.setTorikomiYM(get非空年月(parameter.get処理年月()));
        給付実績D32一時tableWriter.insert(d32Entity);
    }

    private void d4一時TBLに登録する(DbWT111FKyufuJissekiD4CsvEntity d4CsvEntity, int レコード番号) {
        DbWT111FKyufuJissekiD4Entity d4Entity = new DbWT111FKyufuJissekiD4Entity();
        d4Entity.setRenban(連番);
        d4Entity.setRecordNo(new RString(レコード番号));
        d4Entity.setKokanJohoShikibetsuNo(d4CsvEntity.get交換情報識別番号());
        d4Entity.setInputShikibetsuNo(d4CsvEntity.get入力識別番号());
        d4Entity.setRecodeShubetsuCode(get非空文字列(d4CsvEntity.getレコード種別コード()));
        d4Entity.setShokisaiHokenshaNo(d4CsvEntity.get証記載保険者番号());
        d4Entity.setHiHokenshaNo(d4CsvEntity.get被保険者番号());
        d4Entity.setServiceTeikyoYM(get非空年月(d4CsvEntity.getサービス提供年月()));
        d4Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(d4CsvEntity.get事業所番号())));
        d4Entity.setToshiNo(RString.EMPTY);
        d4Entity.setKihonTeikyoNissu(d4CsvEntity.get基本_提供日数());
        d4Entity.setKihonTeikyoTanka(d4CsvEntity.get基本_提供単価());
        d4Entity.setKihonTeikyoKingaku(d4CsvEntity.get基本_提供金額());
        d4Entity.setTokubestuTeikyoNissu(d4CsvEntity.get特別_提供日数());
        d4Entity.setTokubestuTeikyoTanka(d4CsvEntity.get特別_提供単価());
        d4Entity.setTokubestuTeikyoKingaku(d4CsvEntity.get特別_提供金額());
        d4Entity.setSyokujiTeikyoNissu(d4CsvEntity.get食事提供延べ日数());
        d4Entity.setKohi1SyokujiTeikyoNissu(d4CsvEntity.get公費１対象食事提供延べ日数());
        d4Entity.setKohi2SyokujiTeikyoNissu(d4CsvEntity.get公費２対象食事提供延べ日数());
        d4Entity.setKohi3SyokujiTeikyoNissu(d4CsvEntity.get公費３対象食事提供延べ日数());
        d4Entity.setSyokujiTeikyohiTotal(d4CsvEntity.get食事提供費合計());
        d4Entity.setGetsugakuHyojunFutanGaku(d4CsvEntity.get標準負担額_月額());
        d4Entity.setSyokujiTeikyohiSeikyugaku(d4CsvEntity.get食事提供費請求額());
        d4Entity.setKohi1SyokujiTeikyohiSeikyugaku(d4CsvEntity.get公費１食事提供費請求額());
        d4Entity.setKohi2SyokujiTeikyohiSeikyugaku(d4CsvEntity.get公費２食事提供費請求額());
        d4Entity.setKohi3SyokujiTeikyohiSeikyugaku(d4CsvEntity.get公費３食事提供費請求額());
        d4Entity.setNichigakuHyojunFutanGaku(d4CsvEntity.get標準負担額_日額());
        d4Entity.setAtoKihonTeikyoTanka(d4CsvEntity.get後_基本食提供費用提供単価());
        d4Entity.setAtoTokubestuTeikyoTanka(d4CsvEntity.get後_特別食提供費用提供単価());
        d4Entity.setAtoSyokujiTeikyohiSeikyugaku(d4CsvEntity.get後_食事提供費請求額());
        d4Entity.setSaishinsaKaisu(d4CsvEntity.get再審査回数());
        d4Entity.setKagoKaisu(d4CsvEntity.get過誤回数());
        d4Entity.setShinsaYM(get非空年月(d4CsvEntity.get審査年月()));
        d4Entity.setSeiriNo(get非空文字列(d4CsvEntity.get整理番号()));
        d4Entity.setTorikomiYM(parameter.get処理年月());
        給付実績D4一時tableWriter.insert(d4Entity);
    }

    private void d51一時TBLに登録する(DbWT111GKyufuJissekiD51CsvEntity d51CsvEntity, int レコード番号) {
        DbWT111GKyufuJissekiD5Entity d5Entity = new DbWT111GKyufuJissekiD5Entity();
        d5Entity.setRenban(連番);
        d5Entity.setRecordNo(new RString(レコード番号));
        d5Entity.setKokanJohoShikibetsuNo(d51CsvEntity.get交換情報識別番号());
        d5Entity.setInputShikibetsuNo(d51CsvEntity.get入力識別番号());
        d5Entity.setRecodeShubetsuCode(get非空文字列(d51CsvEntity.getレコード種別コード()));
        d5Entity.setShokisaiHokenshaNo(d51CsvEntity.get証記載保険者番号());
        d5Entity.setHiHokenshaNo(d51CsvEntity.get被保険者番号());
        d5Entity.setServiceTeikyoYM(get非空年月(d51CsvEntity.getサービス提供年月()));
        d5Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(d51CsvEntity.get事業所番号())));
        d5Entity.setToshiNo(RString.EMPTY);
        d5Entity.setServicePlanhiMeisaiLineNo(RString.EMPTY);
        d5Entity.setShiteiKijunGaitoJigyoshaKubunCode(get非空文字列(d51CsvEntity.get指定_基準該当等事業所区分コード()));
        d5Entity.setTanisuTanka(get非空数字(d51CsvEntity.get単位数単価()));
        d5Entity.setKyotakuServiceSakuseiIraiYMD(get非空年月日(d51CsvEntity.get居宅サービス計画作成依頼届出年月日()));
        d5Entity.setServiceCode(d51CsvEntity.getサービスコード());
        d5Entity.setTanisu(get非空数字(d51CsvEntity.get単位数()));
        d5Entity.setKaisu(INDEX_0);
        d5Entity.setServiceTanisu(Decimal.ZERO);
        d5Entity.setServiceTanisuTotal(Decimal.ZERO);
        d5Entity.setSeikyuKingaku(get非空数字(d51CsvEntity.get請求金額()));
        d5Entity.setTantouKaigoShienSemmoninNo(RString.EMPTY);
        d5Entity.setTekiyo(RString.EMPTY);
        d5Entity.setAtoTanisu(get非空数字(d51CsvEntity.get後_単位数()));
        d5Entity.setAtoKaisu(INDEX_0);
        d5Entity.setAtoServiceTanisu(Decimal.ZERO);
        d5Entity.setAtoServiceTanisuTotal(Decimal.ZERO);
        d5Entity.setAtoSeikyuKingaku(get非空数字(d51CsvEntity.get後_請求金額()));
        d5Entity.setSaishinsaKaisu(d51CsvEntity.get再審査回数());
        d5Entity.setKagoKaisu(d51CsvEntity.get過誤回数());
        d5Entity.setShinsaYM(get非空年月(d51CsvEntity.get審査年月()));
        d5Entity.setSeiriNo(get非空文字列(d51CsvEntity.get整理番号()));
        d5Entity.setTorikomiYM(get非空年月(parameter.get処理年月()));
        給付実績D5一時tableWriter.insert(d5Entity);
    }

    private void d52一時TBLに登録する(DbWT111GKyufuJissekiD52CsvEntity d52CsvEntity, int レコード番号) {
        DbWT111GKyufuJissekiD5Entity d5Entity = new DbWT111GKyufuJissekiD5Entity();
        d5Entity.setRenban(連番);
        d5Entity.setRecordNo(new RString(レコード番号));
        d5Entity.setKokanJohoShikibetsuNo(d52CsvEntity.get交換情報識別番号());
        d5Entity.setInputShikibetsuNo(d52CsvEntity.get入力識別番号());
        d5Entity.setRecodeShubetsuCode(get非空文字列(d52CsvEntity.getレコード種別コード()));
        d5Entity.setShokisaiHokenshaNo(d52CsvEntity.get証記載保険者番号());
        d5Entity.setHiHokenshaNo(d52CsvEntity.get被保険者番号());
        d5Entity.setServiceTeikyoYM(get非空年月(d52CsvEntity.getサービス提供年月()));
        d5Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(d52CsvEntity.get事業所番号())));
        d5Entity.setToshiNo(RString.EMPTY);
        d5Entity.setServicePlanhiMeisaiLineNo(RString.EMPTY);
        d5Entity.setShiteiKijunGaitoJigyoshaKubunCode(get非空文字列(d52CsvEntity.get指定_基準該当等事業所区分コード()));
        d5Entity.setTanisuTanka(get非空数字(d52CsvEntity.get単位数単価()));
        d5Entity.setKyotakuServiceSakuseiIraiYMD(get非空年月日(d52CsvEntity.get居宅サービス計画作成依頼届出年月日()));
        d5Entity.setServiceCode(d52CsvEntity.getサービスコード());
        d5Entity.setTanisu(get非空数字(d52CsvEntity.get単位数()));
        d5Entity.setKaisu(INDEX_0);
        d5Entity.setServiceTanisu(Decimal.ZERO);
        d5Entity.setServiceTanisuTotal(Decimal.ZERO);
        d5Entity.setSeikyuKingaku(get非空数字(d52CsvEntity.get請求金額()));
        d5Entity.setTantouKaigoShienSemmoninNo(get非空文字列(d52CsvEntity.get担当介護支援専門員番号()));
        d5Entity.setTekiyo(get非空文字列(d52CsvEntity.get摘要()));
        d5Entity.setAtoTanisu(get非空数字(d52CsvEntity.get後_単位数()));
        d5Entity.setAtoKaisu(INDEX_0);
        d5Entity.setAtoServiceTanisu(Decimal.ZERO);
        d5Entity.setAtoServiceTanisuTotal(Decimal.ZERO);
        d5Entity.setAtoSeikyuKingaku(get非空数字(d52CsvEntity.get後_請求金額()));
        d5Entity.setSaishinsaKaisu(d52CsvEntity.get再審査回数());
        d5Entity.setKagoKaisu(d52CsvEntity.get過誤回数());
        d5Entity.setShinsaYM(get非空年月(d52CsvEntity.get審査年月()));
        d5Entity.setSeiriNo(get非空文字列(d52CsvEntity.get整理番号()));
        d5Entity.setTorikomiYM(parameter.get処理年月());
        給付実績D5一時tableWriter.insert(d5Entity);
    }

    private void d53一時TBLに登録する(DbWT111GKyufuJissekiD53CsvEntity d53CsvEntity, int レコード番号) {
        DbWT111GKyufuJissekiD5Entity d5Entity = new DbWT111GKyufuJissekiD5Entity();
        d5Entity.setRenban(連番);
        d5Entity.setRecordNo(new RString(レコード番号));
        d5Entity.setKokanJohoShikibetsuNo(d53CsvEntity.get交換情報識別番号());
        d5Entity.setInputShikibetsuNo(d53CsvEntity.get入力識別番号());
        d5Entity.setRecodeShubetsuCode(get非空文字列(d53CsvEntity.getレコード種別コード()));
        d5Entity.setShokisaiHokenshaNo(d53CsvEntity.get証記載保険者番号());
        d5Entity.setHiHokenshaNo(d53CsvEntity.get被保険者番号());
        d5Entity.setServiceTeikyoYM(get非空年月(d53CsvEntity.getサービス提供年月()));
        d5Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(d53CsvEntity.get事業所番号())));
        d5Entity.setToshiNo(RString.EMPTY);
        d5Entity.setServicePlanhiMeisaiLineNo(get非空文字列(d53CsvEntity.getサービス計画費明細行番号()));
        d5Entity.setShiteiKijunGaitoJigyoshaKubunCode(get非空文字列(d53CsvEntity.get指定_基準該当等事業所区分コード()));
        d5Entity.setTanisuTanka(get非空数字(d53CsvEntity.get単位数単価()));
        d5Entity.setKyotakuServiceSakuseiIraiYMD(get非空年月日(d53CsvEntity.get居宅サービス計画作成依頼届出年月日()));
        d5Entity.setServiceCode(d53CsvEntity.getサービスコード());
        d5Entity.setTanisu(get非空数字(d53CsvEntity.get単位数()));
        d5Entity.setKaisu(d53CsvEntity.get回数());
        d5Entity.setServiceTanisu(get非空数字(d53CsvEntity.getサービス単位数()));
        d5Entity.setServiceTanisuTotal(get非空数字(d53CsvEntity.getサービス単位数合計()));
        d5Entity.setSeikyuKingaku(get非空数字(d53CsvEntity.get請求金額()));
        d5Entity.setTantouKaigoShienSemmoninNo(get非空文字列(d53CsvEntity.get担当介護支援専門員番号()));
        d5Entity.setTekiyo(get非空文字列(d53CsvEntity.get摘要()));
        d5Entity.setAtoTanisu(get非空数字(d53CsvEntity.get後_単位数()));
        d5Entity.setAtoKaisu(d53CsvEntity.get後_回数());
        d5Entity.setAtoServiceTanisu(get非空数字(d53CsvEntity.getサービス単位数()));
        d5Entity.setAtoServiceTanisuTotal(get非空数字(d53CsvEntity.getサービス単位数合計()));
        d5Entity.setAtoSeikyuKingaku(get非空数字(d53CsvEntity.get後_請求金額()));
        d5Entity.setSaishinsaKaisu(d53CsvEntity.get再審査回数());
        d5Entity.setKagoKaisu(d53CsvEntity.get過誤回数());
        d5Entity.setShinsaYM(get非空年月(d53CsvEntity.get審査年月()));
        d5Entity.setSeiriNo(get非空文字列(d53CsvEntity.get整理番号()));
        d5Entity.setTorikomiYM(parameter.get処理年月());
        給付実績D5一時tableWriter.insert(d5Entity);
    }

    private void d6一時TBLに登録する(DbWT111HKyufuJissekiD6CsvEntity d6CsvEntity, int レコード番号) {
        DbWT111HKyufuJissekiD6Entity d6Entity = new DbWT111HKyufuJissekiD6Entity();
        d6Entity.setRenban(連番);
        d6Entity.setRecordNo(new RString(レコード番号));
        d6Entity.setKokanJohoShikibetsuNo(d6CsvEntity.get交換情報識別番号());
        d6Entity.setInputShikibetsuNo(d6CsvEntity.get入力識別番号());
        d6Entity.setRecodeShubetsuCode(get非空文字列(d6CsvEntity.getレコード種別コード()));
        d6Entity.setShokisaiHokenshaNo(d6CsvEntity.get証記載保険者番号());
        d6Entity.setHiHokenshaNo(d6CsvEntity.get被保険者番号());
        d6Entity.setServiceTeikyoYM(get非空年月(d6CsvEntity.getサービス提供年月()));
        d6Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(d6CsvEntity.get事業所番号())));
        d6Entity.setToshiNo(RString.EMPTY);
        if (null != d6CsvEntity.getサービスコード()) {
            endIndex = d6CsvEntity.getサービスコード().getColumnValue().length();
            if (INDEX_4 <= endIndex) {
                beginIndex = endIndex - INDEX_4;
                d6Entity.setMeisaiNo(d6CsvEntity.getサービスコード().getColumnValue()
                        .substringReturnAsPossible(beginIndex, endIndex));
            } else {
                d6Entity.setMeisaiNo(RString.EMPTY);
            }
            d6Entity.setServiceCode(d6CsvEntity.getサービスコード());
        } else {
            d6Entity.setMeisaiNo(RString.EMPTY);
            d6Entity.setServiceCode(ServiceCode.EMPTY);
        }
        d6Entity.setFukushiyoguHanbaiYMD(get非空年月日(d6CsvEntity.get福祉用具販売年月日()));
        d6Entity.setFukushiyoguShohinName(get非空文字列(d6CsvEntity.get福祉用具商品名()));
        d6Entity.setFukushiyoguSyumokuCode(get非空文字列(d6CsvEntity.get福祉用具種目コード()));
        d6Entity.setFukushiyoguSeizoJigyoshaName(get非空文字列(d6CsvEntity.get福祉用具製造事業者名()));
        d6Entity.setFukushiyoguHanbaiJigyoshaName(get非空文字列(d6CsvEntity.get福祉用具販売事業者名()));
        d6Entity.setHanbaiKingaku(get非空数字(d6CsvEntity.get販売金額()));
        d6Entity.setTekiyo(get非空文字列(d6CsvEntity.get摘要_品目コード()));
        d6Entity.setShinsaYM(get非空年月(d6CsvEntity.get審査年月()));
        d6Entity.setSeiriNo(get非空文字列(d6CsvEntity.get整理番号()));
        d6Entity.setTorikomiYM(parameter.get処理年月());
        給付実績D6一時tableWriter.insert(d6Entity);
    }

    private void d7一時TBLに登録する(DbWT111IKyufuJissekiD7CsvEntity d7CsvEntity, int レコード番号) {
        DbWT111IKyufuJissekiD7Entity d7Entity = new DbWT111IKyufuJissekiD7Entity();
        d7Entity.setRenban(連番);
        d7Entity.setRecordNo(new RString(レコード番号));
        d7Entity.setKokanJohoShikibetsuNo(d7CsvEntity.get交換情報識別番号());
        d7Entity.setInputShikibetsuNo(d7CsvEntity.get入力識別番号());
        d7Entity.setRecodeShubetsuCode(get非空文字列(d7CsvEntity.getレコード種別コード()));
        d7Entity.setShokisaiHokenshaNo(d7CsvEntity.get証記載保険者番号());
        d7Entity.setHiHokenshaNo(d7CsvEntity.get被保険者番号());
        d7Entity.setServiceTeikyoYM(get非空年月(d7CsvEntity.getサービス提供年月()));
        d7Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(d7CsvEntity.get事業所番号())));
        d7Entity.setToshiNo(RString.EMPTY);
        if (null != d7CsvEntity.getサービスコード()) {
            endIndex = d7CsvEntity.getサービスコード().getColumnValue().length();
            if (INDEX_4 <= endIndex) {
                beginIndex = endIndex - INDEX_4;
                d7Entity.setMeisaiNo(d7CsvEntity.getサービスコード().getColumnValue()
                        .substringReturnAsPossible(beginIndex, endIndex));
            } else {
                d7Entity.setMeisaiNo(RString.EMPTY);
            }
            d7Entity.setServiceCode(d7CsvEntity.getサービスコード());
        } else {
            d7Entity.setMeisaiNo(RString.EMPTY);
            d7Entity.setServiceCode(ServiceCode.EMPTY);
        }
        d7Entity.setJutakuKaishuchakkoYMD(get非空年月日(d7CsvEntity.get住宅改修着工年月日()));
        d7Entity.setJutakuKaishuJigyoshaName(get非空文字列(d7CsvEntity.get住宅改修事業者名()));
        d7Entity.setJuutakukaishuJyutakuAdress(get非空文字列(d7CsvEntity.get住宅改修住宅住所()));
        d7Entity.setKaishuKingaku(get非空数字(d7CsvEntity.get改修金額()));
        d7Entity.setShinsaYM(get非空年月(d7CsvEntity.get審査年月()));
        d7Entity.setSeiriNo(get非空文字列(d7CsvEntity.get整理番号()));
        d7Entity.setTorikomiYM(parameter.get処理年月());
        給付実績D7一時tableWriter.insert(d7Entity);
    }

    private void d8一時TBLに登録する(DbWT111JKyufuJissekiD8CsvEntity d8CsvEntity, int レコード番号) {
        DbWT111JKyufuJissekiD8Entity d8Entity = new DbWT111JKyufuJissekiD8Entity();
        d8Entity.setRenban(連番);
        d8Entity.setRecordNo(new RString(レコード番号));
        d8Entity.setKokanJohoShikibetsuNo(d8CsvEntity.get交換情報識別番号());
        if (null != d8CsvEntity.get入力識別番号()
                && !RString.isNullOrEmpty(d8CsvEntity.get入力識別番号().getColumnValue())) {
            d8Entity.setInputShikibetsuNo(d8CsvEntity.get入力識別番号());
        } else {
            if (帳票レコード種別_D8.equals(d8CsvEntity.getレコード種別コード())) {
                d8Entity.setInputShikibetsuNo(入力識別番号_3411);
            } else if (帳票レコード種別_DE.equals(d8CsvEntity.getレコード種別コード())) {
                d8Entity.setInputShikibetsuNo(入力識別番号_3421);
            }
        }
        d8Entity.setRecodeShubetsuCode(get非空文字列(d8CsvEntity.getレコード種別コード()));
        d8Entity.setShokisaiHokenshaNo(d8CsvEntity.get証記載保険者番号());
        d8Entity.setHiHokenshaNo(d8CsvEntity.get被保険者番号());
        d8Entity.setServiceTeikyoYM(get非空年月(d8CsvEntity.getサービス提供年月()));
        d8Entity.setKyufuSakuseiKubunCode(get非空文字列(d8CsvEntity.get給付実績情報作成区分コード()));
        d8Entity.setKyufuJissekiKubunCode(get非空文字列(d8CsvEntity.get給付実績区分コード()));
        d8Entity.setToshiNo(RString.EMPTY);
        d8Entity.setUketsukeYMD(get非空年月日(d8CsvEntity.get受付年月日()));
        d8Entity.setKetteiYMD(get非空年月日(d8CsvEntity.get決定年月日()));
        d8Entity.setKohi1FutanNo(get非空文字列(d8CsvEntity.get公費１負担番号()));
        d8Entity.setKohi2FutanNo(get非空文字列(d8CsvEntity.get公費２負担番号()));
        d8Entity.setKohi3FutanNo(get非空文字列(d8CsvEntity.get公費３負担番号()));
        d8Entity.setRiyoshaFutangaku(d8CsvEntity.get利用者負担額());
        d8Entity.setKohi1Futangaku(d8CsvEntity.get公費１負担額());
        d8Entity.setKohi2Futangaku(d8CsvEntity.get公費２負担額());
        d8Entity.setKohi3Futangaku(d8CsvEntity.get公費３負担額());
        d8Entity.setShikyugaku(d8CsvEntity.get支給額());
        d8Entity.setKohi1Shikyugaku(d8CsvEntity.get公費１支給額());
        d8Entity.setKohi2Shikyugaku(d8CsvEntity.get公費２支給額());
        d8Entity.setKohi3Shikyugaku(d8CsvEntity.get公費３支給額());
        d8Entity.setShinsaYM(get非空年月(d8CsvEntity.get審査年月()));
        d8Entity.setSeiriNo(RString.EMPTY);
        d8Entity.setSofuYM(FlexibleYearMonth.EMPTY);
        d8Entity.setTorikomiYM(parameter.get処理年月());
        d8Entity.setSakuseiKubun(国保連受取);
        d8Entity.setKanriNo(RString.EMPTY);
        d8Entity.setHokenshaHoyuKyufujissekiJohoSakujoZumiFlag(false);
        給付実績D8一時tableWriter.insert(d8Entity);

    }

    private void d9一時TBLに登録する(DbWT111KKyufuJissekiD9CsvEntity d9CsvEntity, int レコード番号) {
        DbWT111KKyufuJissekiD9Entity d9Entity = new DbWT111KKyufuJissekiD9Entity();
        d9Entity.setRenban(連番);
        d9Entity.setRecordNo(new RString(レコード番号));
        d9Entity.setKokanJohoShikibetsuNo(d9CsvEntity.get交換情報識別番号());
        d9Entity.setInputShikibetsuNo(d9CsvEntity.get入力識別番号());
        d9Entity.setRecodeShubetsuCode(get非空文字列(d9CsvEntity.getレコード種別コード()));
        d9Entity.setShokisaiHokenshaNo(d9CsvEntity.get証記載保険者番号());
        d9Entity.setHiHokenshaNo(d9CsvEntity.get被保険者番号());
        d9Entity.setServiceTeikyoYM(get非空年月(d9CsvEntity.getサービス提供年月()));
        d9Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(d9CsvEntity.get事業所番号())));
        d9Entity.setToshiNo(RString.EMPTY);
        d9Entity.setRecodeJunjiNo(get非空文字列(d9CsvEntity.getレコード順次番号()));
        d9Entity.setServiceSyuruiCode(get非空サービス種類コード(d9CsvEntity.getサービス種類コード()));
        d9Entity.setServiceKomokuCode(get非空サービス項目コード(d9CsvEntity.getサービス項目コード()));
        d9Entity.setHiyoTanka(get非空数字(d9CsvEntity.get費用単価()));
        d9Entity.setFutanGendogaku(get非空数字(d9CsvEntity.get負担限度額()));
        d9Entity.setNissu(d9CsvEntity.get日数());
        d9Entity.setKohi1Nissu(d9CsvEntity.get公費１日数());
        d9Entity.setKohi2Nissu(d9CsvEntity.get公費２日数());
        d9Entity.setKohi3Nissu(d9CsvEntity.get公費３日数());
        d9Entity.setHiyogaku(get非空数字(d9CsvEntity.get費用額()));
        d9Entity.setHokenbunSeikyugaku(get非空数字(d9CsvEntity.get保険分請求額()));
        d9Entity.setKohi1Futangaku(get非空数字(d9CsvEntity.get公費１負担額_明細()));
        d9Entity.setKohi2Futangaku(get非空数字(d9CsvEntity.get公費２負担額_明細()));
        d9Entity.setKohi3Futangaku(get非空数字(d9CsvEntity.get公費3負担額_明細()));
        d9Entity.setRiyoshaFutangaku(get非空数字(d9CsvEntity.get利用者負担額()));
        d9Entity.setHiyogakuTotal(get非空数字(d9CsvEntity.get費用額合計()));
        d9Entity.setHokenbunSeikyugakuTotal(get非空数字(d9CsvEntity.get保険分請求額合計()));
        d9Entity.setRiyoshaFutangakuTotal(get非空数字(d9CsvEntity.get利用者負担額合計()));
        d9Entity.setKohi1FutangakuTotal(get非空数字(d9CsvEntity.get公費１_負担額合計()));
        d9Entity.setKohi1Seikyugaku(get非空数字(d9CsvEntity.get公費１_請求額()));
        d9Entity.setKohi1HonninFutanGetsugaku(get非空数字(d9CsvEntity.get公費１_本人負担月額()));
        d9Entity.setKohi2FutangakuTotal(get非空数字(d9CsvEntity.get公費２_負担額合計()));
        d9Entity.setKohi2Seikyugaku(get非空数字(d9CsvEntity.get公費２_請求額()));
        d9Entity.setKohi2HonninFutanGetsugaku(get非空数字(d9CsvEntity.get公費２_本人負担月額()));
        d9Entity.setKohi3FutangakuTotal(get非空数字(d9CsvEntity.get公費３_負担額合計()));
        d9Entity.setKohi3Seikyugaku(get非空数字(d9CsvEntity.get公費３_請求額()));
        d9Entity.setKohi3HonninFutanGetsugaku(get非空数字(d9CsvEntity.get公費３_本人負担月額()));
        d9Entity.setAtoHiyoTanka(get非空数字(d9CsvEntity.get後_費用単価()));
        d9Entity.setAtoNissu(d9CsvEntity.get後_日数());
        d9Entity.setAtoKohi1Nissu(d9CsvEntity.get後_公費１日数());
        d9Entity.setAtoKohi2Nissu(d9CsvEntity.get後_公費２日数());
        d9Entity.setAtoKohi3Nissu(d9CsvEntity.get後_公費３日数());
        d9Entity.setAtoHiyogaku(get非空数字(d9CsvEntity.get後_費用額()));
        d9Entity.setAtoHokenbunSeikyugaku(get非空数字(d9CsvEntity.get保険分請求額()));
        d9Entity.setAtoKohi1Futangaku(get非空数字(d9CsvEntity.get後_公費１負担額_明細()));
        d9Entity.setAtoKohi2Futangaku(get非空数字(d9CsvEntity.get後_公費2負担額_明細()));
        d9Entity.setAtoKohi3Futangaku(get非空数字(d9CsvEntity.get後_公費3負担額_明細()));
        d9Entity.setAtoRiyoshaFutangaku(get非空数字(d9CsvEntity.get後_利用者負担額()));
        d9Entity.setAtoHiyogakuTotal(get非空数字(d9CsvEntity.get後_費用額合計()));
        d9Entity.setAtoHokenbunSeikyugakuTotal(get非空数字(d9CsvEntity.get後_保険分請求額合計()));
        d9Entity.setAtoRiyoshaFutangakuTotal(get非空数字(d9CsvEntity.get後_利用者負担額合計()));
        d9Entity.setAtoKohi1FutangakuTotal(get非空数字(d9CsvEntity.get後_公費１_負担額合計()));
        d9Entity.setAtoKohi1Seikyugaku(get非空数字(d9CsvEntity.get後_公費１_請求額()));
        d9Entity.setAtoKohi1HonninFutanGetsugaku(get非空数字(d9CsvEntity.get後_公費１_本人負担月額()));
        d9Entity.setAtoKohi2FutangakuTotal(get非空数字(d9CsvEntity.get後_公費２_負担額合計()));
        d9Entity.setAtoKohi2Seikyugaku(get非空数字(d9CsvEntity.get後_公費２_請求額()));
        d9Entity.setAtoKohi2HonninFutanGetsugaku(get非空数字(d9CsvEntity.get後_公費２_本人負担月額()));
        d9Entity.setAtoKohi3FutangakuTotal(get非空数字(d9CsvEntity.get後_公費３_負担額合計()));
        d9Entity.setAtoKohi3Seikyugaku(get非空数字(d9CsvEntity.get後_公費３_請求額()));
        d9Entity.setAtoKohi3HonninFutanGetsugaku(get非空数字(d9CsvEntity.get後_公費３_本人負担月額()));
        d9Entity.setSaishinsaKaisu(d9CsvEntity.get再審査回数());
        d9Entity.setKagoKaisu(d9CsvEntity.get過誤回数());
        d9Entity.setShinsaYM(get非空年月(d9CsvEntity.get審査年月()));
        d9Entity.setSeiriNo(get非空文字列(d9CsvEntity.get整理番号()));
        d9Entity.setTorikomiYM(parameter.get処理年月());
        給付実績D9一時tableWriter.insert(d9Entity);
    }

    private void da一時TBLに登録する(DbWT111LKyufuJissekiDACsvEntity daCsvEntity, int レコード番号) {
        DbWT111LKyufuJissekiDAEntity daEntity = new DbWT111LKyufuJissekiDAEntity();
        daEntity.setRenban(連番);
        daEntity.setRecordNo(new RString(レコード番号));
        daEntity.setKokanJohoShikibetsuNo(daCsvEntity.get交換情報識別番号());
        daEntity.setInputShikibetsuNo(daCsvEntity.get入力識別番号());
        daEntity.setRecodeShubetsuCode(get非空文字列(daCsvEntity.getレコード種別コード()));
        daEntity.setShokisaiHokenshaNo(daCsvEntity.get証記載保険者番号());
        daEntity.setHiHokenshaNo(daCsvEntity.get被保険者番号());
        daEntity.setServiceTeikyoYM(get非空年月(daCsvEntity.getサービス提供年月()));
        daEntity.setJigyoshoNo(new JigyoshaNo(get事業所番号(daCsvEntity.get事業所番号())));
        daEntity.setToshiNo(RString.EMPTY);
        daEntity.setServiceSyuruiCode(get非空サービス種類コード(daCsvEntity.getサービス種類コード()));
        daEntity.setKeigenritsu(get非空数字(daCsvEntity.get軽減率()).divide(DATA_10));
        daEntity.setRiyoshaFutanTotal(get非空数字(daCsvEntity.get受領すべき利用者負担の総額()));
        daEntity.setKeigengaku(get非空数字(daCsvEntity.get軽減額()));
        daEntity.setKeigengoRiyoshaFutangaku(get非空数字(daCsvEntity.get軽減後利用者負担額()));
        daEntity.setBiko(get非空文字列(daCsvEntity.get備考()));
        daEntity.setAtoRiyoshaFutanTotal(get非空数字(daCsvEntity.get後_受領すべき利用者負担の総額()));
        daEntity.setAtoKeigengaku(get非空数字(daCsvEntity.get後_軽減額()));
        daEntity.setAtoKeigengoRiyoshaFutangaku(get非空数字(daCsvEntity.get後_軽減後利用者負担額()));
        daEntity.setSaishinsaKaisu(daCsvEntity.get再審査回数());
        daEntity.setKagoKaisu(daCsvEntity.get過誤回数());
        daEntity.setShinsaYM(get非空年月(daCsvEntity.get審査年月()));
        daEntity.setSeiriNo(get非空文字列(daCsvEntity.get整理番号()));
        daEntity.setTorikomiYM(parameter.get処理年月());
        給付実績DA一時tableWriter.insert(daEntity);
    }

    private void db一時TBLに登録する(DbWT111MKyufuJissekiDBCsvEntity dbCsvEntity, int レコード番号) {
        DbWT111MKyufuJissekiDBEntity dbEntity = new DbWT111MKyufuJissekiDBEntity();
        dbEntity.setRenban(連番);
        dbEntity.setRecordNo(new RString(レコード番号));
        dbEntity.setKokanJohoShikibetsuNo(dbCsvEntity.get交換情報識別番号());
        dbEntity.setInputShikibetsuNo(dbCsvEntity.get入力識別番号());
        dbEntity.setRecodeShubetsuCode(get非空文字列(dbCsvEntity.getレコード種別コード()));
        dbEntity.setShokisaiHokenshaNo(dbCsvEntity.get証記載保険者番号());
        dbEntity.setHiHokenshaNo(dbCsvEntity.get被保険者番号());
        dbEntity.setServiceTeikyoYM(get非空年月(dbCsvEntity.getサービス提供年月()));
        dbEntity.setJigyoshoNo(new JigyoshaNo(get事業所番号(dbCsvEntity.get事業所番号())));
        dbEntity.setShiteiKijungaitoJigyoshoKubunCode(get非空文字列(dbCsvEntity.get指定_基準該当事業所区分コード()));
        dbEntity.setKyotakuServiceSakuseiIraiYMD(get非空年月日(dbCsvEntity.get居宅サービス計画作成依頼届出年月日()));
        dbEntity.setToshiNo(RString.EMPTY);
        dbEntity.setServicePlanhiMeisaiLineNo(get非空文字列(dbCsvEntity.getサービス計画費明細行番号()));
        dbEntity.setTanisuTanka(get非空数字(dbCsvEntity.get単位数単価()).divide(DATA_100));
        dbEntity.setServiceCode(dbCsvEntity.getサービスコード());
        dbEntity.setTanisu(dbCsvEntity.get単位数());
        dbEntity.setKaisu(dbCsvEntity.get回数());
        dbEntity.setServiceTanisu(dbCsvEntity.getサービス単位数());
        dbEntity.setSerivceTanisuTotal(dbCsvEntity.getサービス単位数合計());
        dbEntity.setSeikyuKingaku(dbCsvEntity.get請求金額());
        dbEntity.setTantoKaigoShienSemmoninNo(get非空文字列(dbCsvEntity.get担当介護支援専門員番号()));
        dbEntity.setTekiyo(get非空文字列(dbCsvEntity.get摘要()));
        dbEntity.setRiyoushaFutangaku(dbCsvEntity.get利用者負担額());
        dbEntity.setAtoTanisu(dbCsvEntity.get後_単位数());
        dbEntity.setAtoKaisu(dbCsvEntity.get後_回数());
        dbEntity.setAtoServiceTanisu(dbCsvEntity.get後_サービス単位数());
        dbEntity.setAtoServiceTanisuTotal(dbCsvEntity.get後_サービス単位数合計());
        dbEntity.setAtoSeikyuKingaku(dbCsvEntity.get後_請求金額());
        dbEntity.setAtoRiyoshaFutangaku(dbCsvEntity.get後_利用者負担額());
        dbEntity.setSaishinsaKaisu(dbCsvEntity.get再審査回数());
        dbEntity.setKagoKaisu(dbCsvEntity.get過誤回数());
        dbEntity.setShinsaYM(get非空年月(dbCsvEntity.get審査年月()));
        dbEntity.setSeiriNo(get非空文字列(dbCsvEntity.get整理番号()));
        dbEntity.setTorikomiYM(parameter.get処理年月());
        給付実績DB一時tableWriter.insert(dbEntity);
    }

    private void dc一時TBLに登録する(DbWT111NKyufuJissekiDCCsvEntity dcCsvEntity, int レコード番号) {
        DbWT111NKyufuJissekiDCEntity dcEntity = new DbWT111NKyufuJissekiDCEntity();
        dcEntity.setRenban(連番);
        dcEntity.setRecordNo(new RString(レコード番号));
        dcEntity.setKokanJohoShikibetsuNo(dcCsvEntity.get交換情報識別番号());
        dcEntity.setInputShikibetsuNo(dcCsvEntity.get入力識別番号());
        dcEntity.setRecodeShubetsuCode(get非空文字列(dcCsvEntity.getレコード種別コード()));
        dcEntity.setShokisaiHokenshaNo(dcCsvEntity.get証記載保険者番号());
        dcEntity.setHiHokenshaNo(dcCsvEntity.get被保険者番号());
        dcEntity.setServiceTeikyoYM(get非空年月(dcCsvEntity.getサービス提供年月()));
        dcEntity.setJigyoshoNo(new JigyoshaNo(get事業所番号(dcCsvEntity.get事業所番号())));
        dcEntity.setToshiNo(RString.EMPTY);
        dcEntity.setRecodeJunjiNo(get非空文字列(dcCsvEntity.get緊急時施設療養情報レコード順次番号()));
        dcEntity.setKinkyuShobyoName1(get非空文字列(dcCsvEntity.get緊急時傷病名１()));
        dcEntity.setKinkyuShobyoName2(get非空文字列(dcCsvEntity.get緊急時傷病名２()));
        dcEntity.setKinkyuShobyoName3(get非空文字列(dcCsvEntity.get緊急時傷病名３()));
        dcEntity.setKinkyuChiryoKaishiYMD1(get非空年月日(dcCsvEntity.get緊急時治療開始年月日１()));
        dcEntity.setKinkyuChiryoKaishiYMD2(get非空年月日(dcCsvEntity.get緊急時治療開始年月日２()));
        dcEntity.setKinkyuChiryoKaishiYMD3(get非空年月日(dcCsvEntity.get緊急時治療開始年月日３()));
        dcEntity.setOshinNissu(dcCsvEntity.get往診日数());
        dcEntity.setOshinIryoKikanName(get非空文字列(dcCsvEntity.get往診医療機関名()));
        dcEntity.setTsuinNissu(dcCsvEntity.get通院日数());
        dcEntity.setTsuinIryoKikanName(get非空文字列(dcCsvEntity.get通院医療機関名()));
        dcEntity.setKinkyuChiryoKanriTanisu(dcCsvEntity.get緊急時治療管理単位数());
        dcEntity.setKinkyuChiryoKanriNissu(dcCsvEntity.get緊急時治療管理日数());
        dcEntity.setKinkyuChiryoKanriSubTotal(dcCsvEntity.get緊急時治療管理小計());
        dcEntity.setRehabilitationTensu(dcCsvEntity.getリハビリテーション点数());
        dcEntity.setShochiTensu(dcCsvEntity.get処置点数());
        dcEntity.setShujutsuTensu(dcCsvEntity.get手術点数());
        dcEntity.setMasuiTensu(dcCsvEntity.get麻酔点数());
        dcEntity.setHoshasenChiryoTensu(dcCsvEntity.get放射線治療点数());
        dcEntity.setTekiyo1(get非空文字列(dcCsvEntity.get摘要１()));
        dcEntity.setTekiyo2(get非空文字列(dcCsvEntity.get摘要2()));
        dcEntity.setTekiyo3(get非空文字列(dcCsvEntity.get摘要３()));
        dcEntity.setTekiyo4(get非空文字列(dcCsvEntity.get摘要４()));
        dcEntity.setTekiyo5(get非空文字列(dcCsvEntity.get摘要５()));
        dcEntity.setTekiyo6(get非空文字列(dcCsvEntity.get摘要６()));
        dcEntity.setTekiyo7(get非空文字列(dcCsvEntity.get摘要７()));
        dcEntity.setTekiyo8(get非空文字列(dcCsvEntity.get摘要８()));
        dcEntity.setTekiyo9(get非空文字列(dcCsvEntity.get摘要９()));
        dcEntity.setTekiyo10(get非空文字列(dcCsvEntity.get摘要10()));
        dcEntity.setTekiyo11(get非空文字列(dcCsvEntity.get摘要11()));
        dcEntity.setTekiyo12(get非空文字列(dcCsvEntity.get摘要12()));
        dcEntity.setTekiyo13(get非空文字列(dcCsvEntity.get摘要13()));
        dcEntity.setTekiyo14(get非空文字列(dcCsvEntity.get摘要14()));
        dcEntity.setTekiyo15(get非空文字列(dcCsvEntity.get摘要15()));
        dcEntity.setTekiyo16(get非空文字列(dcCsvEntity.get摘要16()));
        dcEntity.setTekiyo17(get非空文字列(dcCsvEntity.get摘要17()));
        dcEntity.setTekiyo18(get非空文字列(dcCsvEntity.get摘要18()));
        dcEntity.setTekiyo19(get非空文字列(dcCsvEntity.get摘要19()));
        dcEntity.setTekiyo20(get非空文字列(dcCsvEntity.get摘要20()));
        dcEntity.setKinkyuShisetsuRyoyohiTotalTensu(dcCsvEntity.get緊急時施設療養費合計点数());
        dcEntity.setShoteiShikkanShisetsuRyoyohiShobyoName1(get非空文字列(dcCsvEntity.get所定疾患施設療養費傷病名１()));
        dcEntity.setShoteiShikkanShisetsuRyoyohiShobyoName2(get非空文字列(dcCsvEntity.get所定疾患施設療養費傷病名２()));
        dcEntity.setShoteiShikkanShisetsuRyoyohiShobyoName3(get非空文字列(dcCsvEntity.get所定疾患施設療養費傷病名３()));
        dcEntity.setShoteiShikkanShisetsuRyoyohiKaishiYMD1(get非空年月日(dcCsvEntity.get所定疾患施設療養費開始年月日１()));
        dcEntity.setShoteiShikkanShisetsuRyoyohiKaishiYMD2(get非空年月日(dcCsvEntity.get所定疾患施設療養費開始年月日２()));
        dcEntity.setShoteiShikkanShisetsuRyoyohiKaishiYMD3(get非空年月日(dcCsvEntity.get所定疾患施設療養費開始年月日３()));
        dcEntity.setShoteiShikkanShisetsuRyoyohiTanisu(dcCsvEntity.get所定疾患施設療養費単位数());
        dcEntity.setShoteiShikkanShisetsuRyoyohiNissu(dcCsvEntity.get所定疾患施設療養費日数());
        dcEntity.setShoteiShikkanShisetsuRyoyohiSubTotal(dcCsvEntity.get所定疾患施設療養費小計());
        dcEntity.setAtoOshinNissu(dcCsvEntity.get後_往診日数());
        dcEntity.setAtoTsuinNissu(dcCsvEntity.get後_通院日数());
        dcEntity.setAtoKinkyuChiryoKanriTanisu(dcCsvEntity.get後_緊急時治療管理単位数());
        dcEntity.setAtoKinkyuChiryoKanriNissu(dcCsvEntity.get後_緊急時治療管理日数());
        dcEntity.setAtoRehabilitationTensu(dcCsvEntity.get後_リハビリテーション点数());
        dcEntity.setAtoShochiTensu(dcCsvEntity.get後_処置点数());
        dcEntity.setAtoShujutsuTensu(dcCsvEntity.get後_手術点数());
        dcEntity.setAtoMasuiTensu(dcCsvEntity.get後_麻酔点数());
        dcEntity.setAtoHoshasenChiryoTensu(dcCsvEntity.get後_放射線治療点数());
        dcEntity.setAtoShoteiShikkanShisetsuRyoyoHiTanisu(dcCsvEntity.get後_所定疾患施設療養費単位数());
        dcEntity.setAtoShoteiShikkanShisetsuRyoyoHiNissu(dcCsvEntity.get後_所定疾患施設療養費日数());
        dcEntity.setSaishinsaKaisu(dcCsvEntity.get再審査回数());
        dcEntity.setKagoKaisu(dcCsvEntity.get過誤回数());
        dcEntity.setShinsaYM(get非空年月(dcCsvEntity.get審査年月()));
        dcEntity.setSeiriNo(get非空文字列(dcCsvEntity.get整理番号()));
        dcEntity.setTorikomiYM(parameter.get処理年月());
        給付実績DC一時tableWriter.insert(dcEntity);
    }

    private void dd一時TBLに登録する(DbWT111OKyufuJissekiDDCsvEntity ddCsvEntity, int レコード番号) {
        DbWT111OKyufuJissekiDDEntity ddEntity = new DbWT111OKyufuJissekiDDEntity();
        ddEntity.setRenban(連番);
        ddEntity.setRecordNo(new RString(レコード番号));
        ddEntity.setKokanJohoShikibetsuNo(ddCsvEntity.get交換情報識別番号());
        ddEntity.setInputShikibetsuNo(ddCsvEntity.get入力識別番号());
        ddEntity.setRecodeShubetsuCode(get非空文字列(ddCsvEntity.getレコード種別コード()));
        ddEntity.setShokisaiHokenshaNo(ddCsvEntity.get証記載保険者番号());
        ddEntity.setHiHokenshaNo(ddCsvEntity.get被保険者番号());
        ddEntity.setServiceTeikyoYM(get非空年月(ddCsvEntity.getサービス提供年月()));
        ddEntity.setJigyoshoNo(new JigyoshaNo(get事業所番号(ddCsvEntity.get事業所番号())));
        ddEntity.setToshiNo(RString.EMPTY);
        ddEntity.setServiceShuruiCode(get非空サービス種類コード(ddCsvEntity.getサービス種類コード()));
        ddEntity.setServiceKomokuCode(get非空サービス項目コード(ddCsvEntity.getサービス項目コード()));
        ddEntity.setTanisu(get非空数字(ddCsvEntity.get単位数()));
        ddEntity.setNissuKaisu(get非空数字(ddCsvEntity.get日数_回数()));
        ddEntity.setKohi1TaishoNissuKaisu(get非空数字(ddCsvEntity.get公費１対象日数_回数()));
        ddEntity.setKohi2TaishoNissuKaisu(get非空数字(ddCsvEntity.get公費２対象日数_回数()));
        ddEntity.setKohi3TaishoNissuKaisu(get非空数字(ddCsvEntity.get公費３対象日数_回数()));
        ddEntity.setServiceTanisu(ddCsvEntity.getサービス単位数());
        ddEntity.setKohi1TaishoServiceTanisu(ddCsvEntity.get公費１対象サービス単位数());
        ddEntity.setKohi2TaishoServiceTanisu(ddCsvEntity.get公費２対象サービス単位数());
        ddEntity.setKohi3TaishoServiceTanisu(ddCsvEntity.get公費３対象サービス単位数());
        ddEntity.setShisetsuShozaiHokenshaNo(ddCsvEntity.get施設所在保険者番号());
        ddEntity.setTekiyo(get非空文字列(ddCsvEntity.get摘要()));
        ddEntity.setAtoTanisu(get非空数字(ddCsvEntity.get後_単位数()));
        ddEntity.setAtoNissuKaisu(get非空数字(ddCsvEntity.get後_日数_回数()));
        ddEntity.setAtoKohi1TaishoNissuKaisu(get非空数字(ddCsvEntity.get後_公費１対象日数_回数()));
        ddEntity.setAtoKohi2TaishoNissukaisu(get非空数字(ddCsvEntity.get後_公費２対象日数_回数()));
        ddEntity.setAtoKohi3TaishoNissuKaisu(get非空数字(ddCsvEntity.get後_公費３対象日数_回数()));
        ddEntity.setAtoServiceTanisu(ddCsvEntity.get後_サービス単位数());
        ddEntity.setAtoKohi1TaishoServiceTanisu(ddCsvEntity.get後_公費１対象サービス単位数());
        ddEntity.setAtoKohi2TaishoServiceTanisu(ddCsvEntity.get後_公費２対象サービス単位数());
        ddEntity.setAtoKohi3TaishoServiceTanisu(ddCsvEntity.get後_公費３対象サービス単位数());
        ddEntity.setSaishinsaKaisu(get非空数字(ddCsvEntity.get再審査回数()));
        ddEntity.setKagoKaisu(get非空数字(ddCsvEntity.get過誤回数()));
        ddEntity.setShinsaYM(get非空年月(ddCsvEntity.get審査年月()));
        ddEntity.setSeiriNo(get非空文字列(ddCsvEntity.get整理番号()));
        ddEntity.setTorikomiYM(parameter.get処理年月());
        給付実績DD一時tableWriter.insert(ddEntity);
    }

    private void t1一時TBLに登録する(DbWT111ZKyufuJissekiT1CsvEntity t1CsvEntity, int レコード番号) {
        DbWT111ZKyufuJissekiT1Entity t1Entity = new DbWT111ZKyufuJissekiT1Entity();
        t1Entity.setRenban(連番);
        t1Entity.setRecordNo(new RString(レコード番号));
        t1Entity.setKokanJohoShikibetsuNo(t1CsvEntity.get交換情報識別番号());
        t1Entity.setInputShikibetsuNo(t1CsvEntity.get入力識別番号());
        t1Entity.setRecodeShubetsuCode(get非空文字列(t1CsvEntity.getレコード種別コード()));
        t1Entity.setShokisaiHokenshaNo(t1CsvEntity.get証記載保険者番号());
        t1Entity.setHiHokenshaNo(t1CsvEntity.get被保険者番号());
        t1Entity.setServiceTeikyoYM(get非空年月(t1CsvEntity.getサービス提供年月()));
        t1Entity.setJigyoshoNo(new JigyoshaNo(get事業所番号(t1CsvEntity.get事業所番号())));
        t1Entity.setToshiNo(RString.EMPTY);
        t1Entity.setServiceSyuruiCode(get非空サービス種類コード(t1CsvEntity.getサービス種類コード()));
        t1Entity.setServiceJitsunissu(t1CsvEntity.getサービス実日数());
        t1Entity.setPlanTanisu(get非空数字(t1CsvEntity.get計画単位数()));
        t1Entity.setGendogakuKanriTaishoTanisu(get非空数字(t1CsvEntity.get限度額管理対象単位数()));
        t1Entity.setGendogakuKanritaishogaiTanisu(get非空数字(t1CsvEntity.get限度額管理対象外単位数()));
        t1Entity.setTankiNyushoPlanNissu(t1CsvEntity.get短期入所計画日数());
        t1Entity.setTankiNyushoJitsunissu(t1CsvEntity.get短期入所実日数());
        t1Entity.setHokenTanisuTotal(get非空数字(t1CsvEntity.get保険_単位数合計()));
        t1Entity.setHokenTanisuTani(get非空数字(t1CsvEntity.get保険_単位数単価()));
        t1Entity.setHokenSeikyugaku(get非空数字(t1CsvEntity.get保険_請求額()));
        t1Entity.setHokenRiyoshaFutangaku(get非空数字(t1CsvEntity.get保険_利用者負担額()));
        t1Entity.setKohi1TanisuTotal(get非空数字(t1CsvEntity.get公費１_単位数合計()));
        t1Entity.setKohi1Seikyugaku(get非空数字(t1CsvEntity.get公費１_請求額()));
        t1Entity.setKohi1HonninFutangaku(get非空数字(t1CsvEntity.get公費１_本人負担額()));
        t1Entity.setKohi2TanisuTotal(get非空数字(t1CsvEntity.get公費２_単位数合計()));
        t1Entity.setKohi2Seikyugaku(get非空数字(t1CsvEntity.get公費２_請求額()));
        t1Entity.setKohi2HonninFutangaku(get非空数字(t1CsvEntity.get公費２_本人負担額()));
        t1Entity.setKohi3TanisuTotal(get非空数字(t1CsvEntity.get公費３_単位数合計()));
        t1Entity.setKohi3Seikyugaku(get非空数字(t1CsvEntity.get公費３_請求額()));
        t1Entity.setKohi3HonninFutangaku(get非空数字(t1CsvEntity.get公費３_本人負担額()));
        t1Entity.setHokenDekidakaTanisuTotal(get非空数字(t1CsvEntity.get保険_出来高単位数合計()));
        t1Entity.setHokenDekidakaSeikyugaku(get非空数字(t1CsvEntity.get保険_出来高請求額()));
        t1Entity.setHokenDekidakaIryohiRiyoshaFutangaku(get非空数字(t1CsvEntity.get保険_出来高医療費利用者負担額()));
        t1Entity.setKohi1DekidakaTanisuTotal(get非空数字(t1CsvEntity.get公費１_出来高単位数合計()));
        t1Entity.setKohi1DekidakaSeikyugaku(get非空数字(t1CsvEntity.get公費１_出来高請求額()));
        t1Entity.setKohi1DekidakaIryohiRiyoshaFutangaku(get非空数字(t1CsvEntity.get公費１_出来高医療費利用者負担額()));
        t1Entity.setKohi2DekidakaTanisuTotal(get非空数字(t1CsvEntity.get公費２_出来高単位数合計()));
        t1Entity.setKohi2DekidakaSeikyugaku(get非空数字(t1CsvEntity.get公費２_出来高請求額()));
        t1Entity.setKohi2DekidakaIryohiRiyoshaFutangaku(get非空数字(t1CsvEntity.get公費２_出来高医療費本人負担額()));
        t1Entity.setKohi3DekidakaTanisuTotal(get非空数字(t1CsvEntity.get公費３_出来高単位数合計()));
        t1Entity.setKohi3DekidakaSeikyugaku(get非空数字(t1CsvEntity.get公費３_出来高請求額()));
        t1Entity.setKohi3DekidakaIryohiRiyoshaFutangaku(get非空数字(t1CsvEntity.get公費３_出来高医療費本人負担額()));
        t1Entity.setAtoTankiNyushoJitsunissu(t1CsvEntity.get後_短期入所実日数());
        t1Entity.setAtoHokenTanisuTotal(get非空数字(t1CsvEntity.get後_単位数合計()));
        t1Entity.setAtoHokenSeikyugaku(get非空数字(t1CsvEntity.get後_保険請求分請求額()));
        t1Entity.setAtoKohi1TanisuTotal(get非空数字(t1CsvEntity.get後_公費１_単位数合計()));
        t1Entity.setAtoKohi1Seikyugaku(get非空数字(t1CsvEntity.get後_公費１_請求額()));
        t1Entity.setAtoKohi2TanisuTotal(get非空数字(t1CsvEntity.get後_公費２_単位数合計()));
        t1Entity.setAtoKohi2Seikyugaku(get非空数字(t1CsvEntity.get後_公費２_請求額()));
        t1Entity.setAtoKohi3TanisuTotal(get非空数字(t1CsvEntity.get後_公費３_単位数合計()));
        t1Entity.setAtoKohi3Seikyugaku(get非空数字(t1CsvEntity.get後_公費３_請求額()));
        t1Entity.setAtoHokenDekidakaTanisuTotal(get非空数字(t1CsvEntity.get後_保険_出来高単位数合計()));
        t1Entity.setAtoHokenDekidakaSeikyugaku(get非空数字(t1CsvEntity.get後_保険_出来高請求額()));
        t1Entity.setAtoKohi1DekidakaTanisuTotal(get非空数字(t1CsvEntity.get後_公費１_出来高単位数合計()));
        t1Entity.setAtoKohi1DekidakaSeikyugaku(get非空数字(t1CsvEntity.get後_公費１_出来高請求額()));
        t1Entity.setAtoKohi2DekidakaTanisuTotal(get非空数字(t1CsvEntity.get後_公費２_出来高単位数合計()));
        t1Entity.setAtoKohi2DekidakaSeikyugaku(get非空数字(t1CsvEntity.get後_公費２_出来高請求額()));
        t1Entity.setAtoKohi3DekidakaTanisuTotal(get非空数字(t1CsvEntity.get後_公費３_出来高単位数合計()));
        t1Entity.setAtoKohi3DekidakaSeikyugaku(get非空数字(t1CsvEntity.get後_公費３_出来高請求額()));
        t1Entity.setSaishinsaKaisu(t1CsvEntity.get再審査回数());
        t1Entity.setKagoKaisu(t1CsvEntity.get過誤回数());
        t1Entity.setShinsaYM(get非空年月(t1CsvEntity.get審査年月()));
        t1Entity.setSeiriNo(get非空文字列(t1CsvEntity.get整理番号()));
        t1Entity.setTorikomiYM(parameter.get処理年月());
        給付実績T1一時tableWriter.insert(t1Entity);
    }

    private RString get事業所番号(JigyoshaNo 事業所番号) {
        if (事業所番号 == null || 事業所番号.isEmpty()) {
            return 事業所番号_0;
        } else {
            return 事業所番号.value().padLeft(RString.HALF_SPACE.toString(), DATA_10);
        }
    }

    private FlexibleDate get非空年月日(FlexibleDate 年月日) {
        if (null == 年月日) {
            return FlexibleDate.EMPTY;
        }
        return 年月日;
    }

    private FlexibleYearMonth get非空年月(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return FlexibleYearMonth.EMPTY;
        }
        return 年月;
    }

    private RString get非空文字列(RString 文字列) {
        if (null == 文字列) {
            return RString.EMPTY;
        }
        return 文字列;
    }

    private HokenKyufuRitsu get非空給付率(HokenKyufuRitsu 給付率) {
        if (null == 給付率) {
            return HokenKyufuRitsu.ZERO;
        }
        return 給付率;
    }

    private Decimal get非空数字(Decimal 数字) {
        if (null == 数字) {
            return Decimal.ZERO;
        }
        return 数字;
    }

    private ServiceShuruiCode get非空サービス種類コード(ServiceShuruiCode サービス種類コード) {
        if (null == サービス種類コード) {
            return ServiceShuruiCode.EMPTY;
        }
        return サービス種類コード;
    }

    private ServiceKomokuCode get非空サービス項目コード(ServiceKomokuCode サービス項目コード) {
        if (null == サービス項目コード) {
            return ServiceKomokuCode.EMPTY;
        }
        return サービス項目コード;
    }

}
