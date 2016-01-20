/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaiKaisaiKekka;

import jp.co.ndensan.reams.db.dbe.entity.db.shinsakaiKaisaiKekka.ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定審査会開催結果登録の審査会委員一覧検索Business
 */
public class ShinsakaiWariateIinJohoBusiness {

    private final ShinsakaiWariateIinJohoEntity entity;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会開催結果登録の審査会委員一覧検索に使用します。
     *
     * @param entity ShinsakaiWariateIinJohoEntity
     */
    public ShinsakaiWariateIinJohoBusiness(ShinsakaiWariateIinJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 審査会委員コードを返します。
     *
     * @return 審査会委員コード
     */
    public RString get審査会委員コード() {
        return entity.get介護認定審査会委員コード();
    }

    /**
     * 介護認定審査会委員氏名を返します。
     *
     * @return 介護認定審査会委員氏名
     */
    public AtenaMeisho get介護認定審査会委員氏名() {
        return entity.get介護認定審査会委員氏名();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.get性別();
    }

    /**
     * 介護認定審査員資格コードを返します。
     *
     * @return 介護認定審査員資格コード
     */
    public Code get介護認定審査員資格コード() {
        return entity.get介護認定審査員資格コード();
    }

    /**
     * 合議体長区分コードを返します。
     *
     * @return 合議体長区分コード
     */
    public Code get合議体長区分コード() {
        return entity.get合議体長区分コード();
    }

    /**
     * 介護認定審査会議長区分コードを返します。
     *
     * @return 介護認定審査会議長区分コード
     */
    public Code get介護認定審査会議長区分コード() {
        return entity.get介護認定審査会議長区分コード();
    }

    /**
     * 委員出席を返します。
     *
     * @return 委員出席
     */
    public boolean get委員出席() {
        return entity.is委員出席();
    }

    /**
     * 委員遅刻有無を返します。
     *
     * @return 委員遅刻有無
     */
    public boolean get委員遅刻有無() {
        return entity.is委員遅刻有無();
    }

    /**
     * 委員出席時間を返します。
     *
     * @return 委員出席時間
     */
    public RString get委員出席時間() {
        return entity.get委員出席時間();
    }

    /**
     * 委員早退有無を返します。
     *
     * @return 委員早退有無
     */
    public boolean get委員早退有無() {
        return entity.is委員早退有無();
    }

    /**
     * 委員退席時間を返します。
     *
     * @return 委員退席時間
     */
    public RString get委員退席時間() {
        return entity.get委員退席時間();
    }

}
