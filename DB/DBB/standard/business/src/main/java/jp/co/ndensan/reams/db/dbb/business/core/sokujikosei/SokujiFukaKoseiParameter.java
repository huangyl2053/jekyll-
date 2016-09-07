/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.sokujikosei;

import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.NendobunFukaList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 即時賦課更正処理用のパラメータクラスです。
 *
 * @reamsid_L DBB-0660-020 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokujiFukaKoseiParameter {

    private FlexibleYear 賦課年度;
    private HihokenshaNo 被保険者番号;
    private TsuchishoNo 通知書番号;
    private Decimal 更正後減免額;
    private NendobunFukaList 更正後年度分賦課リスト;
    private ChoshuHoho 更正後徴収方法;
    private HihokenshaDaicho 資格の情報;
}
