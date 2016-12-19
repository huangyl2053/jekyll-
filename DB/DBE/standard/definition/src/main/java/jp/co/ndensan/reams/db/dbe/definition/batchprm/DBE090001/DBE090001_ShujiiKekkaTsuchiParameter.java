/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE090001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe090001.YouKaiGoNinTeiKekTesuChiProcessParemeter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医への結果通知書のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0220-030 wangkun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBE090001_ShujiiKekkaTsuchiParameter extends BatchParameterBase {

    private static final String NIJIHANTEIYMDFROM = "nijiHanteiYMDFrom";
    private static final String NIJIHANTEIYMDTO = "nijiHanteiYMDTo";
    private static final String MADANYURYOKU = "maDaNyuRyoKu";
    private static final String SHUJIIJYOUHOU = "shuJiiJyouHou";
    private static final String SHINSEISHOKANRINO = "shinseishoKanriNo";
    private static final String SHOKISAIHOKENSHANO = "shoKisaiHokenshaNo";
    private static final String USESHOKISAIHOKENSHANO = "useShoKisaiHokenshaNo";
    private static final String SHISHOCODE = "shishoCode";
    private static final String NINTEIJOHOTEIKYOYMD = "ninteiJohoTeikyoYMD";
    private static final String SHICHOSON_CODE = "shichosonCode";
    private static final long serialVersionUID = -5187631016597638486L;

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
    @BatchParameter(key = USESHOKISAIHOKENSHANO, name = "証記載保険者番号使用フラグ")
    private boolean useShoKisaiHokenshaNo;
    @BatchParameter(key = SHISHOCODE, name = "支所コード")
    private RString shishoCode;
    @BatchParameter(key = NINTEIJOHOTEIKYOYMD, name = "認定状況提供日")
    private RString ninteiJohoTeikyoYMD;
    @BatchParameter(key = SHICHOSON_CODE, name = "市町村コード")
    private RString shichosonCode;

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
                ninteiJohoTeikyoYMD,
                shichosonCode,
                useShoKisaiHokenshaNo);
    }
}
