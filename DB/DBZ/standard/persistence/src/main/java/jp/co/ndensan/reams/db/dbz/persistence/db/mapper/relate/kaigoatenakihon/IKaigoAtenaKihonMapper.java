/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kaigoatenakihon;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kaigoatenakihon.KaigoAtenaKihonEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 介護資格系基本情報のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0030-010 wangxiaodong
 */
public interface IKaigoAtenaKihonMapper {

    /**
     * 介護資格基本情報を識別コード検索でリスト取得します。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @return リストKaigoAtenaKihonEntity
     */
    List<KaigoAtenaKihonEntity> selectKaigoShikakuKihonByShikibetsuCode(ShikibetsuCode shikibetsuCode);

    /**
     * 介護資格基本情報を被保険者番号検索でリスト取得します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return リストKaigoAtenaKihonEntity
     */
    List<KaigoAtenaKihonEntity> selectKaigoShikakuKihonByHihokenshaNo(HihokenshaNo hihokenshaNo);
}
