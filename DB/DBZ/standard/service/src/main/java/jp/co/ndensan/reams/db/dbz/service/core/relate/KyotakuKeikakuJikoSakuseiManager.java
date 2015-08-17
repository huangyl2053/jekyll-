/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikosakuseiMeisai;
import jp.co.ndensan.reams.db.dbz.business.core.basic.YoboKeikakuJikoSakuseiMeisai;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.relate.KyotakuKeikakuJikoSakuseiMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.relate.KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT3007KyotakuKeikakuJikoSakuseiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.relate.IKyotakuKeikakuJikoSakuseiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KyotakuKeikakuJikosakuseiMeisaiManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.YoboKeikakuJikoSakuseiMeisaiManager;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画自己作成を管理するクラスです。
 */
public class KyotakuKeikakuJikoSakuseiManager {

    private final MapperProvider mapperProvider;
    private final DbT3007KyotakuKeikakuJikoSakuseiDac 居宅給付計画自己作成Dac;
    private final KyotakuKeikakuJikosakuseiMeisaiManager 居宅給付計画自己作成明細Manager;
    private final YoboKeikakuJikoSakuseiMeisaiManager 予防給付計画自己作成明細Manager;

    /**
     * コンストラクタです。
     */
    KyotakuKeikakuJikoSakuseiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.居宅給付計画自己作成Dac = InstanceProvider.create(DbT3007KyotakuKeikakuJikoSakuseiDac.class);
        this.居宅給付計画自己作成明細Manager = new KyotakuKeikakuJikosakuseiMeisaiManager();
        this.予防給付計画自己作成明細Manager = new YoboKeikakuJikoSakuseiMeisaiManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 居宅給付計画自己作成Dac 居宅給付計画自己作成Dac
     * @param 居宅給付計画自己作成明細Manager 居宅給付計画自己作成明細Manager
     * @param 予防給付計画自己作成明細Manager 予防給付計画自己作成明細Manager
     */
    KyotakuKeikakuJikoSakuseiManager(
            MapperProvider mapperProvider,
            DbT3007KyotakuKeikakuJikoSakuseiDac 居宅給付計画自己作成Dac,
            KyotakuKeikakuJikosakuseiMeisaiManager 居宅給付計画自己作成明細Manager,
            YoboKeikakuJikoSakuseiMeisaiManager 予防給付計画自己作成明細Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.居宅給付計画自己作成Dac = 居宅給付計画自己作成Dac;
        this.居宅給付計画自己作成明細Manager = 居宅給付計画自己作成明細Manager;
        this.予防給付計画自己作成明細Manager = 予防給付計画自己作成明細Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyotakuKeikakuJikoSakuseiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KyotakuKeikakuJikoSakuseiManager}のインスタンス
     */
    public static KyotakuKeikakuJikoSakuseiManager createInstance() {
        return InstanceProvider.create(KyotakuKeikakuJikoSakuseiManager.class);
    }

    /**
     * 主キーに合致する居宅給付計画自己作成を返します。
     *
     * @param 居宅給付計画自己作成検索条件 居宅給付計画自己作成検索条件
     * @return KyotakuKeikakuJikoSakusei 【　※ツールの都合上、このカッコ部は手動で削除して下さい
     * 居宅給付計画自己作成】 nullが返る可能性があります。
     */
    @Transaction
    public KyotakuKeikakuJikoSakusei get居宅給付計画自己作成(KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件) {
        requireNonNull(居宅給付計画自己作成検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成検索条件"));
        IKyotakuKeikakuJikoSakuseiMapper mapper = mapperProvider.create(IKyotakuKeikakuJikoSakuseiMapper.class);

        KyotakuKeikakuJikoSakuseiEntity relateEntity = mapper.select居宅給付計画自己作成ByKey(居宅給付計画自己作成検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new KyotakuKeikakuJikoSakusei(relateEntity.get居宅給付計画自己作成Entity());
    }

    /**
     * 主キー1に合致する居宅給付計画自己作成のリストを返します。
     *
     * @param 居宅給付計画自己作成検索条件 居宅給付計画自己作成検索条件
     * @return KyotakuKeikakuJikoSakuseiの{@code list}
     */
    @Transaction
    public List<KyotakuKeikakuJikoSakusei> get居宅給付計画自己作成リストBy主キー1(KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件) {
        requireNonNull(居宅給付計画自己作成検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成検索条件"));
        IKyotakuKeikakuJikoSakuseiMapper mapper = mapperProvider.create(IKyotakuKeikakuJikoSakuseiMapper.class);

        List<KyotakuKeikakuJikoSakuseiEntity> relateEntityList = mapper.select居宅給付計画自己作成リストBy主キー1(居宅給付計画自己作成検索条件);

        ArrayList<KyotakuKeikakuJikoSakusei> 居宅給付計画自己作成List = new ArrayList<>();
        for (KyotakuKeikakuJikoSakuseiEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            居宅給付計画自己作成List.add(new KyotakuKeikakuJikoSakusei(relateEntity.get居宅給付計画自己作成Entity()));
        }
        return 居宅給付計画自己作成List;

    }

    /**
     * 居宅給付計画自己作成{@link KyotakuKeikakuJikoSakusei}を保存します。
     *
     * @param 居宅給付計画自己作成 居宅給付計画自己作成
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(KyotakuKeikakuJikoSakusei 居宅給付計画自己作成) {
        requireNonNull(居宅給付計画自己作成, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成"));

        if (!居宅給付計画自己作成.hasChanged()) {
            return false;
        }
        居宅給付計画自己作成 = 居宅給付計画自己作成.modifiedModel();
        save居宅給付計画自己作成明細リスト(居宅給付計画自己作成.getKyotakuKeikakuJikosakuseiMeisaiList());  // XXXは本メソッドの引数に変更してください。
        save予防給付計画自己作成明細リスト(居宅給付計画自己作成.getYoboKeikakuJikoSakuseiMeisaiList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 居宅給付計画自己作成Dac.save(居宅給付計画自己作成.toEntity());
    }

    private void save居宅給付計画自己作成明細リスト(List<KyotakuKeikakuJikosakuseiMeisai> 居宅給付計画自己作成明細List) {
        for (KyotakuKeikakuJikosakuseiMeisai 居宅給付計画自己作成明細 : 居宅給付計画自己作成明細List) {
            居宅給付計画自己作成明細Manager.save居宅給付計画自己作成明細(居宅給付計画自己作成明細);
        }
    }

    private void save予防給付計画自己作成明細リスト(List<YoboKeikakuJikoSakuseiMeisai> 予防給付計画自己作成明細List) {
        for (YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細 : 予防給付計画自己作成明細List) {
            予防給付計画自己作成明細Manager.save予防給付計画自己作成明細(予防給付計画自己作成明細);
        }
    }
}
