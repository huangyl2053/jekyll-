/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD519002;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519002.RenekeiDataSakuseiFourMasterProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定関連データ作成のバッチパラメータ。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBD519002Parameter extends BatchParameterBase {

    private static final long serialVersionUID = -7108768751931298237L;
    private static final String KONKAISHORIYMDTIME_FROM = "konkaishoriymdtime_from";
    private static final String KONKAISHORIYMDTIME_TO = "konkaishoriymdtime_to";
    private static final String SHIHKIBETSUCODE = "shikibetsucode";
    private static final String CHOSAITAKUSAKIFILENAME = "chosaitakusakifilename";
    private static final String CHOSAINFILENAME = "chosainfilename";
    private static final String SHUJIIIRYOKIKANFILENAME = "shujiiIryokikanfilename";
    private static final String SHUJIIIFILENAME = "shujiifilename";

    @BatchParameter(key = KONKAISHORIYMDTIME_FROM, name = "今回処理日時開始日時")
    private RDateTime konkaishoriymdtime_from;
    @BatchParameter(key = KONKAISHORIYMDTIME_TO, name = "今回処理日時終了日時")
    private RDateTime konkaishoriymdtime_to;
    @BatchParameter(key = SHIHKIBETSUCODE, name = "識別コード")
    private RString shikibetsucode;
    @BatchParameter(key = CHOSAITAKUSAKIFILENAME, name = "認定調査委託先情報ファイル名")
    private RString chosaitakusakifilename;
    @BatchParameter(key = CHOSAINFILENAME, name = "認定調査員情報ファイル名")
    private RString chosainfilename;
    @BatchParameter(key = SHUJIIIRYOKIKANFILENAME, name = "主治医医療機関情報ファイル名")
    private RString shujiiIryokikanfilename;
    @BatchParameter(key = SHUJIIIFILENAME, name = "主治医情報ファイル名")
    private RString shujiifilename;

    /**
     * 認定調査委託先情報CSV_電算版のProcessParameterを作成する。
     *
     * @return 認定調査委託先情報CSV_電算版のProcessParameter
     */
    public RenekeiDataSakuseiFourMasterProcessParameter toChosaitakusakiReamsProcessParameter() {
        return new RenekeiDataSakuseiFourMasterProcessParameter(
                shikibetsucode,
                konkaishoriymdtime_from,
                konkaishoriymdtime_to,
                chosaitakusakifilename,
                true);
    }

    /**
     * 認定調査委託先情報CSVのProcessParameterを作成する。
     *
     * @return 認定調査委託先情報CSVのProcessParameter
     */
    public RenekeiDataSakuseiFourMasterProcessParameter toChosaitakusakiProcessParameter() {
        return new RenekeiDataSakuseiFourMasterProcessParameter(
                shikibetsucode,
                konkaishoriymdtime_from,
                konkaishoriymdtime_to,
                chosaitakusakifilename,
                false);
    }

    /**
     * 認定調査員情報CSV_電算版のProcessParameterを作成する。
     *
     * @return 認定調査員情報CSV_電算版のProcessParameter
     */
    public RenekeiDataSakuseiFourMasterProcessParameter toChosainReamsProcessParameter() {
        return new RenekeiDataSakuseiFourMasterProcessParameter(
                shikibetsucode,
                konkaishoriymdtime_from,
                konkaishoriymdtime_to,
                chosainfilename,
                true);
    }

    /**
     * 認定調査員情報CSVのProcessParameterを作成する。
     *
     * @return 認定調査員情報CSVのProcessParameter
     */
    public RenekeiDataSakuseiFourMasterProcessParameter toChosainProcessParameter() {
        return new RenekeiDataSakuseiFourMasterProcessParameter(
                shikibetsucode,
                konkaishoriymdtime_from,
                konkaishoriymdtime_to,
                chosainfilename,
                false);
    }

    /**
     * 主治医医療機関情報CSV_電算版のProcessParameterを作成する。
     *
     * @return 主治医医療機関情報CSV_電算版のProcessParameter
     */
    public RenekeiDataSakuseiFourMasterProcessParameter toShujiiIryokikanReamsProcessParameter() {
        return new RenekeiDataSakuseiFourMasterProcessParameter(
                shikibetsucode,
                konkaishoriymdtime_from,
                konkaishoriymdtime_to,
                shujiiIryokikanfilename,
                true);
    }

    /**
     * 主治医医療機関情報CSVのProcessParameterを作成する。
     *
     * @return 主治医医療機関情報CSVのProcessParameter
     */
    public RenekeiDataSakuseiFourMasterProcessParameter toShujiiIryokikanProcessParameter() {
        return new RenekeiDataSakuseiFourMasterProcessParameter(
                shikibetsucode,
                konkaishoriymdtime_from,
                konkaishoriymdtime_to,
                shujiiIryokikanfilename,
                false);
    }

    /**
     * 主治医情報CSV_電算版のProcessParameterを作成する。
     *
     * @return 主治医情報CSV_電算版のProcessParameter
     */
    public RenekeiDataSakuseiFourMasterProcessParameter toShujiiReamsProcessParameter() {
        return new RenekeiDataSakuseiFourMasterProcessParameter(
                shikibetsucode,
                konkaishoriymdtime_from,
                konkaishoriymdtime_to,
                shujiifilename,
                true);
    }

    /**
     * 主治医情報CSVのProcessParameterを作成する。
     *
     * @return 主治医情報CSVのProcessParameter
     */
    public RenekeiDataSakuseiFourMasterProcessParameter toShujiiProcessParameter() {
        return new RenekeiDataSakuseiFourMasterProcessParameter(
                shikibetsucode,
                konkaishoriymdtime_from,
                konkaishoriymdtime_to,
                shujiifilename,
                false);
    }

    /**
     * 要介護認定外部データ出力履歴に更新のProcessParameterを作成する。
     *
     * @return 要介護認定外部データ出力履歴に更新のProcessParameter
     */
    public RenekeiDataSakuseiFourMasterProcessParameter toYokaigoNinteiGaibuDataOutputHistoryProcessParameter() {
        return new RenekeiDataSakuseiFourMasterProcessParameter(konkaishoriymdtime_from, konkaishoriymdtime_to);
    }
}
