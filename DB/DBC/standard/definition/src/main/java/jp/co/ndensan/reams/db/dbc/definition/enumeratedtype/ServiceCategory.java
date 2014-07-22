/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

/**
 * 給付実績集計の合計対象を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ServiceCategory {

    /**
     * 合計対象が「居宅サービス合計」であることを表します。 <br />
     */
    居宅サービス,
    /**
     * 合計対象が「施設サービス合計」であることを表します。 <br />
     */
    施設サービス,
    /**
     * 合計対象が「地域密着型サービス合計」であることを表します。 <br />
     */
    地域密着型サービス,
    /**
     * 合計対象ではないことを表します。 <br />
     */
    合計対象外;
}
