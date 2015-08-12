/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinKyuHihokenshaNoHenkan;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7026ShinKyuHihokenshaNoHenkanDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 新旧被保険者番号変換テーブルを管理するクラスです。
 */
public class ShinKyuHihokenshaNoHenkanManager {

    private final DbT7026ShinKyuHihokenshaNoHenkanDac dac;

    /**
     * コンストラクタです。
     */
    public ShinKyuHihokenshaNoHenkanManager() {
        dac = InstanceProvider.create(DbT7026ShinKyuHihokenshaNoHenkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7026ShinKyuHihokenshaNoHenkanDac}
     */
    ShinKyuHihokenshaNoHenkanManager(DbT7026ShinKyuHihokenshaNoHenkanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する新旧被保険者番号変換テーブルを返します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧番号 KyuNo
     * @return ShinKyuHihokenshaNoHenkan
     */
    @Transaction
    public ShinKyuHihokenshaNoHenkan get新旧被保険者番号変換テーブル(
            LasdecCode 市町村コード,
            RString 旧番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));

        DbT7026ShinKyuHihokenshaNoHenkanEntity entity = dac.selectByKey(
                市町村コード,
                旧番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinKyuHihokenshaNoHenkan(entity);
    }

    /**
     * 新旧被保険者番号変換テーブルを全件返します。
     *
     * @return List<ShinKyuHihokenshaNoHenkan>
     */
    @Transaction
    public List<ShinKyuHihokenshaNoHenkan> get新旧被保険者番号変換テーブル一覧() {
        List<ShinKyuHihokenshaNoHenkan> businessList = new ArrayList<>();

        for (DbT7026ShinKyuHihokenshaNoHenkanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinKyuHihokenshaNoHenkan(entity));
        }

        return businessList;
    }

    /**
     * 新旧被保険者番号変換テーブル{@link ShinKyuHihokenshaNoHenkan}を保存します。
     *
     * @param 新旧被保険者番号変換テーブル {@link ShinKyuHihokenshaNoHenkan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save新旧被保険者番号変換テーブル(ShinKyuHihokenshaNoHenkan 新旧被保険者番号変換テーブル) {
        requireNonNull(新旧被保険者番号変換テーブル, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧被保険者番号変換テーブル"));
        if (!新旧被保険者番号変換テーブル.hasChanged()) {
            return false;
        }
        return 1 == dac.save(新旧被保険者番号変換テーブル.toEntity());
    }
}
