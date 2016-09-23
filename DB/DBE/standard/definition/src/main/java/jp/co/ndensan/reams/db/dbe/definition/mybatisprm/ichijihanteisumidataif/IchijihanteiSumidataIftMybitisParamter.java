/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteisumidataif;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 一次判定データ出力MybitisParamterです。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class IchijihanteiSumidataIftMybitisParamter implements IMyBatisParameter {

    private final List<RString> shinseishoKanriNoList;
    private final RString 日付指定;
    private final RString 申請日From;
    private final RString 申請日To;
    private final RString 一次判定日From;
    private final RString 一次判定日To;
    private final boolean 仮一次判定区分;
    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();
    private final boolean 一次判定日フラグ;
    private final boolean 申請日フラグ;

    private IchijihanteiSumidataIftMybitisParamter(
            List<RString> shinseishoKanriNoList,
            RString 日付指定,
            RString 申請日From,
            RString 申請日To,
            RString 一次判定日From,
            RString 一次判定日To,
            boolean 仮一次判定区分,
            boolean 一次判定日フラグ,
            boolean 申請日フラグ) {
        this.shinseishoKanriNoList = shinseishoKanriNoList;
        this.日付指定 = 日付指定;
        this.申請日From = 申請日From;
        this.申請日To = 申請日To;
        this.一次判定日From = 一次判定日From;
        this.一次判定日To = 一次判定日To;
        this.仮一次判定区分 = 仮一次判定区分;
        this.一次判定日フラグ = 一次判定日フラグ;
        this.申請日フラグ = 申請日フラグ;

    }

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNoList List<RString>
     * @param 日付指定 RString
     * @param 申請日From RString
     * @param 申請日To RString
     * @param 一次判定日From RString
     * @param 一次判定日To RString
     * @param 仮一次判定区分 RString
     * @return IchijiHanteizumIfOutputMybitisParamter
     */
    public static IchijihanteiSumidataIftMybitisParamter createParam(
            List<RString> shinseishoKanriNoList,
            RString 日付指定,
            RString 申請日From,
            RString 申請日To,
            RString 一次判定日From,
            RString 一次判定日To,
            boolean 仮一次判定区分) {
        boolean 一次判定日フラグ = false;
        boolean 申請日フラグ = false;
        if (new RString("0").equals(日付指定)) {
            申請日フラグ = true;
        }
        if (new RString("1").equals(日付指定)) {
            一次判定日フラグ = true;
        }

        return new IchijihanteiSumidataIftMybitisParamter(shinseishoKanriNoList,
                日付指定,
                申請日From,
                申請日To,
                一次判定日From,
                一次判定日To,
                仮一次判定区分,
                一次判定日フラグ,
                申請日フラグ);
    }
}
