/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.chosachikugroup;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup.ChosaChikuGroup;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5225ChosaChikuGroupDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調査地区グループマスタを管理するクラスです。
 */
public class ChosaChikuGroupManager {

    private final DbT5225ChosaChikuGroupDac dac;

    /**
     * コンストラクタです。
     */
    public ChosaChikuGroupManager() {
        dac = InstanceProvider.create(DbT5225ChosaChikuGroupDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5225ChosaChikuGroupDac}
     */
    ChosaChikuGroupManager(DbT5225ChosaChikuGroupDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する調査地区グループマスタを返します。
     *
     * @param 調査地区グループコード 調査地区グループコード
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     * @return ChosaChikuGroup
     */
    @Transaction
    public ChosaChikuGroup get調査地区グループマスタ(
             Code 調査地区グループコード,
            Code 調査地区コード,
            LasdecCode 市町村コード) {
        requireNonNull(調査地区グループコード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区グループコード"));
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbT5225ChosaChikuGroupEntity entity = dac.selectByKey(
                調査地区グループコード,
                調査地区コード,
                市町村コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChosaChikuGroup(entity);
    }

    /**
     * 調査地区グループマスタを全件返します。
     *
     * @return ChosaChikuGroupの{@code list}
     */
    @Transaction
    public List<ChosaChikuGroup> get調査地区グループマスタ一覧() {
        List<ChosaChikuGroup> businessList = new ArrayList<>();

        for (DbT5225ChosaChikuGroupEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChosaChikuGroup(entity));
        }

        return businessList;
    }

    /**
     * 調査地区グループマスタ{@link ChosaChikuGroup}を保存します。
     *
     * @param 調査地区グループマスタ {@link ChosaChikuGroup}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save調査地区グループマスタ(ChosaChikuGroup 調査地区グループマスタ) {
        requireNonNull(調査地区グループマスタ, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区グループマスタ"));
        if (!調査地区グループマスタ.hasChanged()) {
            return false;
        }
        return 1 == dac.save(調査地区グループマスタ.toEntity());
    }
}
