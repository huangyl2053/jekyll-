/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 判定結果情報出力(介護認定審査会)バッチのパラメータ。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBE525001_HanteiKekkaShinsakaiParameter extends BatchParameterBase {

    private static final String KEY_KAISAIBANGOULIST = "kaisaiBangouList";
    private static final String KEY_KAISAIBANGOU = "kaisaiBangou";
    private static final String ISPUBLISH_KEKKAICHIRAN_A3 = "isPublish_HanteiKekkaA3";
    private static final String ISPUBLISH_KEKKAICHIRAN = "isPublish_HanteiKekka";
    private static final String ISPUBLISH_KEKKAICHIRAN_KAGAMI = "isPublish_HanteiKekkaKagami";
    private static final String ISPUBLISH_SHINSAKAIGIJIROKU = "isPublish_ShinsakaiGijiroku";
    private static final String ISPUBLISH_KEKKATSUCHIICHIRAN = "isPublish_KekkaTsuchiIchiran";
    private static final String USERID = "userId";

    @BatchParameter(key = KEY_KAISAIBANGOULIST, name = "開催番号")
    private List<RString> kaisaiBangouList;
    @BatchParameter(key = KEY_KAISAIBANGOU, name = "開催番号")
    private RString kaisaiBangou;
    @BatchParameter(key = ISPUBLISH_KEKKAICHIRAN_A3, name = "要介護認定判定結果一覧表A3版")
    private boolean isPublish_HanteiKekkaA3;
    @BatchParameter(key = ISPUBLISH_KEKKAICHIRAN, name = "要介護認定判定結果一覧表")
    private boolean isPublish_HanteiKekka;
    @BatchParameter(key = ISPUBLISH_KEKKAICHIRAN_KAGAMI, name = "要介護認定審査判定結果_鑑")
    private boolean isPublish_HanteiKekkaKagami;
    @BatchParameter(key = ISPUBLISH_SHINSAKAIGIJIROKU, name = "要介護認定審査会議事録")
    private boolean isPublish_ShinsakaiGijiroku;
    @BatchParameter(key = ISPUBLISH_KEKKATSUCHIICHIRAN, name = "要介護認定結果通知一覧表")
    private boolean isPublish_KekkaTsuchiIchiran;
    @BatchParameter(key = USERID, name = "ユーザID")
    private RString userId;

    /**
     * バッチのパラメータを作成します。
     *
     * @return HanteiKekkaJohoShuturyokuProcessParameter
     */
    public HanteiKekkaJohoShuturyokuProcessParameter toHanteiKekkaJohoShuturyokuProcessParameter() {
        return new HanteiKekkaJohoShuturyokuProcessParameter(
                kaisaiBangouList,
                kaisaiBangou,
                isPublish_HanteiKekkaA3,
                isPublish_HanteiKekka,
                isPublish_HanteiKekkaKagami,
                isPublish_ShinsakaiGijiroku,
                isPublish_KekkaTsuchiIchiran,
                userId
        );
    }
}
