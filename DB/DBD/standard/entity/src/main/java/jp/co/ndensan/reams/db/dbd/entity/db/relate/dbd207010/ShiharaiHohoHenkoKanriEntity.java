/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 支払方法変更管理リストEntiyクラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoKanriEntity {

    private FlexibleDate 基準日;
    private Long 登録者選択;
    private Long 差止予告登録者２号の選択;
    private Long 差止登録者２号の選択;
    private Long 償還予告登録者１号の選択;
    private Long 償還決定登録者１号の選択;
    private Long 償還決定登録者１号_差止中あり者のみの選択;
    private Long 償還決定登録者１号_保険料控除あり者のみの選択;
    private Long 改頁出力順ID;
    private Long 帳票分類ID;
    private ReportId 帳票ID;
    private Long 帳票作成日時;
}
