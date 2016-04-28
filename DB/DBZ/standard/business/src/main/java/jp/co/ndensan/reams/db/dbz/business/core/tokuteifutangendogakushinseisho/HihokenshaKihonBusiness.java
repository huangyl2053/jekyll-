/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.tokuteifutangendogakushinseisho.HihokenshaKihonEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者基本情報Businessです。
 *
 * @reamsid_L DBA-0540-714 yaodongsheng
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
        return new RString("11");
//        return entity.getフリガナ();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
//        return entity.get被保険者氏名();
        return new RString("11");
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
//        return entity.get保険者番号();
        return new HokenshaNo("11");
    }

    /**
     * 保険者名称を取得します。
     *
     * @return 保険者名称
     */
    public RString get保険者名称() {
//        return entity.get保険者名称();
        return new RString("11");
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
//        return entity.get被保険者番号();
        return new HihokenshaNo("11");
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
//        return entity.get生年月日();
        return new FlexibleDate("20160101");
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
//        return entity.get性別();
        return new RString("11");
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get続柄() {
//        return entity.get続柄();
        return new RString("11");
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get郵便番号() {
//        return entity.get郵便番号();
        return new RString("11");

    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get電話番号() {
//        return entity.get電話番号();
        return new RString("11");

    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get住所() {
//        return entity.get住所();
        return new RString("11");
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get住民種別コード() {
//        return entity.get住民種別コード();
        return new RString("11");
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get世帯主氏名() {
//        return entity.get世帯主氏名();
        return new RString("11");
    }

    /**
     * フリガナを取得します。
     *
     * @return フリガナ
     */
    public RString get生年月日不詳区分() {
//        return entity.get生年月日不詳区分();
        return new RString("11");
    }

    /**
     * 方書を取得します。
     *
     * @return 方書
     */
    public RString get方書() {
//        return entity.get方書();
        return new RString("11");
    }
}
