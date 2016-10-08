/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.nenreitoutatsuyoteisha;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitoutatsuyoteisha.INenreiToutatsuYoteishaCheckListMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 年齢到達予定者チェックリストののバッチ処理クラスのパラメータです。
 *
 * @reamsid_L DBA-0580-020 yaodongsheng
 * @deprecated 削除予定. {@link jp.co.ndensan.reams.db.dba.definition.processprm.dba120010.INenreiToutatsuYoteishaCheckListProcessParameter}を利用してください。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class INenreiToutatsuYoteishaCheckListProcessParameter implements IBatchProcessParameter {

    private RString syutsuryokutaisyo;
    private boolean koumokumeiflg;
    private boolean renbanfukaflg;
    private boolean nichihensyuflg;
    private RString juminShubetsu;
    private FlexibleDate konkaikaishi;
    private FlexibleDate konkaisyuryo;
    private Long shutsuryokujunId;

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
    public INenreiToutatsuYoteishaCheckListProcessParameter(RString syutsuryokutaisyo, boolean koumokumeiflg,
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
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public INenreiToutatsuYoteishaCheckListMybatisParameter toINenreiToutatsuYoteishaCheckListMybatisParameter() {
        return new INenreiToutatsuYoteishaCheckListMybatisParameter(syutsuryokutaisyo, koumokumeiflg,
                renbanfukaflg, nichihensyuflg, juminShubetsu, konkaikaishi,
                konkaisyuryo, shutsuryokujunId);
    }
}
