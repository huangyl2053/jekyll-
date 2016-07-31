/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.ShiharaiHohoHenkoGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTaino;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.shiharaihohohenko.ShiharaiHohoHenkoMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenko.IShiharaiHohoHenkoMapper;
import jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitomeManager;
import jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.shiharaihohohenkogengaku.ShiharaiHohoHenkoGengakuManager;
import jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTainoManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ShiharaiHohoHenkoManager {

    private final MapperProvider mapperProvider;
    private final DbT4021ShiharaiHohoHenkoDac 支払方法変更Dac;
    private final ShiharaiHohoHenkoTainoManager 支払方法変更滞納Manager;
    private final ShiharaiHohoHenkoSashitomeManager 支払方法変更差止Manager;
    private final ShiharaiHohoHenkoGengakuManager 支払方法変更減額Manager;

    /**
     * コンストラクタです。
     */
    ShiharaiHohoHenkoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.支払方法変更Dac = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
        this.支払方法変更滞納Manager = new ShiharaiHohoHenkoTainoManager();
        this.支払方法変更差止Manager = new ShiharaiHohoHenkoSashitomeManager();
        this.支払方法変更減額Manager = ShiharaiHohoHenkoGengakuManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 支払方法変更Dac 支払方法変更Dac
     * @param 支払方法変更滞納Manager 支払方法変更滞納Manager
     * @param 支払方法変更差止Manager 支払方法変更差止Manager
     * @param 支払方法変更減額Manager 支払方法変更減額Manager
     */
    ShiharaiHohoHenkoManager(
            MapperProvider mapperProvider,
            DbT4021ShiharaiHohoHenkoDac 支払方法変更Dac,
            ShiharaiHohoHenkoTainoManager 支払方法変更滞納Manager,
            ShiharaiHohoHenkoSashitomeManager 支払方法変更差止Manager,
            ShiharaiHohoHenkoGengakuManager 支払方法変更減額Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.支払方法変更Dac = 支払方法変更Dac;
        this.支払方法変更滞納Manager = 支払方法変更滞納Manager;
        this.支払方法変更差止Manager = 支払方法変更差止Manager;
        this.支払方法変更減額Manager = 支払方法変更減額Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShiharaiHohoHenkoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShiharaiHohoHenkoManager}のインスタンス
     */
    public static ShiharaiHohoHenkoManager createInstance() {
        return InstanceProvider.create(ShiharaiHohoHenkoManager.class);
    }

    /**
     * 主キーに合致する支払方法変更を返します。
     *
     * @param 支払方法変更検索条件 支払方法変更検索条件
     * @return ShiharaiHohoHenko 【　※ツールの都合上、このカッコ部は手動で削除して下さい 支払方法変更】 nullが返る可能性があります。
     */
    @Transaction
    public ShiharaiHohoHenko get支払方法変更(ShiharaiHohoHenkoMapperParameter 支払方法変更検索条件) {
        requireNonNull(支払方法変更検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更検索条件"));
        IShiharaiHohoHenkoMapper mapper = mapperProvider.create(IShiharaiHohoHenkoMapper.class);

        ShiharaiHohoHenkoEntity relateEntity = mapper.select支払方法変更ByKey(支払方法変更検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShiharaiHohoHenko(relateEntity);
    }

    /**
     * 支払方法変更{@link ShiharaiHohoHenko}を保存します。
     *
     * @param 支払方法変更 支払方法変更
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ShiharaiHohoHenko 支払方法変更) {
        requireNonNull(支払方法変更, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更"));

        if (!支払方法変更.hasChanged()) {
            return false;
        }
        支払方法変更 = 支払方法変更.modifiedModel();
        save支払方法変更滞納リスト(支払方法変更.getShiharaiHohoHenkoTainoList());
        save支払方法変更差止リスト(支払方法変更.getShiharaiHohoHenkoSashitomeList());
        save支払方法変更減額リスト(支払方法変更.getShiharaiHohoHenkoGengakuList());
        return 1 == 支払方法変更Dac.save(支払方法変更.toEntity());
    }

    private void save支払方法変更滞納リスト(List<ShiharaiHohoHenkoTaino> 支払方法変更滞納List) {
        for (ShiharaiHohoHenkoTaino 支払方法変更滞納 : 支払方法変更滞納List) {
            支払方法変更滞納Manager.save(支払方法変更滞納);
        }
    }

    private void save支払方法変更差止リスト(List<ShiharaiHohoHenkoSashitome> 支払方法変更差止List) {
        for (ShiharaiHohoHenkoSashitome 支払方法変更差止 : 支払方法変更差止List) {
            支払方法変更差止Manager.save(支払方法変更差止);
        }
    }

    private void save支払方法変更減額リスト(List<ShiharaiHohoHenkoGengaku> 支払方法変更減額List) {
        for (ShiharaiHohoHenkoGengaku 支払方法変更減額 : 支払方法変更減額List) {
            支払方法変更減額Manager.save(支払方法変更減額);
        }
    }
}
