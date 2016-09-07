/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.iryohikojokakuninsinsei;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.iryohikojokakuninsinsei.IryoHiKojoKakuninSinseiParameter;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
public interface IIryoHiKojoKakuninSinseiMapper {

    /**
     * 受給者判定
     *
     * @param 被保険者番号 RString
     * @return Integer
     */
    Integer 受給者台帳抽出(RString 被保険者番号);

    /**
     * おむつ使用証明書、主治医意見書確認書の編集に用いる宛名情報を取得する。
     *
     * @param param パラメータ
     * @param 識別コード 識別コード
     * @return 宛名情報
     */
    UaFt200FindShikibetsuTaishoEntity select宛名情報(IryoHiKojoKakuninSinseiParameter param, @Param("識別コード") ShikibetsuCode 識別コード);

}
