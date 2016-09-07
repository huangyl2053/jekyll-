/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shinseishohakkotaishoshahaakubatch;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShinseishoHakkoTaishoshaHaakuBatch;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4030ShinseishoHakkoTaishoshaHaakuBatchDac;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 申請書発行対象者把握のManagerクラスです。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
public class ShinseishoHakkoTaishoshaHaakuBatchManager {

    private final DbT4030ShinseishoHakkoTaishoshaHaakuBatchDac dac;

    /**
     * コンストラクタです。
     */
    ShinseishoHakkoTaishoshaHaakuBatchManager() {
        this.dac = InstanceProvider.create(DbT4030ShinseishoHakkoTaishoshaHaakuBatchDac.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinseishoHakkoTaishoshaHaakuBatchManager}のインスタンスを返します。
     *
     * @return ShinseishoHakkoTaishoshaHaakuBatchManager
     */
    public static ShinseishoHakkoTaishoshaHaakuBatchManager createInstance() {
        return InstanceProvider.create(ShinseishoHakkoTaishoshaHaakuBatchManager.class);
    }

    /**
     * 最新の把握情報を取得する。
     *
     * @return ShinseishoHakkoTaishoshaHaakuBatch
     */
    @Transaction
    public ShinseishoHakkoTaishoshaHaakuBatch select最新の把握情報() {
        DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity entity = dac.select最新の把握情報();
        if (entity == null) {
            return null;
        } else {
            return new ShinseishoHakkoTaishoshaHaakuBatch(entity);
        }
    }

    /**
     * 一年間の基準日時を取得する。
     *
     * @param 減免減額種類 RString
     * @return List<ShinseishoHakkoTaishoshaHaakuBatch>
     */
    @Transaction
    public List<ShinseishoHakkoTaishoshaHaakuBatch> select基準日時(RString 減免減額種類) {
        List<DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity> entityList = dac.select基準日時(減免減額種類);
        if (entityList == null) {
            entityList = new ArrayList<>();
        }
        List<ShinseishoHakkoTaishoshaHaakuBatch> result = new ArrayList<>();
        for (DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity entity : entityList) {
            ShinseishoHakkoTaishoshaHaakuBatch shinseisho = new ShinseishoHakkoTaishoshaHaakuBatch(entity);
            result.add(shinseisho);
        }
        return result;
    }

    /**
     * 把握情報を取得する。
     *
     * @param 把握処理ID UUID
     * @return ShinseishoHakkoTaishoshaHaakuBatch
     */
    @Transaction
    public ShinseishoHakkoTaishoshaHaakuBatch select把握情報(UUID 把握処理ID) {
        DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity entity = dac.select把握情報(把握処理ID);
        if (entity == null) {
            return null;
        } else {
            return new ShinseishoHakkoTaishoshaHaakuBatch(entity);
        }
    }

    /**
     * 把握処理IDを取得する。
     *
     * @param バッチ処理日時 YMDHMS
     * @return ShinseishoHakkoTaishoshaHaakuBatch
     */
    @Transaction
    public ShinseishoHakkoTaishoshaHaakuBatch select把握処理ID(YMDHMS バッチ処理日時) {
        DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity entity = dac.select把握処理ID(バッチ処理日時);
        if (entity == null) {
            return null;
        } else {
            return new ShinseishoHakkoTaishoshaHaakuBatch(entity);
        }
    }
}
