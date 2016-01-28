/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyogaikyochosa;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.gaikyotokki.GaikyoTokki;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosaMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5202NinteichosahyoGaikyoChosaDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahyo.ninteichosahyogaikyochosa.INinteichosahyoGaikyoChosaMapper;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.gaikyotokki.GaikyoTokkiManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItemManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlagManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（概況調査）を管理するクラスです。
 */
public class NinteichosahyoGaikyoChosaManager {

    private final MapperProvider mapperProvider;
    private final DbT5202NinteichosahyoGaikyoChosaDac 認定調査票_概況調査Dac;
    private final GaikyoTokkiManager 認定調査票_概況特記Manager;
    private final NinteichosahyoTokkijikoManager 認定調査票_特記情報Manager;
    private final NinteichosahyoServiceJokyoManager 認定調査票_概況調査_サービスの状況Manager;
    private final NinteichosahyoServiceJokyoFlagManager 認定調査票_概況調査_サービスの状況フラグManager;
    private final NinteichosahyoKinyuItemManager 認定調査票_概況調査_記入項目Manager;
    private final NinteichosahyoShisetsuRiyoManager 認定調査票_概況調査_施設利用Manager;
    private final NinteichosahyoKihonChosaManager 認定調査票_基本調査Manager;

    /**
     * コンストラクタです。
     */
    NinteichosahyoGaikyoChosaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.認定調査票_概況調査Dac = InstanceProvider.create(DbT5202NinteichosahyoGaikyoChosaDac.class);
        this.認定調査票_概況特記Manager = new GaikyoTokkiManager();
        this.認定調査票_特記情報Manager = new NinteichosahyoTokkijikoManager();
        this.認定調査票_概況調査_サービスの状況Manager = new NinteichosahyoServiceJokyoManager();
        this.認定調査票_概況調査_サービスの状況フラグManager = new NinteichosahyoServiceJokyoFlagManager();
        this.認定調査票_概況調査_記入項目Manager = new NinteichosahyoKinyuItemManager();
        this.認定調査票_概況調査_施設利用Manager = new NinteichosahyoShisetsuRiyoManager();
        this.認定調査票_基本調査Manager = NinteichosahyoKihonChosaManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 認定調査票_概況調査Dac 認定調査票_概況調査Dac
     * @param 認定調査票_概況特記Manager 認定調査票_概況特記Manager
     * @param 認定調査票_特記情報Manager 認定調査票_特記情報Manager
     * @param 認定調査票_概況調査_サービスの状況Manager 認定調査票_概況調査_サービスの状況Manager
     * @param 認定調査票_概況調査_サービスの状況フラグManager 認定調査票_概況調査_サービスの状況フラグManager
     * @param 認定調査票_概況調査_記入項目Manager 認定調査票_概況調査_記入項目Manager
     * @param 認定調査票_概況調査_施設利用Manager 認定調査票_概況調査_施設利用Manager
     * @param 認定調査票_基本調査Manager 認定調査票_基本調査Manager
     */
    NinteichosahyoGaikyoChosaManager(
            MapperProvider mapperProvider,
            DbT5202NinteichosahyoGaikyoChosaDac 認定調査票_概況調査Dac,
            GaikyoTokkiManager 認定調査票_概況特記Manager,
            NinteichosahyoTokkijikoManager 認定調査票_特記情報Manager,
            NinteichosahyoServiceJokyoManager 認定調査票_概況調査_サービスの状況Manager,
            NinteichosahyoServiceJokyoFlagManager 認定調査票_概況調査_サービスの状況フラグManager,
            NinteichosahyoKinyuItemManager 認定調査票_概況調査_記入項目Manager,
            NinteichosahyoShisetsuRiyoManager 認定調査票_概況調査_施設利用Manager,
            NinteichosahyoKihonChosaManager 認定調査票_基本調査Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.認定調査票_概況調査Dac = 認定調査票_概況調査Dac;
        this.認定調査票_概況特記Manager = 認定調査票_概況特記Manager;
        this.認定調査票_特記情報Manager = 認定調査票_特記情報Manager;
        this.認定調査票_概況調査_サービスの状況Manager = 認定調査票_概況調査_サービスの状況Manager;
        this.認定調査票_概況調査_サービスの状況フラグManager = 認定調査票_概況調査_サービスの状況フラグManager;
        this.認定調査票_概況調査_記入項目Manager = 認定調査票_概況調査_記入項目Manager;
        this.認定調査票_概況調査_施設利用Manager = 認定調査票_概況調査_施設利用Manager;
        this.認定調査票_基本調査Manager = 認定調査票_基本調査Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoGaikyoChosaManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteichosahyoGaikyoChosaManager}のインスタンス
     */
    public static NinteichosahyoGaikyoChosaManager createInstance() {
        return InstanceProvider.create(NinteichosahyoGaikyoChosaManager.class);
    }

