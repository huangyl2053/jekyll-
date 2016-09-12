/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;

/**
 * DoShoriKekkaListSakuseiProcessパラメータです。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter implements IBatchProcessParameter {

    private KokuhorenJoho_TorikomiErrorListType エラーリストタイプ;

}
