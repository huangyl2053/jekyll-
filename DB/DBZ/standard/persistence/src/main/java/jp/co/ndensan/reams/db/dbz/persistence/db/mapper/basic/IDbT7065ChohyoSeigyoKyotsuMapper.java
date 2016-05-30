/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.chohyoseigyokyotsucontro.ChohyoSeigyoKyotsuParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;

/**
 *
 * @author LDNS xuxf
 */
public interface IDbT7065ChohyoSeigyoKyotsuMapper {

    /**
     * {@link DbT7065ChohyoSeigyoKyotsuEntity}を取得します。
     *
     * @return {@link DbT7065ChohyoSeigyoKyotsuEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7065ChohyoSeigyoKyotsuEntity getEntity();

    /**
     * 帳票分類名称の取得処理します。
     *
     * @param params ChohyoSeigyoKyotsuControParameter
     * @return List<IKijuntsukiShichosonjohoRelateEntity>
     */
    List<DbT7065ChohyoSeigyoKyotsuEntity> get帳票分類名称(ChohyoSeigyoKyotsuParameter params);
}
