/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshakannri;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyosha;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBCMNG1002_市町村特別給付・サービス事業者管理のViewStateクラスです。
 *
 * @reamsid_L DBC-3430-010 miaojin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShichosonTokubetsuKyufuJigyoshaViewState implements Serializable {

    private ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者情報;
    private RString state;
    private int rirekiNo;

    /**
     * コンストラクタです。
     *
     * @param 市町村特別給付サービス事業者情報 市町村特別給付サービス事業者情報
     * @param state EntityDataState
     * @param rirekiNo 履歴番号
     */
    public ShichosonTokubetsuKyufuJigyoshaViewState(ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者情報, RString state, int rirekiNo) {
        this.市町村特別給付サービス事業者情報 = 市町村特別給付サービス事業者情報;
        this.state = state;
        this.rirekiNo = rirekiNo;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShichosonTokubetsuKyufuJigyoshaViewStateBuilder createBuilderForEdit() {
        return new ShichosonTokubetsuKyufuJigyoshaViewStateBuilder(市町村特別給付サービス事業者情報, state, rirekiNo);
    }
}
