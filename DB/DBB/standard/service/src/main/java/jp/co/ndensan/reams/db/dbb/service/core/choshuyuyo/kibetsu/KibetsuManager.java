/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo.kibetsu;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.KibetsuMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choshuyuyo.IKibetsuMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo.choteikyotsu.ChoteiKyotsuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護期別を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class KibetsuManager {

    private final MapperProvider mapperProvider;
    private final DbT2003KibetsuDac 介護期別Dac;
    private final ChoteiKyotsuManager 調定共通Manager;

    /**
     * コンストラクタです。
     */
    KibetsuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護期別Dac = InstanceProvider.create(DbT2003KibetsuDac.class);
        this.調定共通Manager = new ChoteiKyotsuManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護期別Dac 介護期別Dac
     * @param 調定共通Manager 調定共通Manager
     */
    KibetsuManager(
            MapperProvider mapperProvider,
            DbT2003KibetsuDac 介護期別Dac,
            ChoteiKyotsuManager 調定共通Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護期別Dac = 介護期別Dac;
        this.調定共通Manager = 調定共通Manager;
    }

    /**
     * 主キーに合致する介護期別情報を返します。
     *
     * @param 介護期別検索条件 KibetsuMapperParameter
     * @return Kibetsu nullが返る可能性があります。
     */
    @Transaction
    public Kibetsu get介護期別情報(KibetsuMapperParameter 介護期別検索条件) {
        requireNonNull(介護期別検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課の情報検索条件"));
        IKibetsuMapper mapper = mapperProvider.create(IKibetsuMapper.class);

        KibetsuEntity relateEntity = mapper.select介護期別ByKey(介護期別検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new Kibetsu(relateEntity);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KibetsuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KibetsuManager}のインスタンス
     */
    public static KibetsuManager createInstance() {
        return InstanceProvider.create(KibetsuManager.class);
    }

    /**
     * 介護期別{@link Kibetsu}を保存します。
     *
     * @param 介護期別 介護期別
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save介護期別(Kibetsu 介護期別) {
        requireNonNull(介護期別, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別"));

        if (!介護期別.hasChanged()) {
            return false;
        }
        介護期別 = 介護期別.modifiedModel();
        save調定共通リスト(介護期別.getChoteiKyotsuList());

        return 1 == 介護期別Dac.save(介護期別.toEntity());
    }

    private void save調定共通リスト(List<ChoteiKyotsu> 調定共通List) {
        for (ChoteiKyotsu 調定共通 : 調定共通List) {
            調定共通Manager.save調定共通(調定共通);
        }
    }
}
