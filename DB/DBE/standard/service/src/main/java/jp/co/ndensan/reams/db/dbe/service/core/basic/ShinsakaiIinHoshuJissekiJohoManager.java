/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5603ShinsakaiIinHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5603ShinsakaiIinHoshuJissekiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定審査会委員報酬実績情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 zhengsongling
 */
public class ShinsakaiIinHoshuJissekiJohoManager {

    private final DbT5603ShinsakaiIinHoshuJissekiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinHoshuJissekiJohoManager() {
        dac = InstanceProvider.create(DbT5603ShinsakaiIinHoshuJissekiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5603ShinsakaiIinHoshuJissekiJohoDac}
     */
    ShinsakaiIinHoshuJissekiJohoManager(DbT5603ShinsakaiIinHoshuJissekiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 介護認定審査会委員報酬実績情報を全件返します。
     *
     * @return ShinsakaiIinHoshuJissekiJohoの{@code list}
     */
    public SearchResult<ShinsakaiIinHoshuJissekiJoho> get介護認定審査会委員報酬実績情報一覧() {
        List<ShinsakaiIinHoshuJissekiJoho> businessList = new ArrayList<>();
        for (DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinsakaiIinHoshuJissekiJoho(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 主キーに合致する介護認定審査会委員報酬実績情報を返します。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 審査会委員報酬区分 審査会委員報酬区分
     * @param 実施年月日 実施年月日
     * @param 連番 連番
     * @return ShinsakaiIinHoshuJissekiJoho
     */
    public ShinsakaiIinHoshuJissekiJoho get介護認定審査会委員報酬実績情報(
            RString 介護認定審査会委員コード,
            Code 審査会委員報酬区分,
            FlexibleDate 実施年月日,
            int 連番) {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        requireNonNull(審査会委員報酬区分, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員報酬区分"));
        requireNonNull(実施年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("実施年月日"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity = dac.selectByKey(
                介護認定審査会委員コード,
                審査会委員報酬区分,
                実施年月日,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinsakaiIinHoshuJissekiJoho(entity);
    }

}
