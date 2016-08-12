/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.seikyugakutsuchishofutanshain;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * SeikyugakuTsuchishoFutanshaInProcessParameterパラメータです
 *
 * @reamsid_L DBC-2790-011 hemin
 */
@lombok.Getter
@lombok.Setter
public class SeikyugakuTsuchishoFutanshaInProcessParameter implements IBatchProcessParameter {

    private RString 保存先フォルダ;
    private List<RString> エントリ情報List;
}
