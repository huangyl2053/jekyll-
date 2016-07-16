/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan;

import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 調定計算用のパラメータクラスです。
 *
 * @reamsid_L DBB-0660-030 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CalculateChoteiParameter {

    private FlexibleYear 賦課年度;
    private YMDHMS 調定日時;
    private NendobunFukaList 年度分賦課リスト_更正前;
    private ChoshuHoho 徴収方法の情報_更正前;
    private Decimal 年額保険料;
    private HihokenshaDaicho 資格の情報;
}
