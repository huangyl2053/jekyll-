/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 証交付回収情報の取得するクラスです。
 */
public class ShoKofuKaishuJohoModel {

    private final DbT7037ShoKofuKaishuEntity entity;

    /**
     * コンストラクタです。<br/>
     * 証交付回収情報の新規作成時に使用します。
     *
     * @param entity DbT7037ShoKofuKaishuEntity
     */
    public ShoKofuKaishuJohoModel(DbT7037ShoKofuKaishuEntity entity) {
        this.entity = entity;
    }

    

    /**
     * 交付証種類を返します。
     *
     * @return 交付証種類
     */
    public RString get交付証種類コード() {
        return entity.getKofuShoShurui();
    }
    
     /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getHakkoShoriTimestamp();
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public FlexibleDate get交付年月日() {
        return entity.getKofuYMD();
    }

    /**
     * 有効期限を返します。
     *
     * @return 有効期限
     */
    public FlexibleDate get有効期限() {
        return entity.getKofuYMD();
    }

    /**
     * 交付事由コードを返します。
     *
     * @return 交付事由コード
     */
    public RString get交付事由コード() {
        return entity.getKofuJiyu();
    }

    /**
     * 交付理由を返します。
     *
     * @return 交付理由
     */
    public RString get交付理由() {
        return entity.getKofuRiyu();
    }

    /**
     * 回収年月日を返します。
     *
     * @return 回収年月日
     */
    public FlexibleDate get回収年月日() {
        return entity.getKaishuYMD();
    }

    /**
     * 回収事由コードを返します。
     *
     * @return 回収事由コード
     */
    public RString get回収事由コード() {
        return entity.getKaishuJiyu();
    }

    /**
     * 回収理由を返します。
     *
     * @return 回収理由
     */
    public RString get回収理由() {
        return entity.getKaishuRiyu();
    }

}
