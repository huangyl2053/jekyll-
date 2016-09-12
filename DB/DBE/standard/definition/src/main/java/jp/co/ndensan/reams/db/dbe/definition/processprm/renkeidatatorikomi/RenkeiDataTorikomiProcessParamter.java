/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.renkeidatatorikomi.ShiseiDataParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.renkeidatatorikomi.RenkeiDataTorikomiMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定申請連携データ取込ですためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class RenkeiDataTorikomiProcessParamter implements IBatchProcessParameter {

    private final RString 市町村コード;
    private final List<RString> 取込み対象ファイルリスト;
    private final List<ShiseiDataParameter> 申請情報データリスト;
    private final boolean 厚労省フラグ;
    private final boolean 東芝版フラグ;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 取込み対象ファイルリスト 取込み対象ファイルリスト
     * @param 申請情報データリスト 申請情報データリスト
     * @param 厚労省フラグ 厚労省フラグ
     * @param 東芝版フラグ 東芝版フラグ
     */
    public RenkeiDataTorikomiProcessParamter(RString 市町村コード,
            List<RString> 取込み対象ファイルリスト,
            List<ShiseiDataParameter> 申請情報データリスト,
            boolean 厚労省フラグ,
            boolean 東芝版フラグ) {
        this.市町村コード = 市町村コード;
        this.取込み対象ファイルリスト = 取込み対象ファイルリスト;
        this.申請情報データリスト = 申請情報データリスト;
        this.厚労省フラグ = 厚労省フラグ;
        this.東芝版フラグ = 東芝版フラグ;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return NinteiChosaIraiMybitisParamter
     */
    public RenkeiDataTorikomiMybitisParamter toRenkeiDataTorikomiMybitisParamter() {
        return new RenkeiDataTorikomiMybitisParamter(市町村コード,
                申請情報データリスト);
    }
}
