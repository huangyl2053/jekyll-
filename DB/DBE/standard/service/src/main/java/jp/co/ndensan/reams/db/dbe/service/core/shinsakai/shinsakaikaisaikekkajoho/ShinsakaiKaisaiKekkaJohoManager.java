/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaikekkajoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会開催結果情報を管理するクラスです。
 */
public class ShinsakaiKaisaiKekkaJohoManager {

    private final DbT5511ShinsakaiKaisaiKekkaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKaisaiKekkaJohoManager() {
        dac = InstanceProvider.create(DbT5511ShinsakaiKaisaiKekkaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5511ShinsakaiKaisaiKekkaJohoDac}
     */
    ShinsakaiKaisaiKekkaJohoManager(DbT5511ShinsakaiKaisaiKekkaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiKekkaJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiYoteiJohoManager}のインスタンス
     */
    public static ShinsakaiKaisaiKekkaJohoManager createInstance() {
        return InstanceProvider.create(ShinsakaiKaisaiKekkaJohoManager.class);
    }

    /**
     * 主キーに合致する介護認定審査会開催結果情報を返します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return ShinsakaiKaisaiKekkaJoho
     */
    @Transaction
    public ShinsakaiKaisaiKekkaJoho get介護認定審査会開催結果情報(
            RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));

        DbT5511ShinsakaiKaisaiKekkaJohoEntity entity = dac.selectByKey(
                介護認定審査会開催番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinsakaiKaisaiKekkaJoho(entity);
    }

    /**
     * 介護認定審査会開催結果情報を全件返します。
     *
     * @return ShinsakaiKaisaiKekkaJohoの{@code list}
     */
    @Transaction
    public List<ShinsakaiKaisaiKekkaJoho> get介護認定審査会開催結果情報一覧() {
        List<ShinsakaiKaisaiKekkaJoho> businessList = new ArrayList<>();

        for (DbT5511ShinsakaiKaisaiKekkaJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinsakaiKaisaiKekkaJoho(entity));
        }

        return businessList;
    }

    /**
     * 介護認定審査会開催結果情報{@link ShinsakaiKaisaiKekkaJoho}を保存します。
     *
     * @param 介護認定審査会開催結果情報 {@link ShinsakaiKaisaiKekkaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会開催結果情報(ShinsakaiKaisaiKekkaJoho 介護認定審査会開催結果情報) {
        requireNonNull(介護認定審査会開催結果情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催結果情報"));
        if (!介護認定審査会開催結果情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会開催結果情報.toEntity());
    }
}
