/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd203010;

import jp.co.ndensan.reams.db.dbd.business.core.dbd203010.NinteishaListSakuseiBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.dbd203010.NinteishaListSakuseiNoRenbaBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.Setaiinshotokujoho;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.ShakaiFukushiHojinKeigenCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.ShakaiFukushiHojinKeigenGaitoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.ShakaiFukushiHojinKeigenNoRennbannCsvEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * CSV作成の取得クラスです
 *
 * @reamsid_L DBD-3830-030 tianyh
 */
public class NinteishaListSakuseiManager {

    /**
     * NinteishaListSakuseiManagerのインスタンス化
     *
     * @return NinteishaListSakuseiManager
     */
    public static NinteishaListSakuseiManager createInstance() {
        return InstanceProvider.create(NinteishaListSakuseiManager.class);
    }

    /**
     * 連番ありCSV世帯員情報設定
     *
     * @param eucCsvEntity ShakaiFukushiHojinKeigenCsvEntity
     * @param entity ShakaiFukushiHojinKeigenGaitoshaIchiranEntity
     * @param 連番 int
     * @param is日付スラッシュ編集 boolean
     * @param joho Setaiinshotokujoho
     *
     */
    public void 連番ありCSV世帯員情報設定(ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenGaitoshaIchiranEntity entity,
            int 連番, boolean is日付スラッシュ編集, Setaiinshotokujoho joho) {
        NinteishaListSakuseiBusiness bus = new NinteishaListSakuseiBusiness();
        bus.setEucCsvEntity(eucCsvEntity, entity, 連番, is日付スラッシュ編集);
        if (joho != null) {
            bus.set世帯員CsvEntity(eucCsvEntity, joho);
        }
    }

    /**
     * 連番ありCSV情報設定
     *
     * @param eucCsvEntity ShakaiFukushiHojinKeigenCsvEntity
     * @param joho Setaiinshotokujoho
     *
     */
    public void 連番ありCSV情報設定(ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity, Setaiinshotokujoho joho) {
        NinteishaListSakuseiBusiness bus = new NinteishaListSakuseiBusiness();
        bus.setCsvEntityEmptyNo世帯員(eucCsvEntity);
        bus.set世帯員CsvEntity(eucCsvEntity, joho);
    }

    /**
     * 連番なしCSV世帯員情報設定
     *
     * @param eucCsvEntity ShakaiFukushiHojinKeigenNoRennbannCsvEntity
     * @param entity ShakaiFukushiHojinKeigenGaitoshaIchiranEntity
     * @param is日付スラッシュ編集 boolean
     * @param joho Setaiinshotokujoho
     *
     */
    public void 連番なしCSV世帯員情報設定(ShakaiFukushiHojinKeigenNoRennbannCsvEntity eucCsvEntity,
            ShakaiFukushiHojinKeigenGaitoshaIchiranEntity entity, boolean is日付スラッシュ編集, Setaiinshotokujoho joho) {
        NinteishaListSakuseiNoRenbaBusiness bus = new NinteishaListSakuseiNoRenbaBusiness();
        bus.setNoRennbannEucCsvEntity(eucCsvEntity, entity, is日付スラッシュ編集);
        if (joho != null) {
            bus.set世帯員NoRennbannCsvEntity(eucCsvEntity, joho);
        }
    }

    /**
     * 連番なしCSV情報設定
     *
     * @param eucCsvEntity ShakaiFukushiHojinKeigenNoRennbannCsvEntity
     * @param joho Setaiinshotokujoho
     *
     */
    public void 連番なしCSV情報設定(ShakaiFukushiHojinKeigenNoRennbannCsvEntity eucCsvEntity, Setaiinshotokujoho joho) {
        NinteishaListSakuseiNoRenbaBusiness bus = new NinteishaListSakuseiNoRenbaBusiness();
        bus.setNoRennbannCsvEntityEmptyNo世帯員(eucCsvEntity);
        bus.set世帯員NoRennbannCsvEntity(eucCsvEntity, joho);
    }
}
