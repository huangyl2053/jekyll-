/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;

/**
 * 介護事業者代表者マスタのデータベースアクセス機能を提供するインターフェースです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者代表者Dacインタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者代表者
 * @mainClass
 * @reference
 * @deprecated {@link UrT0520KaigoJigyoshaDaihyoshaDac}を使用してください。
 */
public interface IDbT7062KaigoJigyoshaDaihyoshaDac {
    //TODO n3423 樋木隆真 不要クラスのため「施設入退所実装時」に削除

    /**
     * 介護事業者代表者マスタより指定された事業者番号を持つデータを1件取得します。
     *
     * @param jigyoshaBango 事業者番号
     * @return 事業者代表者
     */
    DbT7062KaigoJigyoshaDaihyoshaEntity select事業者代表者(KaigoJigyoshaNo jigyoshaBango);

    /**
     * 介護事業者代表者マスタより指定された事業者番号を持つデータを取得します。
     *
     * @param jigyoshaBangos 事業者番号のリスト
     * @return 事業者代表者のリスト
     */
    List<DbT7062KaigoJigyoshaDaihyoshaEntity> select事業者代表者s(List<KaigoJigyoshaNo> jigyoshaBangos);
}
