/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170020.TorikomiDataTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc170020.IKaigoSabisuNaiyoMasterKoshinMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護サービス内容マスタ更新。
 *
 * @reamsid_L DBC-3400-030 liuyl
 */
public class KaigoSabisuNaiyoMasterKoshin extends BatchProcessBase<TorikomiDataTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc170020."
            + "IKaigoSabisuNaiyoMasterKoshinMapper.select介護サービス内容");
    private IKaigoSabisuNaiyoMasterKoshinMapper mapper;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7131KaigoServiceNaiyouEntity> tableWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IKaigoSabisuNaiyoMasterKoshinMapper.class);
        mapper.delete介護サービス内容();
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter(DbT7131KaigoServiceNaiyouEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(TorikomiDataTempEntity tempEntity) {
        tableWriter.insert(getEntity(tempEntity));
    }

    private DbT7131KaigoServiceNaiyouEntity getEntity(TorikomiDataTempEntity tempEntity) {
        DbT7131KaigoServiceNaiyouEntity entity = new DbT7131KaigoServiceNaiyouEntity();
        entity.setServiceShuruiCd(tempEntity.getServiceShuruiCd());
        entity.setServiceKoumokuCd(tempEntity.getServiceKoumokuCd());
        entity.setTeikyoKaishiYM(tempEntity.getTeikyoKaishiYM());
        entity.setRirekiNo(tempEntity.getRirekiNo());
        entity.setTeikyoShuryoYM(tempEntity.getTeikyoShuryoYM());
        entity.setServiceName(tempEntity.getServiceName());
        entity.setServiceNameRyaku(tempEntity.getServiceNameRyaku());
        entity.setTaniSu(tempEntity.getTaniSu());
        entity.setTanisuShikibetsuCode(tempEntity.getTanisuShikibetsuCode());
        entity.setTanisuSanteiTaniCode(tempEntity.getTanisuSanteiTaniCode());
        entity.setIdouJiyuCode(tempEntity.getIdouJiyuCode());
        entity.setGendogakuTaishogaiFlag(tempEntity.getGendogakuTaishogaiFlag());
        entity.setGaibuServiceRiyoKataKubun(tempEntity.getGaibuServiceRiyoKataKubun());
        entity.setTokubetsuChiikiKasanFlag(tempEntity.getTokubetsuChiikiKasanFlag());
        entity.setRiyosyaFutanTeiritsuTeigakuKubun(tempEntity.getRiyosyaFutanTeiritsuTeigakuKubun());
        entity.setKoshinUmuFoag(tempEntity.getKoshinUmuFoag());
        entity.setMotoTensu(tempEntity.getMotoTensu());
        entity.setMotoGendogakuTaishogaiFlag(tempEntity.getMotoGendogakuTaishogaiFlag());
        entity.setMotoTaniShikibetsuCd(tempEntity.getMotoTaniShikibetsuCd());
        entity.setRiyoshaFutanGaku(tempEntity.getRiyoshaFutanGaku());
        entity.setKyufuRitsu(tempEntity.getKyufuRitsu());
        entity.setNijiyoboJigyoTaishaJishiKubunHigaito(tempEntity.getNijiyoboJigyoTaishaJishiKubunHigaito());
        entity.setYoshien1JukyushaJishiKubun(tempEntity.getYoshien1JukyushaJishiKubun());
        entity.setYoshien2JukyushaJishiKubun(tempEntity.getYoshien2JukyushaJishiKubun());
        entity.setTaishoJigyoJishiKubun(tempEntity.getTaishoJigyoJishiKubun());
        entity.setSogoJigyoServiceKubun(tempEntity.getSogoJigyoServiceKubun());
        entity.setSeigenNissuKaisu(tempEntity.getSeigenNissuKaisu());
        entity.setSanteiKaisuSeigenKikanKubun(tempEntity.getSanteiKaisuSeigenKikanKubun());
        return entity;
    }
}
