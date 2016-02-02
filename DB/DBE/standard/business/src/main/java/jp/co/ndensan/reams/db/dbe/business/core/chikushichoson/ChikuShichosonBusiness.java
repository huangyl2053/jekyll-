/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chikushichoson;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 認定調査スケジュール登録1を管理するクラスです。
 */
public class ChikuShichosonBusiness {

    private final DbT5224ChikuShichosonEntity entity;

    /**
     * 認定調査スケジュール登録1項目を返します。
     *
     * @param entity NinnteiChousairaiEntity
     */
    public ChikuShichosonBusiness(DbT5224ChikuShichosonEntity entity) {
        this.entity = entity;
    }

    /**
     * 調査地区コードを返します。
     *
     * @return 調査地区コード
     */
    public Code getChosaChikuCode() {
        return entity.getChosaChikuCode();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return entity.getShichosonCode();
    }

    /**
     * 優先番号を返します。
     *
     * @return 優先番号
     */
    public int getYusenNo() {
        return entity.getYusenNo();
    }

    /**
     * 自地区フラグを返します。
     *
     * @return 自地区フラグ
     */
    public boolean isJiChikuFlag() {
        return entity.getJiChikuFlag();
    }
}
