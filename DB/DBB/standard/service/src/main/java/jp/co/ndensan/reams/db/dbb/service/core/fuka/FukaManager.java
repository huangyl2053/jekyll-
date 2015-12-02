/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuka;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.FukaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.FukaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka.IFukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課を管理するクラスです。
 */
public class FukaManager {

    private final MapperProvider mapperProvider;
    private final DbT2002FukaDac 介護賦課Dac;
    private final KibetsuManager 介護期別Manager;

    /**
     * コンストラクタです。
     */
    FukaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.介護期別Manager = new KibetsuManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護賦課Dac 介護賦課Dac
     * @param 介護期別Manager 介護期別Manager
     */
    FukaManager(
            MapperProvider mapperProvider,
            DbT2002FukaDac 介護賦課Dac,
            KibetsuManager 介護期別Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護賦課Dac = 介護賦課Dac;
        this.介護期別Manager = 介護期別Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FukaManager}のインスタンス
     */
    public static FukaManager createInstance() {
        return InstanceProvider.create(FukaManager.class);
    }

    /**
     * 主キーに合致する介護賦課を返します。
     *
     * @param 介護賦課検索条件 介護賦課検索条件
     * @return Fuka nullが返る可能性があります。
     */
    @Transaction
    public Fuka get介護賦課(FukaMapperParameter 介護賦課検索条件) {
        requireNonNull(介護賦課検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課検索条件"));
        IFukaMapper mapper = mapperProvider.create(IFukaMapper.class);

        FukaEntity relateEntity = mapper.getFukaEntity(介護賦課検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new Fuka(relateEntity);
    }

    /**
     * 介護賦課{@link Fuka}を保存します。
     *
     * @param 介護賦課 介護賦課
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(Fuka 介護賦課) {
        requireNonNull(介護賦課, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課"));

        if (!介護賦課.hasChanged()) {
            return false;
        }
        介護賦課 = 介護賦課.modifiedModel();
        save介護期別リスト(介護賦課.getKibetsuList());
        return 1 == 介護賦課Dac.save(介護賦課.toEntity());
    }

    private void save介護期別リスト(List<Kibetsu> 介護期別List) {
        for (Kibetsu 介護期別 : 介護期別List) {
            介護期別Manager.save介護期別(介護期別);
        }
    }
}
