/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppoippan;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.HihokenshaDaichoBirthYMDMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyouHoukokuTokeiMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.RiyoshaFutangakuKanriJohoSyoriMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.SyotaiJohoSyoriMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.TokuteiNyushoshaJohoSyoriMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.YokaigoNinteishaJohoSyoriMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogaku.ShoriKekkaKakuninListRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.IchigoHihokenshaJohoKonkyoCSVEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.IppanJokyoJigyouHoukokuTokeiEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.RiyoshaFutangakuGemmenJohoKonkyoCSVEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.SyotaiJohoCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.TokuteiNyushoshaGengakuNinteiJohoCSVEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.YokaigoNinteishaJohoKonkyoCSVEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;

/**
 * 事業報告月報_一般状況のMapperクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public interface IJigyoHokokuGeppoIppanMapper {

    /**
     * temp事業報告被保険者統計元データテーブルをCREATEします。
     */
    void createTempJigyoHokokuHihokenshaTokeiMotoData();

    /**
     * 事業状況報告世帯情報をtemp事業報告被保険者統計元データテーブルに登録します。
     *
     * @param paramter SyotaiJohoSyoriMybatisParameter
     */
    void exeShotaiDataInsert(SyotaiJohoSyoriMybatisParameter paramter);

    /**
     * 事業状況報告情報を取得します。
     *
     * @return List<SyotaiJohoCsvEntity>
     */
    List<SyotaiJohoCsvEntity> getShotaiJohoKonkyoCSV();

    /**
     * 被保台帳生年月日情報をtemp事業報告被保険者統計元データテーブルに登録します。
     *
     * @param paramter HihokenshaDaichoBirthYMDMybatisParameter
     */
    void exeIchigoHihokenshaDataInsert(HihokenshaDaichoBirthYMDMybatisParameter paramter);

    /**
     * 被保台帳生年月日情報をtemp事業報告被保険者統計元データテーブルに登録します。
     *
     * @param paramter HihokenshaDaichoBirthYMDMybatisParameter
     * @return List<IchigoHihokenshaJohoKonkyoCSVEntity>
     */
    List<IchigoHihokenshaJohoKonkyoCSVEntity> getIchigoHihokenshaJohoKonkyoCSV(HihokenshaDaichoBirthYMDMybatisParameter paramter);

    /**
     * 利用者負担減額管理情報をtemp事業報告認定統計元データテーブルに登録します。
     *
     * @param paramter RiyoshaFutangakuKanriJohoSyoriMybatisParameter
     */
    void exeRiyoshaFutangakuGemmenDataInsert(RiyoshaFutangakuKanriJohoSyoriMybatisParameter paramter);

    /**
     * 利用者負担減額管理情報をtemp事業報告認定統計元データテーブルに登録します。
     *
     * @param paramter RiyoshaFutangakuKanriJohoSyoriMybatisParameter
     * @return List<IchigoHihokenshaJohoKonkyoCSVEntity>
     */
    List<RiyoshaFutangakuGemmenJohoKonkyoCSVEntity> getRiyoshaFutangakuGemmenJohoKonkyoCSV(RiyoshaFutangakuKanriJohoSyoriMybatisParameter paramter);

    /**
     * 特定入所者管理情報をtemp事業報告認定統計元データテーブルに登録します。
     *
     * @param paramter RiyoshaFutangakuKanriJohoSyoriMybatisParameter
     */
    void exeTokuteiNyushoshaDataInsert(TokuteiNyushoshaJohoSyoriMybatisParameter paramter);

    /**
     * 利用者負担減額管理情報をtemp事業報告認定統計元データテーブルに登録します。
     *
     * @param paramter TokuteiNyushoshaJohoSyoriMybatisParameter
     * @return List<TokuteiNyushoshaGengakuNinteiJohoCSVEntity>
     */
    List<TokuteiNyushoshaGengakuNinteiJohoCSVEntity> getTokuteiNyushoshaGengakuNinteiJohoCSV(TokuteiNyushoshaJohoSyoriMybatisParameter paramter);

    /**
     * 特定入所者管理情報をtemp事業報告認定統計元データテーブルに登録します。
     *
     * @param paramter YokaigoNinteishaJohoSyoriMybatisParameter
     */
    void exeYokaigoNinteishaDataInsert(YokaigoNinteishaJohoSyoriMybatisParameter paramter);

    /**
     * 利用者負担減額管理情報をtemp事業報告認定統計元データテーブルに登録します。
     *
     * @param paramter YokaigoNinteishaJohoSyoriMybatisParameter
     * @return List<TokuteiNyushoshaGengakuNinteiJohoCSVEntity>
     */
    List<YokaigoNinteishaJohoKonkyoCSVEntity> getYokaigoNinteishaJohoKonkyoCSV(YokaigoNinteishaJohoSyoriMybatisParameter paramter);

    /**
     * 事業報告統計データを削除します。
     *
     * @param paramter JigyouHoukokuTokeiMybatisParameter
     */
    void exeJigyouHoukokuTokeiDelete(JigyouHoukokuTokeiMybatisParameter paramter);

    /**
     * 事業状況報告統計情報を取得します。
     *
     * @param paramter JigyouHoukokuTokeiMybatisParameter
     * @return List<IppanJokyoJigyouHoukokuTokeiEntity>
     */
    List<IppanJokyoJigyouHoukokuTokeiEntity> getIppanJokyoJigyouHoukokuTokei(JigyouHoukokuTokeiMybatisParameter paramter);

    /**
     * 処理日付管理マスタを登録します。
     *
     * @param paramter JigyouHoukokuTokeiMybatisParameter
     */
    void exeShoriDateKanriUpdate(JigyouHoukokuTokeiMybatisParameter paramter);

    /**
     * 事業報告統計データを取得します。
     *
     * @param paramter JigyoHokokuGeppoIppanReportMybatisParameter
     * @return List<JigyoHokokuDataRelateEntity>
     */
    List<JigyoHokokuDataRelateEntity> getJigyouHoukokuTokeiTyouhyou(JigyoHokokuGeppoIppanReportMybatisParameter paramter);

    /**
     * 世帯情報処理の確認リストを取得します。
     *
     * @param paramter JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter
     * @return List<ShoriKekkaKakuninListRelateEntity>
     */
    List<ShoriKekkaKakuninListRelateEntity> getHihokenshaDaichoSyoriKakuninRisuto(JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter paramter);

    /**
     * 被保台帳生年月日情報の確認リストを取得します。
     *
     * @param paramter JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter
     * @return List<ShoriKekkaKakuninListRelateEntity>
     */
    List<ShoriKekkaKakuninListRelateEntity> getIchigoHihokenshaSyoriKakuninRisuto(JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter paramter);

    /**
     * 利用者負担減額管理情報の確認リストを取得します。
     *
     * @param paramter JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter
     * @return List<ShoriKekkaKakuninListRelateEntity>
     */
    List<ShoriKekkaKakuninListRelateEntity> getRiyoshaFutangakuGemmenHihokenshaDaichoSyoriKakuninRisuto(
            JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter paramter);

    /**
     * 特定入所者管理情報または標準負担額減免情報の確認リストを取得します。
     *
     * @return List<ShoriKekkaKakuninListRelateEntity>
     */
    List<ShoriKekkaKakuninListRelateEntity> getTokuteiNyushoshaGengakuNinteiSyoriKakuninRisuto();

    /**
     * 受給者台帳情報の確認リストを取得します。
     *
     * @param paramter JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter
     * @return List<ShoriKekkaKakuninListRelateEntity>
     */
    List<ShoriKekkaKakuninListRelateEntity> getYokaigoNinteishaSyoriKakuninRisuto(JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter paramter);
}
