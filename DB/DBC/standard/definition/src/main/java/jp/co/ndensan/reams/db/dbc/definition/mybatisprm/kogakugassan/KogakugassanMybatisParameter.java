/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassan;

import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_DataSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_SofuTaishogaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenDataSaisoFlag;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算補正済自己負担額情報作成のMybatisパラメータです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth shoriYM;
    private RString saishoriKubun;
    private RString shutsuryokujunId;
    private RString shoriKunbun;
    private RString 出力順;
    private RString データ区分_1;
    private RString データ区分_3;
    private RString 介護合算_送付対象外;
    private RString 国保連データ再送フラグ_再送要;

    /**
     * コンストラクタです。
     *
     * @param shoriYM 処理年月
     * @param saishoriKubun 再処理区分
     * @param shutsuryokujunId 出力順ID
     * @param shoriKunbun 処理区分
     */
    public KogakugassanMybatisParameter(FlexibleYearMonth shoriYM,
            RString saishoriKubun,
            RString shutsuryokujunId,
            RString shoriKunbun) {
        this.shoriYM = shoriYM;
        this.saishoriKubun = saishoriKubun;
        this.shutsuryokujunId = shutsuryokujunId;
        this.shoriKunbun = shoriKunbun;
        this.データ区分_1 = Kaigogassan_DataSakuseiKubun.国保連取込情報.getコード();
        this.データ区分_3 = Kaigogassan_DataSakuseiKubun.計算処理時_全受給者.getコード();
        this.介護合算_送付対象外 = Kaigogassan_SofuTaishogaiKubun.送付対象外.getコード();
        this.国保連データ再送フラグ_再送要 = KokuhorenDataSaisoFlag.再送要.getコード();
    }

}
