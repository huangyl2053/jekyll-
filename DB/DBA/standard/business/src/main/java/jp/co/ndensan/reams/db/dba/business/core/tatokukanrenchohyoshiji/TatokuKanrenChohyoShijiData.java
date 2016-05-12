/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tatokukanrenchohyoshiji;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho.TatokuKanrenChohyoShijiDataEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例者関連帳票の項目定義クラスです。
 *
 * @reamsid_L DBA-0380-020 houtianpeng
 */
public class TatokuKanrenChohyoShijiData implements Serializable {

    private final TatokuKanrenChohyoShijiDataEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 帳票発行指示データ作成Entity
     */
    public TatokuKanrenChohyoShijiData(TatokuKanrenChohyoShijiDataEntity entity) {
        this.entity = entity;
    }

    /**
     * Entityを取得します。
     *
     * @return Entity
     */
    public TatokuKanrenChohyoShijiDataEntity getEntity() {
        return entity;
    }

    /**
     * 保険者郵便番号を取得します。
     *
     * @return 保険者郵便番号
     */
    public YubinNo get保険者郵便番号() {
        return entity.get保険者郵便番号();
    }

    /**
     * 文書番号を取得します。
     *
     * @return 文書番号
     */
    public RString get文書番号() {
        return entity.get文書番号();
    }

    /**
     * 保険者住所を取得します。
     *
     * @return 保険者住所
     */
    public RString get保険者住所() {
        return entity.get保険者住所();
    }

    /**
     * 発行年月日を取得します。
     *
     * @return 発行年月日
     */
    public FlexibleDate get発行年月日() {
        return entity.get発行年月日();
    }

    /**
     * 保険者名を取得します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.get保険者名();
    }

    /**
     * 保険者名敬称を取得します。
     *
     * @return 保険者名敬称
     */
    public RString get保険者名敬称() {
        return entity.get保険者名敬称();
    }

    /**
     * 担当部署名を取得します。
     *
     * @return 担当部署名
     */
    public RString get担当部署名() {
        return entity.get担当部署名();
    }

    /**
     * 担当部署名敬称を取得します。
     *
     * @return 担当部署名敬称
     */
    public RString get担当部署名敬称() {
        return entity.get担当部署名敬称();
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
     * 異動日を取得します。
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return entity.getIdoYMD();
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public RString get枝番() {
        return entity.getEdaNo();
    }

    /**
     * 入所年月日を取得します。
     *
     * @return 入所年月日
     */
    public FlexibleDate get入所年月日() {
        return entity.get入所年月日();
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
     * 住所出力不要フラグを取得します。
     *
     * @return 住所出力不要フラグ
     */
    public boolean is住所出力不要フラグ() {
        return entity.is住所出力不要フラグ();
    }
}
