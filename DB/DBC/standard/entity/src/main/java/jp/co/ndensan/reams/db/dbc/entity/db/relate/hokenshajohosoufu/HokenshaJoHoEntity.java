/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenshajohosoufu;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 保険者情報送付の共有ファイルエントリ情報クラスです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaJoHoEntity {

    private RString fileName;
    private RDateTime fileId;
}
