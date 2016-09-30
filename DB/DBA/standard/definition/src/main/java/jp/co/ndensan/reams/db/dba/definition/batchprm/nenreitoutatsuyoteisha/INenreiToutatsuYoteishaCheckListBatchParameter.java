/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.nenreitoutatsuyoteisha;

import jp.co.ndensan.reams.db.dba.definition.processprm.nenreitoutatsuyoteisha.INenreiToutatsuYoteishaCheckListProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 年齢到達予定者チェックリストのBatchParameterクラスです。
 *
 * @reamsid_L DBA-0580-020 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class INenreiToutatsuYoteishaCheckListBatchParameter extends BatchParameterBase {

    private static final String KEY_SYUTSURYOKUTAISYO = "syutsuryokutaisyo";
    private static final String KEY_KOUMOKUMEIFLG = "koumokumeiflg";
    private static final String KEY_RENBANFUKAFLG = "renbanfukaflg";
    private static final String KEY_NICHIHENSYUFLG = "nichihensyuflg";
    private static final String KEY_JUMINSHUBETSU = "juminShubetsu";
    private static final String KEY_KONKAIKAISHI = "konkaikaishi";
    private static final String KEY_KONKAISYURYO = "konkaisyuryo";
    private static final String KEY_SHUTSURYOKUJUNID = "shutsuryokujunId";

    @BatchParameter(key = KEY_SYUTSURYOKUTAISYO, name = "出力対象者")
    private RString syutsuryokutaisyo;
    @BatchParameter(key = KEY_KOUMOKUMEIFLG, name = "項目名付加フラグ")
    private boolean koumokumeiflg;
    @BatchParameter(key = KEY_RENBANFUKAFLG, name = "連番付加フラグ")
    private boolean renbanfukaflg;
    @BatchParameter(key = KEY_NICHIHENSYUFLG, name = "日付'/'編集フラグ")
    private boolean nichihensyuflg;
    @BatchParameter(key = KEY_JUMINSHUBETSU, name = "住民種別")
    private RString juminShubetsu;
    @BatchParameter(key = KEY_KONKAIKAISHI, name = "今回開始日")
    private FlexibleDate konkaikaishi;
    @BatchParameter(key = KEY_KONKAISYURYO, name = "今回終了日")
    private FlexibleDate konkaisyuryo;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = "出力順ID")
    private Long shutsuryokujunId;

    /**
     * コンストラクタです。
     */
    public INenreiToutatsuYoteishaCheckListBatchParameter() {
    }

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
    public INenreiToutatsuYoteishaCheckListBatchParameter(RString syutsuryokutaisyo, boolean koumokumeiflg,
            boolean renbanfukaflg, boolean nichihensyuflg, RString juminShubetsu, FlexibleDate konkaikaishi,
            FlexibleDate konkaisyuryo, Long shutsuryokujunId) {
        this.syutsuryokutaisyo = syutsuryokutaisyo;
        this.koumokumeiflg = koumokumeiflg;
        this.renbanfukaflg = renbanfukaflg;
        this.nichihensyuflg = nichihensyuflg;
        this.juminShubetsu = juminShubetsu;
        this.konkaikaishi = konkaikaishi;
        this.konkaisyuryo = konkaisyuryo;
        this.shutsuryokujunId = shutsuryokujunId;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public INenreiToutatsuYoteishaCheckListProcessParameter toNenreiToutatsuYoteishaCheckListProcessParameter() {
        return new INenreiToutatsuYoteishaCheckListProcessParameter(syutsuryokutaisyo, koumokumeiflg,
                renbanfukaflg, nichihensyuflg, juminShubetsu, konkaikaishi,
                konkaisyuryo, shutsuryokujunId);
    }

}
