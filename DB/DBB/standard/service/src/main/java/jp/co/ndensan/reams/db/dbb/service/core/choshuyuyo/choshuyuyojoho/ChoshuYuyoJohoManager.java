/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo.choshuyuyojoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.chochuyuyo.ChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choshuyuyojoho.ChoshuYuyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.ChoshuYuyoJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.ChoshuYuyoJohoRelateSonotaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.ChoshuYuyoJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choshuyuyo.IChoshuYuyoJohoRelateMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo.choshuyuyo.ChoshuYuyoManager;
import jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo.kibetsu.KibetsuManager;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 徴収猶予の情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 xicongwang
 */
public class ChoshuYuyoJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT2002FukaDac 介護賦課Dac;
    private final KibetsuManager 介護期別Manager;
    private final ChoshuYuyoManager 介護賦課徴収猶予Manager;

    private static final RString 検索条件 = new RString("徴収猶予の情報検索条件");

    /**
     * コンストラクタです。
     */
    ChoshuYuyoJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.介護期別Manager = KibetsuManager.createInstance();
        this.介護賦課徴収猶予Manager = ChoshuYuyoManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護賦課Dac 介護賦課Dac
     * @param 介護期別Manager 介護期別Manager
     * @param 介護賦課徴収猶予Manager 介護賦課徴収猶予Manager
     */
    ChoshuYuyoJohoManager(
            MapperProvider mapperProvider,
            DbT2002FukaDac 介護賦課Dac,
            KibetsuManager 介護期別Manager,
            ChoshuYuyoManager 介護賦課徴収猶予Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護賦課Dac = 介護賦課Dac;
        this.介護期別Manager = 介護期別Manager;
        this.介護賦課徴収猶予Manager = 介護賦課徴収猶予Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChoshuYuyoJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ChoshuYuyoJohoManager}のインスタンス
     */
    public static ChoshuYuyoJohoManager createInstance() {
        return InstanceProvider.create(ChoshuYuyoJohoManager.class);
    }

    /**
     * 主キーに合致する徴収猶予の情報を返します。
     *
     * @param 徴収猶予の情報検索条件 徴収猶予の情報検索条件
     * @return ChoshuYuyoJoho nullが返る可能性があります。
     */
    @Transaction
    public ChoshuYuyoJoho get徴収猶予の情報(ChoshuYuyoJohoRelateMapperParameter 徴収猶予の情報検索条件) {
        requireNonNull(徴収猶予の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(検索条件.toString()));
        IChoshuYuyoJohoRelateMapper mapper = mapperProvider.create(IChoshuYuyoJohoRelateMapper.class);

        ChoshuYuyoJohoRelateEntity relateEntity = mapper.select徴収猶予の情報ByKey(徴収猶予の情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ChoshuYuyoJoho(relateEntity);
    }

    /**
     * 主キーに合致する徴収猶予の情報を返します。
     *
     * @param 徴収猶予の情報検索条件 徴収猶予の情報検索条件
     * @return ChoshuYuyoJoho nullが返る可能性があります。
     */
    @Transaction
    public ChoshuYuyoJoho get徴収猶予の情報_決定更正後(ChoshuYuyoJohoRelateSonotaMapperParameter 徴収猶予の情報検索条件) {
        requireNonNull(徴収猶予の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(検索条件.toString()));
        IChoshuYuyoJohoRelateMapper mapper = mapperProvider.create(IChoshuYuyoJohoRelateMapper.class);

        ChoshuYuyoJohoRelateEntity relateEntity = mapper.select徴収猶予の情報_決定更正後(徴収猶予の情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ChoshuYuyoJoho(relateEntity);
    }

    /**
     * 主キーに合致する徴収猶予の情報を返します。
     *
     * @param 徴収猶予の情報検索条件 徴収猶予の情報検索条件
     * @return ChoshuYuyoJoho nullが返る可能性があります。
     */
    @Transaction
    public ChoshuYuyoJoho get徴収猶予の情報_取消更正後(ChoshuYuyoJohoRelateSonotaMapperParameter 徴収猶予の情報検索条件) {
        requireNonNull(徴収猶予の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(検索条件.toString()));
        IChoshuYuyoJohoRelateMapper mapper = mapperProvider.create(IChoshuYuyoJohoRelateMapper.class);

        ChoshuYuyoJohoRelateEntity relateEntity = mapper.select徴収猶予の情報_取消更正後(徴収猶予の情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ChoshuYuyoJoho(relateEntity);
    }

    /**
     * 主キーに合致する徴収猶予の情報を返します。
     *
     * @param 徴収猶予の情報検索条件 徴収猶予の情報検索条件
     * @return ChoshuYuyoJoho nullが返る可能性があります。
     */
    public ChoshuYuyoJoho select徴収猶予の情報_最新(ChoshuYuyoJohoRelateMapperParameter 徴収猶予の情報検索条件) {
        requireNonNull(徴収猶予の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(検索条件.toString()));
        IChoshuYuyoJohoRelateMapper mapper = mapperProvider.create(IChoshuYuyoJohoRelateMapper.class);
        ChoshuYuyoJohoRelateEntity relateEntity = mapper.select徴収猶予の情報_最新(徴収猶予の情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ChoshuYuyoJoho(relateEntity);
    }

    /**
     * 主キーに合致する徴収猶予の情報を返します。
     *
     * @param 徴収猶予の情報検索条件 徴収猶予の情報検索条件
     * @return ChoshuYuyoJoho nullが返る可能性があります。
     */
    public ChoshuYuyoJoho select最新の徴収猶予の情報(ChoshuYuyoJohoRelateMapperParameter 徴収猶予の情報検索条件) {
        requireNonNull(徴収猶予の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage(検索条件.toString()));
        IChoshuYuyoJohoRelateMapper mapper = mapperProvider.create(IChoshuYuyoJohoRelateMapper.class);
        ChoshuYuyoJohoRelateEntity relateEntity = mapper.select最新の徴収猶予の情報(徴収猶予の情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ChoshuYuyoJoho(relateEntity);
    }

    /**
     * 徴収猶予情報{@link ChoshuYuyoJoho}を保存します。
     *
     * @param 徴収猶予情報 徴収猶予情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ChoshuYuyoJoho 徴収猶予情報) {
        requireNonNull(徴収猶予情報, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予情報"));

        if (!徴収猶予情報.hasChanged()) {
            return false;
        }
        徴収猶予情報 = 徴収猶予情報.modifiedModel();
        save介護期別リスト(徴収猶予情報.getKibetsuList());
        save介護賦課徴収猶予リスト(徴収猶予情報.getChoshuYuyoList());
        return 1 == 介護賦課Dac.save(徴収猶予情報.toEntity());
    }

    private void save介護期別リスト(List<Kibetsu> 介護期別List) {
        for (Kibetsu 介護期別 : 介護期別List) {
            介護期別Manager.save介護期別(介護期別);
        }
    }

    private void save介護賦課徴収猶予リスト(List<ChoshuYuyo> 介護賦課徴収猶予List) {
        for (ChoshuYuyo 介護賦課徴収猶予 : 介護賦課徴収猶予List) {
            介護賦課徴収猶予Manager.save介護賦課徴収猶予(介護賦課徴収猶予);
        }
    }
}
