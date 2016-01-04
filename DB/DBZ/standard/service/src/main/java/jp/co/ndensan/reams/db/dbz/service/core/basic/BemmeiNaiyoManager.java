/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeiNaiyo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7002BemmeiNaiyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 弁明内容を管理するクラスです。
 */
public class BemmeiNaiyoManager {

    private final DbT7002BemmeiNaiyoDac dac;

    /**
     * コンストラクタです。
     */
    public BemmeiNaiyoManager() {
        dac = InstanceProvider.create(DbT7002BemmeiNaiyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7002BemmeiNaiyoDac}
     */
    BemmeiNaiyoManager(DbT7002BemmeiNaiyoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する弁明内容を返します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 GenshobunHihokenshaNo
     * @param 審査請求届出日 ShinsaseikyuTodokedeYMD
     * @param 弁明書作成日 BemmeishoSakuseiYMD
     * @return BemmeiNaiyo
     */
    @Transaction
    public BemmeiNaiyo get弁明内容(
            ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));

        DbT7002BemmeiNaiyoEntity entity = dac.selectByKey(
                識別コード,
                原処分被保険者番号,
                審査請求届出日,
                弁明書作成日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new BemmeiNaiyo(entity);
    }

    /**
     * 弁明内容を全件返します。
     *
     * @return List<BemmeiNaiyo>
     */
    @Transaction
    public List<BemmeiNaiyo> get弁明内容一覧() {
        List<BemmeiNaiyo> businessList = new ArrayList<>();

        for (DbT7002BemmeiNaiyoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new BemmeiNaiyo(entity));
        }

        return businessList;
    }

    /**
     * 弁明内容{@link BemmeiNaiyo}を保存します。
     *
     * @param 弁明内容 {@link BemmeiNaiyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save弁明内容(BemmeiNaiyo 弁明内容) {
        requireNonNull(弁明内容, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明内容"));
        if (!弁明内容.hasChanged()) {
            return false;
        }
        return 1 == dac.save(弁明内容.toEntity());
    }
}
