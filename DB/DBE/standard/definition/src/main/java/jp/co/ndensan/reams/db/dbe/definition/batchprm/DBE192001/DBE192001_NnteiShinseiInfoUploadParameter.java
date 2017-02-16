/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE192001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi.RenkeiDataTorikomiProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請連携データ取込のパラメータクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBE192001_NnteiShinseiInfoUploadParameter extends BatchParameterBase {

    private static final String SHICHOSONCODE = "shichosonCode";
    private static final String TORIKOMIFILELIST = "torikomifilelist";
    private static final String SHINSEIJOHODATALIST = "shinseiJohoDataList";
    private static final String PATH = "path";
    private static final String FILEID = "fileId";
    private static final String HOKAISEIGOFLAG = "hokaiseiGoFlag";

    private boolean 厚労省フラグ;
    private boolean 東芝版フラグ;
    private boolean センター送信運用有無フラグ;
    private boolean 情報提供同意有無フラグ;

    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private RString 市町村コード;
    @BatchParameter(key = TORIKOMIFILELIST, name = "取込み対象ファイルリスト")
    private List<RString> 取込み対象ファイルリスト;
    @BatchParameter(key = SHINSEIJOHODATALIST, name = "要介護認定申請情報データリスト")
    private List<ShiseiDataParameter> 申請情報データリスト;
    @BatchParameter(key = PATH, name = "格納パス")
    private RString 格納パス;
    @BatchParameter(key = FILEID, name = "共有ファイルID")
    private List<RDateTime> 共有ファイルIDList;
    @BatchParameter(key = HOKAISEIGOFLAG, name = "法改正後フラグ")
    private boolean 法改正後フラグ;

    /**
     * mybatisのパラメータを生成します。
     *
     * @return NinteiChosaIraiMybitisParamter
     */
    public RenkeiDataTorikomiProcessParamter toRenkeiDataTorikomiProcessParamter() {
        return new RenkeiDataTorikomiProcessParamter(市町村コード,
                取込み対象ファイルリスト,
                申請情報データリスト,
                厚労省フラグ,
                東芝版フラグ,
                法改正後フラグ,
                センター送信運用有無フラグ,
                情報提供同意有無フラグ);
    }
}
