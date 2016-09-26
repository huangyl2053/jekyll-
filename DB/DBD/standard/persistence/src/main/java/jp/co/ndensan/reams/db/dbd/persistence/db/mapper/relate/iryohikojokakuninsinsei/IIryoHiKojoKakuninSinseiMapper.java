/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.iryohikojokakuninsinsei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.iryohikojokakuninsinsei.ShikibetsuTaishoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.iryohikojokakuninsinsei.IryohiKojoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.iryohikojokakuninsinsei.SogoJigyouTaisyouSyaJyohoJoho;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
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
     * 受給者判定
     *
     * @param 被保険者番号 RString
     * @param 対象年 RString
     * @return DbT4001JukyushaDaicho
     */
    SogoJigyouTaisyouSyaJyohoJoho select受給者台帳情報(@Param("被保険者番号") RString 被保険者番号, @Param("対象年") RString 対象年);

    /**
     * 単票用医療費控除取得
     *
     * @param 被保険者番号 RString
     * @param データ区分 RString
     * @return 単票用医療費控除
     */
    List<IryohiKojoEntity> select単票用医療費控除(@Param("被保険者番号") RString 被保険者番号, @Param("データ区分") RString データ区分);

    /**
     * おむつ使用証明書、主治医意見書確認書の編集に用いる宛名情報を取得する。
     *
     * @param param パラメータ
     * @return 宛名情報
     */
    UaFt200FindShikibetsuTaishoEntity select宛名情報(ShikibetsuTaishoParameter param);
}
