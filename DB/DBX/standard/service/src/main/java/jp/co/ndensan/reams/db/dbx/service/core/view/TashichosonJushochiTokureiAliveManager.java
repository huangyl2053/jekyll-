/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.view.TashichosonJushochiTokureiAlive;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1003TashichosonJushochiTokureiAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 他市町村住所地特例者台帳管理Aliveを管理するクラスです。
 */
public class TashichosonJushochiTokureiAliveManager {

    private final DbV1003TashichosonJushochiTokureiAliveDac dac;

    /**
     * コンストラクタです。
     */
    public TashichosonJushochiTokureiAliveManager() {
        dac = InstanceProvider.create(DbV1003TashichosonJushochiTokureiAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV1003TashichosonJushochiTokureiDac}
     */
    TashichosonJushochiTokureiAliveManager(DbV1003TashichosonJushochiTokureiAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する他市町村住所地特例者台帳管理Aliveを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return TashichosonJushochiTokureiAlive
     */
    @Transaction
    public TashichosonJushochiTokureiAlive get他市町村住所地特例者台帳管理Alive(
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbV1003TashichosonJushochiTokureiEntity entity = dac.selectByKey(
                識別コード,
                異動日,
                枝番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TashichosonJushochiTokureiAlive(entity);
    }

    /**
     * 他市町村住所地特例者台帳管理Aliveを全件返します。
     *
     * @return List<TashichosonJushochiTokureiAlive>
     */
    @Transaction
    public List<TashichosonJushochiTokureiAlive> get他市町村住所地特例者台帳管理Alive一覧() {
        List<TashichosonJushochiTokureiAlive> businessList = new ArrayList<>();

        for (DbV1003TashichosonJushochiTokureiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TashichosonJushochiTokureiAlive(entity));
        }

        return businessList;
    }

    /**
     * 他市町村住所地特例者台帳管理Alive{@link TashichosonJushochiTokureiAlive}を保存します。
     *
     * @param 他市町村住所地特例者台帳管理Alive {@link TashichosonJushochiTokureiAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save他市町村住所地特例者台帳管理Alive(TashichosonJushochiTokureiAlive 他市町村住所地特例者台帳管理Alive) {
        requireNonNull(他市町村住所地特例者台帳管理Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例者台帳管理Alive"));
        if (!他市町村住所地特例者台帳管理Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(他市町村住所地特例者台帳管理Alive.toEntity());
    }
}
