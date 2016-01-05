/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.GappeiJoho;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeishichoson.GappeiShichoson;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.gappeijoho.GappeiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.GappeiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.gappeijoho.IGappeiJohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeishichoson.GappeiShichosonManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併情報を管理するクラスです。
 */
public class GappeiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT7055GappeiJohoDac 合併情報Dac;
    private final GappeiShichosonManager 合併市町村Manager;

    /**
     * コンストラクタです。
     */
    GappeiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.合併情報Dac = InstanceProvider.create(DbT7055GappeiJohoDac.class);
        this.合併市町村Manager = new GappeiShichosonManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 合併情報Dac 合併情報Dac
     * @param 合併市町村Manager 合併市町村Manager
     */
    GappeiJohoManager(
            MapperProvider mapperProvider,
            DbT7055GappeiJohoDac 合併情報Dac,
            GappeiShichosonManager 合併市町村Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.合併情報Dac = 合併情報Dac;
        this.合併市町村Manager = 合併市町村Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GappeiJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link GappeiJohoManager}のインスタンス
     */
    public static GappeiJohoManager createInstance() {
        return InstanceProvider.create(GappeiJohoManager.class);
    }

    /**
     * 主キーに合致する合併情報を返します。
     *
     * @param 合併情報検索条件 合併情報検索条件
     * @return GappeiJoho nullが返る可能性があります。
     */
    @Transaction
    public GappeiJoho get合併情報(GappeiJohoMapperParameter 合併情報検索条件) {
        requireNonNull(合併情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報検索条件"));
        IGappeiJohoMapper mapper = mapperProvider.create(IGappeiJohoMapper.class);

        GappeiJohoRelateEntity relateEntity = mapper.getGappeiJohoRelateEntity(合併情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new GappeiJoho(relateEntity);
    }

    /**
     * 合併情報{@link GappeiJoho}を保存します。
     *
     * @param 合併情報 合併情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(GappeiJoho 合併情報) {
        requireNonNull(合併情報, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報"));

        if (!合併情報.hasChanged()) {
            return false;
        }
        合併情報 = 合併情報.modifiedModel();
        save合併市町村リスト(合併情報.getGappeiShichosonList());
        return 1 == 合併情報Dac.save(合併情報.toEntity());
    }

    private void save合併市町村リスト(List<GappeiShichoson> 合併市町村List) {
        for (GappeiShichoson 合併市町村 : 合併市町村List) {
            合併市町村Manager.save合併市町村(合併市町村);
        }
    }
}
