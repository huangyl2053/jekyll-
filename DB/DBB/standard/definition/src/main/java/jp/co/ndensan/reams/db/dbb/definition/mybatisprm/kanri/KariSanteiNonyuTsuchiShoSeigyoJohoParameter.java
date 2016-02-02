/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kanri;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 *
 * 納入通知書制御情報取得するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KariSanteiNonyuTsuchiShoSeigyoJohoParameter {

    private final SubGyomuCode サブ業務コード;
    private final FlexibleYear 調定年度;

    /**
     * コンストラクタです。
     *
     * @param サブ業務コード サブ業務コード
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KariSanteiNonyuTsuchiShoSeigyoJohoParameter(
            SubGyomuCode サブ業務コード, FlexibleYear 調定年度) {
        this.サブ業務コード = requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        this.調定年度 = requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
    }

    /**
     * 納入通知書制御情報取得するためのMyBatis用パラメータを生成します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 調定年度 調定年度
     * @return 納入通知書制御情報取得するためのMyBatis用パラメータ
     */
    public static KariSanteiNonyuTsuchiShoSeigyoJohoParameter createParam(
            SubGyomuCode サブ業務コード, FlexibleYear 調定年度) {
        return new KariSanteiNonyuTsuchiShoSeigyoJohoParameter(サブ業務コード, 調定年度);
    }

}
