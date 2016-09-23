/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010010;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業状況報告資料（月報）作成のパラメータクラスです
 *
 * @reamsid_L DBU-5530-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBU010010_JigyoHokokuGeppo_MainParameter extends BatchParameterBase {

    private static final String PRINTCONTROLKBN = "printControlKbn";
    private static final String SHUUKEI_NENGETU = "shuukeiNengetu";
    private static final String HOUKOKU_NENGETU = "houkokuNengetu";
    private static final String NENDO = "nendo";
    private static final String SAKUSEI_NITIZI = "sakuseiNitizi";
    private static final String SYORI_NITIZI = "syoriNitizi";
    private static final String OLD_SHICHOSON_KUBUN = "oldShichosonKubun";
    private static final String KOUSEI_SHICHOSON_KUBUN = "kouseiShichosonKubun";
    private static final String SHICHOSON_CODE = "shichosonCode";
    private static final String KOUSEI_SHICHOSON_CODE = "kouseiShichosonCode";
    private static final String OLD_SHICHOSON_CODE = "oldShichosonCode";
    private static final String SHUUKEIBUN_SHICHOSON_CODE = "shuukeibunShichosonCode";
    private static final String SHUUKEIBUN_SHICHOSON_KUBUN = "shuukeibunShichosonKubun";
    private static final String CSVID = "csvID";
    private static final String BATCHID = "batchID";
    private static final String KYUUFU_SHUUKEI_KUBUN = "kyuufuShuukeiKubunn";
    private static final String HOKOKU_KUBUN = "hokokuKubun";
    private static final String KAISHI_YM = "kaishiYm";
    private static final String SHURYO_YM = "shusyoYm";
    private static final String KETTEI_YM = "ketteiYm";
    private static final String HOKOKU_NENDO = "hokokuNendo";
    private static final String SHUKEI_NENDO = "shukeiNendo";
    private static final String SYUTYORYOKU_KUBUN = "syutyoryokuKubun";

    @BatchParameter(key = PRINTCONTROLKBN, name = "プリントコントロール区分")
    private RString printControlKbn;
    @BatchParameter(key = SHUUKEI_NENGETU, name = "集計年月")
    private List<RString> shuukeiNengetu;
    @BatchParameter(key = HOUKOKU_NENGETU, name = "報告年月")
    private RString houkokuNengetu;
    @BatchParameter(key = NENDO, name = "年度")
    private List<RString> nendo;
    @BatchParameter(key = SAKUSEI_NITIZI, name = "作成日時")
    private List<RDateTime> sakuseiNitizi;
    @BatchParameter(key = SYORI_NITIZI, name = "処理日時")
    private RDateTime syoriNitizi;
    @BatchParameter(key = OLD_SHICHOSON_KUBUN, name = "旧市町村区分")
    private RString oldShichosonKubun;
    @BatchParameter(key = KOUSEI_SHICHOSON_KUBUN, name = "構成市町村区分")
    private RString kouseiShichosonKubun;
    @BatchParameter(key = SHICHOSON_CODE, name = "市町村コード")
    private LasdecCode shichosonCode;
    @BatchParameter(key = KOUSEI_SHICHOSON_CODE, name = "構成市町村コードList")
    private List<LasdecCode> kouseiShichosonCode;
    @BatchParameter(key = OLD_SHICHOSON_CODE, name = "旧市町村コードList")
    private List<LasdecCode> oldShichosonCode;
    @BatchParameter(key = SHUUKEIBUN_SHICHOSON_CODE, name = "過去集計分市町村コードList")
    private List<RString> shuukeibunShichosonCode;
    @BatchParameter(key = SHUUKEIBUN_SHICHOSON_KUBUN, name = "過去集計分旧市町村区分")
    private RString shuukeibunShichosonKubun;
    @BatchParameter(key = CSVID, name = "作成CSVファイルID")
    private List<RString> csvID;
    @BatchParameter(key = BATCHID, name = "バッチID")
    private List<RString> batchID;
    @BatchParameter(key = KYUUFU_SHUUKEI_KUBUN, name = "給付集計区分")
    private List<RString> kyuufuShuukeiKubunn;
    @BatchParameter(key = HOKOKU_KUBUN, name = "報告区分")
    private RString hokokuKubun;
    @BatchParameter(key = KAISHI_YM, name = "集計開始年月")
    private RString kaishiYm;
    @BatchParameter(key = SHURYO_YM, name = "集計終了年月")
    private RString shusyoYm;
    @BatchParameter(key = KETTEI_YM, name = "決定年月")
    private List<RString> ketteiYm;
    @BatchParameter(key = HOKOKU_NENDO, name = "報告年度")
    private RString hokokuNendo;
    @BatchParameter(key = SHUKEI_NENDO, name = "集計年度")
    private RString shukeiNendo;
    @BatchParameter(key = SYUTYORYOKU_KUBUN, name = "プリントコントロール区分")
    private List<RString> syutyoryokuKubun;

    /**
     * コンストラクタです。
     */
    public DBU010010_JigyoHokokuGeppo_MainParameter() {
    }
}
