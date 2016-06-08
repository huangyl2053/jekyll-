/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.view.TekiyoJogaishaAlive;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1002TekiyoJogaishaAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者台帳管理Aliveを管理するクラスです。
 */
public class TekiyoJogaishaAliveManager {

    private final DbV1002TekiyoJogaishaAliveDac dac;

    /**
     * コンストラクタです。
     */
    public TekiyoJogaishaAliveManager() {
        dac = InstanceProvider.create(DbV1002TekiyoJogaishaAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV1002TekiyoJogaishaDac}
     */
    TekiyoJogaishaAliveManager(DbV1002TekiyoJogaishaAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する適用除外者台帳管理Aliveを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return TekiyoJogaishaAlive
     */
    @Transaction
    public TekiyoJogaishaAlive get適用除外者台帳管理Alive(
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbV1002TekiyoJogaishaEntity entity = dac.selectByKey(
                識別コード,
                異動日,
                枝番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TekiyoJogaishaAlive(entity);
    }

    /**
     * 適用除外者台帳管理Aliveを全件返します。
     *
     * @return List<TekiyoJogaishaAlive>
     */
    @Transaction
    public List<TekiyoJogaishaAlive> get適用除外者台帳管理Alive一覧() {
        List<TekiyoJogaishaAlive> businessList = new ArrayList<>();

        for (DbV1002TekiyoJogaishaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TekiyoJogaishaAlive(entity));
        }

        return businessList;
    }

    /**
     * 適用除外者台帳管理Alive{@link TekiyoJogaishaAlive}を保存します。
     *
     * @param 適用除外者台帳管理Alive {@link TekiyoJogaishaAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save適用除外者台帳管理Alive(TekiyoJogaishaAlive 適用除外者台帳管理Alive) {
        requireNonNull(適用除外者台帳管理Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外者台帳管理Alive"));
        if (!適用除外者台帳管理Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(適用除外者台帳管理Alive.toEntity());
    }
}
