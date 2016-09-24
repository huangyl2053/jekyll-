/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushainsub.KyoudouShoriYouJukyuusyaJouhou;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenTorikomiKokanJohoShikibetsuBango;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyodojukyushainsub.KyufuJissekiInProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C31KihonKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C32ShoukanKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C33KougakuKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvListReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一時TBL作成処理Processクラスです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
public class CreateTmptableProcess extends BatchProcessBase<List<RString>> {

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString レコード種別_コントロール = new RString("1");
    private static final RString レコード種別_データ = new RString("2");
    private static final int INDEX_3 = 3;
    private static final int INDEX_6 = 6;
    private static final int INDEX_10 = 10;
    private static final RString TABLE_基本共同処理一時TBL = new RString("DbWT5C31KihonKyoudouShori");
    private static final RString TABLE_償還共同処理一時TBL = new RString("DbWT5C32ShoukanKyoudouShori");
    private static final RString TABLE_高額共同処理一時TBL = new RString("DbWT5C33KougakuKyoudouShori");
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
    private RString 保険者番号;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 基本共同処理一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 償還共同処理一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額共同処理一時TBL;

    @Override
    protected void initialize() {
        outDataKensu = new OutputParameter();
        outDataNengetu = new OutputParameter();
    }

    @Override
    protected IBatchReader createReader() {
        RString csvReaderPath = Path.combinePath(processParameter.get保存先フォルダ(), processParameter.getCsvファイル名());
        RString filePath = Path.combinePath(csvReaderPath);
        return new BatchCsvListReader(new CsvListReader.InstanceBuilder(filePath)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).hasHeader(false).setNewLine(NewLine.CRLF).build());
    }

    @Override
    protected void createWriter() {
        基本共同処理一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_基本共同処理一時TBL,
                DbWT5C31KihonKyoudouShoriEntity.class);
        償還共同処理一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_償還共同処理一時TBL,
                DbWT5C32ShoukanKyoudouShoriEntity.class);
        高額共同処理一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_高額共同処理一時TBL,
                DbWT5C33KougakuKyoudouShoriEntity.class);
    }

    @Override
    protected void process(List<RString> data) {
        if (data != null && !data.isEmpty()) {
            if (レコード種別_コントロール.equals(data.get(0))) {
                outDataKensu.setValue(Integer.valueOf(data.get(INDEX_3).toString()));
                outDataNengetu.setValue(data.get(INDEX_10));
                保険者番号 = data.get(INDEX_6);
            }
            if (レコード種別_データ.equals(data.get(0))) {
                save共同処理用受給者情報(data);
            }
        }
    }

    @Override
    protected void afterExecute() {
    }

    private void save共同処理用受給者情報(List<RString> data) {
        KyoudouShoriYouJukyuusyaJouhou jouhou = new KyoudouShoriYouJukyuusyaJouhou(保険者番号);
        RString 保険者名 = get保険者名();
        if (KokuhorenTorikomiKokanJohoShikibetsuBango.共同処理用受給者情報更新結果情報_基本情報.getコード().equals(data.get(2))) {
            基本共同処理一時TBL.insert(jouhou.getDbWT5C31Entity(data, 保険者名));
        } else if (KokuhorenTorikomiKokanJohoShikibetsuBango.共同処理用受給者情報更新結果情報_償還情報.getコード().equals(data.get(2))) {
            償還共同処理一時TBL.insert(jouhou.getDbWT5D31Entity(data, 保険者名));
        } else if (KokuhorenTorikomiKokanJohoShikibetsuBango.共同処理用受給者情報更新結果情報_高額情報.getコード().equals(data.get(2))) {
            高額共同処理一時TBL.insert(jouhou.getDbWT5E31Entity(data, 保険者名));
        } else if (KokuhorenTorikomiKokanJohoShikibetsuBango.共同処理用受給者情報_基本情報.getコード().equals(data.get(2))) {
            基本共同処理一時TBL.insert(jouhou.getDbWT5C41Entity(data, 保険者名));
        } else if (KokuhorenTorikomiKokanJohoShikibetsuBango.共同処理用受給者情報_償還情報.getコード().equals(data.get(2))) {
            償還共同処理一時TBL.insert(jouhou.getDbWT5D41Entity(data, 保険者名));
        } else if (KokuhorenTorikomiKokanJohoShikibetsuBango.共同処理用受給者情報_高額情報.getコード().equals(data.get(2))) {
            高額共同処理一時TBL.insert(jouhou.getDbWT5E41Entity(data, 保険者名));
        }
    }

    private RString get保険者名() {
        if (!RString.isNullOrEmpty(保険者番号)) {
            Hokensha hokensha = HokenshaNyuryokuHojoFinder.createInstance().getHokensha(new HokenjaNo(保険者番号));
            if (hokensha != null) {
                return hokensha.get保険者名();
            }
        }
        return RString.EMPTY;
    }
}
