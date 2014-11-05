/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShisetsuNyushoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TsuchiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.business.IKaigoServiceShurui;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 要介護認定結果を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiResult {

    private final ShinseishoKanriNo 申請書管理番号;
    private final YMDHMS 処理日時;
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final KaigoHihokenshaNo 被保険者番号;
    private final FlexibleDate 要介護度認定年月日;
    private final YokaigoJotai 要介護状態;
    private final YokaigoJotaizoRei 要介護状態像例;
    private final IKaigoServiceShurui 介護サービス種類０１;
    private final IKaigoServiceShurui 介護サービス種類０２;
    private final IKaigoServiceShurui 介護サービス種類０３;
    private final IKaigoServiceShurui 介護サービス種類０４;
    private final IKaigoServiceShurui 介護サービス種類０５;
    private final IKaigoServiceShurui 介護サービス種類０６;
    private final IKaigoServiceShurui 介護サービス種類０７;
    private final IKaigoServiceShurui 介護サービス種類０８;
    private final IKaigoServiceShurui 介護サービス種類０９;
    private final IKaigoServiceShurui 介護サービス種類１０;
    private final IKaigoServiceShurui 介護サービス種類１１;
    private final IKaigoServiceShurui 介護サービス種類１２;
    private final IKaigoServiceShurui 介護サービス種類１３;
    private final IKaigoServiceShurui 介護サービス種類１４;
    private final IKaigoServiceShurui 介護サービス種類１５;
    private final IKaigoServiceShurui 介護サービス種類１６;
    private final IKaigoServiceShurui 介護サービス種類１７;
    private final IKaigoServiceShurui 介護サービス種類１８;
    private final IKaigoServiceShurui 介護サービス種類１９;
    private final IKaigoServiceShurui 介護サービス種類２０;
    private final IKaigoServiceShurui 介護サービス種類２１;
    private final IKaigoServiceShurui 介護サービス種類２２;
    private final IKaigoServiceShurui 介護サービス種類２３;
    private final IKaigoServiceShurui 介護サービス種類２４;
    private final IKaigoServiceShurui 介護サービス種類２５;
    private final IKaigoServiceShurui 介護サービス種類２６;
    private final IKaigoServiceShurui 介護サービス種類２７;
    private final IKaigoServiceShurui 介護サービス種類２８;
    private final IKaigoServiceShurui 介護サービス種類２９;
    private final IKaigoServiceShurui 介護サービス種類３０;
    private final ShisetsuNyushoKubun 施設入所区分;
    private final TokuteiShippei 特定疾病;
    private final NinteiShinsakaiIken 認定審査会意見;
    private final NinteiResultIdo 認定結果異動;
    private final NinteiTorikeshi 認定取消;
    private final TsuchiKubun 通知区分;
    private final RString 認定理由;
    private final FlexibleDate IF送付年月日;

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 処理日時 処理日時
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 要介護度認定年月日 要介護度認定年月日
     * @param 要介護状態 要介護状態
     * @param 要介護状態像例 要介護状態像例
     * @param 介護サービス種類 介護サービス種類
     * @param 施設入所区分 施設入所区分
     * @param 特定疾病 特定疾病
     * @param 認定審査会意見 認定審査会意見
     * @param 認定結果異動 認定結果異動
     * @param 認定取消 認定取消
     * @param 認定理由 認定理由
     * @param IF送付年月日 IF送付年月日
     */
    public NinteiResult(
            ShinseishoKanriNo 申請書管理番号,
            YMDHMS 処理日時,
            ShoKisaiHokenshaNo 証記載保険者番号,
            KaigoHihokenshaNo 被保険者番号,
            FlexibleDate 要介護度認定年月日,
            YokaigoJotai 要介護状態,
            YokaigoJotaizoRei 要介護状態像例,
            IKaigoServiceShurui 介護サービス種類０１,
            IKaigoServiceShurui 介護サービス種類０２,
            IKaigoServiceShurui 介護サービス種類０３,
            IKaigoServiceShurui 介護サービス種類０４,
            IKaigoServiceShurui 介護サービス種類０５,
            IKaigoServiceShurui 介護サービス種類０６,
            IKaigoServiceShurui 介護サービス種類０７,
            IKaigoServiceShurui 介護サービス種類０８,
            IKaigoServiceShurui 介護サービス種類０９,
            IKaigoServiceShurui 介護サービス種類１０,
            IKaigoServiceShurui 介護サービス種類１１,
            IKaigoServiceShurui 介護サービス種類１２,
            IKaigoServiceShurui 介護サービス種類１３,
            IKaigoServiceShurui 介護サービス種類１４,
            IKaigoServiceShurui 介護サービス種類１５,
            IKaigoServiceShurui 介護サービス種類１６,
            IKaigoServiceShurui 介護サービス種類１７,
            IKaigoServiceShurui 介護サービス種類１８,
            IKaigoServiceShurui 介護サービス種類１９,
            IKaigoServiceShurui 介護サービス種類２０,
            IKaigoServiceShurui 介護サービス種類２１,
            IKaigoServiceShurui 介護サービス種類２２,
            IKaigoServiceShurui 介護サービス種類２３,
            IKaigoServiceShurui 介護サービス種類２４,
            IKaigoServiceShurui 介護サービス種類２５,
            IKaigoServiceShurui 介護サービス種類２６,
            IKaigoServiceShurui 介護サービス種類２７,
            IKaigoServiceShurui 介護サービス種類２８,
            IKaigoServiceShurui 介護サービス種類２９,
            IKaigoServiceShurui 介護サービス種類３０,
            ShisetsuNyushoKubun 施設入所区分,
            TokuteiShippei 特定疾病,
            NinteiShinsakaiIken 認定審査会意見,
            NinteiResultIdo 認定結果異動,
            NinteiTorikeshi 認定取消,
            TsuchiKubun 通知区分,
            RString 認定理由,
            FlexibleDate IF送付年月日) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        this.処理日時 = requireNonNull(処理日時, Messages.E00001.replace("処理日時").getMessage());
        this.証記載保険者番号 = requireNonNull(証記載保険者番号, Messages.E00001.replace("証記載保険者番号").getMessage());
        this.被保険者番号 = requireNonNull(被保険者番号, Messages.E00001.replace("被保険者番号").getMessage());
        this.要介護度認定年月日 = requireNonNull(要介護度認定年月日, Messages.E00001.replace("要介護度認定年月日").getMessage());
        this.要介護状態 = requireNonNull(要介護状態, Messages.E00001.replace("要介護状態").getMessage());
        this.要介護状態像例 = 要介護状態像例;
        this.介護サービス種類０１ = 介護サービス種類０１;
        this.介護サービス種類０２ = 介護サービス種類０２;
        this.介護サービス種類０３ = 介護サービス種類０３;
        this.介護サービス種類０４ = 介護サービス種類０４;
        this.介護サービス種類０５ = 介護サービス種類０５;
        this.介護サービス種類０６ = 介護サービス種類０６;
        this.介護サービス種類０７ = 介護サービス種類０７;
        this.介護サービス種類０８ = 介護サービス種類０８;
        this.介護サービス種類０９ = 介護サービス種類０９;
        this.介護サービス種類１０ = 介護サービス種類１０;
        this.介護サービス種類１１ = 介護サービス種類１１;
        this.介護サービス種類１２ = 介護サービス種類１２;
        this.介護サービス種類１３ = 介護サービス種類１３;
        this.介護サービス種類１４ = 介護サービス種類１４;
        this.介護サービス種類１５ = 介護サービス種類１５;
        this.介護サービス種類１６ = 介護サービス種類１６;
        this.介護サービス種類１７ = 介護サービス種類１７;
        this.介護サービス種類１８ = 介護サービス種類１８;
        this.介護サービス種類１９ = 介護サービス種類１９;
        this.介護サービス種類２０ = 介護サービス種類２０;
        this.介護サービス種類２１ = 介護サービス種類２１;
        this.介護サービス種類２２ = 介護サービス種類２２;
        this.介護サービス種類２３ = 介護サービス種類２３;
        this.介護サービス種類２４ = 介護サービス種類２４;
        this.介護サービス種類２５ = 介護サービス種類２５;
        this.介護サービス種類２６ = 介護サービス種類２６;
        this.介護サービス種類２７ = 介護サービス種類２７;
        this.介護サービス種類２８ = 介護サービス種類２８;
        this.介護サービス種類２９ = 介護サービス種類２９;
        this.介護サービス種類３０ = 介護サービス種類３０;
        this.施設入所区分 = 施設入所区分;
        this.特定疾病 = 特定疾病;
        this.認定審査会意見 = 認定審査会意見;
        this.認定結果異動 = 認定結果異動;
        this.認定取消 = 認定取消;
        this.通知区分 = 通知区分;
        this.認定理由 = 認定理由;
        this.IF送付年月日 = IF送付年月日;
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
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return 処理日時;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return 証記載保険者番号;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public KaigoHihokenshaNo get被保険者番号() {
        return 被保険者番号;
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
     * 介護サービス種類０１を返します。
     *
     * @return 介護サービス種類０１
     */
    public IKaigoServiceShurui get介護サービス種類０１() {
        return 介護サービス種類０１;
    }

    /**
     * 介護サービス種類０２を返します。
     *
     * @return 介護サービス種類０２
     */
    public IKaigoServiceShurui get介護サービス種類０２() {
        return 介護サービス種類０２;
    }

    /**
     * 介護サービス種類０３を返します。
     *
     * @return 介護サービス種類０３
     */
    public IKaigoServiceShurui get介護サービス種類０３() {
        return 介護サービス種類０３;
    }

    /**
     * 介護サービス種類０４を返します。
     *
     * @return 介護サービス種類０４
     */
    public IKaigoServiceShurui get介護サービス種類０４() {
        return 介護サービス種類０４;
    }

    /**
     * 介護サービス種類０５を返します。
     *
     * @return 介護サービス種類０５
     */
    public IKaigoServiceShurui get介護サービス種類０５() {
        return 介護サービス種類０５;
    }

    /**
     * 介護サービス種類０６を返します。
     *
     * @return 介護サービス種類０６
     */
    public IKaigoServiceShurui get介護サービス種類０６() {
        return 介護サービス種類０６;
    }

    /**
     * 介護サービス種類０７を返します。
     *
     * @return 介護サービス種類０７
     */
    public IKaigoServiceShurui get介護サービス種類０７() {
        return 介護サービス種類０７;
    }

    /**
     * 介護サービス種類０８を返します。
     *
     * @return 介護サービス種類０８
     */
    public IKaigoServiceShurui get介護サービス種類０８() {
        return 介護サービス種類０８;
    }

    /**
     * 介護サービス種類０９を返します。
     *
     * @return 介護サービス種類０９
     */
    public IKaigoServiceShurui get介護サービス種類０９() {
        return 介護サービス種類０９;
    }

    /**
     * 介護サービス種類１０を返します。
     *
     * @return 介護サービス種類１０
     */
    public IKaigoServiceShurui get介護サービス種類１０() {
        return 介護サービス種類１０;
    }

    /**
     * 介護サービス種類１１を返します。
     *
     * @return 介護サービス種類１１
     */
    public IKaigoServiceShurui get介護サービス種類１１() {
        return 介護サービス種類１１;
    }

    /**
     * 介護サービス種類１２を返します。
     *
     * @return 介護サービス種類１２
     */
    public IKaigoServiceShurui get介護サービス種類１２() {
        return 介護サービス種類１２;
    }

    /**
     * 介護サービス種類１３を返します。
     *
     * @return 介護サービス種類１３
     */
    public IKaigoServiceShurui get介護サービス種類１３() {
        return 介護サービス種類１３;
    }

    /**
     * 介護サービス種類１４を返します。
     *
     * @return 介護サービス種類１４
     */
    public IKaigoServiceShurui get介護サービス種類１４() {
        return 介護サービス種類１４;
    }

    /**
     * 介護サービス種類１５を返します。
     *
     * @return 介護サービス種類１５
     */
    public IKaigoServiceShurui get介護サービス種類１５() {
        return 介護サービス種類１５;
    }

    /**
     * 介護サービス種類１６を返します。
     *
     * @return 介護サービス種類１６
     */
    public IKaigoServiceShurui get介護サービス種類１６() {
        return 介護サービス種類１６;
    }

    /**
     * 介護サービス種類１７を返します。
     *
     * @return 介護サービス種類１７
     */
    public IKaigoServiceShurui get介護サービス種類１７() {
        return 介護サービス種類１７;
    }

    /**
     * 介護サービス種類１８を返します。
     *
     * @return 介護サービス種類１８
     */
    public IKaigoServiceShurui get介護サービス種類１８() {
        return 介護サービス種類１８;
    }

    /**
     * 介護サービス種類１９を返します。
     *
     * @return 介護サービス種類１９
     */
    public IKaigoServiceShurui get介護サービス種類１９() {
        return 介護サービス種類１９;
    }

    /**
     * 介護サービス種類２０を返します。
     *
     * @return 介護サービス種類２０
     */
    public IKaigoServiceShurui get介護サービス種類２０() {
        return 介護サービス種類２０;
    }

    /**
     * 介護サービス種類２１を返します。
     *
     * @return 介護サービス種類２１
     */
    public IKaigoServiceShurui get介護サービス種類２１() {
        return 介護サービス種類２１;
    }

    /**
     * 介護サービス種類２２を返します。
     *
     * @return 介護サービス種類２２
     */
    public IKaigoServiceShurui get介護サービス種類２２() {
        return 介護サービス種類２２;
    }

    /**
     * 介護サービス種類２３を返します。
     *
     * @return 介護サービス種類２３
     */
    public IKaigoServiceShurui get介護サービス種類２３() {
        return 介護サービス種類２３;
    }

    /**
     * 介護サービス種類２４を返します。
     *
     * @return 介護サービス種類２４
     */
    public IKaigoServiceShurui get介護サービス種類２４() {
        return 介護サービス種類２４;
    }

    /**
     * 介護サービス種類２５を返します。
     *
     * @return 介護サービス種類２５
     */
    public IKaigoServiceShurui get介護サービス種類２５() {
        return 介護サービス種類２５;
    }

    /**
     * 介護サービス種類２６を返します。
     *
     * @return 介護サービス種類２６
     */
    public IKaigoServiceShurui get介護サービス種類２６() {
        return 介護サービス種類２６;
    }

    /**
     * 介護サービス種類２７を返します。
     *
     * @return 介護サービス種類２７
     */
    public IKaigoServiceShurui get介護サービス種類２７() {
        return 介護サービス種類２７;
    }

    /**
     * 介護サービス種類２８を返します。
     *
     * @return 介護サービス種類２８
     */
    public IKaigoServiceShurui get介護サービス種類２８() {
        return 介護サービス種類２８;
    }

    /**
     * 介護サービス種類２９を返します。
     *
     * @return 介護サービス種類２９
     */
    public IKaigoServiceShurui get介護サービス種類２９() {
        return 介護サービス種類２９;
    }

    /**
     * 介護サービス種類３０を返します。
     *
     * @return 介護サービス種類３０
     */
    public IKaigoServiceShurui get介護サービス種類３０() {
        return 介護サービス種類３０;
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
     * 特定疾病を返します。
     *
     * @return 特定疾病
     */
    public TokuteiShippei get特定疾病() {
        return 特定疾病;
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
     * 通知区分を返します。
     *
     * @return 通知区分
     */
    public TsuchiKubun get通知区分() {
        return 通知区分;
    }

    /**
     * 認定理由を返します。
     *
     * @return 認定理由
     */
    public RString get認定理由() {
        return 認定理由;
    }

    /**
     * IF送付年月日を返します。
     *
     * @return IF送付年月日
     */
    public FlexibleDate getIF送付年月日() {
        return IF送付年月日;
    }
}
