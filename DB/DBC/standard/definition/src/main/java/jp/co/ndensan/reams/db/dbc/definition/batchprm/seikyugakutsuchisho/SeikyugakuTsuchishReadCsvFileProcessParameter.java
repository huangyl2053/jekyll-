/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.seikyugakutsuchisho;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * SeikyugakuTsuchishReadCsvFileProcessパラメータです。
 *
 * @reamsid_L DBC-2480-010 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyugakuTsuchishReadCsvFileProcessParameter implements IBatchProcessParameter {

    private RString 保存先フォルダ;
    private List<RString> エントリ情報List;

}
