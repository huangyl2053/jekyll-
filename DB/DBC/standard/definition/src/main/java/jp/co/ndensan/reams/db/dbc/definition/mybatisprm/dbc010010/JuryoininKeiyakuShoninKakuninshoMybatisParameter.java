/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc010010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護保険受領委任契約承認（不承認）確認書のMybatisParameter
 *
 * @reamsid_L DBC-1910-030 yuanzhenxia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JuryoininKeiyakuShoninKakuninshoMybatisParameter implements IMyBatisParameter {

    private FlexibleDate 契約申請日開始;
    private FlexibleDate 契約申請日終了;
    private FlexibleDate 契約決定日開始;
    private FlexibleDate 契約決定日終了;
    private RString 発行済;
    private RString 改頁出力順;
    private RString 処理年月日;

    /**
     * コンストラクタです。
     *
     * @param 契約申請日開始 契約申請日開始
     * @param 契約申請日終了 契約申請日終了
     * @param 契約決定日開始 契約決定日開始
     * @param 契約決定日終了 契約決定日終了
     * @param 発行済 発行済
     * @param 改頁出力順 改頁出力順
     * @param 処理年月日 処理年月日
     */
    public JuryoininKeiyakuShoninKakuninshoMybatisParameter(FlexibleDate 契約申請日開始, FlexibleDate 契約申請日終了, FlexibleDate 契約決定日開始,
            FlexibleDate 契約決定日終了, RString 発行済, RString 改頁出力順, RDate 処理年月日) {
        this.契約申請日開始 = 契約申請日開始;
        this.契約申請日終了 = 契約申請日終了;
        this.契約決定日開始 = 契約決定日開始;
        this.契約決定日終了 = 契約決定日終了;
        this.発行済 = 発行済;
        this.改頁出力順 = 改頁出力順;
        this.処理年月日 = 処理年月日.toDateString();
    }

}
