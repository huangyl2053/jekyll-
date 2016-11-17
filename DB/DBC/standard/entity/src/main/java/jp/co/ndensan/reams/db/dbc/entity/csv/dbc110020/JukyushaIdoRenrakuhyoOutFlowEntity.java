/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110020;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者異動連絡票情報送付対象者リストCSVする。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaIdoRenrakuhyoOutFlowEntity {

    private int 異動連絡票件数;
    private int 訂正連絡票件数;
    private int レコード件数合計;
    private RString 入力ファイルパス;
    private RString 出力ファイルパス;

}
