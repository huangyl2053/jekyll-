/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tatokukanrenchohyoshiji;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tatokukanrenchohyoshiji.TatokuKanrenChohyoSofusakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例者関連帳票の項目定義クラスです。
 *
 * @reamsid_L DBA-0380-020 houtianpeng
 */
public class TatokuKanrenChohyoSofusaki implements Serializable {

    private final TatokuKanrenChohyoSofusakiEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 画面初期値取得Entity
     */
    public TatokuKanrenChohyoSofusaki(TatokuKanrenChohyoSofusakiEntity entity) {
        this.entity = entity;
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
    public RString get住所() {
        return entity.get住所();
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
     * 役所名を取得します。
     *
     * @return 役所名
     */
    public RString get役所名() {
        return entity.get役所名();
    }

    /**
     * 役所名敬称を取得します。
     *
     * @return 役所名敬称
     */
    public RString get役所名敬称() {
        return entity.get役所名敬称();
    }

    /**
     * 担当課名を取得します。
     *
     * @return 担当課名
     */
    public RString get担当課名() {
        return entity.get担当課名();
    }

    /**
     * 担当課名敬称を取得します。
     *
     * @return 担当課名敬称
     */
    public RString get担当課名敬称() {
        return entity.get担当課名敬称();
    }

    /**
     * 発行日を取得します。
     *
     * @return 発行日
     */
    public FlexibleDate get発行日() {
        return entity.get発行日();
    }

    /**
     * 文書番号を取得します。
     *
     * @return 文書番号
     */
    public RString get文書番号() {
        return entity.get文書番号();
    }
}
