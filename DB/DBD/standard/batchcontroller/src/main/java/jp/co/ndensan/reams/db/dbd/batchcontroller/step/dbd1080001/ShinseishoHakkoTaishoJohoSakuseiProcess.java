/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1080001;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001.ShinseishoHakkoTaishoJohoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4031ShinseishoHakkoKohoshasEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.ShinseishoHakkoTaishoJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.service.core.gemmenshinseishotaishohaaku.ZenNendoResearcher;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBZ12021_2_減免減額申請書発行用対象者把握（バッチ）の_process処理クラスです。
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
public class ShinseishoHakkoTaishoJohoSakuseiProcess extends BatchProcessBase<ShinseishoHakkoTaishoJohoSakuseiEntity> {

    private static final RString MYBATIS_SELECT_ID_申請_負担限度額認定 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db"
            + ".mapper.relate.gemmenshinseishotaishohaaku.IShinseishoHakkoTaishoJohoSakuseiMapper.get申請書発行対象者情報_負担限度額認定");
    private static final RString MYBATIS_SELECT_ID_申請_利用者負担額減額 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db"
            + ".mapper.relate.gemmenshinseishotaishohaaku.IShinseishoHakkoTaishoJohoSakuseiMapper.get申請書発行対象者情報_利用者負担額減額");
    private static final RString MYBATIS_SELECT_ID_申請_訪問介護利用者 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db"
            + ".mapper.relate.gemmenshinseishotaishohaaku.IShinseishoHakkoTaishoJohoSakuseiMapper.get申請書発行対象者情報_訪問介護利用者負担額減額");
    private static final RString MYBATIS_SELECT_ID_申請_社会福祉法人 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db"
            + ".mapper.relate.gemmenshinseishotaishohaaku.IShinseishoHakkoTaishoJohoSakuseiMapper.get申請書発行対象者情報_社会福祉法人等利用者負担軽減");

    private ShinseishoHakkoTaishoJohoSakuseiProcessParameter processParamter;
    private FlexibleDate 終了日;
    private FlexibleDate 開始日;
    private UUID uuid;

    @BatchWriter
    private BatchPermanentTableWriter<DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity> dbT4030BatchWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT4031ShinseishoHakkoKohoshasEntity> dbT4031Writer;

    /**
     * OUT_把握処理ID
     */
    public static final RString OUT_把握処理ID;

    static {
        OUT_把握処理ID = new RString("OUT_uuID");
    }

    private OutputParameter<UUID> uuId;

    @Override
    protected void beforeExecute() {
        uuId = new OutputParameter<>();
    }

    @Override
    protected void initialize() {
        終了日 = ZenNendoResearcher.createIntance(processParamter.get減免減額種類(), processParamter.get基準日()).get終了日();
        開始日 = ZenNendoResearcher.createIntance(processParamter.get減免減額種類(), processParamter.get基準日()).get開始日();
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.負担限度額認定)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_申請_負担限度額認定, processParamter.toShinseishoHakkoTaishoJohoSakuseiMybatisParameter(開始日, 終了日));
        } else if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.利用者負担額減額)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_申請_利用者負担額減額, processParamter.toShinseishoHakkoTaishoJohoSakuseiMybatisParameter(開始日, 終了日));
        } else if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.訪問介護利用者負担額減額)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_申請_訪問介護利用者, processParamter.toShinseishoHakkoTaishoJohoSakuseiMybatisParameter(開始日, 終了日));
        } else {
            return new BatchDbReader(MYBATIS_SELECT_ID_申請_社会福祉法人, processParamter.toShinseishoHakkoTaishoJohoSakuseiMybatisParameter(開始日, 終了日));
        }
    }

    @Override
    protected void createWriter() {
        dbT4030BatchWriter = new BatchPermanentTableWriter<>(DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity.class);
        dbT4031Writer = new BatchPermanentTableWriter<>(DbT4031ShinseishoHakkoKohoshasEntity.class);
    }

    @Override
    protected void process(ShinseishoHakkoTaishoJohoSakuseiEntity list) {
        uuid = UUID.randomUUID();
        DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity dbT4030BatchEntity
                = new DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity();
        DbT4031ShinseishoHakkoKohoshasEntity dbT4031Entity = new DbT4031ShinseishoHakkoKohoshasEntity();
        setDbT4030Entity(dbT4030BatchEntity, uuid);
        setDbT4031Entity(dbT4031Entity, list, uuid);
        dbT4030BatchWriter.insert(dbT4030BatchEntity);
        dbT4031Writer.insert(dbT4031Entity);
        uuId.setValue(uuid);
    }

    private void setDbT4030Entity(DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity dbT4030Batch, UUID uuid) {
        dbT4030Batch.setHaakuShoriID(uuid);
        dbT4030Batch.setBatchExecutedTimestamp(new YMDHMS(RDate.getNowDateTime()));
        dbT4030Batch.setKijunYmd(processParamter.get基準日());
        dbT4030Batch.setShotokuNendo(new FlexibleYearMonth(processParamter.get所得年度().toString().concat("01")));
        if (processParamter.get減免減額種類() == null) {
            dbT4030Batch.setGemmenGengakuShurui(RString.EMPTY);
        } else if (processParamter.get減免減額種類().get名称().equals(GemmenGengakuShurui.利用者負担額減額.get名称())) {
            dbT4030Batch.setGemmenGengakuShurui(GemmenGengakuShurui.利用者負担額減額.getコード());
        } else if (processParamter.get減免減額種類().get名称().equals(GemmenGengakuShurui.負担限度額認定.get名称())) {
            dbT4030Batch.setGemmenGengakuShurui(GemmenGengakuShurui.負担限度額認定.getコード());
        } else if (processParamter.get減免減額種類().get名称().equals(GemmenGengakuShurui.訪問介護利用者負担額減額.get名称())) {
            dbT4030Batch.setGemmenGengakuShurui(GemmenGengakuShurui.訪問介護利用者負担額減額.getコード());
        } else if (processParamter.get減免減額種類().get名称().equals(GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称())) {
            dbT4030Batch.setGemmenGengakuShurui(GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード());
        } else {
            dbT4030Batch.setGemmenGengakuShurui(RString.EMPTY);
        }
    }

    private void setDbT4031Entity(DbT4031ShinseishoHakkoKohoshasEntity dbT4031ShinseishoHakkoKohoshas,
            ShinseishoHakkoTaishoJohoSakuseiEntity list, UUID uuid) {
        dbT4031ShinseishoHakkoKohoshas.setHaakuShoriID(uuid);
        dbT4031ShinseishoHakkoKohoshas.setGokeiShotokuKingaku(list.get合計所得金額());
        dbT4031ShinseishoHakkoKohoshas.setHihokenshaNo(list.get被保険者番号());
        dbT4031ShinseishoHakkoKohoshas.setHikazeinenkinKananGaku(list.get非課税年金勘案額());
        dbT4031ShinseishoHakkoKohoshas.setHonninKazeiKubun(list.get本人課税区分());
        dbT4031ShinseishoHakkoKohoshas.setIsRoreiFukushiNenkinJukyusha(list.is老齢受給者フラグ());
        dbT4031ShinseishoHakkoKohoshas.setIsSeikatsuHogoJukyusha(list.is生保受給者フラグ());
        dbT4031ShinseishoHakkoKohoshas.setWillBeRenewed(list.is更新認定フラグ());
        dbT4031ShinseishoHakkoKohoshas.setNenkinShunyuGaku(list.get年金収入額());
        dbT4031ShinseishoHakkoKohoshas.setSetaiKazeiKubun(list.get世帯課税区分());
        dbT4031ShinseishoHakkoKohoshas.setShikibetsuCode(list.get識別コード());
        if (list.get事業者番号() == null) {
            dbT4031ShinseishoHakkoKohoshas.setJigyoshaNo(new JigyoshaNo(new RString("01")));
        } else {
            dbT4031ShinseishoHakkoKohoshas.setJigyoshaNo(list.get事業者番号());
        }
        if (list.get利用者負担段階() == null) {
            dbT4031ShinseishoHakkoKohoshas.setRiyoshaFutanDankai(RString.EMPTY);
        } else {
            dbT4031ShinseishoHakkoKohoshas.setRiyoshaFutanDankai(list.get利用者負担段階());
        }
    }
}
