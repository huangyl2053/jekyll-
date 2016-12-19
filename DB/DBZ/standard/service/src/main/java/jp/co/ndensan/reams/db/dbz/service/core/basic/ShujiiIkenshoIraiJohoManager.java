/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5301ShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成依頼情報を管理するクラスです。
 */
public class ShujiiIkenshoIraiJohoManager {

    private final DbT5301ShujiiIkenshoIraiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoIraiJohoManager() {
        this.dac = InstanceProvider.create(DbT5301ShujiiIkenshoIraiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5301ShujiiIkenshoIraiJohoDac}
     */
    ShujiiIkenshoIraiJohoManager(DbT5301ShujiiIkenshoIraiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoIraiJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoIraiJohoManager}のインスタンス
     */
    public static ShujiiIkenshoIraiJohoManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoIraiJohoManager.class);
    }
    
    /**
     * 主キーに合致する主治医意見書作成依頼情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return ShujiiIkenshoIraiJoho
     */
    @Transaction
    public ShujiiIkenshoIraiJoho get主治医意見書作成依頼情報(
            ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));

        DbT5301ShujiiIkenshoIraiJohoEntity entity = dac.selectByKey(
                申請書管理番号,
                主治医意見書作成依頼履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShujiiIkenshoIraiJoho(entity);
    }

    /**
     * 主治医意見書作成依頼情報を全件返します。
     *
     * @return ShujiiIkenshoIraiJohoの{@code list}
     */
    @Transaction
    public List<ShujiiIkenshoIraiJoho> get主治医意見書作成依頼情報一覧() {
        List<ShujiiIkenshoIraiJoho> businessList = new ArrayList<>();

        for (DbT5301ShujiiIkenshoIraiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShujiiIkenshoIraiJoho(entity));
        }

        return businessList;
    }

    /**
     * 主治医意見書作成依頼情報{@link ShujiiIkenshoIraiJoho}を保存します。
     *
     * @param 主治医意見書作成依頼情報 {@link ShujiiIkenshoIraiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save主治医意見書作成依頼情報(ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報) {
        requireNonNull(主治医意見書作成依頼情報, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼情報"));
        if (!主治医意見書作成依頼情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(主治医意見書作成依頼情報.toEntity());
    }
}
