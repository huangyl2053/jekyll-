
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shogaishakoujohaaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4010011.ShogaishaKojoTaishoshaHaakuKekkaIchiranMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shogaishakojotaishoshahaakukekkaichiran.ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity;

/**
 * 控除対象者データの取得のMapperクラスです。
 *
 * @reamsid_L DBD-3850-030 liuwei2
 */
public interface IShogaishaKojoTaishoshaHaakuKekkaIchiranMapper {

    /**
     * 介護施設入退所情報を取得します。
     *
     * @param parameter ShogaishaKojoTaishoshaHaakuKekkaIchiranMapperParameter
     * @return List<ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity>
     */
    List<ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity> get障がい者控除対象者出力一覧情報(ShogaishaKojoTaishoshaHaakuKekkaIchiranMapperParameter parameter);

    /**
     * 障がい者控除情報を取得します。
     *
     * @return List<DbT4038ShogaishaKoujoEntity>
     */
    List<DbT4038ShogaishaKoujoEntity> get障がい者控除();

    /**
     * 減免減額申請情報を取得します。
     *
     * @return List<DbT4010GemmenGengakuShinseiEntity>
     */
    List<DbT4010GemmenGengakuShinseiEntity> get減免減額申請();
}
