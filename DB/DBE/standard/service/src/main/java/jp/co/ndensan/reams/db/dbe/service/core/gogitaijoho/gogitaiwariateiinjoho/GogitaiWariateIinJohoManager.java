/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaiwariateiinjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5593GogitaiWariateIinJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体割当委員情報を管理するクラスです。
 */
public class GogitaiWariateIinJohoManager {

    private final DbT5593GogitaiWariateIinJohoDac dac;

    /**
     * コンストラクタです。
     */
    public GogitaiWariateIinJohoManager() {
        dac = InstanceProvider.create(DbT5593GogitaiWariateIinJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5593GogitaiWariateIinJohoDac}
     */
    GogitaiWariateIinJohoManager(DbT5593GogitaiWariateIinJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する合議体割当委員情報を返します。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @return GogitaiWariateIinJoho
     */
    @Transaction
    public GogitaiWariateIinJoho get合議体割当委員情報(
            int 合議体番号,
            FlexibleDate 合議体有効期間開始年月日,
            RString 介護認定審査会委員コード) {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));
        requireNonNull(合議体有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体有効期間開始年月日"));
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));

        DbT5593GogitaiWariateIinJohoEntity entity = dac.selectByKey(
                合議体番号,
                合議体有効期間開始年月日,
                介護認定審査会委員コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new GogitaiWariateIinJoho(entity);
    }

    /**
     * 合議体割当委員情報を全件返します。
     *
     * @return GogitaiWariateIinJohoの{@code list}
     */
    @Transaction
    public List<GogitaiWariateIinJoho> get合議体割当委員情報一覧() {
        List<GogitaiWariateIinJoho> businessList = new ArrayList<>();

        for (DbT5593GogitaiWariateIinJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new GogitaiWariateIinJoho(entity));
        }

        return businessList;
    }

    /**
     * 合議体割当委員情報{@link GogitaiWariateIinJoho}を保存します。
     *
     * @param 合議体割当委員情報 {@link GogitaiWariateIinJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save合議体割当委員情報(GogitaiWariateIinJoho 合議体割当委員情報) {
        requireNonNull(合議体割当委員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体割当委員情報"));
        if (!合議体割当委員情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(合議体割当委員情報.toEntity());
    }
}
