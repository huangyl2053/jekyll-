/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD519003;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 資格喪失（死亡）データ作成のバッチパラメータ。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBD519003_YokaigoNinteiSoshitsuDataSakusei extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private static final String KONKAIKAISHIDATETIME = "konkaikaishidatetime";
    private static final String KONKAISHORIDATETIME = "konkaishoridatetime";
    private static final String HANTEIIRAIICHIRANHYOU = "hanteiiraiichiranhyou";
    private static final String NEWFILENAME = "newfilename";

    @BatchParameter(key = KONKAIKAISHIDATETIME, name = "今回開始日時")
    private RDateTime konkaikaishidatetime;
    @BatchParameter(key = KONKAISHORIDATETIME, name = "今回終了日時")
    private RDateTime konkaishoridatetime;
    @BatchParameter(key = HANTEIIRAIICHIRANHYOU, name = "判定依頼一覧表ラジオボタン")
    private RString hanteiiraiichiranhyou;
    @BatchParameter(key = NEWFILENAME, name = "新ファイル名")
    private RString newfilename;

    /**
     * プロセスパラメータの作成。
     *
     * @return RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter
     */
    public RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter toRenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter() {
        return new RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter(
                konkaikaishidatetime, konkaishoridatetime, hanteiiraiichiranhyou, newfilename);
    }
}
