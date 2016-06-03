/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.homonkaigogengaku;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4016HomonKaigoRiyoshaFutangakuGengakuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.homonkaigogengaku.IHomonKaigoRiyoshaFutangakuGengakuMapper;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shinsei.GemmenGengakuShinseiManager;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.util.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 訪問介護利用者負担額減額を管理するクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public class HomonKaigoRiyoshaFutangakuGengakuManager {

    private final MapperProvider mapperProvider;
    private final DbT4016HomonKaigoRiyoshaFutangakuGengakuDac 訪問介護利用者負担額減額Dac;
    private final GemmenGengakuShinseiManager 減免減額申請Manager;

    /**
     * コンストラクタです。
     */
    HomonKaigoRiyoshaFutangakuGengakuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.訪問介護利用者負担額減額Dac = InstanceProvider.create(DbT4016HomonKaigoRiyoshaFutangakuGengakuDac.class);
        this.減免減額申請Manager = new GemmenGengakuShinseiManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 訪問介護利用者負担額減額Dac 訪問介護利用者負担額減額Dac
     * @param 減免減額申請Manager 減免減額申請Manager
     */
    HomonKaigoRiyoshaFutangakuGengakuManager(
            MapperProvider mapperProvider,
            DbT4016HomonKaigoRiyoshaFutangakuGengakuDac 訪問介護利用者負担額減額Dac,
            GemmenGengakuShinseiManager 減免減額申請Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.訪問介護利用者負担額減額Dac = 訪問介護利用者負担額減額Dac;
        this.減免減額申請Manager = 減免減額申請Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HomonKaigoRiyoshaFutangakuGengakuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HomonKaigoRiyoshaFutangakuGengakuManager}のインスタンス
     */
    public static HomonKaigoRiyoshaFutangakuGengakuManager createInstance() {
        return InstanceProvider.create(HomonKaigoRiyoshaFutangakuGengakuManager.class);
    }

    /**
     * 主キーに合致する訪問介護利用者負担額減額を返します。
     *
     * @param 訪問介護利用者負担額減額検索条件 訪問介護利用者負担額減額検索条件
     * @return HomonKaigoRiyoshaFutangakuGengaku nullが返る可能性があります。
     */
    @Transaction
    public HomonKaigoRiyoshaFutangakuGengaku get訪問介護利用者負担額減額(HomonKaigoRiyoshaFutangakuGengakuMapperParameter 訪問介護利用者負担額減額検索条件) {
        requireNonNull(訪問介護利用者負担額減額検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問介護利用者負担額減額検索条件"));
        IHomonKaigoRiyoshaFutangakuGengakuMapper mapper = mapperProvider.create(IHomonKaigoRiyoshaFutangakuGengakuMapper.class);

        HomonKaigoRiyoshaFutangakuGengakuEntity relateEntity = mapper.select訪問介護利用者負担額減額ByKey(訪問介護利用者負担額減額検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new HomonKaigoRiyoshaFutangakuGengaku(relateEntity);
    }

    /**
     * 訪問介護利用者負担額減額{@link HomonKaigoRiyoshaFutangakuGengaku}を保存します。
     *
     * @param 訪問介護利用者負担額減額 訪問介護利用者負担額減額
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額) {
        requireNonNull(訪問介護利用者負担額減額, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問介護利用者負担額減額"));

        if (!訪問介護利用者負担額減額.hasChanged()) {
            return false;
        }
        訪問介護利用者負担額減額 = 訪問介護利用者負担額減額.modifiedModel();
        save減免減額申請リスト(訪問介護利用者負担額減額.getGemmenGengakuShinseiList());
        return 1 == 訪問介護利用者負担額減額Dac.save(訪問介護利用者負担額減額.toEntity());
    }

    private void save減免減額申請リスト(List<GemmenGengakuShinsei> 減免減額申請List) {
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請List) {
            減免減額申請Manager.save減免減額申請(減免減額申請);
        }
    }
}
