/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.ippangenbutsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業報告月報_一般現物のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class TempJigyoHokokuTokeiMotoDataMybatisParamter implements IMyBatisParameter {

    private final List<RString> 対象市町村コードList;
    private final RString 集計年月;
    private final RString 給付実績区分コード;
    private final List<RString> 集計番号List;

    private TempJigyoHokokuTokeiMotoDataMybatisParamter(
            List<RString> 対象市町村コードList,
            RString 集計年月,
            RString 給付実績区分コード,
            List<RString> 集計番号List) {
        this.対象市町村コードList = 対象市町村コードList;
        this.集計年月 = 集計年月;
        this.給付実績区分コード = 給付実績区分コード;
        this.集計番号List = 集計番号List;
    }

    /**
     * 事業報告統計データの削除処理mybatisのパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 集計年月 集計年月
     * @param 給付実績区分コード 給付実績区分コード
     * @param 集計番号List 集計番号List
     * @param 広域フラグ 広域フラグ
     * @param 構成市町村コードList 構成市町村コードList
     * @param 旧市町村コードList 旧市町村コードList
     * @param 合併フラグ 合併フラグ
     * @return TempJigyoHokokuTokeiMotoDataMybatisParamter
     */
    public static TempJigyoHokokuTokeiMotoDataMybatisParamter createDataParam(RString 市町村コード,
            RString 集計年月,
            RString 給付実績区分コード,
            List<RString> 集計番号List,
            List<RString> 構成市町村コードList,
            List<RString> 旧市町村コードList,
            boolean 広域フラグ,
            boolean 合併フラグ) {
        List<RString> 対象市町村コードList = new ArrayList<>();
        対象市町村コードList.add(市町村コード);
        if (広域フラグ) {
            対象市町村コードList.addAll(構成市町村コードList);
        }
        if (合併フラグ) {
            対象市町村コードList.addAll(旧市町村コードList);
        }
        return new TempJigyoHokokuTokeiMotoDataMybatisParamter(
                対象市町村コードList, 集計年月, 給付実績区分コード, 集計番号List);
    }
}
