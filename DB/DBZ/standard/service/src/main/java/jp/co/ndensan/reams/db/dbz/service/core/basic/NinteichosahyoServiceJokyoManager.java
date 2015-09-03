/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5207NinteichosahyoServiceJokyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_概況調査_サービスの状況を管理するクラスです。
 */
public class NinteichosahyoServiceJokyoManager {

    private final DbT5207NinteichosahyoServiceJokyoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoServiceJokyoManager() {
        dac = InstanceProvider.create(DbT5207NinteichosahyoServiceJokyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5207NinteichosahyoServiceJokyoDac}
     */
    NinteichosahyoServiceJokyoManager(DbT5207NinteichosahyoServiceJokyoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査票_概況調査_サービスの状況を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 連番 連番
     * @return NinteichosahyoServiceJokyo
     */
    @Transaction
    public NinteichosahyoServiceJokyo get認定調査票_概況調査_サービスの状況(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5207NinteichosahyoServiceJokyoEntity entity = dac.selectByKey(
                申請書管理番号,
                認定調査依頼履歴番号,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosahyoServiceJokyo(entity);
    }

    /**
     * 認定調査票_概況調査_サービスの状況を全件返します。
     *
     * @return NinteichosahyoServiceJokyoの{@code list}
     */
    @Transaction
    public List<NinteichosahyoServiceJokyo> get認定調査票_概況調査_サービスの状況一覧() {
        List<NinteichosahyoServiceJokyo> businessList = new ArrayList<>();

        for (DbT5207NinteichosahyoServiceJokyoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosahyoServiceJokyo(entity));
        }

        return businessList;
    }

    /**
     * 認定調査票_概況調査_サービスの状況{@link NinteichosahyoServiceJokyo}を保存します。
     *
     * @param 認定調査票_概況調査_サービスの状況 {@link NinteichosahyoServiceJokyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況調査_サービスの状況(NinteichosahyoServiceJokyo 認定調査票_概況調査_サービスの状況) {
        requireNonNull(認定調査票_概況調査_サービスの状況, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況調査_サービスの状況"));
        if (!認定調査票_概況調査_サービスの状況.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_概況調査_サービスの状況.toEntity());
    }
}
