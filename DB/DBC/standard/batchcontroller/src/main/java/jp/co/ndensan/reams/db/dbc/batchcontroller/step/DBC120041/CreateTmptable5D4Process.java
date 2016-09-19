/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kyodojukyushainsub.KyufuJissekiInProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C32ShoukanKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.KyoudouShori5C3CsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.KyoudouShori5D4CsvEntity;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一時TBL作成処理Processクラスです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
public class CreateTmptable5D4Process extends BatchProcessBase<KyoudouShori5D4CsvEntity> {

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString TABLE_償還共同処理一時TBL = new RString("DbWT5C32ShoukanKyoudouShori");
    private KyufuJissekiInProcessParameter processParameter;
    /**
     * レコード件数です。
     */
    public static final RString レコード件数;
    /**
     * 処理対象年月です。
     */
    public static final RString 処理対象年月;

    static {
        レコード件数 = new RString("outDataKensu");
        処理対象年月 = new RString("outDataNengetu");
    }
    private OutputParameter<Integer> outDataKensu;
    private OutputParameter<RString> outDataNengetu;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 償還共同処理一時TBL;

    @Override
    protected void initialize() {
        outDataKensu = new OutputParameter();
        outDataNengetu = new OutputParameter();
    }

    @Override
    protected IBatchReader createReader() {
        RString csvReaderPath = Path.combinePath(processParameter.get保存先フォルダ(), processParameter.getCsvファイル名());
        RString filePath = Path.combinePath(csvReaderPath);
        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, KyoudouShori5C3CsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(true).setNewLine(NewLine.LF).build();
        return new BatchCsvReader(csvReader);
    }

    @Override
    protected void createWriter() {
        償還共同処理一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_償還共同処理一時TBL,
                DbWT5C32ShoukanKyoudouShoriEntity.class);
    }

    @Override
    protected void process(KyoudouShori5D4CsvEntity csvEntity) {
        outDataKensu.setValue(Integer.valueOf(csvEntity.getレコード件数().toString()));
        outDataNengetu.setValue(csvEntity.get処理対象年月());
        償還共同処理一時TBL.insert(getDbWT5C32Entity(csvEntity));
    }

    @Override
    protected void afterExecute() {
    }

    private DbWT5C32ShoukanKyoudouShoriEntity getDbWT5C32Entity(KyoudouShori5D4CsvEntity csvEntity) {
        DbWT5C32ShoukanKyoudouShoriEntity entity = new DbWT5C32ShoukanKyoudouShoriEntity();
        entity.setHokenshaNo(csvEntity.get保険者番号());
        entity.setHokenshaName(get保険者名(new HokenjaNo(csvEntity.get保険者番号())));
        entity.setShikibetsuNo(csvEntity.get交換情報識別番号());
        entity.setHiHokenshaNo(csvEntity.get被保険者番号());
        entity.setIdoYMD(csvEntity.get異動年月日());
        entity.setIdoKubunCode(csvEntity.get異動区分コード());
        entity.setJukyushaIdoJiyu(csvEntity.get異動事由());
        entity.setShoKisaiHokenshaNo(csvEntity.get証記載保険者番号());
        entity.setHokenKyufuIchijiSashitomeKaishiYMD(csvEntity.get保険給付支払の一時差止の開始年月日());
        entity.setHokenKyufuIchijiSashitomeShuryoYMD(csvEntity.get保険給付支払の一時差止の終了年月日());
        entity.setHokenkyufuIchijiSashitomeKubunCode(csvEntity.get保険給付支払の一時差止区分());
        entity.setHokenkyufuIchijiSashitomeKingaku(csvEntity.get保険給付支払の一時差止金額());
        entity.setTeiseiYMD(csvEntity.get訂正年月日());
        return entity;
    }

    private RString get保険者名(HokenjaNo 保険者番号) {
        Hokensha hokensha = HokenshaNyuryokuHojoFinder.createInstance().getHokensha(保険者番号);
        if (hokensha != null) {
            return hokensha.get保険者名();
        }
        return RString.EMPTY;
    }
}
