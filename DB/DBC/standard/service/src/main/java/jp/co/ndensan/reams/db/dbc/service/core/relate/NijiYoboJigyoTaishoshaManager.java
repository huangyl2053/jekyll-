/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboKihonCheckList;
import jp.co.ndensan.reams.db.dbc.definition.mybatis.param.relate.NijiYoboJigyoTaishoshaMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.relate.NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3100NijiYoboJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.relate.INijiYoboJigyoTaishoshaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 二次予防事業対象者を管理するクラスです。
 */
public class NijiYoboJigyoTaishoshaManager {

    private final MapperProvider mapperProvider;
    private final DbT3100NijiYoboJigyoTaishoshaDac 二次予防事業対象者Dac;
    private final NijiYoboKihonCheckListManager 二次予防基本チェックリストManager;

    /**
     * コンストラクタです。
     */
    NijiYoboJigyoTaishoshaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.二次予防事業対象者Dac = InstanceProvider.create(DbT3100NijiYoboJigyoTaishoshaDac.class);
        this.二次予防基本チェックリストManager = new NijiYoboKihonCheckListManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 二次予防事業対象者Dac 二次予防事業対象者Dac
     * @param 二次予防基本チェックリストManager 二次予防基本チェックリストManager
     */
    NijiYoboJigyoTaishoshaManager(
            MapperProvider mapperProvider,
            DbT3100NijiYoboJigyoTaishoshaDac 二次予防事業対象者Dac,
            NijiYoboKihonCheckListManager 二次予防基本チェックリストManager
    ) {
        this.mapperProvider = mapperProvider;
        this.二次予防事業対象者Dac = 二次予防事業対象者Dac;
        this.二次予防基本チェックリストManager = 二次予防基本チェックリストManager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NijiYoboJigyoTaishoshaManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NijiYoboJigyoTaishoshaManager}のインスタンス
     */
    public static NijiYoboJigyoTaishoshaManager createInstance() {
        return InstanceProvider.create(NijiYoboJigyoTaishoshaManager.class);
    }

    /**
     * 主キーに合致する二次予防事業対象者を返します。
     *
     * @param 二次予防事業対象者検索条件 二次予防事業対象者検索条件
     * @return NijiYoboJigyoTaishosha nullが返る可能性があります。
     */
    @Transaction
    public NijiYoboJigyoTaishosha get二次予防事業対象者(NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件) {
        requireNonNull(二次予防事業対象者検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業対象者検索条件"));
        INijiYoboJigyoTaishoshaMapper mapper = mapperProvider.create(INijiYoboJigyoTaishoshaMapper.class);

        NijiYoboJigyoTaishoshaEntity relateEntity = mapper.select二次予防事業対象者ByKey(二次予防事業対象者検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new NijiYoboJigyoTaishosha(relateEntity.get二次予防事業対象者Entity());
    }

    /**
     * 主キー1に合致する二次予防事業対象者のリストを返します。
     *
     * @param 二次予防事業対象者検索条件 二次予防事業対象者検索条件
     * @return NijiYoboJigyoTaishoshaの{@code list}
     */
    @Transaction
    public List<NijiYoboJigyoTaishosha> get二次予防事業対象者リストBy主キー1(NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件) {
        requireNonNull(二次予防事業対象者検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業対象者検索条件"));
        INijiYoboJigyoTaishoshaMapper mapper = mapperProvider.create(INijiYoboJigyoTaishoshaMapper.class);

        List<NijiYoboJigyoTaishoshaEntity> relateEntityList = mapper.select二次予防事業対象者リストBy主キー1(二次予防事業対象者検索条件);

        ArrayList<NijiYoboJigyoTaishosha> 二次予防事業対象者List = new ArrayList<>();
        for (NijiYoboJigyoTaishoshaEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            二次予防事業対象者List.add(new NijiYoboJigyoTaishosha(relateEntity.get二次予防事業対象者Entity()));
        }
        return 二次予防事業対象者List;

    }

    /**
     * 二次予防事業対象者{@link NijiYoboJigyoTaishosha}を保存します。
     *
     * @param 二次予防事業対象者 二次予防事業対象者
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(NijiYoboJigyoTaishosha 二次予防事業対象者) {
        requireNonNull(二次予防事業対象者, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業対象者"));

        if (!二次予防事業対象者.hasChanged()) {
            return false;
        }
        二次予防事業対象者 = 二次予防事業対象者.modifiedModel();
        save二次予防基本チェックリストリスト(二次予防事業対象者.getNijiYoboKihonCheckListList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 二次予防事業対象者Dac.save(二次予防事業対象者.toEntity());
    }

    private void save二次予防基本チェックリストリスト(List<NijiYoboKihonCheckList> 二次予防基本チェックリストList) {
        for (NijiYoboKihonCheckList 二次予防基本チェックリスト : 二次予防基本チェックリストList) {
            二次予防基本チェックリストManager.save(二次予防基本チェックリスト);
        }
    }
}
