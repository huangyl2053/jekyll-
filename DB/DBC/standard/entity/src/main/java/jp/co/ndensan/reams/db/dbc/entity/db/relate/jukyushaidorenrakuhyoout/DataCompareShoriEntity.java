/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout;

import lombok.Getter;
import lombok.Setter;

/**
 * データ比較処理エンティティ。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DataCompareShoriEntity {

    private JukyushaIdoRenrakuhyoTempTBLEntity 受給者異動送付;
    private IdoTblTmpEntity 異動一時2;
}
