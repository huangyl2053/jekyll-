/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KaigoServiceType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShisetsuNyushoKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定結果を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiResult {

    private final ShinseishoKanriNo 申請書管理番号;
    private final FlexibleDate 要介護度認定年月日;
    private final YokaigoJotai 要介護状態;
    private final YokaigoJotaizoRei 要介護状態像例;
    private final KaigoServiceType 介護サービス種類;
    private final ShisetsuNyushoKubun 施設入所区分;
    private final TokuteiShippeiKubun 特定疾病区分;
    private final NinteiShinsakaiIken 認定審査会意見;
    private final NinteiResultIdo 認定結果異動;
    private final NinteiTorikeshi 認定取消;
    private final RString 認定理由;

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護度認定年月日 要介護度認定年月日
     * @param 要介護状態 要介護状態
     * @param 要介護状態像例 要介護状態像例
     * @param 介護サービス種類 介護サービス種類
     * @param 施設入所区分 施設入所区分
     * @param 特定疾病区分 特定疾病区分
     * @param 認定審査会意見 認定審査会意見
     * @param 認定結果異動 認定結果異動
     * @param 認定取消 認定取消
     * @param 認定理由 認定理由
     */
    public NinteiResult(
            ShinseishoKanriNo 申請書管理番号,
            FlexibleDate 要介護度認定年月日,
            YokaigoJotai 要介護状態,
            YokaigoJotaizoRei 要介護状態像例,
            KaigoServiceType 介護サービス種類,
            ShisetsuNyushoKubun 施設入所区分,
            TokuteiShippeiKubun 特定疾病区分,
            NinteiShinsakaiIken 認定審査会意見,
            NinteiResultIdo 認定結果異動,
            NinteiTorikeshi 認定取消,
            RString 認定理由) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        this.要介護度認定年月日 = requireNonNull(要介護度認定年月日, Messages.E00001.replace("要介護度認定年月日").getMessage());
        this.要介護状態 = requireNonNull(要介護状態, Messages.E00001.replace("要介護状態").getMessage());
        this.要介護状態像例 = 要介護状態像例;
        this.介護サービス種類 = 介護サービス種類;
        this.施設入所区分 = 施設入所区分;
        this.特定疾病区分 = 特定疾病区分;
        this.認定審査会意見 = 認定審査会意見;
        this.認定結果異動 = 認定結果異動;
        this.認定取消 = 認定取消;
        this.認定理由 = 認定理由;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
    }

    /**
     * 要介護度認定年月日を返します。
     *
     * @return 要介護度認定年月日
     */
    public FlexibleDate get要介護度認定年月日() {
        return 要介護度認定年月日;
    }

    /**
     * 要介護状態を返します。
     *
     * @return 要介護状態
     */
    public YokaigoJotai get要介護状態() {
        return 要介護状態;
    }

    /**
     * 要介護状態像例を返します。
     *
     * @return 要介護状態像例
     */
    public YokaigoJotaizoRei get要介護状態像例() {
        return 要介護状態像例;
    }

    /**
     * 介護サービス種類を返します。
     *
     * @return 介護サービス種類
     */
    public KaigoServiceType get介護サービス種類() {
        return 介護サービス種類;
    }

    /**
     * 施設入所区分を返します。
     *
     * @return 施設入所区分
     */
    public ShisetsuNyushoKubun get施設入所区分() {
        return 施設入所区分;
    }

    /**
     * 特定疾病区分を返します。
     *
     * @return 特定疾病区分
     */
    public TokuteiShippeiKubun get特定疾病区分() {
        return 特定疾病区分;
    }

    /**
     * 認定審査会意見を返します。
     *
     * @return 認定審査会意見
     */
    public NinteiShinsakaiIken get認定審査会意見() {
        return 認定審査会意見;
    }

    /**
     * 認定結果異動を返します。
     *
     * @return 認定結果異動
     */
    public NinteiResultIdo get認定結果異動() {
        return 認定結果異動;
    }

    /**
     * 認定取消を返します。
     *
     * @return 認定取消
     */
    public NinteiTorikeshi get認定取消() {
        return 認定取消;
    }

    /**
     * 認定理由を返します。
     *
     * @return 認定理由
     */
    public RString get認定理由() {
        return 認定理由;
    }
}
