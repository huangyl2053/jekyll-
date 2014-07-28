/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 給付実績居宅サービスを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class KyufuJissekiKyotakuService {

    private final KokanShikibetsuNo 交換情報識別コード;
    private final NyuryokuShikibetsuNo 入力識別コード;
    private final RString レコード種別コード;
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final KaigoHihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス適用年月;
    private final JigyoshaNo 事業者番号;
    private final RString 通し番号;
    private final RString 指定基準該当等事業者区分コード;
    private final FlexibleDate 居宅サービス作成依頼年月日;
    private final RString サービス計画費明細行番号;
    private final Decimal 単位数単価;
    private final ServiceCode サービスコード;
    private final KyotakuServiceSeikyuKingakuJoho 請求金額情報;
    private final RString 担当介護支援専門員番号;
    private final RString 摘要;
    private final KyotakuServiceSeikyuKingakuJoho 後請求金額情報;
    private final int 再審査回数;
    private final int 過誤回数;
    private final FlexibleYearMonth 審査年月;
    private final RString 整理番号;
    private final FlexibleYearMonth 取込年月;

    /**
     * 外部から必要な情報を受け取り、インスタンスを生成します。
     *
     * @param 交換情報識別コード 交換情報識別コード。必須項目
     * @param 入力識別コード 入力識別コード。必須項目
     * @param レコード種別コード レコード種別コード。必須項目
     * @param 証記載保険者番号 証記載保険者番号。必須項目
     * @param 被保険者番号 被保険者番号。必須項目
     * @param サービス適用年月 サービス摘要年月。必須項目
     * @param 事業者番号 事業者番号。必須項目
     * @param 通し番号 通し番号。必須項目
     * @param 指定基準該当等事業者区分コード 指定基準該当等事業者区分コード。必須項目
     * @param 居宅サービス作成依頼年月日 居宅サービス作成依頼年月日。必須項目
     * @param サービス計画費明細行番号 サービス計画費明細行番号。必須項目
     * @param 単位数単価 単位数単価
     * @param サービスコード サービスコード
     * @param 請求金額情報 請求金額情報
     * @param 担当介護支援専門員番号 担当介護支援専門員番号
     * @param 摘要 摘要
     * @param 後請求金額情報 後請求金額情報
     * @param 再審査回数 再審査回数
     * @param 過誤回数 過誤回数
     * @param 審査年月 審査年月
     * @param 整理番号 整理番号
     * @param 取込年月 取込年月
     * @throws NullPointerException 必須の項目にnullが渡されたとき
     * @throws IllegalArgumentException 再審査回数、過誤回数に0より小さい値が渡されたとき
     */
    public KyufuJissekiKyotakuService(KokanShikibetsuNo 交換情報識別コード, NyuryokuShikibetsuNo 入力識別コード,
            RString レコード種別コード, ShoKisaiHokenshaNo 証記載保険者番号, KaigoHihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス適用年月, JigyoshaNo 事業者番号, RString 通し番号, RString 指定基準該当等事業者区分コード,
            FlexibleDate 居宅サービス作成依頼年月日, RString サービス計画費明細行番号, Decimal 単位数単価, ServiceCode サービスコード,
            KyotakuServiceSeikyuKingakuJoho 請求金額情報, RString 担当介護支援専門員番号, RString 摘要,
            KyotakuServiceSeikyuKingakuJoho 後請求金額情報, int 再審査回数, int 過誤回数, FlexibleYearMonth 審査年月,
            RString 整理番号, FlexibleYearMonth 取込年月) throws NullPointerException, IllegalArgumentException {
        requireNonNull(交換情報識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別コード"));
        requireNonNull(入力識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別コード"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス適用年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス適用年月"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(指定基準該当等事業者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("指定基準該当等事業者区分コード"));
        requireNonNull(居宅サービス作成依頼年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス作成依頼年月日"));
        requireNonNull(サービス計画費明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス計画費明細行番号"));
        check0未満(再審査回数, UrErrorMessages.項目に対する制約.getMessage().replace("再審査回数", "0以上"));
        check0未満(過誤回数, UrErrorMessages.項目に対する制約.getMessage().replace("過誤回数", "0以上"));

        this.交換情報識別コード = 交換情報識別コード;
        this.入力識別コード = 入力識別コード;
        this.レコード種別コード = レコード種別コード;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.サービス適用年月 = サービス適用年月;
        this.事業者番号 = 事業者番号;
        this.通し番号 = 通し番号;
        this.指定基準該当等事業者区分コード = 指定基準該当等事業者区分コード;
        this.居宅サービス作成依頼年月日 = 居宅サービス作成依頼年月日;
        this.サービス計画費明細行番号 = サービス計画費明細行番号;
        this.単位数単価 = 単位数単価;
        this.サービスコード = サービスコード;
        this.請求金額情報 = 請求金額情報;
        this.担当介護支援専門員番号 = 担当介護支援専門員番号;
        this.摘要 = 摘要;
        this.後請求金額情報 = 後請求金額情報;
        this.再審査回数 = 再審査回数;
        this.過誤回数 = 過誤回数;
        this.審査年月 = 審査年月;
        this.整理番号 = 整理番号;
        this.取込年月 = 取込年月;
    }

    private int check0未満(int チェック項目, Message エラーメッセージ) {
        if (チェック項目 < 0) {
            throw new IllegalArgumentException(エラーメッセージ.getMessage());
        }
        return チェック項目;
    }

    /**
     * 交換情報識別コードを取得します。
     *
     * @return 交換情報識別コード
     */
    public KokanShikibetsuNo get交換情報識別コード() {
        return 交換情報識別コード;
    }

    /**
     * 入力識別コードを取得します。
     *
     * @return 入力識別コード
     */
    public NyuryokuShikibetsuNo get入力識別コード() {
        return 入力識別コード;
    }

    /**
     * レコード種別コードを取得します。
     *
     * @return レコード種別コード
     */
    public RString getレコード種別コード() {
        return レコード種別コード;
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return 証記載保険者番号;
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public KaigoHihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * サービス摘要年月を取得します。
     *
     * @return サービス摘要年月
     */
    public FlexibleYearMonth getサービス適用年月() {
        return サービス適用年月;
    }

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return 事業者番号;
    }

    /**
     * 通し番号を取得します。
     *
     * @return 通し番号
     */
    public RString get通し番号() {
        return 通し番号;
    }

    /**
     * 指定基準該当等事業者区分コードを取得します。
     *
     * @return 指定基準該当等事業者区分コード
     */
    public RString get指定基準該当等事業者区分コード() {
        return 指定基準該当等事業者区分コード;
    }

    /**
     * 居宅サービス作成依頼年月日を取得します。
     *
     * @return 居宅サービス作成依頼年月日
     */
    public FlexibleDate get居宅サービス作成依頼年月日() {
        return 居宅サービス作成依頼年月日;
    }

    /**
     * サービス計画費明細行番号を取得します。
     *
     * @return サービス計画費明細行番号
     */
    public RString getサービス計画費明細行番号() {
        return サービス計画費明細行番号;
    }

    /**
     * 単位数単価を取得します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価() {
        return 単位数単価;
    }

    /**
     * サービスコードを取得します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード() {
        return サービスコード;
    }

    /**
     * 請求金額情報を取得します。
     *
     * @return 請求金額情報
     */
    public KyotakuServiceSeikyuKingakuJoho get請求金額情報() {
        return 請求金額情報;
    }

    /**
     * 担当介護支援専門員番号を取得します。
     *
     * @return 担当介護支援専門員番号
     */
    public RString get担当介護支援専門員番号() {
        return 担当介護支援専門員番号;
    }

    /**
     * 摘要を取得します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return 摘要;
    }

    /**
     * 後請求金額情報を取得します。
     *
     * @return 後請求金額情報
     */
    public KyotakuServiceSeikyuKingakuJoho get後請求金額情報() {
        return 後請求金額情報;
    }

    /**
     * 再審査回数を取得します。
     *
     * @return 再審査回数
     */
    public int get再審査回数() {
        return 再審査回数;
    }

    /**
     * 過誤回数を取得します。
     *
     * @return 過誤回数
     */
    public int get過誤回数() {
        return 過誤回数;
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return 審査年月;
    }

    /**
     * 整理番号を取得します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return 整理番号;
    }

    /**
     * 取込年月を取得します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return 取込年月;
    }

}
