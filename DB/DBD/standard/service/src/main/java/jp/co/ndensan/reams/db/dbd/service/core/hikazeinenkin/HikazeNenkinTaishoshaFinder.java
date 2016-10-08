/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.hikazeinenkin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.hikazenenkintaishosha.HikazeNenkinTaishosha;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4037HikazeNenkinTaishoshaDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 非課税年金対象者のデータアクセスクラスです。
 *
 * @reamsid_L DBX-9999-023 liangbc
 */
public class HikazeNenkinTaishoshaFinder {

    private final DbT4037HikazeNenkinTaishoshaDac 非課税年金対象者Dac;

    /**
     * コンストラクタです。
     */
    HikazeNenkinTaishoshaFinder() {
        this.非課税年金対象者Dac = InstanceProvider.create(DbT4037HikazeNenkinTaishoshaDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 非課税年金対象者Dac 非課税年金対象者Dac
     */
    HikazeNenkinTaishoshaFinder(DbT4037HikazeNenkinTaishoshaDac 非課税年金対象者Dac) {
        this.非課税年金対象者Dac = 非課税年金対象者Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HikazeNenkinTaishoshaFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HikazeNenkinTaishoshaFinder}のインスタンス
     */
    public static HikazeNenkinTaishoshaFinder createInstance() {
        return InstanceProvider.create(HikazeNenkinTaishoshaFinder.class);
    }

    /**
     * 全て履歴を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 年度 年度
     * @return List<HikazeNenkinTaishosha>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<HikazeNenkinTaishosha> select全て履歴(RString 被保険者番号, RYear 年度) {
        List<DbT4037HikazeNenkinTaishoshaEntity> list = 非課税年金対象者Dac.select全て履歴(被保険者番号, 年度);
        List<HikazeNenkinTaishosha> 非課税年金対象者List = new ArrayList<>();
        for (DbT4037HikazeNenkinTaishoshaEntity entity : list) {
            非課税年金対象者List.add(new HikazeNenkinTaishosha(entity));
        }

        return 非課税年金対象者List;
    }

    /**
     * 同一年金単位最新履歴を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 年度 年度
     * @return List<HikazeNenkinTaishosha>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<HikazeNenkinTaishosha> select同一年金単位最新履歴(RString 被保険者番号, RYear 年度) {
        List<DbT4037HikazeNenkinTaishoshaEntity> list
                = 非課税年金対象者Dac.select同一年金単位最新履歴(被保険者番号, new RString(年度.minusYear(1).toString()));
        List<HikazeNenkinTaishosha> 非課税年金対象者List = new ArrayList<>();
        for (DbT4037HikazeNenkinTaishoshaEntity entity : list) {
            非課税年金対象者List.add(new HikazeNenkinTaishosha(entity));
        }
        return 非課税年金対象者List;
    }
    
    /**
     * 非課税年金情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 年度 年度
     * @return List<HikazeNenkinTaishosha>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<HikazeNenkinTaishosha> select非課税年金情報(RString 被保険者番号, RYear 年度) {
        List<DbT4037HikazeNenkinTaishoshaEntity> list
                = 非課税年金対象者Dac.select非課税年金情報(被保険者番号, 年度);
        List<HikazeNenkinTaishosha> 非課税年金情報List = new ArrayList<>();
        for (DbT4037HikazeNenkinTaishoshaEntity entity : list) {
            非課税年金情報List.add(new HikazeNenkinTaishosha(entity));
        }
        return 非課税年金情報List;
    }
}
