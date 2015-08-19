/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseisho;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3068KogakuGassanShinseishoDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算申請書を管理するクラスです。
 */
public class KogakuGassanShinseishoManager {

    private final DbT3068KogakuGassanShinseishoDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuGassanShinseishoManager() {
        dac = InstanceProvider.create(DbT3068KogakuGassanShinseishoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3068KogakuGassanShinseishoDac}
     */
    KogakuGassanShinseishoManager(DbT3068KogakuGassanShinseishoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額合算申請書を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 整理番号 SeiriNo
     * @param 履歴番号 RirekiNo
     * @return KogakuGassanShinseisho
     */
    @Transaction
    public KogakuGassanShinseisho get高額合算申請書(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 整理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3068KogakuGassanShinseishoEntity entity = dac.selectByKey(
                被保険者番号,
                対象年度,
                保険者番号,
                整理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuGassanShinseisho(entity);
    }

    /**
     * 高額合算申請書を全件返します。
     *
     * @return List<KogakuGassanShinseisho>
     */
    @Transaction
    public List<KogakuGassanShinseisho> get高額合算申請書一覧() {
        List<KogakuGassanShinseisho> businessList = new ArrayList<>();

        for (DbT3068KogakuGassanShinseishoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuGassanShinseisho(entity));
        }

        return businessList;
    }

    /**
     * 高額合算申請書{@link KogakuGassanShinseisho}を保存します。
     *
     * @param 高額合算申請書 {@link KogakuGassanShinseisho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額合算申請書(KogakuGassanShinseisho 高額合算申請書) {
        requireNonNull(高額合算申請書, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算申請書"));
        if (!高額合算申請書.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額合算申請書.toEntity());
    }
}
