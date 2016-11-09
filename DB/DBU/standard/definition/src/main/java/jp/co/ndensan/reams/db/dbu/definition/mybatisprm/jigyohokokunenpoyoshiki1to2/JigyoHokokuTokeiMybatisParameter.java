/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業状況報告年報　様式１・２のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class JigyoHokokuTokeiMybatisParameter implements IMyBatisParameter {

    private final FlexibleDate 報告開始年月;
    private final FlexibleDate 報告終了年月;
    private final FlexibleYear 報告年;
    private final RString 報告月;
    private final LasdecCode 市町村コード;
    private final Code 表番号;
    private final Code 集計番号;
    private final Code 縦項目コード;
    private final Code 横項目コード;

    private final List<RString> 市町村コードリスト;
    private final RString サブ業務コード;
    private final RString 処理名;
    private final RString 処理枝番;
    private final RString 年度;
    private final RString 基準年月日;
    private final RString 基準日時;

    private final boolean is期間;
    private final boolean isNo期間;
    private final boolean isSum;
    private final boolean isNoSum;

    private static final RString 市町村コード区分 = new RString("1");
    private static final RString 日付_FORMAT = new RString("yyyyMMddHHmmss");

    /**
     * コンストラクタです。
     */
    private JigyoHokokuTokeiMybatisParameter(FlexibleDate 報告開始年月,
            FlexibleDate 報告終了年月, FlexibleYear 報告年, RString 報告月,
            LasdecCode 市町村コード, Code 表番号, Code 集計番号,
            Code 縦項目コード, Code 横項目コード, boolean is期間,
            boolean isNo期間, boolean isSum, boolean isNoSum,
            List<RString> 市町村コードリスト, RString サブ業務コード,
            RString 処理名, RString 処理枝番, RString 年度,
            RString 基準年月日, RString 基準日時) {
        this.報告開始年月 = 報告開始年月;
        this.報告終了年月 = 報告終了年月;
        this.報告年 = 報告年;
        this.報告月 = 報告月;
        this.市町村コード = 市町村コード;
        this.表番号 = 表番号;
        this.集計番号 = 集計番号;
        this.縦項目コード = 縦項目コード;
        this.横項目コード = 横項目コード;
        this.is期間 = is期間;
        this.isNo期間 = isNo期間;
        this.isSum = isSum;
        this.isNoSum = isNoSum;
        this.市町村コードリスト = 市町村コードリスト;
        this.サブ業務コード = サブ業務コード;
        this.処理名 = 処理名;
        this.処理枝番 = 処理枝番;
        this.年度 = 年度;
        this.基準年月日 = 基準年月日;
        this.基準日時 = 基準日時;
    }

    /**
     * 事業状況報告年報　様式１・２のパラメータを生成します。
     *
     *
     * @param 報告開始年月 報告開始年月
     * @param 報告終了年月 報告終了年月
     * @param 市町村コード 市町村コード
     * @param 表番号 表番号
     * @param 集計番号 集計番号
     * @param 縦番号 縦番号
     * @param 横番号 横番号
     * @param isSum isSum
     * @return JigyoHokokuNenpoIppanGenbutsuMybatisParamter
     */
    public static JigyoHokokuTokeiMybatisParameter createJigyoHokokuTokeiParam(
            FlexibleDate 報告開始年月, FlexibleDate 報告終了年月,
            LasdecCode 市町村コード, Code 表番号, Code 集計番号,
            int 縦番号, int 横番号, boolean isSum) {
        boolean is期間 = false;
        RString 報告月 = null;
        FlexibleYear 報告年 = null;
        if (報告開始年月 != null && 報告終了年月 != null) {
            is期間 = true;
        } else if (報告開始年月 != null) {
            報告月 = new RString(報告開始年月.getMonthValue());
            報告年 = 報告開始年月.getYear();
        } else if (報告終了年月 != null) {
            報告月 = new RString(報告終了年月.getMonthValue());
            報告年 = 報告終了年月.getYear();
        }
        return new JigyoHokokuTokeiMybatisParameter(
                報告開始年月, 報告終了年月, 報告年, 報告月, 市町村コード, 表番号, 集計番号,
                new Code(new RString(縦番号)), new Code(new RString(横番号)),
                is期間, !is期間, isSum, !isSum, null, null, null, null, null, null, null);
    }

    /**
     * 処理日付管理マスタのパラメータを生成します。
     *
     *
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村コードリスト 旧市町村コードリスト
     * @param 市町村コード 市町村コード
     * @param 集計年度 集計年度
     * @param 構成市町村区分 構成市町村区分
     * @param 旧市町村区分 旧市町村区分
     * @param 処理日時 処理日時
     * @param 作成日時 作成日時
     * @param プリントコントロール区分 プリントコントロール区分
     * @return JigyoHokokuNenpoIppanGenbutsuMybatisParamter
     */
    public static JigyoHokokuTokeiMybatisParameter create処理日付管理マスタParamter(
            List<RString> 構成市町村コードリスト,
            List<RString> 旧市町村コードリスト,
            RString 市町村コード,
            RString 集計年度,
            RString 構成市町村区分,
            RString 旧市町村区分,
            RDateTime 処理日時,
            RDateTime 作成日時,
            RString プリントコントロール区分) {
        List<RString> 市町村コードList = new ArrayList<>();
        市町村コードList.add(市町村コード);
        // TODO QA109512未回答ので、以下の実装します
        if (市町村コード区分.equals(構成市町村区分) && 構成市町村コードリスト != null) {
            市町村コードList.addAll(構成市町村コードリスト);
        } else if (市町村コード区分.equals(旧市町村区分) && 旧市町村コードリスト != null) {
            市町村コードList.addAll(旧市町村コードリスト);
        }
        RString 基準年月日 = RString.EMPTY;
        RString 基準日時 = RString.EMPTY;
        if (PrintControlKubun.集計のみ.getコード().equals(プリントコントロール区分)
                || PrintControlKubun.集計後印刷.getコード().equals(プリントコントロール区分)) {
            基準年月日 = 処理日時.getDate().toDateString();
            基準日時 = 処理日時.format西暦(日付_FORMAT.toString());
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(プリントコントロール区分)) {
            基準年月日 = 作成日時.getDate().toDateString();
            基準日時 = 作成日時.format西暦(日付_FORMAT.toString());
        }
        return new JigyoHokokuTokeiMybatisParameter(
                null, null, null, null, null, null, null,
                null, null,
                false, false, false, false,
                市町村コードList, new RString("DBU"), Syorimei.年報報告様式１_２.get名称(),
                new RString("0099"),
                集計年度, 基準年月日, 基準日時);
    }
}
