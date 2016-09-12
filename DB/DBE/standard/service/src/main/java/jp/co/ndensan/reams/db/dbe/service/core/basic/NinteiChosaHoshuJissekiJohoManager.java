/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5601NinteiChosaHoshuJissekiJohoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査報酬実績情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 wanghui
 */
public class NinteiChosaHoshuJissekiJohoManager {

    private final DbT5601NinteiChosaHoshuJissekiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiChosaHoshuJissekiJohoManager() {
        dac = InstanceProvider.create(DbT5601NinteiChosaHoshuJissekiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5601NinteiChosaHoshuJissekiJohoDac}
     */
    NinteiChosaHoshuJissekiJohoManager(DbT5601NinteiChosaHoshuJissekiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査報酬実績情報を返します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return NinteiChosaHoshuJissekiJoho
     */
    @Transaction
    public NinteiChosaHoshuJissekiJoho get認定調査報酬実績情報(
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));

        DbT5601NinteiChosaHoshuJissekiJohoEntity entity = dac.selectByKey(
                認定調査委託先コード,
                認定調査員コード,
                申請書管理番号,
                認定調査依頼履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteiChosaHoshuJissekiJoho(entity);
    }

    /**
     * 認定調査報酬実績情報を全件返します。
     *
     * @return NinteiChosaHoshuJissekiJohoの{@code list}
     */
    @Transaction
    public List<NinteiChosaHoshuJissekiJoho> get認定調査報酬実績情報一覧() {
        List<NinteiChosaHoshuJissekiJoho> businessList = new ArrayList<>();

        for (DbT5601NinteiChosaHoshuJissekiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteiChosaHoshuJissekiJoho(entity));
        }

        return businessList;
    }

    /**
     * 認定調査報酬実績情報{@link NinteiChosaHoshuJissekiJoho}を保存します。
     *
     * @param 認定調査報酬実績情報 {@link NinteiChosaHoshuJissekiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査報酬実績情報(NinteiChosaHoshuJissekiJoho 認定調査報酬実績情報) {
        requireNonNull(認定調査報酬実績情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査報酬実績情報"));
        if (!認定調査報酬実績情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査報酬実績情報.toEntity());
    }
}
