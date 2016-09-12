/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5190002;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定関連データ作成のバッチパラメータ
 *
 * @reamsid_L DBD-2100-020 liwul
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class RenekeiDataSakuseiFourMasterBatchParameter {

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

}
