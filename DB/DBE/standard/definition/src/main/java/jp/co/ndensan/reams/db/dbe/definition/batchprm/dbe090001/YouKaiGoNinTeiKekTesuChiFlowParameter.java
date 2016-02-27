/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe090001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe090001.YouKaiGoNinTeiKekTesuChiProcessParemeter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医への結果通知書のMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class YouKaiGoNinTeiKekTesuChiFlowParameter extends BatchParameterBase {

    /**
     * 二次判定期間From
     */
    public static final String NIJIHANTEIYMDFROM = "nijiHanteiYMDFrom";

    /**
     * 二次判定期間To
     */
    public static final String NIJIHANTEIYMDTO = "nijiHanteiYMDTo";

    /**
     * 未出力フラグ
     */
    public static final String MADANYURYOKU = "maDaNyuRyoKu";

    /**
     * 主治医情報
     */
    public static final String SHUJIIJYOUHOU = "shuJiiJyouHou";

    /**
     * 申請書管理番号
     */
    public static final String SHINSEISHOKANRINO = "shinseishoKanriNo";

    /**
     * 証記載保険者番号
     */
    public static final String SHOKISAIHOKENSHANO = "shoKisaiHokenshaNo";

    /**
     * 支所コード
     */
    public static final String SHISHOCODE = "shishoCode";

    /**
     * 認定状況提供日
     */
    public static final String NINTEIJOHOTEIKYOYMD = "ninteiJohoTeikyoYMD";

    @BatchParameter(key = NIJIHANTEIYMDFROM, name = "二次判定期間From")
    private RString nijiHanteiYMDFrom;
    @BatchParameter(key = NIJIHANTEIYMDTO, name = "二次判定期間To")
    private RString nijiHanteiYMDTo;
    @BatchParameter(key = MADANYURYOKU, name = "未出力フラグ")
    private RString maDaNyuRyoKu;
    @BatchParameter(key = SHUJIIJYOUHOU, name = "主治医情報")
    private RString shuJiiJyouHou;
    @BatchParameter(key = SHINSEISHOKANRINO, name = "申請書管理番号")
    private RString shinseishoKanriNo;
    @BatchParameter(key = SHOKISAIHOKENSHANO, name = "証記載保険者番号")
    private RString shoKisaiHokenshaNo;
    @BatchParameter(key = SHISHOCODE, name = "支所コード")
    private RString shishoCode;
    @BatchParameter(key = NINTEIJOHOTEIKYOYMD, name = "認定状況提供日")
    private RString ninteiJohoTeikyoYMD;

    /**
     * 主治医への結果通知書のMybatisパラメータークラス作成
     *
     * @return ItakusakiChosainIchiranMybitisParamter
     */
    public YouKaiGoNinTeiKekTesuChiProcessParemeter toProcessParameter() {
        return new YouKaiGoNinTeiKekTesuChiProcessParemeter(nijiHanteiYMDFrom,
                nijiHanteiYMDTo,
                maDaNyuRyoKu,
                shuJiiJyouHou,
                shinseishoKanriNo,
                shoKisaiHokenshaNo,
                shishoCode,
                ninteiJohoTeikyoYMD);
    }
}
