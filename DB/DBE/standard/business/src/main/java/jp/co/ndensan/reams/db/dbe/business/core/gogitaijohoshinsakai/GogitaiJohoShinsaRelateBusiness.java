/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijohoshinsakai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohoshinsakai.GogitaiJohoShinsaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 合議体情報と介護認定審査会委員情報のRelateBusinessクラスです。
 */
public class GogitaiJohoShinsaRelateBusiness {

    private final GogitaiJohoShinsaRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity GogitaiJohoShinsaRelateEntity
     */
    public GogitaiJohoShinsaRelateBusiness(GogitaiJohoShinsaRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 合議体番号のgetメソッドです。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.get合議体番号();
    }

    /**
     * 合議体名称のgetメソッドです。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.get合議体名称();
    }

    /**
     * 合議体番号のgetメソッドです。
     *
     * @return 合議体精神科医存在フラグ
     */
    public boolean is合議体精神科医存在フラグ() {
        return entity.is合議体精神科医存在フラグ();
    }

    /**
     * 介護認定審査会委員氏名のgetメソッドです。
     *
     * @return 介護認定審査会委員氏名
     */
    public RString get介護認定審査会委員氏名() {
        return entity.get介護認定審査会委員氏名();
    }

    /**
     * 介護認定審査会開催場所コードのgetメソッドです。
     *
     * @return 介護認定審査会開催場所コード
     */
    public RString get介護認定審査会開催場所コード() {
        return entity.get介護認定審査会開催場所コード();
    }

    /**
     * 介護認定審査会委員氏名のgetメソッドです。
     *
     * @return 介t介護認定審査会予定定員
     */
    public int get介護認定審査会予定定員() {
        return entity.get介護認定審査会予定定員();

    }

    /**
     * 介護認定審査会自動割当定員のgetメソッドです。
     *
     * @return 介護認定審査会自動割当定員
     */
    public int get介護認定審査会自動割当定員() {
        return entity.get介護認定審査会自動割当定員();
    }

    /**
     * 介護認定審査会委員定員のgetメソッドです。
     *
     * @return 介護認定審査会委員定員
     */
    public int get介護認定審査会委員定員() {
        return entity.get介護認定審査会委員定員();
    }

    /**
     * 介護認定審査会開催予定年月日のgetメソッドです。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public FlexibleDate get介護認定審査会開催予定年月日() {
        return entity.get介護認定審査会開催予定年月日();
    }

    /**
     * 介護認定審査会開始予定時刻のgetメソッドです。
     *
     * @return 介護認定審査会開始予定時刻
     */
    public RString get介護認定審査会開始予定時刻() {
        return entity.get介護認定審査会開始予定時刻();
    }

    /**
     * 介護認定審査会終了予定時刻のgetメソッドです。
     *
     * @return 介護認定審査会終了予定時刻
     */
    public RString get介護認定審査会終了予定時刻() {
        return entity.get介護認定審査会終了予定時刻();
    }
}
