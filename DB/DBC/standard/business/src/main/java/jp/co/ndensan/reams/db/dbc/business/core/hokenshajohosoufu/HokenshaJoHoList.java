/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hokenshajohosoufu;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 保険者情報送付の保険者情報リストクラスです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaJoHoList implements Serializable {

    private RString ファイル名の先頭6桁;
    private List<RString> 共有ファイル名;
}
