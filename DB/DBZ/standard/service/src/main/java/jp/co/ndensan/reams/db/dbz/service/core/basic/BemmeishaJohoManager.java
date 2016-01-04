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
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeishaJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7003BemmeishaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 弁明者情報を管理するクラスです。
 */
public class BemmeishaJohoManager {

    private final DbT7003BemmeishaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public BemmeishaJohoManager() {
        dac = InstanceProvider.create(DbT7003BemmeishaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7003BemmeishaJohoDac}
     */
    BemmeishaJohoManager(DbT7003BemmeishaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する弁明者情報を返します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 GenshobunHihokenshaNo
     * @param 審査請求届出日 ShinsaseikyuTodokedeYMD
     * @param 弁明書作成日 BemmeishoSakuseiYMD
     * @param 弁明者枝番 BemmeishaEdaban
     * @return BemmeishaJoho
     */
    @Transaction
    public BemmeishaJoho get弁明者情報(
            ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            Decimal 弁明者枝番) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));
        requireNonNull(弁明者枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者枝番"));

        DbT7003BemmeishaJohoEntity entity = dac.selectByKey(
                識別コード,
                原処分被保険者番号,
                審査請求届出日,
                弁明書作成日,
                弁明者枝番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new BemmeishaJoho(entity);
    }

    /**
     * 弁明者情報を全件返します。
     *
     * @return List<BemmeishaJoho>
     */
    @Transaction
    public List<BemmeishaJoho> get弁明者情報一覧() {
        List<BemmeishaJoho> businessList = new ArrayList<>();

        for (DbT7003BemmeishaJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new BemmeishaJoho(entity));
        }

        return businessList;
    }

    /**
     * 弁明者情報{@link BemmeishaJoho}を保存します。
     *
     * @param 弁明者情報 {@link BemmeishaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save弁明者情報(BemmeishaJoho 弁明者情報) {
        requireNonNull(弁明者情報, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者情報"));
        if (!弁明者情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(弁明者情報.toEntity());
    }
}
