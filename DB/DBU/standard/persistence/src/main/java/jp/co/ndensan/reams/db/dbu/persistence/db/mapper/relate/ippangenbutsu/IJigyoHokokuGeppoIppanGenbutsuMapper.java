/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.ippangenbutsu.JigyoHokokuGeppoIppanGenbutsuMybatisParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.JigyoHokokuIppanGenbutsuRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.KyufuJissekiKonkyoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;

/**
 *
 * 事業報告月報_一般現物のMapperクラスです。-
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
public interface IJigyoHokokuGeppoIppanGenbutsuMapper {

    /**
     * temp事業報告償還分決定年月統計元データの作成処理です。
     */
    void createtempJigyoHokokuTokeiMotoData();

    /**
     * 事業報告統計元データの取得処理です。
     *
     * @param parameter 事業報告月報_一般現物パラメータ
     *
     * @return 事業報告統計元データ
     */
    List<JigyoHokokuIppanGenbutsuRelateEntity> getJigyoHokokuTokeiMotoData(JigyoHokokuGeppoIppanGenbutsuMybatisParamter parameter);

    /**
     * 処理結果確認リストEntityの取得処理です。
     *
     * @return 処理結果確認リストEntity
     */
    List<JigyoHokokuIppanGenbutsuRelateEntity> getResultKyufuJisseki();

    /**
     * 事業報告情報の取得処理です。
     *
     * @param parameter 事業報告月報_一般現物パラメータ
     *
     * @return 事業報告情報
     */
    List<KyufuJissekiKonkyoRelateEntity> getKyufuJissekiKonkyo(JigyoHokokuGeppoIppanGenbutsuMybatisParamter parameter);

    /**
     * 事業報告統計データの取得処理です。
     *
     * @param parameter 事業報告月報_一般現物パラメータ
     *
     * @return 事業報告統計データ
     */
    List<KyufuJissekiKonkyoRelateEntity> getJigyoHokokuTokei12to14(JigyoHokokuGeppoIppanGenbutsuMybatisParamter parameter);

    /**
     * 処理日付管理マスタへ登録処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　一般状況（１～１１）パラメータ
     */
    void insertShoriDateKanri(JigyoHokokuGeppoIppanGenbutsuMybatisParamter parameter);

    /**
     * 事業状況報告統計帳票用情報の取得処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　一般状況（１～１１）パラメータ
     *
     * @return 事業状況報告統計帳票用情報
     */
    List<JigyoHokokuDataRelateEntity> getJigyouHoukokuTokeiTyouhyou(JigyoHokokuGeppoIppanGenbutsuMybatisParamter parameter);

}
