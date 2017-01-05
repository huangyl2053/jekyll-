package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.OnseiFileOperator.OnseiFileOperator;

import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IOnseiFileOperatorDiv extends ICommonChildDivBaseProperties {

    /**
     * 共有子Divの初期化を行います。
     *
     * @param 審査会音声情報 審査会音声情報
     */
    void initialize(ShinsakaiOnseiJoho2 審査会音声情報);

    /**
     * 共有子Divの初期化を行います。
     *
     * @param 審査会音声情報 審査会音声情報
     * @param 追加日時 追加日時
     */
    void initialize(ShinsakaiOnseiJoho2 審査会音声情報, RDateTime 追加日時);
}
