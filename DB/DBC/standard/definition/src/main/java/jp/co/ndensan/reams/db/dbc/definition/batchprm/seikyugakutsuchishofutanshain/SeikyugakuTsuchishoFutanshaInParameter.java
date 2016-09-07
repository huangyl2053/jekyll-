/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.seikyugakutsuchishofutanshain;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込・公費負担者分）batchParameterクラスです
 *
 * @reamsid_L DBC-2790-011 hemin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyugakuTsuchishoFutanshaInParameter extends BatchParameterBase {

    private RString 保存先フォルダ;
    private List<RString> エントリ情報List;

}
