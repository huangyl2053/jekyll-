/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150040;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.processprm.heikinriyogakuyokeihyo.HeikinriyogakuTokeihyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 平均利用額統計表作成のBatchParameterです。
 *
 * @reamsid_L DBC-3490-030 yaoyahui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC150040_HeikinriyogakuTokeihyoParameter extends BatchParameterBase {

    private static final String TAISHONENDOYM = "taishoNendoYM";
    private static final String KAISHIYM = "kaishiYM";
    private static final String SHURYOYM = "shuryoYM";
    private static final String CHIKUSHITEI = "chikuShitei";
    private static final String SELECTORCHIKULIST = "selectorChikulist";
    private static final String SHICHOSONCODE = "shichosonCode";
    private static final String SHICHOSONMEI = " shichosonMei";
    private static final String KYUSHICHOSONCODE = "kyuShichosonCode";
    private static final String KYUSHICHOSONMEI = "kyuShichosonMei";
    private static final String DONYUKEITAICODE = "donyuKeitaiCode";
    private static final String ISTAISHONENDOYM = "istaishoNendoYM";
    private static final String ISSHICHOSONKYUSHICHOSONCODE1 = "isshichosonkyuShichosonCode1";
    private static final String ISSHICHOSONKYUSHICHOSONCODE2 = "isshichosonkyuShichosonCode2";
    private static final String ISSHICHOSONKYUSHICHOSONCODE3 = "isshichosonkyuShichosonCode3";
    private static final String ISGYOSEIKU = "isgyoseiku";
    private static final String ISCHOIKI = "ischoiki";
    private static final String ISCHIKU1 = "ischiku1";
    private static final String ISCHIKU2 = "ischiku2";
    private static final String ISCHIKU3 = "ischiku3";
    private static final long serialVersionUID = 1L;
    @BatchParameter(key = TAISHONENDOYM, name = "対象年月")
    private RString taishoNendoYM;
    @BatchParameter(key = KAISHIYM, name = "開始年月")
    private RString kaishiYM;
    @BatchParameter(key = SHURYOYM, name = "終了年月")
    private RString shuryoYM;
    @BatchParameter(key = CHIKUSHITEI, name = "地区指定")
    private RString chikuShitei;
    @BatchParameter(key = SELECTORCHIKULIST, name = "選択地区Map")
    private Map<String, String> selectorChikulist;
    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private RString shichosonCode;
    @BatchParameter(key = SHICHOSONMEI, name = "市町村名称")
    private RString shichosonMei;
    @BatchParameter(key = KYUSHICHOSONCODE, name = "旧市町村コード")
    private RString kyuShichosonCode;
    @BatchParameter(key = KYUSHICHOSONMEI, name = "旧市町村名称")
    private RString kyuShichosonMei;
    @BatchParameter(key = DONYUKEITAICODE, name = "導入形態コード")
    private RString donyuKeitaiCode;
    @BatchParameter(key = ISTAISHONENDOYM, name = "is対象年月")
    private boolean istaishoNendoYM;
    @BatchParameter(key = ISSHICHOSONKYUSHICHOSONCODE1, name = "is旧市町村且市町村1")
    private boolean isshichosonkyuShichosonCode1;
    @BatchParameter(key = ISSHICHOSONKYUSHICHOSONCODE2, name = "is旧市町村且市町村2")
    private boolean isshichosonkyuShichosonCode2;
    @BatchParameter(key = ISSHICHOSONKYUSHICHOSONCODE3, name = "is旧市町村且市町村3")
    private boolean isshichosonkyuShichosonCode3;
    @BatchParameter(key = ISCHOIKI, name = "is町域")
    private boolean ischoiki;
    @BatchParameter(key = ISGYOSEIKU, name = "is行政区")
    private boolean isgyoseiku;
    @BatchParameter(key = ISCHIKU1, name = "is地区1")
    private boolean ischiku1;
    @BatchParameter(key = ISCHIKU2, name = "is地区2")
    private boolean ischiku2;
    @BatchParameter(key = ISCHIKU3, name = "is地区3")
    private boolean ischiku3;

    /**
     * コンストラクタです。
     */
    public DBC150040_HeikinriyogakuTokeihyoParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param taishoNendoYM 対象年月
     * @param kaishiYM 開始年月
     * @param shuryoYM 終了年月
     * @param chikuShitei 地区指定
     * @param 選択地区Map 選択地区Map
     * @param shichosonCode 市町村コード
     * @param shichosonMei 市町村名称
     * @param kyuShichosonCode 旧市町村コード
     * @param kyuShichosonMei 旧市町村名称
     * @param donyuKeitaiCode 導入形態コード
     * @param istaishoNendoYM istaishoNendoYM
     * @param isshichosonkyuShichosonCode1 is旧市町村且市町村1
     * @param isshichosonkyuShichosonCode2 is旧市町村且市町村2
     * @param isshichosonkyuShichosonCode3 is旧市町村且市町村3
     * @param ischoiki is町域
     * @param isgyoseiku is行政区
     * @param ischiku1 is地区1
     * @param ischiku2 is地区2
     * @param ischiku3 is地区3
     */
    public DBC150040_HeikinriyogakuTokeihyoParameter(
            RString taishoNendoYM,
            RString kaishiYM,
            RString shuryoYM,
            RString chikuShitei,
            Map<String, String> 選択地区Map,
            RString shichosonCode,
            RString shichosonMei,
            RString kyuShichosonCode,
            RString kyuShichosonMei,
            RString donyuKeitaiCode,
            boolean istaishoNendoYM,
            boolean isshichosonkyuShichosonCode1,
            boolean isshichosonkyuShichosonCode2,
            boolean isshichosonkyuShichosonCode3,
            boolean ischoiki,
            boolean isgyoseiku,
            boolean ischiku1,
            boolean ischiku2,
            boolean ischiku3
    ) {
        this.taishoNendoYM = taishoNendoYM;
        this.kaishiYM = kaishiYM;
        this.shuryoYM = shuryoYM;
        this.chikuShitei = chikuShitei;
        this.selectorChikulist = 選択地区Map;
        this.shichosonCode = shichosonCode;
        this.shichosonMei = shichosonMei;
        this.kyuShichosonCode = kyuShichosonCode;
        this.kyuShichosonMei = kyuShichosonMei;
        this.donyuKeitaiCode = donyuKeitaiCode;
        this.istaishoNendoYM = istaishoNendoYM;
        this.isshichosonkyuShichosonCode1 = isshichosonkyuShichosonCode1;
        this.isshichosonkyuShichosonCode2 = isshichosonkyuShichosonCode2;
        this.isshichosonkyuShichosonCode3 = isshichosonkyuShichosonCode3;
        this.ischoiki = ischoiki;
        this.isgyoseiku = isgyoseiku;
        this.ischiku1 = ischiku1;
        this.ischiku2 = ischiku2;
        this.ischiku3 = ischiku3;

    }

    /**
     * 平均利用額統計表作成processのパラメータを作成します。
     *
     * @return HeikinriyogakuTokeihyoProcessParameter
     */
    public HeikinriyogakuTokeihyoProcessParameter toHeikinriyogakuTokeihyoProcessParameter() {
        return new HeikinriyogakuTokeihyoProcessParameter(
                taishoNendoYM,
                kaishiYM,
                shuryoYM,
                chikuShitei,
                setselectorChikulist(),
                shichosonCode,
                shichosonMei,
                kyuShichosonCode,
                kyuShichosonMei,
                donyuKeitaiCode,
                istaishoNendoYM,
                isshichosonkyuShichosonCode1,
                isshichosonkyuShichosonCode2,
                isshichosonkyuShichosonCode3,
                ischoiki,
                isgyoseiku,
                ischiku1,
                ischiku2,
                ischiku3
        );
    }

    private List<RString> setselectorChikulist() {
        List<RString> chikulist = new ArrayList<>();
        if (0 < selectorChikulist.size()) {
            for (String 選択結果 : selectorChikulist.keySet()) {
                chikulist.add(new RString(選択結果));
            }
        }
        return chikulist;
    }
}
