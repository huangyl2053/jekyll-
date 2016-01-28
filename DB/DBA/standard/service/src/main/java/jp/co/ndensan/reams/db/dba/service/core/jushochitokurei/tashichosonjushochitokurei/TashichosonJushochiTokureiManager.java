/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jushochitokurei.tashichosonjushochitokurei;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.tashichosonjushochitokurei.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jushochitokurei.tashichosonjushochitokurei.TashichosonJushochiTokureiMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jushochitokurei.tashichosonjushochitokurei.TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.jushochitokurei.tashichosonjushochitokurei.ITashichosonJushochiTokureiMapper;
import jp.co.ndensan.reams.db.dba.service.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaishoManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 他市町村住所地特例を管理するクラスです。
 */
public class TashichosonJushochiTokureiManager {

    private final MapperProvider mapperProvider;
    private final DbT1003TashichosonJushochiTokureiDac 他市町村住所地特例Dac;
    private final ShisetsuNyutaishoManager 介護保険施設入退所Manager;

    /**
     * コンストラクタです。
     */
    TashichosonJushochiTokureiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.他市町村住所地特例Dac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
        this.介護保険施設入退所Manager = new ShisetsuNyutaishoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 他市町村住所地特例Dac 他市町村住所地特例Dac
     * @param 介護保険施設入退所Manager 介護保険施設入退所Manager
     */
    TashichosonJushochiTokureiManager(
            MapperProvider mapperProvider,
            DbT1003TashichosonJushochiTokureiDac 他市町村住所地特例Dac,
            ShisetsuNyutaishoManager 介護保険施設入退所Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.他市町村住所地特例Dac = 他市町村住所地特例Dac;
        this.介護保険施設入退所Manager = 介護保険施設入退所Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TashichosonJushochiTokureiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TashichosonJushochiTokureiManager}のインスタンス
     */
    public static TashichosonJushochiTokureiManager createInstance() {
        return InstanceProvider.create(TashichosonJushochiTokureiManager.class);
    }

    /**
     * 主キーに合致する他市町村住所地特例を返します。
     *
     * @param 他市町村住所地特例検索条件 他市町村住所地特例検索条件
     * @return TashichosonJushochiTokurei 【　※ツールの都合上、このカッコ部は手動で削除して下さい 他市町村住所地特例】 nullが返る可能性があります。
     */
    @Transaction
    public TashichosonJushochiTokurei get他市町村住所地特例(TashichosonJushochiTokureiMapperParameter 他市町村住所地特例検索条件) {
        requireNonNull(他市町村住所地特例検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例検索条件"));
        ITashichosonJushochiTokureiMapper mapper = mapperProvider.create(ITashichosonJushochiTokureiMapper.class);

        TashichosonJushochiTokureiEntity relateEntity = mapper.select他市町村住所地特例ByKey(他市町村住所地特例検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new TashichosonJushochiTokurei(relateEntity);
    }

    /**
     * 他市町村住所地特例{@link TashichosonJushochiTokurei}を保存します。
     *
     * @param 他市町村住所地特例 他市町村住所地特例
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(TashichosonJushochiTokurei 他市町村住所地特例) {
        requireNonNull(他市町村住所地特例, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例"));

        if (!他市町村住所地特例.hasChanged()) {
            return false;
        }
        他市町村住所地特例 = 他市町村住所地特例.modifiedModel();
        save介護保険施設入退所リスト(他市町村住所地特例.getShisetsuNyutaishoList());
        return 1 == 他市町村住所地特例Dac.save(他市町村住所地特例.toEntity());
    }

    private void save介護保険施設入退所リスト(List<ShisetsuNyutaisho> 介護保険施設入退所List) {
        for (ShisetsuNyutaisho 介護保険施設入退所 : 介護保険施設入退所List) {
            介護保険施設入退所Manager.save介護保険施設入退所(介護保険施設入退所);
        }
    }
}
