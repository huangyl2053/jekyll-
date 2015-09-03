/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TandokuJoseikinKyufuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TandokuJoseikinKyufuShinsei;
import jp.co.ndensan.reams.db.dbc.definition.mybatis.param.relate.TandokuJoseikinKyufuShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.relate.TandokuJoseikinKyufuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3098TandokuJoseikinKyufuShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.relate.ITandokuJoseikinKyufuShinseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.basic.TandokuJoseikinKyufuKetteiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村単独助成金給付申請を管理するクラスです。
 */
public class TandokuJoseikinKyufuShinseiManager {

    private final MapperProvider mapperProvider;
    private final DbT3098TandokuJoseikinKyufuShinseiDac 市町村単独助成金給付申請Dac;
    private final TandokuJoseikinKyufuKetteiManager 市町村単独助成金給付決定Manager;

    /**
     * コンストラクタです。
     */
    TandokuJoseikinKyufuShinseiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.市町村単独助成金給付申請Dac = InstanceProvider.create(DbT3098TandokuJoseikinKyufuShinseiDac.class);
        this.市町村単独助成金給付決定Manager = new TandokuJoseikinKyufuKetteiManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 市町村単独助成金給付申請Dac 市町村単独助成金給付申請Dac
     * @param 市町村単独助成金給付決定Manager 市町村単独助成金給付決定Manager
     */
    TandokuJoseikinKyufuShinseiManager(
            MapperProvider mapperProvider,
            DbT3098TandokuJoseikinKyufuShinseiDac 市町村単独助成金給付申請Dac,
            TandokuJoseikinKyufuKetteiManager 市町村単独助成金給付決定Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.市町村単独助成金給付申請Dac = 市町村単独助成金給付申請Dac;
        this.市町村単独助成金給付決定Manager = 市町村単独助成金給付決定Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TandokuJoseikinKyufuShinseiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TandokuJoseikinKyufuShinseiManager}のインスタンス
     */
    public static TandokuJoseikinKyufuShinseiManager createInstance() {
        return InstanceProvider.create(TandokuJoseikinKyufuShinseiManager.class);
    }

    /**
     * 主キーに合致する市町村単独助成金給付申請を返します。
     *
     * @param 市町村単独助成金給付申請検索条件 市町村単独助成金給付申請検索条件
     * @return TandokuJoseikinKyufuShinsei nullが返る可能性があります。
     */
    @Transaction
    public TandokuJoseikinKyufuShinsei get市町村単独助成金給付申請(TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件) {
        requireNonNull(市町村単独助成金給付申請検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成金給付申請検索条件"));
        ITandokuJoseikinKyufuShinseiMapper mapper = mapperProvider.create(ITandokuJoseikinKyufuShinseiMapper.class);

        TandokuJoseikinKyufuShinseiEntity relateEntity = mapper.select市町村単独助成金給付申請ByKey(市町村単独助成金給付申請検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new TandokuJoseikinKyufuShinsei(relateEntity.get市町村単独助成金給付申請Entity());
    }

    /**
     * 主キー1に合致する市町村単独助成金給付申請のリストを返します。
     *
     * @param 市町村単独助成金給付申請検索条件 市町村単独助成金給付申請検索条件
     * @return TandokuJoseikinKyufuShinseiの{@code list}
     */
    @Transaction
    public List<TandokuJoseikinKyufuShinsei> get市町村単独助成金給付申請リストBy主キー1(TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件) {
        requireNonNull(市町村単独助成金給付申請検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成金給付申請検索条件"));
        ITandokuJoseikinKyufuShinseiMapper mapper = mapperProvider.create(ITandokuJoseikinKyufuShinseiMapper.class);

        List<TandokuJoseikinKyufuShinseiEntity> relateEntityList = mapper.select市町村単独助成金給付申請リストBy主キー1(市町村単独助成金給付申請検索条件);

        ArrayList<TandokuJoseikinKyufuShinsei> 市町村単独助成金給付申請List = new ArrayList<>();
        for (TandokuJoseikinKyufuShinseiEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            市町村単独助成金給付申請List.add(new TandokuJoseikinKyufuShinsei(relateEntity.get市町村単独助成金給付申請Entity()));
        }
        return 市町村単独助成金給付申請List;

    }

    /**
     * 市町村単独助成金給付申請{@link TandokuJoseikinKyufuShinsei}を保存します。
     *
     * @param 市町村単独助成金給付申請 市町村単独助成金給付申請
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請) {
        requireNonNull(市町村単独助成金給付申請, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成金給付申請"));

        if (!市町村単独助成金給付申請.hasChanged()) {
            return false;
        }
        市町村単独助成金給付申請 = 市町村単独助成金給付申請.modifiedModel();
        save市町村単独助成金給付決定リスト(市町村単独助成金給付申請.getTandokuJoseikinKyufuKetteiList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 市町村単独助成金給付申請Dac.save(市町村単独助成金給付申請.toEntity());
    }

    private void save市町村単独助成金給付決定リスト(List<TandokuJoseikinKyufuKettei> 市町村単独助成金給付決定List) {
        for (TandokuJoseikinKyufuKettei 市町村単独助成金給付決定 : 市町村単独助成金給付決定List) {
            市町村単独助成金給付決定Manager.save市町村単独助成金給付決定(市町村単独助成金給付決定);
        }
    }
}
