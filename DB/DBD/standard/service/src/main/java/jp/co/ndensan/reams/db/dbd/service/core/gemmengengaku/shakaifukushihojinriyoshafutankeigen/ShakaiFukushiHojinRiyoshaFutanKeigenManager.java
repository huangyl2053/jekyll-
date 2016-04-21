/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shakaifukushihojinriyoshafutankeigen;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShakaiFukushiHojinRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 社会福祉法人等利用者負担軽減を管理するクラスです。
 *
 * @reamsid_L DBD-9999-023 wangjie2
 */
public class ShakaiFukushiHojinRiyoshaFutanKeigenManager {

    private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac dac;

    /**
     * コンストラクタです。
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenManager() {
        this.dac = InstanceProvider.create(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac}
     */
    ShakaiFukushiHojinRiyoshaFutanKeigenManager(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する社会福祉法人等利用者負担軽減を返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @return GemmenGengakuShinsei
     */
    @Transaction
    public ShakaiFukushiHojinRiyoshaFutanKeigen get社会福祉法人等利用者負担軽減(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity = dac.selectByKey(証記載保険者番号, 被保険者番号, 履歴番号);
        if (null == entity) {
            return null;
        }
        entity.initializeMd5();
        return new ShakaiFukushiHojinRiyoshaFutanKeigen(entity);
    }

    /**
     * 社会福祉法人等利用者負担軽減を全件返します。
     *
     * @return GemmenGengakuShinseiの{@code list}
     */
    @Transaction
    public List<ShakaiFukushiHojinRiyoshaFutanKeigen> get社会福祉法人等利用者負担軽減一覧() {
        List<ShakaiFukushiHojinRiyoshaFutanKeigen> businessList = new ArrayList<>();

        for (DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShakaiFukushiHojinRiyoshaFutanKeigen(entity));
        }

        return businessList;
    }

    /**
     * 社会福祉法人等利用者負担軽減{@link ShakaiFukushiHojinRiyoshaFutanKeigen}を保存します。
     *
     * @param 社会福祉法人等利用者負担軽減 {@link ShakaiFukushiHojinRiyoshaFutanKeigen}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save社会福祉法人等利用者負担軽減(ShakaiFukushiHojinRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減) {
        requireNonNull(社会福祉法人等利用者負担軽減, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額申請"));
        if (!社会福祉法人等利用者負担軽減.hasChanged()) {
            return false;
        }
        return 1 == dac.save(社会福祉法人等利用者負担軽減.toEntity());
    }

    /**
     * 社会福祉法人等利用者負担軽減{@link ShakaiFukushiHojinRiyoshaFutanKeigen}を削除します。
     *
     * @param 社会福祉法人等利用者負担軽減 {@link ShakaiFukushiHojinRiyoshaFutanKeigen}
     * @return 物理削除完成フラグ
     */
    @Transaction
    public boolean delete社会福祉法人等利用者負担軽減(ShakaiFukushiHojinRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減) {
        requireNonNull(社会福祉法人等利用者負担軽減, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額申請"));
        return 1 == dac.delete(社会福祉法人等利用者負担軽減.toEntity());
    }

}
