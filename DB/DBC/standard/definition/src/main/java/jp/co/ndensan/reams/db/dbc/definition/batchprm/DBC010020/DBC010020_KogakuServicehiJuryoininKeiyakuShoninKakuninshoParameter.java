/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC010020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehijuryoininkeiyakushoninkakuninsho.KogakuServicehiJuryoininProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成
 *
 * @reamsid_L DBC-1970-010 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninshoParameter extends BatchParameterBase {

    private static final String KEY_契約申請開始 = "契約申請開始";
    private static final String KEY_契約申請終了 = "契約申請終了";
    private static final String KEY_契約決定開始 = "契約決定開始";
    private static final String KEY_契約決定終了 = "契約決定終了";
    private static final String KEY_発行済 = "発行済";
    private static final String KEY_通知日 = "通知日";
    private static final String KEY_文書番号 = "文書番号";
    private static final String KEY_改頁出力順ID = "改頁出力順ID";
    private static final String KEY_市町村コード = "市町村コード";
    private static final String KEY_処理日時 = "処理日時";
    @BatchParameter(key = KEY_契約申請開始, name = "契約申請開始")
    private FlexibleDate 契約申請開始;
    @BatchParameter(key = KEY_契約申請終了, name = "契約申請終了")
    private FlexibleDate 契約申請終了;
    @BatchParameter(key = KEY_契約決定開始, name = "契約決定開始")
    private FlexibleDate 契約決定開始;
    @BatchParameter(key = KEY_契約決定終了, name = "契約決定終了")
    private FlexibleDate 契約決定終了;
    @BatchParameter(key = KEY_発行済, name = "発行済")
    private RString 発行済;
    @BatchParameter(key = KEY_通知日, name = "通知日")
    private FlexibleDate 通知日;
    @BatchParameter(key = KEY_文書番号, name = "文書番号")
    private RString 文書番号;
    @BatchParameter(key = KEY_改頁出力順ID, name = "改頁出力順ID")
    private RString 改頁出力順ID;
    @BatchParameter(key = KEY_市町村コード, name = "市町村コード")
    private LasdecCode 市町村コード;
    @BatchParameter(key = KEY_処理日時, name = "処理日時")
    private RDateTime 処理日時;

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public KogakuServicehiJuryoininProcessParameter toProcessParameter() {
        FlexibleDate 契約申請開始日 = FlexibleDate.MIN;
        FlexibleDate 契約申請終了日 = FlexibleDate.MAX;
        FlexibleDate 契約決定開始日 = FlexibleDate.MIN;
        FlexibleDate 契約決定終了日 = FlexibleDate.MAX;
        if (契約申請開始 != null && !契約申請開始.isEmpty()) {
            契約申請開始日 = 契約申請開始;
        }
        if (契約申請終了 != null && !契約申請終了.isEmpty()) {
            契約申請終了日 = 契約申請終了;
        }
        if (契約決定開始 != null && !契約決定開始.isEmpty()) {
            契約決定開始日 = 契約決定開始;
        }
        if (契約決定終了 != null && !契約決定終了.isEmpty()) {
            契約決定終了日 = 契約決定終了;
        }
        return new KogakuServicehiJuryoininProcessParameter(契約申請開始日, 契約申請終了日, 契約決定開始日, 契約決定終了日,
                発行済, 通知日, 文書番号, 改頁出力順ID, 市町村コード, 処理日時);
    }
}
