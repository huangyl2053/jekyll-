/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeiNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitate;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.FufukuMoshitateMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.FufukuMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7001FufukuMoshitateDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.fufukumoshitate.IFufukuMoshitateMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 不服審査申立情報を管理するクラスです。
 */
public class FufukuMoshitateManager {

    private final MapperProvider mapperProvider;
    private final DbT7001FufukuMoshitateDac 不服審査申立情報Dac;
    private final BemmeiNaiyoManager 弁明内容Manager;

    /**
     * コンストラクタです。
     */
    FufukuMoshitateManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.不服審査申立情報Dac = InstanceProvider.create(DbT7001FufukuMoshitateDac.class);
        this.弁明内容Manager = new BemmeiNaiyoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 不服審査申立情報Dac 不服審査申立情報Dac
     * @param 弁明内容Manager 弁明内容Manager
     */
    FufukuMoshitateManager(
            MapperProvider mapperProvider,
            DbT7001FufukuMoshitateDac 不服審査申立情報Dac,
            BemmeiNaiyoManager 弁明内容Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.不服審査申立情報Dac = 不服審査申立情報Dac;
        this.弁明内容Manager = 弁明内容Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FufukuMoshitateManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link FufukuMoshitateManager}のインスタンス
     */
    public static FufukuMoshitateManager createInstance() {
        return InstanceProvider.create(FufukuMoshitateManager.class);
    }

    /**
     * 主キーに合致する不服審査申立情報を返します。
     *
     * @param 不服審査申立情報検索条件 不服審査申立情報検索条件
     * @return FufukuMoshitate 【　※ツールの都合上、このカッコ部は手動で削除して下さい 不服審査申立情報】
     * nullが返る可能性があります。
     */
    @Transaction
    public FufukuMoshitate get不服審査申立情報(FufukuMoshitateMapperParameter 不服審査申立情報検索条件) {
        requireNonNull(不服審査申立情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("不服審査申立情報検索条件"));
        IFufukuMoshitateMapper mapper = mapperProvider.create(IFufukuMoshitateMapper.class);

        FufukuMoshitateEntity relateEntity = mapper.select不服審査申立情報ByKey(不服審査申立情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new FufukuMoshitate(relateEntity.get不服審査申立情報Entity());
    }

    /**
     * 主キー1に合致する不服審査申立情報のリストを返します。
     *
     * @param 不服審査申立情報検索条件 不服審査申立情報検索条件
     * @return FufukuMoshitateの{@code list}
     */
    @Transaction
    public List<FufukuMoshitate> get不服審査申立情報リストBy主キー1(FufukuMoshitateMapperParameter 不服審査申立情報検索条件) {
        requireNonNull(不服審査申立情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("不服審査申立情報検索条件"));
        IFufukuMoshitateMapper mapper = mapperProvider.create(IFufukuMoshitateMapper.class);

        List<FufukuMoshitateEntity> relateEntityList = mapper.select不服審査申立情報リストBy主キー1(不服審査申立情報検索条件);

        ArrayList<FufukuMoshitate> 不服審査申立情報List = new ArrayList<>();
        for (FufukuMoshitateEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            不服審査申立情報List.add(new FufukuMoshitate(relateEntity.get不服審査申立情報Entity()));
        }
        return 不服審査申立情報List;

    }

    /**
     * 要介護認定申請情報（子）{@link FufukuMoshitate}を保存します。
     *
     * @param 不服審査申立情報 不服審査申立情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(FufukuMoshitate 不服審査申立情報) {
        requireNonNull(不服審査申立情報, UrSystemErrorMessages.値がnull.getReplacedMessage("不服審査申立情報"));

        if (!不服審査申立情報.hasChanged()) {
            return false;
        }
        不服審査申立情報 = 不服審査申立情報.modifiedModel();
        save弁明内容リスト(不服審査申立情報.getBemmeiNaiyoList());  // XXXは本メソッドの引数に変更してください。
        return 1 == 不服審査申立情報Dac.save(不服審査申立情報.toEntity());
    }

    private void save弁明内容リスト(List<BemmeiNaiyo> 弁明内容List) {
        for (BemmeiNaiyo 弁明内容 : 弁明内容List) {
            弁明内容Manager.save(弁明内容);
        }
    }
}
