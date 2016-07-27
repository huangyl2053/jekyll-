/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査データ出力（モバイル）ですためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1860-011 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class NinteiChosaDataOutputBatchMybitisParameter implements IMyBatisParameter {

    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();
    private final RString imageKubun = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分,
            RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    private final RString ninteichosaItakusakiCode;
    private final RString ninteiChosainCode;
    private final List<RString> shinseishoKanriNoList;
    private final RString shichosonCode;
    private final boolean isShinseishoKanriNo;
    private final boolean isNinteichosaItakusakiCode;
    private final boolean isNinteiChosainCode;
    private final boolean isShichoson;

    /**
     * コンストラクタです。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param 市町村コード 市町村コード
     * @param is認定調査委託先コード is認定調査委託先コード
     * @param is認定調査委託先コード is認定調査委託先コード
     * @param is認定調査員コード is認定調査員コード
     */
    private NinteiChosaDataOutputBatchMybitisParameter(RString 認定調査委託先コード,
            RString 認定調査員コード,
            List<RString> 申請書管理番号リスト,
            RString 市町村コード,
            boolean isShinseishoKanriNo,
            boolean is認定調査委託先コード,
            boolean is認定調査員コード,
            boolean is全市町村) {
        this.ninteichosaItakusakiCode = 認定調査委託先コード;
        this.ninteiChosainCode = 認定調査員コード;
        this.shinseishoKanriNoList = 申請書管理番号リスト;
        this.shichosonCode = 市町村コード;
        this.isShinseishoKanriNo = isShinseishoKanriNo;
        this.isNinteichosaItakusakiCode = is認定調査委託先コード;
        this.isNinteiChosainCode = is認定調査員コード;
        this.isShichoson = is全市町村;
    }

    /**
     * コンストラクタです。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param 市町村コード 市町村コード
     * @return ShujiiIkenshoSakuseiMybitisParamter
     */
    public static NinteiChosaDataOutputBatchMybitisParameter createSelectByKeyParam(
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            List<RString> 申請書管理番号リスト,
            RString 市町村コード) {
        boolean is認定調査委託先コード = false;
        boolean is認定調査員コード = false;
        boolean is全市町村 = false;
        if (!RString.isNullOrEmpty(認定調査委託先コード)) {
            is認定調査委託先コード = true;
        }
        if (!RString.isNullOrEmpty(認定調査委託先コード) && !RString.isNullOrEmpty(認定調査員コード)) {
            is認定調査員コード = true;
        }
        boolean is申請書管理番号フラグ = false;
        if (申請書管理番号リスト != null && !申請書管理番号リスト.isEmpty()) {
            is申請書管理番号フラグ = true;
        }
        if (RString.isNullOrEmpty(市町村コード)) {
            is全市町村 = true;
        }
        return new NinteiChosaDataOutputBatchMybitisParameter(認定調査委託先コード,
                認定調査員コード,
                申請書管理番号リスト,
                市町村コード,
                is申請書管理番号フラグ,
                is認定調査委託先コード,
                is認定調査員コード,
                is全市町村);
    }
}
