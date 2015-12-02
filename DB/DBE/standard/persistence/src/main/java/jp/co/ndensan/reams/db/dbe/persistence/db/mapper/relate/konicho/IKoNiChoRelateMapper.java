/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.konicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.konicho.KoNiChoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.konicho.KoNiChoRelateEntity;

/**
 *
 * @author LINGHUHANG
 */
public interface IKoNiChoRelateMapper {

    /**
     * 調査員情報の検索
     *
     * @param 調査員検索条件
     * @return
     */
    List<KoNiChoRelateEntity> getKoNiChoRelateEntity(KoNiChoRelateMapperParameter 調査員検索条件);

//    /**
//     * 調査員情報の重複チェック
//     *
//     * @param 調査員内容
//     * @return
//     */
//    int getKoNiChoSearchResultCount(KoNiChoRelateMapperParameter 調査員内容);
//
//    /**
//     * 調査員情報の削除前処理
//     *
//     * @param 調査員内容
//     * @return
//     */
//    int getKoNiChobeforeDeleteCount(KoNiChoRelateMapperParameter 調査員内容);
//
//    /**
//     * 調査員情報の削除前処理
//     *
//     * @param 調査員内容
//     * @return
//     */
//    int getKoNiChobeforeDeleteResult(KoNiChoRelateMapperParameter 調査員内容);
}
