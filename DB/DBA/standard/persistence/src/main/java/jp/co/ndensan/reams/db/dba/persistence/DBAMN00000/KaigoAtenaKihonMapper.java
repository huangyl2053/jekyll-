/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.DBAMN00000;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.DBAMN00000.KaigoAtenaKihonEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 介護資格系基本情報のマッパーインタフェースです。
 */
public interface KaigoAtenaKihonMapper {

    /**
     * 介護資格基本情報を識別コード検索でリスト取得します。
     *
     * @param ShikibetsuCode shikibetsuCode
     * @return List　KaigoAtenaKihonEntity
     */
    List<KaigoAtenaKihonEntity> selectKaigoShikakuKihonByShikibetsuCode(ShikibetsuCode shikibetsuCode);
}
