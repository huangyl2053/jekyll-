/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboNiniCheckList;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3102NijiYoboNiniCheckListDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 二次予防任意チェックリストを管理するクラスです。
 */
public class NijiYoboNiniCheckListManager {

    private final DbT3102NijiYoboNiniCheckListDac dac;

    /**
     * コンストラクタです。
     */
    public NijiYoboNiniCheckListManager() {
        dac = InstanceProvider.create(DbT3102NijiYoboNiniCheckListDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3102NijiYoboNiniCheckListDac}
     */
    NijiYoboNiniCheckListManager(DbT3102NijiYoboNiniCheckListDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する二次予防任意チェックリストを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 任意質問番号 NiniShitsumonNo
     * @param 履歴番号 RirekiNo
     * @return NijiYoboNiniCheckList
     */
    @Transaction
    public NijiYoboNiniCheckList get二次予防任意チェックリスト(
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 任意質問番号,
            Decimal 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(任意質問番号, UrSystemErrorMessages.値がnull.getReplacedMessage("任意質問番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3102NijiYoboNiniCheckListEntity entity = dac.selectByKey(
                識別コード,
                被保険者番号,
                受付年月日,
                任意質問番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NijiYoboNiniCheckList(entity);
    }

    /**
     * 二次予防任意チェックリストを全件返します。
     *
     * @return List<NijiYoboNiniCheckList>
     */
    @Transaction
    public List<NijiYoboNiniCheckList> get二次予防任意チェックリスト一覧() {
        List<NijiYoboNiniCheckList> businessList = new ArrayList<>();

        for (DbT3102NijiYoboNiniCheckListEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NijiYoboNiniCheckList(entity));
        }

        return businessList;
    }

    /**
     * 二次予防任意チェックリスト{@link NijiYoboNiniCheckList}を保存します。
     *
     * @param 二次予防任意チェックリスト {@link NijiYoboNiniCheckList}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save二次予防任意チェックリスト(NijiYoboNiniCheckList 二次予防任意チェックリスト) {
        requireNonNull(二次予防任意チェックリスト, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防任意チェックリスト"));
        if (!二次予防任意チェックリスト.hasChanged()) {
            return false;
        }
        return 1 == dac.save(二次予防任意チェックリスト.toEntity());
    }
}
