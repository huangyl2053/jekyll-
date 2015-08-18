/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KakushuShinKyuNoHenkan;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7028KakushuShinKyuNoHenkanDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 各種新旧番号変換テーブルを管理するクラスです。
 */
public class KakushuShinKyuNoHenkanManager {

    private final DbT7028KakushuShinKyuNoHenkanDac dac;

    /**
     * コンストラクタです。
     */
    public KakushuShinKyuNoHenkanManager() {
        dac = InstanceProvider.create(DbT7028KakushuShinKyuNoHenkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7028KakushuShinKyuNoHenkanDac}
     */
    KakushuShinKyuNoHenkanManager(DbT7028KakushuShinKyuNoHenkanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する各種新旧番号変換テーブルを返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 番号区分 NoKubun
     * @param 旧番号 KyuNo
     * @return KakushuShinKyuNoHenkan
     */
    @Transaction
    public KakushuShinKyuNoHenkan get各種新旧番号変換テーブル(
            HihokenshaNo 被保険者番号,
            RString 番号区分,
            RString 旧番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(番号区分, UrSystemErrorMessages.値がnull.getReplacedMessage("番号区分"));
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));

        DbT7028KakushuShinKyuNoHenkanEntity entity = dac.selectByKey(
                被保険者番号,
                番号区分,
                旧番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KakushuShinKyuNoHenkan(entity);
    }

    /**
     * 各種新旧番号変換テーブルを全件返します。
     *
     * @return List<KakushuShinKyuNoHenkan>
     */
    @Transaction
    public List<KakushuShinKyuNoHenkan> get各種新旧番号変換テーブル一覧() {
        List<KakushuShinKyuNoHenkan> businessList = new ArrayList<>();

        for (DbT7028KakushuShinKyuNoHenkanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KakushuShinKyuNoHenkan(entity));
        }

        return businessList;
    }

    /**
     * 各種新旧番号変換テーブル{@link KakushuShinKyuNoHenkan}を保存します。
     *
     * @param 各種新旧番号変換テーブル {@link KakushuShinKyuNoHenkan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save各種新旧番号変換テーブル(KakushuShinKyuNoHenkan 各種新旧番号変換テーブル) {
        requireNonNull(各種新旧番号変換テーブル, UrSystemErrorMessages.値がnull.getReplacedMessage("各種新旧番号変換テーブル"));
        if (!各種新旧番号変換テーブル.hasChanged()) {
            return false;
        }
        return 1 == dac.save(各種新旧番号変換テーブル.toEntity());
    }
}
