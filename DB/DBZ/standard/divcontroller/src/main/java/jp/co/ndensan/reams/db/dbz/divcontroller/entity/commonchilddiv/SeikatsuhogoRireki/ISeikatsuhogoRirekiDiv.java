package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoRireki;

import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBZ-4520-010 zhangzhiming
 */
public interface ISeikatsuhogoRirekiDiv extends ICommonChildDivBaseProperties {

    /**
     * 生活保護履歴画面の初期化処理です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 業務コード GyomuCode
     * @param 表示モード RString
     */
    public void initialize(ShikibetsuCode 識別コード, GyomuCode 業務コード, RString 表示モード);
}
