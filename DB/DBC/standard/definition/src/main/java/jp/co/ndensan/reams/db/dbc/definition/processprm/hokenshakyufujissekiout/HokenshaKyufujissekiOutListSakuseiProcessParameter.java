/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;

/**
 * 処理結果リスト作成iProcessパラメータです。
 *
 * @reamsid_L DBC-2460-011 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaKyufujissekiOutListSakuseiProcessParameter implements IBatchProcessParameter {

    private KokuhorenJoho_SakuseiErrorListType エラーリストタイプ;

}
