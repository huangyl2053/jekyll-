/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kyodojukyushainsub.KyufuJissekiInProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C31KihonKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C32ShoukanKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C33KougakuKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.KyoudouShoriCsvEntity;
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
public class CreateTmptableProcess extends BatchProcessBase<KyoudouShoriCsvEntity> {

    private static final RString 基本情報_5C31 = new RString("5C31");
    private static final RString 償還情報_5D31 = new RString("5D31");
    private static final RString 高額情報_5E31 = new RString("5E31");
    private static final RString 基本情報_5C41 = new RString("5C41");
    private static final RString 償還情報_5D41 = new RString("5D41");
    private static final RString 高額情報_5E41 = new RString("5E41");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
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
        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, KyoudouShoriCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(true).setNewLine(NewLine.LF).build();
        return new BatchCsvReader(csvReader);
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
    protected void process(KyoudouShoriCsvEntity csvEntity) {
        outDataKensu.setValue(Integer.valueOf(csvEntity.getレコード件数().toString()));
        outDataNengetu.setValue(csvEntity.get処理対象年月());
        if (基本情報_5C31.equals(csvEntity.get交換情報識別番号()) || 基本情報_5C41.equals(csvEntity.get交換情報識別番号())) {
            基本共同処理一時TBL.insert(getDbWT5C31Entity(csvEntity));
        } else if (償還情報_5D31.equals(csvEntity.get交換情報識別番号()) || 償還情報_5D41.equals(csvEntity.get交換情報識別番号())) {
            償還共同処理一時TBL.insert(getDbWT5C32Entity(csvEntity));
        } else if (高額情報_5E31.equals(csvEntity.get交換情報識別番号()) || 高額情報_5E41.equals(csvEntity.get交換情報識別番号())) {
            高額共同処理一時TBL.insert(getDbWT5C33Entity(csvEntity));
        }
    }

    @Override
    protected void afterExecute() {
    }

    private DbWT5C31KihonKyoudouShoriEntity getDbWT5C31Entity(KyoudouShoriCsvEntity csvEntity) {
        DbWT5C31KihonKyoudouShoriEntity entity = new DbWT5C31KihonKyoudouShoriEntity();
        entity.setHokenshaNo(csvEntity.get保険者番号());
        entity.setHokenshaName(get保険者名(new HokenjaNo(csvEntity.get保険者番号())));
        entity.setShikibetsuNo(csvEntity.get交換情報識別番号());
        entity.setHiHokenshaNo(csvEntity.get被保険者番号());
        entity.setIdoYMD(csvEntity.get異動年月日());
        entity.setIdoKubunCode(csvEntity.get異動区分コード());
        entity.setJukyushaIdoJiyu(csvEntity.get異動事由());
        entity.setShoKisaiHokenshaNo(csvEntity.get証記載保険者番号());
        entity.setHiHokenshaName(csvEntity.get被保険者氏名());
        entity.setYubinNo(csvEntity.get郵便番号());
        entity.setDdressKana(csvEntity.get住所カナ());
        entity.setAddress(csvEntity.get住所());
        entity.setTelNo(csvEntity.get電話番号());
        entity.setChohyoOutputJunjyoCode(csvEntity.get帳票出力順序コード());
        entity.setTeiseiKubunCode(csvEntity.get訂正区分コード());
        entity.setTeiseiYMD(csvEntity.get訂正年月日());
        return entity;
    }

    private DbWT5C32ShoukanKyoudouShoriEntity getDbWT5C32Entity(KyoudouShoriCsvEntity csvEntity) {
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
        entity.setTeiseiKubunCode(csvEntity.get訂正区分コード());
        entity.setTeiseiYMD(csvEntity.get訂正年月日());
        return entity;
    }

    private DbWT5C33KougakuKyoudouShoriEntity getDbWT5C33Entity(KyoudouShoriCsvEntity csvEntity) {
        DbWT5C33KougakuKyoudouShoriEntity entity = new DbWT5C33KougakuKyoudouShoriEntity();
        entity.setHokenshaNo(csvEntity.get保険者番号());
        entity.setHokenshaName(get保険者名(new HokenjaNo(csvEntity.get保険者番号())));
        entity.setShikibetsuNo(csvEntity.get交換情報識別番号());
        entity.setHiHokenshaNo(csvEntity.get被保険者番号());
        entity.setIdoYMD(csvEntity.get異動年月日());
        entity.setIdoKubunCode(csvEntity.get異動区分コード());
        entity.setJukyushaIdoJiyu(csvEntity.get異動事由());
        entity.setShoKisaiHokenshaNo(csvEntity.get証記載保険者番号());
        entity.setSetaiShuyakuNo(csvEntity.get世帯主被保険者番号());
        entity.setSetaiShotokuKubunCode(csvEntity.get世帯所得区分コード());
        entity.setShotokuKubunCode(csvEntity.get所得区分コード());
        entity.setRoureiFukushiNenkinJukyuAriFlag(csvEntity.get老齢福祉年金受給の有無());
        entity.setRiyoshaFutan2DankaiAriFlag(csvEntity.get利用者負担第２段階());
        entity.setShikyuShinseishoOutputAriFlag(csvEntity.get支給申請書出力の有無());
        entity.setTeiseiKubunCode(csvEntity.get訂正区分コード());
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
