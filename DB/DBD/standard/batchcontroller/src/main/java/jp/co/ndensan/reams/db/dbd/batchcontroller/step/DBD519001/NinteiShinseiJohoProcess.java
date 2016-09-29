/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.NinteiShinseiJohoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.temp.NinteiShinseiJohoTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請情報抽出_process処理クラスです。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
public class NinteiShinseiJohoProcess extends BatchProcessBase<DbT4101NinteiShinseiJohoEntity> {

    private static final RString MYBATIS_MAPPER_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.ninteishinseiinfoif.INinteiShinseiJohoMapper.select要介護認定申請情報");
    private NinteiShinseiJohoProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(NinteiShinseiJohoTempEntity.TABLE_NAME, NinteiShinseiJohoTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_MAPPER_ID, parameter.toNinteiShinseiJohoMybatisParameter());
    }

    @Override
    protected void process(DbT4101NinteiShinseiJohoEntity entity) {
        tableWriter.insert(creatTempEntity(entity));
    }

    private NinteiShinseiJohoTempEntity creatTempEntity(DbT4101NinteiShinseiJohoEntity entity) {
        NinteiShinseiJohoTempEntity tempEntity = new NinteiShinseiJohoTempEntity();
        tempEntity.setAge(entity.getAge());
        tempEntity.setChikuCode(entity.getChikuCode());
        tempEntity.setChosaKubun(entity.getChosaKubun());
        tempEntity.setEnkiKetteiYMD(entity.getEnkiKetteiYMD());
        tempEntity.setEnkiMikomiKaishiYMD(entity.getEnkiKetteiYMD());
        tempEntity.setEnkiMikomiShuryoYMD(entity.getEnkiMikomiShuryoYMD());
        tempEntity.setEnkiRiyu(entity.getEnkiRiyu());
        tempEntity.setEnkiTsuchiHakkoKaisu(entity.getEnkiTsuchiHakkoKaisu());
        tempEntity.setEnkiTsuchiHakkoYMD(entity.getEnkiTsuchiHakkoYMD());
        tempEntity.setEnkitsuchiNashiDoiFlag(entity.getEnkitsuchiNashiDoiFlag());
        tempEntity.setHihokenshaKana(entity.getHihokenshaKana());
        tempEntity.setHihokenshaKubunCode(entity.getHihokenshaKubunCode());
        tempEntity.setHihokenshaName(entity.getHihokenshaName());
        tempEntity.setHihokenshaNo(entity.getHihokenshaNo());
        tempEntity.setHomonChosasakiJusho(entity.getHomonChosasakiJusho());
        tempEntity.setHomonChosasakiName(entity.getHomonChosasakiName());
        tempEntity.setHomonChosasakiTelNo(entity.getHomonChosasakiTelNo());
        tempEntity.setHomonChosasakiYubinNo(entity.getHomonChosasakiYubinNo());
        tempEntity.setIfSofuYMD(entity.getIfSofuYMD());
        tempEntity.setIkenshoDataShubetsu(entity.getIkenshoDataShubetsu());
        tempEntity.setJidoWariateJogaishaKubun(entity.getJidoWariateJogaishaKubun());
        tempEntity.setJohoteikyoDoiFlag(entity.getJohoteikyoDoiFlag());
        tempEntity.setJohoteikyoSiryoOutputYMD(entity.getJohoteikyoSiryoOutputYMD());
        tempEntity.setJusho(entity.getJusho());
        tempEntity.setKateiHomonFlag(entity.getKateiHomonFlag());
        tempEntity.setKoikinaiTenkyoKubun(entity.getKoikinaiTenkyoKubun());
        tempEntity.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        tempEntity.setKoshinTsuchiHakkoKanryoYMD(entity.getKoshinTsuchiHakkoKanryoYMD());
        tempEntity.setKoshinTsuchiHakkoYMD(entity.getKoshinTsuchiHakkoYMD());
        tempEntity.setKyakkaRiyu(entity.getKyakkaRiyu());
        tempEntity.setKyakkaYMD(entity.getKyakkaYMD());
        tempEntity.setLogicalDeletedFlag(entity.getLogicalDeletedFlag());
        tempEntity.setMinashiNigoEtcTaishoFlag(entity.getMinashiNigoEtcTaishoFlag());
        tempEntity.setNigoIryoHokenKigoBango(entity.getNigoIryoHokenKigoBango());
        tempEntity.setNigoIryoHokenshaName(entity.getNigoIryoHokenshaName());
        tempEntity.setNigoTokuteiShippeiCode(entity.getNigoTokuteiShippeiCode());
        tempEntity.setNinteiChosaItakusakiCode(entity.getNinteiChosaItakusakiCode());
        tempEntity.setNinteiChosainCode(entity.getNinteiChosainCode());
        tempEntity.setNinteiShinseiEdabanCode(entity.getNinteiShinseiEdabanCode());
        tempEntity.setNinteiShinseiHoreiKubunCode(entity.getNinteiShinseiHoreiKubunCode());
        tempEntity.setNinteiShinseiJohoTorokuYMD(entity.getNinteiShinseiJohoTorokuYMD());
        tempEntity.setNinteiShinseiRiyu(entity.getNinteiShinseiRiyu());
        tempEntity.setNinteiShinseiShinseijiKubunCode(entity.getNinteiShinseiShinseijiKubunCode());
        tempEntity.setNinteiShinseiYMD(entity.getNinteiShinseiYMD());
        tempEntity.setNinteiShinseiYukoKubunCode(entity.getNinteiShinseiYukoKubunCode());
        tempEntity.setNyushoShisetsuCode(entity.getNyushoShisetsuCode());
        tempEntity.setRenrakuJikoToChosain(entity.getRenrakuJikoToChosain());
        tempEntity.setRenrakuJikoToShujii(entity.getRenrakuJikoToShujii());
        tempEntity.setSaiChosaIraiKaisu(entity.getSaiChosaIraiKaisu());
        tempEntity.setSaiSakuseiIraiKaisu(entity.getSaiSakuseiIraiKaisu());
        tempEntity.setSeibetsu(entity.getSeibetsu());
        tempEntity.setSeinengappiYMD(entity.getSeinengappiYMD());
        tempEntity.setShichosonRenrakuJiko(entity.getShichosonRenrakuJiko());
        tempEntity.setShienShinseiKubun(entity.getShienShinseiKubun());
        tempEntity.setShikibetsuCode(entity.getShikibetsuCode());
        tempEntity.setShinsaKeizokuFlag(entity.getShinsaKeizokuFlag());
        tempEntity.setShinsakaiYusenWaritsukeKubunCode(entity.getShinsakaiYusenWaritsukeKubunCode());
        tempEntity.setShinseiNendo(entity.getShinseiNendo());
        tempEntity.setShinseiServiceDeleteRiyu(entity.getShinseiServiceDeleteRiyu());
        tempEntity.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        tempEntity.setShisetsuNyushoFlag(entity.getShisetsuNyushoFlag());
        tempEntity.setShishoCode(entity.getShishoCode());
        tempEntity.setShiteiiFlag(entity.getShiteiiFlag());
        tempEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        tempEntity.setShoriJotaiKubun(entity.getShoriJotaiKubun());
        tempEntity.setShujiiCode(entity.getShujiiCode());
        tempEntity.setShujiiIryokikanCode(entity.getShujiiIryokikanCode());
        tempEntity.setTelNo(entity.getTelNo());
        tempEntity.setTorisageKubunCode(entity.getTorisageKubunCode());
        tempEntity.setTorisageRiyu(entity.getTorisageRiyu());
        tempEntity.setTorisageYMD(entity.getTorisageYMD());
        tempEntity.setYubinNo(entity.getYubinNo());
        tempEntity.setZenYokaigoKubunCode(entity.getZenYokaigoKubunCode());
        tempEntity.setZenkaiNinteiYMD(entity.getZenkaiNinteiYMD());
        tempEntity.setZenkaiYukoKikanEnd(entity.getZenkaiYukoKikanEnd());
        tempEntity.setZenkaiYukoKikanStart(entity.getZenkaiYukoKikanStart());
        return tempEntity;
    }
}
