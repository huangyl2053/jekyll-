/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.standard.persistence;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
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
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護事業状況 介護事業状況
     * @return 認定調査委託先情報エンティティ
     */
    DbT7010NinteichosaItakusakiJohoEntity select(RString 市町村コード, KaigoJigyoshaNo 介護事業者番号, boolean 介護事業状況);

    /**
     * 市町村コード・事業者番号・介護事業状況を指定して認定調査委託先を取得します
     *
     * @param 市町村コード 市町村コード
     * @param 事業者番号 事業者番号
     * @param 介護事業状況 介護事業状況
     * @return 認定調査委託先情報エンティティ
     */
    DbT7010NinteichosaItakusakiJohoEntity select(RString 市町村コード, JigyoshaNo 事業者番号, boolean 介護事業状況);

    /**
     * 指定した市町村コードで有効又は無効の認定調査委託先を取得します
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業状況 介護事業状況
     * @return 認定調査委託先情報エンティティ
     */
    List<DbT7010NinteichosaItakusakiJohoEntity> selectAll(RString 市町村コード, boolean 介護事業状況);

    /**
     * 指定した市町村コードで登録されている全ての認定調査委託先を取得します
     *
     * @param 市町村コード 市町村コード
     * @return 認定調査委託先情報エンティティ
     */
    List<DbT7010NinteichosaItakusakiJohoEntity> selectAll(RString 市町村コード);

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
