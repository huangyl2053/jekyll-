/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendotennyu;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民異動連動資格登録_転入Entityクラスです。
 *
 * @reamsid_L DBA-1410-012 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TennyuuMaeparametaEntity {

    private FlexibleDate 登録異動日;
    private FlexibleDate 登録届出日;
    private boolean is広域;
    private FlexibleDate 年齢到達日;
    private int 年齢;
    private RString 処理対象区分;
}
