/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout;

import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算給付実績情報作成の送付対象データ取得のflowEntity
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SofuTaishoEntity {

    private int 合計;
    private int 総出力件数;
    private SharedFileDescriptor エントリ情報;

}
