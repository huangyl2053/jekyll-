/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaScore;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5204NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5204NinteichosahyoKihonChosaScoreDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_基本調査素点を管理するクラスです。
 */
public class NinteichosahyoKihonChosaScoreManager {

    private final DbT5204NinteichosahyoKihonChosaScoreDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoKihonChosaScoreManager() {
        dac = InstanceProvider.create(DbT5204NinteichosahyoKihonChosaScoreDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5204NinteichosahyoKihonChosaScoreDac}
     */
    NinteichosahyoKihonChosaScoreManager(DbT5204NinteichosahyoKihonChosaScoreDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査票_基本調査素点を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @return NinteichosahyoKihonChosaScore
     */
    @Transaction
    public NinteichosahyoKihonChosaScore get認定調査票_基本調査素点(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号
    ) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));

        DbT5204NinteichosahyoKihonChosaScoreEntity entity = dac.selectByKey(
                申請書管理番号,
                要介護認定調査履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosahyoKihonChosaScore(entity);
    }

    /**
     * 認定調査票_基本調査素点を全件返します。
     *
     * @return NinteichosahyoKihonChosaScoreの{@code list}
     */
    @Transaction
    public List<NinteichosahyoKihonChosaScore> get認定調査票_基本調査素点一覧() {
        List<NinteichosahyoKihonChosaScore> businessList = new ArrayList<>();

        for (DbT5204NinteichosahyoKihonChosaScoreEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosahyoKihonChosaScore(entity));
        }

        return businessList;
    }

    /**
     * 認定調査票_基本調査素点{@link NinteichosahyoKihonChosaScore}を保存します。
     *
     * @param 認定調査票_基本調査素点 {@link NinteichosahyoKihonChosaScore}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_基本調査素点(NinteichosahyoKihonChosaScore 認定調査票_基本調査素点) {
        requireNonNull(認定調査票_基本調査素点, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_基本調査素点"));
        if (!認定調査票_基本調査素点.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_基本調査素点.toEntity());
    }
}
