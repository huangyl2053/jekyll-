/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.InsShotokushokaihyoTmpParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataMapbEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbb.service.core.shotokushokaihyo.Shotokushokaihyo;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得照会票データTempテーブルに登録のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class InsShotokushokaihyoTmpProcess extends BatchProcessBase<ShotokuShoukaiDataMapbEntity> {

    private static final int INT_0 = 0;
    private static final int INT_6 = 6;
    private static final RString 候補者区分_転入者 = new RString("1");
    private static final RString 候補者区分_住特者 = new RString("2");
    private static final RString 管内_1 = new RString("1");
    private static final RString 住特者_2 = new RString("2");
    private static final RString 導入形態コード_111 = new RString("111");
    private static final RString 導入形態コード_112 = new RString("112");
    private static final RString 導入形態コード_120 = new RString("120");
    private static final RString 表示する = new RString("1");
    private static final RString 表示しない = new RString("0");
    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db"
            + ".mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper.select所得照会票データ");
    private static final RString 所得照会票データTEMP = new RString("ShotokuShoukaiDataTemp");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 所得照会票データwriter;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private InsShotokushokaihyoTmpParameter myBatisParameter;
    private Shotokushokaihyo manager;
    private RString 都道府県名;
    private RString 市町村名;
    private RString 郡名;
    private RString 都道府県名付与有無;
    private RString 郡名付与有無;
    private RString 市町村名付与有無;
    private RDate 処理日付;
    private RString 導入形態コード;
    private ShotokuShoukaiDataTempEntity 所得照会票データ;

    @Override
    public void initialize() {
        manager = Shotokushokaihyo.createInstance();
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        都道府県名 = association.get都道府県名();
        郡名 = association.get郡名();
        市町村名 = association.get市町村名();
        処理日付 = RDate.getNowDate();
        導入形態コード = processParameter.get導入形態コード();
        都道府県名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
                処理日付, SubGyomuCode.DBU介護統計報告);
        郡名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                処理日付, SubGyomuCode.DBU介護統計報告);
        市町村名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無,
                処理日付, SubGyomuCode.DBU介護統計報告);

    }

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = new InsShotokushokaihyoTmpParameter();
        myBatisParameter.set出力対象(processParameter.get出力対象());
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        所得照会票データwriter = new BatchEntityCreatedTempTableWriter(所得照会票データTEMP, ShotokuShoukaiDataTempEntity.class);
    }

    @Override
    protected void process(ShotokuShoukaiDataMapbEntity t) {
        所得照会票データ = creatEntity(t);
        editor住所を編集(導入形態コード);
        所得照会票データwriter.insert(所得照会票データ);
    }

    private ShotokuShoukaiDataTempEntity creatEntity(ShotokuShoukaiDataMapbEntity t) {
        ShotokuShoukaiDataTempEntity entity = new ShotokuShoukaiDataTempEntity();
        entity.setShikibetsuCode(t.getShikibetsuCode());
        entity.setGenLasdecCode(t.getGenLasdecCode());
        if (t.getZenkokuJushoCode() != null && !t.getZenkokuJushoCode().isEmpty()) {
            entity.setZenkokuJushoCode(t.getZenkokuJushoCode());
        }
        if (t.getSoufusenzenkokuJushoCode() != null && !t.getSoufusenzenkokuJushoCode().isEmpty()) {
            entity.setSoufusenzenkokuJushoCode(t.getSoufusenzenkokuJushoCode().getColumnValue());
        } else {
            entity.setSoufusenzenkokuJushoCode(RString.EMPTY);
        }
        entity.setSetaiCode(t.getSetaiCode());
        entity.setHihokenshaNo(t.getHihokenshaNo());
        entity.setHihokenshaName(t.getHihokenshaName());
        entity.setHihokenshajusho(t.getHihokenshajusho());
        entity.setZenjusho(t.getZenjusho());
        entity.setGenjusho(t.getGenjusho());
        entity.setKanaMeisho(t.getKanaMeisho());
        entity.setMeisho(t.getMeisho());
        entity.setSeinengappiYMD(t.getSeinengappiYMD());
        entity.setIdoYMD(t.getIdoYMD());
        entity.setKouhoshakubun(t.getKouhoshakubun());
        entity.setHonninKubun(t.getHonninKubun());
        entity.setChoikiCode(t.getChoikiCode());
        entity.setGyoseikuCode(t.getGyoseikuCode());
        RString shichosonCode = t.getShichosonCode() == null ? RString.EMPTY : t.getShichosonCode().getColumnValue();
        if (shichosonCode.length() >= INT_6) {
            entity.setShichosonCode(shichosonCode.substring(INT_0, INT_6));
        }
        entity.setZenjushoCode(t.getZenjushoCode());
        entity.setYubinNo(t.getYubinNo());
        entity.setChikuCode1(t.getChikuCode1());
        entity.setChikuCode2(t.getChikuCode2());
        entity.setChikuCode3(t.getChikuCode3());
        entity.setJuminJotaiCode(t.getJuminJotaiCode());
        entity.setKannaiKangaiKubun(t.getKannaiKangaiKubun());
        entity.setHihokennshaKubunCode(t.getHihokennshaKubunCode());
        entity.setSeibetsuCode(t.getSeibetsuCode());
        entity.setJuminShubetsuCode(t.getJuminShubetsuCode());
        RString torokuTodokedeYMD = t.getTorokuTodokedeYMD() == null
                ? RString.EMPTY : new RString(t.getTorokuTodokedeYMD().toString());
        entity.setTorokuTodokedeYMD(torokuTodokedeYMD);
        return entity;
    }

    private void editor住所を編集(RString 導入形態コード) {
        if (所得照会票データ.getKouhoshakubun().equals(住特者_2)
                && 所得照会票データ.getKannaiKangaiKubun().equals(管内_1)) {
            editor被保険者住所();
        }
        if (所得照会票データ.getKannaiKangaiKubun().equals(管内_1)) {
            editor現住所(導入形態コード);
        }
    }

    private void editor現住所(RString 導入形態コード) {
        if (導入形態コード_120.equals(導入形態コード) || 導入形態コード_112.equals(導入形態コード)) {
            if (都道府県名付与有無.equals(表示する) && 郡名付与有無.equals(表示する) && 市町村名付与有無.equals(表示する)) {
                RString 現住所 = 都道府県名.concat(郡名).concat(市町村名).concat(所得照会票データ.getGenjusho());
                所得照会票データ.setGenjusho(現住所);
            } else if (都道府県名付与有無.equals(表示しない)
                    && 郡名付与有無.equals(表示しない) && 市町村名付与有無.equals(表示しない)) {
                所得照会票データ.setGenjusho(RString.EMPTY);
            }
        } else if (導入形態コード.equals(導入形態コード_111)) {
            LasdecCode 市町村コード = LasdecCode.EMPTY;
            if (所得照会票データ.getShichosonCode() != null && 所得照会票データ.getShichosonCode().length() >= INT_6) {
                市町村コード = new LasdecCode(所得照会票データ.getShichosonCode());
            }
            RString 市町村識別ID = manager.get市町村識別ID(市町村コード);
            KoseiShichosonJoho 構成市町村情報 = ShichosonSecurityJoho
                    .getKouseiShichosonJoho(市町村識別ID);
            RString 都道府県名_構成 = RString.EMPTY;
            RString 郡名_構成 = RString.EMPTY;
            if (構成市町村情報 != null) {
                都道府県名_構成 = 構成市町村情報.get都道府県名称();
                郡名_構成 = 構成市町村情報.get郡名称();
            }
            RString 現住所 = 都道府県名_構成.concat(郡名_構成).concat(所得照会票データ.getGenjusho());
            所得照会票データ.setGenjusho(現住所);
        }
    }

    private void editor被保険者住所() {
        if (導入形態コード_120.equals(導入形態コード) || 導入形態コード_112.equals(導入形態コード)) {
            if (都道府県名付与有無.equals(表示する) && 郡名付与有無.equals(表示する) && 市町村名付与有無.equals(表示する)) {
                RString 被保険者住所 = 都道府県名.concat(郡名).concat(市町村名).concat(所得照会票データ.getHihokenshajusho());
                所得照会票データ.setHihokenshajusho(被保険者住所);
            } else if (都道府県名付与有無.equals(表示しない) && 郡名付与有無.equals(表示しない) && 市町村名付与有無.equals(表示しない)) {
                所得照会票データ.setHihokenshajusho(RString.EMPTY);
            }
        } else if (導入形態コード.equals(導入形態コード_111)) {
            LasdecCode 市町村コード = LasdecCode.EMPTY;
            if (所得照会票データ.getShichosonCode() != null && 所得照会票データ.getShichosonCode().length() >= INT_6) {
                市町村コード = new LasdecCode(所得照会票データ.getShichosonCode());
            }
            RString 市町村識別ID = manager.get市町村識別ID(市町村コード);
            RString 都道府県名_構成 = RString.EMPTY;
            RString 郡名_構成 = RString.EMPTY;
            KoseiShichosonJoho 構成市町村情報 = ShichosonSecurityJoho.getKouseiShichosonJoho(市町村識別ID);
            if (構成市町村情報 != null) {
                都道府県名_構成 = 構成市町村情報.get都道府県名称();
                郡名_構成 = 構成市町村情報.get郡名称();
            }
            RString 被保険者住所 = 都道府県名_構成.concat(郡名_構成).concat(所得照会票データ.getHihokenshajusho());
            所得照会票データ.setHihokenshajusho(被保険者住所);
        }
    }

}
