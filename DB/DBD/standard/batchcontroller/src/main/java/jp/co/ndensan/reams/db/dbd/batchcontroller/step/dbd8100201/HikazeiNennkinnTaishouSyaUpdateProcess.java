/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者更新_process処理クラスです.
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
public class HikazeiNennkinnTaishouSyaUpdateProcess extends BatchProcessBase<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "hikazeinennkintaishousyajohotorikomi.IHikazeiNennkinnTaishouSyaDeleteMapper.get非課税年金対象者同定結果情報一時のデータ情報");
    @BatchWriter
    private BatchPermanentTableWriter<DbT4037HikazeNenkinTaishoshaEntity> hikazeNenkinTableEntity;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        hikazeNenkinTableEntity = new BatchPermanentTableWriter<>(DbT4037HikazeNenkinTaishoshaEntity.class);
    }

    @Override
    protected void process(HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity t) {
        DbT4037HikazeNenkinTaishoshaEntity insertHikazeNenkinTableEntity = new DbT4037HikazeNenkinTaishoshaEntity();
        edit非課税年金対象者情報(t, insertHikazeNenkinTableEntity);
        hikazeNenkinTableEntity.insert(insertHikazeNenkinTableEntity);

    }

    private void edit非課税年金対象者情報(HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity t,
            DbT4037HikazeNenkinTaishoshaEntity insertHikazeNenkinTableEntity) {
        insertHikazeNenkinTableEntity.setNendo(t.getNendo());
        insertHikazeNenkinTableEntity.setShorikubun(t.getShoriKubunn());
        insertHikazeNenkinTableEntity.setTaishom(t.getTaishoMonth());
        insertHikazeNenkinTableEntity.setKisonenkinno(t.getKisoNennkinnNo());
        insertHikazeNenkinTableEntity.setGenkisonenkinno(t.getGenKisoNennkinnNo());
        insertHikazeNenkinTableEntity.setNenkincode(t.getNennkinnCode());
        insertHikazeNenkinTableEntity.setHihokenshano(t.getHihokenshaNo().getColumnValue());
        insertHikazeNenkinTableEntity.setTorokukubun(t.getTourokuKubunn());
        insertHikazeNenkinTableEntity.setDtrecordkubun(t.getDtRekoDoKubunn());
        insertHikazeNenkinTableEntity.setDtcitycode(t.getDtShichosonCode());
        insertHikazeNenkinTableEntity.setDtnenkinhokenshacode(t.getDtNennkinnHokenshaCode());
        insertHikazeNenkinTableEntity.setDttsuchinaiyocode(t.getDtTsuuchiContentCode());
        insertHikazeNenkinTableEntity.setDtyobi1(t.getDtYobi1());
        insertHikazeNenkinTableEntity.setDtseidocode(t.getDtSeidoCode());
        insertHikazeNenkinTableEntity.setDtsakuseiymd(t.getDtCreateYMD());
        insertHikazeNenkinTableEntity.setDtkisonenkinno(t.getDtKisoNennkinnNo());
        insertHikazeNenkinTableEntity.setDtnenkincode(t.getDtNennkinnCode());
        insertHikazeNenkinTableEntity.setDtyobi2(t.getDtYobi2());
        insertHikazeNenkinTableEntity.setDtbirthday(t.getDtSeinenngappi());
        insertHikazeNenkinTableEntity.setDtseibetsu(t.getDtSeibetsu());
        insertHikazeNenkinTableEntity.setDtkanashimei(t.getDtKanaShimei());
        insertHikazeNenkinTableEntity.setDtshiftcode1(t.getDtShifutoCode1());
        insertHikazeNenkinTableEntity.setDtkanjishimei(t.getDtKanjiShimei());
        insertHikazeNenkinTableEntity.setDtshiftcode2(t.getDtShifutoCode2());
        insertHikazeNenkinTableEntity.setDtyubinno(t.getDtYubinNo());
        insertHikazeNenkinTableEntity.setDtkanajusho(t.getDtKanajusyo());
        insertHikazeNenkinTableEntity.setDtshiftcode3(t.getDtShifutoCode3());
        insertHikazeNenkinTableEntity.setDtkanjijusho(t.getDtKanjijusyo());
        insertHikazeNenkinTableEntity.setDtshiftcode4(t.getDtShifutoCode4());
        insertHikazeNenkinTableEntity.setDttaishoy(t.getDtTaisyoYear());
        insertHikazeNenkinTableEntity.setDtteiseihyoji(t.getDtTeiseiHyouji());
        insertHikazeNenkinTableEntity.setDtkakushukubun(t.getDtKakushuKubun());
        insertHikazeNenkinTableEntity.setDtshorikekka(t.getDtShoriResult());
        insertHikazeNenkinTableEntity.setDtyobi3(t.getDtYobi3());
        insertHikazeNenkinTableEntity.setDtyobi4(t.getDtYobi4());
        insertHikazeNenkinTableEntity.setDtkingaku1(t.getDtkinngaku1());
        insertHikazeNenkinTableEntity.setDtkingakuyobi1(t.getDtKinngakuYobi1());
        insertHikazeNenkinTableEntity.setDtkingakuyobi2(t.getDtKinngakuYobi2());
        insertHikazeNenkinTableEntity.setDtyobi5(t.getDtYobi5());
        insertHikazeNenkinTableEntity.setDtkyosainenkinshoshokigono(t.getDtKyousaiNennkinnShoushoKigouNo());

    }
}
