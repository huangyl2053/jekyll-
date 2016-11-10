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
public class DoDaTuNenReiSyuToKuEntity {

    private FlexibleDate 取得日work;
    private FlexibleDate 号年齢到達日_1;
    private FlexibleDate 号年齢到達日work_1;
    private FlexibleDate 号年齢到達日_2;
    private RString 年齢区分;
}
