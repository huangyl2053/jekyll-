/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiDataSakusei_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_MeisaiDataKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.FurikomiDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.KozaFurikomiTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 振込データ作成_Process処理クラスです．
 *
 * @reamsid_L DBC-2830-030 donghj
 */
public class FurikomiDataProcess extends BatchProcessBase<FurikomiDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.dbc050010.IFurikomiDataMapper.get振込対象データ");
    private FurikomiDataProcessParameter parameter;

    private boolean flag = true;
    private static final int INT10 = 10;
    private static final RString 名 = new RString("名");
    private static final RString 件 = new RString("件");
    private static final RString 文字 = new RString("△");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT0512ShoriKekkaKakuninList;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT0511KozaFurikomi;

    @Override
    protected void createWriter() {
        dbWT0512ShoriKekkaKakuninList = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShoriKekkaKakuninListTempTableEntity.class)
                .tempTableName(ShoriKekkaKakuninListTempTableEntity.TABLE_NAME).build();
        dbWT0511KozaFurikomi = BatchEntityCreatedTempTableWriterBuilders.createBuilder(KozaFurikomiTempTableEntity.class)
                .tempTableName(KozaFurikomiTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(FurikomiDataEntity entity) {
        flag = false;
        KozaFurikomiTempTableEntity tempTable = setKozaFurikomiTempTableEntity(entity);
        dbWT0511KozaFurikomi.insert(tempTable);
    }

    @Override
    protected void afterExecute() {
        if (flag) {
            ShoriKekkaKakuninListTempTableEntity tempTable2 = new ShoriKekkaKakuninListTempTableEntity();
            tempTable2.setErrorKubun(FurikomiDataSakusei_ErrorKubun.振込データなし.getコード());
            dbWT0512ShoriKekkaKakuninList.insert(tempTable2);
        }
    }

    private KozaFurikomiTempTableEntity setKozaFurikomiTempTableEntity(FurikomiDataEntity entity) {

        KozaFurikomiTempTableEntity tempTable1 = new KozaFurikomiTempTableEntity();
        tempTable1.setFurikomiId(Long.valueOf("0"));
        tempTable1.setItakushaId(Decimal.ZERO);
        tempTable1.setFurikomiYMD(parameter.get振込指定年月日());
        tempTable1.setSakuseiKaisu(Decimal.ONE);
        tempTable1.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        tempTable1.setGyomunaiKubun(parameter.get振込業務内区分().getコード());
        tempTable1.setKamokuCode(KamokuCode.EMPTY);
        tempTable1.setKamokuEdabanCode(EdabanCode.EMPTY);
        tempTable1.setRyokinShubetsuCode(Code.EMPTY);
        tempTable1.setJigyoKubunCode(Code.EMPTY);
        tempTable1.setFurikomiKubun(Code.EMPTY);
        RString データ区分の名称 = RString.EMPTY;
        FurikomiDetailTempTableEntity furikomiDetailEntity = entity.get振込明細一時Entity();
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
            if (furikomiDetailEntity.getDataKubun() != null && !furikomiDetailEntity.getDataKubun().isEmpty()) {
                データ区分の名称 = Furikomi_MeisaiDataKubun.toValue(furikomiDetailEntity.getDataKubun()).get名称();
            }

        }
        RString 口座摘要 = null;
        int 件数 = entity.get件数();

        if (件数 == 1) {
            口座摘要 = データ区分の名称.padLeft(RString.HALF_SPACE, INT10);
        } else if (件数 >= 2 && entity.getデータ区分件数() == 1) {
            口座摘要 = set口座摘要(件数, データ区分の名称);
        } else if (件数 >= 2 && entity.getデータ区分件数() >= 2) {
            RString 償還高額の名称 = Furikomi_MeisaiDataKubun.償還高額.get名称();
            口座摘要 = set口座摘要(件数, 償還高額の名称);
        }
        tempTable1.setKozaTekiyo(口座摘要);
        tempTable1.setFurikomigaku(entity.get合計振込金額());
        tempTable1.setKokyakuCode1(RString.EMPTY);

        tempTable1.setTesuryoFutanKubun(RString.EMPTY);
        tempTable1.setTesuryo(Decimal.ZERO);
        tempTable1.setFurikomiSakuseiKubun(new Code("0"));
        tempTable1.setFurikomiSakuseiYMDHMS(YMDHMS.now());

        tempTable1.setBaitaiSakuseizumiFlag(false);
        tempTable1.setIraishoSakuseizumiFlag(false);
        tempTable1.setSakujoFlag(false);
        if (furikomiDetailEntity != null) {
            tempTable1.setGyomuKoyuKey(furikomiDetailEntity.getKozaNayoseKey());
        }
        return tempTable1;

    }

    private RString set口座摘要(int 件数, RString 名称) {
        RStringBuilder rStringBuilder = new RStringBuilder().append(名).append(RString.HALF_SPACE)
                .append(RString.HALF_SPACE).append(RString.HALF_SPACE).append(RString.HALF_SPACE).
                append(件数).append(件).append(文字).append(名称);
        return rStringBuilder.toRString();
    }

}
