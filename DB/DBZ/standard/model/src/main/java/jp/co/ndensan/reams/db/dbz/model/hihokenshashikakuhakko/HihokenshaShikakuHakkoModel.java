/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 被保険者・証資格者証発行画面の表示情報を保持するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class HihokenshaShikakuHakkoModel implements Serializable {

    private RDate 有効期限;
    private FlexibleDate 交付日;
    private RString 保険者番号;
    private RString 保険者名称;
    private RString 保険者表示;
    private RString 交付事由コード;
    private RString 交付事由;
    private RString 要介護状態;
    private RDate 認定日;
    private RDate 有効期間開始日;
    private RDate 有効期間終了日;
    private FlexibleDate 申請日;
    private boolean is性同一性障害用;
    private Decimal 限度基準額;
    private RDate 限度額有効期間開始日;
    private RDate 限度額有効期間終了日;
    private List<RString> 限度基準額サービス種類;
    private List<RString> 限度基準額サービス額;
    private RString 審査会意見;
    private List<RString> 給付制限内容;
    private List<RDate> 給付制限開始日;
    private List<RDate> 給付制限終了日;
    private List<RString> 支援事業者名称;
    private List<FlexibleDate> 支援事業者届出日;
    private List<FlexibleDate> 支援事業者適用開始日;
    private List<RString> 施設名;
    private List<FlexibleDate> 施設入所日;
    private List<FlexibleDate> 施設退所日;
    private boolean isテスト;
    private boolean is直前履歴;

    public HihokenshaShikakuHakkoModel() {
    }

    /**
     * @return the 有効期限
     */
    public RDate get有効期限() {
        return 有効期限;
    }

    /**
     * @param 有効期限 the 有効期限 to set
     */
    public void set有効期限(RDate 有効期限) {
        this.有効期限 = 有効期限;
    }

    /**
     * @return the 交付日
     */
    public FlexibleDate get交付日() {
        return 交付日;
    }

    /**
     * @param 交付日 the 交付日 to set
     */
    public void set交付日(FlexibleDate 交付日) {
        this.交付日 = 交付日;
    }

    /**
     * @return the 保険者番号
     */
    public RString get保険者番号() {
        return 保険者番号;
    }

    /**
     * @param 保険者番号 the 保険者番号 to set
     */
    public void set保険者番号(RString 保険者番号) {
        this.保険者番号 = 保険者番号;
    }

    /**
     * @return the 保険者名称
     */
    public RString get保険者名称() {
        return 保険者名称;
    }

    /**
     * @param 保険者名称 the 保険者名称 to set
     */
    public void set保険者名称(RString 保険者名称) {
        this.保険者名称 = 保険者名称;
    }

    /**
     * @return the 保険者表示
     */
    public RString get保険者表示() {
        return 保険者表示;
    }

    /**
     * @param 保険者表示 the 保険者表示 to set
     */
    public void set保険者表示(RString 保険者表示) {
        this.保険者表示 = 保険者表示;
    }

    /**
     * @return the 交付事由コード
     */
    public RString get交付事由コード() {
        return 交付事由コード;
    }

    /**
     * @param 交付事由コード the 交付事由コード to set
     */
    public void set交付事由コード(RString 交付事由コード) {
        this.交付事由コード = 交付事由コード;
    }

    /**
     * @return the 交付事由
     */
    public RString get交付事由() {
        return 交付事由;
    }

    /**
     * @param 交付事由 the 交付事由 to set
     */
    public void set交付事由(RString 交付事由) {
        this.交付事由 = 交付事由;
    }

    /**
     * @return the 要介護状態
     */
    public RString get要介護状態() {
        return 要介護状態;
    }

    /**
     * @param 要介護状態 the 要介護状態 to set
     */
    public void set要介護状態(RString 要介護状態) {
        this.要介護状態 = 要介護状態;
    }

    /**
     * @return the 認定日
     */
    public RDate get認定日() {
        return 認定日;
    }

    /**
     * @param 認定日 the 認定日 to set
     */
    public void set認定日(RDate 認定日) {
        this.認定日 = 認定日;
    }

    /**
     * @return the 有効期間開始日
     */
    public RDate get有効期間開始日() {
        return 有効期間開始日;
    }

    /**
     * @param 有効期間開始日 the 有効期間開始日 to set
     */
    public void set有効期間開始日(RDate 有効期間開始日) {
        this.有効期間開始日 = 有効期間開始日;
    }

    /**
     * @return the 有効期間終了日
     */
    public RDate get有効期間終了日() {
        return 有効期間終了日;
    }

    /**
     * @param 有効期間終了日 the 有効期間終了日 to set
     */
    public void set有効期間終了日(RDate 有効期間終了日) {
        this.有効期間終了日 = 有効期間終了日;
    }

    /**
     * @return the 申請日
     */
    public FlexibleDate get申請日() {
        return 申請日;
    }

    /**
     * @param 申請日 the 申請日 to set
     */
    public void set申請日(FlexibleDate 申請日) {
        this.申請日 = 申請日;
    }

    /**
     * @return the is性同一性障害用
     */
    public boolean is性同一性障害用() {
        return is性同一性障害用;
    }

    /**
     * @param is性同一性障害用 the is性同一性障害用 to set
     */
    public void setIs性同一性障害用(boolean is性同一性障害用) {
        this.is性同一性障害用 = is性同一性障害用;
    }

    /**
     * @return the 限度基準額
     */
    public Decimal get限度基準額() {
        return 限度基準額;
    }

    /**
     * @param 限度基準額 the 限度基準額 to set
     */
    public void set限度基準額(Decimal 限度基準額) {
        this.限度基準額 = 限度基準額;
    }

    /**
     * @return the 限度額有効期間開始日
     */
    public RDate get限度額有効期間開始日() {
        return 限度額有効期間開始日;
    }

    /**
     * @param 限度額有効期間開始日 the 限度額有効期間開始日 to set
     */
    public void set限度額有効期間開始日(RDate 限度額有効期間開始日) {
        this.限度額有効期間開始日 = 限度額有効期間開始日;
    }

    /**
     * @return the 限度額有効期間終了日
     */
    public RDate get限度額有効期間終了日() {
        return 限度額有効期間終了日;
    }

    /**
     * @param 限度額有効期間終了日 the 限度額有効期間終了日 to set
     */
    public void set限度額有効期間終了日(RDate 限度額有効期間終了日) {
        this.限度額有効期間終了日 = 限度額有効期間終了日;
    }

    /**
     * @return the 限度基準額サービス種類
     */
    public List<RString> get限度基準額サービス種類() {
        return 限度基準額サービス種類;
    }

    /**
     * @param 限度基準額サービス種類 the 限度基準額サービス種類 to set
     */
    public void set限度基準額サービス種類(List<RString> 限度基準額サービス種類) {
        this.限度基準額サービス種類 = 限度基準額サービス種類;
    }

    /**
     * @return the 限度基準額サービス額
     */
    public List<RString> get限度基準額サービス額() {
        return 限度基準額サービス額;
    }

    /**
     * @param 限度基準額サービス額 the 限度基準額サービス額 to set
     */
    public void set限度基準額サービス額(List<RString> 限度基準額サービス額) {
        this.限度基準額サービス額 = 限度基準額サービス額;
    }

    /**
     * @return the 審査会意見
     */
    public RString get審査会意見() {
        return 審査会意見;
    }

    /**
     * @param 審査会意見 the 審査会意見 to set
     */
    public void set審査会意見(RString 審査会意見) {
        this.審査会意見 = 審査会意見;
    }

    /**
     * @return the 給付制限内容
     */
    public List<RString> get給付制限内容() {
        return 給付制限内容;
    }

    /**
     * @param 給付制限内容 the 給付制限内容 to set
     */
    public void set給付制限内容(List<RString> 給付制限内容) {
        this.給付制限内容 = 給付制限内容;
    }

    /**
     * @return the 給付制限開始日
     */
    public List<RDate> get給付制限開始日() {
        return 給付制限開始日;
    }

    /**
     * @param 給付制限開始日 the 給付制限開始日 to set
     */
    public void set給付制限開始日(List<RDate> 給付制限開始日) {
        this.給付制限開始日 = 給付制限開始日;
    }

    /**
     * @return the 給付制限終了日
     */
    public List<RDate> get給付制限終了日() {
        return 給付制限終了日;
    }

    /**
     * @param 給付制限終了日 the 給付制限終了日 to set
     */
    public void set給付制限終了日(List<RDate> 給付制限終了日) {
        this.給付制限終了日 = 給付制限終了日;
    }

    /**
     * @return the 支援事業者名称
     */
    public List<RString> get支援事業者名称() {
        return 支援事業者名称;
    }

    /**
     * @param 支援事業者名称 the 支援事業者名称 to set
     */
    public void set支援事業者名称(List<RString> 支援事業者名称) {
        this.支援事業者名称 = 支援事業者名称;
    }

    /**
     * @return the 支援事業者届出日
     */
    public List<FlexibleDate> get支援事業者届出日() {
        return 支援事業者届出日;
    }

    /**
     * @param 支援事業者届出日 the 支援事業者届出日 to set
     */
    public void set支援事業者届出日(List<FlexibleDate> 支援事業者届出日) {
        this.支援事業者届出日 = 支援事業者届出日;
    }

    /**
     * @return the 支援事業者適用開始日
     */
    public List<FlexibleDate> get支援事業者適用開始日() {
        return 支援事業者適用開始日;
    }

    /**
     * @param 支援事業者適用開始日 the 支援事業者適用開始日 to set
     */
    public void set支援事業者適用開始日(List<FlexibleDate> 支援事業者適用開始日) {
        this.支援事業者適用開始日 = 支援事業者適用開始日;
    }

    /**
     * @return the 施設名
     */
    public List<RString> get施設名() {
        return 施設名;
    }

    /**
     * @param 施設名 the 施設名 to set
     */
    public void set施設名(List<RString> 施設名) {
        this.施設名 = 施設名;
    }

    /**
     * @return the 施設入所日
     */
    public List<FlexibleDate> get施設入所日() {
        return 施設入所日;
    }

    /**
     * @param 施設入所日 the 施設入所日 to set
     */
    public void set施設入所日(List<FlexibleDate> 施設入所日) {
        this.施設入所日 = 施設入所日;
    }

    /**
     * @return the 施設退所日
     */
    public List<FlexibleDate> get施設退所日() {
        return 施設退所日;
    }

    /**
     * @param 施設退所日 the 施設退所日 to set
     */
    public void set施設退所日(List<FlexibleDate> 施設退所日) {
        this.施設退所日 = 施設退所日;
    }

    /**
     * @return the isテスト
     */
    public boolean isテスト() {
        return isテスト;
    }

    /**
     * @param isテスト the isテスト to set
     */
    public void setIsテスト(boolean isテスト) {
        this.isテスト = isテスト;
    }

    /**
     * @return the is直前履歴
     */
    public boolean is直前履歴() {
        return is直前履歴;
    }

    /**
     * @param is直前履歴 the is直前履歴 to set
     */
    public void setIs直前履歴(boolean is直前履歴) {
        this.is直前履歴 = is直前履歴;
    }
}
