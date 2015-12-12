/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorList;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2010FukaErrorListDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課エラー一覧を管理するクラスです。
 */
public class FukaErrorListManager {

    private final DbT2010FukaErrorListDac dac;

    /**
     * コンストラクタです。
     */
    public FukaErrorListManager() {
        dac = InstanceProvider.create(DbT2010FukaErrorListDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2010FukaErrorListDac}
     */
    FukaErrorListManager(DbT2010FukaErrorListDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する賦課エラー一覧を返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 内部帳票ID InternalReportId
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @return FukaErrorList
     */
    @Transaction
    public FukaErrorList get賦課エラー一覧(
            SubGyomuCode サブ業務コード,
            RString 内部帳票ID,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(内部帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("内部帳票ID"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbT2010FukaErrorListEntity entity = dac.selectByKey(
                サブ業務コード,
                内部帳票ID,
                賦課年度,
                通知書番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new FukaErrorList(entity);
    }

    /**
     * 賦課エラー一覧を全件返します。
     *
     * @return List<FukaErrorList>
     */
    @Transaction
    public List<FukaErrorList> get賦課エラー一覧一覧() {
        List<FukaErrorList> businessList = new ArrayList<>();

        for (DbT2010FukaErrorListEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new FukaErrorList(entity));
        }

        return businessList;
    }

    /**
     * 賦課エラー一覧{@link FukaErrorList}を保存します。
     *
     * @param 賦課エラー一覧 {@link FukaErrorList}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save賦課エラー一覧(FukaErrorList 賦課エラー一覧) {
        requireNonNull(賦課エラー一覧, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課エラー一覧"));
        if (!賦課エラー一覧.hasChanged()) {
            return false;
        }
        return 1 == dac.save(賦課エラー一覧.toEntity());
    }
}
