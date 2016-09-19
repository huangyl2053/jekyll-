/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb112001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112003.SichousonEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shutokujohoshuchutsurenkei.ShutokuJohoShuchutsuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.csv.ToushoShotokuJohoChushutsuRenkeiCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohotemp.DbTShotokuJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 所得情報抽出・連携バッチのファイルの登録Processです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public class SelectShotokuJohoProcess extends BatchProcessBase<RString> {

    private static final RString 区切り文字 = new RString(",");
    private static final RString 所得情報一時TABLE_NAME = new RString("DbTShotokuJoho");
    private static final RString 当初_広域_1 = new RString("1");
    private static final RString 異動_広域_2 = new RString("2");
    private static final RString 当初_単一_3 = new RString("3");
    private static final RString 異動_単一_4 = new RString("4");

    private RString csvReaderPath;
    private ShutokuJohoShuchutsuRenkeiProcessParameter parameter;
    private ToushoShotokuJohoChushutsuRenkeiCSVEntity csvEntity;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 所得情報一時tableWriter;

    @Override
    protected void initialize() {
        // TODO  batchParameterのパラメータは問題があります、csvReaderPath = parameter.getPath().concat(KEY_分離文字).concat(parameter.getFileName());
        csvReaderPath = Path.combinePath(parameter.get共有ファイルID(), parameter.get共有ファイル名());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(csvReaderPath);
    }

    @Override
    protected void createWriter() {
        所得情報一時tableWriter
                = new BatchEntityCreatedTempTableWriter(所得情報一時TABLE_NAME, DbTShotokuJohoTempTableEntity.class);
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        csvEntity = ListToObjectMappingHelper.toObject(ToushoShotokuJohoChushutsuRenkeiCSVEntity.class, data);
        RString 処理区分 = parameter.get処理区分();
        List<SichousonEntity> 市町村情報List = parameter.get市町村情報List();
        if (当初_広域_1.equals(処理区分) || 異動_広域_2.equals(処理区分)) {
            for (SichousonEntity 市町村情報 : 市町村情報List) {
                if (市町村コードチェック(csvEntity.get市町村コード(), 市町村情報.get市町村コード())) {
                    DbTShotokuJohoTempTableEntity tempEntity = get所得情報entity(csvEntity);
                    所得情報一時tableWriter.insert(tempEntity);
                }
            }
        } else if (当初_単一_3.equals(処理区分) || 異動_単一_4.equals(処理区分)) {
            DbTShotokuJohoTempTableEntity tempEntity = get所得情報entity(csvEntity);
            所得情報一時tableWriter.insert(tempEntity);
        }

    }

    private boolean 市町村コードチェック(RString 市町村コードcsv, LasdecCode 市町村コードentity) {
        if (市町村コードcsv == null || 市町村コードcsv.isEmpty() || 市町村コードentity == null || 市町村コードentity.isEmpty()) {
            return false;
        } else {
            return 市町村コードcsv.equals(市町村コードentity.getColumnValue());
        }
    }

    private DbTShotokuJohoTempTableEntity get所得情報entity(ToushoShotokuJohoChushutsuRenkeiCSVEntity entity) {
        DbTShotokuJohoTempTableEntity 一時entity = new DbTShotokuJohoTempTableEntity();
        一時entity.setShichosonCode(new LasdecCode(entity.get市町村コード()));
        一時entity.setShikibetuId(entity.get識別ＩＤ());
        一時entity.setTimeStep(entity.getタイムスタンプ());
        一時entity.setSaisyuRecordKunbun(entity.get最終レコード区分());
        一時entity.setRenben(Integer.valueOf(entity.get連番().toString()));
        一時entity.setFiller(entity.getＦＩＬＬＥＲ());
        FlexibleYear 賦課年度 = entity.get賦課年度() == null
                || entity.get賦課年度().isEmpty() ? FlexibleYear.EMPTY : new FlexibleYear(entity.get賦課年度());
        一時entity.setFukaNendo(賦課年度);
        ShikibetsuCode 住民ｺｰﾄﾞ = entity.get住民ｺｰﾄﾞ() == null
                || entity.get住民ｺｰﾄﾞ().isEmpty() ? ShikibetsuCode.EMPTY : new ShikibetsuCode(entity.get住民ｺｰﾄﾞ());
        一時entity.setJyuuminCode(住民ｺｰﾄﾞ);
        一時entity.setShotoKunbun(entity.get所得把握区分_申告区分());
        一時entity.setHiKazeiKunbun(entity.get非課税区分());
        一時entity.setJyuuminseiKiru(entity.get住民税所得割());
        一時entity.setJyuuminseiIziKiru(entity.get住民税均等割());
        一時entity.setGokeiShotokuGaku(strToDecimal(entity.get合計所得金額()));
        一時entity.setAgiShunyuGaku(strToDecimal(entity.get給与収入額()));
        一時entity.setNenkiniShunyuGaku(strToDecimal(entity.get公的年金等収入額()));
        一時entity.setNenkiniShotokuGaku(strToDecimal(entity.get公的年金等所得額()));
        一時entity.setSonotaSyutoku1(entity.getその他所得１());
        一時entity.setSonotaSyutoku2(entity.getその他所得２());
        一時entity.setYobi(entity.get予備());
        一時entity.setGekihenkanwaKubun(entity.get激変緩和区分());
        一時entity.setDataShubetsu(entity.getデータ種類());
        一時entity.setShotoZei(strToDecimal(entity.get所得税()));
        一時entity.setUpdateTimestamp(entity.get更新日時());
        return 一時entity;
    }

    private Decimal strToDecimal(RString str) {
        return str == null || str.isEmpty() ? null : new Decimal(str.toString());
    }
}
