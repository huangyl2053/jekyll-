/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceTypeCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者の検索機能を提供するインタフェースです。
 * <p>
 * 処理の対象となるテーブルは、介護事業者（KaigoJigyosha）、介護事業者指定サービス（KaigoJigyoshaShiteiService）です。<br
 * />
 * このインタフェースのインスタンスは、{@link KaigoJigyoshaFinderFactory#getInstance() }
 * で取得してください。
 * </p>
 * <p>
 * <br/>
 * ■関連テーブル
 * <ul>
 * <li>{@link jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaEntity}</li>
 * <li>{@link jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaShiteiServiceEntity}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者取得インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass ○
 * @reference
 * @deprecated {@link IKaigoJigyoshaRelateFinder}を使用してください。
 */
public interface IKaigoJigyoshaFinder {
    //TODO n3423 樋木隆真 不要クラスのため、新ビジネス対応時に削除

    /**
     * 引数で指定したサービス種類コードのサービスを提供している介護事業者リストを取得します。
     *
     * @param serviceTypeCd サービス種類コード
     *
     * @return 指定したサービス種類コードのサービスを提供している介護事業者のリスト
     */
    List<IKaigoJigyosha> get特定の指定サービスを含む事業者一覧(IKaigoServiceTypeCode serviceTypeCd);

    /**
     * 指定した事業者番号に該当する介護事業者を取得します。
     *
     * @param jigyoshaBango 事業者番号
     *
     * @return 指定された条件に合致する介護事業者
     */
    IKaigoJigyosha get特定の事業者番号の介護事業者(RString jigyoshaBango);

    /**
     * 指定した事業者番号と有効開始年月日に該当する介護事業者を取得します。
     *
     * @param jigyoshaBango 事業者番号
     * @param 有効開始年月日 有効開始年月日
     *
     * @return 指定された条件に合致する介護事業者
     */
    IKaigoJigyosha get特定の事業者番号の介護事業者(RString jigyoshaBango, FlexibleDate 有効開始年月日);
}
