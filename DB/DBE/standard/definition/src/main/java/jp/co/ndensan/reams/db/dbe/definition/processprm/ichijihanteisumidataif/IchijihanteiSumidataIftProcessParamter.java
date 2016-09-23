/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ichijihanteisumidataif;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteisumidataif.IchijihanteiSumidataIftMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 一次判定データ出力ProcessParamterです。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class IchijihanteiSumidataIftProcessParamter implements IBatchProcessParameter {

    private final List<RString> shinseishoKanriNoList;
    private final RString 日付指定;
    private final RString 申請日From;
    private final RString 申請日To;
    private final RString 一次判定日From;
    private final RString 一次判定日To;
    private boolean 仮一次判定区分;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト List<RString>
     * @param 日付指定 RString
     * @param 申請日From RString
     * @param 申請日To RString
     * @param 一次判定日From RString
     * @param 一次判定日To RString
     */
    public IchijihanteiSumidataIftProcessParamter(
            List<RString> 申請書管理番号リスト,
            RString 日付指定,
            RString 申請日From,
            RString 申請日To,
            RString 一次判定日From,
            RString 一次判定日To) {
        this.shinseishoKanriNoList = 申請書管理番号リスト;
        this.日付指定 = 日付指定;
        this.申請日From = 申請日From;
        this.申請日To = 申請日To;
        this.一次判定日From = 一次判定日From;
        this.一次判定日To = 一次判定日To;

    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return IchijihanteiSumidataIftMybitisParamter
     */
    public IchijihanteiSumidataIftMybitisParamter toIchijihanteiSumidataIftMybitisParamter() {
        return IchijihanteiSumidataIftMybitisParamter.createParam(shinseishoKanriNoList,
                日付指定,
                申請日From,
                申請日To,
                一次判定日From,
                一次判定日To,
                仮一次判定区分);
    }

}
