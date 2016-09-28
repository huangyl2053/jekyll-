/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakujuryoininkeiyakujigyosha;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費等受領委任払情報管理のParameterです。
 *
 * @reamsid_L DBC-1980-010 yuqingzhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuJuryoininKeiyakuJigyoshaParameter {

    private RString 被保険者番号;
    private RString 履歴番号;
}
