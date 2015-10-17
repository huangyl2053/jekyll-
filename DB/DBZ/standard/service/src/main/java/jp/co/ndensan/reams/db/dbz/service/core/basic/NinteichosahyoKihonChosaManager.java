/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5203NinteichosahyoKihonChosaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_基本調査を管理するクラスです。
 */
public class NinteichosahyoKihonChosaManager {

    private final DbT5203NinteichosahyoKihonChosaDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoKihonChosaManager() {
        dac = InstanceProvider.create(DbT5203NinteichosahyoKihonChosaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5203NinteichosahyoKihonChosaDac}
     */
    NinteichosahyoKihonChosaManager(DbT5203NinteichosahyoKihonChosaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査票_基本調査を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @return NinteichosahyoKihonChosa
     */
    @Transaction
    public NinteichosahyoKihonChosa get認定調査票_基本調査(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号
    ) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));

        DbT5203NinteichosahyoKihonChosaEntity entity = dac.selectByKey(
                申請書管理番号,
                要介護認定調査履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosahyoKihonChosa(entity);
    }

    /**
     * 認定調査票_基本調査を全件返します。
     *
     * @return NinteichosahyoKihonChosaの{@code list}
     */
    @Transaction
    public List<NinteichosahyoKihonChosa> get認定調査票_基本調査一覧() {
        List<NinteichosahyoKihonChosa> businessList = new ArrayList<>();

        for (DbT5203NinteichosahyoKihonChosaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosahyoKihonChosa(entity));
        }

        return businessList;
    }

    /**
     * 認定調査票_基本調査{@link NinteichosahyoKihonChosa}を保存します。
     *
     * @param 認定調査票_基本調査 {@link NinteichosahyoKihonChosa}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_基本調査(NinteichosahyoKihonChosa 認定調査票_基本調査) {
        requireNonNull(認定調査票_基本調査, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_基本調査")
        );
        if (!認定調査票_基本調査.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_基本調査.toEntity());
    }
}
