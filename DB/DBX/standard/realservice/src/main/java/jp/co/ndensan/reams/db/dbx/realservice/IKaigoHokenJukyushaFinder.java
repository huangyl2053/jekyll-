/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.IKaigoHokenJukyusha;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 介護保険受給者の検索機能を提供するインタフェースです。
 * <p>
 * 処理の対象となるテーブルは、介護保険受給者（KaigohokenJukyusha）です。<br />
 * このインタフェースのインスタンスは、{@link KaigoHokenJukyushaFactory#createInstance() }
 * で取得してください。
 * </p>
 * <p>
 * <br/>
 * ■関連テーブル
 * <ul>
 * <li>{@link jp.co.ndensan.reams.ur.urz.entity.basic.KaigohokenJukyushaEntity}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author N2806 太田 智之
 * @jpName 介護保険受給者取得インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass ○
 * @reference
 */
public interface IKaigoHokenJukyushaFinder {

    /**
     * 指定した対象者の現在の受給者情報を取得します。<br />
     * 現時点で受給者でない場合はnullを返します。
     *
     * @param 識別コード 識別コード
     *
     * @return 介護保険受給者
     */
    IKaigoHokenJukyusha get要介護受給者(ShikibetsuCode 識別コード);

    /**
     * 指定した対象者の基準日時点での受給者情報を取得します。<br />
     * 指定日時点で受給者でない場合はnullを返します。
     *
     * @param 識別コード 識別コード
     * @param 基準日 基準日
     *
     * @return 介護保険受給者
     */
    IKaigoHokenJukyusha get要介護受給者(ShikibetsuCode 識別コード, RDate 基準日);

    /**
     * 指定した対象者の過去の要介護認定歴を取得します。
     *
     * @param 識別コード 識別コード
     *
     * @return 介護保険受給者
     */
    IKaigoHokenJukyusha get要介護受給者履歴(ShikibetsuCode 識別コード);

    /**
     * 指定した範囲内で一致する現時点での受給者情報をリストで取得します。<br />
     * 現時点で受給者でない場合は対象外です。
     *
     * @param from要介護状態区分 from要介護状態区分
     * @param to要介護状態区分 to要介護状態区分
     *
     * @return 介護保険受給者リスト
     */
    List<IKaigoHokenJukyusha> get要介護受給者リスト(YoKaigoJotaiKubun from要介護状態区分, YoKaigoJotaiKubun to要介護状態区分);
}
