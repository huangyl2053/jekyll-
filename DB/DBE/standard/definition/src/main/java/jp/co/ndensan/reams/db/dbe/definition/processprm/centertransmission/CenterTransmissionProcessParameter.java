/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionMybitisParamter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
    private final boolean is未出力のみ;
    private final boolean is転入死亡情報出力;
    private final RString 二次判定開始日;
    private final RString 二次判定終了日;
    private final boolean is二次判定開始日Empty;
    private final boolean is二次判定終了日Empty;
    private final LasdecCode 市町村コード;
    private final RString 市町村名;
    private final ShoKisaiHokenshaNo 証記載保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param is未出力のみ is未出力のみ
     * @param is転入死亡情報出力 is転入死亡情報出力
     * @param 二次判定開始日 二次判定開始日
     * @param 二次判定終了日 二次判定終了日
     * @param is二次判定開始日Empty boolean
     * @param is二次判定終了日Empty boolean
     * @param 市町村コード LasdecCode
     * @param 市町村名 RString
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     */
    public CenterTransmissionProcessParameter(
            List<RString> 申請書管理番号リスト,
            boolean is未出力のみ,
            boolean is転入死亡情報出力,
            RString 二次判定開始日,
            RString 二次判定終了日,
            boolean is二次判定開始日Empty,
            boolean is二次判定終了日Empty,
            LasdecCode 市町村コード,
            RString 市町村名,
            ShoKisaiHokenshaNo 証記載保険者番号) {
        this.申請書管理番号リスト = 申請書管理番号リスト;
        this.is未出力のみ = is未出力のみ;
        this.is転入死亡情報出力 = is転入死亡情報出力;
        this.二次判定開始日 = 二次判定開始日;
        this.二次判定終了日 = 二次判定終了日;
        this.is二次判定開始日Empty = is二次判定開始日Empty;
        this.is二次判定終了日Empty = is二次判定終了日Empty;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.証記載保険者番号 = 証記載保険者番号;
    }

    /**
     * CenterTransmissionMybitisParamterに転換します。
     *
     * @return CenterTransmissionMybitisParamter
     */
    public CenterTransmissionMybitisParamter toCenterTransmissionMybitisParamter() {
        CenterTransmissionMybitisParamter paramter = new CenterTransmissionMybitisParamter();
        paramter.set通常(ShoriJotaiKubun.通常.getコード());
        paramter.set延期(ShoriJotaiKubun.延期.getコード());
        paramter.setShinseishoKanriNoList(申請書管理番号リスト);
        paramter.setMiSyutsuryokuNomi(is未出力のみ);
        paramter.setTennyuShiboSyuturyoku(is転入死亡情報出力);
        paramter.setNijiHanteiKaishiYMD(二次判定開始日);
        paramter.setNijiHanteiShuryoYMD(二次判定終了日);
        paramter.setNijiHanteiKaishiYMDEmpty(is二次判定開始日Empty);
        paramter.setNijiHanteiShuryoYMDEmpty(is二次判定終了日Empty);
        paramter.setShichosonCode(市町村コード);
        paramter.setShichosonMei(市町村名);
        paramter.setShoKisaiHokenshaNo(証記載保険者番号);
        return paramter;
    }
}
