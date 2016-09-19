/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippanshokanketteiym;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.ippanshokanketteiym.JigyoHokokuGeppoIppanShokanMybatisParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym.JigyouHoukokuTokTyhyouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym.JigyouHoukokuTokeiThuRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym.JyukyushaJohoKonkyoCSVRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;

/**
 *
 * 事業報告月報_一般状況のMapperクラスです。-
 *
 * @reamsid_L DBU-5550-030 suguangjun
 */
public interface IJigyoHokokuGeppoIppanShokanMapper {

    /**
     * temp事業報告償還分決定年月統計元データの取得処理です。
     *
     * @param parameter 事業報告月報_一般状況パラメータ
     *
     */
    void insertShokanServiceData(JigyoHokokuGeppoIppanShokanMybatisParamter parameter);

    /**
     * 処理結果確認リストEntityの取得処理です。
     *
     * @param parameter 事業報告月報_一般状況パラメータ
     *
     * @return 処理結果確認リストEntity
     */
    List<JigyouHoukokuTokeiThuRelateEntity> getJigyouHoukokuTokeiThu(JigyoHokokuGeppoIppanShokanMybatisParamter parameter);

    /**
     * 統計明細CSVの取得処理です。
     *
     * @param parameter 事業報告月報_一般状況パラメータ
     *
     * @return 事業報告情報
     */
    List<JyukyushaJohoKonkyoCSVRelateEntity> getJyukyushaJohoKonkyoCSV(JigyoHokokuGeppoIppanShokanMybatisParamter parameter);

    /**
     * 事業報告統計データの削除処理です。
     *
     * @param parameter 事業報告月報_一般状況パラメータ
     */
    void deleteJigyouHoukokuTokei(JigyoHokokuGeppoIppanShokanMybatisParamter parameter);

    /**
     * 事業報告統計データの取得処理です。
     *
     * @param parameter 事業報告月報_一般状況パラメータ
     *
     * @return 事業報告統計データ
     */
    List<JigyouHoukokuTokTyhyouRelateEntity> getJyukyushaJigyouHoukokuTokei(JigyoHokokuGeppoIppanShokanMybatisParamter parameter);

    /**
     * 処理日付管理マスタへ登録処理です。
     *
     * @param parameter 事業報告月報_一般状況パラメータ
     */
    void updateShoriDateKanri(JigyoHokokuGeppoIppanShokanMybatisParamter parameter);

    /**
     * 事業報告統計データ帳票用情報の取得処理です。
     *
     * @param parameter 事業報告月報_一般状況パラメータ
     *
     * @return 事業状況報告統計帳票用情報
     */
    List<JigyouHoukokuTokTyhyouRelateEntity> getJigyouHoukokuTokeiTyouhyou(JigyoHokokuGeppoIppanShokanMybatisParamter parameter);

    /**
     * 主治医情報の取得処理です。
     *
     *
     * @return 主治医情報
     */
    List<DbT5912ShujiiJohoEntity> selectShujiiJohoList();

}
