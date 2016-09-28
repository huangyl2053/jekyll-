/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kaigokyufuhikagomositatetouroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KagoMoshitate;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufuhikagomositatetouroku.KaigoKyufuhiKagoMositateTourokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）のEntityクラスです。
 *
 * @reamsid_L DBC-2220-030 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoKyufuhiKagoMositateTourokuResult implements Serializable {

    private final KaigoKyufuhiKagoMositateTourokuEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 介護給付費過誤申立登録（事業分、経過措置分含む）のEntity
     */
    public KaigoKyufuhiKagoMositateTourokuResult(KaigoKyufuhiKagoMositateTourokuEntity entity) {
        this.entity = entity;
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
     * 事業所番号を取得します。
     *
     * @return 事業所番号
     */
    public RString get事業所番号() {
        return entity.get事業所番号();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 様式番号を取得します。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return entity.get様式番号();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public RString getサービス提供年月() {
        return entity.getサービス提供年月();
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public RString get審査年月() {
        return entity.get審査年月();
    }

    /**
     * 給付実績作成区分コードを取得します。
     *
     * @return 給付実績作成区分コード
     */
    public RString get給付実績作成区分コード() {
        return entity.get給付実績作成区分コード();
    }

    /**
     * 給付区分を取得します。
     *
     * @return 給付区分
     */
    public RString get給付区分() {
        return entity.get給付区分();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * 行番号を取得します。
     *
     * @return 行番号
     */
    public RString get行番号() {
        return entity.get行番号();
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return entity.get氏名();
    }

    /**
     * 事業者名を取得します。
     *
     * @return 事業者名
     */
    public RString get事業者名() {
        return entity.get事業者名();
    }

    /**
     * 過誤申立情報を取得します。
     *
     * @return 過誤申立情報
     */
    public KagoMoshitate get過誤申立情報() {
        if (entity.getDbT3059() == null) {
            return null;
        }
        return new KagoMoshitate(entity.getDbT3059());
    }
}
