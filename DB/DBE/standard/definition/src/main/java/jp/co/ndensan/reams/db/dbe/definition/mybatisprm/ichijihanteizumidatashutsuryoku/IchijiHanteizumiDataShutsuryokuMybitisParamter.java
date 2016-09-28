/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteizumidatashutsuryoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 一次判定データ出力MybitisParamterです。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class IchijiHanteizumiDataShutsuryokuMybitisParamter {

    private final boolean 一次判定日フラグ;
    private final boolean 申請日フラグ;
    private final RString 日付指定;
    private final RString 申請日From;
    private final RString 申請日To;
    private final RString 一次判定日From;
    private final RString 一次判定日To;
    private final RString 総合事業開始区分;
    private final boolean usesSaidaiHyojiKensu;
    private final Decimal saidaiHyojiKensu;
    private final List<RString> shinseishoKanriNoList;
    private final boolean 仮一次判定区分;
    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();

    private IchijiHanteizumiDataShutsuryokuMybitisParamter(boolean 一次判定日フラグ,
            boolean 申請日フラグ,
            RString 日付指定,
            RString 申請日From,
            RString 申請日To,
            RString 一次判定日From,
            RString 一次判定日To,
            boolean usesSaidaiHyojiKensu,
            Decimal saidaiHyojiKensu,
            RString 総合事業開始区分,
            List<RString> shinseishoKanriNoLis,
            boolean 仮一次判定区分) {
        this.申請日フラグ = 申請日フラグ;
        this.一次判定日フラグ = 一次判定日フラグ;
        this.日付指定 = 日付指定;
        this.申請日From = 申請日From;
        this.申請日To = 申請日To;
        this.一次判定日From = 一次判定日From;
        this.一次判定日To = 一次判定日To;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.総合事業開始区分 = 総合事業開始区分;
        this.shinseishoKanriNoList = shinseishoKanriNoLis;
        this.仮一次判定区分 = 仮一次判定区分;
    }

    /**
     * コンストラクタ作成
     *
     * @param 日付指定 RString
     * @param 申請日From RString
     * @param 申請日To RString
     * @param 一次判定日From RString
     * @param 一次判定日To RString
     * @param saidaiHyojiKensu RString
     * @param 総合事業開始区分 RString
     * @param shinseishoKanriNoList List<RString>
     * @param 仮一次判定区分 boolean
     * @return NinteiChosaHoshuJissekiJohoMybatisParameter NinteiChosaHoshuJissekiJohoMybatisParameter
     */
    public static IchijiHanteizumiDataShutsuryokuMybitisParamter createParam(
            RString 日付指定,
            RString 申請日From,
            RString 申請日To,
            RString 一次判定日From,
            RString 一次判定日To,
            Decimal saidaiHyojiKensu,
            RString 総合事業開始区分,
            List<RString> shinseishoKanriNoList,
            boolean 仮一次判定区分
    ) {
        boolean 一次判定日フラグ = false;
        boolean 申請日フラグ = false;
        boolean usesSaidaiHyojiKensu = false;
        if (new RString("1").equals(日付指定)) {
            一次判定日フラグ = true;
        }
        if (new RString("0").equals(日付指定)) {
            申請日フラグ = true;
        }
        if (saidaiHyojiKensu != null) {
            usesSaidaiHyojiKensu = true;
        }
        return new IchijiHanteizumiDataShutsuryokuMybitisParamter(
                一次判定日フラグ,
                申請日フラグ,
                日付指定,
                申請日From,
                申請日To,
                一次判定日From,
                一次判定日To,
                usesSaidaiHyojiKensu,
                saidaiHyojiKensu,
                総合事業開始区分,
                shinseishoKanriNoList,
                仮一次判定区分);
    }
}
