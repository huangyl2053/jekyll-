/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者異動連絡票Entity
 *
 * @reamsid_L DBC-2720-090 surun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaIdoRenrakuhyoEntity {

    private RString 出力ファイルパス;
    private int 総出力件数;
    private RString 入力ファイルパス;

}