    /**
     * 主キーに合致する認定調査票（概況調査）を返します。
     *
     * @param 認定調査票_概況調査_検索条件 認定調査票_概況調査_検索条件
     * @return NinteichosahyoGaikyoChosa nullが返る可能性があります。
     */
    @Transaction
    public NinteichosahyoGaikyoChosa get認定調査票_概況調査(NinteichosahyoGaikyoChosaMapperParameter 認定調査票_概況調査_検索条件) {
        requireNonNull(認定調査票_概況調査_検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）検索条件")
        );
        INinteichosahyoGaikyoChosaMapper mapper = mapperProvider.create(INinteichosahyoGaikyoChosaMapper.class);

        NinteichosahyoGaikyoChosaEntity relateEntity = mapper.select認定調査票_概況調査ByKey(認定調査票_概況調査_検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new NinteichosahyoGaikyoChosa(relateEntity);
    }

    /**
     * 主キー1に合致する認定調査票（概況調査）のリストを返します。
     *
     * @param 認定調査票_概況調査_検索条件 認定調査票_概況調査_検索条件
     * @return NinteichosahyoGaikyoChosaの{@code list}
     */
    @Transaction
    public List<NinteichosahyoGaikyoChosa> get認定調査票_概況調査リストBy主キー1(NinteichosahyoGaikyoChosaMapperParameter 認定調査票_概況調査_検索条件) {
        requireNonNull(認定調査票_概況調査_検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）検索条件"));
        INinteichosahyoGaikyoChosaMapper mapper = mapperProvider.create(INinteichosahyoGaikyoChosaMapper.class);

        List<NinteichosahyoGaikyoChosaEntity> relateEntityList = mapper.select認定調査票_概況調査リストBy主キー1(認定調査票_概況調査_検索条件);

        ArrayList<NinteichosahyoGaikyoChosa> 認定調査票_概況調査List = new ArrayList<>();
        for (NinteichosahyoGaikyoChosaEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            認定調査票_概況調査List.add(new NinteichosahyoGaikyoChosa(relateEntity));
        }
        return 認定調査票_概況調査List;

    }

    /**
     * 認定調査票（概況調査）{@link NinteichosahyoGaikyoChosa}を保存します。
     *
     * @param 認定調査票_概況調査 認定調査票_概況調査
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(NinteichosahyoGaikyoChosa 認定調査票_概況調査) {
        requireNonNull(認定調査票_概況調査, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）"));

        if (!認定調査票_概況調査.hasChanged()) {
            return false;
        }
        認定調査票_概況調査 = 認定調査票_概況調査.modifiedModel();
        save認定調査票_概況特記リスト(認定調査票_概況調査.getGaikyoTokkiList());
        save認定調査票_特記情報リスト(認定調査票_概況調査.getNinteichosahyoTokkijikoList());
        save認定調査票_概況調査_サービスの状況リスト(認定調査票_概況調査.getNinteichosahyoServiceJokyoList());
        save認定調査票_概況調査_サービスの状況フラグリスト(認定調査票_概況調査.getNinteichosahyoServiceJokyoFlagList());
        save認定調査票_概況調査_記入項目リスト(認定調査票_概況調査.getNinteichosahyoKinyuItemList());
        save認定調査票_概況調査_施設利用リスト(認定調査票_概況調査.getNinteichosahyoShisetsuRiyoList());
        save認定調査票_基本調査リスト(認定調査票_概況調査.getNinteichosahyoKihonChosaList());
        return 1 == 認定調査票_概況調査Dac.save(認定調査票_概況調査.toEntity());
    }

    private void save認定調査票_概況特記リスト(List<GaikyoTokki> 認定調査票_概況特記List) {
        for (GaikyoTokki 認定調査票_概況特記 : 認定調査票_概況特記List) {
            認定調査票_概況特記Manager.save認定調査票_概況特記(認定調査票_概況特記);
        }
    }

    private void save認定調査票_特記情報リスト(List<NinteichosahyoTokkijiko> 認定調査票_特記情報List) {
        for (NinteichosahyoTokkijiko 認定調査票_特記情報 : 認定調査票_特記情報List) {
            認定調査票_特記情報Manager.save認定調査票_特記情報(認定調査票_特記情報);
        }
    }

    private void save認定調査票_概況調査_サービスの状況リスト(List<NinteichosahyoServiceJokyo> 認定調査票_概況調査_サービスの状況List) {
        for (NinteichosahyoServiceJokyo 認定調査票_概況調査_サービスの状況 : 認定調査票_概況調査_サービスの状況List) {
            認定調査票_概況調査_サービスの状況Manager.save認定調査票_概況調査_サービスの状況(認定調査票_概況調査_サービスの状況);
        }
    }

    private void save認定調査票_概況調査_サービスの状況フラグリスト(List<NinteichosahyoServiceJokyoFlag> 認定調査票_概況調査_サービスの状況フラグList) {
        for (NinteichosahyoServiceJokyoFlag 認定調査票_概況調査_サービスの状況フラグ : 認定調査票_概況調査_サービスの状況フラグList) {
            認定調査票_概況調査_サービスの状況フラグManager.save認定調査票_概況調査_サービスの状況フラグ(認定調査票_概況調査_サービスの状況フラグ);
        }
    }

    private void save認定調査票_概況調査_記入項目リスト(List<NinteichosahyoKinyuItem> 認定調査票_概況調査_記入項目List) {
        for (NinteichosahyoKinyuItem 認定調査票_概況調査_記入項目 : 認定調査票_概況調査_記入項目List) {
            認定調査票_概況調査_記入項目Manager.save認定調査票_概況調査_記入項目(認定調査票_概況調査_記入項目);
        }
    }

    private void save認定調査票_概況調査_施設利用リスト(List<NinteichosahyoShisetsuRiyo> 認定調査票_概況調査_施設利用List) {
        for (NinteichosahyoShisetsuRiyo 認定調査票_概況調査_施設利用 : 認定調査票_概況調査_施設利用List) {
            認定調査票_概況調査_施設利用Manager.save認定調査票_概況調査_施設利用(認定調査票_概況調査_施設利用);
        }
    }

    private void save認定調査票_基本調査リスト(List<NinteichosahyoKihonChosa> 認定調査票_基本調査List) {
        for (NinteichosahyoKihonChosa 認定調査票_基本調査 : 認定調査票_基本調査List) {
            認定調査票_基本調査Manager.save(認定調査票_基本調査);
        }
    }
}
