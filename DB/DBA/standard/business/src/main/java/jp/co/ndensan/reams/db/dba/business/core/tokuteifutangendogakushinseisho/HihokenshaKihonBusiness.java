/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dba.entity.db.relate.tokuteifutangendogakushinseisho.HihokenshaKihonEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者基本情報Businessです。
 */
public class HihokenshaKihonBusiness {

    private final HihokenshaKihonEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity HihokenshaKihonEntity
     */
    public HihokenshaKihonBusiness(HihokenshaKihonEntity entity) {
        this.entity = entity;
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString getフリガナ() {
        return entity.getフリガナ();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return entity.get保険者番号();
    }

    /**
     * 保険者名称を取得します。
     *
     * @return 保険者名称
     */
    public RString get保険者名称() {
        return entity.get保険者名称();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.get被保険者番号();
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
    public RString get性別() {
        return entity.get性別();
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get続柄() {
        return entity.get続柄();
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get郵便番号() {
        return entity.get郵便番号();
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get電話番号() {
        return entity.get電話番号();
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get住所() {
        return entity.get住所();
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get住民種別コード() {
        return entity.get住民種別コード();
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get世帯主氏名() {
        return entity.get世帯主氏名();
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get生年月日不詳区分() {
        return entity.get生年月日不詳区分();
    }
}
