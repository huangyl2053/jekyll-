/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120130;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufujissekikoshinin.KyufuJissekiKoshinReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoControlCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H1KogakuGassanaJikofutangakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassanjikofutangaku.KogakuGassanJikofutangakuReadCsvFileService;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額証明書情報取込のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
public class KogakuGassanJikofutangakuReadCsvFileProcess extends BatchProcessBase<RString> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KyufuJissekiKoshinReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private KogakuGassanJikofutangakuShomeishoInCsvEntity shomeishoInCsvEntity;

    private KyufuJissekiKoshinJohoControlCSVEntity controlCsvEntity;
    private KyufuJissekiKoshinJohoDataEntity dataEntity;
    private KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity kihonMeisaiOneEntity;
    private KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity kihonMeisaiTwoEntity;
    private KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity kougakuKaigoMeisaiEntity;
    private KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity taisyogaiMeisaiEntity;
    private List<KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity> listCsvTaisyogaiMeisaiEntity;
    private KogakuGassanJikofutangakuReadCsvFileService service;
    private static final Integer INDEX_0 = 0;

    private static final RString カンマ = new RString(",");

    @BatchWriter
    private IBatchTableWriter 高額合算自己負担額一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 高額合算自己負担額明細一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 被保険者一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;

    private static final RString 高額合算自己負担額一時_TABLE_NAME = new RString("DbWT37H1KogakuGassanaJikofutangaku");
    private static final RString 高額合算自己負担額明細一時_TABLE_NAME = new RString("DbWT37H2KogakuGassanaJikofutangakuMeisai");
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");

    private OutputParameter<FlowEntity> flowEntity;
    private FlowEntity returnEntity;
    int 連番;

    @Override
    protected void initialize() {
        service = KogakuGassanJikofutangakuReadCsvFileService.createInstance();
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
        高額合算自己負担額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算自己負担額一時_TABLE_NAME, DbWT37H1KogakuGassanaJikofutangakuTempEntity.class);
        高額合算自己負担額明細一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算自己負担額明細一時_TABLE_NAME, DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity.class);
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaIchijiEntity.class);
    }

    @Override
    protected void process(RString t) {
        List<RString> data = t.split(カンマ.toString());
        if (null != shomeishoInCsvEntity) {
            連番 = 連番 + 1;
            service.insert高額合算自己負担額一時TBL(連番, shomeishoInCsvEntity, 高額合算自己負担額一時tableWriter);
            service.insert高額合算自己負担額明細一時TBL(連番, shomeishoInCsvEntity, 高額合算自己負担額一時tableWriter);
            service.insert被保険者一時TBL(連番, shomeishoInCsvEntity, 高額合算自己負担額一時tableWriter);
        }
        shomeishoInCsvEntity = ListToObjectMappingHelper.toObject(KogakuGassanJikofutangakuShomeishoInCsvEntity.class, data);
    }

    @Override
    protected void afterExecute() {
//        int レコード件数合算 = INDEX_0;
//        if (controlCsvEntity != null && controlCsvEntity.getCodeNum() != null) {
//            レコード件数合算 = Integer.parseInt(controlCsvEntity.getCodeNum().toString());
//        }
//        if (controlCsvEntity != null && controlCsvEntity.getShoriYM() != null) {
//            FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(controlCsvEntity.getShoriYM());
//            returnEntity.setShoriYM(処理対象年月);
//        }
//        returnEntity.setCodeNum(レコード件数合算);
//        returnEntity.set高額合算自己負担額一時TBL登録件数(renban);
//        flowEntity.setValue(returnEntity);
    }

}
