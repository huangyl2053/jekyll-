/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601004;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshohoshushokaiichiran.IkenshoHoshuShokaiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshohoshushokai.IkenHoshuIchiranProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 意見書作成報酬照会の合計額リスト_バッチフロークラスパラメータクラスです。
 *
 * @reamsid_L DBE-1930-020 chenxiangyu
 */
@Setter
@Getter
public class DBE601004_IkenshosakuseiHoshuParameter extends BatchParameterBase {

    private static final String KEY_SYOHYO_SYUTURYOKU = "syohyoSyuturyoku";
    private static final String KEY_IRAISHO_SAKUSEI_IRAI_FROM = "iraishoSakuseiIraiFrom";
    private static final String KEY_IRAISHO_SAKUSEI_IRAI_TO = "iraishoSakuseiIraiTo";
    private static final String KEY_JOHO = "keyJoho";
    private static final long serialVersionUID = 7174093335006943966L;

    @BatchParameter(key = KEY_SYOHYO_SYUTURYOKU, name = "帳票出力区分")
    private RString syohyoSyuturyoku;
    @BatchParameter(key = KEY_IRAISHO_SAKUSEI_IRAI_FROM, name = "作成依頼日期間開始")
    private FlexibleDate iraishoSakuseiIraiFrom;
    @BatchParameter(key = KEY_IRAISHO_SAKUSEI_IRAI_TO, name = "作成依頼日期間終了")
    private FlexibleDate iraishoSakuseiIraiTo;
    @BatchParameter(key = KEY_JOHO, name = "キー情報Entityリスト")
    private List<IkenshoHoshuShokaiIchiranKey> keyJoho;

    /**
     * コンストラクタです。
     *
     * @param syohyoSyuturyoku 帳票出力区分
     * @param iraishoSakuseiIraiFrom 作成依頼日期間開始
     * @param iraishoSakuseiIraiTo 作成依頼日期間終了
     * @param keyJoho キー情報Entityリスト
     */
    public DBE601004_IkenshosakuseiHoshuParameter(
            RString syohyoSyuturyoku,
            FlexibleDate iraishoSakuseiIraiFrom,
            FlexibleDate iraishoSakuseiIraiTo,
            List<IkenshoHoshuShokaiIchiranKey> keyJoho) {
        this.syohyoSyuturyoku = syohyoSyuturyoku;
        this.iraishoSakuseiIraiFrom = iraishoSakuseiIraiFrom;
        this.iraishoSakuseiIraiTo = iraishoSakuseiIraiTo;
        this.keyJoho = keyJoho;
    }

    /**
     * コンストラクタです。
     */
    public DBE601004_IkenshosakuseiHoshuParameter() {
    }

    /**
     * 主治医意見書作成実績集計表のProcessParameterを作成します
     *
     * @return 主治医意見書作成実績集計表のProcessParameter
     */
    public IkenHoshuIchiranProcessParameter toProcessParamter() {
        return new IkenHoshuIchiranProcessParameter(syohyoSyuturyoku,
                iraishoSakuseiIraiFrom,
                iraishoSakuseiIraiTo,
                keyJoho);
    }

}
