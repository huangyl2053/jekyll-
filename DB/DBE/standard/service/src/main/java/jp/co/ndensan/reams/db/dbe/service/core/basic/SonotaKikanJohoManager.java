/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.SonotaKikanJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5914SonotaKikanJohoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * その他機関情報を管理するクラスです。
 */
public class SonotaKikanJohoManager {

    private final DbT5914SonotaKikanJohoDac dac;

    /**
     * コンストラクタです。
     */
    public SonotaKikanJohoManager() {
        dac = InstanceProvider.create(DbT5914SonotaKikanJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5914SonotaKikanJohoDac}
     */
    SonotaKikanJohoManager(DbT5914SonotaKikanJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致するその他機関情報を返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param その他機関コード その他機関コード
     * @return SonotaKikanJoho
     */
    @Transaction
    public SonotaKikanJoho getその他機関情報(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString その他機関コード) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(その他機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("その他機関コード"));

        DbT5914SonotaKikanJohoEntity entity = dac.selectByKey(
                証記載保険者番号,
                その他機関コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new SonotaKikanJoho(entity);
    }

    /**
     * その他機関情報を全件返します。
     *
     * @return SonotaKikanJohoの{@code list}
     */
    @Transaction
    public List<SonotaKikanJoho> getその他機関情報一覧() {
        List<SonotaKikanJoho> businessList = new ArrayList<>();

        for (DbT5914SonotaKikanJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new SonotaKikanJoho(entity));
        }

        return businessList;
    }

    /**
     * その他機関情報{@link SonotaKikanJoho}を保存します。
     *
     * @param その他機関情報 {@link SonotaKikanJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveその他機関情報(SonotaKikanJoho その他機関情報) {
        requireNonNull(その他機関情報, UrSystemErrorMessages.値がnull.getReplacedMessage("その他機関情報"));
        if (!その他機関情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(その他機関情報.toEntity());
    }
}
