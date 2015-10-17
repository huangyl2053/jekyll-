/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeiNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeishaJoho;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.BemmeiNaiyoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.BemmeiNaiyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7002BemmeiNaiyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.IBemmeiNaiyoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.BemmeishaJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 弁明内容を管理するクラスです。
 */
public class BemmeiNaiyoManager {

    private final MapperProvider mapperProvider;
    private final DbT7002BemmeiNaiyoDac 弁明内容Dac;
    private final BemmeishaJohoManager 弁明者情報Manager;

    /**
     * コンストラクタです。
     */
    BemmeiNaiyoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.弁明内容Dac = InstanceProvider.create(DbT7002BemmeiNaiyoDac.class);
        this.弁明者情報Manager = new BemmeishaJohoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 弁明内容Dac 弁明内容Dac
     * @param 弁明者情報Manager 弁明者情報Manager
     */
    BemmeiNaiyoManager(
            MapperProvider mapperProvider,
            DbT7002BemmeiNaiyoDac 弁明内容Dac,
            BemmeishaJohoManager 弁明者情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.弁明内容Dac = 弁明内容Dac;
        this.弁明者情報Manager = 弁明者情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link BemmeiNaiyoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link BemmeiNaiyoManager}のインスタンス
     */
    public static BemmeiNaiyoManager createInstance() {
        return InstanceProvider.create(BemmeiNaiyoManager.class);
    }

    /**
     * 主キーに合致する弁明内容を返します。
     *
     * @param 弁明内容検索条件 弁明内容検索条件
     * @return BemmeiNaiyo 【　※ツールの都合上、このカッコ部は手動で削除して下さい 弁明内容】 nullが返る可能性があります。
     */
    @Transaction
    public BemmeiNaiyo get弁明内容(BemmeiNaiyoMapperParameter 弁明内容検索条件) {
        requireNonNull(弁明内容検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明内容検索条件"));
        IBemmeiNaiyoMapper mapper = mapperProvider.create(IBemmeiNaiyoMapper.class);

        BemmeiNaiyoEntity relateEntity = mapper.select弁明内容ByKey(弁明内容検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new BemmeiNaiyo(relateEntity.get弁明内容Entity());
    }

    /**
     * 主キー1に合致する弁明内容のリストを返します。
     *
     * @param 弁明内容検索条件 弁明内容検索条件
     * @return BemmeiNaiyoの{@code list}
     */
    @Transaction
    public List<BemmeiNaiyo> get弁明内容リストBy主キー1(BemmeiNaiyoMapperParameter 弁明内容検索条件) {
        requireNonNull(弁明内容検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明内容検索条件"));
        IBemmeiNaiyoMapper mapper = mapperProvider.create(IBemmeiNaiyoMapper.class);

        List<BemmeiNaiyoEntity> relateEntityList = mapper.select弁明内容リストBy主キー1(弁明内容検索条件);

        ArrayList<BemmeiNaiyo> 弁明内容List = new ArrayList<>();
        for (BemmeiNaiyoEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            弁明内容List.add(new BemmeiNaiyo(relateEntity.get弁明内容Entity()));
        }
        return 弁明内容List;

    }

    /**
     * 認定調査票（概況調査）{@link BemmeiNaiyo}を保存します。
     *
     * @param 弁明内容 弁明内容
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(BemmeiNaiyo 弁明内容) {
        requireNonNull(弁明内容, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明内容"));

        if (!弁明内容.hasChanged()) {
            return false;
        }
        弁明内容 = 弁明内容.modifiedModel();
        save弁明者情報リスト(弁明内容.getBemmeishaJohoList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 弁明内容Dac.save(弁明内容.toEntity());
    }

    private void save弁明者情報リスト(List<BemmeishaJoho> 弁明者情報List) {
        for (BemmeishaJoho 弁明者情報 : 弁明者情報List) {
            弁明者情報Manager.save弁明者情報(弁明者情報);
        }
    }
}
