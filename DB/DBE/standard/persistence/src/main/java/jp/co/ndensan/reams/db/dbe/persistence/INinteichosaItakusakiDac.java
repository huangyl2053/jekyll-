/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先を管理するインターフェースです
 *
 * @author N1013 松本直樹
 */
public interface INinteichosaItakusakiDac {

    /**
     * 市町村・介護事業者番号・介護事業状況を指定して認定調査委託先を取得します
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護事業者番号 介護事業者番号
     * @param 介護事業状況 介護事業状況
     * @return 認定調査委託先情報エンティティ
     */
    DbT7010NinteichosaItakusakiJohoEntity select(RString 証記載保険者番号, KaigoJigyoshaNo 介護事業者番号, boolean 介護事業状況);

    /**
     * 証記載保険者番号・事業者番号・介護事業状況を指定して認定調査委託先を取得します
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 事業者番号 事業者番号
     * @param 介護事業状況 介護事業状況
     * @return 認定調査委託先情報エンティティ
     */
    DbT7010NinteichosaItakusakiJohoEntity select(RString 証記載保険者番号, JigyoshaNo 事業者番号, boolean 介護事業状況);

    /**
     * 指定した証記載保険者番号で有効又は無効の認定調査委託先を取得します
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護事業状況 介護事業状況
     * @return 認定調査委託先情報エンティティ
     */
    List<DbT7010NinteichosaItakusakiJohoEntity> selectAll(RString 証記載保険者番号, boolean 介護事業状況);

    /**
     * 指定した証記載保険者番号で登録されている全ての認定調査委託先を取得します
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 認定調査委託先情報エンティティ
     */
    List<DbT7010NinteichosaItakusakiJohoEntity> selectAll(RString 証記載保険者番号);

    /**
     * 認定調査委託先情報に対し追加・更新を行います
     *
     * @param entity 認定調査委託先情報エンティティ
     * @return 更新・追加結果
     */
    int insertOrUpdate(DbT7010NinteichosaItakusakiJohoEntity entity);

    /**
     * 認定調査委託先を削除します
     *
     * @param data 認定調査委託先情報エンティティ
     * @return 削除結果
     */
    int delete(DbT7010NinteichosaItakusakiJohoEntity data);
}
