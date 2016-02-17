/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 世帯員所得情報を管理するクラスです。
 */
public class SetaiinShotoku {

    private final ShikibetsuCode 識別コード;
    private final HihokenshaNo 被保険者番号;
    private final RString 氏名;
    private final RString カナ氏名;
    private final FlexibleDate 生年月日;
    private final RString 性別コード;
    private final RString 性別;
    private final RString 続柄コード;
    private final RString 続柄;
    private final RString 種別コード;
    private final RString 種別;
    private final RString 課税区分_住民税減免前;
    private final RString 課税区分_住民税減免後;
    private final RString 激変緩和措置;
    private final Decimal 合計所得金額;
    private final Decimal 年金収入額;
    private final Decimal 年金所得額;
    private final Decimal 課税所得額;
    private final RString 登録業務;
    private final FlexibleDate 更正日;
    private final boolean 同月サービス有無;
    private final FlexibleDate 住民情報_異動日;
    private final FlexibleDate 住民情報_住定日;
    private final RString 住民情報_異動事由コード;
    private final RString 住民情報_異動事由;
    private final int 住民票表示順;
    private final RString 本人区分;
    private final RString 世帯コード;

    /**
     * コンストラクタです。<br/>
     * 世帯員情報の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param カナ氏名 カナ氏名
     * @param 氏名 氏名
     * @param 生年月日 生年月日
     * @param 性別コード 性別コード
     * @param 性別 性別
     * @param 続柄コード 続柄コード
     * @param 続柄 続柄
     * @param 種別コード 種別コード
     * @param 種別 種別
     * @param 課税区分_住民税減免前 課税区分_住民税減免前
     * @param 課税区分_住民税減免後 課税区分_住民税減免後
     * @param 激変緩和措置 激変緩和措置
     * @param 合計所得金額 合計所得金額
     * @param 年金収入額 年金収入額
     * @param 課税所得額 課税所得額
     * @param 年金所得額 年金所得額
     * @param 更正日 更正日
     * @param 登録業務 登録業務
     * @param 同月サービス有無 同月サービス有無
     * @param 住民情報_異動日 住民情報_異動日
     * @param 住民情報_住定日 住民情報_住定日
     * @param 住民情報_異動事由コード 住民情報_異動事由コード
     * @param 住民情報_異動事由 住民情報_異動事由
     * @param 住民票表示順 住民票表示順
     * @param 本人区分 本人区分
     * @param 世帯コード 世帯コード
     */
    public SetaiinShotoku(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, RString 氏名, RString カナ氏名, FlexibleDate 生年月日,
            RString 性別コード, RString 性別, RString 続柄コード, RString 続柄, RString 種別コード, RString 種別,
            RString 課税区分_住民税減免前, RString 課税区分_住民税減免後, RString 激変緩和措置,
            Decimal 合計所得金額, Decimal 年金収入額, Decimal 年金所得額, Decimal 課税所得額, RString 登録業務, FlexibleDate 更正日,
            boolean 同月サービス有無, FlexibleDate 住民情報_異動日, FlexibleDate 住民情報_住定日,
            RString 住民情報_異動事由コード, RString 住民情報_異動事由, int 住民票表示順, RString 本人区分, RString 世帯コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        this.識別コード = 識別コード;
        this.被保険者番号 = 被保険者番号;
        this.氏名 = 氏名;
        this.カナ氏名 = カナ氏名;
        this.生年月日 = 生年月日;
        this.性別コード = 性別コード;
        this.性別 = 性別;
        this.続柄コード = 続柄コード;
        this.続柄 = 続柄;
        this.種別コード = 種別コード;
        this.種別 = 種別;
        this.課税区分_住民税減免前 = 課税区分_住民税減免前;
        this.課税区分_住民税減免後 = 課税区分_住民税減免後;
        this.激変緩和措置 = 激変緩和措置;
        this.合計所得金額 = 合計所得金額;
        this.年金収入額 = 年金収入額;
        this.年金所得額 = 年金所得額;
        this.課税所得額 = 課税所得額;
        this.登録業務 = 登録業務;
        this.更正日 = 更正日;
        this.同月サービス有無 = 同月サービス有無;
        this.住民情報_異動日 = 住民情報_異動日;
        this.住民情報_住定日 = 住民情報_住定日;
        this.住民情報_異動事由コード = 住民情報_異動事由コード;
        this.住民情報_異動事由 = 住民情報_異動事由;
        this.住民票表示順 = 住民票表示順;
        this.本人区分 = 本人区分;
        this.世帯コード = 世帯コード;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return 氏名;
    }

