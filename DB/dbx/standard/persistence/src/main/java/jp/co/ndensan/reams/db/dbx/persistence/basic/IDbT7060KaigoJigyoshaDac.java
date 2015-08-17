/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者マスタのデータベースアクセス機能を提供するインターフェースです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者Dacインタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 * @deprecated {@link UrT0518KaigoJigyoshaDac}を使用してください。
 */
public interface IDbT7060KaigoJigyoshaDac {
    //TODO n3423 樋木隆真 不要クラスのため「施設入退所実装時」に削除

    /**
     * 指定した事業者番号と有効開始年月日を元に、事業者を1件取得します。
     *
     * @param jigyoshaBango 事業者番号
     * @param 有効開始年月日 有効開始年月日
     * @return 指定した事業者番号の事業者を1件
     */
    KaigoJigyoshaEntity select特定の事業者番号の事業者(RString jigyoshaBango, FlexibleDate 有効開始年月日);

    /**
     * 指定した事業者番号と有効開始年月日を元に、事業者を1件取得します。
     *
     * @param jigyoshaBango 事業者番号
     * @return 指定した事業者の最新を1件
     */
    KaigoJigyoshaEntity select特定の事業者番号の事業者(RString jigyoshaBango);

    /**
     * 介護事業者マスタより特定の事業者番号の一覧を取得します。
     *
     * @param jigyoshaBango 事業者番号
     * @return 該当事業者一覧
     */
    List<KaigoJigyoshaEntity> select特定の事業者番号の事業者List(RString jigyoshaBango);

    /**
     * 事業者マスタより特定の事業者種別かつ特定の事業者番号の事業者を取得します。
     * 指定された事業者番号のリストに含まれた全ての事業者についてデータを取得します。
     *
     * @param jigyoshaBangos 事業者番号のリスト
     * @return 該当の事業者s（複数件）
     */
    List<KaigoJigyoshaEntity> select特定の事業者番号の事業者List(List<RString> jigyoshaBangos);
}
