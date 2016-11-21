/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataMapaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再発行所得照会票データTempテーブルに登録のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class InsReHakouShotokushokaihyoTmpProcess extends BatchProcessBase<ShotokuShoukaiDataMapaEntity> {

    private static final RString INDEX_112 = new RString("112");
    private static final RString INDEX_120 = new RString("120");
    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db"
            + ".mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper.select所得照会票データ再発行");
    private static final RString 所得照会票データTEMP = new RString("ShotokuShoukaiDataTemp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 所得照会票データwriter;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private RString 導入形態コード;
    private LasdecCode 導入団体コード;

    @Override
    public void initialize() {
        導入形態コード = processParameter.get導入形態コード();
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 地方公共団体.getLasdecCode_();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECTPATH);
    }

    @Override
    protected void createWriter() {
        所得照会票データwriter = new BatchEntityCreatedTempTableWriter(所得照会票データTEMP, ShotokuShoukaiDataTempEntity.class);
    }

    @Override
    protected void process(ShotokuShoukaiDataMapaEntity t) {
        所得照会票データwriter.insert(creat所得照会票データEntity(t));
    }

    private ShotokuShoukaiDataTempEntity creat所得照会票データEntity(ShotokuShoukaiDataMapaEntity 所得照会票データ) {
        ShotokuShoukaiDataTempEntity entity = new ShotokuShoukaiDataTempEntity();
        entity.setShikibetsuCode(所得照会票データ.getShikibetsuCode());
        entity.setGenLasdecCode(所得照会票データ.getGenLasdecCode());
        entity.setZenkokuJushoCode(所得照会票データ.getZenkokuJushoCode());
        if (所得照会票データ.getSoufusenzenkokuJushoCode() != null) {
            entity.setSoufusenzenkokuJushoCode(所得照会票データ.getSoufusenzenkokuJushoCode().getColumnValue());
        }
        entity.setSetaiCode(所得照会票データ.getSetaiCode());
        entity.setHihokenshaNo(所得照会票データ.getHihokenshaNo());
        entity.setHihokenshaName(所得照会票データ.getHihokenshaName());
        entity.setHihokenshajusho(所得照会票データ.getHihokenshajusho());
        entity.setZenjusho(所得照会票データ.getZenjusho());
        entity.setGenjusho(所得照会票データ.getGenjusho());
        entity.setKanaMeisho(所得照会票データ.getKanaMeisho());
        entity.setMeisho(所得照会票データ.getMeisho());
        entity.setSeinengappiYMD(所得照会票データ.getSeinengappiYMD());
        entity.setIdoYMD(所得照会票データ.getIdoYMD());
        entity.setKouhoshakubun(所得照会票データ.getKouhoshakubun());
        entity.setHonninKubun(所得照会票データ.getHonninKubun());
        entity.setChoikiCode(所得照会票データ.getChoikiCode());
        entity.setGyoseikuCode(所得照会票データ.getGyoseikuCode());
        if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            entity.setShichosonCode(導入団体コード.getColumnValue());
        } else {
            RString shichosonCode = 所得照会票データ.getGenLasdecCode() == null
                    ? RString.EMPTY : 所得照会票データ.getGenLasdecCode().getColumnValue();
            entity.setShichosonCode(shichosonCode);
        }
        entity.setZenjushoCode(所得照会票データ.getZenjushoCode());
        entity.setYubinNo(所得照会票データ.getYubinNo());
        entity.setChikuCode1(所得照会票データ.getChikuCode1());
        entity.setChikuCode2(所得照会票データ.getChikuCode2());
        entity.setChikuCode3(所得照会票データ.getChikuCode3());
        entity.setJuminJotaiCode(所得照会票データ.getJuminJotaiCode());
        entity.setKannaiKangaiKubun(所得照会票データ.getKannaiKangaiKubun());
        entity.setHihokennshaKubunCode(RString.EMPTY);
        entity.setSeibetsuCode(所得照会票データ.getSeibetsuCode());
        entity.setJuminShubetsuCode(所得照会票データ.getJuminShubetsuCode());
        RString torokuTodokedeYMD = 所得照会票データ.getTorokuTodokedeYMD() == null
                ? RString.EMPTY : new RString(所得照会票データ.getTorokuTodokedeYMD().toString());
        entity.setTorokuTodokedeYMD(torokuTodokedeYMD);
        return entity;
    }

}
