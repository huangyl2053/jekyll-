/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.InsHakouRirekiAndKanriMstParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2020ShotokuShokaihyoHakkoRirekiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShouKanriRirekiRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 所得照会票発行履歴、および介護所得管理マスタに登録のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class InsHakouRirekiAndKanriMstProcess extends BatchProcessBase<ShotokuShouKanriRirekiRelateEntity> {

    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_6 = 6;
    private static final RString 優先区分 = new RString("0");
    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db"
            + ".mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper.select所得照会票Temp");

    @BatchWriter
    private BatchPermanentTableWriter 所得照会票発行履歴writer;
    @BatchWriter
    private BatchPermanentTableWriter 介護所得管理マスタwriter;
    private ShotokuShouKanriRirekiRelateEntity 連合Entity;
    private ShotokuShoukaiDataTempEntity 所得照会票データEntity;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private InsHakouRirekiAndKanriMstParameter myBatisParameter;
    private YMDHMS システム日時;
    private int 履歴番号;

    @Override
    public void initialize() {
        システム日時 = YMDHMS.now();
        履歴番号 = 0;
    }

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = new InsHakouRirekiAndKanriMstParameter();
        myBatisParameter.set処理年度(processParameter.get処理年度());
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        介護所得管理マスタwriter = new BatchPermanentTableWriter(DbT2008ShotokuKanriEntity.class);
        所得照会票発行履歴writer = new BatchPermanentTableWriter(DbT2020ShotokuShokaihyoHakkoRirekiEntity.class);
    }

    @Override
    protected void process(ShotokuShouKanriRirekiRelateEntity t) {
        連合Entity = t;
        所得照会票データEntity = t.get所得照会票Entity();
        所得照会票発行履歴writer.insert(creat所得照会票発行一覧());
        介護所得管理マスタwriter.insert(creat介護所得管理マスタ());
    }

    private DbT2020ShotokuShokaihyoHakkoRirekiEntity creat所得照会票発行一覧() {
        DbT2020ShotokuShokaihyoHakkoRirekiEntity 所得照会票発行履歴Entity = new DbT2020ShotokuShokaihyoHakkoRirekiEntity();
        所得照会票発行履歴Entity.setShoriNendo(processParameter.get処理年度());
        所得照会票発行履歴Entity.setShikibetsuCode(所得照会票データEntity.getShikibetsuCode());
        if (連合Entity.get所得照会票発行履歴Entity() == null) {
            履歴番号 = 1;
        } else {
            履歴番号 = 連合Entity.get所得照会票発行履歴Entity().getRirekiNo() + INT_1;
        }
        所得照会票発行履歴Entity.setRirekiNo(履歴番号);
        if (!RString.isNullOrEmpty(所得照会票データEntity.getSoufusenzenkokuJushoCode())) {
            RString 送付先全国住所コード = 所得照会票データEntity.getSoufusenzenkokuJushoCode().trim();
            if (INT_6 <= 送付先全国住所コード.length()) {
                所得照会票発行履歴Entity.setShokaisakiLasdecCode(new LasdecCode(送付先全国住所コード.substring(INT_0, INT_6)));
            } else {
                所得照会票発行履歴Entity.setShokaisakiLasdecCode(LasdecCode.EMPTY);
            }
        }
        所得照会票発行履歴Entity.setSetaiCode(所得照会票データEntity.getSetaiCode());
        所得照会票発行履歴Entity.setHakkoReamsLoginId(ControlDataHolder.getUserId());
        所得照会票発行履歴Entity.setHakkoYMD(processParameter.get照会年月日());
        所得照会票発行履歴Entity.setSakuseiTimestamp(システム日時);
        return 所得照会票発行履歴Entity;
    }

    private DbT2008ShotokuKanriEntity creat介護所得管理マスタ() {
        DbT2008ShotokuKanriEntity 介護所得管理Entity = new DbT2008ShotokuKanriEntity();
        介護所得管理Entity.setShotokuNendo(processParameter.get処理年度());
        介護所得管理Entity.setShikibetsuCode(所得照会票データEntity.getShikibetsuCode());
        if (連合Entity.get介護所得管理マスタEntity() == null) {
            履歴番号 = 1;
        } else {
            履歴番号 = 連合Entity.get介護所得管理マスタEntity().getRirekiNo() + INT_1;
        }
        介護所得管理Entity.setRirekiNo(履歴番号);
        介護所得管理Entity.setKazeiKubun(KazeiKubun.所得調査中.getコード());
        介護所得管理Entity.setKazeiKubunGemmenGo(KazeiKubun.所得調査中.getコード());
        介護所得管理Entity.setGokeiShotokuGaku(Decimal.ZERO);
        介護所得管理Entity.setNenkiniShunyuGaku(Decimal.ZERO);
        介護所得管理Entity.setNenkiniShotokuGaku(Decimal.ZERO);
        介護所得管理Entity.setKazeiShotokuGaku(Decimal.ZERO);
        介護所得管理Entity.setGekihenKanwaKubun(RString.EMPTY);
        介護所得管理Entity.setYusenKubun(優先区分);
        介護所得管理Entity.setShoriTimeStamp(システム日時);
        return 介護所得管理Entity;
    }

}
