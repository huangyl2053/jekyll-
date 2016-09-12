/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Entity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業報告月報様式_01のBusinessです。
 *
 * @reamsid_L DBU-5560-040 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki201Business {

    private RString 年報月報区分;
    private RString 処理日時;
    private RString 旧市町村区分;
    private RString 保険者コード;
    private RString 保険者名;
    private List<JigyohokokuCompYoshiki201Entity> 事業報告資料;
    private RString 集計年月;

}
