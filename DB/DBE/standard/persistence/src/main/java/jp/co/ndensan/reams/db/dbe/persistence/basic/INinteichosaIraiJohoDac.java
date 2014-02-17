/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IInsertable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IReplaceable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IUpdatable;

/**
 * 認定調査依頼情報を取得するデータアクセスクラスのインターフェースです。
 *
 * @author n8178 城間篤人
 */
//TODO n8178 城間篤人 insertOrUpdateを今後どのように実装するか不明のため、後日実装予定 2014年2月末
public interface INinteichosaIraiJohoDac extends IInsertable<DbT5006NinteichosaIraiJohoEntity>, IUpdatable<DbT5006NinteichosaIraiJohoEntity>,
        IReplaceable<DbT5006NinteichosaIraiJohoEntity> {

    /**
     * 引数の申請書管理番号と認定調査履歴番号に該当する、認定調査依頼情報の取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査委依頼履歴番号 認定調査委依頼履歴番号
     * @return 認定調査依頼情報Entity
     */
    DbT5006NinteichosaIraiJohoEntity select(ShinseishoKanriNo 申請書管理番号, int 認定調査委依頼履歴番号);

    /**
     * 引数で申請書管理番号を指定し、認定調査依頼情報の履歴をリストで取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査依頼情報のリスト
     */
    List<DbT5006NinteichosaIraiJohoEntity> select(ShinseishoKanriNo 申請書管理番号);
}
