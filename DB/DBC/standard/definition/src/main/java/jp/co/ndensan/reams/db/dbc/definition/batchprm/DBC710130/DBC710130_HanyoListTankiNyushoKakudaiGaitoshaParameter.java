/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710130;

import jp.co.ndensan.reams.db.dbc.definition.processprm.tankinyushokakudaigaitosha.TankiNyushoKakudaiGaitoshaProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_短期入所拡大該当者のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-3111-020 duanzhanli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710130_HanyoListTankiNyushoKakudaiGaitoshaParameter extends BatchParameterBase {

    private static final String KEY_REPORTID = "帳票ID";
    private static final String KEY_SHUTSURYOKUJUNID = "出力順ID";
    private static final String KEY_SHUTSURYOKUJUNKOMOKUID = "出力順項目ID";
    private static final String KEY_KOMOUKUMEI = "is項目名付加";
    private static final String KEY_RENBANFUKA = "is連番付加";
    private static final String KEY_ISDATEEDIT = "is日付編集";
    private static final String KEY_HONKENSHACODE = "保険者コード";
    private static final String KEY_TYUSYUTUKUBUN = "抽出区分";
    private static final String KEY_TEKIYOKAISHIYMFROM = "適用開始年月From";
    private static final String KEY_TEKIYOKAISHIYMTO = "適用開始年月To";
    private static final String KEY_TEKIYOSHURYOYMFROM = "適用終了年月From";
    private static final String KEY_TEKIYOSHURYOYMTO = "適用終了年月To";
    private static final String KEY_KIKANSU = "限度額管理期間数";

    @BatchParameter(key = KEY_REPORTID, name = "帳票ID")
    private RString 帳票ID;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = "出力順ID")
    private long 出力順ID;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNKOMOKUID, name = "出力順項目ID")
    private RString 出力順項目ID;
    @BatchParameter(key = KEY_KOMOUKUMEI, name = "is項目名付加")
    private boolean is項目名付加;
    @BatchParameter(key = KEY_RENBANFUKA, name = "is連番付加")
    private boolean is連番付加;
    @BatchParameter(key = KEY_ISDATEEDIT, name = "is日付編集")
    private boolean is日付編集;
    @BatchParameter(key = KEY_HONKENSHACODE, name = "保険者コード")
    private RString 保険者コード;
    @BatchParameter(key = KEY_TYUSYUTUKUBUN, name = "抽出区分")
    private RString 抽出区分;
    @BatchParameter(key = KEY_TEKIYOKAISHIYMFROM, name = "適用開始年月From")
    private RString 適用開始年月From;
    @BatchParameter(key = KEY_TEKIYOKAISHIYMTO, name = "適用開始年月To")
    private RString 適用開始年月To;
    @BatchParameter(key = KEY_TEKIYOSHURYOYMFROM, name = "適用終了年月From")
    private RString 適用終了年月From;
    @BatchParameter(key = KEY_TEKIYOSHURYOYMTO, name = "適用終了年月To")
    private RString 適用終了年月To;
    @BatchParameter(key = KEY_KIKANSU, name = "限度額管理期間数")
    private RString 限度額管理期間数;

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public TankiNyushoKakudaiGaitoshaProcessParameter toProcessParameter() {
        return new TankiNyushoKakudaiGaitoshaProcessParameter(帳票ID,
                出力順ID,
                出力順項目ID,
                is項目名付加,
                is連番付加,
                is日付編集,
                保険者コード,
                抽出区分,
                適用開始年月From,
                適用開始年月To,
                適用終了年月From,
                適用終了年月To,
                限度額管理期間数);
    }
}
