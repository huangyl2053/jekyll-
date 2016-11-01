/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請先頭レコード明細インタフェース。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public interface IShinseiJoho {

    /**
     * レコード種別を返します。
     *
     * @return レコード種別
     */
    RString getレコード種別();

    /**
     * レコード番号を返します。
     *
     * @return レコード番号
     */
    RString getレコード番号();

    /**
     * レコード種別コードを返します。
     *
     * @return レコード種別コード
     */
    RString getレコード種別コード();

    /**
     * 給付実績情報作成区分コードを返します。
     *
     * @return 給付実績情報作成区分コード
     */
    RString get給付実績情報作成区分コード();

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    RString get証記載保険者番号();

    /**
     * 給付実績区分コードを返します。
     *
     * @return 給付実績区分コード
     */
    RString get給付実績区分コード();

    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    RString get交換情報識別番号();

    /**
     * 入力識別番号を返します。
     *
     * @return 入力識別番号
     */
    RString get入力識別番号();

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    RString get被保険者番号();

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    RString getサービス提供年月();

    /**
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    RString get事業所番号();

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    RString get整理番号();

    /**
     * 警告区分コードを返します。
     *
     * @return 警告区分コード
     */
    RString get警告区分コード();

}
