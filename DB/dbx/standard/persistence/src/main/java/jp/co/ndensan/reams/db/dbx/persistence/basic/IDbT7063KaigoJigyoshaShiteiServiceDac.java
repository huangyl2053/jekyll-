/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者指定サービスマスタのデータベースアクセスを提供するインターフェースです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者指定サービスDacインタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 * @deprecated {@link UrT0521KaigoJigyoshaShiteiServiceDac}を使用してください。
 */
public interface IDbT7063KaigoJigyoshaShiteiServiceDac {
    //TODO n3423 樋木隆真 不要クラスのため「施設入退所実装時」に削除

    /**
     * 介護事業者指定サービスマスタより、指定されたサービス種類コードのデータ一覧を取得します。
     *
     * @param serviceTypeCd サービス種類コード
     * @return 指定されたサービス種類コードのデータ一覧
     */
    List<KaigoJigyoshaShiteiServiceEntity> select特定のサービス種類コードのサービス種類一覧(RString serviceTypeCd);

    /**
     * 介護事業者指定サービスマスタより、指定された事業者番号を持つ一覧を取得します。
     *
     * @param jigyoshaBango 事業者番号
     * @return 事業者指定サービス一覧
     */
    List<KaigoJigyoshaShiteiServiceEntity> select特定の事業者が提供する指定サービス一覧(KaigoJigyoshaNo jigyoshaBango);

    /**
     * 介護事業者指定サービスマスタより、指定された事業者番号、サービス種類を持つデータを1件取得します。
     *
     * @param jigyoshaBango 事業者番号
     * @param serviceTypeCd サービス種類コード
     * @return 事業者指定サービス
     */
    KaigoJigyoshaShiteiServiceEntity select事業者指定サービス(KaigoJigyoshaNo jigyoshaBango, RString serviceTypeCd);
}
