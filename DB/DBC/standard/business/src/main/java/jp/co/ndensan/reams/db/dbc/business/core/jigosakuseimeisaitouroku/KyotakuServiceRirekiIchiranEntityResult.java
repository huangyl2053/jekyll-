/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.KyotakuServiceRirekiIchiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス履歴一覧情報クラスです。
 *
 * @reamsid_L DBC-1930-010 xuchangyong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyotakuServiceRirekiIchiranEntityResult implements Serializable {

    private static final long serialVersionUID = 1L;
    private KyotakuServiceRirekiIchiranEntity entity;

    /**
     * 対象年月の取得します。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth get対象年月() {
        return this.entity.get対象年月();
    }

    /**
     * 作成区分コードの取得します。
     *
     * @return 作成区分コード
     */
    public RString get作成区分コード() {
        return this.entity.get作成区分コード();
    }

    /**
     * 事業者番号の取得します。
     *
     * @return 事業者番号
     */
    public RString get事業者番号() {
        return this.entity.get事業者番号();
    }

    /**
     * 事業者名の取得します。
     *
     * @return 事業者名
     */
    public RString get事業者名() {
        return this.entity.get事業者名();
    }

    /**
     * 委託先情報者コードの取得します。
     *
     * @return 委託先情報者コード
     */
    public RString get委託先情報者コード() {
        return this.entity.get委託先情報者コード();
    }

    /**
     * 委託先情報者名の取得します。
     *
     * @return 委託先情報者名
     */
    public RString get委託先情報者名() {
        return this.entity.get委託先情報者名();
    }

    /**
     * 開始日の取得します。
     *
     * @return 開始日
     */
    public FlexibleDate get開始日() {
        return this.entity.get開始日();
    }

    /**
     * 終了日の取得します。
     *
     * @return 終了日
     */
    public FlexibleDate get終了日() {
        return this.entity.get終了日();
    }

    /**
     * 届出日の取得します。
     *
     * @return 届出日
     */
    public FlexibleDate get届出日() {
        return this.entity.get届出日();
    }

    /**
     * 更新日の取得します。
     *
     * @return 更新日
     */
    public FlexibleDate get更新日() {
        return this.entity.get更新日() != null ? new FlexibleDate(this.entity.get更新日().getDate().toDateString()) : FlexibleDate.MIN;
    }

    /**
     * 最大履歴番号の取得します。
     *
     * @return 最大履歴番号
     */
    public int get最大履歴番号() {
        return this.entity.get最大履歴番号();
    }

    /**
     * 届出区分の取得します。
     *
     * @return 届出区分
     */
    public RString get届出区分() {
        return this.entity.get届出区分();
    }

    /**
     * 氏名の取得します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return this.entity.get氏名();
    }

    /**
     * カナの取得します。
     *
     * @return カナ
     */
    public RString getカナ() {
        return this.entity.getカナ();
    }

    /**
     * 関係区分の取得します。
     *
     * @return 関係区分
     */
    public RString get関係区分() {
        return this.entity.get関係区分();
    }

    /**
     * 電話番号の取得します。
     *
     * @return 電話番号
     */
    public RString get電話番号() {
        return this.entity.get電話番号();
    }

    /**
     * 郵便番号の取得します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return this.entity.get郵便番号();
    }

    /**
     * 住所の取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        return this.entity.get住所();
    }

    /**
     * サービス種類コードの取得します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return this.entity.getサービス種類コード();
    }

    /**
     * 事業者郵便番号の取得します。
     *
     * @return 事業者郵便番号
     */
    public YubinNo get事業者郵便番号() {
        return this.entity.get事業者郵便番号();
    }

    /**
     * 事業者住所の取得します。
     *
     * @return 事業者住所
     */
    public AtenaJusho get事業者住所() {
        return this.entity.get事業者住所();
    }

    /**
     * 事業者電話番号の取得します。
     *
     * @return 事業者電話番号
     */
    public TelNo get事業者電話番号() {
        return this.entity.get事業者電話番号();
    }

    /**
     * 管理者名の取得します。
     *
     * @return 管理者名
     */
    public AtenaMeisho get管理者名() {
        return this.entity.get管理者名();
    }

    /**
     * 事業者変更年月日の取得します。
     *
     * @return 事業者変更年月日
     */
    public FlexibleDate get事業者変更年月日() {
        return this.entity.get事業者変更年月日();
    }

    /**
     * 事業者変更事由の取得します。
     *
     * @return 事業者変更事由
     */
    public RString get事業者変更事由() {
        return this.entity.get事業者変更事由();
    }

    /**
     * 居宅総合事業区分の取得します。
     *
     * @return 居宅総合事業区分
     */
    public RString get居宅総合事業区分() {
        return this.entity.get居宅総合事業区分();
    }
}
