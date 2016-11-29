/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 更正処理コア用のパラメータクラスです。
 *
 * @reamsid_L DBB-0660-030 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiShorikoaParameter {

    private FlexibleYear 賦課年度;
    private YMDHMS 調定日時;
    private NendobunFukaList 年度分賦課リスト_更正前;
    private ChoshuHoho 徴収方法の情報_更正前;
    private HihokenshaDaicho 資格の情報;
    private List<SetaiinShotoku> 世帯員所得情報List;
    private List<SeikatsuHogoJukyusha> 生保の情報のリスト;
    private List<RoreiFukushiNenkinJukyusha> 老福の情報のリスト;
    private List<KyokaisoGaitosha> 境界層の情報のリスト;
    private List<Koza> 口座のリスト;
    private HokenryoDankaiList 保険料段階リスト;
    private List<ShoriDateKanri> 処理状況の情報リスト;

}
