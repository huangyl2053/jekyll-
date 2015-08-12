/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinKyuChosaItakusakiChosainNoHenkan;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkanDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 新旧調査委託先調査員番号変換テーブルを管理するクラスです。
 */
public class ShinKyuChosaItakusakiChosainNoHenkanManager {

    private final DbT7029ShinKyuChosaItakusakiChosainNoHenkanDac dac;

    /**
     * コンストラクタです。
     */
    public ShinKyuChosaItakusakiChosainNoHenkanManager() {
        dac = InstanceProvider.create(DbT7029ShinKyuChosaItakusakiChosainNoHenkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7029ShinKyuChosaItakusakiChosainNoHenkanDac}
     */
    ShinKyuChosaItakusakiChosainNoHenkanManager(DbT7029ShinKyuChosaItakusakiChosainNoHenkanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する新旧調査委託先調査員番号変換テーブルを返します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧調査委託先番号 KyuChosaItakusakiNo
     * @param 旧調査員番号 KyuChosainNo
     * @return ShinKyuChosaItakusakiChosainNoHenkan
     */
    @Transaction
    public ShinKyuChosaItakusakiChosainNoHenkan get新旧調査委託先調査員番号変換テーブル(
            LasdecCode 市町村コード,
            RString 旧調査委託先番号,
            RString 旧調査員番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧調査委託先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査委託先番号"));
        requireNonNull(旧調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査員番号"));

        DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity = dac.selectByKey(
                市町村コード,
                旧調査委託先番号,
                旧調査員番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinKyuChosaItakusakiChosainNoHenkan(entity);
    }

    /**
     * 新旧調査委託先調査員番号変換テーブルを全件返します。
     *
     * @return List<ShinKyuChosaItakusakiChosainNoHenkan>
     */
    @Transaction
    public List<ShinKyuChosaItakusakiChosainNoHenkan> get新旧調査委託先調査員番号変換テーブル一覧() {
        List<ShinKyuChosaItakusakiChosainNoHenkan> businessList = new ArrayList<>();

        for (DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinKyuChosaItakusakiChosainNoHenkan(entity));
        }

        return businessList;
    }

    /**
     * 新旧調査委託先調査員番号変換テーブル{@link ShinKyuChosaItakusakiChosainNoHenkan}を保存します。
     *
     * @param 新旧調査委託先調査員番号変換テーブル {@link ShinKyuChosaItakusakiChosainNoHenkan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save新旧調査委託先調査員番号変換テーブル(ShinKyuChosaItakusakiChosainNoHenkan 新旧調査委託先調査員番号変換テーブル) {
        requireNonNull(新旧調査委託先調査員番号変換テーブル, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧調査委託先調査員番号変換テーブル"));
        if (!新旧調査委託先調査員番号変換テーブル.hasChanged()) {
            return false;
        }
        return 1 == dac.save(新旧調査委託先調査員番号変換テーブル.toEntity());
    }
}
