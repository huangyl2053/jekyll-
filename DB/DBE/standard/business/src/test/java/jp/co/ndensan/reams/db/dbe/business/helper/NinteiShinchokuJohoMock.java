/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ConsentsToEnkitsuchiHakko;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.センター送信年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.主治医意見書作成依頼完了年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.主治医意見書登録完了年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.依頼情報データ送信年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.申請書管理番号;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.要介護認定1_5次判定完了年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.要介護認定一次判定完了年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.要介護認定一次判定情報抽出年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.要介護認定延期理由;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.認定審査会割当完了年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.認定審査会完了年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.認定延期通知発行に対する同意有無;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.認定延期通知発行回数;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.認定延期通知発行年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.認定申請情報登録年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.認定調査依頼完了年月日;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock.認定調査完了年月日;

/**
 * モデルパッケージ作成時にエラーになったため仮作成。対応するときに考える。
 *
 * @author N3317 塚田 萌
 */
public class NinteiShinchokuJohoMock {

    /**
     * テスト用認定進捗情報を返します。
     *
     * @return 認定進捗情報
     */
    public static YokaigoNinteiProgress create認定進捗情報() {
        return new YokaigoNinteiProgress(
                申請書管理番号,
                認定申請情報登録年月日,
                ConsentsToEnkitsuchiHakko.toValue(認定延期通知発行に対する同意有無),
                認定延期通知発行年月日,
                認定延期通知発行回数,
                要介護認定延期理由,
                要介護認定一次判定情報抽出年月日,
                依頼情報データ送信年月日,
                認定調査依頼完了年月日,
                認定調査完了年月日,
                主治医意見書作成依頼完了年月日,
                主治医意見書登録完了年月日,
                要介護認定一次判定完了年月日,
                要介護認定1_5次判定完了年月日,
                認定審査会割当完了年月日,
                認定審査会完了年月日,
                センター送信年月日);
    }
}
