/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SeigoseiCheck;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1014SeigoseiCheckEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1014SeigoseiCheckDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 整合性チェックを管理するクラスです。
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
public class SeigoseiCheckManager {

    private final DbT1014SeigoseiCheckDac dac;

    /**
     * コンストラクタです。
     */
    public SeigoseiCheckManager() {
        dac = InstanceProvider.create(DbT1014SeigoseiCheckDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1014SeigoseiCheckDac}
     */
    SeigoseiCheckManager(DbT1014SeigoseiCheckDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SeigoseiCheckManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SeigoseiCheckManager}のインスタンス
     */
    public static SeigoseiCheckManager createInstance() {
        return InstanceProvider.create(SeigoseiCheckManager.class);
    }

    /**
     * 主キーに合致する整合性チェックを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @return SeigoseiCheck
     */
    @Transaction
    public SeigoseiCheck get整合性チェック(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbT1014SeigoseiCheckEntity entity = dac.selectByKey(識別コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new SeigoseiCheck(entity);
    }

    /**
     * 整合性チェックを全件返します。
     *
     * @return List<SeigoseiCheck>
     */
    @Transaction
    public List<SeigoseiCheck> get整合性チェック一覧() {
        List<SeigoseiCheck> businessList = new ArrayList<>();

        for (DbT1014SeigoseiCheckEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new SeigoseiCheck(entity));
        }

        return businessList;
    }

    /**
     * 整合性チェック{@link SeigoseiCheck}を保存します。
     *
     * @param 整合性チェック {@link SeigoseiCheck}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save整合性チェック(SeigoseiCheck 整合性チェック) {
        requireNonNull(整合性チェック, UrSystemErrorMessages.値がnull.getReplacedMessage("整合性チェック"));
        if (!整合性チェック.hasChanged()) {
            return false;
        }
        return 1 == dac.save(整合性チェック.toEntity());
    }
}
