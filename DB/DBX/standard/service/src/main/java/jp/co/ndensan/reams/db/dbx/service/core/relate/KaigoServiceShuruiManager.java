/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.relate.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.relate.KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.relate.IKaigoServiceShuruiMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoServiceNaiyouManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス種類を管理するクラスです。
 */
public class KaigoServiceShuruiManager {

    private final MapperProvider mapperProvider;
    private final DbT7130KaigoServiceShuruiDac 介護サービス種類Dac;
    private final KaigoServiceNaiyouManager 介護サービス内容Manager;

    /**
     * コンストラクタです。
     */
    KaigoServiceShuruiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護サービス種類Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        this.介護サービス内容Manager = new KaigoServiceNaiyouManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護サービス種類Dac 介護サービス種類Dac
     * @param 介護サービス内容Manager 介護サービス内容Manager
     */
    KaigoServiceShuruiManager(
            MapperProvider mapperProvider,
            DbT7130KaigoServiceShuruiDac 介護サービス種類Dac,
            KaigoServiceNaiyouManager 介護サービス内容Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護サービス種類Dac = 介護サービス種類Dac;
        this.介護サービス内容Manager = 介護サービス内容Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoServiceShuruiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KaigoServiceShuruiManager}のインスタンス
     */
    public static KaigoServiceShuruiManager createInstance() {
        return InstanceProvider.create(KaigoServiceShuruiManager.class);
    }

    /**
     * 主キーに合致する介護サービス種類を返します。
     *
     * @param 介護サービス種類検索条件 介護サービス種類検索条件
     * @return KaigoServiceShurui 【　※ツールの都合上、このカッコ部は手動で削除して下さい 介護サービス種類】
     * nullが返る可能性があります。
     */
    @Transaction
    public KaigoServiceShurui get介護サービス種類(KaigoServiceShuruiMapperParameter 介護サービス種類検索条件) {
        requireNonNull(介護サービス種類検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類検索条件"));
        IKaigoServiceShuruiMapper mapper = mapperProvider.create(IKaigoServiceShuruiMapper.class);

        KaigoServiceShuruiEntity relateEntity = mapper.select介護サービス種類ByKey(介護サービス種類検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new KaigoServiceShurui(relateEntity.get介護サービス種類Entity());
    }

    /**
     * 主キー1に合致する介護サービス種類のリストを返します。
     *
     * @param 介護サービス種類検索条件 介護サービス種類検索条件
     * @return KaigoServiceShuruiの{@code list}
     */
    @Transaction
    public List<KaigoServiceShurui> get介護サービス種類リストBy主キー1(KaigoServiceShuruiMapperParameter 介護サービス種類検索条件) {
        requireNonNull(介護サービス種類検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類検索条件"));
        IKaigoServiceShuruiMapper mapper = mapperProvider.create(IKaigoServiceShuruiMapper.class);

        List<KaigoServiceShuruiEntity> relateEntityList = mapper.select介護サービス種類リストBy主キー1(介護サービス種類検索条件);

        ArrayList<KaigoServiceShurui> 介護サービス種類List = new ArrayList<>();
        for (KaigoServiceShuruiEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            介護サービス種類List.add(new KaigoServiceShurui(relateEntity.get介護サービス種類Entity()));
        }
        return 介護サービス種類List;

    }

    /**
     * 要介護認定申請情報{@link KaigoServiceShurui}を保存します。
     *
     * @param 介護サービス種類 介護サービス種類
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(KaigoServiceShurui 介護サービス種類) {
        requireNonNull(介護サービス種類, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類"));

        if (!介護サービス種類.hasChanged()) {
            return false;
        }
        介護サービス種類 = 介護サービス種類.modifiedModel();
        save介護サービス内容リスト(介護サービス種類.getKaigoServiceNaiyouList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 介護サービス種類Dac.save(介護サービス種類.toEntity());
    }

    private void save介護サービス内容リスト(List<KaigoServiceNaiyou> 介護サービス内容List) {
        for (KaigoServiceNaiyou 介護サービス内容 : 介護サービス内容List) {
            介護サービス内容Manager.save介護サービス内容(介護サービス内容);
        }
    }
}
