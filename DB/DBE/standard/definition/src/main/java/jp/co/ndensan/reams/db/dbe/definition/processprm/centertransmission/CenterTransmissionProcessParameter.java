/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * センター送信データ作成のProcessParameterクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CenterTransmissionProcessParameter implements IBatchProcessParameter {

    private final List<RString> 申請書管理番号リスト;
    private final boolean is転入死亡情報出力;
    private final RString 二次判定開始日;
    private final RString 二次判定終了日;
    private final boolean is二次判定開始日Empty;
    private final boolean is二次判定終了日Empty;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param is転入死亡情報出力 boolean
     * @param 二次判定開始日 二次判定開始日
     * @param 二次判定終了日 二次判定終了日
     * @param is二次判定開始日Empty boolean
     * @param is二次判定終了日Empty boolean
     */
    public CenterTransmissionProcessParameter(
            List<RString> 申請書管理番号リスト,
            boolean is転入死亡情報出力,
            RString 二次判定開始日,
            RString 二次判定終了日,
            boolean is二次判定開始日Empty,
            boolean is二次判定終了日Empty) {
        this.申請書管理番号リスト = 申請書管理番号リスト;
        this.is転入死亡情報出力 = is転入死亡情報出力;
        this.二次判定開始日 = 二次判定開始日;
        this.二次判定終了日 = 二次判定終了日;
        this.is二次判定開始日Empty = is二次判定開始日Empty;
        this.is二次判定終了日Empty = is二次判定終了日Empty;
    }

    /**
     * CenterTransmissionMybitisParamterに転換します。
     *
     * @return CenterTransmissionMybitisParamter
     */
    public CenterTransmissionMybitisParamter toCenterTransmissionMybitisParamter() {
        CenterTransmissionMybitisParamter paramter = new CenterTransmissionMybitisParamter();
        paramter.setShinseishoKanriNoList(申請書管理番号リスト);
        paramter.setTennyuShiboSyuturyoku(is転入死亡情報出力);
        paramter.setNijiHanteiKaishiYMD(二次判定開始日);
        paramter.setNijiHanteiShuryoYMD(二次判定終了日);
        paramter.setNijiHanteiKaishiYMDEmpty(is二次判定開始日Empty);
        paramter.setNijiHanteiShuryoYMDEmpty(is二次判定終了日Empty);
        return paramter;
    }
}
