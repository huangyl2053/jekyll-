/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC010010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc010010.JuryoininKeiyakuShoninKakuninshoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険受領委任契約承認（不承認）確認書です。
 *
 * @reamsid_L DBC-1910-010 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC010010_JuryoininKeiyakuShoninKakuninshoParameter extends BatchParameterBase {

    @BatchParameter(key = "契約申請日開始", name = "契約申請日開始")
    private FlexibleDate 契約申請日開始;
    @BatchParameter(key = "契約申請日終了", name = "契約申請日終了")
    private FlexibleDate 契約申請日終了;
    @BatchParameter(key = "契約決定日開始", name = "契約決定日開始")
    private FlexibleDate 契約決定日開始;
    @BatchParameter(key = "契約決定日終了", name = "契約決定日終了")
    private FlexibleDate 契約決定日終了;
    @BatchParameter(key = "発行済", name = "発行済")
    private RString 発行済;
    @BatchParameter(key = "通知日", name = "通知日")
    private FlexibleDate 通知日;
    @BatchParameter(key = "文書番号", name = "文書番号")
    private RString 文書番号;
    @BatchParameter(key = "改頁出力順ID", name = "改頁出力順ID")
    private RString 改頁出力順ID;
    @BatchParameter(key = "市町村コード", name = "市町村コード")
    private LasdecCode 市町村コード;
    @BatchParameter(key = "市町村名称", name = "市町村名称")
    private RString 市町村名称;
    @BatchParameter(key = "処理日時", name = "処理日時")
    private RDateTime 処理日時;

    /**
     * 介護保険受領委任契約承認（不承認）確認書のProcessParameterを作成する。
     *
     * @return JuryoininKeiyakuShoninKakuninshoProcessParameter
     */
    public JuryoininKeiyakuShoninKakuninshoProcessParameter toJuryoininKeiyakuShoninKakuninshoProcessParameter() {
        FlexibleDate 契約申請開始日 = FlexibleDate.MIN;
        FlexibleDate 契約申請終了日 = FlexibleDate.MAX;
        FlexibleDate 契約決定開始日 = FlexibleDate.MIN;
        FlexibleDate 契約決定終了日 = FlexibleDate.MAX;
        if (契約申請日開始 != null && !契約申請日開始.isEmpty()) {
            契約申請開始日 = 契約申請日開始;
        }
        if (契約申請日終了 != null && !契約申請日終了.isEmpty()) {
            契約申請終了日 = 契約申請日終了;
        }
        if (契約決定日開始 != null && !契約決定日開始.isEmpty()) {
            契約決定開始日 = 契約決定日開始;
        }
        if (契約決定日終了 != null && !契約決定日終了.isEmpty()) {
            契約決定終了日 = 契約決定日終了;
        }
        return new JuryoininKeiyakuShoninKakuninshoProcessParameter(契約申請開始日, 契約申請終了日, 契約決定開始日, 契約決定終了日, 発行済,
                通知日, 文書番号, 改頁出力順ID, 市町村コード, 市町村名称, 処理日時
        );
    }
}
