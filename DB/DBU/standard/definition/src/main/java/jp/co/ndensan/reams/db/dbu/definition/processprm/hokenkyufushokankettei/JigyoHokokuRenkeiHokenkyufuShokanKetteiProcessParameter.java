/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.hokenkyufushokankettei;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hokenkyufushokankettei.JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import lombok.Getter;

/**
 * 保険給付【償還_決定】のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter implements IBatchProcessParameter {

    private final RString プリントコントロール区分;
    private final RString 集計年月;
    private final RString 報告年月;
    private final RString 作成日付;
    private final RString 処理日時;
    private final RString 統計対象区分;
    private final RString 市町村コード;
    private final RString 構成市町村区分;
    private final RString 旧市町村区分;
    private final List<RString> 構成市町村コードリスト;
    private final List<RString> 旧市町村コードリスト;
    private final List<RString> 過去集計分市町村コードリスト;
    private final RString 過去集計分旧市町村区分;
    private final RString バッチID;
    private final RString csvFilePath;
    private final FileSpoolManager manager;

    /**
     * コンストラクタです。
     *
     * @param プリントコントロール区分 プリントコントロール区分
     * @param 集計年月 集計年月
     * @param 報告年月 報告年月
     * @param 作成日付 作成日付
     * @param 処理日時 処理日時
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 旧市町村区分 旧市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村コードリスト 旧市町村コードリスト
     * @param 過去集計分市町村コードリスト 過去集計分市町村コードリスト
     * @param 過去集計分旧市町村区分 過去集計分旧市町村区分
     * @param バッチID バッチID
     * @param csvFilePath csvFilePath
     * @param manager manager
     */
    public JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter(RString プリントコントロール区分,
            RString 集計年月,
            RString 報告年月,
            RString 作成日付,
            RString 処理日時,
            RString 統計対象区分,
            RString 市町村コード,
            RString 構成市町村区分,
            RString 旧市町村区分,
            List<RString> 構成市町村コードリスト,
            List<RString> 旧市町村コードリスト,
            List<RString> 過去集計分市町村コードリスト,
            RString 過去集計分旧市町村区分,
            RString バッチID,
            RString csvFilePath,
            FileSpoolManager manager) {
        this.プリントコントロール区分 = プリントコントロール区分;
        this.集計年月 = 集計年月;
        this.報告年月 = 報告年月;
        this.作成日付 = 作成日付;
        this.処理日時 = 処理日時;
        this.統計対象区分 = 統計対象区分;
        this.市町村コード = 市町村コード;
        this.構成市町村区分 = 構成市町村区分;
        this.旧市町村区分 = 旧市町村区分;
        this.構成市町村コードリスト = 構成市町村コードリスト;
        this.旧市町村コードリスト = 旧市町村コードリスト;
        this.過去集計分市町村コードリスト = 過去集計分市町村コードリスト;
        this.過去集計分旧市町村区分 = 過去集計分旧市町村区分;
        this.バッチID = バッチID;
        this.csvFilePath = csvFilePath;
        this.manager = manager;
    }

    /**
     * 保険給付【償還_決定】の根拠CSV情報作成処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter create根拠CSV情報作成MybitisParamter() {
        return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter.create根拠CSV情報作成Paramter(集計年月);
    }

    /**
     * 処理日付管理マスタへ登録処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter create処理日付管理マスタへ登録MybitisParamter() {
        return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter.create処理日付管理マスタへ登録Paramter(集計年月,
                市町村コード,
                構成市町村区分,
                旧市町村区分,
                構成市町村コードリスト,
                旧市町村コードリスト,
                作成日付,
                処理日時,
                プリントコントロール区分);
    }

    /**
     * 保険給付【償還_決定】の根拠CSV情報作成処理mybatisのパラメータを生成します。
     *
     * @param 市町村コードList 市町村コードList
     * @param 表番号List 表番号List
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter create事業状況報告取得MybitisParamter(
            List<RString> 市町村コードList,
            List<RString> 表番号List) {
        return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter.create事業状況報告取得Paramter(
                市町村コードList,
                集計年月,
                表番号List);
    }

    /**
     * 事業報告統計データを削除するmybatisのパラメータを生成します。
     *
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter createDelete事業報告統計データMybitisParamter() {
        return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter.delete事業状況報告取得Paramter(集計年月);
    }

    /**
     * 事業報告統計データを削除するmybatisのパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 旧市町村コード 旧市町村コード
     * @param 縦軸index 縦軸index
     * @param 横軸index 横軸index
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter create集計結果値MybitisParamter(
            RString 市町村コード,
            RString 旧市町村コード,
            int 縦軸index,
            int 横軸index) {
        return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter.get集計結果値のParameter(
                市町村コード,
                旧市町村コード,
                構成市町村区分,
                旧市町村区分,
                縦軸index,
                横軸index);
    }

    /**
     * 事業報告統計データを削除するmybatisのパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 表番号 表番号
     * @param 集計番号 集計番号
     * @param 縦軸index 縦軸index
     * @param 横軸index 横軸index
     * @param 集計結果値 集計結果値
     * @param 統計対象区分 統計対象区分
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter createInsert事業報告統計データMybitisParamter(
            RString 市町村コード,
            RString 表番号,
            RString 集計番号,
            int 縦軸index,
            int 横軸index,
            Decimal 集計結果値,
            RString 統計対象区分) {
        return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter.set事業報告統計データのParameter(
                市町村コード,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                報告年月,
                集計年月,
                表番号,
                集計番号,
                縦軸index,
                横軸index,
                集計結果値,
                統計対象区分);
    }
}
