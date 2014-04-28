/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link HihokenshaForSearchResult}のDataGridで保持する項目をまとめたインタフェースです。
 *
 * @author N3327 三浦 凌
 */
public interface IHihokenshaForSearchResult {

    /**
     * 被保番号を返します。
     *
     * @return 被保番号
     */
    RString hihokenshaNo();

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    RString shikibetsuCode();

    /**
     * 被保険者区分を返します。
     *
     * @return 被保険者区分
     */
    RString hihokenshaKubun();

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    RString shimei();

    /**
     * カナ氏名を返します。
     *
     * @return カナ氏名
     */
    RString kanaShimei();

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    RString gender();

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    RDate birthDay();

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    RString jusho();

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    RString yubinNo();

    /**
     * 個人番号を返します。
     *
     * @return 個人番号
     */
    RString kojinNo();

    /**
     * 住民種別を返します。
     *
     * @return 住民種別
     */
    RString juminShubetsu();

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    RString setaiCode();

}
