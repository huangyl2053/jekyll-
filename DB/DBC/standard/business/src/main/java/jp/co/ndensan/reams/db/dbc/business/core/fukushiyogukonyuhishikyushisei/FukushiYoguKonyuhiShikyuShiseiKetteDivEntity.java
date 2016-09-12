/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 福祉用具購入費支給申請決定情報画面Entity
 *
 * @reamsid_L DBC-1020-040 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukushiYoguKonyuhiShikyuShiseiKetteDivEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth 提供_購入_年月;
    private RString 整理番号;
    private JigyoshaNo 事業者番号;
    private RString 証明書コード;
    private RString 明細番号;
    private FlexibleDate 決定日;
    private ShikibetsuCode 識別コード;
    private List<ShokanFukushiYoguHanbaihi> 登録福祉用具販売費リスト;
    private List<ShokanFukushiYoguHanbaihi> 修正福祉用具販売費リスト;
    private List<ShokanFukushiYoguHanbaihi> 削除福祉用具販売費リスト;

    private boolean 差額金額登録フラグ;
    private final ShokanHanteiKekka 償還払支給判定結果;
    private final ShokanShukei 償還払集計;
    private RString 画面モード;

    private static final RString MODEL_TOROKU = new RString("登録");
    private static final RString MODEL_SHUSEI = new RString("修正");
    private static final RString MODEL_SAKUJO = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param 画面モード 画面モード
     */
    FukushiYoguKonyuhiShikyuShiseiKetteDivEntity(
            RString 画面モード,
            ShokanHanteiKekka 償還払支給判定結果,
            ShokanShukei 償還払集計) {
        requireNonNull(画面モード, UrSystemErrorMessages.値がnull.getReplacedMessage("画面モード"));
        requireNonNull(償還払支給判定結果, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給判定結果"));
        requireNonNull(償還払集計, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払集計"));
        this.画面モード = 画面モード;
        this.償還払支給判定結果 = 償還払支給判定結果;
        this.償還払集計 = 償還払集計;
        登録福祉用具販売費リスト = new ArrayList<>();
        修正福祉用具販売費リスト = new ArrayList<>();
        削除福祉用具販売費リスト = new ArrayList<>();
    }

    /**
     * 福祉用具購入費支給申請決定情報画面Entity作成
     *
     * @param 画面モード 画面モード
     * @param 償還払支給判定結果 償還払支給判定結果
     * @param 償還払集計 償還払集計
     * @return 福祉用具購入費支給申請決定情報画面Entity
     */
    public static FukushiYoguKonyuhiShikyuShiseiKetteDivEntity createEntity(
            RString 画面モード,
            ShokanHanteiKekka 償還払支給判定結果,
            ShokanShukei 償還払集計) {
        return new FukushiYoguKonyuhiShikyuShiseiKetteDivEntity(画面モード, 償還払支給判定結果, 償還払集計);
    }

    /**
     * 福祉用具販売費をリストに追加。
     *
     * @param 状態 状態(新規、修正、削除)
     * @param 福祉用具販売費 福祉用具販売費
     */
    public void add福祉用具販売費(RString 状態, ShokanFukushiYoguHanbaihi 福祉用具販売費) {
        if (null == 登録福祉用具販売費リスト) {
            登録福祉用具販売費リスト = new ArrayList<>();
        }
        if (null == 修正福祉用具販売費リスト) {
            修正福祉用具販売費リスト = new ArrayList<>();
        }
        if (null == 削除福祉用具販売費リスト) {
            削除福祉用具販売費リスト = new ArrayList<>();
        }
        if (MODEL_TOROKU.equals(状態)) {
            登録福祉用具販売費リスト.add(福祉用具販売費);
        } else if (MODEL_SHUSEI.equals(状態)) {
            修正福祉用具販売費リスト.add(福祉用具販売費);
        } else if (MODEL_SAKUJO.equals(状態)) {
            削除福祉用具販売費リスト.add(福祉用具販売費);
        }
    }

    /**
     * 福祉用具販売費をリストに追加
     *
     * @param 状態 状態
     * @param 福祉用具販売費リスト 福祉用具販売費リスト
     */
    public void add福祉用具販売費リスト(RString 状態, List<ShokanFukushiYoguHanbaihi> 福祉用具販売費リスト) {
        if (null == 登録福祉用具販売費リスト) {
            登録福祉用具販売費リスト = new ArrayList<>();
        }
        if (null == 修正福祉用具販売費リスト) {
            修正福祉用具販売費リスト = new ArrayList<>();
        }
        if (null == 削除福祉用具販売費リスト) {
            削除福祉用具販売費リスト = new ArrayList<>();
        }
        if (MODEL_TOROKU.equals(状態)) {
            登録福祉用具販売費リスト.addAll(福祉用具販売費リスト);
        } else if (MODEL_SHUSEI.equals(状態)) {
            修正福祉用具販売費リスト.addAll(福祉用具販売費リスト);
        } else if (MODEL_SAKUJO.equals(状態)) {
            削除福祉用具販売費リスト.addAll(福祉用具販売費リスト);
        }
    }

}
