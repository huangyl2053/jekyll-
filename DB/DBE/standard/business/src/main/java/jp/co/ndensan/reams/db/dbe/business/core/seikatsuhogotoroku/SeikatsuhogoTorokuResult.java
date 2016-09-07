/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.seikatsuhogotoroku.SeikatsuhogoTorokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし2号登録のビジネスクラスです
 *
 * @reamsid_L DBE-1310-020 chengsanyuan
 */
public class SeikatsuhogoTorokuResult {

    private final SeikatsuhogoTorokuRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity みなし2号登録RelateEntity
     */
    public SeikatsuhogoTorokuResult(SeikatsuhogoTorokuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 被保険者氏名カナを取得します。
     *
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho get被保険者氏名カナ() {
        return entity.get被保険者氏名カナ();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.get生年月日();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public Code get性別() {
        return entity.get性別();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.get郵便番号();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.get住所();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.get電話番号();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.get識別コード();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }
}
