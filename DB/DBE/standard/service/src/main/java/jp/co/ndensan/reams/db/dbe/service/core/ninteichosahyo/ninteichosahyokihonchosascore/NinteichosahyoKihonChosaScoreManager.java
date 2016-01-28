/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyokihonchosascore;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScore;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascoreitem.NinteichosahyoKihonChosaScoreItem;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScoreMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5204NinteichosahyoKihonChosaScoreDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahyo.ninteichosahyokihonchosascore.INinteichosahyoKihonChosaScoreMapper;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyokihonchosascoreitem.NinteichosahyoKihonChosaScoreItemManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（基本調査素点）を管理するクラスです。
 */
public class NinteichosahyoKihonChosaScoreManager {

    private final MapperProvider mapperProvider;
    private final DbT5204NinteichosahyoKihonChosaScoreDac 認定調査票_基本調査素点Dac;
    private final NinteichosahyoKihonChosaScoreItemManager 認定調査票_基本調査素点項目Manager;

    /**
     * コンストラクタです。
     */
    NinteichosahyoKihonChosaScoreManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.認定調査票_基本調査素点Dac = InstanceProvider.create(DbT5204NinteichosahyoKihonChosaScoreDac.class);
        this.認定調査票_基本調査素点項目Manager = new NinteichosahyoKihonChosaScoreItemManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 認定調査票_基本調査素点Dac 認定調査票_基本調査素点Dac
     * @param 認定調査票_基本調査素点項目Manager 認定調査票_基本調査素点項目Manager
     */
    NinteichosahyoKihonChosaScoreManager(
            MapperProvider mapperProvider,
            DbT5204NinteichosahyoKihonChosaScoreDac 認定調査票_基本調査素点Dac,
            NinteichosahyoKihonChosaScoreItemManager 認定調査票_基本調査素点項目Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.認定調査票_基本調査素点Dac = 認定調査票_基本調査素点Dac;
        this.認定調査票_基本調査素点項目Manager = 認定調査票_基本調査素点項目Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoKihonChosaScoreManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoKihonChosaScoreManager}のインスタンス
     */
    public static NinteichosahyoKihonChosaScoreManager createInstance() {
        return InstanceProvider.create(NinteichosahyoKihonChosaScoreManager.class);
    }

    /**
     * 主キーに合致する認定調査票（基本調査素点）を返します。
     *
     * @param 認定調査票_基本調査素点_検索条件 認定調査票_基本調査素点_検索条件
     * @return NinteichosahyoKihonChosaScore nullが返る可能性があります。
     */
    @Transaction
    public NinteichosahyoKihonChosaScore get認定調査票_基本調査素点(NinteichosahyoKihonChosaScoreMapperParameter 認定調査票_基本調査素点_検索条件) {
        requireNonNull(認定調査票_基本調査素点_検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査素点）検索条件"));
        INinteichosahyoKihonChosaScoreMapper mapper = mapperProvider.create(INinteichosahyoKihonChosaScoreMapper.class);

        NinteichosahyoKihonChosaScoreEntity relateEntity = mapper.select認定調査票_基本調査素点ByKey(認定調査票_基本調査素点_検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new NinteichosahyoKihonChosaScore(relateEntity);
    }

    /**
     * 主キー1に合致する認定調査票（基本調査素点）のリストを返します。
     *
     * @param 認定調査票_基本調査素点_検索条件 認定調査票_基本調査素点_検索条件
     * @return NinteichosahyoKihonChosaScoreの{@code list}
     */
    @Transaction
    public List<NinteichosahyoKihonChosaScore> get認定調査票_基本調査素点_リストBy主キー1(NinteichosahyoKihonChosaScoreMapperParameter 認定調査票_基本調査素点_検索条件) {
        requireNonNull(認定調査票_基本調査素点_検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査素点）検索条件")
        );
        INinteichosahyoKihonChosaScoreMapper mapper = mapperProvider.create(INinteichosahyoKihonChosaScoreMapper.class);

        List<NinteichosahyoKihonChosaScoreEntity> relateEntityList = mapper.select認定調査票_基本調査素点リストBy主キー1(認定調査票_基本調査素点_検索条件);

        ArrayList<NinteichosahyoKihonChosaScore> 認定調査票_基本調査素点List = new ArrayList<>();
        for (NinteichosahyoKihonChosaScoreEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            認定調査票_基本調査素点List.add(new NinteichosahyoKihonChosaScore(relateEntity));
        }
        return 認定調査票_基本調査素点List;

    }

    /**
     * 認定調査票（基本調査素点）{@link NinteichosahyoKihonChosaScore}を保存します。
     *
     * @param 認定調査票_基本調査素点 認定調査票_基本調査素点
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(NinteichosahyoKihonChosaScore 認定調査票_基本調査素点) {
        requireNonNull(認定調査票_基本調査素点, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査素点）")
        );

        if (!認定調査票_基本調査素点.hasChanged()) {
            return false;
        }
        認定調査票_基本調査素点 = 認定調査票_基本調査素点.modifiedModel();
        save認定調査票_基本調査素点項目リスト(認定調査票_基本調査素点.getNinteichosahyoKihonChosaScoreItemList());
        return 1 == 認定調査票_基本調査素点Dac.save(認定調査票_基本調査素点.toEntity()
        );
    }

    private void save認定調査票_基本調査素点項目リスト(List<NinteichosahyoKihonChosaScoreItem> 認定調査票_基本調査素点項目List) {
        for (NinteichosahyoKihonChosaScoreItem 認定調査票_基本調査素点項目 : 認定調査票_基本調査素点項目List) {
            認定調査票_基本調査素点項目Manager.save認定調査票_基本調査素点項目(認定調査票_基本調査素点項目);
        }
    }
}
