/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinsakaiWariateJohoKenshu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5504ShinsakaiWariateJohoKenshuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5504ShinsakaiWariateJohoKenshuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author n3213
 */
public class ShinsakaiWariateJohoKenshuManager {

    private DbT5504ShinsakaiWariateJohoKenshuDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiWariateJohoKenshuManager() {
        dac = InstanceProvider.create(DbT5504ShinsakaiWariateJohoKenshuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5504ShinsakaiWariateJohoKenshuDac}
     */
    ShinsakaiWariateJohoKenshuManager(DbT5504ShinsakaiWariateJohoKenshuDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiWariateJohoKenshuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiWariateJohoKenshuManager}のインスタンス
     */
    public static ShinsakaiWariateJohoKenshuManager createInstance() {
        return InstanceProvider.create(ShinsakaiWariateJohoKenshuManager.class);
    }

    @Transaction
    public ShinsakaiWariateJohoKenshu get審査会割当情報研修(RString 介護認定審査会開催番号, ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbT5504ShinsakaiWariateJohoKenshuEntity entity = dac.selectByKey(介護認定審査会開催番号, 申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinsakaiWariateJohoKenshu(entity);
    }

    /**
     * 審査会開催番号に合致する介護認定審査会割当情報研修のリストを返します。
     * 
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return List<ShinsakaiWariateJohoKenshu>
     */
    @Transaction
    public List<ShinsakaiWariateJohoKenshu> get審査会割当情報研修By審査会開催番号(RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));

        List<ShinsakaiWariateJohoKenshu> businessList = new ArrayList<>();
        List<DbT5504ShinsakaiWariateJohoKenshuEntity> entities = dac.selectByShinsakaiKaisaiNo(介護認定審査会開催番号);
        
        for (DbT5504ShinsakaiWariateJohoKenshuEntity entity : entities) {
            entity.initializeMd5();
            businessList.add(new ShinsakaiWariateJohoKenshu(entity));
        }
        
        return businessList;
    }

    /**
     * 介護認定審査会割当情報研修{@link ShinsakaiWariateJohoKenshu}を保存します。
     *
     * @param 介護認定審査会割当情報研修 {@link ShinsakaiWariateJohoKenshu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会割当情報研修(ShinsakaiWariateJohoKenshu 介護認定審査会割当情報研修) {
        requireNonNull(介護認定審査会割当情報研修, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報研修"));
        if (!介護認定審査会割当情報研修.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会割当情報研修.toEntity());
    }

    /**
     * 介護認定審査会割当情報研修{@link ShinsakaiWariateJohoKenshu}を保存します。
     *
     * @param 介護認定審査会割当情報研修 {@link ShinsakaiWariateJohoKenshu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveOrDeletePhysicalBy介護認定審査会割当情報研修(ShinsakaiWariateJohoKenshu 介護認定審査会割当情報研修) {
        requireNonNull(介護認定審査会割当情報研修, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報研修"));
        if (!介護認定審査会割当情報研修.hasChanged()) {
            return false;
        }
        return 1 == dac.saveOrDeletePhysicalBy(介護認定審査会割当情報研修.toEntity());
    }

}
