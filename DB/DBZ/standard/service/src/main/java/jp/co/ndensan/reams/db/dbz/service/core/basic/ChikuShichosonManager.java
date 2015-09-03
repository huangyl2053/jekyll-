/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuShichoson;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5224ChikuShichosonDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 地区市町村を管理するクラスです。
 */
public class ChikuShichosonManager {

    private final DbT5224ChikuShichosonDac dac;

    /**
     * コンストラクタです。
     */
    public ChikuShichosonManager() {
        dac = InstanceProvider.create(DbT5224ChikuShichosonDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5224ChikuShichosonDac}
     */
    ChikuShichosonManager(DbT5224ChikuShichosonDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する地区市町村を返します。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     * @return ChikuShichoson
     */
    @Transaction
    public ChikuShichoson get地区市町村(
            Code 調査地区コード,
            LasdecCode 市町村コード) {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbT5224ChikuShichosonEntity entity = dac.selectByKey(
                調査地区コード,
                市町村コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChikuShichoson(entity);
    }

    /**
     * 地区市町村を全件返します。
     *
     * @return ChikuShichosonの{@code list}
     */
    @Transaction
    public List<ChikuShichoson> get地区市町村一覧() {
        List<ChikuShichoson> businessList = new ArrayList<>();

        for (DbT5224ChikuShichosonEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChikuShichoson(entity));
        }

        return businessList;
    }

    /**
     * 地区市町村{@link ChikuShichoson}を保存します。
     *
     * @param 地区市町村 {@link ChikuShichoson}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save地区市町村(ChikuShichoson 地区市町村) {
        requireNonNull(地区市町村, UrSystemErrorMessages.値がnull.getReplacedMessage("地区市町村"));
        if (!地区市町村.hasChanged()) {
            return false;
        }
        return 1 == dac.save(地区市町村.toEntity());
    }
}
