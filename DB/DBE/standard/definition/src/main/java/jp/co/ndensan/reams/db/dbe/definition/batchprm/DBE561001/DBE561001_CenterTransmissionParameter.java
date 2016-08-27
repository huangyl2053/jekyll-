/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE561001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * センター送信データ作成のバッチパラメータクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBE561001_CenterTransmissionParameter extends BatchParameterBase {

    private static final String SHINSEISHOKANRINOLIST = "shinseishoKanriNoList";
    private static final String TENNYUSHIBOKUBUN = "tennyuShiboKubun";
    private static final String NIJIHANTEIKAISHIYMD = "nijiHanteiKaishiYMD";
    private static final String NIJIHANTEISHURYOYMD = "nijiHanteiShuryoYMD";
    private static final RString 出力する = new RString(0);

    @BatchParameter(key = SHINSEISHOKANRINOLIST, name = "申請書管理番号リスト")
    private List<RString> 申請書管理番号リスト;
    @BatchParameter(key = TENNYUSHIBOKUBUN, name = "転入死亡情報出力区分")
    private RString 転入死亡情報出力区分;
    @BatchParameter(key = NIJIHANTEIKAISHIYMD, name = "二次判定開始日")
    private RString 二次判定開始日;
    @BatchParameter(key = NIJIHANTEISHURYOYMD, name = "二次判定終了日")
    private RString 二次判定終了日;

    /**
     * コンストラクタです。
     */
    public DBE561001_CenterTransmissionParameter() {

    }

    /**
     * 調査票（概況調査）サービスの状況一時テーブルのProcessParameterを作成します。
     *
     * @return CenterTransmissionProcessParameter
     */
    public CenterTransmissionProcessParameter toCenterTransmissionProcessParameter() {
        return new CenterTransmissionProcessParameter(
                申請書管理番号リスト,
                出力する.equals(転入死亡情報出力区分),
                二次判定開始日,
                二次判定終了日,
                RString.isNullOrEmpty(二次判定開始日),
                RString.isNullOrEmpty(二次判定終了日));
    }
}
