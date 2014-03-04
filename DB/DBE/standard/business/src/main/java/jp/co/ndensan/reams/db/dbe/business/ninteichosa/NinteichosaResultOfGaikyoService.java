/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GenzaiJokyoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ServiceKubun;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果情報（概況調査サービス状況）を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResultOfGaikyoService {

    private final ServiceKubun サービス区分;
    private final int 訪問介護;
    private final int 訪問入浴介護;
    private final int 訪問看護;
    private final int 訪問リハビリ;
    private final int 居宅療養管理指導;
    private final int 通所介護;
    private final int 通所リハビリテーション;
    private final int 短期入所生活介護;
    private final int 短期入所療養介護;
    private final int 特定施設入居者生活介護;
    private final int 福祉用具貸与;
    private final int 特定福祉用具販売;
    private final int 住宅改修;
    private final int 夜間対応型訪問介護;
    private final int 認知症対応型通所介護;
    private final int 小規模多機能型居宅介護;
    private final int 認知症対応型共同生活介護;
    private final int 地域密着型特定施設入居者生活介護;
    private final int 地域密着型介護老人福祉施設入所者生活介護;
    private final int 定期巡回随時対応型訪問介護看護;
    private final int 複合型サービス;
    private final GenzaiJokyoKubun 現在の状況;
    private final RString 市町村特別給付;
    private final RString 介護保険給付以外の在宅サービス;

    /**
     * インスタンスを生成します。
     *
     * @param サービス区分 サービス区分
     * @param 訪問介護 訪問介護
     * @param 訪問入浴介護 訪問入浴介護
     * @param 訪問看護 訪問看護
     * @param 訪問リハビリ 訪問リハビリ
     * @param 居宅療養管理指導 居宅療養管理指導
     * @param 通所介護 通所介護
     * @param 通所リハビリテーション 通所リハビリテーション
     * @param 短期入所生活介護 短期入所生活介護
     * @param 短期入所療養介護 短期入所療養介護
     * @param 特定施設入居者生活介護 特定施設入居者生活介護
     * @param 福祉用具貸与 福祉用具貸与
     * @param 特定福祉用具販売 特定福祉用具販売
     * @param 住宅改修 住宅改修
     * @param 夜間対応型訪問介護 夜間対応型訪問介護
     * @param 認知症対応型通所介護 認知症対応型通所介護
     * @param 小規模多機能型居宅介護 小規模多機能型居宅介護
     * @param 認知症対応型共同生活介護 認知症対応型共同生活介護
     * @param 地域密着型特定施設入居者生活介護 地域密着型特定施設入居者生活介護
     * @param 地域密着型介護老人福祉施設入所者生活介護 地域密着型介護老人福祉施設入所者生活介護
     * @param 定期巡回随時対応型訪問介護看護 定期巡回随時対応型訪問介護看護
     * @param 複合型サービス 複合型サービス
     * @param 現在の状況 現在の状況
     * @param 市町村特別給付 市町村特別給付
     * @param 介護保険給付以外の在宅サービス 介護保険給付以外の在宅サービス
     */
    public NinteichosaResultOfGaikyoService(
            ServiceKubun サービス区分,
            int 訪問介護,
            int 訪問入浴介護,
            int 訪問看護,
            int 訪問リハビリ,
            int 居宅療養管理指導,
            int 通所介護,
            int 通所リハビリテーション,
            int 短期入所生活介護,
            int 短期入所療養介護,
            int 特定施設入居者生活介護,
            int 福祉用具貸与,
            int 特定福祉用具販売,
            int 住宅改修,
            int 夜間対応型訪問介護,
            int 認知症対応型通所介護,
            int 小規模多機能型居宅介護,
            int 認知症対応型共同生活介護,
            int 地域密着型特定施設入居者生活介護,
            int 地域密着型介護老人福祉施設入所者生活介護,
            int 定期巡回随時対応型訪問介護看護,
            int 複合型サービス,
            GenzaiJokyoKubun 現在の状況,
            RString 市町村特別給付,
            RString 介護保険給付以外の在宅サービス) {
        this.サービス区分 = requireNonNull(サービス区分, Messages.E00001.replace("サービス区分").getMessage());
        this.訪問介護 = 訪問介護;
        this.訪問入浴介護 = 訪問入浴介護;
        this.訪問看護 = 訪問看護;
        this.訪問リハビリ = 訪問リハビリ;
        this.居宅療養管理指導 = 居宅療養管理指導;
        this.通所介護 = 通所介護;
        this.通所リハビリテーション = 通所リハビリテーション;
        this.短期入所生活介護 = 短期入所生活介護;
        this.短期入所療養介護 = 短期入所療養介護;
        this.特定施設入居者生活介護 = 特定施設入居者生活介護;
        this.福祉用具貸与 = 福祉用具貸与;
        this.特定福祉用具販売 = 特定福祉用具販売;
        this.住宅改修 = 住宅改修;
        this.夜間対応型訪問介護 = 夜間対応型訪問介護;
        this.認知症対応型通所介護 = 認知症対応型通所介護;
        this.小規模多機能型居宅介護 = 小規模多機能型居宅介護;
        this.認知症対応型共同生活介護 = 認知症対応型共同生活介護;
        this.地域密着型特定施設入居者生活介護 = 地域密着型特定施設入居者生活介護;
        this.地域密着型介護老人福祉施設入所者生活介護 = 地域密着型介護老人福祉施設入所者生活介護;
        this.定期巡回随時対応型訪問介護看護 = 定期巡回随時対応型訪問介護看護;
        this.複合型サービス = 複合型サービス;
        this.現在の状況 = requireNonNull(現在の状況, Messages.E00001.replace("現在の状況").getMessage());
        this.市町村特別給付 = requireNonNull(市町村特別給付, Messages.E00001.replace("市町村特別給付").getMessage());
        this.介護保険給付以外の在宅サービス =
                requireNonNull(介護保険給付以外の在宅サービス, Messages.E00001.replace("介護保険給付以外の在宅サービス").getMessage());
    }

    /**
     * サービス区分を返します。
     *
     * @return サービス区分
     */
    public ServiceKubun getサービス区分() {
        return サービス区分;
    }

    /**
     * 訪問介護を返します。
     *
     * @return 訪問介護
     */
    public int get訪問介護() {
        return 訪問介護;
    }

    /**
     * 訪問入浴介護を返します。
     *
     * @return 訪問入浴介護
     */
    public int get訪問入浴介護() {
        return 訪問入浴介護;
    }

    /**
     * 訪問看護を返します。
     *
     * @return 訪問看護
     */
    public int get訪問看護() {
        return 訪問看護;
    }

    /**
     * 訪問リハビリを返します。
     *
     * @return 訪問リハビリ
     */
    public int get訪問リハビリ() {
        return 訪問リハビリ;
    }

    /**
     * 居宅療養管理指導を返します。
     *
     * @return 居宅療養管理指導
     */
    public int get居宅療養管理指導() {
        return 居宅療養管理指導;
    }

    /**
     * 通所介護を返します。
     *
     * @return 通所介護
     */
    public int get通所介護() {
        return 通所介護;
    }

    /**
     * 通所リハビリテーションを返します。
     *
     * @return 通所リハビリテーション
     */
    public int get通所リハビリテーション() {
        return 通所リハビリテーション;
    }

    /**
     * 短期入所生活介護を返します。
     *
     * @return 短期入所生活介護
     */
    public int get短期入所生活介護() {
        return 短期入所生活介護;
    }

    /**
     * 短期入所療養介護を返します。
     *
     * @return 短期入所療養介護
     */
    public int get短期入所療養介護() {
        return 短期入所療養介護;
    }

    /**
     * 特定施設入居者生活介護を返します。
     *
     * @return 特定施設入居者生活介護
     */
    public int get特定施設入居者生活介護() {
        return 特定施設入居者生活介護;
    }

    /**
     * 福祉用具貸与を返します。
     *
     * @return 福祉用具貸与
     */
    public int get福祉用具貸与() {
        return 福祉用具貸与;
    }

    /**
     * 特定福祉用具販売を返します。
     *
     * @return 特定福祉用具販売
     */
    public int get特定福祉用具販売() {
        return 特定福祉用具販売;
    }

    /**
     * 住宅改修を返します。
     *
     * @return 住宅改修
     */
    public int get住宅改修() {
        return 住宅改修;
    }

    /**
     * 夜間対応型訪問介護を返します。
     *
     * @return 夜間対応型訪問介護
     */
    public int get夜間対応型訪問介護() {
        return 夜間対応型訪問介護;
    }

    /**
     * 認知症対応型通所介護を返します。
     *
     * @return 認知症対応型通所介護
     */
    public int get認知症対応型通所介護() {
        return 認知症対応型通所介護;
    }

    /**
     * 小規模多機能型居宅介護を返します。
     *
     * @return 小規模多機能型居宅介護
     */
    public int get小規模多機能型居宅介護() {
        return 小規模多機能型居宅介護;
    }

    /**
     * 認知症対応型共同生活介護を返します。
     *
     * @return 認知症対応型共同生活介護
     */
    public int get認知症対応型共同生活介護() {
        return 認知症対応型共同生活介護;
    }

    /**
     * 地域密着型特定施設入居者生活介護を返します。
     *
     * @return 地域密着型特定施設入居者生活介護
     */
    public int get地域密着型特定施設入居者生活介護() {
        return 地域密着型特定施設入居者生活介護;
    }

    /**
     * 地域密着型介護老人福祉施設入所者生活介護を返します。
     *
     * @return 地域密着型介護老人福祉施設入所者生活介護
     */
    public int get地域密着型介護老人福祉施設入所者生活介護() {
        return 地域密着型介護老人福祉施設入所者生活介護;
    }

    /**
     * 定期巡回随時対応型訪問介護看護を返します。
     *
     * @return 定期巡回随時対応型訪問介護看護
     */
    public int get定期巡回随時対応型訪問介護看護() {
        return 定期巡回随時対応型訪問介護看護;
    }

    /**
     * 複合型サービスを返します。
     *
     * @return 複合型サービス
     */
    public int get複合型サービス() {
        return 複合型サービス;
    }

    /**
     * 現在の状況を返します。
     *
     * @return 現在の状況
     */
    public GenzaiJokyoKubun get現在の状況() {
        return 現在の状況;
    }

    /**
     * 市町村特別給付を返します。
     *
     * @return 市町村特別給付
     */
    public RString get市町村特別給付() {
        return 市町村特別給付;
    }

    /**
     * 介護保険給付以外の在宅サービスを返します。
     *
     * @return 介護保険給付以外の在宅サービス
     */
    public RString get介護保険給付以外の在宅サービス() {
        return 介護保険給付以外の在宅サービス;
    }
}
