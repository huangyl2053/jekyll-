/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.tyousai.chosainjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調査員情報を管理するクラスです。
 *
 * @reamsid_L DBZ-9999-011 sunhaidi
 */
public class ChosainJohoManager {

    private final DbT5913ChosainJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ChosainJohoManager() {
        dac = InstanceProvider.create(DbT5913ChosainJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5913ChosainJohoDac}
     */
    ChosainJohoManager(DbT5913ChosainJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosainJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChosainJohoManager}のインスタンス
     */
    public static ChosainJohoManager createInstance() {
        return InstanceProvider.create(ChosainJohoManager.class);
    }

    /**
     * 調査員情報を全件返します。
     *
     * @return ChosainJohoの{@code list}
     */
    @Transaction
    public List<ChosainJoho> get調査員情報一覧() {
        List<ChosainJoho> businessList = new ArrayList<>();

        for (DbT5913ChosainJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChosainJoho(entity));
        }

        return businessList;
    }

    /**
     * 調査員情報{@link ChosainJoho}を保存します。
     *
     * @param 調査員情報 {@link ChosainJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save調査員情報(ChosainJoho 調査員情報) {
        requireNonNull(調査員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員情報"));
        if (!調査員情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(調査員情報.toEntity());
    }

    /**
     * 調査員情報{@link ChosainJoho}を保存します。
     *
     * @param 調査員情報 {@link ChosainJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveOrDelete調査員情報(ChosainJoho 調査員情報) {
        requireNonNull(調査員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員情報"));
        if (!調査員情報.hasChanged()) {
            return false;
        }

        return 1 == dac.save(調査員情報.toEntity());
    }

    /**
     * 市町村コードと認定調査委託先コードで、調査員情報を取得します。
     *
     * @param 市町村コード LasdecCode
     * @param 認定調査委託先コード ChosaItakusakiCode
     * @param 認定調査員コード ChosainCode
     * @return 件数
     */
    @Transaction
    public DbT5913ChosainJohoEntity countByShichosonCodeAndNinteichosaItakusakiCode(
            LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード, ChosainCode 認定調査員コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        return dac.selectByKey(市町村コード, 認定調査委託先コード, 認定調査員コード);
    }
    
    /**
     * 主キーで調査員情報件数を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param R認定調査委託先コード NinteichosaItakusakiCode
     * @return 認定調査委託先情報件数
     */
    public int countByKey(LasdecCode 市町村コード, RString R認定調査委託先コード) {
        ChosaItakusakiCode 認定調査委託先コード = new ChosaItakusakiCode(R認定調査委託先コード);
        return dac.select調査員情報(市町村コード, 認定調査委託先コード).size();
    }
}
