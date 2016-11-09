/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jikofutangakuhosei;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGakuMeisai;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JigyoKogakuGassanJikoFutanGakuManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JigyoKogakuGassanJikoFutanGakuMeisaiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 負担額と負担額明細Managerクラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class JikoFutangakuSaveManager {

    private final JigyoKogakuGassanJikoFutanGakuManager 負担額Manager;
    private final JigyoKogakuGassanJikoFutanGakuMeisaiManager 負担額明細Manager;

    /**
     * コンストラクタです。
     */
    JikoFutangakuSaveManager() {
        this.負担額Manager = InstanceProvider.create(JigyoKogakuGassanJikoFutanGakuManager.class);
        this.負担額明細Manager = InstanceProvider.create(JigyoKogakuGassanJikoFutanGakuMeisaiManager.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 負担額Manager 負担額Manager
     * @param 負担額明細Manager 負担額明細Manager
     */
    JikoFutangakuSaveManager(
            JigyoKogakuGassanJikoFutanGakuManager 負担額Manager,
            JigyoKogakuGassanJikoFutanGakuMeisaiManager 負担額明細Manager
    ) {
        this.負担額Manager = 負担額Manager;
        this.負担額明細Manager = 負担額明細Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JikoFutangakuHoseiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link JikoFutangakuHoseiManager}のインスタンス
     */
    public static JikoFutangakuSaveManager createInstance() {
        return InstanceProvider.create(JikoFutangakuSaveManager.class);
    }

    /**
     * 負担額と負担額明細を保存します。
     *
     * @param 負担額 JigyoKogakuGassanJikoFutanGakuManager
     * @param 負担額明細一覧 List<JigyoKogakuGassanJikoFutanGakuMeisai>
     */
    @Transaction
    public void 保存(JigyoKogakuGassanJikoFutanGaku 負担額,
            List<JigyoKogakuGassanJikoFutanGakuMeisai> 負担額明細一覧) {
        requireNonNull(負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("負担額"));
        負担額Manager.save高額合算自己負担額(負担額);
        if (負担額明細一覧 != null) {
            for (JigyoKogakuGassanJikoFutanGakuMeisai 負担額明細 : 負担額明細一覧) {
                負担額明細Manager.save高額合算自己負担額明細(負担額明細);
            }
        }
    }
}
