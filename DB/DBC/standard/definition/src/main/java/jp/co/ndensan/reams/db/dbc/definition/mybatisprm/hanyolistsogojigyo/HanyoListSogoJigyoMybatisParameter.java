/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistsogojigyo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(総合事業費情報)MybatisParameterです。
 *
 * @reamsid_L DBC-3107-020 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HanyoListSogoJigyoMybatisParameter implements IMyBatisParameter {

    private static final RString 基本明細情報 = new RString("基本情報+明細情報");
    private static final RString 基本集計情報 = new RString("基本情報+集計情報");
    private static final RString 基本ケアマネジメント情報 = new RString("基本情報+ケアマネジメント費情報");
    private static final RString 保険者コード_すべて = new RString("すべて");
    private final long 出力順ID;
    private final RString 出力順項目ID;
    private final boolean is項目名付加;
    private final boolean is連番付加;
    private final boolean is日付スラッシュ付加;
    private final RString 事業者コード;
    private final boolean 事業者コードFlag;
    private final RString サービス種類コード;
    private final boolean サービス種類コードFlag;
    private final RString 保険者コード;
    private final boolean 保険者コードFlag;
    private final RString 抽出方法;
    private final boolean is基本情報明細情報;
    private final boolean is基本情報集計情報;
    private final boolean is基本情報ケアマネジメント費情報;
    private final RString サービス提供年月開始年月;
    private final boolean サービス開始年月Flag;
    private final RString サービス提供年月終了年月;
    private final boolean サービス終了年月Flag;
    private final RString 審査年月開始年月;
    private final boolean 審査年月開始年月Flag;
    private final RString 審査年月終了年月;
    private final boolean 審査年月終了年月Flag;
    private final RString 取込年月開始年月;
    private final boolean 取込年月開始年月Flag;
    private final RString 取込年月終了年月;
    private final boolean 取込年月終了年月Flag;
    private final RString psmShikibetsuTaisho;
    private final RString 出力順;

    private HanyoListSogoJigyoMybatisParameter(long 出力順ID,
            RString 出力順項目ID,
            boolean is項目名付加,
            boolean is連番付加,
            boolean is日付スラッシュ付加,
            boolean 事業者コードFlag,
            RString 事業者コード,
            boolean サービス種類コードFlag,
            RString サービス種類コード,
            boolean 保険者コードFlag,
            RString 保険者コード,
            RString 抽出方法,
            boolean is基本情報明細情報,
            boolean is基本情報集計情報,
            boolean is基本情報ケアマネジメント費情報,
            boolean サービス開始年月Flag,
            RString サービス提供年月開始年月,
            boolean サービス終了年月Flag,
            RString サービス提供年月終了年月,
            boolean 審査年月開始年月Flag,
            RString 審査年月開始年月,
            boolean 審査年月終了年月Flag,
            RString 審査年月終了年月,
            boolean 取込年月開始年月Flag,
            RString 取込年月開始年月,
            boolean 取込年月終了年月Flag,
            RString 取込年月終了年月,
            RString psmShikibetsuTaisho,
            RString 出力順) {
        this.出力順ID = 出力順ID;
        this.出力順項目ID = 出力順項目ID;
        this.is項目名付加 = is項目名付加;
        this.is連番付加 = is連番付加;
        this.is日付スラッシュ付加 = is日付スラッシュ付加;
        this.事業者コードFlag = 事業者コードFlag;
        this.事業者コード = 事業者コード;
        this.サービス種類コードFlag = サービス種類コードFlag;
        this.サービス種類コード = サービス種類コード;
        this.保険者コードFlag = 保険者コードFlag;
        this.保険者コード = 保険者コード;
        this.抽出方法 = 抽出方法;
        this.is基本情報明細情報 = is基本情報明細情報;
        this.is基本情報集計情報 = is基本情報集計情報;
        this.is基本情報ケアマネジメント費情報 = is基本情報ケアマネジメント費情報;
        this.サービス開始年月Flag = サービス開始年月Flag;
        this.サービス提供年月開始年月 = サービス提供年月開始年月;
        this.サービス終了年月Flag = サービス終了年月Flag;
        this.サービス提供年月終了年月 = サービス提供年月終了年月;
        this.審査年月開始年月Flag = 審査年月開始年月Flag;
        this.審査年月開始年月 = 審査年月開始年月;
        this.審査年月終了年月Flag = 審査年月終了年月Flag;
        this.審査年月終了年月 = 審査年月終了年月;
        this.取込年月開始年月Flag = 取込年月開始年月Flag;
        this.取込年月開始年月 = 取込年月開始年月;
        this.取込年月終了年月Flag = 取込年月終了年月Flag;
        this.取込年月終了年月 = 取込年月終了年月;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.出力順 = 出力順;
    }

    /**
     * 汎用リスト出力(総合事業費情報)の取得のパラメータを作成します。
     *
     * @param 出力順ID long
     * @param 出力順項目ID RString
     * @param is項目名付加 boolean
     * @param is連番付加 boolean
     * @param is日付スラッシュ付加 boolean
     * @param 事業者コード RString
     * @param サービス種類コード RString
     * @param 保険者コード RString
     * @param 抽出方法 RString
     * @param サービス提供年月開始年月 RString
     * @param サービス提供年月終了年月 RString
     * @param 審査年月開始年月 RString
     * @param 審査年月終了年月 RString
     * @param 取込年月開始年月 RString
     * @param 取込年月終了年月 RString
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 出力順 出力順
     * @return 審査会委員実績データの取得パラメータ
     */
    public static HanyoListSogoJigyoMybatisParameter createMybatisParameter(long 出力順ID,
            RString 出力順項目ID,
            boolean is項目名付加,
            boolean is連番付加,
            boolean is日付スラッシュ付加,
            RString 事業者コード,
            RString サービス種類コード,
            RString 保険者コード,
            RString 抽出方法,
            RString サービス提供年月開始年月,
            RString サービス提供年月終了年月,
            RString 審査年月開始年月,
            RString 審査年月終了年月,
            RString 取込年月開始年月,
            RString 取込年月終了年月,
            RString psmShikibetsuTaisho,
            RString 出力順) {
        boolean is基本情報明細情報 = false;
        boolean is基本情報集計情報 = false;
        boolean is基本情報ケアマネジメント費情報 = false;
        boolean 保険者コードFlag = false;
        if (基本明細情報.equals(抽出方法)) {
            is基本情報明細情報 = true;
        } else if (基本集計情報.equals(抽出方法)) {
            is基本情報集計情報 = true;
        } else if (基本ケアマネジメント情報.equals(抽出方法)) {
            is基本情報ケアマネジメント費情報 = true;
        }
        if (!保険者コード_すべて.equals(保険者コード) && !保険者コード.isEmpty()) {
            保険者コードFlag = true;
        }
        return new HanyoListSogoJigyoMybatisParameter(出力順ID,
                出力順項目ID,
                is項目名付加,
                is連番付加,
                is日付スラッシュ付加,
                !isnull(事業者コード),
                事業者コード,
                !isnull(サービス種類コード),
                サービス種類コード,
                保険者コードFlag,
                保険者コード,
                抽出方法,
                is基本情報明細情報,
                is基本情報集計情報,
                is基本情報ケアマネジメント費情報,
                !isnull(サービス提供年月開始年月),
                サービス提供年月開始年月,
                !isnull(サービス提供年月終了年月),
                サービス提供年月終了年月,
                !isnull(審査年月開始年月),
                審査年月開始年月,
                !isnull(審査年月終了年月),
                審査年月終了年月,
                !isnull(取込年月開始年月),
                取込年月開始年月,
                !isnull(取込年月終了年月),
                取込年月終了年月,
                psmShikibetsuTaisho,
                出力順
        );
    }

    private static boolean isnull(RString value) {
        boolean flag = false;
        if (RString.isNullOrEmpty(value)) {
            flag = true;
        }
        return flag;
    }
}
