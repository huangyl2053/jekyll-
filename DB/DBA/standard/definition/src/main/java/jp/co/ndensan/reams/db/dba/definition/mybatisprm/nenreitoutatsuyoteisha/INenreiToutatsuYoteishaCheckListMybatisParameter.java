/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitoutatsuyoteisha;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 年齢到達予定者チェックリストのMyBatisパラメータ。
 *
 * @reamsid_L DBA-0580-020 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class INenreiToutatsuYoteishaCheckListMybatisParameter implements IMyBatisParameter {

    private final RString syutsuryokutaisyo;
    private final boolean koumokumeiflg;
    private final boolean renbanfukaflg;
    private final boolean nichihensyuflg;
    private final RString juminShubetsu;
    private final FlexibleDate konkaikaishi;
    private final FlexibleDate konkaisyuryo;
    private final RString shutsuryokujunId;

    /**
     * コンストラクタです。<br/>
     *
     * @param syutsuryokutaisyo 出力対象者
     * @param koumokumeiflg 項目名付加フラグ
     * @param renbanfukaflg 連番付加フラグ
     * @param nichihensyuflg 日付'/'編集フラグ
     * @param juminShubetsu 住民種別
     * @param konkaikaishi 今回開始日
     * @param konkaisyuryo 今回終了日
     * @param shutsuryokujunId 出力順ID
     */
    public INenreiToutatsuYoteishaCheckListMybatisParameter(RString syutsuryokutaisyo, boolean koumokumeiflg,
            boolean renbanfukaflg, boolean nichihensyuflg, RString juminShubetsu, FlexibleDate konkaikaishi,
            FlexibleDate konkaisyuryo, RString shutsuryokujunId) {
        this.syutsuryokutaisyo = syutsuryokutaisyo;
        this.koumokumeiflg = koumokumeiflg;
        this.renbanfukaflg = renbanfukaflg;
        this.nichihensyuflg = nichihensyuflg;
        this.juminShubetsu = juminShubetsu;
        this.konkaikaishi = konkaikaishi;
        this.konkaisyuryo = konkaisyuryo;
        this.shutsuryokujunId = shutsuryokujunId;
    }
}
