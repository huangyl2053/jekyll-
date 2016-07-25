package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 世帯所得一覧Divのインターフェースです。
 *
 * @author n8300 姜
 */
public interface ISetaiShotokuIchiranDiv extends ICommonChildDivBaseProperties {

    /**
     * Divの初期化を行います。
     *
     * @param 識別コード 識別コード
     * @param 世帯基準年月日 世帯基準年月日
     * @param 所得年度 所得年度
     * @param 所得基準年月日時分秒 所得基準年月日時分秒
     */
    void initialize(ShikibetsuCode 識別コード, FlexibleDate 世帯基準年月日, FlexibleYear 所得年度, YMDHMS 所得基準年月日時分秒);

    /**
     * 世帯員所得Girdで選択された情報の取得を行います。
     *
     * @return
     */
    List<SetaiinShotoku> get世帯員所得Selected();

    /**
     * 比較時のバリデーションを行い結果を返却します。
     *
     * @return バリデーションの結果
     */
    ValidationMessageControlPairs validate比較対象();
}
