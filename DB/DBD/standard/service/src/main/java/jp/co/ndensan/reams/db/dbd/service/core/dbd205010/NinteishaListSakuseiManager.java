/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd205010;

import jp.co.ndensan.reams.db.dbd.business.core.dbd205010.NinteishaListSakuseiBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.dbd205010.NinteishaListSakuseiNoRenbaBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.KakuninListCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.KakuninListNoRenbanCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 負担限度額認定者リスト発行ＣＳＶ編集クラスです．
 *
 * @reamsid_L DBD-3960-050 x_liuwei
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
     * @param has世帯員以外情報 has世帯員以外情報
     * @param has世帯員情報 has世帯員情報
     * @param 世帯員情報Index 世帯員情報Index
     */
    public void 連番ありCSV情報設定(KakuninListCsvEntity eucCsvEntity, NinteishaListSakuseiEntity t, int 連番, boolean is日付スラッシュ編集,
            boolean has世帯員以外情報, boolean has世帯員情報, int 世帯員情報Index) {
        NinteishaListSakuseiBusiness bus = new NinteishaListSakuseiBusiness();
        bus.setEucCsvEntity(eucCsvEntity, t, 連番, is日付スラッシュ編集, has世帯員以外情報, has世帯員情報, 世帯員情報Index);
    }

    /**
     * 連番なしCSV情報設定
     *
     * @param eucCsvEntity 出力CSV情報
     * @param t SQL取得情報
     * @param is日付スラッシュ編集 is日付スラッシュ編集
     * @param has世帯員以外情報 has世帯員以外情報
     * @param has世帯員情報 has世帯員情報
     * @param 世帯員情報Index 世帯員情報Index
     */
    public void 連番なしCSV情報設定(KakuninListNoRenbanCsvEntity eucCsvEntity, NinteishaListSakuseiEntity t, boolean is日付スラッシュ編集,
            boolean has世帯員以外情報, boolean has世帯員情報, int 世帯員情報Index) {
        NinteishaListSakuseiNoRenbaBusiness bus = new NinteishaListSakuseiNoRenbaBusiness();
        bus.setEucCsvEntity(eucCsvEntity, t, is日付スラッシュ編集, has世帯員以外情報, has世帯員情報, 世帯員情報Index);
    }
}
