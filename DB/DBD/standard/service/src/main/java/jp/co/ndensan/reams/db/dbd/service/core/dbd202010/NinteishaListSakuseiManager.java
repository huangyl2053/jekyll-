/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd202010;

import jp.co.ndensan.reams.db.dbd.business.core.dbd202010.NinteishaListSakuseiBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.dbd202010.NinteishaListSakuseiNoRenbaBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.KakuninListCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.KakuninListNoRenbanCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 訪問介護利用者負担額減額認定者リス発行ＣＳＶ編集クラスです．
 *
 * @reamsid_L DBD-3970-050 x_lilh
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
     * 連番ありCSV情報設定
     *
     * @param eucCsvEntity 出力CSV情報
     * @param t SQL取得情報
     * @param 連番 連番
     * @param is日付スラッシュ編集 is日付スラッシュ編集
     */
    public void 連番ありCSV情報設定(KakuninListCsvEntity eucCsvEntity, NinteishaListSakuseiEntity t, int 連番, boolean is日付スラッシュ編集) {
        NinteishaListSakuseiBusiness bus = new NinteishaListSakuseiBusiness();
        bus.setEucCsvEntity(eucCsvEntity, t, 連番, is日付スラッシュ編集);
    }

    /**
     * 連番なしCSV情報設定
     *
     * @param eucCsvEntity 出力CSV情報
     * @param t SQL取得情報
     * @param is日付スラッシュ編集 is日付スラッシュ編集
     */
    public void 連番なしCSV情報設定(KakuninListNoRenbanCsvEntity eucCsvEntity, NinteishaListSakuseiEntity t, boolean is日付スラッシュ編集) {
        NinteishaListSakuseiNoRenbaBusiness bus = new NinteishaListSakuseiNoRenbaBusiness();
        bus.setEucCsvEntity(eucCsvEntity, t, is日付スラッシュ編集);
    }
}
