/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.ChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.KibetsuChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.ChoshuYuyoMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2006ChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choshuyuyo.IChoshuYuyoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課徴収猶予を管理するクラスです。
 */
public class ChoshuYuyoManager {

    private final MapperProvider mapperProvider;
    private final DbT2006ChoshuYuyoDac 介護賦課徴収猶予Dac;
    private final KibetsuChoshuYuyoManager 介護期別徴収猶予Manager;

    /**
     * コンストラクタです。
     */
    ChoshuYuyoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護賦課徴収猶予Dac = InstanceProvider.create(DbT2006ChoshuYuyoDac.class);
        this.介護期別徴収猶予Manager = new KibetsuChoshuYuyoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護賦課徴収猶予Dac 介護賦課徴収猶予Dac
     * @param 介護期別徴収猶予Manager 介護期別徴収猶予Manager
     */
    ChoshuYuyoManager(
            MapperProvider mapperProvider,
            DbT2006ChoshuYuyoDac 介護賦課徴収猶予Dac,
            KibetsuChoshuYuyoManager 介護期別徴収猶予Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護賦課徴収猶予Dac = 介護賦課徴収猶予Dac;
        this.介護期別徴収猶予Manager = 介護期別徴収猶予Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChoshuYuyoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ChoshuYuyoManager}のインスタンス
     */
    public static ChoshuYuyoManager createInstance() {
        return InstanceProvider.create(ChoshuYuyoManager.class);
    }

    /**
     * 主キーに合致する介護賦課徴収猶予を返します。
     *
     * @param 介護賦課徴収猶予検索条件 介護賦課徴収猶予検索条件
     * @return ChoshuYuyo nullが返る可能性があります。
     */
    @Transaction
    public ChoshuYuyo get介護賦課徴収猶予(ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件) {
        requireNonNull(介護賦課徴収猶予検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課徴収猶予検索条件"));
        IChoshuYuyoMapper mapper = mapperProvider.create(IChoshuYuyoMapper.class);

        ChoshuYuyoEntity relateEntity = mapper.getChoshuyuyoEntity(介護賦課徴収猶予検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ChoshuYuyo(relateEntity);
    }

    /**
     * 介護賦課徴収猶予{@link ChoshuYuyo}を保存します。
     *
     * @param 介護賦課徴収猶予 介護賦課徴収猶予
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ChoshuYuyo 介護賦課徴収猶予) {
        requireNonNull(介護賦課徴収猶予, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課徴収猶予"));

        if (!介護賦課徴収猶予.hasChanged()) {
            return false;
        }
        介護賦課徴収猶予 = 介護賦課徴収猶予.modifiedModel();
        save介護期別徴収猶予リスト(介護賦課徴収猶予.getKibetsuChoshuYuyoList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 介護賦課徴収猶予Dac.save(介護賦課徴収猶予.toEntity());
    }

    private void save介護期別徴収猶予リスト(List<KibetsuChoshuYuyo> 介護期別徴収猶予List) {
        for (KibetsuChoshuYuyo 介護期別徴収猶予 : 介護期別徴収猶予List) {
            介護期別徴収猶予Manager.save介護期別徴収猶予(介護期別徴収猶予);
        }
    }
}
