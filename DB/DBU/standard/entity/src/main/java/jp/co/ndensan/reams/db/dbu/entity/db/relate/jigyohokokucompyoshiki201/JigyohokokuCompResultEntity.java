/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業報告資料.集計結果値のEntityです。
 *
 * @reamsid_L DBU-5560-040 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompResultEntity {

    private RString 集計番号;
    private RString 給付実績区分コード;
    private int 要支援１;
    private int 要支援２;
    private int 計１;
    private int 非該当;
    private int 経過的要介護;
    private int 要介護１;
    private int 要介護２;
    private int 要介護３;
    private int 要介護４;
    private int 要介護５;
    private int 計２;
    private int 合計;
}
