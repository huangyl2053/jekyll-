/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiiryokikanmaster;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医医療機関情報を管理するクラスです。
 */
public class ShujiiIryoKikanJohoManager {

    private final DbT5911ShujiiIryoKikanJohoDac 主治医医療機関情報Dac;

    /**
     * コンストラクタです。
     */
    ShujiiIryoKikanJohoManager() {
        this.主治医医療機関情報Dac = InstanceProvider.create(DbT5911ShujiiIryoKikanJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 主治医医療機関情報Dac 主治医医療機関情報Dac
     */
    ShujiiIryoKikanJohoManager(
            DbT5911ShujiiIryoKikanJohoDac 主治医医療機関情報Dac
    ) {
        this.主治医医療機関情報Dac = 主治医医療機関情報Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIryoKikanJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiIryoKikanJohoManager}のインスタンス
     */
    public static ShujiiIryoKikanJohoManager createInstance() {
        return InstanceProvider.create(ShujiiIryoKikanJohoManager.class);
    }

    /**
     * 主治医医療機関情報{@link ShujiiIryoKikanJoho}を保存します。
     *
     * @param 主治医医療機関情報 {@link ShujiiIryoKikanJho}
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean saveOrDelete主治医医療機関情報(ShujiiIryoKikanJoho 主治医医療機関情報) {
        requireNonNull(主治医医療機関情報, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員情報"));
        if (!主治医医療機関情報.hasChanged()) {
            return false;
        }
        return 1 == 主治医医療機関情報Dac.saveOrDelete(主治医医療機関情報.toEntity());
    }

    /**
     * 市町村コードと主治医医療機関コードで、主治医医療機関情報の件数を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return 件数
     */
    @Transaction
    public int countByShichosonCodeAndShujiiIryokikanCode(LasdecCode 市町村コード, ShujiiIryokikanCode 主治医医療機関コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        return 主治医医療機関情報Dac.countByShichosonCodeAndShujiiIryokikanCode(市町村コード, 主治医医療機関コード);
    }
}
