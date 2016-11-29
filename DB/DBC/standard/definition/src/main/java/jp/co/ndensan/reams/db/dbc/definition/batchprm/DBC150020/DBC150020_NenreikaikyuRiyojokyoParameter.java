/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150020;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.processprm.nenreikaikyuriyojokyo.NenreikaikyuRiyojokyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 年齢階級別利用状況作成バッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBC150020_NenreikaikyuRiyojokyoParameter extends BatchParameterBase {

    private static final String SERVICETEIKYOYM = "serviceTeikyoYM";
    private static final String SHINSAYM = "sinsaYM";
    private static final String NENREISANSYUTUKIJUBI = "nenreiSansyutuKijyubi";
    private static final String SENTAKUTEISYOKUBUN = "sentakuTaisyoKubun";
    private static final String SENTAKUTAISYOMAP = "sentakuTaisyoMap";
    private static final String SHICHOSONCODE = "shichosonCode";
    private static final String SHICHOSONMEISHO = "shichosonMeisho";
    private static final String KYOSHICHOSONCODE = "kyoShichosonCode";
    private static final String KYOSHICHOSONMEISHO = "kyoShichosonMeisho";

    @BatchParameter(key = SERVICETEIKYOYM, name = "サービス提供年月")
    private FlexibleDate serviceTeikyoYM;
    @BatchParameter(key = SHINSAYM, name = "審査年月")
    private FlexibleDate sinsaYM;
    @BatchParameter(key = NENREISANSYUTUKIJUBI, name = "年齢算出基準日")
    private FlexibleDate nenreiSansyutuKijyubi;
    @BatchParameter(key = SENTAKUTEISYOKUBUN, name = "選択対象区分")
    private RString sentakuTaisyoKubun;
    @BatchParameter(key = SENTAKUTAISYOMAP, name = "選択対象リスト")
    private Map<RString, RString> sentakuTaisyoMap;
    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private Code shichosonCode;
    @BatchParameter(key = SHICHOSONMEISHO, name = "市町村名称")
    private RString shichosonMeisho;
    @BatchParameter(key = KYOSHICHOSONCODE, name = "旧市町村コード")
    private Code kyoShichosonCode;
    @BatchParameter(key = KYOSHICHOSONMEISHO, name = "旧市町村名称")
    private RString kyoShichosonMeisho;

    /**
     * コンストラクタです。
     */
    public DBC150020_NenreikaikyuRiyojokyoParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param serviceTeikyoYM サービス提供年月
     * @param sinsaYM 審査年月
     * @param nenreiSansyutuKijyubi 年齢算出基準日
     * @param sentakuTaisyoKubun 選択対象区分
     * @param sentakuTaisyoMap 選択対象リスト
     * @param shichosonCode 市町村コード
     * @param shichosonMeisho 市町村名称
     * @param kyoShichosonCode 旧市町村コード
     * @param kyoShichosonMeisho 旧市町村名称
     */
    public DBC150020_NenreikaikyuRiyojokyoParameter(FlexibleDate serviceTeikyoYM,
            FlexibleDate sinsaYM,
            FlexibleDate nenreiSansyutuKijyubi,
            RString sentakuTaisyoKubun,
            Map<RString, RString> sentakuTaisyoMap,
            Code shichosonCode,
            RString shichosonMeisho,
            Code kyoShichosonCode,
            RString kyoShichosonMeisho) {
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.sinsaYM = sinsaYM;
        this.nenreiSansyutuKijyubi = nenreiSansyutuKijyubi;
        this.sentakuTaisyoKubun = sentakuTaisyoKubun;
        this.sentakuTaisyoMap = sentakuTaisyoMap;
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.kyoShichosonCode = kyoShichosonCode;
        this.kyoShichosonMeisho = kyoShichosonMeisho;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return NenreikaikyuRiyojokyoProcessParameter
     */
    public NenreikaikyuRiyojokyoProcessParameter toNenreikaikyuRiyojokyoProcessParameter() {
        return new NenreikaikyuRiyojokyoProcessParameter(serviceTeikyoYM,
                sinsaYM,
                nenreiSansyutuKijyubi,
                sentakuTaisyoKubun,
                setselectorChikulist(),
                shichosonCode,
                shichosonMeisho,
                kyoShichosonCode,
                kyoShichosonMeisho);
    }

    private List<RString> setselectorChikulist() {
        List<RString> selectorChikulist = new ArrayList<>();
        if (0 < sentakuTaisyoMap.size()) {
            for (RString 選択結果 : sentakuTaisyoMap.keySet()) {
                selectorChikulist.add(選択結果);
            }
        }
        return selectorChikulist;
    }
}
