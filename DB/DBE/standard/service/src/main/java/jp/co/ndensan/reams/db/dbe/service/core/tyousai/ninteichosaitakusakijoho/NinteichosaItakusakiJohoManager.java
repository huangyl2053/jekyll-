/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.tyousai.ninteichosaitakusakijoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.chosainjoho.ChosainJohoManager;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査委託先情報を管理するクラスです。
 *
 * @reamsid_L DBE-0270-010 liangbc
 */
public class NinteichosaItakusakiJohoManager {

//    private final MapperProvider mapperProvider;
    private final DbT5910NinteichosaItakusakiJohoDac 認定調査委託先情報Dac;
    private final ChosainJohoManager 調査員情報Manager;

    /**
     * コンストラクタです。
     */
    NinteichosaItakusakiJohoManager() {
//        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.認定調査委託先情報Dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        this.調査員情報Manager = new ChosainJohoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * // * @param mapperProvider mapperProvider
     *
     * @param 認定調査委託先情報Dac 認定調査委託先情報Dac
     * @param 調査員情報Manager 調査員情報Manager
     */
    NinteichosaItakusakiJohoManager(
            //            MapperProvider mapperProvider,
            DbT5910NinteichosaItakusakiJohoDac 認定調査委託先情報Dac,
            ChosainJohoManager 調査員情報Manager
    ) {
//        this.mapperProvider = mapperProvider;
        this.認定調査委託先情報Dac = 認定調査委託先情報Dac;
        this.調査員情報Manager = 調査員情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaItakusakiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteichosaItakusakiJohoManager}のインスタンス
     */
    public static NinteichosaItakusakiJohoManager createInstance() {
        return InstanceProvider.create(NinteichosaItakusakiJohoManager.class);
    }

    /**
     * 主キーで認定調査委託先情報を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 認定調査委託先コード NinteichosaItakusakiCode
     * @return DbT5910NinteichosaItakusakiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public NinteichosaItakusaki selectByKey(
            LasdecCode 市町村コード,
            RString 認定調査委託先コード) {
        NinteichosaItakusaki ninteichosaItakusaki = new NinteichosaItakusaki();
        ninteichosaItakusaki.setEntity(認定調査委託先情報Dac.selectByKey(市町村コード, 認定調査委託先コード));
        return ninteichosaItakusaki;
    }

    /**
     * 認定調査委託先情報{@link NinteichosaItakusakiJoho}を保存します。
     *
     * @param 認定調査委託先情報 認定調査委託先情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(NinteichosaItakusakiJoho 認定調査委託先情報) {
        requireNonNull(認定調査委託先情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先情報"));

        if (!認定調査委託先情報.hasChanged()) {
            return false;
        }
        認定調査委託先情報 = 認定調査委託先情報.modifiedModel();
        save調査員情報リスト(認定調査委託先情報.getChosainJohoList());
        return 1 == 認定調査委託先情報Dac.save(認定調査委託先情報.toEntity());
    }

    private void save調査員情報リスト(List<ChosainJoho> 調査員情報List) {
        for (ChosainJoho 調査員情報 : 調査員情報List) {
            調査員情報Manager.save調査員情報(調査員情報);
        }
    }

    /**
     * 主キーで認定調査委託先情報件数を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 認定調査委託先コード NinteichosaItakusakiCode
     * @return 認定調査委託先情報件数
     */
    public int countByKey(LasdecCode 市町村コード, RString 認定調査委託先コード) {
        return 認定調査委託先情報Dac.countByKey(市町村コード, 認定調査委託先コード);
    }

    /**
     * DbT5910NinteichosaItakusakiJohoEntityを物理削除。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int deletePhysical(DbT5910NinteichosaItakusakiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先情報エンティティ"));
        return 認定調査委託先情報Dac.deletePhysical(entity);
    }
}
