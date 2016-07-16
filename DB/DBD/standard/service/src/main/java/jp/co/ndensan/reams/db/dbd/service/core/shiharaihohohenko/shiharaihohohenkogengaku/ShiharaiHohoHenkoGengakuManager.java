/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.shiharaihohohenkogengaku;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.ShiharaiHohoHenkoGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.meisai.ShiharaiHohoHenkoGengakuMeisai;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.shiharaihohohenko.ShiharaiHohoHenkoGengakuMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4025ShiharaiHohoHenkoGengakuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenko.IShiharaiHohoHenkoGengakuMapper;
import jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.shiharaihohohenkogengaku.meisai.ShiharaiHohoHenkoGengakuMeisaiManager;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更減額を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ShiharaiHohoHenkoGengakuManager {

    private final MapperProvider mapperProvider;
    private final DbT4025ShiharaiHohoHenkoGengakuDac 支払方法変更減額Dac;
    private final ShiharaiHohoHenkoGengakuMeisaiManager 支払方法変更減額明細Manager;

    /**
     * コンストラクタです。
     */
    ShiharaiHohoHenkoGengakuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.支払方法変更減額Dac = InstanceProvider.create(DbT4025ShiharaiHohoHenkoGengakuDac.class);
        this.支払方法変更減額明細Manager = new ShiharaiHohoHenkoGengakuMeisaiManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 支払方法変更減額Dac 支払方法変更減額Dac
     * @param 支払方法変更減額明細Manager 支払方法変更減額明細Manager
     */
    ShiharaiHohoHenkoGengakuManager(
            MapperProvider mapperProvider,
            DbT4025ShiharaiHohoHenkoGengakuDac 支払方法変更減額Dac,
            ShiharaiHohoHenkoGengakuMeisaiManager 支払方法変更減額明細Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.支払方法変更減額Dac = 支払方法変更減額Dac;
        this.支払方法変更減額明細Manager = 支払方法変更減額明細Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShiharaiHohoHenkoGengakuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShiharaiHohoHenkoGengakuManager}のインスタンス
     */
    public static ShiharaiHohoHenkoGengakuManager createInstance() {
        return InstanceProvider.create(ShiharaiHohoHenkoGengakuManager.class);
    }

    /**
     * 主キーに合致する支払方法変更減額を返します。
     *
     * @param 支払方法変更減額検索条件 支払方法変更減額検索条件
     * @return ShiharaiHohoHenkoGengaku 【　※ツールの都合上、このカッコ部は手動で削除して下さい 支払方法変更減額】 nullが返る可能性があります。
     */
    @Transaction
    public ShiharaiHohoHenkoGengaku get支払方法変更減額(ShiharaiHohoHenkoGengakuMapperParameter 支払方法変更減額検索条件) {
        requireNonNull(支払方法変更減額検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更減額検索条件"));
        IShiharaiHohoHenkoGengakuMapper mapper = mapperProvider.create(IShiharaiHohoHenkoGengakuMapper.class);

        ShiharaiHohoHenkoGengakuEntity relateEntity = mapper.select支払方法変更減額ByKey(支払方法変更減額検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShiharaiHohoHenkoGengaku(relateEntity);
    }

    /**
     * 支払方法変更減額{@link ShiharaiHohoHenkoGengaku}を保存します。
     *
     * @param 支払方法変更減額 支払方法変更減額
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ShiharaiHohoHenkoGengaku 支払方法変更減額) {
        requireNonNull(支払方法変更減額, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更減額"));

        if (!支払方法変更減額.hasChanged()) {
            return false;
        }
        支払方法変更減額 = 支払方法変更減額.modifiedModel();
        save支払方法変更減額明細リスト(支払方法変更減額.getShiharaiHohoHenkoGengakuMeisaiList());
        return 1 == 支払方法変更減額Dac.save(支払方法変更減額.toEntity());
    }

    private void save支払方法変更減額明細リスト(List<ShiharaiHohoHenkoGengakuMeisai> 支払方法変更減額明細List) {
        for (ShiharaiHohoHenkoGengakuMeisai 支払方法変更減額明細 : 支払方法変更減額明細List) {
            支払方法変更減額明細Manager.save(支払方法変更減額明細);
        }
    }
}
