/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJigyoshaSakusei;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.relate.KyotakuKeikakuTodokedeMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.relate.KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT3005KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.relate.IKyotakuKeikakuTodokedeMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KyotakuKeikakuJigyoshaSakuseiManager;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
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
        this.居宅給付計画自己作成Manager = new KyotakuKeikakuJikoSakuseiManager();
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
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KyotakuKeikakuTodokedeManager}のインスタンス
     */
    public static KyotakuKeikakuTodokedeManager createInstance() {
        return InstanceProvider.create(KyotakuKeikakuTodokedeManager.class);
    }

    /**
     * 主キーに合致する居宅給付計画届出を返します。
     *
     * @param 居宅給付計画届出検索条件 居宅給付計画届出検索条件
     * @return KyotakuKeikakuTodokede 【　※ツールの都合上、このカッコ部は手動で削除して下さい 居宅給付計画届出】
     * nullが返る可能性があります。
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
        return new KyotakuKeikakuTodokede(relateEntity.get居宅給付計画届出Entity());
    }

    /**
     * 主キー1に合致する居宅給付計画届出のリストを返します。
     *
     * @param 居宅給付計画届出検索条件 居宅給付計画届出検索条件
     * @return KyotakuKeikakuTodokedeの{@code list}
     */
    @Transaction
    public List<KyotakuKeikakuTodokede> get居宅給付計画届出リストBy主キー1(KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件) {
        requireNonNull(居宅給付計画届出検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画届出検索条件"));
        IKyotakuKeikakuTodokedeMapper mapper = mapperProvider.create(IKyotakuKeikakuTodokedeMapper.class);

        List<KyotakuKeikakuTodokedeEntity> relateEntityList = mapper.select居宅給付計画届出リストBy主キー1(居宅給付計画届出検索条件);

        ArrayList<KyotakuKeikakuTodokede> 居宅給付計画届出List = new ArrayList<>();
        for (KyotakuKeikakuTodokedeEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            居宅給付計画届出List.add(new KyotakuKeikakuTodokede(relateEntity.get居宅給付計画届出Entity()));
        }
        return 居宅給付計画届出List;

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
        save居宅給付計画事業者作成リスト(居宅給付計画届出.getKyotakuKeikakuJigyoshaSakuseiList());  // XXXは本メソッドの引数に変更してください。
        save居宅給付計画自己作成リスト(居宅給付計画届出.getKyotakuKeikakuJikoSakuseiList());  // XXXは本メソッドの引数に変更してください。
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
