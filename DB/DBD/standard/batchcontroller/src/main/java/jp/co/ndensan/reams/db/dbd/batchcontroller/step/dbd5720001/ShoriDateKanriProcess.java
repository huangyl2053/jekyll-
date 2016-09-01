/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5720001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5720001.JyukyushaDaichoIdoCheckListProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタ更新のprocess処理クラスです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
public class ShoriDateKanriProcess extends BatchProcessBase<KoseiShichosonMasterEntity> {

    private JyukyushaDaichoIdoCheckListProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "koseishichosonmaster.IKoseiShichosonMasterMapper.get市町村識別ID");

    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbT7022EntityWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        dbT7022EntityWriter = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(KoseiShichosonMasterEntity enity) {
        dbT7022EntityWriter.update(update処理日付管理マスタ(enity));
    }

    private DbT7022ShoriDateKanriEntity update処理日付管理マスタ(KoseiShichosonMasterEntity entity) {
        DbT7022ShoriDateKanriEntity dbT7022entity = new DbT7022ShoriDateKanriEntity();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null) {
            RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().getColumnValue();
            setShoriEdaban(dbT7022entity, entity, 導入形態コード);
        }
        dbT7022entity.setSubGyomuCode(SubGyomuCode.DBD介護受給);
        dbT7022entity.setShoriName(new RString("異動チェックリスト"));
        if (parameter.get今回抽出終了年月日() == null || parameter.get今回抽出終了年月日().toString().isEmpty()) {
            dbT7022entity.setKijunYMD(FlexibleDate.EMPTY);
            dbT7022entity.setTaishoShuryoYMD(FlexibleDate.EMPTY);
        } else {
            dbT7022entity.setKijunYMD(new FlexibleDate(parameter.get今回抽出終了年月日().toString()));
            dbT7022entity.setTaishoShuryoYMD(new FlexibleDate(parameter.get今回抽出終了年月日().toString()));
        }
        if (parameter.get今回抽出終了時分秒() == null || parameter.get今回抽出終了時分秒().toString().isEmpty()) {
            dbT7022entity.setKijunTimestamp(YMDHMS.now());
            dbT7022entity.setTaishoShuryoTimestamp(YMDHMS.now());
        } else {
            dbT7022entity.setKijunTimestamp(new YMDHMS(RDate.getNowDate(), parameter.get今回抽出終了時分秒()));
            dbT7022entity.setTaishoShuryoTimestamp(new YMDHMS(RDate.getNowDate(), parameter.get今回抽出終了時分秒()));
        }
        if (parameter.get今回抽出開始年月日() == null || parameter.get今回抽出開始年月日().toString().isEmpty()) {
            dbT7022entity.setTaishoKaishiYMD(FlexibleDate.EMPTY);
        } else {
            dbT7022entity.setTaishoKaishiYMD(new FlexibleDate(parameter.get今回抽出開始年月日().toString()));
        }
        if (parameter.get今回抽出開始時分秒() == null || parameter.get今回抽出開始時分秒().toString().isEmpty()) {
            dbT7022entity.setTaishoKaishiTimestamp(YMDHMS.now());
        } else {
            dbT7022entity.setTaishoKaishiTimestamp(new YMDHMS(RDate.getNowDate(), parameter.get今回抽出開始時分秒()));
        }
        if (dbT7022entity.getShichosonCode() == null) {
            dbT7022entity.setShichosonCode(LasdecCode.EMPTY);
        }
        if (dbT7022entity.getNendo() == null) {
            dbT7022entity.setNendo(FlexibleYear.EMPTY);
        }
        if (dbT7022entity.getNendoNaiRenban() == null) {
            dbT7022entity.setNendoNaiRenban(RString.EMPTY);
        }
        return dbT7022entity;
    }

    private void setShoriEdaban(DbT7022ShoriDateKanriEntity dbT7022entity,
            KoseiShichosonMasterEntity entity,
            RString 導入形態コード) {
        if (導入形態コード.equals(new RString("120"))) {
            dbT7022entity.setShoriEdaban(new RString("0000"));
        }
        if (導入形態コード.equals(new RString("111")) || 導入形態コード.equals(new RString("112"))) {
            RString ログインユーザID = ControlDataHolder.getUserId();
            List<AuthorityItem> authorityItemList = ShichosonSecurityJoho.getShichosonShikibetsuId(ログインユーザID);
            RString 市町村識別ID = authorityItemList.get(0).getItemId();
            if (市町村識別ID.equals(new RString("00"))) {
                dbT7022entity.setShoriEdaban(new RString("00").concat(entity.get市町村識別ID()));
            }
            if (!市町村識別ID.equals(new RString("00"))) {
                dbT7022entity.setShoriEdaban(new RString("00").concat(市町村識別ID));
            }
        }
    }

}
