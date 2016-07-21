/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1008IryohokenKanyuJokyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険医療保険加入状況を管理するクラスです。
 */
public class IryohokenKanyuJokyoManager {

    private final DbT1008IryohokenKanyuJokyoDac dac;

    /**
     * コンストラクタです。
     */
    public IryohokenKanyuJokyoManager() {
        dac = InstanceProvider.create(DbT1008IryohokenKanyuJokyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1008IryohokenKanyuJokyoDac}
     */
    IryohokenKanyuJokyoManager(DbT1008IryohokenKanyuJokyoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護保険医療保険加入状況を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return IryohokenKanyuJokyo
     */
    @Transaction
    public IryohokenKanyuJokyo get介護保険医療保険加入状況(
            ShikibetsuCode 識別コード,
            int 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT1008IryohokenKanyuJokyoEntity entity = dac.selectByKey(
                識別コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new IryohokenKanyuJokyo(entity);
    }

    /**
     * 介護保険医療保険加入状況を全件返します。
     *
     * @return List<IryohokenKanyuJokyo>
     */
    @Transaction
    public List<IryohokenKanyuJokyo> get介護保険医療保険加入状況一覧() {
        List<IryohokenKanyuJokyo> businessList = new ArrayList<>();

        for (DbT1008IryohokenKanyuJokyoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new IryohokenKanyuJokyo(entity));
        }

        return businessList;
    }

    /**
     * 介護保険医療保険加入状況{@link IryohokenKanyuJokyo}を保存します。
     *
     * @param 介護保険医療保険加入状況 {@link IryohokenKanyuJokyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護保険医療保険加入状況(IryohokenKanyuJokyo 介護保険医療保険加入状況) {
        requireNonNull(介護保険医療保険加入状況, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険医療保険加入状況"));
        if (!介護保険医療保険加入状況.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護保険医療保険加入状況.toEntity());
    }
}
