/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosairaijoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5201NinteichosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahyo.ninteichosairaijoho.INinteichosaIraiJohoMapper;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosaManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼情報を管理するクラスです。
 */
public class NinteichosaIraiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5201NinteichosaIraiJohoDac 認定調査依頼情報Dac;
    private final NinteichosahyoGaikyoChosaManager 認定調査票_概況調査Manager;

    /**
     * コンストラクタです。
     */
    NinteichosaIraiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.認定調査依頼情報Dac = InstanceProvider.create(DbT5201NinteichosaIraiJohoDac.class);
        this.認定調査票_概況調査Manager = NinteichosahyoGaikyoChosaManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 認定調査依頼情報Dac 認定調査依頼情報Dac
     * @param 認定調査票_概況調査Manager 認定調査票_概況調査Manager
     */
    NinteichosaIraiJohoManager(
            MapperProvider mapperProvider,
            DbT5201NinteichosaIraiJohoDac 認定調査依頼情報Dac,
            NinteichosahyoGaikyoChosaManager 認定調査票_概況調査Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.認定調査依頼情報Dac = 認定調査依頼情報Dac;
        this.認定調査票_概況調査Manager = 認定調査票_概況調査Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaIraiJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaIraiJohoManager}のインスタンス
     */
    public static NinteichosaIraiJohoManager createInstance() {
        return InstanceProvider.create(NinteichosaIraiJohoManager.class);
    }

    /**
     * 主キーに合致する認定調査依頼情報を返します。
     *
     * @param 認定調査依頼情報検索条件 認定調査依頼情報検索条件
     * @return NinteichosaIraiJoho 【　※ツールの都合上、このカッコ部は手動で削除して下さい 認定調査依頼情報】
     * nullが返る可能性があります。
     */
    @Transaction
    public NinteichosaIraiJoho get認定調査依頼情報(NinteichosaIraiJohoMapperParameter 認定調査依頼情報検索条件) {
        requireNonNull(認定調査依頼情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼情報検索条件"));
        INinteichosaIraiJohoMapper mapper = mapperProvider.create(INinteichosaIraiJohoMapper.class);

        NinteichosaIraiJohoEntity relateEntity = mapper.select認定調査依頼情報ByKey(認定調査依頼情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new NinteichosaIraiJoho(relateEntity);
    }

    /**
     * 主キー1に合致する認定調査依頼情報のリストを返します。
     *
     * @param 認定調査依頼情報検索条件 認定調査依頼情報検索条件
     * @return NinteichosaIraiJohoの{@code list}
     */
    @Transaction
    public List<NinteichosaIraiJoho> get認定調査依頼情報リストBy主キー1(NinteichosaIraiJohoMapperParameter 認定調査依頼情報検索条件) {
        requireNonNull(認定調査依頼情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼情報検索条件"));
        INinteichosaIraiJohoMapper mapper = mapperProvider.create(INinteichosaIraiJohoMapper.class);

        List<NinteichosaIraiJohoEntity> relateEntityList = mapper.select認定調査依頼情報リストBy主キー1(認定調査依頼情報検索条件);

        ArrayList<NinteichosaIraiJoho> 認定調査依頼情報List = new ArrayList<>();
        for (NinteichosaIraiJohoEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            認定調査依頼情報List.add(new NinteichosaIraiJoho(relateEntity));
        }
        return 認定調査依頼情報List;

    }

    /**
     * 認定調査依頼情報{@link NinteichosaIraiJoho}を保存します。
     *
     * @param 認定調査依頼情報 認定調査依頼情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(NinteichosaIraiJoho 認定調査依頼情報) {
        requireNonNull(認定調査依頼情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼情報"));

        if (!認定調査依頼情報.hasChanged()) {
            return false;
        }
        認定調査依頼情報 = 認定調査依頼情報.modifiedModel();
        save認定調査票_概況調査リスト(認定調査依頼情報.getNinteichosahyoGaikyoChosaList());
        return 1 == 認定調査依頼情報Dac.save(認定調査依頼情報.toEntity());
    }

    private void save認定調査票_概況調査リスト(List<NinteichosahyoGaikyoChosa> 認定調査票_概況調査List) {
        for (NinteichosahyoGaikyoChosa 認定調査票_概況調査 : 認定調査票_概況調査List) {
            認定調査票_概況調査Manager.save(認定調査票_概況調査);
        }
    }
}
