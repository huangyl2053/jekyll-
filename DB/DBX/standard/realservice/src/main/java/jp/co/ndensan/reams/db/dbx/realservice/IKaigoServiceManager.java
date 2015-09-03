/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.IKaigoService;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceCode;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceNaiyo;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceShurui;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;

/**
 * 介護サービスに関する情報の検索および登録（新規・修正・削除）機能を提供するインターフェースです。
 * <p>
 * 処理の対象となるテーブルは、介護サービス種類（UrT0522KaigoServiceShurui）、介護サービス内容（UrT0523KaigoServiceNaiyou）です。<br/>
 * このインタフェースのインスタンスは、{@link KaigoServiceManagerFactory#createInstance() }
 * で取得してください。
 * </p>
 * <p>
 * <br/>
 * ■関連テーブル
 * <ul>
 * <li>{@link jp.co.ndensan.reams.ur.urz.entity.basic.UrT0522KaigoServiceShuruiEntity}</li>
 * <li>{@link jp.co.ndensan.reams.ur.urz.entity.basic.UrT0523KaigoServiceNaiyouEntity}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス管理インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass ○
 * @reference
 */
public interface IKaigoServiceManager {

    /**
     * 介護サービス種類を取得します。
     *
     * @param 基準年月 基準年月
     * @return 介護サービス種類List
     */
    List<IKaigoServiceShurui> get介護サービス種類All(FlexibleYearMonth 基準年月);

    /**
     * 介護サービス種類と介護サービス内容を取得します。
     *
     * @param 基準年月 基準年月
     * @param サービス種類 サービス種類
     * @return 介護サービスList
     */
    IKaigoService get介護サービス(FlexibleYearMonth 基準年月, KaigoServiceShuruiCode サービス種類);

    /**
     * 介護サービス種類を取得します。
     *
     * @param 基準年月 基準年月
     * @param サービス分類 サービス分類
     * @return 介護サービス種類List
     */
    List<IKaigoServiceShurui> get介護サービス種類(FlexibleYearMonth 基準年月, RString サービス分類);

    /**
     * 介護サービス種類と介護サービス内容を取得します。
     *
     * @param 基準年月 基準年月
     * @param サービスコード サービスコード
     * @return 介護サービスList
     */
    IKaigoService get介護サービス内容(FlexibleYearMonth 基準年月, IKaigoServiceCode サービスコード);

    /**
     * 介護サービス種類を登録・更新します。
     *
     * @param 介護サービス種類 介護サービス種類
     * @return 登録・更新件数
     */
    int save介護サービス種類(IKaigoServiceShurui 介護サービス種類);

    /**
     * 介護サービス内容を登録・更新します。
     *
     * @param 介護サービス内容 介護サービス内容
     * @return 登録・更新件数
     */
    int save介護サービス内容(IKaigoServiceNaiyo 介護サービス内容);

    /**
     * 介護サービス種類を削除します。<br />
     * 介護サービス種類と同一の種類コードをもった介護サービス内容を削除します。
     *
     * @param 介護サービス種類 介護サービス種類
     * @return 削除件数
     */
    int remove介護サービス種類(IKaigoServiceShurui 介護サービス種類);

    /**
     * 介護サービス内容を削除します。
     *
     * @param 介護サービス内容 介護サービス内容
     * @return 削除件数
     */
    int remove介護サービス内容(IKaigoServiceNaiyo 介護サービス内容);
}
