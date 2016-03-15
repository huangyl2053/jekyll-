/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic.chosachikugroup;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosachikugroup.ChosaChikuGroupRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査地区グループ調査地区一覧情報を管理するクラスです。
 */
public class ChosaChikuGroupMaster {

    private final ChosaChikuGroupRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ChosaChikuGroupRelateEntity}より{@link ChosaChikuGrou}を生成します。
     *
     * @param entity DBより取得した{@link ChosaChikuGroupRelateEntity}
     */
    public ChosaChikuGroupMaster(ChosaChikuGroupRelateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区グループ調査地区一覧情報"));
    }

    /**
     * 優先番号を返します。
     *
     * @return 優先番号
     */
    public int get優先番号() {
        return entity.getYusenNo();
    }

    /**
     * 調査地区コードを返します。
     *
     * @return 調査地区コード
     */
    public Code get調査地区コード() {
        return entity.getChosachikucode();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }
}
