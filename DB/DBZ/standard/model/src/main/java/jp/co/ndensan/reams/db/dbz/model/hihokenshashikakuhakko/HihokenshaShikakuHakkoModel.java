/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 被保険者・証資格者証発行画面の表示情報を保持するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class HihokenshaShikakuHakkoModel implements Serializable {

    private Optional<FlexibleDate> 有効期限;
    private FlexibleDate 交付日;
    private RString 保険者番号;
    private RString 保険者名称;
    private RString 保険者表示;
    private RString 交付事由コード;
    private RString 交付事由;
    private RString 要介護状態;
    private FlexibleDate 認定日;
    private FlexibleDate 有効期間開始日;
    private FlexibleDate 有効期間終了日;
    private FlexibleDate 申請日;
    private boolean selected性同一障害用;
    private Decimal 限度基準額;
    private FlexibleDate 限度額有効期間開始日;
    private FlexibleDate 限度額有効期間終了日;
    private List<RString> 限度基準額サービス種類;
    private List<RString> 限度基準額サービス額;
    private RString 審査会意見;
    private List<RString> 給付制限内容;
    private List<FlexibleDate> 給付制限開始日;
    private List<FlexibleDate> 給付制限終了日;
    private List<RString> 支援事業者名称;
    private List<FlexibleDate> 支援事業者届出日;
    private List<FlexibleDate> 支援事業者適用開始日;
    private List<FlexibleDate> 支援事業者適用終了日;
    private List<RString> 施設名;
    private List<FlexibleDate> 施設入所日;
    private List<FlexibleDate> 施設退所日;
    private List<RString> 入所施設コード;
    private boolean selectedテスト;
    private boolean selected直前履歴;

    /**
     * コンストラクタです。
     */
    public HihokenshaShikakuHakkoModel() {
        this.selected性同一障害用 = false;
        this.selectedテスト = false;
        this.selected直前履歴 = false;
    }

    /**
     * 有効期限を取得する。
     *
     * @return 有効期限
     */
    public Optional<FlexibleDate> get有効期限() {
        return 有効期限;
    }

    /**
     * 有効期限を設定する。
     *
     * @param 有効期限 有効期限
     */
    public void set有効期限(FlexibleDate 有効期限) {
        this.有効期限 = Optional.ofNullable(有効期限);
    }

    /**
     * 交付日を取得する。
     *
     * @return 交付日
     */
    public FlexibleDate get交付日() {
        return 交付日;
    }

    /**
     * 交付日を設定する。
     *
     * @param 交付日 交付日
     */
    public void set交付日(FlexibleDate 交付日) {
        this.交付日 = 交付日;
    }

    /**
     * 保険者番号を取得する。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return 保険者番号;
    }

    /**
     * 保険者番号を設定する。
     *
     * @param 保険者番号 保険者番号
     */
    public void set保険者番号(RString 保険者番号) {
        this.保険者番号 = 保険者番号;
    }

    /**
     * 保険者名称を取得する。
     *
     * @return 保険者名称
     */
    public RString get保険者名称() {
        return 保険者名称;
    }

    /**
     * 保険者名称を設定する。
     *
     * @param 保険者名称 保険者名称
     */
    public void set保険者名称(RString 保険者名称) {
        this.保険者名称 = 保険者名称;
    }

    /**
     * 保険者表示を取得する。
     *
     * @return 保険者表示
     */
    public RString get保険者表示() {
        return 保険者表示;
    }

    /**
     * 保険者表示を設定する。
     *
     * @param 保険者表示 保険者表示
     */
    public void set保険者表示(RString 保険者表示) {
        this.保険者表示 = 保険者表示;
    }

    /**
     * 交付事由コードを取得する。
     *
     * @return 交付事由コード
     */
    public RString get交付事由コード() {
        return 交付事由コード;
    }

    /**
     * 交付事由コードを設定する。
     *
     * @param 交付事由コード 交付事由コード
     */
    public void set交付事由コード(RString 交付事由コード) {
        this.交付事由コード = 交付事由コード;
    }

    /**
     * 交付事由を取得する。
     *
     * @return 交付事由
     */
    public RString get交付事由() {
        return 交付事由;
    }

    /**
     * 交付事由を設定する。
     *
     * @param 交付事由 交付事由
     */
    public void set交付事由(RString 交付事由) {
        this.交付事由 = 交付事由;
    }

    /**
     * 要介護状態を取得する。
     *
     * @return 要介護状態
     */
    public RString get要介護状態() {
        return 要介護状態;
    }

    /**
     * 要介護状態を設定する。
     *
     * @param 要介護状態 要介護状態
     */
    public void set要介護状態(RString 要介護状態) {
        this.要介護状態 = 要介護状態;
    }

    /**
     * 認定日を取得する。
     *
     * @return 認定日
     */
    public FlexibleDate get認定日() {
        return 認定日;
    }

    /**
     * 認定日を設定する。
     *
     * @param 認定日 認定日
     */
    public void set認定日(FlexibleDate 認定日) {
        this.認定日 = 認定日;
    }

    /**
     * 有効期間開始日を取得する。
     *
     * @return 有効期間開始日
     */
    public FlexibleDate get有効期間開始日() {
        return 有効期間開始日;
    }

    /**
     * 有効期間開始日を設定する。
     *
     * @param 有効期間開始日 有効期間開始日
     */
    public void set有効期間開始日(FlexibleDate 有効期間開始日) {
        this.有効期間開始日 = 有効期間開始日;
    }

    /**
     * 有効期間終了日を取得する。
     *
     * @return 有効期間終了日
     */
    public FlexibleDate get有効期間終了日() {
        return 有効期間終了日;
    }

    /**
     * 有効期間終了日を設定する。
     *
     * @param 有効期間終了日 有効期間終了日
     */
    public void set有効期間終了日(FlexibleDate 有効期間終了日) {
        this.有効期間終了日 = 有効期間終了日;
    }

    /**
     * 申請日を取得する。
     *
     * @return 申請日
     */
    public FlexibleDate get申請日() {
        return 申請日;
    }

    /**
     * 申請日を設定する。
     *
     * @param 申請日 申請日
     */
    public void set申請日(FlexibleDate 申請日) {
        this.申請日 = 申請日;
    }

    /**
     * selected性同一障害用を取得する。
     *
     * @return selected性同一障害用
     */
    public boolean is性同一障害用() {
        return selected性同一障害用;
    }

    /**
     * selected性同一障害用を設定する。
     *
     * @param selected性同一障害用 selected性同一障害用
     */
    public void setSelected性同一障害用(boolean selected性同一障害用) {
        this.selected性同一障害用 = selected性同一障害用;
    }

    /**
     * 限度基準額を取得する。
     *
     * @return 限度基準額
     */
    public Decimal get限度基準額() {
        return 限度基準額;
    }

    /**
     * 限度基準額を設定する。
     *
     * @param 限度基準額 限度基準額
     */
    public void set限度基準額(Decimal 限度基準額) {
        this.限度基準額 = 限度基準額;
    }

    /**
     * 限度額有効期間開始日を取得する。
     *
     * @return 限度額有効期間開始日
     */
    public FlexibleDate get限度額有効期間開始日() {
        return 限度額有効期間開始日;
    }

    /**
     * 限度額有効期間開始日を設定する。
     *
     * @param 限度額有効期間開始日 限度額有効期間開始日
     */
    public void set限度額有効期間開始日(FlexibleDate 限度額有効期間開始日) {
        this.限度額有効期間開始日 = 限度額有効期間開始日;
    }

    /**
     * 限度額有効期間終了日を取得する。
     *
     * @return 限度額有効期間終了日
     */
    public FlexibleDate get限度額有効期間終了日() {
        return 限度額有効期間終了日;
    }

    /**
     * 限度額有効期間終了日を設定する。
     *
     * @param 限度額有効期間終了日 限度額有効期間終了日
     */
    public void set限度額有効期間終了日(FlexibleDate 限度額有効期間終了日) {
        this.限度額有効期間終了日 = 限度額有効期間終了日;
    }

    /**
     * 限度基準額サービス種類を取得する。
     *
     * @return 限度基準額サービス種類
     */
    public List<RString> get限度基準額サービス種類() {
        return 限度基準額サービス種類;
    }

    /**
     * 限度基準額サービス種類を設定する。
     *
     * @param 限度基準額サービス種類 限度基準額サービス種類
     */
    public void set限度基準額サービス種類(List<RString> 限度基準額サービス種類) {
        this.限度基準額サービス種類 = 限度基準額サービス種類;
    }

    /**
     * 限度基準額サービス額を取得する。
     *
     * @return 限度基準額サービス額
     */
    public List<RString> get限度基準額サービス額() {
        return 限度基準額サービス額;
    }

    /**
     * 限度基準額サービス額を設定する。
     *
     * @param 限度基準額サービス額 限度基準額サービス額
     */
    public void set限度基準額サービス額(List<RString> 限度基準額サービス額) {
        this.限度基準額サービス額 = 限度基準額サービス額;
    }

    /**
     * 審査会意見を取得する。
     *
     * @return 審査会意見
     */
    public RString get審査会意見() {
        return 審査会意見;
    }

    /**
     * 審査会意見を設定する。
     *
     * @param 審査会意見 審査会意見
     */
    public void set審査会意見(RString 審査会意見) {
        this.審査会意見 = 審査会意見;
    }

    /**
     * 給付制限内容を取得する。
     *
     * @return 給付制限内容
     */
    public List<RString> get給付制限内容() {
        return 給付制限内容;
    }

    /**
     * 給付制限内容を設定する。
     *
     * @param 給付制限内容 給付制限内容
     */
    public void set給付制限内容(List<RString> 給付制限内容) {
        this.給付制限内容 = 給付制限内容;
    }

    /**
     * 給付制限開始日を取得する。
     *
     * @return 給付制限開始日
     */
    public List<FlexibleDate> get給付制限開始日() {
        return 給付制限開始日;
    }

    /**
     * 給付制限開始日を設定する。
     *
     * @param 給付制限開始日 給付制限開始日
     */
    public void set給付制限開始日(List<FlexibleDate> 給付制限開始日) {
        this.給付制限開始日 = 給付制限開始日;
    }

    /**
     * 給付制限終了日を取得する。
     *
     * @return 給付制限終了日
     */
    public List<FlexibleDate> get給付制限終了日() {
        return 給付制限終了日;
    }

    /**
     * 給付制限終了日を設定する。
     *
     * @param 給付制限終了日 給付制限終了日
     */
    public void set給付制限終了日(List<FlexibleDate> 給付制限終了日) {
        this.給付制限終了日 = 給付制限終了日;
    }

    /**
     * 支援事業者名称を取得する。
     *
     * @return 支援事業者名称
     */
    public List<RString> get支援事業者名称() {
        return 支援事業者名称;
    }

    /**
     * 支援事業者名称を設定する。
     *
     * @param 支援事業者名称 支援事業者名称
     */
    public void set支援事業者名称(List<RString> 支援事業者名称) {
        this.支援事業者名称 = 支援事業者名称;
    }

    /**
     * 支援事業者届出日を取得する。
     *
     * @return 支援事業者届出日
     */
    public List<FlexibleDate> get支援事業者届出日() {
        return 支援事業者届出日;
    }

    /**
     * 支援事業者届出日を設定する。
     *
     * @param 支援事業者届出日 支援事業者届出日
     */
    public void set支援事業者届出日(List<FlexibleDate> 支援事業者届出日) {
        this.支援事業者届出日 = 支援事業者届出日;
    }

    /**
     * 支援事業者適用開始日を取得する。
     *
     * @return 支援事業者適用開始日
     */
    public List<FlexibleDate> get支援事業者適用開始日() {
        return 支援事業者適用開始日;
    }

    /**
     * 支援事業者適用開始日を設定する。
     *
     * @param 支援事業者適用開始日 支援事業者適用開始日
     */
    public void set支援事業者適用開始日(List<FlexibleDate> 支援事業者適用開始日) {
        this.支援事業者適用開始日 = 支援事業者適用開始日;
    }

    /**
     * 支援事業者適用終了日を取得する。
     *
     * @return 支援事業者適用終了日
     */
    public List<FlexibleDate> get支援事業者適用終了日() {
        return 支援事業者適用終了日;
    }

    /**
     * 支援事業者適用終了日を設定する。
     *
     * @param 支援事業者適用終了日 支援事業者適用終了日
     */
    public void set支援事業者適用終了日(List<FlexibleDate> 支援事業者適用終了日) {
        this.支援事業者適用終了日 = 支援事業者適用終了日;
    }

    /**
     * 施設名を取得する。
     *
     * @return 施設名
     */
    public List<RString> get施設名() {
        return 施設名;
    }

    /**
     * 施設名を設定する。
     *
     * @param 施設名 施設名
     */
    public void set施設名(List<RString> 施設名) {
        this.施設名 = 施設名;
    }

    /**
     * 施設入所日を取得する。
     *
     * @return 施設入所日
     */
    public List<FlexibleDate> get施設入所日() {
        return 施設入所日;
    }

    /**
     * 施設入所日を設定する。
     *
     * @param 施設入所日 施設入所日
     */
    public void set施設入所日(List<FlexibleDate> 施設入所日) {
        this.施設入所日 = 施設入所日;
    }

    /**
     * 施設退所日を取得する。
     *
     * @return 施設退所日
     */
    public List<FlexibleDate> get施設退所日() {
        return 施設退所日;
    }

    /**
     * 施設退所日を設定する。
     *
     * @param 施設退所日 施設退所日
     */
    public void set施設退所日(List<FlexibleDate> 施設退所日) {
        this.施設退所日 = 施設退所日;
    }

    /**
     * 入所施設コードを取得する。
     *
     * @return 入所施設コード
     */
    public List<RString> get入所施設コード() {
        return 入所施設コード;
    }

    /**
     * 入所施設コードを設定する。
     *
     * @param 入所施設コード List<RString>
     */
    public void set入所施設コード(List<RString> 入所施設コード) {
        this.入所施設コード = 入所施設コード;
    }

    /**
     * selectedテストを取得する。
     *
     * @return selectedテスト
     */
    public boolean isテスト() {
        return selectedテスト;
    }

    /**
     * selectedテストを設定する。
     *
     * @param selectedテスト selectedテスト
     */
    public void setSelectedテスト(boolean selectedテスト) {
        this.selectedテスト = selectedテスト;
    }

    /**
     * selected直前履歴を取得する。
     *
     * @return selected直前履歴
     */
    public boolean is直前履歴() {
        return selected直前履歴;
    }

    /**
     * selected直前履歴を設定する。
     *
     * @param selected直前履歴 selected直前履歴
     */
    public void setSelected直前履歴(boolean selected直前履歴) {
        this.selected直前履歴 = selected直前履歴;
    }
}
