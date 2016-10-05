/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030070;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpohokenkyufugenbutsu.JigyoHokokuNenpoHokenkyufuGenbutsuProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業状況報告資料（年報）作成　保険給付決定状況のバッチパラメータクラスです。
 *
 * @reamsid_L DBU-5600-050 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsuParameter extends BatchParameterBase {

    private static final String PRINTCONTROLKBN = "printControlKbn";
    private static final String HOKOKUNENDO = "hokokuNendo";
    private static final String HOKOKUKAISHIYM = "hokokuKaishiYm";
    private static final String HOKOKUSHURYOYM = "hokokuShuryoYm";
    private static final String SHUKEINENDO = "shukeiNendo";
    private static final String SHUKEIKAISHIYM = "shukeiKaishiYm";
    private static final String SHUKEISHURYOYM = "shukeiShuryoYm";
    private static final String SAKUSEIDATE = "sakuseiDate";
    private static final String SHORIDATE = "shoriDate";
    private static final String SHICHOSONCODE = "shichosonCode";
    private static final String KOSEISHICHOSONKBN = "koseiShichosonKbn";
    private static final String KYUSHICHOSONKBN = "kyuShichosonKbn";
    private static final String KOSEISHICHOSONLIST = "koseiShichosonList";
    private static final String KYUSHICHOSONLIST = "kyuShichosonList";
    private static final String KAKOSHUKEISHICHOSONLIST = "kakoShukeiShichosonList";
    private static final String KYUFUSYUKEYIKUBUN = "kyufuSyukeyiKubun";
    private static final String KAKOSHUKEIKYUSHICHOSONKBN = "kakoShukeiKyuShichosonKbn";

    @BatchParameter(key = PRINTCONTROLKBN, name = "プリントコントロール区分")
    private RString プリントコントロール区分;
    @BatchParameter(key = HOKOKUNENDO, name = "報告年度")
    private RString 報告年度;
    @BatchParameter(key = HOKOKUKAISHIYM, name = "報告開始年月")
    private RString 報告開始年月;
    @BatchParameter(key = HOKOKUSHURYOYM, name = "報告終了年月")
    private RString 報告終了年月;
    @BatchParameter(key = SHUKEINENDO, name = "集計年度")
    private RString 集計年度;
    @BatchParameter(key = SHUKEIKAISHIYM, name = "集計開始年月")
    private RString 集計開始年月;
    @BatchParameter(key = SHUKEISHURYOYM, name = "集計終了年月")
    private RString 集計終了年月;
    @BatchParameter(key = SAKUSEIDATE, name = "作成日時")
    private RDateTime 作成日時;
    @BatchParameter(key = SHORIDATE, name = "処理日時")
    private RDateTime 処理日時;
    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private RString 市町村コード;
    @BatchParameter(key = KOSEISHICHOSONKBN, name = "構成市町村区分")
    private RString 構成市町村区分;
    @BatchParameter(key = KYUSHICHOSONKBN, name = "旧市町村区分")
    private RString 旧市町村区分;
    @BatchParameter(key = KOSEISHICHOSONLIST, name = "構成市町村コードリスト")
    private List<RString> 構成市町村コードリスト;
    @BatchParameter(key = KYUSHICHOSONLIST, name = "旧市町村コードリスト")
    private List<RString> 旧市町村コードリスト;
    @BatchParameter(key = KAKOSHUKEISHICHOSONLIST, name = "過去集計分市町村コードリスト")
    private List<RString> 過去集計分市町村コードリスト;
    @BatchParameter(key = KYUFUSYUKEYIKUBUN, name = "給付集計区分")
    private RString 給付集計区分;
    @BatchParameter(key = KAKOSHUKEIKYUSHICHOSONKBN, name = "過去集計分旧市町村区分")
    private RString 過去集計分旧市町村区分;

    /**
     * Process用のパラメータを生成します。
     *
     * @return JigyoHokokuNenpoHokenkyufuGenbutsuProcessParamter
     */
    public JigyoHokokuNenpoHokenkyufuGenbutsuProcessParamter toProcessParamter() {
        return new JigyoHokokuNenpoHokenkyufuGenbutsuProcessParamter(
                プリントコントロール区分,
                報告年度,
                報告開始年月,
                報告終了年月,
                集計年度,
                集計開始年月,
                集計終了年月,
                作成日時,
                処理日時,
                市町村コード,
                構成市町村区分,
                旧市町村区分,
                構成市町村コードリスト,
                旧市町村コードリスト,
                過去集計分市町村コードリスト,
                給付集計区分,
                過去集計分旧市町村区分);
    }
}
