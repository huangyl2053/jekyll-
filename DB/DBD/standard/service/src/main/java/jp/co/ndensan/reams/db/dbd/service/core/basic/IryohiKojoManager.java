/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.basic.IryohiKojo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4401IryohiKojoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4401IryohiKojoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 医療費控除を管理するクラスです。
 *
 * @reamsid_L DBD-5780-010 tz_chengpeng
 */
public class IryohiKojoManager {

    private final DbT4401IryohiKojoDac dac;

    /**
     * コンストラクタです。
     */
    public IryohiKojoManager() {
        dac = InstanceProvider.create(DbT4401IryohiKojoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4401IryohiKojoDac}
     */
    IryohiKojoManager(DbT4401IryohiKojoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する医療費控除を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 控除対象年 控除対象年
     * @param データ区分 データ区分
     * @return IryohiKojo
     */
    @Transaction
    public IryohiKojo get医療費控除(
            HihokenshaNo 被保険者番号,
            FlexibleYear 控除対象年,
            RString データ区分) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(控除対象年, UrSystemErrorMessages.値がnull.getReplacedMessage("控除対象年"));
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));

        DbT4401IryohiKojoEntity entity = dac.selectByKey(
                被保険者番号,
                控除対象年,
                データ区分);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new IryohiKojo(entity);
    }

    /**
     * 医療費控除を全件返します。
     *
     * @return IryohiKojoの{@code list}
     */
    @Transaction
    public List<IryohiKojo> get医療費控除一覧() {
        List<IryohiKojo> businessList = new ArrayList<>();

        for (DbT4401IryohiKojoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new IryohiKojo(entity));
        }

        return businessList;
    }

    /**
     * 医療費控除{@link IryohiKojo}を保存します。
     *
     * @param 医療費控除 {@link IryohiKojo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save医療費控除(IryohiKojo 医療費控除) {
        requireNonNull(医療費控除, UrSystemErrorMessages.値がnull.getReplacedMessage("医療費控除"));
        if (!医療費控除.hasChanged()) {
            return false;
        }
        return 1 == dac.save(医療費控除.toEntity());
    }

    /**
     * 医療費控除{@link IryohiKojo}を削除します。
     *
     * @param 医療費控除 {@link IryohiKojo}
     * @return 削除件数 削除結果の件数を返します。
     */
    @Transaction
    public boolean delete医療費控除(IryohiKojo 医療費控除) {
        requireNonNull(医療費控除, UrSystemErrorMessages.値がnull.getReplacedMessage("医療費控除"));
        if (!医療費控除.hasChanged()) {
            return false;
        }
        return 1 == dac.delete(医療費控除.toEntity());
    }
}
