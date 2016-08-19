/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100203;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.temptable.TorikomiTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 遡及非課税年金対象者同定_未同定データ作成_process処理クラスです。
 *
 * @reamsid_L DBD-4910-050 x_youyj
 */
public class MiDouteiDataCreateProcess extends BatchProcessBase<DbT4037HikazeNenkinTaishoshaEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.sokyuhikazeinenkintaishousyadoutei."
            + "IMiDouteiDataCreateMapper.get未同定データ作成情報");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(
                TorikomiTempTableEntity.class)
                .tempTableName(TorikomiTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(DbT4037HikazeNenkinTaishoshaEntity t) {
        TorikomiTempTableEntity tempTableEntity
                = createTempTableEntity(t);
        tmpTableWriter.insert(tempTableEntity);
    }

    private TorikomiTempTableEntity createTempTableEntity(DbT4037HikazeNenkinTaishoshaEntity entity) {
        TorikomiTempTableEntity data = new TorikomiTempTableEntity();
        if (entity != null) {
            data.setDtrekodoKubun(entity.getDtrecordkubun());
            data.setDtshichosonCode(entity.getDtcitycode());
            data.setDtDTnennkinnHokennshaCode(entity.getDtnenkinhokenshacode());
            data.setDttsuuchiContentCode(entity.getDttsuchinaiyocode());
            data.setDtyobi1(entity.getDtyobi1());
            data.setDtseidoCode(entity.getDtseidocode());
            data.setDtcreateYMD(new FlexibleDate(entity.getDtsakuseiymd()));
            data.setDtnennkinnNo(entity.getDtkisonenkinno());
            data.setDtnennkinnCode(entity.getDtnenkincode());
            data.setDtyobi2(entity.getDtyobi2());
            data.setDtseinenngappi(entity.getDtbirthday());
            data.setDtseibetsu(entity.getDtseibetsu());
            data.setDtkanaShimei(entity.getDtkanashimei());
            data.setDtshifutoCode1(entity.getDtshiftcode1());
            data.setDtkanjiShimei(entity.getDtkanjishimei());
            data.setDtshifutoCode2(entity.getDtshiftcode2());
            data.setDtYubinNo(new YubinNo(entity.getDtyubinno()));
            data.setDtkanaJusyo(entity.getDtkanajusho());
            data.setDtshifutoCode3(entity.getDtshiftcode3());
            data.setDtkanjiJusyo(entity.getDtkanjijusho());
            data.setDtshifutoCode4(entity.getDtshiftcode4());
            data.setDtTaishoYear(new FlexibleYear(entity.getDttaishoy()));
            data.setDtteiseiHyouji(entity.getDtteiseihyoji());
            data.setDtkakushuKubun(entity.getDtkakushukubun());
            data.setDtshoriResult(entity.getDtshorikekka());
            data.setDtyobi3(entity.getDtyobi3());
            data.setDtyobi4(entity.getDtyobi4());
            if (entity.getDtkingaku1() != null && !entity.getDtkingaku1().trim().isEmpty()) {
                data.setDtkinngaku1(Decimal.valueOf(Long.valueOf(entity.getDtkingaku1().trim().toString())));
            } else {
                data.setDtkinngaku1(Decimal.valueOf(0));
            }
            if (entity.getDtkingakuyobi1() != null && !entity.getDtkingakuyobi1().trim().isEmpty()) {
                data.setDtkinngakuYobi1(Decimal.valueOf(Long.valueOf(entity.getDtkingakuyobi1().trim().toString())));
            } else {
                data.setDtkinngakuYobi1(Decimal.valueOf(0));
            }
            if (entity.getDtkingakuyobi2() != null && !entity.getDtkingakuyobi2().trim().isEmpty()) {
                data.setDtkinngakuYobi2(Decimal.valueOf(Long.valueOf(entity.getDtkingakuyobi2().trim().toString())));
            } else {
                data.setDtkinngakuYobi2(Decimal.valueOf(0));
            }
            data.setDtyobi5(entity.getDtyobi5());
            data.setDtkyousaiNennkinnShoushoKigouNo(entity.getDtkyosainenkinshoshokigono());
        }
        return data;
    }
}
