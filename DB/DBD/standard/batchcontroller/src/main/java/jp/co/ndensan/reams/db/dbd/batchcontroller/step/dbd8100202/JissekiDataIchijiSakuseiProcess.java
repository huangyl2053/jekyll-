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
        JissekiDataIchijiSakuseiTempTableEntity jissekiDataIchijiSakuseiTempTableEntity = createTempTableEntity(t);
        tmpTableWriter.insert(jissekiDataIchijiSakuseiTempTableEntity);
    }

    private JissekiDataIchijiSakuseiTempTableEntity createTempTableEntity(JissekiDataIchijiSakuseiJohoEntity jissekiDataIchijiSakuseiJohoEntity) {

        JissekiDataIchijiSakuseiTempTableEntity jissekiDataIchijiSakuseiTempTableEntity = new JissekiDataIchijiSakuseiTempTableEntity();
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理NewestEntity = jissekiDataIchijiSakuseiJohoEntity.get被保険者台帳管理NewestEntity();
        DbT4037HikazeNenkinTaishoshaEntity 非課税年金対象者Entity = jissekiDataIchijiSakuseiJohoEntity.get非課税年金対象者Entity();
        IKojin 宛名Entity = ShikibetsuTaishoFactory.createKojin(jissekiDataIchijiSakuseiJohoEntity.get宛名Entity());

        jissekiDataIchijiSakuseiTempTableEntity.setHihokenshaNo(被保険者台帳管理NewestEntity.getHihokenshaNo());
        jissekiDataIchijiSakuseiTempTableEntity.setAtenaKanaShimei(宛名Entity.get名称().getKana().getColumnValue());
        jissekiDataIchijiSakuseiTempTableEntity.setAtenaSeinenngappi(宛名Entity.get生年月日().toFlexibleDate());
        jissekiDataIchijiSakuseiTempTableEntity.setAtenaSeibetsu(宛名Entity.get性別().getCode());
        jissekiDataIchijiSakuseiTempTableEntity.setShikibetsuCode(被保険者台帳管理NewestEntity.getShikibetsuCode());
        jissekiDataIchijiSakuseiTempTableEntity.setShotaiCode(宛名Entity.get世帯コード().getColumnValue());
        jissekiDataIchijiSakuseiTempTableEntity.setAtenaKanjiShimei(宛名Entity.get名称().getName().getColumnValue());
        jissekiDataIchijiSakuseiTempTableEntity.setAtenaYubinNo(宛名Entity.get住所().get郵便番号().getColumnValue());
        jissekiDataIchijiSakuseiTempTableEntity.setAtenakanaJusyo(宛名Entity.get住所().get住所());
        jissekiDataIchijiSakuseiTempTableEntity.setNendo(非課税年金対象者Entity.getNendo());
        jissekiDataIchijiSakuseiTempTableEntity.setShoriKubunn(非課税年金対象者Entity.getShorikubun());
        jissekiDataIchijiSakuseiTempTableEntity.setTaishoMonth(非課税年金対象者Entity.getTaishom());
        jissekiDataIchijiSakuseiTempTableEntity.setKisoNennkinnNo(非課税年金対象者Entity.getKisonenkinno());
        jissekiDataIchijiSakuseiTempTableEntity.setGenKisoNennkinnNo(非課税年金対象者Entity.getGenkisonenkinno());
        jissekiDataIchijiSakuseiTempTableEntity.setNennkinnCode(非課税年金対象者Entity.getNenkincode());
        jissekiDataIchijiSakuseiTempTableEntity.setTourokuKubunn(非課税年金対象者Entity.getTorokukubun());
        jissekiDataIchijiSakuseiTempTableEntity.setDtRekoDoKubunn(非課税年金対象者Entity.getDtrecordkubun());
        jissekiDataIchijiSakuseiTempTableEntity.setDtShichosonCode(非課税年金対象者Entity.getDtcitycode());
        jissekiDataIchijiSakuseiTempTableEntity.setDtNennkinnHokenshaCode(非課税年金対象者Entity.getDtnenkinhokenshacode());
        jissekiDataIchijiSakuseiTempTableEntity.setDtTsuuchiContentCode(非課税年金対象者Entity.getDttsuchinaiyocode());
        jissekiDataIchijiSakuseiTempTableEntity.setDtYobi1(非課税年金対象者Entity.getDtyobi1());
        jissekiDataIchijiSakuseiTempTableEntity.setDtSeidoCode(非課税年金対象者Entity.getDtseidocode());
        jissekiDataIchijiSakuseiTempTableEntity.setDtCreateYMD(非課税年金対象者Entity.getDtsakuseiymd());
        jissekiDataIchijiSakuseiTempTableEntity.setDtKisoNennkinnNo(非課税年金対象者Entity.getDtkisonenkinno());
        jissekiDataIchijiSakuseiTempTableEntity.setDtNennkinnCode(非課税年金対象者Entity.getDtnenkincode());
        jissekiDataIchijiSakuseiTempTableEntity.setDtYobi2(非課税年金対象者Entity.getDtyobi2());
        jissekiDataIchijiSakuseiTempTableEntity.setDtSeinenngappi(非課税年金対象者Entity.getDtbirthday());
        jissekiDataIchijiSakuseiTempTableEntity.setDtSeibetsu(非課税年金対象者Entity.getDtseibetsu());
        jissekiDataIchijiSakuseiTempTableEntity.setDtKanaShimei(非課税年金対象者Entity.getDtkanashimei());
        jissekiDataIchijiSakuseiTempTableEntity.setDtShifutoCode1(非課税年金対象者Entity.getDtshiftcode1());
        jissekiDataIchijiSakuseiTempTableEntity.setDtKanjiShimei(非課税年金対象者Entity.getDtkanjishimei());
        jissekiDataIchijiSakuseiTempTableEntity.setDtShifutoCode2(非課税年金対象者Entity.getDtshiftcode2());
        jissekiDataIchijiSakuseiTempTableEntity.setDtYubinNo(非課税年金対象者Entity.getDtyubinno());
        jissekiDataIchijiSakuseiTempTableEntity.setDtKanajusyo(非課税年金対象者Entity.getDtkanajusho());
        jissekiDataIchijiSakuseiTempTableEntity.setDtShifutoCode3(非課税年金対象者Entity.getDtshiftcode3());
        jissekiDataIchijiSakuseiTempTableEntity.setDtKanjijusyo(非課税年金対象者Entity.getDtkanjijusho());
        jissekiDataIchijiSakuseiTempTableEntity.setDtShifutoCode4(非課税年金対象者Entity.getDtshiftcode4());
        jissekiDataIchijiSakuseiTempTableEntity.setDtTaisyoYear(非課税年金対象者Entity.getDttaishoy());
        jissekiDataIchijiSakuseiTempTableEntity.setDtTeiseiHyouji(非課税年金対象者Entity.getDtteiseihyoji());
        jissekiDataIchijiSakuseiTempTableEntity.setDtKakushuKubun(非課税年金対象者Entity.getDtkakushukubun());
        jissekiDataIchijiSakuseiTempTableEntity.setDtShoriResult(非課税年金対象者Entity.getDtshorikekka());
        jissekiDataIchijiSakuseiTempTableEntity.setDtYobi3(非課税年金対象者Entity.getDtyobi3());
        jissekiDataIchijiSakuseiTempTableEntity.setDtYobi4(非課税年金対象者Entity.getDtyobi4());
        jissekiDataIchijiSakuseiTempTableEntity.setDtkinngaku1(非課税年金対象者Entity.getDtkingaku1());
        jissekiDataIchijiSakuseiTempTableEntity.setDtKinngakuYobi1(非課税年金対象者Entity.getDtkingakuyobi1());
        jissekiDataIchijiSakuseiTempTableEntity.setDtKinngakuYobi2(非課税年金対象者Entity.getDtkingakuyobi2());
        jissekiDataIchijiSakuseiTempTableEntity.setDtYobi5(非課税年金対象者Entity.getDtyobi5());
        jissekiDataIchijiSakuseiTempTableEntity.setDtYobi5(非課税年金対象者Entity.getDtyobi5());
        jissekiDataIchijiSakuseiTempTableEntity.setDtKyousaiNennkinnShoushoKigouNo(非課税年金対象者Entity.getDtkyosainenkinshoshokigono());

        return jissekiDataIchijiSakuseiTempTableEntity;
    }
}
