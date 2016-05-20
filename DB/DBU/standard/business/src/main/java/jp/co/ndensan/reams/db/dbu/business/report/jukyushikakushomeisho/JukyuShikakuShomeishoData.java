/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jukyushikakushomeisho;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jukyushikakushomeisho.JukyuShikakuShomeishoDataEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 受給資格証明書の帳票出力用データを管理するビジネスです。
 *
 * @reamsid_L DBU-0490-050 wangjie2
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyuShikakuShomeishoData {

    private final JukyuShikakuShomeishoDataEntity entity;
    private final Ninshosha 認証者;
    private final Association 地方公共団体;
    private final RString 帳票制御共通_首長名印字位置;
    private final boolean 帳票制御共通_電子公印印字有無;

    /**
     * コンストラクタです。<br/>
     *
     * @param entity JukyuShikakuShomeishoDataEntity
     * @param 認証者 認証者
     * @param 地方公共団体 地方公共団体
     * @param 帳票制御共通_首長名印字位置 帳票制御共通_首長名印字位置
     * @param 帳票制御共通_電子公印印字有無 帳票制御共通_電子公印印字有無
     */
    public JukyuShikakuShomeishoData(JukyuShikakuShomeishoDataEntity entity, Ninshosha 認証者,
            Association 地方公共団体, RString 帳票制御共通_首長名印字位置, boolean 帳票制御共通_電子公印印字有無) {
        this.entity = entity;
        this.認証者 = 認証者;
        this.地方公共団体 = 地方公共団体;
        this.帳票制御共通_首長名印字位置 = 帳票制御共通_首長名印字位置;
        this.帳票制御共通_電子公印印字有無 = 帳票制御共通_電子公印印字有無;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 被保険者フリガナを返します。
     *
     * @return 被保険者フリガナ
     */
    public AtenaKanaMeisho get被保険者フリガナ() {
        return entity.get被保険者フリガナ();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 年号_明治を返します。
     *
     * @return 年号_明治
     */
    public RString get年号_明治() {
        return entity.get年号_明治();
    }

    /**
     * 年号_大正を返します。
     *
     * @return 年号_大正
     */
    public RString get年号_大正() {
        return entity.get年号_大正();
    }

    /**
     * 年号_昭和を返します。
     *
     * @return 年号_昭和
     */
    public RString get年号_昭和() {
        return entity.get年号_昭和();
    }

    /**
     * 被保険者生年月日を返します。
     *
     * @return 被保険者生年月日
     */
    public RString get被保険者生年月日() {
        return entity.get被保険者生年月日();
    }

    /**
     * 被保険者性別を返します。
     *
     * @return 被保険者性別
     */
    public RString get被保険者性別() {
        return entity.get被保険者性別();
    }

    /**
     * 被保険者住所_転出前を返します。
     *
     * @return 被保険者住所_転出前
     */
    public RString get被保険者住所_転出前() {
        return entity.get被保険者住所_転出前();
    }

    /**
     * 被保険者住所_転出先予定を返します。
     *
     * @return 被保険者住所_転出先予定
     */
    public RString get被保険者住所_転出先予定() {
        return entity.get被保険者住所_転出先予定();
    }

    /**
     * 被保険者異動予定日を返します。
     *
     * @return 被保険者異動予定日
     */
    public RString get被保険者異動予定日() {
        return entity.get被保険者異動予定日();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.get保険者番号();
    }

    /**
     * 発行日を返します。
     *
     * @return 発行日
     */
    public RString get発行日() {
        return entity.get発行日();
    }

    /**
     * 申請状況を返します。
     *
     * @return 申請状況
     */
    public RString get申請状況() {
        return entity.get申請状況();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public RString get申請年月日() {
        return entity.get申請年月日();
    }

    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    public RString get要介護状態区分() {
        return entity.get要介護状態区分();
    }

    /**
     * 認定年月日を返します。
     *
     * @return 認定年月日
     */
    public RString get認定年月日() {
        return entity.get認定年月日();
    }

    /**
     * 認定の有効期間の開始年月日を返します。
     *
     * @return 認定の有効期間の開始年月日
     */
    public RString get認定の有効期間の開始年月日() {
        return entity.get認定の有効期間の開始年月日();
    }

    /**
     * 認定の有効期間の終了年月日を返します。
     *
     * @return 認定の有効期間の終了年月日
     */
    public RString get認定の有効期間の終了年月日() {
        return entity.get認定の有効期間の終了年月日();
    }

    /**
     * 認定審査会の意見等を返します。
     *
     * @return 認定審査会の意見等
     */
    public RString get認定審査会の意見等() {
        return entity.get認定審査会の意見等();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.get備考();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public RString get連番() {
        return entity.get連番();
    }

}
