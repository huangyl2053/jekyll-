/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.nenreikaikyuriyojokyo;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.nenreikaikyuriyojokyo.NenreikaikyuRiyojokyoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 年齢階級別利用状況作成Process用パラメータクラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NenreikaikyuRiyojokyoProcessParameter implements IBatchProcessParameter {

    private final FlexibleDate serviceTeikyoYM;
    private final FlexibleDate sinsaYM;
    private final FlexibleDate nenreiSansyutuKijyubi;
    private final RString sentakuTaisyoKubun;
    private final Map<RString, RString> sentakuTaisyoList;
    private final Code shichosonCode;
    private final RString shichosonMeisho;
    private final Code kyoShichosonCode;
    private final RString kyoShichosonMeisho;

    /**
     * コンストラクタです。
     *
     * @param serviceTeikyoYM サービス提供年月
     * @param sinsaYM 審査年月
     * @param nenreiSansyutuKijyubi 年齢算出基準日
     * @param sentakuTaisyoKubun 選択対象区分
     * @param sentakuTaisyoList 選択対象リスト
     * @param shichosonCode 市町村コード
     * @param shichosonMeisho 市町村名称
     * @param kyoShichosonCode 旧市町村コード
     * @param kyoShichosonMeisho 旧市町村名称
     */
    public NenreikaikyuRiyojokyoProcessParameter(FlexibleDate serviceTeikyoYM,
            FlexibleDate sinsaYM,
            FlexibleDate nenreiSansyutuKijyubi,
            RString sentakuTaisyoKubun,
            Map<RString, RString> sentakuTaisyoList,
            Code shichosonCode,
            RString shichosonMeisho,
            Code kyoShichosonCode,
            RString kyoShichosonMeisho) {
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.sinsaYM = sinsaYM;
        this.nenreiSansyutuKijyubi = nenreiSansyutuKijyubi;
        this.sentakuTaisyoKubun = sentakuTaisyoKubun;
        this.sentakuTaisyoList = sentakuTaisyoList;
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.kyoShichosonCode = kyoShichosonCode;
        this.kyoShichosonMeisho = kyoShichosonMeisho;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return NenreikaikyuRiyojokyoMybatisParameter
     */
    public NenreikaikyuRiyojokyoMybatisParameter toNenreikaikyuRiyojokyoMybatisParameter() {
        return NenreikaikyuRiyojokyoMybatisParameter.createParam(serviceTeikyoYM,
                sinsaYM,
                nenreiSansyutuKijyubi,
                sentakuTaisyoKubun,
                sentakuTaisyoList,
                shichosonCode,
                shichosonMeisho,
                kyoShichosonCode,
                kyoShichosonMeisho);
    }

}
