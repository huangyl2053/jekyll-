/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohiseikyugakutsuchishokohiin;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * TsuchishoKohiGetFileProcessパラメータです。
 *
 * @reamsid_L DBC-4700-030 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsuchishoKohiGetFileProcessParameter implements IBatchProcessParameter {

    private RString 交換情報識別番号;
    private RString ファイル格納フォルダ名;

}