    /**
     * カナ氏名を返します。
     *
     * @return カナ氏名
     */
    public RString getカナ氏名() {
        return カナ氏名;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return 生年月日;
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return 性別コード;
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return 性別;
    }

    /**
     * 続柄コードを返します。
     *
     * @return 続柄コード
     */
    public RString get続柄コード() {
        return 続柄コード;
    }

    /**
     * 続柄を返します。
     *
     * @return 続柄
     */
    public RString get続柄() {
        return 続柄;
    }

    /**
     * 種別コードを返します。
     *
     * @return 種別コード
     */
    public RString get種別コード() {
        return 種別コード;
    }

    /**
     * 種別を返します。
     *
     * @return 種別
     */
    public RString get種別() {
        return 種別;
    }

    /**
     * 課税区分_住民税減免前を返します。
     *
     * @return 課税区分_住民税減免前
     */
    public RString get課税区分_住民税減免前() {
        return 課税区分_住民税減免前;
    }

    /**
     * 課税区分_住民税減免後を返します。
     *
     * @return 課税区分_住民税減免後
     */
    public RString get課税区分_住民税減免後() {
        return 課税区分_住民税減免後;
    }

    /**
     * 激変緩和措置を返します。
     *
     * @return 激変緩和措置
     */
    public RString get激変緩和措置() {
        return 激変緩和措置;
    }

    /**
     * 合計所得金額を返します。
     *
     * @return 合計所得金額
     */
    public Decimal get合計所得金額() {
        return 合計所得金額;
    }

    /**
     * 年金収入額を返します。
     *
     * @return 年金収入額
     */
    public Decimal get年金収入額() {
        return 年金収入額;
    }

    /**
     * 年金所得額を返します。
     *
     * @return 年金所得額
     */
    public Decimal get年金所得額() {
        return 年金所得額;
    }

    /**
     * 課税所得額を返します。
     *
     * @return 課税所得額
     */
    public Decimal get課税所得額() {
        return 課税所得額;
    }

    /**
     * 登録業務を返します。
     *
     * @return 登録業務
     */
    public RString get登録業務() {
        return 登録業務;
    }

    /**
     * 更正日を返します。
     *
     * @return 更正日
     */
    public FlexibleDate get更正日() {
        return 更正日;
    }

    /**
     * 同月サービス有無を返します。
     *
     * @return 同月サービス有無
     */
    public boolean get同月サービス有無() {
        return 同月サービス有無;
    }

    /**
     * 住民情報_異動日を返します。
     *
     * @return 住民情報_異動日
     */
    public FlexibleDate get住民情報_異動日() {
        return 住民情報_異動日;
    }

    /**
     * 住民情報_住定日を返します。
     *
     * @return 住民情報_住定日
     */
    public FlexibleDate get住民情報_住定日() {
        return 住民情報_住定日;
    }

    /**
     * 住民情報_異動事由コードを返します。
     *
     * @return 住民情報_異動事由コード
     */
    public RString get住民情報_異動事由コード() {
        return 住民情報_異動事由コード;
    }

    /**
     * 住民情報_異動事由を返します。
     *
     * @return 住民情報_異動事由
     */
    public RString get住民情報_異動事由() {
        return 住民情報_異動事由;
    }

    /**
     * 住民票表示順を返します。
     *
     * @return 住民票表示順
     */
    public int get住民票表示順() {
        return 住民票表示順;
    }

    /**
     * 本人区分を返します。
     *
     * @return 本人区分
     */
    public RString get本人区分() {
        return 本人区分;
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public RString get世帯コード() {
        return 世帯コード;
    }
}
