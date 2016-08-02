/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.yokaigoninteijoho.YokaigoNinteiTsutishoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho.YokaigoNinteiTsutishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho.YokaigoNinteiTsutishoIkkatsuHakkoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 要介護認定通知書発行の処理します。
 *
 * @reamsid_L DBE-1430-010 lit
 */
public interface IYokaigoNinteiTsutishoMapper {

    /**
     * 対象者情報の取得します。
     *
     * @param 認定通知書発行検索用パラメータ YokaigoNinteiTsutishoMybatisParameter
     * @return 対象者情報 List<YokaigoNinteiTsutishoEntity>
     */
    List<YokaigoNinteiTsutishoEntity> get対象者情報(YokaigoNinteiTsutishoMybatisParameter 認定通知書発行検索用パラメータ);

    /**
     * 認定結果通知書情報の取得します。
     *
     * @param 認定通知書発行検索用パラメータ YokaigoNinteiTsutishoMybatisParameter
     * @return 認定結果通知書情報 List<YokaigoNinteiTsutishoEntity>
     */
    List<YokaigoNinteiTsutishoEntity> get認定結果通知書情報(YokaigoNinteiTsutishoMybatisParameter 認定通知書発行検索用パラメータ);

    /**
     * 受給者台帳情報の取得します。
     *
     * @param 認定通知書発行検索用パラメータ YokaigoNinteiTsutishoMybatisParameter
     * @return 受給者台帳情報 List<YokaigoNinteiTsutishoEntity>
     */
    List<YokaigoNinteiTsutishoEntity> get受給者台帳情報(YokaigoNinteiTsutishoMybatisParameter 認定通知書発行検索用パラメータ);

    /**
     * 一括発行データの取得します。
     *
     * @param 市町村コード RString
     * @param 処理名 RString
     * @return 一括発行データ List<YokaigoNinteiTsutishoIkkatsuHakkoEntity>
     */
    List<YokaigoNinteiTsutishoIkkatsuHakkoEntity> get一括発行データ(
            @Param("市町村コード") RString 市町村コード,
            @Param("処理名") RString 処理名);
}
