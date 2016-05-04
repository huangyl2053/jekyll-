/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.jukyushikakushomeisho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.jukyushikakushomeisho.JukyuShikakuShomeishoKaiKoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給資格証明書発行
 *
 * @reamsid_L DBU-0490-050 wangchao
 */
public class JukyuShikakuShomeishoKaiKo {

    private final JukyuShikakuShomeishoKaiKoEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7022ShoriDateKanriEntity}より{@link ChushutsuKikanJohoData}を生成します。
     *
     * @param entity DBより取得した{@link DbT7021JigyoHokokuTokeiDataEntity}
     */
    public JukyuShikakuShomeishoKaiKo(JukyuShikakuShomeishoKaiKoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受給資格証明書発行データ"));
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
     * 異動予定日を返します。
     *
     * @return 異動予定日
     */
    public RString get異動予定日() {
        return entity.get異動予定日();
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
     * 備考号を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.get備考();
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public RString get交付年月日() {
        return entity.get交付年月日();
    }

    /**
     * 交付日を返します。
     *
     * @return 交付日
     */
    public RDate get交付日() {
        return entity.get交付日();
    }

    /**
     * 申請日を返します。
     *
     * @return 申請日
     */
    public RString get申請日() {
        return entity.get申請日();
    }

    /**
     * 申請状況区分を返します。
     *
     * @return 申請状況区分
     */
    public RString get申請状況区分() {
        return entity.get申請状況区分();
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
     * 有効期間の終了年月日を返します。
     *
     * @return 有効期間の終了年月日
     */
    public RString get有効期間の終了年月日() {
        return entity.get有効期間の終了年月日();
    }

    /**
     * 有効期間の開始年月日を返します。
     *
     * @return 有効期間の開始年月日
     */
    public RString get有効期間の開始年月日() {
        return entity.get有効期間の開始年月日();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.get識別コード();
    }

    /**
     * 住所を印字を返します。
     *
     * @return 住所を印字
     */
    public boolean is住所を印字() {
        return entity.is住所を印字();
    }

    /**
     * 負担割合を返します。
     *
     * @return 負担割合
     */
    public RString get負担割合() {
        return entity.get負担割合();
    }

    /**
     * 負担割該当を返します。
     *
     * @return 負担割該当
     */
    public RString get負担割該当() {
        return entity.get負担割該当();
    }
}
