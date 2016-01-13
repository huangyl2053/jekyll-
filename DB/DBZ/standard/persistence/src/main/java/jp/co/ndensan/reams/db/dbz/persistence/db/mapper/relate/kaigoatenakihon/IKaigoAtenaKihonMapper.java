/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kaigoatenakihon;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kaigoatenakihon.KaigoAtenaKihonEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 介護資格系基本情報のマッパーインタフェースです。
 */
public interface IKaigoAtenaKihonMapper {

    /**
     * 介護資格基本情報を識別コード検索でリスト取得します。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @return リストKaigoAtenaKihonEntity
     */
    List<KaigoAtenaKihonEntity> selectKaigoShikakuKihonByShikibetsuCode(ShikibetsuCode shikibetsuCode);
}
