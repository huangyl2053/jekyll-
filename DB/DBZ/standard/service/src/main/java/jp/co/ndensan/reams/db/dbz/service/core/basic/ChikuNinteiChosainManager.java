/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5223ChikuNinteiChosainDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 地区認定調査員を管理するクラスです。
 */
public class ChikuNinteiChosainManager {

    private final DbT5223ChikuNinteiChosainDac dac;

    /**
     * コンストラクタです。
     */
    public ChikuNinteiChosainManager() {
        dac = InstanceProvider.create(DbT5223ChikuNinteiChosainDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5223ChikuNinteiChosainDac}
     */
    ChikuNinteiChosainManager(DbT5223ChikuNinteiChosainDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する地区認定調査員を返します。
     *
     * @param 調査地区コード 調査地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     * @return ChikuNinteiChosain
     */
    @Transaction
    public ChikuNinteiChosain get地区認定調査員(
            Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード) {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbT5223ChikuNinteiChosainEntity entity = dac.selectByKey(
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChikuNinteiChosain(entity);
    }

    /**
     * 地区認定調査員を全件返します。
     *
     * @return ChikuNinteiChosainの{@code list}
     */
    @Transaction
    public List<ChikuNinteiChosain> get地区認定調査員一覧() {
        List<ChikuNinteiChosain> businessList = new ArrayList<>();

        for (DbT5223ChikuNinteiChosainEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChikuNinteiChosain(entity));
        }

        return businessList;
    }

    /**
     * 地区認定調査員{@link ChikuNinteiChosain}を保存します。
     *
     * @param 地区認定調査員 {@link ChikuNinteiChosain}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save地区認定調査員(ChikuNinteiChosain 地区認定調査員) {
        requireNonNull(地区認定調査員, UrSystemErrorMessages.値がnull.getReplacedMessage("地区認定調査員"));
        if (!地区認定調査員.hasChanged()) {
            return false;
        }
        return 1 == dac.save(地区認定調査員.toEntity());
    }
}
