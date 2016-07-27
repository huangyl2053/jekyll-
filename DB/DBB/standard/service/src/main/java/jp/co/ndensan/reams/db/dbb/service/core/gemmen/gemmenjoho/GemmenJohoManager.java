/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.gemmen.gemmenjoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmen.Gemmen;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho.GemmenJoho;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gemmen.GemmenJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gemmen.GemmenJohoRelateSonotaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gemmen.GemmenJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.gemmen.IGemmenJohoRelateMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.gemmen.gemmen.GemmenManager;
import jp.co.ndensan.reams.db.dbb.service.core.gemmen.kibetsu.KibetsuManager;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 減免の情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 xicongwang
 */
public class GemmenJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT2002FukaDac 介護賦課Dac;
    private final KibetsuManager 介護期別Manager;
    private final GemmenManager 介護賦課減免Manager;

    private static final RString 減免の情報検索条件MESSAGE = new RString("減免の情報検索条件");

    /**
     * コンストラクタです。
     */
    GemmenJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.介護期別Manager = KibetsuManager.createInstance();
        this.介護賦課減免Manager = new GemmenManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護賦課Dac 介護賦課Dac
     * @param 介護期別Manager 介護期別Manager
     * @param 介護賦課減免Manager 介護賦課減免Manager
     */
    GemmenJohoManager(
            MapperProvider mapperProvider,
            DbT2002FukaDac 介護賦課Dac,
            KibetsuManager 介護期別Manager,
            GemmenManager 介護賦課減免Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護賦課Dac = 介護賦課Dac;
        this.介護期別Manager = 介護期別Manager;
        this.介護賦課減免Manager = 介護賦課減免Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GemmenJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link GemmenJohoManager}のインスタンス
     */
    public static GemmenJohoManager createInstance() {
        return InstanceProvider.create(GemmenJohoManager.class);
    }

    /**
     * 主キーに合致する減免の情報を返します。
     *
     * @param 減免の情報検索条件 減免の情報検索条件
     * @return GemmenJoho nullが返る可能性があります。
     */
    @Transaction
    public GemmenJoho get減免の情報(GemmenJohoRelateMapperParameter 減免の情報検索条件) {
        requireNonNull(減免の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(減免の情報検索条件MESSAGE.toString()));
        IGemmenJohoRelateMapper mapper = mapperProvider.create(IGemmenJohoRelateMapper.class);

        GemmenJohoRelateEntity relateEntity = mapper.select減免の情報ByKey(減免の情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new GemmenJoho(relateEntity);
    }

    /**
     * 主キーに合致する最新の減免の情報を返します。
     *
     * @param 減免の情報検索条件 減免の情報検索条件
     * @return GemmenJoho nullが返る可能性があります。
     */
    @Transaction
    public GemmenJoho get最新の減免情報(GemmenJohoRelateMapperParameter 減免の情報検索条件) {
        requireNonNull(減免の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(減免の情報検索条件MESSAGE.toString()));
        IGemmenJohoRelateMapper mapper = mapperProvider.create(IGemmenJohoRelateMapper.class);

        GemmenJohoRelateEntity relateEntity = mapper.select最新の減免情報ByKey(減免の情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new GemmenJoho(relateEntity);
    }

    /**
     * 主キーに合致する減免の情報を返します。
     *
     * @param 減免の情報検索条件 減免の情報検索条件
     * @return GemmenJoho nullが返る可能性があります。
     */
    @Transaction
    public GemmenJoho get減免の情報_決定更正後(GemmenJohoRelateSonotaMapperParameter 減免の情報検索条件) {
        requireNonNull(減免の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(減免の情報検索条件MESSAGE.toString()));
        IGemmenJohoRelateMapper mapper = mapperProvider.create(IGemmenJohoRelateMapper.class);

        GemmenJohoRelateEntity relateEntity = mapper.select減免の情報_決定更正後(減免の情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new GemmenJoho(relateEntity);
    }

    /**
     * 主キーに合致する減免の情報を返します。
     *
     * @param 減免の情報検索条件 減免の情報検索条件
     * @return GemmenJoho nullが返る可能性があります。
     */
    @Transaction
    public GemmenJoho get減免の情報_取消更正後(GemmenJohoRelateSonotaMapperParameter 減免の情報検索条件) {
        requireNonNull(減免の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(減免の情報検索条件MESSAGE.toString()));
        IGemmenJohoRelateMapper mapper = mapperProvider.create(IGemmenJohoRelateMapper.class);

        GemmenJohoRelateEntity relateEntity = mapper.select減免の情報_取消更正後(減免の情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new GemmenJoho(relateEntity);
    }

    /**
     * 減免の情報{@link Fuka}を保存します。
     *
     * @param 減免の情報 減免の情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(GemmenJoho 減免の情報) {
        requireNonNull(減免の情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課"));

        if (!減免の情報.hasChanged()) {
            return false;
        }
        減免の情報 = 減免の情報.modifiedModel();
        save介護期別リスト(減免の情報.getKibetsuList());
        save介護賦課減免リスト(減免の情報.getGemmenList());
        return 1 == 介護賦課Dac.save(減免の情報.toEntity());
    }

    private void save介護期別リスト(List<Kibetsu> 介護期別List) {
        for (Kibetsu 介護期別 : 介護期別List) {
            介護期別Manager.save介護期別(介護期別);
        }
    }

    private void save介護賦課減免リスト(List<Gemmen> 介護賦課減免List) {
        for (Gemmen 介護賦課減免 : 介護賦課減免List) {
            介護賦課減免Manager.save介護賦課減免(介護賦課減免);
        }
    }
}
