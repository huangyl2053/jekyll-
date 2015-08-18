/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaisha;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1009ShikakuShutokuJogaishaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 資格取得除外者を管理するクラスです。
 */
public class ShikakuShutokuJogaishaManager {

    private final DbT1009ShikakuShutokuJogaishaDac dac;

    /**
     * コンストラクタです。
     */
    public ShikakuShutokuJogaishaManager() {
        dac = InstanceProvider.create(DbT1009ShikakuShutokuJogaishaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1009ShikakuShutokuJogaishaDac}
     */
    ShikakuShutokuJogaishaManager(DbT1009ShikakuShutokuJogaishaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する資格取得除外者を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return ShikakuShutokuJogaisha
     */
    @Transaction
    public ShikakuShutokuJogaisha get資格取得除外者(
            ShikibetsuCode 識別コード,
            int 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT1009ShikakuShutokuJogaishaEntity entity = dac.selectByKey(
                識別コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShikakuShutokuJogaisha(entity);
    }

    /**
     * 資格取得除外者を全件返します。
     *
     * @return List<ShikakuShutokuJogaisha>
     */
    @Transaction
    public List<ShikakuShutokuJogaisha> get資格取得除外者一覧() {
        List<ShikakuShutokuJogaisha> businessList = new ArrayList<>();

        for (DbT1009ShikakuShutokuJogaishaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShikakuShutokuJogaisha(entity));
        }

        return businessList;
    }

    /**
     * 資格取得除外者{@link ShikakuShutokuJogaisha}を保存します。
     *
     * @param 資格取得除外者 {@link ShikakuShutokuJogaisha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save資格取得除外者(ShikakuShutokuJogaisha 資格取得除外者) {
        requireNonNull(資格取得除外者, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得除外者"));
        if (!資格取得除外者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(資格取得除外者.toEntity());
    }
}
