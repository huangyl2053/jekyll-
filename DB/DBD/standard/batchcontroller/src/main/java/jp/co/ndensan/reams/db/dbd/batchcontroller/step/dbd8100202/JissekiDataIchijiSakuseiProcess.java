/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.JissekiDataIchijiSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.JissekiDataIchijiSakuseiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.JissekiDataIchijiSakuseiTempTableEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 実績データ一時作成_process処理クラスです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public class JissekiDataIchijiSakuseiProcess extends BatchProcessBase<JissekiDataIchijiSakuseiJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei."
            + "IJissekiDataIchijiSakuseiMapper.select実績データ一作成");

    private JissekiDataIchijiSakuseiProcessParamter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJissekiDataIchijiSakuseiMybatisprmParamter(psmShikibetsuTaisho));
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(JissekiDataIchijiSakuseiTempTableEntity.class)
                .tempTableName(JissekiDataIchijiSakuseiTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(JissekiDataIchijiSakuseiJohoEntity t) {
        JissekiDataIchijiSakuseiTempTableEntity jissekiDataTempTableEntity = createTempTableEntity(t);
        tmpTableWriter.insert(jissekiDataTempTableEntity);
    }

    private JissekiDataIchijiSakuseiTempTableEntity createTempTableEntity(JissekiDataIchijiSakuseiJohoEntity jissekiDataEntity) {

        JissekiDataIchijiSakuseiTempTableEntity jissekiDataTempTableEntity = new JissekiDataIchijiSakuseiTempTableEntity();
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理NewestEntity = jissekiDataEntity.get被保険者台帳管理NewestEntity();
        UaFt200FindShikibetsuTaishoEntity psmEntity = jissekiDataEntity.getPsmEntity();
        IKojin 宛名Entity = null;
        if (psmEntity != null) {
            宛名Entity = ShikibetsuTaishoFactory.createKojin(psmEntity);
        }
        DbT4037HikazeNenkinTaishoshaEntity 非課税年金対象者Entity = jissekiDataEntity.get非課税年金対象者Entity();

        jissekiDataTempTableEntity.setHihokenshaNo(被保険者台帳管理NewestEntity.getHihokenshaNo());
        if (宛名Entity != null) {
            jissekiDataTempTableEntity.setAtenaKanaShimei(宛名Entity.get名称().getKana().getColumnValue());
            jissekiDataTempTableEntity.setAtenaSeinenngappi(宛名Entity.get生年月日().toFlexibleDate());
            jissekiDataTempTableEntity.setAtenaSeibetsu(宛名Entity.get性別().getCode());
            jissekiDataTempTableEntity.setShotaiCode(宛名Entity.get世帯コード().getColumnValue());
            jissekiDataTempTableEntity.setAtenaKanjiShimei(宛名Entity.get名称().getName().getColumnValue());
            jissekiDataTempTableEntity.setAtenaYubinNo(宛名Entity.get住所().get郵便番号().getColumnValue());
            jissekiDataTempTableEntity.setAtenakanaJusyo(宛名Entity.get住所().get住所());
        }
        jissekiDataTempTableEntity.setShikibetsuCode(被保険者台帳管理NewestEntity.getShikibetsuCode());
        jissekiDataTempTableEntity.setNendo(非課税年金対象者Entity.getNendo());
        jissekiDataTempTableEntity.setShoriKubunn(非課税年金対象者Entity.getShorikubun());
        jissekiDataTempTableEntity.setTaishoMonth(非課税年金対象者Entity.getTaishom());
        jissekiDataTempTableEntity.setKisoNennkinnNo(非課税年金対象者Entity.getKisonenkinno());
        jissekiDataTempTableEntity.setGenKisoNennkinnNo(非課税年金対象者Entity.getGenkisonenkinno());
        jissekiDataTempTableEntity.setNennkinnCode(非課税年金対象者Entity.getNenkincode());
        jissekiDataTempTableEntity.setTourokuKubunn(非課税年金対象者Entity.getTorokukubun());
        jissekiDataTempTableEntity.setDtRekoDoKubunn(非課税年金対象者Entity.getDtrecordkubun());
        jissekiDataTempTableEntity.setDtShichosonCode(非課税年金対象者Entity.getDtcitycode());
        jissekiDataTempTableEntity.setDtNennkinnHokenshaCode(非課税年金対象者Entity.getDtnenkinhokenshacode());
        jissekiDataTempTableEntity.setDtTsuuchiContentCode(非課税年金対象者Entity.getDttsuchinaiyocode());
        jissekiDataTempTableEntity.setDtYobi1(非課税年金対象者Entity.getDtyobi1());
        jissekiDataTempTableEntity.setDtSeidoCode(非課税年金対象者Entity.getDtseidocode());
        jissekiDataTempTableEntity.setDtCreateYMD(非課税年金対象者Entity.getDtsakuseiymd());
        jissekiDataTempTableEntity.setDtKisoNennkinnNo(非課税年金対象者Entity.getDtkisonenkinno());
        jissekiDataTempTableEntity.setDtNennkinnCode(非課税年金対象者Entity.getDtnenkincode());
        jissekiDataTempTableEntity.setDtYobi2(非課税年金対象者Entity.getDtyobi2());
        jissekiDataTempTableEntity.setDtSeinenngappi(非課税年金対象者Entity.getDtbirthday());
        jissekiDataTempTableEntity.setDtSeibetsu(非課税年金対象者Entity.getDtseibetsu());
        jissekiDataTempTableEntity.setDtKanaShimei(非課税年金対象者Entity.getDtkanashimei());
        jissekiDataTempTableEntity.setDtShifutoCode1(非課税年金対象者Entity.getDtshiftcode1());
        jissekiDataTempTableEntity.setDtKanjiShimei(非課税年金対象者Entity.getDtkanjishimei());
        jissekiDataTempTableEntity.setDtShifutoCode2(非課税年金対象者Entity.getDtshiftcode2());
        jissekiDataTempTableEntity.setDtYubinNo(非課税年金対象者Entity.getDtyubinno());
        jissekiDataTempTableEntity.setDtKanajusyo(非課税年金対象者Entity.getDtkanajusho());
        jissekiDataTempTableEntity.setDtShifutoCode3(非課税年金対象者Entity.getDtshiftcode3());
        jissekiDataTempTableEntity.setDtKanjijusyo(非課税年金対象者Entity.getDtkanjijusho());
        jissekiDataTempTableEntity.setDtShifutoCode4(非課税年金対象者Entity.getDtshiftcode4());
        jissekiDataTempTableEntity.setDtTaisyoYear(非課税年金対象者Entity.getDttaishoy());
        jissekiDataTempTableEntity.setDtTeiseiHyouji(非課税年金対象者Entity.getDtteiseihyoji());
        jissekiDataTempTableEntity.setDtKakushuKubun(非課税年金対象者Entity.getDtkakushukubun());
        jissekiDataTempTableEntity.setDtShoriResult(非課税年金対象者Entity.getDtshorikekka());
        jissekiDataTempTableEntity.setDtYobi3(非課税年金対象者Entity.getDtyobi3());
        jissekiDataTempTableEntity.setDtYobi4(非課税年金対象者Entity.getDtyobi4());
        jissekiDataTempTableEntity.setDtkinngaku1(非課税年金対象者Entity.getDtkingaku1());
        jissekiDataTempTableEntity.setDtKinngakuYobi1(非課税年金対象者Entity.getDtkingakuyobi1());
        jissekiDataTempTableEntity.setDtKinngakuYobi2(非課税年金対象者Entity.getDtkingakuyobi2());
        jissekiDataTempTableEntity.setDtYobi5(非課税年金対象者Entity.getDtyobi5());
        jissekiDataTempTableEntity.setDtYobi5(非課税年金対象者Entity.getDtyobi5());
        jissekiDataTempTableEntity.setDtKyousaiNennkinnShoushoKigouNo(非課税年金対象者Entity.getDtkyosainenkinshoshokigono());

        return jissekiDataTempTableEntity;
    }
}
