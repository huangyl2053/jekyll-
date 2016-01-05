/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyokihonchosa;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScore;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5203NinteichosahyoKihonChosaDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahyo.ninteichosahyokihonchosa.INinteichosahyoKihonChosaMapper;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItemManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScoreManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（基本調査）を管理するクラスです。
 */
public class NinteichosahyoKihonChosaManager {

    private final MapperProvider mapperProvider;
    private final DbT5203NinteichosahyoKihonChosaDac 認定調査票_基本調査Dac;
    private final NinteichosahyoChosaItemManager 認定調査票_基本調査_調査項目Manager;
    private final NinteichosahyoKihonChosaScoreManager 認定調査票_基本調査素点Manager;

    /**
     * コンストラクタです。
     */
    NinteichosahyoKihonChosaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.認定調査票_基本調査Dac = InstanceProvider.create(DbT5203NinteichosahyoKihonChosaDac.class);
        this.認定調査票_基本調査_調査項目Manager = new NinteichosahyoChosaItemManager();
        this.認定調査票_基本調査素点Manager = NinteichosahyoKihonChosaScoreManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 認定調査票（基本調査）Dac 認定調査票（基本調査）Dac
     * @param 認定調査票（基本調査）調査項目Manager 認定調査票（基本調査）調査項目Manager
     * @param 認定調査票（基本調査素点）Manager 認定調査票（基本調査素点）Manager
     */
    NinteichosahyoKihonChosaManager(
            MapperProvider mapperProvider,
            DbT5203NinteichosahyoKihonChosaDac 認定調査票_基本調査Dac,
            NinteichosahyoChosaItemManager 認定調査票_基本調査_調査項目Manager,
            NinteichosahyoKihonChosaScoreManager 認定調査票_基本調査素点Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.認定調査票_基本調査Dac = 認定調査票_基本調査Dac;
        this.認定調査票_基本調査_調査項目Manager = 認定調査票_基本調査_調査項目Manager;
        this.認定調査票_基本調査素点Manager = 認定調査票_基本調査素点Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoKihonChosaManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoKihonChosaManager}のインスタンス
     */
    public static NinteichosahyoKihonChosaManager createInstance() {
        return InstanceProvider.create(NinteichosahyoKihonChosaManager.class);
    }

    /**
     * 主キーに合致する認定調査票（基本調査）を返します。
     *
     * @param 認定調査票_基本調査_検索条件 認定調査票_基本調査_検索条件
     * @return NinteichosahyoKihonChosa nullが返る可能性があります。
     */
    @Transaction
    public NinteichosahyoKihonChosa get認定調査票_基本調査(NinteichosahyoKihonChosaMapperParameter 認定調査票_基本調査_検索条件) {
        requireNonNull(認定調査票_基本調査_検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査）検索条件"));
        INinteichosahyoKihonChosaMapper mapper = mapperProvider.create(INinteichosahyoKihonChosaMapper.class);

        NinteichosahyoKihonChosaEntity relateEntity = mapper.select認定調査票_基本調査ByKey(認定調査票_基本調査_検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new NinteichosahyoKihonChosa(relateEntity);
    }

    /**
     * 主キー1に合致する認定調査票（基本調査）のリストを返します。
     *
     * @param 認定調査票_基本調査_検索条件 認定調査票_基本調査_検索条件
     * @return NinteichosahyoKihonChosaの{@code list}
     */
    @Transaction
    public List<NinteichosahyoKihonChosa> get認定調査票_基本調査リストBy主キー1(NinteichosahyoKihonChosaMapperParameter 認定調査票_基本調査_検索条件) {
        requireNonNull(認定調査票_基本調査_検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査）検索条件")
        );
        INinteichosahyoKihonChosaMapper mapper = mapperProvider.create(INinteichosahyoKihonChosaMapper.class);

        List<NinteichosahyoKihonChosaEntity> relateEntityList = mapper.select認定調査票_基本調査リストBy主キー1(認定調査票_基本調査_検索条件);

        ArrayList<NinteichosahyoKihonChosa> 認定調査票_基本調査List = new ArrayList<>();
        for (NinteichosahyoKihonChosaEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            認定調査票_基本調査List.add(new NinteichosahyoKihonChosa(relateEntity));
        }
        return 認定調査票_基本調査List;

    }

    /**
     * 認定調査票（基本調査）{@link NinteichosahyoKihonChosa}を保存します。
     *
     * @param 認定調査票_基本調査 認定調査票_基本調査
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(NinteichosahyoKihonChosa 認定調査票_基本調査) {
        requireNonNull(認定調査票_基本調査, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査）")
        );

        if (!認定調査票_基本調査.hasChanged()) {
            return false;
        }
        認定調査票_基本調査 = 認定調査票_基本調査.modifiedModel();
        save認定調査票_基本調査_調査項目リスト(認定調査票_基本調査.getNinteichosahyoChosaItemList());
        save認定調査票_基本調査素点リスト(認定調査票_基本調査.getNinteichosahyoKihonChosaScoreList());
        return 1 == 認定調査票_基本調査Dac.save(認定調査票_基本調査.toEntity());
    }

    private void save認定調査票_基本調査_調査項目リスト(List<NinteichosahyoChosaItem> 認定調査票_基本調査_調査項目List) {
        for (NinteichosahyoChosaItem 認定調査票_基本調査_調査項目 : 認定調査票_基本調査_調査項目List) {
            認定調査票_基本調査_調査項目Manager.save認定調査票_基本調査_調査項目(認定調査票_基本調査_調査項目);
        }
    }

    private void save認定調査票_基本調査素点リスト(List<NinteichosahyoKihonChosaScore> 認定調査票_基本調査素点List) {
        for (NinteichosahyoKihonChosaScore 認定調査票_基本調査素点 : 認定調査票_基本調査素点List) {
            認定調査票_基本調査素点Manager.save(認定調査票_基本調査素点);
        }
    }
}
