/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IkenshoImageJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5305IkenshoImageJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定意見書イメージ情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 chengsanyuan
 */
public class IkenshoImageJohoManager {

    private final DbT5305IkenshoImageJohoDac dac;

    /**
     * コンストラクタです。
     */
    public IkenshoImageJohoManager() {
        dac = InstanceProvider.create(DbT5305IkenshoImageJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5305IkenshoImageJohoDac}
     */
    IkenshoImageJohoManager(DbT5305IkenshoImageJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IkenshoImageJohoManager}のインスタンスを返します。
     *
     *
     * @return IkenshoImageJohoManager
     */
    public static IkenshoImageJohoManager createInstance() {
        return InstanceProvider.create(IkenshoImageJohoManager.class);
    }

    /**
     * 主キーに合致する要介護認定意見書イメージ情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @param 帳票ID 帳票ID
     * @param マスキングデータ区分 マスキングデータ区分
     * @param 取込みページ番号 取込みページ番号
     * @return IkenshoImageJoho
     */
    @Transaction
    public IkenshoImageJoho get要介護認定意見書イメージ情報(
            ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号,
            Code 帳票ID,
            RString マスキングデータ区分,
            int 取込みページ番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        requireNonNull(帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票ID"));
        requireNonNull(マスキングデータ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("マスキングデータ区分"));
        requireNonNull(取込みページ番号, UrSystemErrorMessages.値がnull.getReplacedMessage("取込みページ番号"));

        DbT5305IkenshoImageJohoEntity entity = dac.selectByKey(
                申請書管理番号,
                主治医意見書作成依頼履歴番号,
                帳票ID,
                マスキングデータ区分,
                取込みページ番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new IkenshoImageJoho(entity);
    }

    /**
     * 要介護認定意見書イメージ情報を全件返します。
     *
     * @return IkenshoImageJohoの{@code list}
     */
    @Transaction
    public List<IkenshoImageJoho> get要介護認定意見書イメージ情報一覧() {
        List<IkenshoImageJoho> businessList = new ArrayList<>();

        for (DbT5305IkenshoImageJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new IkenshoImageJoho(entity));
        }

        return businessList;
    }

    /**
     * 要介護認定意見書イメージ情報{@link IkenshoImageJoho}を保存します。
     *
     * @param 要介護認定意見書イメージ情報 {@link IkenshoImageJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定意見書イメージ情報(IkenshoImageJoho 要介護認定意見書イメージ情報) {
        requireNonNull(要介護認定意見書イメージ情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定意見書イメージ情報"));
        if (!要介護認定意見書イメージ情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定意見書イメージ情報.toEntity());
    }
}
