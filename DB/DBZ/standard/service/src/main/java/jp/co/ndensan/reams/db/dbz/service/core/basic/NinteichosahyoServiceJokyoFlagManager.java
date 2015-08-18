/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5208NinteichosahyoServiceJokyoFlagDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_概況調査_サービスの状況フラグを管理するクラスです。
 */
public class NinteichosahyoServiceJokyoFlagManager {

    private final DbT5208NinteichosahyoServiceJokyoFlagDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoServiceJokyoFlagManager() {
        dac = InstanceProvider.create(DbT5208NinteichosahyoServiceJokyoFlagDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5208NinteichosahyoServiceJokyoFlagDac}
     */
    NinteichosahyoServiceJokyoFlagManager(DbT5208NinteichosahyoServiceJokyoFlagDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査票_概況調査_サービスの状況フラグを返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 連番 連番
     * @return NinteichosahyoServiceJokyoFlag
     */
    @Transaction
    public NinteichosahyoServiceJokyoFlag get認定調査票_概況調査_サービスの状況フラグ(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5208NinteichosahyoServiceJokyoFlagEntity entity = dac.selectByKey(
                申請書管理番号,
                認定調査依頼履歴番号,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosahyoServiceJokyoFlag(entity);
    }

    /**
     * 認定調査票_概況調査_サービスの状況フラグを全件返します。
     *
     * @return NinteichosahyoServiceJokyoFlagの{@code list}
     */
    @Transaction
    public List<NinteichosahyoServiceJokyoFlag> get認定調査票_概況調査_サービスの状況フラグ一覧() {
        List<NinteichosahyoServiceJokyoFlag> businessList = new ArrayList<>();

        for (DbT5208NinteichosahyoServiceJokyoFlagEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosahyoServiceJokyoFlag(entity));
        }

        return businessList;
    }

    /**
     * 認定調査票_概況調査_サービスの状況フラグ{@link NinteichosahyoServiceJokyoFlag}を保存します。
     *
     * @param 認定調査票_概況調査_サービスの状況フラグ {@link NinteichosahyoServiceJokyoFlag}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況調査_サービスの状況フラグ(NinteichosahyoServiceJokyoFlag 認定調査票_概況調査_サービスの状況フラグ) {
        requireNonNull(認定調査票_概況調査_サービスの状況フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況調査_サービスの状況フラグ"));
        if (!認定調査票_概況調査_サービスの状況フラグ.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_概況調査_サービスの状況フラグ.toEntity());
    }
}
