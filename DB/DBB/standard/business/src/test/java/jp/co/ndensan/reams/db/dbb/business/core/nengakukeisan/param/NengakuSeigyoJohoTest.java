/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 年額計算で用いる各種制御情報のテストデータ設定クラスです。
 *
 * @author wangchao
 */
public class NengakuSeigyoJohoTest {

    public static NengakuSeigyoJoho set端数調整不要の場合は金額に変更なし(List<HokenryoDankai> hokenryoDankaiList) {
        NengakuSeigyoJoho seigyo = new NengakuSeigyoJoho();
        seigyo.set端数単位(new Decimal("10"));
        seigyo.set端数調整方法(HasuChoseiHoho.valueOf("切り上げ"));
        seigyo.set端数単位_ランク用(new Decimal("100"));
        seigyo.set端数調整方法_ランク用(HasuChoseiHoho.valueOf("切捨て"));
        return seigyo;
    }
}
