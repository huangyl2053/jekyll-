/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.kogakugassanjikofutangakushomeishoin;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 額合算自己負担額証明書情報または高額合算自己負担額確認情報
 *
 * @reamsid_L DBC-2640-011 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJikofutangakuShomeishoInParamerter extends BatchParameterBase {

    private RString 保存先フォルダ;
    private List<RString> エントリ情報List;

}
