/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村単独助成金給付申請を管理するクラスです。
 */
public class TandokuJoseikinKyufuShinseiManager {

    private final DbT3098TandokuJoseikinKyufuShinseiDac dac;

    /**
     * コンストラクタです。
     */
    public TandokuJoseikinKyufuShinseiManager() {
        dac = InstanceProvider.create(DbT3098TandokuJoseikinKyufuShinseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3098TandokuJoseikinKyufuShinseiDac}
     */
    TandokuJoseikinKyufuShinseiManager(DbT3098TandokuJoseikinKyufuShinseiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する市町村単独助成金給付申請を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 履歴番号 RirekiNo
     * @return TandokuJoseikinKyufuShinsei
     */
    @Transaction
    public TandokuJoseikinKyufuShinsei get市町村単独助成金給付申請(
             HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3098TandokuJoseikinKyufuShinseiEntity entity = dac.selectByKey(
                被保険者番号,
                受付年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TandokuJoseikinKyufuShinsei(entity);
    }

    /**
     * 市町村単独助成金給付申請を全件返します。
     *
     * @return List<TandokuJoseikinKyufuShinsei>
     */
    @Transaction
    public List<TandokuJoseikinKyufuShinsei> get市町村単独助成金給付申請一覧() {
        List<TandokuJoseikinKyufuShinsei> businessList = new ArrayList<>();

        for (DbT3098TandokuJoseikinKyufuShinseiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TandokuJoseikinKyufuShinsei(entity));
        }

        return businessList;
    }

    /**
     * 市町村単独助成金給付申請{@link TandokuJoseikinKyufuShinsei}を保存します。
     *
     * @param 市町村単独助成金給付申請 {@link TandokuJoseikinKyufuShinsei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save市町村単独助成金給付申請(TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請) {
        requireNonNull(市町村単独助成金給付申請, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成金給付申請"));
        if (!市町村単独助成金給付申請.hasChanged()) {
            return false;
        }
        return 1 == dac.save(市町村単独助成金給付申請.toEntity());
    }
}
