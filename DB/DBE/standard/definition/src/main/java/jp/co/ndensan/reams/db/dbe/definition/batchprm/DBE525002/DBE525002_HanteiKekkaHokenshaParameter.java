/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 判定結果情報出力(保険者)を特定するためのバッチ用パラメータクラスです。
 *
 * @reamsid_L DBE-0190-030 duanzhanli
 */
@Getter
@Setter
public class DBE525002_HanteiKekkaHokenshaParameter extends BatchParameterBase {

    private static final String SHINSEISHOKANRINO = "shinseishoKanriNo";
    private static final String NIJIHANTEIYMDFROM = "nijiHanteiYMDFrom";
    private static final String NIJIHANTEIYMDTO = "nijiHanteiYMDTo";

    @BatchParameter(key = SHINSEISHOKANRINO, name = "申請書管理番号")
    private List<RString> shinseishoKanriNo;
    @BatchParameter(key = NIJIHANTEIYMDFROM, name = "二次判定日From")
    private RString nijiHanteiYMDFrom;
    @BatchParameter(key = NIJIHANTEIYMDTO, name = "二次判定日To")
    private RString nijiHanteiYMDTo;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 二次判定日From 二次判定日From
     * @param 二次判定日To 二次判定日To
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public DBE525002_HanteiKekkaHokenshaParameter(
            List<RString> 申請書管理番号,
            RString 二次判定日From,
            RString 二次判定日To) {
        this.shinseishoKanriNo = 申請書管理番号;
        this.nijiHanteiYMDFrom = 二次判定日From;
        this.nijiHanteiYMDTo = 二次判定日To;
    }

    /**
     * コンストラクタです。
     */
    public DBE525002_HanteiKekkaHokenshaParameter() {
    }

    /**
     * processのパラメータを生成します。
     *
     * @return ItakusakiChosainIchiranMybitisParamter
     */
    public HanteiKekkaJohoShutsuryokuProcessParamter toHanteiKekkaJohoShutsuryokuProcessParamter() {
        return new HanteiKekkaJohoShutsuryokuProcessParamter(shinseishoKanriNo,
                nijiHanteiYMDFrom,
                nijiHanteiYMDTo);
    }
}
