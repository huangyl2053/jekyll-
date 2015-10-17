/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboKihonCheckList;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3101NijiYoboKihonCheckListDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 二次予防基本チェックリストを管理するクラスです。
 */
public class NijiYoboKihonCheckListManager {

    private final DbT3101NijiYoboKihonCheckListDac dac;

    /**
     * コンストラクタです。
     */
    public NijiYoboKihonCheckListManager() {
        dac = InstanceProvider.create(DbT3101NijiYoboKihonCheckListDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3101NijiYoboKihonCheckListDac}
     */
    NijiYoboKihonCheckListManager(DbT3101NijiYoboKihonCheckListDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する二次予防基本チェックリストを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 履歴番号 RirekiNo
     * @return NijiYoboKihonCheckList
     */
    @Transaction
    public NijiYoboKihonCheckList get二次予防基本チェックリスト(
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3101NijiYoboKihonCheckListEntity entity = dac.selectByKey(
                識別コード,
                被保険者番号,
                受付年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NijiYoboKihonCheckList(entity);
    }

    /**
     * 二次予防基本チェックリストを全件返します。
     *
     * @return List<NijiYoboKihonCheckList>
     */
    @Transaction
    public List<NijiYoboKihonCheckList> get二次予防基本チェックリスト一覧() {
        List<NijiYoboKihonCheckList> businessList = new ArrayList<>();

        for (DbT3101NijiYoboKihonCheckListEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NijiYoboKihonCheckList(entity));
        }

        return businessList;
    }

    /**
     * 二次予防基本チェックリスト{@link NijiYoboKihonCheckList}を保存します。
     *
     * @param 二次予防基本チェックリスト {@link NijiYoboKihonCheckList}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save二次予防基本チェックリスト(NijiYoboKihonCheckList 二次予防基本チェックリスト) {
        requireNonNull(二次予防基本チェックリスト, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防基本チェックリスト"));
        if (!二次予防基本チェックリスト.hasChanged()) {
            return false;
        }
        return 1 == dac.save(二次予防基本チェックリスト.toEntity());
    }
}
