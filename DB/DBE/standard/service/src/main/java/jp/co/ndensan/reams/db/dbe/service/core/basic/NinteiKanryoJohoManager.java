/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定完了情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class NinteiKanryoJohoManager {

    private final DbT5105NinteiKanryoJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiKanryoJohoManager() {
        dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5105NinteiKanryoJohoDac}
     */
    NinteiKanryoJohoManager(DbT5105NinteiKanryoJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiKanryoJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteiKanryoJohoManager}のインスタンス
     */
    public static NinteiKanryoJohoManager createInstance() {
        return InstanceProvider.create(NinteiKanryoJohoManager.class);
    }

    /**
     * 要介護認定完了情報{@link NinteiKanryoJoho}を保存します。
     *
     * @param 要介護認定完了情報 {@link NinteiKanryoJoho}
     * @return 更新結果を返します（trueなら更新成功）。
     */
    @Transaction
    public boolean save要介護認定完了情報(NinteiKanryoJoho 要介護認定完了情報) {
        requireNonNull(要介護認定完了情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定完了情報"));
        if (!要介護認定完了情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定完了情報.toEntity());
    }

    /**
     * 要介護認定完了情報{@link NinteiKanryoJoho}を保存します。
     *
     * @param 要介護認定完了情報List {@link NinteiKanryoJoho}のList
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public int save要介護認定完了情報List(List<NinteiKanryoJoho> 要介護認定完了情報List) {
        requireNonNull(要介護認定完了情報List, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定完了情報List"));

        int saveNum = 0;
        for (NinteiKanryoJoho kanryoJoho : 要介護認定完了情報List) {
            if (save要介護認定完了情報(kanryoJoho)) {
                saveNum++;
            }
        }
        return saveNum;
    }

    @Transaction
    public List<NinteiKanryoJoho> get要介護認定完了情報List(List<ShinseishoKanriNo> 申請書管理番号List) {
        requireNonNull(申請書管理番号List, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号List"));
        List<NinteiKanryoJoho> kanryoJohoList = new ArrayList<>();
        if (申請書管理番号List.isEmpty()) {
            return kanryoJohoList;
        }

        List<DbT5105NinteiKanryoJohoEntity> entityList = dac.select申請書管理番号(申請書管理番号List);
        if (entityList != null && !entityList.isEmpty()) {
            for (DbT5105NinteiKanryoJohoEntity entity : entityList) {
                kanryoJohoList.add(new NinteiKanryoJoho(entity));
            }
        }
        return kanryoJohoList;

    }
}
