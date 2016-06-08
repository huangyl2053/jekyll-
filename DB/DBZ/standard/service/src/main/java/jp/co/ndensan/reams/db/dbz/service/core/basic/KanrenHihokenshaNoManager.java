/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KanrenHihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7054KanrenHihokenshaNoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 関連被保険者番号を管理するクラスです。
 */
public class KanrenHihokenshaNoManager {

    private final DbT7054KanrenHihokenshaNoDac dac;

    /**
     * コンストラクタです。
     */
    public KanrenHihokenshaNoManager() {
        dac = InstanceProvider.create(DbT7054KanrenHihokenshaNoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7054KanrenHihokenshaNoDac}
     */
    KanrenHihokenshaNoManager(DbT7054KanrenHihokenshaNoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する関連被保険者番号を返します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 最新被保険者番号 SaishinHihokenshaNo
     * @return KanrenHihokenshaNo
     */
    @Transaction
    public KanrenHihokenshaNo get関連被保険者番号(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 最新被保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(最新被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("最新被保険者番号"));

        DbT7054KanrenHihokenshaNoEntity entity = dac.selectByKey(
                証記載保険者番号,
                最新被保険者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KanrenHihokenshaNo(entity);
    }

    /**
     * 関連被保険者番号を全件返します。
     *
     * @return List<KanrenHihokenshaNo>
     */
    @Transaction
    public List<KanrenHihokenshaNo> get関連被保険者番号一覧() {
        List<KanrenHihokenshaNo> businessList = new ArrayList<>();

        for (DbT7054KanrenHihokenshaNoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KanrenHihokenshaNo(entity));
        }

        return businessList;
    }

    /**
     * 関連被保険者番号{@link KanrenHihokenshaNo}を保存します。
     *
     * @param 関連被保険者番号 {@link KanrenHihokenshaNo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save関連被保険者番号(KanrenHihokenshaNo 関連被保険者番号) {
        requireNonNull(関連被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("関連被保険者番号"));
        if (!関連被保険者番号.hasChanged()) {
            return false;
        }
        return 1 == dac.save(関連被保険者番号.toEntity());
    }
}
