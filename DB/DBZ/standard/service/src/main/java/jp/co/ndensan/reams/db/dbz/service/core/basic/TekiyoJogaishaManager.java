/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者を管理するクラスです。
 */
public class TekiyoJogaishaManager {

    private final DbT1002TekiyoJogaishaDac dac;

    /**
     * コンストラクタです。
     */
    public TekiyoJogaishaManager() {
        dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1002TekiyoJogaishaDac}
     */
    TekiyoJogaishaManager(DbT1002TekiyoJogaishaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する適用除外者を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return TekiyoJogaisha
     */
    @Transaction
    public TekiyoJogaisha get適用除外者(
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbT1002TekiyoJogaishaEntity entity = dac.selectByKey(
                識別コード,
                異動日,
                枝番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TekiyoJogaisha(entity);
    }

    /**
     * 適用除外者を全件返します。
     *
     * @return List<TekiyoJogaisha>
     */
    @Transaction
    public List<TekiyoJogaisha> get適用除外者一覧() {
        List<TekiyoJogaisha> businessList = new ArrayList<>();

        for (DbT1002TekiyoJogaishaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TekiyoJogaisha(entity));
        }

        return businessList;
    }

    /**
     * 適用除外者{@link TekiyoJogaisha}を保存します。
     *
     * @param 適用除外者 {@link TekiyoJogaisha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save適用除外者(TekiyoJogaisha 適用除外者) {
        requireNonNull(適用除外者, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外者"));
        if (!適用除外者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(適用除外者.toEntity());
    }
}
