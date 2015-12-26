/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeikakutodokede;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujigyoshasakusei.KyotakuKeikakuJigyoshaSakusei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokedeMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyotakukeika.kyotakukeikakutodokede.IKyotakuKeikakuTodokedeMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeikakujigyoshasakusei.KyotakuKeikakuJigyoshaSakuseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakuseiManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3005KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画届出を管理するクラスです。
 */
public class KyotakuKeikakuTodokedeManager {

    private final MapperProvider mapperProvider;
    private final DbT3005KyotakuKeikakuTodokedeDac 居宅給付計画届出Dac;
    private final KyotakuKeikakuJigyoshaSakuseiManager 居宅給付計画事業者作成Manager;
    private final KyotakuKeikakuJikoSakuseiManager 居宅給付計画自己作成Manager;

    /**
     * コンストラクタです。
     */
    KyotakuKeikakuTodokedeManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.居宅給付計画届出Dac = InstanceProvider.create(DbT3005KyotakuKeikakuTodokedeDac.class);
        this.居宅給付計画事業者作成Manager = new KyotakuKeikakuJigyoshaSakuseiManager();
        this.居宅給付計画自己作成Manager = KyotakuKeikakuJikoSakuseiManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 居宅給付計画届出Dac 居宅給付計画届出Dac
     * @param 居宅給付計画事業者作成Manager 居宅給付計画事業者作成Manager
     * @param 居宅給付計画自己作成Manager 居宅給付計画自己作成Manager
     */
    KyotakuKeikakuTodokedeManager(
            MapperProvider mapperProvider,
            DbT3005KyotakuKeikakuTodokedeDac 居宅給付計画届出Dac,
            KyotakuKeikakuJigyoshaSakuseiManager 居宅給付計画事業者作成Manager,
            KyotakuKeikakuJikoSakuseiManager 居宅給付計画自己作成Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.居宅給付計画届出Dac = 居宅給付計画届出Dac;
        this.居宅給付計画事業者作成Manager = 居宅給付計画事業者作成Manager;
        this.居宅給付計画自己作成Manager = 居宅給付計画自己作成Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyotakuKeikakuTodokedeManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KyotakuKeikakuTodokedeManager}のインスタンス
     */
    public static KyotakuKeikakuTodokedeManager createInstance() {
        return InstanceProvider.create(KyotakuKeikakuTodokedeManager.class);
    }

    /**
     * 主キーに合致する居宅給付計画届出を返します。
     *
     * @param 居宅給付計画届出検索条件 居宅給付計画届出検索条件
     * @return KyotakuKeikakuTodokede nullが返る可能性があります。
     */
    @Transaction
    public KyotakuKeikakuTodokede get居宅給付計画届出(KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件) {
        requireNonNull(居宅給付計画届出検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画届出検索条件"));
        IKyotakuKeikakuTodokedeMapper mapper = mapperProvider.create(IKyotakuKeikakuTodokedeMapper.class);

        KyotakuKeikakuTodokedeEntity relateEntity = mapper.select居宅給付計画届出ByKey(居宅給付計画届出検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new KyotakuKeikakuTodokede(relateEntity);
    }

    /**
     * 居宅給付計画届出{@link KyotakuKeikakuTodokede}を保存します。
     *
     * @param 居宅給付計画届出 居宅給付計画届出
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(KyotakuKeikakuTodokede 居宅給付計画届出) {
        requireNonNull(居宅給付計画届出, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画届出"));

        if (!居宅給付計画届出.hasChanged()) {
            return false;
        }
        居宅給付計画届出 = 居宅給付計画届出.modifiedModel();
        save居宅給付計画事業者作成リスト(居宅給付計画届出.getKyotakuKeikakuJigyoshaSakuseiList());
        save居宅給付計画自己作成リスト(居宅給付計画届出.getKyotakuKeikakuJikoSakuseiList());
        return 1 == 居宅給付計画届出Dac.save(居宅給付計画届出.toEntity());
    }

    private void save居宅給付計画事業者作成リスト(List<KyotakuKeikakuJigyoshaSakusei> 居宅給付計画事業者作成List) {
        for (KyotakuKeikakuJigyoshaSakusei 居宅給付計画事業者作成 : 居宅給付計画事業者作成List) {
            居宅給付計画事業者作成Manager.save居宅給付計画事業者作成(居宅給付計画事業者作成);
        }
    }

    private void save居宅給付計画自己作成リスト(List<KyotakuKeikakuJikoSakusei> 居宅給付計画自己作成List) {
        for (KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 : 居宅給付計画自己作成List) {
            居宅給付計画自己作成Manager.save(居宅給付計画自己作成);
        }
    }
}
