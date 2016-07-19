/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.business.core.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.FukaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.FukaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka.IFukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.basic.KibetsuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課を管理するクラスです。
 */
public class FukaRelateManager {

    private final MapperProvider mapperProvider;
    private final DbT2002FukaDac 介護賦課Dac;
    private final KibetsuManager 介護期別Manager;

    /**
     * コンストラクタです。
     */
    FukaRelateManager() {
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
    FukaRelateManager(
            MapperProvider mapperProvider,
            DbT2002FukaDac 介護賦課Dac,
            KibetsuManager 介護期別Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護賦課Dac = 介護賦課Dac;
        this.介護期別Manager = 介護期別Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaRelateManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FukaRelateManager}のインスタンス
     */
    public static FukaRelateManager createInstance() {
        return InstanceProvider.create(FukaRelateManager.class);
    }

    /**
     * 主キーに合致する介護賦課を返します。
     *
     * @param 介護賦課検索条件 介護賦課検索条件
     * @return Fuka 【　※ツールの都合上、このカッコ部は手動で削除して下さい 介護賦課】 nullが返る可能性があります。
     */
    @Transaction
    public Fuka get介護賦課(FukaMapperParameter 介護賦課検索条件) {
        requireNonNull(介護賦課検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課検索条件"));
        IFukaMapper mapper = mapperProvider.create(IFukaMapper.class);

        FukaEntity relateEntity = mapper.select介護賦課ByKey(介護賦課検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new Fuka(relateEntity.get介護賦課Entity());
    }

    /**
     * 主キー1に合致する介護賦課のリストを返します。
     *
     * @param 介護賦課検索条件 介護賦課検索条件
     * @return Fukaの{@code list}
     */
    @Transaction
    public List<Fuka> get介護賦課リストBy主キー1(FukaMapperParameter 介護賦課検索条件) {
        requireNonNull(介護賦課検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課検索条件"));
        IFukaMapper mapper = mapperProvider.create(IFukaMapper.class);

        List<FukaEntity> relateEntityList = mapper.select介護賦課リストBy主キー1(介護賦課検索条件);

        ArrayList<Fuka> 介護賦課List = new ArrayList<>();
        for (FukaEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            介護賦課List.add(new Fuka(relateEntity.get介護賦課Entity()));
        }
        return 介護賦課List;

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
        save介護期別リスト(介護賦課.getKibetsuList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 介護賦課Dac.save(介護賦課.toEntity());
    }

    private void save介護期別リスト(List<Kibetsu> 介護期別List) {
        for (Kibetsu 介護期別 : 介護期別List) {
            介護期別Manager.save介護期別(介護期別);
        }
    }
}
