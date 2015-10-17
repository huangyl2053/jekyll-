/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7069KaigoToiawasesakiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護問合せ先を管理するクラスです。
 */
public class KaigoToiawasesakiManager {

    private final DbT7069KaigoToiawasesakiDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoToiawasesakiManager() {
        dac = InstanceProvider.create(DbT7069KaigoToiawasesakiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7069KaigoToiawasesakiDac}
     */
    KaigoToiawasesakiManager(DbT7069KaigoToiawasesakiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護問合せ先を返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票分類ID ChohyoBunruiID
     * @return KaigoToiawasesaki
     */
    @Transaction
    public KaigoToiawasesaki get介護問合せ先(
            SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));

        DbT7069KaigoToiawasesakiEntity entity = dac.selectByKey(
                サブ業務コード,
                帳票分類ID);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoToiawasesaki(entity);
    }

    /**
     * 介護問合せ先を全件返します。
     *
     * @return List<KaigoToiawasesaki>
     */
    @Transaction
    public List<KaigoToiawasesaki> get介護問合せ先一覧() {
        List<KaigoToiawasesaki> businessList = new ArrayList<>();

        for (DbT7069KaigoToiawasesakiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoToiawasesaki(entity));
        }

        return businessList;
    }

    /**
     * 介護問合せ先{@link KaigoToiawasesaki}を保存します。
     *
     * @param 介護問合せ先 {@link KaigoToiawasesaki}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護問合せ先(KaigoToiawasesaki 介護問合せ先) {
        requireNonNull(介護問合せ先, UrSystemErrorMessages.値がnull.getReplacedMessage("介護問合せ先"));
        if (!介護問合せ先.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護問合せ先.toEntity());
    }
}
