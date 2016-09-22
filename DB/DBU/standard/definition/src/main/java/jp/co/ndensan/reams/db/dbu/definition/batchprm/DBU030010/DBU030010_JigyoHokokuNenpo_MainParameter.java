/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030010;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010100.DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030030.DBU030030_JigyoHokokuNenpo_IppanParamter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030040.DBU030040_JigyoHokokuNenpo_IppanGenbutsuParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030070.DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsuParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030100.DBU030100_JigyoHokokuNenpo_HokenkyufuKogakuParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業状況報告資料（年報）作成のパラメータクラスです。
 *
 * @reamsid_L DBU-5600-290 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBU030010_JigyoHokokuNenpo_MainParameter extends BatchParameterBase {

    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
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
    private static final String KAKOSHUKEIKYUSHICHOSONKBN = "kakoShukeiKyuShichosonKbn";
    private static final String SYUTURYOKUKUBUNLIST = "syuturyokuKubunList";

    @BatchParameter(key = PRINTCONTROLKBN, name = "プリントコントロール区分")
    private RString プリントコントロール区分;
    @BatchParameter(key = HOKOKUNENDO, name = "報告年度")
    private RString 報告年度;
    @BatchParameter(key = HOKOKUKAISHIYM, name = "報告開始年月")
    private RString 報告開始年月;
    @BatchParameter(key = HOKOKUSHURYOYM, name = "報告終了年月")
    private RString 報告終了年月;
    @BatchParameter(key = SHUKEINENDO, name = "集計年度")
    private List<RString> 集計年度;
    @BatchParameter(key = SHUKEIKAISHIYM, name = "集計開始年月")
    private List<RString> 集計開始年月;
    @BatchParameter(key = SHUKEISHURYOYM, name = "集計終了年月")
    private List<RString> 集計終了年月;
    @BatchParameter(key = SAKUSEIDATE, name = "作成日時")
    private List<RDateTime> 作成日時;
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
    @BatchParameter(key = KAKOSHUKEIKYUSHICHOSONKBN, name = "過去集計分旧市町村区分")
    private RString 過去集計分旧市町村区分;
    @BatchParameter(key = SYUTURYOKUKUBUNLIST, name = "出力区分リスト")
    private List<RString> 出力区分リスト;

    /**
     * コンストラクタです。
     */
    public DBU030010_JigyoHokokuNenpo_MainParameter() {
    }

    /**
     * 事業状況報告資料（年報）作成　一般状況（１～１１）を生成します。
     *
     * @return 事業状況報告資料（年報）作成　一般状況（１～１１）のパラメータ
     */
    public DBU030030_JigyoHokokuNenpo_IppanParamter toDBU030030Parameter() {
        DBU030030_JigyoHokokuNenpo_IppanParamter parameter = new DBU030030_JigyoHokokuNenpo_IppanParamter();
        parameter.setプリントコントロール区分(プリントコントロール区分);
        parameter.set報告年度(報告年度);
        parameter.set報告開始年月(報告開始年月);
        parameter.set報告終了年月(報告終了年月);
        parameter.set集計年度(集計年度.get(2));
        parameter.set集計開始年月(集計開始年月.get(2));
        parameter.set集計終了年月(集計終了年月.get(2));
        parameter.set作成日時(作成日時.get(2));
        parameter.set処理日時(処理日時);
        parameter.set市町村コード(市町村コード);
        parameter.set構成市町村区分(構成市町村区分);
        parameter.set旧市町村区分(旧市町村区分);
        parameter.set構成市町村コードリスト(構成市町村コードリスト);
        parameter.set旧市町村コードリスト(旧市町村コードリスト);
        parameter.set過去集計分市町村コードリスト(過去集計分市町村コードリスト);
        parameter.set過去集計分旧市町村区分(過去集計分旧市町村区分);
        return parameter;
    }

    /**
     * 事業状況報告資料（年報）作成　一般状況（１２～１４）を生成します。
     *
     * @param 集計年度 集計年度
     * @param 集計開始年月 集計開始年月
     * @param 集計終了年月 集計終了年月
     * @param 作成日時 作成日時
     * @param 給付集計区分 給付集計区分
     * @return 事業状況報告資料（年報）作成　一般状況（１２～１４）のバッチパラメータ
     */
    public DBU030040_JigyoHokokuNenpo_IppanGenbutsuParameter toDBU030040Parameter(RString 集計年度,
            RString 集計開始年月, RString 集計終了年月, RDateTime 作成日時, RString 給付集計区分) {
        DBU030040_JigyoHokokuNenpo_IppanGenbutsuParameter parameter = new DBU030040_JigyoHokokuNenpo_IppanGenbutsuParameter();
        parameter.setプリントコントロール区分(プリントコントロール区分);
        parameter.set報告年度(報告年度);
        parameter.set報告開始年月(報告開始年月);
        parameter.set報告終了年月(報告終了年月);
        parameter.set集計年度(集計年度);
        parameter.set集計開始年月(集計開始年月);
        parameter.set集計終了年月(集計終了年月);
        parameter.set作成日時(作成日時);
        parameter.set処理日時(処理日時);
        parameter.set市町村コード(市町村コード);
        parameter.set構成市町村区分(構成市町村区分);
        parameter.set旧市町村区分(旧市町村区分);
        parameter.set構成市町村コードリスト(構成市町村コードリスト);
        parameter.set旧市町村コードリスト(旧市町村コードリスト);
        parameter.set過去集計分市町村コードリスト(過去集計分市町村コードリスト);
        parameter.set給付集計区分(給付集計区分);
        parameter.set過去集計分旧市町村区分(過去集計分旧市町村区分);
        return parameter;
    }

    /**
     * 事業状況報告資料（年報）作成　保険給付決定状況を生成します。
     *
     * @param 集計年度 集計年度
     * @param 集計開始年月 集計開始年月
     * @param 集計終了年月 集計終了年月
     * @param 作成日時 作成日時
     * @param 給付集計区分 給付集計区分
     * @return 事業状況報告資料（年報）作成　保険給付決定状況のバッチパラメータ
     */
    public DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsuParameter toDBU030070Parameter(RString 集計年度,
            RString 集計開始年月, RString 集計終了年月, RDateTime 作成日時, RString 給付集計区分) {
        DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsuParameter parameter = new DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsuParameter();
        parameter.setプリントコントロール区分(プリントコントロール区分);
        parameter.set報告年度(報告年度);
        parameter.set報告開始年月(報告開始年月);
        parameter.set報告終了年月(報告終了年月);
        parameter.set集計年度(集計年度);
        parameter.set集計開始年月(集計開始年月);
        parameter.set集計終了年月(集計終了年月);
        parameter.set作成日時(作成日時);
        parameter.set処理日時(処理日時);
        parameter.set市町村コード(市町村コード);
        parameter.set構成市町村区分(構成市町村区分);
        parameter.set旧市町村区分(旧市町村区分);
        parameter.set構成市町村コードリスト(構成市町村コードリスト);
        parameter.set旧市町村コードリスト(旧市町村コードリスト);
        parameter.set過去集計分市町村コードリスト(過去集計分市町村コードリスト);
        parameter.set給付集計区分(給付集計区分);
        parameter.set過去集計分旧市町村区分(過去集計分旧市町村区分);
        return parameter;
    }

    /**
     * 事業状況報告資料（年報）作成　保険給付決定状況(高額分)を生成します。
     *
     * @return 事業状況報告資料（年報）作成　保険給付決定状況(高額分)のバッチパラメータ
     */
    public DBU030100_JigyoHokokuNenpo_HokenkyufuKogakuParameter toDBU030100Parameter() {
        DBU030100_JigyoHokokuNenpo_HokenkyufuKogakuParameter parameter = new DBU030100_JigyoHokokuNenpo_HokenkyufuKogakuParameter();
        parameter.setプリントコントロール区分(プリントコントロール区分);
        parameter.set報告年度(報告年度);
        parameter.set報告開始年月(報告開始年月);
        parameter.set報告終了年月(報告終了年月);
        parameter.set集計年度(集計年度.get(INDEX_7));
        parameter.set集計開始年月(集計開始年月.get(INDEX_7));
        parameter.set集計終了年月(集計終了年月.get(INDEX_7));
        parameter.set作成日時(作成日時.get(INDEX_7));
        parameter.set処理日時(処理日時);
        parameter.set市町村コード(市町村コード);
        parameter.set構成市町村区分(構成市町村区分);
        parameter.set旧市町村区分(旧市町村区分);
        parameter.set構成市町村コードリスト(構成市町村コードリスト);
        parameter.set旧市町村コードリスト(旧市町村コードリスト);
        parameter.set過去集計分市町村コードリスト(過去集計分市町村コードリスト);
        parameter.set過去集計分旧市町村区分(過去集計分旧市町村区分);
        return parameter;
    }

    /**
     * 事業状況報告資料月報作成_保険給付決定状況_高額合算分を生成します。
     *
     * @return 事業状況報告資料月報作成_保険給付決定状況_高額合算分のバッチパラメータ
     */
    public DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter toDBU010100Parameter() {
        DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter parameter = new DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter();
        parameter.setプリントコントロール区分(プリントコントロール区分);
        parameter.set報告区分(new RString("2"));
        parameter.set報告年度(報告年度);
        parameter.set集計年度(集計年度.get(INDEX_8));
        parameter.set集計開始年月(集計開始年月.get(INDEX_8));
        parameter.set集計終了年月(集計終了年月.get(INDEX_8));
        parameter.set作成日時(作成日時.get(INDEX_8).getDate().toDateString().concat(getDate(作成日時.get(INDEX_8).getHour())).
                concat(getDate(作成日時.get(INDEX_8).getMinute())).concat(getDate(作成日時.get(INDEX_8).getSecond())));
        parameter.set処理日時(処理日時.getDate().toDateString().concat(getDate(処理日時.getHour())).
                concat(getDate(処理日時.getMinute())).concat(getDate(処理日時.getSecond())));
        parameter.set市町村コード(市町村コード);
        parameter.set構成市町村区分(構成市町村区分);
        parameter.set旧市町村区分(旧市町村区分);
        parameter.set構成市町村コードリスト(構成市町村コードリスト);
        parameter.set旧市町村コードリスト(旧市町村コードリスト);
        parameter.set過去集計分市町村コードリスト(過去集計分市町村コードリスト);
        parameter.set過去集計分旧市町村区分(過去集計分旧市町村区分);
        parameter.setバッチID(new RString("DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassan"));
        return parameter;
    }

    private static RString getDate(int 時間) {
        return new RString(時間).padZeroToLeft(2);
    }
}
