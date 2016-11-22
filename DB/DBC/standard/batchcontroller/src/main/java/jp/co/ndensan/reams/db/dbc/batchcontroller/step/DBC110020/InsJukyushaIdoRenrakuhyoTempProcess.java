/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.JukyushaIdoRenrakuhyoTempTBLEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者異動送付の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class InsJukyushaIdoRenrakuhyoTempProcess extends BatchProcessBase<DbT3001JukyushaIdoRenrakuhyoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select受給者異動送付");
    private static final RString 受給者異動送付一時_TABLE_NAME = new RString("JukyushaIdoRenrakuhyoTemp");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 受給者異動送付一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        受給者異動送付一時tableWriter
                = new BatchEntityCreatedTempTableWriter(受給者異動送付一時_TABLE_NAME, JukyushaIdoRenrakuhyoTempTBLEntity.class);
    }

    @Override
    protected void process(DbT3001JukyushaIdoRenrakuhyoEntity entity) {
//        if (!entity.getHiHokenshaNo().equals(new HihokenshaNo("2016111601"))) {
//            return;
//        }
        受給者異動送付一時tableWriter.insert(getJukyushaIdoRenrakuhyoTempTBLEntity(entity));
    }

    private JukyushaIdoRenrakuhyoTempTBLEntity getJukyushaIdoRenrakuhyoTempTBLEntity(DbT3001JukyushaIdoRenrakuhyoEntity entity) {
        JukyushaIdoRenrakuhyoTempTBLEntity insertEntity = new JukyushaIdoRenrakuhyoTempTBLEntity();
        insertEntity.setHiHokenshaNo(entity.getHiHokenshaNo());
        insertEntity.setIdoYMD(entity.getIdoYMD());
        insertEntity.setRirekiNo(entity.getRirekiNo());
        insertEntity.setIdoKubunCode(entity.getIdoKubunCode());
        insertEntity.setJukyushaIdoJiyu(entity.getJukyushaIdoJiyu());
        insertEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        insertEntity.setHiHokenshaNameKana(entity.getHiHokenshaNameKana());
        insertEntity.setUmareYMD(entity.getUmareYMD());
        insertEntity.setSeibetsuCode(entity.getSeibetsuCode());
        insertEntity.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        insertEntity.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        insertEntity.setRojinHokenShichosonNo(entity.getRojinHokenShichosonNo());
        insertEntity.setRojinHokenJukyushaNo(entity.getRojinHokenJukyushaNo());
        insertEntity.setKohiFutanshaNo(entity.getKohiFutanshaNo());
        insertEntity.setKoikiRengoHokenshaNo(entity.getKoikiRengoHokenshaNo());
        insertEntity.setShinseiShubetsuCode(entity.getShinseiShubetsuCode());
        insertEntity.setHenkoShinseichuKubunCode(entity.getHenkoShinseichuKubunCode());
        insertEntity.setShinseiYMD(entity.getShinseiYMD());
        insertEntity.setMinashiYokaigoJotaiKubunCode(entity.getMinashiYokaigoJotaiKubunCode());
        insertEntity.setYokaigoJotaiKubunCode(entity.getYokaigoJotaiKubunCode());
        insertEntity.setNinteiYukoKikankaishiYMD(entity.getNinteiYukoKikankaishiYMD());
        insertEntity.setNinteiYukoKikanShuryoYMD(entity.getNinteiYukoKikanShuryoYMD());
        insertEntity.setKyotakuServiceSakuseiKubunCode(entity.getKyotakuServiceSakuseiKubunCode());
        insertEntity.setKyotakuKaigoShienJigyoshoNo(entity.getKyotakuKaigoShienJigyoshoNo());
        insertEntity.setKyotakuServiceTekiyoKaishiYMD(entity.getKyotakuServiceTekiyoKaishiYMD());
        insertEntity.setKyotakuServiceTekiyoShuryoYMD(entity.getKyotakuServiceTekiyoShuryoYMD());
        insertEntity.setHomonTsushoServiceShikyuGendoKijungaku(entity.getHomonTsushoServiceShikyuGendoKijungaku());
        insertEntity.setHomonTsushoServiceJogenKanriTekiyoKaishiYMD(entity.getHomonTsushoServiceJogenKanriTekiyoKaishiYMD());
        insertEntity.setHomonTsushoServiceJogenKanriTekiyoShuryoYMD(entity.getHomonTsushoServiceJogenKanriTekiyoShuryoYMD());
        insertEntity.setTankiNyushoServiceShikyuGendoKijungaku(entity.getTankiNyushoServiceShikyuGendoKijungaku());
        insertEntity.setTankinyushoServiceJogenKanriTekiyoKaishiYMD(entity.getTankinyushoServiceJogenKanriTekiyoKaishiYMD());
        insertEntity.setTankinyushoServiceJogenKanriTekiyoShuryoYMD(entity.getTankinyushoServiceJogenKanriTekiyoShuryoYMD());
        insertEntity.setKohiFutanJogenGengakuAriFlag(entity.getKohiFutanJogenGengakuAriFlag());
        insertEntity.setShokanbaraikaKaishiYMD(entity.getShokanbaraikaKaishiYMD());
        insertEntity.setShokanbaraikaShuryoYMD(entity.getShokanbaraikaShuryoYMD());
        insertEntity.setKyufuritsuHikisageKaishiYMD(entity.getKyufuritsuHikisageKaishiYMD());
        insertEntity.setKyufuritsuHikisageShuryoYMD(entity.getKyufuritsuHikisageShuryoYMD());
        insertEntity.setGemmenShinseichuKubunCode(entity.getGemmenShinseichuKubunCode());
        insertEntity.setRiyoshaFutanKubunCode(entity.getRiyoshaFutanKubunCode());
        insertEntity.setKyufuritsu(entity.getKyufuritsu());
        insertEntity.setTekiyoKaishiYMD(entity.getTekiyoKaishiYMD());
        insertEntity.setTekiyoShuryoYMD(entity.getTekiyoShuryoYMD());
        insertEntity.setHyojunFutanKubunCode(entity.getHyojunFutanKubunCode());
        insertEntity.setFutangaku(entity.getFutangaku());
        insertEntity.setFutangakuTekiyoKaishiYMD(entity.getFutangakuTekiyoKaishiYMD());
        insertEntity.setFutangakuTekiyoShuryoYMD(entity.getFutangakuTekiyoShuryoYMD());
        insertEntity.setTokuteiNyushoshaNinteiShinseichuKubunCode(entity.getTokuteiNyushoshaNinteiShinseichuKubunCode());
        insertEntity.setTokuteiNyushoshaKaigoServiceKubunCode(entity.getTokuteiNyushoshaKaigoServiceKubunCode());
        insertEntity.setKaizeisoTokureiGengakuSochiTaishoFlag(entity.getKaizeisoTokureiGengakuSochiTaishoFlag());
        insertEntity.setShokuhiFutanGendogaku(entity.getShokuhiFutanGendogaku());
        insertEntity.setKyojuhiUnitGataKoshitsuFutanGendogaku(entity.getKyojuhiUnitGataKoshitsuFutanGendogaku());
        insertEntity.setKyojuhiUnitGataJunKoshitsuFutanGendogaku(entity.getKyojuhiUnitGataJunKoshitsuFutanGendogaku());
        insertEntity.setKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku(entity.getKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku());
        insertEntity.setKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku(entity.getKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku());
        insertEntity.setKyujuhiTashoshitsuFutanGendogaku(entity.getKyujuhiTashoshitsuFutanGendogaku());
        insertEntity.setFutanGendogakuTekiyoKaishiYMD(entity.getFutanGendogakuTekiyoKaishiYMD());
        insertEntity.setFutanGendogakuTekiyoShuryoYMD(entity.getFutanGendogakuTekiyoShuryoYMD());
        insertEntity.setKeigenritsu(entity.getKeigenritsu());
        insertEntity.setKeigenritsuTekiyoKaishiYMD(entity.getKeigenritsuTekiyoKaishiYMD());
        insertEntity.setKeigenritsuTekiyoShuryoYMD(entity.getKeigenritsuTekiyoShuryoYMD());
        insertEntity.setShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag(entity.getShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag());
        insertEntity.setKokiKoureiIryoHokenshaNo(entity.getKokiKoureiIryoHokenshaNo());
        insertEntity.setKokikoureiIryoHiHokenshaNo(entity.getKokikoureiIryoHiHokenshaNo());
        insertEntity.setKokuhoHokenshaNo(entity.getKokuhoHokenshaNo());
        insertEntity.setKokuhoHiHokenshaNo(entity.getKokuhoHiHokenshaNo());
        insertEntity.setKokuhoKojinNo(entity.getKokuhoKojinNo());
        insertEntity.setNijiyoboJigyoKubunCode(entity.getNijiyoboJigyoKubunCode());
        insertEntity.setNijiyoboJigyoYukoKikanKaishiYMD(entity.getNijiyoboJigyoYukoKikanKaishiYMD());
        insertEntity.setNijiyoboJigyoYukoKikanShuryoYMD(entity.getNijiyoboJigyoYukoKikanShuryoYMD());
        insertEntity.setTeiseiRenrakuhyoFlag(entity.getTeiseiRenrakuhyoFlag());
        insertEntity.setSofuYM(entity.getSofuYM());
        insertEntity.setJushochiTokureiTaishoshaKubunCode(entity.getJushochiTokureiTaishoshaKubunCode());
        insertEntity.setShisetsuShozaiHokenjaNo(entity.getShisetsuShozaiHokenjaNo());
        insertEntity.setJushochiTokureiTekiyoKaishiYMD(entity.getJushochiTokureiTekiyoKaishiYMD());
        insertEntity.setJushochiTokureiTekiyoShuryoYMD(entity.getJushochiTokureiTekiyoShuryoYMD());
        insertEntity.setKyotakuhiShin1FutanGendogaku(entity.getKyotakuhiShin1FutanGendogaku());
        insertEntity.setKyotakuhiShin2FutanGendogaku(entity.getKyotakuhiShin2FutanGendogaku());
        insertEntity.setKyotakuhiShin3FutanGendogaku(entity.getKyotakuhiShin3FutanGendogaku());
        insertEntity.setRiyosyaFutanWariaiYukoKaishiYMD(entity.getRiyosyaFutanWariaiYukoKaishiYMD());
        insertEntity.setRiyosyaFutanWariaiYukoShuryoYMD(entity.getRiyosyaFutanWariaiYukoShuryoYMD());
        insertEntity.setTeiseiKubunCode(entity.getTeiseiKubunCode());
        insertEntity.setTeiseiYMD(entity.getTeiseiYMD());
        insertEntity.setLogicalDeletedFlag(entity.getLogicalDeletedFlag());
        return insertEntity;
    }
}
