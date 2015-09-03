/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GappeiNaiJutokushaShinKyuNoHenkan;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併内住特者新旧番号変換テーブルを管理するクラスです。
 */
public class GappeiNaiJutokushaShinKyuNoHenkanManager {

    private final DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac dac;

    /**
     * コンストラクタです。
     */
    public GappeiNaiJutokushaShinKyuNoHenkanManager() {
        dac = InstanceProvider.create(DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac}
     */
    GappeiNaiJutokushaShinKyuNoHenkanManager(DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する合併内住特者新旧番号変換テーブルを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return GappeiNaiJutokushaShinKyuNoHenkan
     */
    @Transaction
    public GappeiNaiJutokushaShinKyuNoHenkan get合併内住特者新旧番号変換テーブル(
            ShikibetsuCode 識別コード,
            RString 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = dac.selectByKey(
                識別コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new GappeiNaiJutokushaShinKyuNoHenkan(entity);
    }

    /**
     * 合併内住特者新旧番号変換テーブルを全件返します。
     *
     * @return List<GappeiNaiJutokushaShinKyuNoHenkan>
     */
    @Transaction
    public List<GappeiNaiJutokushaShinKyuNoHenkan> get合併内住特者新旧番号変換テーブル一覧() {
        List<GappeiNaiJutokushaShinKyuNoHenkan> businessList = new ArrayList<>();

        for (DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new GappeiNaiJutokushaShinKyuNoHenkan(entity));
        }

        return businessList;
    }

    /**
     * 合併内住特者新旧番号変換テーブル{@link GappeiNaiJutokushaShinKyuNoHenkan}を保存します。
     *
     * @param 合併内住特者新旧番号変換テーブル {@link GappeiNaiJutokushaShinKyuNoHenkan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save合併内住特者新旧番号変換テーブル(GappeiNaiJutokushaShinKyuNoHenkan 合併内住特者新旧番号変換テーブル) {
        requireNonNull(合併内住特者新旧番号変換テーブル, UrSystemErrorMessages.値がnull.getReplacedMessage("合併内住特者新旧番号変換テーブル"));
        if (!合併内住特者新旧番号変換テーブル.hasChanged()) {
            return false;
        }
        return 1 == dac.save(合併内住特者新旧番号変換テーブル.toEntity());
    }
}
