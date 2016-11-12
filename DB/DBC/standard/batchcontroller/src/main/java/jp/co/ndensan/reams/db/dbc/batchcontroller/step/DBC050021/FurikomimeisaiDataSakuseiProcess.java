/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiDataSakusei_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050021.FurikomimeisaiFurikomiDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.KozaFurikomiTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.FurikomiDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 振込データ作成_Process処理クラスです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class FurikomimeisaiDataSakuseiProcess extends BatchProcessBase<FurikomiDataSakuseiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.get振込対象データ");
    private FurikomimeisaiFurikomiDataProcessParameter parameter;
    /**
     * 件数取得です。
     */
    public static final RString PARAMETER_OUT_件数;

    static {
        PARAMETER_OUT_件数 = new RString("件数");
    }
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final RString 名 = new RString("名");
    private static final RString 件 = new RString("件");
    private static final RString RSTRING_0 = new RString("0");

    private OutputParameter<Integer> 件数;
    private int renban;
    @BatchWriter
    BatchEntityCreatedTempTableWriter shoriKekkaKakuninListDataNasi;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT0511KozaFurikomi;

    @Override
    protected void initialize() {
        件数 = new OutputParameter<>();
        renban = INT_0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        shoriKekkaKakuninListDataNasi = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShoriKekkaKakuninListTempTableEntity.class)
                .tempTableName(ShoriKekkaKakuninListTempTableEntity.TABLE_NAME).build();
        dbWT0511KozaFurikomi = BatchEntityCreatedTempTableWriterBuilders.createBuilder(KozaFurikomiTempTableEntity.class)
                .tempTableName(KozaFurikomiTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(FurikomiDataSakuseiEntity entity) {
        renban = renban + INT_1;
        KozaFurikomiTempTableEntity tempTable = setKozaFurikomiTempTableEntity(entity);
        dbWT0511KozaFurikomi.insert(tempTable);
    }

    @Override
    protected void afterExecute() {
        件数.setValue(renban);
        if (renban == INT_0) {
            ShoriKekkaKakuninListTempTableEntity tempTable2 = get処理結果確認リスト一時();
            shoriKekkaKakuninListDataNasi.insert(tempTable2);
        }
    }

    private ShoriKekkaKakuninListTempTableEntity get処理結果確認リスト一時() {
        ShoriKekkaKakuninListTempTableEntity shoriKekkaKakuninList = new ShoriKekkaKakuninListTempTableEntity();
        shoriKekkaKakuninList.setErrorKubun(FurikomiDataSakusei_ErrorKubun.振込データなし.getコード());
        shoriKekkaKakuninList.setBiko(RString.EMPTY);
        shoriKekkaKakuninList.setHiHokenshaNo(HihokenshaNo.EMPTY);
        shoriKekkaKakuninList.setHihokenshaShimei(RString.EMPTY);
        shoriKekkaKakuninList.setKey1(RString.EMPTY);
        shoriKekkaKakuninList.setKey2(RString.EMPTY);
        shoriKekkaKakuninList.setKey3(RString.EMPTY);
        shoriKekkaKakuninList.setKey4(RString.EMPTY);
        shoriKekkaKakuninList.setKey5(RString.EMPTY);
        shoriKekkaKakuninList.setShoKisaiHokenshaNo(ShoKisaiHokenshaNo.EMPTY);
        return shoriKekkaKakuninList;
    }

    private KozaFurikomiTempTableEntity setKozaFurikomiTempTableEntity(FurikomiDataSakuseiEntity entity) {
        KozaFurikomiTempTableEntity tempTable1 = new KozaFurikomiTempTableEntity();
        tempTable1.setFurikomiId(Long.valueOf(RSTRING_0.toString()));
        tempTable1.setItakushaId(parameter.get委託者ID() == null || parameter.get委託者ID().isEmpty()
                ? Decimal.ZERO : new Decimal(parameter.get委託者ID().toString()));
        tempTable1.setFurikomiYMD(parameter.get振込指定年月日());
        tempTable1.setSakuseiKaisu(Decimal.ONE);
        tempTable1.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        tempTable1.setGyomunaiKubun(parameter.get振込業務内区分().getコード());
        tempTable1.setKamokuCode(KamokuCode.EMPTY);
        tempTable1.setKamokuEdabanCode(EdabanCode.EMPTY);
        tempTable1.setRyokinShubetsuCode(Code.EMPTY);
        tempTable1.setJigyoKubunCode(Code.EMPTY);
        tempTable1.setFurikomiKubun(Code.EMPTY);
        DbWT0510FurikomiMeisaiTempEntity furikomiDetailEntity = entity.get振込明細一時Entity();
        if (furikomiDetailEntity != null) {
            tempTable1.setKinyuKikanCode(furikomiDetailEntity.getKinyuKikanCode());
            tempTable1.setKinyuKikanName(furikomiDetailEntity.getKinyuKikanName());
            tempTable1.setKinyuKikanKanaName(furikomiDetailEntity.getKinyuKikanKanaName());
            tempTable1.setKinyuKikanShitenCode(furikomiDetailEntity.getKinyuKikanShitenCode());
            tempTable1.setKinyuKikanShitenName(furikomiDetailEntity.getKinyuKikanShitenName());
            tempTable1.setKinyuKikanShitenKanaName(furikomiDetailEntity.getKinyuKikanShitenKanaName());
            tempTable1.setYokinShubetsu(furikomiDetailEntity.getYokinShubetsuCode());
            tempTable1.setKozaNo(furikomiDetailEntity.getKozaNo());
            tempTable1.setKozaMeiginin(furikomiDetailEntity.getKozaMeiginin());
            tempTable1.setKozaMeigininKanji(furikomiDetailEntity.getKozaMeigininKanji());
            if (furikomiDetailEntity.getHihokenshaNo() != null && !furikomiDetailEntity.getHihokenshaNo().isEmpty()) {
                tempTable1.setKokyakuCode2(furikomiDetailEntity.getHihokenshaNo().value());
            }
            tempTable1.setTaishoshaShikibetsuCode(furikomiDetailEntity.getKozaShikibetsuCode());
        }
        RString 口座摘要 = RString.EMPTY;
        int 件数_口座摘要 = entity.get件数();
        if (件数_口座摘要 == 1) {
            口座摘要 = RString.EMPTY;
        } else if (件数_口座摘要 >= 2) {
            口座摘要 = 名.concat(RString.HALF_SPACE).concat(RString.HALF_SPACE)
                    .concat(RString.HALF_SPACE).concat(RString.HALF_SPACE).concat(new RString(件数_口座摘要)).concat(件);
        }
        tempTable1.setKozaTekiyo(口座摘要);
        tempTable1.setFurikomigaku(entity.get合計振込金額());
        tempTable1.setKokyakuCode1(RString.EMPTY);

        tempTable1.setTesuryoFutanKubun(RString.EMPTY);
        tempTable1.setTesuryo(Decimal.ZERO);
        tempTable1.setFurikomiSakuseiKubun(new Code(RSTRING_0));
        tempTable1.setFurikomiSakuseiYMDHMS(parameter.getシステム日時());

        tempTable1.setBaitaiSakuseizumiFlag(false);
        tempTable1.setIraishoSakuseizumiFlag(false);
        tempTable1.setSakujoFlag(false);
        tempTable1.setGyomuKoyuKey(entity.getKozaNayoseKey());

        return tempTable1;

    }

}
