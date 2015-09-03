/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 他市町村住所地特例を管理するクラスです。
 */
public class TashichosonJushochiTokureiManager {

    private final DbT1003TashichosonJushochiTokureiDac dac;

    /**
     * コンストラクタです。
     */
    public TashichosonJushochiTokureiManager() {
        dac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1003TashichosonJushochiTokureiDac}
     */
    TashichosonJushochiTokureiManager(DbT1003TashichosonJushochiTokureiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する他市町村住所地特例を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return TashichosonJushochiTokurei
     */
    @Transaction
    public TashichosonJushochiTokurei get他市町村住所地特例(
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbT1003TashichosonJushochiTokureiEntity entity = dac.selectByKey(
                識別コード,
                異動日,
                枝番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TashichosonJushochiTokurei(entity);
    }

    /**
     * 他市町村住所地特例を全件返します。
     *
     * @return List<TashichosonJushochiTokurei>
     */
    @Transaction
    public List<TashichosonJushochiTokurei> get他市町村住所地特例一覧() {
        List<TashichosonJushochiTokurei> businessList = new ArrayList<>();

        for (DbT1003TashichosonJushochiTokureiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TashichosonJushochiTokurei(entity));
        }

        return businessList;
    }

    /**
     * 他市町村住所地特例{@link TashichosonJushochiTokurei}を保存します。
     *
     * @param 他市町村住所地特例 {@link TashichosonJushochiTokurei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save他市町村住所地特例(TashichosonJushochiTokurei 他市町村住所地特例) {
        requireNonNull(他市町村住所地特例, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例"));
        if (!他市町村住所地特例.hasChanged()) {
            return false;
        }
        return 1 == dac.save(他市町村住所地特例.toEntity());
    }
}
