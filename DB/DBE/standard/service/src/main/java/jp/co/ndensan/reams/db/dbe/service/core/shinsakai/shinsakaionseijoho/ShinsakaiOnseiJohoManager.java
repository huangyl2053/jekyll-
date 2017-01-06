/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaionseijoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5512ShinsakaiOnseiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会音声情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class ShinsakaiOnseiJohoManager {

    private final DbT5512ShinsakaiOnseiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiOnseiJohoManager() {
        dac = InstanceProvider.create(DbT5512ShinsakaiOnseiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5512ShinsakaiOnseiJohoDac}
     */
    ShinsakaiOnseiJohoManager(DbT5512ShinsakaiOnseiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiOnseiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiOnseiJohoManager}のインスタンス
     */
    public static ShinsakaiOnseiJohoManager createInstance() {
        return InstanceProvider.create(ShinsakaiOnseiJohoManager.class);
    }

    /**
     * 主キーに合致する介護認定審査会音声情報を返します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 連番 連番
     * @return ShinsakaiOnseiJoho
     */
    @Transaction
    public ShinsakaiOnseiJoho2 get介護認定審査会音声情報(
            RString 介護認定審査会開催番号,
            int 連番) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5512ShinsakaiOnseiJohoEntity entity = dac.selectByKey(
                介護認定審査会開催番号,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinsakaiOnseiJoho2(entity);
    }

    /**
     * 主キーに合致する介護認定審査会音声情報を返します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 連番 連番
     * @return ShinsakaiOnseiJoho
     */
    @Transaction
    public List<ShinsakaiOnseiJoho2> get介護認定審査会音声情報(RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));

        List<DbT5512ShinsakaiOnseiJohoEntity> entities = dac.selectByKey(介護認定審査会開催番号);
        List<ShinsakaiOnseiJoho2> result = new ArrayList<>();
        for (DbT5512ShinsakaiOnseiJohoEntity entity : entities) {
            entity.initializeMd5();
            result.add(new ShinsakaiOnseiJoho2(entity));
        }
        return result;
    }

    /**
     * 介護認定審査会音声情報を全件返します。
     *
     * @return ShinsakaiOnseiJohoの{@code list}
     */
    @Transaction
    public List<ShinsakaiOnseiJoho2> get介護認定審査会音声情報一覧() {
        List<ShinsakaiOnseiJoho2> businessList = new ArrayList<>();

        for (DbT5512ShinsakaiOnseiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinsakaiOnseiJoho2(entity));
        }

        return businessList;
    }

    /**
     * 介護認定審査会音声情報{@link ShinsakaiOnseiJoho}を保存します。
     *
     * @param 介護認定審査会音声情報 {@link ShinsakaiOnseiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会音声情報(ShinsakaiOnseiJoho2 介護認定審査会音声情報) {
        requireNonNull(介護認定審査会音声情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会音声情報"));
        if (!介護認定審査会音声情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会音声情報.toEntity());
    }
}
