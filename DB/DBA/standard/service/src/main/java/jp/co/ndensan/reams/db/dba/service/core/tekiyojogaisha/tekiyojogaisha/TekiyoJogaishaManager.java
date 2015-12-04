/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha.tekiyojogaisha;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.tekiyojogaisha.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaisha.tekiyojogaisha.ITekiyoJogaishaMapper;
import jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha.shisetsunyutaisho.ShisetsuNyutaishoManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者を管理するクラスです。
 */
public class TekiyoJogaishaManager {

    private final MapperProvider mapperProvider;
    private final DbT1002TekiyoJogaishaDac 適用除外者Dac;
    private final ShisetsuNyutaishoManager 介護保険施設入退所Manager;

    /**
     * コンストラクタです。
     */
    TekiyoJogaishaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.適用除外者Dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
        this.介護保険施設入退所Manager = new ShisetsuNyutaishoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 適用除外者Dac 適用除外者Dac
     * @param 介護保険施設入退所Manager 介護保険施設入退所Manager
     */
    TekiyoJogaishaManager(
            MapperProvider mapperProvider,
            DbT1002TekiyoJogaishaDac 適用除外者Dac,
            ShisetsuNyutaishoManager 介護保険施設入退所Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.適用除外者Dac = 適用除外者Dac;
        this.介護保険施設入退所Manager = 介護保険施設入退所Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaManager}のインスタンス
     */
    public static TekiyoJogaishaManager createInstance() {
        return InstanceProvider.create(TekiyoJogaishaManager.class);
    }

    /**
     * 主キーに合致する適用除外者を返します。
     *
     * @param 適用除外者検索条件 適用除外者検索条件
     * @return TekiyoJogaisha nullが返る可能性があります。
     */
    @Transaction
    public TekiyoJogaisha get適用除外者(TekiyoJogaishaMapperParameter 適用除外者検索条件) {
        requireNonNull(適用除外者検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外者検索条件"));
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);

        TekiyoJogaishaEntity relateEntity = mapper.select適用除外者ByKey(適用除外者検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new TekiyoJogaisha(relateEntity);
    }

    /**
     * 適用除外者{@link TekiyoJogaisha}を保存します。
     *
     * @param 適用除外者 適用除外者
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(TekiyoJogaisha 適用除外者) {
        requireNonNull(適用除外者, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外者"));

        if (!適用除外者.hasChanged()) {
            return false;
        }
        適用除外者 = 適用除外者.modifiedModel();
        save介護保険施設入退所リスト(適用除外者.getSeishinTechoNiniList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 適用除外者Dac.save(適用除外者.toEntity());
    }

    private void save介護保険施設入退所リスト(List<ShisetsuNyutaisho> 介護保険施設入退所List) {
        for (ShisetsuNyutaisho 介護保険施設入退所 : 介護保険施設入退所List) {
            介護保険施設入退所Manager.save介護保険施設入退所(介護保険施設入退所);
        }
    }
}
